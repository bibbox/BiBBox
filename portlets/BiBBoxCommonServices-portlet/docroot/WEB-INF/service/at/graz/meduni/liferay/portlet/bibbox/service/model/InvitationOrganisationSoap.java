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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.InvitationOrganisationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.InvitationOrganisationServiceSoap
 * @generated
 */
public class InvitationOrganisationSoap implements Serializable {
	public static InvitationOrganisationSoap toSoapModel(
		InvitationOrganisation model) {
		InvitationOrganisationSoap soapModel = new InvitationOrganisationSoap();

		soapModel.setInvitationOrganisationId(model.getInvitationOrganisationId());
		soapModel.setInvitationId(model.getInvitationId());
		soapModel.setOrganisationId(model.getOrganisationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLastchanged(model.getLastchanged());
		soapModel.setLastchanger(model.getLastchanger());

		return soapModel;
	}

	public static InvitationOrganisationSoap[] toSoapModels(
		InvitationOrganisation[] models) {
		InvitationOrganisationSoap[] soapModels = new InvitationOrganisationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvitationOrganisationSoap[][] toSoapModels(
		InvitationOrganisation[][] models) {
		InvitationOrganisationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvitationOrganisationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvitationOrganisationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvitationOrganisationSoap[] toSoapModels(
		List<InvitationOrganisation> models) {
		List<InvitationOrganisationSoap> soapModels = new ArrayList<InvitationOrganisationSoap>(models.size());

		for (InvitationOrganisation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvitationOrganisationSoap[soapModels.size()]);
	}

	public InvitationOrganisationSoap() {
	}

	public long getPrimaryKey() {
		return _invitationOrganisationId;
	}

	public void setPrimaryKey(long pk) {
		setInvitationOrganisationId(pk);
	}

	public long getInvitationOrganisationId() {
		return _invitationOrganisationId;
	}

	public void setInvitationOrganisationId(long invitationOrganisationId) {
		_invitationOrganisationId = invitationOrganisationId;
	}

	public long getInvitationId() {
		return _invitationId;
	}

	public void setInvitationId(long invitationId) {
		_invitationId = invitationId;
	}

	public long getOrganisationId() {
		return _organisationId;
	}

	public void setOrganisationId(long organisationId) {
		_organisationId = organisationId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getLastchanged() {
		return _lastchanged;
	}

	public void setLastchanged(Date lastchanged) {
		_lastchanged = lastchanged;
	}

	public long getLastchanger() {
		return _lastchanger;
	}

	public void setLastchanger(long lastchanger) {
		_lastchanger = lastchanger;
	}

	private long _invitationOrganisationId;
	private long _invitationId;
	private long _organisationId;
	private long _userId;
	private Date _lastchanged;
	private long _lastchanger;
}