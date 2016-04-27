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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.service.http.ICD10ServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.service.http.ICD10ServiceSoap
 * @generated
 */
public class ICD10Soap implements Serializable {
	public static ICD10Soap toSoapModel(ICD10 model) {
		ICD10Soap soapModel = new ICD10Soap();

		soapModel.setId(model.getId());
		soapModel.setCode(model.getCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setINKLUSIVA(model.getINKLUSIVA());
		soapModel.setEXKLUSIVA(model.getEXKLUSIVA());
		soapModel.setTYPE(model.getTYPE());
		soapModel.setUSED(model.getUSED());
		soapModel.setFROM_CODE(model.getFROM_CODE());
		soapModel.setTO_CODE(model.getTO_CODE());

		return soapModel;
	}

	public static ICD10Soap[] toSoapModels(ICD10[] models) {
		ICD10Soap[] soapModels = new ICD10Soap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ICD10Soap[][] toSoapModels(ICD10[][] models) {
		ICD10Soap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ICD10Soap[models.length][models[0].length];
		}
		else {
			soapModels = new ICD10Soap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ICD10Soap[] toSoapModels(List<ICD10> models) {
		List<ICD10Soap> soapModels = new ArrayList<ICD10Soap>(models.size());

		for (ICD10 model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ICD10Soap[soapModels.size()]);
	}

	public ICD10Soap() {
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

	public String getINKLUSIVA() {
		return _INKLUSIVA;
	}

	public void setINKLUSIVA(String INKLUSIVA) {
		_INKLUSIVA = INKLUSIVA;
	}

	public String getEXKLUSIVA() {
		return _EXKLUSIVA;
	}

	public void setEXKLUSIVA(String EXKLUSIVA) {
		_EXKLUSIVA = EXKLUSIVA;
	}

	public String getTYPE() {
		return _TYPE;
	}

	public void setTYPE(String TYPE) {
		_TYPE = TYPE;
	}

	public double getUSED() {
		return _USED;
	}

	public void setUSED(double USED) {
		_USED = USED;
	}

	public String getFROM_CODE() {
		return _FROM_CODE;
	}

	public void setFROM_CODE(String FROM_CODE) {
		_FROM_CODE = FROM_CODE;
	}

	public String getTO_CODE() {
		return _TO_CODE;
	}

	public void setTO_CODE(String TO_CODE) {
		_TO_CODE = TO_CODE;
	}

	private long _id;
	private String _code;
	private String _description;
	private String _INKLUSIVA;
	private String _EXKLUSIVA;
	private String _TYPE;
	private double _USED;
	private String _FROM_CODE;
	private String _TO_CODE;
}