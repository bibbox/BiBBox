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
import at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalServiceUtil;

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
public class DiseaseDiscriptionClp extends BaseModelImpl<DiseaseDiscription>
	implements DiseaseDiscription {
	public DiseaseDiscriptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DiseaseDiscription.class;
	}

	@Override
	public String getModelClassName() {
		return DiseaseDiscription.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _diseasediscriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDiseasediscriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _diseasediscriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("diseasediscriptionId", getDiseasediscriptionId());
		attributes.put("diseasecode", getDiseasecode());
		attributes.put("diseasegroup", getDiseasegroup());
		attributes.put("diseasediscription", getDiseasediscription());
		attributes.put("root", getRoot());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long diseasediscriptionId = (Long)attributes.get("diseasediscriptionId");

		if (diseasediscriptionId != null) {
			setDiseasediscriptionId(diseasediscriptionId);
		}

		String diseasecode = (String)attributes.get("diseasecode");

		if (diseasecode != null) {
			setDiseasecode(diseasecode);
		}

		String diseasegroup = (String)attributes.get("diseasegroup");

		if (diseasegroup != null) {
			setDiseasegroup(diseasegroup);
		}

		String diseasediscription = (String)attributes.get("diseasediscription");

		if (diseasediscription != null) {
			setDiseasediscription(diseasediscription);
		}

		Boolean root = (Boolean)attributes.get("root");

		if (root != null) {
			setRoot(root);
		}
	}

	@Override
	public long getDiseasediscriptionId() {
		return _diseasediscriptionId;
	}

	@Override
	public void setDiseasediscriptionId(long diseasediscriptionId) {
		_diseasediscriptionId = diseasediscriptionId;

		if (_diseaseDiscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseDiscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasediscriptionId",
						long.class);

				method.invoke(_diseaseDiscriptionRemoteModel,
					diseasediscriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasecode() {
		return _diseasecode;
	}

	@Override
	public void setDiseasecode(String diseasecode) {
		_diseasecode = diseasecode;

		if (_diseaseDiscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseDiscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasecode", String.class);

				method.invoke(_diseaseDiscriptionRemoteModel, diseasecode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasegroup() {
		return _diseasegroup;
	}

	@Override
	public void setDiseasegroup(String diseasegroup) {
		_diseasegroup = diseasegroup;

		if (_diseaseDiscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseDiscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasegroup", String.class);

				method.invoke(_diseaseDiscriptionRemoteModel, diseasegroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasediscription() {
		return _diseasediscription;
	}

	@Override
	public void setDiseasediscription(String diseasediscription) {
		_diseasediscription = diseasediscription;

		if (_diseaseDiscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseDiscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasediscription",
						String.class);

				method.invoke(_diseaseDiscriptionRemoteModel, diseasediscription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRoot() {
		return _root;
	}

	@Override
	public boolean isRoot() {
		return _root;
	}

	@Override
	public void setRoot(boolean root) {
		_root = root;

		if (_diseaseDiscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseDiscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setRoot", boolean.class);

				method.invoke(_diseaseDiscriptionRemoteModel, root);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDiseaseDiscriptionRemoteModel() {
		return _diseaseDiscriptionRemoteModel;
	}

	public void setDiseaseDiscriptionRemoteModel(
		BaseModel<?> diseaseDiscriptionRemoteModel) {
		_diseaseDiscriptionRemoteModel = diseaseDiscriptionRemoteModel;
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

		Class<?> remoteModelClass = _diseaseDiscriptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_diseaseDiscriptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DiseaseDiscriptionLocalServiceUtil.addDiseaseDiscription(this);
		}
		else {
			DiseaseDiscriptionLocalServiceUtil.updateDiseaseDiscription(this);
		}
	}

	@Override
	public DiseaseDiscription toEscapedModel() {
		return (DiseaseDiscription)ProxyUtil.newProxyInstance(DiseaseDiscription.class.getClassLoader(),
			new Class[] { DiseaseDiscription.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DiseaseDiscriptionClp clone = new DiseaseDiscriptionClp();

		clone.setDiseasediscriptionId(getDiseasediscriptionId());
		clone.setDiseasecode(getDiseasecode());
		clone.setDiseasegroup(getDiseasegroup());
		clone.setDiseasediscription(getDiseasediscription());
		clone.setRoot(getRoot());

		return clone;
	}

	@Override
	public int compareTo(DiseaseDiscription diseaseDiscription) {
		int value = 0;

		value = getDiseasegroup().compareTo(diseaseDiscription.getDiseasegroup());

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

		if (!(obj instanceof DiseaseDiscriptionClp)) {
			return false;
		}

		DiseaseDiscriptionClp diseaseDiscription = (DiseaseDiscriptionClp)obj;

		long primaryKey = diseaseDiscription.getPrimaryKey();

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

		sb.append("{diseasediscriptionId=");
		sb.append(getDiseasediscriptionId());
		sb.append(", diseasecode=");
		sb.append(getDiseasecode());
		sb.append(", diseasegroup=");
		sb.append(getDiseasegroup());
		sb.append(", diseasediscription=");
		sb.append(getDiseasediscription());
		sb.append(", root=");
		sb.append(getRoot());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>diseasediscriptionId</column-name><column-value><![CDATA[");
		sb.append(getDiseasediscriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasecode</column-name><column-value><![CDATA[");
		sb.append(getDiseasecode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasegroup</column-name><column-value><![CDATA[");
		sb.append(getDiseasegroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasediscription</column-name><column-value><![CDATA[");
		sb.append(getDiseasediscription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>root</column-name><column-value><![CDATA[");
		sb.append(getRoot());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _diseasediscriptionId;
	private String _diseasecode;
	private String _diseasegroup;
	private String _diseasediscription;
	private boolean _root;
	private BaseModel<?> _diseaseDiscriptionRemoteModel;
}