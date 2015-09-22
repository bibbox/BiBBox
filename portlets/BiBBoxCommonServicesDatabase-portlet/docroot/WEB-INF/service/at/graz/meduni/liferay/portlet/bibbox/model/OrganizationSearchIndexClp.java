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
import at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalServiceUtil;

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
public class OrganizationSearchIndexClp extends BaseModelImpl<OrganizationSearchIndex>
	implements OrganizationSearchIndex {
	public OrganizationSearchIndexClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizationSearchIndex.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizationSearchIndex.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _searchid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSearchid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("searchid", getSearchid());
		attributes.put("organisationid", getOrganisationid());
		attributes.put("locationid", getLocationid());
		attributes.put("location", getLocation());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long searchid = (Long)attributes.get("searchid");

		if (searchid != null) {
			setSearchid(searchid);
		}

		Long organisationid = (Long)attributes.get("organisationid");

		if (organisationid != null) {
			setOrganisationid(organisationid);
		}

		Long locationid = (Long)attributes.get("locationid");

		if (locationid != null) {
			setLocationid(locationid);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getSearchid() {
		return _searchid;
	}

	@Override
	public void setSearchid(long searchid) {
		_searchid = searchid;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchid", long.class);

				method.invoke(_organizationSearchIndexRemoteModel, searchid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganisationid() {
		return _organisationid;
	}

	@Override
	public void setOrganisationid(long organisationid) {
		_organisationid = organisationid;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationid", long.class);

				method.invoke(_organizationSearchIndexRemoteModel,
					organisationid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationid() {
		return _locationid;
	}

	@Override
	public void setLocationid(long locationid) {
		_locationid = locationid;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationid", long.class);

				method.invoke(_organizationSearchIndexRemoteModel, locationid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_organizationSearchIndexRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public void setKey(String key) {
		_key = key;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setKey", String.class);

				method.invoke(_organizationSearchIndexRemoteModel, key);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_organizationSearchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _organizationSearchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_organizationSearchIndexRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrganizationSearchIndexRemoteModel() {
		return _organizationSearchIndexRemoteModel;
	}

	public void setOrganizationSearchIndexRemoteModel(
		BaseModel<?> organizationSearchIndexRemoteModel) {
		_organizationSearchIndexRemoteModel = organizationSearchIndexRemoteModel;
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

		Class<?> remoteModelClass = _organizationSearchIndexRemoteModel.getClass();

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

		Object returnValue = method.invoke(_organizationSearchIndexRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationSearchIndexLocalServiceUtil.addOrganizationSearchIndex(this);
		}
		else {
			OrganizationSearchIndexLocalServiceUtil.updateOrganizationSearchIndex(this);
		}
	}

	@Override
	public OrganizationSearchIndex toEscapedModel() {
		return (OrganizationSearchIndex)ProxyUtil.newProxyInstance(OrganizationSearchIndex.class.getClassLoader(),
			new Class[] { OrganizationSearchIndex.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationSearchIndexClp clone = new OrganizationSearchIndexClp();

		clone.setSearchid(getSearchid());
		clone.setOrganisationid(getOrganisationid());
		clone.setLocationid(getLocationid());
		clone.setLocation(getLocation());
		clone.setKey(getKey());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(OrganizationSearchIndex organizationSearchIndex) {
		long primaryKey = organizationSearchIndex.getPrimaryKey();

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

		if (!(obj instanceof OrganizationSearchIndexClp)) {
			return false;
		}

		OrganizationSearchIndexClp organizationSearchIndex = (OrganizationSearchIndexClp)obj;

		long primaryKey = organizationSearchIndex.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{searchid=");
		sb.append(getSearchid());
		sb.append(", organisationid=");
		sb.append(getOrganisationid());
		sb.append(", locationid=");
		sb.append(getLocationid());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>searchid</column-name><column-value><![CDATA[");
		sb.append(getSearchid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organisationid</column-name><column-value><![CDATA[");
		sb.append(getOrganisationid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationid</column-name><column-value><![CDATA[");
		sb.append(getLocationid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _searchid;
	private long _organisationid;
	private long _locationid;
	private String _location;
	private String _key;
	private String _value;
	private BaseModel<?> _organizationSearchIndexRemoteModel;
}