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

package at.graz.meduni.liferay.portlet.bibbox.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SymbolTypeConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see SymbolTypeConfiguration
 * @generated
 */
public class SymbolTypeConfigurationWrapper implements SymbolTypeConfiguration,
	ModelWrapper<SymbolTypeConfiguration> {
	public SymbolTypeConfigurationWrapper(
		SymbolTypeConfiguration symbolTypeConfiguration) {
		_symbolTypeConfiguration = symbolTypeConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return SymbolTypeConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SymbolTypeConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("symboltypeconfigurationId",
			getSymboltypeconfigurationId());
		attributes.put("symboltype", getSymboltype());
		attributes.put("template", getTemplate());
		attributes.put("symboliconconfiguration", getSymboliconconfiguration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long symboltypeconfigurationId = (Long)attributes.get(
				"symboltypeconfigurationId");

		if (symboltypeconfigurationId != null) {
			setSymboltypeconfigurationId(symboltypeconfigurationId);
		}

		String symboltype = (String)attributes.get("symboltype");

		if (symboltype != null) {
			setSymboltype(symboltype);
		}

		String template = (String)attributes.get("template");

		if (template != null) {
			setTemplate(template);
		}

		String symboliconconfiguration = (String)attributes.get(
				"symboliconconfiguration");

		if (symboliconconfiguration != null) {
			setSymboliconconfiguration(symboliconconfiguration);
		}
	}

	/**
	* Returns the primary key of this symbol type configuration.
	*
	* @return the primary key of this symbol type configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _symbolTypeConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this symbol type configuration.
	*
	* @param primaryKey the primary key of this symbol type configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_symbolTypeConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the symboltypeconfiguration ID of this symbol type configuration.
	*
	* @return the symboltypeconfiguration ID of this symbol type configuration
	*/
	@Override
	public long getSymboltypeconfigurationId() {
		return _symbolTypeConfiguration.getSymboltypeconfigurationId();
	}

	/**
	* Sets the symboltypeconfiguration ID of this symbol type configuration.
	*
	* @param symboltypeconfigurationId the symboltypeconfiguration ID of this symbol type configuration
	*/
	@Override
	public void setSymboltypeconfigurationId(long symboltypeconfigurationId) {
		_symbolTypeConfiguration.setSymboltypeconfigurationId(symboltypeconfigurationId);
	}

	/**
	* Returns the symboltype of this symbol type configuration.
	*
	* @return the symboltype of this symbol type configuration
	*/
	@Override
	public java.lang.String getSymboltype() {
		return _symbolTypeConfiguration.getSymboltype();
	}

	/**
	* Sets the symboltype of this symbol type configuration.
	*
	* @param symboltype the symboltype of this symbol type configuration
	*/
	@Override
	public void setSymboltype(java.lang.String symboltype) {
		_symbolTypeConfiguration.setSymboltype(symboltype);
	}

	/**
	* Returns the template of this symbol type configuration.
	*
	* @return the template of this symbol type configuration
	*/
	@Override
	public java.lang.String getTemplate() {
		return _symbolTypeConfiguration.getTemplate();
	}

	/**
	* Sets the template of this symbol type configuration.
	*
	* @param template the template of this symbol type configuration
	*/
	@Override
	public void setTemplate(java.lang.String template) {
		_symbolTypeConfiguration.setTemplate(template);
	}

	/**
	* Returns the symboliconconfiguration of this symbol type configuration.
	*
	* @return the symboliconconfiguration of this symbol type configuration
	*/
	@Override
	public java.lang.String getSymboliconconfiguration() {
		return _symbolTypeConfiguration.getSymboliconconfiguration();
	}

	/**
	* Sets the symboliconconfiguration of this symbol type configuration.
	*
	* @param symboliconconfiguration the symboliconconfiguration of this symbol type configuration
	*/
	@Override
	public void setSymboliconconfiguration(
		java.lang.String symboliconconfiguration) {
		_symbolTypeConfiguration.setSymboliconconfiguration(symboliconconfiguration);
	}

	@Override
	public boolean isNew() {
		return _symbolTypeConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_symbolTypeConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _symbolTypeConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_symbolTypeConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _symbolTypeConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _symbolTypeConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_symbolTypeConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _symbolTypeConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_symbolTypeConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_symbolTypeConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_symbolTypeConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SymbolTypeConfigurationWrapper((SymbolTypeConfiguration)_symbolTypeConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration) {
		return _symbolTypeConfiguration.compareTo(symbolTypeConfiguration);
	}

	@Override
	public int hashCode() {
		return _symbolTypeConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> toCacheModel() {
		return _symbolTypeConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration toEscapedModel() {
		return new SymbolTypeConfigurationWrapper(_symbolTypeConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration toUnescapedModel() {
		return new SymbolTypeConfigurationWrapper(_symbolTypeConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _symbolTypeConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _symbolTypeConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_symbolTypeConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SymbolTypeConfigurationWrapper)) {
			return false;
		}

		SymbolTypeConfigurationWrapper symbolTypeConfigurationWrapper = (SymbolTypeConfigurationWrapper)obj;

		if (Validator.equals(_symbolTypeConfiguration,
					symbolTypeConfigurationWrapper._symbolTypeConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SymbolTypeConfiguration getWrappedSymbolTypeConfiguration() {
		return _symbolTypeConfiguration;
	}

	@Override
	public SymbolTypeConfiguration getWrappedModel() {
		return _symbolTypeConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_symbolTypeConfiguration.resetOriginalValues();
	}

	private SymbolTypeConfiguration _symbolTypeConfiguration;
}