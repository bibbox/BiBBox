<%@ include file="/html/init.jsp"%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<aui:button-row>
	<portlet:renderURL var="addConfigurationURL">
		<portlet:param name="mvcPath" value="/html/configuration/configurationpuchmuseum/edit.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button value="add-configuration" onClick="<%= addConfigurationURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "20")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ConfigurationLocalServiceUtil.getConfigurations(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ConfigurationLocalServiceUtil.getConfigurationsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.hmmc.liferay.portlet.puch.model.Configuration"
		keyProperty="configurationId"
		modelVar="configuration" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			value="<%= Long.toString(configuration.getConfigurationId()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Scope"
			value="<%= configuration.getScope() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Key"
			value="<%= configuration.getOptionkey() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Value"
			value="<%= configuration.getOptionvalue() %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/configuration/configurationpuchmuseum/configuration_actions.jsp"
		/>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
