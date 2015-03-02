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
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.EventDataLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class EventDataClp extends BaseModelImpl<EventData> implements EventData {
	public EventDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventData.class;
	}

	@Override
	public String getModelClassName() {
		return EventData.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventdataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventdataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventdataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventdataId", getEventdataId());
		attributes.put("eventlayoutId", getEventlayoutId());
		attributes.put("ontology", getOntology());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventdataId = (Long)attributes.get("eventdataId");

		if (eventdataId != null) {
			setEventdataId(eventdataId);
		}

		Long eventlayoutId = (Long)attributes.get("eventlayoutId");

		if (eventlayoutId != null) {
			setEventlayoutId(eventlayoutId);
		}

		String ontology = (String)attributes.get("ontology");

		if (ontology != null) {
			setOntology(ontology);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getEventdataId() {
		return _eventdataId;
	}

	@Override
	public void setEventdataId(long eventdataId) {
		_eventdataId = eventdataId;

		if (_eventDataRemoteModel != null) {
			try {
				Class<?> clazz = _eventDataRemoteModel.getClass();

				Method method = clazz.getMethod("setEventdataId", long.class);

				method.invoke(_eventDataRemoteModel, eventdataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventlayoutId() {
		return _eventlayoutId;
	}

	@Override
	public void setEventlayoutId(long eventlayoutId) {
		_eventlayoutId = eventlayoutId;

		if (_eventDataRemoteModel != null) {
			try {
				Class<?> clazz = _eventDataRemoteModel.getClass();

				Method method = clazz.getMethod("setEventlayoutId", long.class);

				method.invoke(_eventDataRemoteModel, eventlayoutId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOntology() {
		return _ontology;
	}

	@Override
	public void setOntology(String ontology) {
		_ontology = ontology;

		if (_eventDataRemoteModel != null) {
			try {
				Class<?> clazz = _eventDataRemoteModel.getClass();

				Method method = clazz.getMethod("setOntology", String.class);

				method.invoke(_eventDataRemoteModel, ontology);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_eventDataRemoteModel != null) {
			try {
				Class<?> clazz = _eventDataRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_eventDataRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventDataRemoteModel() {
		return _eventDataRemoteModel;
	}

	public void setEventDataRemoteModel(BaseModel<?> eventDataRemoteModel) {
		_eventDataRemoteModel = eventDataRemoteModel;
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

		Class<?> remoteModelClass = _eventDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventDataLocalServiceUtil.addEventData(this);
		}
		else {
			EventDataLocalServiceUtil.updateEventData(this);
		}
	}

	@Override
	public EventData toEscapedModel() {
		return (EventData)ProxyUtil.newProxyInstance(EventData.class.getClassLoader(),
			new Class[] { EventData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventDataClp clone = new EventDataClp();

		clone.setEventdataId(getEventdataId());
		clone.setEventlayoutId(getEventlayoutId());
		clone.setOntology(getOntology());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(EventData eventData) {
		int value = 0;

		if (getEventlayoutId() < eventData.getEventlayoutId()) {
			value = -1;
		}
		else if (getEventlayoutId() > eventData.getEventlayoutId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof EventDataClp)) {
			return false;
		}

		EventDataClp eventData = (EventDataClp)obj;

		long primaryKey = eventData.getPrimaryKey();

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

		sb.append("{eventdataId=");
		sb.append(getEventdataId());
		sb.append(", eventlayoutId=");
		sb.append(getEventlayoutId());
		sb.append(", ontology=");
		sb.append(getOntology());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventdataId</column-name><column-value><![CDATA[");
		sb.append(getEventdataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventlayoutId</column-name><column-value><![CDATA[");
		sb.append(getEventlayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ontology</column-name><column-value><![CDATA[");
		sb.append(getOntology());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventdataId;
	private long _eventlayoutId;
	private String _ontology;
	private String _value;
	private BaseModel<?> _eventDataRemoteModel;
}