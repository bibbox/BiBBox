package at.graz.meduni.liferay.portlet.bibbox.user;

import java.util.HashSet;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvitationHelpRequest
 */
public class InvitationHelpRequest extends MVCPortlet {
	
	/**
	 * Send help request
	 */
	public void sendHelpRequest(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String mailSubject = ParamUtil.getString(request,"textselection") + ParamUtil.getString(request,"subject");
		String mailBody = ParamUtil.getString(request,"body");
		String emails_request = ParamUtil.getString(request,"email");
		long maincontactrole = ParamUtil.getLong(request,"email");
		boolean sendcompytorequester = ParamUtil.getBoolean(request,"sendcopy");
		System.out.println("====sendMailMessage===");
		HashSet<InternetAddress> emails = new HashSet<InternetAddress>();
		for(String email : emails_request.split(";")) {
			System.out.println("email requester:" + email);
			emails.add(new InternetAddress(email));
		}
		System.out.println("Subject:" + mailSubject);
		System.out.println("Body:" + mailBody);
        String senderMailAddress="catalogue@rd-connect.eu";
        String organiaztioid = ParamUtil.getString(request,"organizationinvitation");
        String receiverMailAddress="";
        if(organiaztioid.equalsIgnoreCase("")) {
        	receiverMailAddress = ParamUtil.getString(request,"requesteremail");
        } else {
        	long invitationorganizationId = ParamUtil.getLong(request,"organizationinvitation");
        	InvitationOrganisation invitationorganisation = InvitationOrganisationLocalServiceUtil.getInvitationOrganisation(invitationorganizationId);
			if(invitationorganisation != null) {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(invitationorganisation.getOrganisationId());
				User user = getEmailFromMaincontact(organization, maincontactrole);
				receiverMailAddress = user.getEmailAddress();
				if(sendcompytorequester) {
					emails.add(new InternetAddress(receiverMailAddress));
				}
			}
        }
        if(!receiverMailAddress.equalsIgnoreCase("")) {
	        try {
	        	MailMessage mailMessage=new MailMessage();
	        	mailMessage.setHTMLFormat(true);
			    mailMessage.setBody(mailBody);
			    mailMessage.setSubject(mailSubject);
			    mailMessage.setFrom(new InternetAddress(senderMailAddress));
			    InternetAddress[] sendto = {};
			    sendto = emails.toArray(sendto);
			    mailMessage.setTo(sendto);
			    mailMessage.setCC(new InternetAddress(receiverMailAddress));
			    mailMessage.setCC(new InternetAddress(senderMailAddress));
		        MailServiceUtil.sendEmail(mailMessage);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        }
	}

	/**
	 * 
	 * @param organization
	 * @param maincontact_role
	 * @return
	 */
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
}
