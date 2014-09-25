package at.graz.meduni.liferay.portlet.bibbox.user;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation = InvitationLocalServiceUtil.invitationFromRequest(request);
		invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("saved"));
		InvitationLocalServiceUtil.addInvitation(invitation);
		
		sendRedirect(request, response);
	}
	
	/**
	 * Update a new Invitation
	 */
	public void updateInvitation(ActionRequest request, ActionResponse response) throws Exception {
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation = InvitationLocalServiceUtil.invitationFromRequest(request);
		invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("saved"));
		InvitationLocalServiceUtil.updateInvitation(invitation);
		
		sendRedirect(request, response);
	}
	
	/**
	 * Deletes a invitation from the database.
	 *
	 */
	public void deleteInvitation(ActionRequest request, ActionResponse response)
		throws Exception {
		long invitationId = ParamUtil.getLong(request, "invitationId");
		List<InvitationOrganisation> invitationorganisations = InvitationOrganisationLocalServiceUtil.getOrganisationByInvitation(invitationId);
		for(InvitationOrganisation invitationorganisation : invitationorganisations) {
			InvitationOrganisationLocalServiceUtil.deleteInvitationOrganisation(invitationorganisation);
		}
		InvitationLocalServiceUtil.deleteInvitation(invitationId);
		sendRedirect(request, response);
	}
	
	/**
	 * Simulate Invitation send email
	 *
	 */
	public void simulateInvitation(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Simulate Invitation");
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation = InvitationLocalServiceUtil.invitationFromRequest(request);
		// Save the invitation
		invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("simulated"));
		boolean createinvitation = ParamUtil.getBoolean(request, "cmd");
		if(createinvitation) {
			InvitationLocalServiceUtil.addInvitation(invitation);
		} else {
			InvitationLocalServiceUtil.updateInvitation(invitation);
		}
		// Send the Simulation Mails
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String email = themeDisplay.getUser().getEmailAddress();
		// prepare for replacing
		String organizationfriendlyurl = "";
		String organizationpath = organizationfriendlyurl + "?invitation="+invitation.getInvitationId();//replace with OrganisationInvitationId for organizationselection
		String securitylinktoken = "";
		String securitytoken = "";
		String organizationrejectpath = organizationfriendlyurl + "?invitation="+invitation.getInvitationId()+"&securitylinktoken=";//replace with OrganisationInvitationId for organizationselection
		//replacing Strings
		String mailSubject = replaceTagsInString(invitation.getSubject(), true, themeDisplay,organizationpath);
		String mailBody = replaceTagsInString(invitation.getBody(), true, themeDisplay,organizationpath);
		sendEmail(email, mailSubject, mailBody);
		// Redirect
		sendRedirect(request, response);
	}
	
	/**
	 * Send Invitation send email
	 *
	 */
	public void sendInvitation(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Send Invitation");
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation = InvitationLocalServiceUtil.invitationFromRequest(request);
		// Save the invitation
		invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("send"));
		boolean createinvitation = ParamUtil.getBoolean(request, "cmd");
		if(createinvitation) {
			InvitationLocalServiceUtil.addInvitation(invitation);
		} else {
			InvitationLocalServiceUtil.updateInvitation(invitation);
		}
		// Redirect
		sendRedirect(request, response);
	}
	
	/**
	 * Replace Body Naming
	 *
	 */
	private String replaceTagsInString(String string, boolean simulate, ThemeDisplay themedisplay, String organizationpath) {
		// replace [$TO_NAME$]
		if(simulate) {
			string = string.replaceAll("\\[\\$TO_NAME\\$\\]", themedisplay.getUser().getFullName());
		} else {
			//TODO: replace the name for the invitation send.
		}
		// replace [$url$]
		String organisation_link = themedisplay.getURLPortal()+"/web"+organizationpath;
		string = string.replaceAll("\\[\\$url\\$\\]", themedisplay.getUser().getFullName());
		return string;
	}
	
	/**
	 * Sending email to specified user
	 */
	private void sendEmail(String email, String mailSubject, String mailBody) {
		System.out.println("====sendMailMessage===");
		System.out.println("email:" + email);
		System.out.println("Subject:" + mailSubject);
		System.out.println("Body:" + mailBody);
        String senderMailAddress="robert.reihs@medunigraz.at";
        String receiverMailAddress=email;
        try {
        	MailMessage mailMessage=new MailMessage();
		    mailMessage.setBody(mailBody);
		    mailMessage.setSubject(mailSubject);
		    mailMessage.setFrom(new InternetAddress(senderMailAddress));
		    mailMessage.setTo(new InternetAddress(receiverMailAddress));
	        MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Create Security Token
	 */
	private String createSecurityToken() {
		return "";
	}
}
