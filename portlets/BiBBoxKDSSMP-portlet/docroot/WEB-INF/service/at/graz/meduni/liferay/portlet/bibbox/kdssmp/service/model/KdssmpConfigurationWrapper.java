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
 * This class is a wrapper for {@link KdssmpConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see KdssmpConfiguration
 * @generated
 */
public class KdssmpConfigurationWrapper implements KdssmpConfiguration,
	ModelWrapper<KdssmpConfiguration> {
	public KdssmpConfigurationWrapper(KdssmpConfiguration kdssmpConfiguration) {
		_kdssmpConfiguration = kdssmpConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpConfiguration.class.getName();
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
	* Returns the primary key of this kdssmp configuration.
	*
	* @return the primary key of this kdssmp configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _kdssmpConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kdssmp configuration.
	*
	* @param primaryKey the primary key of this kdssmp configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kdssmpConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the configuration ID of this kdssmp configuration.
	*
	* @return the configuration ID of this kdssmp configuration
	*/
	@Override
	public long getConfigurationId() {
		return _kdssmpConfiguration.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this kdssmp configuration.
	*
	* @param configurationId the configuration ID of this kdssmp configuration
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_kdssmpConfiguration.setConfigurationId(configurationId);
	}

	/**
	* Returns the scope of this kdssmp configuration.
	*
	* @return the scope of this kdssmp configuration
	*/
	@Override
	public java.lang.String getScope() {
		return _kdssmpConfiguration.getScope();
	}

	/**
	* Sets the scope of this kdssmp configuration.
	*
	* @param scope the scope of this kdssmp configuration
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_kdssmpConfiguration.setScope(scope);
	}

	/**
	* Returns the optionkey of this kdssmp configuration.
	*
	* @return the optionkey of this kdssmp configuration
	*/
	@Override
	public java.lang.String getOptionkey() {
		return _kdssmpConfiguration.getOptionkey();
	}

	/**
	* Sets the optionkey of this kdssmp configuration.
	*
	* @param optionkey the optionkey of this kdssmp configuration
	*/
	@Override
	public void setOptionkey(java.lang.String optionkey) {
		_kdssmpConfiguration.setOptionkey(optionkey);
	}

	/**
	* Returns the optionvalue of this kdssmp configuration.
	*
	* @return the optionvalue of this kdssmp configuration
	*/
	@Override
	public java.lang.String getOptionvalue() {
		return _kdssmpConfiguration.getOptionvalue();
	}

	/**
	* Sets the optionvalue of this kdssmp configuration.
	*
	* @param optionvalue the optionvalue of this kdssmp configuration
	*/
	@Override
	public void setOptionvalue(java.lang.String optionvalue) {
		_kdssmpConfiguration.setOptionvalue(optionvalue);
	}

	@Override
	public boolean isNew() {
		return _kdssmpConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kdssmpConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kdssmpConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kdssmpConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kdssmpConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kdssmpConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kdssmpConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kdssmpConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kdssmpConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kdssmpConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kdssmpConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KdssmpConfigurationWrapper((KdssmpConfiguration)_kdssmpConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration) {
		return _kdssmpConfiguration.compareTo(kdssmpConfiguration);
	}

	@Override
	public int hashCode() {
		return _kdssmpConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> toCacheModel() {
		return _kdssmpConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration toEscapedModel() {
		return new KdssmpConfigurationWrapper(_kdssmpConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration toUnescapedModel() {
		return new KdssmpConfigurationWrapper(_kdssmpConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kdssmpConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kdssmpConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kdssmpConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpConfigurationWrapper)) {
			return false;
		}

		KdssmpConfigurationWrapper kdssmpConfigurationWrapper = (KdssmpConfigurationWrapper)obj;

		if (Validator.equals(_kdssmpConfiguration,
					kdssmpConfigurationWrapper._kdssmpConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KdssmpConfiguration getWrappedKdssmpConfiguration() {
		return _kdssmpConfiguration;
	}

	@Override
	public KdssmpConfiguration getWrappedModel() {
		return _kdssmpConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_kdssmpConfiguration.resetOriginalValues();
	}

	private KdssmpConfiguration _kdssmpConfiguration;
}