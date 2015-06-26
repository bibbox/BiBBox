<%@ include file="/html/demo2/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsCouncelingGroupLeaderRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsCouncelingGroupLeaderRoleId", "0"));
long optionsPathologistRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPathologistRoleId", "0"));
long optionsOnkologistRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsOnkologistRoleId", "0"));
long optionsPatientRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPatientRoleId", "0"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:layout cssClass="proposelayout">
			<aui:column columnWidth="100">
				<aui:select label="Counceling Group Leader" name="preferences--optionsCouncelingGroupLeaderRoleId--">
					<%
					for(Role role : roles) {
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsCouncelingGroupLeaderRoleId_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100">
				<aui:select label="Pathologist" name="preferences--optionsPathologistRoleId--">
					<%
					for(Role role : roles) {
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsPathologistRoleId_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100">
				<aui:select label="Onkologist" name="preferences--optionsOnkologistRoleId--">
					<%
					for(Role role : roles) {
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsOnkologistRoleId_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100">
				<aui:select label="Patient" name="preferences--optionsPatientRoleId--">
					<%
					for(Role role : roles) {
						%>
						<aui:option value="<%= role.getRoleId() %>" selected='<%= optionsPatientRoleId_cfg == role.getRoleId() ? true : false %>' ><%= role.getName() %></aui:option>
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