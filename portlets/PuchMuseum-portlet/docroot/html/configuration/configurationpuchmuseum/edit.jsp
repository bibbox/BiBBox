<%@ include file="/html/init.jsp"%>

<%
Configuration configuration = null;

	long configurationId = ParamUtil.getLong(request, "configurationId");

	if (configurationId > 0) {
		configuration = ConfigurationLocalServiceUtil.getConfiguration(configurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= configuration %>" model="<%= Configuration.class %>" />

<portlet:actionURL name='<%= configuration == null ? "addConfiguration" : "updateConfiguration" %>' var="editConfigurationURL" windowState="normal" />
<aui:form action="<%= editConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="configurationId" value='<%= configuration == null ? "" : configuration.getConfigurationId() %>'/>

		<aui:input name="scope" />
		<aui:input name="optionkey" />
		<aui:input name="optionvalue" />
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<%
if (configurationId > 0) {
	if(configuration.getScope().equalsIgnoreCase("Object")) {
		%>
		<%@include file="/html/configuration/configurationpuchmuseum/view_configurations_for_object.jspf" %>
		<%
	} else if(configuration.getScope().equalsIgnoreCase("Parameter")) {
		%>
		<%@include file="/html/configuration/parameterconfiguration/view_parameters_for_configuration.jspf" %>
		<%
	}
}
%>