package at.meduni.liferay.portlet.rdconnect.admin;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Scheduler5Minutes implements MessageListener {
	 private static final Log LOGGER = LogFactoryUtil.getLog(Scheduler5Minutes.class);
	 
	 /**
	 * Job that we need to run on scheduler
	 */
	 public void receive(Message arg0) throws MessageListenerException {
		 LOGGER.info("Scheduler----&gt; receive()");
		 System.out.println("Scheduler----&gt; receive()");
		 //write your logic.
	 }
}
