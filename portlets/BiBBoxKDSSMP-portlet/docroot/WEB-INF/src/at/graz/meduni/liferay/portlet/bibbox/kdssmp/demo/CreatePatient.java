package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.patientnamegeneratorLocalServiceUtil;

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
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordConstants;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CreatePatient
 */
public class CreatePatient extends MVCPortlet {
	Locale default_locale_ = null;
	long company_id_ = 0;
 
	public void createNewPatient(ActionRequest request, ActionResponse response) throws Exception {	
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			default_locale_ = themeDisplay.getLocale();
			company_id_ = themeDisplay.getCompanyId();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(560)+1;
			patientnamegenerator patientnamegenerator_vorname = patientnamegeneratorLocalServiceUtil.getpatientnamegenerator(randomInt);
			randomInt = randomGenerator.nextInt(3422) + 561;
			patientnamegenerator patientnamegenerator_nachname = patientnamegeneratorLocalServiceUtil.getpatientnamegenerator(randomInt);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -(randomGenerator.nextInt(80)+15));
			cal.add(Calendar.MONTH, randomGenerator.nextInt(11)+1);
			cal.add(Calendar.DAY_OF_MONTH, randomGenerator.nextInt(31)+1);
			Date dateofbirth = cal.getTime();
			
			
			Company company = CompanyLocalServiceUtil.getCompanyById(company_id_);
			
			String organization_name = ParamUtil.getString(request, "bibbox_cs_organisationname");
			organization_name += " - " + patientnamegenerator_vorname.getName() + " " + patientnamegenerator_nachname.getName() + " (" + dateFormat.format(dateofbirth) + ")";
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
			organization.getExpandoBridge().setAttribute("dateofbirth", dateofbirth);
			organization.getExpandoBridge().setAttribute("firstname", patientnamegenerator_vorname.getName());
			organization.getExpandoBridge().setAttribute("lastname", patientnamegenerator_nachname.getName());
			if(patientnamegenerator_vorname.getType().equalsIgnoreCase("Jungennamen")) {
				organization.getExpandoBridge().setAttribute("male", true);
			} else {
				organization.getExpandoBridge().setAttribute("male", false);
			}
			// Create DDLs
			createDDLs(ddlgeneration, organization.getGroupId(), themeDisplay.getUserId(), serviceContext, request);
			
			if(ParamUtil.getString(request, "bibbox_cs_email") != null) {
				createUser(request, serviceContext, organization, company);
			} else {	
				// Add user to the Organization
				long[] userroleid_array = {ParamUtil.getLong(request, "bibbox_cs_selectuserrole")};
				if(!ParamUtil.getString(request, "bibbox_cs_selectuser").equals("no")) {
					long userid = ParamUtil.getLong(request, "bibbox_cs_userfororganization");
					OrganizationLocalServiceUtil.addUserOrganization(userid, organization.getOrganizationId());
					UserGroupRoleLocalServiceUtil.addUserGroupRoles(userid, organization.getGroup().getGroupId(), userroleid_array);
				}
			}
			sendRedirect(request, response);
		} catch (Exception ex) {
			System.out.println("ERROR: CreatePatient::createNewPatient");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Create user account
	 */
	private User createUser(ActionRequest request, ServiceContext serviceContext, Organization organization, Company company) throws PortalException, SystemException {
		User user = null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean autoPassword = true;
			String password1 = "";
			boolean autoScreenName = true;
			String screenName = "";
			long facebookId = 0;
			String openId = "";
			String firstName = themeDisplay.getUser().getFirstName();
			String middleName = themeDisplay.getUser().getMiddleName();
			String lastName = themeDisplay.getUser().getLastName();
			String mail = themeDisplay.getUser().getEmailAddress();
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
			System.out.println(lastName);
			user = UserLocalServiceUtil.addUser(company.getDefaultUser().getUserId(), company.getCompanyId(), autoPassword, password1, password1, 
					autoScreenName, screenName, mail, facebookId, openId, default_locale_, firstName, middleName, lastName, 
					prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			user.setPasswordReset(false);
			String position = "";
			for(String tmppos : ParamUtil.getParameterValues(request, "bibbox_cs_position")) {
				if(position.length() != 0) {
					position += ", ";
				}
				position += tmppos;
			}
			user.getExpandoBridge().setAttribute("Role within the organisation", organization.getOrganizationId() + "_" + position + ";");
			UserLocalServiceUtil.updateUser(user);
			long[] userroleid_array = {ParamUtil.getLong(request, "bibbox_cs_selectuserrole")};
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), organization.getGroup().getGroupId(), userroleid_array);
		} catch (Exception ex) {
			System.out.println("ERROR: CreatePatient::createUser");
			ex.printStackTrace();
		}
		return user;
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
