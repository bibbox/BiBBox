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
public class patientnamegeneratorSoap implements Serializable {
	public static patientnamegeneratorSoap toSoapModel(
		patientnamegenerator model) {
		patientnamegeneratorSoap soapModel = new patientnamegeneratorSoap();

		soapModel.setPatientnamegeneratorId(model.getPatientnamegeneratorId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static patientnamegeneratorSoap[] toSoapModels(
		patientnamegenerator[] models) {
		patientnamegeneratorSoap[] soapModels = new patientnamegeneratorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static patientnamegeneratorSoap[][] toSoapModels(
		patientnamegenerator[][] models) {
		patientnamegeneratorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new patientnamegeneratorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new patientnamegeneratorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static patientnamegeneratorSoap[] toSoapModels(
		List<patientnamegenerator> models) {
		List<patientnamegeneratorSoap> soapModels = new ArrayList<patientnamegeneratorSoap>(models.size());

		for (patientnamegenerator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new patientnamegeneratorSoap[soapModels.size()]);
	}

	public patientnamegeneratorSoap() {
	}

	public long getPrimaryKey() {
		return _patientnamegeneratorId;
	}

	public void setPrimaryKey(long pk) {
		setPatientnamegeneratorId(pk);
	}

	public long getPatientnamegeneratorId() {
		return _patientnamegeneratorId;
	}

	public void setPatientnamegeneratorId(long patientnamegeneratorId) {
		_patientnamegeneratorId = patientnamegeneratorId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _patientnamegeneratorId;
	private String _name;
	private String _type;
}