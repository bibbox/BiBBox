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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.SymbolTypeConfigurationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.SymbolTypeConfigurationServiceSoap
 * @generated
 */
public class SymbolTypeConfigurationSoap implements Serializable {
	public static SymbolTypeConfigurationSoap toSoapModel(
		SymbolTypeConfiguration model) {
		SymbolTypeConfigurationSoap soapModel = new SymbolTypeConfigurationSoap();

		soapModel.setSymboltypeconfigurationId(model.getSymboltypeconfigurationId());
		soapModel.setSymboltype(model.getSymboltype());
		soapModel.setTemplate(model.getTemplate());
		soapModel.setSymboliconconfiguration(model.getSymboliconconfiguration());

		return soapModel;
	}

	public static SymbolTypeConfigurationSoap[] toSoapModels(
		SymbolTypeConfiguration[] models) {
		SymbolTypeConfigurationSoap[] soapModels = new SymbolTypeConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SymbolTypeConfigurationSoap[][] toSoapModels(
		SymbolTypeConfiguration[][] models) {
		SymbolTypeConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SymbolTypeConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SymbolTypeConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SymbolTypeConfigurationSoap[] toSoapModels(
		List<SymbolTypeConfiguration> models) {
		List<SymbolTypeConfigurationSoap> soapModels = new ArrayList<SymbolTypeConfigurationSoap>(models.size());

		for (SymbolTypeConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SymbolTypeConfigurationSoap[soapModels.size()]);
	}

	public SymbolTypeConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _symboltypeconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setSymboltypeconfigurationId(pk);
	}

	public long getSymboltypeconfigurationId() {
		return _symboltypeconfigurationId;
	}

	public void setSymboltypeconfigurationId(long symboltypeconfigurationId) {
		_symboltypeconfigurationId = symboltypeconfigurationId;
	}

	public String getSymboltype() {
		return _symboltype;
	}

	public void setSymboltype(String symboltype) {
		_symboltype = symboltype;
	}

	public String getTemplate() {
		return _template;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	public String getSymboliconconfiguration() {
		return _symboliconconfiguration;
	}

	public void setSymboliconconfiguration(String symboliconconfiguration) {
		_symboliconconfiguration = symboliconconfiguration;
	}

	private long _symboltypeconfigurationId;
	private String _symboltype;
	private String _template;
	private String _symboliconconfiguration;
}