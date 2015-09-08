<%@page import="com.ssavr.solr.model.IceCream"%>
<%@page import="org.apache.solr.client.solrj.response.FacetField"%>
<%@page import="java.util.List"%>

<%
	int totalIceCreams = (Integer) renderRequest
			.getAttribute("totalAttr");
	SearchContainer iceCreamSearchContainer = (SearchContainer) renderRequest
			.getAttribute("searchContainerAttr");
	List<IceCream> iceCreams = (List<IceCream>) renderRequest
			.getAttribute("resultsAttr");
%>

<aui:fieldset>
		<aui:layout>
			<liferay-ui:search-container
				searchContainer="<%=iceCreamSearchContainer%>"
				deltaParam="delta" delta="50">

				<liferay-ui:search-container-results results="<%=iceCreams%>"
					total="<%=totalIceCreams%>" />

				<liferay-ui:search-container-row
					className="com.ssavr.solr.model.IceCream"
					keyProperty="iceCreamId" modelVar="iceCream">

					<liferay-ui:search-container-column-text
						name="ice-cream-name-label" value="<%=iceCream.getName()%>"
						orderable="false" />

					<liferay-ui:search-container-column-text
						name="ice-cream-flavor-label" value="<%=iceCream.getFlavor()%>"
						orderable="false" />

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:layout>
	</aui:fieldset>