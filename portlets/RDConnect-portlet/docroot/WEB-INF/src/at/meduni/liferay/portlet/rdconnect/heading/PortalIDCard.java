package at.meduni.liferay.portlet.rdconnect.heading;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
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
	
	public void countUserOrgaization(ActionRequest request, ActionResponse response) throws Exception {		
		long userid = 0;
		long ipaddress = 0;
		long organizationid = 0;
		
		userid = ParamUtil.getLong(request, "userid");
		organizationid = ParamUtil.getLong(request, "organizationid");
		ipaddress = Long.parseLong(ParamUtil.getString(request, "ipaddress").replaceAll("\\.", ""));
		
		System.out.println("UserID: " + userid + ", OrganizationID: " + organizationid + ", IPAddress: " + ipaddress);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -5);
		Date oneHourBack = cal.getTime();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RDCOrganizationUserAccess.class);
		
		Criterion criterion = RestrictionsFactoryUtil.eq("organisationId", organizationid);
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("userId", userid));
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("ipaddress", ipaddress));
		criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.gt("lastaccess", oneHourBack));
		dynamicQuery.add(criterion);
		Order order = OrderFactoryUtil.desc("lastaccess");
		dynamicQuery.addOrder(order);
		List<RDCOrganizationUserAccess> serachresults = RDCOrganizationUserAccessLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(serachresults != null) {
			if(serachresults.size() != 0) {
				for(RDCOrganizationUserAccess serachresult : serachresults) {
					serachresult.setLastaccess(new Date());
					RDCOrganizationUserAccessLocalServiceUtil.updateRDCOrganizationUserAccess(serachresult);
				}
				//System.out.println("Somthing found");
			} else {
				try {
					RDCOrganizationUserAccessLocalServiceUtil.addRDCOrganizationUserAccess(organizationid, userid, ipaddress);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				//System.out.println("Search 0");
			}
		} else {
			System.out.println("Search Null");
		}
	}

}
