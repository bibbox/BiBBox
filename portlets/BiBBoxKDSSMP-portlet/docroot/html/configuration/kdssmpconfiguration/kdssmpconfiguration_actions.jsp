<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
KdssmpConfiguration kdssmpconfiguration = (KdssmpConfiguration)row.getObject();

String name = KdssmpConfiguration.class.getName();
long kdssmpconfigurationId = kdssmpconfiguration.getConfigurationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/configuration/kdssmpconfiguration/edit_kdssmpconfiguration.jsp" />
		<portlet:param name="kdssmpconfigurationId" value="<%= String.valueOf(kdssmpconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteKdssmpConfiguration" var="deleteKdssmpConfigurationURL">
		<portlet:param name="kdssmpconfigurationId" value="<%= String.valueOf(kdssmpconfigurationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteKdssmpConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>