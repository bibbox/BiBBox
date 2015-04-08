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

package at.graz.meduni.liferay.api.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.api.service.http.rdconnectServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.api.service.http.rdconnectServiceSoap
 * @generated
 */
public class rdconnectSoap implements Serializable {
	public static rdconnectSoap toSoapModel(rdconnect model) {
		rdconnectSoap soapModel = new rdconnectSoap();

		soapModel.setIdcardapilogId(model.getIdcardapilogId());
		soapModel.setUserId(model.getUserId());
		soapModel.setIpaddress(model.getIpaddress());
		soapModel.setAccessDate(model.getAccessDate());
		soapModel.setRequestparameter(model.getRequestparameter());

		return soapModel;
	}

	public static rdconnectSoap[] toSoapModels(rdconnect[] models) {
		rdconnectSoap[] soapModels = new rdconnectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static rdconnectSoap[][] toSoapModels(rdconnect[][] models) {
		rdconnectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new rdconnectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new rdconnectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static rdconnectSoap[] toSoapModels(List<rdconnect> models) {
		List<rdconnectSoap> soapModels = new ArrayList<rdconnectSoap>(models.size());

		for (rdconnect model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new rdconnectSoap[soapModels.size()]);
	}

	public rdconnectSoap() {
	}

	public long getPrimaryKey() {
		return _idcardapilogId;
	}

	public void setPrimaryKey(long pk) {
		setIdcardapilogId(pk);
	}

	public long getIdcardapilogId() {
		return _idcardapilogId;
	}

	public void setIdcardapilogId(long idcardapilogId) {
		_idcardapilogId = idcardapilogId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getIpaddress() {
		return _ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		_ipaddress = ipaddress;
	}

	public Date getAccessDate() {
		return _accessDate;
	}

	public void setAccessDate(Date accessDate) {
		_accessDate = accessDate;
	}

	public String getRequestparameter() {
		return _requestparameter;
	}

	public void setRequestparameter(String requestparameter) {
		_requestparameter = requestparameter;
	}

	private long _idcardapilogId;
	private long _userId;
	private String _ipaddress;
	private Date _accessDate;
	private String _requestparameter;
}