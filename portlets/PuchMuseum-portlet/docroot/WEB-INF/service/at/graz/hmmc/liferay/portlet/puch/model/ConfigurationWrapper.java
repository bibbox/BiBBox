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
 * This class is a wrapper for {@link Configuration}.
 * </p>
 *
 * @author reihsr
 * @see Configuration
 * @generated
 */
public class ConfigurationWrapper implements Configuration,
	ModelWrapper<Configuration> {
	public ConfigurationWrapper(Configuration configuration) {
		_configuration = configuration;
	}

	@Override
	public Class<?> getModelClass() {
		return Configuration.class;
	}

	@Override
	public String getModelClassName() {
		return Configuration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configurationId", getConfigurationId());
		attributes.put("scope", getScope());
		attributes.put("optionkey", getOptionkey());
		attributes.put("optionvalue", getOptionvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
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
	* Returns the primary key of this configuration.
	*
	* @return the primary key of this configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _configuration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuration.
	*
	* @param primaryKey the primary key of this configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_configuration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the configuration ID of this configuration.
	*
	* @return the configuration ID of this configuration
	*/
	@Override
	public long getConfigurationId() {
		return _configuration.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this configuration.
	*
	* @param configurationId the configuration ID of this configuration
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_configuration.setConfigurationId(configurationId);
	}

	/**
	* Returns the scope of this configuration.
	*
	* @return the scope of this configuration
	*/
	@Override
	public java.lang.String getScope() {
		return _configuration.getScope();
	}

	/**
	* Sets the scope of this configuration.
	*
	* @param scope the scope of this configuration
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_configuration.setScope(scope);
	}

	/**
	* Returns the optionkey of this configuration.
	*
	* @return the optionkey of this configuration
	*/
	@Override
	public java.lang.String getOptionkey() {
		return _configuration.getOptionkey();
	}

	/**
	* Sets the optionkey of this configuration.
	*
	* @param optionkey the optionkey of this configuration
	*/
	@Override
	public void setOptionkey(java.lang.String optionkey) {
		_configuration.setOptionkey(optionkey);
	}

	/**
	* Returns the optionvalue of this configuration.
	*
	* @return the optionvalue of this configuration
	*/
	@Override
	public java.lang.String getOptionvalue() {
		return _configuration.getOptionvalue();
	}

	/**
	* Sets the optionvalue of this configuration.
	*
	* @param optionvalue the optionvalue of this configuration
	*/
	@Override
	public void setOptionvalue(java.lang.String optionvalue) {
		_configuration.setOptionvalue(optionvalue);
	}

	@Override
	public boolean isNew() {
		return _configuration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_configuration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _configuration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_configuration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _configuration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _configuration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configuration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configuration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_configuration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_configuration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configuration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfigurationWrapper((Configuration)_configuration.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration) {
		return _configuration.compareTo(configuration);
	}

	@Override
	public int hashCode() {
		return _configuration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.Configuration> toCacheModel() {
		return _configuration.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration toEscapedModel() {
		return new ConfigurationWrapper(_configuration.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration toUnescapedModel() {
		return new ConfigurationWrapper(_configuration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configuration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _configuration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configuration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigurationWrapper)) {
			return false;
		}

		ConfigurationWrapper configurationWrapper = (ConfigurationWrapper)obj;

		if (Validator.equals(_configuration, configurationWrapper._configuration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Configuration getWrappedConfiguration() {
		return _configuration;
	}

	@Override
	public Configuration getWrappedModel() {
		return _configuration;
	}

	@Override
	public void resetOriginalValues() {
		_configuration.resetOriginalValues();
	}

	private Configuration _configuration;
}