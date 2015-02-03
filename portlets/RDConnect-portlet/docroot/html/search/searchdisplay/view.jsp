<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page
	import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet"%>
<%@ page
	import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page
	import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.UserGroupRole"%>
<%@ page import="java.util.ArrayList"%>

<portlet:defineObjects />

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
	String searchurl1 = themeDisplay.getURLPortal() + "/web/guest/search";
%>
<aui:form action="<%= searchurl1 %>" method="POST" name="fm">
	<aui:fieldset>
		<input style="width: 420px;" type="text" placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..." value="<%= keywords %>" name="SEARCH" size="60">
	</aui:fieldset>
	<aui:button-row cssClass="searchFiledFloat">
		<aui:button type="submit" value="Search" />
	</aui:button-row>
</aui:form>

Search for: <%= keywords %>
<%
	if(keywords.equalsIgnoreCase("")) {
		%>
		<h4>No search key specified.</h4>
		<br />
		<%
	} else {
		String textresult = SearchIndexLocalServiceUtil.getSearchIndexByKeyword(keywords, themeDisplay, request.getContextPath());
		%>
		<%= textresult %>
		<br />
		<%
	}
%>

