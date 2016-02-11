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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.idcardServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.idcardServiceSoap
 * @generated
 */
public class idcardSoap implements Serializable {
	public static idcardSoap toSoapModel(idcard model) {
		idcardSoap soapModel = new idcardSoap();

		soapModel.setIdcardId(model.getIdcardId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserip(model.getUserip());
		soapModel.setLogmsg(model.getLogmsg());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static idcardSoap[] toSoapModels(idcard[] models) {
		idcardSoap[] soapModels = new idcardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static idcardSoap[][] toSoapModels(idcard[][] models) {
		idcardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new idcardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new idcardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static idcardSoap[] toSoapModels(List<idcard> models) {
		List<idcardSoap> soapModels = new ArrayList<idcardSoap>(models.size());

		for (idcard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new idcardSoap[soapModels.size()]);
	}

	public idcardSoap() {
	}

	public long getPrimaryKey() {
		return _idcardId;
	}

	public void setPrimaryKey(long pk) {
		setIdcardId(pk);
	}

	public long getIdcardId() {
		return _idcardId;
	}

	public void setIdcardId(long idcardId) {
		_idcardId = idcardId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserip() {
		return _userip;
	}

	public void setUserip(String userip) {
		_userip = userip;
	}

	public String getLogmsg() {
		return _logmsg;
	}

	public void setLogmsg(String logmsg) {
		_logmsg = logmsg;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private long _idcardId;
	private long _userId;
	private String _userip;
	private String _logmsg;
	private Date _date;
}