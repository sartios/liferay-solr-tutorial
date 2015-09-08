<%@ include file="/html/manageicecreams/init.jsp"%>

<portlet:actionURL name="createIceCream" var="createIceCreamURL" />

<aui:form name="createIceCreamFm" method="post"
	action="<%=createIceCreamURL.toString()%>">

	<aui:fieldset>
		<aui:layout>
			<aui:input id="name" name="name" label="ice-cream-name"/>
			<aui:input id="flavor" name="flavor" label="ice-cream-flavor"/>
			
			<%@ include file="/html/manageicecreams/multiDocument.jsp"%>
			<aui:button-row>
				<aui:button name="createBtn" value="create-ice-cream" type="submit"/>
			</aui:button-row>
		</aui:layout>
	</aui:fieldset>
</aui:form>