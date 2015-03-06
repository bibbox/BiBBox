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
 * This class is a wrapper for {@link KdssmpParameterConfiguration}.
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterConfiguration
 * @generated
 */
public class KdssmpParameterConfigurationWrapper
	implements KdssmpParameterConfiguration,
		ModelWrapper<KdssmpParameterConfiguration> {
	public KdssmpParameterConfigurationWrapper(
		KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		_kdssmpParameterConfiguration = kdssmpParameterConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpParameterConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpParameterConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("displayname", getDisplayname());
		attributes.put("datatype", getDatatype());
		attributes.put("valuerange", getValuerange());
		attributes.put("displayoptions", getDisplayoptions());
		attributes.put("visible", getVisible());
		attributes.put("computed", getComputed());
		attributes.put("confirmationscript", getConfirmationscript());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String displayname = (String)attributes.get("displayname");

		if (displayname != null) {
			setDisplayname(displayname);
		}

		String datatype = (String)attributes.get("datatype");

		if (datatype != null) {
			setDatatype(datatype);
		}

		String valuerange = (String)attributes.get("valuerange");

		if (valuerange != null) {
			setValuerange(valuerange);
		}

		String displayoptions = (String)attributes.get("displayoptions");

		if (displayoptions != null) {
			setDisplayoptions(displayoptions);
		}

		String visible = (String)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}

		String computed = (String)attributes.get("computed");

		if (computed != null) {
			setComputed(computed);
		}

		String confirmationscript = (String)attributes.get("confirmationscript");

		if (confirmationscript != null) {
			setConfirmationscript(confirmationscript);
		}
	}

	/**
	* Returns the primary key of this kdssmp parameter configuration.
	*
	* @return the primary key of this kdssmp parameter configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _kdssmpParameterConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kdssmp parameter configuration.
	*
	* @param primaryKey the primary key of this kdssmp parameter configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kdssmpParameterConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the parameterconfiguration ID of this kdssmp parameter configuration.
	*
	* @return the parameterconfiguration ID of this kdssmp parameter configuration
	*/
	@Override
	public long getParameterconfigurationId() {
		return _kdssmpParameterConfiguration.getParameterconfigurationId();
	}

	/**
	* Sets the parameterconfiguration ID of this kdssmp parameter configuration.
	*
	* @param parameterconfigurationId the parameterconfiguration ID of this kdssmp parameter configuration
	*/
	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_kdssmpParameterConfiguration.setParameterconfigurationId(parameterconfigurationId);
	}

	/**
	* Returns the displayname of this kdssmp parameter configuration.
	*
	* @return the displayname of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getDisplayname() {
		return _kdssmpParameterConfiguration.getDisplayname();
	}

	/**
	* Sets the displayname of this kdssmp parameter configuration.
	*
	* @param displayname the displayname of this kdssmp parameter configuration
	*/
	@Override
	public void setDisplayname(java.lang.String displayname) {
		_kdssmpParameterConfiguration.setDisplayname(displayname);
	}

	/**
	* Returns the datatype of this kdssmp parameter configuration.
	*
	* @return the datatype of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getDatatype() {
		return _kdssmpParameterConfiguration.getDatatype();
	}

	/**
	* Sets the datatype of this kdssmp parameter configuration.
	*
	* @param datatype the datatype of this kdssmp parameter configuration
	*/
	@Override
	public void setDatatype(java.lang.String datatype) {
		_kdssmpParameterConfiguration.setDatatype(datatype);
	}

	/**
	* Returns the valuerange of this kdssmp parameter configuration.
	*
	* @return the valuerange of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getValuerange() {
		return _kdssmpParameterConfiguration.getValuerange();
	}

	/**
	* Sets the valuerange of this kdssmp parameter configuration.
	*
	* @param valuerange the valuerange of this kdssmp parameter configuration
	*/
	@Override
	public void setValuerange(java.lang.String valuerange) {
		_kdssmpParameterConfiguration.setValuerange(valuerange);
	}

	/**
	* Returns the displayoptions of this kdssmp parameter configuration.
	*
	* @return the displayoptions of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getDisplayoptions() {
		return _kdssmpParameterConfiguration.getDisplayoptions();
	}

	/**
	* Sets the displayoptions of this kdssmp parameter configuration.
	*
	* @param displayoptions the displayoptions of this kdssmp parameter configuration
	*/
	@Override
	public void setDisplayoptions(java.lang.String displayoptions) {
		_kdssmpParameterConfiguration.setDisplayoptions(displayoptions);
	}

	/**
	* Returns the visible of this kdssmp parameter configuration.
	*
	* @return the visible of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getVisible() {
		return _kdssmpParameterConfiguration.getVisible();
	}

	/**
	* Sets the visible of this kdssmp parameter configuration.
	*
	* @param visible the visible of this kdssmp parameter configuration
	*/
	@Override
	public void setVisible(java.lang.String visible) {
		_kdssmpParameterConfiguration.setVisible(visible);
	}

	/**
	* Returns the computed of this kdssmp parameter configuration.
	*
	* @return the computed of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getComputed() {
		return _kdssmpParameterConfiguration.getComputed();
	}

	/**
	* Sets the computed of this kdssmp parameter configuration.
	*
	* @param computed the computed of this kdssmp parameter configuration
	*/
	@Override
	public void setComputed(java.lang.String computed) {
		_kdssmpParameterConfiguration.setComputed(computed);
	}

	/**
	* Returns the confirmationscript of this kdssmp parameter configuration.
	*
	* @return the confirmationscript of this kdssmp parameter configuration
	*/
	@Override
	public java.lang.String getConfirmationscript() {
		return _kdssmpParameterConfiguration.getConfirmationscript();
	}

	/**
	* Sets the confirmationscript of this kdssmp parameter configuration.
	*
	* @param confirmationscript the confirmationscript of this kdssmp parameter configuration
	*/
	@Override
	public void setConfirmationscript(java.lang.String confirmationscript) {
		_kdssmpParameterConfiguration.setConfirmationscript(confirmationscript);
	}

	@Override
	public boolean isNew() {
		return _kdssmpParameterConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kdssmpParameterConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kdssmpParameterConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kdssmpParameterConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kdssmpParameterConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kdssmpParameterConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kdssmpParameterConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kdssmpParameterConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kdssmpParameterConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kdssmpParameterConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kdssmpParameterConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KdssmpParameterConfigurationWrapper((KdssmpParameterConfiguration)_kdssmpParameterConfiguration.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		return _kdssmpParameterConfiguration.compareTo(kdssmpParameterConfiguration);
	}

	@Override
	public int hashCode() {
		return _kdssmpParameterConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration> toCacheModel() {
		return _kdssmpParameterConfiguration.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration toEscapedModel() {
		return new KdssmpParameterConfigurationWrapper(_kdssmpParameterConfiguration.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration toUnescapedModel() {
		return new KdssmpParameterConfigurationWrapper(_kdssmpParameterConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kdssmpParameterConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kdssmpParameterConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kdssmpParameterConfiguration.persist();
	}

	@Override
	public java.lang.String getInputParameter() {
		return _kdssmpParameterConfiguration.getInputParameter();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpParameterConfigurationWrapper)) {
			return false;
		}

		KdssmpParameterConfigurationWrapper kdssmpParameterConfigurationWrapper = (KdssmpParameterConfigurationWrapper)obj;

		if (Validator.equals(_kdssmpParameterConfiguration,
					kdssmpParameterConfigurationWrapper._kdssmpParameterConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KdssmpParameterConfiguration getWrappedKdssmpParameterConfiguration() {
		return _kdssmpParameterConfiguration;
	}

	@Override
	public KdssmpParameterConfiguration getWrappedModel() {
		return _kdssmpParameterConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_kdssmpParameterConfiguration.resetOriginalValues();
	}

	private KdssmpParameterConfiguration _kdssmpParameterConfiguration;
}