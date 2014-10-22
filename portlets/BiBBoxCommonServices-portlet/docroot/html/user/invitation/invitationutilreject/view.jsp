<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<%
long optionsDeleteParentOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsDeleteParentOrganisation", "0"));
%>

<%
String redirect = ParamUtil.getString(request, "redirect");	
String invitationorganizationId = "0";
String securitylinktoken = "0";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
invitationorganizationId = httpRequest.getParameter("invitation");
securitylinktoken = httpRequest.getParameter("securitylinktoken");
%>

<h1>Reject the participation to RD-Connect</h1>
<br />
<liferay-ui:success key="organization-successfully-deleted" message="organization-successfully-deleted" />
<liferay-ui:error key="security-token-missmatch" message="security-token-missmatch" />
We are sorry you don't want to participateopen in the RD-Connect Network. Please fill in the security code you received with this link to remove your organization from the RD-Connect list.

<portlet:actionURL name='rejectParticipation' var="rejectParticipationURL" windowState="normal" />
<aui:form action="<%= rejectParticipationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="invitationorganizationId" value="<%= invitationorganizationId %>" />
		<aui:input type="hidden" name="securitylinktoken" value="<%= securitylinktoken %>" />
		<aui:input type="hidden" name="optionsDeleteParentOrganisation" value="<%= optionsDeleteParentOrganisation_cfg %>" />
		<aui:input name="securitytoken" value=''></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>