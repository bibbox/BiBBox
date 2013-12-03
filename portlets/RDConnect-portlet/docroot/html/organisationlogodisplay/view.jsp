<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	if(organizationId == 16527)
		continue;
	if(organizationId == 16520)
		continue;
	if(organizationId == 26585)
		continue;
    ///image/user_portrait?screenName=mue&companyId=22945
    ///image/layout_set_logo?img_id=30100&t=1385933683439
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
%>
	<img alt="logo" src="<%= imgPath %>" width="120px" />
<%
break;
}
%>
<br />

