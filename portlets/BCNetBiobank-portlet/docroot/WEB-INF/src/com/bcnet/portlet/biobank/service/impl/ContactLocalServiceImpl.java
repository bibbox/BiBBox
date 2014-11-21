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

package com.bcnet.portlet.biobank.service.impl;

import java.util.List;

import com.bcnet.portlet.biobank.NoSuchContactException;
import com.bcnet.portlet.biobank.model.Contact;
import com.bcnet.portlet.biobank.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.ContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.ContactLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.ContactLocalServiceUtil
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.ContactLocalServiceUtil} to access the contact local service.
	 */

	public Contact addContact(String firstName, String lastName, String phone, String email, String address,
			String zip, String city, String countryCode, long juristicPersonId, String department, String orcId) 
					throws SystemException{

		long contactId = counterLocalService.increment(Contact.class.getName());

		Contact contact = contactPersistence.create(contactId);

		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setAddress(address);
		contact.setZip(zip);
		contact.setCity(city);
		contact.setCountryCode(countryCode);
		contact.setJuristicPersonId(juristicPersonId);
		contact.setDepartment(department);
		contact.setOrcId(orcId);

		super.addContact(contact);

		return contact;

	}


	public Contact deleteContact(Contact contact) throws SystemException{

		return contactPersistence.remove(contact);
	}

	public Contact deleteContact(long contactId) throws NoSuchContactException, SystemException{

		Contact contact = contactPersistence.findByPrimaryKey(contactId);
		return deleteContact(contact);
	}

	public Contact getContact(long contactId) throws NoSuchContactException, SystemException{

		return contactPersistence.findByPrimaryKey(contactId);
	}

	public List<Contact> getAllContacts() throws SystemException{

		return contactPersistence.findAll();
	}

	public List<Contact> getAllContacts(int start, int end) throws SystemException{

		return contactPersistence.findAll(start, end);
	}
	
	public Contact updateContact(long contactId, String firstName, String lastName, String phone,
			String email, String address, String zip, String city, String countryCode,
			long juristicPersonId, String department, String orcId) throws SystemException{
		
		Contact contact = contactPersistence.fetchByPrimaryKey(contactId);
		
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setAddress(address);
		contact.setZip(zip);
		contact.setCity(city);
		contact.setCountryCode(countryCode);
		contact.setJuristicPersonId(juristicPersonId);
		contact.setDepartment(department);
		contact.setOrcId(orcId);
		
		super.updateContact(contact);
		
		return contact;
		
	}
}