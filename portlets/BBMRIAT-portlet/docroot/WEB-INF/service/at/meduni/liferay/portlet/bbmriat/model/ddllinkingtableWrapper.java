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

package at.meduni.liferay.portlet.bbmriat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ddllinkingtable}.
 * </p>
 *
 * @author Robert Reihs
 * @see ddllinkingtable
 * @generated
 */
public class ddllinkingtableWrapper implements ddllinkingtable,
	ModelWrapper<ddllinkingtable> {
	public ddllinkingtableWrapper(ddllinkingtable ddllinkingtable) {
		_ddllinkingtable = ddllinkingtable;
	}

	@Override
	public Class<?> getModelClass() {
		return ddllinkingtable.class;
	}

	@Override
	public String getModelClassName() {
		return ddllinkingtable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddllinkingtable", getDdllinkingtable());
		attributes.put("recordid", getRecordid());
		attributes.put("recordsetid", getRecordsetid());
		attributes.put("linkrecordid", getLinkrecordid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddllinkingtable = (Long)attributes.get("ddllinkingtable");

		if (ddllinkingtable != null) {
			setDdllinkingtable(ddllinkingtable);
		}

		Long recordid = (Long)attributes.get("recordid");

		if (recordid != null) {
			setRecordid(recordid);
		}

		Long recordsetid = (Long)attributes.get("recordsetid");

		if (recordsetid != null) {
			setRecordsetid(recordsetid);
		}

		Long linkrecordid = (Long)attributes.get("linkrecordid");

		if (linkrecordid != null) {
			setLinkrecordid(linkrecordid);
		}
	}

	/**
	* Returns the primary key of this ddllinkingtable.
	*
	* @return the primary key of this ddllinkingtable
	*/
	@Override
	public long getPrimaryKey() {
		return _ddllinkingtable.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ddllinkingtable.
	*
	* @param primaryKey the primary key of this ddllinkingtable
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ddllinkingtable.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ddllinkingtable of this ddllinkingtable.
	*
	* @return the ddllinkingtable of this ddllinkingtable
	*/
	@Override
	public long getDdllinkingtable() {
		return _ddllinkingtable.getDdllinkingtable();
	}

	/**
	* Sets the ddllinkingtable of this ddllinkingtable.
	*
	* @param ddllinkingtable the ddllinkingtable of this ddllinkingtable
	*/
	@Override
	public void setDdllinkingtable(long ddllinkingtable) {
		_ddllinkingtable.setDdllinkingtable(ddllinkingtable);
	}

	/**
	* Returns the recordid of this ddllinkingtable.
	*
	* @return the recordid of this ddllinkingtable
	*/
	@Override
	public long getRecordid() {
		return _ddllinkingtable.getRecordid();
	}

	/**
	* Sets the recordid of this ddllinkingtable.
	*
	* @param recordid the recordid of this ddllinkingtable
	*/
	@Override
	public void setRecordid(long recordid) {
		_ddllinkingtable.setRecordid(recordid);
	}

	/**
	* Returns the recordsetid of this ddllinkingtable.
	*
	* @return the recordsetid of this ddllinkingtable
	*/
	@Override
	public long getRecordsetid() {
		return _ddllinkingtable.getRecordsetid();
	}

	/**
	* Sets the recordsetid of this ddllinkingtable.
	*
	* @param recordsetid the recordsetid of this ddllinkingtable
	*/
	@Override
	public void setRecordsetid(long recordsetid) {
		_ddllinkingtable.setRecordsetid(recordsetid);
	}

	/**
	* Returns the linkrecordid of this ddllinkingtable.
	*
	* @return the linkrecordid of this ddllinkingtable
	*/
	@Override
	public long getLinkrecordid() {
		return _ddllinkingtable.getLinkrecordid();
	}

	/**
	* Sets the linkrecordid of this ddllinkingtable.
	*
	* @param linkrecordid the linkrecordid of this ddllinkingtable
	*/
	@Override
	public void setLinkrecordid(long linkrecordid) {
		_ddllinkingtable.setLinkrecordid(linkrecordid);
	}

	@Override
	public boolean isNew() {
		return _ddllinkingtable.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ddllinkingtable.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ddllinkingtable.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ddllinkingtable.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ddllinkingtable.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ddllinkingtable.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ddllinkingtable.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ddllinkingtable.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ddllinkingtable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ddllinkingtable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ddllinkingtable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ddllinkingtableWrapper((ddllinkingtable)_ddllinkingtable.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable) {
		return _ddllinkingtable.compareTo(ddllinkingtable);
	}

	@Override
	public int hashCode() {
		return _ddllinkingtable.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> toCacheModel() {
		return _ddllinkingtable.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable toEscapedModel() {
		return new ddllinkingtableWrapper(_ddllinkingtable.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable toUnescapedModel() {
		return new ddllinkingtableWrapper(_ddllinkingtable.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ddllinkingtable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ddllinkingtable.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ddllinkingtable.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ddllinkingtableWrapper)) {
			return false;
		}

		ddllinkingtableWrapper ddllinkingtableWrapper = (ddllinkingtableWrapper)obj;

		if (Validator.equals(_ddllinkingtable,
					ddllinkingtableWrapper._ddllinkingtable)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ddllinkingtable getWrappedddllinkingtable() {
		return _ddllinkingtable;
	}

	@Override
	public ddllinkingtable getWrappedModel() {
		return _ddllinkingtable;
	}

	@Override
	public void resetOriginalValues() {
		_ddllinkingtable.resetOriginalValues();
	}

	private ddllinkingtable _ddllinkingtable;
}