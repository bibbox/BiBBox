<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
//BBMRI-ERIC Update
//list of all actions inherit by subFolder or Documents
List<String> supportedActions = new ArrayList<String>();
supportedActions.add(ActionKeys.ACCESS);
supportedActions.add(ActionKeys.VIEW);
supportedActions.add(ActionKeys.UPDATE);
supportedActions.add(ActionKeys.PERMISSIONS);
supportedActions.add(ActionKeys.DELETE);
supportedActions.add(ActionKeys.ADD_DOCUMENT);
supportedActions.add(ActionKeys.ADD_SHORTCUT);
supportedActions.add(ActionKeys.ADD_SUBFOLDER);
supportedActions.add(ActionKeys.ADD_DISCUSSION);
supportedActions.add(ActionKeys.DELETE_DISCUSSION);

Folder folder = (Folder)request.getAttribute("view.jsp-folder");

long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"));

List<DLFileEntryType> fileEntryTypes = Collections.emptyList();

boolean inherited = true;

if ((folder != null) && (folder.getModel() instanceof DLFolder)) {
	DLFolder dlFolder = (DLFolder)folder.getModel();

	inherited = !dlFolder.isOverrideFileEntryTypes();
}

if ((folder == null) || folder.isSupportsMetadata()) {
	fileEntryTypes = DLFileEntryTypeServiceUtil.getFolderFileEntryTypes(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), folderId, inherited);
}

boolean hasAddDocumentPermission = DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_DOCUMENT);

//BBMRI-ERIC Update
//permissions of the parrentFolder as a list for all roles
List<ResourcePermission> parrentFolderPermissions = null;
try {
	parrentFolderPermissions = ResourcePermissionLocalServiceUtil.getResourcePermissions(themeDisplay.getCompanyId(),
		DLFolder.class.getName(),
		ResourceConstants.SCOPE_INDIVIDUAL,
		String.valueOf(folderId));
} catch (Exception e) {
	   e.printStackTrace();
}
%>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
         
	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER) %>">
		<portlet:renderURL var="addFolderURL">
			<portlet:param name="struts_action" value="/document_library/edit_folder" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="parentFolderId" value="<%= String.valueOf(folderId) %>" />
			<%--additional Parameter for Document inheritance --%>

            <%-- set the viewable part of permission input --%>
            <%
               for (ResourcePermission rp : parrentFolderPermissions) {
            %>
            <c:if test="<%=rp.hasActionId(ActionKeys.VIEW)%>">
                <portlet:param name="inputPermissionsViewRole" value="<%=RoleLocalServiceUtil.getRole(rp.getRoleId()).getName()%>" />
            </c:if>

            <%--set checkBoxes --%>
            <%
                for (String action : supportedActions) {
            %>
            <c:if test="<%=rp.hasActionId(action)%>">
                <c:if test="<%=RoleLocalServiceUtil.getRole(rp.getRoleId()).getName().equals(RoleConstants.GUEST)%>">
                    <portlet:param name="guestPermissions" value="<%=action%>" />
                </c:if>
                <c:if test="<%=!RoleLocalServiceUtil.getRole(rp.getRoleId()).getName().equals(RoleConstants.GUEST)%>">
                    <portlet:param name="groupPermissions" value="<%=action%>" />
                </c:if>
            </c:if>
            <%
                }
            }
            %>
            <%--end of additonal parameters --%>
		</portlet:renderURL>

		<aui:nav-item href="<%= addFolderURL %>" iconCssClass="icon-folder-open" label='<%= (folder != null) ? "subfolder" : "folder" %>' />
	</c:if>

	<c:if test="<%= ((folder == null) || folder.isSupportsShortcuts()) && DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_SHORTCUT) %>">
		<portlet:renderURL var="editFileShortcutURL">
			<portlet:param name="struts_action" value="/document_library/edit_file_shortcut" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= editFileShortcutURL %>" label="shortcut" />
	</c:if>

	<c:if test="<%= (folderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) && (DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_REPOSITORY)) %>">
		<portlet:renderURL var="addRepositoryURL">
			<portlet:param name="struts_action" value="/document_library/edit_repository" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= addRepositoryURL %>" iconCssClass="icon-hdd" label="repository" />
	</c:if>

	<c:if test="<%= ((folder == null) || folder.isSupportsMultipleUpload()) && hasAddDocumentPermission && !fileEntryTypes.isEmpty() %>">
		<portlet:renderURL var="editFileEntryURL">
			<portlet:param name="struts_action" value="/document_library/upload_multiple_file_entries" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= editFileEntryURL %>" label="multiple-documents" />
	</c:if>

	<c:choose>
		<c:when test="<%= hasAddDocumentPermission && (repositoryId != scopeGroupId) %>">
			<portlet:renderURL var="editFileEntryURL">
				<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
				<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
			</portlet:renderURL>

			<aui:nav-item href="<%= editFileEntryURL %>" iconCssClass="icon-file" label="basic-document" />
		</c:when>
		<c:when test="<%= !fileEntryTypes.isEmpty() && hasAddDocumentPermission %>">

			<%
			for (DLFileEntryType fileEntryType : fileEntryTypes) {
			%>

				<portlet:renderURL var="addFileEntryTypeURL">
					<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
					<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
					<portlet:param name="fileEntryTypeId" value="<%= String.valueOf(fileEntryType.getFileEntryTypeId()) %>" />
				</portlet:renderURL>

				<aui:nav-item href="<%= addFileEntryTypeURL %>" iconCssClass="icon-file" label="<%= HtmlUtil.escape(fileEntryType.getName(locale)) %>" />

			<%
			}
			%>

		</c:when>
	</c:choose>
</aui:nav-item>

<aui:script use="aui-base,uploader">
	if (!A.UA.ios && (A.Uploader.TYPE != 'none')) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');

		uploadMultipleDocumentsIcon.show();
	}
</aui:script>