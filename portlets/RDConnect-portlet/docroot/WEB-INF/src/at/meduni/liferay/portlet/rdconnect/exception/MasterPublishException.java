package at.meduni.liferay.portlet.rdconnect.exception;

/**
 * Exception handlin class for publishing organizations
 * 
 * @author Robert Reihs
 * @since	1.0
 */
public class MasterPublishException extends Exception {
	private static final long serialVersionUID = 2900221544206522396L;

	public MasterPublishException(String message) {
		super(message);
	}
	
	public MasterPublishException(Throwable cause) {
		super(cause);
	}
	
	public MasterPublishException(String message, Throwable cause) {
		super(message, cause);
	}
}
