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
 * This class is a wrapper for {@link D2BiobankNetwork}.
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetwork
 * @generated
 */
public class D2BiobankNetworkWrapper implements D2BiobankNetwork,
	ModelWrapper<D2BiobankNetwork> {
	public D2BiobankNetworkWrapper(D2BiobankNetwork d2BiobankNetwork) {
		_d2BiobankNetwork = d2BiobankNetwork;
	}

	@Override
	public Class<?> getModelClass() {
		return D2BiobankNetwork.class;
	}

	@Override
	public String getModelClassName() {
		return D2BiobankNetwork.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("d2biobanknetworkId", getD2biobanknetworkId());
		attributes.put("parentd2biobanknetworkId", getParentd2biobanknetworkId());
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
		attributes.put("bbmriBiobankNetworkID", getBbmriBiobankNetworkID());
		attributes.put("biobankNetworkName", getBiobankNetworkName());
		attributes.put("biobankNetworkCommonCollectionFocus",
			getBiobankNetworkCommonCollectionFocus());
		attributes.put("biobankNetworkCommonCharter",
			getBiobankNetworkCommonCharter());
		attributes.put("biobankNetworkCommonSOPs", getBiobankNetworkCommonSOPs());
		attributes.put("biobankNetworkCommonDataAccessPolicy",
			getBiobankNetworkCommonDataAccessPolicy());
		attributes.put("biobankNetworkCommonSampleAccessPolicy",
			getBiobankNetworkCommonSampleAccessPolicy());
		attributes.put("biobankNetworkCommonMTA", getBiobankNetworkCommonMTA());
		attributes.put("biobankNetworkCommonRepresentation",
			getBiobankNetworkCommonRepresentation());
		attributes.put("biobankNetworkCommonURL", getBiobankNetworkCommonURL());
		attributes.put("biobankNetworkIDRef", getBiobankNetworkIDRef());
		attributes.put("geoLatitude", getGeoLatitude());
		attributes.put("geoLongitude", getGeoLongitude());
		attributes.put("biobankNetworkAcronym", getBiobankNetworkAcronym());
		attributes.put("biobankNetworkDescription",
			getBiobankNetworkDescription());
		attributes.put("biobankNetworkURL", getBiobankNetworkURL());
		attributes.put("biobankNetworkJuridicalPerson",
			getBiobankNetworkJuridicalPerson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long d2biobanknetworkId = (Long)attributes.get("d2biobanknetworkId");

		if (d2biobanknetworkId != null) {
			setD2biobanknetworkId(d2biobanknetworkId);
		}

		Long parentd2biobanknetworkId = (Long)attributes.get(
				"parentd2biobanknetworkId");

		if (parentd2biobanknetworkId != null) {
			setParentd2biobanknetworkId(parentd2biobanknetworkId);
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

		String bbmriBiobankNetworkID = (String)attributes.get(
				"bbmriBiobankNetworkID");

		if (bbmriBiobankNetworkID != null) {
			setBbmriBiobankNetworkID(bbmriBiobankNetworkID);
		}

		String biobankNetworkName = (String)attributes.get("biobankNetworkName");

		if (biobankNetworkName != null) {
			setBiobankNetworkName(biobankNetworkName);
		}

		Boolean biobankNetworkCommonCollectionFocus = (Boolean)attributes.get(
				"biobankNetworkCommonCollectionFocus");

		if (biobankNetworkCommonCollectionFocus != null) {
			setBiobankNetworkCommonCollectionFocus(biobankNetworkCommonCollectionFocus);
		}

		Boolean biobankNetworkCommonCharter = (Boolean)attributes.get(
				"biobankNetworkCommonCharter");

		if (biobankNetworkCommonCharter != null) {
			setBiobankNetworkCommonCharter(biobankNetworkCommonCharter);
		}

		Boolean biobankNetworkCommonSOPs = (Boolean)attributes.get(
				"biobankNetworkCommonSOPs");

		if (biobankNetworkCommonSOPs != null) {
			setBiobankNetworkCommonSOPs(biobankNetworkCommonSOPs);
		}

		Boolean biobankNetworkCommonDataAccessPolicy = (Boolean)attributes.get(
				"biobankNetworkCommonDataAccessPolicy");

		if (biobankNetworkCommonDataAccessPolicy != null) {
			setBiobankNetworkCommonDataAccessPolicy(biobankNetworkCommonDataAccessPolicy);
		}

		Boolean biobankNetworkCommonSampleAccessPolicy = (Boolean)attributes.get(
				"biobankNetworkCommonSampleAccessPolicy");

		if (biobankNetworkCommonSampleAccessPolicy != null) {
			setBiobankNetworkCommonSampleAccessPolicy(biobankNetworkCommonSampleAccessPolicy);
		}

		Boolean biobankNetworkCommonMTA = (Boolean)attributes.get(
				"biobankNetworkCommonMTA");

		if (biobankNetworkCommonMTA != null) {
			setBiobankNetworkCommonMTA(biobankNetworkCommonMTA);
		}

		Boolean biobankNetworkCommonRepresentation = (Boolean)attributes.get(
				"biobankNetworkCommonRepresentation");

		if (biobankNetworkCommonRepresentation != null) {
			setBiobankNetworkCommonRepresentation(biobankNetworkCommonRepresentation);
		}

		Boolean biobankNetworkCommonURL = (Boolean)attributes.get(
				"biobankNetworkCommonURL");

		if (biobankNetworkCommonURL != null) {
			setBiobankNetworkCommonURL(biobankNetworkCommonURL);
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

		String biobankNetworkAcronym = (String)attributes.get(
				"biobankNetworkAcronym");

		if (biobankNetworkAcronym != null) {
			setBiobankNetworkAcronym(biobankNetworkAcronym);
		}

		String biobankNetworkDescription = (String)attributes.get(
				"biobankNetworkDescription");

		if (biobankNetworkDescription != null) {
			setBiobankNetworkDescription(biobankNetworkDescription);
		}

		String biobankNetworkURL = (String)attributes.get("biobankNetworkURL");

		if (biobankNetworkURL != null) {
			setBiobankNetworkURL(biobankNetworkURL);
		}

		String biobankNetworkJuridicalPerson = (String)attributes.get(
				"biobankNetworkJuridicalPerson");

		if (biobankNetworkJuridicalPerson != null) {
			setBiobankNetworkJuridicalPerson(biobankNetworkJuridicalPerson);
		}
	}

	/**
	* Returns the primary key of this d2 biobank network.
	*
	* @return the primary key of this d2 biobank network
	*/
	@Override
	public long getPrimaryKey() {
		return _d2BiobankNetwork.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d2 biobank network.
	*
	* @param primaryKey the primary key of this d2 biobank network
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_d2BiobankNetwork.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this d2 biobank network.
	*
	* @return the uuid of this d2 biobank network
	*/
	@Override
	public java.lang.String getUuid() {
		return _d2BiobankNetwork.getUuid();
	}

	/**
	* Sets the uuid of this d2 biobank network.
	*
	* @param uuid the uuid of this d2 biobank network
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_d2BiobankNetwork.setUuid(uuid);
	}

	/**
	* Returns the d2biobanknetwork ID of this d2 biobank network.
	*
	* @return the d2biobanknetwork ID of this d2 biobank network
	*/
	@Override
	public long getD2biobanknetworkId() {
		return _d2BiobankNetwork.getD2biobanknetworkId();
	}

	/**
	* Sets the d2biobanknetwork ID of this d2 biobank network.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID of this d2 biobank network
	*/
	@Override
	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		_d2BiobankNetwork.setD2biobanknetworkId(d2biobanknetworkId);
	}

	/**
	* Returns the parentd2biobanknetwork ID of this d2 biobank network.
	*
	* @return the parentd2biobanknetwork ID of this d2 biobank network
	*/
	@Override
	public long getParentd2biobanknetworkId() {
		return _d2BiobankNetwork.getParentd2biobanknetworkId();
	}

	/**
	* Sets the parentd2biobanknetwork ID of this d2 biobank network.
	*
	* @param parentd2biobanknetworkId the parentd2biobanknetwork ID of this d2 biobank network
	*/
	@Override
	public void setParentd2biobanknetworkId(long parentd2biobanknetworkId) {
		_d2BiobankNetwork.setParentd2biobanknetworkId(parentd2biobanknetworkId);
	}

	/**
	* Returns the status of this d2 biobank network.
	*
	* @return the status of this d2 biobank network
	*/
	@Override
	public int getStatus() {
		return _d2BiobankNetwork.getStatus();
	}

	/**
	* Sets the status of this d2 biobank network.
	*
	* @param status the status of this d2 biobank network
	*/
	@Override
	public void setStatus(int status) {
		_d2BiobankNetwork.setStatus(status);
	}

	/**
	* Returns the status by user ID of this d2 biobank network.
	*
	* @return the status by user ID of this d2 biobank network
	*/
	@Override
	public long getStatusByUserId() {
		return _d2BiobankNetwork.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this d2 biobank network.
	*
	* @param statusByUserId the status by user ID of this d2 biobank network
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_d2BiobankNetwork.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this d2 biobank network.
	*
	* @return the status by user uuid of this d2 biobank network
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2BiobankNetwork.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this d2 biobank network.
	*
	* @param statusByUserUuid the status by user uuid of this d2 biobank network
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_d2BiobankNetwork.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this d2 biobank network.
	*
	* @return the status by user name of this d2 biobank network
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _d2BiobankNetwork.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this d2 biobank network.
	*
	* @param statusByUserName the status by user name of this d2 biobank network
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_d2BiobankNetwork.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this d2 biobank network.
	*
	* @return the status date of this d2 biobank network
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _d2BiobankNetwork.getStatusDate();
	}

	/**
	* Sets the status date of this d2 biobank network.
	*
	* @param statusDate the status date of this d2 biobank network
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_d2BiobankNetwork.setStatusDate(statusDate);
	}

	/**
	* Returns the company ID of this d2 biobank network.
	*
	* @return the company ID of this d2 biobank network
	*/
	@Override
	public long getCompanyId() {
		return _d2BiobankNetwork.getCompanyId();
	}

	/**
	* Sets the company ID of this d2 biobank network.
	*
	* @param companyId the company ID of this d2 biobank network
	*/
	@Override
	public void setCompanyId(long companyId) {
		_d2BiobankNetwork.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this d2 biobank network.
	*
	* @return the group ID of this d2 biobank network
	*/
	@Override
	public long getGroupId() {
		return _d2BiobankNetwork.getGroupId();
	}

	/**
	* Sets the group ID of this d2 biobank network.
	*
	* @param groupId the group ID of this d2 biobank network
	*/
	@Override
	public void setGroupId(long groupId) {
		_d2BiobankNetwork.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this d2 biobank network.
	*
	* @return the user ID of this d2 biobank network
	*/
	@Override
	public long getUserId() {
		return _d2BiobankNetwork.getUserId();
	}

	/**
	* Sets the user ID of this d2 biobank network.
	*
	* @param userId the user ID of this d2 biobank network
	*/
	@Override
	public void setUserId(long userId) {
		_d2BiobankNetwork.setUserId(userId);
	}

	/**
	* Returns the user uuid of this d2 biobank network.
	*
	* @return the user uuid of this d2 biobank network
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2BiobankNetwork.getUserUuid();
	}

	/**
	* Sets the user uuid of this d2 biobank network.
	*
	* @param userUuid the user uuid of this d2 biobank network
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_d2BiobankNetwork.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this d2 biobank network.
	*
	* @return the user name of this d2 biobank network
	*/
	@Override
	public java.lang.String getUserName() {
		return _d2BiobankNetwork.getUserName();
	}

	/**
	* Sets the user name of this d2 biobank network.
	*
	* @param userName the user name of this d2 biobank network
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_d2BiobankNetwork.setUserName(userName);
	}

	/**
	* Returns the create date of this d2 biobank network.
	*
	* @return the create date of this d2 biobank network
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _d2BiobankNetwork.getCreateDate();
	}

	/**
	* Sets the create date of this d2 biobank network.
	*
	* @param createDate the create date of this d2 biobank network
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_d2BiobankNetwork.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this d2 biobank network.
	*
	* @return the modified date of this d2 biobank network
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _d2BiobankNetwork.getModifiedDate();
	}

	/**
	* Sets the modified date of this d2 biobank network.
	*
	* @param modifiedDate the modified date of this d2 biobank network
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_d2BiobankNetwork.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updateuuid of this d2 biobank network.
	*
	* @return the updateuuid of this d2 biobank network
	*/
	@Override
	public java.lang.String getUpdateuuid() {
		return _d2BiobankNetwork.getUpdateuuid();
	}

	/**
	* Sets the updateuuid of this d2 biobank network.
	*
	* @param updateuuid the updateuuid of this d2 biobank network
	*/
	@Override
	public void setUpdateuuid(java.lang.String updateuuid) {
		_d2BiobankNetwork.setUpdateuuid(updateuuid);
	}

	/**
	* Returns the contact i d ref of this d2 biobank network.
	*
	* @return the contact i d ref of this d2 biobank network
	*/
	@Override
	public java.lang.String getContactIDRef() {
		return _d2BiobankNetwork.getContactIDRef();
	}

	/**
	* Sets the contact i d ref of this d2 biobank network.
	*
	* @param contactIDRef the contact i d ref of this d2 biobank network
	*/
	@Override
	public void setContactIDRef(java.lang.String contactIDRef) {
		_d2BiobankNetwork.setContactIDRef(contactIDRef);
	}

	/**
	* Returns the contact priority of this d2 biobank network.
	*
	* @return the contact priority of this d2 biobank network
	*/
	@Override
	public long getContactPriority() {
		return _d2BiobankNetwork.getContactPriority();
	}

	/**
	* Sets the contact priority of this d2 biobank network.
	*
	* @param contactPriority the contact priority of this d2 biobank network
	*/
	@Override
	public void setContactPriority(long contactPriority) {
		_d2BiobankNetwork.setContactPriority(contactPriority);
	}

	/**
	* Returns the bbmri biobank network i d of this d2 biobank network.
	*
	* @return the bbmri biobank network i d of this d2 biobank network
	*/
	@Override
	public java.lang.String getBbmriBiobankNetworkID() {
		return _d2BiobankNetwork.getBbmriBiobankNetworkID();
	}

	/**
	* Sets the bbmri biobank network i d of this d2 biobank network.
	*
	* @param bbmriBiobankNetworkID the bbmri biobank network i d of this d2 biobank network
	*/
	@Override
	public void setBbmriBiobankNetworkID(java.lang.String bbmriBiobankNetworkID) {
		_d2BiobankNetwork.setBbmriBiobankNetworkID(bbmriBiobankNetworkID);
	}

	/**
	* Returns the biobank network name of this d2 biobank network.
	*
	* @return the biobank network name of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkName() {
		return _d2BiobankNetwork.getBiobankNetworkName();
	}

	/**
	* Sets the biobank network name of this d2 biobank network.
	*
	* @param biobankNetworkName the biobank network name of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkName(java.lang.String biobankNetworkName) {
		_d2BiobankNetwork.setBiobankNetworkName(biobankNetworkName);
	}

	/**
	* Returns the biobank network common collection focus of this d2 biobank network.
	*
	* @return the biobank network common collection focus of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonCollectionFocus() {
		return _d2BiobankNetwork.getBiobankNetworkCommonCollectionFocus();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common collection focus.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common collection focus; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonCollectionFocus() {
		return _d2BiobankNetwork.isBiobankNetworkCommonCollectionFocus();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common collection focus.
	*
	* @param biobankNetworkCommonCollectionFocus the biobank network common collection focus of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonCollectionFocus(
		boolean biobankNetworkCommonCollectionFocus) {
		_d2BiobankNetwork.setBiobankNetworkCommonCollectionFocus(biobankNetworkCommonCollectionFocus);
	}

	/**
	* Returns the biobank network common charter of this d2 biobank network.
	*
	* @return the biobank network common charter of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonCharter() {
		return _d2BiobankNetwork.getBiobankNetworkCommonCharter();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common charter.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common charter; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonCharter() {
		return _d2BiobankNetwork.isBiobankNetworkCommonCharter();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common charter.
	*
	* @param biobankNetworkCommonCharter the biobank network common charter of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonCharter(
		boolean biobankNetworkCommonCharter) {
		_d2BiobankNetwork.setBiobankNetworkCommonCharter(biobankNetworkCommonCharter);
	}

	/**
	* Returns the biobank network common s o ps of this d2 biobank network.
	*
	* @return the biobank network common s o ps of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonSOPs() {
		return _d2BiobankNetwork.getBiobankNetworkCommonSOPs();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common s o ps.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common s o ps; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonSOPs() {
		return _d2BiobankNetwork.isBiobankNetworkCommonSOPs();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common s o ps.
	*
	* @param biobankNetworkCommonSOPs the biobank network common s o ps of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonSOPs(boolean biobankNetworkCommonSOPs) {
		_d2BiobankNetwork.setBiobankNetworkCommonSOPs(biobankNetworkCommonSOPs);
	}

	/**
	* Returns the biobank network common data access policy of this d2 biobank network.
	*
	* @return the biobank network common data access policy of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonDataAccessPolicy() {
		return _d2BiobankNetwork.getBiobankNetworkCommonDataAccessPolicy();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common data access policy.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common data access policy; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonDataAccessPolicy() {
		return _d2BiobankNetwork.isBiobankNetworkCommonDataAccessPolicy();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common data access policy.
	*
	* @param biobankNetworkCommonDataAccessPolicy the biobank network common data access policy of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonDataAccessPolicy(
		boolean biobankNetworkCommonDataAccessPolicy) {
		_d2BiobankNetwork.setBiobankNetworkCommonDataAccessPolicy(biobankNetworkCommonDataAccessPolicy);
	}

	/**
	* Returns the biobank network common sample access policy of this d2 biobank network.
	*
	* @return the biobank network common sample access policy of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonSampleAccessPolicy() {
		return _d2BiobankNetwork.getBiobankNetworkCommonSampleAccessPolicy();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common sample access policy.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common sample access policy; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonSampleAccessPolicy() {
		return _d2BiobankNetwork.isBiobankNetworkCommonSampleAccessPolicy();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common sample access policy.
	*
	* @param biobankNetworkCommonSampleAccessPolicy the biobank network common sample access policy of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonSampleAccessPolicy(
		boolean biobankNetworkCommonSampleAccessPolicy) {
		_d2BiobankNetwork.setBiobankNetworkCommonSampleAccessPolicy(biobankNetworkCommonSampleAccessPolicy);
	}

	/**
	* Returns the biobank network common m t a of this d2 biobank network.
	*
	* @return the biobank network common m t a of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonMTA() {
		return _d2BiobankNetwork.getBiobankNetworkCommonMTA();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common m t a.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common m t a; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonMTA() {
		return _d2BiobankNetwork.isBiobankNetworkCommonMTA();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common m t a.
	*
	* @param biobankNetworkCommonMTA the biobank network common m t a of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonMTA(boolean biobankNetworkCommonMTA) {
		_d2BiobankNetwork.setBiobankNetworkCommonMTA(biobankNetworkCommonMTA);
	}

	/**
	* Returns the biobank network common representation of this d2 biobank network.
	*
	* @return the biobank network common representation of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonRepresentation() {
		return _d2BiobankNetwork.getBiobankNetworkCommonRepresentation();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common representation.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common representation; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonRepresentation() {
		return _d2BiobankNetwork.isBiobankNetworkCommonRepresentation();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common representation.
	*
	* @param biobankNetworkCommonRepresentation the biobank network common representation of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonRepresentation(
		boolean biobankNetworkCommonRepresentation) {
		_d2BiobankNetwork.setBiobankNetworkCommonRepresentation(biobankNetworkCommonRepresentation);
	}

	/**
	* Returns the biobank network common u r l of this d2 biobank network.
	*
	* @return the biobank network common u r l of this d2 biobank network
	*/
	@Override
	public boolean getBiobankNetworkCommonURL() {
		return _d2BiobankNetwork.getBiobankNetworkCommonURL();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is biobank network common u r l.
	*
	* @return <code>true</code> if this d2 biobank network is biobank network common u r l; <code>false</code> otherwise
	*/
	@Override
	public boolean isBiobankNetworkCommonURL() {
		return _d2BiobankNetwork.isBiobankNetworkCommonURL();
	}

	/**
	* Sets whether this d2 biobank network is biobank network common u r l.
	*
	* @param biobankNetworkCommonURL the biobank network common u r l of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkCommonURL(boolean biobankNetworkCommonURL) {
		_d2BiobankNetwork.setBiobankNetworkCommonURL(biobankNetworkCommonURL);
	}

	/**
	* Returns the biobank network i d ref of this d2 biobank network.
	*
	* @return the biobank network i d ref of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkIDRef() {
		return _d2BiobankNetwork.getBiobankNetworkIDRef();
	}

	/**
	* Sets the biobank network i d ref of this d2 biobank network.
	*
	* @param biobankNetworkIDRef the biobank network i d ref of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkIDRef(java.lang.String biobankNetworkIDRef) {
		_d2BiobankNetwork.setBiobankNetworkIDRef(biobankNetworkIDRef);
	}

	/**
	* Returns the geo latitude of this d2 biobank network.
	*
	* @return the geo latitude of this d2 biobank network
	*/
	@Override
	public java.lang.String getGeoLatitude() {
		return _d2BiobankNetwork.getGeoLatitude();
	}

	/**
	* Sets the geo latitude of this d2 biobank network.
	*
	* @param geoLatitude the geo latitude of this d2 biobank network
	*/
	@Override
	public void setGeoLatitude(java.lang.String geoLatitude) {
		_d2BiobankNetwork.setGeoLatitude(geoLatitude);
	}

	/**
	* Returns the geo longitude of this d2 biobank network.
	*
	* @return the geo longitude of this d2 biobank network
	*/
	@Override
	public java.lang.String getGeoLongitude() {
		return _d2BiobankNetwork.getGeoLongitude();
	}

	/**
	* Sets the geo longitude of this d2 biobank network.
	*
	* @param geoLongitude the geo longitude of this d2 biobank network
	*/
	@Override
	public void setGeoLongitude(java.lang.String geoLongitude) {
		_d2BiobankNetwork.setGeoLongitude(geoLongitude);
	}

	/**
	* Returns the biobank network acronym of this d2 biobank network.
	*
	* @return the biobank network acronym of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkAcronym() {
		return _d2BiobankNetwork.getBiobankNetworkAcronym();
	}

	/**
	* Sets the biobank network acronym of this d2 biobank network.
	*
	* @param biobankNetworkAcronym the biobank network acronym of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkAcronym(java.lang.String biobankNetworkAcronym) {
		_d2BiobankNetwork.setBiobankNetworkAcronym(biobankNetworkAcronym);
	}

	/**
	* Returns the biobank network description of this d2 biobank network.
	*
	* @return the biobank network description of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkDescription() {
		return _d2BiobankNetwork.getBiobankNetworkDescription();
	}

	/**
	* Sets the biobank network description of this d2 biobank network.
	*
	* @param biobankNetworkDescription the biobank network description of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkDescription(
		java.lang.String biobankNetworkDescription) {
		_d2BiobankNetwork.setBiobankNetworkDescription(biobankNetworkDescription);
	}

	/**
	* Returns the biobank network u r l of this d2 biobank network.
	*
	* @return the biobank network u r l of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkURL() {
		return _d2BiobankNetwork.getBiobankNetworkURL();
	}

	/**
	* Sets the biobank network u r l of this d2 biobank network.
	*
	* @param biobankNetworkURL the biobank network u r l of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkURL(java.lang.String biobankNetworkURL) {
		_d2BiobankNetwork.setBiobankNetworkURL(biobankNetworkURL);
	}

	/**
	* Returns the biobank network juridical person of this d2 biobank network.
	*
	* @return the biobank network juridical person of this d2 biobank network
	*/
	@Override
	public java.lang.String getBiobankNetworkJuridicalPerson() {
		return _d2BiobankNetwork.getBiobankNetworkJuridicalPerson();
	}

	/**
	* Sets the biobank network juridical person of this d2 biobank network.
	*
	* @param biobankNetworkJuridicalPerson the biobank network juridical person of this d2 biobank network
	*/
	@Override
	public void setBiobankNetworkJuridicalPerson(
		java.lang.String biobankNetworkJuridicalPerson) {
		_d2BiobankNetwork.setBiobankNetworkJuridicalPerson(biobankNetworkJuridicalPerson);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _d2BiobankNetwork.getApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is approved.
	*
	* @return <code>true</code> if this d2 biobank network is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _d2BiobankNetwork.isApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is denied.
	*
	* @return <code>true</code> if this d2 biobank network is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _d2BiobankNetwork.isDenied();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is a draft.
	*
	* @return <code>true</code> if this d2 biobank network is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _d2BiobankNetwork.isDraft();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is expired.
	*
	* @return <code>true</code> if this d2 biobank network is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _d2BiobankNetwork.isExpired();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is inactive.
	*
	* @return <code>true</code> if this d2 biobank network is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _d2BiobankNetwork.isInactive();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is incomplete.
	*
	* @return <code>true</code> if this d2 biobank network is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _d2BiobankNetwork.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is pending.
	*
	* @return <code>true</code> if this d2 biobank network is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _d2BiobankNetwork.isPending();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network is scheduled.
	*
	* @return <code>true</code> if this d2 biobank network is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _d2BiobankNetwork.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _d2BiobankNetwork.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_d2BiobankNetwork.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _d2BiobankNetwork.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_d2BiobankNetwork.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _d2BiobankNetwork.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _d2BiobankNetwork.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_d2BiobankNetwork.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _d2BiobankNetwork.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_d2BiobankNetwork.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_d2BiobankNetwork.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_d2BiobankNetwork.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new D2BiobankNetworkWrapper((D2BiobankNetwork)_d2BiobankNetwork.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork d2BiobankNetwork) {
		return _d2BiobankNetwork.compareTo(d2BiobankNetwork);
	}

	@Override
	public int hashCode() {
		return _d2BiobankNetwork.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> toCacheModel() {
		return _d2BiobankNetwork.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork toEscapedModel() {
		return new D2BiobankNetworkWrapper(_d2BiobankNetwork.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork toUnescapedModel() {
		return new D2BiobankNetworkWrapper(_d2BiobankNetwork.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _d2BiobankNetwork.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _d2BiobankNetwork.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_d2BiobankNetwork.persist();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation() {
		return _d2BiobankNetwork.getContactInformation();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getAssosiatedNetworks() {
		return _d2BiobankNetwork.getAssosiatedNetworks();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getAssosiatedBiobanks() {
		return _d2BiobankNetwork.getAssosiatedBiobanks();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getAssosiatedCollections() {
		return _d2BiobankNetwork.getAssosiatedCollections();
	}

	/**
	* @return
	*/
	@Override
	public java.lang.String getBiobankNetworkJavascriptTable() {
		return _d2BiobankNetwork.getBiobankNetworkJavascriptTable();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2BiobankNetworkWrapper)) {
			return false;
		}

		D2BiobankNetworkWrapper d2BiobankNetworkWrapper = (D2BiobankNetworkWrapper)obj;

		if (Validator.equals(_d2BiobankNetwork,
					d2BiobankNetworkWrapper._d2BiobankNetwork)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _d2BiobankNetwork.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public D2BiobankNetwork getWrappedD2BiobankNetwork() {
		return _d2BiobankNetwork;
	}

	@Override
	public D2BiobankNetwork getWrappedModel() {
		return _d2BiobankNetwork;
	}

	@Override
	public void resetOriginalValues() {
		_d2BiobankNetwork.resetOriginalValues();
	}

	private D2BiobankNetwork _d2BiobankNetwork;
}