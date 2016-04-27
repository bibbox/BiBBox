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

package at.graz.meduni.liferay.portlet.saat.model;

import at.graz.meduni.liferay.portlet.saat.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalServiceUtil;

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
public class DictionaryDictionaryLinkClp extends BaseModelImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLink {
	public DictionaryDictionaryLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictionary_dictionary_addiction_linkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionary_dictionary_addiction_linkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionary_dictionary_addiction_linkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionary_dictionary_addiction_linkId",
			getDictionary_dictionary_addiction_linkId());
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("addictionId", getAddictionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionary_dictionary_addiction_linkId = (Long)attributes.get(
				"dictionary_dictionary_addiction_linkId");

		if (dictionary_dictionary_addiction_linkId != null) {
			setDictionary_dictionary_addiction_linkId(dictionary_dictionary_addiction_linkId);
		}

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long addictionId = (Long)attributes.get("addictionId");

		if (addictionId != null) {
			setAddictionId(addictionId);
		}
	}

	@Override
	public long getDictionary_dictionary_addiction_linkId() {
		return _dictionary_dictionary_addiction_linkId;
	}

	@Override
	public void setDictionary_dictionary_addiction_linkId(
		long dictionary_dictionary_addiction_linkId) {
		_dictionary_dictionary_addiction_linkId = dictionary_dictionary_addiction_linkId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionary_dictionary_addiction_linkId",
						long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel,
					dictionary_dictionary_addiction_linkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, dictionaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAddictionId() {
		return _addictionId;
	}

	@Override
	public void setAddictionId(long addictionId) {
		_addictionId = addictionId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setAddictionId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, addictionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictionaryDictionaryLinkRemoteModel() {
		return _dictionaryDictionaryLinkRemoteModel;
	}

	public void setDictionaryDictionaryLinkRemoteModel(
		BaseModel<?> dictionaryDictionaryLinkRemoteModel) {
		_dictionaryDictionaryLinkRemoteModel = dictionaryDictionaryLinkRemoteModel;
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

		Class<?> remoteModelClass = _dictionaryDictionaryLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictionaryDictionaryLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictionaryDictionaryLinkLocalServiceUtil.addDictionaryDictionaryLink(this);
		}
		else {
			DictionaryDictionaryLinkLocalServiceUtil.updateDictionaryDictionaryLink(this);
		}
	}

	@Override
	public DictionaryDictionaryLink toEscapedModel() {
		return (DictionaryDictionaryLink)ProxyUtil.newProxyInstance(DictionaryDictionaryLink.class.getClassLoader(),
			new Class[] { DictionaryDictionaryLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictionaryDictionaryLinkClp clone = new DictionaryDictionaryLinkClp();

		clone.setDictionary_dictionary_addiction_linkId(getDictionary_dictionary_addiction_linkId());
		clone.setDictionaryId(getDictionaryId());
		clone.setAddictionId(getAddictionId());

		return clone;
	}

	@Override
	public int compareTo(DictionaryDictionaryLink dictionaryDictionaryLink) {
		int value = 0;

		if (getDictionary_dictionary_addiction_linkId() < dictionaryDictionaryLink.getDictionary_dictionary_addiction_linkId()) {
			value = -1;
		}
		else if (getDictionary_dictionary_addiction_linkId() > dictionaryDictionaryLink.getDictionary_dictionary_addiction_linkId()) {
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

		if (!(obj instanceof DictionaryDictionaryLinkClp)) {
			return false;
		}

		DictionaryDictionaryLinkClp dictionaryDictionaryLink = (DictionaryDictionaryLinkClp)obj;

		long primaryKey = dictionaryDictionaryLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{dictionary_dictionary_addiction_linkId=");
		sb.append(getDictionary_dictionary_addiction_linkId());
		sb.append(", dictionaryId=");
		sb.append(getDictionaryId());
		sb.append(", addictionId=");
		sb.append(getAddictionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictionary_dictionary_addiction_linkId</column-name><column-value><![CDATA[");
		sb.append(getDictionary_dictionary_addiction_linkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addictionId</column-name><column-value><![CDATA[");
		sb.append(getAddictionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictionary_dictionary_addiction_linkId;
	private long _dictionaryId;
	private long _addictionId;
	private BaseModel<?> _dictionaryDictionaryLinkRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.class;
}