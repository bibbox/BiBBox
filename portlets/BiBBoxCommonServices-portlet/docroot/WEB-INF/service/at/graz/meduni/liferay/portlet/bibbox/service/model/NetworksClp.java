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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil;

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
public class NetworksClp extends BaseModelImpl<Networks> implements Networks {
	public NetworksClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Networks.class;
	}

	@Override
	public String getModelClassName() {
		return Networks.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _networkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNetworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _networkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("networkId", getNetworkId());
		attributes.put("organizationnetworkId", getOrganizationnetworkId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("relation", getRelation());
		attributes.put("yearofestablishment", getYearofestablishment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long networkId = (Long)attributes.get("networkId");

		if (networkId != null) {
			setNetworkId(networkId);
		}

		Long organizationnetworkId = (Long)attributes.get(
				"organizationnetworkId");

		if (organizationnetworkId != null) {
			setOrganizationnetworkId(organizationnetworkId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String relation = (String)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
		}

		String yearofestablishment = (String)attributes.get(
				"yearofestablishment");

		if (yearofestablishment != null) {
			setYearofestablishment(yearofestablishment);
		}
	}

	@Override
	public long getNetworkId() {
		return _networkId;
	}

	@Override
	public void setNetworkId(long networkId) {
		_networkId = networkId;

		if (_networksRemoteModel != null) {
			try {
				Class<?> clazz = _networksRemoteModel.getClass();

				Method method = clazz.getMethod("setNetworkId", long.class);

				method.invoke(_networksRemoteModel, networkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationnetworkId() {
		return _organizationnetworkId;
	}

	@Override
	public void setOrganizationnetworkId(long organizationnetworkId) {
		_organizationnetworkId = organizationnetworkId;

		if (_networksRemoteModel != null) {
			try {
				Class<?> clazz = _networksRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationnetworkId",
						long.class);

				method.invoke(_networksRemoteModel, organizationnetworkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_networksRemoteModel != null) {
			try {
				Class<?> clazz = _networksRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_networksRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRelation() {
		return _relation;
	}

	@Override
	public void setRelation(String relation) {
		_relation = relation;

		if (_networksRemoteModel != null) {
			try {
				Class<?> clazz = _networksRemoteModel.getClass();

				Method method = clazz.getMethod("setRelation", String.class);

				method.invoke(_networksRemoteModel, relation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYearofestablishment() {
		return _yearofestablishment;
	}

	@Override
	public void setYearofestablishment(String yearofestablishment) {
		_yearofestablishment = yearofestablishment;

		if (_networksRemoteModel != null) {
			try {
				Class<?> clazz = _networksRemoteModel.getClass();

				Method method = clazz.getMethod("setYearofestablishment",
						String.class);

				method.invoke(_networksRemoteModel, yearofestablishment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNetworksRemoteModel() {
		return _networksRemoteModel;
	}

	public void setNetworksRemoteModel(BaseModel<?> networksRemoteModel) {
		_networksRemoteModel = networksRemoteModel;
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

		Class<?> remoteModelClass = _networksRemoteModel.getClass();

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

		Object returnValue = method.invoke(_networksRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NetworksLocalServiceUtil.addNetworks(this);
		}
		else {
			NetworksLocalServiceUtil.updateNetworks(this);
		}
	}

	@Override
	public Networks toEscapedModel() {
		return (Networks)ProxyUtil.newProxyInstance(Networks.class.getClassLoader(),
			new Class[] { Networks.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NetworksClp clone = new NetworksClp();

		clone.setNetworkId(getNetworkId());
		clone.setOrganizationnetworkId(getOrganizationnetworkId());
		clone.setOrganizationId(getOrganizationId());
		clone.setRelation(getRelation());
		clone.setYearofestablishment(getYearofestablishment());

		return clone;
	}

	@Override
	public int compareTo(Networks networks) {
		long primaryKey = networks.getPrimaryKey();

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

		if (!(obj instanceof NetworksClp)) {
			return false;
		}

		NetworksClp networks = (NetworksClp)obj;

		long primaryKey = networks.getPrimaryKey();

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

		sb.append("{networkId=");
		sb.append(getNetworkId());
		sb.append(", organizationnetworkId=");
		sb.append(getOrganizationnetworkId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", relation=");
		sb.append(getRelation());
		sb.append(", yearofestablishment=");
		sb.append(getYearofestablishment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.Networks");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>networkId</column-name><column-value><![CDATA[");
		sb.append(getNetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationnetworkId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationnetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relation</column-name><column-value><![CDATA[");
		sb.append(getRelation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearofestablishment</column-name><column-value><![CDATA[");
		sb.append(getYearofestablishment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _networkId;
	private long _organizationnetworkId;
	private long _organizationId;
	private String _relation;
	private String _yearofestablishment;
	private BaseModel<?> _networksRemoteModel;
}