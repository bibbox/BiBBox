<%@ include file="/html/network/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
long optionsParentOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Select Main Contact Role -->
			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Main Contact Role for Organisation" name="preferences--optionsMainContactRole--">
					<%
					for(Role role : roles) {
						
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsMainContactRole_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<!-- Select parent Organization -->
			<aui:column columnWidth="25" first="true">
				<aui:select label="Select Parent Organisation for Organisation" name="preferences--optionsParentOrganisation--">
					<aui:option value="0" selected='<%= optionsParentOrganisation_cfg == 0 ? true : false %>' >Main Organization</aui:option>
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
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>