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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PRUser}.
 * </p>
 *
 * @author Rich Sezov
 * @see PRUser
 * @generated
 */
public class PRUserWrapper implements PRUser, ModelWrapper<PRUser> {
	public PRUserWrapper(PRUser prUser) {
		_prUser = prUser;
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

	/**
	* Returns the primary key of this p r user.
	*
	* @return the primary key of this p r user
	*/
	@Override
	public long getPrimaryKey() {
		return _prUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p r user.
	*
	* @param primaryKey the primary key of this p r user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_prUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the pr user ID of this p r user.
	*
	* @return the pr user ID of this p r user
	*/
	@Override
	public long getPrUserId() {
		return _prUser.getPrUserId();
	}

	/**
	* Sets the pr user ID of this p r user.
	*
	* @param prUserId the pr user ID of this p r user
	*/
	@Override
	public void setPrUserId(long prUserId) {
		_prUser.setPrUserId(prUserId);
	}

	/**
	* Returns the pr user uuid of this p r user.
	*
	* @return the pr user uuid of this p r user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getPrUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUser.getPrUserUuid();
	}

	/**
	* Sets the pr user uuid of this p r user.
	*
	* @param prUserUuid the pr user uuid of this p r user
	*/
	@Override
	public void setPrUserUuid(java.lang.String prUserUuid) {
		_prUser.setPrUserUuid(prUserUuid);
	}

	/**
	* Returns the first name of this p r user.
	*
	* @return the first name of this p r user
	*/
	@Override
	public java.lang.String getFirstName() {
		return _prUser.getFirstName();
	}

	/**
	* Sets the first name of this p r user.
	*
	* @param firstName the first name of this p r user
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_prUser.setFirstName(firstName);
	}

	/**
	* Returns the last name of this p r user.
	*
	* @return the last name of this p r user
	*/
	@Override
	public java.lang.String getLastName() {
		return _prUser.getLastName();
	}

	/**
	* Sets the last name of this p r user.
	*
	* @param lastName the last name of this p r user
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_prUser.setLastName(lastName);
	}

	/**
	* Returns the address1 of this p r user.
	*
	* @return the address1 of this p r user
	*/
	@Override
	public java.lang.String getAddress1() {
		return _prUser.getAddress1();
	}

	/**
	* Sets the address1 of this p r user.
	*
	* @param address1 the address1 of this p r user
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_prUser.setAddress1(address1);
	}

	/**
	* Returns the address2 of this p r user.
	*
	* @return the address2 of this p r user
	*/
	@Override
	public java.lang.String getAddress2() {
		return _prUser.getAddress2();
	}

	/**
	* Sets the address2 of this p r user.
	*
	* @param address2 the address2 of this p r user
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_prUser.setAddress2(address2);
	}

	/**
	* Returns the city of this p r user.
	*
	* @return the city of this p r user
	*/
	@Override
	public java.lang.String getCity() {
		return _prUser.getCity();
	}

	/**
	* Sets the city of this p r user.
	*
	* @param city the city of this p r user
	*/
	@Override
	public void setCity(java.lang.String city) {
		_prUser.setCity(city);
	}

	/**
	* Returns the state of this p r user.
	*
	* @return the state of this p r user
	*/
	@Override
	public java.lang.String getState() {
		return _prUser.getState();
	}

	/**
	* Sets the state of this p r user.
	*
	* @param state the state of this p r user
	*/
	@Override
	public void setState(java.lang.String state) {
		_prUser.setState(state);
	}

	/**
	* Returns the postal code of this p r user.
	*
	* @return the postal code of this p r user
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _prUser.getPostalCode();
	}

	/**
	* Sets the postal code of this p r user.
	*
	* @param postalCode the postal code of this p r user
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_prUser.setPostalCode(postalCode);
	}

	/**
	* Returns the country of this p r user.
	*
	* @return the country of this p r user
	*/
	@Override
	public java.lang.String getCountry() {
		return _prUser.getCountry();
	}

	/**
	* Sets the country of this p r user.
	*
	* @param country the country of this p r user
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_prUser.setCountry(country);
	}

	/**
	* Returns the phone number of this p r user.
	*
	* @return the phone number of this p r user
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _prUser.getPhoneNumber();
	}

	/**
	* Sets the phone number of this p r user.
	*
	* @param phoneNumber the phone number of this p r user
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_prUser.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the email of this p r user.
	*
	* @return the email of this p r user
	*/
	@Override
	public java.lang.String getEmail() {
		return _prUser.getEmail();
	}

	/**
	* Sets the email of this p r user.
	*
	* @param email the email of this p r user
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_prUser.setEmail(email);
	}

	/**
	* Returns the birth date of this p r user.
	*
	* @return the birth date of this p r user
	*/
	@Override
	public java.util.Date getBirthDate() {
		return _prUser.getBirthDate();
	}

	/**
	* Sets the birth date of this p r user.
	*
	* @param birthDate the birth date of this p r user
	*/
	@Override
	public void setBirthDate(java.util.Date birthDate) {
		_prUser.setBirthDate(birthDate);
	}

	/**
	* Returns the male of this p r user.
	*
	* @return the male of this p r user
	*/
	@Override
	public boolean getMale() {
		return _prUser.getMale();
	}

	/**
	* Returns <code>true</code> if this p r user is male.
	*
	* @return <code>true</code> if this p r user is male; <code>false</code> otherwise
	*/
	@Override
	public boolean isMale() {
		return _prUser.isMale();
	}

	/**
	* Sets whether this p r user is male.
	*
	* @param male the male of this p r user
	*/
	@Override
	public void setMale(boolean male) {
		_prUser.setMale(male);
	}

	/**
	* Returns the user ID of this p r user.
	*
	* @return the user ID of this p r user
	*/
	@Override
	public long getUserId() {
		return _prUser.getUserId();
	}

	/**
	* Sets the user ID of this p r user.
	*
	* @param userId the user ID of this p r user
	*/
	@Override
	public void setUserId(long userId) {
		_prUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p r user.
	*
	* @return the user uuid of this p r user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this p r user.
	*
	* @param userUuid the user uuid of this p r user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_prUser.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this p r user.
	*
	* @return the company ID of this p r user
	*/
	@Override
	public long getCompanyId() {
		return _prUser.getCompanyId();
	}

	/**
	* Sets the company ID of this p r user.
	*
	* @param companyId the company ID of this p r user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_prUser.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this p r user.
	*
	* @return the group ID of this p r user
	*/
	@Override
	public long getGroupId() {
		return _prUser.getGroupId();
	}

	/**
	* Sets the group ID of this p r user.
	*
	* @param groupId the group ID of this p r user
	*/
	@Override
	public void setGroupId(long groupId) {
		_prUser.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _prUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_prUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _prUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_prUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _prUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _prUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_prUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _prUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_prUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_prUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_prUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PRUserWrapper((PRUser)_prUser.clone());
	}

	@Override
	public int compareTo(
		com.inkwell.internet.productregistration.model.PRUser prUser) {
		return _prUser.compareTo(prUser);
	}

	@Override
	public int hashCode() {
		return _prUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.inkwell.internet.productregistration.model.PRUser> toCacheModel() {
		return _prUser.toCacheModel();
	}

	@Override
	public com.inkwell.internet.productregistration.model.PRUser toEscapedModel() {
		return new PRUserWrapper(_prUser.toEscapedModel());
	}

	@Override
	public com.inkwell.internet.productregistration.model.PRUser toUnescapedModel() {
		return new PRUserWrapper(_prUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _prUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _prUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_prUser.persist();
	}

	@Override
	public java.lang.String getGender() {
		return _prUser.getGender();
	}

	@Override
	public void setGender(java.lang.String gender) {
		_prUser.setGender(gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PRUserWrapper)) {
			return false;
		}

		PRUserWrapper prUserWrapper = (PRUserWrapper)obj;

		if (Validator.equals(_prUser, prUserWrapper._prUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PRUser getWrappedPRUser() {
		return _prUser;
	}

	@Override
	public PRUser getWrappedModel() {
		return _prUser;
	}

	@Override
	public void resetOriginalValues() {
		_prUser.resetOriginalValues();
	}

	private PRUser _prUser;
}