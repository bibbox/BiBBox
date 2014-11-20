<!-- 
BiBBoxCommonServices
user/invitation/request

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String optionsDefaultText_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDefaultText", "organisation"));
String optionsRequestStatusId_cfg = GetterUtil.getString(portletPreferences.getValue("optionsRequestStatusId", "0"));

long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
}
%>

<%= optionsDefaultText_cfg %>

<%
List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organizationId);
if(invitationorganisations.size() != 0) {
	%>
	<portlet:actionURL name='sendRequest' var="sendRequestURL" windowState="normal" />
	
	<aui:form action="<%= sendRequestURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="status" value="<%= optionsRequestStatusId_cfg %>" />
			<aui:input type="hidden" name="organizationId" value="<%= organizationId %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" value="<%= InvitationLocalServiceUtil.getStatusFromLong(Long.parseLong(optionsRequestStatusId_cfg)) %>" ></aui:button>
		</aui:button-row>
	</aui:form>
	<%
}
%>