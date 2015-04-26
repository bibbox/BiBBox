<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsFilter", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Filter  -->
			<aui:column columnWidth="50" first="true">
				<aui:select label="Select Filter for Networks" name="preferences--optionsFilter--">
					<aui:option value="" selected='<%= optionsFilter_cfg.equalsIgnoreCase("") %>' >No filtering</aui:option>
					<aui:option value="network" selected='<%= optionsFilter_cfg.equalsIgnoreCase("network") %>' >Network</aui:option>
				</aui:select>
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>