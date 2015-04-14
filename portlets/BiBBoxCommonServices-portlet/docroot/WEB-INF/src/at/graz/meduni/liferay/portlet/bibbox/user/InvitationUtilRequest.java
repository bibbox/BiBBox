package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
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
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			String shorttext = "";
			String longtext = "";
			String link = "";
			String restricted = "RD-Connect CURATOR";
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

			eventtitle = "Biobank requesed a pannel assessment: " + organization.getName();
			link = link + "/bb_home";
			shorttext = "Biobank "+ organization.getName() + " from " + country + " requesed a pannel assessment.";
			longtext = "";
			
			RDConnectEventLocalServiceUtil.createEvent(eventtitle, new Date(), organizationId, themeDisplay.getUserId(), shorttext, longtext, link, restricted);
		} catch(Exception ex) {
			System.out.println("InvitationUtilRequest::sendRequest->Add Event");
		}
	}
}
