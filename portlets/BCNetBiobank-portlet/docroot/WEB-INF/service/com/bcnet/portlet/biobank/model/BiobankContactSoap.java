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

import com.bcnet.portlet.biobank.service.persistence.BiobankContactPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.BiobankContactServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.BiobankContactServiceSoap
 * @generated
 */
public class BiobankContactSoap implements Serializable {
	public static BiobankContactSoap toSoapModel(BiobankContact model) {
		BiobankContactSoap soapModel = new BiobankContactSoap();

		soapModel.setBiobankDbId(model.getBiobankDbId());
		soapModel.setContactId(model.getContactId());

		return soapModel;
	}

	public static BiobankContactSoap[] toSoapModels(BiobankContact[] models) {
		BiobankContactSoap[] soapModels = new BiobankContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiobankContactSoap[][] toSoapModels(BiobankContact[][] models) {
		BiobankContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiobankContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiobankContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiobankContactSoap[] toSoapModels(List<BiobankContact> models) {
		List<BiobankContactSoap> soapModels = new ArrayList<BiobankContactSoap>(models.size());

		for (BiobankContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiobankContactSoap[soapModels.size()]);
	}

	public BiobankContactSoap() {
	}

	public BiobankContactPK getPrimaryKey() {
		return new BiobankContactPK(_biobankDbId, _contactId);
	}

	public void setPrimaryKey(BiobankContactPK pk) {
		setBiobankDbId(pk.biobankDbId);
		setContactId(pk.contactId);
	}

	public long getBiobankDbId() {
		return _biobankDbId;
	}

	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	private long _biobankDbId;
	private long _contactId;
}