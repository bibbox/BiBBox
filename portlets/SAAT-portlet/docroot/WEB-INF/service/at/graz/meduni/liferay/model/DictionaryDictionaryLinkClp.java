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

package at.graz.meduni.liferay.model;

import at.graz.meduni.liferay.service.ClpSerializer;
import at.graz.meduni.liferay.service.DictionaryDictionaryLinkLocalServiceUtil;

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
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("dictionary_id", getDictionary_id());
		attributes.put("addiction_id", getAddiction_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long dictionary_id = (Long)attributes.get("dictionary_id");

		if (dictionary_id != null) {
			setDictionary_id(dictionary_id);
		}

		Long addiction_id = (Long)attributes.get("addiction_id");

		if (addiction_id != null) {
			setAddiction_id(addiction_id);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictionary_id() {
		return _dictionary_id;
	}

	@Override
	public void setDictionary_id(long dictionary_id) {
		_dictionary_id = dictionary_id;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionary_id", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel,
					dictionary_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAddiction_id() {
		return _addiction_id;
	}

	@Override
	public void setAddiction_id(long addiction_id) {
		_addiction_id = addiction_id;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setAddiction_id", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, addiction_id);
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

		clone.setId(getId());
		clone.setDictionary_id(getDictionary_id());
		clone.setAddiction_id(getAddiction_id());

		return clone;
	}

	@Override
	public int compareTo(DictionaryDictionaryLink dictionaryDictionaryLink) {
		int value = 0;

		if (getId() < dictionaryDictionaryLink.getId()) {
			value = -1;
		}
		else if (getId() > dictionaryDictionaryLink.getId()) {
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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", dictionary_id=");
		sb.append(getDictionary_id());
		sb.append(", addiction_id=");
		sb.append(getAddiction_id());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.model.DictionaryDictionaryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictionary_id</column-name><column-value><![CDATA[");
		sb.append(getDictionary_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addiction_id</column-name><column-value><![CDATA[");
		sb.append(getAddiction_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _dictionary_id;
	private long _addiction_id;
	private BaseModel<?> _dictionaryDictionaryLinkRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.service.ClpSerializer.class;
}