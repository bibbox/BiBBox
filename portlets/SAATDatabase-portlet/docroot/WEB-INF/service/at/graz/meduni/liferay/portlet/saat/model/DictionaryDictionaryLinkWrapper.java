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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DictionaryDictionaryLink}.
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLink
 * @generated
 */
public class DictionaryDictionaryLinkWrapper implements DictionaryDictionaryLink,
	ModelWrapper<DictionaryDictionaryLink> {
	public DictionaryDictionaryLinkWrapper(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		_dictionaryDictionaryLink = dictionaryDictionaryLink;
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionary_dictionary_addiction_linkId",
			getDictionary_dictionary_addiction_linkId());
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("addictionId", getAddictionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionary_dictionary_addiction_linkId = (Long)attributes.get(
				"dictionary_dictionary_addiction_linkId");

		if (dictionary_dictionary_addiction_linkId != null) {
			setDictionary_dictionary_addiction_linkId(dictionary_dictionary_addiction_linkId);
		}

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long addictionId = (Long)attributes.get("addictionId");

		if (addictionId != null) {
			setAddictionId(addictionId);
		}
	}

	/**
	* Returns the primary key of this dictionary dictionary link.
	*
	* @return the primary key of this dictionary dictionary link
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionaryDictionaryLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dictionary dictionary link.
	*
	* @param primaryKey the primary key of this dictionary dictionary link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionaryDictionaryLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dictionary_dictionary_addiction_link ID of this dictionary dictionary link.
	*
	* @return the dictionary_dictionary_addiction_link ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionary_dictionary_addiction_linkId() {
		return _dictionaryDictionaryLink.getDictionary_dictionary_addiction_linkId();
	}

	/**
	* Sets the dictionary_dictionary_addiction_link ID of this dictionary dictionary link.
	*
	* @param dictionary_dictionary_addiction_linkId the dictionary_dictionary_addiction_link ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionary_dictionary_addiction_linkId(
		long dictionary_dictionary_addiction_linkId) {
		_dictionaryDictionaryLink.setDictionary_dictionary_addiction_linkId(dictionary_dictionary_addiction_linkId);
	}

	/**
	* Returns the dictionary ID of this dictionary dictionary link.
	*
	* @return the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionaryId() {
		return _dictionaryDictionaryLink.getDictionaryId();
	}

	/**
	* Sets the dictionary ID of this dictionary dictionary link.
	*
	* @param dictionaryId the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryDictionaryLink.setDictionaryId(dictionaryId);
	}

	/**
	* Returns the addiction ID of this dictionary dictionary link.
	*
	* @return the addiction ID of this dictionary dictionary link
	*/
	@Override
	public long getAddictionId() {
		return _dictionaryDictionaryLink.getAddictionId();
	}

	/**
	* Sets the addiction ID of this dictionary dictionary link.
	*
	* @param addictionId the addiction ID of this dictionary dictionary link
	*/
	@Override
	public void setAddictionId(long addictionId) {
		_dictionaryDictionaryLink.setAddictionId(addictionId);
	}

	@Override
	public boolean isNew() {
		return _dictionaryDictionaryLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictionaryDictionaryLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictionaryDictionaryLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionaryDictionaryLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionaryDictionaryLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictionaryDictionaryLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictionaryDictionaryLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictionaryDictionaryLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryDictionaryLinkWrapper((DictionaryDictionaryLink)_dictionaryDictionaryLink.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLink.compareTo(dictionaryDictionaryLink);
	}

	@Override
	public int hashCode() {
		return _dictionaryDictionaryLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink> toCacheModel() {
		return _dictionaryDictionaryLink.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink toEscapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink toUnescapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictionaryDictionaryLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionaryDictionaryLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionaryDictionaryLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryDictionaryLinkWrapper)) {
			return false;
		}

		DictionaryDictionaryLinkWrapper dictionaryDictionaryLinkWrapper = (DictionaryDictionaryLinkWrapper)obj;

		if (Validator.equals(_dictionaryDictionaryLink,
					dictionaryDictionaryLinkWrapper._dictionaryDictionaryLink)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DictionaryDictionaryLink getWrappedDictionaryDictionaryLink() {
		return _dictionaryDictionaryLink;
	}

	@Override
	public DictionaryDictionaryLink getWrappedModel() {
		return _dictionaryDictionaryLink;
	}

	@Override
	public void resetOriginalValues() {
		_dictionaryDictionaryLink.resetOriginalValues();
	}

	private DictionaryDictionaryLink _dictionaryDictionaryLink;
}