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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class KdssmpParameterConfigurationSoap implements Serializable {
	public static KdssmpParameterConfigurationSoap toSoapModel(
		KdssmpParameterConfiguration model) {
		KdssmpParameterConfigurationSoap soapModel = new KdssmpParameterConfigurationSoap();

		soapModel.setParameterconfigurationId(model.getParameterconfigurationId());
		soapModel.setDisplayname(model.getDisplayname());
		soapModel.setDatatype(model.getDatatype());
		soapModel.setValuerange(model.getValuerange());
		soapModel.setDisplayoptions(model.getDisplayoptions());
		soapModel.setVisible(model.getVisible());
		soapModel.setComputed(model.getComputed());
		soapModel.setConfirmationscript(model.getConfirmationscript());

		return soapModel;
	}

	public static KdssmpParameterConfigurationSoap[] toSoapModels(
		KdssmpParameterConfiguration[] models) {
		KdssmpParameterConfigurationSoap[] soapModels = new KdssmpParameterConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KdssmpParameterConfigurationSoap[][] toSoapModels(
		KdssmpParameterConfiguration[][] models) {
		KdssmpParameterConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KdssmpParameterConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KdssmpParameterConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KdssmpParameterConfigurationSoap[] toSoapModels(
		List<KdssmpParameterConfiguration> models) {
		List<KdssmpParameterConfigurationSoap> soapModels = new ArrayList<KdssmpParameterConfigurationSoap>(models.size());

		for (KdssmpParameterConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KdssmpParameterConfigurationSoap[soapModels.size()]);
	}

	public KdssmpParameterConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _parameterconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setParameterconfigurationId(pk);
	}

	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;
	}

	public String getDisplayname() {
		return _displayname;
	}

	public void setDisplayname(String displayname) {
		_displayname = displayname;
	}

	public String getDatatype() {
		return _datatype;
	}

	public void setDatatype(String datatype) {
		_datatype = datatype;
	}

	public String getValuerange() {
		return _valuerange;
	}

	public void setValuerange(String valuerange) {
		_valuerange = valuerange;
	}

	public String getDisplayoptions() {
		return _displayoptions;
	}

	public void setDisplayoptions(String displayoptions) {
		_displayoptions = displayoptions;
	}

	public String getVisible() {
		return _visible;
	}

	public void setVisible(String visible) {
		_visible = visible;
	}

	public String getComputed() {
		return _computed;
	}

	public void setComputed(String computed) {
		_computed = computed;
	}

	public String getConfirmationscript() {
		return _confirmationscript;
	}

	public void setConfirmationscript(String confirmationscript) {
		_confirmationscript = confirmationscript;
	}

	private long _parameterconfigurationId;
	private String _displayname;
	private String _datatype;
	private String _valuerange;
	private String _displayoptions;
	private String _visible;
	private String _computed;
	private String _confirmationscript;
}