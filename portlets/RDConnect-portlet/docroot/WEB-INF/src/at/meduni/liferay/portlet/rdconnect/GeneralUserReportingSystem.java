package at.meduni.liferay.portlet.rdconnect;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GeneralUserReportingSystem
 */
public class GeneralUserReportingSystem extends MVCPortlet {
	
	/**
	 * FilterList for the general list
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void filterList(ActionRequest request, ActionResponse response) throws Exception {
		String keywords = ParamUtil.getString(request, "keywords");
		String candidatetype = ParamUtil.getString(request, "candidatetype");
		response.setRenderParameter("keywords", keywords);
		response.setRenderParameter("candidatetype", candidatetype);
		sendRedirect(request, response);
	}

}
