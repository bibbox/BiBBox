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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class FahrzeugSoap implements Serializable {
	public static FahrzeugSoap toSoapModel(Fahrzeug model) {
		FahrzeugSoap soapModel = new FahrzeugSoap();

		soapModel.setFahrzeugId(model.getFahrzeugId());
		soapModel.setCreaterUserId(model.getCreaterUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTyp(model.getTyp());

		return soapModel;
	}

	public static FahrzeugSoap[] toSoapModels(Fahrzeug[] models) {
		FahrzeugSoap[] soapModels = new FahrzeugSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FahrzeugSoap[][] toSoapModels(Fahrzeug[][] models) {
		FahrzeugSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FahrzeugSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FahrzeugSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FahrzeugSoap[] toSoapModels(List<Fahrzeug> models) {
		List<FahrzeugSoap> soapModels = new ArrayList<FahrzeugSoap>(models.size());

		for (Fahrzeug model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FahrzeugSoap[soapModels.size()]);
	}

	public FahrzeugSoap() {
	}

	public long getPrimaryKey() {
		return _fahrzeugId;
	}

	public void setPrimaryKey(long pk) {
		setFahrzeugId(pk);
	}

	public long getFahrzeugId() {
		return _fahrzeugId;
	}

	public void setFahrzeugId(long fahrzeugId) {
		_fahrzeugId = fahrzeugId;
	}

	public long getCreaterUserId() {
		return _createrUserId;
	}

	public void setCreaterUserId(long createrUserId) {
		_createrUserId = createrUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTyp() {
		return _typ;
	}

	public void setTyp(String typ) {
		_typ = typ;
	}

	private long _fahrzeugId;
	private long _createrUserId;
	private Date _createDate;
	private long _modifiedUserId;
	private Date _modifiedDate;
	private String _typ;
}