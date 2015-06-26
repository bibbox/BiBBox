<%@ include file="/html/demo2/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsPageTemplate_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
long optionsParentOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
long optionsRoleForUser_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRoleForUser", "0"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:layout cssClass="proposelayout">
   			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Parent Organisation for Organisation" name="preferences--optionsParentOrganisation--">
					<aui:option value="0" selected='<%= optionsParentOrganisation_cfg == 0 ? true : false %>' >As Main Organization</aui:option>
					<aui:option value="1" selected='<%= optionsParentOrganisation_cfg == 1 ? true : false %>' >In the Organization of the portlet</aui:option>
					<aui:option value="2" selected='<%= optionsParentOrganisation_cfg == 2 ? true : false %>' >The Parent Organization of the current Organization</aui:option>
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
			<aui:column columnWidth="100" first="true">
				<%
				List<LayoutSetPrototype> site_templates = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);
				%>
				<aui:select label="Select PageTemplate for Organisation" name="preferences--optionsPageTemplate--">
					<aui:option value="0" selected='<%= optionsPageTemplate_cfg == 0 ? true : false %>' >No Page</aui:option>
					<% for(LayoutSetPrototype site_template : site_templates) { %>
						<aui:option value="<%= site_template.getPrimaryKey() %>" selected='<%= optionsPageTemplate_cfg == site_template.getPrimaryKey() ? true : false %>' ><%= site_template.getName() %></aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25">
				<aui:select lable="Select Role for User" name="preferences--optionsRoleForUser--">
					<%
					for(Role role : roles) {
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsRoleForUser_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
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