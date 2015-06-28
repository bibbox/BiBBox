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
import at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceLocalServiceUtil;

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
public class GeneReferenceClp extends BaseModelImpl<GeneReference>
	implements GeneReference {
	public GeneReferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GeneReference.class;
	}

	@Override
	public String getModelClassName() {
		return GeneReference.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _genereferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGenereferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _genereferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genereferenceId", getGenereferenceId());
		attributes.put("geneId", getGeneId());
		attributes.put("source", getSource());
		attributes.put("reference", getReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genereferenceId = (Long)attributes.get("genereferenceId");

		if (genereferenceId != null) {
			setGenereferenceId(genereferenceId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}
	}

	@Override
	public long getGenereferenceId() {
		return _genereferenceId;
	}

	@Override
	public void setGenereferenceId(long genereferenceId) {
		_genereferenceId = genereferenceId;

		if (_geneReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _geneReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setGenereferenceId", long.class);

				method.invoke(_geneReferenceRemoteModel, genereferenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGeneId() {
		return _geneId;
	}

	@Override
	public void setGeneId(long geneId) {
		_geneId = geneId;

		if (_geneReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _geneReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneId", long.class);

				method.invoke(_geneReferenceRemoteModel, geneId);
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

		if (_geneReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _geneReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", String.class);

				method.invoke(_geneReferenceRemoteModel, source);
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

		if (_geneReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _geneReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setReference", String.class);

				method.invoke(_geneReferenceRemoteModel, reference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneReferenceRemoteModel() {
		return _geneReferenceRemoteModel;
	}

	public void setGeneReferenceRemoteModel(
		BaseModel<?> geneReferenceRemoteModel) {
		_geneReferenceRemoteModel = geneReferenceRemoteModel;
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

		Class<?> remoteModelClass = _geneReferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geneReferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneReferenceLocalServiceUtil.addGeneReference(this);
		}
		else {
			GeneReferenceLocalServiceUtil.updateGeneReference(this);
		}
	}

	@Override
	public GeneReference toEscapedModel() {
		return (GeneReference)ProxyUtil.newProxyInstance(GeneReference.class.getClassLoader(),
			new Class[] { GeneReference.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneReferenceClp clone = new GeneReferenceClp();

		clone.setGenereferenceId(getGenereferenceId());
		clone.setGeneId(getGeneId());
		clone.setSource(getSource());
		clone.setReference(getReference());

		return clone;
	}

	@Override
	public int compareTo(GeneReference geneReference) {
		long primaryKey = geneReference.getPrimaryKey();

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

		if (!(obj instanceof GeneReferenceClp)) {
			return false;
		}

		GeneReferenceClp geneReference = (GeneReferenceClp)obj;

		long primaryKey = geneReference.getPrimaryKey();

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

		sb.append("{genereferenceId=");
		sb.append(getGenereferenceId());
		sb.append(", geneId=");
		sb.append(getGeneId());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", reference=");
		sb.append(getReference());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.GeneReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>genereferenceId</column-name><column-value><![CDATA[");
		sb.append(getGenereferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geneId</column-name><column-value><![CDATA[");
		sb.append(getGeneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reference</column-name><column-value><![CDATA[");
		sb.append(getReference());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _genereferenceId;
	private long _geneId;
	private String _source;
	private String _reference;
	private BaseModel<?> _geneReferenceRemoteModel;
}