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

package at.graz.meduni.liferay.portlet.bibbox.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Networks in entity cache.
 *
 * @author reihsr
 * @see Networks
 * @generated
 */
public class NetworksCacheModel implements CacheModel<Networks>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{networkId=");
		sb.append(networkId);
		sb.append(", organizationnetworkId=");
		sb.append(organizationnetworkId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", relation=");
		sb.append(relation);
		sb.append(", externalnetworkId=");
		sb.append(externalnetworkId);
		sb.append(", yearofestablishment=");
		sb.append(yearofestablishment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Networks toEntityModel() {
		NetworksImpl networksImpl = new NetworksImpl();

		networksImpl.setNetworkId(networkId);
		networksImpl.setOrganizationnetworkId(organizationnetworkId);
		networksImpl.setOrganizationId(organizationId);

		if (relation == null) {
			networksImpl.setRelation(StringPool.BLANK);
		}
		else {
			networksImpl.setRelation(relation);
		}

		if (externalnetworkId == null) {
			networksImpl.setExternalnetworkId(StringPool.BLANK);
		}
		else {
			networksImpl.setExternalnetworkId(externalnetworkId);
		}

		if (yearofestablishment == null) {
			networksImpl.setYearofestablishment(StringPool.BLANK);
		}
		else {
			networksImpl.setYearofestablishment(yearofestablishment);
		}

		networksImpl.resetOriginalValues();

		return networksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		networkId = objectInput.readLong();
		organizationnetworkId = objectInput.readLong();
		organizationId = objectInput.readLong();
		relation = objectInput.readUTF();
		externalnetworkId = objectInput.readUTF();
		yearofestablishment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(networkId);
		objectOutput.writeLong(organizationnetworkId);
		objectOutput.writeLong(organizationId);

		if (relation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relation);
		}

		if (externalnetworkId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalnetworkId);
		}

		if (yearofestablishment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yearofestablishment);
		}
	}

	public long networkId;
	public long organizationnetworkId;
	public long organizationId;
	public String relation;
	public String externalnetworkId;
	public String yearofestablishment;
}