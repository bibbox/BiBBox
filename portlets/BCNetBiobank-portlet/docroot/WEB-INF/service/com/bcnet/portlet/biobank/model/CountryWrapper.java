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
 * This class is a wrapper for {@link Country}.
 * </p>
 *
 * @author suyama
 * @see Country
 * @generated
 */
public class CountryWrapper implements Country, ModelWrapper<Country> {
	public CountryWrapper(Country country) {
		_country = country;
	}

	@Override
	public Class<?> getModelClass() {
		return Country.class;
	}

	@Override
	public String getModelClassName() {
		return Country.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryCode", getCountryCode());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this country.
	*
	* @return the primary key of this country
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _country.getPrimaryKey();
	}

	/**
	* Sets the primary key of this country.
	*
	* @param primaryKey the primary key of this country
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_country.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the country code of this country.
	*
	* @return the country code of this country
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _country.getCountryCode();
	}

	/**
	* Sets the country code of this country.
	*
	* @param countryCode the country code of this country
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_country.setCountryCode(countryCode);
	}

	/**
	* Returns the name of this country.
	*
	* @return the name of this country
	*/
	@Override
	public java.lang.String getName() {
		return _country.getName();
	}

	/**
	* Sets the name of this country.
	*
	* @param name the name of this country
	*/
	@Override
	public void setName(java.lang.String name) {
		_country.setName(name);
	}

	@Override
	public boolean isNew() {
		return _country.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_country.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _country.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_country.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _country.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _country.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_country.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _country.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_country.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_country.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_country.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CountryWrapper((Country)_country.clone());
	}

	@Override
	public int compareTo(com.bcnet.portlet.biobank.model.Country country) {
		return _country.compareTo(country);
	}

	@Override
	public int hashCode() {
		return _country.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.Country> toCacheModel() {
		return _country.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.Country toEscapedModel() {
		return new CountryWrapper(_country.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.Country toUnescapedModel() {
		return new CountryWrapper(_country.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _country.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _country.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_country.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryWrapper)) {
			return false;
		}

		CountryWrapper countryWrapper = (CountryWrapper)obj;

		if (Validator.equals(_country, countryWrapper._country)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Country getWrappedCountry() {
		return _country;
	}

	@Override
	public Country getWrappedModel() {
		return _country;
	}

	@Override
	public void resetOriginalValues() {
		_country.resetOriginalValues();
	}

	private Country _country;
}