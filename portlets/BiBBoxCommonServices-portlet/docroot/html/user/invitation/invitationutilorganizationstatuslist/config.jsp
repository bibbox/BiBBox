<%@ include file="/html/user/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsRequestStatusId_cfg = GetterUtil.getString(portletPreferences.getValue("optionsRequestStatusId", "0"));
String optionsSetRequestStatusId_cfg = GetterUtil.getString(portletPreferences.getValue("optionsSetRequestStatusId", "0"));
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));
long optionsPublishToId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPublishToId", "0"));

int[] role_type = {RoleConstants.TYPE_ORGANIZATION};
List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), role_type);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<aui:column columnWidth="50" first="true">
   				<aui:select label="Send Request Status" name="preferences--optionsRequestStatusId--" >
   					<aui:option value="20" selected="<%=\"20\".equals(optionsRequestStatusId_cfg) %>" >Request Panel Assessment</aui:option>
   					<aui:option value="30" selected="<%=\"30\".equals(optionsSetRequestStatusId_cfg) %>" >Biobank Published</aui:option>
   				</aui:select>
   			</aui:column>
   			<!-- Select Main Contact Role -->
			<aui:column columnWidth="50" last="true">
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
			<aui:column columnWidth="50" first="true">
   				<aui:select label="Set Status" name="preferences--optionsSetRequestStatusId--" >
   					<aui:option value="20" selected="<%=\"20\".equals(optionsSetRequestStatusId_cfg) %>" >Request Panel Assessment</aui:option>
   					<aui:option value="30" selected="<%=\"30\".equals(optionsSetRequestStatusId_cfg) %>" >Biobank Published</aui:option>
   				</aui:select>
   			</aui:column>
   			<aui:column columnWidth="50" last="true">
   				<aui:select label="Publish To" name="preferences--optionsPublishToId--" >
					<aui:option value="0" selected='<%= optionsPublishToId_cfg == 0 ? true : false %>' >As Main Organization</aui:option>
					<%
					List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
					for(Organization organization : organizations) {
						%>
						<aui:option value="<%= organization.getOrganizationId() %>" selected='<%= optionsPublishToId_cfg == organization.getOrganizationId() ? true : false %>' >In Organization: <%= organization.getName() %></aui:option>
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
