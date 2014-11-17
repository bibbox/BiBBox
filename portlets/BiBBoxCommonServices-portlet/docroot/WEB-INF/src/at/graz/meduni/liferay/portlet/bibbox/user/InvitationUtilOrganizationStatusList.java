package at.graz.meduni.liferay.portlet.bibbox.user;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;
import at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationUtilOrganizationStatusList
 */
public class InvitationUtilOrganizationStatusList extends MVCPortlet {
	/**
	 * Delete an Organization from the Invitation
	 */
	public void createAssessment(ActionRequest request, ActionResponse response) throws Exception {
		BiobankPanelAssessment biobankpanelassessment = BiobankPanelAssessmentLocalServiceUtil.biobankPanelAssessmentFromRequest(request);
		BiobankPanelAssessmentLocalServiceUtil.addBiobankPanelAssessment(biobankpanelassessment);
	}

}
