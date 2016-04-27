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

package at.graz.meduni.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.service.http.SCGServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.service.http.SCGServiceSoap
 * @generated
 */
public class SCGSoap implements Serializable {
	public static SCGSoap toSoapModel(SCG model) {
		SCGSoap soapModel = new SCGSoap();

		soapModel.setId(model.getId());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static SCGSoap[] toSoapModels(SCG[] models) {
		SCGSoap[] soapModels = new SCGSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SCGSoap[][] toSoapModels(SCG[][] models) {
		SCGSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SCGSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SCGSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SCGSoap[] toSoapModels(List<SCG> models) {
		List<SCGSoap> soapModels = new ArrayList<SCGSoap>(models.size());

		for (SCG model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SCGSoap[soapModels.size()]);
	}

	public SCGSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private String _code;
	private String _description;
}