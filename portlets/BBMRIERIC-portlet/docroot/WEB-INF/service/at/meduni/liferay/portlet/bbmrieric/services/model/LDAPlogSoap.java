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

package at.meduni.liferay.portlet.bbmrieric.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class LDAPlogSoap implements Serializable {
	public static LDAPlogSoap toSoapModel(LDAPlog model) {
		LDAPlogSoap soapModel = new LDAPlogSoap();

		soapModel.setLdaplogId(model.getLdaplogId());

		return soapModel;
	}

	public static LDAPlogSoap[] toSoapModels(LDAPlog[] models) {
		LDAPlogSoap[] soapModels = new LDAPlogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LDAPlogSoap[][] toSoapModels(LDAPlog[][] models) {
		LDAPlogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LDAPlogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LDAPlogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LDAPlogSoap[] toSoapModels(List<LDAPlog> models) {
		List<LDAPlogSoap> soapModels = new ArrayList<LDAPlogSoap>(models.size());

		for (LDAPlog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LDAPlogSoap[soapModels.size()]);
	}

	public LDAPlogSoap() {
	}

	public long getPrimaryKey() {
		return _ldaplogId;
	}

	public void setPrimaryKey(long pk) {
		setLdaplogId(pk);
	}

	public long getLdaplogId() {
		return _ldaplogId;
	}

	public void setLdaplogId(long ldaplogId) {
		_ldaplogId = ldaplogId;
	}

	private long _ldaplogId;
}