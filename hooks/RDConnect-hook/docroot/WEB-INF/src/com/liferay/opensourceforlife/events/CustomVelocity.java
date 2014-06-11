package com.liferay.opensourceforlife.events;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.events.Action;

import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class CustomVelocity extends Action {
	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#Action()
	 */
	public CustomVelocity() {
		super();
	}

	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#run(HttpServletRequest request, HttpServletResponse response)
	 */
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		/*System.out.println("CustomVelocity.run()");
		String pid = (String) request.getAttribute(WebKeys.PORTLET_SESSION);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<String, Object> vmVariables = new HashMap<String, Object>();
		System.out.println("User: " + themeDisplay.getUser().getFullName());
		String var = themeDisplay.getPortletDisplay().getId();
		System.out.println("plid: " + themeDisplay.getPlid());
		
		//PortletConfig portletConfig = (PortletConfig)request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		//System.out.println("getPortletName: " + portletConfig.getPortletName());
		System.out.println("portletResource: " + ParamUtil.getString(request, "portletResource"));
		//var = pid;
		System.out.println("var: " + var);
		vmVariables.put("rdcPortalId", var);
		vmVariables.put("rdctest", "test");
		
		request.setAttribute(WebKeys.VM_VARIABLES, vmVariables);*/
	}

}