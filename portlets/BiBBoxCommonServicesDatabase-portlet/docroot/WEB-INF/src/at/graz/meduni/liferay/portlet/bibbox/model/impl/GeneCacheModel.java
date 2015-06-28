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

import at.graz.meduni.liferay.portlet.bibbox.model.Gene;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Gene in entity cache.
 *
 * @author reihsr
 * @see Gene
 * @generated
 */
public class GeneCacheModel implements CacheModel<Gene>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{geneId=");
		sb.append(geneId);
		sb.append(", orphanetdisorderId=");
		sb.append(orphanetdisorderId);
		sb.append(", symbol=");
		sb.append(symbol);
		sb.append(", description=");
		sb.append(description);
		sb.append(", geneorphanumber=");
		sb.append(geneorphanumber);
		sb.append(", genetype=");
		sb.append(genetype);
		sb.append(", genetypeorphanumber=");
		sb.append(genetypeorphanumber);
		sb.append(", genetypename=");
		sb.append(genetypename);
		sb.append(", disordergeneassociationtype=");
		sb.append(disordergeneassociationtype);
		sb.append(", disordergeneassociationtypename=");
		sb.append(disordergeneassociationtypename);
		sb.append(", disordergeneassociationstatus=");
		sb.append(disordergeneassociationstatus);
		sb.append(", disordergeneassociationstatusname=");
		sb.append(disordergeneassociationstatusname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Gene toEntityModel() {
		GeneImpl geneImpl = new GeneImpl();

		geneImpl.setGeneId(geneId);
		geneImpl.setOrphanetdisorderId(orphanetdisorderId);

		if (symbol == null) {
			geneImpl.setSymbol(StringPool.BLANK);
		}
		else {
			geneImpl.setSymbol(symbol);
		}

		if (description == null) {
			geneImpl.setDescription(StringPool.BLANK);
		}
		else {
			geneImpl.setDescription(description);
		}

		geneImpl.setGeneorphanumber(geneorphanumber);
		geneImpl.setGenetype(genetype);
		geneImpl.setGenetypeorphanumber(genetypeorphanumber);

		if (genetypename == null) {
			geneImpl.setGenetypename(StringPool.BLANK);
		}
		else {
			geneImpl.setGenetypename(genetypename);
		}

		geneImpl.setDisordergeneassociationtype(disordergeneassociationtype);

		if (disordergeneassociationtypename == null) {
			geneImpl.setDisordergeneassociationtypename(StringPool.BLANK);
		}
		else {
			geneImpl.setDisordergeneassociationtypename(disordergeneassociationtypename);
		}

		geneImpl.setDisordergeneassociationstatus(disordergeneassociationstatus);

		if (disordergeneassociationstatusname == null) {
			geneImpl.setDisordergeneassociationstatusname(StringPool.BLANK);
		}
		else {
			geneImpl.setDisordergeneassociationstatusname(disordergeneassociationstatusname);
		}

		geneImpl.resetOriginalValues();

		return geneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		geneId = objectInput.readLong();
		orphanetdisorderId = objectInput.readLong();
		symbol = objectInput.readUTF();
		description = objectInput.readUTF();
		geneorphanumber = objectInput.readLong();
		genetype = objectInput.readLong();
		genetypeorphanumber = objectInput.readLong();
		genetypename = objectInput.readUTF();
		disordergeneassociationtype = objectInput.readLong();
		disordergeneassociationtypename = objectInput.readUTF();
		disordergeneassociationstatus = objectInput.readLong();
		disordergeneassociationstatusname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(geneId);
		objectOutput.writeLong(orphanetdisorderId);

		if (symbol == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(symbol);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(geneorphanumber);
		objectOutput.writeLong(genetype);
		objectOutput.writeLong(genetypeorphanumber);

		if (genetypename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(genetypename);
		}

		objectOutput.writeLong(disordergeneassociationtype);

		if (disordergeneassociationtypename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disordergeneassociationtypename);
		}

		objectOutput.writeLong(disordergeneassociationstatus);

		if (disordergeneassociationstatusname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disordergeneassociationstatusname);
		}
	}

	public long geneId;
	public long orphanetdisorderId;
	public String symbol;
	public String description;
	public long geneorphanumber;
	public long genetype;
	public long genetypeorphanumber;
	public String genetypename;
	public long disordergeneassociationtype;
	public String disordergeneassociationtypename;
	public long disordergeneassociationstatus;
	public String disordergeneassociationstatusname;
}