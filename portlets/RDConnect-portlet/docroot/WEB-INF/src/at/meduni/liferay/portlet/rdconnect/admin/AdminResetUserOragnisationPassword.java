package at.meduni.liferay.portlet.rdconnect.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdminResetUserOragnisationPassword
 */
public class AdminResetUserOragnisationPassword extends MVCPortlet {
	public void resetUserPassword(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Integer numberofusers = ParamUtil.getInteger(request, "numberofuseres");
			long organizationId = ParamUtil.getLong(request, "organisationid");
			for(int i = 0; i < numberofusers; i++) {
				if(ParamUtil.getBoolean(request, "changeuserpw" + i)) {
					User user = UserLocalServiceUtil.getUser(ParamUtil.getLong(request, "changeuserpwuserid" + i));
		    		user.setPasswordUnencrypted("rdconnect$" + organizationId);
		    		user.setPasswordReset(false);
		    		System.out.println("rdconnect$" + organizationId);
		    		UserLocalServiceUtil.updateUser(user);
				}
			}
		} catch (Exception e) {
			System.out.println("AdminResetUserOragnisationPassword::resetUserPassword");
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
}
