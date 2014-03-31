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

package at.meduni.liferay.portlet.bbmriat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Robert Reihs
 * @generated
 */
public class ddllinkingtableSoap implements Serializable {
	public static ddllinkingtableSoap toSoapModel(ddllinkingtable model) {
		ddllinkingtableSoap soapModel = new ddllinkingtableSoap();

		soapModel.setDdllinkingtable(model.getDdllinkingtable());
		soapModel.setRecordid(model.getRecordid());
		soapModel.setRecordsetid(model.getRecordsetid());
		soapModel.setLinkrecordid(model.getLinkrecordid());
		soapModel.setLinkrecordsetid(model.getLinkrecordsetid());

		return soapModel;
	}

	public static ddllinkingtableSoap[] toSoapModels(ddllinkingtable[] models) {
		ddllinkingtableSoap[] soapModels = new ddllinkingtableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ddllinkingtableSoap[][] toSoapModels(
		ddllinkingtable[][] models) {
		ddllinkingtableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ddllinkingtableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ddllinkingtableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ddllinkingtableSoap[] toSoapModels(
		List<ddllinkingtable> models) {
		List<ddllinkingtableSoap> soapModels = new ArrayList<ddllinkingtableSoap>(models.size());

		for (ddllinkingtable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ddllinkingtableSoap[soapModels.size()]);
	}

	public ddllinkingtableSoap() {
	}

	public long getPrimaryKey() {
		return _ddllinkingtable;
	}

	public void setPrimaryKey(long pk) {
		setDdllinkingtable(pk);
	}

	public long getDdllinkingtable() {
		return _ddllinkingtable;
	}

	public void setDdllinkingtable(long ddllinkingtable) {
		_ddllinkingtable = ddllinkingtable;
	}

	public long getRecordid() {
		return _recordid;
	}

	public void setRecordid(long recordid) {
		_recordid = recordid;
	}

	public long getRecordsetid() {
		return _recordsetid;
	}

	public void setRecordsetid(long recordsetid) {
		_recordsetid = recordsetid;
	}

	public long getLinkrecordid() {
		return _linkrecordid;
	}

	public void setLinkrecordid(long linkrecordid) {
		_linkrecordid = linkrecordid;
	}

	public long getLinkrecordsetid() {
		return _linkrecordsetid;
	}

	public void setLinkrecordsetid(long linkrecordsetid) {
		_linkrecordsetid = linkrecordsetid;
	}

	private long _ddllinkingtable;
	private long _recordid;
	private long _recordsetid;
	private long _linkrecordid;
	private long _linkrecordsetid;
}