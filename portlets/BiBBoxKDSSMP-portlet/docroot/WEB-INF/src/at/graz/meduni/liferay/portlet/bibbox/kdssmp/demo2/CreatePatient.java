package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.patientnamegeneratorLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CreatePatient
 */
public class CreatePatient extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws Exception
	 */
	public void createNewPatientWithAZ(ActionRequest request, ActionResponse response) {	
		try {
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
			String gender = "";
			
			if(patientnamegenerator_vorname.getType().equalsIgnoreCase("Jungennamen")) {
				gender = "male";
			} else {
				gender = "female";
			}
			
			String organization_name = ParamUtil.getString(request, "kdssmp_az");
			organization_name += " - " + patientnamegenerator_vorname.getName() + " " + patientnamegenerator_nachname.getName() + " (" + dateFormat.format(dateofbirth) + ")";
			
			createNewPatient(patientnamegenerator_vorname.getName(), patientnamegenerator_nachname.getName(), dateofbirth, gender, organization_name, request);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreatePatient::createNewPatientWithAZ] Error Creating a new Patient.");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void createNewPatient(ActionRequest request, ActionResponse response) throws Exception {	
		try {
			String firstname = ParamUtil.getString(request, "kdssmp_firstname");
			String lastname = ParamUtil.getString(request, "kdssmp_lastname");
			Date dob = ParamUtil.getDate(request, "kdssmp_dob", dateFormat);
			String gender = ParamUtil.getString(request, "kdssmp_gender");
			String organization_name = firstname + " " + lastname + " (" + dateFormat.format(dob) + ")";
			createNewPatient(firstname, lastname, dob, gender, organization_name, request);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreatePatient::createNewPatient] Error Creating a new Patient.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param dob
	 * @param gender
	 * @param organizationname
	 */
	private void createNewPatient(String firstname, String lastname, Date dob, String gender, String organizationname, ActionRequest request) {
		try {
			Date dod = null;
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long company_id = themeDisplay.getCompanyId();
			Company company = CompanyLocalServiceUtil.getCompanyById(company_id);
			long parentorganisation = ParamUtil.getLong(request, "kdssmp_parentorganisation");
			long pagetemplate = ParamUtil.getLong(request, "kdssmp_pagetemplate");
			long roleforuser = ParamUtil.getLong(request, "kdssmp_roleforuser");
			long roleforpatient = ParamUtil.getLong(request, "kdssmp_roleforpatient");
			boolean site = pagetemplate == 0 ? false : true;
			Organization organization = createOrganization(organizationname, company, site, parentorganisation);
			KdssmpPatientLocalServiceUtil.createKdssmpPatient(firstname, lastname, dob, dod, gender, organization.getOrganizationId());
			if(site) {
				createPages(organization, pagetemplate);
			}
			OrganizationLocalServiceUtil.addUserOrganization(themeDisplay.getUserId(), organization.getOrganizationId());
			if(roleforuser != 0) {
				long[] userroleid_array = {roleforuser};
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(themeDisplay.getUserId(), organization.getGroup().getGroupId(), userroleid_array);
			}
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
			User patient = createUser(null, firstname, lastname, themeDisplay.getCompany(), firstname.toLowerCase() + "." + lastname.toLowerCase() + "@bibbox.org", organization, serviceContext, themeDisplay.getLocale());
			if(roleforpatient != 0) {
				long[] userroleid_array = {roleforpatient};
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(patient.getUserId(), organization.getGroup().getGroupId(), userroleid_array);
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreatePatient::createNewPatient] Error Creating a new Patient.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param user
	 * @param company
	 * @param mail
	 * @param organization
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private User createUser(User user, String firstName, String lastName, Company company, String mail, Organization organization, ServiceContext serviceContext, Locale default_locale) throws PortalException, SystemException {
		System.out.println(mail);
		boolean autoPassword = false;
		String password1 = "20fenris14";
		boolean autoScreenName = true;
		String screenName = "";
		long facebookId = 0;
		String openId = "";
		String middleName = "";
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
				autoScreenName, screenName, mail, facebookId, openId, default_locale, firstName, middleName, lastName, 
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		user.setPasswordReset(false);
		UserLocalServiceUtil.updateUser(user);
		return user;
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
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreatePatient::createOrganization] Error Creating a Organization for Patient.");
			ex.printStackTrace();
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
	private void createPages(Organization organization, long publicLayoutSetPrototypeId) throws Exception {
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
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxkDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreatePatient::createPages] Error Creating PageLayout for Organization for Patient.");
			ex.printStackTrace();
		}
	}
}
