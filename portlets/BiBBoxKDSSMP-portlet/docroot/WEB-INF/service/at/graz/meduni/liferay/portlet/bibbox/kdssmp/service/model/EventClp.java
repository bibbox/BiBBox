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
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class EventClp extends BaseModelImpl<Event> implements Event {
	public EventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
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
		attributes.put("patientId", getPatientId());
		attributes.put("eventdate", getEventdate());
		attributes.put("eventtype", getEventtype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Date eventdate = (Date)attributes.get("eventdate");

		if (eventdate != null) {
			setEventdate(eventdate);
		}

		String eventtype = (String)attributes.get("eventtype");

		if (eventtype != null) {
			setEventtype(eventtype);
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_eventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_patientId = patientId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientId", long.class);

				method.invoke(_eventRemoteModel, patientId);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventdate", Date.class);

				method.invoke(_eventRemoteModel, eventdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventtype() {
		return _eventtype;
	}

	@Override
	public void setEventtype(String eventtype) {
		_eventtype = eventtype;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventtype", String.class);

				method.invoke(_eventRemoteModel, eventtype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getEventGroup() {
		try {
			String methodName = "getEventGroup";

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

	public BaseModel<?> getEventRemoteModel() {
		return _eventRemoteModel;
	}

	public void setEventRemoteModel(BaseModel<?> eventRemoteModel) {
		_eventRemoteModel = eventRemoteModel;
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

		Class<?> remoteModelClass = _eventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventLocalServiceUtil.addEvent(this);
		}
		else {
			EventLocalServiceUtil.updateEvent(this);
		}
	}

	@Override
	public Event toEscapedModel() {
		return (Event)ProxyUtil.newProxyInstance(Event.class.getClassLoader(),
			new Class[] { Event.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventClp clone = new EventClp();

		clone.setEventId(getEventId());
		clone.setPatientId(getPatientId());
		clone.setEventdate(getEventdate());
		clone.setEventtype(getEventtype());

		return clone;
	}

	@Override
	public int compareTo(Event event) {
		int value = 0;

		if (getPatientId() < event.getPatientId()) {
			value = -1;
		}
		else if (getPatientId() > event.getPatientId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getEventdate(), event.getEventdate());

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

		if (!(obj instanceof EventClp)) {
			return false;
		}

		EventClp event = (EventClp)obj;

		long primaryKey = event.getPrimaryKey();

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

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", patientId=");
		sb.append(getPatientId());
		sb.append(", eventdate=");
		sb.append(getEventdate());
		sb.append(", eventtype=");
		sb.append(getEventtype());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientId</column-name><column-value><![CDATA[");
		sb.append(getPatientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventdate</column-name><column-value><![CDATA[");
		sb.append(getEventdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventtype</column-name><column-value><![CDATA[");
		sb.append(getEventtype());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventId;
	private long _patientId;
	private Date _eventdate;
	private String _eventtype;
	private BaseModel<?> _eventRemoteModel;
}