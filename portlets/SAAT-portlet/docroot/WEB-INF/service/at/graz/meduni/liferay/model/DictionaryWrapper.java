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

package at.graz.meduni.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dictionary}.
 * </p>
 *
 * @author reihsr
 * @see Dictionary
 * @generated
 */
public class DictionaryWrapper implements Dictionary, ModelWrapper<Dictionary> {
	public DictionaryWrapper(Dictionary dictionary) {
		_dictionary = dictionary;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionary_id", getDictionary_id());
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
		Long dictionary_id = (Long)attributes.get("dictionary_id");

		if (dictionary_id != null) {
			setDictionary_id(dictionary_id);
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

	/**
	* Returns the primary key of this dictionary.
	*
	* @return the primary key of this dictionary
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dictionary.
	*
	* @param primaryKey the primary key of this dictionary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dictionary_id of this dictionary.
	*
	* @return the dictionary_id of this dictionary
	*/
	@Override
	public long getDictionary_id() {
		return _dictionary.getDictionary_id();
	}

	/**
	* Sets the dictionary_id of this dictionary.
	*
	* @param dictionary_id the dictionary_id of this dictionary
	*/
	@Override
	public void setDictionary_id(long dictionary_id) {
		_dictionary.setDictionary_id(dictionary_id);
	}

	/**
	* Returns the synonym of this dictionary.
	*
	* @return the synonym of this dictionary
	*/
	@Override
	public java.lang.String getSynonym() {
		return _dictionary.getSynonym();
	}

	/**
	* Sets the synonym of this dictionary.
	*
	* @param synonym the synonym of this dictionary
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_dictionary.setSynonym(synonym);
	}

	/**
	* Returns the before_synonym of this dictionary.
	*
	* @return the before_synonym of this dictionary
	*/
	@Override
	public int getBefore_synonym() {
		return _dictionary.getBefore_synonym();
	}

	/**
	* Sets the before_synonym of this dictionary.
	*
	* @param before_synonym the before_synonym of this dictionary
	*/
	@Override
	public void setBefore_synonym(int before_synonym) {
		_dictionary.setBefore_synonym(before_synonym);
	}

	/**
	* Returns the after_synonym of this dictionary.
	*
	* @return the after_synonym of this dictionary
	*/
	@Override
	public int getAfter_synonym() {
		return _dictionary.getAfter_synonym();
	}

	/**
	* Sets the after_synonym of this dictionary.
	*
	* @param after_synonym the after_synonym of this dictionary
	*/
	@Override
	public void setAfter_synonym(int after_synonym) {
		_dictionary.setAfter_synonym(after_synonym);
	}

	/**
	* Returns the foreword of this dictionary.
	*
	* @return the foreword of this dictionary
	*/
	@Override
	public boolean getForeword() {
		return _dictionary.getForeword();
	}

	/**
	* Returns <code>true</code> if this dictionary is foreword.
	*
	* @return <code>true</code> if this dictionary is foreword; <code>false</code> otherwise
	*/
	@Override
	public boolean isForeword() {
		return _dictionary.isForeword();
	}

	/**
	* Sets whether this dictionary is foreword.
	*
	* @param foreword the foreword of this dictionary
	*/
	@Override
	public void setForeword(boolean foreword) {
		_dictionary.setForeword(foreword);
	}

	/**
	* Returns the ending of this dictionary.
	*
	* @return the ending of this dictionary
	*/
	@Override
	public boolean getEnding() {
		return _dictionary.getEnding();
	}

	/**
	* Returns <code>true</code> if this dictionary is ending.
	*
	* @return <code>true</code> if this dictionary is ending; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnding() {
		return _dictionary.isEnding();
	}

	/**
	* Sets whether this dictionary is ending.
	*
	* @param ending the ending of this dictionary
	*/
	@Override
	public void setEnding(boolean ending) {
		_dictionary.setEnding(ending);
	}

	/**
	* Returns the sentence of this dictionary.
	*
	* @return the sentence of this dictionary
	*/
	@Override
	public boolean getSentence() {
		return _dictionary.getSentence();
	}

	/**
	* Returns <code>true</code> if this dictionary is sentence.
	*
	* @return <code>true</code> if this dictionary is sentence; <code>false</code> otherwise
	*/
	@Override
	public boolean isSentence() {
		return _dictionary.isSentence();
	}

	/**
	* Sets whether this dictionary is sentence.
	*
	* @param sentence the sentence of this dictionary
	*/
	@Override
	public void setSentence(boolean sentence) {
		_dictionary.setSentence(sentence);
	}

	/**
	* Returns the iscode of this dictionary.
	*
	* @return the iscode of this dictionary
	*/
	@Override
	public boolean getIscode() {
		return _dictionary.getIscode();
	}

	/**
	* Returns <code>true</code> if this dictionary is iscode.
	*
	* @return <code>true</code> if this dictionary is iscode; <code>false</code> otherwise
	*/
	@Override
	public boolean isIscode() {
		return _dictionary.isIscode();
	}

	/**
	* Sets whether this dictionary is iscode.
	*
	* @param iscode the iscode of this dictionary
	*/
	@Override
	public void setIscode(boolean iscode) {
		_dictionary.setIscode(iscode);
	}

	/**
	* Returns the pattern of this dictionary.
	*
	* @return the pattern of this dictionary
	*/
	@Override
	public java.lang.String getPattern() {
		return _dictionary.getPattern();
	}

	/**
	* Sets the pattern of this dictionary.
	*
	* @param pattern the pattern of this dictionary
	*/
	@Override
	public void setPattern(java.lang.String pattern) {
		_dictionary.setPattern(pattern);
	}

	/**
	* Returns the code_typ of this dictionary.
	*
	* @return the code_typ of this dictionary
	*/
	@Override
	public java.lang.String getCode_typ() {
		return _dictionary.getCode_typ();
	}

	/**
	* Sets the code_typ of this dictionary.
	*
	* @param code_typ the code_typ of this dictionary
	*/
	@Override
	public void setCode_typ(java.lang.String code_typ) {
		_dictionary.setCode_typ(code_typ);
	}

	/**
	* Returns the code_value of this dictionary.
	*
	* @return the code_value of this dictionary
	*/
	@Override
	public java.lang.String getCode_value() {
		return _dictionary.getCode_value();
	}

	/**
	* Sets the code_value of this dictionary.
	*
	* @param code_value the code_value of this dictionary
	*/
	@Override
	public void setCode_value(java.lang.String code_value) {
		_dictionary.setCode_value(code_value);
	}

	/**
	* Returns the root of this dictionary.
	*
	* @return the root of this dictionary
	*/
	@Override
	public boolean getRoot() {
		return _dictionary.getRoot();
	}

	/**
	* Returns <code>true</code> if this dictionary is root.
	*
	* @return <code>true</code> if this dictionary is root; <code>false</code> otherwise
	*/
	@Override
	public boolean isRoot() {
		return _dictionary.isRoot();
	}

	/**
	* Sets whether this dictionary is root.
	*
	* @param root the root of this dictionary
	*/
	@Override
	public void setRoot(boolean root) {
		_dictionary.setRoot(root);
	}

	/**
	* Returns the negation of this dictionary.
	*
	* @return the negation of this dictionary
	*/
	@Override
	public boolean getNegation() {
		return _dictionary.getNegation();
	}

	/**
	* Returns <code>true</code> if this dictionary is negation.
	*
	* @return <code>true</code> if this dictionary is negation; <code>false</code> otherwise
	*/
	@Override
	public boolean isNegation() {
		return _dictionary.isNegation();
	}

	/**
	* Sets whether this dictionary is negation.
	*
	* @param negation the negation of this dictionary
	*/
	@Override
	public void setNegation(boolean negation) {
		_dictionary.setNegation(negation);
	}

	/**
	* Returns the occur of this dictionary.
	*
	* @return the occur of this dictionary
	*/
	@Override
	public boolean getOccur() {
		return _dictionary.getOccur();
	}

	/**
	* Returns <code>true</code> if this dictionary is occur.
	*
	* @return <code>true</code> if this dictionary is occur; <code>false</code> otherwise
	*/
	@Override
	public boolean isOccur() {
		return _dictionary.isOccur();
	}

	/**
	* Sets whether this dictionary is occur.
	*
	* @param occur the occur of this dictionary
	*/
	@Override
	public void setOccur(boolean occur) {
		_dictionary.setOccur(occur);
	}

	/**
	* Returns the disease_ids of this dictionary.
	*
	* @return the disease_ids of this dictionary
	*/
	@Override
	public java.lang.String getDisease_ids() {
		return _dictionary.getDisease_ids();
	}

	/**
	* Sets the disease_ids of this dictionary.
	*
	* @param disease_ids the disease_ids of this dictionary
	*/
	@Override
	public void setDisease_ids(java.lang.String disease_ids) {
		_dictionary.setDisease_ids(disease_ids);
	}

	/**
	* Returns the dirty of this dictionary.
	*
	* @return the dirty of this dictionary
	*/
	@Override
	public boolean getDirty() {
		return _dictionary.getDirty();
	}

	/**
	* Returns <code>true</code> if this dictionary is dirty.
	*
	* @return <code>true</code> if this dictionary is dirty; <code>false</code> otherwise
	*/
	@Override
	public boolean isDirty() {
		return _dictionary.isDirty();
	}

	/**
	* Sets whether this dictionary is dirty.
	*
	* @param dirty the dirty of this dictionary
	*/
	@Override
	public void setDirty(boolean dirty) {
		_dictionary.setDirty(dirty);
	}

	/**
	* Returns the priority of this dictionary.
	*
	* @return the priority of this dictionary
	*/
	@Override
	public int getPriority() {
		return _dictionary.getPriority();
	}

	/**
	* Sets the priority of this dictionary.
	*
	* @param priority the priority of this dictionary
	*/
	@Override
	public void setPriority(int priority) {
		_dictionary.setPriority(priority);
	}

	/**
	* Returns the disease_ids_count of this dictionary.
	*
	* @return the disease_ids_count of this dictionary
	*/
	@Override
	public int getDisease_ids_count() {
		return _dictionary.getDisease_ids_count();
	}

	/**
	* Sets the disease_ids_count of this dictionary.
	*
	* @param disease_ids_count the disease_ids_count of this dictionary
	*/
	@Override
	public void setDisease_ids_count(int disease_ids_count) {
		_dictionary.setDisease_ids_count(disease_ids_count);
	}

	/**
	* Returns the priority_mode of this dictionary.
	*
	* @return the priority_mode of this dictionary
	*/
	@Override
	public boolean getPriority_mode() {
		return _dictionary.getPriority_mode();
	}

	/**
	* Returns <code>true</code> if this dictionary is priority_mode.
	*
	* @return <code>true</code> if this dictionary is priority_mode; <code>false</code> otherwise
	*/
	@Override
	public boolean isPriority_mode() {
		return _dictionary.isPriority_mode();
	}

	/**
	* Sets whether this dictionary is priority_mode.
	*
	* @param priority_mode the priority_mode of this dictionary
	*/
	@Override
	public void setPriority_mode(boolean priority_mode) {
		_dictionary.setPriority_mode(priority_mode);
	}

	@Override
	public boolean isNew() {
		return _dictionary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictionary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictionary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictionary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictionary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictionary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictionary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictionary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictionary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryWrapper((Dictionary)_dictionary.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.model.Dictionary dictionary) {
		return _dictionary.compareTo(dictionary);
	}

	@Override
	public int hashCode() {
		return _dictionary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.model.Dictionary> toCacheModel() {
		return _dictionary.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.model.Dictionary toEscapedModel() {
		return new DictionaryWrapper(_dictionary.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.model.Dictionary toUnescapedModel() {
		return new DictionaryWrapper(_dictionary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictionary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryWrapper)) {
			return false;
		}

		DictionaryWrapper dictionaryWrapper = (DictionaryWrapper)obj;

		if (Validator.equals(_dictionary, dictionaryWrapper._dictionary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Dictionary getWrappedDictionary() {
		return _dictionary;
	}

	@Override
	public Dictionary getWrappedModel() {
		return _dictionary;
	}

	@Override
	public void resetOriginalValues() {
		_dictionary.resetOriginalValues();
	}

	private Dictionary _dictionary;
}