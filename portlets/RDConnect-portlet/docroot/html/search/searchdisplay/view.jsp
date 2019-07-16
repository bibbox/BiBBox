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
	String nToken = "";
	nToken = httpRequest.getParameter("nToken");
	String selectedElements = httpRequest.getParameter("selectedbiobanks");
	if (selectedElements == null) {
		selectedElements = "";
	}
%>

<%
	String searchurl1 = themeDisplay.getURLPortal() + "/web/guest/search";
%>
<aui:form action="<%= searchurl1 %>" method="POST" name="fm" style="width: 700px;">
	<aui:fieldset style="width: 600px;">
		<input style="width: 420px;" type="text" placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..." value="<%= keywords %>" name="SEARCH" size="60">
	</aui:fieldset>
	<aui:button-row cssClass="searchFiledFloat"  style="width: 90px;float: right;">
		<aui:button type="submit" value="Search" />
	</aui:button-row>
</aui:form>

Search for: <%= keywords %>

<portlet:actionURL name='negotiationStartUpdate' var="negotiationStartUpdateURL" windowState="normal" />
<aui:form action="<%= negotiationStartUpdateURL %>" method="POST" name="fm">

<aui:button-row>
	<%
	if(nToken == null) {
		%>
		<aui:button type="submit" value='Start Negotiation' />
		<%
	} else {
		%>
		<aui:button type="submit" value='Edit Negotiation' />
		<%
	} 
	%>
	
</aui:button-row>
	<aui:input type="hidden" name="ntoken" value="<%= nToken %>" />
	<aui:input type="hidden" name="humanReadable" value="<%= keywords %>" />
<%
	if(keywords.equalsIgnoreCase("")) {
		%>
		<h4>No search key specified.</h4>
		<br />
		<%
	} else {
		String textresult = SearchIndexLocalServiceUtil.getSearchIndexByKeyword(keywords, themeDisplay, request.getContextPath(), selectedElements);
		%>
		<%= textresult %>
		<br />
		<%
	}
%>
</aui:form>

