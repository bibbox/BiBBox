package at.graz.meduni.liferay.portlet.bibbox;

import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
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
	
	public void editMaincontact(ActionRequest request, ActionResponse response) throws Exception {
		long maincontactid = ParamUtil.getLong(request, "bibbox_cs_maincontactid");
		long organizationid = ParamUtil.getLong(request, "bibbox_cs_organizationid");
		long maincontactroleid = ParamUtil.getLong(request, "bibbox_cs_maincontactroleid");
		long[] maincontactroleid_array = {maincontactroleid};
		Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationid);
		List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organizationid);
		for(User user_mc : userlist) {
			List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
			for (UserGroupRole ugr : usergrouprolles) {
				if(ugr.getRoleId() == maincontactroleid) {
					UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId(), maincontactroleid_array);
				}
			}
		}
		UserGroupRoleLocalServiceUtil.addUserGroupRoles(maincontactid, organization.getGroup().getGroupId(), maincontactroleid_array);
	}
	
	public void addUser(ActionRequest request, ActionResponse response) throws Exception {
		User user = getUserFromRequest(request, null);
		user = UserLocalServiceUtil.addUser(user);
		setUserRolesInOrganisation(request, user.getUserId());
		user = updateOrganisationJobDiscription(request, user);
		UserLocalServiceUtil.updateUser(user);
	}
	
	public void editUser(ActionRequest request, ActionResponse response) throws Exception {
		long bibbox_cs_userid = ParamUtil.getLong(request, "bibbox_cs_userid");
		User user = UserLocalServiceUtil.getUser(bibbox_cs_userid);
		user = getUserFromRequest(request, user);
		UserLocalServiceUtil.updateUser(user);
		setUserRolesInOrganisation(request, user.getUserId());
		user = updateOrganisationJobDiscription(request, user);
		UserLocalServiceUtil.updateUser(user);
	}
	
	private void setUserRolesInOrganisation(ActionRequest request, long userid) {
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(ParamUtil.getLong(request, "bibbox_cs_organisationid"));
			long editorrole = ParamUtil.getLong(request, "bibbox_cs_editorrole");
			long ownerrole = ParamUtil.getLong(request, "bibbox_cs_ownerrole");
			long maincontact = ParamUtil.getLong(request, "bibbox_cs_maincontact");
			long[] userids = {userid};
			if(ParamUtil.getBoolean(request, "bibbox_cs_roleowner")) {
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), ownerrole);
			} else {
				UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), ownerrole);
			}
			if(ParamUtil.getBoolean(request, "bibbox_cs_roleeditor")) {
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), editorrole);
			} else {
				UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), editorrole);
			}
			if(ParamUtil.getBoolean(request, "bibbox_cs_rolemaincontact")) {
				removeAllMaincontactUseres(maincontact, organization.getOrganizationId(), organization.getGroupId());
				UserGroupRoleLocalServiceUtil.addUserGroupRoles(userids, organization.getGroupId(), maincontact);
			} else {
				UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userids, organization.getGroupId(), maincontact);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void removeAllMaincontactUseres(long roleid, long organizationid, long groupid) {
		try {
			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(UserLocalServiceUtil.getOrganizationUserIds(organizationid), groupid, roleid);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private User updateOrganisationJobDiscription(ActionRequest request, User user) {
		long organizationId = ParamUtil.getLong(request, "bibbox_cs_organisationid");
		boolean nohit = true;
		String new_user_roles  = "";
		String[] user_roles = user.getExpandoBridge().getAttribute("Role within the organisation").toString().split(";");
		for(String user_role : user_roles) {
			String[] our = user_role.split("_");
			if(our.length == 0 || our[0].length() == 0) {
				continue;
			}
			long orgid = Long.parseLong(our[0]);
			if(orgid == organizationId) {
				new_user_roles += orgid + "_" + ParamUtil.getString(request, "bibbox_cs_position") + ";";
				nohit = false;
			} else {
				new_user_roles += user_role + ";";
			}
		}
		if(nohit) {
			new_user_roles += organizationId + "_" + ParamUtil.getString(request, "bibbox_cs_position") + ";";
		}
		user.getExpandoBridge().setAttribute("Role within the organisation", new_user_roles);
		return user;
	}
	
	private User getUserFromRequest(ActionRequest request, User user) {
		String firstname = ParamUtil.getString(request, "bibbox_cs_firstname");
		String middlname = ParamUtil.getString(request, "bibbox_cs_middlename");
		String lastname = ParamUtil.getString(request, "bibbox_cs_lastname");
		String email = ParamUtil.getString(request, "bibbox_cs_email");
		if(user == null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
			boolean autoPassword = true;
			String password1 = "";
			boolean autoScreenName = true;
			String screenName = "";
			long facebookId = 0;
			String openId = "";
			int prefixId = 0;
			int suffixId = 0;
			int birthdayMonth = 1;
			int birthdayDay = 1;
			int birthdayYear = 1970;
			String jobTitle = "";
			long[] groupIds = new long[0];
			long[] organizationIds = {ParamUtil.getLong(request, "bibbox_cs_organisationid")};
			long[] roleIds = new long[0];
			long[] userGroupIds = new long[0];
			boolean male = false;
			boolean sendEmail = false;
			try {
				user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), autoPassword, password1, password1, 
						autoScreenName, screenName, email, facebookId, openId, themeDisplay.getLocale(), firstname, middlname, lastname, 
						prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			user.setFirstName(firstname);
			user.setMiddleName(middlname);
			user.setLastName(lastname);
			user.setEmailAddress(email);
		}
		return user;
	}
}
