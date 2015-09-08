package com.ssavr.solr.search;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.solr.client.solrj.response.FacetField;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ssavr.solr.model.IceCream;
import com.ssavr.solr.service.IceCreamLocalServiceUtil;

/**
 * Portlet implementation class SearchIceCreams
 */
public class SearchIceCreams extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (_log.isDebugEnabled()) {
			_log.debug("doView()");
		}
		Boolean doSearch = (Boolean) renderRequest.getAttribute("showSearch");
		doSearch = (doSearch == null) ? new Boolean(false) : doSearch;

		registerFacets(renderRequest);

		if (doSearch) {
			initSearchContainer(renderRequest, renderResponse);
		}
		super.doView(renderRequest, renderResponse);
	}

	private void registerFacets(RenderRequest renderRequest) {
		try {
			List<FacetField> facets = IceCreamLocalServiceUtil
					.getIceCreamsFacets();
			renderRequest.setAttribute("facets", facets);
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
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

		List<IceCream> results = searchIceCreams(renderRequest);
		end = results.size() > end ? end : results.size();
		start = results.size() > start ? start : results.size();
		results.subList(start, end);
		int total = searchIceCreams(renderRequest).size();

		searchContainer.setResults(results);
		searchContainer.setTotal(total);
		searchContainer.setEmptyResultsMessage("empty-result-message");

		renderRequest.setAttribute("totalAttr", total);
		renderRequest.setAttribute("searchContainerAttr", searchContainer);
		renderRequest.setAttribute("resultsAttr", results);
	}

	private String getOrderByType(RenderRequest renderRequest) {
		return "desc";
	}

	private String getOrderByCol(RenderRequest renderRequest) {
		return null;
	}

	private List<IceCream> searchIceCreams(RenderRequest renderRequest) {
		String name = ParamUtil.getString(renderRequest, "name",
				StringPool.BLANK);
		String flavor = ParamUtil.getString(renderRequest, "flavor",
				StringPool.BLANK);
		String text = ParamUtil.getString(renderRequest, "text",
				StringPool.BLANK);
		String facetValue = ParamUtil.getString(renderRequest, "facetValue",
				StringPool.BLANK);
		String facetField = ParamUtil.getString(renderRequest, "facetField",
				StringPool.BLANK);

		name = name.trim().isEmpty() && !facetValue.trim().isEmpty()
				&& facetField.equals("iceCreamName") ? facetValue : name;
		flavor = flavor.trim().isEmpty() && !facetValue.trim().isEmpty()
				&& facetField.equals("iceCreamFlavor") ? facetValue : flavor;

		String generalText = ParamUtil.getString(renderRequest, "generalText",
				StringPool.BLANK);

		if (_log.isDebugEnabled()) {
			_log.debug(".....................search(name: " + name
					+ ", flavor: " + flavor + ", text: " + text + ")");
		}

		int start = 0;
		int rows = 100;
		String orderByCol = "";
		String orderByType = "";

		List<IceCream> results = Collections.emptyList();

		try {
			results = IceCreamLocalServiceUtil.searchIceCreams(name, flavor,
					text, start, rows, orderByCol, orderByType);

			_log.warn("Found: " + results.size() + " Ice Cream(-s)");

			if (!generalText.isEmpty()) {
				results = IceCreamLocalServiceUtil.searchIceCreamsWithEDisMax(
						name, flavor, text, generalText, start, rows,
						orderByCol, orderByType);

				_log.warn("eDisMax found: " + results.size() + " Ice Cream(-s)");
			}

		} catch (PortalException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
		return results;
	}

	public void searchIceCreams(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		if (_log.isDebugEnabled()) {
			_log.debug("searchIceCreams()");
		}
		actionRequest.setAttribute("showSearch", true);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	public void facetIceCreams(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		if (_log.isDebugEnabled()) {
			_log.debug("facetIceCreams(facetField)");
		}

		actionRequest.setAttribute("showSearch", true);
		actionRequest.setAttribute("facetSearch", true);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(SearchIceCreams.class);
}