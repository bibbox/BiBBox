package at.meduni.liferay.portlet.rdconnect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CandidateTabel
 */
public class CandidateTabel extends MVCPortlet {
	public void filterCandidates(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("filter");
		response.setRenderParameter("action-status", "filter");
	}
	
	public void updateCandidateTableData(ActionRequest request, ActionResponse response) throws Exception {
		//System.out.println("Source: " + ParamUtil.getString(request, "source"));
		
		long candidateid = 0;
		boolean accepted = false;
		long masterid = 0;
		
		candidateid = ParamUtil.getLong(request, "candidateid");
		masterid = ParamUtil.getLong(request, "masterid");
		accepted = ParamUtil.getBoolean(request, "accepted");
		/*String source = ParamUtil.getString(request, "source");
		candidateid = getCandidateidFromHtml(source);
		masterid = getMasteridFromHtml(source);
		accepted = getAcceptedFromHtml(source);*/
		
		if(candidateid != 0) {
			//System.out.println("Update");
			System.out.println("CandidateID: " + candidateid + " MasterID: " + masterid + " Accepted: " + accepted);
			CandidateLocalServiceUtil.updateCandidate(candidateid, accepted, masterid);
		}
		
		System.out.println("Somthing has happend");
	}
	
	private boolean getAcceptedFromHtml(String source) {
		boolean accepted = false;
		String pattern = "<input.*?name=\"accepted\".*?checked.*?>";
		Pattern pattern_compiled = Pattern.compile(pattern);
		Matcher matcher = pattern_compiled.matcher(source);
		while (matcher.find()) {
			System.out.println(matcher.group());
			return true;
		}
		return accepted;
	}
	
	private long getMasteridFromHtml(String source) {
		long masterid = 0;
		String pattern = "<input.*?name=\"masterId\".*?value=\"([\\d]*)\".*?>";
		Pattern pattern_compiled = Pattern.compile(pattern);
		Matcher matcher = pattern_compiled.matcher(source);
		while (matcher.find()) {
			try{
				System.out.println("Masterid:" + matcher.group(1));
				masterid = Long.parseLong(matcher.group(1));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return masterid;
	}
	
	private long getCandidateidFromHtml(String source) {
		long candidateid = 0;
		String pattern = "<input.*?name=\"candidateId\".*?value=\"([\\d]*)\".*?>";
		Pattern pattern_compiled = Pattern.compile(pattern);
		Matcher matcher = pattern_compiled.matcher(source);
		while (matcher.find()) {
			try{
				System.out.println("Candidateid:" + matcher.group(1));
				candidateid = Long.parseLong(matcher.group(1));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return candidateid;
	}
	
	public void updateCandidateToMaster(ActionRequest request, ActionResponse response) throws Exception {
		long candidateId = ParamUtil.getLong(request, "candidateId");
		System.out.println("candidateId: " + candidateId);
		System.out.println(ParamUtil.getBoolean(request, "accepted"));
		if(candidateId == 0) {
			System.out.println("RETURN");
			return;
		} else {
			System.out.println("update");
			CandidateLocalServiceUtil.updateCandidate(candidateId, ParamUtil.getBoolean(request, "accepted"), ParamUtil.getLong(request, "masterId"));
		}		
	}
}
