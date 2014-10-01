package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationUtilReject
 */
public class InvitationUtilReject extends MVCPortlet {
	/**
	 * Set the now for the React date if not set jet, update the last used link to now.
	 */
	public void rejectParticipation(ActionRequest request, ActionResponse response) throws Exception {
		long invitationorganizationId = ParamUtil.getLong(request,"invitationorganizationId");
		long securitytoken = ParamUtil.getLong(request,"securitytoken");
		long securitylinktoken = ParamUtil.getLong(request,"securitylinktoken");
		long optionsDeleteParentOrganisation = ParamUtil.getLong(request,"optionsDeleteParentOrganisation");
		if(invitationorganizationId != 0) {
			System.out.println("Reject Organization: Delete to: " + optionsDeleteParentOrganisation);
			InvitationOrganisation invitationorganisation = InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationorganizationId);
			if(invitationorganisation != null) {
				System.out.println("Securitylinktoken: " + invitationorganisation.getSecuritylinktoken() + "  Securitytoken: " + invitationorganisation.getSecuritytoken());
				if(invitationorganisation.getSecuritylinktoken() == securitylinktoken && invitationorganisation.getSecuritytoken() == securitytoken) {
					invitationorganisation.setRejectdate(new Date());
					Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
					organization.setParentOrganizationId(optionsDeleteParentOrganisation);
					OrganizationLocalServiceUtil.updateOrganization(organization);
					InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(invitationorganisation);
					SessionMessages.add(request, "organization-successfully-deleted");
					sendRedirect(request, response);
				} else {
					SessionErrors.add(request, "security-token-missmatch");
					response.setRenderParameter("success", "false");
				}
			}
		}
	}

}
