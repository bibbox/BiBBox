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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author reihsr
 * @see Event
 * @generated
 */
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("patientId", getPatientId());
		attributes.put("layoutId", getLayoutId());
		attributes.put("eventdate", getEventdate());
		attributes.put("eventtype", getEventtype());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		Date eventdate = (Date)attributes.get("eventdate");

		if (eventdate != null) {
			setEventdate(eventdate);
		}

		String eventtype = (String)attributes.get("eventtype");

		if (eventtype != null) {
			setEventtype(eventtype);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event ID of this event.
	*
	* @return the event ID of this event
	*/
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	* Sets the event ID of this event.
	*
	* @param eventId the event ID of this event
	*/
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	/**
	* Returns the patient ID of this event.
	*
	* @return the patient ID of this event
	*/
	@Override
	public long getPatientId() {
		return _event.getPatientId();
	}

	/**
	* Sets the patient ID of this event.
	*
	* @param patientId the patient ID of this event
	*/
	@Override
	public void setPatientId(long patientId) {
		_event.setPatientId(patientId);
	}

	/**
	* Returns the layout ID of this event.
	*
	* @return the layout ID of this event
	*/
	@Override
	public long getLayoutId() {
		return _event.getLayoutId();
	}

	/**
	* Sets the layout ID of this event.
	*
	* @param layoutId the layout ID of this event
	*/
	@Override
	public void setLayoutId(long layoutId) {
		_event.setLayoutId(layoutId);
	}

	/**
	* Returns the eventdate of this event.
	*
	* @return the eventdate of this event
	*/
	@Override
	public java.util.Date getEventdate() {
		return _event.getEventdate();
	}

	/**
	* Sets the eventdate of this event.
	*
	* @param eventdate the eventdate of this event
	*/
	@Override
	public void setEventdate(java.util.Date eventdate) {
		_event.setEventdate(eventdate);
	}

	/**
	* Returns the eventtype of this event.
	*
	* @return the eventtype of this event
	*/
	@Override
	public java.lang.String getEventtype() {
		return _event.getEventtype();
	}

	/**
	* Sets the eventtype of this event.
	*
	* @param eventtype the eventtype of this event
	*/
	@Override
	public void setEventtype(java.lang.String eventtype) {
		_event.setEventtype(eventtype);
	}

	/**
	* Returns the status of this event.
	*
	* @return the status of this event
	*/
	@Override
	public java.lang.String getStatus() {
		return _event.getStatus();
	}

	/**
	* Sets the status of this event.
	*
	* @param status the status of this event
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_event.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event event) {
		return _event.compareTo(event);
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_event.persist();
	}

	@Override
	public java.lang.String getEventGroup() {
		return _event.getEventGroup();
	}

	@Override
	public java.lang.String getPatientName() {
		return _event.getPatientName();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Validator.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Event getWrappedEvent() {
		return _event;
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private Event _event;
}