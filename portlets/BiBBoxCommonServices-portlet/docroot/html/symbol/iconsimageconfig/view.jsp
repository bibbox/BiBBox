<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addIconURL">
		<portlet:param name="mvcPath" value="/html/symbol/iconsimageconfig/edit_icon.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button value="list-templates" onClick="<%= addIconURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= IconsLocalServiceUtil.getIconses(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= IconsLocalServiceUtil.getIconsesCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.meduni.liferay.portlet.bibbox.model.Icons"
		keyProperty="iconsId"
		modelVar="icons" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			value="<%= Long.toString(icons.getIconsId()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Group"
			value="<%= icons.getGroup() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="IconURL"
			value="<%= icons.getIconurl() %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right" 
			path="/html/symbol/iconsimageconfig/icon.jsp"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/symbol/iconsimageconfig/iconimage_actions.jsp"
		/>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
