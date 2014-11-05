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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.InvitationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.InvitationServiceSoap
 * @generated
 */
public class InvitationSoap implements Serializable {
	public static InvitationSoap toSoapModel(Invitation model) {
		InvitationSoap soapModel = new InvitationSoap();

		soapModel.setInvitationId(model.getInvitationId());
		soapModel.setName(model.getName());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setStatus(model.getStatus());
		soapModel.setInvitationsend(model.getInvitationsend());
		soapModel.setLastchanged(model.getLastchanged());
		soapModel.setLastchanger(model.getLastchanger());
		soapModel.setFilter(model.getFilter());

		return soapModel;
	}

	public static InvitationSoap[] toSoapModels(Invitation[] models) {
		InvitationSoap[] soapModels = new InvitationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvitationSoap[][] toSoapModels(Invitation[][] models) {
		InvitationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvitationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvitationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvitationSoap[] toSoapModels(List<Invitation> models) {
		List<InvitationSoap> soapModels = new ArrayList<InvitationSoap>(models.size());

		for (Invitation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvitationSoap[soapModels.size()]);
	}

	public InvitationSoap() {
	}

	public long getPrimaryKey() {
		return _invitationId;
	}

	public void setPrimaryKey(long pk) {
		setInvitationId(pk);
	}

	public long getInvitationId() {
		return _invitationId;
	}

	public void setInvitationId(long invitationId) {
		_invitationId = invitationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public Date getInvitationsend() {
		return _invitationsend;
	}

	public void setInvitationsend(Date invitationsend) {
		_invitationsend = invitationsend;
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

	public String getFilter() {
		return _filter;
	}

	public void setFilter(String filter) {
		_filter = filter;
	}

	private long _invitationId;
	private String _name;
	private String _subject;
	private String _body;
	private long _status;
	private Date _invitationsend;
	private Date _lastchanged;
	private long _lastchanger;
	private String _filter;
}