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

package at.meduni.liferay.portlet.rdconnect.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RDCOrganizationUserAccess}.
 * </p>
 *
 * @author Robert Reihs
 * @see RDCOrganizationUserAccess
 * @generated
 */
public class RDCOrganizationUserAccessWrapper
	implements RDCOrganizationUserAccess,
		ModelWrapper<RDCOrganizationUserAccess> {
	public RDCOrganizationUserAccessWrapper(
		RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		_rdcOrganizationUserAccess = rdcOrganizationUserAccess;
	}

	@Override
	public Class<?> getModelClass() {
		return RDCOrganizationUserAccess.class;
	}

	@Override
	public String getModelClassName() {
		return RDCOrganizationUserAccess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rdcorganizationuseraccessId",
			getRdcorganizationuseraccessId());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("userId", getUserId());
		attributes.put("ipaddress", getIpaddress());
		attributes.put("lastaccess", getLastaccess());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rdcorganizationuseraccessId = (Long)attributes.get(
				"rdcorganizationuseraccessId");

		if (rdcorganizationuseraccessId != null) {
			setRdcorganizationuseraccessId(rdcorganizationuseraccessId);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long ipaddress = (Long)attributes.get("ipaddress");

		if (ipaddress != null) {
			setIpaddress(ipaddress);
		}

		Date lastaccess = (Date)attributes.get("lastaccess");

		if (lastaccess != null) {
			setLastaccess(lastaccess);
		}
	}

	/**
	* Returns the primary key of this r d c organization user access.
	*
	* @return the primary key of this r d c organization user access
	*/
	@Override
	public long getPrimaryKey() {
		return _rdcOrganizationUserAccess.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d c organization user access.
	*
	* @param primaryKey the primary key of this r d c organization user access
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdcOrganizationUserAccess.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rdcorganizationuseraccess ID of this r d c organization user access.
	*
	* @return the rdcorganizationuseraccess ID of this r d c organization user access
	*/
	@Override
	public long getRdcorganizationuseraccessId() {
		return _rdcOrganizationUserAccess.getRdcorganizationuseraccessId();
	}

	/**
	* Sets the rdcorganizationuseraccess ID of this r d c organization user access.
	*
	* @param rdcorganizationuseraccessId the rdcorganizationuseraccess ID of this r d c organization user access
	*/
	@Override
	public void setRdcorganizationuseraccessId(long rdcorganizationuseraccessId) {
		_rdcOrganizationUserAccess.setRdcorganizationuseraccessId(rdcorganizationuseraccessId);
	}

	/**
	* Returns the organisation ID of this r d c organization user access.
	*
	* @return the organisation ID of this r d c organization user access
	*/
	@Override
	public long getOrganisationId() {
		return _rdcOrganizationUserAccess.getOrganisationId();
	}

	/**
	* Sets the organisation ID of this r d c organization user access.
	*
	* @param organisationId the organisation ID of this r d c organization user access
	*/
	@Override
	public void setOrganisationId(long organisationId) {
		_rdcOrganizationUserAccess.setOrganisationId(organisationId);
	}

	/**
	* Returns the user ID of this r d c organization user access.
	*
	* @return the user ID of this r d c organization user access
	*/
	@Override
	public long getUserId() {
		return _rdcOrganizationUserAccess.getUserId();
	}

	/**
	* Sets the user ID of this r d c organization user access.
	*
	* @param userId the user ID of this r d c organization user access
	*/
	@Override
	public void setUserId(long userId) {
		_rdcOrganizationUserAccess.setUserId(userId);
	}

	/**
	* Returns the user uuid of this r d c organization user access.
	*
	* @return the user uuid of this r d c organization user access
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdcOrganizationUserAccess.getUserUuid();
	}

	/**
	* Sets the user uuid of this r d c organization user access.
	*
	* @param userUuid the user uuid of this r d c organization user access
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rdcOrganizationUserAccess.setUserUuid(userUuid);
	}

	/**
	* Returns the ipaddress of this r d c organization user access.
	*
	* @return the ipaddress of this r d c organization user access
	*/
	@Override
	public long getIpaddress() {
		return _rdcOrganizationUserAccess.getIpaddress();
	}

	/**
	* Sets the ipaddress of this r d c organization user access.
	*
	* @param ipaddress the ipaddress of this r d c organization user access
	*/
	@Override
	public void setIpaddress(long ipaddress) {
		_rdcOrganizationUserAccess.setIpaddress(ipaddress);
	}

	/**
	* Returns the lastaccess of this r d c organization user access.
	*
	* @return the lastaccess of this r d c organization user access
	*/
	@Override
	public java.util.Date getLastaccess() {
		return _rdcOrganizationUserAccess.getLastaccess();
	}

	/**
	* Sets the lastaccess of this r d c organization user access.
	*
	* @param lastaccess the lastaccess of this r d c organization user access
	*/
	@Override
	public void setLastaccess(java.util.Date lastaccess) {
		_rdcOrganizationUserAccess.setLastaccess(lastaccess);
	}

	@Override
	public boolean isNew() {
		return _rdcOrganizationUserAccess.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdcOrganizationUserAccess.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdcOrganizationUserAccess.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdcOrganizationUserAccess.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdcOrganizationUserAccess.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdcOrganizationUserAccess.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdcOrganizationUserAccess.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdcOrganizationUserAccess.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdcOrganizationUserAccess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdcOrganizationUserAccess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdcOrganizationUserAccess.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDCOrganizationUserAccessWrapper((RDCOrganizationUserAccess)_rdcOrganizationUserAccess.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		return _rdcOrganizationUserAccess.compareTo(rdcOrganizationUserAccess);
	}

	@Override
	public int hashCode() {
		return _rdcOrganizationUserAccess.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> toCacheModel() {
		return _rdcOrganizationUserAccess.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess toEscapedModel() {
		return new RDCOrganizationUserAccessWrapper(_rdcOrganizationUserAccess.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess toUnescapedModel() {
		return new RDCOrganizationUserAccessWrapper(_rdcOrganizationUserAccess.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdcOrganizationUserAccess.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdcOrganizationUserAccess.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdcOrganizationUserAccess.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDCOrganizationUserAccessWrapper)) {
			return false;
		}

		RDCOrganizationUserAccessWrapper rdcOrganizationUserAccessWrapper = (RDCOrganizationUserAccessWrapper)obj;

		if (Validator.equals(_rdcOrganizationUserAccess,
					rdcOrganizationUserAccessWrapper._rdcOrganizationUserAccess)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDCOrganizationUserAccess getWrappedRDCOrganizationUserAccess() {
		return _rdcOrganizationUserAccess;
	}

	@Override
	public RDCOrganizationUserAccess getWrappedModel() {
		return _rdcOrganizationUserAccess;
	}

	@Override
	public void resetOriginalValues() {
		_rdcOrganizationUserAccess.resetOriginalValues();
	}

	private RDCOrganizationUserAccess _rdcOrganizationUserAccess;
}