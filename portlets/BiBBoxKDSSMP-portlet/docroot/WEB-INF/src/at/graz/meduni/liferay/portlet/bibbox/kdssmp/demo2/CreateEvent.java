package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo.Patient;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutPrototype;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutPrototypeLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CreateEvent
 */
public class CreateEvent extends MVCPortlet {
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
	public void createEvent(ActionRequest request, ActionResponse response) throws Exception {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date eventdate = ParamUtil.getDate(request, "kdssmpdate", dateFormat);
			String eventtype = ParamUtil.getString(request, "eventType");
			long organizationId = ParamUtil.getLong(request, "organizationId");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			
			String pagetitle = organizationId + " " + dateFormat.format(eventdate) + " " + eventtype;
			
			KdssmpPatient patient = KdssmpPatientLocalServiceUtil.getPatientForOrganization(organizationId);
			
			// Create Layout
			Layout layout = createLayout(pagetitle, eventtype, organizationId, userId, groupId);
			
			// Create Event
			Event event = EventLocalServiceUtil.createNewEvent(layout.getPlid(), patient.getPatientId(), eventdate, eventtype);
			
			// Add Event Data
			createEventData(request, patient.getPatientId(), event.getEventId());
			
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreateEvent::createEvent] Error in creating Event.");
			ex.printStackTrace();
		}
	} 
	
	private void createEventData(ActionRequest request, long patientId, long eventId) {
		try {
			String eventtype = ParamUtil.getString(request, "eventType");
			List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype);
			for(KdssmpConfiguration parameter : parameters) {
				KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
				String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
				String value = "";
				System.out.println(parameterconfig.getDatatype());
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
				EventDataLocalServiceUtil.createNewEventData(eventId, patientId, String.valueOf(parameterconfig.getParameterconfigurationId()), value);
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreateEvent::createEvent] Error in creating Event.");
			ex.printStackTrace();
		}
	}
	
	private Layout createLayout(String pagetitle, String eventtype, long organizationId, long userId, long groupId) {
		try {
			boolean privateLayout = false;
			long parentLayoutId = 0;
			String name = pagetitle;
			String title = null;
			String description = null;
			String type = LayoutConstants.TYPE_PORTLET;
			boolean hidden = false;
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			char d = (char)(r.nextInt(26) + 'a');
			String friendlyURL = "/" + PortalUUIDUtil.generate();
			
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
	
			Layout layout = LayoutLocalServiceUtil.addLayout(userId, groupId, privateLayout, parentLayoutId, name, title, description, type, hidden, friendlyURL, serviceContext);
	
			KdssmpConfiguration eventlayoutprototype = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("layoutprototype", eventtype);
			
			List<LayoutPrototype> layoutprototypes = LayoutPrototypeLocalServiceUtil.getLayoutPrototypes(-1, -1);
			for(LayoutPrototype layoutprototype : layoutprototypes) {
				if (HtmlUtil.escape(layoutprototype.getName()).contains(eventlayoutprototype.getOptionvalue())) {
					layout.setLayoutPrototypeUuid(layoutprototype.getUuid());
					layout.setLayoutPrototypeLinkEnabled(true);
					LayoutLocalServiceUtil.updateLayout(layout);
				}
			}
			
			return layout;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxKDSSMP-portlet::at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo2.CreateEvent::createLayout] Error creating Layout for event(" + pagetitle + ", " + eventtype + ", " + organizationId + ", " + userId + ", " + groupId + ").");
			ex.printStackTrace();
		}
		return null;
	}
}
