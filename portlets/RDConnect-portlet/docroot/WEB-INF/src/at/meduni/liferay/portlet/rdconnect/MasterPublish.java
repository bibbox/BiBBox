package at.meduni.liferay.portlet.rdconnect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.exception.MasterPublishException;
import at.meduni.liferay.portlet.rdconnect.helper.HelperUser;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.service.persistence.WebsiteUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;
import com.liferay.portal.security.membershippolicy.OrganizationMembershipPolicyFactoryUtil;

/**
 * MasterPublish is a helper class for all publishing of organizations in the RD-Connect Context
 * This class encapsulates the creation and assostioation of different liferay objects and objects
 * definde for the RD-Connect purpose.
 * This objects includes:
 * <ul>
 * <li>Organization</li>
 * <li>Site</li>
 * <li>User</li>
 * <li>Address</li>
 * <li>Phone</li>
 * <li>DDL</li>
 * <li>Folder</li>
 * </ul>
 * 
 * @author	Robert Reihs
 * @version	%I%, %G%
 * @since	1.0
 */
public class MasterPublish extends MVCPortlet {
	/**
	 * Declare Error Variables
	 */
	String error_date_format_apache_pattern_ = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat error_date_format_apache_ = new SimpleDateFormat(error_date_format_apache_pattern_);
	String class_name_ = "RDConnect-portlet::at.meduni.liferay.portlet.rdconnect.MasterPublish";
	
	/**
	 * Declare Variables 
	 */
	final String alphabet_ = "abcdefghijklmopqrstuvwxyz";
    final int alphabeth_length_ = alphabet_.length();
    Random random_ = new Random();
    MasterCandidate master_ = null;
    String password_ = "rdc2015";
    Organization organization_ = null;
    // Liferay data
    ActionRequest request_ = null;
    ThemeDisplay theme_display_ = null;
    Company company_ = null;
    long company_id_ = 0;
    Locale default_locale_ = null;
    // Roles
    long bb_reg_editor_role_id_ = 0; 
    long bb_reg_owner_role_id_ = 0;
    long bb_reg_maincontact_role_id_ = 0;
    // Parent Organizations
    long biobank_assessment_organization_id_ = 0;
    long catalog_organization_id_ = 0;
    // Web page
    
    int PUBLICWEBSITETYPEID = 12020; // Public: 12020
    int INTRANETWEBSITETYPEID = 12019; // Public: 12020
    // E-mail
    int EMAILADDRESS_TYPEID = 12004;
    // Address
    int ADDRESS_BILLING = 12000;
    int ADDRESS_OTHER = 12001;
    int ADDRESS_POBOX = 12002;
    int ADDRESS_SHIPPING = 12003;
    // NamingConventions
    String PUBLIC_LAYOUT_SET_PROTOTYPE_NAME = "ID-Card";
	
    /**
     * Publish an new organization for RD-Connect
     * Registries are directly published to the catalogue, Biobanks are first published to the 
     * assessment organization and moved after the assessment to the catalogue.
     * For all organizations contact details are added to the liferay organization, users are
     * added with the proper roles, or if they dose not exist new users are created.
     * 
     * @param request the ActionRequest from the portlet call with information of the portal
     * @param response - delete
     * @param master 
     * @throws Exception
     */
	public void publishToGate(ActionRequest request, ActionResponse response, MasterCandidate master) throws Exception {
		try {
			//TODO: Use SessionMessages for display (msg):   error-assining-user-role, error-creating-user, master-cadidate-not-updated, error-creating-ddl, error-creating-folder
			//TODO: Use SessionMessages for display (error): organization-creation-error
			master_ = master;
			request_ = request;
			setUpVaraibles();
			organization_ = createOrganisation();
			updateMasterCandidate();
			createPublicPage();
			HashSet<User> users = createUsersFromMaster();
			addUsersToOrganization(users);
			createDDLs();
			addFoldersForOrganization();
			//TODO: addOrganisationDetails(organization, master, themeDisplay.getUserId());
			//TODO: OrganizationLocalServiceUtil.rebuildTree(company.getCompanyId());
			organization_.getExpandoBridge().setAttribute("Organization Type", master_.getCandidatetype());
		} catch (MasterPublishException exception) {
			SessionErrors.add(request_, "organization-creation-error", exception.getMessage());
			response.setRenderParameter("success", "false");
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Organization organization = null;
		
		try {
			//setUpVaraibles(request);
			Company company = CompanyLocalServiceUtil.getCompanyById(company_id_);
			// Create Organisation
			organization = createOrganisation(company);
			
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
			// Add Organisation details
			addOrganisationDetails(organization, master, themeDisplay.getUserId());
			
			OrganizationLocalServiceUtil.rebuildTree(company.getCompanyId());
			
			organization.getExpandoBridge().setAttribute("Organization Type", master.getCandidatetype());
		} catch(Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate");
			e.printStackTrace();
		}	
		
		try {
			String shorttext = "";
			String longtext = "";
			String link = "";
			String restricted = "";
			String eventtitle = "";
			
			String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
			
			if(master.getCandidatetype().equalsIgnoreCase("Biobank")) {
				eventtitle = "New Biobank Published: " + organization.getName();
				restricted = "RD-Connect CURATOR";
				link = link + "/bb_home";
				shorttext = "Biobank "+ organization.getName() + " from " + master.getCountry() + " was published an is now in the list redy for the pannel assessment invitation.";
				longtext = "";
			} else {
				eventtitle = "New Registry Published: " + organization.getName();
				restricted = "";
				link = link + "/reg_home";
				shorttext = "Registry "+ organization.getName() + " from " + master.getCountry() + " was published an is now listed in the catalouge.";
				longtext = "";
			}
			addEventEntry(new Date(), organization.getOrganizationId(), themeDisplay.getUserId(), shorttext, longtext, link, restricted, eventtitle);
		} catch(Exception e) {
			System.out.println("RDC Exception in MasterPublish:publishToGate -> Add Event");
			e.printStackTrace();
		}
	}
	
	/**
     * Setup variables for publishing an organization
     * 
     * @param request the ActionRequest from the portlet call with information of the portal 
	 * @throws MasterPublishException 
     */
    public void setUpVaraibles() throws MasterPublishException {
    	try {
    		theme_display_ = (ThemeDisplay) request_.getAttribute(WebKeys.THEME_DISPLAY);
    		company_id_ = theme_display_.getCompanyId();
    		default_locale_ = theme_display_.getLocale();
    		company_ = theme_display_.getCompany();
    		
    		setUpRoleVaraibles();
    		setUpOrganizationVaraibles();
    		
    	} catch(Exception exception) {
    		System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::setUpVaraibles(ActionRequest request)] Error Setting up Varaibles for publishing: " + exception.getMessage());
    		exception.printStackTrace();
    		throw new MasterPublishException("Error Setting up Varaibles for publishing: " + exception.getMessage());
    	}
    }
    
    /**
     * Setup role variables for publishing an organization
     * @throws MasterPublishException 
     */
    public void setUpRoleVaraibles() throws MasterPublishException {
    	try {
	    	bb_reg_editor_role_id_ = RoleLocalServiceUtil.getRole(company_id_, "BB-REG-EDITOR").getRoleId();
			bb_reg_owner_role_id_ = RoleLocalServiceUtil.getRole(company_id_, "BB-REG-OWNER").getRoleId();
			bb_reg_maincontact_role_id_ = RoleLocalServiceUtil.getRole(company_id_, "BB-REG-MAINCONTACT").getRoleId();
    	} catch(Exception exception) {
    		System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::setUpRoleVaraibles()] Error Setting up Role Varaibles for publishing: " + exception.getMessage());
    		exception.printStackTrace();
    		throw new MasterPublishException("Error Setting up Role Varaibles for publishing: " + exception.getMessage());
    	}
    }
    
    /**
     * Setup organization variables for publishing an organization
     * @throws MasterPublishException 
     */
    public void setUpOrganizationVaraibles() throws MasterPublishException {
    	try {
    		biobank_assessment_organization_id_ = OrganizationLocalServiceUtil.getOrganization(company_id_, "Biobank Assessment").getOrganizationId();
    		catalog_organization_id_ = OrganizationLocalServiceUtil.getOrganization(company_id_, "Catalog").getOrganizationId();
    	} catch(Exception exception) {
    		System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::setUpOrganizationVaraibles()] Error Setting up Organization Varaibles for publishing: " + exception.getMessage());
    		exception.printStackTrace();
    		throw new MasterPublishException("Error Setting up Organization Varaibles for publishing: " + exception.getMessage());
    	}
    }
    
    /**
     * 
     * @param company
     * @return
     * @throws MasterPublishException
     */
    private Organization createOrganisation() throws MasterPublishException {
		try {	
			long userId = company_.getDefaultUser().getUserId();
	        long parentOrganizationId = getParentOrganizationIdForMasterCandidate();
	        String name = getOrganizationNameForMasterCandidate();
	        String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
	        long regionId = 0;
	        long countryId = 0;
	        int statusId = GetterUtil.getInteger(PropsUtil.get("sql.data.com.liferay.portal.model.ListType.organization.status"));
	        String comments = null;
	        boolean site = true;
	
	        ServiceContext service_context = getServiceContext();

	        Organization organization =
	                OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, type, regionId, countryId, 
	                		statusId, comments, site, service_context);
	        
			return organization;
		} catch (Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::createOrganisation()] Error creating Organization: " + exception.getMessage());
    		exception.printStackTrace();
    		throw new MasterPublishException("Error creating Organization: " + exception.getMessage());
		}
	}
    
    /**
     * 
     * @return
     */
    private long getParentOrganizationIdForMasterCandidate() {
    	long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
        if(master_.getCandidatetype().equalsIgnoreCase("biobank")) {
        	parentOrganizationId = biobank_assessment_organization_id_;
        } else {
        	parentOrganizationId = catalog_organization_id_;
        }
        return parentOrganizationId;
    }
    
    /**
     * 
     * @return
     */
    private String getOrganizationNameForMasterCandidate() {
    	String name = master_.getName();
        if(name.length() > 100) {
        	name = name.substring(0, 100);
        }
        return name;
    }
    
    /**
     * 
     * @param organization_id
     */
    private void updateMasterCandidate() {
    	try {
	    	master_.setOrganisationid(organization_.getOrganizationId());
	    	master_.setState("P");
	    	master_ = MasterCandidateLocalServiceUtil.updateMasterCandidate(master_);
    	} catch(Exception exception) {
    		System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::updateMasterCandidate(long organization_id)] Error updating MasterCandidate: [masterId:" + master_.getMasterCandidateId() + "; organizationId:" + organization_.getOrganizationId() + "]" + exception.getMessage());
    		exception.printStackTrace();
    		SessionMessages.add(request_, "master-cadidate-not-updated", "There was an error updating the MasterCandidate Table.");
    		//TODO: Add Event for Admins for this
    	}
    }
    
    /**
     * 
     * @return
     */
    private ServiceContext getServiceContext() {
    	ServiceContext service_context = new ServiceContext();
    	service_context.setAddGroupPermissions(true);
    	service_context.setAddGuestPermissions(true);
        return service_context;
    }
    
    /**
     * Create public site for organization
     * 
     * @throws Exception
     */
    private void createPublicPage() throws Exception {
		try {
			long public_layout_set_prototype_id = getPublicLayoutSetPrototypeId();
			boolean is_private_layout = false;
			Group organization_group = organization_.getGroup();
			long group_id = organization_group.getGroupId();
			boolean layout_set_prototype_link_enabled = true;
			
		    LayoutSetPrototype prototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(public_layout_set_prototype_id);
		    LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(group_id, is_private_layout,
		            layout_set_prototype_link_enabled, prototype.getUuid());
		    
		    LayoutSet layout_set = LayoutSetLocalServiceUtil.getLayoutSet(group_id, is_private_layout);
		    SitesUtil.mergeLayoutSetPrototypeLayouts(organization_group, layout_set);
		    
		} catch (Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::createOrganisation()] Error creating Organization: " + exception.getMessage());
    		exception.printStackTrace();
    		throw new MasterPublishException("Error creating Organization Site: " + exception.getMessage());
		}
	}
    
    /**
     * Get the PublicLayoutSetPrototypeId for the name
     * 
     * @return
     * @throws PortalException
     * @throws SystemException
     * @throws MasterPublishException
     */
    private long getPublicLayoutSetPrototypeId() throws PortalException, SystemException, MasterPublishException {
    	List<LayoutSetPrototype> site_templates = LayoutSetPrototypeServiceUtil.search(company_.getCompanyId(), Boolean.TRUE, null);
    	for(LayoutSetPrototype site_template : site_templates) {
    		if(site_template.getName().equalsIgnoreCase(PUBLIC_LAYOUT_SET_PROTOTYPE_NAME)) {
    			return site_template.getLayoutSetPrototypeId();
    		}
    	}
    	throw new MasterPublishException("Error LayoutSetPrototype with name " + PUBLIC_LAYOUT_SET_PROTOTYPE_NAME + " dose not exist: ");
    }
    
    /**
     * 
     * @param organization
     * @param company
     */
    private HashSet<User> createUsersFromMaster() {
		HashSet<HelperUser> mails = getEmailAddressFromMaster(master_.getMail());
		HashSet<User> users = new HashSet<User>();
		
		boolean fix_use_contact_person = false;
		if(mails.size() == 1) {
			fix_use_contact_person = true;
		}
		
		for(HelperUser mail : mails) {	
			try {
				User user = createUsers(mail, fix_use_contact_person);
				users.add(user);
			} catch(Exception exception) {
				System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::createUsersFromMaster()] Error creating user: [email: " + mail.getEmail() + "]" + exception.getMessage());
	    		exception.printStackTrace();
	    		SessionMessages.add(request_, "error-creating-user", "There was an error creating the user with email: " + mail.getEmail() + ".");
	    		//TODO: Add Event for Admins for this
			}
		}
		return users;
	}
    
    /**
     * 
     * @param email
     * @return
     */
    private HashSet<HelperUser> getEmailAddressFromMaster(String email) {
    	HashSet<HelperUser> mails = new HashSet<HelperUser>();
    	email = email.replaceAll("mailto:", ";").replaceAll(" ", "");
    	String pattern_string_mail_ = "\\b([a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4})*)\\b";
		Pattern pattern_mail_ = Pattern.compile(pattern_string_mail_);
		Matcher matcher = pattern_mail_.matcher(email);
		while (matcher.find()) {
			HelperUser helper_user = new HelperUser();
			helper_user.setEmail(matcher.group().toLowerCase());
			if(!mails.contains(helper_user)) {
				mails.add(helper_user);
			}
		}
		return mails;
    }
    
    /**
     * 
     * @param mail
     * @param fix_use_contact_person
     * @throws SystemException 
     * @throws PortalException 
     */
    private User createUsers(HelperUser mail, boolean fix_use_contact_person) throws PortalException, SystemException {
		mail.extractNameFromContactPerson(master_.getContactperson(), master_.getHead(), fix_use_contact_person);
		return createLiferayUser(mail);
    }
	
    /**
     * 
     * @param mail
     * @return
     * @throws PortalException
     * @throws SystemException
     */
	private User createLiferayUser(HelperUser mail) throws PortalException, SystemException {
		boolean autoPassword = false;
		boolean autoScreenName = true;
		String screenName = "";
		long facebookId = 0;
		String openId = "";
		String firstName = mail.getFirstname();
		String middleName = "";
		String lastName = mail.getLastname();
		int prefixId = 0;
		int suffixId = 0;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = new long[0];
		long[] organizationIds = {};
		long[] roleIds = new long[0];
		long[] userGroupIds = new long[0];
		boolean male = false;
		boolean sendEmail = false;
		User user = UserLocalServiceUtil.addUser(company_.getDefaultUser().getUserId(), company_.getCompanyId(), autoPassword, password_, password_, 
				autoScreenName, screenName, mail.getEmail(), facebookId, openId, default_locale_, firstName, middleName, lastName, 
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, getServiceContext());
		user.setPasswordReset(false);
		UserLocalServiceUtil.updateUser(user);
		return user;
	}
	
	/**
	 * 
	 * @param organization
	 * @param users
	 */
	private void addUsersToOrganization(HashSet<User> users) {
		boolean maincontact = true;
		for(User user : users) {
			addUserToOrganization(user, maincontact);
			maincontact = false;
		}
	}
	
	/**
	 * 
	 * @param organization
	 * @param user
	 * @param maincontact
	 */
	private void addUserToOrganization(User user, boolean maincontact) {
		try {
			OrganizationLocalServiceUtil.addUserOrganization(user.getUserId(), organization_);
			long[] userids = {user.getUserId()};
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization_.getGroupId(), bb_reg_editor_role_id_);
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization_.getGroupId(), bb_reg_owner_role_id_);
			if(maincontact) {
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization_.getGroupId(), bb_reg_maincontact_role_id_);
			}
		} catch (Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::addUserToOrganization(Organization organization, User user, boolean maincontact)] Error adding user to organization: [UserId: " + user.getUserId() + "; OrganizationId: " + organization_.getOrganizationId() + "]" + exception.getMessage());
    		exception.printStackTrace();
    		SessionMessages.add(request_, "error-assining-user-role", "There was an error assigning the Roles for user with email: " + user.getEmailAddress() + ".");
    		//TODO: Add Event for Admins for this
		}
	}
	
	/**
	 * Creates DDL entrys for the RD-Connect ID-Cards with data from master
	 */
	private void createDDLs() {
		createRecordSetWithDatafields("core", "core");
		createRecordSetWithDatafields("bb_core", "bb_core");
		createRecordSetWithDatafields("reg_quality", "reg_quality");
		createRecordSetWithDatafields("bb_quality", "bb_quality");
		createRecordSetWithDatafields("Disease Areas (ICD10)", "Disease Areas (ICD10)");
		createRecordSetWithDatafields("reg_accessibility", "reg_accessibility");
		createRecordSetWithDatafields("bb_accessibility", "bb_accessibility");
		createRecordSetWithDatafields("Scientific publications", "Scientific publications");
		createRecordSetWithDatafields("bb_contribution", "bb_contribution");
	}
	
	/**
	 * Function to create DDLs from DDM Structure with data from the master record
	 * 
	 * @param ddl_name
	 * @param ddm_name
	 */
	private void createRecordSetWithDatafields(String ddl_name, String ddm_name) {
		try {
			long ddm_structure_id = getDDMStructureIdFromDDMName(ddm_name);
			DDLRecordSet recordSet = createRecordSet(ddl_name, ddm_structure_id);
			creatRecord(recordSet);
		} catch (Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::createRecordSetWithDatafields(String ddl_name, String ddm_name)] Error adding DDL Structure: [DDLname: " + ddl_name + "; OrganizationId: " + organization_.getOrganizationId() + "]" + exception.getMessage());
    		exception.printStackTrace();
    		SessionMessages.add(request_, "error-creating-ddl", "There was an error creating a DDL for the Organization.");
    		//TODO: Add Event for Admins for this
		}
	}
	
	/**
	 * Temporary class needs to be updated to get the information from liferay API
	 * 
	 * @param name
	 * @return
	 */
	private long getDDMStructureIdFromDDMName(String name) {
		if(name.equalsIgnoreCase("core")) {
			return 16059;
		}
		if(name.equalsIgnoreCase("bb_core")) {
			return 32327;
		}
		if(name.equalsIgnoreCase("reg_quality")) {
			return 23725;
		}
		if(name.equalsIgnoreCase("bb_quality")) {
			return 32325;
		}
		if(name.equalsIgnoreCase("Disease Areas (ICD10)")) {
			return 32329;
		}
		if(name.equalsIgnoreCase("reg_accessibility")) {
			return 22594;
		}
		if(name.equalsIgnoreCase("bb_accessibility")) {
			return 32323;
		}
		if(name.equalsIgnoreCase("Scientific publications")) {
			return 32331;
		}
		if(name.equalsIgnoreCase("bb_contribution")) {
			return 32333;
		}
		return 0;
	}
	
	/**
	 * Creates DDL RecordSet from DDM Structure
	 * 
	 * @param name
	 * @param ddm_structure_id
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private DDLRecordSet createRecordSet(String name, long ddm_structure_id) throws PortalException, SystemException {
		ServiceContext serviceContext = getServiceContext();
        Group group = organization_.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        serviceContext.setUserId(organization_.getUserId());
		long groupId = organization_.getGroupId();
		String recordSetKey = null;
		int scope = 0;
		String[] languageid = {"0"};
		String[] names = {name};
		String[] description = {name};
		Map<Locale,String> nameMap = LocalizationUtil.getLocalizationMap(languageid, names);
		Map<Locale,String> descriptionMap = LocalizationUtil.getLocalizationMap(languageid, description);

		DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(theme_display_.getUserId(), groupId, ddm_structure_id, recordSetKey, nameMap, 
				descriptionMap, DDLRecordSetConstants.MIN_DISPLAY_ROWS_DEFAULT, scope, serviceContext);
		return recordSet;
	}
	
	/**
	 * Create Record for the DDL
	 * 
	 * @param record_set
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void creatRecord(DDLRecordSet record_set) throws PortalException, SystemException {
		ServiceContext serviceContext = getServiceContext();
        Group group = organization_.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        serviceContext.setUserId(organization_.getUserId());		
		Fields fields = DDMUtil.getFields(record_set.getDDMStructureId(), serviceContext);
		fields = master_.getFieldsForDDLRecord(fields, record_set.getName());
		DDLRecordLocalServiceUtil.addRecord(
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(), record_set.getRecordSetId(),
				DDLRecordConstants.DISPLAY_INDEX_DEFAULT, fields,
				serviceContext);
	}
	
	/**
	 * Creating Folders for RD-Connect
	 */
	private void addFoldersForOrganization() {
		addFolderForOrganization("Study protocol", "");
		addFolderForOrganization("Datasets", "Case Report Form");
		addFolderForOrganization("Standard Operating Procedures", "");
		addFolderForOrganization("Informed consent templates", "");
		addFolderForOrganization("REC approval", "");
		addFolderForOrganization("Data transfer agreement", "");
		addFolderForOrganization("Papers and publications", "");
	}
	
	/**
	 * Creating a folder in the organization site
	 * 
	 * @param foldername
	 */
	private void addFolderForOrganization(String foldername, String description) {
		try {
			ServiceContext serviceContext = getServiceContext();
	        Group group = organization_.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        serviceContext.setUserId(organization_.getUserId());
			DLFolderLocalServiceUtil.addFolder(organization_.getUserId(), organization_.getGroupId(), organization_.getGroupId(), false, 0, foldername, description, false, serviceContext);
		} catch(Exception exception) {
			System.err.println("[" + error_date_format_apache_.format(new Date()) + "] [error] [" + class_name_ + "::createRecordSetWithDatafields(String ddl_name, String ddm_name)] Error adding Folder: [Foldername: " + foldername + "; OrganizationId: " + organization_.getOrganizationId() + "]" + exception.getMessage());
    		exception.printStackTrace();
    		SessionMessages.add(request_, "error-creating-folder", "There was an error creating a Folder for the Organization.");
    		//TODO: Add Event for Admins for this
		}
	}
    
    //----------------------------------------------------------------
	
	
	
	/**
	 * Add event entry
	 * 
	 * @param eventdate
	 * @param organizationId
	 * @param userId
	 * @param shorttext
	 * @param longtext
	 * @param link
	 * @param restricted
	 */
	private void addEventEntry(Date eventdate, long organizationId, long userId, String shorttext, String longtext, String link, String restricted, String eventtitle) {
		RDConnectEventLocalServiceUtil.createEvent(eventtitle, eventdate, organizationId, userId, shorttext, longtext, link, restricted);
	}
	
	private void addOrganisationDetails(Organization organization, MasterCandidate master, long userid) {
		addWebpageToOrganisation(organization, master);
		addEmailAddressToOrganisation(organization, master);
		addAddressToOrganisation(organization, master, userid);
	}
	
	private void addEmailAddressToOrganisation(Organization organization, MasterCandidate master) {
		try {
			List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
			String pattern_string_mail_ = "\\b([a-zA-Z0-9._%+-]+@([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4})*)\\b";
			Pattern pattern_mail_ = Pattern.compile(pattern_string_mail_);
			
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
			
			HashSet<String> mails = new HashSet<String>();
			Matcher matcher = pattern_mail_.matcher(master.getMail().replaceAll("mailto:", ""));
			while (matcher.find()) {
				if(!mails.contains(matcher.group().toLowerCase()))
					mails.add(matcher.group().toLowerCase());
			}
			matcher = pattern_mail_.matcher(master.getContactperson().replaceAll("mailto:", ""));
			while (matcher.find()) {
				if(!mails.contains(matcher.group().toLowerCase()))
					mails.add(matcher.group().toLowerCase());
			}
			matcher = pattern_mail_.matcher(master.getHead().replaceAll("mailto:", ""));
			while (matcher.find()) {
				if(!mails.contains(matcher.group().toLowerCase()))
					mails.add(matcher.group().toLowerCase());
			}
			
			boolean primary = true;
			for(String mail : mails) {
				EmailAddress emailAddress = EmailAddressLocalServiceUtil.createEmailAddress(0);

				emailAddress.setAddress(mail);
				emailAddress.setTypeId(EMAILADDRESS_TYPEID);
				emailAddress.setPrimary(primary);
				primary = false;
				emailAddresses.add(emailAddress);
			}
			UsersAdminUtil.updateEmailAddresses(Organization.class.getName(), organization.getOrganizationId(), emailAddresses);
		} catch (PortalException e) {
			System.out.println("RDC Exception MasterPublish::addEmailAddressToOrganisation");
			System.out.println("PortalException");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception MasterPublish::addEmailAddressToOrganisation");
			System.out.println("SystemException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("RDC Exception MasterPublish::addEmailAddressToOrganisation");
			e.printStackTrace();
		}
	}
	
	private void addPhoneToOrganisation(Organization organization, MasterCandidate master) {
		try {
			List<Phone> phones = new ArrayList<Phone>();
			UsersAdminUtil.updatePhones(Organization.class.getName(), organization.getOrganizationId(), phones);
		} catch (PortalException e) {
			System.out.println("RDC Exception MasterPublish::addPhoneToOrganisation");
			System.out.println("PortalException");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception MasterPublish::addPhoneToOrganisation");
			System.out.println("SystemException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("RDC Exception MasterPublish::addPhoneToOrganisation");
			e.printStackTrace();
		}
	}
	
	private void addAddressToOrganisation(Organization organization, MasterCandidate master, long userid) {
		try {
			List<Address> addresses = new ArrayList<Address>();
			String street1 = "-";
			String street2 = "";
			String street3 = "";
			String city = "-";
			String zip = "-";
			
			if(!master.getAddress().equalsIgnoreCase("")){ 
				int end = 0;
				int start = 0;
				if(master.getAddress().length() <= 75) {
					street1 = master.getAddress();
				} else if (master.getAddress().length() > 75 && master.getAddress().length() <= 150) {
					end = master.getAddress().substring(start, 75).lastIndexOf(" ");
					street1 = master.getAddress().substring(start, end);
				} else if (master.getAddress().length() > 150 && master.getAddress().length() <= 225) {
					end = master.getAddress().substring(start, 75).lastIndexOf(" ");				
					street1 = master.getAddress().substring(start, end);
					start = end;
					end = start + master.getAddress().substring(start, end+75).lastIndexOf(" ");
					street2 = master.getAddress().substring(start, end);
					if(end < master.getAddress().length())
						street3 = master.getAddress().substring(end);
				} else if (master.getAddress().length() > 225) {
					end = master.getAddress().substring(start, 75).lastIndexOf(" ");
					street1 = master.getAddress().substring(start, end);
					start = end;
					end = start + master.getAddress().substring(start, end+75).lastIndexOf(" ");
					street2 = master.getAddress().substring(start, end);
					start = end;
					end = start + master.getAddress().substring(start, start+75).lastIndexOf(" ");
					street3 = master.getAddress().substring(start, end);
				}
			}
			
			int typeId = ADDRESS_OTHER;
			long regionId = 0;
			long countryId = 0;
			boolean mailing = false;
			boolean primary = true;
			addresses.add(AddressLocalServiceUtil.addAddress(userid, Organization.class.getName(), organization.getOrganizationId(), street1, street2, street3, city, zip, 
					regionId, countryId, typeId, mailing, primary, new ServiceContext()));
			UsersAdminUtil.updateAddresses(Organization.class.getName(), organization.getOrganizationId(), addresses);
		} catch (PortalException e) {
			System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
			System.out.println("PortalException");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
			System.out.println("SystemException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("RDC Exception MasterPublish::addAddressToOrganisation");
			e.printStackTrace();
		}
	}
	
	private void addWebpageToOrganisation(Organization organization, MasterCandidate master) {
		try {
			List<Website> websites = new ArrayList<Website>();
			String[] urls = master.getUrl().split("[,; ]");
			boolean primary = true;
			for(String url : urls) {
				url = url.trim();
				if(url.length() == 0)
					continue;
				if(!url.startsWith("http"))
					url = "http://" + url;
				Website website = WebsiteLocalServiceUtil.createWebsite(0);
				website.setUrl(url);
				website.setTypeId(PUBLICWEBSITETYPEID);
				website.setPrimary(primary);
				primary = false;
				websites.add(website);
			}
			UsersAdminUtil.updateWebsites(Organization.class.getName(), organization.getOrganizationId(), websites);
		} catch (PortalException e) {
			System.out.println("RDC Exception MasterPublish::addWebpageToOrganisation");
			System.out.println("PortalException");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("RDC Exception MasterPublish::addWebpageToOrganisation");
			System.out.println("SystemException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("RDC Exception MasterPublish::addWebpageToOrganisation");
			e.printStackTrace();
		}
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
		return getNameStringFormat(name);
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
		return getNameStringFormat(name);
	}
	
	private String getNameStringFormat(String name) {
		if(name.length() > 1) {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		} else if(name.length() == 1) {
			name = name.substring(0, 1).toUpperCase();
		}
		System.out.println("Name: " + name);
		return name;
	}
	
	
	
	
	
	
	
	private String randomIdGenerator() {
		String id = "_INSTANCE_";
	    for (int i = 0; i < 4; i++) {
	    	id += alphabet_.charAt(random_.nextInt(alphabeth_length_));
	    }
	    return id;
	}
	
	private void creatRecordDiseaseMatrix(DDLRecordSet recordSet, long groupId, ServiceContext serviceContext, MasterCandidate master) throws PortalException, SystemException {
		String[] diseascodes = master.getDiseasescodes().split(";");
		for(String s : diseascodes) {
			try {
				DDMStructure ddmStructure = recordSet.getDDMStructure();		
				Fields fields = DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
				
				s = s.trim();
				
				String fieldtype = "Comment";
				if(s.contains("orpha") || s.contains("ORPHA")) {
					fieldtype = "Orphanet_Number";
				}
				if(s.matches("\\w\\d\\d\\.\\d") || s.matches("\\w\\d\\d") || s.matches("ICD10:\\w\\d\\d\\.\\d") || s.matches("ICD10:\\w\\d\\d")) {
					fieldtype = "ICD10";
				}
				if(s.matches("\\d{6}") || s.matches("OMIM:\\d{6}") || s.matches("OMIM\\d{6}")) {
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
					
				Field field_code = new Field("Name", s);
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
