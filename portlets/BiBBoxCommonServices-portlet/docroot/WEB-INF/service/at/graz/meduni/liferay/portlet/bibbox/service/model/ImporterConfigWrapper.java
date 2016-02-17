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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ImporterConfig}.
 * </p>
 *
 * @author reihsr
 * @see ImporterConfig
 * @generated
 */
public class ImporterConfigWrapper implements ImporterConfig,
	ModelWrapper<ImporterConfig> {
	public ImporterConfigWrapper(ImporterConfig importerConfig) {
		_importerConfig = importerConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return ImporterConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ImporterConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("importerconfigId", getImporterconfigId());
		attributes.put("scope", getScope());
		attributes.put("elementId", getElementId());
		attributes.put("elementvalue", getElementvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long importerconfigId = (Long)attributes.get("importerconfigId");

		if (importerconfigId != null) {
			setImporterconfigId(importerconfigId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String elementvalue = (String)attributes.get("elementvalue");

		if (elementvalue != null) {
			setElementvalue(elementvalue);
		}
	}

	/**
	* Returns the primary key of this importer config.
	*
	* @return the primary key of this importer config
	*/
	@Override
	public long getPrimaryKey() {
		return _importerConfig.getPrimaryKey();
	}

	/**
	* Sets the primary key of this importer config.
	*
	* @param primaryKey the primary key of this importer config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_importerConfig.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the importerconfig ID of this importer config.
	*
	* @return the importerconfig ID of this importer config
	*/
	@Override
	public long getImporterconfigId() {
		return _importerConfig.getImporterconfigId();
	}

	/**
	* Sets the importerconfig ID of this importer config.
	*
	* @param importerconfigId the importerconfig ID of this importer config
	*/
	@Override
	public void setImporterconfigId(long importerconfigId) {
		_importerConfig.setImporterconfigId(importerconfigId);
	}

	/**
	* Returns the scope of this importer config.
	*
	* @return the scope of this importer config
	*/
	@Override
	public java.lang.String getScope() {
		return _importerConfig.getScope();
	}

	/**
	* Sets the scope of this importer config.
	*
	* @param scope the scope of this importer config
	*/
	@Override
	public void setScope(java.lang.String scope) {
		_importerConfig.setScope(scope);
	}

	/**
	* Returns the element ID of this importer config.
	*
	* @return the element ID of this importer config
	*/
	@Override
	public java.lang.String getElementId() {
		return _importerConfig.getElementId();
	}

	/**
	* Sets the element ID of this importer config.
	*
	* @param elementId the element ID of this importer config
	*/
	@Override
	public void setElementId(java.lang.String elementId) {
		_importerConfig.setElementId(elementId);
	}

	/**
	* Returns the elementvalue of this importer config.
	*
	* @return the elementvalue of this importer config
	*/
	@Override
	public java.lang.String getElementvalue() {
		return _importerConfig.getElementvalue();
	}

	/**
	* Sets the elementvalue of this importer config.
	*
	* @param elementvalue the elementvalue of this importer config
	*/
	@Override
	public void setElementvalue(java.lang.String elementvalue) {
		_importerConfig.setElementvalue(elementvalue);
	}

	@Override
	public boolean isNew() {
		return _importerConfig.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_importerConfig.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _importerConfig.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_importerConfig.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _importerConfig.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _importerConfig.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_importerConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _importerConfig.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_importerConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_importerConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_importerConfig.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImporterConfigWrapper((ImporterConfig)_importerConfig.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig) {
		return _importerConfig.compareTo(importerConfig);
	}

	@Override
	public int hashCode() {
		return _importerConfig.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> toCacheModel() {
		return _importerConfig.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig toEscapedModel() {
		return new ImporterConfigWrapper(_importerConfig.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig toUnescapedModel() {
		return new ImporterConfigWrapper(_importerConfig.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _importerConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _importerConfig.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_importerConfig.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImporterConfigWrapper)) {
			return false;
		}

		ImporterConfigWrapper importerConfigWrapper = (ImporterConfigWrapper)obj;

		if (Validator.equals(_importerConfig,
					importerConfigWrapper._importerConfig)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ImporterConfig getWrappedImporterConfig() {
		return _importerConfig;
	}

	@Override
	public ImporterConfig getWrappedModel() {
		return _importerConfig;
	}

	@Override
	public void resetOriginalValues() {
		_importerConfig.resetOriginalValues();
	}

	private ImporterConfig _importerConfig;
}