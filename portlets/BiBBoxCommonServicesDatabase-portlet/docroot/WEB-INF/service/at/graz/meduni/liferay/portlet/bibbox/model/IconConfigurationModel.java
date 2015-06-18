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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the IconConfiguration service. Represents a row in the &quot;bibboxcs.iconconfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl}.
 * </p>
 *
 * @author reihsr
 * @see IconConfiguration
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl
 * @generated
 */
public interface IconConfigurationModel extends BaseModel<IconConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a icon configuration model instance should use the {@link IconConfiguration} interface instead.
	 */

	/**
	 * Returns the primary key of this icon configuration.
	 *
	 * @return the primary key of this icon configuration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this icon configuration.
	 *
	 * @param primaryKey the primary key of this icon configuration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the iconconfiguration ID of this icon configuration.
	 *
	 * @return the iconconfiguration ID of this icon configuration
	 */
	public long getIconconfigurationId();

	/**
	 * Sets the iconconfiguration ID of this icon configuration.
	 *
	 * @param iconconfigurationId the iconconfiguration ID of this icon configuration
	 */
	public void setIconconfigurationId(long iconconfigurationId);

	/**
	 * Returns the symbolconfiguration ID of this icon configuration.
	 *
	 * @return the symbolconfiguration ID of this icon configuration
	 */
	public long getSymbolconfigurationId();

	/**
	 * Sets the symbolconfiguration ID of this icon configuration.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID of this icon configuration
	 */
	public void setSymbolconfigurationId(long symbolconfigurationId);

	/**
	 * Returns the position of this icon configuration.
	 *
	 * @return the position of this icon configuration
	 */
	@AutoEscape
	public String getPosition();

	/**
	 * Sets the position of this icon configuration.
	 *
	 * @param position the position of this icon configuration
	 */
	public void setPosition(String position);

	/**
	 * Returns the key of this icon configuration.
	 *
	 * @return the key of this icon configuration
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this icon configuration.
	 *
	 * @param key the key of this icon configuration
	 */
	public void setKey(String key);

	/**
	 * Returns the image of this icon configuration.
	 *
	 * @return the image of this icon configuration
	 */
	@AutoEscape
	public String getImage();

	/**
	 * Sets the image of this icon configuration.
	 *
	 * @param image the image of this icon configuration
	 */
	public void setImage(String image);

	/**
	 * Returns the elementcolor of this icon configuration.
	 *
	 * @return the elementcolor of this icon configuration
	 */
	@AutoEscape
	public String getElementcolor();

	/**
	 * Sets the elementcolor of this icon configuration.
	 *
	 * @param elementcolor the elementcolor of this icon configuration
	 */
	public void setElementcolor(String elementcolor);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(IconConfiguration iconConfiguration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<IconConfiguration> toCacheModel();

	@Override
	public IconConfiguration toEscapedModel();

	@Override
	public IconConfiguration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}