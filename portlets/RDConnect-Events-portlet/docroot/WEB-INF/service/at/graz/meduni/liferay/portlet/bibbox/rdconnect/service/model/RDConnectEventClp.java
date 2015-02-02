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
import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;

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
public class RDConnectEventClp extends BaseModelImpl<RDConnectEvent>
	implements RDConnectEvent {
	public RDConnectEventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectEvent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("eventdate", getEventdate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("shorttext", getShorttext());
		attributes.put("longtext", getLongtext());
		attributes.put("link", getLink());
		attributes.put("restricted", getRestricted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Date eventdate = (Date)attributes.get("eventdate");

		if (eventdate != null) {
			setEventdate(eventdate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String shorttext = (String)attributes.get("shorttext");

		if (shorttext != null) {
			setShorttext(shorttext);
		}

		String longtext = (String)attributes.get("longtext");

		if (longtext != null) {
			setLongtext(longtext);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String restricted = (String)attributes.get("restricted");

		if (restricted != null) {
			setRestricted(restricted);
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_rdConnectEventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventdate() {
		return _eventdate;
	}

	@Override
	public void setEventdate(Date eventdate) {
		_eventdate = eventdate;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventdate", Date.class);

				method.invoke(_rdConnectEventRemoteModel, eventdate);
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

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_rdConnectEventRemoteModel, organizationId);
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

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rdConnectEventRemoteModel, userId);
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
	public String getShorttext() {
		return _shorttext;
	}

	@Override
	public void setShorttext(String shorttext) {
		_shorttext = shorttext;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setShorttext", String.class);

				method.invoke(_rdConnectEventRemoteModel, shorttext);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongtext() {
		return _longtext;
	}

	@Override
	public void setLongtext(String longtext) {
		_longtext = longtext;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLongtext", String.class);

				method.invoke(_rdConnectEventRemoteModel, longtext);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLink() {
		return _link;
	}

	@Override
	public void setLink(String link) {
		_link = link;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setLink", String.class);

				method.invoke(_rdConnectEventRemoteModel, link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRestricted() {
		return _restricted;
	}

	@Override
	public void setRestricted(String restricted) {
		_restricted = restricted;

		if (_rdConnectEventRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectEventRemoteModel.getClass();

				Method method = clazz.getMethod("setRestricted", String.class);

				method.invoke(_rdConnectEventRemoteModel, restricted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRDConnectEventRemoteModel() {
		return _rdConnectEventRemoteModel;
	}

	public void setRDConnectEventRemoteModel(
		BaseModel<?> rdConnectEventRemoteModel) {
		_rdConnectEventRemoteModel = rdConnectEventRemoteModel;
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

		Class<?> remoteModelClass = _rdConnectEventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdConnectEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDConnectEventLocalServiceUtil.addRDConnectEvent(this);
		}
		else {
			RDConnectEventLocalServiceUtil.updateRDConnectEvent(this);
		}
	}

	@Override
	public RDConnectEvent toEscapedModel() {
		return (RDConnectEvent)ProxyUtil.newProxyInstance(RDConnectEvent.class.getClassLoader(),
			new Class[] { RDConnectEvent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDConnectEventClp clone = new RDConnectEventClp();

		clone.setEventId(getEventId());
		clone.setEventdate(getEventdate());
		clone.setOrganizationId(getOrganizationId());
		clone.setUserId(getUserId());
		clone.setShorttext(getShorttext());
		clone.setLongtext(getLongtext());
		clone.setLink(getLink());
		clone.setRestricted(getRestricted());

		return clone;
	}

	@Override
	public int compareTo(RDConnectEvent rdConnectEvent) {
		int value = 0;

		value = DateUtil.compareTo(getEventdate(), rdConnectEvent.getEventdate());

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

		if (!(obj instanceof RDConnectEventClp)) {
			return false;
		}

		RDConnectEventClp rdConnectEvent = (RDConnectEventClp)obj;

		long primaryKey = rdConnectEvent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", eventdate=");
		sb.append(getEventdate());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", shorttext=");
		sb.append(getShorttext());
		sb.append(", longtext=");
		sb.append(getLongtext());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", restricted=");
		sb.append(getRestricted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventdate</column-name><column-value><![CDATA[");
		sb.append(getEventdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shorttext</column-name><column-value><![CDATA[");
		sb.append(getShorttext());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longtext</column-name><column-value><![CDATA[");
		sb.append(getLongtext());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>restricted</column-name><column-value><![CDATA[");
		sb.append(getRestricted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventId;
	private Date _eventdate;
	private long _organizationId;
	private long _userId;
	private String _userUuid;
	private String _shorttext;
	private String _longtext;
	private String _link;
	private String _restricted;
	private BaseModel<?> _rdConnectEventRemoteModel;
}