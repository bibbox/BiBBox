package at.meduni.liferay.portlet.rdconnect.admin;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdminRedeployDDLs
 */
public class AdminRedeployDDLs extends MVCPortlet {
	public void addFolders(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String foldername = ParamUtil.getString(request, "foldername");
			System.out.println("Add Folder: " + foldername);
			runAddFolder(foldername, themeDisplay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
	
	private void runAddFolder(String foldername, ThemeDisplay themeDisplay) {
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 10709);
			for(Organization organization : organizations) {
				ServiceContext serviceContext = new ServiceContext();

		        serviceContext.setAddGroupPermissions(true);
		        serviceContext.setAddGuestPermissions(true);
		        Group group = organization.getGroup();
		        serviceContext.setScopeGroupId(group.getGroupId());
		        
		        serviceContext.setUserId(organization.getUserId());
				try {
					DLFolder folder = DLFolderLocalServiceUtil.getFolder(organization.getGroupId(), 0, foldername);
					if(folder != null) {
						System.out.println("Folder " + foldername + " found in Organization " + organization.getGroup().getGroupId() + " " + folder.getRepositoryId() + " " + folder.getMountPoint());
					}
				} catch (PortalException e) {
					// Add Folder
					try {
						DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), organization.getGroupId(), organization.getGroupId(), false, 0, foldername, "", false, serviceContext);
					} catch (PortalException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void renameDDLS(ActionRequest request, ActionResponse response) throws Exception {
		try {
			String name = ParamUtil.getString(request, "ddlname");
			String structureid = ParamUtil.getString(request, "structureid");
			String newname = ParamUtil.getString(request, "ddlnewname");
			System.out.println("Rename DDLs: " + name + " with structure: " + structureid + " to: " + newname + ".");
			runRenaming(name, Long.parseLong(structureid), newname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
	
	public void addDDLS(ActionRequest request, ActionResponse response) throws Exception {
		try {
			String name = ParamUtil.getString(request, "ddlname");
			String structureid = ParamUtil.getString(request, "structureid");
			System.out.println("Create DDLs: " + name + " with structure: " + structureid + ".");
			createDDl(name, Long.parseLong(structureid), request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}

	private void createDDl(String name, long structureid, ActionRequest request) {
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			for(Organization organization : organizations) {
				boolean create = true;
				List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
				for(DDLRecordSet rdc_rs : rdc_recordlist) {
			  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
			  		if(rdc_rsname.equals(name)) {
			  			create = false;
			  		}
			  	}
				if(create) {
					System.out.println("Creating ddl " + name + " with structure: " + structureid + " for organisation " + organization.getName() + ".");
					try {
						ServiceContext serviceContext = new ServiceContext();
				        serviceContext.setAddGroupPermissions(true);
				        serviceContext.setAddGuestPermissions(true);
				        Group group = organization.getGroup();
				        serviceContext.setScopeGroupId(group.getGroupId());
				        serviceContext.setUserId(organization.getUserId());
						ServiceContext serviceContextRecord = serviceContext;
						long groupId = organization.getGroupId();
						ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
						String recordSetKey = null;
						int scope = 0;
						String[] languageid = {"0"};
						String[] names = {name};
						String[] description = {name};
						Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
						Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);
	
						DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(themeDisplay.getUserId(), groupId, structureid, recordSetKey, nameMap, 
								descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
						try {
							DDMStructure ddmStructure = recordSet.getDDMStructure();		
							Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
							DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
									serviceContext.getUserId(),
									serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
									DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
									serviceContext);
						} catch (Exception e) {
							System.out.println("RDC-Error: could not create DDL record for organisation " + organization.getName() + ".");
							e.printStackTrace();
						}
					} catch (Exception e) {
						System.out.println("RDC-Error: could not create DDL for organisation " + organization.getName() + ".");
						e.printStackTrace();
					}
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void runRenaming(String oldname, long structureid, String newname) {
		try {
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			for(Organization organization : organizations) {
				List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
				for(DDLRecordSet rdc_rs : rdc_recordlist) {
			  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
			  		if(rdc_rsname.equals(oldname) && rdc_rs.getDDMStructureId() == structureid) {
			  			System.out.println("Renaming for Organisation " + organization.getName() + ".");
			  			rdc_rs.setName(newname);
			  			DDLRecordSetLocalServiceUtil.updateDDLRecordSet(rdc_rs);
			  		}
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
