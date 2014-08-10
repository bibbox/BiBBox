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

		soapModel.setInvitationID(model.getInvitationID());

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
		return _invitationID;
	}

	public void setPrimaryKey(long pk) {
		setInvitationID(pk);
	}

	public long getInvitationID() {
		return _invitationID;
	}

	public void setInvitationID(long invitationID) {
		_invitationID = invitationID;
	}

	private long _invitationID;
}