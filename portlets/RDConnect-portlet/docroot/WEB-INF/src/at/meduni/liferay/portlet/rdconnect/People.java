package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class People
 */
public class People extends MVCPortlet {
	long ORGANISATION_ADMIN_ROLL = 22956; // local 10166 Server 22956
    long ADMIN_ROLL = 22951;
    long BIOBANK_REG_EDITOR = 32822;
    long BIOBANK_REG_MEMBER = 32821;
    long BIOBANK_REG_OWNER = 32823;
    long BiobanK_REG_MAINCONTACT = 71378;
    
    public void editUserRolles(ActionRequest request, ActionResponse response) throws Exception {
    	try {
    		long rdcuserid = ParamUtil.getLong(request, "rdcuserid");
    		long rdcorganisationid = ParamUtil.getLong(request, "rdcorganisationid");
    		boolean member = ParamUtil.getBoolean(request, "rdcorganisationmember");
    		boolean owner = ParamUtil.getBoolean(request, "rdcroleowner");
    		boolean editor = ParamUtil.getBoolean(request, "rdcroleeditor");
    		String rdcposition = ParamUtil.getString(request, "rdcposition");
    		Organization organization = OrganizationLocalServiceUtil.getOrganization(ParamUtil.getLong(request, "rdcorganisationid"));
    		
    		User user = UserLocalServiceUtil.getUser(rdcuserid);
    		user.setJobTitle(rdcposition);
    		UserLocalServiceUtil.updateUser(user);
    		
    		long[] userids = {rdcuserid};
    		try {
	    		if(editor) {
	    			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_EDITOR);
	    		} else {
	    			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_EDITOR);
	    		}
    		} catch (Exception e) {
    			
    		}
    		try {
	    		if(owner) {
	    			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_OWNER);
	    		} else {
	    			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_OWNER);
	    		}
    		} catch (Exception e) {
    			
    		}
    		try {
	    		if(!member) {
	    			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_MEMBER);
	    			OrganizationLocalServiceUtil.deleteUserOrganization(rdcuserid, rdcorganisationid);
	    		}
    		} catch (Exception e) {
    			
    		}
    	} catch (Exception e) {
			System.out.println("RDC Exception in People::editUserRolles");
			e.printStackTrace();
		}
    }
	
	public void addUser(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String email = ParamUtil.getString(request, "rdcemail");
			Organization organization = OrganizationLocalServiceUtil.getOrganization(ParamUtil.getLong(request, "rdcorganisationid"));
			
			User user = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), email);
			if (user == null) {
				ServiceContext serviceContext = new ServiceContext();
		        serviceContext.setAddGroupPermissions(true);
		        serviceContext.setAddGuestPermissions(true);
				boolean autoPassword = false;
				String password1 = "1234";
				boolean autoScreenName = true;
				String screenName = "";
				long facebookId = 0;
				String openId = "";
				String firstName = ParamUtil.getString(request, "rdcfirstname");
				String middleName = ParamUtil.getString(request, "rdcmiddlename");
				String lastName = ParamUtil.getString(request, "rdclastname");
				int prefixId = 0;
				int suffixId = 0;
				int birthdayMonth = 1;
				int birthdayDay = 1;
				int birthdayYear = 1970;
				String jobTitle = ParamUtil.getString(request, "rdcposition");
				long[] groupIds = new long[0];
				long[] organizationIds = {organization.getOrganizationId()};
				long[] roleIds = new long[0];
				long[] userGroupIds = new long[0];
				boolean male = false;
				if(ParamUtil.getString(request, "rdcgender").equalsIgnoreCase("male"))
					male = true;
				boolean sendEmail = false;
				user = UserLocalServiceUtil.addUser(ParamUtil.getLong(request, "rdccreaterid"), themeDisplay.getCompanyId(), autoPassword, password1, password1, 
						autoScreenName, screenName, email, facebookId, openId, themeDisplay.getLocale(), firstName, middleName, lastName, 
						prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
				user.setPasswordReset(false);
				UserLocalServiceUtil.updateUser(user);
			} else {
				OrganizationLocalServiceUtil.addUserOrganization(user.getUserId(), organization);
			}
			
			long[] userids = {user.getUserId()};
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_MEMBER);
			if(ParamUtil.getBoolean(request, "rdcroleeditor"))
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_EDITOR);
			if(ParamUtil.getBoolean(request, "rdcroleowner"))
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), BIOBANK_REG_OWNER);	
		} catch (Exception e) {
			System.out.println("RDC Exception in People::addUser");
			e.printStackTrace();
		}	
	}
}
