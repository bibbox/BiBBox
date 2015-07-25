package at.meduni.liferay.portlet.bbmrieric.scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.EmailAddressServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;

/**
 * Portlet implementation class LDAPSyncService
 */
public class LDAPSyncService implements MessageListener {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);

	/**
	 * 
	 */
	@Override
	public void receive(Message message) throws MessageListenerException {
		Date startdate = new Date();
		String uuid = PortalUUIDUtil.generate();
		System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::receive] Info started LDAP Sync Scheduler (" + uuid + ").");
		
		connectLDAP(uuid);
		
		// End
		long datediff = new Date().getTime() - startdate.getTime();
		System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::receive] Info LDAP Sync Scheduler (" + uuid + ") finished in " + datediff + "ms.");
	} 
 
	/**
	 * 
	 */
	private void connectLDAP(String uuid) {
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(LdapContext.CONTROL_FACTORIES, "com.sun.jndi.ldap.ControlFactory");
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, "ldap://directory.bbmri-eric.eu:389");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.REFERRAL, "follow");
		// connect to LDAP
		try {
			DirContext ctx = new InitialDirContext(environment);
			
			SearchControls ctls = new SearchControls();
			ctls.setReturningAttributes(null);
			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			
			// Search for objects using filter and controls
			NamingEnumeration answer = ctx.search("dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
			int counter = 0;
			int counter_biobanks = 0;
			while (answer.hasMore()) {
				counter++;
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				try {
					if(attrs.get("biobankCountry") != null) {
						counter_biobanks++;
						String ldapbiobankID = getAttributeValues(attrs.get("biobankID"));
						BioBank biobank = BioBankLocalServiceUtil.getBioBank(ldapbiobankID);
						if(biobank == null) {
							biobank = BioBankLocalServiceUtil.createBioBank(ldapbiobankID);
							biobank = BioBankLocalServiceUtil.addBioBank(biobank);
							Organization organization = createOrganization(attrs);
							biobank.setOrganisationid(organization.getOrganizationId());
							biobank.setUUID(uuid);
							BioBankLocalServiceUtil.updateBioBank(biobank);
						}
						
						biobank.setBiobankcountry(getAttributeValues(attrs.get("biobankCountry")));
						biobank.setBiobankjuristicperson(getAttributeValues(attrs.get("biobankJuridicalPerson")));
						biobank.setBiobankname(getAttributeValues(attrs.get("biobankName")));
						
						biobank.setBiobanktype(getAttributeValues(attrs.get("objectClass")));
						biobank.setBiobanksize(getAttributeValues(attrs.get("biobankSize")));
						biobank.setUUID(uuid);
						BioBankLocalServiceUtil.updateBioBank(biobank);
						
						System.out.println("Update Biobank:" + biobank.getBiobankname() + ", with Organization ID: " + biobank.getOrganisationid());
						
						if(biobank.getOrganisationid() == 0) {
							BioBankLocalServiceUtil.deleteBioBank(biobank);
							continue;
						}
						createSearchIndex(attrs, biobank, uuid);
					}
				} catch (Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::connectLDAP] Error Creating Entrys for Biobank: " + getAttributeValues(attrs.get("biobankName")));
					ex.printStackTrace();
				}
			}
			System.out.println("LDAP contained: " + counter + " entrys with " + counter_biobanks + " Biobanks.");
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::connectLDAP] Error reading data from LDAP Server.");
			ex.printStackTrace();
		}
		
		try {
			deleteSearchIndexNotUpdated(uuid);
			deleteBioBanksNotUpdated(uuid);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::connectLDAP] Error deleting not updated Entries.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param uuid
	 */
	private void deleteBioBanksNotUpdated(String uuid) {
		List<BioBank> biobanks = BioBankLocalServiceUtil.notUpdatedBioBank(uuid);
		for(BioBank biobank : biobanks) {
			try {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(biobank.getOrganisationid());
				removeUsersFromOrganization(organization);
				OrganizationLocalServiceUtil.deleteOrganization(organization);
				BioBankLocalServiceUtil.deleteBioBank(biobank);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::createSearchIndex] Error creating search index.");
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param uuid
	 */
	private void deleteSearchIndexNotUpdated(String uuid) {
		List<SearchIndex> searchindexs = SearchIndexLocalServiceUtil.notUpdatedSearchIndex(uuid);
		for(SearchIndex searchindex : searchindexs) {
			try {
				SearchIndexLocalServiceUtil.deleteSearchIndex(searchindex);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::createSearchIndex] Error creating search index.");
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @param biobank
	 * @param uuid
	 */
	private void createSearchIndex(Attributes attrs, BioBank biobank,
			String uuid) {
		try {
			for (NamingEnumeration ae = attrs.getAll(); ae.hasMore();) {
				try {
					Attribute attr = (Attribute) ae.next();
					String value = getAttributeValues(attrs.get(attr.getID()));
					String key = attr.getID();
					long organizationid = biobank.getOrganisationid();
					SearchIndex searchindex = SearchIndexLocalServiceUtil
							.getSearchIndex(organizationid, key);
					if (searchindex == null) {
						searchindex = SearchIndexLocalServiceUtil
								.createSearchIndex(organizationid, key, value,
										uuid);
					} else {
						searchindex.setSearchindexvalue(value);
						searchindex.setUUID(uuid);
						SearchIndexLocalServiceUtil
								.updateSearchIndex(searchindex);
					}
				} catch (Exception ex) {
					System.err
							.println("["
									+ date_format_apache_error
											.format(new Date())
									+ "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::createSearchIndex] Error creating search index.");
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			System.err
					.println("["
							+ date_format_apache_error.format(new Date())
							+ "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::createSearchIndex] Error reading Element atrributes.");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @return
	 */
	private Organization createOrganization(Attributes attrs) {
		try {
			Company company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());
			User defaultUser = company.getDefaultUser();
			long userId = company.getDefaultUser().getUserId();
			
			String parentname = "BBMRI." + getAttributeValues(attrs.get("biobankCountry")).toLowerCase();
	        long parentOrganizationId = OrganizationLocalServiceUtil.getOrganization(company.getCompanyId(), parentname).getOrganizationId();
	        String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
	        boolean recursable = true;
	        long regionId = 0;
	        long countryId = 0;
	        int statusId = GetterUtil.getInteger(PropsUtil.get(
	                "sql.data.com.liferay.portal.model.ListType.organization.status"));
	        String comments = null;
	
	        ServiceContext serviceContext = new ServiceContext();
	
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        
	        boolean site = true;
	        
	        //TODO Update that Organization name longer than 100 characters
	        String name = getAttributeValues(attrs.get("biobankID")) + "__" + getAttributeValues(attrs.get("biobankName"));
	        if(name.length() > 100) {
	        	name = name.substring(0, 100);
	        }
	
	        Organization organization = OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, type, regionId, countryId, statusId, comments, site, serviceContext);
	        
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
	        
	        // Add User
	        User user = addUser(attrs, organization);
	        // Add Address
	        //addAddress(attrs, organization, user);
	        // Add Phone
	        //addPhone(attrs, organization, user);
	        // Add Webpage
	        //addWebpage(attrs, organization, user);
	        // Add Email
	        //addEmail(attrs, organization, user);
	        
	        return organization;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes " + attrs.toString() + ".");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param attrs
	 * @param organization
	 * @param user
	 */
	private void addEmail(Attributes attrs, Organization organization, User user) {
		try {
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
			List<EmailAddress> emailaddress_organization = EmailAddressLocalServiceUtil.getEmailAddresses(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			if(emailaddress_organization.size() == 0) {
				emailaddress_organization = new ArrayList<EmailAddress>();
				emailaddress_organization.add(EmailAddressServiceUtil.addEmailAddress(Organization.class.getName(), organization.getOrganizationId(), user.getEmailAddress(), 12004, true, serviceContext));
				UsersAdminUtil.updateEmailAddresses(Organization.class.getName(), organization.getOrganizationId(), emailaddress_organization);
			} else if(emailaddress_organization.size() == 1) {
				for(EmailAddress emailaddress : emailaddress_organization) {
					emailaddress.setAddress(user.getEmailAddress());
					EmailAddressLocalServiceUtil.updateEmailAddress(emailaddress);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addEmail] Error more than one Email for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addEmail] Error creating email; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @param organization
	 * @param user
	 */
	private void addWebpage(Attributes attrs, Organization organization, User user) {
		try {
			List<Website> websites_organization = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			String url = getAttributeValues(attrs.get("biobankURL"));
			if(url.equalsIgnoreCase("")) {
				return;
			}
			if(websites_organization.size() == 0) {
				websites_organization = new ArrayList<Website>();
				boolean primary = true;
				Website website = WebsiteLocalServiceUtil.createWebsite(0);
				website.setUrl(url);
				website.setTypeId(12020);
				website.setPrimary(primary);
				websites_organization.add(website);
				UsersAdminUtil.updateWebsites(Organization.class.getName(), organization.getOrganizationId(), websites_organization);
			} else if(websites_organization.size() == 1) {
				for(Website website : websites_organization) {
					website.setUrl(url);
					WebsiteLocalServiceUtil.updateWebsite(website);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addWebpage] Error more than one webpage for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addWebpage] Error creating webpage; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @param organization
	 * @param user
	 */
	private void addPhone(Attributes attrs, Organization organization, User user) {
		try {
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
			List<Phone> phones_organization = PhoneLocalServiceUtil.getPhones(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			List<Phone> phones_user = PhoneLocalServiceUtil.getPhones(organization.getCompanyId(), User.class.getName(), user.getUserId());
			String phonenumber = getAttributeValues(attrs.get("biobankContactPhone"));
			
			long userId = user.getUserId();
			int typeId_user = 11006; //Bussines
			int typeId_organization = 12009; //Bussines
			
			if(phones_organization.size() == 0) {
				phones_organization = new ArrayList<Phone>();
				phones_organization.add(PhoneLocalServiceUtil.addPhone(userId, Organization.class.getName(), organization.getOrganizationId(), phonenumber, "", typeId_organization, true, serviceContext));
				UsersAdminUtil.updatePhones(Organization.class.getName(), organization.getOrganizationId(), phones_organization);
			} else if(phones_organization.size() == 1) {
				for(Phone phone : phones_organization) {
					phone.setNumber(phonenumber);
					PhoneLocalServiceUtil.updatePhone(phone);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addPhone] Error more than one phone for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
			
			serviceContext.setScopeGroupId(user.getGroup().getGroupId());
			if(phones_user.size() == 0) {
				phones_user = new ArrayList<Phone>();
				phones_user.add(PhoneLocalServiceUtil.addPhone(userId, User.class.getName(), user.getUserId(), phonenumber, "", typeId_user, true, serviceContext));
				UsersAdminUtil.updatePhones(User.class.getName(), user.getUserId(), phones_user);
			} else if(phones_user.size() == 1) {
				for(Phone phone : phones_user) {
					phone.setNumber(phonenumber);
					PhoneLocalServiceUtil.updatePhone(phone);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addPhone] Error more than one phone for the user; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addPhone] Error creating phone; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @param organization
	 * @param user
	 */
	private void addAddress(Attributes attrs, Organization organization, User user) {
		try {
			ServiceContext serviceContext = new ServiceContext();
	        serviceContext.setAddGroupPermissions(true);
	        serviceContext.setAddGuestPermissions(true);
	        Group group = organization.getGroup();
	        serviceContext.setScopeGroupId(group.getGroupId());
			List<Address> addresses_organization = organization.getAddresses();
			List<Address> addresses_user = user.getAddresses();
			String street1 = "-";
			String street2 = "";
			String street3 = "";
			String city = getAttributeValues(attrs.get("biobankContactCity"));
			String zip = getAttributeValues(attrs.get("biobankContactZIP"));
			
			int end = 0;
			int start = 0;
			String addressstring = getAttributeValues(attrs.get("biobankContactAddress"));
			if(addressstring.length() <= 75) {
				street1 = addressstring;
			} else if (addressstring.length() > 75 && addressstring.length() <= 150) {
				end = addressstring.substring(start, 75).lastIndexOf(" ");
				street1 = addressstring.substring(start, end);
			} else if (addressstring.length() > 150 && addressstring.length() <= 225) {
				end = addressstring.substring(start, 75).lastIndexOf(" ");				
				street1 = addressstring.substring(start, end);
				start = end;
				end = start + addressstring.substring(start, end+75).lastIndexOf(" ");
				street2 = addressstring.substring(start, end);
				if(end < addressstring.length())
					street3 = addressstring.substring(end);
			} else if (addressstring.length() > 225) {
				end = addressstring.substring(start, 75).lastIndexOf(" ");
				street1 = addressstring.substring(start, end);
				start = end;
				end = start + addressstring.substring(start, end+75).lastIndexOf(" ");
				street2 = addressstring.substring(start, end);
				start = end;
				end = start + addressstring.substring(start, start+75).lastIndexOf(" ");
				street3 = addressstring.substring(start, end);
			}
			int typeId_organization = 12001;
			int typeId_user = 11000;
			long regionId = 0;
			long countryId = CountryServiceUtil.getCountryByA2(getAttributeValues(attrs.get("biobankCountry"))).getCountryId();
			long userid = user.getUserId();
			boolean mailing = false;
			boolean primary = true;
			
			// Update Organization Address
			if(addresses_organization.size() == 0) {
				addresses_organization = new ArrayList<Address>();
				addresses_organization.add(AddressLocalServiceUtil.addAddress(userid, User.class.getName(), user.getUserId(), street1, street2, street3, city, zip, 
						regionId, countryId, typeId_organization, mailing, primary, serviceContext));
				UsersAdminUtil.updateAddresses(Organization.class.getName(), organization.getOrganizationId(), addresses_organization);
			} else if(addresses_organization.size() == 1) {
				for(Address address : addresses_organization) {
					address.setStreet1(street1);
					address.setStreet2(street2);
					address.setStreet3(street3);
					address.setCity(city);
					address.setZip(zip);
					address.setCountryId(countryId);
					AddressLocalServiceUtil.updateAddress(address);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addAddress] Error more than one address for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
			
			// Update User Address
			serviceContext.setScopeGroupId(user.getGroup().getGroupId());
			countryId = CountryServiceUtil.getCountryByA2(getAttributeValues(attrs.get("biobankContactCountry"))).getCountryId();
			if(addresses_user.size() == 0) {
				addresses_user = new ArrayList<Address>();
				addresses_user.add(AddressLocalServiceUtil.addAddress(userid, Organization.class.getName(), organization.getOrganizationId(), street1, street2, street3, city, zip, 
						regionId, countryId, typeId_user, mailing, primary, serviceContext));
				UsersAdminUtil.updateAddresses(User.class.getName(), user.getUserId(), addresses_user);
			} else if(addresses_user.size() == 1) {
				for(Address address : addresses_user) {
					address.setStreet1(street1);
					address.setStreet2(street2);
					address.setStreet3(street3);
					address.setCity(city);
					address.setZip(zip);
					address.setCountryId(countryId);
					AddressLocalServiceUtil.updateAddress(address);
				}
			} else {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addAddress] Error more than one address for the user; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addAddress] Error creating address Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attrs
	 * @param organization
	 * @return
	 */
	private User addUser(Attributes attrs, Organization organization) {
		try {
			removeUsersFromOrganization(organization);
			String email = getAttributeValues(attrs.get("biobankContactEmail"));
			String firstname = getAttributeValues(attrs.get("biobankContactEmail"));
			String lastname = getAttributeValues(attrs.get("biobankContactEmail"));
			User user = null;
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(organization.getCompanyId(), email);
			} catch (Exception ex) {
				System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addUser] No user exist with email: " + email + ".");
			}
			if(user == null) {
				user = createUser(organization, email, firstname, lastname);
			} else {
				user.setFirstName(firstname);
				user.setLastName(lastname);
				UserLocalServiceUtil.updateUser(user);
			}
			return user;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::addUser] Error Adding user to Organization Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ".");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param organization
	 * @param mail
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private User createUser(Organization organization, String mail, String firstName, String lastName) throws PortalException, SystemException {
		ServiceContext serviceContext = new ServiceContext();
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        Group group = organization.getGroup();
        serviceContext.setScopeGroupId(group.getGroupId());

        Company company = CompanyLocalServiceUtil.getCompany(organization.getCompanyId());
        
		boolean autoPassword = true;
		String password1 = "";
		boolean autoScreenName = true;
		String screenName = "";
		long facebookId = 0;
		String openId = "";
		String middleName = "";
		int prefixId = 0;
		int suffixId = 0;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = new long[0];
		long[] organizationIds = {organization.getOrganizationId()};
		long[] roleIds = new long[0];
		long[] userGroupIds = new long[0];
		boolean male = false;
		boolean sendEmail = false;
		User user = UserLocalServiceUtil.addUser(company.getDefaultUser().getUserId(), company.getCompanyId(), autoPassword, password1, password1, 
				autoScreenName, screenName, mail, facebookId, openId, Locale.UK, firstName, middleName, lastName, 
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		user.setPasswordReset(false);
		UserLocalServiceUtil.updateUser(user);
		return user;
	}
	
	/**
	 * 
	 * @param organization
	 */
	private void removeUsersFromOrganization(Organization organization) {
		try {
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
			for(User u : userlist) {
				OrganizationLocalServiceUtil.deleteUserOrganization(u.getUserId(), organization);
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::removeUsersFromOrganization] Error removing users from Organization (" + organization.getOrganizationId() + ").");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	private String getAttributeValues(Attribute attr) {
		String values = "";
		String seperator = "";
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes " + attr.toString() + ".");
			//ex.printStackTrace();
			return "";
		}
		return values; 
	}

}
