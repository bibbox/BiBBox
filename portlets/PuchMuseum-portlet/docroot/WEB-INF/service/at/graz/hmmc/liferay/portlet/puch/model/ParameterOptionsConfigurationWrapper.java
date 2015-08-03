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

package at.graz.hmmc.liferay.portlet.puch.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ParameterOptionsConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see ParameterOptionsConfiguration
 * @generated
 */
public class ParameterOptionsConfigurationWrapper
	implements ParameterOptionsConfiguration,
		ModelWrapper<ParameterOptionsConfiguration> {
	public ParameterOptionsConfigurationWrapper(
		ParameterOptionsConfiguration parameterOptionsConfiguration) {
		_parameterOptionsConfiguration = parameterOptionsConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return ParameterOptionsConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ParameterOptionsConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameteroptionsconfigurationId",
			getParameteroptionsconfigurationId());
		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("optionkey", getOptionkey());
		attributes.put("optionvalue", getOptionvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameteroptionsconfigurationId = (Long)attributes.get(
				"parameteroptionsconfigurationId");

		if (parameteroptionsconfigurationId != null) {
			setParameteroptionsconfigurationId(parameteroptionsconfigurationId);
		}

		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String optionkey = (String)attributes.get("optionkey");

		if (optionkey != null) {
			setOptionkey(optionkey);
		}

		String optionvalue = (String)attributes.get("optionvalue");

		if (optionvalue != null) {
			setOptionvalue(optionvalue);
		}
	}

	/**
	* Returns the primary key of this parameter options configuration.
	*
	* @return the primary key of this parameter options configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _parameterOptionsConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this parameter options configuration.
	*
	* @param primaryKey the primary key of this parameter options configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_parameterOptionsConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the parameteroptionsconfiguration ID of this parameter options configuration.
	*
	* @return the parameteroptionsconfiguration ID of this parameter options configuration
	*/
	@Override
	public long getParameteroptionsconfigurationId() {
		return _parameterOptionsConfiguration.getParameteroptionsconfigurationId();
	}

	/**
	* Sets the parameteroptionsconfiguration ID of this parameter options configuration.
	*
	* @param parameteroptionsconfigurationId the parameteroptionsconfiguration ID of this parameter options configuration
	*/
	@Override
	public void setParameteroptionsconfigurationId(
		long parameteroptionsconfigurationId) {
		_parameterOptionsConfiguration.setParameteroptionsconfigurationId(parameteroptionsconfigurationId);
	}

	/**
	* Returns the parameterconfiguration ID of this parameter options configuration.
	*
	* @return the parameterconfiguration ID of this parameter options configuration
	*/
	@Override
	public long getParameterconfigurationId() {
		return _parameterOptionsConfiguration.getParameterconfigurationId();
	}

	/**
	* Sets the parameterconfiguration ID of this parameter options configuration.
	*
	* @param parameterconfigurationId the parameterconfiguration ID of this parameter options configuration
	*/
	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterOptionsConfiguration.setParameterconfigurationId(parameterconfigurationId);
	}

	/**
	* Returns the optionkey of this parameter options configuration.
	*
	* @return the optionkey of this parameter options configuration
	*/
	@Override
	public java.lang.String getOptionkey() {
		return _parameterOptionsConfiguration.getOptionkey();
	}

	/**
	* Sets the optionkey of this parameter options configuration.
	*
	* @param optionkey the optionkey of this parameter options configuration
	*/
	@Override
	public void setOptionkey(java.lang.String optionkey) {
		_parameterOptionsConfiguration.setOptionkey(optionkey);
	}

	/**
	* Returns the optionvalue of this parameter options configuration.
	*
	* @return the optionvalue of this parameter options configuration
	*/
	@Override
	public java.lang.String getOptionvalue() {
		return _parameterOptionsConfiguration.getOptionvalue();
	}

	/**
	* Sets the optionvalue of this parameter options configuration.
	*
	* @param optionvalue the optionvalue of this parameter options configuration
	*/
	@Override
	public void setOptionvalue(java.lang.String optionvalue) {
		_parameterOptionsConfiguration.setOptionvalue(optionvalue);
	}

	@Override
	public boolean isNew() {
		return _parameterOptionsConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_parameterOptionsConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _parameterOptionsConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_parameterOptionsConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _parameterOptionsConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _parameterOptionsConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_parameterOptionsConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _parameterOptionsConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_parameterOptionsConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_parameterOptionsConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_parameterOptionsConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParameterOptionsConfigurationWrapper((ParameterOptionsConfiguration)_parameterOptionsConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration) {
		return _parameterOptionsConfiguration.compareTo(parameterOptionsConfiguration);
	}

	@Override
	public int hashCode() {
		return _parameterOptionsConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> toCacheModel() {
		return _parameterOptionsConfiguration.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration toEscapedModel() {
		return new ParameterOptionsConfigurationWrapper(_parameterOptionsConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration toUnescapedModel() {
		return new ParameterOptionsConfigurationWrapper(_parameterOptionsConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _parameterOptionsConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _parameterOptionsConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_parameterOptionsConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParameterOptionsConfigurationWrapper)) {
			return false;
		}

		ParameterOptionsConfigurationWrapper parameterOptionsConfigurationWrapper =
			(ParameterOptionsConfigurationWrapper)obj;

		if (Validator.equals(_parameterOptionsConfiguration,
					parameterOptionsConfigurationWrapper._parameterOptionsConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ParameterOptionsConfiguration getWrappedParameterOptionsConfiguration() {
		return _parameterOptionsConfiguration;
	}

	@Override
	public ParameterOptionsConfiguration getWrappedModel() {
		return _parameterOptionsConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_parameterOptionsConfiguration.resetOriginalValues();
	}

	private ParameterOptionsConfiguration _parameterOptionsConfiguration;
}