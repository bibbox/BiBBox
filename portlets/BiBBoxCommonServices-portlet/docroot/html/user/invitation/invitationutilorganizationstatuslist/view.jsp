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
long optionsPublishToId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPublishToId", "0"));
long optionsSetRequestStatusId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsSetRequestStatusId", "0"));
List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByStatus(optionsRequestStatusId_cfg);
if(invitationorganisations.size() > 0) {
	%>
	<table class="table table-bordered table-hover table-striped">
		<thead class="table-columns" >
			<tr>
				<th class="table-first-header">Biobank Name</th>
				<th>Request Date</th>
				<th>Number of Assessment</th>
				<th class="table-last-header"> </th>
			</tr>
		</thead>
		<tbody class="table-data" >
			<%
			for(InvitationOrganisation invitationorganisation : invitationorganisations) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
				String requestdate = "";
				if(invitationorganisation.getStatusdate() != null) {
					requestdate = dateFormat.format(invitationorganisation.getStatusdate());
				}
				%>
				<tr>
				<td><%= organization.getName() %></td>
				<td><%= requestdate %></td>
				<td><%= BiobankPanelAssessmentLocalServiceUtil.getNumberOfAssessmentsForOrganization(organization.getOrganizationId()) %></td>
				<td>
					<liferay-ui:icon-menu>
						<% String biobankPrintURL = themeDisplay.getURLCurrent().split("[?]")[0] + "/-/invitation/biobank/" + organization.getOrganizationId(); %>
						<liferay-ui:icon image="edit" message="Print Biobank Details" url="<%=biobankPrintURL.toString() %>" target="blank_" />
						<portlet:renderURL var="CreateAssessmentURL">
							<portlet:param name="mvcPath" value="/html/user/invitation/invitationutilorganizationstatuslist/createbiobankpanelassessment.jsp" />
							<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:renderURL>
						<liferay-ui:icon image="edit" message="Add Assessment" url="<%=CreateAssessmentURL.toString() %>" />
						<portlet:renderURL var="ListAssessmentsURL">
							<portlet:param name="mvcPath" value="/html/user/invitation/invitationutilorganizationstatuslist/listbiobankpanelassessment.jsp" />
							<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:renderURL>
						<liferay-ui:icon image="edit" message="List Assessments" url="<%=ListAssessmentsURL.toString() %>" />
						<portlet:actionURL name="publishBiobank" var="publishBiobankURL">
							<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>" />
							<portlet:param name="invitationorganisationId" value="<%= String.valueOf(invitationorganisation.getInvitationOrganisationId()) %>" />
							<portlet:param name="invitationId" value="<%= String.valueOf(invitationorganisation.getInvitationId()) %>" />
							<portlet:param name="movetoId" value="<%= String.valueOf(optionsPublishToId_cfg) %>" />
							<portlet:param name="setstatusId" value="<%= String.valueOf(optionsSetRequestStatusId_cfg) %>" />
							<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
						</portlet:actionURL>
						<liferay-ui:icon image="edit" message="Publish Biobank" url="<%=publishBiobankURL.toString() %>" />
					</liferay-ui:icon-menu>
				</td>
				</tr>
				<%
			}
			%>
		</tbody>
	</table>
	<%
}
%>