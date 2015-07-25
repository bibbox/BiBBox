<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
.symboltypeconfigurationtemplate {
	height: 500px;
	width: 1700px;
}
</style>

<%
SymbolTypeConfiguration symboltypeconfiguration = null;

	long symboltypeconfigurationId = ParamUtil.getLong(request, "symboltypeconfigurationId");

	if (symboltypeconfigurationId > 0) {
		symboltypeconfiguration = SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfiguration(symboltypeconfigurationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= symboltypeconfiguration %>" model="<%= SymbolTypeConfiguration.class %>" />

<portlet:actionURL name='<%= symboltypeconfiguration == null ? "addSymbolTypeConfiguration" : "updateSymbolTypeConfiguration" %>' var="editSymbolTypeConfigurationURL" windowState="normal" />
<aui:form action="<%= editSymbolTypeConfigurationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="symboltypeconfigurationId" value='<%= symboltypeconfiguration == null ? "" : symboltypeconfiguration.getSymboltypeconfigurationId() %>'/>

		<aui:input name="symboltype" />
		<aui:input name="template" type="textarea"  cssClass="symboltypeconfigurationtemplate" />
		<aui:input name="symboliconconfiguration" />
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>