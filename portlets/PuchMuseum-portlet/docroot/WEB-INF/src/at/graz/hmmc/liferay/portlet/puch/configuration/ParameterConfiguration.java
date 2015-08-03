package at.graz.hmmc.liferay.portlet.puch.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ParameterConfiguration
 */
public class ParameterConfiguration extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addParameterConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			System.out.println(ParamUtil.getString(request, "scope") + " - " + ParamUtil.getString(request, "optionkey") + " - " + ParamUtil.getString(request, "optionvalue"));
			
			at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration configuration = ParameterConfigurationLocalServiceUtil.parameterConfigurationFromRequest(request);
			ParameterConfigurationLocalServiceUtil.addParameterConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterConfiguration::addConfiguration] Error adding Configuration.");
			ex.printStackTrace();
		}
	}
	
	public void updateParameterConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration configuration = ParameterConfigurationLocalServiceUtil.parameterConfigurationFromRequest(request);
			ParameterConfigurationLocalServiceUtil.updateParameterConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterConfiguration::updateConfiguration] Error updating Configuration.");
			ex.printStackTrace();
		}
	}
	
	public void deleteParameterConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long parameterconfigurationId = ParamUtil.getLong(request, "parameterconfigurationId");
			at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration configuration = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(parameterconfigurationId);
			
			ParameterConfigurationLocalServiceUtil.deleteParameterConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterConfiguration::deleteConfiguration] Error deleting Configuration.");
			ex.printStackTrace();
		}
	}

}
