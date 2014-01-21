package at.meduni.liferay.portlet.rdconnect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CandidatePropose
 */
public class CandidatePropose extends MVCPortlet {
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception e) {
			//log.error(e);
		}
	}
	
	public void addCandidate(ActionRequest request, ActionResponse response) throws Exception {		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean recaptcher = false;
		if(themeDisplay.isSignedIn()) {
			recaptcher = true;
		} else {
			ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		    reCaptcha.setPrivateKey("6LdHqekSAAAAAD23pmQUF_9scOyhkYwJg2ldL3FK");//"<font color=red>your_private_key</font>");
		    String challenge = request.getParameter("recaptcha_challenge_field");
		    String uresponse = request.getParameter("recaptcha_response_field");
		    
		    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer("", challenge, uresponse);
		    
		    if (reCaptchaResponse.isValid()) {
		    	recaptcher = true;
		    } else {
		    	recaptcher = false;
		    	SessionErrors.add(request, "recaptcha-required");
		    }
		}

		Candidate candidate = candidateFromRequest(request);
		//MasterCandidate mastercandidate = masterCandidateFromRequest(request);
		ArrayList<String> errors = new ArrayList<String>();
		if(validateCandidate(candidate, errors) && recaptcher) {
			System.out.println(candidate.getState());
			CandidateLocalServiceUtil.addCandidate(candidate);
			//MasterCandidateLocalServiceUtil.addMasterCandidate(mastercandidate);
			SessionMessages.add(request, "candidate-saved-successfully");
			//response.setRenderParameter("success", "true");
			sendRedirect(request, response);
		} else {
			SessionErrors.add(request, "fields-required");
			for(String e : errors) {
				SessionErrors.add(request, e);
			}
			response.setRenderParameter("success", "false");
		}
		
		//sendRedirect(request, response);
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
	private MasterCandidate masterCandidateFromRequest(PortletRequest request) {
		MasterCandidateImpl candidate = new MasterCandidateImpl();
		candidate.setName(ParamUtil.getString(request, "name"));
		candidate.setUrl(ParamUtil.getString(request, "url"));
		candidate.setContactperson(ParamUtil.getString(request, "contactperson"));
		candidate.setCandidatetype(ParamUtil.getString(request, "candidatetype"));
		candidate.setCountry(ParamUtil.getString(request, "country"));
		candidate.setDiseasescodes(ParamUtil.getString(request, "diseasescodes"));
		candidate.setDiseasesfreetext(ParamUtil.getString(request, "diseasesfreetext"));
		candidate.setComment(ParamUtil.getString(request, "comment"));
		candidate.setAddress(ParamUtil.getString(request, "address"));
		candidate.setMail(ParamUtil.getString(request, "mail"));
		candidate.setHead(ParamUtil.getString(request, "head"));
		candidate.setState("0");
		return candidate;
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
		candidate.setState("0");
		return candidate;
	}
	
	private static boolean validateCandidate(Candidate candidate, List errors) {
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

}
