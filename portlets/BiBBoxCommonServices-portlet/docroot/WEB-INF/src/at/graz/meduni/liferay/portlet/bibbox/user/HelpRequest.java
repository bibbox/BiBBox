package at.graz.meduni.liferay.portlet.bibbox.user;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class HelpRequest
 */
public class HelpRequest extends MVCPortlet {
 
	/**
	 * Send help request
	 */
	public void sendHelpRequest(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String mailSubject = ParamUtil.getString(request,"subject");
		String mailBody = ParamUtil.getString(request,"body");
		String email = themeDisplay.getUser().getEmailAddress();
		System.out.println("====sendMailMessage===");
		System.out.println("email requester:" + email);
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
		    InternetAddress[] sendto = {new InternetAddress("sabina.gainotti@iss.it"), new InternetAddress("robert.reihs@gmail.com")};
		    mailMessage.setTo(sendto);
		    mailMessage.setCC(new InternetAddress(receiverMailAddress));
		    mailMessage.setCC(new InternetAddress(senderMailAddress));
	        MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
