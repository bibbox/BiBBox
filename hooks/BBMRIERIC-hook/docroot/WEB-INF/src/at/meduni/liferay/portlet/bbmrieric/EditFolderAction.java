package at.meduni.liferay.portlet.bbmrieric;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.util.WebKeys;

public class EditFolderAction extends BaseStrutsPortletAction {

	public EditFolderAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processAction(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the process actionwhile creating the account>>>");
		super.processAction(originalStrutsPortletAction, portletConfig,
				actionRequest, actionResponse);
	}

	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the render action while creating the account>>>");
		if(originalStrutsPortletAction == null) {
			System.out.println("originalStrutsPortletAction");
		}
		 String ret = originalStrutsPortletAction.render(null, portletConfig, renderRequest, renderResponse);
		 renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.TRUE);
		 return ret;
	}
	
	@Override
	public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside the serveResource action while creating the account>>>");
        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }
}
