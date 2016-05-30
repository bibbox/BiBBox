<%@ include file="/html/user/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsParentOrganisationNameOption_cfg = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationNameOption", "organisation"));
String optionsParentOrganisationName_cfg = GetterUtil.getString(portletPreferences.getValue("optionsParentOrganisationName", "Portal"));
long optionsParentOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
String optionsTypeFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));
String optionsDefaultBodyText_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDefaultBodyText", ""));
String optionsInvitationTypeFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsInvitationTypeFilter", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<aui:column columnWidth="25" first="true">
				<aui:select label="Select Parent Organisation for Organisation" name="preferences--optionsParentOrganisation--">
					<aui:option value="0" selected='<%= optionsParentOrganisation_cfg == 0 ? true : false %>' >As Main Organization</aui:option>
					<aui:option value="1" selected='<%= optionsParentOrganisation_cfg == 1 ? true : false %>' >In the Organization of the portlet</aui:option>
					<%
					List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
					for(Organization organization : organizations) {
						%>
						<aui:option value="<%= organization.getOrganizationId() %>" selected='<%= optionsParentOrganisation_cfg == organization.getOrganizationId() ? true : false %>' >In Organization: <%= organization.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input name="preferences--optionsTypeFilter--" label="Set Organisation Filter Type" type="text" value ="<%= optionsTypeFilter_cfg %>" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Main Contact Role for Organisation" name="preferences--optionsMainContactRole--">
					<%
					int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
					List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
					for(Role role : roles) {
						
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsMainContactRole_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
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