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
		String state = "0";
		long masterid = 0;
		
		candidateid = ParamUtil.getLong(request, "candidateid");
		masterid = ParamUtil.getLong(request, "masterid");
		state = ParamUtil.getString(request, "state");
		
		System.out.println("State b if: " + state);
		
		if(!state.equalsIgnoreCase("x") &&  !state.equalsIgnoreCase("0") &&
				!state.equalsIgnoreCase("1") && !state.equalsIgnoreCase("2") &&
				!state.equalsIgnoreCase("3") && !state.equalsIgnoreCase("4") &&
				!state.equalsIgnoreCase("5") && !state.equalsIgnoreCase("P")) {
			System.out.println("if");
			state = "0";
		}
		
		if(candidateid != 0) {
			System.out.println("CandidateID: " + candidateid + " MasterID: " + masterid + " State: " + state);
			CandidateLocalServiceUtil.updateCandidate(candidateid, state.toUpperCase(), masterid);
			MasterCandidate master = MasterCandidateLocalServiceUtil.getMasterCandidate(candidateid);
			master.setState(state.toUpperCase());
			master.setJoinId(masterid);
			MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
		}
	}
	
	/*
	public void updateCandidateToMaster(ActionRequest request, ActionResponse response) throws Exception {
		long candidateId = ParamUtil.getLong(request, "candidateId");
		System.out.println("candidateId: " + candidateId);
		System.out.println(ParamUtil.getString(request, "state"));
		if(candidateId == 0) {
			System.out.println("RETURN");
			return;
		} else {
			System.out.println("update");
			CandidateLocalServiceUtil.updateCandidate(candidateId, ParamUtil.getString(request, "state"), ParamUtil.getLong(request, "masterId"));
		}		
	}*/
}
