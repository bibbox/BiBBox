package at.graz.hmmc.liferay.portlet.puch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;
import at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;
import at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PuchMuseumsObjektErstellen
 */
public class PuchMuseumsObjektErstellen extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public void addPuchMuseumsObject(ActionRequest request, ActionResponse response) throws Exception {
		try {
			// Creating Object
			String objecttype = ParamUtil.getString(request, "objekttyp");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PuchMuseumsObjekt puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.addPuchMuseumsObjekt(objecttype, themeDisplay.getUserId());
			puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.addPuchMuseumsObjekt(puchmuseumsobjekt);
			// Adding Data for the Object
			addDataToObject(request, puchmuseumsobjekt);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.PuchMuseumsObjektErstellen::addPuchMuseumsObject] Error adding PuchMuseumsObject.");
			ex.printStackTrace();
		}
	}
	
	private void addDataToObject(ActionRequest request, PuchMuseumsObjekt puchmuseumsobjekt) {
		String objecttype = ParamUtil.getString(request, "objekttyp");
		List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objecttype);
		for(Configuration configuration : configurations) {
			try {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				String id = parameterconfig.getParameterconfigurationId() + "";
				String value = "";
				if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
					String[] items = ParamUtil.getParameterValues(request, id);
					boolean first = true;
					for(String item : items){
						if(!first) {
							value += ";";
						} else {
							first = false;
						}
						value += "\"" + item + "\"";
					}
				}
				ObjectData objectdata = ObjectDataLocalServiceUtil.addObjectData(puchmuseumsobjekt.getPuchmuseumsobjectId(), id, value);
				ObjectDataLocalServiceUtil.addObjectData(objectdata);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.PuchMuseumsObjektErstellen::addDataToObject] Error adding DataObject to PuchMuseumsObject.");
				ex.printStackTrace();
			}
		}
	}
	
	public void updatePuchMuseumsObject(ActionRequest request, ActionResponse response) throws Exception {
		try {
			// Creating Object
			String objecttype = ParamUtil.getString(request, "objekttyp");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjektId");
			PuchMuseumsObjekt puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
			puchmuseumsobjekt.setModifiedDate(new Date());
			puchmuseumsobjekt.setModifiedUserId(themeDisplay.getUserId());
			puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.updatePuchMuseumsObjekt(puchmuseumsobjekt);
			// Adding Data for the Object
			updateDataToObject(request, puchmuseumsobjekt);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.PuchMuseumsObjektErstellen::addPuchMuseumsObject] Error adding PuchMuseumsObject.");
			ex.printStackTrace();
		}
	}
	
	private void updateDataToObject(ActionRequest request, PuchMuseumsObjekt puchmuseumsobjekt) {
		String objecttype = ParamUtil.getString(request, "objekttyp");
		List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objecttype);
		for(Configuration configuration : configurations) {
			try {
				ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
				String id = parameterconfig.getParameterconfigurationId() + "";
				String value = "";
				if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
					value = ParamUtil.getString(request, id);
				} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
					String[] items = ParamUtil.getParameterValues(request, id);
					boolean first = true;
					for(String item : items){
						if(!first) {
							value += ";";
						} else {
							first = false;
						}
						value += "\"" + item + "\"";
					}
				}
				ObjectData objectdata = ObjectDataLocalServiceUtil.getObjectDataForObject(puchmuseumsobjekt.getPuchmuseumsobjectId(), id);
				if(objectdata == null) {
					objectdata = ObjectDataLocalServiceUtil.addObjectData(puchmuseumsobjekt.getPuchmuseumsobjectId(), id, value);
					ObjectDataLocalServiceUtil.addObjectData(objectdata);
				} else {
					objectdata.setObjectvalue(value);
					ObjectDataLocalServiceUtil.updateObjectData(objectdata);
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [PuchMuseum-portlet::at.graz.hmmc.liferay.portlet.puch.PuchMuseumsObjektErstellen::addDataToObject] Error adding DataObject to PuchMuseumsObject.");
				ex.printStackTrace();
			}
		}
	}
}
