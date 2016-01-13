package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ViewEventData
 */
public class ViewEventData extends MVCPortlet {
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateData(ActionRequest request, ActionResponse response) throws Exception {	
		long eventid = ParamUtil.getLong(request, "eventid");
		long organizationId = ParamUtil.getLong(request, "organizationId");
		long patientid = ParamUtil.getLong(request, "patientId");
		String ontology = ParamUtil.getString(request, "ontology");
		//System.out.println("eventid: " + eventid + "; organizationId: " + organizationId + "; ontology: " + ontology + ";");
		String value = ParamUtil.getString(request, "value");
		//System.out.println(value);
		
		String pattern = "(\\d*)$";
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		Matcher m = r.matcher(ontology);
		String key = "";
		if (m.find( )) {
			key = m.group(0);
		}
		try {
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(eventid, key);
			if(eventdata != null) {
				eventdata.setValue(value);
				EventDataLocalServiceUtil.updateEventData(eventdata);
				//System.out.println("Update: eventlayoutid: " + eventlayoutid + "; patientid: " + patientid + "; ontology: " + ontology + "; value: " + value);
			} else {
				EventDataLocalServiceUtil.createNewEventData(eventid, patientid, key, value);
				//System.out.println("Create: eventlayoutid: " + eventlayoutid + "; patientid: " + patientid + "; ontology: " + ontology + "; value: " + value);
			}
		} catch(Exception ex) {
			System.err.println("ERROR: DisplayEventParameter::updateData(ActionRequest request, ActionResponse response)");
			ex.printStackTrace();
		}
	}
	
	public void createEvent(ActionRequest actionRequest, ActionResponse actionRresponse) throws PortletException, IOException {
		uploadImage(actionRequest, actionRresponse);
	}
	
	public void uploadImage(ActionRequest actionRequest, ActionResponse actionRresponse) throws PortletException, IOException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long eventdataId = ParamUtil.getLong(uploadRequest, "eventdataid");
		long patientId = ParamUtil.getLong(uploadRequest, "patientid");
		long eventid = ParamUtil.getLong(uploadRequest, "eventid");
		long eventlayoutid = ParamUtil.getLong(uploadRequest, "eventlayoutid");
		String storehtml = ParamUtil.getString(uploadRequest, "store375");
		
		System.out.println("eventid: " + eventid + " - patientId: " + patientId + " - eventdataId: " + eventdataId);
		System.out.println(storehtml);
		
		try {
			
			
			String filename = "kDSSMPFile";
			System.out.println("Field Name: "+filename);
			System.out.println("Size:       "+uploadRequest.getSize(filename));
			System.out.println("FileName:   " + uploadRequest.getFileName(filename));
			if (uploadRequest.getSize(filename)==0) {
				SessionErrors.add(actionRequest, "error");
				return;
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
			String title = sourceFileName;
			String description = "This file is added via Uploader";
			String changeLog = "Upload File";
			System.out.println("Name: "+file.getName());
			System.out.println("sourceFileName: "+sourceFileName);
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
		        serviceContext.setAddGroupPermissions(true);
		        serviceContext.setAddGuestPermissions(true);
				Folder folder_upload = null;
				String foldername = "Unterschriebene Documente";
				try {
					folder_upload = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, foldername);
					
				} catch (PortalException e) {
					// Add Folder
					try {
						long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
						folder_upload = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, foldername, foldername, serviceContext);
					} catch (PortalException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		    	InputStream is = new FileInputStream( file );
		    	boolean fileexists = false;
		    	try {
		    		FileEntry exists = DLAppServiceUtil.getFileEntry(repositoryId, folder_upload.getFolderId(), title);
		    		if(exists != null) {
		    			fileexists = true;
						DLAppServiceUtil.updateFileEntry(exists.getFileEntryId(), sourceFileName, mimeType, title, description, changeLog, true, is, file.getTotalSpace(), serviceContext);
		    		}
		    	} catch (Exception e) {
			    	 System.out.println("File dose not exists Exception");
			    }
		    	if(!fileexists) {
			    	DLAppServiceUtil.addFileEntry(repositoryId, folder_upload.getFolderId(), sourceFileName, mimeType, 
			    			title, description, changeLog, is, file.getTotalSpace(), serviceContext);
		    	}
		     } catch (Exception e) {
		    	 System.out.println("Exception");
		    	 e.printStackTrace();
		     }
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
	    	 System.out.println("Exception");
	    	 e.printStackTrace();
		}
		try {
			Event event = EventLocalServiceUtil.getEvent(eventid);
			event.setStatus("signed");
			EventLocalServiceUtil.updateEvent(event);
			EventDataLocalServiceUtil.createNewEventData(eventid, patientId, "375", storehtml);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
