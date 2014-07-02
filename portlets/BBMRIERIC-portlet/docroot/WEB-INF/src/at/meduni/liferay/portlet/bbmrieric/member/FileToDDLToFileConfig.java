package at.meduni.liferay.portlet.bbmrieric.member;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class FileToDDLToFileConfig  implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		System.out.println("processAction Config");
		// TODO Auto-generated method stub
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 

		  PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 

		  //Read, validate, and then set form parameters as portlet preferences
		  prefs.setValue("TestConfig", "ConfigTest");

		  prefs.store();

		  SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("render Config");
		return "/html/filetoddltofile/config.jsp";
	}
}
