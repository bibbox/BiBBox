package at.graz.meduni.liferay.portlet.bibbox.user;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Invitation
 */
public class Invitation extends MVCPortlet {

	/*
	 * (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			JSONObject json2 = JSONFactoryUtil.createJSONObject();

			json.put("address", "1236 Some Street");
			json.put("name", "John A. Smith");
			json.put("Rating", "5");
			json2.put("datas", json);
			System.out.println(json2.toString());
			resourceResponse.getPortletOutputStream().write(json2.toString().getBytes());
		} catch (IOException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete an Organization from the Invitation
	 */
	public void deleteOrganizationFromInvitation(ActionRequest request, ActionResponse response) throws Exception {
		long organizationId = ParamUtil.getLong(request,"bibbox_cs_organisationid");
		long invitationId = ParamUtil.getLong(request,"bibbox_cs_invitationid");
		InvitationOrganisationLocalServiceUtil.deleteInvitationOrganisation(InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationId, organizationId));
		System.out.println("Delete");
	}

	/**
	 * Update the list of all Organizations in the Invitation
	 */
	public void updateOrganisationForInvitation(ActionRequest request, ActionResponse response) throws Exception {
		long counter = ParamUtil.getLong(request,"bibbox_cs_counter");
		long invitationId = ParamUtil.getLong(request,"bibbox_cs_invitationId");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// Get assigned organizations
		List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getOrganisationByInvitation(invitationId);
		HashSet<Long> existingorganisationids = new HashSet<Long>();
		for(InvitationOrganisation invitationorganisation : invitationorganisations) {
			existingorganisationids.add(invitationorganisation.getOrganisationId());
		}
		for(int i=0; i<counter; i++) {
			if(ParamUtil.getBoolean(request,"bibbox_cs_organisations_" + i)) {
				long request_organisationid = ParamUtil.getLong(request,"bibbox_cs_organisationsid_" + i);
				if(existingorganisationids.contains(request_organisationid)) {
					existingorganisationids.remove(request_organisationid);
				} else {
					InvitationOrganisationImpl invitationOrganisation = new InvitationOrganisationImpl();
					invitationOrganisation.setInvitationOrganisationId(CounterLocalServiceUtil.increment(InvitationOrganisation.class.getName()));
					invitationOrganisation.setInvitationId(invitationId);
					invitationOrganisation.setOrganisationId(request_organisationid);
					invitationOrganisation.setLastchanged(new Date());
					invitationOrganisation.setLastchanger(themeDisplay.getUserId());
					invitationOrganisation.setUserId(ParamUtil.getLong(request,"bibbox_cs_organisationuserid_" + i));
					InvitationOrganisationLocalServiceUtil.addInvitationOrganisation(invitationOrganisation);
				}
			}
			System.out.println(i + " Selected: " + ParamUtil.getLong(request,"bibbox_cs_organisationsid_" + i) + " " + ParamUtil.getBoolean(request,"bibbox_cs_organisations_" + i));
		}
		for(long deleteorganisationid : existingorganisationids) {
			try {
				InvitationOrganisationLocalServiceUtil.deleteInvitationOrganisation(InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationId, deleteorganisationid));
			} catch(Exception e) {
				System.out.println("---------------------------------------------------------------");
				System.out.println("BiBBox Exception in Invitation::updateOrganisationForInvitation");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Create a new Invitation
	 */
	public void addInvitation(ActionRequest request, ActionResponse response) throws Exception {
		
	}
	
	/**
	 * Update the Invitation
	 */
	public void updateInvitation(ActionRequest request, ActionResponse response) throws Exception {
		
	}
	
}
