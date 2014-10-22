<%
	String keywords = "";
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	keywords = httpRequest.getParameter("SEARCH");
	if (keywords == null) {
		keywords = "";
	}
%>

<%
	String searchurl1 = themeDisplay.getURLPortal() + themeDisplay.getLayout().getFriendlyURL();
%>

<%= searchurl1 %>