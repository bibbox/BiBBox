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

package at.graz.meduni.liferay.portlet.bbmriat.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Organizationlink}.
 * </p>
 *
 * @author Reihs Robert
 * @see Organizationlink
 * @generated
 */
public class OrganizationlinkWrapper implements Organizationlink,
	ModelWrapper<Organizationlink> {
	public OrganizationlinkWrapper(Organizationlink organizationlink) {
		_organizationlink = organizationlink;
	}

	@Override
	public Class<?> getModelClass() {
		return Organizationlink.class;
	}

	@Override
	public String getModelClassName() {
		return Organizationlink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizationlinkId", getOrganizationlinkId());
		attributes.put("parentorganizationId", getParentorganizationId());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizationlinkId = (Long)attributes.get("organizationlinkId");

		if (organizationlinkId != null) {
			setOrganizationlinkId(organizationlinkId);
		}

		Long parentorganizationId = (Long)attributes.get("parentorganizationId");

		if (parentorganizationId != null) {
			setParentorganizationId(parentorganizationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	/**
	* Returns the primary key of this organizationlink.
	*
	* @return the primary key of this organizationlink
	*/
	@Override
	public long getPrimaryKey() {
		return _organizationlink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organizationlink.
	*
	* @param primaryKey the primary key of this organizationlink
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organizationlink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the organizationlink ID of this organizationlink.
	*
	* @return the organizationlink ID of this organizationlink
	*/
	@Override
	public long getOrganizationlinkId() {
		return _organizationlink.getOrganizationlinkId();
	}

	/**
	* Sets the organizationlink ID of this organizationlink.
	*
	* @param organizationlinkId the organizationlink ID of this organizationlink
	*/
	@Override
	public void setOrganizationlinkId(long organizationlinkId) {
		_organizationlink.setOrganizationlinkId(organizationlinkId);
	}

	/**
	* Returns the parentorganization ID of this organizationlink.
	*
	* @return the parentorganization ID of this organizationlink
	*/
	@Override
	public long getParentorganizationId() {
		return _organizationlink.getParentorganizationId();
	}

	/**
	* Sets the parentorganization ID of this organizationlink.
	*
	* @param parentorganizationId the parentorganization ID of this organizationlink
	*/
	@Override
	public void setParentorganizationId(long parentorganizationId) {
		_organizationlink.setParentorganizationId(parentorganizationId);
	}

	/**
	* Returns the organization ID of this organizationlink.
	*
	* @return the organization ID of this organizationlink
	*/
	@Override
	public long getOrganizationId() {
		return _organizationlink.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organizationlink.
	*
	* @param organizationId the organization ID of this organizationlink
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_organizationlink.setOrganizationId(organizationId);
	}

	@Override
	public boolean isNew() {
		return _organizationlink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organizationlink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organizationlink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organizationlink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organizationlink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organizationlink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizationlink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizationlink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organizationlink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organizationlink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizationlink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationlinkWrapper((Organizationlink)_organizationlink.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink organizationlink) {
		return _organizationlink.compareTo(organizationlink);
	}

	@Override
	public int hashCode() {
		return _organizationlink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink> toCacheModel() {
		return _organizationlink.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink toEscapedModel() {
		return new OrganizationlinkWrapper(_organizationlink.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink toUnescapedModel() {
		return new OrganizationlinkWrapper(_organizationlink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizationlink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organizationlink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizationlink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationlinkWrapper)) {
			return false;
		}

		OrganizationlinkWrapper organizationlinkWrapper = (OrganizationlinkWrapper)obj;

		if (Validator.equals(_organizationlink,
					organizationlinkWrapper._organizationlink)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Organizationlink getWrappedOrganizationlink() {
		return _organizationlink;
	}

	@Override
	public Organizationlink getWrappedModel() {
		return _organizationlink;
	}

	@Override
	public void resetOriginalValues() {
		_organizationlink.resetOriginalValues();
	}

	private Organizationlink _organizationlink;
}