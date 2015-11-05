package at.graz.meduni.liferay.portlet.saat;

import java.util.Date;
import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.model.BackgroundTask;

public class StringMatchingCodeGeneratorBackgroundTask extends BaseBackgroundTaskExecutor {
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		//Map taskContextMap = backgroundTask.getTaskContextMap();
		Date date = new Date();
		System.out.println("IN TASK TestBackgroundTasks: " + date.toString());
		Message message = new Message();
		message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());
		message.put("bgtStatus", "vorher");
		System.out.println("Vorher");
		MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		Thread.sleep(10000);
		System.out.println("nacher");
		message.put("bgtStatus", "nacher");
		MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		date = new Date();
		System.out.println("IN TASK TestBackgroundTasks: " + date.toString());
		return BackgroundTaskResult.SUCCESS;
	}

}
