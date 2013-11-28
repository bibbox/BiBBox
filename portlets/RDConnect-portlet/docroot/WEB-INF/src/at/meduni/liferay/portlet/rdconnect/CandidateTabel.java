package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
	
	/*
	public void clearFilterCandidates(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("clear");
		response.setRenderParameter("action-status", "clear");
		sendRedirect(request, response);
	}*/
	
	/*public void search(ActionRequest request, ActionResponse response) throws Exception {
		//String country = ParamUtil.getString(request, "s2");
		System.out.println("!!!!!!!!!!!!!!!!!");
	}*/

}
