package at.graz.meduni.liferay.portlet.bibbox.kdssmp.demo;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.HtmlUtil;
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
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EventList
 */
public class EventList extends MVCPortlet {
	public void createNewEvent(ActionRequest request, ActionResponse response) throws Exception {
		try {
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

			List<LayoutSetPrototype> lsps = LayoutSetPrototypeServiceUtil.search(themeDisplay.getCompanyId(), Boolean.TRUE, null);
			for(LayoutSetPrototype lsp : lsps) {
				//System.out.println("->" + lsp.getName() + " - " + lsp.getLayoutSetPrototypeId());
				if (HtmlUtil.escape(lsp.getName()).contains("kDSSMP")){
					System.out.println("hit");
					LayoutTypePortlet ltp = (LayoutTypePortlet) layout.getLayoutType();
					ltp.setLayoutTemplateId(userId, "1_column");
					System.out.println("ltp.setLayoutTemplateId("+userId+", "+lsp.getNameCurrentLanguageId()+");");
					LayoutLocalServiceUtil.updateLayout(layout);
					//LayoutLocalServiceUtil.updateLayout(layout.getGroupId(), layout.isPrivateLayout(),layout.getLayoutId(), layout.getTypeSettings());
					addResources(layout, PortletKeys.DOCKBAR);
				}
				
			}	
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	protected void addResources(Layout layout, String portletId)
			throws Exception{
			String rootPortletId = PortletConstants.getRootPortletId(portletId);
			String portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(
			layout.getPlid(), portletId);
			ResourceLocalServiceUtil.addResources(
			layout.getCompanyId(), layout.getGroupId(), 0, rootPortletId,
			portletPrimaryKey, true, true, true);
			}

}
