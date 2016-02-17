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
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
public class ContactInformationClp extends BaseModelImpl<ContactInformation>
	implements ContactInformation {
	public ContactInformationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactInformation.class;
	}

	@Override
	public String getModelClassName() {
		return ContactInformation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contactinformationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactinformationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactinformationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("contactinformationId", getContactinformationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("updateuuid", getUpdateuuid());
		attributes.put("contactID", getContactID());
		attributes.put("contactEmail", getContactEmail());
		attributes.put("contactCountry", getContactCountry());
		attributes.put("contactFirstName", getContactFirstName());
		attributes.put("contactLastName", getContactLastName());
		attributes.put("contactPhone", getContactPhone());
		attributes.put("contactAddress", getContactAddress());
		attributes.put("contactZIP", getContactZIP());
		attributes.put("contactCity", getContactCity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long contactinformationId = (Long)attributes.get("contactinformationId");

		if (contactinformationId != null) {
			setContactinformationId(contactinformationId);
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

		String contactID = (String)attributes.get("contactID");

		if (contactID != null) {
			setContactID(contactID);
		}

		String contactEmail = (String)attributes.get("contactEmail");

		if (contactEmail != null) {
			setContactEmail(contactEmail);
		}

		String contactCountry = (String)attributes.get("contactCountry");

		if (contactCountry != null) {
			setContactCountry(contactCountry);
		}

		String contactFirstName = (String)attributes.get("contactFirstName");

		if (contactFirstName != null) {
			setContactFirstName(contactFirstName);
		}

		String contactLastName = (String)attributes.get("contactLastName");

		if (contactLastName != null) {
			setContactLastName(contactLastName);
		}

		String contactPhone = (String)attributes.get("contactPhone");

		if (contactPhone != null) {
			setContactPhone(contactPhone);
		}

		String contactAddress = (String)attributes.get("contactAddress");

		if (contactAddress != null) {
			setContactAddress(contactAddress);
		}

		String contactZIP = (String)attributes.get("contactZIP");

		if (contactZIP != null) {
			setContactZIP(contactZIP);
		}

		String contactCity = (String)attributes.get("contactCity");

		if (contactCity != null) {
			setContactCity(contactCity);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_contactInformationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactinformationId() {
		return _contactinformationId;
	}

	@Override
	public void setContactinformationId(long contactinformationId) {
		_contactinformationId = contactinformationId;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactinformationId",
						long.class);

				method.invoke(_contactInformationRemoteModel,
					contactinformationId);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contactInformationRemoteModel, companyId);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contactInformationRemoteModel, groupId);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contactInformationRemoteModel, userId);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_contactInformationRemoteModel, userName);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contactInformationRemoteModel, createDate);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contactInformationRemoteModel, modifiedDate);
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

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateuuid", String.class);

				method.invoke(_contactInformationRemoteModel, updateuuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactID() {
		return _contactID;
	}

	@Override
	public void setContactID(String contactID) {
		_contactID = contactID;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactID", String.class);

				method.invoke(_contactInformationRemoteModel, contactID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactEmail() {
		return _contactEmail;
	}

	@Override
	public void setContactEmail(String contactEmail) {
		_contactEmail = contactEmail;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactEmail", String.class);

				method.invoke(_contactInformationRemoteModel, contactEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactCountry() {
		return _contactCountry;
	}

	@Override
	public void setContactCountry(String contactCountry) {
		_contactCountry = contactCountry;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactCountry",
						String.class);

				method.invoke(_contactInformationRemoteModel, contactCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactFirstName() {
		return _contactFirstName;
	}

	@Override
	public void setContactFirstName(String contactFirstName) {
		_contactFirstName = contactFirstName;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactFirstName",
						String.class);

				method.invoke(_contactInformationRemoteModel, contactFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactLastName() {
		return _contactLastName;
	}

	@Override
	public void setContactLastName(String contactLastName) {
		_contactLastName = contactLastName;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactLastName",
						String.class);

				method.invoke(_contactInformationRemoteModel, contactLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactPhone() {
		return _contactPhone;
	}

	@Override
	public void setContactPhone(String contactPhone) {
		_contactPhone = contactPhone;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPhone", String.class);

				method.invoke(_contactInformationRemoteModel, contactPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactAddress() {
		return _contactAddress;
	}

	@Override
	public void setContactAddress(String contactAddress) {
		_contactAddress = contactAddress;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactAddress",
						String.class);

				method.invoke(_contactInformationRemoteModel, contactAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactZIP() {
		return _contactZIP;
	}

	@Override
	public void setContactZIP(String contactZIP) {
		_contactZIP = contactZIP;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactZIP", String.class);

				method.invoke(_contactInformationRemoteModel, contactZIP);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactCity() {
		return _contactCity;
	}

	@Override
	public void setContactCity(String contactCity) {
		_contactCity = contactCity;

		if (_contactInformationRemoteModel != null) {
			try {
				Class<?> clazz = _contactInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactCity", String.class);

				method.invoke(_contactInformationRemoteModel, contactCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getContactEmailMunged() {
		try {
			String methodName = "getContactEmailMunged";

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
	public java.lang.String getHtmlAddress() {
		try {
			String methodName = "getHtmlAddress";

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
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ContactInformation.class.getName()));
	}

	public BaseModel<?> getContactInformationRemoteModel() {
		return _contactInformationRemoteModel;
	}

	public void setContactInformationRemoteModel(
		BaseModel<?> contactInformationRemoteModel) {
		_contactInformationRemoteModel = contactInformationRemoteModel;
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

		Class<?> remoteModelClass = _contactInformationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contactInformationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactInformationLocalServiceUtil.addContactInformation(this);
		}
		else {
			ContactInformationLocalServiceUtil.updateContactInformation(this);
		}
	}

	@Override
	public ContactInformation toEscapedModel() {
		return (ContactInformation)ProxyUtil.newProxyInstance(ContactInformation.class.getClassLoader(),
			new Class[] { ContactInformation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactInformationClp clone = new ContactInformationClp();

		clone.setUuid(getUuid());
		clone.setContactinformationId(getContactinformationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUpdateuuid(getUpdateuuid());
		clone.setContactID(getContactID());
		clone.setContactEmail(getContactEmail());
		clone.setContactCountry(getContactCountry());
		clone.setContactFirstName(getContactFirstName());
		clone.setContactLastName(getContactLastName());
		clone.setContactPhone(getContactPhone());
		clone.setContactAddress(getContactAddress());
		clone.setContactZIP(getContactZIP());
		clone.setContactCity(getContactCity());

		return clone;
	}

	@Override
	public int compareTo(ContactInformation contactInformation) {
		long primaryKey = contactInformation.getPrimaryKey();

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

		if (!(obj instanceof ContactInformationClp)) {
			return false;
		}

		ContactInformationClp contactInformation = (ContactInformationClp)obj;

		long primaryKey = contactInformation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", contactinformationId=");
		sb.append(getContactinformationId());
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
		sb.append(", contactID=");
		sb.append(getContactID());
		sb.append(", contactEmail=");
		sb.append(getContactEmail());
		sb.append(", contactCountry=");
		sb.append(getContactCountry());
		sb.append(", contactFirstName=");
		sb.append(getContactFirstName());
		sb.append(", contactLastName=");
		sb.append(getContactLastName());
		sb.append(", contactPhone=");
		sb.append(getContactPhone());
		sb.append(", contactAddress=");
		sb.append(getContactAddress());
		sb.append(", contactZIP=");
		sb.append(getContactZIP());
		sb.append(", contactCity=");
		sb.append(getContactCity());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append(
			"at.meduni.liferay.portlet.bbmrieric.model.ContactInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactinformationId</column-name><column-value><![CDATA[");
		sb.append(getContactinformationId());
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
			"<column><column-name>contactID</column-name><column-value><![CDATA[");
		sb.append(getContactID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactEmail</column-name><column-value><![CDATA[");
		sb.append(getContactEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactCountry</column-name><column-value><![CDATA[");
		sb.append(getContactCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactFirstName</column-name><column-value><![CDATA[");
		sb.append(getContactFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactLastName</column-name><column-value><![CDATA[");
		sb.append(getContactLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPhone</column-name><column-value><![CDATA[");
		sb.append(getContactPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactAddress</column-name><column-value><![CDATA[");
		sb.append(getContactAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactZIP</column-name><column-value><![CDATA[");
		sb.append(getContactZIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactCity</column-name><column-value><![CDATA[");
		sb.append(getContactCity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _contactinformationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _contactInformationRemoteModel;
}