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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RDConnectEvent}.
 * </p>
 *
 * @author reihsr
 * @see RDConnectEvent
 * @generated
 */
public class RDConnectEventWrapper implements RDConnectEvent,
	ModelWrapper<RDConnectEvent> {
	public RDConnectEventWrapper(RDConnectEvent rdConnectEvent) {
		_rdConnectEvent = rdConnectEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("eventdate", getEventdate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("shorttext", getShorttext());
		attributes.put("longtext", getLongtext());
		attributes.put("link", getLink());
		attributes.put("restricted", getRestricted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Date eventdate = (Date)attributes.get("eventdate");

		if (eventdate != null) {
			setEventdate(eventdate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String shorttext = (String)attributes.get("shorttext");

		if (shorttext != null) {
			setShorttext(shorttext);
		}

		String longtext = (String)attributes.get("longtext");

		if (longtext != null) {
			setLongtext(longtext);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String restricted = (String)attributes.get("restricted");

		if (restricted != null) {
			setRestricted(restricted);
		}
	}

	/**
	* Returns the primary key of this r d connect event.
	*
	* @return the primary key of this r d connect event
	*/
	@Override
	public long getPrimaryKey() {
		return _rdConnectEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d connect event.
	*
	* @param primaryKey the primary key of this r d connect event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdConnectEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event ID of this r d connect event.
	*
	* @return the event ID of this r d connect event
	*/
	@Override
	public long getEventId() {
		return _rdConnectEvent.getEventId();
	}

	/**
	* Sets the event ID of this r d connect event.
	*
	* @param eventId the event ID of this r d connect event
	*/
	@Override
	public void setEventId(long eventId) {
		_rdConnectEvent.setEventId(eventId);
	}

	/**
	* Returns the eventdate of this r d connect event.
	*
	* @return the eventdate of this r d connect event
	*/
	@Override
	public java.util.Date getEventdate() {
		return _rdConnectEvent.getEventdate();
	}

	/**
	* Sets the eventdate of this r d connect event.
	*
	* @param eventdate the eventdate of this r d connect event
	*/
	@Override
	public void setEventdate(java.util.Date eventdate) {
		_rdConnectEvent.setEventdate(eventdate);
	}

	/**
	* Returns the organization ID of this r d connect event.
	*
	* @return the organization ID of this r d connect event
	*/
	@Override
	public long getOrganizationId() {
		return _rdConnectEvent.getOrganizationId();
	}

	/**
	* Sets the organization ID of this r d connect event.
	*
	* @param organizationId the organization ID of this r d connect event
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_rdConnectEvent.setOrganizationId(organizationId);
	}

	/**
	* Returns the user ID of this r d connect event.
	*
	* @return the user ID of this r d connect event
	*/
	@Override
	public long getUserId() {
		return _rdConnectEvent.getUserId();
	}

	/**
	* Sets the user ID of this r d connect event.
	*
	* @param userId the user ID of this r d connect event
	*/
	@Override
	public void setUserId(long userId) {
		_rdConnectEvent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this r d connect event.
	*
	* @return the user uuid of this r d connect event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEvent.getUserUuid();
	}

	/**
	* Sets the user uuid of this r d connect event.
	*
	* @param userUuid the user uuid of this r d connect event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rdConnectEvent.setUserUuid(userUuid);
	}

	/**
	* Returns the shorttext of this r d connect event.
	*
	* @return the shorttext of this r d connect event
	*/
	@Override
	public java.lang.String getShorttext() {
		return _rdConnectEvent.getShorttext();
	}

	/**
	* Sets the shorttext of this r d connect event.
	*
	* @param shorttext the shorttext of this r d connect event
	*/
	@Override
	public void setShorttext(java.lang.String shorttext) {
		_rdConnectEvent.setShorttext(shorttext);
	}

	/**
	* Returns the longtext of this r d connect event.
	*
	* @return the longtext of this r d connect event
	*/
	@Override
	public java.lang.String getLongtext() {
		return _rdConnectEvent.getLongtext();
	}

	/**
	* Sets the longtext of this r d connect event.
	*
	* @param longtext the longtext of this r d connect event
	*/
	@Override
	public void setLongtext(java.lang.String longtext) {
		_rdConnectEvent.setLongtext(longtext);
	}

	/**
	* Returns the link of this r d connect event.
	*
	* @return the link of this r d connect event
	*/
	@Override
	public java.lang.String getLink() {
		return _rdConnectEvent.getLink();
	}

	/**
	* Sets the link of this r d connect event.
	*
	* @param link the link of this r d connect event
	*/
	@Override
	public void setLink(java.lang.String link) {
		_rdConnectEvent.setLink(link);
	}

	/**
	* Returns the restricted of this r d connect event.
	*
	* @return the restricted of this r d connect event
	*/
	@Override
	public java.lang.String getRestricted() {
		return _rdConnectEvent.getRestricted();
	}

	/**
	* Sets the restricted of this r d connect event.
	*
	* @param restricted the restricted of this r d connect event
	*/
	@Override
	public void setRestricted(java.lang.String restricted) {
		_rdConnectEvent.setRestricted(restricted);
	}

	@Override
	public boolean isNew() {
		return _rdConnectEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdConnectEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdConnectEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdConnectEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdConnectEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdConnectEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdConnectEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdConnectEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdConnectEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdConnectEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdConnectEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDConnectEventWrapper((RDConnectEvent)_rdConnectEvent.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent) {
		return _rdConnectEvent.compareTo(rdConnectEvent);
	}

	@Override
	public int hashCode() {
		return _rdConnectEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> toCacheModel() {
		return _rdConnectEvent.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent toEscapedModel() {
		return new RDConnectEventWrapper(_rdConnectEvent.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent toUnescapedModel() {
		return new RDConnectEventWrapper(_rdConnectEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdConnectEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdConnectEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdConnectEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDConnectEventWrapper)) {
			return false;
		}

		RDConnectEventWrapper rdConnectEventWrapper = (RDConnectEventWrapper)obj;

		if (Validator.equals(_rdConnectEvent,
					rdConnectEventWrapper._rdConnectEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDConnectEvent getWrappedRDConnectEvent() {
		return _rdConnectEvent;
	}

	@Override
	public RDConnectEvent getWrappedModel() {
		return _rdConnectEvent;
	}

	@Override
	public void resetOriginalValues() {
		_rdConnectEvent.resetOriginalValues();
	}

	private RDConnectEvent _rdConnectEvent;
}