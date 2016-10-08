package at.meduni.liferay.portlet.rdconnect.helper;

/**
 * Helper class for creating Address object
 * 
 * @author Robert Reihs
 * @since	1.0
 */
public class AddressHelper {
	
	private String street1_ = "-";
	private String street2_ = "";
	private String street3_ = "";
	private String city_ = "-";
	private String zip_ = "-";
	
	public AddressHelper(String address) {
		if(!address.equalsIgnoreCase("")){ 
			int end = 0;
			int start = 0;
			if(address.length() <= 75) {
				street1_ = address;
			} else if (address.length() > 75 && address.length() <= 150) {
				end = address.substring(start, 75).lastIndexOf(" ");
				street1_ = address.substring(start, end);
			} else if (address.length() > 150 && address.length() <= 225) {
				end = address.substring(start, 75).lastIndexOf(" ");				
				street1_ = address.substring(start, end);
				start = end;
				end = start + address.substring(start, end+75).lastIndexOf(" ");
				street2_ = address.substring(start, end);
				if(end < address.length())
					street3_ = address.substring(end);
			} else if (address.length() > 225) {
				end = address.substring(start, 75).lastIndexOf(" ");
				street1_ = address.substring(start, end);
				start = end;
				end = start + address.substring(start, end+75).lastIndexOf(" ");
				street2_ = address.substring(start, end);
				start = end;
				end = start + address.substring(start, start+75).lastIndexOf(" ");
				street3_ = address.substring(start, end);
			}
		}
	}
	public String getStreet1() {
		return street1_;
	}
	
	public String getStreet2() {
		return street2_;
	}
	
	public String getStreet3() {
		return street3_;
	}
	
	public String getCity() {
		return city_;
	}
	
	public String getZip() {
		return zip_;
	}
}
