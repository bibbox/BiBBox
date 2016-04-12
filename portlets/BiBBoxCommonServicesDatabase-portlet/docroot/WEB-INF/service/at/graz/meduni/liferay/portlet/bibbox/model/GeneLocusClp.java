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
import at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusLocalServiceUtil;

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
public class GeneLocusClp extends BaseModelImpl<GeneLocus> implements GeneLocus {
	public GeneLocusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GeneLocus.class;
	}

	@Override
	public String getModelClassName() {
		return GeneLocus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _genelocusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGenelocusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _genelocusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genelocusId", getGenelocusId());
		attributes.put("geneId", getGeneId());
		attributes.put("genelocus", getGenelocus());
		attributes.put("genelocuskey", getGenelocuskey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genelocusId = (Long)attributes.get("genelocusId");

		if (genelocusId != null) {
			setGenelocusId(genelocusId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String genelocus = (String)attributes.get("genelocus");

		if (genelocus != null) {
			setGenelocus(genelocus);
		}

		String genelocuskey = (String)attributes.get("genelocuskey");

		if (genelocuskey != null) {
			setGenelocuskey(genelocuskey);
		}
	}

	@Override
	public long getGenelocusId() {
		return _genelocusId;
	}

	@Override
	public void setGenelocusId(long genelocusId) {
		_genelocusId = genelocusId;

		if (_geneLocusRemoteModel != null) {
			try {
				Class<?> clazz = _geneLocusRemoteModel.getClass();

				Method method = clazz.getMethod("setGenelocusId", long.class);

				method.invoke(_geneLocusRemoteModel, genelocusId);
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

		if (_geneLocusRemoteModel != null) {
			try {
				Class<?> clazz = _geneLocusRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneId", long.class);

				method.invoke(_geneLocusRemoteModel, geneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGenelocus() {
		return _genelocus;
	}

	@Override
	public void setGenelocus(String genelocus) {
		_genelocus = genelocus;

		if (_geneLocusRemoteModel != null) {
			try {
				Class<?> clazz = _geneLocusRemoteModel.getClass();

				Method method = clazz.getMethod("setGenelocus", String.class);

				method.invoke(_geneLocusRemoteModel, genelocus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGenelocuskey() {
		return _genelocuskey;
	}

	@Override
	public void setGenelocuskey(String genelocuskey) {
		_genelocuskey = genelocuskey;

		if (_geneLocusRemoteModel != null) {
			try {
				Class<?> clazz = _geneLocusRemoteModel.getClass();

				Method method = clazz.getMethod("setGenelocuskey", String.class);

				method.invoke(_geneLocusRemoteModel, genelocuskey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneLocusRemoteModel() {
		return _geneLocusRemoteModel;
	}

	public void setGeneLocusRemoteModel(BaseModel<?> geneLocusRemoteModel) {
		_geneLocusRemoteModel = geneLocusRemoteModel;
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

		Class<?> remoteModelClass = _geneLocusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geneLocusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneLocusLocalServiceUtil.addGeneLocus(this);
		}
		else {
			GeneLocusLocalServiceUtil.updateGeneLocus(this);
		}
	}

	@Override
	public GeneLocus toEscapedModel() {
		return (GeneLocus)ProxyUtil.newProxyInstance(GeneLocus.class.getClassLoader(),
			new Class[] { GeneLocus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneLocusClp clone = new GeneLocusClp();

		clone.setGenelocusId(getGenelocusId());
		clone.setGeneId(getGeneId());
		clone.setGenelocus(getGenelocus());
		clone.setGenelocuskey(getGenelocuskey());

		return clone;
	}

	@Override
	public int compareTo(GeneLocus geneLocus) {
		long primaryKey = geneLocus.getPrimaryKey();

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

		if (!(obj instanceof GeneLocusClp)) {
			return false;
		}

		GeneLocusClp geneLocus = (GeneLocusClp)obj;

		long primaryKey = geneLocus.getPrimaryKey();

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

		sb.append("{genelocusId=");
		sb.append(getGenelocusId());
		sb.append(", geneId=");
		sb.append(getGeneId());
		sb.append(", genelocus=");
		sb.append(getGenelocus());
		sb.append(", genelocuskey=");
		sb.append(getGenelocuskey());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>genelocusId</column-name><column-value><![CDATA[");
		sb.append(getGenelocusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geneId</column-name><column-value><![CDATA[");
		sb.append(getGeneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genelocus</column-name><column-value><![CDATA[");
		sb.append(getGenelocus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genelocuskey</column-name><column-value><![CDATA[");
		sb.append(getGenelocuskey());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _genelocusId;
	private long _geneId;
	private String _genelocus;
	private String _genelocuskey;
	private BaseModel<?> _geneLocusRemoteModel;
}