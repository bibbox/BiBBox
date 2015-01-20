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

package at.rdconnect.update.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AccessibilityUpdate}.
 * </p>
 *
 * @author reihsr
 * @see AccessibilityUpdate
 * @generated
 */
public class AccessibilityUpdateWrapper implements AccessibilityUpdate,
	ModelWrapper<AccessibilityUpdate> {
	public AccessibilityUpdateWrapper(AccessibilityUpdate accessibilityUpdate) {
		_accessibilityUpdate = accessibilityUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return AccessibilityUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return AccessibilityUpdate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coreid", getCoreid());
		attributes.put("organizationid", getOrganizationid());
		attributes.put("fieldname", getFieldname());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coreid = (Long)attributes.get("coreid");

		if (coreid != null) {
			setCoreid(coreid);
		}

		Long organizationid = (Long)attributes.get("organizationid");

		if (organizationid != null) {
			setOrganizationid(organizationid);
		}

		String fieldname = (String)attributes.get("fieldname");

		if (fieldname != null) {
			setFieldname(fieldname);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this accessibility update.
	*
	* @return the primary key of this accessibility update
	*/
	@Override
	public long getPrimaryKey() {
		return _accessibilityUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this accessibility update.
	*
	* @param primaryKey the primary key of this accessibility update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_accessibilityUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the coreid of this accessibility update.
	*
	* @return the coreid of this accessibility update
	*/
	@Override
	public long getCoreid() {
		return _accessibilityUpdate.getCoreid();
	}

	/**
	* Sets the coreid of this accessibility update.
	*
	* @param coreid the coreid of this accessibility update
	*/
	@Override
	public void setCoreid(long coreid) {
		_accessibilityUpdate.setCoreid(coreid);
	}

	/**
	* Returns the organizationid of this accessibility update.
	*
	* @return the organizationid of this accessibility update
	*/
	@Override
	public long getOrganizationid() {
		return _accessibilityUpdate.getOrganizationid();
	}

	/**
	* Sets the organizationid of this accessibility update.
	*
	* @param organizationid the organizationid of this accessibility update
	*/
	@Override
	public void setOrganizationid(long organizationid) {
		_accessibilityUpdate.setOrganizationid(organizationid);
	}

	/**
	* Returns the fieldname of this accessibility update.
	*
	* @return the fieldname of this accessibility update
	*/
	@Override
	public java.lang.String getFieldname() {
		return _accessibilityUpdate.getFieldname();
	}

	/**
	* Sets the fieldname of this accessibility update.
	*
	* @param fieldname the fieldname of this accessibility update
	*/
	@Override
	public void setFieldname(java.lang.String fieldname) {
		_accessibilityUpdate.setFieldname(fieldname);
	}

	/**
	* Returns the value of this accessibility update.
	*
	* @return the value of this accessibility update
	*/
	@Override
	public java.lang.String getValue() {
		return _accessibilityUpdate.getValue();
	}

	/**
	* Sets the value of this accessibility update.
	*
	* @param value the value of this accessibility update
	*/
	@Override
	public void setValue(java.lang.String value) {
		_accessibilityUpdate.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _accessibilityUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_accessibilityUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _accessibilityUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_accessibilityUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _accessibilityUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _accessibilityUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_accessibilityUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _accessibilityUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_accessibilityUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_accessibilityUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_accessibilityUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AccessibilityUpdateWrapper((AccessibilityUpdate)_accessibilityUpdate.clone());
	}

	@Override
	public int compareTo(
		at.rdconnect.update.model.AccessibilityUpdate accessibilityUpdate) {
		return _accessibilityUpdate.compareTo(accessibilityUpdate);
	}

	@Override
	public int hashCode() {
		return _accessibilityUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.rdconnect.update.model.AccessibilityUpdate> toCacheModel() {
		return _accessibilityUpdate.toCacheModel();
	}

	@Override
	public at.rdconnect.update.model.AccessibilityUpdate toEscapedModel() {
		return new AccessibilityUpdateWrapper(_accessibilityUpdate.toEscapedModel());
	}

	@Override
	public at.rdconnect.update.model.AccessibilityUpdate toUnescapedModel() {
		return new AccessibilityUpdateWrapper(_accessibilityUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _accessibilityUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _accessibilityUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_accessibilityUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccessibilityUpdateWrapper)) {
			return false;
		}

		AccessibilityUpdateWrapper accessibilityUpdateWrapper = (AccessibilityUpdateWrapper)obj;

		if (Validator.equals(_accessibilityUpdate,
					accessibilityUpdateWrapper._accessibilityUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AccessibilityUpdate getWrappedAccessibilityUpdate() {
		return _accessibilityUpdate;
	}

	@Override
	public AccessibilityUpdate getWrappedModel() {
		return _accessibilityUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_accessibilityUpdate.resetOriginalValues();
	}

	private AccessibilityUpdate _accessibilityUpdate;
}