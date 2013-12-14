package at.meduni.liferay.portlet.rdconnect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

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
		long candidateid = 0;
		boolean accepted = false;
		long masterid = 0;
		
		candidateid = ParamUtil.getLong(request, "candidateid");
		masterid = ParamUtil.getLong(request, "masterid");
		accepted = ParamUtil.getBoolean(request, "accepted");
		
		if(candidateid != 0) {
			System.out.println("CandidateID: " + candidateid + " MasterID: " + masterid + " Accepted: " + accepted);
			CandidateLocalServiceUtil.updateCandidate(candidateid, accepted, masterid);
			MasterCandidate master = MasterCandidateLocalServiceUtil.getMasterCandidate(candidateid);
			if(master.getAccepted() != accepted || master.getJoinId() != masterid) {
				master.setAccepted(accepted);
				master.setJoinId(masterid);
				MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
			}
		}
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
