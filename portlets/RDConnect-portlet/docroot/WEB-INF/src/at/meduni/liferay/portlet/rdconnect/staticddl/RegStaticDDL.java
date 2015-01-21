package at.meduni.liferay.portlet.rdconnect.staticddl;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class RegStaticDDL
 */
public class RegStaticDDL extends MVCPortlet {
	public void updateCoreDDL(ActionRequest request, ActionResponse response) throws Exception {		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// Read Data from request
		String acronym = ParamUtil.getString(request, "acronym");
		String Description = ParamUtil.getString(request, "Description");
		String Hoste_institute = ParamUtil.getString(request, "Hoste_institute");
		String Host_institution_is_a = ParamUtil.getString(request, "Host_institution_is_a");
		String Type_of_host_institution = ParamUtil.getString(request, "Type_of_host_institution");
		String Text5085 = ParamUtil.getString(request, "Text5085");
		String Target_population_of_the_registry = ParamUtil.getString(request, "Target_population_of_the_registry");
		String year_of_establishment = ParamUtil.getString(request, "year_of_establishment");
		String Ontologies = ParamUtil.getString(request, "Ontologies");
		String Additional_Ontologies = ParamUtil.getString(request, "Additional_Ontologies");
		String Associated_data_available = ParamUtil.getString(request, "Associated_data_available");
		String Additional_Associated_data_available = ParamUtil.getString(request, "Additional_Associated_data_available");
		String Imaging_available = ParamUtil.getString(request, "Imaging_available");
		String Additional_Imaging_available = ParamUtil.getString(request, "Additional_Imaging_available");
		String The_registry_biobanks_is_listed_in_other_inventories_networks = ParamUtil.getString(request, "The_registry_biobanks_is_listed_in_other_inventories_networks");
		String Additional_networks_inventories = ParamUtil.getString(request, "Additional_networks_inventories");
	}

}
