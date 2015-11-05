package at.meduni.liferay.portlet.bbmrieric.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class D2Biobank
 */
public class D2Biobank extends MVCPortlet {
	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(D2Biobank.class.getName(), request);
		String userName = ParamUtil.getString(request, "name");
		String message = ParamUtil.getString(request, "message");
		
		try {
			
		catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::addD2Biobank] Error creating D2Biobank with (D2Biobank newbiobank, ServiceContext serviceContext).");
			e.printStackTrace();
		}
	}

}
