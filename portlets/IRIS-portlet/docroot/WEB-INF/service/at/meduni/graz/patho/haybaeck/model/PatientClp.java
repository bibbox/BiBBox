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
import at.meduni.graz.patho.haybaeck.service.PatientLocalServiceUtil;

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
public class PatientClp extends BaseModelImpl<Patient> implements Patient {
	public PatientClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Patient.class;
	}

	@Override
	public String getModelClassName() {
		return Patient.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patient_Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatient_Id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patient_Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patient_Id", getPatient_Id());
		attributes.put("identifier", getIdentifier());
		attributes.put("cohort", getCohort());
		attributes.put("first_name", getFirst_name());
		attributes.put("last_name", getLast_name());
		attributes.put("date_of_birth", getDate_of_birth());
		attributes.put("date_of_death", getDate_of_death());
		attributes.put("couse_of_death", getCouse_of_death());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patient_Id = (Long)attributes.get("patient_Id");

		if (patient_Id != null) {
			setPatient_Id(patient_Id);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		String cohort = (String)attributes.get("cohort");

		if (cohort != null) {
			setCohort(cohort);
		}

		String first_name = (String)attributes.get("first_name");

		if (first_name != null) {
			setFirst_name(first_name);
		}

		String last_name = (String)attributes.get("last_name");

		if (last_name != null) {
			setLast_name(last_name);
		}

		Date date_of_birth = (Date)attributes.get("date_of_birth");

		if (date_of_birth != null) {
			setDate_of_birth(date_of_birth);
		}

		Date date_of_death = (Date)attributes.get("date_of_death");

		if (date_of_death != null) {
			setDate_of_death(date_of_death);
		}

		String couse_of_death = (String)attributes.get("couse_of_death");

		if (couse_of_death != null) {
			setCouse_of_death(couse_of_death);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	@Override
	public long getPatient_Id() {
		return _patient_Id;
	}

	@Override
	public void setPatient_Id(long patient_Id) {
		_patient_Id = patient_Id;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatient_Id", long.class);

				method.invoke(_patientRemoteModel, patient_Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentifier() {
		return _identifier;
	}

	@Override
	public void setIdentifier(String identifier) {
		_identifier = identifier;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentifier", String.class);

				method.invoke(_patientRemoteModel, identifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCohort() {
		return _cohort;
	}

	@Override
	public void setCohort(String cohort) {
		_cohort = cohort;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setCohort", String.class);

				method.invoke(_patientRemoteModel, cohort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirst_name() {
		return _first_name;
	}

	@Override
	public void setFirst_name(String first_name) {
		_first_name = first_name;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setFirst_name", String.class);

				method.invoke(_patientRemoteModel, first_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLast_name() {
		return _last_name;
	}

	@Override
	public void setLast_name(String last_name) {
		_last_name = last_name;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setLast_name", String.class);

				method.invoke(_patientRemoteModel, last_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate_of_birth() {
		return _date_of_birth;
	}

	@Override
	public void setDate_of_birth(Date date_of_birth) {
		_date_of_birth = date_of_birth;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setDate_of_birth", Date.class);

				method.invoke(_patientRemoteModel, date_of_birth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate_of_death() {
		return _date_of_death;
	}

	@Override
	public void setDate_of_death(Date date_of_death) {
		_date_of_death = date_of_death;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setDate_of_death", Date.class);

				method.invoke(_patientRemoteModel, date_of_death);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCouse_of_death() {
		return _couse_of_death;
	}

	@Override
	public void setCouse_of_death(String couse_of_death) {
		_couse_of_death = couse_of_death;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setCouse_of_death",
						String.class);

				method.invoke(_patientRemoteModel, couse_of_death);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_patientRemoteModel != null) {
			try {
				Class<?> clazz = _patientRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_patientRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPatientRemoteModel() {
		return _patientRemoteModel;
	}

	public void setPatientRemoteModel(BaseModel<?> patientRemoteModel) {
		_patientRemoteModel = patientRemoteModel;
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

		Class<?> remoteModelClass = _patientRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patientRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatientLocalServiceUtil.addPatient(this);
		}
		else {
			PatientLocalServiceUtil.updatePatient(this);
		}
	}

	@Override
	public Patient toEscapedModel() {
		return (Patient)ProxyUtil.newProxyInstance(Patient.class.getClassLoader(),
			new Class[] { Patient.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PatientClp clone = new PatientClp();

		clone.setPatient_Id(getPatient_Id());
		clone.setIdentifier(getIdentifier());
		clone.setCohort(getCohort());
		clone.setFirst_name(getFirst_name());
		clone.setLast_name(getLast_name());
		clone.setDate_of_birth(getDate_of_birth());
		clone.setDate_of_death(getDate_of_death());
		clone.setCouse_of_death(getCouse_of_death());
		clone.setGender(getGender());

		return clone;
	}

	@Override
	public int compareTo(Patient patient) {
		long primaryKey = patient.getPrimaryKey();

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

		if (!(obj instanceof PatientClp)) {
			return false;
		}

		PatientClp patient = (PatientClp)obj;

		long primaryKey = patient.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{patient_Id=");
		sb.append(getPatient_Id());
		sb.append(", identifier=");
		sb.append(getIdentifier());
		sb.append(", cohort=");
		sb.append(getCohort());
		sb.append(", first_name=");
		sb.append(getFirst_name());
		sb.append(", last_name=");
		sb.append(getLast_name());
		sb.append(", date_of_birth=");
		sb.append(getDate_of_birth());
		sb.append(", date_of_death=");
		sb.append(getDate_of_death());
		sb.append(", couse_of_death=");
		sb.append(getCouse_of_death());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.meduni.graz.patho.haybaeck.model.Patient");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patient_Id</column-name><column-value><![CDATA[");
		sb.append(getPatient_Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identifier</column-name><column-value><![CDATA[");
		sb.append(getIdentifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cohort</column-name><column-value><![CDATA[");
		sb.append(getCohort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>first_name</column-name><column-value><![CDATA[");
		sb.append(getFirst_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>last_name</column-name><column-value><![CDATA[");
		sb.append(getLast_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_of_birth</column-name><column-value><![CDATA[");
		sb.append(getDate_of_birth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_of_death</column-name><column-value><![CDATA[");
		sb.append(getDate_of_death());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couse_of_death</column-name><column-value><![CDATA[");
		sb.append(getCouse_of_death());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _patientRemoteModel;
}