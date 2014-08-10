<!-- 
BiBBoxCommonServices
user/people/edit

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long user_id = ParamUtil.getLong(request, "bibbox_cs_userid");
long organizationId = ParamUtil.getLong(request, "bibbox_cs_organizationid");
long editorrole = GetterUtil.getLong(portletPreferences.getValue("optionsEditorRole", "0"));
long ownerrole = GetterUtil.getLong(portletPreferences.getValue("optionsOwnerRole", "0"));
long maincontactrole = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
String redirect = ParamUtil.getString(request, "redirect");
if(organizationId != 0) {
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
		if(edit_user.getMale()) {
			gender = "male";
		} else {
			gender = "female";
		}
		String[] user_positions = edit_user.getExpandoBridge().getAttribute("Role within the organisation").toString().split(";");
		for(String user_position : user_positions) {
			String[] our = user_position.split("_");
			if(our.length == 0 || our[0].length() == 0) {
				continue;
			}
			long orgid = Long.parseLong(our[0]);
			if(orgid == organizationId) {
				position = our[1];
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
	}
	%>
	<liferay-ui:success key="user-added-successfully" message="user-added-successfully" />
	<liferay-ui:error key="fields-required" message="fields-required" />
	
	<aui:model-context bean="<%= user %>" model="<%= User.class %>" />
	<portlet:actionURL name='<%= user_id == 0 ? "addUser" : "editUser" %>' var="addEditUserURL" windowState="normal" />
	<aui:form action="<%= addEditUserURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="bibbox_cs_redirect" value=""<%= redirect %> />
			<aui:input type="hidden" name="bibbox_cs_organisationid" value="<%= organizationId %>" />
			<aui:input type="hidden" name="bibbox_cs_creatorid" value="<%= themeDisplay.getUserId() %>" />
			<aui:input type="hidden" name="bibbox_cs_editorrole" value=""<%= editorrole %> />
			<aui:input type="hidden" name="bibbox_cs_ownerrole" value=""<%= ownerrole %> />
			<aui:input type="hidden" name="bibbox_cs_maincontact" value=""<%= maincontactrole %> />
			
			<aui:input name="bibbox_cs_firstname" label="First Name" type="text" value ="<%= firstname %>"/>
			<aui:input name="bibbox_cs_middlename" label="Middle Name" type="text" value ="<%= middlename %>"/>
			<aui:input name="bibbox_cs_lastname" label="Last Name" type="text" value ="<%= lastname %>"/>
			
			<aui:input name="bibbox_cs_email" label="E-mail" type="text" value ="<%= email %>"/>
			<aui:select name="bibbox_cs_gender" label="Gender" value ="male">
				<aui:option value="male" selected='<%= "male".equals(gender) ? true : false %>' >Male</aui:option>
				<aui:option value="female" selected='<%= "female".equals(gender) ? true : false %>' >Female</aui:option>
			</aui:select>
			<aui:select name="bibbox_cs_position" label="Position" value ="">
				<aui:option value="" selected="true" ></aui:option>
				<aui:option value="Coordinator/Principal Investigator" selected='<%= "Coordinator/Principal Investigator".equals(position) ? true : false %>' >Coordinator/Principal Investigator</aui:option>
				<aui:option value="Data Provider/Contributor" selected='<%= "Data Provider/Contributor".equals(position) ? true : false %>' >Data Provider/Contributor</aui:option>
				<aui:option value="Database Manager" selected='<%= "Database Manager".equals(position) ? true : false %>' >Database Manager</aui:option>
				<aui:option value="Curator" selected='<%= "Curator".equals(position) ? true : false %>' >Curator</aui:option>
				<aui:option value="Data Analyst" selected='<%= "Data Analyst".equals(position) ? true : false %>' >Data Analyst</aui:option>
				<aui:option value="IT Expert" selected='<%= "IT Expert".equals(position) ? true : false %>' >IT Expert</aui:option>
				<aui:option value="Biostatistics Expert" selected='<%= "Biostatistics Expert".equals(position) ? true : false %>' >Biostatistics Expert</aui:option>
				<aui:option value="Scientific Expert" selected='<%= "Scientific Expert".equals(position) ? true : false %>' >Scientific Expert</aui:option>
				<aui:option value="Legal Expert" selected='<%= "Legal Expert".equals(position) ? true : false %>' >Legal Expert</aui:option>
				<aui:option value="Ethical Expert" selected='<%= "Ethical Expert".equals(position) ? true : false %>' >Ethical Expert</aui:option>
				<aui:option value="Patient Representative" selected='<%= "Patient Representative".equals(position) ? true : false %>' >Patient Representative</aui:option>
				<aui:option value="Management" selected='<%= "Management".equals(position) ? true : false %>' >Management</aui:option>
				<aui:option value="Other" selected='<%= "Other".equals(position) ? true : false %>' >Other</aui:option>
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