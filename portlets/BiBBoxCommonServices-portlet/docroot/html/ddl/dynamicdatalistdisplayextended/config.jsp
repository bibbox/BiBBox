<%@ include file="/html/ddl/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String recordname_cfg = GetterUtil.getString(portletPreferences.getValue("recordname", ""));
boolean countFields_cfg = GetterUtil.getBoolean(portletPreferences.getValue("countFields", "false"));
float countFieldsCutoff_cfg = GetterUtil.getFloat(portletPreferences.getValue("countFieldsCutoff", "0.8"));
boolean headerenabled_cfg = GetterUtil.getBoolean(portletPreferences.getValue("headerenabled", "false"));
String headertitle_cfg = GetterUtil.getString(portletPreferences.getValue("headertitle", ""));
String headertooltip_cfg = GetterUtil.getString(portletPreferences.getValue("headertooltip", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Record Name -->
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--recordname--" label="Record Name" type="text" value ="<%= recordname_cfg %>" />
			</aui:column>
			<!-- Count Fields -->
			<aui:column columnWidth="50">
				<aui:input name="preferences--countFields--" type="checkbox" value="<%= countFields_cfg %>" label="Add number of filled fields:" />
			</aui:column>
			<!-- Count Fields Cutoff -->
			<aui:column columnWidth="50" last="true">
				<aui:input name="preferences--countFieldsCutoff--" label="Count Fields Cutoff for highlighting:" type="text" value ="<%= countFieldsCutoff_cfg %>" />
			</aui:column>
		</aui:layout>
		<!-- Header -->
		<aui:layout cssClass="proposelayout">
			<!-- Enable/disable custom Header -->
			<aui:column columnWidth="25" first="true">
				<aui:input name="preferences--headerenabled--" type="checkbox" label="Use owne Header" value ="<%= headerenabled_cfg %>" />
			</aui:column>
			<!-- Header Title -->
			<aui:column columnWidth="25">
				<aui:input name="preferences--headertitle--" label="Title" type="text" value ="<%= headertitle_cfg %>" />
			</aui:column>
			<!-- Header Tooptip -->
			<aui:column columnWidth="50" last="true">
				<aui:input name="preferences--headertooltip--" label="Tips" type="text" value ="<%= headertooltip_cfg %>" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>