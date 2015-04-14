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

package at.meduni.liferay.portlet.rdconnect.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Robert Reihs
 * @generated
 */
public class RDCOrganizationUserAccessSoap implements Serializable {
	public static RDCOrganizationUserAccessSoap toSoapModel(
		RDCOrganizationUserAccess model) {
		RDCOrganizationUserAccessSoap soapModel = new RDCOrganizationUserAccessSoap();

		soapModel.setRdcorganizationuseraccessId(model.getRdcorganizationuseraccessId());
		soapModel.setOrganisationId(model.getOrganisationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setIpaddress(model.getIpaddress());
		soapModel.setLastaccess(model.getLastaccess());

		return soapModel;
	}

	public static RDCOrganizationUserAccessSoap[] toSoapModels(
		RDCOrganizationUserAccess[] models) {
		RDCOrganizationUserAccessSoap[] soapModels = new RDCOrganizationUserAccessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDCOrganizationUserAccessSoap[][] toSoapModels(
		RDCOrganizationUserAccess[][] models) {
		RDCOrganizationUserAccessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDCOrganizationUserAccessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDCOrganizationUserAccessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDCOrganizationUserAccessSoap[] toSoapModels(
		List<RDCOrganizationUserAccess> models) {
		List<RDCOrganizationUserAccessSoap> soapModels = new ArrayList<RDCOrganizationUserAccessSoap>(models.size());

		for (RDCOrganizationUserAccess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDCOrganizationUserAccessSoap[soapModels.size()]);
	}

	public RDCOrganizationUserAccessSoap() {
	}

	public long getPrimaryKey() {
		return _rdcorganizationuseraccessId;
	}

	public void setPrimaryKey(long pk) {
		setRdcorganizationuseraccessId(pk);
	}

	public long getRdcorganizationuseraccessId() {
		return _rdcorganizationuseraccessId;
	}

	public void setRdcorganizationuseraccessId(long rdcorganizationuseraccessId) {
		_rdcorganizationuseraccessId = rdcorganizationuseraccessId;
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

	public long getIpaddress() {
		return _ipaddress;
	}

	public void setIpaddress(long ipaddress) {
		_ipaddress = ipaddress;
	}

	public Date getLastaccess() {
		return _lastaccess;
	}

	public void setLastaccess(Date lastaccess) {
		_lastaccess = lastaccess;
	}

	private long _rdcorganizationuseraccessId;
	private long _organisationId;
	private long _userId;
	private long _ipaddress;
	private Date _lastaccess;
}