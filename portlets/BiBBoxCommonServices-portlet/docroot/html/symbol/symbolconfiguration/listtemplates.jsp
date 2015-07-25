<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-ui:header
	backURL="/symbolconfiguration"
	title='Back to Configurations'
/>

<h3>List Templates</h3>
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
<aui:button-row>
	<portlet:renderURL var="addTemplateURL">
		<portlet:param name="mvcPath" value="/html/symbol/symbolconfiguration/edit_template.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button value="add-templates" onClick="<%= addTemplateURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurations(-1, -1) %>"
		total="<%= SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurationsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration"
		keyProperty="symboltypeconfigurationId"
		modelVar="symboltypeconfiguration" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			value="<%= Long.toString(symboltypeconfiguration.getSymboltypeconfigurationId()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Type"
			value="<%= symboltypeconfiguration.getSymboltype() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Template"
			value="<%= symboltypeconfiguration.getTemplate() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Symboliconconfiguration"
			value="<%= symboltypeconfiguration.getSymboliconconfiguration() %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/symbol/symbolconfiguration/template_actions.jsp"
		/>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
