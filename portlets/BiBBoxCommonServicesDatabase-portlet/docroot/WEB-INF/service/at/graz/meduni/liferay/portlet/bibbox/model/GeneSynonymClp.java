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
import at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymLocalServiceUtil;

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
public class GeneSynonymClp extends BaseModelImpl<GeneSynonym>
	implements GeneSynonym {
	public GeneSynonymClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GeneSynonym.class;
	}

	@Override
	public String getModelClassName() {
		return GeneSynonym.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _genesynonymId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGenesynonymId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _genesynonymId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genesynonymId", getGenesynonymId());
		attributes.put("geneId", getGeneId());
		attributes.put("synonym", getSynonym());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genesynonymId = (Long)attributes.get("genesynonymId");

		if (genesynonymId != null) {
			setGenesynonymId(genesynonymId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}
	}

	@Override
	public long getGenesynonymId() {
		return _genesynonymId;
	}

	@Override
	public void setGenesynonymId(long genesynonymId) {
		_genesynonymId = genesynonymId;

		if (_geneSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _geneSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setGenesynonymId", long.class);

				method.invoke(_geneSynonymRemoteModel, genesynonymId);
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

		if (_geneSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _geneSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneId", long.class);

				method.invoke(_geneSynonymRemoteModel, geneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSynonym() {
		return _synonym;
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;

		if (_geneSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _geneSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setSynonym", String.class);

				method.invoke(_geneSynonymRemoteModel, synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneSynonymRemoteModel() {
		return _geneSynonymRemoteModel;
	}

	public void setGeneSynonymRemoteModel(BaseModel<?> geneSynonymRemoteModel) {
		_geneSynonymRemoteModel = geneSynonymRemoteModel;
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

		Class<?> remoteModelClass = _geneSynonymRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geneSynonymRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneSynonymLocalServiceUtil.addGeneSynonym(this);
		}
		else {
			GeneSynonymLocalServiceUtil.updateGeneSynonym(this);
		}
	}

	@Override
	public GeneSynonym toEscapedModel() {
		return (GeneSynonym)ProxyUtil.newProxyInstance(GeneSynonym.class.getClassLoader(),
			new Class[] { GeneSynonym.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneSynonymClp clone = new GeneSynonymClp();

		clone.setGenesynonymId(getGenesynonymId());
		clone.setGeneId(getGeneId());
		clone.setSynonym(getSynonym());

		return clone;
	}

	@Override
	public int compareTo(GeneSynonym geneSynonym) {
		long primaryKey = geneSynonym.getPrimaryKey();

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

		if (!(obj instanceof GeneSynonymClp)) {
			return false;
		}

		GeneSynonymClp geneSynonym = (GeneSynonymClp)obj;

		long primaryKey = geneSynonym.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{genesynonymId=");
		sb.append(getGenesynonymId());
		sb.append(", geneId=");
		sb.append(getGeneId());
		sb.append(", synonym=");
		sb.append(getSynonym());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>genesynonymId</column-name><column-value><![CDATA[");
		sb.append(getGenesynonymId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geneId</column-name><column-value><![CDATA[");
		sb.append(getGeneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synonym</column-name><column-value><![CDATA[");
		sb.append(getSynonym());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _genesynonymId;
	private long _geneId;
	private String _synonym;
	private BaseModel<?> _geneSynonymRemoteModel;
}