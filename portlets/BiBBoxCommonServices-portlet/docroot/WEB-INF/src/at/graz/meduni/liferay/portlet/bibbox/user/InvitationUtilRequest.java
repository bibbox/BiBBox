package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationUtilRequest
 */
public class InvitationUtilRequest extends MVCPortlet {
	/**
	 * Set the now for the React date if not set jet, update the last used link to now.
	 */
	public void sendRequest(ActionRequest request, ActionResponse response) throws Exception {
		long organizationId = ParamUtil.getLong(request,"organizationId");
		long status = ParamUtil.getLong(request,"status");
		List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getInvitationsByOrganisation(organizationId);
		for(InvitationOrganisation invitationorganisation : invitationorganisations) {
			invitationorganisation.setStatus(status);
			invitationorganisation.setStatusdate(new Date());
			InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(invitationorganisation);
		}
	}
}
