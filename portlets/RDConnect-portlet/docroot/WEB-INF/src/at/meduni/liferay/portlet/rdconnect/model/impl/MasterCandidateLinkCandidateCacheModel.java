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

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MasterCandidateLinkCandidate in entity cache.
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidate
 * @generated
 */
public class MasterCandidateLinkCandidateCacheModel implements CacheModel<MasterCandidateLinkCandidate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{linkId=");
		sb.append(linkId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", masterCandidateId=");
		sb.append(masterCandidateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterCandidateLinkCandidate toEntityModel() {
		MasterCandidateLinkCandidateImpl masterCandidateLinkCandidateImpl = new MasterCandidateLinkCandidateImpl();

		masterCandidateLinkCandidateImpl.setLinkId(linkId);
		masterCandidateLinkCandidateImpl.setCandidateId(candidateId);
		masterCandidateLinkCandidateImpl.setMasterCandidateId(masterCandidateId);

		masterCandidateLinkCandidateImpl.resetOriginalValues();

		return masterCandidateLinkCandidateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linkId = objectInput.readLong();
		candidateId = objectInput.readLong();
		masterCandidateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(linkId);
		objectOutput.writeLong(candidateId);
		objectOutput.writeLong(masterCandidateId);
	}

	public long linkId;
	public long candidateId;
	public long masterCandidateId;
}