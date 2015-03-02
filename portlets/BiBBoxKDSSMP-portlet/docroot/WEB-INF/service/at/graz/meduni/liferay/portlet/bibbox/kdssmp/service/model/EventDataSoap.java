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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class EventDataSoap implements Serializable {
	public static EventDataSoap toSoapModel(EventData model) {
		EventDataSoap soapModel = new EventDataSoap();

		soapModel.setEventdataId(model.getEventdataId());
		soapModel.setEventlayoutId(model.getEventlayoutId());
		soapModel.setPatientId(model.getPatientId());
		soapModel.setOntology(model.getOntology());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static EventDataSoap[] toSoapModels(EventData[] models) {
		EventDataSoap[] soapModels = new EventDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventDataSoap[][] toSoapModels(EventData[][] models) {
		EventDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventDataSoap[] toSoapModels(List<EventData> models) {
		List<EventDataSoap> soapModels = new ArrayList<EventDataSoap>(models.size());

		for (EventData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventDataSoap[soapModels.size()]);
	}

	public EventDataSoap() {
	}

	public long getPrimaryKey() {
		return _eventdataId;
	}

	public void setPrimaryKey(long pk) {
		setEventdataId(pk);
	}

	public long getEventdataId() {
		return _eventdataId;
	}

	public void setEventdataId(long eventdataId) {
		_eventdataId = eventdataId;
	}

	public long getEventlayoutId() {
		return _eventlayoutId;
	}

	public void setEventlayoutId(long eventlayoutId) {
		_eventlayoutId = eventlayoutId;
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public String getOntology() {
		return _ontology;
	}

	public void setOntology(String ontology) {
		_ontology = ontology;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _eventdataId;
	private long _eventlayoutId;
	private long _patientId;
	private String _ontology;
	private String _value;
}