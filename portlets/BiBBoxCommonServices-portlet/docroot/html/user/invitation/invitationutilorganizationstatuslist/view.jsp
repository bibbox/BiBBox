<!-- 
BiBBoxCommonServices
user/invitation/OrganizationLister

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
String redirect = PortalUtil.getCurrentURL(renderRequest);

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
	<td>Panel Assessment Sheets<td>Actions</td><td>Actions</td></td>
	<td>
		<liferay-ui:icon-menu>
			<portlet:renderURL var="CreateAssessmentURL">
				<portlet:param name="mvcPath" value="/html/user/invitation/invitationutilorganizationstatuslist/createbiobankpanelassessment.jsp" />
				<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>"/>
				<portlet:param name="redirect" value="<%= redirect %>"/>
			</portlet:renderURL>
			<liferay-ui:icon image="edit" message="Add Assessment" url="<%=CreateAssessmentURL.toString() %>" />
		</liferay-ui:icon-menu>
	</td>
	</tr></table>
	<%
}
%>