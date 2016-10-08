package at.meduni.liferay.portlet.rdconnect.helper;

/**
 * Helper class for creating users based on email address
 * 
 * @author Robert Reihs
 * @since	1.0
 */
public class UserHelper {
	private String email_ = "";
	private String firstname_ = "";
	private String lastname_ = "";
	
	/**
	 * 
	 */
	@Override
    public boolean equals(Object object) {
        if (object != null && object instanceof UserHelper) {
        	UserHelper helper_user = (UserHelper) object;
        	return (email_.equals(helper_user.getEmail()));
        }
        return false;
    }
	
	/**
	 * 
	 */
	@Override
	public int hashCode(){
		return email_.hashCode();
	}
	
	/**
	 * 
	 * @param contact_person
	 */
	public void extractNameFromContactPerson(String contact_person, String head, boolean fix_use_contact_person) {
		if(fix_use_contact_person) {
			if(contact_person.equalsIgnoreCase("")) {
				setEmailAsName();
			} else {
				setContactPersonName(contact_person);
			}
		} else {
			setName(contact_person, head);
		}
	}
	
	/**
	 * 
	 * @param contact_person
	 */
	private void setContactPersonName(String contact_person) {
		String[] contact_person_split = contact_person.split(" ");
		String split = "";
		for(String name : contact_person_split) {
			if(firstname_.equals("")) {
				firstname_ = name;
			} else if(firstname_.equals("Dr")) {
				firstname_ += " " + name;
			} else {
				lastname_ += split + name;
				split = " ";
			}
		}
	}
	
	/**
	 * 
	 */
	private void setEmailAsName() {
		String email_name = email_.replaceAll("@.*", "");
		String split = "";
		for(String name : email_name.split("\\.")) {
			if(firstname_.equals("")) {
				firstname_ = name;
			} else {
				lastname_ += split + name;
				split = " ";
			}
		}
	}
	
	/**
	 * 
	 * @param contact_person
	 * @param head
	 */
	private void setName(String contact_person, String head) {
		//TODO: Update Methode to extract infromation from the two strings
		setEmailAsName();
	}
	
	/**
	 */
	public String getEmail() {
		return email_;
	}
	
	/**
	 */
	public void setEmail(String email) {
		this.email_ = email;
	}
	
	/**
	 */
	public String getFirstname() {
		return firstname_;
	}
	
	/**
	 */
	public void setFirstname(String firstname) {
		this.firstname_ = firstname;
	}
	
	/**
	 */
	public String getLastname() {
		return lastname_;
	}
	
	/**
	 */
	public void setLastname(String lastname) {
		this.lastname_ = lastname;
	}
}
