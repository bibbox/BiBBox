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

package at.meduni.liferay.portlet.bbmrieric.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class DiseaseDiscriptionSoap implements Serializable {
	public static DiseaseDiscriptionSoap toSoapModel(DiseaseDiscription model) {
		DiseaseDiscriptionSoap soapModel = new DiseaseDiscriptionSoap();

		soapModel.setDiseasediscriptionId(model.getDiseasediscriptionId());
		soapModel.setDiseasecode(model.getDiseasecode());
		soapModel.setDiseasegroup(model.getDiseasegroup());
		soapModel.setDiseasediscription(model.getDiseasediscription());
		soapModel.setRoot(model.getRoot());

		return soapModel;
	}

	public static DiseaseDiscriptionSoap[] toSoapModels(
		DiseaseDiscription[] models) {
		DiseaseDiscriptionSoap[] soapModels = new DiseaseDiscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DiseaseDiscriptionSoap[][] toSoapModels(
		DiseaseDiscription[][] models) {
		DiseaseDiscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DiseaseDiscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DiseaseDiscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DiseaseDiscriptionSoap[] toSoapModels(
		List<DiseaseDiscription> models) {
		List<DiseaseDiscriptionSoap> soapModels = new ArrayList<DiseaseDiscriptionSoap>(models.size());

		for (DiseaseDiscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DiseaseDiscriptionSoap[soapModels.size()]);
	}

	public DiseaseDiscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _diseasediscriptionId;
	}

	public void setPrimaryKey(long pk) {
		setDiseasediscriptionId(pk);
	}

	public long getDiseasediscriptionId() {
		return _diseasediscriptionId;
	}

	public void setDiseasediscriptionId(long diseasediscriptionId) {
		_diseasediscriptionId = diseasediscriptionId;
	}

	public String getDiseasecode() {
		return _diseasecode;
	}

	public void setDiseasecode(String diseasecode) {
		_diseasecode = diseasecode;
	}

	public String getDiseasegroup() {
		return _diseasegroup;
	}

	public void setDiseasegroup(String diseasegroup) {
		_diseasegroup = diseasegroup;
	}

	public String getDiseasediscription() {
		return _diseasediscription;
	}

	public void setDiseasediscription(String diseasediscription) {
		_diseasediscription = diseasediscription;
	}

	public boolean getRoot() {
		return _root;
	}

	public boolean isRoot() {
		return _root;
	}

	public void setRoot(boolean root) {
		_root = root;
	}

	private long _diseasediscriptionId;
	private String _diseasecode;
	private String _diseasegroup;
	private String _diseasediscription;
	private boolean _root;
}