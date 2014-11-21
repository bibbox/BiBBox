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
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.BiobankAttributeListsServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.BiobankAttributeListsServiceSoap
 * @generated
 */
public class BiobankAttributeListsSoap implements Serializable {
	public static BiobankAttributeListsSoap toSoapModel(
		BiobankAttributeLists model) {
		BiobankAttributeListsSoap soapModel = new BiobankAttributeListsSoap();

		soapModel.setBiobankAttributeListsId(model.getBiobankAttributeListsId());
		soapModel.setBiobankDbId(model.getBiobankDbId());
		soapModel.setAttributeListName(model.getAttributeListName());
		soapModel.setAttributeListValue(model.getAttributeListValue());

		return soapModel;
	}

	public static BiobankAttributeListsSoap[] toSoapModels(
		BiobankAttributeLists[] models) {
		BiobankAttributeListsSoap[] soapModels = new BiobankAttributeListsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiobankAttributeListsSoap[][] toSoapModels(
		BiobankAttributeLists[][] models) {
		BiobankAttributeListsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiobankAttributeListsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiobankAttributeListsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiobankAttributeListsSoap[] toSoapModels(
		List<BiobankAttributeLists> models) {
		List<BiobankAttributeListsSoap> soapModels = new ArrayList<BiobankAttributeListsSoap>(models.size());

		for (BiobankAttributeLists model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiobankAttributeListsSoap[soapModels.size()]);
	}

	public BiobankAttributeListsSoap() {
	}

	public long getPrimaryKey() {
		return _biobankAttributeListsId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankAttributeListsId(pk);
	}

	public long getBiobankAttributeListsId() {
		return _biobankAttributeListsId;
	}

	public void setBiobankAttributeListsId(long biobankAttributeListsId) {
		_biobankAttributeListsId = biobankAttributeListsId;
	}

	public long getBiobankDbId() {
		return _biobankDbId;
	}

	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;
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

	private long _biobankAttributeListsId;
	private long _biobankDbId;
	private String _attributeListName;
	private String _attributeListValue;
}