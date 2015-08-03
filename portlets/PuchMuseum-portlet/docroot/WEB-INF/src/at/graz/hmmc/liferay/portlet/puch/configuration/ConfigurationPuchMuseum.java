package at.graz.hmmc.liferay.portlet.puch.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ConfigurationPuchMuseum
 */
public class ConfigurationPuchMuseum extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			System.out.println(ParamUtil.getString(request, "scope") + " - " + ParamUtil.getString(request, "optionkey") + " - " + ParamUtil.getString(request, "optionvalue"));
			
			Configuration configuration = ConfigurationLocalServiceUtil.configurationFromRequest(request);
			ConfigurationLocalServiceUtil.addConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ConfigurationPuchMuseum::addConfiguration] Error adding Configuration.");
			ex.printStackTrace();
		}
	}
	
	public void updateConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Configuration configuration = ConfigurationLocalServiceUtil.configurationFromRequest(request);
			ConfigurationLocalServiceUtil.updateConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ConfigurationPuchMuseum::updateConfiguration] Error updating Configuration.");
			ex.printStackTrace();
		}
	}
	
	public void deleteConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long configurationId = ParamUtil.getLong(request, "configurationId");
			Configuration configuration = ConfigurationLocalServiceUtil.getConfiguration(configurationId);
			ConfigurationLocalServiceUtil.deleteConfiguration(configuration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.configuration.ConfigurationPuchMuseum::deleteConfiguration] Error deleting Configuration.");
			ex.printStackTrace();
		}
	}

}
