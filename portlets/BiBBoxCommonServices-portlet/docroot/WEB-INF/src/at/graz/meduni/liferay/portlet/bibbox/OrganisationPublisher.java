package at.graz.meduni.liferay.portlet.bibbox;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.GetterUtil;
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
		
		
		// Create Organization
		boolean site = pagetemplate == 0 ? false : true;
		Organization organization = createOrganization(organization_name, company, site);
		// Create Site From Template
		if(site) {
			createPages(organization, pagetemplate);
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
