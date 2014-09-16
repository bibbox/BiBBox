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
String tmpTitle = "new-invatiation";
Invitation invitation = null;
long invitationId = ParamUtil.getLong(request, "invitationId");
if(invitationId > 0) {
	invitation = InvitationLocalServiceUtil.getInvitation(invitationId);
	createinvitation = false;
	tmpTitle = invitation.getName();
} else {
	invitation = InvitationLocalServiceUtil.createInvitation(CounterLocalServiceUtil.increment(Invitation.class.getName()));
	createinvitation = true;
}
invitationId = invitation.getInvitationId();

%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= tmpTitle %>'
/>

<portlet:actionURL name='<%= createinvitation ? "addInvitation" : "updateInvitation" %>' var="editInvitationURL" windowState="normal" />
<aui:form action="<%= editInvitationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="invitationId" value='<%= invitation.getInvitationId() %>'/>
		<aui:layout>
			<aui:column columnWidth="75" first="true">
				<aui:input name="name" value='<%= invitation.getName() %>'></aui:input>
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<button id="addorganisations" type="button">Add Organisation</button>/Clear List
			</aui:column>
			<!-- OrganisationList -->
			<aui:column columnWidth="100" first="true">
				Organization <i id="refreschorganizationlist" class="icon-refresh"></i>
				<div id="organisationlist" >
				</div>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="subject" cssClass="bibbox_cs_width_100"  value='<%= invitation.getSubject() %>'></aui:input>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="body" type="textarea" cssClass="bibbox_cs_width_100"  value='<%= invitation.getBody() %>'></aui:input>
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

<% 
String addOrganizationURL = themeDisplay.getURLCurrent().split("[?]")[0] + "/-/invitation/organisations/" + invitationId;
String addOrganizationListURL = themeDisplay.getURLCurrent().split("[?]")[0] + "/-/invitation/vieworganisations/" + invitationId;
%>
<portlet:actionURL name='deleteOrganizationFromInvitation' var="deleteOrganizationFromInvitationURL" />

<aui:script use="aui-base">
            A.all('#addorganisations').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           cache: false,
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
<aui:script use="aui-base,aui-io-request">
	AUI().use('aui-base', function(A){
         var contentNode = A.one('#organisationlist');
      
         if(contentNode) {
            contentNode.empty();
           contentNode.html('<div class="loading-animation"></div>');
           
           contentNode.load('<%= addOrganizationListURL %>');
           
         }
   });
</aui:script>
<aui:script use="aui-base,aui-io-request,click">
AUI().ready(
  'aui-base',
  'aui-io-request',
  'click',
  function(A) {
    A.all('#refreschorganizationlist').each(function() {
      this.on('click', function(event){
         var url = '<%= addOrganizationListURL %>';
         A.io.request(url,{
         on: {
              failure: function() { alert('Unable to Load Data'); },
              success: function() { 
               A.one('#organisationlist').setHTML(this.get('responseData'));
               // Delete Script
               AUI().use(
              'aui-base',
			  'aui-io-request',
			  'click',
			  function(A) {
	               A.all('#deleteOragnizationFromInvitation').on(
					'click',
					function(event) {
						var confirmation_to_delete_user = confirm("Are you sure you want to delete the Organization from the list?");
						if (confirmation_to_delete_user == true) {
							var url = '<%= deleteOrganizationFromInvitationURL.toString() %>';
							A.io.request(url,{
								//this is the data that you are sending to the action method
								data: {
								   <portlet:namespace />bibbox_cs_organisationid: event.currentTarget.getAttribute('organisationid'),
								   <portlet:namespace />bibbox_cs_invitationid: event.currentTarget.getAttribute('invitationid'),
								},
								dataType: 'json',
								on: {
								  failure: function() { alert('There is a problem with the server connection.'); },
								  success: function() { 
										var url = '<%= addOrganizationListURL %>';
								         A.io.request(url,{
								         on: {
								              failure: function() { alert('Unable to Load Data'); },
								              success: function() { 
								               A.one('#organisationlist').setHTML(this.get('responseData'));
								               }
								            }
								         });
								  }
								}
							});
						    
						} 	 
						return false;
					}
				);});
               //Delete Script
               }
            }
         });
     });
 });
});
</aui:script>