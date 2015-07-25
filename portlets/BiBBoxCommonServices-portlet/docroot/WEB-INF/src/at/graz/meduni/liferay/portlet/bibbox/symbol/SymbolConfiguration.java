package at.graz.meduni.liferay.portlet.bibbox.symbol;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SymbolConfiguration
 */
public class SymbolConfiguration extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);

	public void updateSymbolTypeConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			SymbolTypeConfiguration symboltypeconfiguration = SymbolTypeConfigurationLocalServiceUtil.symbolTypeConfigurationFromRequest(request);
			SymbolTypeConfigurationLocalServiceUtil.updateSymbolTypeConfiguration(symboltypeconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.symbol.SymbolConfiguration::updateSymbolTypeConfiguration] Error updating SymbolTypeConfiguration.");
			ex.printStackTrace();
		}
	}
	
	public void addSymbolTypeConfiguration(ActionRequest request, ActionResponse response) throws Exception {
		try {
			SymbolTypeConfiguration symboltypeconfiguration = SymbolTypeConfigurationLocalServiceUtil.symbolTypeConfigurationFromRequest(request);
			SymbolTypeConfigurationLocalServiceUtil.addSymbolTypeConfiguration(symboltypeconfiguration);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.symbol.SymbolConfiguration::addSymbolTypeConfiguration] Error updating SymbolTypeConfiguration.");
			ex.printStackTrace();
		}
	}
}
