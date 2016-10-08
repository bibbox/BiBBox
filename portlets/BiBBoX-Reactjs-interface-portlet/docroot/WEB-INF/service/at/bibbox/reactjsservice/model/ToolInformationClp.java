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

package at.bibbox.reactjsservice.model;

import at.bibbox.reactjsservice.service.ClpSerializer;
import at.bibbox.reactjsservice.service.ToolInformationLocalServiceUtil;

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
public class ToolInformationClp extends BaseModelImpl<ToolInformation>
	implements ToolInformation {
	public ToolInformationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ToolInformation.class;
	}

	@Override
	public String getModelClassName() {
		return ToolInformation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _toolInformationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setToolInformationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _toolInformationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("toolInformationId", getToolInformationId());
		attributes.put("gitUUID", getGitUUID());
		attributes.put("logourl", getLogourl());
		attributes.put("name", getName());
		attributes.put("category", getCategory());
		attributes.put("company", getCompany());
		attributes.put("demourl", getDemourl());
		attributes.put("downloadurl", getDownloadurl());
		attributes.put("toolId", getToolId());
		attributes.put("platform", getPlatform());
		attributes.put("license", getLicense());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long toolInformationId = (Long)attributes.get("toolInformationId");

		if (toolInformationId != null) {
			setToolInformationId(toolInformationId);
		}

		String gitUUID = (String)attributes.get("gitUUID");

		if (gitUUID != null) {
			setGitUUID(gitUUID);
		}

		String logourl = (String)attributes.get("logourl");

		if (logourl != null) {
			setLogourl(logourl);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String demourl = (String)attributes.get("demourl");

		if (demourl != null) {
			setDemourl(demourl);
		}

		String downloadurl = (String)attributes.get("downloadurl");

		if (downloadurl != null) {
			setDownloadurl(downloadurl);
		}

		String toolId = (String)attributes.get("toolId");

		if (toolId != null) {
			setToolId(toolId);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getToolInformationId() {
		return _toolInformationId;
	}

	@Override
	public void setToolInformationId(long toolInformationId) {
		_toolInformationId = toolInformationId;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setToolInformationId",
						long.class);

				method.invoke(_toolInformationRemoteModel, toolInformationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGitUUID() {
		return _gitUUID;
	}

	@Override
	public void setGitUUID(String gitUUID) {
		_gitUUID = gitUUID;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setGitUUID", String.class);

				method.invoke(_toolInformationRemoteModel, gitUUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogourl() {
		return _logourl;
	}

	@Override
	public void setLogourl(String logourl) {
		_logourl = logourl;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setLogourl", String.class);

				method.invoke(_toolInformationRemoteModel, logourl);
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

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_toolInformationRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_toolInformationRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_toolInformationRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDemourl() {
		return _demourl;
	}

	@Override
	public void setDemourl(String demourl) {
		_demourl = demourl;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setDemourl", String.class);

				method.invoke(_toolInformationRemoteModel, demourl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDownloadurl() {
		return _downloadurl;
	}

	@Override
	public void setDownloadurl(String downloadurl) {
		_downloadurl = downloadurl;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadurl", String.class);

				method.invoke(_toolInformationRemoteModel, downloadurl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToolId() {
		return _toolId;
	}

	@Override
	public void setToolId(String toolId) {
		_toolId = toolId;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setToolId", String.class);

				method.invoke(_toolInformationRemoteModel, toolId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlatform() {
		return _platform;
	}

	@Override
	public void setPlatform(String platform) {
		_platform = platform;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setPlatform", String.class);

				method.invoke(_toolInformationRemoteModel, platform);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLicense() {
		return _license;
	}

	@Override
	public void setLicense(String license) {
		_license = license;

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setLicense", String.class);

				method.invoke(_toolInformationRemoteModel, license);
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

		if (_toolInformationRemoteModel != null) {
			try {
				Class<?> clazz = _toolInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_toolInformationRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getToolInformationRemoteModel() {
		return _toolInformationRemoteModel;
	}

	public void setToolInformationRemoteModel(
		BaseModel<?> toolInformationRemoteModel) {
		_toolInformationRemoteModel = toolInformationRemoteModel;
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

		Class<?> remoteModelClass = _toolInformationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_toolInformationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ToolInformationLocalServiceUtil.addToolInformation(this);
		}
		else {
			ToolInformationLocalServiceUtil.updateToolInformation(this);
		}
	}

	@Override
	public ToolInformation toEscapedModel() {
		return (ToolInformation)ProxyUtil.newProxyInstance(ToolInformation.class.getClassLoader(),
			new Class[] { ToolInformation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ToolInformationClp clone = new ToolInformationClp();

		clone.setToolInformationId(getToolInformationId());
		clone.setGitUUID(getGitUUID());
		clone.setLogourl(getLogourl());
		clone.setName(getName());
		clone.setCategory(getCategory());
		clone.setCompany(getCompany());
		clone.setDemourl(getDemourl());
		clone.setDownloadurl(getDownloadurl());
		clone.setToolId(getToolId());
		clone.setPlatform(getPlatform());
		clone.setLicense(getLicense());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(ToolInformation toolInformation) {
		int value = 0;

		value = getName().compareTo(toolInformation.getName());

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

		if (!(obj instanceof ToolInformationClp)) {
			return false;
		}

		ToolInformationClp toolInformation = (ToolInformationClp)obj;

		long primaryKey = toolInformation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{toolInformationId=");
		sb.append(getToolInformationId());
		sb.append(", gitUUID=");
		sb.append(getGitUUID());
		sb.append(", logourl=");
		sb.append(getLogourl());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", demourl=");
		sb.append(getDemourl());
		sb.append(", downloadurl=");
		sb.append(getDownloadurl());
		sb.append(", toolId=");
		sb.append(getToolId());
		sb.append(", platform=");
		sb.append(getPlatform());
		sb.append(", license=");
		sb.append(getLicense());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("at.bibbox.reactjsservice.model.ToolInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>toolInformationId</column-name><column-value><![CDATA[");
		sb.append(getToolInformationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gitUUID</column-name><column-value><![CDATA[");
		sb.append(getGitUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logourl</column-name><column-value><![CDATA[");
		sb.append(getLogourl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>demourl</column-name><column-value><![CDATA[");
		sb.append(getDemourl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadurl</column-name><column-value><![CDATA[");
		sb.append(getDownloadurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toolId</column-name><column-value><![CDATA[");
		sb.append(getToolId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>platform</column-name><column-value><![CDATA[");
		sb.append(getPlatform());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>license</column-name><column-value><![CDATA[");
		sb.append(getLicense());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _toolInformationId;
	private String _gitUUID;
	private String _logourl;
	private String _name;
	private String _category;
	private String _company;
	private String _demourl;
	private String _downloadurl;
	private String _toolId;
	private String _platform;
	private String _license;
	private String _description;
	private BaseModel<?> _toolInformationRemoteModel;
}