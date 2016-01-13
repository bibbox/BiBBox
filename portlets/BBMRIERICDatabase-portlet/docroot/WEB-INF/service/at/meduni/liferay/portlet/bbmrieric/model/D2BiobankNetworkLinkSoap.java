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

package at.meduni.liferay.portlet.bbmrieric.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class D2BiobankNetworkLinkSoap implements Serializable {
	public static D2BiobankNetworkLinkSoap toSoapModel(
		D2BiobankNetworkLink model) {
		D2BiobankNetworkLinkSoap soapModel = new D2BiobankNetworkLinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setD2biobanknetworklinkId(model.getD2biobanknetworklinkId());
		soapModel.setD2biobanknetworkId(model.getD2biobanknetworkId());
		soapModel.setD2linkId(model.getD2linkId());
		soapModel.setD2linktype(model.getD2linktype());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUpdateuuid(model.getUpdateuuid());

		return soapModel;
	}

	public static D2BiobankNetworkLinkSoap[] toSoapModels(
		D2BiobankNetworkLink[] models) {
		D2BiobankNetworkLinkSoap[] soapModels = new D2BiobankNetworkLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankNetworkLinkSoap[][] toSoapModels(
		D2BiobankNetworkLink[][] models) {
		D2BiobankNetworkLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new D2BiobankNetworkLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new D2BiobankNetworkLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankNetworkLinkSoap[] toSoapModels(
		List<D2BiobankNetworkLink> models) {
		List<D2BiobankNetworkLinkSoap> soapModels = new ArrayList<D2BiobankNetworkLinkSoap>(models.size());

		for (D2BiobankNetworkLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new D2BiobankNetworkLinkSoap[soapModels.size()]);
	}

	public D2BiobankNetworkLinkSoap() {
	}

	public long getPrimaryKey() {
		return _d2biobanknetworklinkId;
	}

	public void setPrimaryKey(long pk) {
		setD2biobanknetworklinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getD2biobanknetworklinkId() {
		return _d2biobanknetworklinkId;
	}

	public void setD2biobanknetworklinkId(long d2biobanknetworklinkId) {
		_d2biobanknetworklinkId = d2biobanknetworklinkId;
	}

	public long getD2biobanknetworkId() {
		return _d2biobanknetworkId;
	}

	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		_d2biobanknetworkId = d2biobanknetworkId;
	}

	public long getD2linkId() {
		return _d2linkId;
	}

	public void setD2linkId(long d2linkId) {
		_d2linkId = d2linkId;
	}

	public String getD2linktype() {
		return _d2linktype;
	}

	public void setD2linktype(String d2linktype) {
		_d2linktype = d2linktype;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getUpdateuuid() {
		return _updateuuid;
	}

	public void setUpdateuuid(String updateuuid) {
		_updateuuid = updateuuid;
	}

	private String _uuid;
	private long _d2biobanknetworklinkId;
	private long _d2biobanknetworkId;
	private long _d2linkId;
	private String _d2linktype;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _updateuuid;
}