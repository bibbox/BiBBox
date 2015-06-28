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

import at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GeneLocus in entity cache.
 *
 * @author reihsr
 * @see GeneLocus
 * @generated
 */
public class GeneLocusCacheModel implements CacheModel<GeneLocus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{genelocusId=");
		sb.append(genelocusId);
		sb.append(", geneId=");
		sb.append(geneId);
		sb.append(", genelocus=");
		sb.append(genelocus);
		sb.append(", genelocuskey=");
		sb.append(genelocuskey);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeneLocus toEntityModel() {
		GeneLocusImpl geneLocusImpl = new GeneLocusImpl();

		geneLocusImpl.setGenelocusId(genelocusId);
		geneLocusImpl.setGeneId(geneId);

		if (genelocus == null) {
			geneLocusImpl.setGenelocus(StringPool.BLANK);
		}
		else {
			geneLocusImpl.setGenelocus(genelocus);
		}

		if (genelocuskey == null) {
			geneLocusImpl.setGenelocuskey(StringPool.BLANK);
		}
		else {
			geneLocusImpl.setGenelocuskey(genelocuskey);
		}

		geneLocusImpl.resetOriginalValues();

		return geneLocusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		genelocusId = objectInput.readLong();
		geneId = objectInput.readLong();
		genelocus = objectInput.readUTF();
		genelocuskey = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(genelocusId);
		objectOutput.writeLong(geneId);

		if (genelocus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(genelocus);
		}

		if (genelocuskey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(genelocuskey);
		}
	}

	public long genelocusId;
	public long geneId;
	public String genelocus;
	public String genelocuskey;
}