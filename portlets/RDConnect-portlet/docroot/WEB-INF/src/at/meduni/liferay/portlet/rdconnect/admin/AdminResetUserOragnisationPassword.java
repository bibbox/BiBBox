package at.meduni.liferay.portlet.rdconnect.admin;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdminResetUserOragnisationPassword
 */
public class AdminResetUserOragnisationPassword extends MVCPortlet {
	public void resetUserPassword(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Integer numberofusers = ParamUtil.getInteger(request, "numberofuseres");
			long organizationId = ParamUtil.getLong(request, "organisationid");
			List<MasterCandidate> masters = MasterCandidateLocalServiceUtil.getFilterdCandidates(organizationId);
			long masterId = 0;
			for(MasterCandidate master : masters) {
				masterId = master.getMasterCandidateId();
			}
			String password = "rdconnect$" + masterId;
			for(int i = 0; i < numberofusers; i++) {
				if(ParamUtil.getBoolean(request, "changeuserpw" + i)) {
					UserLocalServiceUtil.updatePassword(ParamUtil.getLong(request, "changeuserpwuserid" + i), password, password, false, true);
				}
			}
		} catch (Exception e) {
			System.out.println("AdminResetUserOragnisationPassword::resetUserPassword");
			e.printStackTrace();
		}
		sendRedirect(request, response);
	}
}

