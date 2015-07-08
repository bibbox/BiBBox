package at.graz.meduni.liferay.portlet.bibbox.ddl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DynamicDataListConfigExtended
 */
public class DynamicDataListConfigExtended extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateDDLConfig(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long ddmstructureid = ParamUtil.getLong(request, "ddmstructureid");
			String ddmstructurename = ParamUtil.getString(request, "ddmstructurename");
			DDMStructure ddm_structure = DDMStructureLocalServiceUtil.getDDMStructure(ddmstructureid);
			Map<String, Map<String, String>> fieldmap = ddm_structure.getFieldsMap();
			for(String key : fieldmap.keySet()) {
		  		if(key.equalsIgnoreCase("_fieldsDisplay")) {
		  			continue;
		  		}
		  		String viewtitlecss = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_viewtitlecss");
		  		String viewvaluecss = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_viewvaluecss");
		  		String displaytip = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_displaytip");
		  		long columwidth = ParamUtil.getLong(request, fieldmap.get(key).get("label") + "_columwidth");
		  		String edittip = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_edittip");
		  		String group = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_group");
		  		boolean display = ParamUtil.getBoolean(request, fieldmap.get(key).get("label") + "_display");
		  		long fieldconfigurationid = ParamUtil.getLong(request, "fieldconfigurationid");
		  		String viewscript = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_viewscript");
		  		String editscript = ParamUtil.getString(request, fieldmap.get(key).get("label") + "_editscript");
		  		DDLConfiguration ddlconfiguration = null;
		  		if(fieldconfigurationid == 0) {
		  			ddlconfiguration = DDLConfigurationLocalServiceUtil.createDDLConfiguration();
		  			ddlconfiguration.setViewtitlecss(viewtitlecss);
		  			ddlconfiguration.setViewvaluecss(viewvaluecss);
		  			ddlconfiguration.setDisplaytip(displaytip);
		  			ddlconfiguration.setColumwidth(columwidth);
		  			ddlconfiguration.setEdittip(edittip);
		  			ddlconfiguration.setGroup(group);
		  			ddlconfiguration.setDisplay(display);
		  			ddlconfiguration.setViewscript(viewscript);
		  			ddlconfiguration.setEditscript(editscript);
		  		} else {
		  			ddlconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfiguration(fieldconfigurationid);
		  			ddlconfiguration.setViewtitlecss(viewtitlecss);
		  			ddlconfiguration.setViewvaluecss(viewvaluecss);
		  			ddlconfiguration.setDisplaytip(displaytip);
		  			ddlconfiguration.setColumwidth(columwidth);
		  			ddlconfiguration.setEdittip(edittip);
		  			ddlconfiguration.setGroup(group);
		  			ddlconfiguration.setDisplay(display);
		  			ddlconfiguration.setViewscript(viewscript);
		  			ddlconfiguration.setEditscript(editscript);
		  		}
		  		DDLConfigurationLocalServiceUtil.updateDDLConfiguration(ddlconfiguration);
			}
		} catch(Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.ddl.DynamicDataListConfigExtended::updateDDLConfig] Error wihle Updating DDL Config.");
			ex.printStackTrace();
		}
	}

}
