package at.meduni.liferay.portlet.bbmrieric;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.FolderNameException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.trash.util.TrashUtil;

public class EditFolderAction extends BaseStrutsPortletAction {

	public EditFolderAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the process actionwhile creating the account>>>");
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				System.out.println("ADD/Update");
				updateFolder(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				System.out.println("Delete");
				deleteFolders(actionRequest, false);
			}
			else if (cmd.equals(Constants.MOVE)) {
				System.out.println("move");
				moveFolders(actionRequest, false);
			}
			else if (cmd.equals(Constants.MOVE_FROM_TRASH)) {
				System.out.println("move from trash");
				moveFolders(actionRequest, true);
			}
			else if (cmd.equals(Constants.MOVE_TO_TRASH)) {
				System.out.println("move to trash");
				deleteFolders(actionRequest, true);
			}
			else if (cmd.equals(Constants.SUBSCRIBE)) {
				System.out.println("subscribe");
				//subscribeFolder(actionRequest);
			}
			else if (cmd.equals(Constants.UNSUBSCRIBE)) {
				System.out.println("unsubscribe");
				unsubscribeFolder(actionRequest);
			}
			else if (cmd.equals("updateWorkflowDefinitions")) {
				System.out.println("updateWorkflowDefinitions");
				updateWorkflowDefinitions(actionRequest);
			}
			//sendRedirect(actionRequest, actionResponse);
			originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchFolderException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());

				//setForward(actionRequest, "portlet.document_library.error");
			}
			else if (e instanceof DuplicateFileException ||
					 e instanceof DuplicateFolderNameException ||
					 e instanceof FolderNameException) {

				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
		
		
		//super.processAction(originalStrutsPortletAction, portletConfig, actionRequest, actionResponse);
	}

	
	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the render action while creating the account>>>");
		if(originalStrutsPortletAction == null) {
			System.out.println("originalStrutsPortletAction");
		}
		 String ret = originalStrutsPortletAction.render(null, portletConfig, renderRequest, renderResponse);
		 renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.TRUE);
		 return ret;
	}
	
	@Override
	public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the serveResource action while creating the account>>>");
        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }
	
	// coopyed from EditFolderAction.java
	protected void updateFolder(ActionRequest actionRequest) throws Exception {
		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId");
		long parentFolderId = ParamUtil.getLong(
			actionRequest, "parentFolderId");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DLFolder.class.getName(), actionRequest);

		if (folderId <= 0) {

			// Add folder

			DLAppServiceUtil.addFolder(
				repositoryId, parentFolderId, name, description,
				serviceContext);
		}
		else {

			// Update folder

			DLAppServiceUtil.updateFolder(
				folderId, name, description, serviceContext);
		}
	}
	
	protected void deleteFolders(
			ActionRequest actionRequest, boolean moveToTrash)
		throws Exception {

		String deleteEntryTitle = null;

		long[] deleteFolderIds = null;

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		if (folderId > 0) {
			deleteFolderIds = new long[] {folderId};
		}
		else {
			deleteFolderIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "folderIds"), 0L);
		}

		for (int i = 0; i < deleteFolderIds.length; i++) {
			long deleteFolderId = deleteFolderIds[i];

			if (moveToTrash) {
				Folder folder = DLAppServiceUtil.moveFolderToTrash(
					deleteFolderId);

				if (i == 0) {
					deleteEntryTitle = TrashUtil.getOriginalTitle(
						folder.getName());
				}
			}
			else {
				DLAppServiceUtil.deleteFolder(deleteFolderId);
			}

			AssetPublisherUtil.removeRecentFolderId(
				actionRequest, DLFileEntry.class.getName(), deleteFolderId);
		}

		if (moveToTrash && (deleteFolderIds.length > 0)) {
			Map<String, String[]> data = new HashMap<String, String[]>();

			data.put(
				"deleteEntryClassName",
				new String[] {DLFolder.class.getName()});

			if (Validator.isNotNull(deleteEntryTitle)) {
				data.put("deleteEntryTitle", new String[] {deleteEntryTitle});
			}

			data.put(
				"restoreFolderIds", ArrayUtil.toStringArray(deleteFolderIds));

			SessionMessages.add(
				actionRequest,
				PortalUtil.getPortletId(actionRequest) +
					SessionMessages.KEY_SUFFIX_DELETE_SUCCESS_DATA, data);

			//hideDefaultSuccessMessage(actionRequest);
		}
	}

	protected void moveFolders(
			ActionRequest actionRequest, boolean moveFromTrash)
		throws Exception {

		long[] folderIds = null;

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		if (folderId > 0) {
			folderIds = new long[] {folderId};
		}
		else {
			folderIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "folderIds"), 0L);
		}

		long parentFolderId = ParamUtil.getLong(
			actionRequest, "parentFolderId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DLFileEntry.class.getName(), actionRequest);

		for (long moveFolderId : folderIds) {
			if (moveFromTrash) {
				DLAppServiceUtil.moveFolderFromTrash(
					moveFolderId, parentFolderId, serviceContext);
			}
			else {
				DLAppServiceUtil.moveFolder(
					moveFolderId, parentFolderId, serviceContext);
			}
		}
	}

	protected void subscribeFolder(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		DLAppServiceUtil.subscribeFolder(
			themeDisplay.getScopeGroupId(), folderId);
	}

	protected void unsubscribeFolder(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		DLAppServiceUtil.unsubscribeFolder(
			themeDisplay.getScopeGroupId(), folderId);
	}
	
	protected void updateWorkflowDefinitions(ActionRequest actionRequest)
			throws Exception {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), actionRequest);

			DLAppServiceUtil.updateFolder(
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, null, null,
				serviceContext);
		}
}
