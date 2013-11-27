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

package at.meduni.liferay.portlet.rdconnect.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Robert Reihs
 * @generated
 */
public class MasterCandidateLinkCandidateSoap implements Serializable {
	public static MasterCandidateLinkCandidateSoap toSoapModel(
		MasterCandidateLinkCandidate model) {
		MasterCandidateLinkCandidateSoap soapModel = new MasterCandidateLinkCandidateSoap();

		soapModel.setLinkId(model.getLinkId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setMasterCandidateId(model.getMasterCandidateId());

		return soapModel;
	}

	public static MasterCandidateLinkCandidateSoap[] toSoapModels(
		MasterCandidateLinkCandidate[] models) {
		MasterCandidateLinkCandidateSoap[] soapModels = new MasterCandidateLinkCandidateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterCandidateLinkCandidateSoap[][] toSoapModels(
		MasterCandidateLinkCandidate[][] models) {
		MasterCandidateLinkCandidateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterCandidateLinkCandidateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterCandidateLinkCandidateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterCandidateLinkCandidateSoap[] toSoapModels(
		List<MasterCandidateLinkCandidate> models) {
		List<MasterCandidateLinkCandidateSoap> soapModels = new ArrayList<MasterCandidateLinkCandidateSoap>(models.size());

		for (MasterCandidateLinkCandidate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterCandidateLinkCandidateSoap[soapModels.size()]);
	}

	public MasterCandidateLinkCandidateSoap() {
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long pk) {
		setLinkId(pk);
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public long getMasterCandidateId() {
		return _masterCandidateId;
	}

	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateId = masterCandidateId;
	}

	private long _linkId;
	private long _candidateId;
	private long _masterCandidateId;
}