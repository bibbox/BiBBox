package at.graz.meduni.liferay.portlet.bibbox.rdconnect.portlet.event;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class EventNotificationSchedule implements MessageListener {

	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String classname = "RDConnect-Events-portlet::at.graz.meduni.liferay.portlet.bibbox.rdconnect.portlet.event.EventNotificationSchedule";
	
	@Override
	public void receive(Message message) throws MessageListenerException {
		System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classname + "::receive] Starting RD-Connect Event Messaging.");

		
	}

}
