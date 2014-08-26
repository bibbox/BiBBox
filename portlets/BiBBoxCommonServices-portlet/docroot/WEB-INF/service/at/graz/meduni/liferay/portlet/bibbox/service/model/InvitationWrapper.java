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

		attributes.put("invitationId", getInvitationId());
		attributes.put("name", getName());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("status", getStatus());
		attributes.put("invitationsend", getInvitationsend());
		attributes.put("lastchanged", getLastchanged());
		attributes.put("lastchanger", getLastchanger());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationId = (Long)attributes.get("invitationId");

		if (invitationId != null) {
			setInvitationId(invitationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date invitationsend = (Date)attributes.get("invitationsend");

		if (invitationsend != null) {
			setInvitationsend(invitationsend);
		}

		Date lastchanged = (Date)attributes.get("lastchanged");

		if (lastchanged != null) {
			setLastchanged(lastchanged);
		}

		Long lastchanger = (Long)attributes.get("lastchanger");

		if (lastchanger != null) {
			setLastchanger(lastchanger);
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
	* Returns the invitation ID of this invitation.
	*
	* @return the invitation ID of this invitation
	*/
	@Override
	public long getInvitationId() {
		return _invitation.getInvitationId();
	}

	/**
	* Sets the invitation ID of this invitation.
	*
	* @param invitationId the invitation ID of this invitation
	*/
	@Override
	public void setInvitationId(long invitationId) {
		_invitation.setInvitationId(invitationId);
	}

	/**
	* Returns the name of this invitation.
	*
	* @return the name of this invitation
	*/
	@Override
	public java.lang.String getName() {
		return _invitation.getName();
	}

	/**
	* Sets the name of this invitation.
	*
	* @param name the name of this invitation
	*/
	@Override
	public void setName(java.lang.String name) {
		_invitation.setName(name);
	}

	/**
	* Returns the subject of this invitation.
	*
	* @return the subject of this invitation
	*/
	@Override
	public java.lang.String getSubject() {
		return _invitation.getSubject();
	}

	/**
	* Sets the subject of this invitation.
	*
	* @param subject the subject of this invitation
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_invitation.setSubject(subject);
	}

	/**
	* Returns the body of this invitation.
	*
	* @return the body of this invitation
	*/
	@Override
	public java.lang.String getBody() {
		return _invitation.getBody();
	}

	/**
	* Sets the body of this invitation.
	*
	* @param body the body of this invitation
	*/
	@Override
	public void setBody(java.lang.String body) {
		_invitation.setBody(body);
	}

	/**
	* Returns the status of this invitation.
	*
	* @return the status of this invitation
	*/
	@Override
	public long getStatus() {
		return _invitation.getStatus();
	}

	/**
	* Sets the status of this invitation.
	*
	* @param status the status of this invitation
	*/
	@Override
	public void setStatus(long status) {
		_invitation.setStatus(status);
	}

	/**
	* Returns the invitationsend of this invitation.
	*
	* @return the invitationsend of this invitation
	*/
	@Override
	public java.util.Date getInvitationsend() {
		return _invitation.getInvitationsend();
	}

	/**
	* Sets the invitationsend of this invitation.
	*
	* @param invitationsend the invitationsend of this invitation
	*/
	@Override
	public void setInvitationsend(java.util.Date invitationsend) {
		_invitation.setInvitationsend(invitationsend);
	}

	/**
	* Returns the lastchanged of this invitation.
	*
	* @return the lastchanged of this invitation
	*/
	@Override
	public java.util.Date getLastchanged() {
		return _invitation.getLastchanged();
	}

	/**
	* Sets the lastchanged of this invitation.
	*
	* @param lastchanged the lastchanged of this invitation
	*/
	@Override
	public void setLastchanged(java.util.Date lastchanged) {
		_invitation.setLastchanged(lastchanged);
	}

	/**
	* Returns the lastchanger of this invitation.
	*
	* @return the lastchanger of this invitation
	*/
	@Override
	public long getLastchanger() {
		return _invitation.getLastchanger();
	}

	/**
	* Sets the lastchanger of this invitation.
	*
	* @param lastchanger the lastchanger of this invitation
	*/
	@Override
	public void setLastchanger(long lastchanger) {
		_invitation.setLastchanger(lastchanger);
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