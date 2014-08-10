package at.graz.meduni.liferay.portlet.bibbox;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
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
}
