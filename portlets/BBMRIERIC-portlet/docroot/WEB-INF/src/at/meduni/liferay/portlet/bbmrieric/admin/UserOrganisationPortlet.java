package at.meduni.liferay.portlet.bbmrieric.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.ContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UserOrganisationPortlet
 */
public class UserOrganisationPortlet extends MVCPortlet {
	public void sendUserEmailForOrganisations(ActionRequest request, ActionResponse response) throws Exception {
		try {
			//Session session = connectMailserver();
			String subject = ParamUtil.getString(request, "subject");
			String mailbody = ParamUtil.getString(request, "subject");

			Integer numberoforganisations = ParamUtil.getInteger(request, "numberoforganisations");
			for(int i = 0; i < numberoforganisations; i++) {
				if(ParamUtil.getBoolean(request, "mail_" + i)) {
					sendUserEmailForOrganisation(ParamUtil.getLong(request, "organisationmail_" + i), subject, mailbody);
				}
			}
		} catch (Exception e) {
			System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisations");
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
	
	private void sendUserEmailForOrganisation(long groupid, String subject, String mailbody) {
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupid);
			List<User> users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
			if(users.size() == 0) {
				users = UserLocalServiceUtil.getOrganizationUsers(group.getOrganizationId());
				for(User user : users) {
					sendEmail(user, subject, mailbody);
				}
			}
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			System.out.println("UserOrganisationPortlet::sendUserEmailForOrganisation");
			e.printStackTrace();
		} 
	}
	
	private void sendEmail(User user, String subject, String mailbody) {  
		try {
			InternetAddress from = new InternetAddress("contact@bbmri-eric.eu", "BBMRI-ERIC Contact");
			   
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(from);
			mailMessage.setBody(mailbody);
			mailMessage.setSubject(subject);
			mailMessage.setTo(new InternetAddress(user.getEmailAddress(), user.getFullName()));
			MailServiceUtil.sendEmail(mailMessage);
		} catch(UnsupportedEncodingException e) {
			System.out.println("UserOrganisationPortlet::sendEmail");
			e.printStackTrace();
		}

	}
	
	private void sendEmaila(Session session, User user, String subject, String mailbody) {
		try {
			Message msg = new MimeMessage(session);
			msg.addRecipient(Message.RecipientType.TO,
			             new InternetAddress(user.getEmailAddress(), user.getFullName()));        
	        msg.setSubject(subject);        
	        msg.setText(mailbody);
	        Transport.send(msg);
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("UserOrganisationPortlet::sendEmail");
			e.printStackTrace();
		} 
	}
	
	private Session connectMailserver() {
		final String username = "robert.reihs@bbmri-eric.eu";
		final String password = "gizmo123$";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.host", "mail.acpcloud.de");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		return session;
	}
	
	public void resetUserPasswordForOrganisations(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Integer numberoforganisations = ParamUtil.getInteger(request, "numberoforganisations");
			String passwordreset = ParamUtil.getString(request, "passwordreset");
			boolean passwordresetneeded = ParamUtil.getBoolean(request, "passwordresetneeded");
			boolean silentreset = ParamUtil.getBoolean(request, "silentreset");
			for(int i = 0; i < numberoforganisations; i++) {
				if(ParamUtil.getBoolean(request, "changepwd_" + i)) {
					resetUserPasswordForOrganisation(ParamUtil.getLong(request, "organisation_" + i), passwordreset, passwordresetneeded, silentreset);
				}
			}
		} catch (Exception e) {
			System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisations");
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
	
	private void resetUserPasswordForOrganisation(long organisation_id, String password, boolean passwordreset, boolean silentchange) {
		try {
			silentchange = true;
			Group group = GroupLocalServiceUtil.getGroup(organisation_id);
			List<User> users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
			if(users.size() == 0) {
				users = UserLocalServiceUtil.getOrganizationUsers(group.getOrganizationId());
			}
			//System.out.println(group.getDescriptiveName() + " - Number of Organisation Users: " + users.size());
			for(User user : users) {
				System.out.println(user.getFullName());
				List<UserGroup> usergroups = user.getUserGroups();
				boolean change = true;
				for(UserGroup usergroup : usergroups) {
					if(usergroup.getName().equalsIgnoreCase("BBMRI-ERIC CEMO Test Group")) {
						change = false;
					}
					if(usergroup.getName().equalsIgnoreCase("BBMRI-ERIC CEMO Personal")) {
						change = false;
					}
					if(usergroup.getName().equalsIgnoreCase("BBMRI-ERIC CEMO Management")) {
						change = false;
					}
					if(usergroup.getName().equalsIgnoreCase("BBMRI-ERIC CEMO ICT Team")) {
						change = false;
					}
					//System.out.println("      " + usergroup.getName());
				}
				if(change) {
					UserLocalServiceUtil.updatePassword(user.getUserId(), password, password, passwordreset, silentchange);
				}
			}
		} catch (SystemException | PortalException e) {
			System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisation");
			e.printStackTrace();
		} 
	}

}
