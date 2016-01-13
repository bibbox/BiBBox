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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpPatientLocalServiceUtil;

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
public class KdssmpPatientClp extends BaseModelImpl<KdssmpPatient>
	implements KdssmpPatient {
	public KdssmpPatientClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpPatient.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpPatient.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientId", getPatientId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("gender", getGender());
		attributes.put("dateofbirth", getDateofbirth());
		attributes.put("dateofdeath", getDateofdeath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date dateofbirth = (Date)attributes.get("dateofbirth");

		if (dateofbirth != null) {
			setDateofbirth(dateofbirth);
		}

		Date dateofdeath = (Date)attributes.get("dateofdeath");

		if (dateofdeath != null) {
			setDateofdeath(dateofdeath);
		}
	}

	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_patientId = patientId;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientId", long.class);

				method.invoke(_kdssmpPatientRemoteModel, patientId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_kdssmpPatientRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstname() {
		return _firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		_firstname = firstname;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstname", String.class);

				method.invoke(_kdssmpPatientRemoteModel, firstname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastname() {
		return _lastname;
	}

	@Override
	public void setLastname(String lastname) {
		_lastname = lastname;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setLastname", String.class);

				method.invoke(_kdssmpPatientRemoteModel, lastname);
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

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_kdssmpPatientRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateofbirth() {
		return _dateofbirth;
	}

	@Override
	public void setDateofbirth(Date dateofbirth) {
		_dateofbirth = dateofbirth;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setDateofbirth", Date.class);

				method.invoke(_kdssmpPatientRemoteModel, dateofbirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateofdeath() {
		return _dateofdeath;
	}

	@Override
	public void setDateofdeath(Date dateofdeath) {
		_dateofdeath = dateofdeath;

		if (_kdssmpPatientRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpPatientRemoteModel.getClass();

				Method method = clazz.getMethod("setDateofdeath", Date.class);

				method.invoke(_kdssmpPatientRemoteModel, dateofdeath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfEvents() {
		try {
			String methodName = "getNumberOfEvents";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event getLastEventOfType(
		java.lang.String eventtype) {
		try {
			String methodName = "getLastEventOfType";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { eventtype };

			at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event returnObj =
				(at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getInitialDiagnosis() {
		try {
			String methodName = "getInitialDiagnosis";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getKdssmpPatientRemoteModel() {
		return _kdssmpPatientRemoteModel;
	}

	public void setKdssmpPatientRemoteModel(
		BaseModel<?> kdssmpPatientRemoteModel) {
		_kdssmpPatientRemoteModel = kdssmpPatientRemoteModel;
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

		Class<?> remoteModelClass = _kdssmpPatientRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kdssmpPatientRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KdssmpPatientLocalServiceUtil.addKdssmpPatient(this);
		}
		else {
			KdssmpPatientLocalServiceUtil.updateKdssmpPatient(this);
		}
	}

	@Override
	public KdssmpPatient toEscapedModel() {
		return (KdssmpPatient)ProxyUtil.newProxyInstance(KdssmpPatient.class.getClassLoader(),
			new Class[] { KdssmpPatient.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KdssmpPatientClp clone = new KdssmpPatientClp();

		clone.setPatientId(getPatientId());
		clone.setOrganizationId(getOrganizationId());
		clone.setFirstname(getFirstname());
		clone.setLastname(getLastname());
		clone.setGender(getGender());
		clone.setDateofbirth(getDateofbirth());
		clone.setDateofdeath(getDateofdeath());

		return clone;
	}

	@Override
	public int compareTo(KdssmpPatient kdssmpPatient) {
		long primaryKey = kdssmpPatient.getPrimaryKey();

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

		if (!(obj instanceof KdssmpPatientClp)) {
			return false;
		}

		KdssmpPatientClp kdssmpPatient = (KdssmpPatientClp)obj;

		long primaryKey = kdssmpPatient.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{patientId=");
		sb.append(getPatientId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", firstname=");
		sb.append(getFirstname());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", dateofbirth=");
		sb.append(getDateofbirth());
		sb.append(", dateofdeath=");
		sb.append(getDateofdeath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patientId</column-name><column-value><![CDATA[");
		sb.append(getPatientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateofbirth</column-name><column-value><![CDATA[");
		sb.append(getDateofbirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateofdeath</column-name><column-value><![CDATA[");
		sb.append(getDateofdeath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _patientId;
	private long _organizationId;
	private String _firstname;
	private String _lastname;
	private String _gender;
	private Date _dateofbirth;
	private Date _dateofdeath;
	private BaseModel<?> _kdssmpPatientRemoteModel;
}