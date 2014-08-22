<!-- 
BiBBoxCommonServices
user/edit_invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_invitation = "ADD_INVITATION";
String actionId_edit_invitation = "EDIT_INVITATION";
%>

<%
String redirect = ParamUtil.getString(request, "redirect");	
String portletResource = ParamUtil.getString(request, "portletResource");
%>

<%
boolean createinvitation = false;
Invitation invitation = null;
long invitationId = ParamUtil.getLong(request, "invitationId");
if(invitationId > 0) {
	invitation = InvitationLocalServiceUtil.getInvitation(invitationId);
	createinvitation = false;
} else {
	invitation = InvitationLocalServiceUtil.createInvitation(CounterLocalServiceUtil.increment(Invitation.class.getName()));
	createinvitation = true;
}
invitationId = invitation.getInvitationId();
String tmpTitle = "new-invatiation";
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= tmpTitle %>'
/>

<aui:model-context bean="<%= invitation %>" model="<%= Invitation.class %>" />
<portlet:actionURL name='<%= createinvitation ? "addInvitation" : "updateInvitation" %>' var="editInvitationURL" windowState="normal" />
<aui:form action="<%= editInvitationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="invitationId" value='<%= invitation.getInvitationId() %>'/>
		<aui:layout>
			<aui:column columnWidth="75" first="true">
				<aui:input name="name"></aui:input>
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<button id="addorganisations" type="button">Add Organisation</button>/Clear List
			</aui:column>
			<!-- OrganisationList -->
			<aui:column columnWidth="100" first="true">
				<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="invitation-organization-empty-results-message">
					<liferay-ui:search-container-results
						results="<%= InvitationOrganisationLocalServiceUtil.getInvitationOrganisations(searchContainer.getStart(), searchContainer.getEnd()) %>"
						total="<%= InvitationOrganisationLocalServiceUtil.getInvitationOrganisationsCount() %>"
					/>
					<liferay-ui:search-container-row
						className="at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation"
						keyProperty="invitationOrganisationId"
						modelVar="invitationorganisation" escapedModel="<%= true %>"
					>
					<liferay-ui:search-container-column-text
						name="id"
						value="<%= Long.toString(invitationorganisation.getInvitationOrganisationId()) %>"
					/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="subject" cssClass="bibbox_cs_width_100"></aui:input>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="body" type="textarea" cssClass="bibbox_cs_width_100" ></aui:input>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<p>Subject and Body Terms:<br />[$TO_NAME$]</p>
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
		<aui:button type="submit" value="Simulate" />
		<aui:button type="submit" value="Send" />
	</aui:button-row>
</aui:form>

<%
/*

Einen not Saved status dazufügen, um die invitation zu erstellen aber wenn sie nicht gespeichert wird wieder löschen.

Bei cancle einfügen wenn noch nicht erstellt dann wird im javascriptgelöscht und dann erst redirect

*/
%>

<% String addOrganizationURL = themeDisplay.getURLCurrent().split("[?]")[0] + "/-/invitation/organisations/" + invitationId; %>

<aui:script use="aui-base">
            A.all('#addorganisations').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1000
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_addorganisation',
                        title: 'Add Organisations.',
                        uri: '<%= addOrganizationURL %>'
                     }
                  );
               }
            );
</aui:script>