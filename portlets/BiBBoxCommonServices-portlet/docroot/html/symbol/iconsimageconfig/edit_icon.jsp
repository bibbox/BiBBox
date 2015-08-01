<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
Icons icons = null;

	long iconId = ParamUtil.getLong(request, "iconId");

	if (iconId > 0) {
		icons = IconsLocalServiceUtil.getIcons(iconId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to list'
/>

<aui:model-context bean="<%= icons %>" model="<%= Icons.class %>" />

<portlet:actionURL name='<%= icons == null ? "addIcon" : "updateIcon" %>' var="editIconURL" windowState="normal" />
<aui:form action="<%= editIconURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="iconsId" value='<%= icons == null ? "" : icons.getIconsId() %>'/>

		<aui:input name="iconurl" />
		<aui:input name="group" />
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>