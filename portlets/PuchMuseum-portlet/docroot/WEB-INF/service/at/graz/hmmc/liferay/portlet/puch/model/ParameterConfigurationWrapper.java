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
 * This class is a wrapper for {@link ParameterConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see ParameterConfiguration
 * @generated
 */
public class ParameterConfigurationWrapper implements ParameterConfiguration,
	ModelWrapper<ParameterConfiguration> {
	public ParameterConfigurationWrapper(
		ParameterConfiguration parameterConfiguration) {
		_parameterConfiguration = parameterConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return ParameterConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ParameterConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("displaynameshort", getDisplaynameshort());
		attributes.put("displaynamelong", getDisplaynamelong());
		attributes.put("datatype", getDatatype());
		attributes.put("group", getGroup());
		attributes.put("tab", getTab());
		attributes.put("summery", getSummery());
		attributes.put("viewscript", getViewscript());
		attributes.put("viewvisible", getViewvisible());
		attributes.put("viewtip", getViewtip());
		attributes.put("viewtitlecss", getViewtitlecss());
		attributes.put("viewvaluecss", getViewvaluecss());
		attributes.put("viewcss", getViewcss());
		attributes.put("editscript", getEditscript());
		attributes.put("editvisible", getEditvisible());
		attributes.put("edittip", getEdittip());
		attributes.put("edittitlecss", getEdittitlecss());
		attributes.put("editvaluecss", getEditvaluecss());
		attributes.put("editcss", getEditcss());
		attributes.put("editcolumnwidth", getEditcolumnwidth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String displaynameshort = (String)attributes.get("displaynameshort");

		if (displaynameshort != null) {
			setDisplaynameshort(displaynameshort);
		}

		String displaynamelong = (String)attributes.get("displaynamelong");

		if (displaynamelong != null) {
			setDisplaynamelong(displaynamelong);
		}

		String datatype = (String)attributes.get("datatype");

		if (datatype != null) {
			setDatatype(datatype);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		String tab = (String)attributes.get("tab");

		if (tab != null) {
			setTab(tab);
		}

		Boolean summery = (Boolean)attributes.get("summery");

		if (summery != null) {
			setSummery(summery);
		}

		String viewscript = (String)attributes.get("viewscript");

		if (viewscript != null) {
			setViewscript(viewscript);
		}

		Boolean viewvisible = (Boolean)attributes.get("viewvisible");

		if (viewvisible != null) {
			setViewvisible(viewvisible);
		}

		String viewtip = (String)attributes.get("viewtip");

		if (viewtip != null) {
			setViewtip(viewtip);
		}

		String viewtitlecss = (String)attributes.get("viewtitlecss");

		if (viewtitlecss != null) {
			setViewtitlecss(viewtitlecss);
		}

		String viewvaluecss = (String)attributes.get("viewvaluecss");

		if (viewvaluecss != null) {
			setViewvaluecss(viewvaluecss);
		}

		String viewcss = (String)attributes.get("viewcss");

		if (viewcss != null) {
			setViewcss(viewcss);
		}

		String editscript = (String)attributes.get("editscript");

		if (editscript != null) {
			setEditscript(editscript);
		}

		Boolean editvisible = (Boolean)attributes.get("editvisible");

		if (editvisible != null) {
			setEditvisible(editvisible);
		}

		String edittip = (String)attributes.get("edittip");

		if (edittip != null) {
			setEdittip(edittip);
		}

		String edittitlecss = (String)attributes.get("edittitlecss");

		if (edittitlecss != null) {
			setEdittitlecss(edittitlecss);
		}

		String editvaluecss = (String)attributes.get("editvaluecss");

		if (editvaluecss != null) {
			setEditvaluecss(editvaluecss);
		}

		String editcss = (String)attributes.get("editcss");

		if (editcss != null) {
			setEditcss(editcss);
		}

		Long editcolumnwidth = (Long)attributes.get("editcolumnwidth");

		if (editcolumnwidth != null) {
			setEditcolumnwidth(editcolumnwidth);
		}
	}

	/**
	* Returns the primary key of this parameter configuration.
	*
	* @return the primary key of this parameter configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _parameterConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this parameter configuration.
	*
	* @param primaryKey the primary key of this parameter configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_parameterConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the parameterconfiguration ID of this parameter configuration.
	*
	* @return the parameterconfiguration ID of this parameter configuration
	*/
	@Override
	public long getParameterconfigurationId() {
		return _parameterConfiguration.getParameterconfigurationId();
	}

	/**
	* Sets the parameterconfiguration ID of this parameter configuration.
	*
	* @param parameterconfigurationId the parameterconfiguration ID of this parameter configuration
	*/
	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterConfiguration.setParameterconfigurationId(parameterconfigurationId);
	}

	/**
	* Returns the displaynameshort of this parameter configuration.
	*
	* @return the displaynameshort of this parameter configuration
	*/
	@Override
	public java.lang.String getDisplaynameshort() {
		return _parameterConfiguration.getDisplaynameshort();
	}

	/**
	* Sets the displaynameshort of this parameter configuration.
	*
	* @param displaynameshort the displaynameshort of this parameter configuration
	*/
	@Override
	public void setDisplaynameshort(java.lang.String displaynameshort) {
		_parameterConfiguration.setDisplaynameshort(displaynameshort);
	}

	/**
	* Returns the displaynamelong of this parameter configuration.
	*
	* @return the displaynamelong of this parameter configuration
	*/
	@Override
	public java.lang.String getDisplaynamelong() {
		return _parameterConfiguration.getDisplaynamelong();
	}

	/**
	* Sets the displaynamelong of this parameter configuration.
	*
	* @param displaynamelong the displaynamelong of this parameter configuration
	*/
	@Override
	public void setDisplaynamelong(java.lang.String displaynamelong) {
		_parameterConfiguration.setDisplaynamelong(displaynamelong);
	}

	/**
	* Returns the datatype of this parameter configuration.
	*
	* @return the datatype of this parameter configuration
	*/
	@Override
	public java.lang.String getDatatype() {
		return _parameterConfiguration.getDatatype();
	}

	/**
	* Sets the datatype of this parameter configuration.
	*
	* @param datatype the datatype of this parameter configuration
	*/
	@Override
	public void setDatatype(java.lang.String datatype) {
		_parameterConfiguration.setDatatype(datatype);
	}

	/**
	* Returns the group of this parameter configuration.
	*
	* @return the group of this parameter configuration
	*/
	@Override
	public java.lang.String getGroup() {
		return _parameterConfiguration.getGroup();
	}

	/**
	* Sets the group of this parameter configuration.
	*
	* @param group the group of this parameter configuration
	*/
	@Override
	public void setGroup(java.lang.String group) {
		_parameterConfiguration.setGroup(group);
	}

	/**
	* Returns the tab of this parameter configuration.
	*
	* @return the tab of this parameter configuration
	*/
	@Override
	public java.lang.String getTab() {
		return _parameterConfiguration.getTab();
	}

	/**
	* Sets the tab of this parameter configuration.
	*
	* @param tab the tab of this parameter configuration
	*/
	@Override
	public void setTab(java.lang.String tab) {
		_parameterConfiguration.setTab(tab);
	}

	/**
	* Returns the summery of this parameter configuration.
	*
	* @return the summery of this parameter configuration
	*/
	@Override
	public boolean getSummery() {
		return _parameterConfiguration.getSummery();
	}

	/**
	* Returns <code>true</code> if this parameter configuration is summery.
	*
	* @return <code>true</code> if this parameter configuration is summery; <code>false</code> otherwise
	*/
	@Override
	public boolean isSummery() {
		return _parameterConfiguration.isSummery();
	}

	/**
	* Sets whether this parameter configuration is summery.
	*
	* @param summery the summery of this parameter configuration
	*/
	@Override
	public void setSummery(boolean summery) {
		_parameterConfiguration.setSummery(summery);
	}

	/**
	* Returns the viewscript of this parameter configuration.
	*
	* @return the viewscript of this parameter configuration
	*/
	@Override
	public java.lang.String getViewscript() {
		return _parameterConfiguration.getViewscript();
	}

	/**
	* Sets the viewscript of this parameter configuration.
	*
	* @param viewscript the viewscript of this parameter configuration
	*/
	@Override
	public void setViewscript(java.lang.String viewscript) {
		_parameterConfiguration.setViewscript(viewscript);
	}

	/**
	* Returns the viewvisible of this parameter configuration.
	*
	* @return the viewvisible of this parameter configuration
	*/
	@Override
	public boolean getViewvisible() {
		return _parameterConfiguration.getViewvisible();
	}

	/**
	* Returns <code>true</code> if this parameter configuration is viewvisible.
	*
	* @return <code>true</code> if this parameter configuration is viewvisible; <code>false</code> otherwise
	*/
	@Override
	public boolean isViewvisible() {
		return _parameterConfiguration.isViewvisible();
	}

	/**
	* Sets whether this parameter configuration is viewvisible.
	*
	* @param viewvisible the viewvisible of this parameter configuration
	*/
	@Override
	public void setViewvisible(boolean viewvisible) {
		_parameterConfiguration.setViewvisible(viewvisible);
	}

	/**
	* Returns the viewtip of this parameter configuration.
	*
	* @return the viewtip of this parameter configuration
	*/
	@Override
	public java.lang.String getViewtip() {
		return _parameterConfiguration.getViewtip();
	}

	/**
	* Sets the viewtip of this parameter configuration.
	*
	* @param viewtip the viewtip of this parameter configuration
	*/
	@Override
	public void setViewtip(java.lang.String viewtip) {
		_parameterConfiguration.setViewtip(viewtip);
	}

	/**
	* Returns the viewtitlecss of this parameter configuration.
	*
	* @return the viewtitlecss of this parameter configuration
	*/
	@Override
	public java.lang.String getViewtitlecss() {
		return _parameterConfiguration.getViewtitlecss();
	}

	/**
	* Sets the viewtitlecss of this parameter configuration.
	*
	* @param viewtitlecss the viewtitlecss of this parameter configuration
	*/
	@Override
	public void setViewtitlecss(java.lang.String viewtitlecss) {
		_parameterConfiguration.setViewtitlecss(viewtitlecss);
	}

	/**
	* Returns the viewvaluecss of this parameter configuration.
	*
	* @return the viewvaluecss of this parameter configuration
	*/
	@Override
	public java.lang.String getViewvaluecss() {
		return _parameterConfiguration.getViewvaluecss();
	}

	/**
	* Sets the viewvaluecss of this parameter configuration.
	*
	* @param viewvaluecss the viewvaluecss of this parameter configuration
	*/
	@Override
	public void setViewvaluecss(java.lang.String viewvaluecss) {
		_parameterConfiguration.setViewvaluecss(viewvaluecss);
	}

	/**
	* Returns the viewcss of this parameter configuration.
	*
	* @return the viewcss of this parameter configuration
	*/
	@Override
	public java.lang.String getViewcss() {
		return _parameterConfiguration.getViewcss();
	}

	/**
	* Sets the viewcss of this parameter configuration.
	*
	* @param viewcss the viewcss of this parameter configuration
	*/
	@Override
	public void setViewcss(java.lang.String viewcss) {
		_parameterConfiguration.setViewcss(viewcss);
	}

	/**
	* Returns the editscript of this parameter configuration.
	*
	* @return the editscript of this parameter configuration
	*/
	@Override
	public java.lang.String getEditscript() {
		return _parameterConfiguration.getEditscript();
	}

	/**
	* Sets the editscript of this parameter configuration.
	*
	* @param editscript the editscript of this parameter configuration
	*/
	@Override
	public void setEditscript(java.lang.String editscript) {
		_parameterConfiguration.setEditscript(editscript);
	}

	/**
	* Returns the editvisible of this parameter configuration.
	*
	* @return the editvisible of this parameter configuration
	*/
	@Override
	public boolean getEditvisible() {
		return _parameterConfiguration.getEditvisible();
	}

	/**
	* Returns <code>true</code> if this parameter configuration is editvisible.
	*
	* @return <code>true</code> if this parameter configuration is editvisible; <code>false</code> otherwise
	*/
	@Override
	public boolean isEditvisible() {
		return _parameterConfiguration.isEditvisible();
	}

	/**
	* Sets whether this parameter configuration is editvisible.
	*
	* @param editvisible the editvisible of this parameter configuration
	*/
	@Override
	public void setEditvisible(boolean editvisible) {
		_parameterConfiguration.setEditvisible(editvisible);
	}

	/**
	* Returns the edittip of this parameter configuration.
	*
	* @return the edittip of this parameter configuration
	*/
	@Override
	public java.lang.String getEdittip() {
		return _parameterConfiguration.getEdittip();
	}

	/**
	* Sets the edittip of this parameter configuration.
	*
	* @param edittip the edittip of this parameter configuration
	*/
	@Override
	public void setEdittip(java.lang.String edittip) {
		_parameterConfiguration.setEdittip(edittip);
	}

	/**
	* Returns the edittitlecss of this parameter configuration.
	*
	* @return the edittitlecss of this parameter configuration
	*/
	@Override
	public java.lang.String getEdittitlecss() {
		return _parameterConfiguration.getEdittitlecss();
	}

	/**
	* Sets the edittitlecss of this parameter configuration.
	*
	* @param edittitlecss the edittitlecss of this parameter configuration
	*/
	@Override
	public void setEdittitlecss(java.lang.String edittitlecss) {
		_parameterConfiguration.setEdittitlecss(edittitlecss);
	}

	/**
	* Returns the editvaluecss of this parameter configuration.
	*
	* @return the editvaluecss of this parameter configuration
	*/
	@Override
	public java.lang.String getEditvaluecss() {
		return _parameterConfiguration.getEditvaluecss();
	}

	/**
	* Sets the editvaluecss of this parameter configuration.
	*
	* @param editvaluecss the editvaluecss of this parameter configuration
	*/
	@Override
	public void setEditvaluecss(java.lang.String editvaluecss) {
		_parameterConfiguration.setEditvaluecss(editvaluecss);
	}

	/**
	* Returns the editcss of this parameter configuration.
	*
	* @return the editcss of this parameter configuration
	*/
	@Override
	public java.lang.String getEditcss() {
		return _parameterConfiguration.getEditcss();
	}

	/**
	* Sets the editcss of this parameter configuration.
	*
	* @param editcss the editcss of this parameter configuration
	*/
	@Override
	public void setEditcss(java.lang.String editcss) {
		_parameterConfiguration.setEditcss(editcss);
	}

	/**
	* Returns the editcolumnwidth of this parameter configuration.
	*
	* @return the editcolumnwidth of this parameter configuration
	*/
	@Override
	public long getEditcolumnwidth() {
		return _parameterConfiguration.getEditcolumnwidth();
	}

	/**
	* Sets the editcolumnwidth of this parameter configuration.
	*
	* @param editcolumnwidth the editcolumnwidth of this parameter configuration
	*/
	@Override
	public void setEditcolumnwidth(long editcolumnwidth) {
		_parameterConfiguration.setEditcolumnwidth(editcolumnwidth);
	}

	@Override
	public boolean isNew() {
		return _parameterConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_parameterConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _parameterConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_parameterConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _parameterConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _parameterConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_parameterConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _parameterConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_parameterConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_parameterConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_parameterConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParameterConfigurationWrapper((ParameterConfiguration)_parameterConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration) {
		return _parameterConfiguration.compareTo(parameterConfiguration);
	}

	@Override
	public int hashCode() {
		return _parameterConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> toCacheModel() {
		return _parameterConfiguration.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration toEscapedModel() {
		return new ParameterConfigurationWrapper(_parameterConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration toUnescapedModel() {
		return new ParameterConfigurationWrapper(_parameterConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _parameterConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _parameterConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_parameterConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParameterConfigurationWrapper)) {
			return false;
		}

		ParameterConfigurationWrapper parameterConfigurationWrapper = (ParameterConfigurationWrapper)obj;

		if (Validator.equals(_parameterConfiguration,
					parameterConfigurationWrapper._parameterConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ParameterConfiguration getWrappedParameterConfiguration() {
		return _parameterConfiguration;
	}

	@Override
	public ParameterConfiguration getWrappedModel() {
		return _parameterConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_parameterConfiguration.resetOriginalValues();
	}

	private ParameterConfiguration _parameterConfiguration;
}