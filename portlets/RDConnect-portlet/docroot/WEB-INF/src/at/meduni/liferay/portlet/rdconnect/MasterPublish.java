package at.meduni.liferay.portlet.rdconnect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.text.Collator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

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
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.LayoutSetServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalService;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AccountLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.portal.security.membershippolicy.OrganizationMembershipPolicyFactoryUtil;

/**
 * Portlet implementation class MasterPublish
 */
public class MasterPublish extends MVCPortlet {
	
	String counter = "15";
	Locale default_locale_ = null;
	final String alphabet_ = "abcdefghijklmopqrstuvwxyz";
    final int N_ = alphabet_.length();
    Random random_ = new Random();
    long ORGANISATION_ADMIN_ROLL = 22956; // local 10166 Server 22956
    long ADMIN_ROLL = 22951;
	
	public void publishToGate(ActionRequest request, ActionResponse response, MasterCandidate master) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		default_locale_ = themeDisplay.getLocale();
		long companyId = themeDisplay.getCompanyId();
		
		try {
			long[] userids = {themeDisplay.getUserId()};
			UserLocalServiceUtil.addRoleUsers(ADMIN_ROLL, userids);
		} catch (Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate - Promote to admin");
			e.printStackTrace();
		}
		
		try {
			Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
			// Create Organisation
			Organization organization = createOrganisation(company, master);
			// ADD Creator to Organisation
			/*OrganizationLocalServiceUtil.addUserOrganization(themeDisplay.getUserId(), organization);
			long[] userids = {themeDisplay.getUserId()};
			UserGroupRoleServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), ORGANISATION_ADMIN_ROLL);*/
			
			
			// Update Master
			master.setOrganisationid(organization.getOrganizationId());
			master.setState("P");
			MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
			// Create Users
			createUsersFromMaster(organization, company, master.getMail(), master.getContactperson(), master.getHead());
			// Create DDL Elements
			createDDLs(request, organization, master);
			
			// Create Organisation Pages
			createPages(organization);
			
			OrganizationLocalServiceUtil.rebuildTree(company.getCompanyId());
			
			
			// REMOVE Creator from Organisation
			/*UserGroupRoleServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), ORGANISATION_ADMIN_ROLL);
			OrganizationLocalServiceUtil.deleteUserOrganization(themeDisplay.getUserId(), organization);*/
		} catch(Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate");
			e.printStackTrace();
		}		
		
		try {
			UserLocalServiceUtil.deleteRoleUser(ADMIN_ROLL, themeDisplay.getUserId());
		} catch (Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate - remove from admin");
			e.printStackTrace();
		}
	
	}
	
	private Organization createOrganisation(Company company, MasterCandidate master) throws PortalException, SystemException {
		try {
			// Create Organisation		
			User defaultUser = company.getDefaultUser();
			
			long userId = company.getDefaultUser().getUserId();
	        long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
	        String name = master.getName();
	        String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
	        boolean recursable = true;
	        long regionId = 0;
	        long countryId = 0;
	        int statusId = GetterUtil.getInteger(PropsUtil.get(
	                "sql.data.com.liferay.portal.model.ListType.organization.status"));
	        String comments = null;
	
	        ServiceContext serviceContext = new ServiceContext();
	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        
	        boolean site = true;
	
	        Organization organization =
	                OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, type, regionId, countryId, 
	                		statusId, comments, site, serviceContext);
	        
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
			return organization;
		} catch (Exception e) {
			System.out.println("RDC Exception in MasterPublish:createOrganisation");
			e.printStackTrace();
		}
		return null;
	}
	
	private void createUsersFromMaster(Organization organization, Company company, String emails, String contactperson, String head) {
		String pattern_string_mail_ = "\\b([a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4})*)\\b";
		Pattern pattern_mail_ = Pattern.compile(pattern_string_mail_);
		
		ServiceContext serviceContext = new ServiceContext();
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
		
		HashSet<String> mails = new HashSet<String>();
		Matcher matcher = pattern_mail_.matcher(emails);
		while (matcher.find()) {
			if(!mails.contains(matcher.group().toLowerCase()))
				mails.add(matcher.group().toLowerCase());
		}
		matcher = pattern_mail_.matcher(contactperson);
		while (matcher.find()) {
			if(!mails.contains(matcher.group().toLowerCase()))
				mails.add(matcher.group().toLowerCase());
		}
		matcher = pattern_mail_.matcher(head);
		while (matcher.find()) {
			if(!mails.contains(matcher.group().toLowerCase()))
				mails.add(matcher.group().toLowerCase());
		}
		
		for(String mail : mails) {
			try {
				addUsersToOrganisation(organization, company, mail, serviceContext);
			} catch (SystemException e) {
				System.out.println("RDC Exception in MasterPublish:createUsersFromMaster");
				System.out.println("Could not create USER");
				e.printStackTrace();
			} catch (PortalException e) {
				System.out.println("RDC Exception in MasterPublish:createUsersFromMaster");
				System.out.println("Could not create USER");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("RDC Exception in MasterPublish:createUsersFromMaster");
				System.out.println("Could not create USER");
				e.printStackTrace();
			}
		}
	}
	
	private void addUsersToOrganisation(Organization organization, Company company, String mail, ServiceContext serviceContext) throws SystemException, PortalException {
		// Create User
		User user = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), mail);
		if (user == null) {
			createUser(user, company, mail, organization, serviceContext);
		} else {
			OrganizationLocalServiceUtil.addUserOrganization(user.getUserId(), organization);
			long[] userids = {user.getUserId()};
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), ORGANISATION_ADMIN_ROLL);
		}
	}
	
	private void createUser(User user, Company company, String mail, Organization organization, ServiceContext serviceContext) throws PortalException, SystemException {
		boolean autoPassword = false;
		String password1 = "1234";
		boolean autoScreenName = true;
		String screenName = "";
		long facebookId = 0;
		String openId = "";
		String firstName = getFirstnameFromMail(mail);
		String middleName = "";
		String lastName = getLastnameFromMail(mail);
		int prefixId = 0;
		int suffixId = 0;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = new long[0];
		long[] organizationIds = {organization.getOrganizationId()};
		long[] roleIds = new long[0];
		long[] userGroupIds = new long[0];
		boolean male = false;
		boolean sendEmail = false;
		user = UserLocalServiceUtil.addUser(company.getDefaultUser().getUserId(), company.getCompanyId(), autoPassword, password1, password1, 
				autoScreenName, screenName, mail, facebookId, openId, default_locale_, firstName, middleName, lastName, 
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		user.setPasswordReset(false);
		UserLocalServiceUtil.updateUser(user);
		long[] userids = {user.getUserId()};
		UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), ORGANISATION_ADMIN_ROLL);
	}
	
	private String getFirstnameFromMail(String mail) {
		String name = "";
		String[] split1 = mail.split("@");
		if(split1.length > 0) {
			String[] split2 = split1[0].split("[\\._]");
			if(split2.length > 0) {
				name = split2[0];
			}
		}
		return name;
	}
	
	private String getLastnameFromMail(String mail) {
		String name = "";
		String[] split1 = mail.split("@");
		if(split1.length > 0) {
			String[] split2 = split1[0].split("[\\._]");
			if(split2.length > 1) {
				name = split2[1];
			}
		}
		return name;
	}
	
	private void createPages(Organization organization) throws Exception {
		try {
			// Create Public Pages
			long publicLayoutSetPrototypeId = 33202; //10350 Community Site for local
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
			
			/*SitesUtil.updateLayoutSetPrototypesLinks(organizationGroup, publicLayoutSetPrototypeId,
							privateLayoutSetPrototypeId,
							publicLayoutSetPrototypeLinkEnabled,
							privateLayoutSetPrototypeLinkEnabled);
			SitesUtil.mergeLayoutSetPrototypeLayouts(organizationGroup, LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), false));*/
		} catch (Exception e) {
			System.out.println("RDC Exception - MasterPublish::createPages");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// Update Logo
		//boolean privateLayout = true;
		
		//String url = "http://localhost:8080/documents/10194/0/Biobank/a7b1fd67-d959-4170-9ea4-2139ed7b6047?t=1390941119698";
	    //File logo = new File(url);    
		//LayoutSetServiceUtil.updateLogo(organization.getGroupId(), privateLayout, true, logo);//organizationGroup.getGroupId()
		/*privateLayout = false;
		LayoutSetServiceUtil.updateLogo(organization.getGroupId(), privateLayout, true, logo);*/
	}
	
	private void createDDLs(ActionRequest request, Organization organization, MasterCandidate master) throws PortalException, SystemException {
		ServiceContext serviceContext = new ServiceContext();

        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        Group group = organization.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        
        serviceContext.setUserId(organization.getUserId());
        
		ServiceContext serviceContextRecord = serviceContext;
		long groupId = organization.getGroupId();
		// create core | ID 28331
		try {
			DDLRecordSet recordSet = createRecordSet(request, organization, "core", 28331, serviceContext);
			creatRecordCore(recordSet, groupId, serviceContextRecord, master);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create core");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create core");
			e.printStackTrace();
		}
		// create Related Persons | ID 30869
		try {
			createRecordSet(request, organization, "Related Persons", 30869, serviceContext);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Related Persons");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Related Persons");
			e.printStackTrace();
		}
		// create Quality Indicators | ID 29098
		try {
			DDLRecordSet recordSet = createRecordSet(request, organization, "Quality Indicators", 29098, serviceContext);
			creatRecordQualityIndicator(recordSet, groupId, serviceContextRecord, master);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Quality Indicators");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Quality Indicators");
			e.printStackTrace();
		}
		// create Disease Areas (ICD10) | ID 32842
		try {
			DDLRecordSet recordSet = createRecordSet(request, organization, "Disease Areas (ICD10)", 32842, serviceContext);
			creatRecordDiseaseAreas(recordSet, groupId, serviceContextRecord, master);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Disease Areas (ICD10)");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Disease Areas (ICD10)");
			e.printStackTrace();
		}
		// create Disease Matrix | ID 32833
		try {
			DDLRecordSet recordSet = createRecordSet(request, organization, "Disease Matrix", 32833, serviceContext);
			creatRecordDiseaseMatrix(recordSet, groupId, serviceContextRecord, master);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Disease Matrix");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Disease Matrix");
			e.printStackTrace();
		}
		// create Accesability | ID 29100
		try {
			DDLRecordSet recordSet = createRecordSet(request, organization, "Accesability", 29100, serviceContext);
			creatRecordAccesability(recordSet, groupId, serviceContextRecord, master);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Accesability");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Accesability");
			e.printStackTrace();
		}
		// create Collections | ID 29093
		try {
			createRecordSet(request, organization, "Collections", 29093, serviceContext);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Collections");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Collections");
			e.printStackTrace();
		}
		// create Studies | ID 31103
		try {
			createRecordSet(request, organization, "Studies", 31103, serviceContext);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Studies");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Studies");
			e.printStackTrace();
		}
		// create Sample Matrix | ID 32849
		try {
			createRecordSet(request, organization, "Sample Matrix", 32849, serviceContext);
		} catch (PortalException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Sample Matrix");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception in MasterPublish:createDDLs");
			System.out.println("Could not create Sample Matrix");
			e.printStackTrace();
		}
	}
	
	private DDLRecordSet createRecordSet(ActionRequest request, Organization organization, String name, long ddmStructureId, ServiceContext serviceContext) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = organization.getGroupId();
		String recordSetKey = null;
		int scope = 0;
		String[] languageid = {"0"};
		String[] names = {name};
		String[] description = {name};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);

		DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(themeDisplay.getUserId(), groupId, ddmStructureId, recordSetKey, nameMap, 
				descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		return recordSet;
	}
	
	private String randomIdGenerator() {
		String id = "_INSTANCE_";
	    for (int i = 0; i < 4; i++) {
	    	id += alphabet_.charAt(random_.nextInt(N_));
	    }
	    return id;
	}
	
	private void creatRecordCore(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		try {
			DDMStructure ddmStructure = recordSet.getDDMStructure();		
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
			// Define Fields
			Field field_name = new Field("name", master.getName());
			fields.put(field_name);
			Field field_acronym = new Field("acronym", "");
			fields.put(field_acronym);
			String type = "bb_reg";
			if(master.getCandidatetype().equalsIgnoreCase("Biobank"))
				type = "bb";
			else if(master.getCandidatetype().equalsIgnoreCase("Registry"))
				type = "reg";
			Field field_type = new Field("Radio2493", "[" + type + "]");
			fields.put(field_type);
			Field field_description = new Field("Description", "");
			fields.put(field_description);
			Field field_subtype = new Field("subtype", master.getCandidatesubtype());
			fields.put(field_subtype);
			Field field_countryCode = new Field("countryCode", master.getCountry());
			fields.put(field_countryCode);
			Field field_geographicAreaCovered = new Field("geographicAreaCovered", "");
			fields.put(field_geographicAreaCovered);
			Field field_Text5085 = new Field("Text5085", "");
			fields.put(field_Text5085);
			Field field_year_of_establishment = new Field("year_of_establishment", "");
			fields.put(field_year_of_establishment);
			DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
				DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
				serviceContext);
		} catch(Exception e) {
			System.out.println("RDC Exception Core");
			e.printStackTrace();
		}
	}
	
	private void creatRecordQualityIndicator(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		try {
			DDMStructure ddmStructure = recordSet.getDDMStructure();		
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
			DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
					DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
					serviceContext);
		} catch(Exception e) {
			System.out.println("RDC Exception QualityIndicator");
			e.printStackTrace();
		}
	}
	
	private void creatRecordDiseaseAreas(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		try {
			DDMStructure ddmStructure = recordSet.getDDMStructure();		
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
			DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
					DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
					serviceContext);
		} catch(Exception e) {
			System.out.println("RDC Exception DiseaseAreas");
			e.printStackTrace();
		}
	}
	
	private void creatRecordAccesability(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		try {
			DDMStructure ddmStructure = recordSet.getDDMStructure();		
			Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);	
			DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
					DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
					serviceContext);
		} catch(Exception e) {
			System.out.println("RDC Exception Accesability");
			e.printStackTrace();
		}
	}
	
	private void creatRecordDiseaseMatrix(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		String[] diseascodes = master.getDiseasescodes().split(";");
		for(String s : diseascodes) {
			try {
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
				
				String fieldtype = "Comment";
				if(s.equalsIgnoreCase("orpha")) {
					fieldtype = "Orphanet_Number";
				}
				if(s.matches("\\w\\d\\d\\.\\d")) {
					fieldtype = "ICD10";
				}
				if(s.matches("\\d{6}")) {
					fieldtype = "OMIM";
				}
				
				Field field_code = new Field(fieldtype, s);
				fields.put(field_code);
				DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
						DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
						serviceContext);
			} catch(Exception e) {
				System.out.println("RDC Exception DiseaseMatrix");
				e.printStackTrace();
			}
		}
		diseascodes = master.getDiseasesfreetext().split(";");
		for(String s : diseascodes) {
			try {
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
					
				Field field_code = new Field("name", s);
				fields.put(field_code);
				DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(), recordSet.getRecordSetId(),
						DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
						serviceContext);
			} catch(Exception e) {
				System.out.println("RDC Exception DiseaseMatrix");
				e.printStackTrace();
			}
		}
	}
	
	
	// --------------------------------------------------------------------
	public void deleteOrganisation(long organisationid) throws PortalException, SystemException {
		try {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organisationid);
		List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
		for(User u : userlist) {
			OrganizationLocalServiceUtil.deleteUserOrganization(u.getUserId(), organization);
		}
		OrganizationLocalServiceUtil.deleteOrganization(organization);
		} catch(Exception e) {
			System.out.println("RDC Exception in MasterPublish:deleteOrganisation");
			System.out.println("Could not delete Organisation: " + organisationid);
			e.printStackTrace();
		}
	}

}
