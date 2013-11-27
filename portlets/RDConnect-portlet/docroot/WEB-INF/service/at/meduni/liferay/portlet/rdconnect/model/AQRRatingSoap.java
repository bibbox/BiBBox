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
public class AQRRatingSoap implements Serializable {
	public static AQRRatingSoap toSoapModel(AQRRating model) {
		AQRRatingSoap soapModel = new AQRRatingSoap();

		soapModel.setAqrId(model.getAqrId());
		soapModel.setAccessability(model.getAccessability());
		soapModel.setQuality(model.getQuality());
		soapModel.setRelevance(model.getRelevance());
		soapModel.setMasterCandidateId(model.getMasterCandidateId());
		soapModel.setAqrrater(model.getAqrrater());
		soapModel.setRatingtype(model.getRatingtype());

		return soapModel;
	}

	public static AQRRatingSoap[] toSoapModels(AQRRating[] models) {
		AQRRatingSoap[] soapModels = new AQRRatingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AQRRatingSoap[][] toSoapModels(AQRRating[][] models) {
		AQRRatingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AQRRatingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AQRRatingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AQRRatingSoap[] toSoapModels(List<AQRRating> models) {
		List<AQRRatingSoap> soapModels = new ArrayList<AQRRatingSoap>(models.size());

		for (AQRRating model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AQRRatingSoap[soapModels.size()]);
	}

	public AQRRatingSoap() {
	}

	public long getPrimaryKey() {
		return _aqrId;
	}

	public void setPrimaryKey(long pk) {
		setAqrId(pk);
	}

	public long getAqrId() {
		return _aqrId;
	}

	public void setAqrId(long aqrId) {
		_aqrId = aqrId;
	}

	public long getAccessability() {
		return _accessability;
	}

	public void setAccessability(long accessability) {
		_accessability = accessability;
	}

	public long getQuality() {
		return _quality;
	}

	public void setQuality(long quality) {
		_quality = quality;
	}

	public long getRelevance() {
		return _relevance;
	}

	public void setRelevance(long relevance) {
		_relevance = relevance;
	}

	public long getMasterCandidateId() {
		return _masterCandidateId;
	}

	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateId = masterCandidateId;
	}

	public String getAqrrater() {
		return _aqrrater;
	}

	public void setAqrrater(String aqrrater) {
		_aqrrater = aqrrater;
	}

	public String getRatingtype() {
		return _ratingtype;
	}

	public void setRatingtype(String ratingtype) {
		_ratingtype = ratingtype;
	}

	private long _aqrId;
	private long _accessability;
	private long _quality;
	private long _relevance;
	private long _masterCandidateId;
	private String _aqrrater;
	private String _ratingtype;
}