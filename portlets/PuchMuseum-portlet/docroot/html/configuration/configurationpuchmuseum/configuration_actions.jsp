<%@ include file="/html/init.jsp" %> 

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Configuration configuration = (Configuration)row.getObject();

String name = Configuration.class.getName();
long configurationId = configuration.getConfigurationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/html/configuration/configurationpuchmuseum/view.jsp" />
		<portlet:param name="configurationId" value="<%= String.valueOf(configurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="view" url="<%=viewURL.toString() %>" />

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/configuration/configurationpuchmuseum/edit.jsp" />
		<portlet:param name="configurationId" value="<%= String.valueOf(configurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteConfiguration" var="deleteConfigurationURL">
		<portlet:param name="configurationId" value="<%= String.valueOf(configurationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>