<!-- 
BiBBoxCommonServices
user/invitationhelprequest

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />

<%
String optionsEmail_cfg = GetterUtil.getString(portletPreferences.getValue("optionsEmail", "robert.reihs@medunigraz.at"));
String optionsText_cfg = GetterUtil.getString(portletPreferences.getValue("optionsText", "If you have any problems pleas let us know."));
boolean optionsSendHelpRequestCopy_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsSendHelpRequestCopy", "true"));
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));

String organizationinvitation = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
organizationinvitation = httpRequest.getParameter("invitation");
if(organizationinvitation == null) {
	organizationinvitation = "";
}
%>

<%
String redirect = ParamUtil.getString(request, "redirect");	
%>

<%= optionsText_cfg %>

<portlet:actionURL name='sendHelpRequest' var="sendHelpRequestURL" windowState="normal" />

<aui:form action="<%= sendHelpRequestURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="email" value="<%= optionsEmail_cfg %>" />
		<aui:input type="hidden" name="sendcopy" value="<%= optionsEmail_cfg %>" />
		<aui:input type="hidden" name="maincontactrole" value="<%= optionsMainContactRole_cfg %>" />
		<aui:input type="hidden" name="organizationinvitation" value="<%= organizationinvitation %>" />
		<aui:layout>
			<% 
			if(organizationinvitation.equalsIgnoreCase("")) {
				%>
				<aui:column columnWidth="100" first="true">
					<aui:input label="Your Email" name="requesteremail"  cssClass="bibbox_cs_width_100" />
				</aui:column>
				<%
			} 
			%>
			<aui:column columnWidth="100" first="true">
				<aui:select label="Request" name="textselection">
					<aui:option value="General Request" >General Request</aui:option>
					<aui:option value="Technical Problem" >Technical Problem</aui:option>
					<aui:option value="Contetn Request" >Content Request</aui:option>
					<aui:option value="Account Request" >Account Request</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="subject" cssClass="bibbox_cs_width_100" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="body" type="textarea" cssClass="bibbox_cs_width_100 bibbox_cs_height_bigger" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>
