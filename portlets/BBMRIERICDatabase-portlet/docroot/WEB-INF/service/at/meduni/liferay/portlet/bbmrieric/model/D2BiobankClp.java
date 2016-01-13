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

import at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class D2BiobankClp extends BaseModelImpl<D2Biobank> implements D2Biobank {
	public D2BiobankClp() {
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
	public long getPrimaryKey() {
		return _biobankId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_d2BiobankRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiobankId() {
		return _biobankId;
	}

	@Override
	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankId", long.class);

				method.invoke(_d2BiobankRemoteModel, biobankId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_d2BiobankRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_d2BiobankRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_d2BiobankRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_d2BiobankRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_d2BiobankRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_d2BiobankRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_d2BiobankRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_d2BiobankRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_d2BiobankRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_d2BiobankRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdateuuid() {
		return _updateuuid;
	}

	@Override
	public void setUpdateuuid(String updateuuid) {
		_updateuuid = updateuuid;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateuuid", String.class);

				method.invoke(_d2BiobankRemoteModel, updateuuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactIDRef() {
		return _contactIDRef;
	}

	@Override
	public void setContactIDRef(String contactIDRef) {
		_contactIDRef = contactIDRef;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setContactIDRef", String.class);

				method.invoke(_d2BiobankRemoteModel, contactIDRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactPriority() {
		return _contactPriority;
	}

	@Override
	public void setContactPriority(long contactPriority) {
		_contactPriority = contactPriority;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPriority", long.class);

				method.invoke(_d2BiobankRemoteModel, contactPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBbmribiobankID() {
		return _bbmribiobankID;
	}

	@Override
	public void setBbmribiobankID(String bbmribiobankID) {
		_bbmribiobankID = bbmribiobankID;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBbmribiobankID",
						String.class);

				method.invoke(_d2BiobankRemoteModel, bbmribiobankID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankName() {
		return _biobankName;
	}

	@Override
	public void setBiobankName(String biobankName) {
		_biobankName = biobankName;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankName", String.class);

				method.invoke(_d2BiobankRemoteModel, biobankName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankJurisdicalPerson() {
		return _biobankJurisdicalPerson;
	}

	@Override
	public void setBiobankJurisdicalPerson(String biobankJurisdicalPerson) {
		_biobankJurisdicalPerson = biobankJurisdicalPerson;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankJurisdicalPerson",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankJurisdicalPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankCountry() {
		return _biobankCountry;
	}

	@Override
	public void setBiobankCountry(String biobankCountry) {
		_biobankCountry = biobankCountry;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankCountry",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankPartnerCharterSigned() {
		return _biobankPartnerCharterSigned;
	}

	@Override
	public boolean isBiobankPartnerCharterSigned() {
		return _biobankPartnerCharterSigned;
	}

	@Override
	public void setBiobankPartnerCharterSigned(
		boolean biobankPartnerCharterSigned) {
		_biobankPartnerCharterSigned = biobankPartnerCharterSigned;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankPartnerCharterSigned",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankPartnerCharterSigned);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBioresourceReference() {
		return _bioresourceReference;
	}

	@Override
	public void setBioresourceReference(String bioresourceReference) {
		_bioresourceReference = bioresourceReference;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBioresourceReference",
						String.class);

				method.invoke(_d2BiobankRemoteModel, bioresourceReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkIDRef() {
		return _biobankNetworkIDRef;
	}

	@Override
	public void setBiobankNetworkIDRef(String biobankNetworkIDRef) {
		_biobankNetworkIDRef = biobankNetworkIDRef;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkIDRef",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankNetworkIDRef);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeoLatitude() {
		return _geoLatitude;
	}

	@Override
	public void setGeoLatitude(String geoLatitude) {
		_geoLatitude = geoLatitude;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLatitude", String.class);

				method.invoke(_d2BiobankRemoteModel, geoLatitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeoLongitude() {
		return _geoLongitude;
	}

	@Override
	public void setGeoLongitude(String geoLongitude) {
		_geoLongitude = geoLongitude;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLongitude", String.class);

				method.invoke(_d2BiobankRemoteModel, geoLongitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	@Override
	public boolean isCollaborationPartnersCommercial() {
		return _collaborationPartnersCommercial;
	}

	@Override
	public void setCollaborationPartnersCommercial(
		boolean collaborationPartnersCommercial) {
		_collaborationPartnersCommercial = collaborationPartnersCommercial;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setCollaborationPartnersCommercial",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel,
					collaborationPartnersCommercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	@Override
	public boolean isCollaborationPartnersNonforprofit() {
		return _collaborationPartnersNonforprofit;
	}

	@Override
	public void setCollaborationPartnersNonforprofit(
		boolean collaborationPartnersNonforprofit) {
		_collaborationPartnersNonforprofit = collaborationPartnersNonforprofit;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setCollaborationPartnersNonforprofit",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel,
					collaborationPartnersNonforprofit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankITSupportAvailable() {
		return _biobankITSupportAvailable;
	}

	@Override
	public boolean isBiobankITSupportAvailable() {
		return _biobankITSupportAvailable;
	}

	@Override
	public void setBiobankITSupportAvailable(boolean biobankITSupportAvailable) {
		_biobankITSupportAvailable = biobankITSupportAvailable;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankITSupportAvailable",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankITSupportAvailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiobankITStaffSize() {
		return _biobankITStaffSize;
	}

	@Override
	public void setBiobankITStaffSize(long biobankITStaffSize) {
		_biobankITStaffSize = biobankITStaffSize;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankITStaffSize",
						long.class);

				method.invoke(_d2BiobankRemoteModel, biobankITStaffSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankISAvailable() {
		return _biobankISAvailable;
	}

	@Override
	public boolean isBiobankISAvailable() {
		return _biobankISAvailable;
	}

	@Override
	public void setBiobankISAvailable(boolean biobankISAvailable) {
		_biobankISAvailable = biobankISAvailable;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankISAvailable",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankISAvailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankHISAvailable() {
		return _biobankHISAvailable;
	}

	@Override
	public boolean isBiobankHISAvailable() {
		return _biobankHISAvailable;
	}

	@Override
	public void setBiobankHISAvailable(boolean biobankHISAvailable) {
		_biobankHISAvailable = biobankHISAvailable;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankHISAvailable",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankHISAvailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankAcronym() {
		return _biobankAcronym;
	}

	@Override
	public void setBiobankAcronym(String biobankAcronym) {
		_biobankAcronym = biobankAcronym;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankAcronym",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankAcronym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankDescription() {
		return _biobankDescription;
	}

	@Override
	public void setBiobankDescription(String biobankDescription) {
		_biobankDescription = biobankDescription;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankDescription",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankURL() {
		return _biobankURL;
	}

	@Override
	public void setBiobankURL(String biobankURL) {
		_biobankURL = biobankURL;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankURL", String.class);

				method.invoke(_d2BiobankRemoteModel, biobankURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankHeadFirstName() {
		return _biobankHeadFirstName;
	}

	@Override
	public void setBiobankHeadFirstName(String biobankHeadFirstName) {
		_biobankHeadFirstName = biobankHeadFirstName;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankHeadFirstName",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankHeadFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankHeadLastName() {
		return _biobankHeadLastName;
	}

	@Override
	public void setBiobankHeadLastName(String biobankHeadLastName) {
		_biobankHeadLastName = biobankHeadLastName;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankHeadLastName",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankHeadLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankHeadRole() {
		return _biobankHeadRole;
	}

	@Override
	public void setBiobankHeadRole(String biobankHeadRole) {
		_biobankHeadRole = biobankHeadRole;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankHeadRole",
						String.class);

				method.invoke(_d2BiobankRemoteModel, biobankHeadRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankClinical() {
		return _biobankClinical;
	}

	@Override
	public boolean isBiobankClinical() {
		return _biobankClinical;
	}

	@Override
	public void setBiobankClinical(boolean biobankClinical) {
		_biobankClinical = biobankClinical;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankClinical",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankClinical);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankPopulation() {
		return _biobankPopulation;
	}

	@Override
	public boolean isBiobankPopulation() {
		return _biobankPopulation;
	}

	@Override
	public void setBiobankPopulation(boolean biobankPopulation) {
		_biobankPopulation = biobankPopulation;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankPopulation",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankPopulation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankResearchStudy() {
		return _biobankResearchStudy;
	}

	@Override
	public boolean isBiobankResearchStudy() {
		return _biobankResearchStudy;
	}

	@Override
	public void setBiobankResearchStudy(boolean biobankResearchStudy) {
		_biobankResearchStudy = biobankResearchStudy;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankResearchStudy",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankResearchStudy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNonHuman() {
		return _biobankNonHuman;
	}

	@Override
	public boolean isBiobankNonHuman() {
		return _biobankNonHuman;
	}

	@Override
	public void setBiobankNonHuman(boolean biobankNonHuman) {
		_biobankNonHuman = biobankNonHuman;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNonHuman",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankNonHuman);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankCollection() {
		return _biobankCollection;
	}

	@Override
	public boolean isBiobankCollection() {
		return _biobankCollection;
	}

	@Override
	public void setBiobankCollection(boolean biobankCollection) {
		_biobankCollection = biobankCollection;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankCollection",
						boolean.class);

				method.invoke(_d2BiobankRemoteModel, biobankCollection);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankType() {
		return _biobankType;
	}

	@Override
	public void setBiobankType(String biobankType) {
		_biobankType = biobankType;

		if (_d2BiobankRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankType", String.class);

				method.invoke(_d2BiobankRemoteModel, biobankType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getNetworksWhereBiobankIsMember() {
		try {
			String methodName = "getNetworksWhereBiobankIsMember";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> returnObj =
				(java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getCollectionsCount() {
		try {
			String methodName = "getCollectionsCount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getCollections() {
		try {
			String methodName = "getCollections";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> returnObj =
				(java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation getContactInformation() {
		try {
			String methodName = "getContactInformation";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			at.meduni.liferay.portlet.bbmrieric.model.ContactInformation returnObj =
				(at.meduni.liferay.portlet.bbmrieric.model.ContactInformation)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getBiobankJavascriptTable() {
		try {
			String methodName = "getBiobankJavascriptTable";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getRootCollections() {
		try {
			String methodName = "getRootCollections";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> returnObj =
				(java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				D2Biobank.class.getName()));
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getD2BiobankRemoteModel() {
		return _d2BiobankRemoteModel;
	}

	public void setD2BiobankRemoteModel(BaseModel<?> d2BiobankRemoteModel) {
		_d2BiobankRemoteModel = d2BiobankRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _d2BiobankRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_d2BiobankRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			D2BiobankLocalServiceUtil.addD2Biobank(this);
		}
		else {
			D2BiobankLocalServiceUtil.updateD2Biobank(this);
		}
	}

	@Override
	public D2Biobank toEscapedModel() {
		return (D2Biobank)ProxyUtil.newProxyInstance(D2Biobank.class.getClassLoader(),
			new Class[] { D2Biobank.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		D2BiobankClp clone = new D2BiobankClp();

		clone.setUuid(getUuid());
		clone.setBiobankId(getBiobankId());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUpdateuuid(getUpdateuuid());
		clone.setContactIDRef(getContactIDRef());
		clone.setContactPriority(getContactPriority());
		clone.setBbmribiobankID(getBbmribiobankID());
		clone.setBiobankName(getBiobankName());
		clone.setBiobankJurisdicalPerson(getBiobankJurisdicalPerson());
		clone.setBiobankCountry(getBiobankCountry());
		clone.setBiobankPartnerCharterSigned(getBiobankPartnerCharterSigned());
		clone.setBioresourceReference(getBioresourceReference());
		clone.setBiobankNetworkIDRef(getBiobankNetworkIDRef());
		clone.setGeoLatitude(getGeoLatitude());
		clone.setGeoLongitude(getGeoLongitude());
		clone.setCollaborationPartnersCommercial(getCollaborationPartnersCommercial());
		clone.setCollaborationPartnersNonforprofit(getCollaborationPartnersNonforprofit());
		clone.setBiobankITSupportAvailable(getBiobankITSupportAvailable());
		clone.setBiobankITStaffSize(getBiobankITStaffSize());
		clone.setBiobankISAvailable(getBiobankISAvailable());
		clone.setBiobankHISAvailable(getBiobankHISAvailable());
		clone.setBiobankAcronym(getBiobankAcronym());
		clone.setBiobankDescription(getBiobankDescription());
		clone.setBiobankURL(getBiobankURL());
		clone.setBiobankHeadFirstName(getBiobankHeadFirstName());
		clone.setBiobankHeadLastName(getBiobankHeadLastName());
		clone.setBiobankHeadRole(getBiobankHeadRole());
		clone.setBiobankClinical(getBiobankClinical());
		clone.setBiobankPopulation(getBiobankPopulation());
		clone.setBiobankResearchStudy(getBiobankResearchStudy());
		clone.setBiobankNonHuman(getBiobankNonHuman());
		clone.setBiobankCollection(getBiobankCollection());
		clone.setBiobankType(getBiobankType());

		return clone;
	}

	@Override
	public int compareTo(D2Biobank d2Biobank) {
		long primaryKey = d2Biobank.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2BiobankClp)) {
			return false;
		}

		D2BiobankClp d2Biobank = (D2BiobankClp)obj;

		long primaryKey = d2Biobank.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(85);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", biobankId=");
		sb.append(getBiobankId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", updateuuid=");
		sb.append(getUpdateuuid());
		sb.append(", contactIDRef=");
		sb.append(getContactIDRef());
		sb.append(", contactPriority=");
		sb.append(getContactPriority());
		sb.append(", bbmribiobankID=");
		sb.append(getBbmribiobankID());
		sb.append(", biobankName=");
		sb.append(getBiobankName());
		sb.append(", biobankJurisdicalPerson=");
		sb.append(getBiobankJurisdicalPerson());
		sb.append(", biobankCountry=");
		sb.append(getBiobankCountry());
		sb.append(", biobankPartnerCharterSigned=");
		sb.append(getBiobankPartnerCharterSigned());
		sb.append(", bioresourceReference=");
		sb.append(getBioresourceReference());
		sb.append(", biobankNetworkIDRef=");
		sb.append(getBiobankNetworkIDRef());
		sb.append(", geoLatitude=");
		sb.append(getGeoLatitude());
		sb.append(", geoLongitude=");
		sb.append(getGeoLongitude());
		sb.append(", collaborationPartnersCommercial=");
		sb.append(getCollaborationPartnersCommercial());
		sb.append(", collaborationPartnersNonforprofit=");
		sb.append(getCollaborationPartnersNonforprofit());
		sb.append(", biobankITSupportAvailable=");
		sb.append(getBiobankITSupportAvailable());
		sb.append(", biobankITStaffSize=");
		sb.append(getBiobankITStaffSize());
		sb.append(", biobankISAvailable=");
		sb.append(getBiobankISAvailable());
		sb.append(", biobankHISAvailable=");
		sb.append(getBiobankHISAvailable());
		sb.append(", biobankAcronym=");
		sb.append(getBiobankAcronym());
		sb.append(", biobankDescription=");
		sb.append(getBiobankDescription());
		sb.append(", biobankURL=");
		sb.append(getBiobankURL());
		sb.append(", biobankHeadFirstName=");
		sb.append(getBiobankHeadFirstName());
		sb.append(", biobankHeadLastName=");
		sb.append(getBiobankHeadLastName());
		sb.append(", biobankHeadRole=");
		sb.append(getBiobankHeadRole());
		sb.append(", biobankClinical=");
		sb.append(getBiobankClinical());
		sb.append(", biobankPopulation=");
		sb.append(getBiobankPopulation());
		sb.append(", biobankResearchStudy=");
		sb.append(getBiobankResearchStudy());
		sb.append(", biobankNonHuman=");
		sb.append(getBiobankNonHuman());
		sb.append(", biobankCollection=");
		sb.append(getBiobankCollection());
		sb.append(", biobankType=");
		sb.append(getBiobankType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(130);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.model.D2Biobank");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankId</column-name><column-value><![CDATA[");
		sb.append(getBiobankId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateuuid</column-name><column-value><![CDATA[");
		sb.append(getUpdateuuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactIDRef</column-name><column-value><![CDATA[");
		sb.append(getContactIDRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPriority</column-name><column-value><![CDATA[");
		sb.append(getContactPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bbmribiobankID</column-name><column-value><![CDATA[");
		sb.append(getBbmribiobankID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankName</column-name><column-value><![CDATA[");
		sb.append(getBiobankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankJurisdicalPerson</column-name><column-value><![CDATA[");
		sb.append(getBiobankJurisdicalPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankCountry</column-name><column-value><![CDATA[");
		sb.append(getBiobankCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankPartnerCharterSigned</column-name><column-value><![CDATA[");
		sb.append(getBiobankPartnerCharterSigned());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bioresourceReference</column-name><column-value><![CDATA[");
		sb.append(getBioresourceReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkIDRef</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkIDRef());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geoLatitude</column-name><column-value><![CDATA[");
		sb.append(getGeoLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geoLongitude</column-name><column-value><![CDATA[");
		sb.append(getGeoLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collaborationPartnersCommercial</column-name><column-value><![CDATA[");
		sb.append(getCollaborationPartnersCommercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>collaborationPartnersNonforprofit</column-name><column-value><![CDATA[");
		sb.append(getCollaborationPartnersNonforprofit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankITSupportAvailable</column-name><column-value><![CDATA[");
		sb.append(getBiobankITSupportAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankITStaffSize</column-name><column-value><![CDATA[");
		sb.append(getBiobankITStaffSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankISAvailable</column-name><column-value><![CDATA[");
		sb.append(getBiobankISAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankHISAvailable</column-name><column-value><![CDATA[");
		sb.append(getBiobankHISAvailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankAcronym</column-name><column-value><![CDATA[");
		sb.append(getBiobankAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankDescription</column-name><column-value><![CDATA[");
		sb.append(getBiobankDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankURL</column-name><column-value><![CDATA[");
		sb.append(getBiobankURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankHeadFirstName</column-name><column-value><![CDATA[");
		sb.append(getBiobankHeadFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankHeadLastName</column-name><column-value><![CDATA[");
		sb.append(getBiobankHeadLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankHeadRole</column-name><column-value><![CDATA[");
		sb.append(getBiobankHeadRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankClinical</column-name><column-value><![CDATA[");
		sb.append(getBiobankClinical());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankPopulation</column-name><column-value><![CDATA[");
		sb.append(getBiobankPopulation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankResearchStudy</column-name><column-value><![CDATA[");
		sb.append(getBiobankResearchStudy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNonHuman</column-name><column-value><![CDATA[");
		sb.append(getBiobankNonHuman());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankCollection</column-name><column-value><![CDATA[");
		sb.append(getBiobankCollection());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankType</column-name><column-value><![CDATA[");
		sb.append(getBiobankType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _biobankId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private String _biobankType;
	private BaseModel<?> _d2BiobankRemoteModel;
}