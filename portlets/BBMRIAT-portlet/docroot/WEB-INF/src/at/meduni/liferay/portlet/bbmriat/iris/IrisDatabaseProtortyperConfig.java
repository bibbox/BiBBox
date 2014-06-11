package at.meduni.liferay.portlet.bbmriat.iris;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;

public class IrisDatabaseProtortyperConfig implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		System.out.println("processAction Config");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("render Config");
		return "/html/iris/irisdatabaseprotortyper/config.jsp";
	}

}
