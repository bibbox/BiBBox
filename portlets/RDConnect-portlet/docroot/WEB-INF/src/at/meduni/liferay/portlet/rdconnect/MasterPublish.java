package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AccountLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;

/**
 * Portlet implementation class MasterPublish
 */
public class MasterPublish extends MVCPortlet {
	
	String counter = "12";
	
	public void publishToGate(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Publish");
		long companyId = 10154;
		createOrganisation2(companyId);
	}
	
	public void createOrganisation2(long companyId) throws PortalException, SystemException {
		
		Company company = CompanyLocalServiceUtil.getCompanyById(companyId);

		Account account = company.getAccount();

		account.setName("Test Organisation V "+counter+" liferay");
		account.setLegalName("Test Organisation "+counter+", Inc");

		AccountLocalServiceUtil.updateAccount(account);

		User defaultUser = company.getDefaultUser();

		
		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				defaultUser.getUserId(),
				OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
				"Test Organisation "+counter+", Inc", true);
		
		// Create Fiendly URL
		String friendlyUrl = organization.getName();
		friendlyUrl= friendlyUrl.trim();
		if(friendlyUrl.contains(" ")) { 
			friendlyUrl = friendlyUrl.replaceAll("\\s+", "-"); 
		} 
		GroupLocalServiceUtil.updateFriendlyURL(
			organization.getGroupId(), "/" + friendlyUrl);

		Layout extranetLayout = LayoutLocalServiceUtil.addLayout(
			defaultUser.getUserId(), organization.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "Test Organisation V"+counter+" liferay Extranet",
			null, null, LayoutConstants.TYPE_PORTLET, false, "/idcard",
			new ServiceContext());
		
		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)extranetLayout.getLayoutType();		
		
		/*layoutTypePortlet.addPortletId(
			0, PortletKeys.SEARCH, "column-1", -1, false);
		layoutTypePortlet.addPortletId(
			0, PortletKeys.MESSAGE_BOARDS, "column-2", -1, false);*/

		LayoutLocalServiceUtil.updateLayout(
			extranetLayout.getGroupId(), false, extranetLayout.getLayoutId(),
			extranetLayout.getTypeSettings());

		/*Layout intranetLayout = LayoutLocalServiceUtil.addLayout(
			defaultUser.getUserId(), organization.getGroupId(), true,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "Test Organisation V liferay Intranet",
			null, null, LayoutConstants.TYPE_PORTLET, false, "/intranet",
			new ServiceContext());

		layoutTypePortlet = (LayoutTypePortlet)intranetLayout.getLayoutType();

		layoutTypePortlet.addPortletId(
			0, PortletKeys.SEARCH, "column-1", -1, false);
		layoutTypePortlet.addPortletId(
			0, PortletKeys.MESSAGE_BOARDS, "column-2", -1, false);

		LayoutLocalServiceUtil.updateLayout(
			intranetLayout.getGroupId(), true, intranetLayout.getLayoutId(),
			intranetLayout.getTypeSettings());*/

		User user = UserLocalServiceUtil.fetchUserByEmailAddress(
			company.getCompanyId(), "robert.reihs@gmail.com");
		System.out.println("Company ID = 10154? " + company.getCompanyId());

		if (user == null) {
			user = UserLocalServiceUtil.addDefaultAdminUser(
				companyId, "joebloggs"+counter+"", "test"+counter+"@biobank.com",
				LocaleUtil.getDefault(), "Joe", StringPool.BLANK, "Bloggs");
		}
		else {
			user.setScreenName("joebloggs"+counter+"");
			user.setGreeting("Welcome Joe Bloggs!");
			user.setFirstName("Joe");
			user.setLastName("Bloggs");
		}

		user.setPasswordReset(false);

		UserLocalServiceUtil.updateUser(user);

		OrganizationLocalServiceUtil.addUserOrganization(user.getUserId(), organization);
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
		boolean setsite = true;
		ServiceContext serviceContext = null;
		String comments = "Automated Test Organistion";
		String type = "regular-organization";
		long regionId = 0;
		long countryId = 0;
		int statusId = 12017;
		long parentOrganizationId = 0;
		String roleName = "Organization Administrator";
		String organisationname = "Test Organization V5";
		
		System.out.println(parentOrganizationId);
		
		Organization organization;
		
		try {
			System.out.println("Create Organisation");
			organization = OrganizationLocalServiceUtil.addOrganization(userId,
					parentOrganizationId,
					organisationname,
			        type,
			        regionId,
			        countryId,
			        statusId,
			        comments,
			        setsite,
			        serviceContext);
			System.out.println("Add user to organisation");
			OrganizationLocalServiceUtil.addUserOrganization(userId, organization);
			System.out.println("Get the roll id");
			long roleId = RoleLocalServiceUtil.getRole(organization.getCompanyId(), roleName).getRoleId();
			System.out.println("Set user roll for organisation");
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userId, organization.getGroup().getGroupId(), new long[] { roleId });
			
			// Add Address
			String className = Organization.class.getName();
            long classPK = organization.getOrganizationId();
            String street1 = "Bay St.";
            String street2 = "";
            String street3 = "";
            String city = "Brighton";
            String zip = "3186";
            regionId = 0;
            //countryId = CountryUtil.findByName("austria").getCountryId();
            int typeId = 12001; // Other
			boolean mailing = false;
            boolean primary = false;
            
            Group orgnGrp = createGroup(organization, userId);
            createLayout(orgnGrp, organization);
            
            /*		
            //Create Organisation Pages
            long companyID = organization.getCompanyId();
            
            LayoutSetPrototypeServiceUtil.search(companyID, Boolean.TRUE, null);
            LayoutSet publicLayoutSet = null;
            LayoutSetPrototype publicLayoutSetPrototype = null;
            boolean publicLayoutSetPrototypeLinkEnabled = true;
            
            boolean site = false;

            Group organizationGroup = null;

            if (organization != null) {
            	organizationGroup = organization.getGroup();

            	site = organizationGroup.isSite();
            	
            	// Wenn die seite Existiert
            	if (site) {
            		try {
            			LayoutLocalServiceUtil.getLayouts(organizationGroup.getGroupId(), false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

            			privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), true);

            			privateLayoutSetPrototypeLinkEnabled = privateLayoutSet.isLayoutSetPrototypeLinkEnabled();

            			String layoutSetPrototypeUuid = privateLayoutSet.getLayoutSetPrototypeUuid();

            			if (Validator.isNotNull(layoutSetPrototypeUuid)) {
            				privateLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(layoutSetPrototypeUuid, company.getCompanyId());
            			}
            		}
            		catch (Exception e) {
            		}

            		try {
            			LayoutLocalServiceUtil.getLayouts(organizationGroup.getGroupId(), true, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

            			publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), false);

            			publicLayoutSetPrototypeLinkEnabled = publicLayoutSet.isLayoutSetPrototypeLinkEnabled();

            			String layoutSetPrototypeUuid = publicLayoutSet.getLayoutSetPrototypeUuid();

            			if (Validator.isNotNull(layoutSetPrototypeUuid)) {
            				publicLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(layoutSetPrototypeUuid, companyID);
            			}
            		}
            		catch (Exception e) {
            		}
            	} else {
            		//publicLayoutSet = 
            		long plid = CounterLocalServiceUtil.increment(Layout.class.getName());
            		Layout layout = LayoutLocalServiceUtil.createLayout(plid);
            		layout.setName("Overview");
            		
            		
            		
            		//organization
            	}
            }
            */
            // Seite Erstellen:
            
            /*List<LayoutSetPrototype> publicLayoutSetPrototypes = LayoutSetPrototypeServiceUtil.search(companyID, Boolean.TRUE, null);
            LayoutSetPrototype publicLayoutSetPrototype = null;*/
            
            //SitesUtil 
            
            final Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class);
            indexer.reindex(organization);
            
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
	
	private Group createGroup(Organization organization, long userId) {
		Group orgnGrp = null;
		try {
			long organization_id = organization.getOrganizationId();
			ClassName clsNameOrgn;
			
			clsNameOrgn = ClassNameLocalServiceUtil.getClassName("com.liferay.portal.model.Organization");
			
			long classNameId=clsNameOrgn.getClassNameId();
			System.out.println("organization classNameId got:"+classNameId);
	
			//Create Group
			long gpId = CounterLocalServiceUtil.increment(Group.class.getName()); 
			orgnGrp = GroupLocalServiceUtil.createGroup(gpId);
			orgnGrp.setClassNameId(classNameId);
			orgnGrp.setClassPK(organization_id);
			orgnGrp.setCompanyId(organization.getCompanyId());
			orgnGrp.setName(String.valueOf(organization_id));
			orgnGrp.setCreatorUserId(userId);
			
			String frndlyUrl = organization.getName();
			frndlyUrl= frndlyUrl.trim();
			if(frndlyUrl.contains(" ")) { 
				frndlyUrl = frndlyUrl.replaceAll("\\s+", "-"); 
			} 
			orgnGrp.setFriendlyURL("/"+frndlyUrl.toLowerCase());
			
		} catch (SystemException e) {
			System.err.println("createGroup in MasterPublisher Error: ");
			e.printStackTrace();
		}
		return orgnGrp;
	}
	
	private void createLayout(Group orgnGrp, Organization organization) {
		try {
			//Create Layout for group layout and orgn association 
			long layoutId = 0L; 
			
			layoutId = CounterLocalServiceUtil.increment(Layout.class.getName());
			
			Layout layoutGrp =LayoutLocalServiceUtil.createLayout(layoutId);
			layoutGrp.setCompanyId(organization.getCompanyId());
			layoutGrp.setName("Layout"+String.valueOf(layoutId) );
			layoutGrp.setHidden(false);
			layoutGrp.setPrivateLayout(false);
			layoutGrp.setFriendlyURL("/"+organization.getName());
			layoutGrp.setGroupId(orgnGrp.getGroupId());
			layoutGrp.setLayoutId(2);
			layoutGrp.setType("portlet"); 
			LayoutLocalServiceUtil.addLayout(layoutGrp);
			System.out.println("layoutGrp:"+layoutGrp);
	
	
			//Create LayoutSet 
			long layoutSetIdPub = CounterLocalServiceUtil.increment(LayoutSet.class.getName());
			LayoutSet layoutSetPub=LayoutSetLocalServiceUtil.createLayoutSet(layoutSetIdPub);
			layoutSetPub.setCompanyId(organization.getCompanyId());
			layoutSetPub.setPrivateLayout(false);
			layoutSetPub.setGroupId(orgnGrp.getGroupId());
			layoutSetPub.setThemeId("classic");
			LayoutSetLocalServiceUtil.addLayoutSet(layoutSetPub);
			System.out.println("layoutSetPub :"+layoutSetPub);
	
			long layoutSetIdPriv= CounterLocalServiceUtil.increment(LayoutSet.class.getName());
			LayoutSet layoutSetPriv=LayoutSetLocalServiceUtil.createLayoutSet(layoutSetIdPriv);
			layoutSetPriv.setCompanyId(organization.getCompanyId());
			layoutSetPriv.setPrivateLayout(true);
			layoutSetPriv.setThemeId("classic");
			layoutSetPriv.setGroupId(orgnGrp.getGroupId());
			LayoutSetLocalServiceUtil.addLayoutSet(layoutSetPriv);
			System.out.println("layoutSetPriv:"+layoutSetPriv);
			
			layoutGrp.setLayoutSet(layoutSetPub);
	
			/*System.out.println("publicLayoutSetPrototypeId got add:"+publicLayoutSetPrototypeId);
			System.out.println("privateLayoutSetPrototypeId got add:"+privateLayoutSetPrototypeId);
			CommunitiesUtil.applyLayoutSetPrototypes(orgnGrp, publicLayoutSetPrototypeId,privateLayoutSetPrototypeId);*/
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
