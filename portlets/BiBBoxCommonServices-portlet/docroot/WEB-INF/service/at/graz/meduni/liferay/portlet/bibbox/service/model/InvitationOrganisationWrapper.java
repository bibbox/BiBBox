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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InvitationOrganisation}.
 * </p>
 *
 * @author reihsr
 * @see InvitationOrganisation
 * @generated
 */
public class InvitationOrganisationWrapper implements InvitationOrganisation,
	ModelWrapper<InvitationOrganisation> {
	public InvitationOrganisationWrapper(
		InvitationOrganisation invitationOrganisation) {
		_invitationOrganisation = invitationOrganisation;
	}

	@Override
	public Class<?> getModelClass() {
		return InvitationOrganisation.class;
	}

	@Override
	public String getModelClassName() {
		return InvitationOrganisation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invitationOrganisationId", getInvitationOrganisationId());
		attributes.put("invitationId", getInvitationId());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("userId", getUserId());
		attributes.put("lastchanged", getLastchanged());
		attributes.put("lastchanger", getLastchanger());
		attributes.put("reactdate", getReactdate());
		attributes.put("lastusedlink", getLastusedlink());
		attributes.put("rejectdate", getRejectdate());
		attributes.put("securitylinktoken", getSecuritylinktoken());
		attributes.put("securitytoken", getSecuritytoken());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationOrganisationId = (Long)attributes.get(
				"invitationOrganisationId");

		if (invitationOrganisationId != null) {
			setInvitationOrganisationId(invitationOrganisationId);
		}

		Long invitationId = (Long)attributes.get("invitationId");

		if (invitationId != null) {
			setInvitationId(invitationId);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date lastchanged = (Date)attributes.get("lastchanged");

		if (lastchanged != null) {
			setLastchanged(lastchanged);
		}

		Long lastchanger = (Long)attributes.get("lastchanger");

		if (lastchanger != null) {
			setLastchanger(lastchanger);
		}

		Date reactdate = (Date)attributes.get("reactdate");

		if (reactdate != null) {
			setReactdate(reactdate);
		}

		Date lastusedlink = (Date)attributes.get("lastusedlink");

		if (lastusedlink != null) {
			setLastusedlink(lastusedlink);
		}

		Date rejectdate = (Date)attributes.get("rejectdate");

		if (rejectdate != null) {
			setRejectdate(rejectdate);
		}

		Long securitylinktoken = (Long)attributes.get("securitylinktoken");

		if (securitylinktoken != null) {
			setSecuritylinktoken(securitylinktoken);
		}

		Long securitytoken = (Long)attributes.get("securitytoken");

		if (securitytoken != null) {
			setSecuritytoken(securitytoken);
		}
	}

	/**
	* Returns the primary key of this invitation organisation.
	*
	* @return the primary key of this invitation organisation
	*/
	@Override
	public long getPrimaryKey() {
		return _invitationOrganisation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this invitation organisation.
	*
	* @param primaryKey the primary key of this invitation organisation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_invitationOrganisation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the invitation organisation ID of this invitation organisation.
	*
	* @return the invitation organisation ID of this invitation organisation
	*/
	@Override
	public long getInvitationOrganisationId() {
		return _invitationOrganisation.getInvitationOrganisationId();
	}

	/**
	* Sets the invitation organisation ID of this invitation organisation.
	*
	* @param invitationOrganisationId the invitation organisation ID of this invitation organisation
	*/
	@Override
	public void setInvitationOrganisationId(long invitationOrganisationId) {
		_invitationOrganisation.setInvitationOrganisationId(invitationOrganisationId);
	}

	/**
	* Returns the invitation ID of this invitation organisation.
	*
	* @return the invitation ID of this invitation organisation
	*/
	@Override
	public long getInvitationId() {
		return _invitationOrganisation.getInvitationId();
	}

	/**
	* Sets the invitation ID of this invitation organisation.
	*
	* @param invitationId the invitation ID of this invitation organisation
	*/
	@Override
	public void setInvitationId(long invitationId) {
		_invitationOrganisation.setInvitationId(invitationId);
	}

	/**
	* Returns the organisation ID of this invitation organisation.
	*
	* @return the organisation ID of this invitation organisation
	*/
	@Override
	public long getOrganisationId() {
		return _invitationOrganisation.getOrganisationId();
	}

	/**
	* Sets the organisation ID of this invitation organisation.
	*
	* @param organisationId the organisation ID of this invitation organisation
	*/
	@Override
	public void setOrganisationId(long organisationId) {
		_invitationOrganisation.setOrganisationId(organisationId);
	}

	/**
	* Returns the user ID of this invitation organisation.
	*
	* @return the user ID of this invitation organisation
	*/
	@Override
	public long getUserId() {
		return _invitationOrganisation.getUserId();
	}

	/**
	* Sets the user ID of this invitation organisation.
	*
	* @param userId the user ID of this invitation organisation
	*/
	@Override
	public void setUserId(long userId) {
		_invitationOrganisation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this invitation organisation.
	*
	* @return the user uuid of this invitation organisation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationOrganisation.getUserUuid();
	}

	/**
	* Sets the user uuid of this invitation organisation.
	*
	* @param userUuid the user uuid of this invitation organisation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_invitationOrganisation.setUserUuid(userUuid);
	}

	/**
	* Returns the lastchanged of this invitation organisation.
	*
	* @return the lastchanged of this invitation organisation
	*/
	@Override
	public java.util.Date getLastchanged() {
		return _invitationOrganisation.getLastchanged();
	}

	/**
	* Sets the lastchanged of this invitation organisation.
	*
	* @param lastchanged the lastchanged of this invitation organisation
	*/
	@Override
	public void setLastchanged(java.util.Date lastchanged) {
		_invitationOrganisation.setLastchanged(lastchanged);
	}

	/**
	* Returns the lastchanger of this invitation organisation.
	*
	* @return the lastchanger of this invitation organisation
	*/
	@Override
	public long getLastchanger() {
		return _invitationOrganisation.getLastchanger();
	}

	/**
	* Sets the lastchanger of this invitation organisation.
	*
	* @param lastchanger the lastchanger of this invitation organisation
	*/
	@Override
	public void setLastchanger(long lastchanger) {
		_invitationOrganisation.setLastchanger(lastchanger);
	}

	/**
	* Returns the reactdate of this invitation organisation.
	*
	* @return the reactdate of this invitation organisation
	*/
	@Override
	public java.util.Date getReactdate() {
		return _invitationOrganisation.getReactdate();
	}

	/**
	* Sets the reactdate of this invitation organisation.
	*
	* @param reactdate the reactdate of this invitation organisation
	*/
	@Override
	public void setReactdate(java.util.Date reactdate) {
		_invitationOrganisation.setReactdate(reactdate);
	}

	/**
	* Returns the lastusedlink of this invitation organisation.
	*
	* @return the lastusedlink of this invitation organisation
	*/
	@Override
	public java.util.Date getLastusedlink() {
		return _invitationOrganisation.getLastusedlink();
	}

	/**
	* Sets the lastusedlink of this invitation organisation.
	*
	* @param lastusedlink the lastusedlink of this invitation organisation
	*/
	@Override
	public void setLastusedlink(java.util.Date lastusedlink) {
		_invitationOrganisation.setLastusedlink(lastusedlink);
	}

	/**
	* Returns the rejectdate of this invitation organisation.
	*
	* @return the rejectdate of this invitation organisation
	*/
	@Override
	public java.util.Date getRejectdate() {
		return _invitationOrganisation.getRejectdate();
	}

	/**
	* Sets the rejectdate of this invitation organisation.
	*
	* @param rejectdate the rejectdate of this invitation organisation
	*/
	@Override
	public void setRejectdate(java.util.Date rejectdate) {
		_invitationOrganisation.setRejectdate(rejectdate);
	}

	/**
	* Returns the securitylinktoken of this invitation organisation.
	*
	* @return the securitylinktoken of this invitation organisation
	*/
	@Override
	public long getSecuritylinktoken() {
		return _invitationOrganisation.getSecuritylinktoken();
	}

	/**
	* Sets the securitylinktoken of this invitation organisation.
	*
	* @param securitylinktoken the securitylinktoken of this invitation organisation
	*/
	@Override
	public void setSecuritylinktoken(long securitylinktoken) {
		_invitationOrganisation.setSecuritylinktoken(securitylinktoken);
	}

	/**
	* Returns the securitytoken of this invitation organisation.
	*
	* @return the securitytoken of this invitation organisation
	*/
	@Override
	public long getSecuritytoken() {
		return _invitationOrganisation.getSecuritytoken();
	}

	/**
	* Sets the securitytoken of this invitation organisation.
	*
	* @param securitytoken the securitytoken of this invitation organisation
	*/
	@Override
	public void setSecuritytoken(long securitytoken) {
		_invitationOrganisation.setSecuritytoken(securitytoken);
	}

	@Override
	public boolean isNew() {
		return _invitationOrganisation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_invitationOrganisation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _invitationOrganisation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_invitationOrganisation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _invitationOrganisation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _invitationOrganisation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_invitationOrganisation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _invitationOrganisation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_invitationOrganisation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_invitationOrganisation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitationOrganisation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InvitationOrganisationWrapper((InvitationOrganisation)_invitationOrganisation.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation invitationOrganisation) {
		return _invitationOrganisation.compareTo(invitationOrganisation);
	}

	@Override
	public int hashCode() {
		return _invitationOrganisation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation> toCacheModel() {
		return _invitationOrganisation.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation toEscapedModel() {
		return new InvitationOrganisationWrapper(_invitationOrganisation.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation toUnescapedModel() {
		return new InvitationOrganisationWrapper(_invitationOrganisation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _invitationOrganisation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _invitationOrganisation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_invitationOrganisation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitationOrganisationWrapper)) {
			return false;
		}

		InvitationOrganisationWrapper invitationOrganisationWrapper = (InvitationOrganisationWrapper)obj;

		if (Validator.equals(_invitationOrganisation,
					invitationOrganisationWrapper._invitationOrganisation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InvitationOrganisation getWrappedInvitationOrganisation() {
		return _invitationOrganisation;
	}

	@Override
	public InvitationOrganisation getWrappedModel() {
		return _invitationOrganisation;
	}

	@Override
	public void resetOriginalValues() {
		_invitationOrganisation.resetOriginalValues();
	}

	private InvitationOrganisation _invitationOrganisation;
}