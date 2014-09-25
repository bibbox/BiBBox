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
<portlet:actionURL name='simulateInvitation' var="simulateInvitationURL" windowState="normal" />
<portlet:actionURL name='sendInvitation' var="sendInvitationURL" windowState="normal" />

<aui:script use="aui-base">
	Liferay.provide(window, 'invitationSubmitForm', function(action) {
		if(action=='save'){
     		A.one('#<portlet:namespace/>fm').set('action','<%=editInvitationURL.toString()%>');
  		}
   		if(action=='simulate'){
     		A.one('#<portlet:namespace/>fm').set('action','<%=simulateInvitationURL.toString()%>');
  		}
		if(action=='send'){
     		A.one('#<portlet:namespace/>fm').set('action','<%=sendInvitationURL.toString()%>');
  		}
	});
</aui:script>

<aui:form action="<%= editInvitationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="cmd" value="<%= createinvitation %>" />
		<aui:input type="hidden" name="status" value="<%= invitation.getStatus() %>" />
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
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" onClick="invitationSubmitForm('save')" />
		<aui:button type="cancel" onClick="<%= redirect %>" />
		<aui:button type="submit" value="Simulate"  onClick="invitationSubmitForm('simulate')" />
		<aui:button type="submit" value="Send"  onClick="invitationSubmitForm('send')" />
	</aui:button-row>
</aui:form>

<p>Tags for Subject and Body:<br />
<table style="margin-left:30px;">
<tr><td>[$TO_NAME$]</td><td>...</td><td>Replace with the full name</td></tr>
<tr><td>[$url$]</td><td>...</td><td>Replace with the portal-URL and the invitation tracking code</td></tr>
<tr><td>[$reject-url$]</td><td>...</td><td>Replace with the URL and the invitation tracking code for rejection the participation</td></tr>
</table>
<br />
Example:<br />
Dear [$TO_NAME$],<br />
You can visit your ID-Card at [$url$]. If you do not won't to participate in the portal pleas visit this link [$reject-url$], and you will not be contacted again.<br />
---------<br />
Dear <%= themeDisplay.getUser().getFullName() %>,<br />
You can visit your ID-Card at <%= themeDisplay.getPortalURL() %>. If you do not won't to participate in the portal pleas visit this link <%= themeDisplay.getPortalURL() %>/reject, and you will not be contacted again.<br />
</p>

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