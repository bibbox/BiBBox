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

import at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GeneSynonym in entity cache.
 *
 * @author reihsr
 * @see GeneSynonym
 * @generated
 */
public class GeneSynonymCacheModel implements CacheModel<GeneSynonym>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{genesynonymId=");
		sb.append(genesynonymId);
		sb.append(", geneId=");
		sb.append(geneId);
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeneSynonym toEntityModel() {
		GeneSynonymImpl geneSynonymImpl = new GeneSynonymImpl();

		geneSynonymImpl.setGenesynonymId(genesynonymId);
		geneSynonymImpl.setGeneId(geneId);

		if (synonym == null) {
			geneSynonymImpl.setSynonym(StringPool.BLANK);
		}
		else {
			geneSynonymImpl.setSynonym(synonym);
		}

		geneSynonymImpl.resetOriginalValues();

		return geneSynonymImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		genesynonymId = objectInput.readLong();
		geneId = objectInput.readLong();
		synonym = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(genesynonymId);
		objectOutput.writeLong(geneId);

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}
	}

	public long genesynonymId;
	public long geneId;
	public String synonym;
}