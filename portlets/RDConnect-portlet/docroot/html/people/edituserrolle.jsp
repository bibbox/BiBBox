<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<portlet:defineObjects />



<% 
String redirect = ParamUtil.getString(request, "redirect");
long rdcuserid = ParamUtil.getLong(request, "rdcuserid");
String rdcuserjob = ParamUtil.getString(request, "rdcuserjob");


long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
String editimgpath = request.getContextPath() + "/images/edit.png";
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
	
	boolean owner = false;
	boolean edithor = false;
	
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
    for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(rdcuserid, organization.getGroupId())) {
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-OWNER"))
    		owner = true;  
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-EDITOR"))
    		edithor = true;
    }
	
	%>
	<h3>Edit User Roles</h3>
	
	<aui:model-context bean="<%= user %>" model="<%= User.class %>" />
	<portlet:actionURL name='<%= "editUserRolles" %>' var="editUserRollesURL" windowState="normal" />
	<aui:form action="<%= editUserRollesURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="rdcredirect" value="" />
			<aui:input type="hidden" name="rdcorganisationid" value="<%= organizationId %>" />
			<aui:input type="hidden" name="rdccreaterid" value="<%= themeDisplay.getUserId() %>" />
			<aui:input type="hidden" name="rdcuserid" value="<%= rdcuserid %>" />
			
			<aui:input name="rdcorganisationmember" label="Registry/Biobank Member" type="checkbox" value="true" checked="true"/>
			<hr>
			<aui:select name="rdcposition" label="Position" value ="rdcuserjob">
				<aui:option value=""  <%= rdcuserjob.equalsIgnoreCase("") ? "selected=\"true\"" : "" %>></aui:option>
				<aui:option value="Coordinator" <%= rdcuserjob.equalsIgnoreCase("Coordinator") ? "selected=\"true\"" : "" %>>Coordinator</aui:option>
				<aui:option value="Data protection"  <%= rdcuserjob.equalsIgnoreCase("Data protection") ? "selected=\"true\"" : "" %>>Data protection</aui:option>
				<aui:option value="Information Technology"  <%= rdcuserjob.equalsIgnoreCase("Information Technology") ? "selected=\"true\"" : "" %>>Information Technology</aui:option>
				<aui:option value="Scientific"  <%= rdcuserjob.equalsIgnoreCase("Scientific") ? "selected=\"true\"" : "" %>>Scientific</aui:option>
				<aui:option value="Statistical"  <%= rdcuserjob.equalsIgnoreCase("Statistical") ? "selected=\"true\"" : "" %>>Statistical</aui:option>
				<aui:option value="Management"  <%= rdcuserjob.equalsIgnoreCase("Management") ? "selected=\"true\"" : "" %>>Management</aui:option>
				<aui:option value="Other"  <%= rdcuserjob.equalsIgnoreCase("Other") ? "selected=\"true\"" : "" %>>Other</aui:option>
			</aui:select>
			<aui:input name="rdcroleowner" label="Owner" type="checkbox" value="<%= owner %>" />
			<aui:input name="rdcroleeditor" label="Editor" type="checkbox" value="<%= edithor %>" />
			
		</aui:fieldset>
	
		
		<aui:button-row>
			<aui:button type="submit"/>
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
	<% 
}
%>