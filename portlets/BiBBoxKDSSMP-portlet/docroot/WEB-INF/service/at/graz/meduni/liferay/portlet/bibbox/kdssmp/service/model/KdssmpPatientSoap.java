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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class KdssmpPatientSoap implements Serializable {
	public static KdssmpPatientSoap toSoapModel(KdssmpPatient model) {
		KdssmpPatientSoap soapModel = new KdssmpPatientSoap();

		soapModel.setPatientId(model.getPatientId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setLastname(model.getLastname());
		soapModel.setGender(model.getGender());
		soapModel.setDateofbirth(model.getDateofbirth());
		soapModel.setDateofdeath(model.getDateofdeath());

		return soapModel;
	}

	public static KdssmpPatientSoap[] toSoapModels(KdssmpPatient[] models) {
		KdssmpPatientSoap[] soapModels = new KdssmpPatientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KdssmpPatientSoap[][] toSoapModels(KdssmpPatient[][] models) {
		KdssmpPatientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KdssmpPatientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KdssmpPatientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KdssmpPatientSoap[] toSoapModels(List<KdssmpPatient> models) {
		List<KdssmpPatientSoap> soapModels = new ArrayList<KdssmpPatientSoap>(models.size());

		for (KdssmpPatient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KdssmpPatientSoap[soapModels.size()]);
	}

	public KdssmpPatientSoap() {
	}

	public long getPrimaryKey() {
		return _patientId;
	}

	public void setPrimaryKey(long pk) {
		setPatientId(pk);
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public Date getDateofbirth() {
		return _dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		_dateofbirth = dateofbirth;
	}

	public Date getDateofdeath() {
		return _dateofdeath;
	}

	public void setDateofdeath(Date dateofdeath) {
		_dateofdeath = dateofdeath;
	}

	private long _patientId;
	private long _organizationId;
	private String _firstname;
	private String _lastname;
	private String _gender;
	private Date _dateofbirth;
	private Date _dateofdeath;
}