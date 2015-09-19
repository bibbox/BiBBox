package at.graz.hmmc.liferay.portlet.puch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectImage;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;
import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;
import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
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
 * Portlet implementation class Transactions
 */
public class Transactions extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addTransaction(ActionRequest request, ActionResponse response) throws Exception {
		try {
			// Creating Object
			String transactiontype = ParamUtil.getString(request, "transactiontype");
			long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjektId");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Date startdate = null;
			Date enddate = null;
			Transaktion transaktion = TransaktionLocalServiceUtil.addTransaction(puchmuseumsobjektId, transactiontype, startdate, enddate, themeDisplay.getUserId());
			transaktion = TransaktionLocalServiceUtil.addTransaktion(transaktion);
			// Adding Data for the Object
			addDataToTransaction(request, transaktion);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.Transactions::addPuchMuseumsObject] Error adding PuchMuseumsObject.");
			ex.printStackTrace();
		}
	}
	
	private void addDataToTransaction(ActionRequest request, Transaktion transaktion) {
		String objecttype = ParamUtil.getString(request, "transactiontype");
		List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objecttype);
		for(Configuration configuration : configurations) {
			try {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				String id = parameterconfig.getParameterconfigurationId() + "";
				String value = "";
				if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
					String[] items = ParamUtil.getParameterValues(request, id);
					boolean first = true;
					for(String item : items){
						if(!first) {
							value += ";";
						} else {
							first = false;
						}
						value += "\"" + item + "\"";
					}
				}
				TransaktionData transaktionData = TransaktionDataLocalServiceUtil.addTransaktionData(transaktion.getTransaktionId(), transaktion.getPuchmuseumsobjectId(), id, value);
				TransaktionDataLocalServiceUtil.addTransaktionData(transaktionData);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.Transactions::addDataToTransaction] Error adding Data to Transaction.");
				ex.printStackTrace();
			}
		}
	}
	
	public void updateTransaction(ActionRequest request, ActionResponse response) throws Exception {
		try {
			// Creating Object
			String transactiontype = ParamUtil.getString(request, "transactiontype");
			long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjektId");
			long transaktionId = ParamUtil.getLong(request, "transaktionId");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Date startdate = null;
			Date enddate = null;
			Transaktion transaktion = TransaktionLocalServiceUtil.getTransaktion(transaktionId);
			transaktion.setModifiedDate(new Date());
			transaktion.setModifiedUserId(themeDisplay.getUserId());
			transaktion.setStartDate(startdate);
			transaktion.setEndDate(enddate);
			transaktion = TransaktionLocalServiceUtil.addTransaktion(transaktion);
			// Adding Data for the Object
			updateDataToTransaction(request, transaktion);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.Transactions::addPuchMuseumsObject] Error adding PuchMuseumsObject.");
			ex.printStackTrace();
		}
	}
	
	private void updateDataToTransaction(ActionRequest request, Transaktion transaktion) {
		String objecttype = ParamUtil.getString(request, "transactiontype");
		List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objecttype);
		for(Configuration configuration : configurations) {
			try {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				String id = parameterconfig.getParameterconfigurationId() + "";
				String value = "";
				if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
					String[] items = ParamUtil.getParameterValues(request, id);
					boolean first = true;
					for(String item : items){
						if(!first) {
							value += ";";
						} else {
							first = false;
						}
						value += "\"" + item + "\"";
					}
				}
				TransaktionData transaktionData = TransaktionDataLocalServiceUtil.getTransaktionDataForObject(transaktion.getTransaktionId(), id);
				if(transaktionData == null) {
					transaktionData = TransaktionDataLocalServiceUtil.addTransaktionData(transaktion.getTransaktionId(), transaktion.getPuchmuseumsobjectId(), id, value);
					TransaktionDataLocalServiceUtil.addTransaktionData(transaktionData);
				} else {
					transaktionData.setObjectvalue(value);
					TransaktionDataLocalServiceUtil.updateTransaktionData(transaktionData);
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.Transactions::addDataToTransaction] Error adding Data to Transaction.");
				ex.printStackTrace();
			}
		}
	}
	/////// Image
	/**
	 * 
	 * @param actionRequest
	 * @param actionRresponse
	 * @throws PortletException
	 * @throws IOException
	 */
	public void uploadImage(ActionRequest actionRequest, ActionResponse actionRresponse) throws PortletException, IOException {
		System.out.println("--------- Image Upload in Transactions ---------");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long puchmuseumsobjektId = ParamUtil.getLong(actionRequest, "puchmuseumsobjektId");
			System.out.println("puchmuseumsobjektId: " + puchmuseumsobjektId);
			System.out.println("--------- " + ParamUtil.getLong(actionRequest, "ojid") + " # " +  ParamUtil.getLong(actionRequest, "puchmuseumsobjektId") + " ---------");
			PuchMuseumsObjekt puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
			if(puchmuseumsobjekt.getFolder() == 0) {
				long folderId = createFolder(actionRequest, "Objekt" + puchmuseumsobjektId);
				puchmuseumsobjekt.setFolder(folderId);
				puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.updatePuchMuseumsObjekt(puchmuseumsobjekt);
			}

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			// read the uploaded files
			long rowimageId = uploadFile("imageRaw", uploadRequest, actionRequest, puchmuseumsobjekt);
			long processedimageId = uploadFile("imageProcessed", uploadRequest, actionRequest, puchmuseumsobjekt);
			long webimageId = 0;
			
			ObjectImage objectimage = ObjectImageLocalServiceUtil.addObjectImage(rowimageId, processedimageId, webimageId, themeDisplay.getUserId(), puchmuseumsobjektId);
			ObjectImageLocalServiceUtil.addObjectImage(objectimage);
			
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
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.Transactions::createFolder] Error creating new Folder.");
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
	private long uploadFile(String filename, UploadPortletRequest uploadRequest, ActionRequest actionRequest, PuchMuseumsObjekt puchmuseumsobjekt) {
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
	    	/*
	    	// TODO: Check if filename exists
	    	try {
		    	if(DLAppServiceUtil.getFileEntry(repositoryId, folder_upload.getFolderId(), title) != null) {
		    		System.out.println("############file exists");
		    	}
	    	} catch (PortalException ex) {
	    		System.out.println("############file dose not exists");
	    		//file.getName()
	    	}*/
	    	
	    	FileEntry fileentry = DLAppServiceUtil.addFileEntry(repositoryId, folder_upload.getFolderId(), sourceFileName, mimeType, 
	    			title, description, changeLog, is, (long)(file.getTotalSpace()/1024.0/1024.0), serviceContext);
	    	return fileentry.getFileEntryId();
	     } catch (Exception e) {
	    	 System.out.println("Exception in Transactions");
	    	 e.printStackTrace();
	     }
		return 0;
	}
}
