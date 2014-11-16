<!-- 
BiBBoxCommonServices
user/invitation/OrganizationLister

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

long optionsRequestStatusId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRequestStatusId", "0"));
List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByStatus(optionsRequestStatusId_cfg);
for(InvitationOrganisation invitationorganisation : invitationorganisations) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
	String requestdate = "";
	if(invitationorganisation.getStatusdate() != null) {
		requestdate = dateFormat.format(invitationorganisation.getStatusdate());
	}
	%>
	<table><tr>
	<td><%= organization.getName() %></td>
	<td><%= requestdate %></td>
	<td>Actions</td>
	</tr></table>
	<%
}
%>