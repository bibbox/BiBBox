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

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrphanetSynonym in entity cache.
 *
 * @author reihsr
 * @see OrphanetSynonym
 * @generated
 */
public class OrphanetSynonymCacheModel implements CacheModel<OrphanetSynonym>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{orphanetsynonymId=");
		sb.append(orphanetsynonymId);
		sb.append(", orphanetdisorderId=");
		sb.append(orphanetdisorderId);
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrphanetSynonym toEntityModel() {
		OrphanetSynonymImpl orphanetSynonymImpl = new OrphanetSynonymImpl();

		orphanetSynonymImpl.setOrphanetsynonymId(orphanetsynonymId);
		orphanetSynonymImpl.setOrphanetdisorderId(orphanetdisorderId);

		if (synonym == null) {
			orphanetSynonymImpl.setSynonym(StringPool.BLANK);
		}
		else {
			orphanetSynonymImpl.setSynonym(synonym);
		}

		orphanetSynonymImpl.resetOriginalValues();

		return orphanetSynonymImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orphanetsynonymId = objectInput.readLong();
		orphanetdisorderId = objectInput.readLong();
		synonym = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orphanetsynonymId);
		objectOutput.writeLong(orphanetdisorderId);

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}
	}

	public long orphanetsynonymId;
	public long orphanetdisorderId;
	public String synonym;
}