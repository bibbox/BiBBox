package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SignEvent
 */
public class SignEvent extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void signEvent(ActionRequest request, ActionResponse response) throws Exception {
		try {
			Event event = EventLocalServiceUtil.getEvent(ParamUtil.getLong(request, "eventId"));
			event.setStatus("signed");
			EventLocalServiceUtil.updateEvent(event);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.SignEvent::signEvent] Error in changing status of Event.");
			ex.printStackTrace();
		}
	} 
}
