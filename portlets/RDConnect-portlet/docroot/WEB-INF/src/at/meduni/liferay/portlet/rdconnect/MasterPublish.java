package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MasterPublish
 */
public class MasterPublish extends MVCPortlet {
	
	public void publishToGate(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Publish");
		createOrganisation();
	}
	
	public void createOrganisation() {
		//http://docs.liferay.com/portal/6.2/javadocs/com/liferay/portal/service/OrganizationLocalServiceUtil.html#addOrganization(long, long, java.lang.String, java.lang.String, long, long, int, java.lang.String, boolean, com.liferay.portal.service.ServiceContext)
		
		/*
		 * OrganizationLocalServiceUtil.addOrganization(long userId,
                long parentOrganizationId,
                String name,
                String type,
                long regionId,
                long countryId,
                int statusId,
                String comments,
                boolean site,
                ServiceContext serviceContext);
		 * 
		 Parameters:
			userId - the primary key of the creator/owner of the organization
			parentOrganizationId - the primary key of the organization's parent organization
			name - the organization's name
			type - the organization's type (regular-organization/location)
			regionId - the primary key of the organization's region
			countryId - the primary key of the organization's country
			statusId - the organization's workflow status
			comments - the comments about the organization
			site - whether the organization is to be associated with a main site
			serviceContext - the service context to be applied (optionally null). Can set asset category IDs, asset tag names, and expando bridge attributes for the organization.

		 */
		long userId = 10434;
		boolean site = true;
		ServiceContext serviceContext = null;
		String comments = "Automated Test Organistion";
		String type = "regular-organization";
		long regionId = 0;
		long countryId = 0;
		int statusId = 12017;
		long parentOrganizationId = 0;
		String roleName = "Organization Administrator";
		
		System.out.println(parentOrganizationId);
		
		Organization org;
		
		try {
			System.out.println("Create Organisation");
			org = OrganizationLocalServiceUtil.addOrganization(userId,
					parentOrganizationId,
			        "Test Organisation new 4",
			        type,
			        regionId,
			        countryId,
			        statusId,
			        comments,
			        site,
			        serviceContext);
			System.out.println("Add user to organisation");
			OrganizationLocalServiceUtil.addUserOrganization(userId, org);
			System.out.println("Get the roll id");
			long roleId = RoleLocalServiceUtil.getRole(org.getCompanyId(), roleName).getRoleId();
			System.out.println("Set user roll for organisation");
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userId, org.getGroup().getGroupId(), new long[] { roleId });
			
			// Add Address
			String className = Organization.class.getName();
            long classPK = org.getOrganizationId();
            String street1 = "Bay St.";
            String street2 = "";
            String street3 = "";
            String city = "Brighton";
            String zip = "3186";
            regionId = 0;
            countryId = CountryUtil.findByName("austria").getCountryId();
            int typeId = 12001; // Other
			boolean mailing = false;
            boolean primary = false;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
