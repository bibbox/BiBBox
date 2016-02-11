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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventNotificationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class RDConnectEventNotificationClp extends BaseModelImpl<RDConnectEventNotification>
	implements RDConnectEventNotification {
	public RDConnectEventNotificationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectEventNotification.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectEventNotification.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventnotificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventnotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventnotificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventnotificationId", getEventnotificationId());
		attributes.put("notificationtype", getNotificationtype());
		attributes.put("userId", getUserId());
		attributes.put("notificationselected", getNotificationselected());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventnotificationId = (Long)attributes.get("eventnotificationId");

		if (eventnotificationId != null) {
			setEventnotificationId(eventnotificationId);
		}

		String notificationtype = (String)attributes.get("notificationtype");

		if (notificationtype != null) {
			setNotificationtype(notificationtype);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean notificationselected = (Boolean)attributes.get(
				"notificationselected");

		if (notificationselected != null) {
			setNotificationselected(notificationselected);
		}
	}

	@Override
	public long getEventnotificationId() {
		return _eventnotificationId;
	}

	@Override
	public void setEventnotificationId(long eventnotificationId) {
		_eventnotificationId = eventnotificationId;

		if (_rdConnectEventNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setEventnotificationId",
						long.class);

				method.invoke(_rdConnectEventNotificationRemoteModel,
					eventnotificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotificationtype() {
		return _notificationtype;
	}

	@Override
	public void setNotificationtype(String notificationtype) {
		_notificationtype = notificationtype;

		if (_rdConnectEventNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationtype",
						String.class);

				method.invoke(_rdConnectEventNotificationRemoteModel,
					notificationtype);
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

		if (_rdConnectEventNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rdConnectEventNotificationRemoteModel, userId);
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
	public boolean getNotificationselected() {
		return _notificationselected;
	}

	@Override
	public boolean isNotificationselected() {
		return _notificationselected;
	}

	@Override
	public void setNotificationselected(boolean notificationselected) {
		_notificationselected = notificationselected;

		if (_rdConnectEventNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationselected",
						boolean.class);

				method.invoke(_rdConnectEventNotificationRemoteModel,
					notificationselected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRDConnectEventNotificationRemoteModel() {
		return _rdConnectEventNotificationRemoteModel;
	}

	public void setRDConnectEventNotificationRemoteModel(
		BaseModel<?> rdConnectEventNotificationRemoteModel) {
		_rdConnectEventNotificationRemoteModel = rdConnectEventNotificationRemoteModel;
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

		Class<?> remoteModelClass = _rdConnectEventNotificationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdConnectEventNotificationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDConnectEventNotificationLocalServiceUtil.addRDConnectEventNotification(this);
		}
		else {
			RDConnectEventNotificationLocalServiceUtil.updateRDConnectEventNotification(this);
		}
	}

	@Override
	public RDConnectEventNotification toEscapedModel() {
		return (RDConnectEventNotification)ProxyUtil.newProxyInstance(RDConnectEventNotification.class.getClassLoader(),
			new Class[] { RDConnectEventNotification.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDConnectEventNotificationClp clone = new RDConnectEventNotificationClp();

		clone.setEventnotificationId(getEventnotificationId());
		clone.setNotificationtype(getNotificationtype());
		clone.setUserId(getUserId());
		clone.setNotificationselected(getNotificationselected());

		return clone;
	}

	@Override
	public int compareTo(RDConnectEventNotification rdConnectEventNotification) {
		long primaryKey = rdConnectEventNotification.getPrimaryKey();

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

		if (!(obj instanceof RDConnectEventNotificationClp)) {
			return false;
		}

		RDConnectEventNotificationClp rdConnectEventNotification = (RDConnectEventNotificationClp)obj;

		long primaryKey = rdConnectEventNotification.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{eventnotificationId=");
		sb.append(getEventnotificationId());
		sb.append(", notificationtype=");
		sb.append(getNotificationtype());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", notificationselected=");
		sb.append(getNotificationselected());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventnotificationId</column-name><column-value><![CDATA[");
		sb.append(getEventnotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationtype</column-name><column-value><![CDATA[");
		sb.append(getNotificationtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationselected</column-name><column-value><![CDATA[");
		sb.append(getNotificationselected());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventnotificationId;
	private String _notificationtype;
	private long _userId;
	private String _userUuid;
	private boolean _notificationselected;
	private BaseModel<?> _rdConnectEventNotificationRemoteModel;
}