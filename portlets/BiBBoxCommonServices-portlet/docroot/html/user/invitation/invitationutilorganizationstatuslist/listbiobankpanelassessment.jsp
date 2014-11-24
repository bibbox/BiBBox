<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long organizationId = ParamUtil.getLong(request, "organizationId");
String redirect = PortalUtil.getCurrentURL(renderRequest);

Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
String tmpTitle = "Panel Assessment for " + organization.getName();
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<liferay-ui:icon-menu>
	<portlet:renderURL var="CreateAssessmentURL">
		<portlet:param name="mvcPath" value="/html/user/invitation/invitationutilorganizationstatuslist/createbiobankpanelassessment.jsp" />
		<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message='<%= "Add Assessment for " + organization.getName() %>' url="<%=CreateAssessmentURL.toString() %>" />
</liferay-ui:icon-menu>
<br /><br />
<%
List<BiobankPanelAssessment> biobankpanelassessments = BiobankPanelAssessmentLocalServiceUtil.getAssessmentsForOrganization(organizationId);
if(biobankpanelassessments.size() != 0) {
	%>
	<table class="table table-bordered table-hover table-striped">
		<thead class="table-columns" >
			<tr>
				<th class="table-first-header">Reviewer</th>
				<th>Date of Assessment</th>
				<th>Questions</th>
				<th>Final recommendation</th>
				<th class="table-last-header"> </th>
			</tr>
		</thead>
		<tbody class="table-data" >
			<%
			for(BiobankPanelAssessment biobankpanelassessment : biobankpanelassessments) {
			%>
			<tr>
				<td><%= biobankpanelassessment.getReviewer() %></td>
				<td></td>
				<td><%= biobankpanelassessment.getAggregatedAnswers() %></td>
				<td><%= biobankpanelassessment.getFinalrecommendation_4() %></td>
				<td>
					<liferay-ui:icon-menu>
						<portlet:renderURL var="EditAssessmentURL">
							<portlet:param name="mvcPath" value="/html/user/invitation/invitationutilorganizationstatuslist/createbiobankpanelassessment.jsp" />
							<portlet:param name="organizationId" value="<%= String.valueOf(organization.getOrganizationId()) %>"/>
							<portlet:param name="assessmnetId" value="<%= String.valueOf(biobankpanelassessment.getBiobankpanelassessmentId()) %>"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:renderURL>
						<liferay-ui:icon image="edit" message="Edit Assessment" url="<%=EditAssessmentURL.toString() %>" />
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