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
 * This class is a wrapper for {@link KdssmpParameterOptions}.
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterOptions
 * @generated
 */
public class KdssmpParameterOptionsWrapper implements KdssmpParameterOptions,
	ModelWrapper<KdssmpParameterOptions> {
	public KdssmpParameterOptionsWrapper(
		KdssmpParameterOptions kdssmpParameterOptions) {
		_kdssmpParameterOptions = kdssmpParameterOptions;
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpParameterOptions.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpParameterOptions.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameteroptionsId", getParameteroptionsId());
		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("option", getOption());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameteroptionsId = (Long)attributes.get("parameteroptionsId");

		if (parameteroptionsId != null) {
			setParameteroptionsId(parameteroptionsId);
		}

		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String option = (String)attributes.get("option");

		if (option != null) {
			setOption(option);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this kdssmp parameter options.
	*
	* @return the primary key of this kdssmp parameter options
	*/
	@Override
	public long getPrimaryKey() {
		return _kdssmpParameterOptions.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kdssmp parameter options.
	*
	* @param primaryKey the primary key of this kdssmp parameter options
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kdssmpParameterOptions.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the parameteroptions ID of this kdssmp parameter options.
	*
	* @return the parameteroptions ID of this kdssmp parameter options
	*/
	@Override
	public long getParameteroptionsId() {
		return _kdssmpParameterOptions.getParameteroptionsId();
	}

	/**
	* Sets the parameteroptions ID of this kdssmp parameter options.
	*
	* @param parameteroptionsId the parameteroptions ID of this kdssmp parameter options
	*/
	@Override
	public void setParameteroptionsId(long parameteroptionsId) {
		_kdssmpParameterOptions.setParameteroptionsId(parameteroptionsId);
	}

	/**
	* Returns the parameterconfiguration ID of this kdssmp parameter options.
	*
	* @return the parameterconfiguration ID of this kdssmp parameter options
	*/
	@Override
	public long getParameterconfigurationId() {
		return _kdssmpParameterOptions.getParameterconfigurationId();
	}

	/**
	* Sets the parameterconfiguration ID of this kdssmp parameter options.
	*
	* @param parameterconfigurationId the parameterconfiguration ID of this kdssmp parameter options
	*/
	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_kdssmpParameterOptions.setParameterconfigurationId(parameterconfigurationId);
	}

	/**
	* Returns the option of this kdssmp parameter options.
	*
	* @return the option of this kdssmp parameter options
	*/
	@Override
	public java.lang.String getOption() {
		return _kdssmpParameterOptions.getOption();
	}

	/**
	* Sets the option of this kdssmp parameter options.
	*
	* @param option the option of this kdssmp parameter options
	*/
	@Override
	public void setOption(java.lang.String option) {
		_kdssmpParameterOptions.setOption(option);
	}

	/**
	* Returns the value of this kdssmp parameter options.
	*
	* @return the value of this kdssmp parameter options
	*/
	@Override
	public java.lang.String getValue() {
		return _kdssmpParameterOptions.getValue();
	}

	/**
	* Sets the value of this kdssmp parameter options.
	*
	* @param value the value of this kdssmp parameter options
	*/
	@Override
	public void setValue(java.lang.String value) {
		_kdssmpParameterOptions.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _kdssmpParameterOptions.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kdssmpParameterOptions.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kdssmpParameterOptions.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kdssmpParameterOptions.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kdssmpParameterOptions.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kdssmpParameterOptions.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kdssmpParameterOptions.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kdssmpParameterOptions.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kdssmpParameterOptions.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kdssmpParameterOptions.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kdssmpParameterOptions.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KdssmpParameterOptionsWrapper((KdssmpParameterOptions)_kdssmpParameterOptions.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions) {
		return _kdssmpParameterOptions.compareTo(kdssmpParameterOptions);
	}

	@Override
	public int hashCode() {
		return _kdssmpParameterOptions.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> toCacheModel() {
		return _kdssmpParameterOptions.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions toEscapedModel() {
		return new KdssmpParameterOptionsWrapper(_kdssmpParameterOptions.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions toUnescapedModel() {
		return new KdssmpParameterOptionsWrapper(_kdssmpParameterOptions.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kdssmpParameterOptions.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kdssmpParameterOptions.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kdssmpParameterOptions.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpParameterOptionsWrapper)) {
			return false;
		}

		KdssmpParameterOptionsWrapper kdssmpParameterOptionsWrapper = (KdssmpParameterOptionsWrapper)obj;

		if (Validator.equals(_kdssmpParameterOptions,
					kdssmpParameterOptionsWrapper._kdssmpParameterOptions)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KdssmpParameterOptions getWrappedKdssmpParameterOptions() {
		return _kdssmpParameterOptions;
	}

	@Override
	public KdssmpParameterOptions getWrappedModel() {
		return _kdssmpParameterOptions;
	}

	@Override
	public void resetOriginalValues() {
		_kdssmpParameterOptions.resetOriginalValues();
	}

	private KdssmpParameterOptions _kdssmpParameterOptions;
}