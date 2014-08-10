<%@ include file="/html/user/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String organisation_type = "organization";

long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));
long optionsEditorRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsEditorRole", ""));
long optionsOwnerRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsOwnerRole", ""));
boolean optionsDisplayMaincontact_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Display Main Contact -->
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--optionsDisplayMaincontact--" type="checkbox" value="<%= optionsDisplayMaincontact_cfg %>" label="Display Main Contact" />
			</aui:column>
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
			<!-- Select Owner Role -->
			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Owner Role for Organisation" name="preferences--optionsOwnerRole--">
					<%
					for(Role role : roles) {
						
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsOwnerRole_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<!-- Select Editor Role -->
			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Editor Role for Organisation" name="preferences--optionsEditorRole--">
					<%
					for(Role role : roles) {
						
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsEditorRole_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
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