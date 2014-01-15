package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MasterTable
 */
public class MasterTable extends MVCPortlet {
	public void filterCandidates(ActionRequest request, ActionResponse response)
			throws Exception {
		System.out.println("filter");
		response.setRenderParameter("action-status", "filter");
	}

	public void updateMasterCandidate(ActionRequest request, ActionResponse response) throws Exception {
		long mastercandidateid = ParamUtil.getLong(request, "masterCandidateId");
		MasterCandidate master = MasterCandidateLocalServiceUtil.getMasterCandidate(mastercandidateid);
		String state = "0";
		state = ParamUtil.getString(request, "state");
		if(!state.equalsIgnoreCase("x") &&  !state.equalsIgnoreCase("0") &&
				!state.equalsIgnoreCase("1") && !state.equalsIgnoreCase("2") &&
				!state.equalsIgnoreCase("3") && !state.equalsIgnoreCase("4") &&
				!state.equalsIgnoreCase("5") && !state.equalsIgnoreCase("P")) {
			state = "0";
		}
		if(state.equalsIgnoreCase(ParamUtil.getString(request, "state")) || master.getJoinId() != ParamUtil.getLong(request, "joinId")) {
			Candidate candidate = CandidateLocalServiceUtil.getCandidate(mastercandidateid);
			candidate.setState(state);
			candidate.setMasterId(ParamUtil.getLong(request, "joinId"));
			CandidateLocalServiceUtil.updateCandidate(candidate);
		}
		master = updateMasterCandidateFromRequest(request, master);
		MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
		/* Placeholder for SessionMessages */
		sendRedirect(request, response);
	}

	private MasterCandidate updateMasterCandidateFromRequest(ActionRequest request, MasterCandidate master) {
		master.setName(ParamUtil.getString(request, "name"));
		master.setUrl(ParamUtil.getString(request, "url"));
		master.setContactperson(ParamUtil.getString(request, "contactperson"));
		master.setCandidatetype(ParamUtil.getString(request, "candidatetype"));
		master.setDiseasescodes(ParamUtil.getString(request, "diseasescodes"));
		master.setDiseasesfreetext(ParamUtil.getString(request,
				"diseasesfreetext"));
		master.setComment(ParamUtil.getString(request, "comment"));
		master.setCountry(ParamUtil.getString(request, "country"));
		master.setAddress(ParamUtil.getString(request, "address"));
		master.setMail(ParamUtil.getString(request, "mail"));
		master.setHead(ParamUtil.getString(request, "head"));
		master.setJoinId(ParamUtil.getLong(request, "joinId"));
		String state = "0";
		state = ParamUtil.getString(request, "state");
		if(!state.equalsIgnoreCase("x") &&  !state.equalsIgnoreCase("0") &&
				!state.equalsIgnoreCase("1") && !state.equalsIgnoreCase("2") &&
				!state.equalsIgnoreCase("3") && !state.equalsIgnoreCase("4") &&
				!state.equalsIgnoreCase("5") && !state.equalsIgnoreCase("P")) {
			state = "0";
		}
		master.setState(state.toUpperCase());
		return master;
	}

	public void deletePatient(ActionRequest request, ActionResponse response) throws Exception {
		long masterId = ParamUtil.getLong(request,"masterId");
		MasterCandidateLocalServiceUtil.deleteMasterCandidate(masterId);
		/* Placeholder for SessionMessages */
		sendRedirect(request, response);
	}
	
	public void publishCandidate(ActionRequest request, ActionResponse response) throws Exception {
		long masterid = ParamUtil.getLong(request,"masterId");
		System.out.println("Publish " + masterid);
		MasterCandidate master = MasterCandidateLocalServiceUtil.getMasterCandidate(masterid);
		MasterPublish mp = new MasterPublish();
		mp.publishToGate(request, response, master);
		sendRedirect(request, response);
	}
	
	public void unpublishCandidate(ActionRequest request, ActionResponse response) throws Exception {
		long masterid = ParamUtil.getLong(request,"masterId");
		System.out.println("Unpublish " + masterid);
		MasterCandidate master = MasterCandidateLocalServiceUtil.getMasterCandidate(masterid);
		MasterPublish mp = new MasterPublish();
		mp.deleteOrganisation(master.getOrganisationid());
		master.setOrganisationid(0);
		master.setState("1");
		MasterCandidateLocalServiceUtil.updateMasterCandidate(master);
		sendRedirect(request, response);
	}

}
