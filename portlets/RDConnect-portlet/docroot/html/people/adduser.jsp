<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
String redirect = ParamUtil.getString(request, "redirect");

long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
String editimgpath = request.getContextPath() + "/images/edit.png";
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
%>
	
	<h3>Add User</h3>
	
	<liferay-ui:success key="candidate-saved-successfully" message="candidate-saved-successfully" />
	<liferay-ui:error key="fields-required" message="fields-required" />
	
	<aui:model-context bean="<%= user %>" model="<%= User.class %>" />
	<portlet:actionURL name='<%= "addUser" %>' var="addUserURL" windowState="normal" />
	<aui:form action="<%= addUserURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="rdcredirect" value="" />
			<aui:input type="hidden" name="rdcorganisationid" value="<%= organizationId %>" />
			<aui:input type="hidden" name="rdccreaterid" value="<%= themeDisplay.getUserId() %>" />
			
			<aui:input name="rdcfirstname" label="First Name" type="text" value =""/>
			<aui:input name="rdcmiddlename" label="Middle Name" type="text" value =""/>
			<aui:input name="rdclastname" label="Last Name" type="text" value =""/>
			
			<aui:input name="rdcemail" label="e-Mail" type="text" value =""/>
			<aui:select name="rdcgender" label="Gender" value ="male">
				<aui:option value="male" selected="true" >Male</aui:option>
				<aui:option value="female" >Female</aui:option>
			</aui:select>
			<aui:input name="rdcposition" label="Position" type="text" value =""/>
			
			<aui:input name="rdcroleowner" label="Owner" type="checkbox" value =""/>
			<aui:input name="rdcroleeditor" label="Editor" type="checkbox" value =""/>
			
		</aui:fieldset>
	
		
		<aui:button-row>
			<aui:button type="submit"/>
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
	<% 
}
%>