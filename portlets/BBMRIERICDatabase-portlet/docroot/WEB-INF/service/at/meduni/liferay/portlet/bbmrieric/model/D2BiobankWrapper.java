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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link D2Biobank}.
 * </p>
 *
 * @author reihsr
 * @see D2Biobank
 * @generated
 */
public class D2BiobankWrapper implements D2Biobank, ModelWrapper<D2Biobank> {
	public D2BiobankWrapper(D2Biobank d2Biobank) {
		_d2Biobank = d2Biobank;
	}

	@Override
	public Class<?> getModelClass() {
		return D2Biobank.class;
	}

	@Override
	public String getModelClassName() {
		return D2Biobank.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("biobankId", getBiobankId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("updateuuid", getUpdateuuid());
		attributes.put("contactIDRef", getContactIDRef());
		attributes.put("contactPriority", getContactPriority());
		attributes.put("bbmribiobankID", getBbmribiobankID());
		attributes.put("biobankName", getBiobankName());
		attributes.put("biobankJurisdicalPerson", getBiobankJurisdicalPerson());
		attributes.put("biobankCountry", getBiobankCountry());
		attributes.put("biobankPartnerCharterSigned",
			getBiobankPartnerCharterSigned());
		attributes.put("bioresourceReference", getBioresourceReference());
		attributes.put("biobankNetworkIDRef", getBiobankNetworkIDRef());
		attributes.put("geoLatitude", getGeoLatitude());
		attributes.put("geoLongitude", getGeoLongitude());
		attributes.put("collaborationPartnersCommercial",
			getCollaborationPartnersCommercial());
		attributes.put("collaborationPartnersNonforprofit",
			getCollaborationPartnersNonforprofit());
		attributes.put("biobankITSupportAvailable",
			getBiobankITSupportAvailable());
		attributes.put("biobankITStaffSize", getBiobankITStaffSize());
		attributes.put("biobankISAvailable", getBiobankISAvailable());
		attributes.put("biobankHISAvailable", getBiobankHISAvailable());
		attributes.put("biobankAcronym", getBiobankAcronym());
		attributes.put("biobankDescription", getBiobankDescription());
		attributes.put("biobankURL", getBiobankURL());
		attributes.put("biobankHeadFirstName", getBiobankHeadFirstName());
		attributes.put("biobankHeadLastName", getBiobankHeadLastName());
		attributes.put("biobankHeadRole", getBiobankHeadRole());
		attributes.put("biobankClinical", getBiobankClinical());
		attributes.put("biobankPopulation", getBiobankPopulation());
		attributes.put("biobankResearchStudy", getBiobankResearchStudy());
		attributes.put("biobankNonHuman", getBiobankNonHuman());
		attributes.put("biobankCollection", getBiobankCollection());
		attributes.put("biobankType", getBiobankType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long biobankId = (Long)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String updateuuid = (String)attributes.get("updateuuid");

		if (updateuuid != null) {
			setUpdateuuid(updateuuid);
		}

		String contactIDRef = (String)attributes.get("contactIDRef");

		if (contactIDRef != null) {
			setContactIDRef(contactIDRef);
		}

		Long contactPriority = (Long)attributes.get("contactPriority");

		if (contactPriority != null) {
			setContactPriority(contactPriority);
		}

		String bbmribiobankID = (String)attributes.get("bbmribiobankID");

		if (bbmribiobankID != null) {
			setBbmribiobankID(bbmribiobankID);
		}

		String biobankName = (String)attributes.get("biobankName");

		if (biobankName != null) {
			setBiobankName(biobankName);
		}

		String biobankJurisdicalPerson = (String)attributes.get(
				"biobankJurisdicalPerson");

		if (biobankJurisdicalPerson != null) {
			setBiobankJurisdicalPerson(biobankJurisdicalPerson);
		}

		String biobankCountry = (String)attributes.get("biobankCountry");

		if (biobankCountry != null) {
			setBiobankCountry(biobankCountry);
		}

		Boolean biobankPartnerCharterSigned = (Boolean)attributes.get(
				"biobankPartnerCharterSigned");

		if (biobankPartnerCharterSigned != null) {
			setBiobankPartnerCharterSigned(biobankPartnerCharterSigned);
		}

		String bioresourceReference = (String)attributes.get(
				"bioresourceReference");

		if (bioresourceReference != null) {
			setBioresourceReference(bioresourceReference);
		}

		String biobankNetworkIDRef = (String)attributes.get(
				"biobankNetworkIDRef");

		if (biobankNetworkIDRef != null) {
			setBiobankNetworkIDRef(biobankNetworkIDRef);
		}

		String geoLatitude = (String)attributes.get("geoLatitude");

		if (geoLatitude != null) {
			setGeoLatitude(geoLatitude);
		}

		String geoLongitude = (String)attributes.get("geoLongitude");

		if (geoLongitude != null) {
			setGeoLongitude(geoLongitude);
		}

		Boolean collaborationPartnersCommercial = (Boolean)attributes.get(
				"collaborationPartnersCommercial");

		if (collaborationPartnersCommercial != null) {
			setCollaborationPartnersCommercial(collaborationPartnersCommercial);
		}

		Boolean collaborationPartnersNonforprofit = (Boolean)attributes.get(
				"collaborationPartnersNonforprofit");

		if (collaborationPartnersNonforprofit != null) {
			setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
		}

		Boolean biobankITSupportAvailable = (Boolean)attributes.get(
				"biobankITSupportAvailable");

		if (biobankITSupportAvailable != null) {
			setBiobankITSupportAvailable(biobankITSupportAvailable);
		}

		Long biobankITStaffSize = (Long)attributes.get("biobankITStaffSize");

		if (biobankITStaffSize != null) {
			setBiobankITStaffSize(biobankITStaffSize);
		}

		Boolean biobankISAvailable = (Boolean)attributes.get(
				"biobankISAvailable");

		if (biobankISAvailable != null) {
			setBiobankISAvailable(biobankISAvailable);
		}

		Boolean biobankHISAvailable = (Boolean)attributes.get(
				"biobankHISAvailable");

		if (biobankHISAvailable != null) {
			setBiobankHISAvailable(biobankHISAvailable);
		}

		String biobankAcronym = (String)attributes.get("biobankAcronym");

		if (biobankAcronym != null) {
			setBiobankAcronym(biobankAcronym);
		}

		String biobankDescription = (String)attributes.get("biobankDescription");

		if (biobankDescription != null) {
			setBiobankDescription(biobankDescription);
		}

		String biobankURL = (String)attributes.get("biobankURL");

		if (biobankURL != null) {
			setBiobankURL(biobankURL);
		}

		String biobankHeadFirstName = (String)attributes.get(
				"biobankHeadFirstName");

		if (biobankHeadFirstName != null) {
			setBiobankHeadFirstName(biobankHeadFirstName);
		}

		String biobankHeadLastName = (String)attributes.get(
				"biobankHeadLastName");

		if (biobankHeadLastName != null) {
			setBiobankHeadLastName(biobankHeadLastName);
		}

		String biobankHeadRole = (String)attributes.get("biobankHeadRole");

		if (biobankHeadRole != null) {
			setBiobankHeadRole(biobankHeadRole);
		}

		Boolean biobankClinical = (Boolean)attributes.get("biobankClinical");

		if (biobankClinical != null) {
			setBiobankClinical(biobankClinical);
		}

		Boolean biobankPopulation = (Boolean)attributes.get("biobankPopulation");

		if (biobankPopulation != null) {
			setBiobankPopulation(biobankPopulation);
		}

		Boolean biobankResearchStudy = (Boolean)attributes.get(
				"biobankResearchStudy");

		if (biobankResearchStudy != null) {
			setBiobankResearchStudy(biobankResearchStudy);
		}

		Boolean biobankNonHuman = (Boolean)attributes.get("biobankNonHuman");

		if (biobankNonHuman != null) {
			setBiobankNonHuman(biobankNonHuman);
		}

		Boolean biobankCollection = (Boolean)attributes.get("biobankCollection");

		if (biobankCollection != null) {
			setBiobankCollection(biobankCollection);
		}

		String biobankType = (String)attributes.get("biobankType");

		if (biobankType != null) {
			setBiobankType(biobankType);
		}
	}

	/**
	* Returns the primary key of this d2 biobank.
	*
	* @return the primary key of this d2 biobank
	*/
	@Override
	public long getPrimaryKey() {
		return _d2Biobank.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d2 biobank.
	*
	* @param primaryKey the primary key of this d2 biobank
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_d2Biobank.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this d2 biobank.
	*
	* @return the uuid of this d2 biobank
	*/
	@Override
	public java.lang.String getUuid() {
		return _d2Biobank.getUuid();
	}

	/**
	* Sets the uuid of this d2 biobank.
	*
	* @param uuid the uuid of this d2 biobank
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_d2Biobank.setUuid(uuid);
	}

	/**
	* Returns the biobank ID of this d2 biobank.
	*
	* @return the biobank ID of this d2 biobank
	*/
	@Override
	public long getBiobankId() {
		return _d2Biobank.getBiobankId();
	}

	/**
	* Sets the biobank ID of this d2 biobank.
	*
	* @param biobankId the biobank ID of this d2 biobank
	*/
	@Override
	public void setBiobankId(long biobankId) {
		_d2Biobank.setBiobankId(biobankId);
	}

	/**
	* Returns the status of this d2 biobank.
	*
	* @return the status of this d2 biobank
	*/
	@Override
	public int getStatus() {
		return _d2Biobank.getStatus();
	}

	/**
	* Sets the status of this d2 biobank.
	*
	* @param status the status of this d2 biobank
	*/
	@Override
	public void setStatus(int status) {
		_d2Biobank.setStatus(status);
	}

	/**
	* Returns the status by user ID of this d2 biobank.
	*
	* @return the status by user ID of this d2 biobank
	*/
	@Override
	public long getStatusByUserId() {
		return _d2Biobank.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this d2 biobank.
	*
	* @param statusByUserId the status by user ID of this d2 biobank
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_d2Biobank.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this d2 biobank.
	*
	* @return the status by user uuid of this d2 biobank
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2Biobank.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this d2 biobank.
	*
	* @param statusByUserUuid the status by user uuid of this d2 biobank
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_d2Biobank.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this d2 biobank.
	*
	* @return the status by user name of this d2 biobank
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _d2Biobank.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this d2 biobank.
	*
	* @param statusByUserName the status by user name of this d2 biobank
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_d2Biobank.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this d2 biobank.
	*
	* @return the status date of this d2 biobank
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _d2Biobank.getStatusDate();
	}

	/**
	* Sets the status date of this d2 biobank.
	*
	* @param statusDate the status date of this d2 biobank
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_d2Biobank.setStatusDate(statusDate);
	}

	/**
	* Returns the company ID of this d2 biobank.
	*
	* @return the company ID of this d2 biobank
	*/
	@Override
	public long getCompanyId() {
		return _d2Biobank.getCompanyId();
	}

	/**
	* Sets the company ID of this d2 biobank.
	*
	* @param companyId the company ID of this d2 biobank
	*/
	@Override
	public void setCompanyId(long companyId) {
		_d2Biobank.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this d2 biobank.
	*
	* @return the group ID of this d2 biobank
	*/
	@Override
	public long getGroupId() {
		return _d2Biobank.getGroupId();
	}

	/**
	* Sets the group ID of this d2 biobank.
	*
	* @param groupId the group ID of this d2 biobank
	*/
	@Override
	public void setGroupId(long groupId) {
		_d2Biobank.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this d2 biobank.
	*
	* @return the user ID of this d2 biobank
	*/
	@Override
	public long getUserId() {
		return _d2Biobank.getUserId();
	}

	/**
	* Sets the user ID of this d2 biobank.
	*
	* @param userId the user ID of this d2 biobank
	*/
	@Override
	public void setUserId(long userId) {
		_d2Biobank.setUserId(userId);
	}

	/**
	* Returns the user uuid of this d2 biobank.
	*
	* @return the user uuid of this d2 biobank
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2Biobank.getUserUuid();
	}

	/**
	* Sets the user uuid of this d2 biobank.
	*
	* @param userUuid the user uuid of this d2 biobank
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_d2Biobank.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this d2 biobank.
	*
	* @return the user name of this d2 biobank
	*/
	@Override
	public java.lang.String getUserName() {
		return _d2Biobank.getUserName();
	}

	/**
	* Sets the user name of this d2 biobank.
	*
	* @param userName the user name of this d2 biobank
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_d2Biobank.setUserName(userName);
	}

	/**
	* Returns the create date of this d2 biobank.
	*
	* @return the create date of this d2 biobank
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _d2Biobank.getCreateDate();
	}

	/**
	* Sets the create date of this d2 biobank.
	*
	* @param createDate the create date of this d2 biobank
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_d2Biobank.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this d2 biobank.
	*
	* @return the modified date of this d2 biobank
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _d2Biobank.getModifiedDate();
	}

	/**
	* Sets the modified date of this d2 biobank.
	*
	* @param modifiedDate the modified date of this d2 biobank
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_d2Biobank.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updateuuid of this d2 biobank.
	*
	* @return the updateuuid of this d2 biobank
	*/
	@Override
	public java.lang.String getUpdateuuid() {
		return _d2Biobank.getUpdateuuid();
	}

	/**
	* Sets the updateuuid of this d2 biobank.
	*
	* @param updateuuid the updateuuid of this d2 biobank
	*/
	@Override
	public void setUpdateuuid(java.lang.String updateuuid) {
		_d2Biobank.setUpdateuuid(updateuuid);
	}

	/**
	* Returns the contact i d ref of this d2 biobank.
	*
	* @return the contact i d ref of this d2 biobank
	*/
	@Override
	public java.lang.String getContactIDRef() {
		return _d2Biobank.getContactIDRef();
	}

	/**
	* Sets the contact i d ref of this d2 biobank.
	*
	* @param contactIDRef the contact i d ref of this d2 biobank
	*/
	@Override
	public void setContactIDRef(java.lang.String contactIDRef) {
		_d2Biobank.setContactIDRef(contactIDRef);
	}

	/**
	* Returns the contact priority of this d2 biobank.
	*
	* @return the contact priority of this d2 biobank
	*/
	@Override
	public long getContactPriority() {
		return _d2Biobank.getContactPriority();
	}

	/**
	* Sets the contact priority of this d2 biobank.
	*
	* @param contactPriority the contact priority of this d2 biobank
	*/
	@Override
	public void setContactPriority(long contactPriority) {
		_d2Biobank.setContactPriority(contactPriority);
	}

	/**
	* Returns the bbmribiobank i d of this d2 biobank.
	*
	* @return the bbmribiobank i d of this d2 biobank
	*/
	@Override
	public java.lang.String getBbmribiobankID() {
		return _d2Biobank.getBbmribiobankID();
	}

	/**
	* Sets the bbmribiobank i d of this d2 biobank.
	*
	* @param bbmribiobankID the bbmribiobank i d of this d2 biobank
	*/
	@Override
	public void setBbmribiobankID(java.lang.String bbmribiobankID) {
		_d2Biobank.setBbmribiobankID(bbmribiobankID);
	}

	/**
	* Returns the biobank name of this d2 biobank.
	*
	* @return the biobank name of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankName() {
		return _d2Biobank.getBiobankName();
	}

	/**
	* Sets the biobank name of this d2 biobank.
	*
	* @param biobankName the biobank name of this d2 biobank
	*/
	@Override
	public void setBiobankName(java.lang.String biobankName) {
		_d2Biobank.setBiobankName(biobankName);
	}

	/**
	* Returns the biobank jurisdical person of this d2 biobank.
	*
	* @return the biobank jurisdical person of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankJurisdicalPerson() {
		return _d2Biobank.getBiobankJurisdicalPerson();
	}

	/**
	* Sets the biobank jurisdical person of this d2 biobank.
	*
	* @param biobankJurisdicalPerson the biobank jurisdical person of this d2 biobank
	*/
	@Override
	public void setBiobankJurisdicalPerson(
		java.lang.String biobankJurisdicalPerson) {
		_d2Biobank.setBiobankJurisdicalPerson(biobankJurisdicalPerson);
	}

	/**
	* Returns the biobank country of this d2 biobank.
	*
	* @return the biobank country of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankCountry() {
		return _d2Biobank.getBiobankCountry();
	}

	/**
	* Sets the biobank country of this d2 biobank.
	*
	* @param biobankCountry the biobank country of this d2 biobank
	*/
	@Override
	public void setBiobankCountry(java.lang.String biobankCountry) {
		_d2Biobank.setBiobankCountry(biobankCountry);
	}

	/**
	* Returns the biobank partner charter signed of this d2 biobank.
	*
	* @return the biobank partner charter signed of this d2 biobank
	*/
	@Override
	public boolean getBiobankPartnerCharterSigned() {
		return _d2Biobank.getBiobankPartnerCharterSigned();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank partner charter signed.
	*
	* @return <code>true</code> if this d2 biobank is biobank partner charter signed; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankPartnerCharterSigned() {
		return _d2Biobank.isBiobankPartnerCharterSigned();
	}

	/**
	* Sets whether this d2 biobank is biobank partner charter signed.
	*
	* @param biobankPartnerCharterSigned the biobank partner charter signed of this d2 biobank
	*/
	@Override
	public void setBiobankPartnerCharterSigned(
		boolean biobankPartnerCharterSigned) {
		_d2Biobank.setBiobankPartnerCharterSigned(biobankPartnerCharterSigned);
	}

	/**
	* Returns the bioresource reference of this d2 biobank.
	*
	* @return the bioresource reference of this d2 biobank
	*/
	@Override
	public java.lang.String getBioresourceReference() {
		return _d2Biobank.getBioresourceReference();
	}

	/**
	* Sets the bioresource reference of this d2 biobank.
	*
	* @param bioresourceReference the bioresource reference of this d2 biobank
	*/
	@Override
	public void setBioresourceReference(java.lang.String bioresourceReference) {
		_d2Biobank.setBioresourceReference(bioresourceReference);
	}

	/**
	* Returns the biobank network i d ref of this d2 biobank.
	*
	* @return the biobank network i d ref of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankNetworkIDRef() {
		return _d2Biobank.getBiobankNetworkIDRef();
	}

	/**
	* Sets the biobank network i d ref of this d2 biobank.
	*
	* @param biobankNetworkIDRef the biobank network i d ref of this d2 biobank
	*/
	@Override
	public void setBiobankNetworkIDRef(java.lang.String biobankNetworkIDRef) {
		_d2Biobank.setBiobankNetworkIDRef(biobankNetworkIDRef);
	}

	/**
	* Returns the geo latitude of this d2 biobank.
	*
	* @return the geo latitude of this d2 biobank
	*/
	@Override
	public java.lang.String getGeoLatitude() {
		return _d2Biobank.getGeoLatitude();
	}

	/**
	* Sets the geo latitude of this d2 biobank.
	*
	* @param geoLatitude the geo latitude of this d2 biobank
	*/
	@Override
	public void setGeoLatitude(java.lang.String geoLatitude) {
		_d2Biobank.setGeoLatitude(geoLatitude);
	}

	/**
	* Returns the geo longitude of this d2 biobank.
	*
	* @return the geo longitude of this d2 biobank
	*/
	@Override
	public java.lang.String getGeoLongitude() {
		return _d2Biobank.getGeoLongitude();
	}

	/**
	* Sets the geo longitude of this d2 biobank.
	*
	* @param geoLongitude the geo longitude of this d2 biobank
	*/
	@Override
	public void setGeoLongitude(java.lang.String geoLongitude) {
		_d2Biobank.setGeoLongitude(geoLongitude);
	}

	/**
	* Returns the collaboration partners commercial of this d2 biobank.
	*
	* @return the collaboration partners commercial of this d2 biobank
	*/
	@Override
	public boolean getCollaborationPartnersCommercial() {
		return _d2Biobank.getCollaborationPartnersCommercial();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is collaboration partners commercial.
	*
	* @return <code>true</code> if this d2 biobank is collaboration partners commercial; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollaborationPartnersCommercial() {
		return _d2Biobank.isCollaborationPartnersCommercial();
	}

	/**
	* Sets whether this d2 biobank is collaboration partners commercial.
	*
	* @param collaborationPartnersCommercial the collaboration partners commercial of this d2 biobank
	*/
	@Override
	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_d2Biobank.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
	}

	/**
	* Returns the collaboration partners nonforprofit of this d2 biobank.
	*
	* @return the collaboration partners nonforprofit of this d2 biobank
	*/
	@Override
	public boolean getCollaborationPartnersNonforprofit() {
		return _d2Biobank.getCollaborationPartnersNonforprofit();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is collaboration partners nonforprofit.
	*
	* @return <code>true</code> if this d2 biobank is collaboration partners nonforprofit; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollaborationPartnersNonforprofit() {
		return _d2Biobank.isCollaborationPartnersNonforprofit();
	}

	/**
	* Sets whether this d2 biobank is collaboration partners nonforprofit.
	*
	* @param collaborationPartnersNonforprofit the collaboration partners nonforprofit of this d2 biobank
	*/
	@Override
	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_d2Biobank.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
	}

	/**
	* Returns the biobank i t support available of this d2 biobank.
	*
	* @return the biobank i t support available of this d2 biobank
	*/
	@Override
	public boolean getBiobankITSupportAvailable() {
		return _d2Biobank.getBiobankITSupportAvailable();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank i t support available.
	*
	* @return <code>true</code> if this d2 biobank is biobank i t support available; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankITSupportAvailable() {
		return _d2Biobank.isBiobankITSupportAvailable();
	}

	/**
	* Sets whether this d2 biobank is biobank i t support available.
	*
	* @param biobankITSupportAvailable the biobank i t support available of this d2 biobank
	*/
	@Override
	public void setBiobankITSupportAvailable(boolean biobankITSupportAvailable) {
		_d2Biobank.setBiobankITSupportAvailable(biobankITSupportAvailable);
	}

	/**
	* Returns the biobank i t staff size of this d2 biobank.
	*
	* @return the biobank i t staff size of this d2 biobank
	*/
	@Override
	public long getBiobankITStaffSize() {
		return _d2Biobank.getBiobankITStaffSize();
	}

	/**
	* Sets the biobank i t staff size of this d2 biobank.
	*
	* @param biobankITStaffSize the biobank i t staff size of this d2 biobank
	*/
	@Override
	public void setBiobankITStaffSize(long biobankITStaffSize) {
		_d2Biobank.setBiobankITStaffSize(biobankITStaffSize);
	}

	/**
	* Returns the biobank i s available of this d2 biobank.
	*
	* @return the biobank i s available of this d2 biobank
	*/
	@Override
	public boolean getBiobankISAvailable() {
		return _d2Biobank.getBiobankISAvailable();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank i s available.
	*
	* @return <code>true</code> if this d2 biobank is biobank i s available; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankISAvailable() {
		return _d2Biobank.isBiobankISAvailable();
	}

	/**
	* Sets whether this d2 biobank is biobank i s available.
	*
	* @param biobankISAvailable the biobank i s available of this d2 biobank
	*/
	@Override
	public void setBiobankISAvailable(boolean biobankISAvailable) {
		_d2Biobank.setBiobankISAvailable(biobankISAvailable);
	}

	/**
	* Returns the biobank h i s available of this d2 biobank.
	*
	* @return the biobank h i s available of this d2 biobank
	*/
	@Override
	public boolean getBiobankHISAvailable() {
		return _d2Biobank.getBiobankHISAvailable();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank h i s available.
	*
	* @return <code>true</code> if this d2 biobank is biobank h i s available; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankHISAvailable() {
		return _d2Biobank.isBiobankHISAvailable();
	}

	/**
	* Sets whether this d2 biobank is biobank h i s available.
	*
	* @param biobankHISAvailable the biobank h i s available of this d2 biobank
	*/
	@Override
	public void setBiobankHISAvailable(boolean biobankHISAvailable) {
		_d2Biobank.setBiobankHISAvailable(biobankHISAvailable);
	}

	/**
	* Returns the biobank acronym of this d2 biobank.
	*
	* @return the biobank acronym of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankAcronym() {
		return _d2Biobank.getBiobankAcronym();
	}

	/**
	* Sets the biobank acronym of this d2 biobank.
	*
	* @param biobankAcronym the biobank acronym of this d2 biobank
	*/
	@Override
	public void setBiobankAcronym(java.lang.String biobankAcronym) {
		_d2Biobank.setBiobankAcronym(biobankAcronym);
	}

	/**
	* Returns the biobank description of this d2 biobank.
	*
	* @return the biobank description of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankDescription() {
		return _d2Biobank.getBiobankDescription();
	}

	/**
	* Sets the biobank description of this d2 biobank.
	*
	* @param biobankDescription the biobank description of this d2 biobank
	*/
	@Override
	public void setBiobankDescription(java.lang.String biobankDescription) {
		_d2Biobank.setBiobankDescription(biobankDescription);
	}

	/**
	* Returns the biobank u r l of this d2 biobank.
	*
	* @return the biobank u r l of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankURL() {
		return _d2Biobank.getBiobankURL();
	}

	/**
	* Sets the biobank u r l of this d2 biobank.
	*
	* @param biobankURL the biobank u r l of this d2 biobank
	*/
	@Override
	public void setBiobankURL(java.lang.String biobankURL) {
		_d2Biobank.setBiobankURL(biobankURL);
	}

	/**
	* Returns the biobank head first name of this d2 biobank.
	*
	* @return the biobank head first name of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankHeadFirstName() {
		return _d2Biobank.getBiobankHeadFirstName();
	}

	/**
	* Sets the biobank head first name of this d2 biobank.
	*
	* @param biobankHeadFirstName the biobank head first name of this d2 biobank
	*/
	@Override
	public void setBiobankHeadFirstName(java.lang.String biobankHeadFirstName) {
		_d2Biobank.setBiobankHeadFirstName(biobankHeadFirstName);
	}

	/**
	* Returns the biobank head last name of this d2 biobank.
	*
	* @return the biobank head last name of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankHeadLastName() {
		return _d2Biobank.getBiobankHeadLastName();
	}

	/**
	* Sets the biobank head last name of this d2 biobank.
	*
	* @param biobankHeadLastName the biobank head last name of this d2 biobank
	*/
	@Override
	public void setBiobankHeadLastName(java.lang.String biobankHeadLastName) {
		_d2Biobank.setBiobankHeadLastName(biobankHeadLastName);
	}

	/**
	* Returns the biobank head role of this d2 biobank.
	*
	* @return the biobank head role of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankHeadRole() {
		return _d2Biobank.getBiobankHeadRole();
	}

	/**
	* Sets the biobank head role of this d2 biobank.
	*
	* @param biobankHeadRole the biobank head role of this d2 biobank
	*/
	@Override
	public void setBiobankHeadRole(java.lang.String biobankHeadRole) {
		_d2Biobank.setBiobankHeadRole(biobankHeadRole);
	}

	/**
	* Returns the biobank clinical of this d2 biobank.
	*
	* @return the biobank clinical of this d2 biobank
	*/
	@Override
	public boolean getBiobankClinical() {
		return _d2Biobank.getBiobankClinical();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank clinical.
	*
	* @return <code>true</code> if this d2 biobank is biobank clinical; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankClinical() {
		return _d2Biobank.isBiobankClinical();
	}

	/**
	* Sets whether this d2 biobank is biobank clinical.
	*
	* @param biobankClinical the biobank clinical of this d2 biobank
	*/
	@Override
	public void setBiobankClinical(boolean biobankClinical) {
		_d2Biobank.setBiobankClinical(biobankClinical);
	}

	/**
	* Returns the biobank population of this d2 biobank.
	*
	* @return the biobank population of this d2 biobank
	*/
	@Override
	public boolean getBiobankPopulation() {
		return _d2Biobank.getBiobankPopulation();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank population.
	*
	* @return <code>true</code> if this d2 biobank is biobank population; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankPopulation() {
		return _d2Biobank.isBiobankPopulation();
	}

	/**
	* Sets whether this d2 biobank is biobank population.
	*
	* @param biobankPopulation the biobank population of this d2 biobank
	*/
	@Override
	public void setBiobankPopulation(boolean biobankPopulation) {
		_d2Biobank.setBiobankPopulation(biobankPopulation);
	}

	/**
	* Returns the biobank research study of this d2 biobank.
	*
	* @return the biobank research study of this d2 biobank
	*/
	@Override
	public boolean getBiobankResearchStudy() {
		return _d2Biobank.getBiobankResearchStudy();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank research study.
	*
	* @return <code>true</code> if this d2 biobank is biobank research study; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankResearchStudy() {
		return _d2Biobank.isBiobankResearchStudy();
	}

	/**
	* Sets whether this d2 biobank is biobank research study.
	*
	* @param biobankResearchStudy the biobank research study of this d2 biobank
	*/
	@Override
	public void setBiobankResearchStudy(boolean biobankResearchStudy) {
		_d2Biobank.setBiobankResearchStudy(biobankResearchStudy);
	}

	/**
	* Returns the biobank non human of this d2 biobank.
	*
	* @return the biobank non human of this d2 biobank
	*/
	@Override
	public boolean getBiobankNonHuman() {
		return _d2Biobank.getBiobankNonHuman();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank non human.
	*
	* @return <code>true</code> if this d2 biobank is biobank non human; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNonHuman() {
		return _d2Biobank.isBiobankNonHuman();
	}

	/**
	* Sets whether this d2 biobank is biobank non human.
	*
	* @param biobankNonHuman the biobank non human of this d2 biobank
	*/
	@Override
	public void setBiobankNonHuman(boolean biobankNonHuman) {
		_d2Biobank.setBiobankNonHuman(biobankNonHuman);
	}

	/**
	* Returns the biobank collection of this d2 biobank.
	*
	* @return the biobank collection of this d2 biobank
	*/
	@Override
	public boolean getBiobankCollection() {
		return _d2Biobank.getBiobankCollection();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is biobank collection.
	*
	* @return <code>true</code> if this d2 biobank is biobank collection; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankCollection() {
		return _d2Biobank.isBiobankCollection();
	}

	/**
	* Sets whether this d2 biobank is biobank collection.
	*
	* @param biobankCollection the biobank collection of this d2 biobank
	*/
	@Override
	public void setBiobankCollection(boolean biobankCollection) {
		_d2Biobank.setBiobankCollection(biobankCollection);
	}

	/**
	* Returns the biobank type of this d2 biobank.
	*
	* @return the biobank type of this d2 biobank
	*/
	@Override
	public java.lang.String getBiobankType() {
		return _d2Biobank.getBiobankType();
	}

	/**
	* Sets the biobank type of this d2 biobank.
	*
	* @param biobankType the biobank type of this d2 biobank
	*/
	@Override
	public void setBiobankType(java.lang.String biobankType) {
		_d2Biobank.setBiobankType(biobankType);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _d2Biobank.getApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is approved.
	*
	* @return <code>true</code> if this d2 biobank is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _d2Biobank.isApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is denied.
	*
	* @return <code>true</code> if this d2 biobank is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _d2Biobank.isDenied();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is a draft.
	*
	* @return <code>true</code> if this d2 biobank is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _d2Biobank.isDraft();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is expired.
	*
	* @return <code>true</code> if this d2 biobank is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _d2Biobank.isExpired();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is inactive.
	*
	* @return <code>true</code> if this d2 biobank is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _d2Biobank.isInactive();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is incomplete.
	*
	* @return <code>true</code> if this d2 biobank is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _d2Biobank.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is pending.
	*
	* @return <code>true</code> if this d2 biobank is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _d2Biobank.isPending();
	}

	/**
	* Returns <code>true</code> if this d2 biobank is scheduled.
	*
	* @return <code>true</code> if this d2 biobank is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _d2Biobank.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _d2Biobank.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_d2Biobank.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _d2Biobank.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_d2Biobank.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _d2Biobank.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _d2Biobank.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_d2Biobank.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _d2Biobank.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_d2Biobank.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_d2Biobank.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_d2Biobank.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new D2BiobankWrapper((D2Biobank)_d2Biobank.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.D2Biobank d2Biobank) {
		return _d2Biobank.compareTo(d2Biobank);
	}

	@Override
	public int hashCode() {
		return _d2Biobank.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> toCacheModel() {
		return _d2Biobank.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Biobank toEscapedModel() {
		return new D2BiobankWrapper(_d2Biobank.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Biobank toUnescapedModel() {
		return new D2BiobankWrapper(_d2Biobank.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _d2Biobank.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _d2Biobank.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_d2Biobank.persist();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation() {
		return _d2Biobank.getContactInformation();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getCollections() {
		return _d2Biobank.getCollections();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getRootCollections() {
		return _d2Biobank.getRootCollections();
	}

	@Override
	public int getCollectionsCount() {
		return _d2Biobank.getCollectionsCount();
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getBiobankJavascriptTable() {
		return _d2Biobank.getBiobankJavascriptTable();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getNetworksWhereBiobankIsMember() {
		return _d2Biobank.getNetworksWhereBiobankIsMember();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2BiobankWrapper)) {
			return false;
		}

		D2BiobankWrapper d2BiobankWrapper = (D2BiobankWrapper)obj;

		if (Validator.equals(_d2Biobank, d2BiobankWrapper._d2Biobank)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _d2Biobank.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public D2Biobank getWrappedD2Biobank() {
		return _d2Biobank;
	}

	@Override
	public D2Biobank getWrappedModel() {
		return _d2Biobank;
	}

	@Override
	public void resetOriginalValues() {
		_d2Biobank.resetOriginalValues();
	}

	private D2Biobank _d2Biobank;
}