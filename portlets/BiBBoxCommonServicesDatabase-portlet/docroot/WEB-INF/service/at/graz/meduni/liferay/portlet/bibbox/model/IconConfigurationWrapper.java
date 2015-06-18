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
 * This class is a wrapper for {@link IconConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see IconConfiguration
 * @generated
 */
public class IconConfigurationWrapper implements IconConfiguration,
	ModelWrapper<IconConfiguration> {
	public IconConfigurationWrapper(IconConfiguration iconConfiguration) {
		_iconConfiguration = iconConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return IconConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return IconConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconconfigurationId", getIconconfigurationId());
		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("position", getPosition());
		attributes.put("key", getKey());
		attributes.put("image", getImage());
		attributes.put("elementcolor", getElementcolor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconconfigurationId = (Long)attributes.get("iconconfigurationId");

		if (iconconfigurationId != null) {
			setIconconfigurationId(iconconfigurationId);
		}

		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String elementcolor = (String)attributes.get("elementcolor");

		if (elementcolor != null) {
			setElementcolor(elementcolor);
		}
	}

	/**
	* Returns the primary key of this icon configuration.
	*
	* @return the primary key of this icon configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _iconConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this icon configuration.
	*
	* @param primaryKey the primary key of this icon configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_iconConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the iconconfiguration ID of this icon configuration.
	*
	* @return the iconconfiguration ID of this icon configuration
	*/
	@Override
	public long getIconconfigurationId() {
		return _iconConfiguration.getIconconfigurationId();
	}

	/**
	* Sets the iconconfiguration ID of this icon configuration.
	*
	* @param iconconfigurationId the iconconfiguration ID of this icon configuration
	*/
	@Override
	public void setIconconfigurationId(long iconconfigurationId) {
		_iconConfiguration.setIconconfigurationId(iconconfigurationId);
	}

	/**
	* Returns the symbolconfiguration ID of this icon configuration.
	*
	* @return the symbolconfiguration ID of this icon configuration
	*/
	@Override
	public long getSymbolconfigurationId() {
		return _iconConfiguration.getSymbolconfigurationId();
	}

	/**
	* Sets the symbolconfiguration ID of this icon configuration.
	*
	* @param symbolconfigurationId the symbolconfiguration ID of this icon configuration
	*/
	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_iconConfiguration.setSymbolconfigurationId(symbolconfigurationId);
	}

	/**
	* Returns the position of this icon configuration.
	*
	* @return the position of this icon configuration
	*/
	@Override
	public java.lang.String getPosition() {
		return _iconConfiguration.getPosition();
	}

	/**
	* Sets the position of this icon configuration.
	*
	* @param position the position of this icon configuration
	*/
	@Override
	public void setPosition(java.lang.String position) {
		_iconConfiguration.setPosition(position);
	}

	/**
	* Returns the key of this icon configuration.
	*
	* @return the key of this icon configuration
	*/
	@Override
	public java.lang.String getKey() {
		return _iconConfiguration.getKey();
	}

	/**
	* Sets the key of this icon configuration.
	*
	* @param key the key of this icon configuration
	*/
	@Override
	public void setKey(java.lang.String key) {
		_iconConfiguration.setKey(key);
	}

	/**
	* Returns the image of this icon configuration.
	*
	* @return the image of this icon configuration
	*/
	@Override
	public java.lang.String getImage() {
		return _iconConfiguration.getImage();
	}

	/**
	* Sets the image of this icon configuration.
	*
	* @param image the image of this icon configuration
	*/
	@Override
	public void setImage(java.lang.String image) {
		_iconConfiguration.setImage(image);
	}

	/**
	* Returns the elementcolor of this icon configuration.
	*
	* @return the elementcolor of this icon configuration
	*/
	@Override
	public java.lang.String getElementcolor() {
		return _iconConfiguration.getElementcolor();
	}

	/**
	* Sets the elementcolor of this icon configuration.
	*
	* @param elementcolor the elementcolor of this icon configuration
	*/
	@Override
	public void setElementcolor(java.lang.String elementcolor) {
		_iconConfiguration.setElementcolor(elementcolor);
	}

	@Override
	public boolean isNew() {
		return _iconConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_iconConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _iconConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_iconConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _iconConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _iconConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_iconConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _iconConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_iconConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_iconConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_iconConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IconConfigurationWrapper((IconConfiguration)_iconConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration) {
		return _iconConfiguration.compareTo(iconConfiguration);
	}

	@Override
	public int hashCode() {
		return _iconConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> toCacheModel() {
		return _iconConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration toEscapedModel() {
		return new IconConfigurationWrapper(_iconConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration toUnescapedModel() {
		return new IconConfigurationWrapper(_iconConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _iconConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _iconConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_iconConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IconConfigurationWrapper)) {
			return false;
		}

		IconConfigurationWrapper iconConfigurationWrapper = (IconConfigurationWrapper)obj;

		if (Validator.equals(_iconConfiguration,
					iconConfigurationWrapper._iconConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public IconConfiguration getWrappedIconConfiguration() {
		return _iconConfiguration;
	}

	@Override
	public IconConfiguration getWrappedModel() {
		return _iconConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_iconConfiguration.resetOriginalValues();
	}

	private IconConfiguration _iconConfiguration;
}