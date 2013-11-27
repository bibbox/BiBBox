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

package at.meduni.liferay.portlet.rdconnect.model.impl;

import at.meduni.liferay.portlet.rdconnect.model.AQRRating;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AQRRating in entity cache.
 *
 * @author Robert Reihs
 * @see AQRRating
 * @generated
 */
public class AQRRatingCacheModel implements CacheModel<AQRRating>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{aqrId=");
		sb.append(aqrId);
		sb.append(", accessability=");
		sb.append(accessability);
		sb.append(", quality=");
		sb.append(quality);
		sb.append(", relevance=");
		sb.append(relevance);
		sb.append(", masterCandidateId=");
		sb.append(masterCandidateId);
		sb.append(", aqrrater=");
		sb.append(aqrrater);
		sb.append(", ratingtype=");
		sb.append(ratingtype);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AQRRating toEntityModel() {
		AQRRatingImpl aqrRatingImpl = new AQRRatingImpl();

		aqrRatingImpl.setAqrId(aqrId);
		aqrRatingImpl.setAccessability(accessability);
		aqrRatingImpl.setQuality(quality);
		aqrRatingImpl.setRelevance(relevance);
		aqrRatingImpl.setMasterCandidateId(masterCandidateId);

		if (aqrrater == null) {
			aqrRatingImpl.setAqrrater(StringPool.BLANK);
		}
		else {
			aqrRatingImpl.setAqrrater(aqrrater);
		}

		if (ratingtype == null) {
			aqrRatingImpl.setRatingtype(StringPool.BLANK);
		}
		else {
			aqrRatingImpl.setRatingtype(ratingtype);
		}

		aqrRatingImpl.resetOriginalValues();

		return aqrRatingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		aqrId = objectInput.readLong();
		accessability = objectInput.readLong();
		quality = objectInput.readLong();
		relevance = objectInput.readLong();
		masterCandidateId = objectInput.readLong();
		aqrrater = objectInput.readUTF();
		ratingtype = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(aqrId);
		objectOutput.writeLong(accessability);
		objectOutput.writeLong(quality);
		objectOutput.writeLong(relevance);
		objectOutput.writeLong(masterCandidateId);

		if (aqrrater == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aqrrater);
		}

		if (ratingtype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ratingtype);
		}
	}

	public long aqrId;
	public long accessability;
	public long quality;
	public long relevance;
	public long masterCandidateId;
	public String aqrrater;
	public String ratingtype;
}