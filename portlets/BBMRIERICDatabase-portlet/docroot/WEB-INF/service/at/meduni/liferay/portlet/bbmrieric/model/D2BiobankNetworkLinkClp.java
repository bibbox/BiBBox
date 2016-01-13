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
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil;

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
public class D2BiobankNetworkLinkClp extends BaseModelImpl<D2BiobankNetworkLink>
	implements D2BiobankNetworkLink {
	public D2BiobankNetworkLinkClp() {
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
	public long getPrimaryKey() {
		return _d2biobanknetworklinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setD2biobanknetworklinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _d2biobanknetworklinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getD2biobanknetworklinkId() {
		return _d2biobanknetworklinkId;
	}

	@Override
	public void setD2biobanknetworklinkId(long d2biobanknetworklinkId) {
		_d2biobanknetworklinkId = d2biobanknetworklinkId;

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setD2biobanknetworklinkId",
						long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel,
					d2biobanknetworklinkId);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setD2biobanknetworkId",
						long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel,
					d2biobanknetworkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getD2linkId() {
		return _d2linkId;
	}

	@Override
	public void setD2linkId(long d2linkId) {
		_d2linkId = d2linkId;

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setD2linkId", long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, d2linkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getD2linktype() {
		return _d2linktype;
	}

	@Override
	public void setD2linktype(String d2linktype) {
		_d2linktype = d2linktype;

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setD2linktype", String.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, d2linktype);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, status);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, statusByUserId);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, statusByUserName);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, statusDate);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, companyId);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, groupId);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, userId);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, userName);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, createDate);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, modifiedDate);
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

		if (_d2BiobankNetworkLinkRemoteModel != null) {
			try {
				Class<?> clazz = _d2BiobankNetworkLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateuuid", String.class);

				method.invoke(_d2BiobankNetworkLinkRemoteModel, updateuuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				D2BiobankNetworkLink.class.getName()));
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

	public BaseModel<?> getD2BiobankNetworkLinkRemoteModel() {
		return _d2BiobankNetworkLinkRemoteModel;
	}

	public void setD2BiobankNetworkLinkRemoteModel(
		BaseModel<?> d2BiobankNetworkLinkRemoteModel) {
		_d2BiobankNetworkLinkRemoteModel = d2BiobankNetworkLinkRemoteModel;
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

		Class<?> remoteModelClass = _d2BiobankNetworkLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_d2BiobankNetworkLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			D2BiobankNetworkLinkLocalServiceUtil.addD2BiobankNetworkLink(this);
		}
		else {
			D2BiobankNetworkLinkLocalServiceUtil.updateD2BiobankNetworkLink(this);
		}
	}

	@Override
	public D2BiobankNetworkLink toEscapedModel() {
		return (D2BiobankNetworkLink)ProxyUtil.newProxyInstance(D2BiobankNetworkLink.class.getClassLoader(),
			new Class[] { D2BiobankNetworkLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		D2BiobankNetworkLinkClp clone = new D2BiobankNetworkLinkClp();

		clone.setUuid(getUuid());
		clone.setD2biobanknetworklinkId(getD2biobanknetworklinkId());
		clone.setD2biobanknetworkId(getD2biobanknetworkId());
		clone.setD2linkId(getD2linkId());
		clone.setD2linktype(getD2linktype());
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

		return clone;
	}

	@Override
	public int compareTo(D2BiobankNetworkLink d2BiobankNetworkLink) {
		long primaryKey = d2BiobankNetworkLink.getPrimaryKey();

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

		if (!(obj instanceof D2BiobankNetworkLinkClp)) {
			return false;
		}

		D2BiobankNetworkLinkClp d2BiobankNetworkLink = (D2BiobankNetworkLinkClp)obj;

		long primaryKey = d2BiobankNetworkLink.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", d2biobanknetworklinkId=");
		sb.append(getD2biobanknetworklinkId());
		sb.append(", d2biobanknetworkId=");
		sb.append(getD2biobanknetworkId());
		sb.append(", d2linkId=");
		sb.append(getD2linkId());
		sb.append(", d2linktype=");
		sb.append(getD2linktype());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append(
			"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2biobanknetworklinkId</column-name><column-value><![CDATA[");
		sb.append(getD2biobanknetworklinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2biobanknetworkId</column-name><column-value><![CDATA[");
		sb.append(getD2biobanknetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2linkId</column-name><column-value><![CDATA[");
		sb.append(getD2linkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d2linktype</column-name><column-value><![CDATA[");
		sb.append(getD2linktype());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _d2biobanknetworklinkId;
	private long _d2biobanknetworkId;
	private long _d2linkId;
	private String _d2linktype;
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
	private BaseModel<?> _d2BiobankNetworkLinkRemoteModel;
}