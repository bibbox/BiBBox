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

		attributes.put("id", getId());
		attributes.put("dictionary_id", getDictionary_id());
		attributes.put("addiction_id", getAddiction_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long dictionary_id = (Long)attributes.get("dictionary_id");

		if (dictionary_id != null) {
			setDictionary_id(dictionary_id);
		}

		Long addiction_id = (Long)attributes.get("addiction_id");

		if (addiction_id != null) {
			setAddiction_id(addiction_id);
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
	* Returns the ID of this dictionary dictionary link.
	*
	* @return the ID of this dictionary dictionary link
	*/
	@Override
	public long getId() {
		return _dictionaryDictionaryLink.getId();
	}

	/**
	* Sets the ID of this dictionary dictionary link.
	*
	* @param id the ID of this dictionary dictionary link
	*/
	@Override
	public void setId(long id) {
		_dictionaryDictionaryLink.setId(id);
	}

	/**
	* Returns the dictionary_id of this dictionary dictionary link.
	*
	* @return the dictionary_id of this dictionary dictionary link
	*/
	@Override
	public long getDictionary_id() {
		return _dictionaryDictionaryLink.getDictionary_id();
	}

	/**
	* Sets the dictionary_id of this dictionary dictionary link.
	*
	* @param dictionary_id the dictionary_id of this dictionary dictionary link
	*/
	@Override
	public void setDictionary_id(long dictionary_id) {
		_dictionaryDictionaryLink.setDictionary_id(dictionary_id);
	}

	/**
	* Returns the addiction_id of this dictionary dictionary link.
	*
	* @return the addiction_id of this dictionary dictionary link
	*/
	@Override
	public long getAddiction_id() {
		return _dictionaryDictionaryLink.getAddiction_id();
	}

	/**
	* Sets the addiction_id of this dictionary dictionary link.
	*
	* @param addiction_id the addiction_id of this dictionary dictionary link
	*/
	@Override
	public void setAddiction_id(long addiction_id) {
		_dictionaryDictionaryLink.setAddiction_id(addiction_id);
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
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLink.compareTo(dictionaryDictionaryLink);
	}

	@Override
	public int hashCode() {
		return _dictionaryDictionaryLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.model.DictionaryDictionaryLink> toCacheModel() {
		return _dictionaryDictionaryLink.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink toEscapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink toUnescapedModel() {
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