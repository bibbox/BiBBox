package at.meduni.liferay.portlet.bbmrieric.idcard;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankLister
 */
public class BiobankLister extends MVCPortlet {
 
	public void filterList(ActionRequest request, ActionResponse response) throws Exception {
		response.setRenderParameter("SEARCH", ParamUtil.getString(request, "SEARCH"));
		response.setRenderParameter("candidatetype", ParamUtil.getString(request, "candidatetype"));
		response.setRenderParameter("country", ParamUtil.getString(request, "country"));
		response.setRenderParameter("materialtype", ParamUtil.getString(request, "materialtype"));
		response.setRenderParameter("diagnosisavailable", ParamUtil.getString(request, "diagnosisavailable"));
		response.setRenderParameter("biobanksize", ParamUtil.getString(request, "biobanksize"));
	}

}
