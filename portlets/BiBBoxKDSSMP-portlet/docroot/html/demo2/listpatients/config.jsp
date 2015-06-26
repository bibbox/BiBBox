<%@ include file="/html/demo2/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsRoleForUser_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRoleForUser", "0"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:layout cssClass="proposelayout">
		<aui:column columnWidth="25">
				<aui:select label="Select Role for User" name="preferences--optionsRoleForUser--">
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