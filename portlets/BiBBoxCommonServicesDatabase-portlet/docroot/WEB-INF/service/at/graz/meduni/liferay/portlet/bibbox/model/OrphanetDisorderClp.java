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

package at.graz.meduni.liferay.portlet.bibbox.model;

import at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalServiceUtil;

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
public class OrphanetDisorderClp extends BaseModelImpl<OrphanetDisorder>
	implements OrphanetDisorder {
	public OrphanetDisorderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetDisorder.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetDisorder.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _orphanetdisorderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrphanetdisorderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orphanetdisorderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("orphanumber", getOrphanumber());
		attributes.put("orpahnetlink", getOrpahnetlink());
		attributes.put("diseasename", getDiseasename());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		Long orphanumber = (Long)attributes.get("orphanumber");

		if (orphanumber != null) {
			setOrphanumber(orphanumber);
		}

		String orpahnetlink = (String)attributes.get("orpahnetlink");

		if (orpahnetlink != null) {
			setOrpahnetlink(orpahnetlink);
		}

		String diseasename = (String)attributes.get("diseasename");

		if (diseasename != null) {
			setDiseasename(diseasename);
		}
	}

	@Override
	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;

		if (_orphanetDisorderRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetDisorderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetdisorderId",
						long.class);

				method.invoke(_orphanetDisorderRemoteModel, orphanetdisorderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrphanumber() {
		return _orphanumber;
	}

	@Override
	public void setOrphanumber(long orphanumber) {
		_orphanumber = orphanumber;

		if (_orphanetDisorderRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetDisorderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanumber", long.class);

				method.invoke(_orphanetDisorderRemoteModel, orphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrpahnetlink() {
		return _orpahnetlink;
	}

	@Override
	public void setOrpahnetlink(String orpahnetlink) {
		_orpahnetlink = orpahnetlink;

		if (_orphanetDisorderRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetDisorderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrpahnetlink", String.class);

				method.invoke(_orphanetDisorderRemoteModel, orpahnetlink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasename() {
		return _diseasename;
	}

	@Override
	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;

		if (_orphanetDisorderRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetDisorderRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasename", String.class);

				method.invoke(_orphanetDisorderRemoteModel, diseasename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrphanetDisorderRemoteModel() {
		return _orphanetDisorderRemoteModel;
	}

	public void setOrphanetDisorderRemoteModel(
		BaseModel<?> orphanetDisorderRemoteModel) {
		_orphanetDisorderRemoteModel = orphanetDisorderRemoteModel;
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

		Class<?> remoteModelClass = _orphanetDisorderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orphanetDisorderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrphanetDisorderLocalServiceUtil.addOrphanetDisorder(this);
		}
		else {
			OrphanetDisorderLocalServiceUtil.updateOrphanetDisorder(this);
		}
	}

	@Override
	public OrphanetDisorder toEscapedModel() {
		return (OrphanetDisorder)ProxyUtil.newProxyInstance(OrphanetDisorder.class.getClassLoader(),
			new Class[] { OrphanetDisorder.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrphanetDisorderClp clone = new OrphanetDisorderClp();

		clone.setOrphanetdisorderId(getOrphanetdisorderId());
		clone.setOrphanumber(getOrphanumber());
		clone.setOrpahnetlink(getOrpahnetlink());
		clone.setDiseasename(getDiseasename());

		return clone;
	}

	@Override
	public int compareTo(OrphanetDisorder orphanetDisorder) {
		long primaryKey = orphanetDisorder.getPrimaryKey();

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

		if (!(obj instanceof OrphanetDisorderClp)) {
			return false;
		}

		OrphanetDisorderClp orphanetDisorder = (OrphanetDisorderClp)obj;

		long primaryKey = orphanetDisorder.getPrimaryKey();

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

		sb.append("{orphanetdisorderId=");
		sb.append(getOrphanetdisorderId());
		sb.append(", orphanumber=");
		sb.append(getOrphanumber());
		sb.append(", orpahnetlink=");
		sb.append(getOrpahnetlink());
		sb.append(", diseasename=");
		sb.append(getDiseasename());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orphanetdisorderId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetdisorderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanumber</column-name><column-value><![CDATA[");
		sb.append(getOrphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orpahnetlink</column-name><column-value><![CDATA[");
		sb.append(getOrpahnetlink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasename</column-name><column-value><![CDATA[");
		sb.append(getDiseasename());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orphanetdisorderId;
	private long _orphanumber;
	private String _orpahnetlink;
	private String _diseasename;
	private BaseModel<?> _orphanetDisorderRemoteModel;
}