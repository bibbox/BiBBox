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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class NetworksSoap implements Serializable {
	public static NetworksSoap toSoapModel(Networks model) {
		NetworksSoap soapModel = new NetworksSoap();

		soapModel.setNetworkId(model.getNetworkId());
		soapModel.setOrganizationnetworkId(model.getOrganizationnetworkId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setRelation(model.getRelation());
		soapModel.setExternalnetworkId(model.getExternalnetworkId());
		soapModel.setYearofestablishment(model.getYearofestablishment());

		return soapModel;
	}

	public static NetworksSoap[] toSoapModels(Networks[] models) {
		NetworksSoap[] soapModels = new NetworksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NetworksSoap[][] toSoapModels(Networks[][] models) {
		NetworksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NetworksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NetworksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NetworksSoap[] toSoapModels(List<Networks> models) {
		List<NetworksSoap> soapModels = new ArrayList<NetworksSoap>(models.size());

		for (Networks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NetworksSoap[soapModels.size()]);
	}

	public NetworksSoap() {
	}

	public long getPrimaryKey() {
		return _networkId;
	}

	public void setPrimaryKey(long pk) {
		setNetworkId(pk);
	}

	public long getNetworkId() {
		return _networkId;
	}

	public void setNetworkId(long networkId) {
		_networkId = networkId;
	}

	public long getOrganizationnetworkId() {
		return _organizationnetworkId;
	}

	public void setOrganizationnetworkId(long organizationnetworkId) {
		_organizationnetworkId = organizationnetworkId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getRelation() {
		return _relation;
	}

	public void setRelation(String relation) {
		_relation = relation;
	}

	public String getExternalnetworkId() {
		return _externalnetworkId;
	}

	public void setExternalnetworkId(String externalnetworkId) {
		_externalnetworkId = externalnetworkId;
	}

	public String getYearofestablishment() {
		return _yearofestablishment;
	}

	public void setYearofestablishment(String yearofestablishment) {
		_yearofestablishment = yearofestablishment;
	}

	private long _networkId;
	private long _organizationnetworkId;
	private long _organizationId;
	private String _relation;
	private String _externalnetworkId;
	private String _yearofestablishment;
}