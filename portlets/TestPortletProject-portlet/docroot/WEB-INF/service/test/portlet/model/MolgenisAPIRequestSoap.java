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

package test.portlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link test.portlet.service.http.MolgenisAPIRequestServiceSoap}.
 *
 * @author reihsr
 * @see test.portlet.service.http.MolgenisAPIRequestServiceSoap
 * @generated
 */
public class MolgenisAPIRequestSoap implements Serializable {
	public static MolgenisAPIRequestSoap toSoapModel(MolgenisAPIRequest model) {
		MolgenisAPIRequestSoap soapModel = new MolgenisAPIRequestSoap();

		soapModel.setMolgenisapirequestId(model.getMolgenisapirequestId());

		return soapModel;
	}

	public static MolgenisAPIRequestSoap[] toSoapModels(
		MolgenisAPIRequest[] models) {
		MolgenisAPIRequestSoap[] soapModels = new MolgenisAPIRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MolgenisAPIRequestSoap[][] toSoapModels(
		MolgenisAPIRequest[][] models) {
		MolgenisAPIRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MolgenisAPIRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MolgenisAPIRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MolgenisAPIRequestSoap[] toSoapModels(
		List<MolgenisAPIRequest> models) {
		List<MolgenisAPIRequestSoap> soapModels = new ArrayList<MolgenisAPIRequestSoap>(models.size());

		for (MolgenisAPIRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MolgenisAPIRequestSoap[soapModels.size()]);
	}

	public MolgenisAPIRequestSoap() {
	}

	public long getPrimaryKey() {
		return _molgenisapirequestId;
	}

	public void setPrimaryKey(long pk) {
		setMolgenisapirequestId(pk);
	}

	public long getMolgenisapirequestId() {
		return _molgenisapirequestId;
	}

	public void setMolgenisapirequestId(long molgenisapirequestId) {
		_molgenisapirequestId = molgenisapirequestId;
	}

	private long _molgenisapirequestId;
}