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
 * This class is a wrapper for {@link D2BiobankNetworkLink}.
 * </p>
 *
 * @author reihsr
 * @see D2BiobankNetworkLink
 * @generated
 */
public class D2BiobankNetworkLinkWrapper implements D2BiobankNetworkLink,
	ModelWrapper<D2BiobankNetworkLink> {
	public D2BiobankNetworkLinkWrapper(
		D2BiobankNetworkLink d2BiobankNetworkLink) {
		_d2BiobankNetworkLink = d2BiobankNetworkLink;
	}

	@Override
	public Class<?> getModelClass() {
		return D2BiobankNetworkLink.class;
	}

	@Override
	public String getModelClassName() {
		return D2BiobankNetworkLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("d2biobanknetworklinkId", getD2biobanknetworklinkId());
		attributes.put("d2biobanknetworkId", getD2biobanknetworkId());
		attributes.put("d2linkId", getD2linkId());
		attributes.put("d2linktype", getD2linktype());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long d2biobanknetworklinkId = (Long)attributes.get(
				"d2biobanknetworklinkId");

		if (d2biobanknetworklinkId != null) {
			setD2biobanknetworklinkId(d2biobanknetworklinkId);
		}

		Long d2biobanknetworkId = (Long)attributes.get("d2biobanknetworkId");

		if (d2biobanknetworkId != null) {
			setD2biobanknetworkId(d2biobanknetworkId);
		}

		Long d2linkId = (Long)attributes.get("d2linkId");

		if (d2linkId != null) {
			setD2linkId(d2linkId);
		}

		String d2linktype = (String)attributes.get("d2linktype");

		if (d2linktype != null) {
			setD2linktype(d2linktype);
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
	}

	/**
	* Returns the primary key of this d2 biobank network link.
	*
	* @return the primary key of this d2 biobank network link
	*/
	@Override
	public long getPrimaryKey() {
		return _d2BiobankNetworkLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d2 biobank network link.
	*
	* @param primaryKey the primary key of this d2 biobank network link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_d2BiobankNetworkLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this d2 biobank network link.
	*
	* @return the uuid of this d2 biobank network link
	*/
	@Override
	public java.lang.String getUuid() {
		return _d2BiobankNetworkLink.getUuid();
	}

	/**
	* Sets the uuid of this d2 biobank network link.
	*
	* @param uuid the uuid of this d2 biobank network link
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_d2BiobankNetworkLink.setUuid(uuid);
	}

	/**
	* Returns the d2biobanknetworklink ID of this d2 biobank network link.
	*
	* @return the d2biobanknetworklink ID of this d2 biobank network link
	*/
	@Override
	public long getD2biobanknetworklinkId() {
		return _d2BiobankNetworkLink.getD2biobanknetworklinkId();
	}

	/**
	* Sets the d2biobanknetworklink ID of this d2 biobank network link.
	*
	* @param d2biobanknetworklinkId the d2biobanknetworklink ID of this d2 biobank network link
	*/
	@Override
	public void setD2biobanknetworklinkId(long d2biobanknetworklinkId) {
		_d2BiobankNetworkLink.setD2biobanknetworklinkId(d2biobanknetworklinkId);
	}

	/**
	* Returns the d2biobanknetwork ID of this d2 biobank network link.
	*
	* @return the d2biobanknetwork ID of this d2 biobank network link
	*/
	@Override
	public long getD2biobanknetworkId() {
		return _d2BiobankNetworkLink.getD2biobanknetworkId();
	}

	/**
	* Sets the d2biobanknetwork ID of this d2 biobank network link.
	*
	* @param d2biobanknetworkId the d2biobanknetwork ID of this d2 biobank network link
	*/
	@Override
	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		_d2BiobankNetworkLink.setD2biobanknetworkId(d2biobanknetworkId);
	}

	/**
	* Returns the d2link ID of this d2 biobank network link.
	*
	* @return the d2link ID of this d2 biobank network link
	*/
	@Override
	public long getD2linkId() {
		return _d2BiobankNetworkLink.getD2linkId();
	}

	/**
	* Sets the d2link ID of this d2 biobank network link.
	*
	* @param d2linkId the d2link ID of this d2 biobank network link
	*/
	@Override
	public void setD2linkId(long d2linkId) {
		_d2BiobankNetworkLink.setD2linkId(d2linkId);
	}

	/**
	* Returns the d2linktype of this d2 biobank network link.
	*
	* @return the d2linktype of this d2 biobank network link
	*/
	@Override
	public java.lang.String getD2linktype() {
		return _d2BiobankNetworkLink.getD2linktype();
	}

	/**
	* Sets the d2linktype of this d2 biobank network link.
	*
	* @param d2linktype the d2linktype of this d2 biobank network link
	*/
	@Override
	public void setD2linktype(java.lang.String d2linktype) {
		_d2BiobankNetworkLink.setD2linktype(d2linktype);
	}

	/**
	* Returns the status of this d2 biobank network link.
	*
	* @return the status of this d2 biobank network link
	*/
	@Override
	public int getStatus() {
		return _d2BiobankNetworkLink.getStatus();
	}

	/**
	* Sets the status of this d2 biobank network link.
	*
	* @param status the status of this d2 biobank network link
	*/
	@Override
	public void setStatus(int status) {
		_d2BiobankNetworkLink.setStatus(status);
	}

	/**
	* Returns the status by user ID of this d2 biobank network link.
	*
	* @return the status by user ID of this d2 biobank network link
	*/
	@Override
	public long getStatusByUserId() {
		return _d2BiobankNetworkLink.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this d2 biobank network link.
	*
	* @param statusByUserId the status by user ID of this d2 biobank network link
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_d2BiobankNetworkLink.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this d2 biobank network link.
	*
	* @return the status by user uuid of this d2 biobank network link
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2BiobankNetworkLink.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this d2 biobank network link.
	*
	* @param statusByUserUuid the status by user uuid of this d2 biobank network link
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_d2BiobankNetworkLink.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this d2 biobank network link.
	*
	* @return the status by user name of this d2 biobank network link
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _d2BiobankNetworkLink.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this d2 biobank network link.
	*
	* @param statusByUserName the status by user name of this d2 biobank network link
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_d2BiobankNetworkLink.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this d2 biobank network link.
	*
	* @return the status date of this d2 biobank network link
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _d2BiobankNetworkLink.getStatusDate();
	}

	/**
	* Sets the status date of this d2 biobank network link.
	*
	* @param statusDate the status date of this d2 biobank network link
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_d2BiobankNetworkLink.setStatusDate(statusDate);
	}

	/**
	* Returns the company ID of this d2 biobank network link.
	*
	* @return the company ID of this d2 biobank network link
	*/
	@Override
	public long getCompanyId() {
		return _d2BiobankNetworkLink.getCompanyId();
	}

	/**
	* Sets the company ID of this d2 biobank network link.
	*
	* @param companyId the company ID of this d2 biobank network link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_d2BiobankNetworkLink.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this d2 biobank network link.
	*
	* @return the group ID of this d2 biobank network link
	*/
	@Override
	public long getGroupId() {
		return _d2BiobankNetworkLink.getGroupId();
	}

	/**
	* Sets the group ID of this d2 biobank network link.
	*
	* @param groupId the group ID of this d2 biobank network link
	*/
	@Override
	public void setGroupId(long groupId) {
		_d2BiobankNetworkLink.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this d2 biobank network link.
	*
	* @return the user ID of this d2 biobank network link
	*/
	@Override
	public long getUserId() {
		return _d2BiobankNetworkLink.getUserId();
	}

	/**
	* Sets the user ID of this d2 biobank network link.
	*
	* @param userId the user ID of this d2 biobank network link
	*/
	@Override
	public void setUserId(long userId) {
		_d2BiobankNetworkLink.setUserId(userId);
	}

	/**
	* Returns the user uuid of this d2 biobank network link.
	*
	* @return the user uuid of this d2 biobank network link
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _d2BiobankNetworkLink.getUserUuid();
	}

	/**
	* Sets the user uuid of this d2 biobank network link.
	*
	* @param userUuid the user uuid of this d2 biobank network link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_d2BiobankNetworkLink.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this d2 biobank network link.
	*
	* @return the user name of this d2 biobank network link
	*/
	@Override
	public java.lang.String getUserName() {
		return _d2BiobankNetworkLink.getUserName();
	}

	/**
	* Sets the user name of this d2 biobank network link.
	*
	* @param userName the user name of this d2 biobank network link
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_d2BiobankNetworkLink.setUserName(userName);
	}

	/**
	* Returns the create date of this d2 biobank network link.
	*
	* @return the create date of this d2 biobank network link
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _d2BiobankNetworkLink.getCreateDate();
	}

	/**
	* Sets the create date of this d2 biobank network link.
	*
	* @param createDate the create date of this d2 biobank network link
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_d2BiobankNetworkLink.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this d2 biobank network link.
	*
	* @return the modified date of this d2 biobank network link
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _d2BiobankNetworkLink.getModifiedDate();
	}

	/**
	* Sets the modified date of this d2 biobank network link.
	*
	* @param modifiedDate the modified date of this d2 biobank network link
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_d2BiobankNetworkLink.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updateuuid of this d2 biobank network link.
	*
	* @return the updateuuid of this d2 biobank network link
	*/
	@Override
	public java.lang.String getUpdateuuid() {
		return _d2BiobankNetworkLink.getUpdateuuid();
	}

	/**
	* Sets the updateuuid of this d2 biobank network link.
	*
	* @param updateuuid the updateuuid of this d2 biobank network link
	*/
	@Override
	public void setUpdateuuid(java.lang.String updateuuid) {
		_d2BiobankNetworkLink.setUpdateuuid(updateuuid);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _d2BiobankNetworkLink.getApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is approved.
	*
	* @return <code>true</code> if this d2 biobank network link is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _d2BiobankNetworkLink.isApproved();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is denied.
	*
	* @return <code>true</code> if this d2 biobank network link is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _d2BiobankNetworkLink.isDenied();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is a draft.
	*
	* @return <code>true</code> if this d2 biobank network link is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _d2BiobankNetworkLink.isDraft();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is expired.
	*
	* @return <code>true</code> if this d2 biobank network link is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _d2BiobankNetworkLink.isExpired();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is inactive.
	*
	* @return <code>true</code> if this d2 biobank network link is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _d2BiobankNetworkLink.isInactive();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is incomplete.
	*
	* @return <code>true</code> if this d2 biobank network link is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _d2BiobankNetworkLink.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is pending.
	*
	* @return <code>true</code> if this d2 biobank network link is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _d2BiobankNetworkLink.isPending();
	}

	/**
	* Returns <code>true</code> if this d2 biobank network link is scheduled.
	*
	* @return <code>true</code> if this d2 biobank network link is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _d2BiobankNetworkLink.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _d2BiobankNetworkLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_d2BiobankNetworkLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _d2BiobankNetworkLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_d2BiobankNetworkLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _d2BiobankNetworkLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _d2BiobankNetworkLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_d2BiobankNetworkLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _d2BiobankNetworkLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_d2BiobankNetworkLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_d2BiobankNetworkLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_d2BiobankNetworkLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new D2BiobankNetworkLinkWrapper((D2BiobankNetworkLink)_d2BiobankNetworkLink.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink d2BiobankNetworkLink) {
		return _d2BiobankNetworkLink.compareTo(d2BiobankNetworkLink);
	}

	@Override
	public int hashCode() {
		return _d2BiobankNetworkLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink> toCacheModel() {
		return _d2BiobankNetworkLink.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink toEscapedModel() {
		return new D2BiobankNetworkLinkWrapper(_d2BiobankNetworkLink.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink toUnescapedModel() {
		return new D2BiobankNetworkLinkWrapper(_d2BiobankNetworkLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _d2BiobankNetworkLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _d2BiobankNetworkLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_d2BiobankNetworkLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof D2BiobankNetworkLinkWrapper)) {
			return false;
		}

		D2BiobankNetworkLinkWrapper d2BiobankNetworkLinkWrapper = (D2BiobankNetworkLinkWrapper)obj;

		if (Validator.equals(_d2BiobankNetworkLink,
					d2BiobankNetworkLinkWrapper._d2BiobankNetworkLink)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _d2BiobankNetworkLink.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public D2BiobankNetworkLink getWrappedD2BiobankNetworkLink() {
		return _d2BiobankNetworkLink;
	}

	@Override
	public D2BiobankNetworkLink getWrappedModel() {
		return _d2BiobankNetworkLink;
	}

	@Override
	public void resetOriginalValues() {
		_d2BiobankNetworkLink.resetOriginalValues();
	}

	private D2BiobankNetworkLink _d2BiobankNetworkLink;
}