package at.meduni.liferay.portlet.rdconnect;

import java.io.Serializable;
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
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
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

/**
 * Portlet implementation class MasterPublish
 */
public class MasterPublish extends MVCPortlet {
	
	String counter = "15";
	Locale default_locale_ = null;
	final String alphabet_ = "abcdefghijklmopqrstuvwxyz";
    final int N_ = alphabet_.length();
    Random random_ = new Random();
	
	public void publishToGate(ActionRequest request, ActionResponse response, MasterCandidate master) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		default_locale_ = themeDisplay.getLocale();
		long companyId = themeDisplay.getCompanyId();
		
		try {
			Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
			// Create Organisation
			Organization organization = createOrganisation(company, master);
			// Update Master
			master.setOrganisationid(organization.getOrganizationId());
			master.setState("P");
			MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
			// Create Users
			createUsersFromMaster(organization, company, master.getMail(), master.getContactperson(), master.getHead(), ServiceContextFactory.getInstance(User.class.getName(), request));
			// Create DDL Elements
			createDDLs(request, organization, master);
			
			// Add me
			//OrganizationLocalServiceUtil.addUserOrganization(themeDisplay.getUserId(), organization);
			
			// Create Organisation Pages
			createPages(organization);
			
			OrganizationLocalServiceUtil.rebuildTree(company.getCompanyId());
		} catch(Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate");
			e.printStackTrace();
		}		
		
		
	}
	
	private Organization createOrganisation(Company company, MasterCandidate master) throws PortalException, SystemException {
		// Create Organisation		
		User defaultUser = company.getDefaultUser();
		
		/*Organization organization = OrganizationLocalServiceUtil.addOrganization(defaultUser.getUserId(),
						OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
						master.getName(), true);*/
		
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
	}
	
	private void createUsersFromMaster(Organization organization, Company company, String emails, String contactperson, String head, ServiceContext serviceContext) {
		String pattern_string_mail_ = "\\b([a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4})*)\\b";
		Pattern pattern_mail_ = Pattern.compile(pattern_string_mail_);
		
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
		// Create Public Pages
		long publicLayoutSetPrototypeId = 33202;
		boolean publicLayoutSetPrototypeLinkEnabled = true;
		long privateLayoutSetPrototypeId = 0;
		boolean privateLayoutSetPrototypeLinkEnabled = false;
				
		Group organizationGroup = organization.getGroup();
				
		SitesUtil.updateLayoutSetPrototypesLinks(organizationGroup, publicLayoutSetPrototypeId,
						privateLayoutSetPrototypeId,
						publicLayoutSetPrototypeLinkEnabled,
						privateLayoutSetPrototypeLinkEnabled);
		SitesUtil.mergeLayoutSetPrototypeLayouts(organizationGroup, LayoutSetLocalServiceUtil.getLayoutSet(organizationGroup.getGroupId(), false));
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
			createRecordSet(request, organization, "Disease Matrix", 32833, serviceContext);
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
		long groupId = organization.getGroupId();
		String recordSetKey = null;
		int scope = 0;
		String[] languageid = {"0"};
		String[] names = {name};
		String[] description = {name};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);

		DDLRecordSet recordSet = DDLRecordSetServiceUtil.addRecordSet(groupId, ddmStructureId, recordSetKey, nameMap, 
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
			Field field_type = new Field("Radio2493", type);
			fields.put(field_type);
			Field field_description = new Field("Description", "");
			fields.put(field_description);
			Field field_subtype = new Field("subtype", master.getCandidatesubtype());
			fields.put(field_subtype);
			Field field_legalEntity = new Field("legalEntity", "");
			fields.put(field_legalEntity);
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
			System.out.println("RDC Exception");
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
			System.out.println("RDC Exception");
			e.printStackTrace();
		}
	}
	
	private void creatRecordDiseaseAreas(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		String displaynames = "";
		Map<String,Serializable> fields = new HashMap<String, Serializable>();
		fields.put("Boolean5173", "");
		displaynames += "Boolean5173" + randomIdGenerator();
		fields.put("Boolean4958", "");
		displaynames += "," + "Boolean4958" + randomIdGenerator();
		fields.put("Boolean4743", "");
		displaynames += "," + "Boolean4743" + randomIdGenerator();
		fields.put("Boolean4528", "");
		displaynames += "," + "Boolean4528" + randomIdGenerator();
		fields.put("Boolean2579", "");
		displaynames += "," + "Boolean2579" + randomIdGenerator();
		fields.put("Boolean3227", "");
		displaynames += "," + "Boolean3227" + randomIdGenerator();
		fields.put("Boolean3012", "");
		displaynames += "," + "Boolean3012" + randomIdGenerator();
		fields.put("Boolean2796", "");
		displaynames += "," + "Boolean2796" + randomIdGenerator();
		fields.put("Boolean3443", "");
		displaynames += "," + "Boolean3443" + randomIdGenerator();
		fields.put("Boolean3659", "");	
		displaynames += "," + "Boolean3659" + randomIdGenerator();
		fields.put("Boolean3875", "");
		displaynames += "," + "Boolean3875" + randomIdGenerator();
		fields.put("Boolean4090", "");
		displaynames += "," + "Boolean4090" + randomIdGenerator();
		fields.put("Boolean4307", "");
		displaynames += "," + "Boolean4307" + randomIdGenerator();
		fields.put("Diseases_of_the_genitourinary_system__N00-N99_", "");
		displaynames += "," + "Diseases_of_the_genitourinary_system__N00-N99_" + randomIdGenerator();
		fields.put("Pregnancy__childbirth_and_the_puerperium__O00-O99_", "");
		displaynames += "," + "Pregnancy__childbirth_and_the_puerperium__O00-O99_" + randomIdGenerator();
		fields.put("Certain_conditions_originating_in_the_perinatal_period__P00-P96_", "");
		displaynames += "," + "Certain_conditions_originating_in_the_perinatal_period__P00-P96_" + randomIdGenerator();
		fields.put("Congenital_malformations__deformations_and_chromosomal_abnormalities__Q00-Q99_", "");
		displaynames += "," + "Congenital_malformations__deformations_and_chromosomal_abnormalities__Q00-Q99_" + randomIdGenerator();
		fields.put("others", "");
		displaynames += "," + "others" + randomIdGenerator();
		fields.put("_fieldsDisplay", displaynames);
		DDLRecord r = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
	}
	
	private void creatRecordAccesability(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		String displaynames = "";
		Map<String,Serializable> fields = new HashMap<String, Serializable>();
		fields.put("Are_data_or_samples_of_the_biobank_accessible_", "");
		displaynames += "Are_data_or_samples_of_the_biobank_accessible_" + randomIdGenerator();
		fields.put("Comment_data___sample_access", "");
		displaynames += "," + "Comment_data___sample_access" + randomIdGenerator();
		fields.put("Is_there_an_access_fee_", "");
		displaynames += "," + "Is_there_an_access_fee_" + randomIdGenerator();
		fields.put("Are_patients__data_distributed_", "");
		displaynames += "," + "Are_patients__data_distributed_" + randomIdGenerator();
		fields.put("Comment_Distribition_of_Patient_Data", "");
		displaynames += "," + "Comment_Distribition_of_Patient_Data" + randomIdGenerator();
		fields.put("Is_informed_consent_mandatory_as_per_your_country_s_regulations_", "");
		displaynames += "," + "Is_informed_consent_mandatory_as_per_your_country_s_regulations_" + randomIdGenerator();
		fields.put("Which_type_of_consent_is_obtained_from_the_patients__", "");
		displaynames += "," + "Which_type_of_consent_is_obtained_from_the_patients__" + randomIdGenerator();
		fields.put("Is_an_ethics_board_decision_already_available_for_the_use_of_the_samples_in_research_", "");
		displaynames += "," + "Is_an_ethics_board_decision_already_available_for_the_use_of_the_samples_in_research_" + randomIdGenerator();
		fields.put("_fieldsDisplay", displaynames);
		DDLRecord r = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
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
	
	// --------------------------------------------------------------------
	// Testing Classes
	// --------------------------------------------------------------------
	public void createRecordSet(ActionRequest request) throws PortalException, SystemException {
		Organization organization = OrganizationLocalServiceUtil.getOrganization(24501);
		if(organization != null) {
			System.out.println("---->notnull");
		} else {
			System.out.println("---->null");
		}
		long groupId = organization.getGroupId();
		long ddmStructureId = 14503;
		String recordSetKey = null;
		String[] languageid = {"0"};
		String[] names = {"DDL Structure Name 2"};
		String[] description = {"DDL Structure description"};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);
		int scope = 0;
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DDLRecordSet.class.getName(), request);
		System.out.println("Add Record Set");
		DDLRecordSet recordSet = DDLRecordSetServiceUtil.addRecordSet(groupId, ddmStructureId, recordSetKey, nameMap, 
				descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		System.out.println("Done Add Record Set");
		System.out.println("Record set generated: " + recordSet.getRecordSetId());
		//recordSet = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordSet.getRecordSetId());
		//DDMStructure ddmStructure = recordSet.getDDMStructure();
		
		//Fields fields = DDMUtil.getFields(ddmStructure.getStructureId(), serviceContext);
		
		Map<String,Serializable> fields = new HashMap<String, Serializable>();
		fields.put("TextNr1", "AutotestValue1");
		
		//fields.get("TextNr1").setValue("AutotestValue");
		System.out.println("Add Record 1");
		DDLRecord r = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
		//fields.get("TextNr1").setValue("zweites Valuze");
		System.out.println("Add Record 2");
		fields.put("TextNr1", "zweites Valuze");
		DDLRecord r2 = DDLRecordServiceUtil.addRecord(groupId, recordSet.getRecordSetId(), DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields, serviceContext);
	}
	
	public void createOrganisation2(long companyId) throws Exception {
		
		// Create Organisation		
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
		
		// Create Public Pages
		long publicLayoutSetPrototypeId = 23302;
		boolean publicLayoutSetPrototypeLinkEnabled = true;
		long privateLayoutSetPrototypeId = 0;
		boolean privateLayoutSetPrototypeLinkEnabled = false;
		
		Group organizationGroup = organization.getGroup();
		
		//if (GroupPermissionUtil.contains(themeDisplay.getPermissionChecker(), organizationGroup.getGroupId(), ActionKeys.UPDATE)) {

			SitesUtil.updateLayoutSetPrototypesLinks(
				organizationGroup, publicLayoutSetPrototypeId,
				privateLayoutSetPrototypeId,
				publicLayoutSetPrototypeLinkEnabled,
				privateLayoutSetPrototypeLinkEnabled);
		//}
		
		
		

		// Create User
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
		
		// Create DDLs
	}
	
	//organization.getGroup().setType(23302);
	
			/*
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
			*/
			/*layoutTypePortlet.addPortletId(
				0, PortletKeys.SEARCH, "column-1", -1, false);
			layoutTypePortlet.addPortletId(
				0, PortletKeys.MESSAGE_BOARDS, "column-2", -1, false);*/

			/*LayoutLocalServiceUtil.updateLayout(
				extranetLayout.getGroupId(), false, extranetLayout.getLayoutId(),
				extranetLayout.getTypeSettings());*/

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
	
	public void createOrganisation3() {
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
