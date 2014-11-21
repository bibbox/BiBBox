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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.ContactServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.ContactServiceSoap
 * @generated
 */
public class ContactSoap implements Serializable {
	public static ContactSoap toSoapModel(Contact model) {
		ContactSoap soapModel = new ContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setPhone(model.getPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setZip(model.getZip());
		soapModel.setCity(model.getCity());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setJuristicPersonId(model.getJuristicPersonId());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setOrcId(model.getOrcId());

		return soapModel;
	}

	public static ContactSoap[] toSoapModels(Contact[] models) {
		ContactSoap[] soapModels = new ContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[][] toSoapModels(Contact[][] models) {
		ContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactSoap[] toSoapModels(List<Contact> models) {
		List<ContactSoap> soapModels = new ArrayList<ContactSoap>(models.size());

		for (Contact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactSoap[soapModels.size()]);
	}

	public ContactSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public long getJuristicPersonId() {
		return _juristicPersonId;
	}

	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPersonId = juristicPersonId;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getOrcId() {
		return _orcId;
	}

	public void setOrcId(String orcId) {
		_orcId = orcId;
	}

	private long _contactId;
	private String _firstName;
	private String _lastName;
	private String _phone;
	private String _email;
	private String _address;
	private String _zip;
	private String _city;
	private String _countryCode;
	private long _juristicPersonId;
	private String _department;
	private String _orcId;
}