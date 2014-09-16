<%@ include file="/html/organisation/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsListOrganizationFromMainOrganization_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsListOrganizationFromMainOrganization", "0"));
String optionsTypeFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
String optionsIgnoreOrganisations_cfg = GetterUtil.getString(portletPreferences.getValue("optionsIgnoreOrganisations", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Select where to list the Organization -->
			<aui:column columnWidth="25" first="true">
				<aui:select label="Select Parent Organization for List" name="preferences--optionsListOrganizationFromMainOrganization--">
					<aui:option value="0" selected='<%= optionsListOrganizationFromMainOrganization_cfg == 0 ? true : false %>' >From Main Organization</aui:option>
					<aui:option value="1" selected='<%= optionsListOrganizationFromMainOrganization_cfg == 1 ? true : false %>' >In the Organization of the portlet</aui:option>
					<aui:option value="2" selected='<%= optionsListOrganizationFromMainOrganization_cfg == 2 ? true : false %>' >The Parent Organization of the current Organization</aui:option>
					<%
					List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
					for(Organization organization : organizations) {
						%>
						<aui:option value="<%= organization.getOrganizationId() %>" selected='<%= optionsListOrganizationFromMainOrganization_cfg == organization.getOrganizationId() ? true : false %>' >In Organization: <%= organization.getName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="75" last="true">
				<aui:input name="preferences--optionsTypeFilter--" label="Set Organisation Type" type="text" value ="<%= optionsTypeFilter_cfg %>" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--optionsIgnoreOrganisations--" label="Ignore Organization Names in List" type="text" value ="<%= optionsIgnoreOrganisations_cfg %>" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

