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
		String country = ParamUtil.getString(request, "s2");
		System.out.println(country);
	}
	
	public void search(ActionRequest request, ActionResponse response) throws Exception {
		//String country = ParamUtil.getString(request, "s2");
		System.out.println("!!!!!!!!!!!!!!!!!");
	}

}
