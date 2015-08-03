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
public class ConfigurationSoap implements Serializable {
	public static ConfigurationSoap toSoapModel(Configuration model) {
		ConfigurationSoap soapModel = new ConfigurationSoap();

		soapModel.setConfigurationId(model.getConfigurationId());
		soapModel.setScope(model.getScope());
		soapModel.setOptionkey(model.getOptionkey());
		soapModel.setOptionvalue(model.getOptionvalue());

		return soapModel;
	}

	public static ConfigurationSoap[] toSoapModels(Configuration[] models) {
		ConfigurationSoap[] soapModels = new ConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationSoap[][] toSoapModels(Configuration[][] models) {
		ConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationSoap[] toSoapModels(List<Configuration> models) {
		List<ConfigurationSoap> soapModels = new ArrayList<ConfigurationSoap>(models.size());

		for (Configuration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfigurationSoap[soapModels.size()]);
	}

	public ConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _configurationId;
	}

	public void setPrimaryKey(long pk) {
		setConfigurationId(pk);
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
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

	private long _configurationId;
	private String _scope;
	private String _optionkey;
	private String _optionvalue;
}