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
import at.meduni.liferay.portlet.bbmriat.service.ddllinkingtableLocalServiceUtil;

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
 * @author Robert Reihs
 */
public class ddllinkingtableClp extends BaseModelImpl<ddllinkingtable>
	implements ddllinkingtable {
	public ddllinkingtableClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ddllinkingtable.class;
	}

	@Override
	public String getModelClassName() {
		return ddllinkingtable.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ddllinkingtable;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDdllinkingtable(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ddllinkingtable;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddllinkingtable", getDdllinkingtable());
		attributes.put("recordid", getRecordid());
		attributes.put("recordsetid", getRecordsetid());
		attributes.put("linkrecordid", getLinkrecordid());
		attributes.put("linkrecordsetid", getLinkrecordsetid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddllinkingtable = (Long)attributes.get("ddllinkingtable");

		if (ddllinkingtable != null) {
			setDdllinkingtable(ddllinkingtable);
		}

		Long recordid = (Long)attributes.get("recordid");

		if (recordid != null) {
			setRecordid(recordid);
		}

		Long recordsetid = (Long)attributes.get("recordsetid");

		if (recordsetid != null) {
			setRecordsetid(recordsetid);
		}

		Long linkrecordid = (Long)attributes.get("linkrecordid");

		if (linkrecordid != null) {
			setLinkrecordid(linkrecordid);
		}

		Long linkrecordsetid = (Long)attributes.get("linkrecordsetid");

		if (linkrecordsetid != null) {
			setLinkrecordsetid(linkrecordsetid);
		}
	}

	@Override
	public long getDdllinkingtable() {
		return _ddllinkingtable;
	}

	@Override
	public void setDdllinkingtable(long ddllinkingtable) {
		_ddllinkingtable = ddllinkingtable;

		if (_ddllinkingtableRemoteModel != null) {
			try {
				Class<?> clazz = _ddllinkingtableRemoteModel.getClass();

				Method method = clazz.getMethod("setDdllinkingtable", long.class);

				method.invoke(_ddllinkingtableRemoteModel, ddllinkingtable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRecordid() {
		return _recordid;
	}

	@Override
	public void setRecordid(long recordid) {
		_recordid = recordid;

		if (_ddllinkingtableRemoteModel != null) {
			try {
				Class<?> clazz = _ddllinkingtableRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordid", long.class);

				method.invoke(_ddllinkingtableRemoteModel, recordid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRecordsetid() {
		return _recordsetid;
	}

	@Override
	public void setRecordsetid(long recordsetid) {
		_recordsetid = recordsetid;

		if (_ddllinkingtableRemoteModel != null) {
			try {
				Class<?> clazz = _ddllinkingtableRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordsetid", long.class);

				method.invoke(_ddllinkingtableRemoteModel, recordsetid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLinkrecordid() {
		return _linkrecordid;
	}

	@Override
	public void setLinkrecordid(long linkrecordid) {
		_linkrecordid = linkrecordid;

		if (_ddllinkingtableRemoteModel != null) {
			try {
				Class<?> clazz = _ddllinkingtableRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkrecordid", long.class);

				method.invoke(_ddllinkingtableRemoteModel, linkrecordid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLinkrecordsetid() {
		return _linkrecordsetid;
	}

	@Override
	public void setLinkrecordsetid(long linkrecordsetid) {
		_linkrecordsetid = linkrecordsetid;

		if (_ddllinkingtableRemoteModel != null) {
			try {
				Class<?> clazz = _ddllinkingtableRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkrecordsetid", long.class);

				method.invoke(_ddllinkingtableRemoteModel, linkrecordsetid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getddllinkingtableRemoteModel() {
		return _ddllinkingtableRemoteModel;
	}

	public void setddllinkingtableRemoteModel(
		BaseModel<?> ddllinkingtableRemoteModel) {
		_ddllinkingtableRemoteModel = ddllinkingtableRemoteModel;
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

		Class<?> remoteModelClass = _ddllinkingtableRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ddllinkingtableRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ddllinkingtableLocalServiceUtil.addddllinkingtable(this);
		}
		else {
			ddllinkingtableLocalServiceUtil.updateddllinkingtable(this);
		}
	}

	@Override
	public ddllinkingtable toEscapedModel() {
		return (ddllinkingtable)ProxyUtil.newProxyInstance(ddllinkingtable.class.getClassLoader(),
			new Class[] { ddllinkingtable.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ddllinkingtableClp clone = new ddllinkingtableClp();

		clone.setDdllinkingtable(getDdllinkingtable());
		clone.setRecordid(getRecordid());
		clone.setRecordsetid(getRecordsetid());
		clone.setLinkrecordid(getLinkrecordid());
		clone.setLinkrecordsetid(getLinkrecordsetid());

		return clone;
	}

	@Override
	public int compareTo(ddllinkingtable ddllinkingtable) {
		int value = 0;

		if (getRecordid() < ddllinkingtable.getRecordid()) {
			value = -1;
		}
		else if (getRecordid() > ddllinkingtable.getRecordid()) {
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

		if (!(obj instanceof ddllinkingtableClp)) {
			return false;
		}

		ddllinkingtableClp ddllinkingtable = (ddllinkingtableClp)obj;

		long primaryKey = ddllinkingtable.getPrimaryKey();

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

		sb.append("{ddllinkingtable=");
		sb.append(getDdllinkingtable());
		sb.append(", recordid=");
		sb.append(getRecordid());
		sb.append(", recordsetid=");
		sb.append(getRecordsetid());
		sb.append(", linkrecordid=");
		sb.append(getLinkrecordid());
		sb.append(", linkrecordsetid=");
		sb.append(getLinkrecordsetid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ddllinkingtable</column-name><column-value><![CDATA[");
		sb.append(getDdllinkingtable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recordid</column-name><column-value><![CDATA[");
		sb.append(getRecordid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recordsetid</column-name><column-value><![CDATA[");
		sb.append(getRecordsetid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkrecordid</column-name><column-value><![CDATA[");
		sb.append(getLinkrecordid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkrecordsetid</column-name><column-value><![CDATA[");
		sb.append(getLinkrecordsetid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ddllinkingtable;
	private long _recordid;
	private long _recordsetid;
	private long _linkrecordid;
	private long _linkrecordsetid;
	private BaseModel<?> _ddllinkingtableRemoteModel;
}