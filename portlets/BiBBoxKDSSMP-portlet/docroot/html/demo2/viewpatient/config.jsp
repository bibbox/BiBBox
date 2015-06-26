<%@ include file="/html/demo2/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsHorizontalLayout_cfg = GetterUtil.getString(portletPreferences.getValue("optionsHorizontalLayout", "vertical"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:layout cssClass="proposelayout">
   			<aui:column columnWidth="100" first="true">
   				<aui:select label="Select Layout Type" name="preferences--optionsHorizontalLayout--">
   					<aui:option value="vertical" selected='<%= optionsHorizontalLayout_cfg.equalsIgnoreCase("vertical") ? true : false %>' >Vertical</aui:option>
					<aui:option value="horizontal" selected='<%= optionsHorizontalLayout_cfg.equalsIgnoreCase("horizontal") ? true : false %>' >Horizontal</aui:option>
   				</aui:select>
   			</aui:column>
   		</aui:layout>
   	</aui:fieldset>
   	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>