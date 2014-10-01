package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationUtilReader
 */
public class InvitationUtilReader extends MVCPortlet {
	/**
	 * Set the now for the React date if not set jet, update the last used link to now.
	 */
	public void setReactDateForInvitation(ActionRequest request, ActionResponse response) throws Exception {
		long invitationOrganisationId = ParamUtil.getLong(request,"bibbox_cs_organizationinvitation");
		if(invitationOrganisationId != 0) {
			InvitationOrganisation invitationorganisation = InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationOrganisationId);
			if(invitationorganisation.getReactdate() == null) {
				invitationorganisation.setReactdate(new Date());
			}
			invitationorganisation.setLastusedlink(new Date());
			InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(invitationorganisation);
		}
	}

}
