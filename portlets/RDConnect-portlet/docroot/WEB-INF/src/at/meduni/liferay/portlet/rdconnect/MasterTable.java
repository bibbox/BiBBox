package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
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
		MasterCandidate master = MasterCandidateLocalServiceUtil
				.getMasterCandidate(ParamUtil.getLong(request,
						"masterCandidateId"));
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
		return master;
	}

	public void deletePatient(ActionRequest request, ActionResponse response) throws Exception {
		long masterId = ParamUtil.getLong(request,"masterId");
		MasterCandidateLocalServiceUtil.deleteMasterCandidate(masterId);
		/* Placeholder for SessionMessages */
		sendRedirect(request, response);
	}

}
