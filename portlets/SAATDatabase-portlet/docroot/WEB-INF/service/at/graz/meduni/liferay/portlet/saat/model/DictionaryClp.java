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
import at.graz.meduni.liferay.portlet.saat.service.DictionaryLocalServiceUtil;

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
public class DictionaryClp extends BaseModelImpl<Dictionary>
	implements Dictionary {
	public DictionaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Dictionary.class;
	}

	@Override
	public String getModelClassName() {
		return Dictionary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("synonym", getSynonym());
		attributes.put("before_synonym", getBefore_synonym());
		attributes.put("after_synonym", getAfter_synonym());
		attributes.put("foreword", getForeword());
		attributes.put("ending", getEnding());
		attributes.put("sentence", getSentence());
		attributes.put("iscode", getIscode());
		attributes.put("pattern", getPattern());
		attributes.put("code_typ", getCode_typ());
		attributes.put("code_value", getCode_value());
		attributes.put("root", getRoot());
		attributes.put("negation", getNegation());
		attributes.put("occur", getOccur());
		attributes.put("disease_ids", getDisease_ids());
		attributes.put("dirty", getDirty());
		attributes.put("priority", getPriority());
		attributes.put("disease_ids_count", getDisease_ids_count());
		attributes.put("priority_mode", getPriority_mode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}

		Integer before_synonym = (Integer)attributes.get("before_synonym");

		if (before_synonym != null) {
			setBefore_synonym(before_synonym);
		}

		Integer after_synonym = (Integer)attributes.get("after_synonym");

		if (after_synonym != null) {
			setAfter_synonym(after_synonym);
		}

		Boolean foreword = (Boolean)attributes.get("foreword");

		if (foreword != null) {
			setForeword(foreword);
		}

		Boolean ending = (Boolean)attributes.get("ending");

		if (ending != null) {
			setEnding(ending);
		}

		Boolean sentence = (Boolean)attributes.get("sentence");

		if (sentence != null) {
			setSentence(sentence);
		}

		Boolean iscode = (Boolean)attributes.get("iscode");

		if (iscode != null) {
			setIscode(iscode);
		}

		String pattern = (String)attributes.get("pattern");

		if (pattern != null) {
			setPattern(pattern);
		}

		String code_typ = (String)attributes.get("code_typ");

		if (code_typ != null) {
			setCode_typ(code_typ);
		}

		String code_value = (String)attributes.get("code_value");

		if (code_value != null) {
			setCode_value(code_value);
		}

		Boolean root = (Boolean)attributes.get("root");

		if (root != null) {
			setRoot(root);
		}

		Boolean negation = (Boolean)attributes.get("negation");

		if (negation != null) {
			setNegation(negation);
		}

		Boolean occur = (Boolean)attributes.get("occur");

		if (occur != null) {
			setOccur(occur);
		}

		String disease_ids = (String)attributes.get("disease_ids");

		if (disease_ids != null) {
			setDisease_ids(disease_ids);
		}

		Boolean dirty = (Boolean)attributes.get("dirty");

		if (dirty != null) {
			setDirty(dirty);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer disease_ids_count = (Integer)attributes.get("disease_ids_count");

		if (disease_ids_count != null) {
			setDisease_ids_count(disease_ids_count);
		}

		Boolean priority_mode = (Boolean)attributes.get("priority_mode");

		if (priority_mode != null) {
			setPriority_mode(priority_mode);
		}
	}

	@Override
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryId", long.class);

				method.invoke(_dictionaryRemoteModel, dictionaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSynonym() {
		return _synonym;
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSynonym", String.class);

				method.invoke(_dictionaryRemoteModel, synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBefore_synonym() {
		return _before_synonym;
	}

	@Override
	public void setBefore_synonym(int before_synonym) {
		_before_synonym = before_synonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setBefore_synonym", int.class);

				method.invoke(_dictionaryRemoteModel, before_synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAfter_synonym() {
		return _after_synonym;
	}

	@Override
	public void setAfter_synonym(int after_synonym) {
		_after_synonym = after_synonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setAfter_synonym", int.class);

				method.invoke(_dictionaryRemoteModel, after_synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForeword() {
		return _foreword;
	}

	@Override
	public boolean isForeword() {
		return _foreword;
	}

	@Override
	public void setForeword(boolean foreword) {
		_foreword = foreword;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setForeword", boolean.class);

				method.invoke(_dictionaryRemoteModel, foreword);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnding() {
		return _ending;
	}

	@Override
	public boolean isEnding() {
		return _ending;
	}

	@Override
	public void setEnding(boolean ending) {
		_ending = ending;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setEnding", boolean.class);

				method.invoke(_dictionaryRemoteModel, ending);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSentence() {
		return _sentence;
	}

	@Override
	public boolean isSentence() {
		return _sentence;
	}

	@Override
	public void setSentence(boolean sentence) {
		_sentence = sentence;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSentence", boolean.class);

				method.invoke(_dictionaryRemoteModel, sentence);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIscode() {
		return _iscode;
	}

	@Override
	public boolean isIscode() {
		return _iscode;
	}

	@Override
	public void setIscode(boolean iscode) {
		_iscode = iscode;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setIscode", boolean.class);

				method.invoke(_dictionaryRemoteModel, iscode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPattern() {
		return _pattern;
	}

	@Override
	public void setPattern(String pattern) {
		_pattern = pattern;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPattern", String.class);

				method.invoke(_dictionaryRemoteModel, pattern);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode_typ() {
		return _code_typ;
	}

	@Override
	public void setCode_typ(String code_typ) {
		_code_typ = code_typ;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCode_typ", String.class);

				method.invoke(_dictionaryRemoteModel, code_typ);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode_value() {
		return _code_value;
	}

	@Override
	public void setCode_value(String code_value) {
		_code_value = code_value;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCode_value", String.class);

				method.invoke(_dictionaryRemoteModel, code_value);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setRoot", boolean.class);

				method.invoke(_dictionaryRemoteModel, root);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNegation() {
		return _negation;
	}

	@Override
	public boolean isNegation() {
		return _negation;
	}

	@Override
	public void setNegation(boolean negation) {
		_negation = negation;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setNegation", boolean.class);

				method.invoke(_dictionaryRemoteModel, negation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOccur() {
		return _occur;
	}

	@Override
	public boolean isOccur() {
		return _occur;
	}

	@Override
	public void setOccur(boolean occur) {
		_occur = occur;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setOccur", boolean.class);

				method.invoke(_dictionaryRemoteModel, occur);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisease_ids() {
		return _disease_ids;
	}

	@Override
	public void setDisease_ids(String disease_ids) {
		_disease_ids = disease_ids;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisease_ids", String.class);

				method.invoke(_dictionaryRemoteModel, disease_ids);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDirty() {
		return _dirty;
	}

	@Override
	public boolean isDirty() {
		return _dirty;
	}

	@Override
	public void setDirty(boolean dirty) {
		_dirty = dirty;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDirty", boolean.class);

				method.invoke(_dictionaryRemoteModel, dirty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(int priority) {
		_priority = priority;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority", int.class);

				method.invoke(_dictionaryRemoteModel, priority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDisease_ids_count() {
		return _disease_ids_count;
	}

	@Override
	public void setDisease_ids_count(int disease_ids_count) {
		_disease_ids_count = disease_ids_count;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisease_ids_count",
						int.class);

				method.invoke(_dictionaryRemoteModel, disease_ids_count);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPriority_mode() {
		return _priority_mode;
	}

	@Override
	public boolean isPriority_mode() {
		return _priority_mode;
	}

	@Override
	public void setPriority_mode(boolean priority_mode) {
		_priority_mode = priority_mode;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority_mode",
						boolean.class);

				method.invoke(_dictionaryRemoteModel, priority_mode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictionaryRemoteModel() {
		return _dictionaryRemoteModel;
	}

	public void setDictionaryRemoteModel(BaseModel<?> dictionaryRemoteModel) {
		_dictionaryRemoteModel = dictionaryRemoteModel;
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

		Class<?> remoteModelClass = _dictionaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictionaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictionaryLocalServiceUtil.addDictionary(this);
		}
		else {
			DictionaryLocalServiceUtil.updateDictionary(this);
		}
	}

	@Override
	public Dictionary toEscapedModel() {
		return (Dictionary)ProxyUtil.newProxyInstance(Dictionary.class.getClassLoader(),
			new Class[] { Dictionary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictionaryClp clone = new DictionaryClp();

		clone.setDictionaryId(getDictionaryId());
		clone.setSynonym(getSynonym());
		clone.setBefore_synonym(getBefore_synonym());
		clone.setAfter_synonym(getAfter_synonym());
		clone.setForeword(getForeword());
		clone.setEnding(getEnding());
		clone.setSentence(getSentence());
		clone.setIscode(getIscode());
		clone.setPattern(getPattern());
		clone.setCode_typ(getCode_typ());
		clone.setCode_value(getCode_value());
		clone.setRoot(getRoot());
		clone.setNegation(getNegation());
		clone.setOccur(getOccur());
		clone.setDisease_ids(getDisease_ids());
		clone.setDirty(getDirty());
		clone.setPriority(getPriority());
		clone.setDisease_ids_count(getDisease_ids_count());
		clone.setPriority_mode(getPriority_mode());

		return clone;
	}

	@Override
	public int compareTo(Dictionary dictionary) {
		int value = 0;

		if (getDictionaryId() < dictionary.getDictionaryId()) {
			value = -1;
		}
		else if (getDictionaryId() > dictionary.getDictionaryId()) {
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

		if (!(obj instanceof DictionaryClp)) {
			return false;
		}

		DictionaryClp dictionary = (DictionaryClp)obj;

		long primaryKey = dictionary.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{dictionaryId=");
		sb.append(getDictionaryId());
		sb.append(", synonym=");
		sb.append(getSynonym());
		sb.append(", before_synonym=");
		sb.append(getBefore_synonym());
		sb.append(", after_synonym=");
		sb.append(getAfter_synonym());
		sb.append(", foreword=");
		sb.append(getForeword());
		sb.append(", ending=");
		sb.append(getEnding());
		sb.append(", sentence=");
		sb.append(getSentence());
		sb.append(", iscode=");
		sb.append(getIscode());
		sb.append(", pattern=");
		sb.append(getPattern());
		sb.append(", code_typ=");
		sb.append(getCode_typ());
		sb.append(", code_value=");
		sb.append(getCode_value());
		sb.append(", root=");
		sb.append(getRoot());
		sb.append(", negation=");
		sb.append(getNegation());
		sb.append(", occur=");
		sb.append(getOccur());
		sb.append(", disease_ids=");
		sb.append(getDisease_ids());
		sb.append(", dirty=");
		sb.append(getDirty());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", disease_ids_count=");
		sb.append(getDisease_ids_count());
		sb.append(", priority_mode=");
		sb.append(getPriority_mode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.saat.model.Dictionary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synonym</column-name><column-value><![CDATA[");
		sb.append(getSynonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>before_synonym</column-name><column-value><![CDATA[");
		sb.append(getBefore_synonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>after_synonym</column-name><column-value><![CDATA[");
		sb.append(getAfter_synonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foreword</column-name><column-value><![CDATA[");
		sb.append(getForeword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ending</column-name><column-value><![CDATA[");
		sb.append(getEnding());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentence</column-name><column-value><![CDATA[");
		sb.append(getSentence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iscode</column-name><column-value><![CDATA[");
		sb.append(getIscode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pattern</column-name><column-value><![CDATA[");
		sb.append(getPattern());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code_typ</column-name><column-value><![CDATA[");
		sb.append(getCode_typ());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code_value</column-name><column-value><![CDATA[");
		sb.append(getCode_value());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>root</column-name><column-value><![CDATA[");
		sb.append(getRoot());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>negation</column-name><column-value><![CDATA[");
		sb.append(getNegation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>occur</column-name><column-value><![CDATA[");
		sb.append(getOccur());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disease_ids</column-name><column-value><![CDATA[");
		sb.append(getDisease_ids());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dirty</column-name><column-value><![CDATA[");
		sb.append(getDirty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disease_ids_count</column-name><column-value><![CDATA[");
		sb.append(getDisease_ids_count());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority_mode</column-name><column-value><![CDATA[");
		sb.append(getPriority_mode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictionaryId;
	private String _synonym;
	private int _before_synonym;
	private int _after_synonym;
	private boolean _foreword;
	private boolean _ending;
	private boolean _sentence;
	private boolean _iscode;
	private String _pattern;
	private String _code_typ;
	private String _code_value;
	private boolean _root;
	private boolean _negation;
	private boolean _occur;
	private String _disease_ids;
	private boolean _dirty;
	private int _priority;
	private int _disease_ids_count;
	private boolean _priority_mode;
	private BaseModel<?> _dictionaryRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.class;
}