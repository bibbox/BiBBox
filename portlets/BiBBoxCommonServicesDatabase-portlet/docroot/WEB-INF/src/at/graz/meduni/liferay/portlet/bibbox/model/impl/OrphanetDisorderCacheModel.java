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

package at.graz.meduni.liferay.portlet.bibbox.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrphanetDisorder in entity cache.
 *
 * @author reihsr
 * @see OrphanetDisorder
 * @generated
 */
public class OrphanetDisorderCacheModel implements CacheModel<OrphanetDisorder>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{orphanetdisorderId=");
		sb.append(orphanetdisorderId);
		sb.append(", orphanumber=");
		sb.append(orphanumber);
		sb.append(", orpahnetlink=");
		sb.append(orpahnetlink);
		sb.append(", diseasename=");
		sb.append(diseasename);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrphanetDisorder toEntityModel() {
		OrphanetDisorderImpl orphanetDisorderImpl = new OrphanetDisorderImpl();

		orphanetDisorderImpl.setOrphanetdisorderId(orphanetdisorderId);
		orphanetDisorderImpl.setOrphanumber(orphanumber);

		if (orpahnetlink == null) {
			orphanetDisorderImpl.setOrpahnetlink(StringPool.BLANK);
		}
		else {
			orphanetDisorderImpl.setOrpahnetlink(orpahnetlink);
		}

		if (diseasename == null) {
			orphanetDisorderImpl.setDiseasename(StringPool.BLANK);
		}
		else {
			orphanetDisorderImpl.setDiseasename(diseasename);
		}

		orphanetDisorderImpl.resetOriginalValues();

		return orphanetDisorderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orphanetdisorderId = objectInput.readLong();
		orphanumber = objectInput.readLong();
		orpahnetlink = objectInput.readUTF();
		diseasename = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orphanetdisorderId);
		objectOutput.writeLong(orphanumber);

		if (orpahnetlink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orpahnetlink);
		}

		if (diseasename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasename);
		}
	}

	public long orphanetdisorderId;
	public long orphanumber;
	public String orpahnetlink;
	public String diseasename;
}