<%@ include file="/html/user/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
String optionsEmail_cfg = GetterUtil.getString(portletPreferences.getValue("optionsEmail", "robert.reihs@medunigraz.at"));
String optionsText_cfg = GetterUtil.getString(portletPreferences.getValue("optionsText", "If you have any problems pleas let us know."));
boolean optionsSendHelpRequestCopy_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsSendHelpRequestCopy", "true"));
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:column columnWidth="100" first="true">
				<aui:input label="Emails send to(seperate by ;)" name="preferences--optionsEmail--" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input label="Send copy to the help requester" name="preferences--optionsSendHelpRequestCopy--" type="checkbox" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input label="Text to displayed in the portlet" name="preferences--optionsText--" />
			</aui:column>
			<!-- Select Main Contact Role -->
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
