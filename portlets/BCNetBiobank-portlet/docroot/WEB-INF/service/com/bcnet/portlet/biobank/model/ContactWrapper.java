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

package com.bcnet.portlet.biobank.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author suyama
 * @see Contact
 * @generated
 */
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
	public ContactWrapper(Contact contact) {
		_contact = contact;
	}

	@Override
	public Class<?> getModelClass() {
		return Contact.class;
	}

	@Override
	public String getModelClassName() {
		return Contact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("zip", getZip());
		attributes.put("city", getCity());
		attributes.put("countryCode", getCountryCode());
		attributes.put("juristicPersonId", getJuristicPersonId());
		attributes.put("department", getDepartment());
		attributes.put("orcId", getOrcId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		Long juristicPersonId = (Long)attributes.get("juristicPersonId");

		if (juristicPersonId != null) {
			setJuristicPersonId(juristicPersonId);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String orcId = (String)attributes.get("orcId");

		if (orcId != null) {
			setOrcId(orcId);
		}
	}

	/**
	* Returns the primary key of this contact.
	*
	* @return the primary key of this contact
	*/
	@Override
	public long getPrimaryKey() {
		return _contact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact.
	*
	* @param primaryKey the primary key of this contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this contact.
	*
	* @return the contact ID of this contact
	*/
	@Override
	public long getContactId() {
		return _contact.getContactId();
	}

	/**
	* Sets the contact ID of this contact.
	*
	* @param contactId the contact ID of this contact
	*/
	@Override
	public void setContactId(long contactId) {
		_contact.setContactId(contactId);
	}

	/**
	* Returns the first name of this contact.
	*
	* @return the first name of this contact
	*/
	@Override
	public java.lang.String getFirstName() {
		return _contact.getFirstName();
	}

	/**
	* Sets the first name of this contact.
	*
	* @param firstName the first name of this contact
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_contact.setFirstName(firstName);
	}

	/**
	* Returns the last name of this contact.
	*
	* @return the last name of this contact
	*/
	@Override
	public java.lang.String getLastName() {
		return _contact.getLastName();
	}

	/**
	* Sets the last name of this contact.
	*
	* @param lastName the last name of this contact
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_contact.setLastName(lastName);
	}

	/**
	* Returns the phone of this contact.
	*
	* @return the phone of this contact
	*/
	@Override
	public java.lang.String getPhone() {
		return _contact.getPhone();
	}

	/**
	* Sets the phone of this contact.
	*
	* @param phone the phone of this contact
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_contact.setPhone(phone);
	}

	/**
	* Returns the email of this contact.
	*
	* @return the email of this contact
	*/
	@Override
	public java.lang.String getEmail() {
		return _contact.getEmail();
	}

	/**
	* Sets the email of this contact.
	*
	* @param email the email of this contact
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_contact.setEmail(email);
	}

	/**
	* Returns the address of this contact.
	*
	* @return the address of this contact
	*/
	@Override
	public java.lang.String getAddress() {
		return _contact.getAddress();
	}

	/**
	* Sets the address of this contact.
	*
	* @param address the address of this contact
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_contact.setAddress(address);
	}

	/**
	* Returns the zip of this contact.
	*
	* @return the zip of this contact
	*/
	@Override
	public java.lang.String getZip() {
		return _contact.getZip();
	}

	/**
	* Sets the zip of this contact.
	*
	* @param zip the zip of this contact
	*/
	@Override
	public void setZip(java.lang.String zip) {
		_contact.setZip(zip);
	}

	/**
	* Returns the city of this contact.
	*
	* @return the city of this contact
	*/
	@Override
	public java.lang.String getCity() {
		return _contact.getCity();
	}

	/**
	* Sets the city of this contact.
	*
	* @param city the city of this contact
	*/
	@Override
	public void setCity(java.lang.String city) {
		_contact.setCity(city);
	}

	/**
	* Returns the country code of this contact.
	*
	* @return the country code of this contact
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _contact.getCountryCode();
	}

	/**
	* Sets the country code of this contact.
	*
	* @param countryCode the country code of this contact
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_contact.setCountryCode(countryCode);
	}

	/**
	* Returns the juristic person ID of this contact.
	*
	* @return the juristic person ID of this contact
	*/
	@Override
	public long getJuristicPersonId() {
		return _contact.getJuristicPersonId();
	}

	/**
	* Sets the juristic person ID of this contact.
	*
	* @param juristicPersonId the juristic person ID of this contact
	*/
	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_contact.setJuristicPersonId(juristicPersonId);
	}

	/**
	* Returns the department of this contact.
	*
	* @return the department of this contact
	*/
	@Override
	public java.lang.String getDepartment() {
		return _contact.getDepartment();
	}

	/**
	* Sets the department of this contact.
	*
	* @param department the department of this contact
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_contact.setDepartment(department);
	}

	/**
	* Returns the orc ID of this contact.
	*
	* @return the orc ID of this contact
	*/
	@Override
	public java.lang.String getOrcId() {
		return _contact.getOrcId();
	}

	/**
	* Sets the orc ID of this contact.
	*
	* @param orcId the orc ID of this contact
	*/
	@Override
	public void setOrcId(java.lang.String orcId) {
		_contact.setOrcId(orcId);
	}

	@Override
	public boolean isNew() {
		return _contact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactWrapper((Contact)_contact.clone());
	}

	@Override
	public int compareTo(com.bcnet.portlet.biobank.model.Contact contact) {
		return _contact.compareTo(contact);
	}

	@Override
	public int hashCode() {
		return _contact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.Contact> toCacheModel() {
		return _contact.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.Contact toEscapedModel() {
		return new ContactWrapper(_contact.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.Contact toUnescapedModel() {
		return new ContactWrapper(_contact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactWrapper)) {
			return false;
		}

		ContactWrapper contactWrapper = (ContactWrapper)obj;

		if (Validator.equals(_contact, contactWrapper._contact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contact getWrappedContact() {
		return _contact;
	}

	@Override
	public Contact getWrappedModel() {
		return _contact;
	}

	@Override
	public void resetOriginalValues() {
		_contact.resetOriginalValues();
	}

	private Contact _contact;
}