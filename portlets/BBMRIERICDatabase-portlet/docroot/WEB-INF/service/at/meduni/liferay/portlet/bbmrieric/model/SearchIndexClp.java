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

package at.meduni.liferay.portlet.bbmrieric.model;

import at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;

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
public class SearchIndexClp extends BaseModelImpl<SearchIndex>
	implements SearchIndex {
	public SearchIndexClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SearchIndex.class;
	}

	@Override
	public String getModelClassName() {
		return SearchIndex.class.getName();
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
		attributes.put("searchindexkey", getSearchindexkey());
		attributes.put("searchindexvalue", getSearchindexvalue());
		attributes.put("UUID", getUUID());

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

		String searchindexkey = (String)attributes.get("searchindexkey");

		if (searchindexkey != null) {
			setSearchindexkey(searchindexkey);
		}

		String searchindexvalue = (String)attributes.get("searchindexvalue");

		if (searchindexvalue != null) {
			setSearchindexvalue(searchindexvalue);
		}

		String UUID = (String)attributes.get("UUID");

		if (UUID != null) {
			setUUID(UUID);
		}
	}

	@Override
	public long getSearchid() {
		return _searchid;
	}

	@Override
	public void setSearchid(long searchid) {
		_searchid = searchid;

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchid", long.class);

				method.invoke(_searchIndexRemoteModel, searchid);
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

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationid", long.class);

				method.invoke(_searchIndexRemoteModel, organisationid);
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

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationid", long.class);

				method.invoke(_searchIndexRemoteModel, locationid);
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

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_searchIndexRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchindexkey() {
		return _searchindexkey;
	}

	@Override
	public void setSearchindexkey(String searchindexkey) {
		_searchindexkey = searchindexkey;

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchindexkey",
						String.class);

				method.invoke(_searchIndexRemoteModel, searchindexkey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchindexvalue() {
		return _searchindexvalue;
	}

	@Override
	public void setSearchindexvalue(String searchindexvalue) {
		_searchindexvalue = searchindexvalue;

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchindexvalue",
						String.class);

				method.invoke(_searchIndexRemoteModel, searchindexvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUUID() {
		return _UUID;
	}

	@Override
	public void setUUID(String UUID) {
		_UUID = UUID;

		if (_searchIndexRemoteModel != null) {
			try {
				Class<?> clazz = _searchIndexRemoteModel.getClass();

				Method method = clazz.getMethod("setUUID", String.class);

				method.invoke(_searchIndexRemoteModel, UUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSearchIndexRemoteModel() {
		return _searchIndexRemoteModel;
	}

	public void setSearchIndexRemoteModel(BaseModel<?> searchIndexRemoteModel) {
		_searchIndexRemoteModel = searchIndexRemoteModel;
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

		Class<?> remoteModelClass = _searchIndexRemoteModel.getClass();

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

		Object returnValue = method.invoke(_searchIndexRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SearchIndexLocalServiceUtil.addSearchIndex(this);
		}
		else {
			SearchIndexLocalServiceUtil.updateSearchIndex(this);
		}
	}

	@Override
	public SearchIndex toEscapedModel() {
		return (SearchIndex)ProxyUtil.newProxyInstance(SearchIndex.class.getClassLoader(),
			new Class[] { SearchIndex.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SearchIndexClp clone = new SearchIndexClp();

		clone.setSearchid(getSearchid());
		clone.setOrganisationid(getOrganisationid());
		clone.setLocationid(getLocationid());
		clone.setLocation(getLocation());
		clone.setSearchindexkey(getSearchindexkey());
		clone.setSearchindexvalue(getSearchindexvalue());
		clone.setUUID(getUUID());

		return clone;
	}

	@Override
	public int compareTo(SearchIndex searchIndex) {
		long primaryKey = searchIndex.getPrimaryKey();

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

		if (!(obj instanceof SearchIndexClp)) {
			return false;
		}

		SearchIndexClp searchIndex = (SearchIndexClp)obj;

		long primaryKey = searchIndex.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{searchid=");
		sb.append(getSearchid());
		sb.append(", organisationid=");
		sb.append(getOrganisationid());
		sb.append(", locationid=");
		sb.append(getLocationid());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", searchindexkey=");
		sb.append(getSearchindexkey());
		sb.append(", searchindexvalue=");
		sb.append(getSearchindexvalue());
		sb.append(", UUID=");
		sb.append(getUUID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.model.SearchIndex");
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
			"<column><column-name>searchindexkey</column-name><column-value><![CDATA[");
		sb.append(getSearchindexkey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchindexvalue</column-name><column-value><![CDATA[");
		sb.append(getSearchindexvalue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UUID</column-name><column-value><![CDATA[");
		sb.append(getUUID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _searchid;
	private long _organisationid;
	private long _locationid;
	private String _location;
	private String _searchindexkey;
	private String _searchindexvalue;
	private String _UUID;
	private BaseModel<?> _searchIndexRemoteModel;
}