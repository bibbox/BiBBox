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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpRulesLocalServiceUtil;

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
public class KdssmpRulesClp extends BaseModelImpl<KdssmpRules>
	implements KdssmpRules {
	public KdssmpRulesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpRules.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpRules.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ruleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ruleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleId", getRuleId());
		attributes.put("rule", getRule());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String rule = (String)attributes.get("rule");

		if (rule != null) {
			setRule(rule);
		}
	}

	@Override
	public long getRuleId() {
		return _ruleId;
	}

	@Override
	public void setRuleId(long ruleId) {
		_ruleId = ruleId;

		if (_kdssmpRulesRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpRulesRemoteModel.getClass();

				Method method = clazz.getMethod("setRuleId", long.class);

				method.invoke(_kdssmpRulesRemoteModel, ruleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRule() {
		return _rule;
	}

	@Override
	public void setRule(String rule) {
		_rule = rule;

		if (_kdssmpRulesRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpRulesRemoteModel.getClass();

				Method method = clazz.getMethod("setRule", String.class);

				method.invoke(_kdssmpRulesRemoteModel, rule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKdssmpRulesRemoteModel() {
		return _kdssmpRulesRemoteModel;
	}

	public void setKdssmpRulesRemoteModel(BaseModel<?> kdssmpRulesRemoteModel) {
		_kdssmpRulesRemoteModel = kdssmpRulesRemoteModel;
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

		Class<?> remoteModelClass = _kdssmpRulesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kdssmpRulesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KdssmpRulesLocalServiceUtil.addKdssmpRules(this);
		}
		else {
			KdssmpRulesLocalServiceUtil.updateKdssmpRules(this);
		}
	}

	@Override
	public KdssmpRules toEscapedModel() {
		return (KdssmpRules)ProxyUtil.newProxyInstance(KdssmpRules.class.getClassLoader(),
			new Class[] { KdssmpRules.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KdssmpRulesClp clone = new KdssmpRulesClp();

		clone.setRuleId(getRuleId());
		clone.setRule(getRule());

		return clone;
	}

	@Override
	public int compareTo(KdssmpRules kdssmpRules) {
		long primaryKey = kdssmpRules.getPrimaryKey();

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

		if (!(obj instanceof KdssmpRulesClp)) {
			return false;
		}

		KdssmpRulesClp kdssmpRules = (KdssmpRulesClp)obj;

		long primaryKey = kdssmpRules.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{ruleId=");
		sb.append(getRuleId());
		sb.append(", rule=");
		sb.append(getRule());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ruleId</column-name><column-value><![CDATA[");
		sb.append(getRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rule</column-name><column-value><![CDATA[");
		sb.append(getRule());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ruleId;
	private String _rule;
	private BaseModel<?> _kdssmpRulesRemoteModel;
}