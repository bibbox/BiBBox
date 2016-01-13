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
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;

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
public class D2BiobankNetworkClp extends BaseModelImpl<D2BiobankNetwork>
	implements D2BiobankNetwork {
	public D2BiobankNetworkClp() {
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
	public long getPrimaryKey() {
		return _d2biobanknetworkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setD2biobanknetworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _d2biobanknetworkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getD2biobanknetworkId() {
		return _d2biobanknetworkId;
	}

	@Override
	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		_d2biobanknetworkId = d2biobanknetworkId;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setD2biobanknetworkId",
						long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, d2biobanknetworkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentd2biobanknetworkId() {
		return _parentd2biobanknetworkId;
	}

	@Override
	public void setParentd2biobanknetworkId(long parentd2biobanknetworkId) {
		_parentd2biobanknetworkId = parentd2biobanknetworkId;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setParentd2biobanknetworkId",
						long.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					parentd2biobanknetworkId);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_d2BiobankNetworkRemoteModel, status);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, statusByUserId);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, statusByUserName);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_d2BiobankNetworkRemoteModel, statusDate);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, companyId);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, groupId);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, userId);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, userName);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_d2BiobankNetworkRemoteModel, createDate);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_d2BiobankNetworkRemoteModel, modifiedDate);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateuuid", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, updateuuid);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setContactIDRef", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, contactIDRef);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPriority", long.class);

				method.invoke(_d2BiobankNetworkRemoteModel, contactPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBbmriBiobankNetworkID() {
		return _bbmriBiobankNetworkID;
	}

	@Override
	public void setBbmriBiobankNetworkID(String bbmriBiobankNetworkID) {
		_bbmriBiobankNetworkID = bbmriBiobankNetworkID;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBbmriBiobankNetworkID",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					bbmriBiobankNetworkID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkName() {
		return _biobankNetworkName;
	}

	@Override
	public void setBiobankNetworkName(String biobankNetworkName) {
		_biobankNetworkName = biobankNetworkName;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkName",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, biobankNetworkName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonCollectionFocus() {
		return _biobankNetworkCommonCollectionFocus;
	}

	@Override
	public boolean isBiobankNetworkCommonCollectionFocus() {
		return _biobankNetworkCommonCollectionFocus;
	}

	@Override
	public void setBiobankNetworkCommonCollectionFocus(
		boolean biobankNetworkCommonCollectionFocus) {
		_biobankNetworkCommonCollectionFocus = biobankNetworkCommonCollectionFocus;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonCollectionFocus",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonCollectionFocus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonCharter() {
		return _biobankNetworkCommonCharter;
	}

	@Override
	public boolean isBiobankNetworkCommonCharter() {
		return _biobankNetworkCommonCharter;
	}

	@Override
	public void setBiobankNetworkCommonCharter(
		boolean biobankNetworkCommonCharter) {
		_biobankNetworkCommonCharter = biobankNetworkCommonCharter;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonCharter",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonCharter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonSOPs() {
		return _biobankNetworkCommonSOPs;
	}

	@Override
	public boolean isBiobankNetworkCommonSOPs() {
		return _biobankNetworkCommonSOPs;
	}

	@Override
	public void setBiobankNetworkCommonSOPs(boolean biobankNetworkCommonSOPs) {
		_biobankNetworkCommonSOPs = biobankNetworkCommonSOPs;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonSOPs",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonSOPs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonDataAccessPolicy() {
		return _biobankNetworkCommonDataAccessPolicy;
	}

	@Override
	public boolean isBiobankNetworkCommonDataAccessPolicy() {
		return _biobankNetworkCommonDataAccessPolicy;
	}

	@Override
	public void setBiobankNetworkCommonDataAccessPolicy(
		boolean biobankNetworkCommonDataAccessPolicy) {
		_biobankNetworkCommonDataAccessPolicy = biobankNetworkCommonDataAccessPolicy;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonDataAccessPolicy",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonDataAccessPolicy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonSampleAccessPolicy() {
		return _biobankNetworkCommonSampleAccessPolicy;
	}

	@Override
	public boolean isBiobankNetworkCommonSampleAccessPolicy() {
		return _biobankNetworkCommonSampleAccessPolicy;
	}

	@Override
	public void setBiobankNetworkCommonSampleAccessPolicy(
		boolean biobankNetworkCommonSampleAccessPolicy) {
		_biobankNetworkCommonSampleAccessPolicy = biobankNetworkCommonSampleAccessPolicy;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonSampleAccessPolicy",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonSampleAccessPolicy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonMTA() {
		return _biobankNetworkCommonMTA;
	}

	@Override
	public boolean isBiobankNetworkCommonMTA() {
		return _biobankNetworkCommonMTA;
	}

	@Override
	public void setBiobankNetworkCommonMTA(boolean biobankNetworkCommonMTA) {
		_biobankNetworkCommonMTA = biobankNetworkCommonMTA;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonMTA",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonMTA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonRepresentation() {
		return _biobankNetworkCommonRepresentation;
	}

	@Override
	public boolean isBiobankNetworkCommonRepresentation() {
		return _biobankNetworkCommonRepresentation;
	}

	@Override
	public void setBiobankNetworkCommonRepresentation(
		boolean biobankNetworkCommonRepresentation) {
		_biobankNetworkCommonRepresentation = biobankNetworkCommonRepresentation;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonRepresentation",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonRepresentation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBiobankNetworkCommonURL() {
		return _biobankNetworkCommonURL;
	}

	@Override
	public boolean isBiobankNetworkCommonURL() {
		return _biobankNetworkCommonURL;
	}

	@Override
	public void setBiobankNetworkCommonURL(boolean biobankNetworkCommonURL) {
		_biobankNetworkCommonURL = biobankNetworkCommonURL;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkCommonURL",
						boolean.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkCommonURL);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkIDRef",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, biobankNetworkIDRef);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLatitude", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, geoLatitude);
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

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoLongitude", String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, geoLongitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkAcronym() {
		return _biobankNetworkAcronym;
	}

	@Override
	public void setBiobankNetworkAcronym(String biobankNetworkAcronym) {
		_biobankNetworkAcronym = biobankNetworkAcronym;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkAcronym",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkAcronym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkDescription() {
		return _biobankNetworkDescription;
	}

	@Override
	public void setBiobankNetworkDescription(String biobankNetworkDescription) {
		_biobankNetworkDescription = biobankNetworkDescription;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkDescription",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkURL() {
		return _biobankNetworkURL;
	}

	@Override
	public void setBiobankNetworkURL(String biobankNetworkURL) {
		_biobankNetworkURL = biobankNetworkURL;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkURL",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel, biobankNetworkURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankNetworkJuridicalPerson() {
		return _biobankNetworkJuridicalPerson;
	}

	@Override
	public void setBiobankNetworkJuridicalPerson(
		String biobankNetworkJuridicalPerson) {
		_biobankNetworkJuridicalPerson = biobankNetworkJuridicalPerson;

		if (_d2BiobankNetworkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankNetworkJuridicalPerson",
						String.class);

				method.invoke(_d2BiobankNetworkRemoteModel,
					biobankNetworkJuridicalPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> getAssosiatedBiobanks() {
		try {
			String methodName = "getAssosiatedBiobanks";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank> returnObj =
				(java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Biobank>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork> getAssosiatedNetworks() {
		try {
			String methodName = "getAssosiatedNetworks";

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
	public java.lang.String getBiobankNetworkJavascriptTable() {
		try {
			String methodName = "getBiobankNetworkJavascriptTable";

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getAssosiatedCollections() {
		try {
			String methodName = "getAssosiatedCollections";

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
				D2BiobankNetwork.class.getName()));
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

	public BaseModel<?> getD2BiobankNetworkRemoteModel() {
		return _d2BiobankNetworkRemoteModel;
	}

	public void setD2BiobankNetworkRemoteModel(
		BaseModel<?> d2BiobankNetworkRemoteModel) {
		_d2BiobankNetworkRemoteModel = d2BiobankNetworkRemoteModel;
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

		Class<?> remoteModelClass = _d2BiobankNetworkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_d2BiobankNetworkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			D2BiobankNetworkLocalServiceUtil.addD2BiobankNetwork(this);
		}
		else {
			D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork(this);
		}
	}

	@Override
	public D2BiobankNetwork toEscapedModel() {
		return (D2BiobankNetwork)ProxyUtil.newProxyInstance(D2BiobankNetwork.class.getClassLoader(),
			new Class[] { D2BiobankNetwork.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		D2BiobankNetworkClp clone = new D2BiobankNetworkClp();

		clone.setUuid(getUuid());
		clone.setD2biobanknetworkId(getD2biobanknetworkId());
		clone.setParentd2biobanknetworkId(getParentd2biobanknetworkId());
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
		clone.setBbmriBiobankNetworkID(getBbmriBiobankNetworkID());
		clone.setBiobankNetworkName(getBiobankNetworkName());
		clone.setBiobankNetworkCommonCollectionFocus(getBiobankNetworkCommonCollectionFocus());
		clone.setBiobankNetworkCommonCharter(getBiobankNetworkCommonCharter());
		clone.setBiobankNetworkCommonSOPs(getBiobankNetworkCommonSOPs());
		clone.setBiobankNetworkCommonDataAccessPolicy(getBiobankNetworkCommonDataAccessPolicy());
		clone.setBiobankNetworkCommonSampleAccessPolicy(getBiobankNetworkCommonSampleAccessPolicy());
		clone.setBiobankNetworkCommonMTA(getBiobankNetworkCommonMTA());
		clone.setBiobankNetworkCommonRepresentation(getBiobankNetworkCommonRepresentation());
		clone.setBiobankNetworkCommonURL(getBiobankNetworkCommonURL());
		clone.setBiobankNetworkIDRef(getBiobankNetworkIDRef());
		clone.setGeoLatitude(getGeoLatitude());
		clone.setGeoLongitude(getGeoLongitude());
		clone.setBiobankNetworkAcronym(getBiobankNetworkAcronym());
		clone.setBiobankNetworkDescription(getBiobankNetworkDescription());
		clone.setBiobankNetworkURL(getBiobankNetworkURL());
		clone.setBiobankNetworkJuridicalPerson(getBiobankNetworkJuridicalPerson());

		return clone;
	}

	@Override
	public int compareTo(D2BiobankNetwork d2BiobankNetwork) {
		long primaryKey = d2BiobankNetwork.getPrimaryKey();

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

		if (!(obj instanceof D2BiobankNetworkClp)) {
			return false;
		}

		D2BiobankNetworkClp d2BiobankNetwork = (D2BiobankNetworkClp)obj;

		long primaryKey = d2BiobankNetwork.getPrimaryKey();

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
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", d2biobanknetworkId=");
		sb.append(getD2biobanknetworkId());
		sb.append(", parentd2biobanknetworkId=");
		sb.append(getParentd2biobanknetworkId());
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
		sb.append(", bbmriBiobankNetworkID=");
		sb.append(getBbmriBiobankNetworkID());
		sb.append(", biobankNetworkName=");
		sb.append(getBiobankNetworkName());
		sb.append(", biobankNetworkCommonCollectionFocus=");
		sb.append(getBiobankNetworkCommonCollectionFocus());
		sb.append(", biobankNetworkCommonCharter=");
		sb.append(getBiobankNetworkCommonCharter());
		sb.append(", biobankNetworkCommonSOPs=");
		sb.append(getBiobankNetworkCommonSOPs());
		sb.append(", biobankNetworkCommonDataAccessPolicy=");
		sb.append(getBiobankNetworkCommonDataAccessPolicy());
		sb.append(", biobankNetworkCommonSampleAccessPolicy=");
		sb.append(getBiobankNetworkCommonSampleAccessPolicy());
		sb.append(", biobankNetworkCommonMTA=");
		sb.append(getBiobankNetworkCommonMTA());
		sb.append(", biobankNetworkCommonRepresentation=");
		sb.append(getBiobankNetworkCommonRepresentation());
		sb.append(", biobankNetworkCommonURL=");
		sb.append(getBiobankNetworkCommonURL());
		sb.append(", biobankNetworkIDRef=");
		sb.append(getBiobankNetworkIDRef());
		sb.append(", geoLatitude=");
		sb.append(getGeoLatitude());
		sb.append(", geoLongitude=");
		sb.append(getGeoLongitude());
		sb.append(", biobankNetworkAcronym=");
		sb.append(getBiobankNetworkAcronym());
		sb.append(", biobankNetworkDescription=");
		sb.append(getBiobankNetworkDescription());
		sb.append(", biobankNetworkURL=");
		sb.append(getBiobankNetworkURL());
		sb.append(", biobankNetworkJuridicalPerson=");
		sb.append(getBiobankNetworkJuridicalPerson());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2biobanknetworkId</column-name><column-value><![CDATA[");
		sb.append(getD2biobanknetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentd2biobanknetworkId</column-name><column-value><![CDATA[");
		sb.append(getParentd2biobanknetworkId());
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
			"<column><column-name>bbmriBiobankNetworkID</column-name><column-value><![CDATA[");
		sb.append(getBbmriBiobankNetworkID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkName</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonCollectionFocus</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonCollectionFocus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonCharter</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonCharter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonSOPs</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonSOPs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonDataAccessPolicy</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonDataAccessPolicy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonSampleAccessPolicy</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonSampleAccessPolicy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonMTA</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonMTA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonRepresentation</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonRepresentation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkCommonURL</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkCommonURL());
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
			"<column><column-name>biobankNetworkAcronym</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkDescription</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkURL</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankNetworkJuridicalPerson</column-name><column-value><![CDATA[");
		sb.append(getBiobankNetworkJuridicalPerson());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _d2biobanknetworkId;
	private long _parentd2biobanknetworkId;
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
	private BaseModel<?> _d2BiobankNetworkRemoteModel;
}