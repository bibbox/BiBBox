package at.graz.hmmc.liferay.portlet.puch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;
import at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil;

import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ImageUpload
 */
public class ImageUpload extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionRresponse
	 * @throws PortletException
	 * @throws IOException
	 */
	public void uploadImage(ActionRequest actionRequest, ActionResponse actionRresponse) throws PortletException, IOException {
		System.out.println("--------- Image Upload in ImageUpload ---------");
		try {
			long puchmuseumsobjektId = ParamUtil.getLong(actionRequest, "puchmuseumsobjektId");
			System.out.println("--------- " + ParamUtil.getLong(actionRequest, "ojid") + " # " +  ParamUtil.getLong(actionRequest, "puchmuseumsobjektId") + " ---------");
			
			PuchMuseumsObjekt puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
			if(puchmuseumsobjekt.getFolder() == 0) {
				long folderId = createFolder(actionRequest, "Objekt" + puchmuseumsobjektId);
				puchmuseumsobjekt.setFolder(folderId);
				puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.updatePuchMuseumsObjekt(puchmuseumsobjekt);
			}
		
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			// read the uploaded files
			uploadFile("imageRaw", uploadRequest, actionRequest, puchmuseumsobjekt);
			uploadFile("imageProcessed", uploadRequest, actionRequest, puchmuseumsobjekt);
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
	    	 System.out.println("Exception");
	    	 e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param puchmuseumsobjektId
	 * @return
	 */
	private long createFolder(ActionRequest actionRequest, String foldername) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long repositoryId = themeDisplay.getScopeGroupId();
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			Folder folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, foldername, foldername, serviceContext);
			return folder.getFolderId();
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.ImageUpload::createFolder] Error creating new Folder.");
			ex.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param filename
	 * @param uploadRequest
	 * @param actionRequest
	 */
	private void uploadFile(String filename, UploadPortletRequest uploadRequest, ActionRequest actionRequest, PuchMuseumsObjekt puchmuseumsobjekt) {
		System.out.println("Name: "+filename);
		System.out.println("Size: "+uploadRequest.getSize(filename));
		if (uploadRequest.getSize(filename)==0) {
			SessionErrors.add(actionRequest, "error");
		}
		String sourceFileName = uploadRequest.getFileName(filename);
		File file = uploadRequest.getFile(filename);
		Float size = (float) file.length();
		System.out.println("file size bytes:" + size);
		System.out.println("file size Mb:" + size / 1048576);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Store file
		long repositoryId = themeDisplay.getScopeGroupId();
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String description = "This file is added via programatically";
		String changeLog = "hi";
		System.out.println("Name: "+file.getName());
		System.out.println("sourceFileName: "+sourceFileName);
		try {
	    	Folder folder_upload =DLAppServiceUtil.getFolder(puchmuseumsobjekt.getFolder());
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    	InputStream is = new FileInputStream( file );
	    	// TODO: Check if filename exists
	    	if(DLAppServiceUtil.getFileEntry(repositoryId, folder_upload.getFolderId(), title) != null) {
	    		System.out.println("############file exists");
	    	}
	    	DLAppServiceUtil.addFileEntry(repositoryId, folder_upload.getFolderId(), file.getName(), mimeType, 
	    			title, description, changeLog, is, file.getTotalSpace(), serviceContext);
	     } catch (Exception e) {
	    	 System.out.println("Exception");
	    	 e.printStackTrace();
	     }
	}
}
