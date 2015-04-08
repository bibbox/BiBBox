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

package at.meduni.liferay.portlet.rdconnect.model.impl;

import at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RDCOrganizationUserAccess in entity cache.
 *
 * @author Robert Reihs
 * @see RDCOrganizationUserAccess
 * @generated
 */
public class RDCOrganizationUserAccessCacheModel implements CacheModel<RDCOrganizationUserAccess>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{rdcorganizationuseraccessId=");
		sb.append(rdcorganizationuseraccessId);
		sb.append(", organisationId=");
		sb.append(organisationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ipaddress=");
		sb.append(ipaddress);
		sb.append(", lastaccess=");
		sb.append(lastaccess);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RDCOrganizationUserAccess toEntityModel() {
		RDCOrganizationUserAccessImpl rdcOrganizationUserAccessImpl = new RDCOrganizationUserAccessImpl();

		rdcOrganizationUserAccessImpl.setRdcorganizationuseraccessId(rdcorganizationuseraccessId);
		rdcOrganizationUserAccessImpl.setOrganisationId(organisationId);
		rdcOrganizationUserAccessImpl.setUserId(userId);
		rdcOrganizationUserAccessImpl.setIpaddress(ipaddress);

		if (lastaccess == Long.MIN_VALUE) {
			rdcOrganizationUserAccessImpl.setLastaccess(null);
		}
		else {
			rdcOrganizationUserAccessImpl.setLastaccess(new Date(lastaccess));
		}

		rdcOrganizationUserAccessImpl.resetOriginalValues();

		return rdcOrganizationUserAccessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rdcorganizationuseraccessId = objectInput.readLong();
		organisationId = objectInput.readLong();
		userId = objectInput.readLong();
		ipaddress = objectInput.readLong();
		lastaccess = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rdcorganizationuseraccessId);
		objectOutput.writeLong(organisationId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(ipaddress);
		objectOutput.writeLong(lastaccess);
	}

	public long rdcorganizationuseraccessId;
	public long organisationId;
	public long userId;
	public long ipaddress;
	public long lastaccess;
}