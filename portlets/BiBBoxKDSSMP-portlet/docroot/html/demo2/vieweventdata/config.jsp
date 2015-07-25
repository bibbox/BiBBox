<%@ include file="/html/demo2/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsGroupFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsGroupFilter", ""));
String optionsTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsTitle", ""));
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<aui:column columnWidth="100" first="true">
   				<aui:input name="preferences--optionsGroupFilter--" label="Group Filter" type="text" value ="<%= optionsGroupFilter_cfg %>" />
   			</aui:column>
   			<aui:column columnWidth="100" first="true">
   				<aui:input name="preferences--optionsTitle--" label="Title" type="text" value ="<%= optionsTitle_cfg %>" />
   			</aui:column>
   		</aui:layout>
   	</aui:fieldset>
   	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
