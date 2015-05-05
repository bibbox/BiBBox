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
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil;

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
public class DDLConfigurationClp extends BaseModelImpl<DDLConfiguration>
	implements DDLConfiguration {
	public DDLConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DDLConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return DDLConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ddlconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDdlconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ddlconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddlconfigurationId", getDdlconfigurationId());
		attributes.put("ddmstructureId", getDdmstructureId());
		attributes.put("fieldname", getFieldname());
		attributes.put("group", getGroup());
		attributes.put("display", getDisplay());
		attributes.put("viewscript", getViewscript());
		attributes.put("displaytip", getDisplaytip());
		attributes.put("viewtitlecss", getViewtitlecss());
		attributes.put("viewvaluecss", getViewvaluecss());
		attributes.put("columwidth", getColumwidth());
		attributes.put("editscript", getEditscript());
		attributes.put("edittip", getEdittip());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddlconfigurationId = (Long)attributes.get("ddlconfigurationId");

		if (ddlconfigurationId != null) {
			setDdlconfigurationId(ddlconfigurationId);
		}

		Long ddmstructureId = (Long)attributes.get("ddmstructureId");

		if (ddmstructureId != null) {
			setDdmstructureId(ddmstructureId);
		}

		String fieldname = (String)attributes.get("fieldname");

		if (fieldname != null) {
			setFieldname(fieldname);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Boolean display = (Boolean)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		String viewscript = (String)attributes.get("viewscript");

		if (viewscript != null) {
			setViewscript(viewscript);
		}

		String displaytip = (String)attributes.get("displaytip");

		if (displaytip != null) {
			setDisplaytip(displaytip);
		}

		String viewtitlecss = (String)attributes.get("viewtitlecss");

		if (viewtitlecss != null) {
			setViewtitlecss(viewtitlecss);
		}

		String viewvaluecss = (String)attributes.get("viewvaluecss");

		if (viewvaluecss != null) {
			setViewvaluecss(viewvaluecss);
		}

		Long columwidth = (Long)attributes.get("columwidth");

		if (columwidth != null) {
			setColumwidth(columwidth);
		}

		String editscript = (String)attributes.get("editscript");

		if (editscript != null) {
			setEditscript(editscript);
		}

		String edittip = (String)attributes.get("edittip");

		if (edittip != null) {
			setEdittip(edittip);
		}
	}

	@Override
	public long getDdlconfigurationId() {
		return _ddlconfigurationId;
	}

	@Override
	public void setDdlconfigurationId(long ddlconfigurationId) {
		_ddlconfigurationId = ddlconfigurationId;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDdlconfigurationId",
						long.class);

				method.invoke(_ddlConfigurationRemoteModel, ddlconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDdmstructureId() {
		return _ddmstructureId;
	}

	@Override
	public void setDdmstructureId(long ddmstructureId) {
		_ddmstructureId = ddmstructureId;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDdmstructureId", long.class);

				method.invoke(_ddlConfigurationRemoteModel, ddmstructureId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFieldname() {
		return _fieldname;
	}

	@Override
	public void setFieldname(String fieldname) {
		_fieldname = fieldname;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setFieldname", String.class);

				method.invoke(_ddlConfigurationRemoteModel, fieldname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroup() {
		return _group;
	}

	@Override
	public void setGroup(String group) {
		_group = group;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroup", String.class);

				method.invoke(_ddlConfigurationRemoteModel, group);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplay() {
		return _display;
	}

	@Override
	public boolean isDisplay() {
		return _display;
	}

	@Override
	public void setDisplay(boolean display) {
		_display = display;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplay", boolean.class);

				method.invoke(_ddlConfigurationRemoteModel, display);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getViewscript() {
		return _viewscript;
	}

	@Override
	public void setViewscript(String viewscript) {
		_viewscript = viewscript;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewscript", String.class);

				method.invoke(_ddlConfigurationRemoteModel, viewscript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplaytip() {
		return _displaytip;
	}

	@Override
	public void setDisplaytip(String displaytip) {
		_displaytip = displaytip;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplaytip", String.class);

				method.invoke(_ddlConfigurationRemoteModel, displaytip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getViewtitlecss() {
		return _viewtitlecss;
	}

	@Override
	public void setViewtitlecss(String viewtitlecss) {
		_viewtitlecss = viewtitlecss;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewtitlecss", String.class);

				method.invoke(_ddlConfigurationRemoteModel, viewtitlecss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getViewvaluecss() {
		return _viewvaluecss;
	}

	@Override
	public void setViewvaluecss(String viewvaluecss) {
		_viewvaluecss = viewvaluecss;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewvaluecss", String.class);

				method.invoke(_ddlConfigurationRemoteModel, viewvaluecss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getColumwidth() {
		return _columwidth;
	}

	@Override
	public void setColumwidth(long columwidth) {
		_columwidth = columwidth;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setColumwidth", long.class);

				method.invoke(_ddlConfigurationRemoteModel, columwidth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditscript() {
		return _editscript;
	}

	@Override
	public void setEditscript(String editscript) {
		_editscript = editscript;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditscript", String.class);

				method.invoke(_ddlConfigurationRemoteModel, editscript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEdittip() {
		return _edittip;
	}

	@Override
	public void setEdittip(String edittip) {
		_edittip = edittip;

		if (_ddlConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _ddlConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEdittip", String.class);

				method.invoke(_ddlConfigurationRemoteModel, edittip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDDLConfigurationRemoteModel() {
		return _ddlConfigurationRemoteModel;
	}

	public void setDDLConfigurationRemoteModel(
		BaseModel<?> ddlConfigurationRemoteModel) {
		_ddlConfigurationRemoteModel = ddlConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _ddlConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ddlConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DDLConfigurationLocalServiceUtil.addDDLConfiguration(this);
		}
		else {
			DDLConfigurationLocalServiceUtil.updateDDLConfiguration(this);
		}
	}

	@Override
	public DDLConfiguration toEscapedModel() {
		return (DDLConfiguration)ProxyUtil.newProxyInstance(DDLConfiguration.class.getClassLoader(),
			new Class[] { DDLConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DDLConfigurationClp clone = new DDLConfigurationClp();

		clone.setDdlconfigurationId(getDdlconfigurationId());
		clone.setDdmstructureId(getDdmstructureId());
		clone.setFieldname(getFieldname());
		clone.setGroup(getGroup());
		clone.setDisplay(getDisplay());
		clone.setViewscript(getViewscript());
		clone.setDisplaytip(getDisplaytip());
		clone.setViewtitlecss(getViewtitlecss());
		clone.setViewvaluecss(getViewvaluecss());
		clone.setColumwidth(getColumwidth());
		clone.setEditscript(getEditscript());
		clone.setEdittip(getEdittip());

		return clone;
	}

	@Override
	public int compareTo(DDLConfiguration ddlConfiguration) {
		int value = 0;

		if (getDdlconfigurationId() < ddlConfiguration.getDdlconfigurationId()) {
			value = -1;
		}
		else if (getDdlconfigurationId() > ddlConfiguration.getDdlconfigurationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof DDLConfigurationClp)) {
			return false;
		}

		DDLConfigurationClp ddlConfiguration = (DDLConfigurationClp)obj;

		long primaryKey = ddlConfiguration.getPrimaryKey();

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

		sb.append("{ddlconfigurationId=");
		sb.append(getDdlconfigurationId());
		sb.append(", ddmstructureId=");
		sb.append(getDdmstructureId());
		sb.append(", fieldname=");
		sb.append(getFieldname());
		sb.append(", group=");
		sb.append(getGroup());
		sb.append(", display=");
		sb.append(getDisplay());
		sb.append(", viewscript=");
		sb.append(getViewscript());
		sb.append(", displaytip=");
		sb.append(getDisplaytip());
		sb.append(", viewtitlecss=");
		sb.append(getViewtitlecss());
		sb.append(", viewvaluecss=");
		sb.append(getViewvaluecss());
		sb.append(", columwidth=");
		sb.append(getColumwidth());
		sb.append(", editscript=");
		sb.append(getEditscript());
		sb.append(", edittip=");
		sb.append(getEdittip());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ddlconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getDdlconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ddmstructureId</column-name><column-value><![CDATA[");
		sb.append(getDdmstructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fieldname</column-name><column-value><![CDATA[");
		sb.append(getFieldname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group</column-name><column-value><![CDATA[");
		sb.append(getGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>display</column-name><column-value><![CDATA[");
		sb.append(getDisplay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewscript</column-name><column-value><![CDATA[");
		sb.append(getViewscript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displaytip</column-name><column-value><![CDATA[");
		sb.append(getDisplaytip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewtitlecss</column-name><column-value><![CDATA[");
		sb.append(getViewtitlecss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewvaluecss</column-name><column-value><![CDATA[");
		sb.append(getViewvaluecss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columwidth</column-name><column-value><![CDATA[");
		sb.append(getColumwidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editscript</column-name><column-value><![CDATA[");
		sb.append(getEditscript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>edittip</column-name><column-value><![CDATA[");
		sb.append(getEdittip());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ddlconfigurationId;
	private long _ddmstructureId;
	private String _fieldname;
	private String _group;
	private boolean _display;
	private String _viewscript;
	private String _displaytip;
	private String _viewtitlecss;
	private String _viewvaluecss;
	private long _columwidth;
	private String _editscript;
	private String _edittip;
	private BaseModel<?> _ddlConfigurationRemoteModel;
}