package at.meduni.liferay.portlet.bbmrieric.portlet;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class D2Biobank
 */
public class Biobank extends MVCPortlet {
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void addBiobank(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);

		try {
			D2BiobankLocalServiceUtil.addD2Biobank(D2BiobankLocalServiceUtil.d2BiobankFromRequest(request), serviceContext);
			SessionMessages.add(request, "BiobankAdded");
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::addBiobank] Error creating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath", "/html/idcard/biobank/edit_biobank.jsp");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateBiobank(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);
		try {
			at.meduni.liferay.portlet.bbmrieric.model.D2Biobank biobank = D2BiobankLocalServiceUtil.d2BiobankFromRequest(request);
			D2BiobankLocalServiceUtil.updateD2Biobank(biobank, serviceContext);
			SessionMessages.add(request, "BiobankAdded");
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::updateBiobank] Error creating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath", "/html/idcard/biobank/edit_biobank.jsp");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void deleteBiobank (ActionRequest request, ActionResponse response) {
		long biobankId = ParamUtil.getLong(request, "biobankId");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);
			response.setRenderParameter("biobankId", Long.toString(biobankId));
			D2BiobankLocalServiceUtil.deleteD2Biobank(biobankId, serviceContext);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::deleteBiobank] Error deleating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
		}
	}

}
