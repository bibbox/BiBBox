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
import com.inkwell.internet.productregistration.service.PRRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rich Sezov
 */
public class PRRegistrationClp extends BaseModelImpl<PRRegistration>
	implements PRRegistration {
	public PRRegistrationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PRRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return PRRegistration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _registrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _registrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registrationId", getRegistrationId());
		attributes.put("prUserId", getPrUserId());
		attributes.put("datePurchased", getDatePurchased());
		attributes.put("howHear", getHowHear());
		attributes.put("wherePurchased", getWherePurchased());
		attributes.put("serialNumber", getSerialNumber());
		attributes.put("productId", getProductId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		Long prUserId = (Long)attributes.get("prUserId");

		if (prUserId != null) {
			setPrUserId(prUserId);
		}

		Date datePurchased = (Date)attributes.get("datePurchased");

		if (datePurchased != null) {
			setDatePurchased(datePurchased);
		}

		String howHear = (String)attributes.get("howHear");

		if (howHear != null) {
			setHowHear(howHear);
		}

		String wherePurchased = (String)attributes.get("wherePurchased");

		if (wherePurchased != null) {
			setWherePurchased(wherePurchased);
		}

		String serialNumber = (String)attributes.get("serialNumber");

		if (serialNumber != null) {
			setSerialNumber(serialNumber);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
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
	public long getRegistrationId() {
		return _registrationId;
	}

	@Override
	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationId", long.class);

				method.invoke(_prRegistrationRemoteModel, registrationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrUserId() {
		return _prUserId;
	}

	@Override
	public void setPrUserId(long prUserId) {
		_prUserId = prUserId;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPrUserId", long.class);

				method.invoke(_prRegistrationRemoteModel, prUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getPrUserId(), "uuid", _prUserUuid);
	}

	@Override
	public void setPrUserUuid(String prUserUuid) {
		_prUserUuid = prUserUuid;
	}

	@Override
	public Date getDatePurchased() {
		return _datePurchased;
	}

	@Override
	public void setDatePurchased(Date datePurchased) {
		_datePurchased = datePurchased;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setDatePurchased", Date.class);

				method.invoke(_prRegistrationRemoteModel, datePurchased);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHowHear() {
		return _howHear;
	}

	@Override
	public void setHowHear(String howHear) {
		_howHear = howHear;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setHowHear", String.class);

				method.invoke(_prRegistrationRemoteModel, howHear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWherePurchased() {
		return _wherePurchased;
	}

	@Override
	public void setWherePurchased(String wherePurchased) {
		_wherePurchased = wherePurchased;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setWherePurchased",
						String.class);

				method.invoke(_prRegistrationRemoteModel, wherePurchased);
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

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setSerialNumber", String.class);

				method.invoke(_prRegistrationRemoteModel, serialNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_prRegistrationRemoteModel, productId);
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

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_prRegistrationRemoteModel, companyId);
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

		if (_prRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _prRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_prRegistrationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPRRegistrationRemoteModel() {
		return _prRegistrationRemoteModel;
	}

	public void setPRRegistrationRemoteModel(
		BaseModel<?> prRegistrationRemoteModel) {
		_prRegistrationRemoteModel = prRegistrationRemoteModel;
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

		Class<?> remoteModelClass = _prRegistrationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_prRegistrationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PRRegistrationLocalServiceUtil.addPRRegistration(this);
		}
		else {
			PRRegistrationLocalServiceUtil.updatePRRegistration(this);
		}
	}

	@Override
	public PRRegistration toEscapedModel() {
		return (PRRegistration)ProxyUtil.newProxyInstance(PRRegistration.class.getClassLoader(),
			new Class[] { PRRegistration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PRRegistrationClp clone = new PRRegistrationClp();

		clone.setRegistrationId(getRegistrationId());
		clone.setPrUserId(getPrUserId());
		clone.setDatePurchased(getDatePurchased());
		clone.setHowHear(getHowHear());
		clone.setWherePurchased(getWherePurchased());
		clone.setSerialNumber(getSerialNumber());
		clone.setProductId(getProductId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(PRRegistration prRegistration) {
		long primaryKey = prRegistration.getPrimaryKey();

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

		if (!(obj instanceof PRRegistrationClp)) {
			return false;
		}

		PRRegistrationClp prRegistration = (PRRegistrationClp)obj;

		long primaryKey = prRegistration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{registrationId=");
		sb.append(getRegistrationId());
		sb.append(", prUserId=");
		sb.append(getPrUserId());
		sb.append(", datePurchased=");
		sb.append(getDatePurchased());
		sb.append(", howHear=");
		sb.append(getHowHear());
		sb.append(", wherePurchased=");
		sb.append(getWherePurchased());
		sb.append(", serialNumber=");
		sb.append(getSerialNumber());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.inkwell.internet.productregistration.model.PRRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>registrationId</column-name><column-value><![CDATA[");
		sb.append(getRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prUserId</column-name><column-value><![CDATA[");
		sb.append(getPrUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datePurchased</column-name><column-value><![CDATA[");
		sb.append(getDatePurchased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>howHear</column-name><column-value><![CDATA[");
		sb.append(getHowHear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wherePurchased</column-name><column-value><![CDATA[");
		sb.append(getWherePurchased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialNumber</column-name><column-value><![CDATA[");
		sb.append(getSerialNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
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

	private long _registrationId;
	private long _prUserId;
	private String _prUserUuid;
	private Date _datePurchased;
	private String _howHear;
	private String _wherePurchased;
	private String _serialNumber;
	private long _productId;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _prRegistrationRemoteModel;
}