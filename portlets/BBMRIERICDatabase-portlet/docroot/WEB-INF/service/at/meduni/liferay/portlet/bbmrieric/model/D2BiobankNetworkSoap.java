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
public class D2BiobankNetworkSoap implements Serializable {
	public static D2BiobankNetworkSoap toSoapModel(D2BiobankNetwork model) {
		D2BiobankNetworkSoap soapModel = new D2BiobankNetworkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setD2biobanknetworkId(model.getD2biobanknetworkId());
		soapModel.setParentd2biobanknetworkId(model.getParentd2biobanknetworkId());
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
		soapModel.setContactIDRef(model.getContactIDRef());
		soapModel.setContactPriority(model.getContactPriority());
		soapModel.setBbmriBiobankNetworkID(model.getBbmriBiobankNetworkID());
		soapModel.setBiobankNetworkName(model.getBiobankNetworkName());
		soapModel.setBiobankNetworkCommonCollectionFocus(model.getBiobankNetworkCommonCollectionFocus());
		soapModel.setBiobankNetworkCommonCharter(model.getBiobankNetworkCommonCharter());
		soapModel.setBiobankNetworkCommonSOPs(model.getBiobankNetworkCommonSOPs());
		soapModel.setBiobankNetworkCommonDataAccessPolicy(model.getBiobankNetworkCommonDataAccessPolicy());
		soapModel.setBiobankNetworkCommonSampleAccessPolicy(model.getBiobankNetworkCommonSampleAccessPolicy());
		soapModel.setBiobankNetworkCommonMTA(model.getBiobankNetworkCommonMTA());
		soapModel.setBiobankNetworkCommonRepresentation(model.getBiobankNetworkCommonRepresentation());
		soapModel.setBiobankNetworkCommonURL(model.getBiobankNetworkCommonURL());
		soapModel.setBiobankNetworkIDRef(model.getBiobankNetworkIDRef());
		soapModel.setGeoLatitude(model.getGeoLatitude());
		soapModel.setGeoLongitude(model.getGeoLongitude());
		soapModel.setBiobankNetworkAcronym(model.getBiobankNetworkAcronym());
		soapModel.setBiobankNetworkDescription(model.getBiobankNetworkDescription());
		soapModel.setBiobankNetworkURL(model.getBiobankNetworkURL());
		soapModel.setBiobankNetworkJuridicalPerson(model.getBiobankNetworkJuridicalPerson());

		return soapModel;
	}

	public static D2BiobankNetworkSoap[] toSoapModels(D2BiobankNetwork[] models) {
		D2BiobankNetworkSoap[] soapModels = new D2BiobankNetworkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankNetworkSoap[][] toSoapModels(
		D2BiobankNetwork[][] models) {
		D2BiobankNetworkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new D2BiobankNetworkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new D2BiobankNetworkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankNetworkSoap[] toSoapModels(
		List<D2BiobankNetwork> models) {
		List<D2BiobankNetworkSoap> soapModels = new ArrayList<D2BiobankNetworkSoap>(models.size());

		for (D2BiobankNetwork model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new D2BiobankNetworkSoap[soapModels.size()]);
	}

	public D2BiobankNetworkSoap() {
	}

	public long getPrimaryKey() {
		return _d2biobanknetworkId;
	}

	public void setPrimaryKey(long pk) {
		setD2biobanknetworkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getD2biobanknetworkId() {
		return _d2biobanknetworkId;
	}

	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		_d2biobanknetworkId = d2biobanknetworkId;
	}

	public long getParentd2biobanknetworkId() {
		return _parentd2biobanknetworkId;
	}

	public void setParentd2biobanknetworkId(long parentd2biobanknetworkId) {
		_parentd2biobanknetworkId = parentd2biobanknetworkId;
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

	public String getContactIDRef() {
		return _contactIDRef;
	}

	public void setContactIDRef(String contactIDRef) {
		_contactIDRef = contactIDRef;
	}

	public long getContactPriority() {
		return _contactPriority;
	}

	public void setContactPriority(long contactPriority) {
		_contactPriority = contactPriority;
	}

	public String getBbmriBiobankNetworkID() {
		return _bbmriBiobankNetworkID;
	}

	public void setBbmriBiobankNetworkID(String bbmriBiobankNetworkID) {
		_bbmriBiobankNetworkID = bbmriBiobankNetworkID;
	}

	public String getBiobankNetworkName() {
		return _biobankNetworkName;
	}

	public void setBiobankNetworkName(String biobankNetworkName) {
		_biobankNetworkName = biobankNetworkName;
	}

	public boolean getBiobankNetworkCommonCollectionFocus() {
		return _biobankNetworkCommonCollectionFocus;
	}

	public boolean isBiobankNetworkCommonCollectionFocus() {
		return _biobankNetworkCommonCollectionFocus;
	}

	public void setBiobankNetworkCommonCollectionFocus(
		boolean biobankNetworkCommonCollectionFocus) {
		_biobankNetworkCommonCollectionFocus = biobankNetworkCommonCollectionFocus;
	}

	public boolean getBiobankNetworkCommonCharter() {
		return _biobankNetworkCommonCharter;
	}

	public boolean isBiobankNetworkCommonCharter() {
		return _biobankNetworkCommonCharter;
	}

	public void setBiobankNetworkCommonCharter(
		boolean biobankNetworkCommonCharter) {
		_biobankNetworkCommonCharter = biobankNetworkCommonCharter;
	}

	public boolean getBiobankNetworkCommonSOPs() {
		return _biobankNetworkCommonSOPs;
	}

	public boolean isBiobankNetworkCommonSOPs() {
		return _biobankNetworkCommonSOPs;
	}

	public void setBiobankNetworkCommonSOPs(boolean biobankNetworkCommonSOPs) {
		_biobankNetworkCommonSOPs = biobankNetworkCommonSOPs;
	}

	public boolean getBiobankNetworkCommonDataAccessPolicy() {
		return _biobankNetworkCommonDataAccessPolicy;
	}

	public boolean isBiobankNetworkCommonDataAccessPolicy() {
		return _biobankNetworkCommonDataAccessPolicy;
	}

	public void setBiobankNetworkCommonDataAccessPolicy(
		boolean biobankNetworkCommonDataAccessPolicy) {
		_biobankNetworkCommonDataAccessPolicy = biobankNetworkCommonDataAccessPolicy;
	}

	public boolean getBiobankNetworkCommonSampleAccessPolicy() {
		return _biobankNetworkCommonSampleAccessPolicy;
	}

	public boolean isBiobankNetworkCommonSampleAccessPolicy() {
		return _biobankNetworkCommonSampleAccessPolicy;
	}

	public void setBiobankNetworkCommonSampleAccessPolicy(
		boolean biobankNetworkCommonSampleAccessPolicy) {
		_biobankNetworkCommonSampleAccessPolicy = biobankNetworkCommonSampleAccessPolicy;
	}

	public boolean getBiobankNetworkCommonMTA() {
		return _biobankNetworkCommonMTA;
	}

	public boolean isBiobankNetworkCommonMTA() {
		return _biobankNetworkCommonMTA;
	}

	public void setBiobankNetworkCommonMTA(boolean biobankNetworkCommonMTA) {
		_biobankNetworkCommonMTA = biobankNetworkCommonMTA;
	}

	public boolean getBiobankNetworkCommonRepresentation() {
		return _biobankNetworkCommonRepresentation;
	}

	public boolean isBiobankNetworkCommonRepresentation() {
		return _biobankNetworkCommonRepresentation;
	}

	public void setBiobankNetworkCommonRepresentation(
		boolean biobankNetworkCommonRepresentation) {
		_biobankNetworkCommonRepresentation = biobankNetworkCommonRepresentation;
	}

	public boolean getBiobankNetworkCommonURL() {
		return _biobankNetworkCommonURL;
	}

	public boolean isBiobankNetworkCommonURL() {
		return _biobankNetworkCommonURL;
	}

	public void setBiobankNetworkCommonURL(boolean biobankNetworkCommonURL) {
		_biobankNetworkCommonURL = biobankNetworkCommonURL;
	}

	public String getBiobankNetworkIDRef() {
		return _biobankNetworkIDRef;
	}

	public void setBiobankNetworkIDRef(String biobankNetworkIDRef) {
		_biobankNetworkIDRef = biobankNetworkIDRef;
	}

	public String getGeoLatitude() {
		return _geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		_geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return _geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		_geoLongitude = geoLongitude;
	}

	public String getBiobankNetworkAcronym() {
		return _biobankNetworkAcronym;
	}

	public void setBiobankNetworkAcronym(String biobankNetworkAcronym) {
		_biobankNetworkAcronym = biobankNetworkAcronym;
	}

	public String getBiobankNetworkDescription() {
		return _biobankNetworkDescription;
	}

	public void setBiobankNetworkDescription(String biobankNetworkDescription) {
		_biobankNetworkDescription = biobankNetworkDescription;
	}

	public String getBiobankNetworkURL() {
		return _biobankNetworkURL;
	}

	public void setBiobankNetworkURL(String biobankNetworkURL) {
		_biobankNetworkURL = biobankNetworkURL;
	}

	public String getBiobankNetworkJuridicalPerson() {
		return _biobankNetworkJuridicalPerson;
	}

	public void setBiobankNetworkJuridicalPerson(
		String biobankNetworkJuridicalPerson) {
		_biobankNetworkJuridicalPerson = biobankNetworkJuridicalPerson;
	}

	private String _uuid;
	private long _d2biobanknetworkId;
	private long _parentd2biobanknetworkId;
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
	private String _contactIDRef;
	private long _contactPriority;
	private String _bbmriBiobankNetworkID;
	private String _biobankNetworkName;
	private boolean _biobankNetworkCommonCollectionFocus;
	private boolean _biobankNetworkCommonCharter;
	private boolean _biobankNetworkCommonSOPs;
	private boolean _biobankNetworkCommonDataAccessPolicy;
	private boolean _biobankNetworkCommonSampleAccessPolicy;
	private boolean _biobankNetworkCommonMTA;
	private boolean _biobankNetworkCommonRepresentation;
	private boolean _biobankNetworkCommonURL;
	private String _biobankNetworkIDRef;
	private String _geoLatitude;
	private String _geoLongitude;
	private String _biobankNetworkAcronym;
	private String _biobankNetworkDescription;
	private String _biobankNetworkURL;
	private String _biobankNetworkJuridicalPerson;
}