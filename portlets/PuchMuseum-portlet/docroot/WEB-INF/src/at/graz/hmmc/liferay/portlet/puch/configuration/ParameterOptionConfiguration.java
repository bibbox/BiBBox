package at.graz.hmmc.liferay.portlet.puch.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ParameterOptionConfiguration
 */
public class ParameterOptionConfiguration extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addParameterOptionsConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ParameterOptionsConfiguration parameteroptionsconfiguration = ParameterOptionsConfigurationLocalServiceUtil.parameterOptionsConfigurationFromRequest(request);
			ParameterOptionsConfigurationLocalServiceUtil.addParameterOptionsConfiguration(parameteroptionsconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterOptionConfiguration::addParameterOptionsConfiguration] Error adding ParameterOptionsConfiguration.");
			ex.printStackTrace();
		}
	}
	
	public void updateParameterOptionsConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ParameterOptionsConfiguration parameteroptionsconfiguration = ParameterOptionsConfigurationLocalServiceUtil.parameterOptionsConfigurationFromRequest(request);
			ParameterOptionsConfigurationLocalServiceUtil.updateParameterOptionsConfiguration(parameteroptionsconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterOptionConfiguration::updateParameterOptionsConfiguration] Error updating ParameterOptionsConfiguration.");
			ex.printStackTrace();
		}
	}
	
	public void deleteParameterOptionsConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long parameteroptionsconfigurationId = ParamUtil.getLong(request, "parameteroptionsconfigurationId");
			ParameterOptionsConfiguration parameteroptionsconfiguration = ParameterOptionsConfigurationLocalServiceUtil.getParameterOptionsConfiguration(parameteroptionsconfigurationId);
			ParameterOptionsConfigurationLocalServiceUtil.deleteParameterOptionsConfiguration(parameteroptionsconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ParameterOptionConfiguration::deleteParameterOptionsConfiguration] Error deleting ParameterOptionsConfiguration.");
			ex.printStackTrace();
		}
	}
}
