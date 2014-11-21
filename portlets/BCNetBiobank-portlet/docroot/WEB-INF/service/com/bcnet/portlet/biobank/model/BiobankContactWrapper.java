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
 * This class is a wrapper for {@link BiobankContact}.
 * </p>
 *
 * @author suyama
 * @see BiobankContact
 * @generated
 */
public class BiobankContactWrapper implements BiobankContact,
	ModelWrapper<BiobankContact> {
	public BiobankContactWrapper(BiobankContact biobankContact) {
		_biobankContact = biobankContact;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankContact.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("contactId", getContactId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}
	}

	/**
	* Returns the primary key of this biobank contact.
	*
	* @return the primary key of this biobank contact
	*/
	@Override
	public com.bcnet.portlet.biobank.service.persistence.BiobankContactPK getPrimaryKey() {
		return _biobankContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank contact.
	*
	* @param primaryKey the primary key of this biobank contact
	*/
	@Override
	public void setPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK primaryKey) {
		_biobankContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank db ID of this biobank contact.
	*
	* @return the biobank db ID of this biobank contact
	*/
	@Override
	public long getBiobankDbId() {
		return _biobankContact.getBiobankDbId();
	}

	/**
	* Sets the biobank db ID of this biobank contact.
	*
	* @param biobankDbId the biobank db ID of this biobank contact
	*/
	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankContact.setBiobankDbId(biobankDbId);
	}

	/**
	* Returns the contact ID of this biobank contact.
	*
	* @return the contact ID of this biobank contact
	*/
	@Override
	public long getContactId() {
		return _biobankContact.getContactId();
	}

	/**
	* Sets the contact ID of this biobank contact.
	*
	* @param contactId the contact ID of this biobank contact
	*/
	@Override
	public void setContactId(long contactId) {
		_biobankContact.setContactId(contactId);
	}

	@Override
	public boolean isNew() {
		return _biobankContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankContactWrapper((BiobankContact)_biobankContact.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact) {
		return _biobankContact.compareTo(biobankContact);
	}

	@Override
	public int hashCode() {
		return _biobankContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.BiobankContact> toCacheModel() {
		return _biobankContact.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankContact toEscapedModel() {
		return new BiobankContactWrapper(_biobankContact.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankContact toUnescapedModel() {
		return new BiobankContactWrapper(_biobankContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankContactWrapper)) {
			return false;
		}

		BiobankContactWrapper biobankContactWrapper = (BiobankContactWrapper)obj;

		if (Validator.equals(_biobankContact,
					biobankContactWrapper._biobankContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankContact getWrappedBiobankContact() {
		return _biobankContact;
	}

	@Override
	public BiobankContact getWrappedModel() {
		return _biobankContact;
	}

	@Override
	public void resetOriginalValues() {
		_biobankContact.resetOriginalValues();
	}

	private BiobankContact _biobankContact;
}