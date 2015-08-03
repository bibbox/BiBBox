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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class ParameterOptionsConfigurationSoap implements Serializable {
	public static ParameterOptionsConfigurationSoap toSoapModel(
		ParameterOptionsConfiguration model) {
		ParameterOptionsConfigurationSoap soapModel = new ParameterOptionsConfigurationSoap();

		soapModel.setParameteroptionsconfigurationId(model.getParameteroptionsconfigurationId());
		soapModel.setParameterconfigurationId(model.getParameterconfigurationId());
		soapModel.setOptionkey(model.getOptionkey());
		soapModel.setOptionvalue(model.getOptionvalue());

		return soapModel;
	}

	public static ParameterOptionsConfigurationSoap[] toSoapModels(
		ParameterOptionsConfiguration[] models) {
		ParameterOptionsConfigurationSoap[] soapModels = new ParameterOptionsConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParameterOptionsConfigurationSoap[][] toSoapModels(
		ParameterOptionsConfiguration[][] models) {
		ParameterOptionsConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParameterOptionsConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParameterOptionsConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParameterOptionsConfigurationSoap[] toSoapModels(
		List<ParameterOptionsConfiguration> models) {
		List<ParameterOptionsConfigurationSoap> soapModels = new ArrayList<ParameterOptionsConfigurationSoap>(models.size());

		for (ParameterOptionsConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParameterOptionsConfigurationSoap[soapModels.size()]);
	}

	public ParameterOptionsConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _parameteroptionsconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setParameteroptionsconfigurationId(pk);
	}

	public long getParameteroptionsconfigurationId() {
		return _parameteroptionsconfigurationId;
	}

	public void setParameteroptionsconfigurationId(
		long parameteroptionsconfigurationId) {
		_parameteroptionsconfigurationId = parameteroptionsconfigurationId;
	}

	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;
	}

	public String getOptionkey() {
		return _optionkey;
	}

	public void setOptionkey(String optionkey) {
		_optionkey = optionkey;
	}

	public String getOptionvalue() {
		return _optionvalue;
	}

	public void setOptionvalue(String optionvalue) {
		_optionvalue = optionvalue;
	}

	private long _parameteroptionsconfigurationId;
	private long _parameterconfigurationId;
	private String _optionkey;
	private String _optionvalue;
}