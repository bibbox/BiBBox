<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addTemplateURL">
		<portlet:param name="mvcPath" value="/html/configuration/kdssmpconfiguration/edit_kdssmpconfiguration.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button value="add-templates" onClick="<%= addTemplateURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= KdssmpConfigurationLocalServiceUtil.getKdssmpConfigurations(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= KdssmpConfigurationLocalServiceUtil.getKdssmpConfigurationsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration"
		keyProperty="configurationId"
		modelVar="kdssmpconfiguration" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			value="<%= Long.toString(kdssmpconfiguration.getConfigurationId()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Scope"
			value="<%= kdssmpconfiguration.getScope() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Key"
			value="<%= kdssmpconfiguration.getOptionkey() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Value"
			value="<%= kdssmpconfiguration.getOptionvalue() %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/configuration/kdssmpconfiguration/kdssmpconfiguration_actions.jsp"
		/>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>