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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link patientnamegenerator}.
 * </p>
 *
 * @author reihsr
 * @see patientnamegenerator
 * @generated
 */
public class patientnamegeneratorWrapper implements patientnamegenerator,
	ModelWrapper<patientnamegenerator> {
	public patientnamegeneratorWrapper(
		patientnamegenerator patientnamegenerator) {
		_patientnamegenerator = patientnamegenerator;
	}

	@Override
	public Class<?> getModelClass() {
		return patientnamegenerator.class;
	}

	@Override
	public String getModelClassName() {
		return patientnamegenerator.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientnamegeneratorId", getPatientnamegeneratorId());
		attributes.put("name", getName());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientnamegeneratorId = (Long)attributes.get(
				"patientnamegeneratorId");

		if (patientnamegeneratorId != null) {
			setPatientnamegeneratorId(patientnamegeneratorId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this patientnamegenerator.
	*
	* @return the primary key of this patientnamegenerator
	*/
	@Override
	public long getPrimaryKey() {
		return _patientnamegenerator.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patientnamegenerator.
	*
	* @param primaryKey the primary key of this patientnamegenerator
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patientnamegenerator.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patientnamegenerator ID of this patientnamegenerator.
	*
	* @return the patientnamegenerator ID of this patientnamegenerator
	*/
	@Override
	public long getPatientnamegeneratorId() {
		return _patientnamegenerator.getPatientnamegeneratorId();
	}

	/**
	* Sets the patientnamegenerator ID of this patientnamegenerator.
	*
	* @param patientnamegeneratorId the patientnamegenerator ID of this patientnamegenerator
	*/
	@Override
	public void setPatientnamegeneratorId(long patientnamegeneratorId) {
		_patientnamegenerator.setPatientnamegeneratorId(patientnamegeneratorId);
	}

	/**
	* Returns the name of this patientnamegenerator.
	*
	* @return the name of this patientnamegenerator
	*/
	@Override
	public java.lang.String getName() {
		return _patientnamegenerator.getName();
	}

	/**
	* Sets the name of this patientnamegenerator.
	*
	* @param name the name of this patientnamegenerator
	*/
	@Override
	public void setName(java.lang.String name) {
		_patientnamegenerator.setName(name);
	}

	/**
	* Returns the type of this patientnamegenerator.
	*
	* @return the type of this patientnamegenerator
	*/
	@Override
	public java.lang.String getType() {
		return _patientnamegenerator.getType();
	}

	/**
	* Sets the type of this patientnamegenerator.
	*
	* @param type the type of this patientnamegenerator
	*/
	@Override
	public void setType(java.lang.String type) {
		_patientnamegenerator.setType(type);
	}

	@Override
	public boolean isNew() {
		return _patientnamegenerator.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patientnamegenerator.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patientnamegenerator.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patientnamegenerator.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patientnamegenerator.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patientnamegenerator.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patientnamegenerator.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patientnamegenerator.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patientnamegenerator.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patientnamegenerator.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patientnamegenerator.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new patientnamegeneratorWrapper((patientnamegenerator)_patientnamegenerator.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator patientnamegenerator) {
		return _patientnamegenerator.compareTo(patientnamegenerator);
	}

	@Override
	public int hashCode() {
		return _patientnamegenerator.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> toCacheModel() {
		return _patientnamegenerator.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator toEscapedModel() {
		return new patientnamegeneratorWrapper(_patientnamegenerator.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator toUnescapedModel() {
		return new patientnamegeneratorWrapper(_patientnamegenerator.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patientnamegenerator.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patientnamegenerator.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patientnamegenerator.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof patientnamegeneratorWrapper)) {
			return false;
		}

		patientnamegeneratorWrapper patientnamegeneratorWrapper = (patientnamegeneratorWrapper)obj;

		if (Validator.equals(_patientnamegenerator,
					patientnamegeneratorWrapper._patientnamegenerator)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public patientnamegenerator getWrappedpatientnamegenerator() {
		return _patientnamegenerator;
	}

	@Override
	public patientnamegenerator getWrappedModel() {
		return _patientnamegenerator;
	}

	@Override
	public void resetOriginalValues() {
		_patientnamegenerator.resetOriginalValues();
	}

	private patientnamegenerator _patientnamegenerator;
}