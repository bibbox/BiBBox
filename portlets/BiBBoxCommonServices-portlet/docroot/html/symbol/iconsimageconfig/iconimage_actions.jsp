<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Icons icon = (Icons)row.getObject();

long iconId = icon.getIconsId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/symbol/iconsimageconfig/edit_icon.jsp" />
		<portlet:param name="iconId" value="<%= String.valueOf(iconId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteIcon" var="deleteIconURL">
		<portlet:param name="iconId" value="<%= String.valueOf(iconId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteIconURL.toString() %>" />

</liferay-ui:icon-menu>