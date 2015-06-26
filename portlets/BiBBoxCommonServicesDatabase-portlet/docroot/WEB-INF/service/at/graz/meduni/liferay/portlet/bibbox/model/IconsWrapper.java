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
 * This class is a wrapper for {@link Icons}.
 * </p>
 *
 * @author reihsr
 * @see Icons
 * @generated
 */
public class IconsWrapper implements Icons, ModelWrapper<Icons> {
	public IconsWrapper(Icons icons) {
		_icons = icons;
	}

	@Override
	public Class<?> getModelClass() {
		return Icons.class;
	}

	@Override
	public String getModelClassName() {
		return Icons.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconsId", getIconsId());
		attributes.put("iconurl", getIconurl());
		attributes.put("group", getGroup());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconsId = (Long)attributes.get("iconsId");

		if (iconsId != null) {
			setIconsId(iconsId);
		}

		String iconurl = (String)attributes.get("iconurl");

		if (iconurl != null) {
			setIconurl(iconurl);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}
	}

	/**
	* Returns the primary key of this icons.
	*
	* @return the primary key of this icons
	*/
	@Override
	public long getPrimaryKey() {
		return _icons.getPrimaryKey();
	}

	/**
	* Sets the primary key of this icons.
	*
	* @param primaryKey the primary key of this icons
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_icons.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the icons ID of this icons.
	*
	* @return the icons ID of this icons
	*/
	@Override
	public long getIconsId() {
		return _icons.getIconsId();
	}

	/**
	* Sets the icons ID of this icons.
	*
	* @param iconsId the icons ID of this icons
	*/
	@Override
	public void setIconsId(long iconsId) {
		_icons.setIconsId(iconsId);
	}

	/**
	* Returns the iconurl of this icons.
	*
	* @return the iconurl of this icons
	*/
	@Override
	public java.lang.String getIconurl() {
		return _icons.getIconurl();
	}

	/**
	* Sets the iconurl of this icons.
	*
	* @param iconurl the iconurl of this icons
	*/
	@Override
	public void setIconurl(java.lang.String iconurl) {
		_icons.setIconurl(iconurl);
	}

	/**
	* Returns the group of this icons.
	*
	* @return the group of this icons
	*/
	@Override
	public java.lang.String getGroup() {
		return _icons.getGroup();
	}

	/**
	* Sets the group of this icons.
	*
	* @param group the group of this icons
	*/
	@Override
	public void setGroup(java.lang.String group) {
		_icons.setGroup(group);
	}

	@Override
	public boolean isNew() {
		return _icons.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_icons.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _icons.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_icons.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _icons.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _icons.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_icons.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _icons.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_icons.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_icons.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_icons.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IconsWrapper((Icons)_icons.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.Icons icons) {
		return _icons.compareTo(icons);
	}

	@Override
	public int hashCode() {
		return _icons.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.Icons> toCacheModel() {
		return _icons.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons toEscapedModel() {
		return new IconsWrapper(_icons.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.Icons toUnescapedModel() {
		return new IconsWrapper(_icons.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _icons.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _icons.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_icons.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IconsWrapper)) {
			return false;
		}

		IconsWrapper iconsWrapper = (IconsWrapper)obj;

		if (Validator.equals(_icons, iconsWrapper._icons)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Icons getWrappedIcons() {
		return _icons;
	}

	@Override
	public Icons getWrappedModel() {
		return _icons;
	}

	@Override
	public void resetOriginalValues() {
		_icons.resetOriginalValues();
	}

	private Icons _icons;
}