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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class LogapiClp extends BaseModelImpl<Logapi> implements Logapi {
	public LogapiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Logapi.class;
	}

	@Override
	public String getModelClassName() {
		return Logapi.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _logapiId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLogapiId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logapiId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logapiId", getLogapiId());
		attributes.put("userId", getUserId());
		attributes.put("userip", getUserip());
		attributes.put("logmsg", getLogmsg());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logapiId = (Long)attributes.get("logapiId");

		if (logapiId != null) {
			setLogapiId(logapiId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userip = (String)attributes.get("userip");

		if (userip != null) {
			setUserip(userip);
		}

		String logmsg = (String)attributes.get("logmsg");

		if (logmsg != null) {
			setLogmsg(logmsg);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public long getLogapiId() {
		return _logapiId;
	}

	@Override
	public void setLogapiId(long logapiId) {
		_logapiId = logapiId;

		if (_logapiRemoteModel != null) {
			try {
				Class<?> clazz = _logapiRemoteModel.getClass();

				Method method = clazz.getMethod("setLogapiId", long.class);

				method.invoke(_logapiRemoteModel, logapiId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_logapiRemoteModel != null) {
			try {
				Class<?> clazz = _logapiRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_logapiRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserip() {
		return _userip;
	}

	@Override
	public void setUserip(String userip) {
		_userip = userip;

		if (_logapiRemoteModel != null) {
			try {
				Class<?> clazz = _logapiRemoteModel.getClass();

				Method method = clazz.getMethod("setUserip", String.class);

				method.invoke(_logapiRemoteModel, userip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogmsg() {
		return _logmsg;
	}

	@Override
	public void setLogmsg(String logmsg) {
		_logmsg = logmsg;

		if (_logapiRemoteModel != null) {
			try {
				Class<?> clazz = _logapiRemoteModel.getClass();

				Method method = clazz.getMethod("setLogmsg", String.class);

				method.invoke(_logapiRemoteModel, logmsg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_logapiRemoteModel != null) {
			try {
				Class<?> clazz = _logapiRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_logapiRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLogapiRemoteModel() {
		return _logapiRemoteModel;
	}

	public void setLogapiRemoteModel(BaseModel<?> logapiRemoteModel) {
		_logapiRemoteModel = logapiRemoteModel;
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

		Class<?> remoteModelClass = _logapiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_logapiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LogapiLocalServiceUtil.addLogapi(this);
		}
		else {
			LogapiLocalServiceUtil.updateLogapi(this);
		}
	}

	@Override
	public Logapi toEscapedModel() {
		return (Logapi)ProxyUtil.newProxyInstance(Logapi.class.getClassLoader(),
			new Class[] { Logapi.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LogapiClp clone = new LogapiClp();

		clone.setLogapiId(getLogapiId());
		clone.setUserId(getUserId());
		clone.setUserip(getUserip());
		clone.setLogmsg(getLogmsg());
		clone.setDate(getDate());

		return clone;
	}

	@Override
	public int compareTo(Logapi logapi) {
		long primaryKey = logapi.getPrimaryKey();

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

		if (!(obj instanceof LogapiClp)) {
			return false;
		}

		LogapiClp logapi = (LogapiClp)obj;

		long primaryKey = logapi.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{logapiId=");
		sb.append(getLogapiId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userip=");
		sb.append(getUserip());
		sb.append(", logmsg=");
		sb.append(getLogmsg());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>logapiId</column-name><column-value><![CDATA[");
		sb.append(getLogapiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userip</column-name><column-value><![CDATA[");
		sb.append(getUserip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logmsg</column-name><column-value><![CDATA[");
		sb.append(getLogmsg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _logapiId;
	private long _userId;
	private String _userUuid;
	private String _userip;
	private String _logmsg;
	private Date _date;
	private BaseModel<?> _logapiRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.class;
}