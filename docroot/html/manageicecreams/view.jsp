<%@ include file="/html/manageicecreams/init.jsp"%>
<%@page import="com.ssavr.solr.model.IceCream"%>

<%
	int totalIceCreams = (Integer) renderRequest
			.getAttribute("totalAttr");
	SearchContainer iceCreamSearchContainer = (SearchContainer) renderRequest
			.getAttribute("searchContainerAttr");
	List<IceCream> iceCreams = (List<IceCream>) renderRequest
			.getAttribute("resultsAttr");
	RowChecker rowChecker = new RowChecker(renderResponse);
%>

<portlet:renderURL var="viewCreateIceCreamURL"
	windowState="<%=WindowState.NORMAL.toString()%>">
	<portlet:param name="jspPage"
		value="/html/manageicecreams/createIceCream.jsp" />
</portlet:renderURL>

<portlet:actionURL name="deleteIceCreams" var="deleteIceCreamsUrl" />

<aui:form name="viewIceCreamsFm" method="post"
	action="<%=deleteIceCreamsUrl.toString()%>">
	<aui:fieldset>
		<aui:layout>
			<liferay-ui:search-container
				searchContainer="<%=iceCreamSearchContainer%>"
				rowChecker="<%=rowChecker%>" deltaParam="delta" delta="50">

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

	<aui:button-row>
		<aui:button name="createIceCream" value="view-create-ice-cream"
			onClick="<%=viewCreateIceCreamURL.toString()%>"></aui:button>
		<aui:button name="deleteIceCreams" value="delete-ice-creams"
			 type="submit" />
	</aui:button-row>

</aui:form>