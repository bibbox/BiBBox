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

package at.graz.meduni.liferay.portlet.bbmriat.service.model.impl;

import at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Organizationlink in entity cache.
 *
 * @author Reihs Robert
 * @see Organizationlink
 * @generated
 */
public class OrganizationlinkCacheModel implements CacheModel<Organizationlink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{organizationlinkId=");
		sb.append(organizationlinkId);
		sb.append(", parentorganizationId=");
		sb.append(parentorganizationId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Organizationlink toEntityModel() {
		OrganizationlinkImpl organizationlinkImpl = new OrganizationlinkImpl();

		organizationlinkImpl.setOrganizationlinkId(organizationlinkId);
		organizationlinkImpl.setParentorganizationId(parentorganizationId);
		organizationlinkImpl.setOrganizationId(organizationId);

		organizationlinkImpl.resetOriginalValues();

		return organizationlinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationlinkId = objectInput.readLong();
		parentorganizationId = objectInput.readLong();
		organizationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(organizationlinkId);
		objectOutput.writeLong(parentorganizationId);
		objectOutput.writeLong(organizationId);
	}

	public long organizationlinkId;
	public long parentorganizationId;
	public long organizationId;
}