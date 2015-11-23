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
public class ContactInformationSoap implements Serializable {
	public static ContactInformationSoap toSoapModel(ContactInformation model) {
		ContactInformationSoap soapModel = new ContactInformationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setContactinformationId(model.getContactinformationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUpdateuuid(model.getUpdateuuid());
		soapModel.setContactID(model.getContactID());
		soapModel.setContactEmail(model.getContactEmail());
		soapModel.setContactCountry(model.getContactCountry());
		soapModel.setContactFirstName(model.getContactFirstName());
		soapModel.setContactLastName(model.getContactLastName());
		soapModel.setContactPhone(model.getContactPhone());
		soapModel.setContactAddress(model.getContactAddress());
		soapModel.setContactZIP(model.getContactZIP());
		soapModel.setContactCity(model.getContactCity());

		return soapModel;
	}

	public static ContactInformationSoap[] toSoapModels(
		ContactInformation[] models) {
		ContactInformationSoap[] soapModels = new ContactInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactInformationSoap[][] toSoapModels(
		ContactInformation[][] models) {
		ContactInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactInformationSoap[] toSoapModels(
		List<ContactInformation> models) {
		List<ContactInformationSoap> soapModels = new ArrayList<ContactInformationSoap>(models.size());

		for (ContactInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactInformationSoap[soapModels.size()]);
	}

	public ContactInformationSoap() {
	}

	public long getPrimaryKey() {
		return _contactinformationId;
	}

	public void setPrimaryKey(long pk) {
		setContactinformationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getContactinformationId() {
		return _contactinformationId;
	}

	public void setContactinformationId(long contactinformationId) {
		_contactinformationId = contactinformationId;
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

	public String getContactID() {
		return _contactID;
	}

	public void setContactID(String contactID) {
		_contactID = contactID;
	}

	public String getContactEmail() {
		return _contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		_contactEmail = contactEmail;
	}

	public String getContactCountry() {
		return _contactCountry;
	}

	public void setContactCountry(String contactCountry) {
		_contactCountry = contactCountry;
	}

	public String getContactFirstName() {
		return _contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		_contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return _contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		_contactLastName = contactLastName;
	}

	public String getContactPhone() {
		return _contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		_contactPhone = contactPhone;
	}

	public String getContactAddress() {
		return _contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		_contactAddress = contactAddress;
	}

	public String getContactZIP() {
		return _contactZIP;
	}

	public void setContactZIP(String contactZIP) {
		_contactZIP = contactZIP;
	}

	public String getContactCity() {
		return _contactCity;
	}

	public void setContactCity(String contactCity) {
		_contactCity = contactCity;
	}

	private String _uuid;
	private long _contactinformationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _updateuuid;
	private String _contactID;
	private String _contactEmail;
	private String _contactCountry;
	private String _contactFirstName;
	private String _contactLastName;
	private String _contactPhone;
	private String _contactAddress;
	private String _contactZIP;
	private String _contactCity;
}