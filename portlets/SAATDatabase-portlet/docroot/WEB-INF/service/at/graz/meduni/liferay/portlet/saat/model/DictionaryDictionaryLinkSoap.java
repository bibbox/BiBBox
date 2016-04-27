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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.saat.service.http.DictionaryDictionaryLinkServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.saat.service.http.DictionaryDictionaryLinkServiceSoap
 * @generated
 */
public class DictionaryDictionaryLinkSoap implements Serializable {
	public static DictionaryDictionaryLinkSoap toSoapModel(
		DictionaryDictionaryLink model) {
		DictionaryDictionaryLinkSoap soapModel = new DictionaryDictionaryLinkSoap();

		soapModel.setDictionary_dictionary_addiction_linkId(model.getDictionary_dictionary_addiction_linkId());
		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setAddictionId(model.getAddictionId());

		return soapModel;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		DictionaryDictionaryLink[] models) {
		DictionaryDictionaryLinkSoap[] soapModels = new DictionaryDictionaryLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[][] toSoapModels(
		DictionaryDictionaryLink[][] models) {
		DictionaryDictionaryLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionaryDictionaryLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionaryDictionaryLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		List<DictionaryDictionaryLink> models) {
		List<DictionaryDictionaryLinkSoap> soapModels = new ArrayList<DictionaryDictionaryLinkSoap>(models.size());

		for (DictionaryDictionaryLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionaryDictionaryLinkSoap[soapModels.size()]);
	}

	public DictionaryDictionaryLinkSoap() {
	}

	public long getPrimaryKey() {
		return _dictionary_dictionary_addiction_linkId;
	}

	public void setPrimaryKey(long pk) {
		setDictionary_dictionary_addiction_linkId(pk);
	}

	public long getDictionary_dictionary_addiction_linkId() {
		return _dictionary_dictionary_addiction_linkId;
	}

	public void setDictionary_dictionary_addiction_linkId(
		long dictionary_dictionary_addiction_linkId) {
		_dictionary_dictionary_addiction_linkId = dictionary_dictionary_addiction_linkId;
	}

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getAddictionId() {
		return _addictionId;
	}

	public void setAddictionId(long addictionId) {
		_addictionId = addictionId;
	}

	private long _dictionary_dictionary_addiction_linkId;
	private long _dictionaryId;
	private long _addictionId;
}