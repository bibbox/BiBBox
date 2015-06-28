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
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil;

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
public class OrphanetReferenceClp extends BaseModelImpl<OrphanetReference>
	implements OrphanetReference {
	public OrphanetReferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetReference.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetReference.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _orphanetreferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrphanetreferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orphanetreferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetreferenceId", getOrphanetreferenceId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("source", getSource());
		attributes.put("reference", getReference());
		attributes.put("disordermappingrelation", getDisordermappingrelation());
		attributes.put("disordermappingrelationorphanumber",
			getDisordermappingrelationorphanumber());
		attributes.put("disordermappingrelationname",
			getDisordermappingrelationname());
		attributes.put("disordermappingicdrelation",
			getDisordermappingicdrelation());
		attributes.put("disordermappingicdrelationorphanumber",
			getDisordermappingicdrelationorphanumber());
		attributes.put("disordermappingicdrelationname",
			getDisordermappingicdrelationname());
		attributes.put("disordermappingvalidationstatus",
			getDisordermappingvalidationstatus());
		attributes.put("disordermappingvalidationstatusorphanumber",
			getDisordermappingvalidationstatusorphanumber());
		attributes.put("disordermappingvalidationstatusname",
			getDisordermappingvalidationstatusname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetreferenceId = (Long)attributes.get("orphanetreferenceId");

		if (orphanetreferenceId != null) {
			setOrphanetreferenceId(orphanetreferenceId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		Long disordermappingrelation = (Long)attributes.get(
				"disordermappingrelation");

		if (disordermappingrelation != null) {
			setDisordermappingrelation(disordermappingrelation);
		}

		Long disordermappingrelationorphanumber = (Long)attributes.get(
				"disordermappingrelationorphanumber");

		if (disordermappingrelationorphanumber != null) {
			setDisordermappingrelationorphanumber(disordermappingrelationorphanumber);
		}

		String disordermappingrelationname = (String)attributes.get(
				"disordermappingrelationname");

		if (disordermappingrelationname != null) {
			setDisordermappingrelationname(disordermappingrelationname);
		}

		Long disordermappingicdrelation = (Long)attributes.get(
				"disordermappingicdrelation");

		if (disordermappingicdrelation != null) {
			setDisordermappingicdrelation(disordermappingicdrelation);
		}

		Long disordermappingicdrelationorphanumber = (Long)attributes.get(
				"disordermappingicdrelationorphanumber");

		if (disordermappingicdrelationorphanumber != null) {
			setDisordermappingicdrelationorphanumber(disordermappingicdrelationorphanumber);
		}

		String disordermappingicdrelationname = (String)attributes.get(
				"disordermappingicdrelationname");

		if (disordermappingicdrelationname != null) {
			setDisordermappingicdrelationname(disordermappingicdrelationname);
		}

		Long disordermappingvalidationstatus = (Long)attributes.get(
				"disordermappingvalidationstatus");

		if (disordermappingvalidationstatus != null) {
			setDisordermappingvalidationstatus(disordermappingvalidationstatus);
		}

		Long disordermappingvalidationstatusorphanumber = (Long)attributes.get(
				"disordermappingvalidationstatusorphanumber");

		if (disordermappingvalidationstatusorphanumber != null) {
			setDisordermappingvalidationstatusorphanumber(disordermappingvalidationstatusorphanumber);
		}

		String disordermappingvalidationstatusname = (String)attributes.get(
				"disordermappingvalidationstatusname");

		if (disordermappingvalidationstatusname != null) {
			setDisordermappingvalidationstatusname(disordermappingvalidationstatusname);
		}
	}

	@Override
	public long getOrphanetreferenceId() {
		return _orphanetreferenceId;
	}

	@Override
	public void setOrphanetreferenceId(long orphanetreferenceId) {
		_orphanetreferenceId = orphanetreferenceId;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetreferenceId",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel, orphanetreferenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetdisorderId",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel, orphanetdisorderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSource() {
		return _source;
	}

	@Override
	public void setSource(String source) {
		_source = source;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", String.class);

				method.invoke(_orphanetReferenceRemoteModel, source);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReference() {
		return _reference;
	}

	@Override
	public void setReference(String reference) {
		_reference = reference;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setReference", String.class);

				method.invoke(_orphanetReferenceRemoteModel, reference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingrelation() {
		return _disordermappingrelation;
	}

	@Override
	public void setDisordermappingrelation(long disordermappingrelation) {
		_disordermappingrelation = disordermappingrelation;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingrelation",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingrelation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingrelationorphanumber() {
		return _disordermappingrelationorphanumber;
	}

	@Override
	public void setDisordermappingrelationorphanumber(
		long disordermappingrelationorphanumber) {
		_disordermappingrelationorphanumber = disordermappingrelationorphanumber;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingrelationorphanumber",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingrelationorphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisordermappingrelationname() {
		return _disordermappingrelationname;
	}

	@Override
	public void setDisordermappingrelationname(
		String disordermappingrelationname) {
		_disordermappingrelationname = disordermappingrelationname;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingrelationname",
						String.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingrelationname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingicdrelation() {
		return _disordermappingicdrelation;
	}

	@Override
	public void setDisordermappingicdrelation(long disordermappingicdrelation) {
		_disordermappingicdrelation = disordermappingicdrelation;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingicdrelation",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingicdrelation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingicdrelationorphanumber() {
		return _disordermappingicdrelationorphanumber;
	}

	@Override
	public void setDisordermappingicdrelationorphanumber(
		long disordermappingicdrelationorphanumber) {
		_disordermappingicdrelationorphanumber = disordermappingicdrelationorphanumber;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingicdrelationorphanumber",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingicdrelationorphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisordermappingicdrelationname() {
		return _disordermappingicdrelationname;
	}

	@Override
	public void setDisordermappingicdrelationname(
		String disordermappingicdrelationname) {
		_disordermappingicdrelationname = disordermappingicdrelationname;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingicdrelationname",
						String.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingicdrelationname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingvalidationstatus() {
		return _disordermappingvalidationstatus;
	}

	@Override
	public void setDisordermappingvalidationstatus(
		long disordermappingvalidationstatus) {
		_disordermappingvalidationstatus = disordermappingvalidationstatus;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingvalidationstatus",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingvalidationstatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordermappingvalidationstatusorphanumber() {
		return _disordermappingvalidationstatusorphanumber;
	}

	@Override
	public void setDisordermappingvalidationstatusorphanumber(
		long disordermappingvalidationstatusorphanumber) {
		_disordermappingvalidationstatusorphanumber = disordermappingvalidationstatusorphanumber;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingvalidationstatusorphanumber",
						long.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingvalidationstatusorphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisordermappingvalidationstatusname() {
		return _disordermappingvalidationstatusname;
	}

	@Override
	public void setDisordermappingvalidationstatusname(
		String disordermappingvalidationstatusname) {
		_disordermappingvalidationstatusname = disordermappingvalidationstatusname;

		if (_orphanetReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordermappingvalidationstatusname",
						String.class);

				method.invoke(_orphanetReferenceRemoteModel,
					disordermappingvalidationstatusname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrphanetReferenceRemoteModel() {
		return _orphanetReferenceRemoteModel;
	}

	public void setOrphanetReferenceRemoteModel(
		BaseModel<?> orphanetReferenceRemoteModel) {
		_orphanetReferenceRemoteModel = orphanetReferenceRemoteModel;
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

		Class<?> remoteModelClass = _orphanetReferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orphanetReferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrphanetReferenceLocalServiceUtil.addOrphanetReference(this);
		}
		else {
			OrphanetReferenceLocalServiceUtil.updateOrphanetReference(this);
		}
	}

	@Override
	public OrphanetReference toEscapedModel() {
		return (OrphanetReference)ProxyUtil.newProxyInstance(OrphanetReference.class.getClassLoader(),
			new Class[] { OrphanetReference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrphanetReferenceClp clone = new OrphanetReferenceClp();

		clone.setOrphanetreferenceId(getOrphanetreferenceId());
		clone.setOrphanetdisorderId(getOrphanetdisorderId());
		clone.setSource(getSource());
		clone.setReference(getReference());
		clone.setDisordermappingrelation(getDisordermappingrelation());
		clone.setDisordermappingrelationorphanumber(getDisordermappingrelationorphanumber());
		clone.setDisordermappingrelationname(getDisordermappingrelationname());
		clone.setDisordermappingicdrelation(getDisordermappingicdrelation());
		clone.setDisordermappingicdrelationorphanumber(getDisordermappingicdrelationorphanumber());
		clone.setDisordermappingicdrelationname(getDisordermappingicdrelationname());
		clone.setDisordermappingvalidationstatus(getDisordermappingvalidationstatus());
		clone.setDisordermappingvalidationstatusorphanumber(getDisordermappingvalidationstatusorphanumber());
		clone.setDisordermappingvalidationstatusname(getDisordermappingvalidationstatusname());

		return clone;
	}

	@Override
	public int compareTo(OrphanetReference orphanetReference) {
		long primaryKey = orphanetReference.getPrimaryKey();

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

		if (!(obj instanceof OrphanetReferenceClp)) {
			return false;
		}

		OrphanetReferenceClp orphanetReference = (OrphanetReferenceClp)obj;

		long primaryKey = orphanetReference.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{orphanetreferenceId=");
		sb.append(getOrphanetreferenceId());
		sb.append(", orphanetdisorderId=");
		sb.append(getOrphanetdisorderId());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", reference=");
		sb.append(getReference());
		sb.append(", disordermappingrelation=");
		sb.append(getDisordermappingrelation());
		sb.append(", disordermappingrelationorphanumber=");
		sb.append(getDisordermappingrelationorphanumber());
		sb.append(", disordermappingrelationname=");
		sb.append(getDisordermappingrelationname());
		sb.append(", disordermappingicdrelation=");
		sb.append(getDisordermappingicdrelation());
		sb.append(", disordermappingicdrelationorphanumber=");
		sb.append(getDisordermappingicdrelationorphanumber());
		sb.append(", disordermappingicdrelationname=");
		sb.append(getDisordermappingicdrelationname());
		sb.append(", disordermappingvalidationstatus=");
		sb.append(getDisordermappingvalidationstatus());
		sb.append(", disordermappingvalidationstatusorphanumber=");
		sb.append(getDisordermappingvalidationstatusorphanumber());
		sb.append(", disordermappingvalidationstatusname=");
		sb.append(getDisordermappingvalidationstatusname());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orphanetreferenceId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetreferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanetdisorderId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetdisorderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reference</column-name><column-value><![CDATA[");
		sb.append(getReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingrelation</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingrelation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingrelationorphanumber</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingrelationorphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingrelationname</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingrelationname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingicdrelation</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingicdrelation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingicdrelationorphanumber</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingicdrelationorphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingicdrelationname</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingicdrelationname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingvalidationstatus</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingvalidationstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingvalidationstatusorphanumber</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingvalidationstatusorphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordermappingvalidationstatusname</column-name><column-value><![CDATA[");
		sb.append(getDisordermappingvalidationstatusname());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orphanetreferenceId;
	private long _orphanetdisorderId;
	private String _source;
	private String _reference;
	private long _disordermappingrelation;
	private long _disordermappingrelationorphanumber;
	private String _disordermappingrelationname;
	private long _disordermappingicdrelation;
	private long _disordermappingicdrelationorphanumber;
	private String _disordermappingicdrelationname;
	private long _disordermappingvalidationstatus;
	private long _disordermappingvalidationstatusorphanumber;
	private String _disordermappingvalidationstatusname;
	private BaseModel<?> _orphanetReferenceRemoteModel;
}