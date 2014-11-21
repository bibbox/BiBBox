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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.Contact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author suyama
 * @see Contact
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", city=");
		sb.append(city);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", juristicPersonId=");
		sb.append(juristicPersonId);
		sb.append(", department=");
		sb.append(department);
		sb.append(", orcId=");
		sb.append(orcId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contact toEntityModel() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setContactId(contactId);

		if (firstName == null) {
			contactImpl.setFirstName(StringPool.BLANK);
		}
		else {
			contactImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			contactImpl.setLastName(StringPool.BLANK);
		}
		else {
			contactImpl.setLastName(lastName);
		}

		if (phone == null) {
			contactImpl.setPhone(StringPool.BLANK);
		}
		else {
			contactImpl.setPhone(phone);
		}

		if (email == null) {
			contactImpl.setEmail(StringPool.BLANK);
		}
		else {
			contactImpl.setEmail(email);
		}

		if (address == null) {
			contactImpl.setAddress(StringPool.BLANK);
		}
		else {
			contactImpl.setAddress(address);
		}

		if (zip == null) {
			contactImpl.setZip(StringPool.BLANK);
		}
		else {
			contactImpl.setZip(zip);
		}

		if (city == null) {
			contactImpl.setCity(StringPool.BLANK);
		}
		else {
			contactImpl.setCity(city);
		}

		if (countryCode == null) {
			contactImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			contactImpl.setCountryCode(countryCode);
		}

		contactImpl.setJuristicPersonId(juristicPersonId);

		if (department == null) {
			contactImpl.setDepartment(StringPool.BLANK);
		}
		else {
			contactImpl.setDepartment(department);
		}

		if (orcId == null) {
			contactImpl.setOrcId(StringPool.BLANK);
		}
		else {
			contactImpl.setOrcId(orcId);
		}

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contactId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		zip = objectInput.readUTF();
		city = objectInput.readUTF();
		countryCode = objectInput.readUTF();
		juristicPersonId = objectInput.readLong();
		department = objectInput.readUTF();
		orcId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contactId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (zip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		objectOutput.writeLong(juristicPersonId);

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (orcId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orcId);
		}
	}

	public long contactId;
	public String firstName;
	public String lastName;
	public String phone;
	public String email;
	public String address;
	public String zip;
	public String city;
	public String countryCode;
	public long juristicPersonId;
	public String department;
	public String orcId;
}