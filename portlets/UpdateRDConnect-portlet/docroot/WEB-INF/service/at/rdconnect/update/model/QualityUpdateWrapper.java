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
 * This class is a wrapper for {@link QualityUpdate}.
 * </p>
 *
 * @author reihsr
 * @see QualityUpdate
 * @generated
 */
public class QualityUpdateWrapper implements QualityUpdate,
	ModelWrapper<QualityUpdate> {
	public QualityUpdateWrapper(QualityUpdate qualityUpdate) {
		_qualityUpdate = qualityUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return QualityUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return QualityUpdate.class.getName();
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
	* Returns the primary key of this quality update.
	*
	* @return the primary key of this quality update
	*/
	@Override
	public long getPrimaryKey() {
		return _qualityUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this quality update.
	*
	* @param primaryKey the primary key of this quality update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_qualityUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the coreid of this quality update.
	*
	* @return the coreid of this quality update
	*/
	@Override
	public long getCoreid() {
		return _qualityUpdate.getCoreid();
	}

	/**
	* Sets the coreid of this quality update.
	*
	* @param coreid the coreid of this quality update
	*/
	@Override
	public void setCoreid(long coreid) {
		_qualityUpdate.setCoreid(coreid);
	}

	/**
	* Returns the organizationid of this quality update.
	*
	* @return the organizationid of this quality update
	*/
	@Override
	public long getOrganizationid() {
		return _qualityUpdate.getOrganizationid();
	}

	/**
	* Sets the organizationid of this quality update.
	*
	* @param organizationid the organizationid of this quality update
	*/
	@Override
	public void setOrganizationid(long organizationid) {
		_qualityUpdate.setOrganizationid(organizationid);
	}

	/**
	* Returns the fieldname of this quality update.
	*
	* @return the fieldname of this quality update
	*/
	@Override
	public java.lang.String getFieldname() {
		return _qualityUpdate.getFieldname();
	}

	/**
	* Sets the fieldname of this quality update.
	*
	* @param fieldname the fieldname of this quality update
	*/
	@Override
	public void setFieldname(java.lang.String fieldname) {
		_qualityUpdate.setFieldname(fieldname);
	}

	/**
	* Returns the value of this quality update.
	*
	* @return the value of this quality update
	*/
	@Override
	public java.lang.String getValue() {
		return _qualityUpdate.getValue();
	}

	/**
	* Sets the value of this quality update.
	*
	* @param value the value of this quality update
	*/
	@Override
	public void setValue(java.lang.String value) {
		_qualityUpdate.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _qualityUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_qualityUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _qualityUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_qualityUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _qualityUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _qualityUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_qualityUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _qualityUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_qualityUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_qualityUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_qualityUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QualityUpdateWrapper((QualityUpdate)_qualityUpdate.clone());
	}

	@Override
	public int compareTo(at.rdconnect.update.model.QualityUpdate qualityUpdate) {
		return _qualityUpdate.compareTo(qualityUpdate);
	}

	@Override
	public int hashCode() {
		return _qualityUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.rdconnect.update.model.QualityUpdate> toCacheModel() {
		return _qualityUpdate.toCacheModel();
	}

	@Override
	public at.rdconnect.update.model.QualityUpdate toEscapedModel() {
		return new QualityUpdateWrapper(_qualityUpdate.toEscapedModel());
	}

	@Override
	public at.rdconnect.update.model.QualityUpdate toUnescapedModel() {
		return new QualityUpdateWrapper(_qualityUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _qualityUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _qualityUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_qualityUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QualityUpdateWrapper)) {
			return false;
		}

		QualityUpdateWrapper qualityUpdateWrapper = (QualityUpdateWrapper)obj;

		if (Validator.equals(_qualityUpdate, qualityUpdateWrapper._qualityUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public QualityUpdate getWrappedQualityUpdate() {
		return _qualityUpdate;
	}

	@Override
	public QualityUpdate getWrappedModel() {
		return _qualityUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_qualityUpdate.resetOriginalValues();
	}

	private QualityUpdate _qualityUpdate;
}