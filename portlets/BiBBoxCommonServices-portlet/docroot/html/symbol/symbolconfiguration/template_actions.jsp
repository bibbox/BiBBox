<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
SymbolTypeConfiguration symboltypeconfiguration = (SymbolTypeConfiguration)row.getObject();

String name = SymbolTypeConfiguration.class.getName();
long symboltypeconfigurationId = symboltypeconfiguration.getSymboltypeconfigurationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/symbol/symbolconfiguration/edit_template.jsp" />
		<portlet:param name="symboltypeconfigurationId" value="<%= String.valueOf(symboltypeconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteSymbolTypeConfiguration" var="deleteSymbolTypeConfigurationURL">
		<portlet:param name="symboltypeconfigurationId" value="<%= String.valueOf(symboltypeconfigurationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteSymbolTypeConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>