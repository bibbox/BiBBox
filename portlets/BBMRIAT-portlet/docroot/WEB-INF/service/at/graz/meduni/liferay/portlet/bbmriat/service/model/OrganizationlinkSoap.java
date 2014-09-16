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

package at.graz.meduni.liferay.portlet.bbmriat.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Reihs Robert
 * @generated
 */
public class OrganizationlinkSoap implements Serializable {
	public static OrganizationlinkSoap toSoapModel(Organizationlink model) {
		OrganizationlinkSoap soapModel = new OrganizationlinkSoap();

		soapModel.setOrganizationlinkId(model.getOrganizationlinkId());
		soapModel.setParentorganizationId(model.getParentorganizationId());
		soapModel.setOrganizationId(model.getOrganizationId());

		return soapModel;
	}

	public static OrganizationlinkSoap[] toSoapModels(Organizationlink[] models) {
		OrganizationlinkSoap[] soapModels = new OrganizationlinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationlinkSoap[][] toSoapModels(
		Organizationlink[][] models) {
		OrganizationlinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationlinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationlinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationlinkSoap[] toSoapModels(
		List<Organizationlink> models) {
		List<OrganizationlinkSoap> soapModels = new ArrayList<OrganizationlinkSoap>(models.size());

		for (Organizationlink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationlinkSoap[soapModels.size()]);
	}

	public OrganizationlinkSoap() {
	}

	public long getPrimaryKey() {
		return _organizationlinkId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationlinkId(pk);
	}

	public long getOrganizationlinkId() {
		return _organizationlinkId;
	}

	public void setOrganizationlinkId(long organizationlinkId) {
		_organizationlinkId = organizationlinkId;
	}

	public long getParentorganizationId() {
		return _parentorganizationId;
	}

	public void setParentorganizationId(long parentorganizationId) {
		_parentorganizationId = parentorganizationId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	private long _organizationlinkId;
	private long _parentorganizationId;
	private long _organizationId;
}