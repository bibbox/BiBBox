package at.graz.meduni.liferay.portlet.bibbox;

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
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
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
		
		
		
		
		// Create Organization
		boolean site = pagetemplate == 0 ? false : true;
		Organization organization = createOrganization(organization_name, company, site);
		
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
		// Create DDLs
		createDDLs(ddlgeneration, organization.getGroupId(), themeDisplay.getUserId(), serviceContext);
		
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
	private void createDDLs(String ddlgeneration, long groupId, long userId, ServiceContext serviceContext) {
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
					createDDLRecordSet(Long.parseLong(ddmstructureid), ddmtitle, groupId, userId, serviceContext);
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
	private Organization createOrganization(String organization_name, Company company, boolean site) {
		try {
			// Create Organization		
			User defaultUser = company.getDefaultUser();
			
			long userId = company.getDefaultUser().getUserId();
	        long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
	        if(organization_name.length() > 100) {
	        	organization_name = organization_name.substring(0, 100);
	        }
	        String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
	        boolean recursable = true;
	        long regionId = 0;
	        long countryId = 0;
	        int statusId = GetterUtil.getInteger(PropsUtil.get("sql.data.com.liferay.portal.model.ListType.organization.status"));
	        String comments = null;
	
	        ServiceContext serviceContext = new ServiceContext();
	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	
	        Organization organization =
	                OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, organization_name, type, regionId, countryId, 
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
