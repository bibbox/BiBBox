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

import at.meduni.graz.patho.haybaeck.service.ClpSerializer;
import at.meduni.graz.patho.haybaeck.service.SampleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class SampleClp extends BaseModelImpl<Sample> implements Sample {
	public SampleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Sample.class;
	}

	@Override
	public String getModelClassName() {
		return Sample.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sample_Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSample_Id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sample_Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sample_Id", getSample_Id());
		attributes.put("patient_id", getPatient_id());
		attributes.put("t", getT());
		attributes.put("n", getN());
		attributes.put("m", getM());
		attributes.put("g", getG());
		attributes.put("r", getR());
		attributes.put("p", getP());
		attributes.put("l", getL());
		attributes.put("v", getV());
		attributes.put("stage", getStage());
		attributes.put("operation", getOperation());
		attributes.put("post_op_treatment", getPost_op_treatment());
		attributes.put("recurrence", getRecurrence());
		attributes.put("recurrence_date", getRecurrence_date());
		attributes.put("dead_live", getDead_live());
		attributes.put("last_follow_up_date", getLast_follow_up_date());
		attributes.put("hospital", getHospital());
		attributes.put("tnm_staging", getTnm_staging());
		attributes.put("diagnosis", getDiagnosis());
		attributes.put("operation_date", getOperation_date());
		attributes.put("tmp_identifier", getTmp_identifier());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sample_Id = (Long)attributes.get("sample_Id");

		if (sample_Id != null) {
			setSample_Id(sample_Id);
		}

		Long patient_id = (Long)attributes.get("patient_id");

		if (patient_id != null) {
			setPatient_id(patient_id);
		}

		String t = (String)attributes.get("t");

		if (t != null) {
			setT(t);
		}

		String n = (String)attributes.get("n");

		if (n != null) {
			setN(n);
		}

		String m = (String)attributes.get("m");

		if (m != null) {
			setM(m);
		}

		String g = (String)attributes.get("g");

		if (g != null) {
			setG(g);
		}

		String r = (String)attributes.get("r");

		if (r != null) {
			setR(r);
		}

		String p = (String)attributes.get("p");

		if (p != null) {
			setP(p);
		}

		String l = (String)attributes.get("l");

		if (l != null) {
			setL(l);
		}

		String v = (String)attributes.get("v");

		if (v != null) {
			setV(v);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		String operation = (String)attributes.get("operation");

		if (operation != null) {
			setOperation(operation);
		}

		String post_op_treatment = (String)attributes.get("post_op_treatment");

		if (post_op_treatment != null) {
			setPost_op_treatment(post_op_treatment);
		}

		Boolean recurrence = (Boolean)attributes.get("recurrence");

		if (recurrence != null) {
			setRecurrence(recurrence);
		}

		Date recurrence_date = (Date)attributes.get("recurrence_date");

		if (recurrence_date != null) {
			setRecurrence_date(recurrence_date);
		}

		String dead_live = (String)attributes.get("dead_live");

		if (dead_live != null) {
			setDead_live(dead_live);
		}

		Date last_follow_up_date = (Date)attributes.get("last_follow_up_date");

		if (last_follow_up_date != null) {
			setLast_follow_up_date(last_follow_up_date);
		}

		String hospital = (String)attributes.get("hospital");

		if (hospital != null) {
			setHospital(hospital);
		}

		String tnm_staging = (String)attributes.get("tnm_staging");

		if (tnm_staging != null) {
			setTnm_staging(tnm_staging);
		}

		String diagnosis = (String)attributes.get("diagnosis");

		if (diagnosis != null) {
			setDiagnosis(diagnosis);
		}

		Date operation_date = (Date)attributes.get("operation_date");

		if (operation_date != null) {
			setOperation_date(operation_date);
		}

		String tmp_identifier = (String)attributes.get("tmp_identifier");

		if (tmp_identifier != null) {
			setTmp_identifier(tmp_identifier);
		}
	}

	@Override
	public long getSample_Id() {
		return _sample_Id;
	}

	@Override
	public void setSample_Id(long sample_Id) {
		_sample_Id = sample_Id;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setSample_Id", long.class);

				method.invoke(_sampleRemoteModel, sample_Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatient_id() {
		return _patient_id;
	}

	@Override
	public void setPatient_id(long patient_id) {
		_patient_id = patient_id;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setPatient_id", long.class);

				method.invoke(_sampleRemoteModel, patient_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getT() {
		return _t;
	}

	@Override
	public void setT(String t) {
		_t = t;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setT", String.class);

				method.invoke(_sampleRemoteModel, t);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getN() {
		return _n;
	}

	@Override
	public void setN(String n) {
		_n = n;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setN", String.class);

				method.invoke(_sampleRemoteModel, n);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getM() {
		return _m;
	}

	@Override
	public void setM(String m) {
		_m = m;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setM", String.class);

				method.invoke(_sampleRemoteModel, m);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getG() {
		return _g;
	}

	@Override
	public void setG(String g) {
		_g = g;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setG", String.class);

				method.invoke(_sampleRemoteModel, g);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getR() {
		return _r;
	}

	@Override
	public void setR(String r) {
		_r = r;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setR", String.class);

				method.invoke(_sampleRemoteModel, r);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getP() {
		return _p;
	}

	@Override
	public void setP(String p) {
		_p = p;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setP", String.class);

				method.invoke(_sampleRemoteModel, p);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getL() {
		return _l;
	}

	@Override
	public void setL(String l) {
		_l = l;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setL", String.class);

				method.invoke(_sampleRemoteModel, l);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getV() {
		return _v;
	}

	@Override
	public void setV(String v) {
		_v = v;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setV", String.class);

				method.invoke(_sampleRemoteModel, v);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStage() {
		return _stage;
	}

	@Override
	public void setStage(String stage) {
		_stage = stage;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setStage", String.class);

				method.invoke(_sampleRemoteModel, stage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOperation() {
		return _operation;
	}

	@Override
	public void setOperation(String operation) {
		_operation = operation;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setOperation", String.class);

				method.invoke(_sampleRemoteModel, operation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPost_op_treatment() {
		return _post_op_treatment;
	}

	@Override
	public void setPost_op_treatment(String post_op_treatment) {
		_post_op_treatment = post_op_treatment;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setPost_op_treatment",
						String.class);

				method.invoke(_sampleRemoteModel, post_op_treatment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRecurrence() {
		return _recurrence;
	}

	@Override
	public boolean isRecurrence() {
		return _recurrence;
	}

	@Override
	public void setRecurrence(boolean recurrence) {
		_recurrence = recurrence;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setRecurrence", boolean.class);

				method.invoke(_sampleRemoteModel, recurrence);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRecurrence_date() {
		return _recurrence_date;
	}

	@Override
	public void setRecurrence_date(Date recurrence_date) {
		_recurrence_date = recurrence_date;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setRecurrence_date", Date.class);

				method.invoke(_sampleRemoteModel, recurrence_date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDead_live() {
		return _dead_live;
	}

	@Override
	public void setDead_live(String dead_live) {
		_dead_live = dead_live;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDead_live", String.class);

				method.invoke(_sampleRemoteModel, dead_live);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLast_follow_up_date() {
		return _last_follow_up_date;
	}

	@Override
	public void setLast_follow_up_date(Date last_follow_up_date) {
		_last_follow_up_date = last_follow_up_date;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setLast_follow_up_date",
						Date.class);

				method.invoke(_sampleRemoteModel, last_follow_up_date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHospital() {
		return _hospital;
	}

	@Override
	public void setHospital(String hospital) {
		_hospital = hospital;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setHospital", String.class);

				method.invoke(_sampleRemoteModel, hospital);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTnm_staging() {
		return _tnm_staging;
	}

	@Override
	public void setTnm_staging(String tnm_staging) {
		_tnm_staging = tnm_staging;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setTnm_staging", String.class);

				method.invoke(_sampleRemoteModel, tnm_staging);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiagnosis() {
		return _diagnosis;
	}

	@Override
	public void setDiagnosis(String diagnosis) {
		_diagnosis = diagnosis;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiagnosis", String.class);

				method.invoke(_sampleRemoteModel, diagnosis);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOperation_date() {
		return _operation_date;
	}

	@Override
	public void setOperation_date(Date operation_date) {
		_operation_date = operation_date;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setOperation_date", Date.class);

				method.invoke(_sampleRemoteModel, operation_date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTmp_identifier() {
		return _tmp_identifier;
	}

	@Override
	public void setTmp_identifier(String tmp_identifier) {
		_tmp_identifier = tmp_identifier;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setTmp_identifier",
						String.class);

				method.invoke(_sampleRemoteModel, tmp_identifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleRemoteModel() {
		return _sampleRemoteModel;
	}

	public void setSampleRemoteModel(BaseModel<?> sampleRemoteModel) {
		_sampleRemoteModel = sampleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _sampleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_sampleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleLocalServiceUtil.addSample(this);
		}
		else {
			SampleLocalServiceUtil.updateSample(this);
		}
	}

	@Override
	public Sample toEscapedModel() {
		return (Sample)ProxyUtil.newProxyInstance(Sample.class.getClassLoader(),
			new Class[] { Sample.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleClp clone = new SampleClp();

		clone.setSample_Id(getSample_Id());
		clone.setPatient_id(getPatient_id());
		clone.setT(getT());
		clone.setN(getN());
		clone.setM(getM());
		clone.setG(getG());
		clone.setR(getR());
		clone.setP(getP());
		clone.setL(getL());
		clone.setV(getV());
		clone.setStage(getStage());
		clone.setOperation(getOperation());
		clone.setPost_op_treatment(getPost_op_treatment());
		clone.setRecurrence(getRecurrence());
		clone.setRecurrence_date(getRecurrence_date());
		clone.setDead_live(getDead_live());
		clone.setLast_follow_up_date(getLast_follow_up_date());
		clone.setHospital(getHospital());
		clone.setTnm_staging(getTnm_staging());
		clone.setDiagnosis(getDiagnosis());
		clone.setOperation_date(getOperation_date());
		clone.setTmp_identifier(getTmp_identifier());

		return clone;
	}

	@Override
	public int compareTo(Sample sample) {
		long primaryKey = sample.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleClp)) {
			return false;
		}

		SampleClp sample = (SampleClp)obj;

		long primaryKey = sample.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{sample_Id=");
		sb.append(getSample_Id());
		sb.append(", patient_id=");
		sb.append(getPatient_id());
		sb.append(", t=");
		sb.append(getT());
		sb.append(", n=");
		sb.append(getN());
		sb.append(", m=");
		sb.append(getM());
		sb.append(", g=");
		sb.append(getG());
		sb.append(", r=");
		sb.append(getR());
		sb.append(", p=");
		sb.append(getP());
		sb.append(", l=");
		sb.append(getL());
		sb.append(", v=");
		sb.append(getV());
		sb.append(", stage=");
		sb.append(getStage());
		sb.append(", operation=");
		sb.append(getOperation());
		sb.append(", post_op_treatment=");
		sb.append(getPost_op_treatment());
		sb.append(", recurrence=");
		sb.append(getRecurrence());
		sb.append(", recurrence_date=");
		sb.append(getRecurrence_date());
		sb.append(", dead_live=");
		sb.append(getDead_live());
		sb.append(", last_follow_up_date=");
		sb.append(getLast_follow_up_date());
		sb.append(", hospital=");
		sb.append(getHospital());
		sb.append(", tnm_staging=");
		sb.append(getTnm_staging());
		sb.append(", diagnosis=");
		sb.append(getDiagnosis());
		sb.append(", operation_date=");
		sb.append(getOperation_date());
		sb.append(", tmp_identifier=");
		sb.append(getTmp_identifier());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("at.meduni.graz.patho.haybaeck.model.Sample");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sample_Id</column-name><column-value><![CDATA[");
		sb.append(getSample_Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patient_id</column-name><column-value><![CDATA[");
		sb.append(getPatient_id());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>t</column-name><column-value><![CDATA[");
		sb.append(getT());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>n</column-name><column-value><![CDATA[");
		sb.append(getN());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>m</column-name><column-value><![CDATA[");
		sb.append(getM());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>g</column-name><column-value><![CDATA[");
		sb.append(getG());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>r</column-name><column-value><![CDATA[");
		sb.append(getR());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>p</column-name><column-value><![CDATA[");
		sb.append(getP());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>l</column-name><column-value><![CDATA[");
		sb.append(getL());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>v</column-name><column-value><![CDATA[");
		sb.append(getV());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stage</column-name><column-value><![CDATA[");
		sb.append(getStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operation</column-name><column-value><![CDATA[");
		sb.append(getOperation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>post_op_treatment</column-name><column-value><![CDATA[");
		sb.append(getPost_op_treatment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrence</column-name><column-value><![CDATA[");
		sb.append(getRecurrence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recurrence_date</column-name><column-value><![CDATA[");
		sb.append(getRecurrence_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dead_live</column-name><column-value><![CDATA[");
		sb.append(getDead_live());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>last_follow_up_date</column-name><column-value><![CDATA[");
		sb.append(getLast_follow_up_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hospital</column-name><column-value><![CDATA[");
		sb.append(getHospital());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tnm_staging</column-name><column-value><![CDATA[");
		sb.append(getTnm_staging());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diagnosis</column-name><column-value><![CDATA[");
		sb.append(getDiagnosis());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operation_date</column-name><column-value><![CDATA[");
		sb.append(getOperation_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tmp_identifier</column-name><column-value><![CDATA[");
		sb.append(getTmp_identifier());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _sampleRemoteModel;
}