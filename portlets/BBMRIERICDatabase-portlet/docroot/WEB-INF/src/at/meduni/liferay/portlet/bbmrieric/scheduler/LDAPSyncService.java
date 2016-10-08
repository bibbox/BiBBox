package at.meduni.liferay.portlet.bbmrieric.scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl;
import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.util.LDAPAttributeEscaper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
	String classpath_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService";
	
	/**
	 * 
	 */
	@Override
	public void receive(Message message) throws MessageListenerException {
		Date startdate = new Date();
		String uuid = PortalUUIDUtil.generate();
		System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::receive] Info started LDAP Sync Scheduler (" + uuid + ").");
		
		//connectLDAP(uuid);
		try {
			long companyId = Long.parseLong(PropsUtil.get("D2BiobankCompany"));
	        long groupId = Long.parseLong(PropsUtil.get("D2BiobankGroup"));
			d2Update(uuid, groupId, companyId);
		} catch (NumberFormatException ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::receive] Error NumberFormatException while reading config from portal-ext.properties.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::receive] Error Reading Data from LDAP.");
			ex.printStackTrace();
		} 
		// End
		System.out.println("");
		long datediff = new Date().getTime() - startdate.getTime();
		System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::receive] Info LDAP Sync Scheduler (" + uuid + ") finished in " + datediff + "ms.");
	} 
	
	/**
	 * 
	 * @param ldapupdateuuid
	 * @param groupId
	 * @param companyId
	 */
	private void d2Update(String ldapupdateuuid, long groupId, long companyId) {
		// ServiceContext to create the assets 
		ServiceContext serviceContext = new ServiceContext();
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			serviceContext.setUserId(company.getDefaultUser().getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
        serviceContext.setCompanyId(companyId);
        serviceContext.setScopeGroupId(groupId);
		
        // Reading data from the LDAP
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(LdapContext.CONTROL_FACTORIES, "com.sun.jndi.ldap.ControlFactory");
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL, "ldap://directory-ldap.bbmri-eric.eu:10389");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.REFERRAL, "follow");
		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(environment);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error reading data from LDAP Server.");
			ex.printStackTrace();
		}
		// Synchronize ContactInformation
		try {
			synchronizeContactInformation(ctx, serviceContext, ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error syncronicing ContactInformation.");
			ex.printStackTrace();
		}
		// Remove ContactInformation Not in the LDAP any more
		try {
			deleteContactInformationNotExistingInLdap(ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated ContactInformation.");
			ex.printStackTrace();
		}
		// Synchronize D2BiobankNetworks
		try {
			synchronizeD2BiobankNetworks(ctx, serviceContext, ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error syncronicing ContactInformation.");
			ex.printStackTrace();
		}
		// Remove D2BiobankNetworks Not in the LDAP any more
		try {
			deleteD2BiobankNetworksNotExistingInLdap(ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated ContactInformation.");
			ex.printStackTrace();
		}
		// Synchronize D2Biobanks
		try {
			synchronizeD2Biobank(ctx, serviceContext, ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error syncronicing D2Biobank.");
			ex.printStackTrace();
		}
		// Remove Biobanks Not in the LDAP any more
		try {
			deleteD2BiobanksNotExistingInLdap(ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated Entries.");
			ex.printStackTrace();
		}
		// Remove D2Collection Not in the LDAP any more
		try {
			deleteD2CollectionNotExistingInLdap(ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated D2Collection.");
			ex.printStackTrace();
		}
		// Remove Network Links Not in the LDAP any more
		try {
			deleteD2BiobankNetworkLinksNotExistingInLdap(ldapupdateuuid, groupId);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated D2BiobankNetworkLinksNotExistingInLdap.");
			ex.printStackTrace();
		}
		// Set Contacts according to Priority
		try {
			updateD2BiobankNetworksContactInformations();
			updateD2BiobankContactInformations();
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated D2BiobankNetworkLinksNotExistingInLdap.");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void updateD2BiobankNetworksContactInformations() {
		try {
			List<D2BiobankNetwork> networks = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworks(-1, -1);
			for(D2BiobankNetwork network : networks) {
				if(network.getParentd2biobanknetworkId() == 0) {
					List<D2BiobankNetwork> assosiatednetworks = network.getAssosiatedNetworks();
					for(D2BiobankNetwork assosiatednetwork : assosiatednetworks) {
						updateD2BiobankNetworksContactInformationsRecursive(assosiatednetwork);
					}
				}
			}
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2BiobankNetworksContactInformations] Error updating Contact information for network.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param network
	 */
	private void updateD2BiobankNetworksContactInformationsRecursive(D2BiobankNetwork network) {
		List<D2BiobankNetwork> assosiatednetworks = network.getAssosiatedNetworks();
		for(D2BiobankNetwork assosiatednetwork : assosiatednetworks) {
			if(network.getContactPriority() > assosiatednetwork.getContactPriority()) {
				try {
					assosiatednetwork.setContactIDRef(network.getContactIDRef());
					assosiatednetwork.setContactPriority(network.getContactPriority());
					D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork(assosiatednetwork);
				} catch (SystemException e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2BiobankNetworksContactInformationsRecursive] Error updating Contact information for network.");
					e.printStackTrace();
				}
			}
			updateD2BiobankNetworksContactInformationsRecursive(assosiatednetwork);
		}
	}
	
	/**
	 * 
	 */
	private void updateD2BiobankContactInformations() {
		try {
			List<D2Biobank> biobanks = D2BiobankLocalServiceUtil.getD2Biobanks(-1, -1);
			for(D2Biobank biobank : biobanks) {
				List<D2BiobankNetwork> assosiatednetworks = biobank.getNetworksWhereBiobankIsMember();
				for(D2BiobankNetwork assosiatednetwork : assosiatednetworks) {
					if(assosiatednetwork.getContactPriority() > biobank.getContactPriority()) {
						biobank.setContactIDRef(assosiatednetwork.getContactIDRef());
						biobank.setContactPriority(assosiatednetwork.getContactPriority());
						D2BiobankLocalServiceUtil.updateD2Biobank(biobank);
					}
				}
				List<D2Collection> collections = biobank.getRootCollections();
				for(D2Collection collection : collections) {
					updateD2CollactionContactInformations(collection, null, biobank);
				}
			}
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2BiobankContactInformations] Error updating Contact information for network.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param collection
	 * @param parrentcollection
	 * @param biobank
	 */
	private void updateD2CollactionContactInformations(D2Collection collection, D2Collection parrentcollection, D2Biobank biobank) {
		if(parrentcollection == null) {
			if(biobank.getContactPriority() > collection.getContactPriority()) {
				try {
					collection.setContactIDRef(biobank.getContactIDRef());
					collection.setContactPriority(biobank.getContactPriority());
					D2CollectionLocalServiceUtil.updateD2Collection(collection);
				} catch (SystemException e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2CollactionContactInformations] Error updating Contact information for network.");
					e.printStackTrace();
				}
			}
		} else {
			if(parrentcollection.getContactPriority() > collection.getContactPriority()) {
				try {
					collection.setContactIDRef(parrentcollection.getContactIDRef());
					collection.setContactPriority(parrentcollection.getContactPriority());
					D2CollectionLocalServiceUtil.updateD2Collection(collection);
				} catch (SystemException e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2CollactionContactInformations] Error updating Contact information for network.");
					e.printStackTrace();
				}
			}
		}
		List<D2BiobankNetwork> assosiatednetworks = collection.getNetworksWhereCollectionIsMember();
		for(D2BiobankNetwork assosiatednetwork : assosiatednetworks) {
			if(assosiatednetwork.getContactPriority() > collection.getContactPriority()) {
				try {
					collection.setContactIDRef(assosiatednetwork.getContactIDRef());
					collection.setContactPriority(assosiatednetwork.getContactPriority());
					D2CollectionLocalServiceUtil.updateD2Collection(collection);
				} catch (SystemException e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateD2CollactionContactInformations] Error updating Contact information for network.");
					e.printStackTrace();
				}
			}
		}
		// Recursive Update
		List<D2Collection> collections = collection.getChildD2Collection();
		for(D2Collection childcollection : collections) {
			updateD2CollactionContactInformations(childcollection, collection, null);
		}
	}

	private void synchronizeLinks(String networkbbmriId, long childId, String childtype, long groupId, String ldapupdateuuid) {
		String[] networkssplit = networkbbmriId.split(",");
		for(String bbmribiobanknetworkID : networkssplit) {
			try {
				System.out.println("Network Link ID: " + bbmribiobanknetworkID);
				bbmribiobanknetworkID = bbmribiobanknetworkID.trim();
				D2BiobankNetwork biobanknetwork = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkByBBMRIERICID(groupId, bbmribiobanknetworkID);
				long d2biobanknetworkId = 0;
				if(biobanknetwork != null) {
					d2biobanknetworkId = biobanknetwork.getD2biobanknetworkId();
					D2BiobankNetworkLink biobanknetworklink = D2BiobankNetworkLinkLocalServiceUtil.getD2BiobankNetworkLink(d2biobanknetworkId, childId, childtype);
					if(biobanknetworklink == null) {
						biobanknetworklink = D2BiobankNetworkLinkLocalServiceUtil.addD2BiobankNetworkLink(d2biobanknetworkId, childId, childtype, groupId, ldapupdateuuid);
					} else {
						biobanknetworklink.setUpdateuuid(ldapupdateuuid);
						biobanknetworklink.setGroupId(groupId);
						D2BiobankNetworkLinkLocalServiceUtil.updateD2BiobankNetworkLink(biobanknetworklink);
					}
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::synchronizeLinks] Error processing Links.");
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param ctx
	 * @param serviceContext
	 * @param ldapupdateuuid
	 * @param groupId
	 * @throws NamingException
	 */
	private void synchronizeD2BiobankNetworks(DirContext ctx, ServiceContext serviceContext, String ldapupdateuuid, long groupId) throws NamingException {
		SearchControls ctls = new SearchControls();
		ctls.setReturningAttributes(null);
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		serviceContext.setModifiedDate(new Date());
		// Search for objects using filter and controls
		NamingEnumeration<?> answer = ctx.search("ou=biobanknetworks,dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
		int counter = 0;
		int counter_networks = 0;
		while (answer.hasMore()) {
			counter++;
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();
			try {
				if(attrs.get("biobankNetworkID") != null) {
					counter_networks++;
					String bbmribiobankNetworkID = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkID"));
					// Update Networks
					D2BiobankNetwork network = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkByBBMRIERICID(groupId, bbmribiobankNetworkID);
					if(network == null) {
						serviceContext.setCreateDate(new Date());
						network = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkFromLDAP(null, attrs);
						network.setUpdateuuid(ldapupdateuuid);
						network = D2BiobankNetworkLocalServiceUtil.addD2BiobankNetwork(network, serviceContext);
					} else {
						network = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkFromLDAP(network, attrs);
						network.setUpdateuuid(ldapupdateuuid);
						network = D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork(network, serviceContext);
					}
					if(!network.getBiobankNetworkIDRef().equals("")) {
						synchronizeLinks(network.getBiobankNetworkIDRef(), network.getD2biobanknetworkId(), "D2BiobankNetwork", groupId, ldapupdateuuid);
					}
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::synchronizeD2BiobankNetworks] Error Creating Entrys for BiobankNetwork: " + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkName")));
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP contained: " + counter + " entrys with " + counter_networks + " Biobank Networks.");
	}
	
	/**
	 * 
	 * @param ctx
	 * @param serviceContext
	 * @param ldapupdateuuid
	 * @param groupId
	 * @throws NamingException
	 */
	private void synchronizeContactInformation(DirContext ctx, ServiceContext serviceContext, String ldapupdateuuid, long groupId) throws NamingException {
		SearchControls ctls = new SearchControls();
		ctls.setReturningAttributes(null);
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		serviceContext.setModifiedDate(new Date());
		// Search for objects using filter and controls
		NamingEnumeration<?> answer = ctx.search("ou=contacts,dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
		int counter = 0;
		int counter_contacts = 0;
		while (answer.hasMore()) {
			counter++;
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();
			try {
				if(attrs.get("contactID") != null) {
					counter_contacts++;
					String contactID = LDAPAttributeEscaper.getAttributeValues(attrs.get("contactID"));
					
					//System.out.println("contactID: " + contactID);
					ContactInformation contactinformation = ContactInformationLocalServiceUtil.getContactInformationByBBMRIERICID(groupId, contactID);
					if(contactinformation == null) {
						serviceContext.setCreateDate(new Date());
						contactinformation = ContactInformationLocalServiceUtil.contactInformationFromLdapAttribute(attrs, null);
						contactinformation.setUpdateuuid(ldapupdateuuid);
						contactinformation = ContactInformationLocalServiceUtil.addContactInformation(contactinformation, serviceContext);
					} else {
						contactinformation = ContactInformationLocalServiceUtil.contactInformationFromLdapAttribute(attrs, contactinformation);
						contactinformation.setUpdateuuid(ldapupdateuuid);
						contactinformation = ContactInformationLocalServiceUtil.updateContactInformation(contactinformation, serviceContext);
					}
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error Creating Entrys for Biobank: " + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP contained: " + counter + " entrys with " + counter_contacts + " Contacts.");
	}
	
	/**
	 * 
	 * @param ctx
	 * @param serviceContext
	 * @param ldapupdateuuid
	 * @param groupId
	 * @throws NamingException
	 */
	private void synchronizeD2Biobank(DirContext ctx, ServiceContext serviceContext, String ldapupdateuuid, long groupId) throws NamingException {
		SearchControls ctls = new SearchControls();
		ctls.setReturningAttributes(null);
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		// Search for objects using filter and controls
		NamingEnumeration<?> answer = ctx.search("ou=biobanks,dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
		int counter_biobanks = 0;
		int counter_collections = 0;
		while (answer.hasMore()) {
			SearchResult sr = (SearchResult) answer.next();
			//System.out.println(">>" + sr.getNameInNamespace());
			Attributes attrs = sr.getAttributes();
			try {
				if(attrs.get("biobankID") != null) {
					counter_biobanks++;
					String bbmribiobankID = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankID"));
					
					//System.out.println("ldapbiobankID: " + ldapbiobankID);
					
					D2Biobank biobank = D2BiobankLocalServiceUtil.getD2BiobankByBBMRIERICID(groupId, bbmribiobankID);
					if(biobank == null) {
						addBiobank(bbmribiobankID, serviceContext, attrs, ldapupdateuuid);
					} else {
						updateBiobank(bbmribiobankID, serviceContext, attrs, ldapupdateuuid);
					}
					if(!biobank.getBiobankNetworkIDRef().equals("")) {
						synchronizeLinks(biobank.getBiobankNetworkIDRef(), biobank.getBiobankId(), "D2Biobank", groupId, ldapupdateuuid);
					}
				} else if (attrs.get("collectionID") != null){
					//>>collectionID=bbmri-eric:collectionID:BE_B0383_PEARL,biobankID=bbmri-eric:biobankID:BE_B0383,c=be,ou=biobanks,dc=directory,dc=bbmri-eric,dc=eu
					String id_string = sr.getNameInNamespace();
					counter_collections++;
					String bbmricollectionID = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID"));
					String bbmribiobankID = "";
					String bbmriparentcollectionID = "";
					
					String[] ldapid = id_string.split(",");
					boolean firstid = true;
					for(String id : ldapid) {
						if(firstid) {
							firstid = false;
							continue;
						}
						String[] title_id = id.split("=");
						if(title_id[0].equalsIgnoreCase("collectionID") && bbmriparentcollectionID.equals("")) {
							bbmriparentcollectionID = title_id[1];
							continue;
						}
						if(title_id[0].equalsIgnoreCase("biobankID")) {
							bbmribiobankID = title_id[1];
							break;
						}
					}
					
					D2Biobank biobank = D2BiobankLocalServiceUtil.getD2BiobankByBBMRIERICID(groupId, bbmribiobankID);
					long biobankId = 0;
					if(biobank != null) {
						biobankId = biobank.getBiobankId();
					}
					long parentcollectionId = 0;
					if(!bbmriparentcollectionID.equals("")) {
						D2Collection parentcollection = D2CollectionLocalServiceUtil.getD2CollectionByBBMRIERICID(groupId, bbmriparentcollectionID, bbmribiobankID);
						if(parentcollection != null) {
							parentcollectionId = parentcollection.getD2collectionId();
						}
					}
					D2Collection collection = D2CollectionLocalServiceUtil.getD2CollectionByBBMRIERICID(groupId, bbmricollectionID, bbmribiobankID);
					if(collection == null) {	
						serviceContext.setCreateDate(new Date());
						collection = D2CollectionLocalServiceUtil.getD2CollectionFromLDAP(collection, attrs, sr, true);
						collection.setUpdateuuid(ldapupdateuuid);
						collection.setBiobankId(biobankId);
						collection.setParentd2collectionId(parentcollectionId);
						collection = D2CollectionLocalServiceUtil.addD2Collection(collection, serviceContext);
					} else {
						collection = D2CollectionLocalServiceUtil.getD2CollectionFromLDAP(collection, attrs, sr, true);
						collection.setUpdateuuid(ldapupdateuuid);
						collection.setBiobankId(biobankId);
						collection.setParentd2collectionId(parentcollectionId);
						collection = D2CollectionLocalServiceUtil.updateD2Collection(collection, serviceContext);
					}
					if(collection != null) {
						if(!collection.getBiobankNetworkIDRef().equals("")) {
							synchronizeLinks(collection.getBiobankNetworkIDRef(), collection.getD2collectionId(), "D2Collection", groupId, ldapupdateuuid);
						}
					}
				}
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error Creating Entrys for Biobank: " + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP contained: " + counter_biobanks + " Biobanks and " + counter_collections + " Collections");
	}
	
	/**
	 * 
	 * @param ldapupdateuuid
	 * @param groupId
	 */
	private void deleteContactInformationNotExistingInLdap(String ldapupdateuuid, long groupId) {
		List<ContactInformation> contactinformations = ContactInformationLocalServiceUtil.getLDAPNotUpdatedContactInformation(groupId, ldapupdateuuid);
		for(ContactInformation contactinformation : contactinformations) {
			try {
				ContactInformationLocalServiceUtil.deleteContactInformation(contactinformation);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::deleteContactInformationNotExistingInLdap] Error deleting ContactInformation not in LDAP.");
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP deltetions: " + contactinformations.size() + " ContactInformation deleted.");
	}
	
	/**
	 * 
	 * @param ldapupdateuuid
	 * @param groupId
	 */
	private void deleteD2BiobanksNotExistingInLdap(String uuid, long groupId) {
		List<D2Biobank> biobanks = D2BiobankLocalServiceUtil.getLDAPNotUpdatedBiobanks(groupId, uuid);
		for(D2Biobank biobank : biobanks) {
			try {
				D2BiobankLocalServiceUtil.deleteD2Biobank(biobank);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::deleteD2BiobanksNotExistingInLdap] Error deleting Biobanks not in LDAP.");
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP deltetions: " + biobanks.size() + " Biobanks deleted.");
	}
	
	/**
	 * 
	 * @param uuid
	 * @param groupId
	 */
	private void deleteD2CollectionNotExistingInLdap(String uuid, long groupId) {
		List<D2Collection> collections = D2CollectionLocalServiceUtil.getLDAPNotUpdatedCollection(groupId, uuid);
		for(D2Collection collection : collections) {
			try {
				D2CollectionLocalServiceUtil.deleteD2Collection(collection);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::deleteD2CollectionNotExistingInLdap] Error deleting Collections not in LDAP.");
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP deltetions: " + collections.size() + " Collections deleted.");
	}
	
	/**
	 * 
	 * @param uuid
	 * @param groupId
	 */
	private void deleteD2BiobankNetworksNotExistingInLdap(String uuid, long groupId) {
		List<D2BiobankNetwork> networks = D2BiobankNetworkLocalServiceUtil.getLDAPNotUpdatedNetworks(groupId, uuid);
		for(D2BiobankNetwork network : networks) {
			try {
				D2BiobankNetworkLocalServiceUtil.deleteD2BiobankNetwork(network);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::deleteD2CollectionNotExistingInLdap] Error deleting Collections not in LDAP.");
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP deltetions: " + networks.size() + " Networks deleted.");
	}
	
	/**
	 * 
	 * @param uuid
	 * @param groupId
	 */
	private void deleteD2BiobankNetworkLinksNotExistingInLdap(String uuid, long groupId) {
		List<D2BiobankNetworkLink> networkslinks = D2BiobankNetworkLinkLocalServiceUtil.getLDAPNotUpdatedNetworkLinks(groupId, uuid);
		for(D2BiobankNetworkLink networkslink : networkslinks) {
			try {
				D2BiobankNetworkLinkLocalServiceUtil.deleteD2BiobankNetworkLink(networkslink);
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::deleteD2BiobankNetworkLinksNotExistingInLdap] Error deleting Network Link not in LDAP.");
				ex.printStackTrace();
			}
		}
		System.out.println("LDAP deltetions: " + networkslinks.size() + " Network Links deleted.");
	}
	
	
	
	//--------------------------------------------------------------------------------
	/**
	 * 
	 * @param ldapbiobankID
	 * @param serviceContext
	 * @param attrs
	 * @param ldapupdateuuid
	 */
	private void addBiobank(String ldapbiobankID, ServiceContext serviceContext, Attributes attrs, String ldapupdateuuid) {
		serviceContext.setCreateDate(new Date());
        serviceContext.setModifiedDate(new Date());
        D2BiobankImpl d2biobank = new D2BiobankImpl();
        // Mandatory Fields
        d2biobank.setBiobankName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
        d2biobank.setBbmribiobankID(ldapbiobankID);
        d2biobank.setUpdateuuid(ldapupdateuuid);
        d2biobank.setContactIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactIDRef")));
        d2biobank.setContactPriority(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("contactPriority")));
        d2biobank.setBiobankJurisdicalPerson(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankJuridicalPerson")));
        d2biobank.setBiobankCountry(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankCountry")));
        d2biobank.setBiobankPartnerCharterSigned(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankPartnerCharterSigned")));
        // Optional Fields
        d2biobank.setBioresourceReference(LDAPAttributeEscaper.getAttributeValues(attrs.get("bioresourceReference")));
        d2biobank.setBiobankNetworkIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkIDRef")));
        d2biobank.setGeoLatitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLatitude")));
        d2biobank.setGeoLongitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLongitude")));
        d2biobank.setCollaborationPartnersCommercial(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersCommercial")));
        d2biobank.setCollaborationPartnersNonforprofit(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersNonforprofit")));
        d2biobank.setBiobankITSupportAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankITSupportAvailable")));
        d2biobank.setBiobankITStaffSize(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("biobankITStaffSize")));
        d2biobank.setBiobankISAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankISAvailable")));
        d2biobank.setBiobankHISAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankHISAvailable")));
        d2biobank.setBiobankAcronym(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankAcronym")));
        d2biobank.setBiobankDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankDescription")));
        d2biobank.setBiobankURL(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankURL")));
        d2biobank.setBiobankHeadFirstName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadFirstName")));
        d2biobank.setBiobankHeadLastName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadLastName")));
        d2biobank.setBiobankHeadRole(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadRole")));
        String types = LDAPAttributeEscaper.getAttributeValues(attrs.get("objectClass"));
        d2biobank.setBiobankType(types);
        if(types.contains("biobankClinical")) {
        	d2biobank.setBiobankClinical(true);
        } else {
        	d2biobank.setBiobankClinical(false);
        }
        if(types.contains("biobankPopulation")) {
        	d2biobank.setBiobankPopulation(true);
        } else {
        	d2biobank.setBiobankPopulation(false);
        }
        if(types.contains("biobankResearchStudy")) {
        	d2biobank.setBiobankResearchStudy(true);
        } else {
        	d2biobank.setBiobankResearchStudy(false);
        }
        if(types.contains("biobankNonHuman")) {
        	d2biobank.setBiobankNonHuman(true);
        } else {
        	d2biobank.setBiobankNonHuman(false);
        }
        if(types.contains("biobankCollection")) {
        	d2biobank.setBiobankCollection(true);
        } else {
        	d2biobank.setBiobankCollection(false);
        }
        D2BiobankLocalServiceUtil.addD2Biobank(d2biobank, serviceContext);
	}
	
	private void updateBiobank(String ldapbiobankID, ServiceContext serviceContext, Attributes attrs, String ldapupdateuuid) {
		serviceContext.setModifiedDate(new Date());
        D2Biobank d2biobank =D2BiobankLocalServiceUtil.getD2BiobankByBBMRIERICID(serviceContext.getScopeGroupId(), ldapbiobankID);
        // Mandatory Fields
        d2biobank.setBiobankName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
        d2biobank.setBbmribiobankID(ldapbiobankID);
        d2biobank.setUpdateuuid(ldapupdateuuid);
        d2biobank.setContactIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactIDRef")));
        d2biobank.setContactPriority(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("contactPriority")));
        d2biobank.setBiobankJurisdicalPerson(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankJuridicalPerson")));
        d2biobank.setBiobankCountry(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankCountry")));
        d2biobank.setBiobankPartnerCharterSigned(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankPartnerCharterSigned")));
        // Optional Fields
        d2biobank.setBioresourceReference(LDAPAttributeEscaper.getAttributeValues(attrs.get("bioresourceReference")));
        d2biobank.setBiobankNetworkIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkIDRef")));
        d2biobank.setGeoLatitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLatitude")));
        d2biobank.setGeoLongitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLongitude")));
        d2biobank.setCollaborationPartnersCommercial(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersCommercial")));
        d2biobank.setCollaborationPartnersNonforprofit(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("collaborationPartnersNonforprofit")));
        d2biobank.setBiobankITSupportAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankITSupportAvailable")));
        d2biobank.setBiobankITStaffSize(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("biobankITStaffSize")));
        d2biobank.setBiobankISAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankISAvailable")));
        d2biobank.setBiobankHISAvailable(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankHISAvailable")));
        d2biobank.setBiobankAcronym(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankAcronym")));
        d2biobank.setBiobankDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankDescription")));
        d2biobank.setBiobankURL(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankURL")));
        d2biobank.setBiobankHeadFirstName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadFirstName")));
        d2biobank.setBiobankHeadLastName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadLastName")));
        d2biobank.setBiobankHeadRole(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankHeadRole")));
        String types = LDAPAttributeEscaper.getAttributeValues(attrs.get("objectClass"));
        d2biobank.setBiobankType(types);
        if(types.contains("biobankClinical")) {
        	d2biobank.setBiobankClinical(true);
        } else {
        	d2biobank.setBiobankClinical(false);
        }
        if(types.contains("biobankPopulation")) {
        	d2biobank.setBiobankPopulation(true);
        } else {
        	d2biobank.setBiobankPopulation(false);
        }
        if(types.contains("biobankResearchStudy")) {
        	d2biobank.setBiobankResearchStudy(true);
        } else {
        	d2biobank.setBiobankResearchStudy(false);
        }
        if(types.contains("biobankNonHuman")) {
        	d2biobank.setBiobankNonHuman(true);
        } else {
        	d2biobank.setBiobankNonHuman(false);
        }
        if(types.contains("biobankCollection")) {
        	d2biobank.setBiobankCollection(true);
        } else {
        	d2biobank.setBiobankCollection(false);
        }
        D2BiobankLocalServiceUtil.updateD2Biobank(d2biobank, serviceContext);
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
						String ldapbiobankID = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankID"));
						BioBank biobank = BioBankLocalServiceUtil.getBioBank(ldapbiobankID);
						if(biobank == null) {
							biobank = BioBankLocalServiceUtil.createBioBank(ldapbiobankID);
							biobank = BioBankLocalServiceUtil.addBioBank(biobank);
							Organization organization = createOrganization(attrs);
							biobank.setOrganisationid(organization.getOrganizationId());
							biobank.setUUID(uuid);
							BioBankLocalServiceUtil.updateBioBank(biobank);
						}
						
						biobank.setBiobankcountry(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankCountry")));
						biobank.setBiobankjuristicperson(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankJuridicalPerson")));
						biobank.setBiobankname(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
						
						biobank.setBiobanktype(LDAPAttributeEscaper.getAttributeValues(attrs.get("objectClass")));
						biobank.setBiobanksize(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankSize")));
						biobank.setUUID(uuid);
						BioBankLocalServiceUtil.updateBioBank(biobank);
						
						//System.out.println("Update Biobank:" + biobank.getBiobankname() + ", with Organization ID: " + biobank.getOrganisationid());
						
						if(biobank.getOrganisationid() == 0) {
							BioBankLocalServiceUtil.deleteBioBank(biobank);
							continue;
						}
						createSearchIndex(attrs, biobank, uuid);
					}
				} catch (Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error Creating Entrys for Biobank: " + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName")));
					ex.printStackTrace();
				}
			}
			System.out.println("LDAP contained: " + counter + " entrys with " + counter_biobanks + " Biobanks.");
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error reading data from LDAP Server.");
			ex.printStackTrace();
		}
		
		try {
			deleteSearchIndexNotUpdated(uuid);
			deleteBioBanksNotUpdated(uuid);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::connectLDAP] Error deleting not updated Entries.");
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::createSearchIndex] Error creating search index.");
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::createSearchIndex] Error creating search index.");
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
					String value = LDAPAttributeEscaper.getAttributeValues(attrs.get(attr.getID()));
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
									+ "] [error] [" + classpath_ + "::createSearchIndex] Error creating search index.");
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			System.err
					.println("["
							+ date_format_apache_error.format(new Date())
							+ "] [error] [" + classpath_ + "::createSearchIndex] Error reading Element atrributes.");
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
			
			String parentname = "BBMRI." + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankCountry")).toLowerCase();
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
	        String name = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankID")) + "__" + LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankName"));
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
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getAttributeValues] Error getting Attributes " + attrs.toString() + ".");
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addEmail] Error more than one Email for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addEmail] Error creating email; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
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
			String url = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankURL"));
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addWebpage] Error more than one webpage for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addWebpage] Error creating webpage; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
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
			String phonenumber = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactPhone"));
			
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addPhone] Error more than one phone for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addPhone] Error more than one phone for the user; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addPhone] Error creating phone; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
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
			String city = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactCity"));
			String zip = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactZIP"));
			
			int end = 0;
			int start = 0;
			String addressstring = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactAddress"));
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
			long countryId = CountryServiceUtil.getCountryByA2(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankCountry"))).getCountryId();
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addAddress] Error more than one address for the organization; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
			
			// Update User Address
			serviceContext.setScopeGroupId(user.getGroup().getGroupId());
			countryId = CountryServiceUtil.getCountryByA2(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactCountry"))).getCountryId();
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addAddress] Error more than one address for the user; Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
			}
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addAddress] Error creating address Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ", UserID: " + user.getUserId() + ".");
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
			String email = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactEmail"));
			String firstname = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactEmail"));
			String lastname = LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankContactEmail"));
			User user = null;
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(organization.getCompanyId(), email);
			} catch (Exception ex) {
				System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::addUser] No user exist with email: " + email + ".");
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
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addUser] Error Adding user to Organization Attributes: " + attrs.toString() + ", OrganizationID: " + organization.getOrganizationId() + ".");
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
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::removeUsersFromOrganization] Error removing users from Organization (" + organization.getOrganizationId() + ").");
			ex.printStackTrace();
		}
	}

}
