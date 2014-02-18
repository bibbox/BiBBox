<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


<%
	String currentURL = PortalUtil.getCurrentURL(renderRequest);
	long groupId = 5;
	long logoId = 7;
	String portletResource = ParamUtil.getString(request, "portletResource");
%>

<portlet:defineObjects />

This is the
<b>Search Field</b>
portlet in View mode.


<portlet:renderURL var="editOrganizationLogoURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="struts_action" value="/searchfield/searchdisplay" />
	<portlet:param name="redirect" value="<%=currentURL%>" />
</portlet:renderURL>
<br>
<%= editOrganizationLogoURL.toString() %>
<br>
<liferay-ui:icon
				image="permissions"
				method="get"
				url="<%= editOrganizationLogoURL %>"
				useDialog="<%= true %>"
			/>

<aui:button name="selectFolderButton" value="select" />

<aui:script use="aui-base">
				A.one('#<portlet:namespace />selectFolderButton').on(
					'click',
					function(event) {
						Liferay.Util.selectEntity(
							{
								dialog: {
									constrain: true,
									modal: true,
									width: 600
								},
								id: '_<%=HtmlUtil.escapeJS(portletResource)%>_selectFolder',
								title: '<liferay-ui:message arguments="folder" key="select-x" />',
								uri: '<%=editOrganizationLogoURL.toString()%>'
							},
							function(event) {
								var folderData = {
									idString: 'rootFolderId',
									idValue: event.folderid,
									nameString: 'rootFolderName',
									nameValue: event.foldername
								};

								Liferay.Util.selectFolder(folderData, '<portlet:namespace />');
							}
						);
					}
				);
</aui:script>