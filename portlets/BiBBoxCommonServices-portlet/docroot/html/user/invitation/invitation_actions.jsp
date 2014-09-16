<!-- 
BiBBoxCommonServices
user/invitation/invitation_actions

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Invitation invitation = (Invitation)row.getObject();

long invitationId = invitation.getInvitationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/user/invitation/edit_invitation.jsp" />
		<portlet:param name="invitationId" value="<%= String.valueOf(invitationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
	
	<portlet:actionURL name="deleteInvitation" var="deleteURL">
		<portlet:param name="invitationId" value="<%= String.valueOf(invitationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>