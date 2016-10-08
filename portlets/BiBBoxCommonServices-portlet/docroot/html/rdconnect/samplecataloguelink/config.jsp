<%@ include file="/html/rdconnect/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<%
String optionsLinkTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsLinkTitle", "Sample Catalogue"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:column columnWidth="25" first="true">
				<aui:input name="preferences--optionsLinkTitle--" value="<%= optionsLinkTitle_cfg %>" label="Link Title" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>