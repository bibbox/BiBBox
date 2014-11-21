package com.bcnet.portlet.biobank;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankGeneralInformationPortlet
 */
public class BiobankGeneralInformationPortlet extends MVCPortlet {

	public void updateBiobankGeneralInfomration(ActionRequest request, ActionResponse response) throws Exception{
		
		_updateBiobankGeneralInfomration(request);

		sendRedirect(request, response);
		

	}

	private BiobankGeneralInformation _updateBiobankGeneralInfomration(ActionRequest request) throws PortalException, SystemException {
		// TODO Auto-generated method stub
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
		
		BiobankGeneralInformation biobankGeneralInformation;
		
		try{
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(biobankDbId);
		}
		catch(Exception e){
			biobankGeneralInformation = new BiobankGeneralInformationImpl();
			biobankGeneralInformation.setBiobankDbId(biobankDbId);
		}
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankDbId);
		organization.setName(name);
		OrganizationLocalServiceUtil.updateOrganization(organization);
		
		biobankGeneralInformation.setBiobankId(biobankId);
		biobankGeneralInformation.setAcronym(acronym);
		biobankGeneralInformation.setUrl(url);
		biobankGeneralInformation.setJuristicPersonId(juristicPersonId);
		biobankGeneralInformation.setCountryCode(countryCode);
		biobankGeneralInformation.setDescription(description);
		biobankGeneralInformation.setBackup(backup);
		biobankGeneralInformation.setTrainingCourses(trainingCourses);
		
		return BiobankGeneralInformationLocalServiceUtil.updateBiobankGeneralInformation(biobankGeneralInformation);
		
	}

}
