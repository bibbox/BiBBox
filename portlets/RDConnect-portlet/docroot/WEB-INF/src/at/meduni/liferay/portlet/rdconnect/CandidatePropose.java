package at.meduni.liferay.portlet.rdconnect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;

/**
 * Portlet implementation class CandidatePropose
 */
public class CandidatePropose extends MVCPortlet {
	/*public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception e) {
			//log.error(e);
		}
	}*/
	
	public void addCandidate(ActionRequest request, ActionResponse response) throws Exception {		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean recaptcher = true;
		
		Candidate candidate = candidateFromRequest(request);
		//MasterCandidate mastercandidate = masterCandidateFromRequest(request);
		ArrayList<String> errors = new ArrayList<String>();
		if(validateCandidate(candidate, errors) && recaptcher) {
			System.out.println(candidate.getState());
			CandidateLocalServiceUtil.addCandidate(candidate);
			//MasterCandidateLocalServiceUtil.addMasterCandidate(mastercandidate);
			SessionMessages.add(request, "candidate-saved-successfully");
			String shortdiscription = candidate.getSubmittername() + " proposed the " + candidate.getCandidatetype() + " " + candidate.getName() + " for " + candidate.getCountry() + ".";
			String longdiscription = candidate.getSubmittername() + " proposed the " + candidate.getCandidatetype() + " " + candidate.getName() + " for " + candidate.getCountry() + "."
					+ "<br>" + candidate.getName() + " (" + candidate.getCandidatesubtype() + ")"
					+ "<br>" + candidate.getCandidatetype()
					+ "<br>Contact: <a href=\"" + candidate.getMail() + "\">" + candidate.getContactperson() + "</a>"
					+ "<br>Address: " + candidate.getAddress()
					+ "<br>URL: <a href=\"" + candidate.getUrl() + "\">" + candidate.getUrl() + "</a>";
			addEventEntry(new Date(), 0, themeDisplay.getUserId(), shortdiscription, longdiscription, "", "RD-Connect CURATOR");
			System.out.println("Send Emails");
			sendEmailToProposer(request, candidate);
			sendNotificationToCurators(request, candidate);
			//response.setRenderParameter("success", "true");
			sendRedirect(request, response);
		} else {
			SessionErrors.add(request, "fields-required");
			for(String e : errors) {
				SessionErrors.add(request, e);
			}
			response.setRenderParameter("success", "false");
			//sendRedirect(request, response);
		}
		
		
	}

	private String getCaptchaValueFromSession(PortletSession session) {
        Enumeration<String> atNames = session.getAttributeNames();
        System.out.println("--------");
        while (atNames.hasMoreElements()) {
            String name = atNames.nextElement();
            System.out.println(name);
            if (name.contains("recaptcha_challenge_field")) {
                return (String) session.getAttribute(name);
            }
        }
        System.out.println("--------");
        return null;
    }
	
	private Candidate candidateFromRequest(PortletRequest request) {
		CandidateImpl candidate = new CandidateImpl();
		candidate.setName(ParamUtil.getString(request, "name"));
		candidate.setSource(ParamUtil.getString(request, "source"));
		candidate.setUrl(ParamUtil.getString(request, "url"));
		candidate.setContactperson(ParamUtil.getString(request, "contactperson"));
		candidate.setCandidatetype(ParamUtil.getString(request, "candidatetype"));
		candidate.setSubunitof(ParamUtil.getString(request, "subunit_of"));
		candidate.setCountry(ParamUtil.getString(request, "country"));
		candidate.setDiseasescodes(ParamUtil.getString(request, "diseasescodes"));
		candidate.setDiseasesfreetext(ParamUtil.getString(request, "diseasesfreetext"));
		candidate.setComment(ParamUtil.getString(request, "comment"));
		candidate.setAddress(ParamUtil.getString(request, "address"));
		candidate.setMail(ParamUtil.getString(request, "mail"));
		candidate.setHead(ParamUtil.getString(request, "head"));
		candidate.setSubmittername(ParamUtil.getString(request, "submittername"));
		candidate.setSubmitteremail(ParamUtil.getString(request, "submitteremail"));
		candidate.setValidated(ParamUtil.getBoolean(request, "validated"));
		candidate.setCandidatesubtype(ParamUtil.getString(request, "candidatesubtype"));
		candidate.setState("0");
		return candidate;
	}
	
	private static boolean validateCandidate(Candidate candidate, List<String> errors) {
		boolean valid = true;
		if (Validator.isNull(candidate.getName())) {
			errors.add("candidate-name-required");
			valid = false;
		}
		if (Validator.isNull(candidate.getContactperson())) {
			errors.add("candidate-contact_person-required");
			valid = false;
		}
		if (Validator.isNull(candidate.getSubmittername())) {
			errors.add("candidate-submitter_name-required");
			valid = false;
		}
		if (Validator.isNull(candidate.getMail())) {
			errors.add("candidate-email-required");
			valid = false;
		}
		if (!Validator.isEmailAddress(candidate.getMail())) {
			errors.add("candidate-email-error");
			valid = false;
		}
		if (Validator.isNull(candidate.getSubmitteremail())) {
			errors.add("candidate-submitteremail-required");
			valid = false;
		}
		if (!Validator.isEmailAddress(candidate.getSubmitteremail())) {
			errors.add("candidate-submitteremail-error");
			valid = false;
		}
		return valid;
	}
	
	/**
	 * RD-Connect Event System add event entry
	 */
	private void addEventEntry(Date eventdate, long organizationId, long userId, String shorttext, String longtext, String link, String restricted) {
		RDConnectEventLocalServiceUtil.createEvent("Candidate Propose", eventdate, organizationId, userId, shorttext, longtext, link, restricted);
	}
	
	/**
	 * Send Notification mail to Proposer
	 * 
	 * @param request
	 * @param candidate 
	 */
	private void sendEmailToProposer(ActionRequest request, Candidate candidate) {
		String subject = "RD-Connect ID-Card Proposal #" + candidate.getCandidateId();
		String body = "Dear " + candidate.getSubmittername() + ", <br>";
		body += "Thank you for proposing the " + candidate.getCandidatetype() + ": " + candidate.getName() + " for the RD-Connect Network.<br>";
		body += "We will inform you as soon as our team has processed the proposal. If you have any additional questions, please reply to this ";
		body += "email or use the subject of this email in your response. It makes the tracking of issues easier for us.<br>";
		body += "<br>With best regards,<br>Your RD-Connect Curator Team.";
		sendEmail(candidate.getSubmitteremail(), subject, body);
	}
	
	/**
	 * Send Notification to Curators
	 * 
	 * Send Notification to Curators who have subscribed to the notification settings
	 * 
	 * @param request
	 * @param candidate 
	 */
	private void sendNotificationToCurators(ActionRequest request, Candidate candidate) {
		String subject = "RD-Connect ID-Card Proposal #" + candidate.getCandidateId();
		String body = "Dear Curators, <br>";
		body += "There was a new " + candidate.getCandidatetype() + " proposed to the portal.<br>";
		body += candidate.getSubmittername() + " (" + candidate.getSubmitteremail() + ")<br><br>";
		body += "Name: " + candidate.getName() + "<br>";
		body += "Country: " + candidate.getCountry() + "<br>";
		body += "Head: " + candidate.getHead() + "<br>";
		body += "Contact: " + candidate.getContactperson() + " (" + candidate.getMail() + ")" + "<br>";
		body += "URL: " + candidate.getUrl() + "<br>";
		body += "<br><br>Please use the subject of this email for every contact concerning this Proposal, ";
		body += "and include the catalogue@rd-connect.eu email in the communication.";
		sendEmail("rd-connect.wp2@iss.it", subject, body);
	}
	
	/**
	 * Sending email to specified user and CC to sender email
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
		    mailMessage.setCC(new InternetAddress(senderMailAddress));
	        MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
