/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationImpl;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.ContactInformationLocalServiceBaseImpl;
import at.meduni.liferay.portlet.bbmrieric.util.LDAPAttributeEscaper;

/**
 * The implementation of the contact information local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.ContactInformationLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil
 */
public class ContactInformationLocalServiceImpl
	extends ContactInformationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil} to access the contact information local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String classpath_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.ContactInformationLocalServiceImpl";
	
	/**
	 * 
	 * @param contactinformation
	 * @param serviceContext
	 * @return
	 */
	public ContactInformation addContactInformation(ContactInformation contactinformation, ServiceContext serviceContext) {
		return addContactInformation(contactinformation.getContactinformationId(), contactinformation.getCompanyId(), contactinformation.getGroupId(), contactinformation.getUserId(),
				contactinformation.getContactID(), contactinformation.getContactEmail(), contactinformation.getContactCountry(),
				contactinformation.getContactFirstName(), contactinformation.getContactLastName(), contactinformation.getContactPhone(), contactinformation.getContactAddress(), contactinformation.getContactZIP(),
				contactinformation.getContactCity(), contactinformation.getUpdateuuid(), serviceContext);
	}
	
	/**
	 * 
	 * @param contactinformationId
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param contactID
	 * @param contactEmail
	 * @param contactCountry
	 * @param contactFirstName
	 * @param contactLastName
	 * @param contactPhone
	 * @param contactAddress
	 * @param contactZIP
	 * @param contactCity
	 * @param serviceContext
	 * @return
	 */
	public ContactInformation addContactInformation(long contactinformationId, long companyId, long groupId, long userId, String contactID, String contactEmail, String contactCountry,
								String contactFirstName, String contactLastName, String contactPhone, String contactAddress, String contactZIP,
								String contactCity, String updateuuid, ServiceContext serviceContext) {
		try {
			if(contactinformationId == 0) {
				contactinformationId = counterLocalService.increment();
			}
			ContactInformation contactinformation = contactInformationPersistence.create(contactinformationId);
			if(companyId == 0) {
				companyId =serviceContext.getCompanyId();
			}
			if(groupId == 0) {
				groupId = serviceContext.getScopeGroupId();
			}
			if(userId == 0) {
				userId =serviceContext.getUserId();
			}
			System.out.println("ContactinformationId: " +contactinformation.getContactinformationId());
			Date now = new Date();
			contactinformation.setCreateDate(serviceContext.getCreateDate(now));
			contactinformation.setModifiedDate(serviceContext.getModifiedDate(now));
			contactinformation.setUserId(userId);
			contactinformation.setGroupId(groupId);
			contactinformation.setCompanyId(companyId);
			contactinformation.setUpdateuuid(updateuuid);
			// Mandatory Fields
			contactinformation.setContactID(contactID);
			contactinformation.setContactEmail(contactEmail);
			contactinformation.setContactCountry(contactCountry);
			// Set optional fields
			contactinformation.setContactFirstName(contactFirstName);
			contactinformation.setContactLastName(contactLastName);
			contactinformation.setContactPhone(contactPhone);
			contactinformation.setContactAddress(contactAddress);
			contactinformation.setContactZIP(contactZIP);
			contactinformation.setContactCity(contactCity);
			contactInformationPersistence.update(contactinformation);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::addContactInformation] Error creating ContactInformation with (ContactInformation contactinformation, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param contactinformation
	 * @param serviceContext
	 * @return
	 */
	public ContactInformation updateContactInformation(ContactInformation contactinformation, ServiceContext serviceContext) {
		try {
			if(contactinformation.getUserId() == 0) {
				contactinformation.setUserId(serviceContext.getUserId());
			}
			Date now = new Date();
			contactinformation.setModifiedDate(serviceContext.getModifiedDate(now));
			return contactInformationPersistence.update(contactinformation);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateContactInformation] Error creating ContactInformation with (ContactInformation contactfnformation, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param contactinformationId
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param contactID
	 * @param contactEmail
	 * @param contactCountry
	 * @param contactFirstName
	 * @param contactLastName
	 * @param contactPhone
	 * @param contactAddress
	 * @param contactZIP
	 * @param contactCity
	 * @param serviceContext
	 * @return
	 */
	public ContactInformation updateContactInformation(long contactinformationId, long companyId, long groupId, long userId, String contactID, String contactEmail, String contactCountry,
			String contactFirstName, String contactLastName, String contactPhone, String contactAddress, String contactZIP,
			String contactCity, String updateuuid, ServiceContext serviceContext) {
		try {
			ContactInformation contactinformation = ContactInformationLocalServiceUtil.getContactInformation(contactinformationId);
			if(contactinformation.getUserId() == 0) {
				contactinformation.setUserId(serviceContext.getUserId());
			}
			Date now = new Date();
			contactinformation.setModifiedDate(serviceContext.getModifiedDate(now));
			contactinformation.setUpdateuuid(updateuuid);
			// Mandatory Fields
			contactinformation.setContactID(contactID);
			contactinformation.setContactEmail(contactEmail);
			contactinformation.setContactCountry(contactCountry);
			// Set optional fields
			contactinformation.setContactFirstName(contactFirstName);
			contactinformation.setContactLastName(contactLastName);
			contactinformation.setContactPhone(contactPhone);
			contactinformation.setContactAddress(contactAddress);
			contactinformation.setContactZIP(contactZIP);
			contactinformation.setContactCity(contactCity);
			return contactInformationPersistence.update(contactinformation);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::updateContactInformation] Error creating ContactInformation with (ContactInformation contactinformation, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Convenience function to get a Object from the LDAP attributes
	 * ------
	 * Function to convert the LDAP Attributes for ContactInformation
	 * into a ContactInformation Object. The function can update an 
	 * existing object or if NULL is handed to the function a new
	 * object is created.
	 * 
	 * @param attrs
	 * @param contactinformation
	 * @return
	 */
	public ContactInformation contactInformationFromLdapAttribute(Attributes attrs, ContactInformation contactinformation) {
		if(contactinformation == null) {
			contactinformation = new ContactInformationImpl();
		}
		contactinformation.setContactID(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactID")));
		contactinformation.setContactEmail(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactEmail")));
		contactinformation.setContactCountry(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactCountry")));
		contactinformation.setContactFirstName(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactFirstName")));
		contactinformation.setContactLastName(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactLastName")));
		contactinformation.setContactPhone(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactPhone")));
		contactinformation.setContactAddress(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactAddress")));
		contactinformation.setContactZIP(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactZIP")));
		contactinformation.setContactCity(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactCity")));
		return contactinformation;
	}
	
	/**
	 * 
	 * @param contactinformationId
	 * @return
	 */
	public ContactInformation getContactInformationWithLdapUpdate(long contactinformationId) {
		try {
			ContactInformation contactinformation = ContactInformationLocalServiceUtil.getContactInformation(contactinformationId);
			// ServiceContext to create the assets
			long companyId = Long.parseLong(PropsUtil.get("D2BiobankCompany"));
			long groupId = Long.parseLong(PropsUtil.get("D2BiobankGroup"));
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
			environment.put(LdapContext.CONTROL_FACTORIES,
					"com.sun.jndi.ldap.ControlFactory");
			environment.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.ldap.LdapCtxFactory");
			environment.put(Context.PROVIDER_URL,
					"ldap://directory.bbmri-eric.eu:10389");
			environment.put(Context.SECURITY_AUTHENTICATION, "simple");
			environment.put(Context.REFERRAL, "follow");
			try {
				Date now = new Date();
				contactinformation.setModifiedDate(serviceContext.getModifiedDate(now));
				

				DirContext ctx = new InitialDirContext(environment);
				SearchControls ctls = new SearchControls();
				ctls.setReturningAttributes(null);
				ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				// Search for objects using filter and controls
				NamingEnumeration<?> answer = ctx.search("contactID=" + contactinformation.getContactID() + ",c=" + contactinformation.getContactCountry().toLowerCase() + ",ou=contacts,dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
				int counter = 0;
				int counter_contacts = 0;
				while (answer.hasMore()) {
					counter++;
					SearchResult sr = (SearchResult) answer.next();
					Attributes attrs = sr.getAttributes();
					contactinformation = ContactInformationLocalServiceUtil.contactInformationFromLdapAttribute(attrs, contactinformation);
					return contactInformationPersistence.update(contactinformation);
				}
			} catch (Exception ex) {
				System.err.println("["+ date_format_apache_error.format(new Date())+ "] [error] [" + classpath_ + "::getContactInformationWithLdapUpdate] Error updating ContactInformation Attributes");
				ex.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getContactInformationWithLdapUpdate] Error getting ContactInformation with LDAP update.");
			e.printStackTrace();
		}
		return null;
	}
	
	public ContactInformation getContactInformationWithLdapUpdate(String contactID) {
		try {
			long companyId = Long.parseLong(PropsUtil.get("D2BiobankCompany"));
			long groupId = Long.parseLong(PropsUtil.get("D2BiobankGroup"));
			ContactInformation contactinformation = ContactInformationLocalServiceUtil.getContactInformationByBBMRIERICID(groupId, contactID);
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
			environment.put(LdapContext.CONTROL_FACTORIES,
					"com.sun.jndi.ldap.ControlFactory");
			environment.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.ldap.LdapCtxFactory");
			environment.put(Context.PROVIDER_URL,
					"ldap://directory.bbmri-eric.eu:10389");
			environment.put(Context.SECURITY_AUTHENTICATION, "simple");
			environment.put(Context.REFERRAL, "follow");
			try {
				Date now = new Date();
				contactinformation.setModifiedDate(serviceContext.getModifiedDate(now));

				DirContext ctx = new InitialDirContext(environment);
				SearchControls ctls = new SearchControls();
				ctls.setReturningAttributes(null);
				ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				// Search for objects using filter and controls
				NamingEnumeration<?> answer = ctx.search("contactID=" + contactinformation.getContactID() + ",c=" + contactinformation.getContactCountry().toLowerCase() + ",ou=contacts,dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
				int counter = 0;
				int counter_contacts = 0;
				while (answer.hasMore()) {
					counter++;
					SearchResult sr = (SearchResult) answer.next();
					Attributes attrs = sr.getAttributes();
					contactinformation = ContactInformationLocalServiceUtil.contactInformationFromLdapAttribute(attrs, contactinformation);
					return contactInformationPersistence.update(contactinformation);
				}
			} catch (Exception ex) {
				System.err.println("["+ date_format_apache_error.format(new Date())+ "] [error] [" + classpath_ + "::getContactInformationWithLdapUpdate] Error updating ContactInformation Attributes");
				ex.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classpath_ + "::getContactInformationWithLdapUpdate] Error getting ContactInformation with LDAP update.");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param contactID
	 * @return
	 */
	public ContactInformation getContactInformationByBBMRIERICID(long groupId, String contactID) {
		try {
			return contactInformationPersistence.findByContactBBMRIERICID(groupId, contactID);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [" + classpath_ + "::getContactInformationByBBMRIERICID] No ContactInformation exists with (groupId: " + groupId + ",  contactID: " + contactID + ".");
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param updateuuid
	 * @return
	 */
	public List<ContactInformation> getLDAPNotUpdatedContactInformation(long groupId, String updateuuid) {
		try {
			return contactInformationPersistence.findByNotUUID(groupId, updateuuid);
		} catch (Exception ex) {
			 
		}
		return null;
	}
}