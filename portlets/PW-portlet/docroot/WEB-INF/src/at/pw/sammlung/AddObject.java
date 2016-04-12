package at.pw.sammlung;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.pw.model.Inventory;
import at.pw.service.InventoryLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AddObject
 */
public class AddObject extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String class_ = "PW-portlet::at.pw.sammlung.AddObject::";
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addObject(ActionRequest request, ActionResponse response) throws Exception {
		String title = ParamUtil.getString(request, "title");
		String structureId = ParamUtil.getString(request, "structureId");
		String inventarNumberpattern = ParamUtil.getString(request, "inventarNumberpattern");
		Inventory inventory = InventoryLocalServiceUtil.addInventoryWithAutoincrement();
		long inventarnummer = inventory.getInventarnummer();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// Add WebContent
		String articaltemplate = ParamUtil.getString(request, "articaltemplate");
		long webcontetnId = addWebcontent(title, structureId, themeDisplay, articaltemplate, request, inventarnummer, inventarNumberpattern);
		// Add Folder
		long folderId = addFolder(title, themeDisplay.getScopeGroupId(), request);
		// Add Inventory
		inventory.setWebcontentId(webcontetnId);
		inventory.setFolderId(folderId);
		inventory.setStructureId(structureId);
		inventory.setStructuretemplateId("");
		InventoryLocalServiceUtil.updateInventory(inventory);
	}
	
 
	private long addFolder(String title, long repositoryId, ActionRequest request) {
		try {
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
			Folder folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, title, title, serviceContext);
			return folder.getFolderId();
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.ImageUpload::createFolder] Error creating new Folder.");
			ex.printStackTrace();
		}
		return 0;
	}
	
	private long addWebcontent(String title, String structureId, ThemeDisplay themeDisplay, String articaltemplate, ActionRequest request, long inventarnummer, String inventarNumberpattern) {
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		Map<Locale, String> titleMap = getNameMap(title);
		Map<Locale, String> descriptionMap = getNameMap(title);
		DecimalFormat myFormatter = new DecimalFormat(inventarNumberpattern);
		System.out.println(inventarNumberpattern);
		System.out.println(myFormatter.format(inventarnummer));
		String content = "<?xml version='1.0' encoding='UTF-8'?><root default-locale=\"de_DE\" available-locales=\"de_DE\"><dynamic-element name=\"Inventarnummer\" type=\"text\" index-type=\"keyword\" index=\"0\"><dynamic-content language-id=\"de_DE\"><![CDATA[" + myFormatter.format(inventarnummer) + "]]></dynamic-content></dynamic-element></root>";
		String ddmTemplateKey = "0";
		for(String id : articaltemplate.split(";")) {
			if(id.startsWith(structureId + "_")) {
				ddmTemplateKey = id.replaceAll(structureId + "_", "");
			}
		}
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
			serviceContext.setUserId(themeDisplay.getUserId());
		
			
			JournalArticle articel = JournalArticleLocalServiceUtil.addArticle(userId, groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, titleMap, descriptionMap, content, structureId, ddmTemplateKey, serviceContext);
			return articel.getPrimaryKey();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		//JournalArticleLocalServiceUtil.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId, version, titleMap, descriptionMap, content, type, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallImageFile, images, articleURL, serviceContext)
	}
	
	private Map<Locale, String> getNameMap(String name) {
		Map<Locale, String> nameMap = new HashMap<Locale, String>();
		Locale locale = LocaleUtil.getDefault();
		nameMap.put(locale, name);
		return nameMap;
	}

}
