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

import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.ContactLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suyama
 */
public class ContactClp extends BaseModelImpl<Contact> implements Contact {
	public ContactClp() {
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
	public long getPrimaryKey() {
		return _contactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_contactRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_contactRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_contactRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_contactRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_contactRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_contactRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZip() {
		return _zip;
	}

	@Override
	public void setZip(String zip) {
		_zip = zip;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", String.class);

				method.invoke(_contactRemoteModel, zip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_contactRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_contactRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJuristicPersonId() {
		return _juristicPersonId;
	}

	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPersonId = juristicPersonId;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setJuristicPersonId",
						long.class);

				method.invoke(_contactRemoteModel, juristicPersonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartment() {
		return _department;
	}

	@Override
	public void setDepartment(String department) {
		_department = department;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_contactRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrcId() {
		return _orcId;
	}

	@Override
	public void setOrcId(String orcId) {
		_orcId = orcId;

		if (_contactRemoteModel != null) {
			try {
				Class<?> clazz = _contactRemoteModel.getClass();

				Method method = clazz.getMethod("setOrcId", String.class);

				method.invoke(_contactRemoteModel, orcId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactRemoteModel() {
		return _contactRemoteModel;
	}

	public void setContactRemoteModel(BaseModel<?> contactRemoteModel) {
		_contactRemoteModel = contactRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _contactRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_contactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactLocalServiceUtil.addContact(this);
		}
		else {
			ContactLocalServiceUtil.updateContact(this);
		}
	}

	@Override
	public Contact toEscapedModel() {
		return (Contact)ProxyUtil.newProxyInstance(Contact.class.getClassLoader(),
			new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactClp clone = new ContactClp();

		clone.setContactId(getContactId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setPhone(getPhone());
		clone.setEmail(getEmail());
		clone.setAddress(getAddress());
		clone.setZip(getZip());
		clone.setCity(getCity());
		clone.setCountryCode(getCountryCode());
		clone.setJuristicPersonId(getJuristicPersonId());
		clone.setDepartment(getDepartment());
		clone.setOrcId(getOrcId());

		return clone;
	}

	@Override
	public int compareTo(Contact contact) {
		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactClp)) {
			return false;
		}

		ContactClp contact = (ContactClp)obj;

		long primaryKey = contact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", juristicPersonId=");
		sb.append(getJuristicPersonId());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", orcId=");
		sb.append(getOrcId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.Contact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>juristicPersonId</column-name><column-value><![CDATA[");
		sb.append(getJuristicPersonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orcId</column-name><column-value><![CDATA[");
		sb.append(getOrcId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _contactRemoteModel;
}