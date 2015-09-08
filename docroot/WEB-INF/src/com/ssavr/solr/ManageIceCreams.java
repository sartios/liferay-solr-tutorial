package com.ssavr.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ssavr.solr.model.IceCream;
import com.ssavr.solr.service.IceCreamLocalServiceUtil;

/**
 * Portlet implementation class ManageIceCreams
 */
public class ManageIceCreams extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (_log.isDebugEnabled()) {
			_log.debug("doView()");
		}
		initSearchContainer(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	private void initSearchContainer(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		if (_log.isDebugEnabled()) {
			_log.debug("initSearchContainer()");
		}
		String curParam = "cur";
		int cur = ParamUtil.getInteger(renderRequest, curParam, 1);
		int delta = ParamUtil.getInteger(renderRequest, "delta", 20);
		String orderByCol = getOrderByCol(renderRequest);
		String orderByType = getOrderByType(renderRequest);

		DisplayTerms displayTerms = null;
		DisplayTerms searchTerms = null;
		PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest,
				renderResponse);
		List<String> headerNames = null;
		String emptyResultsMessage = null;
		SearchContainer<IceCream> searchContainer = new SearchContainer<IceCream>(
				renderRequest, displayTerms, searchTerms, curParam, cur, delta,
				iteratorURL, headerNames, emptyResultsMessage);
		searchContainer.setOrderByCol("");
		searchContainer.setOrderByType(orderByType);

		OrderByComparator comparator = null;
		searchContainer.setOrderByComparator(comparator);

		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		if (_log.isDebugEnabled()) {
			_log.debug("Start: " + start);
			_log.debug("End: " + end);
		}

		List<IceCream> results = getIceCreams(start, end, comparator);
		int total = getCount();

		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		searchContainer.setEmptyResultsMessage("empty-result-message");

		renderRequest.setAttribute("totalAttr", total);
		renderRequest.setAttribute("searchContainerAttr", searchContainer);
		renderRequest.setAttribute("resultsAttr", results);
	}

	private int getCount() {
		int count = 0;
		try {
			count = IceCreamLocalServiceUtil.getIceCreamsCount();
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
		return count;
	}

	private List<IceCream> getIceCreams(int start, int end,
			OrderByComparator comparator) {
		if (_log.isDebugEnabled()) {
			_log.debug("getIceCreams()");
		}
		List<IceCream> iceCreams = new ArrayList<IceCream>();
		try {
			iceCreams = IceCreamLocalServiceUtil.getIceCreams(start, end,
					comparator);
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
		return iceCreams;
	}

	private String getOrderByType(RenderRequest renderRequest) {
		return "desc";
	}

	private String getOrderByCol(RenderRequest renderRequest) {
		return null;
	}

	public void createIceCream(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		if (_log.isDebugEnabled()) {
			_log.debug("createIceCream()");
		}

		long companyId = PortalUtil.getCompanyId(actionRequest);
		long userId = PortalUtil.getUserId(actionRequest);
		ServiceContext serviceContext = getServiceContext(actionRequest,
				IceCream.class.getName());
		String name = ParamUtil.get(actionRequest, "name", StringPool.BLANK);
		String flavor = ParamUtil
				.get(actionRequest, "flavor", StringPool.BLANK);
		String documentIds = ParamUtil.get(actionRequest,
				"iceCreamDocumentsIds", StringPool.BLANK);

		String[] documents = StringUtil.split(documentIds);

		try {
			IceCreamLocalServiceUtil.addIceCream(userId, companyId,
					serviceContext, name, flavor, documents);
		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
	}

	private ServiceContext getServiceContext(ActionRequest actionRequest,
			String clazz) {
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(clazz,
					actionRequest);
		} catch (PortalException e1) {
			if (_log.isErrorEnabled()) {
				_log.error(e1.getMessage());
			}
		} catch (SystemException e1) {
			if (_log.isErrorEnabled()) {
				_log.error(e1.getMessage());
			}
		}
		return serviceContext;
	}

	public void deleteIceCreams(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		if (_log.isDebugEnabled()) {
			_log.debug("deleteIceCreams()");
		}
		long[] rowIds = ParamUtil.getLongValues(actionRequest, "rowIds");
		for (long rowId : rowIds) {
			deleteIceCream(rowId);
		}
	}

	private void deleteIceCream(long rowId) {
		try {
			IceCreamLocalServiceUtil.deleteIceCream(rowId);
		} catch (PortalException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ManageIceCreams.class);
}