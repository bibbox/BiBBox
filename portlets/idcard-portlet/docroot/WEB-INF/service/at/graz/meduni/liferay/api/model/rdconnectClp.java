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

package at.graz.meduni.liferay.api.model;

import at.graz.meduni.liferay.api.service.ClpSerializer;
import at.graz.meduni.liferay.api.service.rdconnectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class rdconnectClp extends BaseModelImpl<rdconnect> implements rdconnect {
	public rdconnectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return rdconnect.class;
	}

	@Override
	public String getModelClassName() {
		return rdconnect.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _idcardapilogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdcardapilogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idcardapilogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idcardapilogId", getIdcardapilogId());
		attributes.put("userId", getUserId());
		attributes.put("ipaddress", getIpaddress());
		attributes.put("accessDate", getAccessDate());
		attributes.put("requestparameter", getRequestparameter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idcardapilogId = (Long)attributes.get("idcardapilogId");

		if (idcardapilogId != null) {
			setIdcardapilogId(idcardapilogId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ipaddress = (String)attributes.get("ipaddress");

		if (ipaddress != null) {
			setIpaddress(ipaddress);
		}

		Date accessDate = (Date)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		String requestparameter = (String)attributes.get("requestparameter");

		if (requestparameter != null) {
			setRequestparameter(requestparameter);
		}
	}

	@Override
	public long getIdcardapilogId() {
		return _idcardapilogId;
	}

	@Override
	public void setIdcardapilogId(long idcardapilogId) {
		_idcardapilogId = idcardapilogId;

		if (_rdconnectRemoteModel != null) {
			try {
				Class<?> clazz = _rdconnectRemoteModel.getClass();

				Method method = clazz.getMethod("setIdcardapilogId", long.class);

				method.invoke(_rdconnectRemoteModel, idcardapilogId);
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

		if (_rdconnectRemoteModel != null) {
			try {
				Class<?> clazz = _rdconnectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rdconnectRemoteModel, userId);
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
	public String getIpaddress() {
		return _ipaddress;
	}

	@Override
	public void setIpaddress(String ipaddress) {
		_ipaddress = ipaddress;

		if (_rdconnectRemoteModel != null) {
			try {
				Class<?> clazz = _rdconnectRemoteModel.getClass();

				Method method = clazz.getMethod("setIpaddress", String.class);

				method.invoke(_rdconnectRemoteModel, ipaddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAccessDate() {
		return _accessDate;
	}

	@Override
	public void setAccessDate(Date accessDate) {
		_accessDate = accessDate;

		if (_rdconnectRemoteModel != null) {
			try {
				Class<?> clazz = _rdconnectRemoteModel.getClass();

				Method method = clazz.getMethod("setAccessDate", Date.class);

				method.invoke(_rdconnectRemoteModel, accessDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequestparameter() {
		return _requestparameter;
	}

	@Override
	public void setRequestparameter(String requestparameter) {
		_requestparameter = requestparameter;

		if (_rdconnectRemoteModel != null) {
			try {
				Class<?> clazz = _rdconnectRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestparameter",
						String.class);

				method.invoke(_rdconnectRemoteModel, requestparameter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getrdconnectRemoteModel() {
		return _rdconnectRemoteModel;
	}

	public void setrdconnectRemoteModel(BaseModel<?> rdconnectRemoteModel) {
		_rdconnectRemoteModel = rdconnectRemoteModel;
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

		Class<?> remoteModelClass = _rdconnectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdconnectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			rdconnectLocalServiceUtil.addrdconnect(this);
		}
		else {
			rdconnectLocalServiceUtil.updaterdconnect(this);
		}
	}

	@Override
	public rdconnect toEscapedModel() {
		return (rdconnect)ProxyUtil.newProxyInstance(rdconnect.class.getClassLoader(),
			new Class[] { rdconnect.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		rdconnectClp clone = new rdconnectClp();

		clone.setIdcardapilogId(getIdcardapilogId());
		clone.setUserId(getUserId());
		clone.setIpaddress(getIpaddress());
		clone.setAccessDate(getAccessDate());
		clone.setRequestparameter(getRequestparameter());

		return clone;
	}

	@Override
	public int compareTo(rdconnect rdconnect) {
		int value = 0;

		value = DateUtil.compareTo(getAccessDate(), rdconnect.getAccessDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof rdconnectClp)) {
			return false;
		}

		rdconnectClp rdconnect = (rdconnectClp)obj;

		long primaryKey = rdconnect.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{idcardapilogId=");
		sb.append(getIdcardapilogId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ipaddress=");
		sb.append(getIpaddress());
		sb.append(", accessDate=");
		sb.append(getAccessDate());
		sb.append(", requestparameter=");
		sb.append(getRequestparameter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.api.model.rdconnect");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idcardapilogId</column-name><column-value><![CDATA[");
		sb.append(getIdcardapilogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipaddress</column-name><column-value><![CDATA[");
		sb.append(getIpaddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessDate</column-name><column-value><![CDATA[");
		sb.append(getAccessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestparameter</column-name><column-value><![CDATA[");
		sb.append(getRequestparameter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idcardapilogId;
	private long _userId;
	private String _userUuid;
	private String _ipaddress;
	private Date _accessDate;
	private String _requestparameter;
	private BaseModel<?> _rdconnectRemoteModel;
}