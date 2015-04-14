package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationUtilOrganizationStatusList
 */
public class InvitationUtilOrganizationStatusList extends MVCPortlet {
	/**
	 * Add Assessment
	 */
	public void createAssessment(ActionRequest request, ActionResponse response) throws Exception {
		BiobankPanelAssessment biobankpanelassessment = BiobankPanelAssessmentLocalServiceUtil.biobankPanelAssessmentFromRequest(request);
		BiobankPanelAssessmentLocalServiceUtil.addBiobankPanelAssessment(biobankpanelassessment);
		sendRedirect(request, response);
	}
	
	/**
	 * Update Assessment
	 */
	public void updateAssessment(ActionRequest request, ActionResponse response) throws Exception {
		BiobankPanelAssessment biobankpanelassessment = BiobankPanelAssessmentLocalServiceUtil.biobankPanelAssessmentFromRequest(request);
		BiobankPanelAssessmentLocalServiceUtil.updateBiobankPanelAssessment(biobankpanelassessment);
		sendRedirect(request, response);
	}

	/**
	 * Publish Biobank and update invitation status
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void publishBiobank(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long organizationId = ParamUtil.getLong(request, "organizationId");
		long invitationorganisationId = ParamUtil.getLong(request, "invitationorganisationId");
		long invitationId = ParamUtil.getLong(request, "invitationId");
		long movetoId = ParamUtil.getLong(request, "movetoId");
		long setstatusId = ParamUtil.getLong(request, "setstatusId");
		Organization organization = null;
		try {
			organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			organization.setParentOrganizationId(movetoId);
			OrganizationLocalServiceUtil.updateOrganization(organization);
		} catch(Exception ex) {
			System.out.println("ERROR: InvitationUtilOrganizationStatusList::publishBiobank->Organization move");
			ex.printStackTrace();
		}
		try {
			InvitationOrganisation invitationorganisation = InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationorganisationId);
			invitationorganisation.setStatus(setstatusId);
			invitationorganisation.setStatusdate(new Date());
			InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(invitationorganisation);
		} catch(Exception ex) {
			System.out.println("ERROR: InvitationUtilOrganizationStatusList::publishBiobank->Update InvitationOrganization");
			ex.printStackTrace();
		}
		try {
			Invitation invitation = InvitationLocalServiceUtil.getInvitation(invitationId);
			invitation.setStatus(setstatusId);
			InvitationLocalServiceUtil.updateInvitation(invitation);
		} catch(Exception ex) {
			System.out.println("ERROR: InvitationUtilOrganizationStatusList::publishBiobank->Update Invitation");
			ex.printStackTrace();
		}
		try {
			String shorttext = "";
			String longtext = "";
			String link = "";
			String restricted = "";
			String eventtitle = "";
			
			String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
			String country = "-";
		  	
		  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		
		  		if(rdc_rsname.equals("core")) {  		
			  		List<DDLRecord> records = rdc_rs.getRecords();
			  		for(DDLRecord record : records) {
			  			if(record.getFieldValue("countryCode") != null) {
			  				country = record.getFieldValue("countryCode").toString();
			  			}
			  		}
		  		}
		  	}

			eventtitle = "New Biobank Published: " + organization.getName();
			link = link + "/bb_home";
			shorttext = "Biobank "+ organization.getName() + " from " + country + " was published an is now listed in the catalouge.";
			longtext = "";
			
			RDConnectEventLocalServiceUtil.createEvent(eventtitle, new Date(), organizationId, themeDisplay.getUserId(), shorttext, longtext, link, restricted);
		} catch(Exception ex) {
			System.out.println("ERROR: InvitationUtilOrganizationStatusList::publishBiobank->Add Event");
			ex.printStackTrace();
		}
	}
}
