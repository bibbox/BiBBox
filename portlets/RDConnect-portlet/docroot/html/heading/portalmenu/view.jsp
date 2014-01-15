<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>

<portlet:defineObjects />
<span>
<aui:a href='<%= themeDisplay.getURLPortal()+"/home" %>'><img alt="homelogo" src="<%= request.getContextPath() %>/images/RDLogoglobe.png" height="40" width="40" /></aui:a>
<%
long organizationId = 0;
long userId = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId);
int i = 0;
for(Organization o : organisations) {
	organizationId = o.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+o.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
	
	if(i>4) {
		continue;
	}
	
	%>
	<aui:a href="<%= orgPath %>"><img alt="logo" height="40" width="40" src="<%= imgPath %>" /></aui:a>
	<%
	i++;
}

%>
</span>

<span>

<% String useraccountedit = themeDisplay.getURLPortal() + "/my_account"; %>

<!--<aui:a href="<%= useraccountedit %>"><%= themeDisplay.getUser().getFullName() %></aui:a>-->

</span>

