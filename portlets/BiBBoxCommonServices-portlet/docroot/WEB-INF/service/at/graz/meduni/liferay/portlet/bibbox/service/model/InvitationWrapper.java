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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Invitation}.
 * </p>
 *
 * @author reihsr
 * @see Invitation
 * @generated
 */
public class InvitationWrapper implements Invitation, ModelWrapper<Invitation> {
	public InvitationWrapper(Invitation invitation) {
		_invitation = invitation;
	}

	@Override
	public Class<?> getModelClass() {
		return Invitation.class;
	}

	@Override
	public String getModelClassName() {
		return Invitation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invitationID", getInvitationID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationID = (Long)attributes.get("invitationID");

		if (invitationID != null) {
			setInvitationID(invitationID);
		}
	}

	/**
	* Returns the primary key of this invitation.
	*
	* @return the primary key of this invitation
	*/
	@Override
	public long getPrimaryKey() {
		return _invitation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this invitation.
	*
	* @param primaryKey the primary key of this invitation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_invitation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the invitation i d of this invitation.
	*
	* @return the invitation i d of this invitation
	*/
	@Override
	public long getInvitationID() {
		return _invitation.getInvitationID();
	}

	/**
	* Sets the invitation i d of this invitation.
	*
	* @param invitationID the invitation i d of this invitation
	*/
	@Override
	public void setInvitationID(long invitationID) {
		_invitation.setInvitationID(invitationID);
	}

	@Override
	public boolean isNew() {
		return _invitation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_invitation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _invitation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_invitation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _invitation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _invitation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_invitation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _invitation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_invitation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_invitation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InvitationWrapper((Invitation)_invitation.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation) {
		return _invitation.compareTo(invitation);
	}

	@Override
	public int hashCode() {
		return _invitation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation> toCacheModel() {
		return _invitation.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation toEscapedModel() {
		return new InvitationWrapper(_invitation.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation toUnescapedModel() {
		return new InvitationWrapper(_invitation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _invitation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _invitation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_invitation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitationWrapper)) {
			return false;
		}

		InvitationWrapper invitationWrapper = (InvitationWrapper)obj;

		if (Validator.equals(_invitation, invitationWrapper._invitation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Invitation getWrappedInvitation() {
		return _invitation;
	}

	@Override
	public Invitation getWrappedModel() {
		return _invitation;
	}

	@Override
	public void resetOriginalValues() {
		_invitation.resetOriginalValues();
	}

	private Invitation _invitation;
}