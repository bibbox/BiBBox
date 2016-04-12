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

import at.graz.meduni.liferay.portlet.bibbox.model.GeneReference;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GeneReference in entity cache.
 *
 * @author reihsr
 * @see GeneReference
 * @generated
 */
public class GeneReferenceCacheModel implements CacheModel<GeneReference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{genereferenceId=");
		sb.append(genereferenceId);
		sb.append(", geneId=");
		sb.append(geneId);
		sb.append(", source=");
		sb.append(source);
		sb.append(", reference=");
		sb.append(reference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeneReference toEntityModel() {
		GeneReferenceImpl geneReferenceImpl = new GeneReferenceImpl();

		geneReferenceImpl.setGenereferenceId(genereferenceId);
		geneReferenceImpl.setGeneId(geneId);

		if (source == null) {
			geneReferenceImpl.setSource(StringPool.BLANK);
		}
		else {
			geneReferenceImpl.setSource(source);
		}

		if (reference == null) {
			geneReferenceImpl.setReference(StringPool.BLANK);
		}
		else {
			geneReferenceImpl.setReference(reference);
		}

		geneReferenceImpl.resetOriginalValues();

		return geneReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		genereferenceId = objectInput.readLong();
		geneId = objectInput.readLong();
		source = objectInput.readUTF();
		reference = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(genereferenceId);
		objectOutput.writeLong(geneId);

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
	}

	public long genereferenceId;
	public long geneId;
	public String source;
	public String reference;
}