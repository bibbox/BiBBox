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
 * This class is a wrapper for {@link CoreUpdate}.
 * </p>
 *
 * @author reihsr
 * @see CoreUpdate
 * @generated
 */
public class CoreUpdateWrapper implements CoreUpdate, ModelWrapper<CoreUpdate> {
	public CoreUpdateWrapper(CoreUpdate coreUpdate) {
		_coreUpdate = coreUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return CoreUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return CoreUpdate.class.getName();
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
	* Returns the primary key of this core update.
	*
	* @return the primary key of this core update
	*/
	@Override
	public long getPrimaryKey() {
		return _coreUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this core update.
	*
	* @param primaryKey the primary key of this core update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_coreUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the coreid of this core update.
	*
	* @return the coreid of this core update
	*/
	@Override
	public long getCoreid() {
		return _coreUpdate.getCoreid();
	}

	/**
	* Sets the coreid of this core update.
	*
	* @param coreid the coreid of this core update
	*/
	@Override
	public void setCoreid(long coreid) {
		_coreUpdate.setCoreid(coreid);
	}

	/**
	* Returns the organizationid of this core update.
	*
	* @return the organizationid of this core update
	*/
	@Override
	public long getOrganizationid() {
		return _coreUpdate.getOrganizationid();
	}

	/**
	* Sets the organizationid of this core update.
	*
	* @param organizationid the organizationid of this core update
	*/
	@Override
	public void setOrganizationid(long organizationid) {
		_coreUpdate.setOrganizationid(organizationid);
	}

	/**
	* Returns the fieldname of this core update.
	*
	* @return the fieldname of this core update
	*/
	@Override
	public java.lang.String getFieldname() {
		return _coreUpdate.getFieldname();
	}

	/**
	* Sets the fieldname of this core update.
	*
	* @param fieldname the fieldname of this core update
	*/
	@Override
	public void setFieldname(java.lang.String fieldname) {
		_coreUpdate.setFieldname(fieldname);
	}

	/**
	* Returns the value of this core update.
	*
	* @return the value of this core update
	*/
	@Override
	public java.lang.String getValue() {
		return _coreUpdate.getValue();
	}

	/**
	* Sets the value of this core update.
	*
	* @param value the value of this core update
	*/
	@Override
	public void setValue(java.lang.String value) {
		_coreUpdate.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _coreUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_coreUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _coreUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coreUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _coreUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _coreUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coreUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coreUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_coreUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_coreUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coreUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CoreUpdateWrapper((CoreUpdate)_coreUpdate.clone());
	}

	@Override
	public int compareTo(at.rdconnect.update.model.CoreUpdate coreUpdate) {
		return _coreUpdate.compareTo(coreUpdate);
	}

	@Override
	public int hashCode() {
		return _coreUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.rdconnect.update.model.CoreUpdate> toCacheModel() {
		return _coreUpdate.toCacheModel();
	}

	@Override
	public at.rdconnect.update.model.CoreUpdate toEscapedModel() {
		return new CoreUpdateWrapper(_coreUpdate.toEscapedModel());
	}

	@Override
	public at.rdconnect.update.model.CoreUpdate toUnescapedModel() {
		return new CoreUpdateWrapper(_coreUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coreUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coreUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coreUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoreUpdateWrapper)) {
			return false;
		}

		CoreUpdateWrapper coreUpdateWrapper = (CoreUpdateWrapper)obj;

		if (Validator.equals(_coreUpdate, coreUpdateWrapper._coreUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CoreUpdate getWrappedCoreUpdate() {
		return _coreUpdate;
	}

	@Override
	public CoreUpdate getWrappedModel() {
		return _coreUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_coreUpdate.resetOriginalValues();
	}

	private CoreUpdate _coreUpdate;
}