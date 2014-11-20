<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
List<InvitationOrganisation> invitationorganisation = InvitationOrganisationLocalServiceUtil.getInvitationOrganisationByStatus();
%>
<%= invitationorganisation.size() %>