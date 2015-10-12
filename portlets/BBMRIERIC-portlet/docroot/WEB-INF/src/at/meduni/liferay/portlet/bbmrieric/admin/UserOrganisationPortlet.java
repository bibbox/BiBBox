package at.meduni.liferay.portlet.bbmrieric.admin;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
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
			List<String> emails = new ArrayList();
			String subject = ParamUtil.getString(request, "subject");
			String mailbody = ParamUtil.getString(request, "mailbody");

			Integer numberoforganisations = ParamUtil.getInteger(request, "numberoforganisations");
			for(int i = 0; i < numberoforganisations; i++) {
				if(ParamUtil.getBoolean(request, "mail_" + i)) {
					List<String> tmp_mail = sendUserEmailForOrganisation(request, ParamUtil.getLong(request, "organisationmail_" + i), subject, mailbody);
					for(String m : tmp_mail) {
						if(!emails.contains(m)) {
							emails.add(m);
						}
					}
				}
			}
			for(String email : emails) {
				sendEmail(request, email, subject, mailbody);
			}
		} catch (Exception e) {
			System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisations");
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
	
	private void sendEmail(ActionRequest request, String email, String mailSubject, String mailBody) {
		System.out.println("====sendMailMessage===");
		System.out.println("email:" + email);
		System.out.println("Subject:" + mailSubject);
		System.out.println("Body:" + mailBody);
        String senderMailAddress="contact@bbmri-eric.eu";
        String receiverMailAddress=email;
        try {
                    MailMessage mailMessage=new MailMessage();
	    mailMessage.setBody(mailBody);
	    mailMessage.setSubject(mailSubject);
	    mailMessage.setFrom(new InternetAddress(senderMailAddress));
	    mailMessage.setTo(new InternetAddress(receiverMailAddress));
        MailServiceUtil.sendEmail(mailMessage);
        SessionMessages.add(request.getPortletSession(),"mail-send-success");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private List<String> sendUserEmailForOrganisation(ActionRequest request, long groupid, String subject, String mailbody) {
		List<String> emails = new ArrayList();
		try {
			// Get the Group
			Group group = GroupLocalServiceUtil.getGroup(groupid);
			// Get first set of Users
			
			List<User> users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
			for(User u : users) {
				if(!emails.contains(u.getEmailAddress())) {
					emails.add(u.getEmailAddress());
				}
			}
			// Get all users from usergroups
			List<UserGroup> usergroups = UserGroupLocalServiceUtil.getGroupUserGroups(group.getGroupId());
			for(UserGroup g : usergroups) {
				List<User> tmpuserlist = UserLocalServiceUtil.getUserGroupUsers(g.getUserGroupId());
				for(User u : tmpuserlist) {
					if(!emails.contains(u.getEmailAddress())) {
						emails.add(u.getEmailAddress());
					}
				}
			}
			List<User> tmpuserlist = UserLocalServiceUtil.getOrganizationUsers(group.getOrganizationId());
			for(User u : tmpuserlist) {
				if(!emails.contains(u.getEmailAddress())) {
					emails.add(u.getEmailAddress());
				}
			}

			
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			System.out.println("UserOrganisationPortlet::sendUserEmailForOrganisation");
			e.printStackTrace();
		} 
		return emails;
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
			// Get the Group
			Group group = GroupLocalServiceUtil.getGroup(organisation_id);
			// Get first set of Users
			List<User> users = UserLocalServiceUtil.getGroupUsers(group.getGroupId());
			changePasswordForUser(users, organisation_id, password, passwordreset, silentchange);
			// Get all users from usergroups
			List<UserGroup> tmpusergroups = UserGroupLocalServiceUtil.getGroupUserGroups(group.getGroupId());
			for(UserGroup g : tmpusergroups) {
				users = UserLocalServiceUtil.getUserGroupUsers(g.getUserGroupId());
				changePasswordForUser(users, organisation_id, password, passwordreset, silentchange);
			}
			List<User> tmpuserlist = UserLocalServiceUtil.getOrganizationUsers(group.getOrganizationId());
			changePasswordForUser(users, organisation_id, password, passwordreset, silentchange);
			
		} catch (SystemException | PortalException e) {
			System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisation");
			e.printStackTrace();
		} 
	}
	
	private void changePasswordForUser(List<User> users, long organisation_id, String password, boolean passwordreset, boolean silentchange) {
		//System.out.println(group.getDescriptiveName() + " - Number of Organisation Users: " + users.size());
		for(User user : users) {
			try {
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
				
					System.out.println("Change password for:" + user.getFullName());
					UserLocalServiceUtil.updatePassword(user.getUserId(), password, password, passwordreset, silentchange);
				
				}
			} catch (SystemException | PortalException e) {
				System.out.println("UserOrganisationPortlet::resetUserPasswordForOrganisation-password Change failed");
				e.printStackTrace();
			} 
		}
	}

}
