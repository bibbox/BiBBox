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
public class SampleSoap implements Serializable {
	public static SampleSoap toSoapModel(Sample model) {
		SampleSoap soapModel = new SampleSoap();

		soapModel.setSample_Id(model.getSample_Id());
		soapModel.setPatient_id(model.getPatient_id());
		soapModel.setT(model.getT());
		soapModel.setN(model.getN());
		soapModel.setM(model.getM());
		soapModel.setG(model.getG());
		soapModel.setR(model.getR());
		soapModel.setP(model.getP());
		soapModel.setL(model.getL());
		soapModel.setV(model.getV());
		soapModel.setStage(model.getStage());
		soapModel.setOperation(model.getOperation());
		soapModel.setPost_op_treatment(model.getPost_op_treatment());
		soapModel.setRecurrence(model.getRecurrence());
		soapModel.setRecurrence_date(model.getRecurrence_date());
		soapModel.setDead_live(model.getDead_live());
		soapModel.setLast_follow_up_date(model.getLast_follow_up_date());
		soapModel.setHospital(model.getHospital());
		soapModel.setTnm_staging(model.getTnm_staging());
		soapModel.setDiagnosis(model.getDiagnosis());
		soapModel.setOperation_date(model.getOperation_date());
		soapModel.setTmp_identifier(model.getTmp_identifier());

		return soapModel;
	}

	public static SampleSoap[] toSoapModels(Sample[] models) {
		SampleSoap[] soapModels = new SampleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleSoap[][] toSoapModels(Sample[][] models) {
		SampleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleSoap[] toSoapModels(List<Sample> models) {
		List<SampleSoap> soapModels = new ArrayList<SampleSoap>(models.size());

		for (Sample model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleSoap[soapModels.size()]);
	}

	public SampleSoap() {
	}

	public long getPrimaryKey() {
		return _sample_Id;
	}

	public void setPrimaryKey(long pk) {
		setSample_Id(pk);
	}

	public long getSample_Id() {
		return _sample_Id;
	}

	public void setSample_Id(long sample_Id) {
		_sample_Id = sample_Id;
	}

	public long getPatient_id() {
		return _patient_id;
	}

	public void setPatient_id(long patient_id) {
		_patient_id = patient_id;
	}

	public String getT() {
		return _t;
	}

	public void setT(String t) {
		_t = t;
	}

	public String getN() {
		return _n;
	}

	public void setN(String n) {
		_n = n;
	}

	public String getM() {
		return _m;
	}

	public void setM(String m) {
		_m = m;
	}

	public String getG() {
		return _g;
	}

	public void setG(String g) {
		_g = g;
	}

	public String getR() {
		return _r;
	}

	public void setR(String r) {
		_r = r;
	}

	public String getP() {
		return _p;
	}

	public void setP(String p) {
		_p = p;
	}

	public String getL() {
		return _l;
	}

	public void setL(String l) {
		_l = l;
	}

	public String getV() {
		return _v;
	}

	public void setV(String v) {
		_v = v;
	}

	public String getStage() {
		return _stage;
	}

	public void setStage(String stage) {
		_stage = stage;
	}

	public String getOperation() {
		return _operation;
	}

	public void setOperation(String operation) {
		_operation = operation;
	}

	public String getPost_op_treatment() {
		return _post_op_treatment;
	}

	public void setPost_op_treatment(String post_op_treatment) {
		_post_op_treatment = post_op_treatment;
	}

	public boolean getRecurrence() {
		return _recurrence;
	}

	public boolean isRecurrence() {
		return _recurrence;
	}

	public void setRecurrence(boolean recurrence) {
		_recurrence = recurrence;
	}

	public Date getRecurrence_date() {
		return _recurrence_date;
	}

	public void setRecurrence_date(Date recurrence_date) {
		_recurrence_date = recurrence_date;
	}

	public String getDead_live() {
		return _dead_live;
	}

	public void setDead_live(String dead_live) {
		_dead_live = dead_live;
	}

	public Date getLast_follow_up_date() {
		return _last_follow_up_date;
	}

	public void setLast_follow_up_date(Date last_follow_up_date) {
		_last_follow_up_date = last_follow_up_date;
	}

	public String getHospital() {
		return _hospital;
	}

	public void setHospital(String hospital) {
		_hospital = hospital;
	}

	public String getTnm_staging() {
		return _tnm_staging;
	}

	public void setTnm_staging(String tnm_staging) {
		_tnm_staging = tnm_staging;
	}

	public String getDiagnosis() {
		return _diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		_diagnosis = diagnosis;
	}

	public Date getOperation_date() {
		return _operation_date;
	}

	public void setOperation_date(Date operation_date) {
		_operation_date = operation_date;
	}

	public String getTmp_identifier() {
		return _tmp_identifier;
	}

	public void setTmp_identifier(String tmp_identifier) {
		_tmp_identifier = tmp_identifier;
	}

	private long _sample_Id;
	private long _patient_id;
	private String _t;
	private String _n;
	private String _m;
	private String _g;
	private String _r;
	private String _p;
	private String _l;
	private String _v;
	private String _stage;
	private String _operation;
	private String _post_op_treatment;
	private boolean _recurrence;
	private Date _recurrence_date;
	private String _dead_live;
	private Date _last_follow_up_date;
	private String _hospital;
	private String _tnm_staging;
	private String _diagnosis;
	private Date _operation_date;
	private String _tmp_identifier;
}