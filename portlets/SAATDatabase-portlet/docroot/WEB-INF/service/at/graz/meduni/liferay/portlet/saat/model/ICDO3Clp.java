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

package at.graz.meduni.liferay.portlet.saat.model;

import at.graz.meduni.liferay.portlet.saat.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.saat.service.ICDO3LocalServiceUtil;

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
public class ICDO3Clp extends BaseModelImpl<ICDO3> implements ICDO3 {
	public ICDO3Clp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ICDO3.class;
	}

	@Override
	public String getModelClassName() {
		return ICDO3.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _icdo3Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIcdo3Id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _icdo3Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("icdo3Id", getIcdo3Id());
		attributes.put("code", getCode());
		attributes.put("term", getTerm());
		attributes.put("sui", getSui());
		attributes.put("typ", getTyp());
		attributes.put("use", getUse());
		attributes.put("description", getDescription());
		attributes.put("localisation", getLocalisation());
		attributes.put("link", getLink());
		attributes.put("exklusiva", getExklusiva());
		attributes.put("hint", getHint());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long icdo3Id = (Long)attributes.get("icdo3Id");

		if (icdo3Id != null) {
			setIcdo3Id(icdo3Id);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer term = (Integer)attributes.get("term");

		if (term != null) {
			setTerm(term);
		}

		Integer sui = (Integer)attributes.get("sui");

		if (sui != null) {
			setSui(sui);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String use = (String)attributes.get("use");

		if (use != null) {
			setUse(use);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String localisation = (String)attributes.get("localisation");

		if (localisation != null) {
			setLocalisation(localisation);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String exklusiva = (String)attributes.get("exklusiva");

		if (exklusiva != null) {
			setExklusiva(exklusiva);
		}

		String hint = (String)attributes.get("hint");

		if (hint != null) {
			setHint(hint);
		}
	}

	@Override
	public long getIcdo3Id() {
		return _icdo3Id;
	}

	@Override
	public void setIcdo3Id(long icdo3Id) {
		_icdo3Id = icdo3Id;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setIcdo3Id", long.class);

				method.invoke(_icdo3RemoteModel, icdo3Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_icdo3RemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTerm() {
		return _term;
	}

	@Override
	public void setTerm(int term) {
		_term = term;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setTerm", int.class);

				method.invoke(_icdo3RemoteModel, term);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSui() {
		return _sui;
	}

	@Override
	public void setSui(int sui) {
		_sui = sui;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setSui", int.class);

				method.invoke(_icdo3RemoteModel, sui);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTyp() {
		return _typ;
	}

	@Override
	public void setTyp(String typ) {
		_typ = typ;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setTyp", String.class);

				method.invoke(_icdo3RemoteModel, typ);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUse() {
		return _use;
	}

	@Override
	public void setUse(String use) {
		_use = use;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setUse", String.class);

				method.invoke(_icdo3RemoteModel, use);
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

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_icdo3RemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocalisation() {
		return _localisation;
	}

	@Override
	public void setLocalisation(String localisation) {
		_localisation = localisation;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setLocalisation", String.class);

				method.invoke(_icdo3RemoteModel, localisation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLink() {
		return _link;
	}

	@Override
	public void setLink(String link) {
		_link = link;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setLink", String.class);

				method.invoke(_icdo3RemoteModel, link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExklusiva() {
		return _exklusiva;
	}

	@Override
	public void setExklusiva(String exklusiva) {
		_exklusiva = exklusiva;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setExklusiva", String.class);

				method.invoke(_icdo3RemoteModel, exklusiva);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHint() {
		return _hint;
	}

	@Override
	public void setHint(String hint) {
		_hint = hint;

		if (_icdo3RemoteModel != null) {
			try {
				Class<?> clazz = _icdo3RemoteModel.getClass();

				Method method = clazz.getMethod("setHint", String.class);

				method.invoke(_icdo3RemoteModel, hint);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getICDO3RemoteModel() {
		return _icdo3RemoteModel;
	}

	public void setICDO3RemoteModel(BaseModel<?> icdo3RemoteModel) {
		_icdo3RemoteModel = icdo3RemoteModel;
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

		Class<?> remoteModelClass = _icdo3RemoteModel.getClass();

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

		Object returnValue = method.invoke(_icdo3RemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ICDO3LocalServiceUtil.addICDO3(this);
		}
		else {
			ICDO3LocalServiceUtil.updateICDO3(this);
		}
	}

	@Override
	public ICDO3 toEscapedModel() {
		return (ICDO3)ProxyUtil.newProxyInstance(ICDO3.class.getClassLoader(),
			new Class[] { ICDO3.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ICDO3Clp clone = new ICDO3Clp();

		clone.setIcdo3Id(getIcdo3Id());
		clone.setCode(getCode());
		clone.setTerm(getTerm());
		clone.setSui(getSui());
		clone.setTyp(getTyp());
		clone.setUse(getUse());
		clone.setDescription(getDescription());
		clone.setLocalisation(getLocalisation());
		clone.setLink(getLink());
		clone.setExklusiva(getExklusiva());
		clone.setHint(getHint());

		return clone;
	}

	@Override
	public int compareTo(ICDO3 icdo3) {
		int value = 0;

		if (getIcdo3Id() < icdo3.getIcdo3Id()) {
			value = -1;
		}
		else if (getIcdo3Id() > icdo3.getIcdo3Id()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ICDO3Clp)) {
			return false;
		}

		ICDO3Clp icdo3 = (ICDO3Clp)obj;

		long primaryKey = icdo3.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{icdo3Id=");
		sb.append(getIcdo3Id());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", term=");
		sb.append(getTerm());
		sb.append(", sui=");
		sb.append(getSui());
		sb.append(", typ=");
		sb.append(getTyp());
		sb.append(", use=");
		sb.append(getUse());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", localisation=");
		sb.append(getLocalisation());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", exklusiva=");
		sb.append(getExklusiva());
		sb.append(", hint=");
		sb.append(getHint());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.saat.model.ICDO3");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>icdo3Id</column-name><column-value><![CDATA[");
		sb.append(getIcdo3Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>term</column-name><column-value><![CDATA[");
		sb.append(getTerm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sui</column-name><column-value><![CDATA[");
		sb.append(getSui());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typ</column-name><column-value><![CDATA[");
		sb.append(getTyp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>use</column-name><column-value><![CDATA[");
		sb.append(getUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localisation</column-name><column-value><![CDATA[");
		sb.append(getLocalisation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exklusiva</column-name><column-value><![CDATA[");
		sb.append(getExklusiva());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hint</column-name><column-value><![CDATA[");
		sb.append(getHint());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _icdo3Id;
	private String _code;
	private int _term;
	private int _sui;
	private String _typ;
	private String _use;
	private String _description;
	private String _localisation;
	private String _link;
	private String _exklusiva;
	private String _hint;
	private BaseModel<?> _icdo3RemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.class;
}