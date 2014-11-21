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

package com.bcnet.portlet.biobank.model;

import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.ClpSerializer;

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
 * @author suyama
 */
public class BiobankAttributeListsClp extends BaseModelImpl<BiobankAttributeLists>
	implements BiobankAttributeLists {
	public BiobankAttributeListsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankAttributeLists.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankAttributeLists.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _biobankAttributeListsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankAttributeListsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankAttributeListsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankAttributeListsId", getBiobankAttributeListsId());
		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankAttributeListsId = (Long)attributes.get(
				"biobankAttributeListsId");

		if (biobankAttributeListsId != null) {
			setBiobankAttributeListsId(biobankAttributeListsId);
		}

		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String attributeListName = (String)attributes.get("attributeListName");

		if (attributeListName != null) {
			setAttributeListName(attributeListName);
		}

		String attributeListValue = (String)attributes.get("attributeListValue");

		if (attributeListValue != null) {
			setAttributeListValue(attributeListValue);
		}
	}

	@Override
	public long getBiobankAttributeListsId() {
		return _biobankAttributeListsId;
	}

	@Override
	public void setBiobankAttributeListsId(long biobankAttributeListsId) {
		_biobankAttributeListsId = biobankAttributeListsId;

		if (_biobankAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankAttributeListsId",
						long.class);

				method.invoke(_biobankAttributeListsRemoteModel,
					biobankAttributeListsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiobankDbId() {
		return _biobankDbId;
	}

	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;

		if (_biobankAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankDbId", long.class);

				method.invoke(_biobankAttributeListsRemoteModel, biobankDbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttributeListName() {
		return _attributeListName;
	}

	@Override
	public void setAttributeListName(String attributeListName) {
		_attributeListName = attributeListName;

		if (_biobankAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListName",
						String.class);

				method.invoke(_biobankAttributeListsRemoteModel,
					attributeListName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttributeListValue() {
		return _attributeListValue;
	}

	@Override
	public void setAttributeListValue(String attributeListValue) {
		_attributeListValue = attributeListValue;

		if (_biobankAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListValue",
						String.class);

				method.invoke(_biobankAttributeListsRemoteModel,
					attributeListValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBiobankAttributeListsRemoteModel() {
		return _biobankAttributeListsRemoteModel;
	}

	public void setBiobankAttributeListsRemoteModel(
		BaseModel<?> biobankAttributeListsRemoteModel) {
		_biobankAttributeListsRemoteModel = biobankAttributeListsRemoteModel;
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

		Class<?> remoteModelClass = _biobankAttributeListsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_biobankAttributeListsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiobankAttributeListsLocalServiceUtil.addBiobankAttributeLists(this);
		}
		else {
			BiobankAttributeListsLocalServiceUtil.updateBiobankAttributeLists(this);
		}
	}

	@Override
	public BiobankAttributeLists toEscapedModel() {
		return (BiobankAttributeLists)ProxyUtil.newProxyInstance(BiobankAttributeLists.class.getClassLoader(),
			new Class[] { BiobankAttributeLists.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiobankAttributeListsClp clone = new BiobankAttributeListsClp();

		clone.setBiobankAttributeListsId(getBiobankAttributeListsId());
		clone.setBiobankDbId(getBiobankDbId());
		clone.setAttributeListName(getAttributeListName());
		clone.setAttributeListValue(getAttributeListValue());

		return clone;
	}

	@Override
	public int compareTo(BiobankAttributeLists biobankAttributeLists) {
		long primaryKey = biobankAttributeLists.getPrimaryKey();

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

		if (!(obj instanceof BiobankAttributeListsClp)) {
			return false;
		}

		BiobankAttributeListsClp biobankAttributeLists = (BiobankAttributeListsClp)obj;

		long primaryKey = biobankAttributeLists.getPrimaryKey();

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

		sb.append("{biobankAttributeListsId=");
		sb.append(getBiobankAttributeListsId());
		sb.append(", biobankDbId=");
		sb.append(getBiobankDbId());
		sb.append(", attributeListName=");
		sb.append(getAttributeListName());
		sb.append(", attributeListValue=");
		sb.append(getAttributeListValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.BiobankAttributeLists");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankAttributeListsId</column-name><column-value><![CDATA[");
		sb.append(getBiobankAttributeListsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankDbId</column-name><column-value><![CDATA[");
		sb.append(getBiobankDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeListName</column-name><column-value><![CDATA[");
		sb.append(getAttributeListName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeListValue</column-name><column-value><![CDATA[");
		sb.append(getAttributeListValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biobankAttributeListsId;
	private long _biobankDbId;
	private String _attributeListName;
	private String _attributeListValue;
	private BaseModel<?> _biobankAttributeListsRemoteModel;
}