<%@ include file="/html/haybaeck/init.jsp" %>

This is the <b>TMA</b> portlet in View mode.

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<!-- Top Actions -->
<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/haybaeck/tma/updateTMAFile.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="Update TMA from File" url="<%=editURL.toString() %>" />
	
	<portlet:renderURL var="editURL2">
		<portlet:param name="mvcPath" value="/html/haybaeck/tma/updateTMAFile.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL2.toString() %>" />
	
</liferay-ui:icon-menu>

<!-- Top Actions -->
