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
public class RDCRecommenderSoap implements Serializable {
	public static RDCRecommenderSoap toSoapModel(RDCRecommender model) {
		RDCRecommenderSoap soapModel = new RDCRecommenderSoap();

		soapModel.setRdcrecommenderid(model.getRdcrecommenderid());
		soapModel.setOrganisationId(model.getOrganisationId());
		soapModel.setRecommendedorganisationId(model.getRecommendedorganisationId());
		soapModel.setRecommendervalue(model.getRecommendervalue());

		return soapModel;
	}

	public static RDCRecommenderSoap[] toSoapModels(RDCRecommender[] models) {
		RDCRecommenderSoap[] soapModels = new RDCRecommenderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDCRecommenderSoap[][] toSoapModels(RDCRecommender[][] models) {
		RDCRecommenderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDCRecommenderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDCRecommenderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDCRecommenderSoap[] toSoapModels(List<RDCRecommender> models) {
		List<RDCRecommenderSoap> soapModels = new ArrayList<RDCRecommenderSoap>(models.size());

		for (RDCRecommender model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDCRecommenderSoap[soapModels.size()]);
	}

	public RDCRecommenderSoap() {
	}

	public long getPrimaryKey() {
		return _rdcrecommenderid;
	}

	public void setPrimaryKey(long pk) {
		setRdcrecommenderid(pk);
	}

	public long getRdcrecommenderid() {
		return _rdcrecommenderid;
	}

	public void setRdcrecommenderid(long rdcrecommenderid) {
		_rdcrecommenderid = rdcrecommenderid;
	}

	public long getOrganisationId() {
		return _organisationId;
	}

	public void setOrganisationId(long organisationId) {
		_organisationId = organisationId;
	}

	public long getRecommendedorganisationId() {
		return _recommendedorganisationId;
	}

	public void setRecommendedorganisationId(long recommendedorganisationId) {
		_recommendedorganisationId = recommendedorganisationId;
	}

	public double getRecommendervalue() {
		return _recommendervalue;
	}

	public void setRecommendervalue(double recommendervalue) {
		_recommendervalue = recommendervalue;
	}

	private long _rdcrecommenderid;
	private long _organisationId;
	private long _recommendedorganisationId;
	private double _recommendervalue;
}