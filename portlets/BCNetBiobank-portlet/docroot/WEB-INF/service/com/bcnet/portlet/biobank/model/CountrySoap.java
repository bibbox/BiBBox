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
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.CountryServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.CountryServiceSoap
 * @generated
 */
public class CountrySoap implements Serializable {
	public static CountrySoap toSoapModel(Country model) {
		CountrySoap soapModel = new CountrySoap();

		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static CountrySoap[] toSoapModels(Country[] models) {
		CountrySoap[] soapModels = new CountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[][] toSoapModels(Country[][] models) {
		CountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CountrySoap[] toSoapModels(List<Country> models) {
		List<CountrySoap> soapModels = new ArrayList<CountrySoap>(models.size());

		for (Country model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CountrySoap[soapModels.size()]);
	}

	public CountrySoap() {
	}

	public String getPrimaryKey() {
		return _countryCode;
	}

	public void setPrimaryKey(String pk) {
		setCountryCode(pk);
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _countryCode;
	private String _name;
}