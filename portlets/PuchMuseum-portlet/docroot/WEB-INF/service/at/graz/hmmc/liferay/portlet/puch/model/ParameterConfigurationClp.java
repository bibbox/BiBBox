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

package at.graz.hmmc.liferay.portlet.puch.model;

import at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil;

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
public class ParameterConfigurationClp extends BaseModelImpl<ParameterConfiguration>
	implements ParameterConfiguration {
	public ParameterConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ParameterConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ParameterConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _parameterconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParameterconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parameterconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("displaynameshort", getDisplaynameshort());
		attributes.put("displaynamelong", getDisplaynamelong());
		attributes.put("datatype", getDatatype());
		attributes.put("group", getGroup());
		attributes.put("tab", getTab());
		attributes.put("summery", getSummery());
		attributes.put("viewscript", getViewscript());
		attributes.put("viewvisible", getViewvisible());
		attributes.put("viewtip", getViewtip());
		attributes.put("viewtitlecss", getViewtitlecss());
		attributes.put("viewvaluecss", getViewvaluecss());
		attributes.put("viewcss", getViewcss());
		attributes.put("editscript", getEditscript());
		attributes.put("editvisible", getEditvisible());
		attributes.put("edittip", getEdittip());
		attributes.put("edittitlecss", getEdittitlecss());
		attributes.put("editvaluecss", getEditvaluecss());
		attributes.put("editcss", getEditcss());
		attributes.put("editcolumnwidth", getEditcolumnwidth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String displaynameshort = (String)attributes.get("displaynameshort");

		if (displaynameshort != null) {
			setDisplaynameshort(displaynameshort);
		}

		String displaynamelong = (String)attributes.get("displaynamelong");

		if (displaynamelong != null) {
			setDisplaynamelong(displaynamelong);
		}

		String datatype = (String)attributes.get("datatype");

		if (datatype != null) {
			setDatatype(datatype);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		String tab = (String)attributes.get("tab");

		if (tab != null) {
			setTab(tab);
		}

		Boolean summery = (Boolean)attributes.get("summery");

		if (summery != null) {
			setSummery(summery);
		}

		String viewscript = (String)attributes.get("viewscript");

		if (viewscript != null) {
			setViewscript(viewscript);
		}

		Boolean viewvisible = (Boolean)attributes.get("viewvisible");

		if (viewvisible != null) {
			setViewvisible(viewvisible);
		}

		String viewtip = (String)attributes.get("viewtip");

		if (viewtip != null) {
			setViewtip(viewtip);
		}

		String viewtitlecss = (String)attributes.get("viewtitlecss");

		if (viewtitlecss != null) {
			setViewtitlecss(viewtitlecss);
		}

		String viewvaluecss = (String)attributes.get("viewvaluecss");

		if (viewvaluecss != null) {
			setViewvaluecss(viewvaluecss);
		}

		String viewcss = (String)attributes.get("viewcss");

		if (viewcss != null) {
			setViewcss(viewcss);
		}

		String editscript = (String)attributes.get("editscript");

		if (editscript != null) {
			setEditscript(editscript);
		}

		Boolean editvisible = (Boolean)attributes.get("editvisible");

		if (editvisible != null) {
			setEditvisible(editvisible);
		}

		String edittip = (String)attributes.get("edittip");

		if (edittip != null) {
			setEdittip(edittip);
		}

		String edittitlecss = (String)attributes.get("edittitlecss");

		if (edittitlecss != null) {
			setEdittitlecss(edittitlecss);
		}

		String editvaluecss = (String)attributes.get("editvaluecss");

		if (editvaluecss != null) {
			setEditvaluecss(editvaluecss);
		}

		String editcss = (String)attributes.get("editcss");

		if (editcss != null) {
			setEditcss(editcss);
		}

		Long editcolumnwidth = (Long)attributes.get("editcolumnwidth");

		if (editcolumnwidth != null) {
			setEditcolumnwidth(editcolumnwidth);
		}
	}

	@Override
	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setParameterconfigurationId",
						long.class);

				method.invoke(_parameterConfigurationRemoteModel,
					parameterconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplaynameshort() {
		return _displaynameshort;
	}

	@Override
	public void setDisplaynameshort(String displaynameshort) {
		_displaynameshort = displaynameshort;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplaynameshort",
						String.class);

				method.invoke(_parameterConfigurationRemoteModel,
					displaynameshort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplaynamelong() {
		return _displaynamelong;
	}

	@Override
	public void setDisplaynamelong(String displaynamelong) {
		_displaynamelong = displaynamelong;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplaynamelong",
						String.class);

				method.invoke(_parameterConfigurationRemoteModel,
					displaynamelong);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDatatype() {
		return _datatype;
	}

	@Override
	public void setDatatype(String datatype) {
		_datatype = datatype;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDatatype", String.class);

				method.invoke(_parameterConfigurationRemoteModel, datatype);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroup", String.class);

				method.invoke(_parameterConfigurationRemoteModel, group);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTab() {
		return _tab;
	}

	@Override
	public void setTab(String tab) {
		_tab = tab;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setTab", String.class);

				method.invoke(_parameterConfigurationRemoteModel, tab);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSummery() {
		return _summery;
	}

	@Override
	public boolean isSummery() {
		return _summery;
	}

	@Override
	public void setSummery(boolean summery) {
		_summery = summery;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSummery", boolean.class);

				method.invoke(_parameterConfigurationRemoteModel, summery);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewscript", String.class);

				method.invoke(_parameterConfigurationRemoteModel, viewscript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getViewvisible() {
		return _viewvisible;
	}

	@Override
	public boolean isViewvisible() {
		return _viewvisible;
	}

	@Override
	public void setViewvisible(boolean viewvisible) {
		_viewvisible = viewvisible;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewvisible", boolean.class);

				method.invoke(_parameterConfigurationRemoteModel, viewvisible);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getViewtip() {
		return _viewtip;
	}

	@Override
	public void setViewtip(String viewtip) {
		_viewtip = viewtip;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewtip", String.class);

				method.invoke(_parameterConfigurationRemoteModel, viewtip);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewtitlecss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, viewtitlecss);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewvaluecss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, viewvaluecss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getViewcss() {
		return _viewcss;
	}

	@Override
	public void setViewcss(String viewcss) {
		_viewcss = viewcss;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setViewcss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, viewcss);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditscript", String.class);

				method.invoke(_parameterConfigurationRemoteModel, editscript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEditvisible() {
		return _editvisible;
	}

	@Override
	public boolean isEditvisible() {
		return _editvisible;
	}

	@Override
	public void setEditvisible(boolean editvisible) {
		_editvisible = editvisible;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditvisible", boolean.class);

				method.invoke(_parameterConfigurationRemoteModel, editvisible);
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

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEdittip", String.class);

				method.invoke(_parameterConfigurationRemoteModel, edittip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEdittitlecss() {
		return _edittitlecss;
	}

	@Override
	public void setEdittitlecss(String edittitlecss) {
		_edittitlecss = edittitlecss;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEdittitlecss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, edittitlecss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditvaluecss() {
		return _editvaluecss;
	}

	@Override
	public void setEditvaluecss(String editvaluecss) {
		_editvaluecss = editvaluecss;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditvaluecss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, editvaluecss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditcss() {
		return _editcss;
	}

	@Override
	public void setEditcss(String editcss) {
		_editcss = editcss;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditcss", String.class);

				method.invoke(_parameterConfigurationRemoteModel, editcss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEditcolumnwidth() {
		return _editcolumnwidth;
	}

	@Override
	public void setEditcolumnwidth(long editcolumnwidth) {
		_editcolumnwidth = editcolumnwidth;

		if (_parameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEditcolumnwidth", long.class);

				method.invoke(_parameterConfigurationRemoteModel,
					editcolumnwidth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getParameterConfigurationRemoteModel() {
		return _parameterConfigurationRemoteModel;
	}

	public void setParameterConfigurationRemoteModel(
		BaseModel<?> parameterConfigurationRemoteModel) {
		_parameterConfigurationRemoteModel = parameterConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _parameterConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_parameterConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ParameterConfigurationLocalServiceUtil.addParameterConfiguration(this);
		}
		else {
			ParameterConfigurationLocalServiceUtil.updateParameterConfiguration(this);
		}
	}

	@Override
	public ParameterConfiguration toEscapedModel() {
		return (ParameterConfiguration)ProxyUtil.newProxyInstance(ParameterConfiguration.class.getClassLoader(),
			new Class[] { ParameterConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParameterConfigurationClp clone = new ParameterConfigurationClp();

		clone.setParameterconfigurationId(getParameterconfigurationId());
		clone.setDisplaynameshort(getDisplaynameshort());
		clone.setDisplaynamelong(getDisplaynamelong());
		clone.setDatatype(getDatatype());
		clone.setGroup(getGroup());
		clone.setTab(getTab());
		clone.setSummery(getSummery());
		clone.setViewscript(getViewscript());
		clone.setViewvisible(getViewvisible());
		clone.setViewtip(getViewtip());
		clone.setViewtitlecss(getViewtitlecss());
		clone.setViewvaluecss(getViewvaluecss());
		clone.setViewcss(getViewcss());
		clone.setEditscript(getEditscript());
		clone.setEditvisible(getEditvisible());
		clone.setEdittip(getEdittip());
		clone.setEdittitlecss(getEdittitlecss());
		clone.setEditvaluecss(getEditvaluecss());
		clone.setEditcss(getEditcss());
		clone.setEditcolumnwidth(getEditcolumnwidth());

		return clone;
	}

	@Override
	public int compareTo(ParameterConfiguration parameterConfiguration) {
		long primaryKey = parameterConfiguration.getPrimaryKey();

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

		if (!(obj instanceof ParameterConfigurationClp)) {
			return false;
		}

		ParameterConfigurationClp parameterConfiguration = (ParameterConfigurationClp)obj;

		long primaryKey = parameterConfiguration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{parameterconfigurationId=");
		sb.append(getParameterconfigurationId());
		sb.append(", displaynameshort=");
		sb.append(getDisplaynameshort());
		sb.append(", displaynamelong=");
		sb.append(getDisplaynamelong());
		sb.append(", datatype=");
		sb.append(getDatatype());
		sb.append(", group=");
		sb.append(getGroup());
		sb.append(", tab=");
		sb.append(getTab());
		sb.append(", summery=");
		sb.append(getSummery());
		sb.append(", viewscript=");
		sb.append(getViewscript());
		sb.append(", viewvisible=");
		sb.append(getViewvisible());
		sb.append(", viewtip=");
		sb.append(getViewtip());
		sb.append(", viewtitlecss=");
		sb.append(getViewtitlecss());
		sb.append(", viewvaluecss=");
		sb.append(getViewvaluecss());
		sb.append(", viewcss=");
		sb.append(getViewcss());
		sb.append(", editscript=");
		sb.append(getEditscript());
		sb.append(", editvisible=");
		sb.append(getEditvisible());
		sb.append(", edittip=");
		sb.append(getEdittip());
		sb.append(", edittitlecss=");
		sb.append(getEdittitlecss());
		sb.append(", editvaluecss=");
		sb.append(getEditvaluecss());
		sb.append(", editcss=");
		sb.append(getEditcss());
		sb.append(", editcolumnwidth=");
		sb.append(getEditcolumnwidth());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>parameterconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getParameterconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displaynameshort</column-name><column-value><![CDATA[");
		sb.append(getDisplaynameshort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displaynamelong</column-name><column-value><![CDATA[");
		sb.append(getDisplaynamelong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datatype</column-name><column-value><![CDATA[");
		sb.append(getDatatype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group</column-name><column-value><![CDATA[");
		sb.append(getGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tab</column-name><column-value><![CDATA[");
		sb.append(getTab());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summery</column-name><column-value><![CDATA[");
		sb.append(getSummery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewscript</column-name><column-value><![CDATA[");
		sb.append(getViewscript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewvisible</column-name><column-value><![CDATA[");
		sb.append(getViewvisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewtip</column-name><column-value><![CDATA[");
		sb.append(getViewtip());
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
			"<column><column-name>viewcss</column-name><column-value><![CDATA[");
		sb.append(getViewcss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editscript</column-name><column-value><![CDATA[");
		sb.append(getEditscript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editvisible</column-name><column-value><![CDATA[");
		sb.append(getEditvisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>edittip</column-name><column-value><![CDATA[");
		sb.append(getEdittip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>edittitlecss</column-name><column-value><![CDATA[");
		sb.append(getEdittitlecss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editvaluecss</column-name><column-value><![CDATA[");
		sb.append(getEditvaluecss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editcss</column-name><column-value><![CDATA[");
		sb.append(getEditcss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editcolumnwidth</column-name><column-value><![CDATA[");
		sb.append(getEditcolumnwidth());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _parameterconfigurationId;
	private String _displaynameshort;
	private String _displaynamelong;
	private String _datatype;
	private String _group;
	private String _tab;
	private boolean _summery;
	private String _viewscript;
	private boolean _viewvisible;
	private String _viewtip;
	private String _viewtitlecss;
	private String _viewvaluecss;
	private String _viewcss;
	private String _editscript;
	private boolean _editvisible;
	private String _edittip;
	private String _edittitlecss;
	private String _editvaluecss;
	private String _editcss;
	private long _editcolumnwidth;
	private BaseModel<?> _parameterConfigurationRemoteModel;
}