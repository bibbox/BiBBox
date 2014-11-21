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

import com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil;
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
public class BiobankClp extends BaseModelImpl<Biobank> implements Biobank {
	public BiobankClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Biobank.class;
	}

	@Override
	public String getModelClassName() {
		return Biobank.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _biobankDbId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankDbId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankDbId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("biobankId", getBiobankId());
		attributes.put("acronym", getAcronym());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("juristicPersonId", getJuristicPersonId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("description", getDescription());
		attributes.put("backup", getBackup());
		attributes.put("trainingCourses", getTrainingCourses());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String biobankId = (String)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long juristicPersonId = (Long)attributes.get("juristicPersonId");

		if (juristicPersonId != null) {
			setJuristicPersonId(juristicPersonId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean backup = (Boolean)attributes.get("backup");

		if (backup != null) {
			setBackup(backup);
		}

		Boolean trainingCourses = (Boolean)attributes.get("trainingCourses");

		if (trainingCourses != null) {
			setTrainingCourses(trainingCourses);
		}
	}

	@Override
	public long getBiobankDbId() {
		return _biobankDbId;
	}

	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankDbId", long.class);

				method.invoke(_biobankRemoteModel, biobankDbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankId() {
		return _biobankId;
	}

	@Override
	public void setBiobankId(String biobankId) {
		_biobankId = biobankId;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankId", String.class);

				method.invoke(_biobankRemoteModel, biobankId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAcronym() {
		return _acronym;
	}

	@Override
	public void setAcronym(String acronym) {
		_acronym = acronym;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setAcronym", String.class);

				method.invoke(_biobankRemoteModel, acronym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_biobankRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_biobankRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJuristicPersonId() {
		return _juristicPersonId;
	}

	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPersonId = juristicPersonId;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setJuristicPersonId",
						long.class);

				method.invoke(_biobankRemoteModel, juristicPersonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_biobankRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_biobankRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBackup() {
		return _backup;
	}

	@Override
	public boolean isBackup() {
		return _backup;
	}

	@Override
	public void setBackup(boolean backup) {
		_backup = backup;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBackup", boolean.class);

				method.invoke(_biobankRemoteModel, backup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTrainingCourses() {
		return _trainingCourses;
	}

	@Override
	public boolean isTrainingCourses() {
		return _trainingCourses;
	}

	@Override
	public void setTrainingCourses(boolean trainingCourses) {
		_trainingCourses = trainingCourses;

		if (_biobankRemoteModel != null) {
			try {
				Class<?> clazz = _biobankRemoteModel.getClass();

				Method method = clazz.getMethod("setTrainingCourses",
						boolean.class);

				method.invoke(_biobankRemoteModel, trainingCourses);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBiobankRemoteModel() {
		return _biobankRemoteModel;
	}

	public void setBiobankRemoteModel(BaseModel<?> biobankRemoteModel) {
		_biobankRemoteModel = biobankRemoteModel;
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

		Class<?> remoteModelClass = _biobankRemoteModel.getClass();

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

		Object returnValue = method.invoke(_biobankRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiobankLocalServiceUtil.addBiobank(this);
		}
		else {
			BiobankLocalServiceUtil.updateBiobank(this);
		}
	}

	@Override
	public Biobank toEscapedModel() {
		return (Biobank)ProxyUtil.newProxyInstance(Biobank.class.getClassLoader(),
			new Class[] { Biobank.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiobankClp clone = new BiobankClp();

		clone.setBiobankDbId(getBiobankDbId());
		clone.setBiobankId(getBiobankId());
		clone.setAcronym(getAcronym());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setJuristicPersonId(getJuristicPersonId());
		clone.setCountryCode(getCountryCode());
		clone.setDescription(getDescription());
		clone.setBackup(getBackup());
		clone.setTrainingCourses(getTrainingCourses());

		return clone;
	}

	@Override
	public int compareTo(Biobank biobank) {
		long primaryKey = biobank.getPrimaryKey();

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

		if (!(obj instanceof BiobankClp)) {
			return false;
		}

		BiobankClp biobank = (BiobankClp)obj;

		long primaryKey = biobank.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{biobankDbId=");
		sb.append(getBiobankDbId());
		sb.append(", biobankId=");
		sb.append(getBiobankId());
		sb.append(", acronym=");
		sb.append(getAcronym());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", juristicPersonId=");
		sb.append(getJuristicPersonId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", backup=");
		sb.append(getBackup());
		sb.append(", trainingCourses=");
		sb.append(getTrainingCourses());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.Biobank");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankDbId</column-name><column-value><![CDATA[");
		sb.append(getBiobankDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankId</column-name><column-value><![CDATA[");
		sb.append(getBiobankId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acronym</column-name><column-value><![CDATA[");
		sb.append(getAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>juristicPersonId</column-name><column-value><![CDATA[");
		sb.append(getJuristicPersonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backup</column-name><column-value><![CDATA[");
		sb.append(getBackup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trainingCourses</column-name><column-value><![CDATA[");
		sb.append(getTrainingCourses());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biobankDbId;
	private String _biobankId;
	private String _acronym;
	private String _name;
	private String _url;
	private long _juristicPersonId;
	private String _countryCode;
	private String _description;
	private boolean _backup;
	private boolean _trainingCourses;
	private BaseModel<?> _biobankRemoteModel;
}