package com.bcnet.portlet.biobank;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankAtrributeListsMaster
 */
public class BiobankAtrributeListsMasterPortlet extends MVCPortlet {

	public void addBiobankAtrributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateBiobankAtrributeListsMaster(request);

		sendRedirect(request, response);
	}

	
	public void updateBiobankAtrributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateBiobankAtrributeListsMaster(request);

		sendRedirect(request, response);
	}
	
	private BiobankAtrributeListsMaster _updateBiobankAtrributeListsMaster(ActionRequest request)
			throws PortalException, SystemException {

		long biobankAtrributeListsMasterId = ParamUtil.getLong(request, "biobankAtrributeListsMasterId");
		String attributeListName = ParamUtil.getString(request, "attributeListName");
		String attributeListValue = ParamUtil.getString(request, "attributeListValue");

		BiobankAtrributeListsMaster biobankAtrributeListsMaster = null;

		if (biobankAtrributeListsMasterId <= 0) {
			biobankAtrributeListsMaster = BiobankAtrributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster(attributeListName, attributeListValue);
		}
		else {
			biobankAtrributeListsMaster = BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMaster(biobankAtrributeListsMasterId);

			biobankAtrributeListsMaster = BiobankAtrributeListsMasterLocalServiceUtil.
					updateBiobankAttributeListsMaster(biobankAtrributeListsMasterId, attributeListName, attributeListValue);
					
		}

		return biobankAtrributeListsMaster;
	}
	
	public void deleteBiobankAtrributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		long biobankAtrributeListsMasterId = ParamUtil.getLong(request, "biobankAtrributeListsMasterId");

		BiobankAtrributeListsMasterLocalServiceUtil.deleteBiobankAtrributeListsMaster(biobankAtrributeListsMasterId);

		sendRedirect(request, response);
	}
}
