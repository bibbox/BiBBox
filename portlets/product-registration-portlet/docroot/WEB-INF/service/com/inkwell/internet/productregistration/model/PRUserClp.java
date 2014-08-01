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

package com.inkwell.internet.productregistration.model;

import com.inkwell.internet.productregistration.service.ClpSerializer;
import com.inkwell.internet.productregistration.service.PRUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rich Sezov
 */
public class PRUserClp extends BaseModelImpl<PRUser> implements PRUser {
	public PRUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PRUser.class;
	}

	@Override
	public String getModelClassName() {
		return PRUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _prUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPrUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _prUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("prUserId", getPrUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("postalCode", getPostalCode());
		attributes.put("country", getCountry());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("email", getEmail());
		attributes.put("birthDate", getBirthDate());
		attributes.put("male", getMale());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long prUserId = (Long)attributes.get("prUserId");

		if (prUserId != null) {
			setPrUserId(prUserId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getPrUserId() {
		return _prUserId;
	}

	@Override
	public void setPrUserId(long prUserId) {
		_prUserId = prUserId;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPrUserId", long.class);

				method.invoke(_prUserRemoteModel, prUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getPrUserId(), "uuid", _prUserUuid);
	}

	@Override
	public void setPrUserUuid(String prUserUuid) {
		_prUserUuid = prUserUuid;
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_prUserRemoteModel, firstName);
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

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_prUserRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress1() {
		return _address1;
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_prUserRemoteModel, address1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress2() {
		return _address2;
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress2", String.class);

				method.invoke(_prUserRemoteModel, address2);
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

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_prUserRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_prUserRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_prUserRemoteModel, postalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_prUserRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneNumber", String.class);

				method.invoke(_prUserRemoteModel, phoneNumber);
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

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_prUserRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthDate", Date.class);

				method.invoke(_prUserRemoteModel, birthDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMale() {
		return _male;
	}

	@Override
	public boolean isMale() {
		return _male;
	}

	@Override
	public void setMale(boolean male) {
		_male = male;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setMale", boolean.class);

				method.invoke(_prUserRemoteModel, male);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_prUserRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_prUserRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_prUserRemoteModel != null) {
			try {
				Class<?> clazz = _prUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_prUserRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getGender() {
		try {
			String methodName = "getGender";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setGender(java.lang.String gender) {
		try {
			String methodName = "setGender";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { gender };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getPRUserRemoteModel() {
		return _prUserRemoteModel;
	}

	public void setPRUserRemoteModel(BaseModel<?> prUserRemoteModel) {
		_prUserRemoteModel = prUserRemoteModel;
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

		Class<?> remoteModelClass = _prUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_prUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PRUserLocalServiceUtil.addPRUser(this);
		}
		else {
			PRUserLocalServiceUtil.updatePRUser(this);
		}
	}

	@Override
	public PRUser toEscapedModel() {
		return (PRUser)ProxyUtil.newProxyInstance(PRUser.class.getClassLoader(),
			new Class[] { PRUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PRUserClp clone = new PRUserClp();

		clone.setPrUserId(getPrUserId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setAddress1(getAddress1());
		clone.setAddress2(getAddress2());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setPostalCode(getPostalCode());
		clone.setCountry(getCountry());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setEmail(getEmail());
		clone.setBirthDate(getBirthDate());
		clone.setMale(getMale());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(PRUser prUser) {
		int value = 0;

		value = getLastName().compareToIgnoreCase(prUser.getLastName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PRUserClp)) {
			return false;
		}

		PRUserClp prUser = (PRUserClp)obj;

		long primaryKey = prUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{prUserId=");
		sb.append(getPrUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", birthDate=");
		sb.append(getBirthDate());
		sb.append(", male=");
		sb.append(getMale());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.inkwell.internet.productregistration.model.PRUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>prUserId</column-name><column-value><![CDATA[");
		sb.append(getPrUserId());
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
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthDate</column-name><column-value><![CDATA[");
		sb.append(getBirthDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>male</column-name><column-value><![CDATA[");
		sb.append(getMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _prUserId;
	private String _prUserUuid;
	private String _firstName;
	private String _lastName;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _postalCode;
	private String _country;
	private String _phoneNumber;
	private String _email;
	private Date _birthDate;
	private boolean _male;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _prUserRemoteModel;
}