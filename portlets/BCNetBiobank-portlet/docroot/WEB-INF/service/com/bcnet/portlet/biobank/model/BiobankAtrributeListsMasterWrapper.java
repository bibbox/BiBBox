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
 * This class is a wrapper for {@link BiobankAtrributeListsMaster}.
 * </p>
 *
 * @author suyama
 * @see BiobankAtrributeListsMaster
 * @generated
 */
public class BiobankAtrributeListsMasterWrapper
	implements BiobankAtrributeListsMaster,
		ModelWrapper<BiobankAtrributeListsMaster> {
	public BiobankAtrributeListsMasterWrapper(
		BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		_biobankAtrributeListsMaster = biobankAtrributeListsMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankAtrributeListsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankAtrributeListsMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankAttributeListsMasterId",
			getBiobankAttributeListsMasterId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankAttributeListsMasterId = (Long)attributes.get(
				"biobankAttributeListsMasterId");

		if (biobankAttributeListsMasterId != null) {
			setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);
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
	* Returns the primary key of this biobank atrribute lists master.
	*
	* @return the primary key of this biobank atrribute lists master
	*/
	@Override
	public long getPrimaryKey() {
		return _biobankAtrributeListsMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank atrribute lists master.
	*
	* @param primaryKey the primary key of this biobank atrribute lists master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobankAtrributeListsMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank attribute lists master ID of this biobank atrribute lists master.
	*
	* @return the biobank attribute lists master ID of this biobank atrribute lists master
	*/
	@Override
	public long getBiobankAttributeListsMasterId() {
		return _biobankAtrributeListsMaster.getBiobankAttributeListsMasterId();
	}

	/**
	* Sets the biobank attribute lists master ID of this biobank atrribute lists master.
	*
	* @param biobankAttributeListsMasterId the biobank attribute lists master ID of this biobank atrribute lists master
	*/
	@Override
	public void setBiobankAttributeListsMasterId(
		long biobankAttributeListsMasterId) {
		_biobankAtrributeListsMaster.setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);
	}

	/**
	* Returns the attribute list name of this biobank atrribute lists master.
	*
	* @return the attribute list name of this biobank atrribute lists master
	*/
	@Override
	public java.lang.String getAttributeListName() {
		return _biobankAtrributeListsMaster.getAttributeListName();
	}

	/**
	* Sets the attribute list name of this biobank atrribute lists master.
	*
	* @param attributeListName the attribute list name of this biobank atrribute lists master
	*/
	@Override
	public void setAttributeListName(java.lang.String attributeListName) {
		_biobankAtrributeListsMaster.setAttributeListName(attributeListName);
	}

	/**
	* Returns the attribute list value of this biobank atrribute lists master.
	*
	* @return the attribute list value of this biobank atrribute lists master
	*/
	@Override
	public java.lang.String getAttributeListValue() {
		return _biobankAtrributeListsMaster.getAttributeListValue();
	}

	/**
	* Sets the attribute list value of this biobank atrribute lists master.
	*
	* @param attributeListValue the attribute list value of this biobank atrribute lists master
	*/
	@Override
	public void setAttributeListValue(java.lang.String attributeListValue) {
		_biobankAtrributeListsMaster.setAttributeListValue(attributeListValue);
	}

	@Override
	public boolean isNew() {
		return _biobankAtrributeListsMaster.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankAtrributeListsMaster.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankAtrributeListsMaster.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankAtrributeListsMaster.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankAtrributeListsMaster.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankAtrributeListsMaster.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankAtrributeListsMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankAtrributeListsMaster.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankAtrributeListsMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankAtrributeListsMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankAtrributeListsMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankAtrributeListsMasterWrapper((BiobankAtrributeListsMaster)_biobankAtrributeListsMaster.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster biobankAtrributeListsMaster) {
		return _biobankAtrributeListsMaster.compareTo(biobankAtrributeListsMaster);
	}

	@Override
	public int hashCode() {
		return _biobankAtrributeListsMaster.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster> toCacheModel() {
		return _biobankAtrributeListsMaster.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster toEscapedModel() {
		return new BiobankAtrributeListsMasterWrapper(_biobankAtrributeListsMaster.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster toUnescapedModel() {
		return new BiobankAtrributeListsMasterWrapper(_biobankAtrributeListsMaster.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankAtrributeListsMaster.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankAtrributeListsMaster.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankAtrributeListsMaster.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankAtrributeListsMasterWrapper)) {
			return false;
		}

		BiobankAtrributeListsMasterWrapper biobankAtrributeListsMasterWrapper = (BiobankAtrributeListsMasterWrapper)obj;

		if (Validator.equals(_biobankAtrributeListsMaster,
					biobankAtrributeListsMasterWrapper._biobankAtrributeListsMaster)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankAtrributeListsMaster getWrappedBiobankAtrributeListsMaster() {
		return _biobankAtrributeListsMaster;
	}

	@Override
	public BiobankAtrributeListsMaster getWrappedModel() {
		return _biobankAtrributeListsMaster;
	}

	@Override
	public void resetOriginalValues() {
		_biobankAtrributeListsMaster.resetOriginalValues();
	}

	private BiobankAtrributeListsMaster _biobankAtrributeListsMaster;
}