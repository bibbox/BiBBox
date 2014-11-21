package com.bcnet.portlet.biobank;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.Biobank;
import com.bcnet.portlet.biobank.model.BiobankAttributeLists;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankPortlet
 */
public class BiobankPortlet extends MVCPortlet {
 
	public void addBiobank(ActionRequest request, ActionResponse response) throws Exception{

		_updateBiobank(request);

		sendRedirect(request, response);

	}
	
	public void deleteBiobank(ActionRequest request, ActionResponse response)
			throws Exception {

		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");

		BiobankLocalServiceUtil.deleteBiobank(biobankDbId);

		sendRedirect(request, response);
	}
	
	public void updateBiobank(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateBiobank(request);

		sendRedirect(request, response);
	}
	
	private Biobank _updateBiobank(ActionRequest request) throws PortalException, SystemException{

		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String biobankId = ParamUtil.getString(request, "biobankId");
		String acronym = ParamUtil.getString(request, "acronym");
		String name = ParamUtil.getString(request, "name");
		String url = ParamUtil.getString(request, "url");
		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		String countryCode = ParamUtil.getString(request, "countryCode");
		String description = ParamUtil.getString(request, "description");
		boolean backup = ParamUtil.getBoolean(request, "backup");
		boolean trainingCourses = ParamUtil.getBoolean(request, "trainingCourses");


		Biobank biobank = null;

		if(biobankDbId <= 0){
			biobank = BiobankLocalServiceUtil.addBiobank(biobankId, acronym, name, url, juristicPersonId,
					countryCode, description, backup, trainingCourses);
		}
		else{
			biobank = BiobankLocalServiceUtil.getBiobank(biobankDbId);

			biobank = BiobankLocalServiceUtil.updateBiobank(biobankDbId,
					biobankId, acronym, name, url, juristicPersonId, countryCode, description,
					backup, trainingCourses);
		}

		return biobank;

	}
	
	
	
	
}
