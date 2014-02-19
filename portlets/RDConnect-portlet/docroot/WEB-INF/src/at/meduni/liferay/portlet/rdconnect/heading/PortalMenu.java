package at.meduni.liferay.portlet.rdconnect.heading;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortalMenu
 */
public class PortalMenu extends MVCPortlet {
	public void searchRDC(ActionRequest request, ActionResponse response) throws Exception {
		String searchstring = ParamUtil.getString(request, "name");
		System.out.println("Search");
		PortletURL redirectURL = null;
	    String redirectJSP = "html/candidate/mastertable/view.jsp";
	    
	    String portletName = (String)request.getAttribute(WebKeys.PORTLET_ID);
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),
                portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
        redirectURL.setParameter("name", portletName);
        redirectURL.setParameter("jspPage", redirectJSP);
	    
	    response.sendRedirect(redirectURL.toString());
	}
}
