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

package at.graz.meduni.liferay.portlet.bibbox.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrganizationSearchIndex}.
 * </p>
 *
 * @author reihsr
 * @see OrganizationSearchIndex
 * @generated
 */
public class OrganizationSearchIndexWrapper implements OrganizationSearchIndex,
	ModelWrapper<OrganizationSearchIndex> {
	public OrganizationSearchIndexWrapper(
		OrganizationSearchIndex organizationSearchIndex) {
		_organizationSearchIndex = organizationSearchIndex;
	}

	@Override
	public Class<?> getModelClass() {
		return OrganizationSearchIndex.class;
	}

	@Override
	public String getModelClassName() {
		return OrganizationSearchIndex.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("searchid", getSearchid());
		attributes.put("organisationid", getOrganisationid());
		attributes.put("locationid", getLocationid());
		attributes.put("location", getLocation());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long searchid = (Long)attributes.get("searchid");

		if (searchid != null) {
			setSearchid(searchid);
		}

		Long organisationid = (Long)attributes.get("organisationid");

		if (organisationid != null) {
			setOrganisationid(organisationid);
		}

		Long locationid = (Long)attributes.get("locationid");

		if (locationid != null) {
			setLocationid(locationid);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this organization search index.
	*
	* @return the primary key of this organization search index
	*/
	@Override
	public long getPrimaryKey() {
		return _organizationSearchIndex.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization search index.
	*
	* @param primaryKey the primary key of this organization search index
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organizationSearchIndex.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the searchid of this organization search index.
	*
	* @return the searchid of this organization search index
	*/
	@Override
	public long getSearchid() {
		return _organizationSearchIndex.getSearchid();
	}

	/**
	* Sets the searchid of this organization search index.
	*
	* @param searchid the searchid of this organization search index
	*/
	@Override
	public void setSearchid(long searchid) {
		_organizationSearchIndex.setSearchid(searchid);
	}

	/**
	* Returns the organisationid of this organization search index.
	*
	* @return the organisationid of this organization search index
	*/
	@Override
	public long getOrganisationid() {
		return _organizationSearchIndex.getOrganisationid();
	}

	/**
	* Sets the organisationid of this organization search index.
	*
	* @param organisationid the organisationid of this organization search index
	*/
	@Override
	public void setOrganisationid(long organisationid) {
		_organizationSearchIndex.setOrganisationid(organisationid);
	}

	/**
	* Returns the locationid of this organization search index.
	*
	* @return the locationid of this organization search index
	*/
	@Override
	public long getLocationid() {
		return _organizationSearchIndex.getLocationid();
	}

	/**
	* Sets the locationid of this organization search index.
	*
	* @param locationid the locationid of this organization search index
	*/
	@Override
	public void setLocationid(long locationid) {
		_organizationSearchIndex.setLocationid(locationid);
	}

	/**
	* Returns the location of this organization search index.
	*
	* @return the location of this organization search index
	*/
	@Override
	public java.lang.String getLocation() {
		return _organizationSearchIndex.getLocation();
	}

	/**
	* Sets the location of this organization search index.
	*
	* @param location the location of this organization search index
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_organizationSearchIndex.setLocation(location);
	}

	/**
	* Returns the key of this organization search index.
	*
	* @return the key of this organization search index
	*/
	@Override
	public java.lang.String getKey() {
		return _organizationSearchIndex.getKey();
	}

	/**
	* Sets the key of this organization search index.
	*
	* @param key the key of this organization search index
	*/
	@Override
	public void setKey(java.lang.String key) {
		_organizationSearchIndex.setKey(key);
	}

	/**
	* Returns the value of this organization search index.
	*
	* @return the value of this organization search index
	*/
	@Override
	public java.lang.String getValue() {
		return _organizationSearchIndex.getValue();
	}

	/**
	* Sets the value of this organization search index.
	*
	* @param value the value of this organization search index
	*/
	@Override
	public void setValue(java.lang.String value) {
		_organizationSearchIndex.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _organizationSearchIndex.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organizationSearchIndex.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organizationSearchIndex.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organizationSearchIndex.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organizationSearchIndex.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organizationSearchIndex.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizationSearchIndex.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizationSearchIndex.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organizationSearchIndex.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organizationSearchIndex.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizationSearchIndex.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationSearchIndexWrapper((OrganizationSearchIndex)_organizationSearchIndex.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex) {
		return _organizationSearchIndex.compareTo(organizationSearchIndex);
	}

	@Override
	public int hashCode() {
		return _organizationSearchIndex.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> toCacheModel() {
		return _organizationSearchIndex.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex toEscapedModel() {
		return new OrganizationSearchIndexWrapper(_organizationSearchIndex.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex toUnescapedModel() {
		return new OrganizationSearchIndexWrapper(_organizationSearchIndex.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizationSearchIndex.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organizationSearchIndex.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizationSearchIndex.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationSearchIndexWrapper)) {
			return false;
		}

		OrganizationSearchIndexWrapper organizationSearchIndexWrapper = (OrganizationSearchIndexWrapper)obj;

		if (Validator.equals(_organizationSearchIndex,
					organizationSearchIndexWrapper._organizationSearchIndex)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrganizationSearchIndex getWrappedOrganizationSearchIndex() {
		return _organizationSearchIndex;
	}

	@Override
	public OrganizationSearchIndex getWrappedModel() {
		return _organizationSearchIndex;
	}

	@Override
	public void resetOriginalValues() {
		_organizationSearchIndex.resetOriginalValues();
	}

	private OrganizationSearchIndex _organizationSearchIndex;
}