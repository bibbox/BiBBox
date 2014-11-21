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
 * This class is a wrapper for {@link BiobankAttributeLists}.
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeLists
 * @generated
 */
public class BiobankAttributeListsWrapper implements BiobankAttributeLists,
	ModelWrapper<BiobankAttributeLists> {
	public BiobankAttributeListsWrapper(
		BiobankAttributeLists biobankAttributeLists) {
		_biobankAttributeLists = biobankAttributeLists;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankAttributeLists.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankAttributeLists.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankAttributeListsId", getBiobankAttributeListsId());
		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankAttributeListsId = (Long)attributes.get(
				"biobankAttributeListsId");

		if (biobankAttributeListsId != null) {
			setBiobankAttributeListsId(biobankAttributeListsId);
		}

		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String attributeListName = (String)attributes.get("attributeListName");

		if (attributeListName != null) {
			setAttributeListName(attributeListName);
		}

		String attributeListValue = (String)attributes.get("attributeListValue");

		if (attributeListValue != null) {
			setAttributeListValue(attributeListValue);
		}
	}

	/**
	* Returns the primary key of this biobank attribute lists.
	*
	* @return the primary key of this biobank attribute lists
	*/
	@Override
	public long getPrimaryKey() {
		return _biobankAttributeLists.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank attribute lists.
	*
	* @param primaryKey the primary key of this biobank attribute lists
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobankAttributeLists.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank attribute lists ID of this biobank attribute lists.
	*
	* @return the biobank attribute lists ID of this biobank attribute lists
	*/
	@Override
	public long getBiobankAttributeListsId() {
		return _biobankAttributeLists.getBiobankAttributeListsId();
	}

	/**
	* Sets the biobank attribute lists ID of this biobank attribute lists.
	*
	* @param biobankAttributeListsId the biobank attribute lists ID of this biobank attribute lists
	*/
	@Override
	public void setBiobankAttributeListsId(long biobankAttributeListsId) {
		_biobankAttributeLists.setBiobankAttributeListsId(biobankAttributeListsId);
	}

	/**
	* Returns the biobank db ID of this biobank attribute lists.
	*
	* @return the biobank db ID of this biobank attribute lists
	*/
	@Override
	public long getBiobankDbId() {
		return _biobankAttributeLists.getBiobankDbId();
	}

	/**
	* Sets the biobank db ID of this biobank attribute lists.
	*
	* @param biobankDbId the biobank db ID of this biobank attribute lists
	*/
	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankAttributeLists.setBiobankDbId(biobankDbId);
	}

	/**
	* Returns the attribute list name of this biobank attribute lists.
	*
	* @return the attribute list name of this biobank attribute lists
	*/
	@Override
	public java.lang.String getAttributeListName() {
		return _biobankAttributeLists.getAttributeListName();
	}

	/**
	* Sets the attribute list name of this biobank attribute lists.
	*
	* @param attributeListName the attribute list name of this biobank attribute lists
	*/
	@Override
	public void setAttributeListName(java.lang.String attributeListName) {
		_biobankAttributeLists.setAttributeListName(attributeListName);
	}

	/**
	* Returns the attribute list value of this biobank attribute lists.
	*
	* @return the attribute list value of this biobank attribute lists
	*/
	@Override
	public java.lang.String getAttributeListValue() {
		return _biobankAttributeLists.getAttributeListValue();
	}

	/**
	* Sets the attribute list value of this biobank attribute lists.
	*
	* @param attributeListValue the attribute list value of this biobank attribute lists
	*/
	@Override
	public void setAttributeListValue(java.lang.String attributeListValue) {
		_biobankAttributeLists.setAttributeListValue(attributeListValue);
	}

	@Override
	public boolean isNew() {
		return _biobankAttributeLists.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankAttributeLists.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankAttributeLists.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankAttributeLists.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankAttributeLists.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankAttributeLists.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankAttributeLists.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankAttributeLists.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankAttributeLists.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankAttributeLists.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankAttributeLists.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankAttributeListsWrapper((BiobankAttributeLists)_biobankAttributeLists.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.BiobankAttributeLists biobankAttributeLists) {
		return _biobankAttributeLists.compareTo(biobankAttributeLists);
	}

	@Override
	public int hashCode() {
		return _biobankAttributeLists.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.BiobankAttributeLists> toCacheModel() {
		return _biobankAttributeLists.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists toEscapedModel() {
		return new BiobankAttributeListsWrapper(_biobankAttributeLists.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeLists toUnescapedModel() {
		return new BiobankAttributeListsWrapper(_biobankAttributeLists.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankAttributeLists.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankAttributeLists.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankAttributeLists.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankAttributeListsWrapper)) {
			return false;
		}

		BiobankAttributeListsWrapper biobankAttributeListsWrapper = (BiobankAttributeListsWrapper)obj;

		if (Validator.equals(_biobankAttributeLists,
					biobankAttributeListsWrapper._biobankAttributeLists)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankAttributeLists getWrappedBiobankAttributeLists() {
		return _biobankAttributeLists;
	}

	@Override
	public BiobankAttributeLists getWrappedModel() {
		return _biobankAttributeLists;
	}

	@Override
	public void resetOriginalValues() {
		_biobankAttributeLists.resetOriginalValues();
	}

	private BiobankAttributeLists _biobankAttributeLists;
}