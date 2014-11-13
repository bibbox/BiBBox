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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.security.RandomUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
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
	 * Update a Invitation
	 */
	public void updateInvitation(ActionRequest request, ActionResponse response) throws Exception {
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation = InvitationLocalServiceUtil.invitationFromRequest(request);
		if(invitation.getStatus() < InvitationLocalServiceUtil.getStatusFromString("saved")) {
			invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("saved"));
		}
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
		if(invitation.getStatus() < InvitationLocalServiceUtil.getStatusFromString("simulated")) {
			invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("simulated"));
		}
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
		String organizationrejectpath = "/reject?invitation="+invitation.getInvitationId()+"&securitylinktoken=" + createSecurityToken(10);//replace with OrganisationInvitationId for organizationselection
		//replacing Strings
		String mailSubject = replaceTagsInString(invitation.getSubject(), true, themeDisplay, themeDisplay.getUser(), organizationpath, organizationrejectpath, "organization name", createSecurityToken(5));
		String mailBody = replaceTagsInString(invitation.getBody(), true, themeDisplay, themeDisplay.getUser(), organizationpath, organizationrejectpath, "organization name", createSecurityToken(5));
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
		long maincontact_role = ParamUtil.getLong(request, "optionsMainContactRole_option");
		// Save the invitation
		if(invitation.getStatus() < InvitationLocalServiceUtil.getStatusFromString("send")) {
			invitation.setStatus(InvitationLocalServiceUtil.getStatusFromString("send"));
		}
		invitation.setInvitationsend(new Date());
		boolean createinvitation = ParamUtil.getBoolean(request, "cmd");
		if(createinvitation) {
			InvitationLocalServiceUtil.addInvitation(invitation);
		} else {
			InvitationLocalServiceUtil.updateInvitation(invitation);
		}
		// Load Organizations
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		for(InvitationOrganisation invitationorganisation : InvitationOrganisationLocalServiceUtil.getOrganisationByInvitation(invitation.getInvitationId())) {
			try {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
				User maincontact = getEmailFromMaincontact(organization, maincontact_role);
				
				// prepare for replacing
				String organizationfriendlyurl = getOrganisationFriendlyLink(organization);
				String organizationpath = organizationfriendlyurl + "?invitation="+invitationorganisation.getInvitationOrganisationId();//replace with OrganisationInvitationId for organizationselection
				String securitylinktoken = createSecurityToken(10);
				String securitytoken = createSecurityToken(5);
				String organizationrejectpath = "/reject?invitation="+invitationorganisation.getInvitationOrganisationId()+"&securitylinktoken=" + securitylinktoken;//replace with OrganisationInvitationId for organizationselection
				//replacing Strings
				String mailSubject = replaceTagsInString(invitation.getSubject(), true, themeDisplay, maincontact, organizationpath, organizationrejectpath, organization.getName(), securitytoken);
				String mailBody = replaceTagsInString(invitation.getBody(), true, themeDisplay, maincontact, organizationpath, organizationrejectpath, organization.getName(), securitytoken);
				sendEmail(maincontact.getEmailAddress(), mailSubject, mailBody);
				invitationorganisation.setSecuritylinktoken(Long.parseLong(securitylinktoken));
				invitationorganisation.setSecuritytoken(Long.parseLong(securitytoken));
				InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(invitationorganisation);
			} catch(Exception e) {
				System.err.println("Ivitation::sendInvitation");
				e.printStackTrace();
			}
		}
		// Redirect
		sendRedirect(request, response);
	}
	
	private String getOrganisationFriendlyLink(Organization organization) {
		String organisationlink = organization.getGroup().getFriendlyURL();
		String orgPath = "";
		try {
			List<DDLRecordSet> recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet recordset : recordlist) {
				String recordsetname = String.valueOf(recordset.getNameCurrentValue());
				if(recordsetname.equals("core")) { 
					List<DDLRecord> records = recordset.getRecords();
		  			for(DDLRecord record : records) {
		  				if(record.getFieldValue("Radio2493") != null) {
		  					String type = record.getFieldValue("Radio2493").toString();
				  			if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
				  				orgPath = "/bb_home";
				  			} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
				  				orgPath = "/home";
				  			} else {
				  				orgPath = "/bb_home";
				  			}
		  				}
		  			}
				}
			}
			organisationlink += orgPath;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return organisationlink;
	}

	private User getEmailFromMaincontact(Organization organization, long maincontact_role) {
		User maincontact = null;
		try {
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == maincontact_role) {
						maincontact =  user_mc;
					}
				}
			}
		} catch(Exception e) {
			System.err.println("Ivitation::getEmailFromMaincontact");
			e.printStackTrace();
		}
		return maincontact;
	}

	/**
	 * Replace Body Naming
	 *
	 */
	private String replaceTagsInString(String string, boolean simulate, ThemeDisplay themedisplay, User maincontact, String organizationpath, String organization_reject_path, String organization_name, String securitytoken) {
		// replace [$TO_NAME$]
		string = string.replaceAll("\\[\\$TO_NAME\\$\\]", maincontact.getFullName());
		// replace [$ORGANIZATION_NAME$]
		string = string.replaceAll("\\[\\$ORGANIZATION_NAME\\$\\]", organization_name);
		// replace [$url$]
		String organization_link = "<a href =\"" + themedisplay.getURLPortal()+"/web"+organizationpath + "\">" + themedisplay.getURLPortal()+"/web"+organizationpath + "</a>";
		string = string.replaceAll("\\[\\$URL\\$\\]", organization_link);
		// replace [$REJECT_URL$]
		String organization_reject_link = "<a href =\"" + themedisplay.getURLPortal()+organization_reject_path + "\">" + themedisplay.getURLPortal()+organization_reject_path + "</a>";
		string = string.replaceAll("\\[\\$REJECT_URL\\$\\]", organization_reject_link + " - Security Code: " + securitytoken);
		// replace [$CREDENTIALS$]
		String account_login_text = "<br><br>Your <b>user ID</b> is: <i>" + maincontact.getEmailAddress() + "</i><br>";
		if(maincontact.getLastLoginDate() == null) {
			account_login_text += "Your <b>password</b> is: <i>rd-connect2014</i><br><br>";
			String password = "rd-connect2014";
			boolean passwordreset = true;
			boolean silentchange = true;
			try {
				UserLocalServiceUtil.updatePassword(maincontact.getUserId(), password, password, passwordreset, silentchange);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			account_login_text += "If you have forgotten your password please use the \"Forgot Password\" link.<br>";
		}
		string = string.replaceAll("\\[\\$CREDENTIALS\\$\\]", account_login_text);
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
        String senderMailAddress="catalogue@rd-connect.eu";
        String receiverMailAddress=email;
        try {
        	MailMessage mailMessage=new MailMessage();
        	mailMessage.setHTMLFormat(true);
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
	private String createSecurityToken(int count) {
		String returnstring = "";
		for(int i : RandomUtil.nextInts(10, count)) {
			returnstring += i;
		}
		return returnstring;
	}
}
