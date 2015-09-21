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

package test.portlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import test.portlet.model.MolgenisAPIRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MolgenisAPIRequest in entity cache.
 *
 * @author reihsr
 * @see MolgenisAPIRequest
 * @generated
 */
public class MolgenisAPIRequestCacheModel implements CacheModel<MolgenisAPIRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{molgenisapirequestId=");
		sb.append(molgenisapirequestId);

		return sb.toString();
	}

	@Override
	public MolgenisAPIRequest toEntityModel() {
		MolgenisAPIRequestImpl molgenisAPIRequestImpl = new MolgenisAPIRequestImpl();

		molgenisAPIRequestImpl.setMolgenisapirequestId(molgenisapirequestId);

		molgenisAPIRequestImpl.resetOriginalValues();

		return molgenisAPIRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		molgenisapirequestId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(molgenisapirequestId);
	}

	public long molgenisapirequestId;
}