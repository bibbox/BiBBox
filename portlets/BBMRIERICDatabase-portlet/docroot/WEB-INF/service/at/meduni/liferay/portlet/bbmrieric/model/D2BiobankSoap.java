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
public class D2BiobankSoap implements Serializable {
	public static D2BiobankSoap toSoapModel(D2Biobank model) {
		D2BiobankSoap soapModel = new D2BiobankSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBiobankId(model.getBiobankId());
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
		soapModel.setBbmribiobankID(model.getBbmribiobankID());
		soapModel.setBiobankName(model.getBiobankName());
		soapModel.setBiobankJurisdicalPerson(model.getBiobankJurisdicalPerson());
		soapModel.setBiobankCountry(model.getBiobankCountry());
		soapModel.setBiobankPartnerCharterSigned(model.getBiobankPartnerCharterSigned());
		soapModel.setBioresourceReference(model.getBioresourceReference());
		soapModel.setBiobankNetworkIDRef(model.getBiobankNetworkIDRef());
		soapModel.setGeoLatitude(model.getGeoLatitude());
		soapModel.setGeoLongitude(model.getGeoLongitude());
		soapModel.setCollaborationPartnersCommercial(model.getCollaborationPartnersCommercial());
		soapModel.setCollaborationPartnersNonforprofit(model.getCollaborationPartnersNonforprofit());
		soapModel.setBiobankITSupportAvailable(model.getBiobankITSupportAvailable());
		soapModel.setBiobankITStaffSize(model.getBiobankITStaffSize());
		soapModel.setBiobankISAvailable(model.getBiobankISAvailable());
		soapModel.setBiobankHISAvailable(model.getBiobankHISAvailable());
		soapModel.setBiobankAcronym(model.getBiobankAcronym());
		soapModel.setBiobankDescription(model.getBiobankDescription());
		soapModel.setBiobankURL(model.getBiobankURL());
		soapModel.setBiobankHeadFirstName(model.getBiobankHeadFirstName());
		soapModel.setBiobankHeadLastName(model.getBiobankHeadLastName());
		soapModel.setBiobankHeadRole(model.getBiobankHeadRole());
		soapModel.setBiobankClinical(model.getBiobankClinical());
		soapModel.setBiobankPopulation(model.getBiobankPopulation());
		soapModel.setBiobankResearchStudy(model.getBiobankResearchStudy());
		soapModel.setBiobankNonHuman(model.getBiobankNonHuman());
		soapModel.setBiobankCollection(model.getBiobankCollection());

		return soapModel;
	}

	public static D2BiobankSoap[] toSoapModels(D2Biobank[] models) {
		D2BiobankSoap[] soapModels = new D2BiobankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankSoap[][] toSoapModels(D2Biobank[][] models) {
		D2BiobankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new D2BiobankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new D2BiobankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static D2BiobankSoap[] toSoapModels(List<D2Biobank> models) {
		List<D2BiobankSoap> soapModels = new ArrayList<D2BiobankSoap>(models.size());

		for (D2Biobank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new D2BiobankSoap[soapModels.size()]);
	}

	public D2BiobankSoap() {
	}

	public long getPrimaryKey() {
		return _biobankId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBiobankId() {
		return _biobankId;
	}

	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;
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

	public String getBbmribiobankID() {
		return _bbmribiobankID;
	}

	public void setBbmribiobankID(String bbmribiobankID) {
		_bbmribiobankID = bbmribiobankID;
	}

	public String getBiobankName() {
		return _biobankName;
	}

	public void setBiobankName(String biobankName) {
		_biobankName = biobankName;
	}

	public String getBiobankJurisdicalPerson() {
		return _biobankJurisdicalPerson;
	}

	public void setBiobankJurisdicalPerson(String biobankJurisdicalPerson) {
		_biobankJurisdicalPerson = biobankJurisdicalPerson;
	}

	public String getBiobankCountry() {
		return _biobankCountry;
	}

	public void setBiobankCountry(String biobankCountry) {
		_biobankCountry = biobankCountry;
	}

	public boolean getBiobankPartnerCharterSigned() {
		return _biobankPartnerCharterSigned;
	}

	public boolean isBiobankPartnerCharterSigned() {
		return _biobankPartnerCharterSigned;
	}

	public void setBiobankPartnerCharterSigned(
		boolean biobankPartnerCharterSigned) {
		_biobankPartnerCharterSigned = biobankPartnerCharterSigned;
	}

	public String getBioresourceReference() {
		return _bioresourceReference;
	}

	public void setBioresourceReference(String bioresourceReference) {
		_bioresourceReference = bioresourceReference;
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

	public boolean getCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	public boolean isCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_collaborationPartnersCommercial = collaborationPartnersCommercial;
	}

	public boolean getCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	public boolean isCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_collaborationPartnersNonforprofit = collaborationPartnersNonforprofit;
	}

	public boolean getBiobankITSupportAvailable() {
		return _biobankITSupportAvailable;
	}

	public boolean isBiobankITSupportAvailable() {
		return _biobankITSupportAvailable;
	}

	public void setBiobankITSupportAvailable(boolean biobankITSupportAvailable) {
		_biobankITSupportAvailable = biobankITSupportAvailable;
	}

	public long getBiobankITStaffSize() {
		return _biobankITStaffSize;
	}

	public void setBiobankITStaffSize(long biobankITStaffSize) {
		_biobankITStaffSize = biobankITStaffSize;
	}

	public boolean getBiobankISAvailable() {
		return _biobankISAvailable;
	}

	public boolean isBiobankISAvailable() {
		return _biobankISAvailable;
	}

	public void setBiobankISAvailable(boolean biobankISAvailable) {
		_biobankISAvailable = biobankISAvailable;
	}

	public boolean getBiobankHISAvailable() {
		return _biobankHISAvailable;
	}

	public boolean isBiobankHISAvailable() {
		return _biobankHISAvailable;
	}

	public void setBiobankHISAvailable(boolean biobankHISAvailable) {
		_biobankHISAvailable = biobankHISAvailable;
	}

	public String getBiobankAcronym() {
		return _biobankAcronym;
	}

	public void setBiobankAcronym(String biobankAcronym) {
		_biobankAcronym = biobankAcronym;
	}

	public String getBiobankDescription() {
		return _biobankDescription;
	}

	public void setBiobankDescription(String biobankDescription) {
		_biobankDescription = biobankDescription;
	}

	public String getBiobankURL() {
		return _biobankURL;
	}

	public void setBiobankURL(String biobankURL) {
		_biobankURL = biobankURL;
	}

	public String getBiobankHeadFirstName() {
		return _biobankHeadFirstName;
	}

	public void setBiobankHeadFirstName(String biobankHeadFirstName) {
		_biobankHeadFirstName = biobankHeadFirstName;
	}

	public String getBiobankHeadLastName() {
		return _biobankHeadLastName;
	}

	public void setBiobankHeadLastName(String biobankHeadLastName) {
		_biobankHeadLastName = biobankHeadLastName;
	}

	public String getBiobankHeadRole() {
		return _biobankHeadRole;
	}

	public void setBiobankHeadRole(String biobankHeadRole) {
		_biobankHeadRole = biobankHeadRole;
	}

	public boolean getBiobankClinical() {
		return _biobankClinical;
	}

	public boolean isBiobankClinical() {
		return _biobankClinical;
	}

	public void setBiobankClinical(boolean biobankClinical) {
		_biobankClinical = biobankClinical;
	}

	public boolean getBiobankPopulation() {
		return _biobankPopulation;
	}

	public boolean isBiobankPopulation() {
		return _biobankPopulation;
	}

	public void setBiobankPopulation(boolean biobankPopulation) {
		_biobankPopulation = biobankPopulation;
	}

	public boolean getBiobankResearchStudy() {
		return _biobankResearchStudy;
	}

	public boolean isBiobankResearchStudy() {
		return _biobankResearchStudy;
	}

	public void setBiobankResearchStudy(boolean biobankResearchStudy) {
		_biobankResearchStudy = biobankResearchStudy;
	}

	public boolean getBiobankNonHuman() {
		return _biobankNonHuman;
	}

	public boolean isBiobankNonHuman() {
		return _biobankNonHuman;
	}

	public void setBiobankNonHuman(boolean biobankNonHuman) {
		_biobankNonHuman = biobankNonHuman;
	}

	public boolean getBiobankCollection() {
		return _biobankCollection;
	}

	public boolean isBiobankCollection() {
		return _biobankCollection;
	}

	public void setBiobankCollection(boolean biobankCollection) {
		_biobankCollection = biobankCollection;
	}

	private String _uuid;
	private long _biobankId;
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
	private String _bbmribiobankID;
	private String _biobankName;
	private String _biobankJurisdicalPerson;
	private String _biobankCountry;
	private boolean _biobankPartnerCharterSigned;
	private String _bioresourceReference;
	private String _biobankNetworkIDRef;
	private String _geoLatitude;
	private String _geoLongitude;
	private boolean _collaborationPartnersCommercial;
	private boolean _collaborationPartnersNonforprofit;
	private boolean _biobankITSupportAvailable;
	private long _biobankITStaffSize;
	private boolean _biobankISAvailable;
	private boolean _biobankHISAvailable;
	private String _biobankAcronym;
	private String _biobankDescription;
	private String _biobankURL;
	private String _biobankHeadFirstName;
	private String _biobankHeadLastName;
	private String _biobankHeadRole;
	private boolean _biobankClinical;
	private boolean _biobankPopulation;
	private boolean _biobankResearchStudy;
	private boolean _biobankNonHuman;
	private boolean _biobankCollection;
}