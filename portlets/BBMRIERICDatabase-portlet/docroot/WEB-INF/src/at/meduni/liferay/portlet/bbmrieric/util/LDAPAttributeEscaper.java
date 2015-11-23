package at.meduni.liferay.portlet.bbmrieric.util;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;

public class LDAPAttributeEscaper {
	/**
	 * 
	 * @param attr
	 * @return
	 */
	public static final String getAttributeValues(Attribute attr) {
		String values = "";
		String seperator = "";
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return "";
		}
		return values;
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	public static final Boolean getAttributeValuesBoolean(Attribute attr) {
		String values = "";
		String seperator = "";
		boolean return_value = false;
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
			return_value = Boolean.parseBoolean(values);
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return false;
		}
		return return_value; 
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	public static final Long getAttributeValuesLong(Attribute attr) {
		String values = "";
		String seperator = "";
		long return_value = 0;
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
			return_value = Long.parseLong(values);
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return (long) 0;
		}
		return return_value; 
	}
}
