package at.meduni.liferay.portlet.rdconnect.heading;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortalIDCard
 */
public class PortalIDCard extends MVCPortlet {
	public String getPageInformation(String page) {
		return "[5]";
	}
	
	public int getFilecount(long scopedGroupId) {
		int rootfolder = 0;
		int filecount = 0;
		try {
			filecount = DLFileEntryLocalServiceUtil.getFileEntriesCount(scopedGroupId, 0);
	  		List<DLFolder> subFolders = DLFolderLocalServiceUtil.getFolders(scopedGroupId, 0);
	  		for(DLFolder folder : subFolders) {
	  			filecount += recursiveCountFiles(scopedGroupId, folder.getFolderId());
	  		}
		} catch (Exception ex) {
			System.out.println("Filecount Error");
			ex.printStackTrace();
		}
		return filecount;
	}
	
	private int recursiveCountFiles(long scopedGroupId, long folderId) {
		int filecount = 0;
		try {
			filecount = DLFileEntryLocalServiceUtil.getFileEntriesCount(scopedGroupId, folderId);
			List<DLFolder> subFolders = DLFolderLocalServiceUtil.getFolders(scopedGroupId, folderId);
	  		for(DLFolder folder : subFolders) {
	  			filecount += recursiveCountFiles(scopedGroupId, folder.getFolderId());
	  		}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filecount;
	}

}
