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

package at.meduni.graz.patho.haybaeck.model;

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
public class PatientSoap implements Serializable {
	public static PatientSoap toSoapModel(Patient model) {
		PatientSoap soapModel = new PatientSoap();

		soapModel.setPatient_Id(model.getPatient_Id());
		soapModel.setIdentifier(model.getIdentifier());
		soapModel.setCohort(model.getCohort());
		soapModel.setFirst_name(model.getFirst_name());
		soapModel.setLast_name(model.getLast_name());
		soapModel.setDate_of_birth(model.getDate_of_birth());
		soapModel.setDate_of_death(model.getDate_of_death());
		soapModel.setCouse_of_death(model.getCouse_of_death());
		soapModel.setGender(model.getGender());

		return soapModel;
	}

	public static PatientSoap[] toSoapModels(Patient[] models) {
		PatientSoap[] soapModels = new PatientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[][] toSoapModels(Patient[][] models) {
		PatientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatientSoap[] toSoapModels(List<Patient> models) {
		List<PatientSoap> soapModels = new ArrayList<PatientSoap>(models.size());

		for (Patient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatientSoap[soapModels.size()]);
	}

	public PatientSoap() {
	}

	public long getPrimaryKey() {
		return _patient_Id;
	}

	public void setPrimaryKey(long pk) {
		setPatient_Id(pk);
	}

	public long getPatient_Id() {
		return _patient_Id;
	}

	public void setPatient_Id(long patient_Id) {
		_patient_Id = patient_Id;
	}

	public String getIdentifier() {
		return _identifier;
	}

	public void setIdentifier(String identifier) {
		_identifier = identifier;
	}

	public String getCohort() {
		return _cohort;
	}

	public void setCohort(String cohort) {
		_cohort = cohort;
	}

	public String getFirst_name() {
		return _first_name;
	}

	public void setFirst_name(String first_name) {
		_first_name = first_name;
	}

	public String getLast_name() {
		return _last_name;
	}

	public void setLast_name(String last_name) {
		_last_name = last_name;
	}

	public Date getDate_of_birth() {
		return _date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		_date_of_birth = date_of_birth;
	}

	public Date getDate_of_death() {
		return _date_of_death;
	}

	public void setDate_of_death(Date date_of_death) {
		_date_of_death = date_of_death;
	}

	public String getCouse_of_death() {
		return _couse_of_death;
	}

	public void setCouse_of_death(String couse_of_death) {
		_couse_of_death = couse_of_death;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	private long _patient_Id;
	private String _identifier;
	private String _cohort;
	private String _first_name;
	private String _last_name;
	private Date _date_of_birth;
	private Date _date_of_death;
	private String _couse_of_death;
	private String _gender;
}