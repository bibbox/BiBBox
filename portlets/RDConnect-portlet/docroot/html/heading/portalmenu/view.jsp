<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	
%>
	<aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" height="40" width="40" /><%= o.getName() %></aui:a>
<%
}
%>
<br />
