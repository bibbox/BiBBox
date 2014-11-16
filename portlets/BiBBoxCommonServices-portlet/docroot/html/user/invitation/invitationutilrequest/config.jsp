<%@ include file="/html/user/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsDefaultText_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDefaultText", "organisation"));
String optionsRequestStatusId_cfg = GetterUtil.getString(portletPreferences.getValue("optionsRequestStatusId", "0"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<aui:column columnWidth="100" first="true">
   				<aui:input name="preferences--optionsDefaultText--" cssClass="bibbox_cs_width_100" label="Set Default Text" type="textarea" value ="<%= optionsDefaultText_cfg %>" />
   			</aui:column>
   			<aui:column columnWidth="100" first="true">
   				<aui:select label="Send Request Status" name="preferences--optionsRequestStatusId--" >
   					<aui:option value="20" selected="<%=\"20\".equals(optionsRequestStatusId_cfg) %>" >Request Panel Assessment</aui:option>
   				</aui:select>
   			</aui:column>
   		</aui:layout>
   	</aui:fieldset>
   	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>