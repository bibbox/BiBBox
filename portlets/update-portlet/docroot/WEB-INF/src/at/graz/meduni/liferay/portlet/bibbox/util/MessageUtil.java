package at.graz.meduni.liferay.portlet.bibbox.util;

public class MessageUtil {
	
	private String message_ = "";
	
	public MessageUtil() {
		
	}
	
	public void addMessage(String message) {
		message_ += message + "<br>";
	}
}
