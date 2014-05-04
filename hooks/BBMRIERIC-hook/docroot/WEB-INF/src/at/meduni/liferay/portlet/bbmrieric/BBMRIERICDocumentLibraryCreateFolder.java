package at.meduni.liferay.portlet.bbmrieric;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

public class BBMRIERICDocumentLibraryCreateFolder extends BaseStrutsPortletAction {
	public String render(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		try {
			System.out.println("DingDong");
				//CustomJavaClass customJavaClass = new CustomJavaClass();
				//String someResult = customJavaClass.execute();
			renderRequest.setAttribute("someResult", "xyaz");
			if(originalStrutsPortletAction == null) {
				System.out.println("originalStrutsPortletAction");
			}
			if(portletConfig == null) {
				System.out.println("portletConfig");
			}
			if(renderRequest == null) {
				System.out.println("renderRequest");
			}
			if(renderResponse == null) {
				System.out.println("renderResponse");
			}
			//return originalStrutsPortletAction.render(null, portletConfig, renderRequest, renderResponse);
		} catch(Exception e) {
			System.out.println("-------------------------------------");
			e.printStackTrace();
		}
		//sendRedirect(renderRequest, renderResponse);
		return null;
	}
}
