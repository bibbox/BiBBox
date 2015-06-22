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
 * This class is a wrapper for {@link SymbolConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see SymbolConfiguration
 * @generated
 */
public class SymbolConfigurationWrapper implements SymbolConfiguration,
	ModelWrapper<SymbolConfiguration> {
	public SymbolConfigurationWrapper(SymbolConfiguration symbolConfiguration) {
		_symbolConfiguration = symbolConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return SymbolConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SymbolConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("scope", getScope());
		attributes.put("eventtype", getEventtype());
		attributes.put("basecolor", getBasecolor());
		attributes.put("symboltype", getSymboltype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String eventtype = (String)attributes.get("eventtype");

		if (eventtype != null) {
			setEventtype(eventtype);
		}

		String basecolor = (String)attributes.get("basecolor");

		if (basecolor != null) {
			setBasecolor(basecolor);
		}

		String symboltype = (String)attributes.get("symboltype");

		if (symboltype != null) {
			setSymboltype(symboltype);
		}
	}

	/**
	* Returns the primary key of this symbol configuration.
	*
	* @return the primary key of this symbol configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _symbolConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this symbol configuration.
	*
	* @param primaryKey the primary key of this symbol configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_symbolConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the symbolconfiguration ID of this symbol configuration.
	*
	* @return the symbolconfiguration ID of this symbol configuration
	*/
	@Override
	public long getSymbolconfigurationId() {
		return _symbolConfiguration.getSymbolconfigurationId();
	}

	/**
	* Sets the symbolconfiguration ID of this symbol configuration.
	*
	* @param symbolconfigurationId the symbolconfiguration ID of this symbol configuration
	*/
	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolConfiguration.setSymbolconfigurationId(symbolconfigurationId);
	}

	/**
	* Returns the scope of this symbol configuration.
	*
	* @return the scope of this symbol configuration
	*/
	@Override
	public java.lang.String getScope() {
		return _symbolConfiguration.getScope();
	}

	/**
	* Sets the scope of this symbol configuration.
	*
	* @param scope the scope of this symbol configuration
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_symbolConfiguration.setScope(scope);
	}

	/**
	* Returns the eventtype of this symbol configuration.
	*
	* @return the eventtype of this symbol configuration
	*/
	@Override
	public java.lang.String getEventtype() {
		return _symbolConfiguration.getEventtype();
	}

	/**
	* Sets the eventtype of this symbol configuration.
	*
	* @param eventtype the eventtype of this symbol configuration
	*/
	@Override
	public void setEventtype(java.lang.String eventtype) {
		_symbolConfiguration.setEventtype(eventtype);
	}

	/**
	* Returns the basecolor of this symbol configuration.
	*
	* @return the basecolor of this symbol configuration
	*/
	@Override
	public java.lang.String getBasecolor() {
		return _symbolConfiguration.getBasecolor();
	}

	/**
	* Sets the basecolor of this symbol configuration.
	*
	* @param basecolor the basecolor of this symbol configuration
	*/
	@Override
	public void setBasecolor(java.lang.String basecolor) {
		_symbolConfiguration.setBasecolor(basecolor);
	}

	/**
	* Returns the symboltype of this symbol configuration.
	*
	* @return the symboltype of this symbol configuration
	*/
	@Override
	public java.lang.String getSymboltype() {
		return _symbolConfiguration.getSymboltype();
	}

	/**
	* Sets the symboltype of this symbol configuration.
	*
	* @param symboltype the symboltype of this symbol configuration
	*/
	@Override
	public void setSymboltype(java.lang.String symboltype) {
		_symbolConfiguration.setSymboltype(symboltype);
	}

	@Override
	public boolean isNew() {
		return _symbolConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_symbolConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _symbolConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_symbolConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _symbolConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _symbolConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_symbolConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _symbolConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_symbolConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_symbolConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_symbolConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SymbolConfigurationWrapper((SymbolConfiguration)_symbolConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration) {
		return _symbolConfiguration.compareTo(symbolConfiguration);
	}

	@Override
	public int hashCode() {
		return _symbolConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> toCacheModel() {
		return _symbolConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration toEscapedModel() {
		return new SymbolConfigurationWrapper(_symbolConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration toUnescapedModel() {
		return new SymbolConfigurationWrapper(_symbolConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _symbolConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _symbolConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_symbolConfiguration.persist();
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getTemplate() {
		return _symbolConfiguration.getTemplate();
	}

	@Override
	public java.lang.String getSymbolIconConfiguration() {
		return _symbolConfiguration.getSymbolIconConfiguration();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SymbolConfigurationWrapper)) {
			return false;
		}

		SymbolConfigurationWrapper symbolConfigurationWrapper = (SymbolConfigurationWrapper)obj;

		if (Validator.equals(_symbolConfiguration,
					symbolConfigurationWrapper._symbolConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SymbolConfiguration getWrappedSymbolConfiguration() {
		return _symbolConfiguration;
	}

	@Override
	public SymbolConfiguration getWrappedModel() {
		return _symbolConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_symbolConfiguration.resetOriginalValues();
	}

	private SymbolConfiguration _symbolConfiguration;
}