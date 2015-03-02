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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventData}.
 * </p>
 *
 * @author reihsr
 * @see EventData
 * @generated
 */
public class EventDataWrapper implements EventData, ModelWrapper<EventData> {
	public EventDataWrapper(EventData eventData) {
		_eventData = eventData;
	}

	@Override
	public Class<?> getModelClass() {
		return EventData.class;
	}

	@Override
	public String getModelClassName() {
		return EventData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventdataId", getEventdataId());
		attributes.put("eventlayoutId", getEventlayoutId());
		attributes.put("patientId", getPatientId());
		attributes.put("ontology", getOntology());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventdataId = (Long)attributes.get("eventdataId");

		if (eventdataId != null) {
			setEventdataId(eventdataId);
		}

		Long eventlayoutId = (Long)attributes.get("eventlayoutId");

		if (eventlayoutId != null) {
			setEventlayoutId(eventlayoutId);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		String ontology = (String)attributes.get("ontology");

		if (ontology != null) {
			setOntology(ontology);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this event data.
	*
	* @return the primary key of this event data
	*/
	@Override
	public long getPrimaryKey() {
		return _eventData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event data.
	*
	* @param primaryKey the primary key of this event data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eventdata ID of this event data.
	*
	* @return the eventdata ID of this event data
	*/
	@Override
	public long getEventdataId() {
		return _eventData.getEventdataId();
	}

	/**
	* Sets the eventdata ID of this event data.
	*
	* @param eventdataId the eventdata ID of this event data
	*/
	@Override
	public void setEventdataId(long eventdataId) {
		_eventData.setEventdataId(eventdataId);
	}

	/**
	* Returns the eventlayout ID of this event data.
	*
	* @return the eventlayout ID of this event data
	*/
	@Override
	public long getEventlayoutId() {
		return _eventData.getEventlayoutId();
	}

	/**
	* Sets the eventlayout ID of this event data.
	*
	* @param eventlayoutId the eventlayout ID of this event data
	*/
	@Override
	public void setEventlayoutId(long eventlayoutId) {
		_eventData.setEventlayoutId(eventlayoutId);
	}

	/**
	* Returns the patient ID of this event data.
	*
	* @return the patient ID of this event data
	*/
	@Override
	public long getPatientId() {
		return _eventData.getPatientId();
	}

	/**
	* Sets the patient ID of this event data.
	*
	* @param patientId the patient ID of this event data
	*/
	@Override
	public void setPatientId(long patientId) {
		_eventData.setPatientId(patientId);
	}

	/**
	* Returns the ontology of this event data.
	*
	* @return the ontology of this event data
	*/
	@Override
	public java.lang.String getOntology() {
		return _eventData.getOntology();
	}

	/**
	* Sets the ontology of this event data.
	*
	* @param ontology the ontology of this event data
	*/
	@Override
	public void setOntology(java.lang.String ontology) {
		_eventData.setOntology(ontology);
	}

	/**
	* Returns the value of this event data.
	*
	* @return the value of this event data
	*/
	@Override
	public java.lang.String getValue() {
		return _eventData.getValue();
	}

	/**
	* Sets the value of this event data.
	*
	* @param value the value of this event data
	*/
	@Override
	public void setValue(java.lang.String value) {
		_eventData.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _eventData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventDataWrapper((EventData)_eventData.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData eventData) {
		return _eventData.compareTo(eventData);
	}

	@Override
	public int hashCode() {
		return _eventData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData> toCacheModel() {
		return _eventData.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData toEscapedModel() {
		return new EventDataWrapper(_eventData.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.EventData toUnescapedModel() {
		return new EventDataWrapper(_eventData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventDataWrapper)) {
			return false;
		}

		EventDataWrapper eventDataWrapper = (EventDataWrapper)obj;

		if (Validator.equals(_eventData, eventDataWrapper._eventData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventData getWrappedEventData() {
		return _eventData;
	}

	@Override
	public EventData getWrappedModel() {
		return _eventData;
	}

	@Override
	public void resetOriginalValues() {
		_eventData.resetOriginalValues();
	}

	private EventData _eventData;
}