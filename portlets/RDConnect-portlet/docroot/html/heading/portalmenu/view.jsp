<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<span>
<%
long organizationId = 0;
long userId = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId);
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	
	%>
	<aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" height="40" width="40" /></aui:a>
	<%
}

%>
</span>

<span>

<% String useraccountedit = themeDisplay.getURLPortal() + "/my_account"; %>

<!--<aui:a href="<%= useraccountedit %>"><%= themeDisplay.getUser().getFullName() %></aui:a>-->

</span>
