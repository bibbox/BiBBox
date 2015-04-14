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

package at.meduni.liferay.portlet.bbmrieric.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LDAPlog}.
 * </p>
 *
 * @author reihsr
 * @see LDAPlog
 * @generated
 */
public class LDAPlogWrapper implements LDAPlog, ModelWrapper<LDAPlog> {
	public LDAPlogWrapper(LDAPlog ldaPlog) {
		_ldaPlog = ldaPlog;
	}

	@Override
	public Class<?> getModelClass() {
		return LDAPlog.class;
	}

	@Override
	public String getModelClassName() {
		return LDAPlog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ldaplogId", getLdaplogId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ldaplogId = (Long)attributes.get("ldaplogId");

		if (ldaplogId != null) {
			setLdaplogId(ldaplogId);
		}
	}

	/**
	* Returns the primary key of this l d a plog.
	*
	* @return the primary key of this l d a plog
	*/
	@Override
	public long getPrimaryKey() {
		return _ldaPlog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l d a plog.
	*
	* @param primaryKey the primary key of this l d a plog
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ldaPlog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ldaplog ID of this l d a plog.
	*
	* @return the ldaplog ID of this l d a plog
	*/
	@Override
	public long getLdaplogId() {
		return _ldaPlog.getLdaplogId();
	}

	/**
	* Sets the ldaplog ID of this l d a plog.
	*
	* @param ldaplogId the ldaplog ID of this l d a plog
	*/
	@Override
	public void setLdaplogId(long ldaplogId) {
		_ldaPlog.setLdaplogId(ldaplogId);
	}

	@Override
	public boolean isNew() {
		return _ldaPlog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ldaPlog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ldaPlog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ldaPlog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ldaPlog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ldaPlog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ldaPlog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ldaPlog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ldaPlog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ldaPlog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ldaPlog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LDAPlogWrapper((LDAPlog)_ldaPlog.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog) {
		return _ldaPlog.compareTo(ldaPlog);
	}

	@Override
	public int hashCode() {
		return _ldaPlog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> toCacheModel() {
		return _ldaPlog.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog toEscapedModel() {
		return new LDAPlogWrapper(_ldaPlog.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog toUnescapedModel() {
		return new LDAPlogWrapper(_ldaPlog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ldaPlog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ldaPlog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ldaPlog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LDAPlogWrapper)) {
			return false;
		}

		LDAPlogWrapper ldaPlogWrapper = (LDAPlogWrapper)obj;

		if (Validator.equals(_ldaPlog, ldaPlogWrapper._ldaPlog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LDAPlog getWrappedLDAPlog() {
		return _ldaPlog;
	}

	@Override
	public LDAPlog getWrappedModel() {
		return _ldaPlog;
	}

	@Override
	public void resetOriginalValues() {
		_ldaPlog.resetOriginalValues();
	}

	private LDAPlog _ldaPlog;
}