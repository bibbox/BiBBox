<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
KdssmpConfiguration kdssmpconfiguration = null;

	long kdssmpconfigurationId = ParamUtil.getLong(request, "kdssmpconfigurationId");

	if (kdssmpconfigurationId > 0) {
		kdssmpconfiguration = KdssmpConfigurationLocalServiceUtil.getKdssmpConfiguration(kdssmpconfigurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= kdssmpconfiguration %>" model="<%= KdssmpConfiguration.class %>" />

<portlet:actionURL name='<%= kdssmpconfiguration == null ? "addKdssmpConfiguration" : "updateKdssmpConfiguration" %>' var="editKdssmpConfigurationURL" windowState="normal" />
<aui:form action="<%= editKdssmpConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="configurationId" value='<%= kdssmpconfiguration == null ? "" : kdssmpconfiguration.getConfigurationId() %>'/>

		<aui:input name="scope" />
		<aui:input name="optionkey" />
		<aui:input name="optionvalue" />
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>