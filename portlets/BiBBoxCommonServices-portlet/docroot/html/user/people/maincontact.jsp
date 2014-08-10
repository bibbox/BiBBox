<!-- 
BiBBoxCommonServices
user/people/maincontact

Change the Main Contact for the Organisation
 -->
<%@ include file="/html/user/init.jsp" %> 

<%
long maincontact_id = ParamUtil.getLong(request, "maincontactid");
String redirect = ParamUtil.getString(request, "redirect");
long MainContactRole = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
		
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}
%>

<portlet:actionURL name="editMaincontact" var="editMaincontactURL" windowState="normal" />
<aui:form action="<%= editMaincontactURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="bibbox_cs_organizationid" type="hidden" value="<%= organizationId %>" />
			<aui:input name="bibbox_cs_maincontactroleid" type="hidden" value="<%= MainContactRole %>" />
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:column columnWidth="100" first="true">
				<aui:select label="Set User for Main Contact" name="bibbox_cs_maincontactid">
					<% 
					//Get Users From Organisations
					List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
					for(User user_om : users) {
						String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+user_om.getScreenName()+"&amp;companyId="+user_om.getCompanyId();
						%>
						<aui:option value="<%= user_om.getUserId() %>" selected='<%= maincontact_id == user_om.getUserId() ? true : false %>' ><%= user_om.getFullName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>