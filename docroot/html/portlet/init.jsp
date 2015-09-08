<%@ include file="/html/common/init.jsp" %>

<portlet:defineObjects />

<%
	WindowState windowState = null;
	PortletMode portletMode = null;
	
	PortletURL currentURLObj = null;
	
	if (renderRequest != null) {
		windowState = renderRequest.getWindowState();
		portletMode = renderRequest.getPortletMode();
	
		currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	}
	else if (resourceRequest != null) {
		windowState = resourceRequest.getWindowState();
		portletMode = resourceRequest.getPortletMode();
	
		currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
	}
	
	String currentURL = currentURLObj.toString();

	//Portal Preferences
	PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);
	
	//Portlet Preferences
	PortletPreferences preferences = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
%>