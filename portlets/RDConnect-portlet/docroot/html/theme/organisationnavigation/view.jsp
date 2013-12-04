<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();3
	String orgPath = themeDisplay.getURLHome()+o.get
%>
	<img alt="logo" src="<%= imgPath %>" width="120px" />
<%
}
%>
<br />
