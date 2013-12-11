<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.LayoutSetPrototypeServiceUtil" %>
<%@ page import="com.liferay.portal.model.LayoutSetPrototype" %>

<portlet:defineObjects />

This is the <b>Master Publish</b> portlet in View mode.

<portlet:actionURL name='publishToGate' var="publishToGateURL" />

<aui:button type="cancel"  onClick="<%= publishToGateURL %>" />

<% 
long companyID = company.getCompanyId(); 
%>

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
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
%>

|<%= o.getGroup() %>|
	<p><aui:a href="<%= orgPath %>"><img alt="logo" src="<%= imgPath %>" width="120px" /><br><%= o.getName() %></aui:a></p>
	
	
<%
}

List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);
%>
Companyid <%= company.getCompanyId() %>

<%
	for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
%>
<%= HtmlUtil.escape(layoutSetPrototype.getName(user.getLanguageId())) %> | <%= layoutSetPrototype.getLayoutSetPrototypeId() %> | <%= LayoutSetPrototypeServiceUtil.getLayoutSetPrototype(23302) %>
<%
}
%>
<br />