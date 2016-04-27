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

package at.graz.meduni.liferay.portlet.saat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SCG}.
 * </p>
 *
 * @author reihsr
 * @see SCG
 * @generated
 */
public class SCGWrapper implements SCG, ModelWrapper<SCG> {
	public SCGWrapper(SCG scg) {
		_scg = scg;
	}

	@Override
	public Class<?> getModelClass() {
		return SCG.class;
	}

	@Override
	public String getModelClassName() {
		return SCG.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scgId", getScgId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scgId = (Long)attributes.get("scgId");

		if (scgId != null) {
			setScgId(scgId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this s c g.
	*
	* @return the primary key of this s c g
	*/
	@Override
	public long getPrimaryKey() {
		return _scg.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s c g.
	*
	* @param primaryKey the primary key of this s c g
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scg.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the scg ID of this s c g.
	*
	* @return the scg ID of this s c g
	*/
	@Override
	public long getScgId() {
		return _scg.getScgId();
	}

	/**
	* Sets the scg ID of this s c g.
	*
	* @param scgId the scg ID of this s c g
	*/
	@Override
	public void setScgId(long scgId) {
		_scg.setScgId(scgId);
	}

	/**
	* Returns the code of this s c g.
	*
	* @return the code of this s c g
	*/
	@Override
	public java.lang.String getCode() {
		return _scg.getCode();
	}

	/**
	* Sets the code of this s c g.
	*
	* @param code the code of this s c g
	*/
	@Override
	public void setCode(java.lang.String code) {
		_scg.setCode(code);
	}

	/**
	* Returns the description of this s c g.
	*
	* @return the description of this s c g
	*/
	@Override
	public java.lang.String getDescription() {
		return _scg.getDescription();
	}

	/**
	* Sets the description of this s c g.
	*
	* @param description the description of this s c g
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_scg.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _scg.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scg.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scg.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scg.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scg.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scg.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scg.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scg.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scg.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SCGWrapper((SCG)_scg.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.portlet.saat.model.SCG scg) {
		return _scg.compareTo(scg);
	}

	@Override
	public int hashCode() {
		return _scg.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.saat.model.SCG> toCacheModel() {
		return _scg.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.SCG toEscapedModel() {
		return new SCGWrapper(_scg.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.SCG toUnescapedModel() {
		return new SCGWrapper(_scg.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scg.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scg.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scg.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SCGWrapper)) {
			return false;
		}

		SCGWrapper scgWrapper = (SCGWrapper)obj;

		if (Validator.equals(_scg, scgWrapper._scg)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SCG getWrappedSCG() {
		return _scg;
	}

	@Override
	public SCG getWrappedModel() {
		return _scg;
	}

	@Override
	public void resetOriginalValues() {
		_scg.resetOriginalValues();
	}

	private SCG _scg;
}