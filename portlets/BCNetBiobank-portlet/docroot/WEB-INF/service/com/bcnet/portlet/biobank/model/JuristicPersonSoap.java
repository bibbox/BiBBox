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

package com.bcnet.portlet.biobank.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.JuristicPersonServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.JuristicPersonServiceSoap
 * @generated
 */
public class JuristicPersonSoap implements Serializable {
	public static JuristicPersonSoap toSoapModel(JuristicPerson model) {
		JuristicPersonSoap soapModel = new JuristicPersonSoap();

		soapModel.setJuristicPersonId(model.getJuristicPersonId());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setAddress(model.getAddress());

		return soapModel;
	}

	public static JuristicPersonSoap[] toSoapModels(JuristicPerson[] models) {
		JuristicPersonSoap[] soapModels = new JuristicPersonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JuristicPersonSoap[][] toSoapModels(JuristicPerson[][] models) {
		JuristicPersonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JuristicPersonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JuristicPersonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JuristicPersonSoap[] toSoapModels(List<JuristicPerson> models) {
		List<JuristicPersonSoap> soapModels = new ArrayList<JuristicPersonSoap>(models.size());

		for (JuristicPerson model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JuristicPersonSoap[soapModels.size()]);
	}

	public JuristicPersonSoap() {
	}

	public long getPrimaryKey() {
		return _juristicPersonId;
	}

	public void setPrimaryKey(long pk) {
		setJuristicPersonId(pk);
	}

	public long getJuristicPersonId() {
		return _juristicPersonId;
	}

	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPersonId = juristicPersonId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	private long _juristicPersonId;
	private String _name;
	private String _url;
	private String _address;
}