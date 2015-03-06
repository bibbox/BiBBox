package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.LayoutTemplate;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.LayoutTemplateLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EventList
 */
public class EventList extends MVCPortlet {
	public void createEvent(ActionRequest request, ActionResponse response) throws Exception {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date eventdate = ParamUtil.getDate(request, "kdssmpdate", dateFormat);
			String eventtype = ParamUtil.getString(request, "eventType");
			long patientId = ParamUtil.getLong(request, "patientId");
			
			String pagetitle = patientId + dateFormat.format(eventdate) + " " + eventtype;
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			boolean privateLayout = false;
			long parentLayoutId = 0;
			String name = pagetitle;
			String title = null;
			String description = null;
			String type = LayoutConstants.TYPE_PORTLET;
			boolean hidden = false;
			String friendlyURL = "/" + pagetitle.replaceAll(" ", "-");
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			Group group = themeDisplay.getScopeGroup();
			serviceContext.setScopeGroupId(group.getGroupId());
			serviceContext.setUserId(themeDisplay.getUserId());

			Layout layout = LayoutLocalServiceUtil.addLayout(userId, groupId, privateLayout, parentLayoutId, name, title, description, type, hidden, friendlyURL, serviceContext);

			List<LayoutSetPrototype> lsps = LayoutSetPrototypeServiceUtil.search(themeDisplay.getCompanyId(), Boolean.TRUE, null);
			for (LayoutSetPrototype lsp : lsps) {
				// System.out.println("->" + lsp.getName() + " - " +
				// lsp.getLayoutSetPrototypeId());
				if (HtmlUtil.escape(lsp.getName()).contains("kDSSMP")) {
					System.out.println("hit");
					LayoutTypePortlet ltp = (LayoutTypePortlet) layout.getLayoutType();
					ltp.setLayoutTemplateId(userId, "1_column");
					System.out.println("ltp.setLayoutTemplateId(" + userId + ", " + lsp.getNameCurrentLanguageId() + ");");
					LayoutLocalServiceUtil.updateLayout(layout);
					// LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
					// layout.isPrivateLayout(),layout.getLayoutId(),
					// layout.getTypeSettings());
					addResources(layout, PortletKeys.DOCKBAR);
				}

			}

			// Create Event in DB
			Event event = EventLocalServiceUtil.createNewEvent(layout.getLayoutId(), patientId ,eventdate, eventtype);
			EventLocalServiceUtil.addEvent(event);

			// Read Data from request
			addEventDate(request);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 
	 * @param request
	 */
	private void addEventDate(ActionRequest request) {
		try {
			String eventtype = ParamUtil.getString(request, "eventType");
			long patientId = ParamUtil.getLong(request, "patientId");
			List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype);
			for(KdssmpConfiguration parameter : parameters) {
				KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
				String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
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
			}
		} catch(Exception ex) {
			System.err.println("ERROR: EventList::addEventDate(ActionRequest request)");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param layout
	 * @param portletId
	 * @throws Exception
	 */
	protected void addResources(Layout layout, String portletId) throws Exception {
		String rootPortletId = PortletConstants.getRootPortletId(portletId);
		String portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(layout.getPlid(), portletId);
		ResourceLocalServiceUtil.addResources(layout.getCompanyId(), layout.getGroupId(), 0, rootPortletId, portletPrimaryKey, true, true, true);
	}
}
