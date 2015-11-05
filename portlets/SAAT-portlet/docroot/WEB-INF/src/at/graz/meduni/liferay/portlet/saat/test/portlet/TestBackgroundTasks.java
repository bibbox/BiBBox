package at.graz.meduni.liferay.portlet.saat.test.portlet;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.saat.StringMatchingCodeGeneratorBackgroundTask;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.BackgroundTask;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class TestBackgroundTasks
 */
public class TestBackgroundTasks extends MVCPortlet {
	public void testBackgroundTasks(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		Date date = new Date();
		System.out.println("TestBackgroundTasks: " + date.toString());
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String,Serializable> taskContextMap = null; 
		String taskName = null; 
		String servletContextNames [] = new String[1] ;
		Portlet portlet = PortletLocalServiceUtil.getPortletById(request.getAttribute(WebKeys.PORTLET_ID).toString());
		servletContextNames[0] = portlet.getContextName();
		BackgroundTask backgroundtask = null;
		try {  
			backgroundtask = BackgroundTaskLocalServiceUtil.addBackgroundTask(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), taskName, servletContextNames,StringMatchingCodeGeneratorBackgroundTask.class, taskContextMap,new ServiceContext());  
		} catch (PortalException e) {  
			  e.printStackTrace();  
		} catch (SystemException e) {  
			  e.printStackTrace();  
		} 
		
		BackgroundTaskStatus backgroundTaskStatus = BackgroundTaskStatusRegistryUtil.getBackgroundTaskStatus(backgroundtask.getBackgroundTaskId());
		if(backgroundTaskStatus != null) {
			System.out.println("backgroundTaskStatus not null");
		}
		System.out.println("getBackgroundTaskId: " + backgroundtask.getBackgroundTaskId() + " " + backgroundtask.getCreateDate() + " " + backgroundtask.getCompletionDate());
		System.out.println("Status: " + backgroundtask.getStatus() + " " + backgroundtask.getStatusMessage() + " ");
		date = new Date();
		System.out.println("Done TestBackgroundTasks: " + date.toString());
	}

}
