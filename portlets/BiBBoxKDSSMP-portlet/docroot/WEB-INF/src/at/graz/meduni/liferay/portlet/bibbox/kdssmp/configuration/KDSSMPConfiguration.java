package at.graz.meduni.liferay.portlet.bibbox.kdssmp.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class KDSSMPConfiguration
 */
public class KDSSMPConfiguration extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addKdssmpConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			System.out.println(ParamUtil.getString(request, "scope") + " - " + ParamUtil.getString(request, "optionkey") + " - " + ParamUtil.getString(request, "optionvalue"));
			
			KdssmpConfiguration kdssmpconfiguration = KdssmpConfigurationLocalServiceUtil.symbolKdssmpConfigurationFromRequest(request);
			KdssmpConfigurationLocalServiceUtil.addKdssmpConfiguration(kdssmpconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.configuration.KDSSMPConfiguration::addKdssmpConfiguration] Error adding KDSSMPConfiguration.");
			ex.printStackTrace();
		}
	}
	
	public void updateKdssmpConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			KdssmpConfiguration kdssmpconfiguration = KdssmpConfigurationLocalServiceUtil.symbolKdssmpConfigurationFromRequest(request);
			KdssmpConfigurationLocalServiceUtil.updateKdssmpConfiguration(kdssmpconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.configuration.KDSSMPConfiguration::updateKdssmpConfiguration] Error updating KDSSMPConfiguration.");
			ex.printStackTrace();
		}
	}
}
