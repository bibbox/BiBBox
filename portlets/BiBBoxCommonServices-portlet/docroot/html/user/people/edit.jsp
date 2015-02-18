<!-- 
BiBBoxCommonServices
user/people/edit

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String currentURL = ParamUtil.getString(request, "redirect");

long user_id = ParamUtil.getLong(request, "bibbox_cs_userid");
long organizationId = ParamUtil.getLong(request, "bibbox_cs_organizationid");
long editorrole = GetterUtil.getLong(portletPreferences.getValue("optionsEditorRole", "0"));
long ownerrole = GetterUtil.getLong(portletPreferences.getValue("optionsOwnerRole", "0"));
long maincontactrole = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
boolean optionsSendMailNotification_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsSendMailNotification", "false"));
String redirect = ParamUtil.getString(request, "redirect");
String cmd = ParamUtil.getString(request, "bibbox_cs_cmd");
if(organizationId != 0) {
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	
	String firstname = "";
	String middlename = "";
	String lastname = "";
	String email = "";
	String gender = "";
	String position = "";
	boolean owner = false;
	boolean editor = false;
	boolean maincontact = false;
	User edit_user = null;
	if(user_id != 0) {
		edit_user = UserLocalServiceUtil.getUser(user_id);
		firstname = edit_user.getFirstName();
		middlename = edit_user.getMiddleName();
		lastname = edit_user.getLastName();
		email = edit_user.getEmailAddress();
		String[] user_positions = edit_user.getExpandoBridge().getAttribute("Role within the organisation").toString().split(";");
		for(String user_position : user_positions) {
			String[] our = user_position.split("_");
			if(our.length == 0 || our[0].length() == 0) {
				continue;
			}
			long orgid = Long.parseLong(our[0]);
			if(orgid == organizationId) {
				if(our.length == 1) {
					position = "";
				} else {
					position = our[1];
				}
			}
		}

		for(long roleid : edit_user.getRoleIds()) {
			if(roleid == editorrole) {
				editor = true;
			}
			if(roleid == ownerrole) {
				owner = true;
			}
			if(roleid == maincontactrole) {
				maincontact = true;
			}
		}
		for(UserGroupRole usergrouprole : UserGroupRoleLocalServiceUtil.getUserGroupRoles(edit_user.getUserId(), organization.getGroupId())) {
			long roleid = usergrouprole.getRoleId();
			if(roleid == editorrole) {
				editor = true;
			}
			if(roleid == ownerrole) {
				owner = true;
			}
			if(roleid == maincontactrole) {
				maincontact = true;
			}
		}
	}
	%>
	
	<aui:model-context bean="<%= user %>" model="<%= User.class %>" />
	<portlet:actionURL name='<%= user_id == 0 ? "addUser" : "editUser" %>' var="addEditUserURL" windowState="normal" />
	<aui:form action="<%= addEditUserURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="bibbox_cs_redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="bibbox_cs_organisationid" value="<%= organizationId %>" />
			<aui:input type="hidden" name="bibbox_cs_userid" value="<%= String.valueOf(user_id) %>" />
			<aui:input type="hidden" name="bibbox_cs_creatorid" value="<%= themeDisplay.getUserId() %>" />
			<aui:input type="hidden" name="bibbox_cs_editorrole" value="<%= editorrole %>" />
			<aui:input type="hidden" name="bibbox_cs_ownerrole" value="<%= ownerrole %>" />
			<aui:input type="hidden" name="bibbox_cs_maincontact" value="<%= maincontactrole %>" />
			<aui:input type="hidden" name="bibbox_cs_sendmailnotification" value="<%= optionsSendMailNotification_cfg %>" />
			
			<div style="display:none;">
				<c:if test="<%= edit_user != null %>">
					<c:choose>
						<c:when test='<%= UsersAdminUtil.hasUpdateFieldPermission(edit_user, "portrait") %>'>
							<portlet:renderURL var="editUserPortraitURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
								<portlet:param name="struts_action" value="/users_admin/edit_user_portrait" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
								<portlet:param name="p_u_i_d" value="<%= String.valueOf(edit_user.getUserId()) %>" />
								<portlet:param name="portrait_id" value="<%= String.valueOf(edit_user.getPortraitId()) %>" />
							</portlet:renderURL>
	
							<liferay-ui:logo-selector
								defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), edit_user.isMale(), 0) %>"
								editLogoURL="<%= editUserPortraitURL %>"
								imageId="<%= edit_user.getPortraitId() %>"
								logoDisplaySelector=".user-logo"
							/>
						</c:when>
						<c:otherwise>
							<img src="<%= edit_user.getPortraitURL(themeDisplay) %>" />
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
			
			
			
			<aui:input name="bibbox_cs_email" label="E-mail&nbsp;&nbsp;&nbsp;<a id='checkemail'>Check if user exists</a>" type="text" value ="<%= email %>"/> 
			
			<aui:input name="bibbox_cs_firstname" label="First Name" type="text" value ="<%= firstname %>"/>
			<aui:input name="bibbox_cs_middlename" label="Middle Name" type="text" value ="<%= middlename %>"/>
			<aui:input name="bibbox_cs_lastname" label="Last Name" type="text" value ="<%= lastname %>"/>
			
			
			<aui:select name="bibbox_cs_position" label="Role within the Organization" value ="" multiple="true" cssClass="bibbox_cs_position_selection">
				<aui:option value=""></aui:option>
				<aui:option value="Coordinator/Principal Investigator" selected='<%= position.contains("Coordinator/Principal Investigator") ? true : false %>' >Coordinator/Principal Investigator</aui:option>
				<aui:option value="Data Provider/Contributor" selected='<%= position.contains("Data Provider/Contributor") ? true : false %>' >Data Provider/Contributor</aui:option>
				<aui:option value="Database Manager" selected='<%= position.contains("Database Manager") ? true : false %>' >Database Manager</aui:option>
				<aui:option value="Curator" selected='<%= position.contains("Curator") ? true : false %>' >Curator</aui:option>
				<aui:option value="Data Analyst" selected='<%= position.contains("Data Analyst") ? true : false %>' >Data Analyst</aui:option>
				<aui:option value="IT Expert" selected='<%= position.contains("IT Expert") ? true : false %>' >IT Expert</aui:option>
				<aui:option value="Biostatistics Expert" selected='<%= position.contains("Biostatistics Expert") ? true : false %>' >Biostatistics Expert</aui:option>
				<aui:option value="Scientific Expert" selected='<%= position.contains("Scientific Expert") ? true : false %>' >Scientific Expert</aui:option>
				<aui:option value="Legal Expert" selected='<%= position.contains("Legal Expert") ? true : false %>' >Legal Expert</aui:option>
				<aui:option value="Ethical Expert" selected='<%= position.contains("Ethical Expert") ? true : false %>' >Ethical Expert</aui:option>
				<aui:option value="Patient Representative" selected='<%= position.contains("Patient Representative") ? true : false %>' >Patient Representative</aui:option>
				<aui:option value="Management" selected='<%= position.contains("Management") ? true : false %>' >Management</aui:option>
				<aui:option value="Other" selected='<%= position.contains("Other") ? true : false %>' >Other</aui:option>
			</aui:select>
			
			<aui:input name="bibbox_cs_roleowner" label="Owner" type="checkbox" value ="<%= owner %>"/>
			<aui:input name="bibbox_cs_roleeditor" label="Editor" type="checkbox" value ="<%= editor %>"/>
			<aui:input name="bibbox_cs_rolemaincontact" label="Main Contact" type="checkbox" value ="<%= maincontact %>"/>
		</aui:fieldset>
	
		
		<aui:button-row>
			<aui:button type="submit"/>
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
	<%
} else {
	%>
	<h2>There is a problem with the link. Please contact the administrator.</h2>
	<% 
}
%>

<portlet:resourceURL var="checkEmailForUserURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-io-request,aui-io-request,event,node,aui-popover,valuechange,event-hover,aui-tooltip,event-valuechange,click">
	AUI().use(
	'aui-base',
	'aui-io-request',  
	'node', 
	function(A){
		A.all('#checkemail').each(function() {
	      this.on('click', function(event){
			var url = '<%= checkEmailForUserURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
				   <portlet:namespace />email: event.currentTarget.get('parentNode').get('parentNode').one('#<portlet:namespace />bibbox_cs_email').get('value'),
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('There is a problem with the server connection.'); },
				  success: function(data) { 
				  	var response = this.get('responseData');
				  	//alert(response['firstName'] + " " + response['lastName'] + " " + response['middleName']);
				  	A.one('#<portlet:namespace />bibbox_cs_firstname').set('value', response['firstName']);
				  	A.one('#<portlet:namespace />bibbox_cs_lastname').set('value', response['lastName']);
				  	A.one('#<portlet:namespace />bibbox_cs_middlename').set('value', response['middleName']);
				  	A.one('#<portlet:namespace />bibbox_cs_userid').set('value', response['userid']);
				  }
				}
			});
		});
	});
	});
</aui:script>