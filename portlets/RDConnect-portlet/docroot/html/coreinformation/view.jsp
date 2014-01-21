<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	/*if(organizationId == 16527)
		continue;
	if(organizationId == 16520)
		continue;
	if(organizationId == 26585)
		continue;*/
    ///image/user_portrait?screenName=mue&companyId=22945
    ///image/layout_set_logo?img_id=30100&t=1385933683439
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	if(o.getName().equalsIgnoreCase("National Biobank of Test"))
		continue;
%>
	<p><aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="120px" /><br><%= o.getName() %></aui:a></p>
<%
}
%>
<br />
