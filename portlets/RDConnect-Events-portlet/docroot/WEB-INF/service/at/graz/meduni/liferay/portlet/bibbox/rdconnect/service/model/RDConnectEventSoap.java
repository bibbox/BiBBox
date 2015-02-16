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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class RDConnectEventSoap implements Serializable {
	public static RDConnectEventSoap toSoapModel(RDConnectEvent model) {
		RDConnectEventSoap soapModel = new RDConnectEventSoap();

		soapModel.setEventId(model.getEventId());
		soapModel.setEventdate(model.getEventdate());
		soapModel.setEventtype(model.getEventtype());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setShorttext(model.getShorttext());
		soapModel.setLongtext(model.getLongtext());
		soapModel.setLink(model.getLink());
		soapModel.setRestricted(model.getRestricted());

		return soapModel;
	}

	public static RDConnectEventSoap[] toSoapModels(RDConnectEvent[] models) {
		RDConnectEventSoap[] soapModels = new RDConnectEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDConnectEventSoap[][] toSoapModels(RDConnectEvent[][] models) {
		RDConnectEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDConnectEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDConnectEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDConnectEventSoap[] toSoapModels(List<RDConnectEvent> models) {
		List<RDConnectEventSoap> soapModels = new ArrayList<RDConnectEventSoap>(models.size());

		for (RDConnectEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDConnectEventSoap[soapModels.size()]);
	}

	public RDConnectEventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Date getEventdate() {
		return _eventdate;
	}

	public void setEventdate(Date eventdate) {
		_eventdate = eventdate;
	}

	public String getEventtype() {
		return _eventtype;
	}

	public void setEventtype(String eventtype) {
		_eventtype = eventtype;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getShorttext() {
		return _shorttext;
	}

	public void setShorttext(String shorttext) {
		_shorttext = shorttext;
	}

	public String getLongtext() {
		return _longtext;
	}

	public void setLongtext(String longtext) {
		_longtext = longtext;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getRestricted() {
		return _restricted;
	}

	public void setRestricted(String restricted) {
		_restricted = restricted;
	}

	private long _eventId;
	private Date _eventdate;
	private String _eventtype;
	private long _organizationId;
	private long _userId;
	private String _shorttext;
	private String _longtext;
	private String _link;
	private String _restricted;
}