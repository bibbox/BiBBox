package com.bcnet.portlet.biobank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.JuristicPerson;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class JuristicPersonPortlet
 */
public class JuristicPersonPortlet extends MVCPortlet {

	public void addJuristicPerson(ActionRequest request, ActionResponse response) throws IOException, SystemException, PortalException{

		_updateJuristicPerson(request);

		sendRedirect(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		JuristicPerson juristicPerson = null;
		try {
			juristicPerson = _updateJuristicPerson(resourceRequest);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long juristicPersonId = juristicPerson.getPrimaryKey();
		String name = juristicPerson.getName();
		JSONObject jsonUser = JSONFactoryUtil.createJSONObject();
		jsonUser.put("name", name);
		jsonUser.put("juristicPersonId", juristicPersonId);
		resourceResponse.getPortletOutputStream().write(jsonUser.toString().getBytes());
		

	}
	
	public void updateJuristicPerson(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException{

		_updateJuristicPerson(request);

		sendRedirect(request, response);
	}
	
	public void deleteJuristicPerson(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		
		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		
		JuristicPersonLocalServiceUtil.deleteJuristicPerson(juristicPersonId);
		
		sendRedirect(request, response);
	}

	private JuristicPerson _updateJuristicPerson(ActionRequest request) throws SystemException, PortalException{

		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		String name = ParamUtil.getString(request, "name");
		String url = ParamUtil.getString(request, "url");
		String address = ParamUtil.getString(request, "address");

		JuristicPerson juristicPerson = null;

		if(juristicPersonId <= 0){
			juristicPerson = JuristicPersonLocalServiceUtil.addJusristicPerson(name, url, address);
		}
		else{
			juristicPerson = JuristicPersonLocalServiceUtil.updateJuristicPerson(juristicPersonId, name, url, address);
		}

		return juristicPerson;

	}
	
	private JuristicPerson _updateJuristicPerson(ResourceRequest resourceRequest) throws SystemException, PortalException{

		long juristicPersonId = ParamUtil.getLong(resourceRequest, "juristicPersonId");
		String name = ParamUtil.getString(resourceRequest, "name");
		String url = ParamUtil.getString(resourceRequest, "url");
		String address = ParamUtil.getString(resourceRequest, "address");

		JuristicPerson juristicPerson = null;

		if(juristicPersonId <= 0){
			juristicPerson = JuristicPersonLocalServiceUtil.addJusristicPerson(name, url, address);
		}
		else{
			juristicPerson = JuristicPersonLocalServiceUtil.updateJuristicPerson(juristicPersonId, name, url, address);
		}

		return juristicPerson;

	}

}
