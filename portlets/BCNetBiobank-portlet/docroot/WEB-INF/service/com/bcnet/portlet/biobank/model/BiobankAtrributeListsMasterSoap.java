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

package com.bcnet.portlet.biobank.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.BiobankAtrributeListsMasterServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.BiobankAtrributeListsMasterServiceSoap
 * @generated
 */
public class BiobankAtrributeListsMasterSoap implements Serializable {
	public static BiobankAtrributeListsMasterSoap toSoapModel(
		BiobankAtrributeListsMaster model) {
		BiobankAtrributeListsMasterSoap soapModel = new BiobankAtrributeListsMasterSoap();

		soapModel.setBiobankAttributeListsMasterId(model.getBiobankAttributeListsMasterId());
		soapModel.setAttributeListName(model.getAttributeListName());
		soapModel.setAttributeListValue(model.getAttributeListValue());

		return soapModel;
	}

	public static BiobankAtrributeListsMasterSoap[] toSoapModels(
		BiobankAtrributeListsMaster[] models) {
		BiobankAtrributeListsMasterSoap[] soapModels = new BiobankAtrributeListsMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiobankAtrributeListsMasterSoap[][] toSoapModels(
		BiobankAtrributeListsMaster[][] models) {
		BiobankAtrributeListsMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiobankAtrributeListsMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiobankAtrributeListsMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiobankAtrributeListsMasterSoap[] toSoapModels(
		List<BiobankAtrributeListsMaster> models) {
		List<BiobankAtrributeListsMasterSoap> soapModels = new ArrayList<BiobankAtrributeListsMasterSoap>(models.size());

		for (BiobankAtrributeListsMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiobankAtrributeListsMasterSoap[soapModels.size()]);
	}

	public BiobankAtrributeListsMasterSoap() {
	}

	public long getPrimaryKey() {
		return _biobankAttributeListsMasterId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankAttributeListsMasterId(pk);
	}

	public long getBiobankAttributeListsMasterId() {
		return _biobankAttributeListsMasterId;
	}

	public void setBiobankAttributeListsMasterId(
		long biobankAttributeListsMasterId) {
		_biobankAttributeListsMasterId = biobankAttributeListsMasterId;
	}

	public String getAttributeListName() {
		return _attributeListName;
	}

	public void setAttributeListName(String attributeListName) {
		_attributeListName = attributeListName;
	}

	public String getAttributeListValue() {
		return _attributeListValue;
	}

	public void setAttributeListValue(String attributeListValue) {
		_attributeListValue = attributeListValue;
	}

	private long _biobankAttributeListsMasterId;
	private String _attributeListName;
	private String _attributeListValue;
}