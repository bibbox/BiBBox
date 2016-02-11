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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class RDConnectEventNotificationSoap implements Serializable {
	public static RDConnectEventNotificationSoap toSoapModel(
		RDConnectEventNotification model) {
		RDConnectEventNotificationSoap soapModel = new RDConnectEventNotificationSoap();

		soapModel.setEventnotificationId(model.getEventnotificationId());
		soapModel.setNotificationtype(model.getNotificationtype());
		soapModel.setUserId(model.getUserId());
		soapModel.setNotificationselected(model.getNotificationselected());

		return soapModel;
	}

	public static RDConnectEventNotificationSoap[] toSoapModels(
		RDConnectEventNotification[] models) {
		RDConnectEventNotificationSoap[] soapModels = new RDConnectEventNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDConnectEventNotificationSoap[][] toSoapModels(
		RDConnectEventNotification[][] models) {
		RDConnectEventNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDConnectEventNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDConnectEventNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDConnectEventNotificationSoap[] toSoapModels(
		List<RDConnectEventNotification> models) {
		List<RDConnectEventNotificationSoap> soapModels = new ArrayList<RDConnectEventNotificationSoap>(models.size());

		for (RDConnectEventNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDConnectEventNotificationSoap[soapModels.size()]);
	}

	public RDConnectEventNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _eventnotificationId;
	}

	public void setPrimaryKey(long pk) {
		setEventnotificationId(pk);
	}

	public long getEventnotificationId() {
		return _eventnotificationId;
	}

	public void setEventnotificationId(long eventnotificationId) {
		_eventnotificationId = eventnotificationId;
	}

	public String getNotificationtype() {
		return _notificationtype;
	}

	public void setNotificationtype(String notificationtype) {
		_notificationtype = notificationtype;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public boolean getNotificationselected() {
		return _notificationselected;
	}

	public boolean isNotificationselected() {
		return _notificationselected;
	}

	public void setNotificationselected(boolean notificationselected) {
		_notificationselected = notificationselected;
	}

	private long _eventnotificationId;
	private String _notificationtype;
	private long _userId;
	private boolean _notificationselected;
}