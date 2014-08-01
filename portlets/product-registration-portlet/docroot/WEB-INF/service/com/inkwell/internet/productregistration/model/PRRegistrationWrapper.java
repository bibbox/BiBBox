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
 * This class is a wrapper for {@link PRRegistration}.
 * </p>
 *
 * @author Rich Sezov
 * @see PRRegistration
 * @generated
 */
public class PRRegistrationWrapper implements PRRegistration,
	ModelWrapper<PRRegistration> {
	public PRRegistrationWrapper(PRRegistration prRegistration) {
		_prRegistration = prRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return PRRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return PRRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registrationId", getRegistrationId());
		attributes.put("prUserId", getPrUserId());
		attributes.put("datePurchased", getDatePurchased());
		attributes.put("howHear", getHowHear());
		attributes.put("wherePurchased", getWherePurchased());
		attributes.put("serialNumber", getSerialNumber());
		attributes.put("productId", getProductId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		Long prUserId = (Long)attributes.get("prUserId");

		if (prUserId != null) {
			setPrUserId(prUserId);
		}

		Date datePurchased = (Date)attributes.get("datePurchased");

		if (datePurchased != null) {
			setDatePurchased(datePurchased);
		}

		String howHear = (String)attributes.get("howHear");

		if (howHear != null) {
			setHowHear(howHear);
		}

		String wherePurchased = (String)attributes.get("wherePurchased");

		if (wherePurchased != null) {
			setWherePurchased(wherePurchased);
		}

		String serialNumber = (String)attributes.get("serialNumber");

		if (serialNumber != null) {
			setSerialNumber(serialNumber);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
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
	* Returns the primary key of this p r registration.
	*
	* @return the primary key of this p r registration
	*/
	@Override
	public long getPrimaryKey() {
		return _prRegistration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p r registration.
	*
	* @param primaryKey the primary key of this p r registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_prRegistration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the registration ID of this p r registration.
	*
	* @return the registration ID of this p r registration
	*/
	@Override
	public long getRegistrationId() {
		return _prRegistration.getRegistrationId();
	}

	/**
	* Sets the registration ID of this p r registration.
	*
	* @param registrationId the registration ID of this p r registration
	*/
	@Override
	public void setRegistrationId(long registrationId) {
		_prRegistration.setRegistrationId(registrationId);
	}

	/**
	* Returns the pr user ID of this p r registration.
	*
	* @return the pr user ID of this p r registration
	*/
	@Override
	public long getPrUserId() {
		return _prRegistration.getPrUserId();
	}

	/**
	* Sets the pr user ID of this p r registration.
	*
	* @param prUserId the pr user ID of this p r registration
	*/
	@Override
	public void setPrUserId(long prUserId) {
		_prRegistration.setPrUserId(prUserId);
	}

	/**
	* Returns the pr user uuid of this p r registration.
	*
	* @return the pr user uuid of this p r registration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getPrUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _prRegistration.getPrUserUuid();
	}

	/**
	* Sets the pr user uuid of this p r registration.
	*
	* @param prUserUuid the pr user uuid of this p r registration
	*/
	@Override
	public void setPrUserUuid(java.lang.String prUserUuid) {
		_prRegistration.setPrUserUuid(prUserUuid);
	}

	/**
	* Returns the date purchased of this p r registration.
	*
	* @return the date purchased of this p r registration
	*/
	@Override
	public java.util.Date getDatePurchased() {
		return _prRegistration.getDatePurchased();
	}

	/**
	* Sets the date purchased of this p r registration.
	*
	* @param datePurchased the date purchased of this p r registration
	*/
	@Override
	public void setDatePurchased(java.util.Date datePurchased) {
		_prRegistration.setDatePurchased(datePurchased);
	}

	/**
	* Returns the how hear of this p r registration.
	*
	* @return the how hear of this p r registration
	*/
	@Override
	public java.lang.String getHowHear() {
		return _prRegistration.getHowHear();
	}

	/**
	* Sets the how hear of this p r registration.
	*
	* @param howHear the how hear of this p r registration
	*/
	@Override
	public void setHowHear(java.lang.String howHear) {
		_prRegistration.setHowHear(howHear);
	}

	/**
	* Returns the where purchased of this p r registration.
	*
	* @return the where purchased of this p r registration
	*/
	@Override
	public java.lang.String getWherePurchased() {
		return _prRegistration.getWherePurchased();
	}

	/**
	* Sets the where purchased of this p r registration.
	*
	* @param wherePurchased the where purchased of this p r registration
	*/
	@Override
	public void setWherePurchased(java.lang.String wherePurchased) {
		_prRegistration.setWherePurchased(wherePurchased);
	}

	/**
	* Returns the serial number of this p r registration.
	*
	* @return the serial number of this p r registration
	*/
	@Override
	public java.lang.String getSerialNumber() {
		return _prRegistration.getSerialNumber();
	}

	/**
	* Sets the serial number of this p r registration.
	*
	* @param serialNumber the serial number of this p r registration
	*/
	@Override
	public void setSerialNumber(java.lang.String serialNumber) {
		_prRegistration.setSerialNumber(serialNumber);
	}

	/**
	* Returns the product ID of this p r registration.
	*
	* @return the product ID of this p r registration
	*/
	@Override
	public long getProductId() {
		return _prRegistration.getProductId();
	}

	/**
	* Sets the product ID of this p r registration.
	*
	* @param productId the product ID of this p r registration
	*/
	@Override
	public void setProductId(long productId) {
		_prRegistration.setProductId(productId);
	}

	/**
	* Returns the company ID of this p r registration.
	*
	* @return the company ID of this p r registration
	*/
	@Override
	public long getCompanyId() {
		return _prRegistration.getCompanyId();
	}

	/**
	* Sets the company ID of this p r registration.
	*
	* @param companyId the company ID of this p r registration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_prRegistration.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this p r registration.
	*
	* @return the group ID of this p r registration
	*/
	@Override
	public long getGroupId() {
		return _prRegistration.getGroupId();
	}

	/**
	* Sets the group ID of this p r registration.
	*
	* @param groupId the group ID of this p r registration
	*/
	@Override
	public void setGroupId(long groupId) {
		_prRegistration.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _prRegistration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_prRegistration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _prRegistration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_prRegistration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _prRegistration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _prRegistration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_prRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _prRegistration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_prRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_prRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_prRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PRRegistrationWrapper((PRRegistration)_prRegistration.clone());
	}

	@Override
	public int compareTo(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration) {
		return _prRegistration.compareTo(prRegistration);
	}

	@Override
	public int hashCode() {
		return _prRegistration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.inkwell.internet.productregistration.model.PRRegistration> toCacheModel() {
		return _prRegistration.toCacheModel();
	}

	@Override
	public com.inkwell.internet.productregistration.model.PRRegistration toEscapedModel() {
		return new PRRegistrationWrapper(_prRegistration.toEscapedModel());
	}

	@Override
	public com.inkwell.internet.productregistration.model.PRRegistration toUnescapedModel() {
		return new PRRegistrationWrapper(_prRegistration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _prRegistration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _prRegistration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_prRegistration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PRRegistrationWrapper)) {
			return false;
		}

		PRRegistrationWrapper prRegistrationWrapper = (PRRegistrationWrapper)obj;

		if (Validator.equals(_prRegistration,
					prRegistrationWrapper._prRegistration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PRRegistration getWrappedPRRegistration() {
		return _prRegistration;
	}

	@Override
	public PRRegistration getWrappedModel() {
		return _prRegistration;
	}

	@Override
	public void resetOriginalValues() {
		_prRegistration.resetOriginalValues();
	}

	private PRRegistration _prRegistration;
}