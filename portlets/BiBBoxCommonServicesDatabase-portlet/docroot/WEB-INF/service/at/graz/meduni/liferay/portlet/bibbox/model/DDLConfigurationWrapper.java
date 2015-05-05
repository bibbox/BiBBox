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
 * This class is a wrapper for {@link DDLConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see DDLConfiguration
 * @generated
 */
public class DDLConfigurationWrapper implements DDLConfiguration,
	ModelWrapper<DDLConfiguration> {
	public DDLConfigurationWrapper(DDLConfiguration ddlConfiguration) {
		_ddlConfiguration = ddlConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return DDLConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return DDLConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddlconfigurationId", getDdlconfigurationId());
		attributes.put("ddmstructureId", getDdmstructureId());
		attributes.put("fieldname", getFieldname());
		attributes.put("group", getGroup());
		attributes.put("display", getDisplay());
		attributes.put("viewscript", getViewscript());
		attributes.put("displaytip", getDisplaytip());
		attributes.put("viewtitlecss", getViewtitlecss());
		attributes.put("viewvaluecss", getViewvaluecss());
		attributes.put("columwidth", getColumwidth());
		attributes.put("editscript", getEditscript());
		attributes.put("edittip", getEdittip());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddlconfigurationId = (Long)attributes.get("ddlconfigurationId");

		if (ddlconfigurationId != null) {
			setDdlconfigurationId(ddlconfigurationId);
		}

		Long ddmstructureId = (Long)attributes.get("ddmstructureId");

		if (ddmstructureId != null) {
			setDdmstructureId(ddmstructureId);
		}

		String fieldname = (String)attributes.get("fieldname");

		if (fieldname != null) {
			setFieldname(fieldname);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Boolean display = (Boolean)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		String viewscript = (String)attributes.get("viewscript");

		if (viewscript != null) {
			setViewscript(viewscript);
		}

		String displaytip = (String)attributes.get("displaytip");

		if (displaytip != null) {
			setDisplaytip(displaytip);
		}

		String viewtitlecss = (String)attributes.get("viewtitlecss");

		if (viewtitlecss != null) {
			setViewtitlecss(viewtitlecss);
		}

		String viewvaluecss = (String)attributes.get("viewvaluecss");

		if (viewvaluecss != null) {
			setViewvaluecss(viewvaluecss);
		}

		Long columwidth = (Long)attributes.get("columwidth");

		if (columwidth != null) {
			setColumwidth(columwidth);
		}

		String editscript = (String)attributes.get("editscript");

		if (editscript != null) {
			setEditscript(editscript);
		}

		String edittip = (String)attributes.get("edittip");

		if (edittip != null) {
			setEdittip(edittip);
		}
	}

	/**
	* Returns the primary key of this d d l configuration.
	*
	* @return the primary key of this d d l configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _ddlConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d d l configuration.
	*
	* @param primaryKey the primary key of this d d l configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ddlConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ddlconfiguration ID of this d d l configuration.
	*
	* @return the ddlconfiguration ID of this d d l configuration
	*/
	@Override
	public long getDdlconfigurationId() {
		return _ddlConfiguration.getDdlconfigurationId();
	}

	/**
	* Sets the ddlconfiguration ID of this d d l configuration.
	*
	* @param ddlconfigurationId the ddlconfiguration ID of this d d l configuration
	*/
	@Override
	public void setDdlconfigurationId(long ddlconfigurationId) {
		_ddlConfiguration.setDdlconfigurationId(ddlconfigurationId);
	}

	/**
	* Returns the ddmstructure ID of this d d l configuration.
	*
	* @return the ddmstructure ID of this d d l configuration
	*/
	@Override
	public long getDdmstructureId() {
		return _ddlConfiguration.getDdmstructureId();
	}

	/**
	* Sets the ddmstructure ID of this d d l configuration.
	*
	* @param ddmstructureId the ddmstructure ID of this d d l configuration
	*/
	@Override
	public void setDdmstructureId(long ddmstructureId) {
		_ddlConfiguration.setDdmstructureId(ddmstructureId);
	}

	/**
	* Returns the fieldname of this d d l configuration.
	*
	* @return the fieldname of this d d l configuration
	*/
	@Override
	public java.lang.String getFieldname() {
		return _ddlConfiguration.getFieldname();
	}

	/**
	* Sets the fieldname of this d d l configuration.
	*
	* @param fieldname the fieldname of this d d l configuration
	*/
	@Override
	public void setFieldname(java.lang.String fieldname) {
		_ddlConfiguration.setFieldname(fieldname);
	}

	/**
	* Returns the group of this d d l configuration.
	*
	* @return the group of this d d l configuration
	*/
	@Override
	public java.lang.String getGroup() {
		return _ddlConfiguration.getGroup();
	}

	/**
	* Sets the group of this d d l configuration.
	*
	* @param group the group of this d d l configuration
	*/
	@Override
	public void setGroup(java.lang.String group) {
		_ddlConfiguration.setGroup(group);
	}

	/**
	* Returns the display of this d d l configuration.
	*
	* @return the display of this d d l configuration
	*/
	@Override
	public boolean getDisplay() {
		return _ddlConfiguration.getDisplay();
	}

	/**
	* Returns <code>true</code> if this d d l configuration is display.
	*
	* @return <code>true</code> if this d d l configuration is display; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplay() {
		return _ddlConfiguration.isDisplay();
	}

	/**
	* Sets whether this d d l configuration is display.
	*
	* @param display the display of this d d l configuration
	*/
	@Override
	public void setDisplay(boolean display) {
		_ddlConfiguration.setDisplay(display);
	}

	/**
	* Returns the viewscript of this d d l configuration.
	*
	* @return the viewscript of this d d l configuration
	*/
	@Override
	public java.lang.String getViewscript() {
		return _ddlConfiguration.getViewscript();
	}

	/**
	* Sets the viewscript of this d d l configuration.
	*
	* @param viewscript the viewscript of this d d l configuration
	*/
	@Override
	public void setViewscript(java.lang.String viewscript) {
		_ddlConfiguration.setViewscript(viewscript);
	}

	/**
	* Returns the displaytip of this d d l configuration.
	*
	* @return the displaytip of this d d l configuration
	*/
	@Override
	public java.lang.String getDisplaytip() {
		return _ddlConfiguration.getDisplaytip();
	}

	/**
	* Sets the displaytip of this d d l configuration.
	*
	* @param displaytip the displaytip of this d d l configuration
	*/
	@Override
	public void setDisplaytip(java.lang.String displaytip) {
		_ddlConfiguration.setDisplaytip(displaytip);
	}

	/**
	* Returns the viewtitlecss of this d d l configuration.
	*
	* @return the viewtitlecss of this d d l configuration
	*/
	@Override
	public java.lang.String getViewtitlecss() {
		return _ddlConfiguration.getViewtitlecss();
	}

	/**
	* Sets the viewtitlecss of this d d l configuration.
	*
	* @param viewtitlecss the viewtitlecss of this d d l configuration
	*/
	@Override
	public void setViewtitlecss(java.lang.String viewtitlecss) {
		_ddlConfiguration.setViewtitlecss(viewtitlecss);
	}

	/**
	* Returns the viewvaluecss of this d d l configuration.
	*
	* @return the viewvaluecss of this d d l configuration
	*/
	@Override
	public java.lang.String getViewvaluecss() {
		return _ddlConfiguration.getViewvaluecss();
	}

	/**
	* Sets the viewvaluecss of this d d l configuration.
	*
	* @param viewvaluecss the viewvaluecss of this d d l configuration
	*/
	@Override
	public void setViewvaluecss(java.lang.String viewvaluecss) {
		_ddlConfiguration.setViewvaluecss(viewvaluecss);
	}

	/**
	* Returns the columwidth of this d d l configuration.
	*
	* @return the columwidth of this d d l configuration
	*/
	@Override
	public long getColumwidth() {
		return _ddlConfiguration.getColumwidth();
	}

	/**
	* Sets the columwidth of this d d l configuration.
	*
	* @param columwidth the columwidth of this d d l configuration
	*/
	@Override
	public void setColumwidth(long columwidth) {
		_ddlConfiguration.setColumwidth(columwidth);
	}

	/**
	* Returns the editscript of this d d l configuration.
	*
	* @return the editscript of this d d l configuration
	*/
	@Override
	public java.lang.String getEditscript() {
		return _ddlConfiguration.getEditscript();
	}

	/**
	* Sets the editscript of this d d l configuration.
	*
	* @param editscript the editscript of this d d l configuration
	*/
	@Override
	public void setEditscript(java.lang.String editscript) {
		_ddlConfiguration.setEditscript(editscript);
	}

	/**
	* Returns the edittip of this d d l configuration.
	*
	* @return the edittip of this d d l configuration
	*/
	@Override
	public java.lang.String getEdittip() {
		return _ddlConfiguration.getEdittip();
	}

	/**
	* Sets the edittip of this d d l configuration.
	*
	* @param edittip the edittip of this d d l configuration
	*/
	@Override
	public void setEdittip(java.lang.String edittip) {
		_ddlConfiguration.setEdittip(edittip);
	}

	@Override
	public boolean isNew() {
		return _ddlConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ddlConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ddlConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ddlConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ddlConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ddlConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ddlConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ddlConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ddlConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ddlConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ddlConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DDLConfigurationWrapper((DDLConfiguration)_ddlConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration) {
		return _ddlConfiguration.compareTo(ddlConfiguration);
	}

	@Override
	public int hashCode() {
		return _ddlConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> toCacheModel() {
		return _ddlConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration toEscapedModel() {
		return new DDLConfigurationWrapper(_ddlConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration toUnescapedModel() {
		return new DDLConfigurationWrapper(_ddlConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ddlConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ddlConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ddlConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DDLConfigurationWrapper)) {
			return false;
		}

		DDLConfigurationWrapper ddlConfigurationWrapper = (DDLConfigurationWrapper)obj;

		if (Validator.equals(_ddlConfiguration,
					ddlConfigurationWrapper._ddlConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DDLConfiguration getWrappedDDLConfiguration() {
		return _ddlConfiguration;
	}

	@Override
	public DDLConfiguration getWrappedModel() {
		return _ddlConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_ddlConfiguration.resetOriginalValues();
	}

	private DDLConfiguration _ddlConfiguration;
}