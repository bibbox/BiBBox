package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DisplayEventParameter
 */
public class DisplayEventParameter extends MVCPortlet {
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateData(ActionRequest request, ActionResponse response) throws Exception {	
		long eventlayoutid = ParamUtil.getLong(request, "eventlayoutid");
		long patientid = ParamUtil.getLong(request, "patientid");
		String ontology = ParamUtil.getString(request, "ontology");
		//System.out.println("eventlayoutid: " + eventlayoutid + "; patientid: " + patientid + "; ontology: " + ontology + ";");
		String value = ParamUtil.getString(request, "value");
		//System.out.println(value);
		
		String pattern = "(\\d*)$";
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		Matcher m = r.matcher(ontology);
		String key = "";
		if (m.find( )) {
			key = m.group(0);
		}
		try {
			EventData eventdata = EventDataLocalServiceUtil.getEventDataByOntology(eventlayoutid, key);
			if(eventdata != null) {
				eventdata.setValue(value);
				EventDataLocalServiceUtil.updateEventData(eventdata);
				System.out.println("Update: eventlayoutid: " + eventlayoutid + "; patientid: " + patientid + "; ontology: " + ontology + "; value: " + value);
			} else {
				EventDataLocalServiceUtil.createNewEventData(eventlayoutid, patientid, key, value);
				System.out.println("Create: eventlayoutid: " + eventlayoutid + "; patientid: " + patientid + "; ontology: " + ontology + "; value: " + value);
			}
		} catch(Exception ex) {
			System.err.println("ERROR: DisplayEventParameter::updateData(ActionRequest request, ActionResponse response)");
			ex.printStackTrace();
		}
		
	}
}
