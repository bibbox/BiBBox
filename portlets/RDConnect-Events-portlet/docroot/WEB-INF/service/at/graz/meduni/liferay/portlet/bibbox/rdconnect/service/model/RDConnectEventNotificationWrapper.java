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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RDConnectEventNotification}.
 * </p>
 *
 * @author reihsr
 * @see RDConnectEventNotification
 * @generated
 */
public class RDConnectEventNotificationWrapper
	implements RDConnectEventNotification,
		ModelWrapper<RDConnectEventNotification> {
	public RDConnectEventNotificationWrapper(
		RDConnectEventNotification rdConnectEventNotification) {
		_rdConnectEventNotification = rdConnectEventNotification;
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectEventNotification.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectEventNotification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventnotificationId", getEventnotificationId());
		attributes.put("notificationtype", getNotificationtype());
		attributes.put("userId", getUserId());
		attributes.put("notificationselected", getNotificationselected());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventnotificationId = (Long)attributes.get("eventnotificationId");

		if (eventnotificationId != null) {
			setEventnotificationId(eventnotificationId);
		}

		String notificationtype = (String)attributes.get("notificationtype");

		if (notificationtype != null) {
			setNotificationtype(notificationtype);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean notificationselected = (Boolean)attributes.get(
				"notificationselected");

		if (notificationselected != null) {
			setNotificationselected(notificationselected);
		}
	}

	/**
	* Returns the primary key of this r d connect event notification.
	*
	* @return the primary key of this r d connect event notification
	*/
	@Override
	public long getPrimaryKey() {
		return _rdConnectEventNotification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d connect event notification.
	*
	* @param primaryKey the primary key of this r d connect event notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdConnectEventNotification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eventnotification ID of this r d connect event notification.
	*
	* @return the eventnotification ID of this r d connect event notification
	*/
	@Override
	public long getEventnotificationId() {
		return _rdConnectEventNotification.getEventnotificationId();
	}

	/**
	* Sets the eventnotification ID of this r d connect event notification.
	*
	* @param eventnotificationId the eventnotification ID of this r d connect event notification
	*/
	@Override
	public void setEventnotificationId(long eventnotificationId) {
		_rdConnectEventNotification.setEventnotificationId(eventnotificationId);
	}

	/**
	* Returns the notificationtype of this r d connect event notification.
	*
	* @return the notificationtype of this r d connect event notification
	*/
	@Override
	public java.lang.String getNotificationtype() {
		return _rdConnectEventNotification.getNotificationtype();
	}

	/**
	* Sets the notificationtype of this r d connect event notification.
	*
	* @param notificationtype the notificationtype of this r d connect event notification
	*/
	@Override
	public void setNotificationtype(java.lang.String notificationtype) {
		_rdConnectEventNotification.setNotificationtype(notificationtype);
	}

	/**
	* Returns the user ID of this r d connect event notification.
	*
	* @return the user ID of this r d connect event notification
	*/
	@Override
	public long getUserId() {
		return _rdConnectEventNotification.getUserId();
	}

	/**
	* Sets the user ID of this r d connect event notification.
	*
	* @param userId the user ID of this r d connect event notification
	*/
	@Override
	public void setUserId(long userId) {
		_rdConnectEventNotification.setUserId(userId);
	}

	/**
	* Returns the user uuid of this r d connect event notification.
	*
	* @return the user uuid of this r d connect event notification
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdConnectEventNotification.getUserUuid();
	}

	/**
	* Sets the user uuid of this r d connect event notification.
	*
	* @param userUuid the user uuid of this r d connect event notification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rdConnectEventNotification.setUserUuid(userUuid);
	}

	/**
	* Returns the notificationselected of this r d connect event notification.
	*
	* @return the notificationselected of this r d connect event notification
	*/
	@Override
	public boolean getNotificationselected() {
		return _rdConnectEventNotification.getNotificationselected();
	}

	/**
	* Returns <code>true</code> if this r d connect event notification is notificationselected.
	*
	* @return <code>true</code> if this r d connect event notification is notificationselected; <code>false</code> otherwise
	*/
	@Override
	public boolean isNotificationselected() {
		return _rdConnectEventNotification.isNotificationselected();
	}

	/**
	* Sets whether this r d connect event notification is notificationselected.
	*
	* @param notificationselected the notificationselected of this r d connect event notification
	*/
	@Override
	public void setNotificationselected(boolean notificationselected) {
		_rdConnectEventNotification.setNotificationselected(notificationselected);
	}

	@Override
	public boolean isNew() {
		return _rdConnectEventNotification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdConnectEventNotification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdConnectEventNotification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdConnectEventNotification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdConnectEventNotification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdConnectEventNotification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdConnectEventNotification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdConnectEventNotification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdConnectEventNotification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdConnectEventNotification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdConnectEventNotification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDConnectEventNotificationWrapper((RDConnectEventNotification)_rdConnectEventNotification.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification rdConnectEventNotification) {
		return _rdConnectEventNotification.compareTo(rdConnectEventNotification);
	}

	@Override
	public int hashCode() {
		return _rdConnectEventNotification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> toCacheModel() {
		return _rdConnectEventNotification.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification toEscapedModel() {
		return new RDConnectEventNotificationWrapper(_rdConnectEventNotification.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification toUnescapedModel() {
		return new RDConnectEventNotificationWrapper(_rdConnectEventNotification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdConnectEventNotification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdConnectEventNotification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdConnectEventNotification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDConnectEventNotificationWrapper)) {
			return false;
		}

		RDConnectEventNotificationWrapper rdConnectEventNotificationWrapper = (RDConnectEventNotificationWrapper)obj;

		if (Validator.equals(_rdConnectEventNotification,
					rdConnectEventNotificationWrapper._rdConnectEventNotification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDConnectEventNotification getWrappedRDConnectEventNotification() {
		return _rdConnectEventNotification;
	}

	@Override
	public RDConnectEventNotification getWrappedModel() {
		return _rdConnectEventNotification;
	}

	@Override
	public void resetOriginalValues() {
		_rdConnectEventNotification.resetOriginalValues();
	}

	private RDConnectEventNotification _rdConnectEventNotification;
}