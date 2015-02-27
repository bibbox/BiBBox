package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EventList
 */
public class EventList extends MVCPortlet {
	public void createNewEvent(ActionRequest request, ActionResponse response) throws Exception {		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();
		boolean privateLayout = false;
		long parentLayoutId = 0;
		String name = "Testpage";
		String title = null;
		String description = null;
		String type = LayoutConstants.TYPE_PORTLET;
		boolean hidden = false;
		String friendlyURL = "/testpage";
		ServiceContext serviceContext = new ServiceContext();
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        Group group = themeDisplay.getScopeGroup();
        serviceContext.setScopeGroupId(group.getGroupId());
        serviceContext.setUserId(themeDisplay.getUserId());
		Layout layout = LayoutLocalServiceUtil.addLayout(userId, groupId, privateLayout, parentLayoutId, name, title, description, type, hidden, friendlyURL, serviceContext);
		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
		layoutTypePortlet.setLayoutTemplateId(userId, "28627", false);
		LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
                layout.isPrivateLayout(),
                layout.getLayoutId(),
                layout.getTypeSettings());
		
	}

}
