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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.service.http.DictionaryServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.service.http.DictionaryServiceSoap
 * @generated
 */
public class DictionarySoap implements Serializable {
	public static DictionarySoap toSoapModel(Dictionary model) {
		DictionarySoap soapModel = new DictionarySoap();

		soapModel.setDictionary_id(model.getDictionary_id());
		soapModel.setSynonym(model.getSynonym());
		soapModel.setBefore_synonym(model.getBefore_synonym());
		soapModel.setAfter_synonym(model.getAfter_synonym());
		soapModel.setForeword(model.getForeword());
		soapModel.setEnding(model.getEnding());
		soapModel.setSentence(model.getSentence());
		soapModel.setIscode(model.getIscode());
		soapModel.setPattern(model.getPattern());
		soapModel.setCode_typ(model.getCode_typ());
		soapModel.setCode_value(model.getCode_value());
		soapModel.setRoot(model.getRoot());
		soapModel.setNegation(model.getNegation());
		soapModel.setOccur(model.getOccur());
		soapModel.setDisease_ids(model.getDisease_ids());
		soapModel.setDirty(model.getDirty());
		soapModel.setPriority(model.getPriority());
		soapModel.setDisease_ids_count(model.getDisease_ids_count());
		soapModel.setPriority_mode(model.getPriority_mode());

		return soapModel;
	}

	public static DictionarySoap[] toSoapModels(Dictionary[] models) {
		DictionarySoap[] soapModels = new DictionarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[][] toSoapModels(Dictionary[][] models) {
		DictionarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[] toSoapModels(List<Dictionary> models) {
		List<DictionarySoap> soapModels = new ArrayList<DictionarySoap>(models.size());

		for (Dictionary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionarySoap[soapModels.size()]);
	}

	public DictionarySoap() {
	}

	public long getPrimaryKey() {
		return _dictionary_id;
	}

	public void setPrimaryKey(long pk) {
		setDictionary_id(pk);
	}

	public long getDictionary_id() {
		return _dictionary_id;
	}

	public void setDictionary_id(long dictionary_id) {
		_dictionary_id = dictionary_id;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	public int getBefore_synonym() {
		return _before_synonym;
	}

	public void setBefore_synonym(int before_synonym) {
		_before_synonym = before_synonym;
	}

	public int getAfter_synonym() {
		return _after_synonym;
	}

	public void setAfter_synonym(int after_synonym) {
		_after_synonym = after_synonym;
	}

	public boolean getForeword() {
		return _foreword;
	}

	public boolean isForeword() {
		return _foreword;
	}

	public void setForeword(boolean foreword) {
		_foreword = foreword;
	}

	public boolean getEnding() {
		return _ending;
	}

	public boolean isEnding() {
		return _ending;
	}

	public void setEnding(boolean ending) {
		_ending = ending;
	}

	public boolean getSentence() {
		return _sentence;
	}

	public boolean isSentence() {
		return _sentence;
	}

	public void setSentence(boolean sentence) {
		_sentence = sentence;
	}

	public boolean getIscode() {
		return _iscode;
	}

	public boolean isIscode() {
		return _iscode;
	}

	public void setIscode(boolean iscode) {
		_iscode = iscode;
	}

	public String getPattern() {
		return _pattern;
	}

	public void setPattern(String pattern) {
		_pattern = pattern;
	}

	public String getCode_typ() {
		return _code_typ;
	}

	public void setCode_typ(String code_typ) {
		_code_typ = code_typ;
	}

	public String getCode_value() {
		return _code_value;
	}

	public void setCode_value(String code_value) {
		_code_value = code_value;
	}

	public boolean getRoot() {
		return _root;
	}

	public boolean isRoot() {
		return _root;
	}

	public void setRoot(boolean root) {
		_root = root;
	}

	public boolean getNegation() {
		return _negation;
	}

	public boolean isNegation() {
		return _negation;
	}

	public void setNegation(boolean negation) {
		_negation = negation;
	}

	public boolean getOccur() {
		return _occur;
	}

	public boolean isOccur() {
		return _occur;
	}

	public void setOccur(boolean occur) {
		_occur = occur;
	}

	public String getDisease_ids() {
		return _disease_ids;
	}

	public void setDisease_ids(String disease_ids) {
		_disease_ids = disease_ids;
	}

	public boolean getDirty() {
		return _dirty;
	}

	public boolean isDirty() {
		return _dirty;
	}

	public void setDirty(boolean dirty) {
		_dirty = dirty;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public int getDisease_ids_count() {
		return _disease_ids_count;
	}

	public void setDisease_ids_count(int disease_ids_count) {
		_disease_ids_count = disease_ids_count;
	}

	public boolean getPriority_mode() {
		return _priority_mode;
	}

	public boolean isPriority_mode() {
		return _priority_mode;
	}

	public void setPriority_mode(boolean priority_mode) {
		_priority_mode = priority_mode;
	}

	private long _dictionary_id;
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
}