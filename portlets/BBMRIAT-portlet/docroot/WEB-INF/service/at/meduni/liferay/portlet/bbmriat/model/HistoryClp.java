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

package at.meduni.liferay.portlet.bbmriat.model;

import at.meduni.liferay.portlet.bbmriat.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmriat.service.HistoryLocalServiceUtil;

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
 * @author Robert Reihs
 */
public class HistoryClp extends BaseModelImpl<History> implements History {
	public HistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return History.class;
	}

	@Override
	public String getModelClassName() {
		return History.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _historyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _historyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("historyId", getHistoryId());
		attributes.put("action", getAction());
		attributes.put("time", getTime());
		attributes.put("histo_id", getHisto_id());
		attributes.put("workplace_id", getWorkplace_id());
		attributes.put("order_id", getOrder_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
		}

		Long action = (Long)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Long histo_id = (Long)attributes.get("histo_id");

		if (histo_id != null) {
			setHisto_id(histo_id);
		}

		Long workplace_id = (Long)attributes.get("workplace_id");

		if (workplace_id != null) {
			setWorkplace_id(workplace_id);
		}

		Long order_id = (Long)attributes.get("order_id");

		if (order_id != null) {
			setOrder_id(order_id);
		}
	}

	@Override
	public long getHistoryId() {
		return _historyId;
	}

	@Override
	public void setHistoryId(long historyId) {
		_historyId = historyId;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setHistoryId", long.class);

				method.invoke(_historyRemoteModel, historyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAction() {
		return _action;
	}

	@Override
	public void setAction(long action) {
		_action = action;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", long.class);

				method.invoke(_historyRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTime() {
		return _time;
	}

	@Override
	public void setTime(Date time) {
		_time = time;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", Date.class);

				method.invoke(_historyRemoteModel, time);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHisto_id() {
		return _histo_id;
	}

	@Override
	public void setHisto_id(long histo_id) {
		_histo_id = histo_id;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setHisto_id", long.class);

				method.invoke(_historyRemoteModel, histo_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkplace_id() {
		return _workplace_id;
	}

	@Override
	public void setWorkplace_id(long workplace_id) {
		_workplace_id = workplace_id;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkplace_id", long.class);

				method.invoke(_historyRemoteModel, workplace_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrder_id() {
		return _order_id;
	}

	@Override
	public void setOrder_id(long order_id) {
		_order_id = order_id;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder_id", long.class);

				method.invoke(_historyRemoteModel, order_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHistoryRemoteModel() {
		return _historyRemoteModel;
	}

	public void setHistoryRemoteModel(BaseModel<?> historyRemoteModel) {
		_historyRemoteModel = historyRemoteModel;
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

		Class<?> remoteModelClass = _historyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_historyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HistoryLocalServiceUtil.addHistory(this);
		}
		else {
			HistoryLocalServiceUtil.updateHistory(this);
		}
	}

	@Override
	public History toEscapedModel() {
		return (History)ProxyUtil.newProxyInstance(History.class.getClassLoader(),
			new Class[] { History.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HistoryClp clone = new HistoryClp();

		clone.setHistoryId(getHistoryId());
		clone.setAction(getAction());
		clone.setTime(getTime());
		clone.setHisto_id(getHisto_id());
		clone.setWorkplace_id(getWorkplace_id());
		clone.setOrder_id(getOrder_id());

		return clone;
	}

	@Override
	public int compareTo(History history) {
		long primaryKey = history.getPrimaryKey();

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

		if (!(obj instanceof HistoryClp)) {
			return false;
		}

		HistoryClp history = (HistoryClp)obj;

		long primaryKey = history.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{historyId=");
		sb.append(getHistoryId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", histo_id=");
		sb.append(getHisto_id());
		sb.append(", workplace_id=");
		sb.append(getWorkplace_id());
		sb.append(", order_id=");
		sb.append(getOrder_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmriat.model.History");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>historyId</column-name><column-value><![CDATA[");
		sb.append(getHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>histo_id</column-name><column-value><![CDATA[");
		sb.append(getHisto_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workplace_id</column-name><column-value><![CDATA[");
		sb.append(getWorkplace_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order_id</column-name><column-value><![CDATA[");
		sb.append(getOrder_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _historyId;
	private long _action;
	private Date _time;
	private long _histo_id;
	private long _workplace_id;
	private long _order_id;
	private BaseModel<?> _historyRemoteModel;
}