package at.graz.meduni.liferay.portlet.bibbox.symbol;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.model.Icons;
import at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalServiceUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class IconsImageConfig
 */
public class IconsImageConfig extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addIcon(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Icons icons = IconsLocalServiceUtil.iconsFromRequest(request);
			IconsLocalServiceUtil.addIcons(icons);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.symbol.IconsImageConfig::addIcon] Error adding Icon.");
			ex.printStackTrace();
		}
	}
	
	public void updateIcon(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Icons icons = IconsLocalServiceUtil.iconsFromRequest(request);
			IconsLocalServiceUtil.updateIcons(icons);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.symbol.IconsImageConfig::updateIcon] Error updating Icon.");
			ex.printStackTrace();
		}
	}

}
