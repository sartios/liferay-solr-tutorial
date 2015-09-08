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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.service.ServiceContext;
import com.ssavr.solr.beans.IceCreamBean;
import com.ssavr.solr.model.IceCream;
import com.ssavr.solr.model.IceCreamDocuments;
import com.ssavr.solr.service.IceCreamLocalServiceUtil;
import com.ssavr.solr.service.base.IceCreamDocumentsLocalServiceBaseImpl;

/**
 * The implementation of the ice cream documents local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ssavr.solr.service.IceCreamDocumentsLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author SAVRAMIS
 * @see com.ssavr.solr.service.base.IceCreamDocumentsLocalServiceBaseImpl
 * @see com.ssavr.solr.service.IceCreamDocumentsLocalServiceUtil
 */
public class IceCreamDocumentsLocalServiceImpl extends
		IceCreamDocumentsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ssavr.solr.service.IceCreamDocumentsLocalServiceUtil} to access the
	 * ice cream documents local service.
	 */

	public List<IceCreamDocuments> addIceCreamDocuments(long userId,
			long companyId, ServiceContext serviceContext, long iceCreamId,
			String[] documentIds) throws SystemException, PortalException,
			Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("addIceCreamDocuments()");
		}
		List<IceCreamDocuments> documents = new ArrayList<IceCreamDocuments>();
		for (String documentId : documentIds) {
			IceCreamDocuments document = addIceCreamDocument(userId, companyId,
					serviceContext, iceCreamId, documentId);
			documents.add(document);
		}
		return documents;
	}

	public IceCreamDocuments addIceCreamDocument(long userId, long companyId,
			ServiceContext serviceContext, long iceCreamId, String documentId)
			throws SystemException, PortalException, Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("addIceCreamDocument()");
		}
		long iceCreamDocumentId = counterLocalService
				.increment(IceCreamDocuments.class.getName());
		IceCreamDocuments document = iceCreamDocumentsPersistence
				.create(iceCreamDocumentId);
		document.setUserId(userId);
		document.setCompanyId(companyId);
		document.setUuid(serviceContext.getUuid());
		document.setIceCreamId(iceCreamId);
		document.setDocumentId(Long.parseLong(documentId));
		Date now = new Date();
		document.setCreateDate(now);
		document.setModifiedDate(now);
		document = iceCreamDocumentsPersistence.update(document, false,
				serviceContext);

		IceCream iceCream = iceCreamLocalService.getIceCream(iceCreamId);
		if (iceCream != null) {
			if (_log.isDebugEnabled()) {
				_log.debug("addUpdateIndex(" + iceCreamId + ")");
			}
			Indexer indexer = IndexerRegistryUtil
					.getIndexer(IceCreamBean.class);
			IceCreamBean bean = IceCreamLocalServiceUtil
					.getIceCreamBean(iceCream);
			indexer.reindex(bean);
		}

		return document;
	}

	public List<IceCreamDocuments> getIceCreamDocumentsByIceCreamId(
			long iceCreamId) throws SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("getIceCreamDocumentsByIceCreamId()");
		}
		return iceCreamDocumentsPersistence.findByIceCreamId(iceCreamId);
	}

	public void deleteIceCreamDocumentsByIceCreamId(long iceCreamId)
			throws SystemException {
		if (_log.isDebugEnabled()) {
			_log.debug("deleteIceCreamDocumentsByIceCreamId()");
		}
		List<IceCreamDocuments> documents = iceCreamDocumentsPersistence
				.findByIceCreamId(iceCreamId);
		for (IceCreamDocuments document : documents) {
			iceCreamDocumentsPersistence.remove(document);
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(IceCreamDocumentsLocalServiceImpl.class);
}