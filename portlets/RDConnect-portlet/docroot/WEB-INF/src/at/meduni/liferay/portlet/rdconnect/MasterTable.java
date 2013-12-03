package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MasterTable
 */
public class MasterTable extends MVCPortlet {
	public void filterCandidates(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("filter");
		response.setRenderParameter("action-status", "filter");
	}

}
