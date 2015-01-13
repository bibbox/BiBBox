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

package at.rdconnect.update.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.rdconnect.update.service.http.AccessibilityUpdateServiceSoap}.
 *
 * @author reihsr
 * @see at.rdconnect.update.service.http.AccessibilityUpdateServiceSoap
 * @generated
 */
public class AccessibilityUpdateSoap implements Serializable {
	public static AccessibilityUpdateSoap toSoapModel(AccessibilityUpdate model) {
		AccessibilityUpdateSoap soapModel = new AccessibilityUpdateSoap();

		soapModel.setCoreid(model.getCoreid());
		soapModel.setOrganizationid(model.getOrganizationid());
		soapModel.setFieldname(model.getFieldname());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static AccessibilityUpdateSoap[] toSoapModels(
		AccessibilityUpdate[] models) {
		AccessibilityUpdateSoap[] soapModels = new AccessibilityUpdateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccessibilityUpdateSoap[][] toSoapModels(
		AccessibilityUpdate[][] models) {
		AccessibilityUpdateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccessibilityUpdateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccessibilityUpdateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccessibilityUpdateSoap[] toSoapModels(
		List<AccessibilityUpdate> models) {
		List<AccessibilityUpdateSoap> soapModels = new ArrayList<AccessibilityUpdateSoap>(models.size());

		for (AccessibilityUpdate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccessibilityUpdateSoap[soapModels.size()]);
	}

	public AccessibilityUpdateSoap() {
	}

	public long getPrimaryKey() {
		return _coreid;
	}

	public void setPrimaryKey(long pk) {
		setCoreid(pk);
	}

	public long getCoreid() {
		return _coreid;
	}

	public void setCoreid(long coreid) {
		_coreid = coreid;
	}

	public long getOrganizationid() {
		return _organizationid;
	}

	public void setOrganizationid(long organizationid) {
		_organizationid = organizationid;
	}

	public String getFieldname() {
		return _fieldname;
	}

	public void setFieldname(String fieldname) {
		_fieldname = fieldname;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _coreid;
	private long _organizationid;
	private String _fieldname;
	private String _value;
}