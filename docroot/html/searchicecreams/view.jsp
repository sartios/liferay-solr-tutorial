<%@page import="org.apache.solr.client.solrj.response.FacetField.Count"%>
<%@ include file="/html/searchicecreams/init.jsp"%>

<%
	Boolean showSearch = (Boolean) renderRequest
			.getAttribute("showSearch");
	showSearch = (showSearch == null) ? new Boolean(false) : showSearch;
	List<FacetField> facets = (List<FacetField>) renderRequest.getAttribute("facets");
%>

<portlet:actionURL name="searchIceCreams" var="searchIceCreamsUrl" />

<aui:form name="searchFm" method="post"
	action="<%=searchIceCreamsUrl.toString()%>">
	<aui:fieldset>
		<aui:layout>
			<aui:input id="name" name="name" label="ice-cream-name" />
			<aui:input id="flavor" name="flavor" label="ice-cream-flavor" />
			<aui:input id="text" name="text" label="recipe-text" type="textarea" />

			<aui:input id="generalText" name="generalText" label="general-text"
				type="textarea" />

			<%
				for(FacetField facet : facets){
			%>
			<ul style="float: left;">
				<portlet:actionURL name="facetIceCreams" var="facetIceCreamsUrl" />
				<li><a href="<%=facetIceCreamsUrl.toString()%>"><%=facet.getName()%></a></li>
				<ul>
					<%
						List<Count> counts = facet.getValues();
						for(Count count : counts){
							String facetValue = count.getName();
					%>

					<portlet:actionURL name="facetIceCreams" var="facetIceCreamsUrl">
						<portlet:param name="facetField" value="<%=facet.getName()%>" />
						<portlet:param name="facetValue" value="<%=facetValue%>" />
					</portlet:actionURL>

					<li><a href="<%=facetIceCreamsUrl.toString()%>"><%=facetValue%>(<%=count.getCount()%>)</a></li><br/>

					<%} %>
				</ul>
			</ul>

			<%
				}
			%>

			<aui:button-row>
				<aui:button name="searchBtn" value="search-ice-cream" type="submit" />
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>

</aui:form>

<%
	if (showSearch) {
%>
<%@ include file="/html/searchicecreams/searchContainer.jsp"%>
<%
	}
%>