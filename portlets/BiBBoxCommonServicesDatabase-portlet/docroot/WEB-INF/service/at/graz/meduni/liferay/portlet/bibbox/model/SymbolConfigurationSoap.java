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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.SymbolConfigurationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.SymbolConfigurationServiceSoap
 * @generated
 */
public class SymbolConfigurationSoap implements Serializable {
	public static SymbolConfigurationSoap toSoapModel(SymbolConfiguration model) {
		SymbolConfigurationSoap soapModel = new SymbolConfigurationSoap();

		soapModel.setSymbolconfigurationId(model.getSymbolconfigurationId());
		soapModel.setScope(model.getScope());
		soapModel.setEventtype(model.getEventtype());
		soapModel.setBasecolor(model.getBasecolor());
		soapModel.setSymboltype(model.getSymboltype());

		return soapModel;
	}

	public static SymbolConfigurationSoap[] toSoapModels(
		SymbolConfiguration[] models) {
		SymbolConfigurationSoap[] soapModels = new SymbolConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SymbolConfigurationSoap[][] toSoapModels(
		SymbolConfiguration[][] models) {
		SymbolConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SymbolConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SymbolConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SymbolConfigurationSoap[] toSoapModels(
		List<SymbolConfiguration> models) {
		List<SymbolConfigurationSoap> soapModels = new ArrayList<SymbolConfigurationSoap>(models.size());

		for (SymbolConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SymbolConfigurationSoap[soapModels.size()]);
	}

	public SymbolConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _symbolconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setSymbolconfigurationId(pk);
	}

	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolconfigurationId = symbolconfigurationId;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
	}

	public String getEventtype() {
		return _eventtype;
	}

	public void setEventtype(String eventtype) {
		_eventtype = eventtype;
	}

	public String getBasecolor() {
		return _basecolor;
	}

	public void setBasecolor(String basecolor) {
		_basecolor = basecolor;
	}

	public String getSymboltype() {
		return _symboltype;
	}

	public void setSymboltype(String symboltype) {
		_symboltype = symboltype;
	}

	private long _symbolconfigurationId;
	private String _scope;
	private String _eventtype;
	private String _basecolor;
	private String _symboltype;
}