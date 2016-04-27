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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.service.http.ICDO3ServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.service.http.ICDO3ServiceSoap
 * @generated
 */
public class ICDO3Soap implements Serializable {
	public static ICDO3Soap toSoapModel(ICDO3 model) {
		ICDO3Soap soapModel = new ICDO3Soap();

		soapModel.setId(model.getId());
		soapModel.setCode(model.getCode());
		soapModel.setTerm(model.getTerm());
		soapModel.setSui(model.getSui());
		soapModel.setTyp(model.getTyp());
		soapModel.setUse(model.getUse());
		soapModel.setDescription(model.getDescription());
		soapModel.setLocalisation(model.getLocalisation());
		soapModel.setLink(model.getLink());
		soapModel.setExklusiva(model.getExklusiva());
		soapModel.setHint(model.getHint());

		return soapModel;
	}

	public static ICDO3Soap[] toSoapModels(ICDO3[] models) {
		ICDO3Soap[] soapModels = new ICDO3Soap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ICDO3Soap[][] toSoapModels(ICDO3[][] models) {
		ICDO3Soap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ICDO3Soap[models.length][models[0].length];
		}
		else {
			soapModels = new ICDO3Soap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ICDO3Soap[] toSoapModels(List<ICDO3> models) {
		List<ICDO3Soap> soapModels = new ArrayList<ICDO3Soap>(models.size());

		for (ICDO3 model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ICDO3Soap[soapModels.size()]);
	}

	public ICDO3Soap() {
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

	public int getTerm() {
		return _term;
	}

	public void setTerm(int term) {
		_term = term;
	}

	public int getSui() {
		return _sui;
	}

	public void setSui(int sui) {
		_sui = sui;
	}

	public String getTyp() {
		return _typ;
	}

	public void setTyp(String typ) {
		_typ = typ;
	}

	public String getUse() {
		return _use;
	}

	public void setUse(String use) {
		_use = use;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLocalisation() {
		return _localisation;
	}

	public void setLocalisation(String localisation) {
		_localisation = localisation;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getExklusiva() {
		return _exklusiva;
	}

	public void setExklusiva(String exklusiva) {
		_exklusiva = exklusiva;
	}

	public String getHint() {
		return _hint;
	}

	public void setHint(String hint) {
		_hint = hint;
	}

	private long _id;
	private String _code;
	private int _term;
	private int _sui;
	private String _typ;
	private String _use;
	private String _description;
	private String _localisation;
	private String _link;
	private String _exklusiva;
	private String _hint;
}