<%@ include file="/html/init.jsp"%>

<%
ParameterOptionsConfiguration parameteroptionsconfiguration = null;

	long parameteroptionsconfigurationId = ParamUtil.getLong(request, "parameteroptionsconfigurationId");

	if (parameteroptionsconfigurationId > 0) {
		parameteroptionsconfiguration = ParameterOptionsConfigurationLocalServiceUtil.getParameterOptionsConfiguration(parameteroptionsconfigurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= parameteroptionsconfiguration %>" model="<%= ParameterOptionsConfiguration.class %>" />

<portlet:actionURL name='<%= parameteroptionsconfiguration == null ? "addParameterOptionsConfiguration" : "updateParameterOptionsConfiguration" %>' var="editParameterOptionsConfigurationURL" windowState="normal" />
<aui:form action="<%= editParameterOptionsConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="parameterconfigurationId" value='<%= parameteroptionsconfiguration == null ? "" : parameteroptionsconfiguration.getParameteroptionsconfigurationId() %>'/>
		
		<aui:input name="parameterconfigurationId" />
		<aui:input name="optionkey" />
		<aui:input name="optionvalue" />
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>