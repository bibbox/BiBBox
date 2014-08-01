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

package com.inkwell.internet.productregistration.model;

import com.inkwell.internet.productregistration.service.ClpSerializer;
import com.inkwell.internet.productregistration.service.PRProductLocalServiceUtil;

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
 * @author Rich Sezov
 */
public class PRProductClp extends BaseModelImpl<PRProduct> implements PRProduct {
	public PRProductClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PRProduct.class;
	}

	@Override
	public String getModelClassName() {
		return PRProduct.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _productId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("productName", getProductName());
		attributes.put("serialNumber", getSerialNumber());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String serialNumber = (String)attributes.get("serialNumber");

		if (serialNumber != null) {
			setSerialNumber(serialNumber);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_prProductRemoteModel != null) {
			try {
				Class<?> clazz = _prProductRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_prProductRemoteModel, productId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductName() {
		return _productName;
	}

	@Override
	public void setProductName(String productName) {
		_productName = productName;

		if (_prProductRemoteModel != null) {
			try {
				Class<?> clazz = _prProductRemoteModel.getClass();

				Method method = clazz.getMethod("setProductName", String.class);

				method.invoke(_prProductRemoteModel, productName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSerialNumber() {
		return _serialNumber;
	}

	@Override
	public void setSerialNumber(String serialNumber) {
		_serialNumber = serialNumber;

		if (_prProductRemoteModel != null) {
			try {
				Class<?> clazz = _prProductRemoteModel.getClass();

				Method method = clazz.getMethod("setSerialNumber", String.class);

				method.invoke(_prProductRemoteModel, serialNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_prProductRemoteModel != null) {
			try {
				Class<?> clazz = _prProductRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_prProductRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_prProductRemoteModel != null) {
			try {
				Class<?> clazz = _prProductRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_prProductRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPRProductRemoteModel() {
		return _prProductRemoteModel;
	}

	public void setPRProductRemoteModel(BaseModel<?> prProductRemoteModel) {
		_prProductRemoteModel = prProductRemoteModel;
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

		Class<?> remoteModelClass = _prProductRemoteModel.getClass();

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

		Object returnValue = method.invoke(_prProductRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PRProductLocalServiceUtil.addPRProduct(this);
		}
		else {
			PRProductLocalServiceUtil.updatePRProduct(this);
		}
	}

	@Override
	public PRProduct toEscapedModel() {
		return (PRProduct)ProxyUtil.newProxyInstance(PRProduct.class.getClassLoader(),
			new Class[] { PRProduct.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PRProductClp clone = new PRProductClp();

		clone.setProductId(getProductId());
		clone.setProductName(getProductName());
		clone.setSerialNumber(getSerialNumber());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(PRProduct prProduct) {
		int value = 0;

		value = getProductName().compareTo(prProduct.getProductName());

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

		if (!(obj instanceof PRProductClp)) {
			return false;
		}

		PRProductClp prProduct = (PRProductClp)obj;

		long primaryKey = prProduct.getPrimaryKey();

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

		sb.append("{productId=");
		sb.append(getProductId());
		sb.append(", productName=");
		sb.append(getProductName());
		sb.append(", serialNumber=");
		sb.append(getSerialNumber());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.inkwell.internet.productregistration.model.PRProduct");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productName</column-name><column-value><![CDATA[");
		sb.append(getProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialNumber</column-name><column-value><![CDATA[");
		sb.append(getSerialNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _productId;
	private String _productName;
	private String _serialNumber;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _prProductRemoteModel;
}