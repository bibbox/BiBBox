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
 * This class is a wrapper for {@link JuristicPerson}.
 * </p>
 *
 * @author suyama
 * @see JuristicPerson
 * @generated
 */
public class JuristicPersonWrapper implements JuristicPerson,
	ModelWrapper<JuristicPerson> {
	public JuristicPersonWrapper(JuristicPerson juristicPerson) {
		_juristicPerson = juristicPerson;
	}

	@Override
	public Class<?> getModelClass() {
		return JuristicPerson.class;
	}

	@Override
	public String getModelClassName() {
		return JuristicPerson.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("juristicPersonId", getJuristicPersonId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long juristicPersonId = (Long)attributes.get("juristicPersonId");

		if (juristicPersonId != null) {
			setJuristicPersonId(juristicPersonId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	/**
	* Returns the primary key of this juristic person.
	*
	* @return the primary key of this juristic person
	*/
	@Override
	public long getPrimaryKey() {
		return _juristicPerson.getPrimaryKey();
	}

	/**
	* Sets the primary key of this juristic person.
	*
	* @param primaryKey the primary key of this juristic person
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_juristicPerson.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the juristic person ID of this juristic person.
	*
	* @return the juristic person ID of this juristic person
	*/
	@Override
	public long getJuristicPersonId() {
		return _juristicPerson.getJuristicPersonId();
	}

	/**
	* Sets the juristic person ID of this juristic person.
	*
	* @param juristicPersonId the juristic person ID of this juristic person
	*/
	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPerson.setJuristicPersonId(juristicPersonId);
	}

	/**
	* Returns the name of this juristic person.
	*
	* @return the name of this juristic person
	*/
	@Override
	public java.lang.String getName() {
		return _juristicPerson.getName();
	}

	/**
	* Sets the name of this juristic person.
	*
	* @param name the name of this juristic person
	*/
	@Override
	public void setName(java.lang.String name) {
		_juristicPerson.setName(name);
	}

	/**
	* Returns the url of this juristic person.
	*
	* @return the url of this juristic person
	*/
	@Override
	public java.lang.String getUrl() {
		return _juristicPerson.getUrl();
	}

	/**
	* Sets the url of this juristic person.
	*
	* @param url the url of this juristic person
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_juristicPerson.setUrl(url);
	}

	/**
	* Returns the address of this juristic person.
	*
	* @return the address of this juristic person
	*/
	@Override
	public java.lang.String getAddress() {
		return _juristicPerson.getAddress();
	}

	/**
	* Sets the address of this juristic person.
	*
	* @param address the address of this juristic person
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_juristicPerson.setAddress(address);
	}

	@Override
	public boolean isNew() {
		return _juristicPerson.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_juristicPerson.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _juristicPerson.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_juristicPerson.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _juristicPerson.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _juristicPerson.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_juristicPerson.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _juristicPerson.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_juristicPerson.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_juristicPerson.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_juristicPerson.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JuristicPersonWrapper((JuristicPerson)_juristicPerson.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson) {
		return _juristicPerson.compareTo(juristicPerson);
	}

	@Override
	public int hashCode() {
		return _juristicPerson.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.JuristicPerson> toCacheModel() {
		return _juristicPerson.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson toEscapedModel() {
		return new JuristicPersonWrapper(_juristicPerson.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson toUnescapedModel() {
		return new JuristicPersonWrapper(_juristicPerson.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _juristicPerson.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _juristicPerson.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_juristicPerson.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JuristicPersonWrapper)) {
			return false;
		}

		JuristicPersonWrapper juristicPersonWrapper = (JuristicPersonWrapper)obj;

		if (Validator.equals(_juristicPerson,
					juristicPersonWrapper._juristicPerson)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JuristicPerson getWrappedJuristicPerson() {
		return _juristicPerson;
	}

	@Override
	public JuristicPerson getWrappedModel() {
		return _juristicPerson;
	}

	@Override
	public void resetOriginalValues() {
		_juristicPerson.resetOriginalValues();
	}

	private JuristicPerson _juristicPerson;
}