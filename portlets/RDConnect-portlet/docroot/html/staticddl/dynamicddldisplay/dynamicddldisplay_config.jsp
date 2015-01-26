<%@ include file="/html/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsDDLName_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDDLName", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:column columnWidth="75" last="true">
				<aui:input name="preferences--optionsDDLName--" label="Set Specific Name" type="text" value ="<%= optionsDDLName_cfg %>" cssClass="propose" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
