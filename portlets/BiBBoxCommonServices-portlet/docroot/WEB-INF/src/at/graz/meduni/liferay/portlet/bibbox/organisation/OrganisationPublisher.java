package at.graz.meduni.liferay.portlet.bibbox.organisation;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OrganisationPublisher
 */
public class OrganisationPublisher extends MVCPortlet {
	Locale default_locale_ = null;
	long company_id_ = 0;
 
	public void createOrganisation(ActionRequest request, ActionResponse response) throws Exception {	
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		default_locale_ = themeDisplay.getLocale();
		company_id_ = themeDisplay.getCompanyId();
		
		Company company = CompanyLocalServiceUtil.getCompanyById(company_id_);
		
		String organization_name = ParamUtil.getString(request, "bibbox_cs_organisationname");
		long pagetemplate = ParamUtil.getLong(request, "bibbox_cs_pagetemplate");
		String ddlgeneration = ParamUtil.getString(request, "bibbox_cs_ddlgeneration");
		long parentorganisation = ParamUtil.getLong(request, "bibbox_cs_parentorganization");
		String organizationtype = ParamUtil.getString(request, "bibbox_cs_organizationtype");
			
		// Create Organization
		boolean site = pagetemplate == 0 ? false : true;
		Organization organization = createOrganization(organization_name, company, site, parentorganisation);
		
		ServiceContext serviceContext = new ServiceContext();
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        Group group = organization.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        serviceContext.setUserId(organization.getUserId());
        
		// Create Site From Template
		if(site) {
			createPages(organization, pagetemplate);
		}
		// Set Organization Type
		organization.getExpandoBridge().setAttribute("Organization Type", organizationtype);
		// Create DDLs
		createDDLs(ddlgeneration, organization.getGroupId(), themeDisplay.getUserId(), serviceContext, request);
		
	}
	
	/**
	 * Create DDLs for Organization.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private void createDDLs(String ddlgeneration, long groupId, long userId, ServiceContext serviceContext, ActionRequest request) {
		String[] split_ddlsoptions = ddlgeneration.split("__");
		System.out.println("Size: " + split_ddlsoptions.length);
		for(String ddloption : split_ddlsoptions) {
			System.out.println(ddloption);
			String pattern_string = "_?(\\d+)_(\\w)_\"(.*?)\"_?";
			Pattern pattern = Pattern.compile(pattern_string);
			Matcher matcher = pattern.matcher(ddloption);
			while (matcher.find()) {
				String ddmstructureid = matcher.group(1);
				String option = matcher.group(2);
				String ddmtitle = matcher.group(3);
				System.out.println("Option: " + ddmstructureid + " - " + option + " - " + ddmtitle);
				if(!option.equals("x")) {
					// Create DDL Record Set
					DDLRecordSet recordset = createDDLRecordSet(Long.parseLong(ddmstructureid), ddmtitle, groupId, userId, serviceContext);
					// Create empty DDL Record
					if(option.equals("o")) {
						createDDLRecord(recordset, groupId, serviceContext);
					}
					// Create DDL Record with data
					if(option.equals("i")) {
						createDDLRecord(recordset, groupId, serviceContext);
					}
					// Create DDL Record with data from file
					if(option.equals("f")) {
						createDDLRecord(recordset, groupId, serviceContext);
					}
				}
			}
		}
	}
	
	/**
	 * Create DDL Record Set.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private DDLRecordSet createDDLRecordSet(long ddmStructureId, String ddmtitle, long groupId, long userId, ServiceContext serviceContext) {
		String[] languageid = {"0"};
		String[] names = {ddmtitle};
		String[] description = {ddmtitle};
		int scope = 0;
		String recordSetKey = null;
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);
		DDLRecordSet recordSet = null;
		try {
			recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(userId, groupId, ddmStructureId, recordSetKey, nameMap, 
					descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		} catch (PortalException  e) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::createDDLRecordSet");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::createDDLRecordSet");
			e.printStackTrace();
		}
		return recordSet;
	}
	
	/**
	 * Create empty DDL Record.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private void createDDLRecord(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext) {
		try {	
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
			DDLRecordLocalServiceUtil.addRecord(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
					DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
					serviceContext);
		} catch(Exception e) {
			System.out.println("----------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::createDDLRecord");
			e.printStackTrace();
		}
	}
	
	/**
	 * Create (one) information DDL Record.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private void createDDLRecord(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, ActionRequest request) {
		try {	
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
			List<Fields> fields1 = recordSet.getRecordsFieldsList();
			for(Fields fi : fields1) {
				for(String fieldname : fi.getNames()) {
					Field field = fi.get(fieldname);
					System.out.println("Field Name:" + fieldname);
					System.out.println("Field Type:" + field.getType());
				}
			}
			DDLRecordLocalServiceUtil.addRecord(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
					DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
					serviceContext);
		} catch(Exception e) {
			System.out.println("----------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::createDDLRecord");
			e.printStackTrace();
		}
	}

	/**
	 * Create Organization.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private Organization createOrganization(String organization_name, Company company, boolean site, long parentorganisation) {
		try {
			// Create Organization		
			long userId = company.getDefaultUser().getUserId();
	        if(organization_name.length() > 100) {
	        	organization_name = organization_name.substring(0, 100);
	        }
	        String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
	        long regionId = 0;
	        long countryId = 0;
	        int statusId = GetterUtil.getInteger(PropsUtil.get("sql.data.com.liferay.portal.model.ListType.organization.status"));
	        String comments = null;
	
	        ServiceContext serviceContext = new ServiceContext();
	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	
	        Organization organization =
	                OrganizationLocalServiceUtil.addOrganization(userId, parentorganisation, organization_name, type, regionId, countryId, 
	                		statusId, comments, site, serviceContext);
	        
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
			return organization;
		} catch (Exception e) {
			System.out.println("------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::Organization");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Create Organization Site.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    [2]
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return The new created Organization.
	 */
	private void createPages(Organization organization , long publicLayoutSetPrototypeId) throws Exception {
		try {
			// Create Public Pages
			boolean publicLayoutSetPrototypeLinkEnabled = true;
			boolean isPrivateLayout = false;
			long privateLayoutSetPrototypeId = 0;
			boolean privateLayoutSetPrototypeLinkEnabled = false;
					
			Group organizationGroup = organization.getGroup();
			
			long groupId = organizationGroup.getGroupId();
		    LayoutSetPrototype prototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(publicLayoutSetPrototypeId);
		    boolean layoutSetPrototypeLinkEnabled = true;
		    LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(groupId, isPrivateLayout,
		            layoutSetPrototypeLinkEnabled, prototype.getUuid());
		    
		    LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, isPrivateLayout);
		    SitesUtil.mergeLayoutSetPrototypeLayouts(organizationGroup, layoutSet);
		} catch (Exception e) {
			System.out.println("------------------------------------------------------");
			System.out.println("BiBBox Exception in OrganisationPublisher::createPages");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
