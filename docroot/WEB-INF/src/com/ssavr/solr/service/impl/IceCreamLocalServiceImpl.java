/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ssavr.solr.service.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.http.HTTPException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.ssavr.solr.NoSuchIceCreamException;
import com.ssavr.solr.beans.IceCreamBean;
import com.ssavr.solr.beans.SolrResponse;
import com.ssavr.solr.model.IceCream;
import com.ssavr.solr.model.IceCreamDocuments;
import com.ssavr.solr.service.base.IceCreamLocalServiceBaseImpl;
import com.ssavr.solr.util.SolrUtil;

/**
 * The implementation of the ice cream local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ssavr.solr.service.IceCreamLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author SAVRAMIS
 * @see com.ssavr.solr.service.base.IceCreamLocalServiceBaseImpl
 * @see com.ssavr.solr.service.IceCreamLocalServiceUtil
 */
public class IceCreamLocalServiceImpl extends IceCreamLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ssavr.solr.service.IceCreamLocalServiceUtil} to access the ice cream
	 * local service.
	 */
	public IceCream addIceCream(long userId, long companyId,
			ServiceContext serviceContext, String name, String flavor,
			String[] documents) throws Exception {

		long iceCreamId = counterLocalService.increment(IceCream.class
				.getName());
		IceCream iceCream = iceCreamPersistence.create(iceCreamId);
		iceCream.setUserId(userId);
		iceCream.setCompanyId(companyId);
		iceCream.setUuid(serviceContext.getUuid());
		iceCream.setName(name);
		iceCream.setFlavor(flavor);
		Date now = new Date();
		iceCream.setCreateDate(now);
		iceCream.setModifiedDate(now);
		iceCream = iceCreamPersistence.update(iceCream, false, serviceContext);

		iceCreamDocumentsLocalService.addIceCreamDocuments(userId, companyId,
				serviceContext, iceCreamId, documents);

		Indexer indexer = IndexerRegistryUtil.getIndexer(IceCreamBean.class);
		IceCreamBean bean = getIceCreamBean(iceCream);
		indexer.reindex(bean);

		return iceCream;
	}

	/***************************************************************************
	 ************************** GET ********************************************
	 ***************************************************************************/

	public IceCreamBean getIceCreamBean(IceCream iceCream) throws Exception {
		String uid = "iceCream_" + iceCream.getUuid();
		IceCreamBean bean = new IceCreamBean();
		bean.setUid(uid);
		bean.setCompanyId(iceCream.getCompanyId());
		bean.setIceCreamId(iceCream.getIceCreamId());
		bean.setName(iceCream.getName());
		bean.setFlavor(iceCream.getFlavor());
		List<IceCreamDocuments> documents = iceCreamDocumentsLocalService
				.getIceCreamDocumentsByIceCreamId(iceCream.getIceCreamId());
		List<String> documentsContent = new ArrayList<String>();

		if (!documents.isEmpty()) {
			List<String> documentIds = new ArrayList<String>();
			for (IceCreamDocuments document : documents) {
				documentIds.add(String.valueOf(document.getDocumentId()));
			}
			String documentsStr = StringUtil.merge(documentIds,
					StringPool.SPACE);

			SolrQuery query = new SolrQuery();
			query.setQuery(Field.ENTRY_CLASS_PK + ":(" + documentsStr + ")");
			query.addFilterQuery(Field.ENTRY_CLASS_NAME
					+ ":(com.liferay.portlet.documentlibrary.model.DLFileEntry)");
			query.setStart(0);
			query.setRows(10000000);

			String activeServerUrl = SolrUtil.getActiveSolrServer();
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(
					activeServerUrl);

			QueryResponse qr = server.query(query);
			SolrDocumentList docs = qr.getResults();
			if (_log.isDebugEnabled()) {
				_log.debug("Found " + docs.size() + " Document(-s)");
			}

			for (int i = 0; i < docs.size(); ++i) {
				String docContent = (String) docs.get(i).getFieldValue(
						"content");
				documentsContent.add(docContent);
			}
		}

		bean.setIceCreamRecipeContent(documentsContent);

		if (_log.isDebugEnabled()) {
			_log.debug(bean.toString());
		}

		return bean;
	}

	public List<IceCream> getAllIceCreams() throws SystemException {
		return iceCreamPersistence.findAll();
	}

	public List<IceCream> getIceCreams(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("getIceCreams()");
		}
		return iceCreamPersistence.findAll(start, end, orderByComparator);
	}

	public List<FacetField> getIceCreamsFacets() throws SystemException {

		List<FacetField> facets = new ArrayList<FacetField>();
		String activeServerURL = SolrUtil.getActiveSolrServer();
		try {
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(
					activeServerURL);
			SolrQuery query = new SolrQuery();

			query.setQuery(getQuery());
			boolean enableFacet = true;
			query.setFacet(enableFacet);
			query.addFacetField("iceCreamName", "iceCreamFlavor");

			QueryResponse response = server.query(query);
			facets = response.getFacetFields();
		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (SolrServerException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (HTTPException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		}

		return facets;
	}

	public List<IceCream> facetIceCreams(String facetValue)
			throws SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("facetIceCreams()");
		}
		List<IceCream> iceCreams = new ArrayList<IceCream>();
		String activeServerURL = SolrUtil.getActiveSolrServer();

		try {
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(
					activeServerURL);
			SolrQuery query = new SolrQuery();
			query.setQuery("*:*");
			query.setFacet(true);
			query.addFacetQuery("iceCreamName:" + facetValue);

			QueryResponse response = server.query(query);

			List<SolrResponse> searchResults = response
					.getBeans(SolrResponse.class);
			for (SolrResponse result : searchResults) {
				String iceCreamId = result.getEntryClassPK();
				IceCream iceCream = iceCreamPersistence.findByPrimaryKey(Long
						.parseLong(iceCreamId));
				iceCreams.add(iceCream);
			}

		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (SolrServerException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (NoSuchIceCreamException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (NumberFormatException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		}

		return iceCreams;
	}

	public List<IceCream> searchIceCreams(String name, String flavor,
			String text, int start, int rows, String orderByCol,
			String orderByType) throws PortalException, SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("searchIceCreams()");
		}
		List<IceCream> iceCreams = new ArrayList<IceCream>();
		String activeServerURL = SolrUtil.getActiveSolrServer();
		try {
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(
					activeServerURL);
			SolrQuery query = new SolrQuery();

			query.setQuery(getQuery());
			List<String> filterQueries = getFilterQueries(name, flavor, text);
			for (String fq : filterQueries) {
				query.setFilterQueries(fq);
			}

			query.setStart(start);
			query.setRows(rows);

			QueryResponse response = server.query(query);

			List<SolrResponse> searchResults = response
					.getBeans(SolrResponse.class);
			for (SolrResponse result : searchResults) {
				String iceCreamId = result.getEntryClassPK();
				IceCream iceCream = iceCreamPersistence.findByPrimaryKey(Long
						.parseLong(iceCreamId));
				iceCreams.add(iceCream);
			}
		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (SolrServerException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		}

		return iceCreams;
	}

	public List<IceCream> searchIceCreamsWithEDisMax(String name,
			String flavor, String text, String value, int start, int rows,
			String orderByCol, String orderByType) throws PortalException,
			SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("searchIceCreams()");
		}
		List<IceCream> iceCreams = new ArrayList<IceCream>();
		String activeServerURL = SolrUtil.getActiveSolrServer();
		try {
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(
					activeServerURL);
			SolrQuery query = new SolrQuery();

			query.setQuery(getQuery(value));
			query.set("qf", "iceCreamName iceCreamFlavor");
			/*
			 * List<String> filterQueries = getFilterQueries(name, flavor,
			 * text); for (String fq : filterQueries) {
			 * query.setFilterQueries(fq); }
			 */

			query.setStart(start);
			query.setRows(rows);

			boolean enableFacet = true;
			query.setFacet(enableFacet);
			query.addFacetField("iceCreamName", "iceCreamFlavor");

			QueryResponse response = server.query(query);

			List<SolrResponse> searchResults = response
					.getBeans(SolrResponse.class);

			for (SolrResponse result : searchResults) {
				String iceCreamId = result.getEntryClassPK();
				IceCream iceCream = iceCreamPersistence.findByPrimaryKey(Long
						.parseLong(iceCreamId));
				iceCreams.add(iceCream);
			}
		} catch (MalformedURLException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		} catch (SolrServerException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new SystemException(e);
		}

		return iceCreams;
	}

	private List<String> getFilterQueries(String name, String flavor,
			String text) {
		List<String> fqs = new ArrayList<String>();
		if (Validator.isNotNull(name)) {
			fqs.add(getNameFilterQuery(name));
		}

		if (Validator.isNotNull(flavor)) {
			fqs.add(getFlavorFilterQuery(flavor));
		}

		if (Validator.isNotNull(text)) {
			fqs.add(getTextFilterQuery(text));
		}

		return fqs;
	}

	private String getTextFilterQuery(String text) {
		return "content:" + text;
	}

	private String getFlavorFilterQuery(String flavor) {
		return "iceCreamFlavor:" + flavor;
	}

	private String getNameFilterQuery(String name) {
		return "iceCreamName:" + name;
	}

	private String getQuery(String value) {
		return "{!edismax}" + value;
	}

	private String getQuery() {
		return getEDisMaxSimpleQuery();
	}

	private String getEDisMaxSimpleQuery() {
		return "{!edismax} entryClassName:com.ssavr.solr.beans.IceCreamBean";
	}

	/***************************************************************************
	 ************************ DELETE *******************************************
	 ***************************************************************************/

	public void deleteIceCream(long iceCreamId) throws PortalException,
			SystemException {
		IceCream iceCream = iceCreamPersistence.findByPrimaryKey(iceCreamId);
		iceCreamDocumentsLocalService
				.deleteIceCreamDocumentsByIceCreamId(iceCreamId);
		try {
			IceCreamBean bean = getIceCreamBean(iceCream);
			IndexerRegistryUtil.getIndexer(IceCreamBean.class).delete(bean);
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
			throw new PortalException(e);
		}
		iceCreamPersistence.remove(iceCream);
	}

	private static Log _log = LogFactoryUtil
			.getLog(IceCreamLocalServiceImpl.class);
}