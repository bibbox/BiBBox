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

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrphanetReference in entity cache.
 *
 * @author reihsr
 * @see OrphanetReference
 * @generated
 */
public class OrphanetReferenceCacheModel implements CacheModel<OrphanetReference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{orphanetreferenceId=");
		sb.append(orphanetreferenceId);
		sb.append(", orphanetdisorderId=");
		sb.append(orphanetdisorderId);
		sb.append(", source=");
		sb.append(source);
		sb.append(", reference=");
		sb.append(reference);
		sb.append(", disordermappingrelation=");
		sb.append(disordermappingrelation);
		sb.append(", disordermappingrelationorphanumber=");
		sb.append(disordermappingrelationorphanumber);
		sb.append(", disordermappingrelationname=");
		sb.append(disordermappingrelationname);
		sb.append(", disordermappingicdrelation=");
		sb.append(disordermappingicdrelation);
		sb.append(", disordermappingicdrelationorphanumber=");
		sb.append(disordermappingicdrelationorphanumber);
		sb.append(", disordermappingicdrelationname=");
		sb.append(disordermappingicdrelationname);
		sb.append(", disordermappingvalidationstatus=");
		sb.append(disordermappingvalidationstatus);
		sb.append(", disordermappingvalidationstatusorphanumber=");
		sb.append(disordermappingvalidationstatusorphanumber);
		sb.append(", disordermappingvalidationstatusname=");
		sb.append(disordermappingvalidationstatusname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrphanetReference toEntityModel() {
		OrphanetReferenceImpl orphanetReferenceImpl = new OrphanetReferenceImpl();

		orphanetReferenceImpl.setOrphanetreferenceId(orphanetreferenceId);
		orphanetReferenceImpl.setOrphanetdisorderId(orphanetdisorderId);

		if (source == null) {
			orphanetReferenceImpl.setSource(StringPool.BLANK);
		}
		else {
			orphanetReferenceImpl.setSource(source);
		}

		if (reference == null) {
			orphanetReferenceImpl.setReference(StringPool.BLANK);
		}
		else {
			orphanetReferenceImpl.setReference(reference);
		}

		orphanetReferenceImpl.setDisordermappingrelation(disordermappingrelation);
		orphanetReferenceImpl.setDisordermappingrelationorphanumber(disordermappingrelationorphanumber);

		if (disordermappingrelationname == null) {
			orphanetReferenceImpl.setDisordermappingrelationname(StringPool.BLANK);
		}
		else {
			orphanetReferenceImpl.setDisordermappingrelationname(disordermappingrelationname);
		}

		orphanetReferenceImpl.setDisordermappingicdrelation(disordermappingicdrelation);
		orphanetReferenceImpl.setDisordermappingicdrelationorphanumber(disordermappingicdrelationorphanumber);

		if (disordermappingicdrelationname == null) {
			orphanetReferenceImpl.setDisordermappingicdrelationname(StringPool.BLANK);
		}
		else {
			orphanetReferenceImpl.setDisordermappingicdrelationname(disordermappingicdrelationname);
		}

		orphanetReferenceImpl.setDisordermappingvalidationstatus(disordermappingvalidationstatus);
		orphanetReferenceImpl.setDisordermappingvalidationstatusorphanumber(disordermappingvalidationstatusorphanumber);

		if (disordermappingvalidationstatusname == null) {
			orphanetReferenceImpl.setDisordermappingvalidationstatusname(StringPool.BLANK);
		}
		else {
			orphanetReferenceImpl.setDisordermappingvalidationstatusname(disordermappingvalidationstatusname);
		}

		orphanetReferenceImpl.resetOriginalValues();

		return orphanetReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orphanetreferenceId = objectInput.readLong();
		orphanetdisorderId = objectInput.readLong();
		source = objectInput.readUTF();
		reference = objectInput.readUTF();
		disordermappingrelation = objectInput.readLong();
		disordermappingrelationorphanumber = objectInput.readLong();
		disordermappingrelationname = objectInput.readUTF();
		disordermappingicdrelation = objectInput.readLong();
		disordermappingicdrelationorphanumber = objectInput.readLong();
		disordermappingicdrelationname = objectInput.readUTF();
		disordermappingvalidationstatus = objectInput.readLong();
		disordermappingvalidationstatusorphanumber = objectInput.readLong();
		disordermappingvalidationstatusname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orphanetreferenceId);
		objectOutput.writeLong(orphanetdisorderId);

		if (source == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (reference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reference);
		}

		objectOutput.writeLong(disordermappingrelation);
		objectOutput.writeLong(disordermappingrelationorphanumber);

		if (disordermappingrelationname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disordermappingrelationname);
		}

		objectOutput.writeLong(disordermappingicdrelation);
		objectOutput.writeLong(disordermappingicdrelationorphanumber);

		if (disordermappingicdrelationname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disordermappingicdrelationname);
		}

		objectOutput.writeLong(disordermappingvalidationstatus);
		objectOutput.writeLong(disordermappingvalidationstatusorphanumber);

		if (disordermappingvalidationstatusname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disordermappingvalidationstatusname);
		}
	}

	public long orphanetreferenceId;
	public long orphanetdisorderId;
	public String source;
	public String reference;
	public long disordermappingrelation;
	public long disordermappingrelationorphanumber;
	public String disordermappingrelationname;
	public long disordermappingicdrelation;
	public long disordermappingicdrelationorphanumber;
	public String disordermappingicdrelationname;
	public long disordermappingvalidationstatus;
	public long disordermappingvalidationstatusorphanumber;
	public String disordermappingvalidationstatusname;
}