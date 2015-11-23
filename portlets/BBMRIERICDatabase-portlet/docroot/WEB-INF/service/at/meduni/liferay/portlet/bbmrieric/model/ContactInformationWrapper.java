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
 * This class is a wrapper for {@link ContactInformation}.
 * </p>
 *
 * @author reihsr
 * @see ContactInformation
 * @generated
 */
public class ContactInformationWrapper implements ContactInformation,
	ModelWrapper<ContactInformation> {
	public ContactInformationWrapper(ContactInformation contactInformation) {
		_contactInformation = contactInformation;
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

	/**
	* Returns the primary key of this contact information.
	*
	* @return the primary key of this contact information
	*/
	@Override
	public long getPrimaryKey() {
		return _contactInformation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact information.
	*
	* @param primaryKey the primary key of this contact information
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactInformation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this contact information.
	*
	* @return the uuid of this contact information
	*/
	@Override
	public java.lang.String getUuid() {
		return _contactInformation.getUuid();
	}

	/**
	* Sets the uuid of this contact information.
	*
	* @param uuid the uuid of this contact information
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_contactInformation.setUuid(uuid);
	}

	/**
	* Returns the contactinformation ID of this contact information.
	*
	* @return the contactinformation ID of this contact information
	*/
	@Override
	public long getContactinformationId() {
		return _contactInformation.getContactinformationId();
	}

	/**
	* Sets the contactinformation ID of this contact information.
	*
	* @param contactinformationId the contactinformation ID of this contact information
	*/
	@Override
	public void setContactinformationId(long contactinformationId) {
		_contactInformation.setContactinformationId(contactinformationId);
	}

	/**
	* Returns the company ID of this contact information.
	*
	* @return the company ID of this contact information
	*/
	@Override
	public long getCompanyId() {
		return _contactInformation.getCompanyId();
	}

	/**
	* Sets the company ID of this contact information.
	*
	* @param companyId the company ID of this contact information
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contactInformation.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this contact information.
	*
	* @return the group ID of this contact information
	*/
	@Override
	public long getGroupId() {
		return _contactInformation.getGroupId();
	}

	/**
	* Sets the group ID of this contact information.
	*
	* @param groupId the group ID of this contact information
	*/
	@Override
	public void setGroupId(long groupId) {
		_contactInformation.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this contact information.
	*
	* @return the user ID of this contact information
	*/
	@Override
	public long getUserId() {
		return _contactInformation.getUserId();
	}

	/**
	* Sets the user ID of this contact information.
	*
	* @param userId the user ID of this contact information
	*/
	@Override
	public void setUserId(long userId) {
		_contactInformation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contact information.
	*
	* @return the user uuid of this contact information
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactInformation.getUserUuid();
	}

	/**
	* Sets the user uuid of this contact information.
	*
	* @param userUuid the user uuid of this contact information
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_contactInformation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contact information.
	*
	* @return the user name of this contact information
	*/
	@Override
	public java.lang.String getUserName() {
		return _contactInformation.getUserName();
	}

	/**
	* Sets the user name of this contact information.
	*
	* @param userName the user name of this contact information
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_contactInformation.setUserName(userName);
	}

	/**
	* Returns the create date of this contact information.
	*
	* @return the create date of this contact information
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contactInformation.getCreateDate();
	}

	/**
	* Sets the create date of this contact information.
	*
	* @param createDate the create date of this contact information
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contactInformation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contact information.
	*
	* @return the modified date of this contact information
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contactInformation.getModifiedDate();
	}

	/**
	* Sets the modified date of this contact information.
	*
	* @param modifiedDate the modified date of this contact information
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactInformation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updateuuid of this contact information.
	*
	* @return the updateuuid of this contact information
	*/
	@Override
	public java.lang.String getUpdateuuid() {
		return _contactInformation.getUpdateuuid();
	}

	/**
	* Sets the updateuuid of this contact information.
	*
	* @param updateuuid the updateuuid of this contact information
	*/
	@Override
	public void setUpdateuuid(java.lang.String updateuuid) {
		_contactInformation.setUpdateuuid(updateuuid);
	}

	/**
	* Returns the contact i d of this contact information.
	*
	* @return the contact i d of this contact information
	*/
	@Override
	public java.lang.String getContactID() {
		return _contactInformation.getContactID();
	}

	/**
	* Sets the contact i d of this contact information.
	*
	* @param contactID the contact i d of this contact information
	*/
	@Override
	public void setContactID(java.lang.String contactID) {
		_contactInformation.setContactID(contactID);
	}

	/**
	* Returns the contact email of this contact information.
	*
	* @return the contact email of this contact information
	*/
	@Override
	public java.lang.String getContactEmail() {
		return _contactInformation.getContactEmail();
	}

	/**
	* Sets the contact email of this contact information.
	*
	* @param contactEmail the contact email of this contact information
	*/
	@Override
	public void setContactEmail(java.lang.String contactEmail) {
		_contactInformation.setContactEmail(contactEmail);
	}

	/**
	* Returns the contact country of this contact information.
	*
	* @return the contact country of this contact information
	*/
	@Override
	public java.lang.String getContactCountry() {
		return _contactInformation.getContactCountry();
	}

	/**
	* Sets the contact country of this contact information.
	*
	* @param contactCountry the contact country of this contact information
	*/
	@Override
	public void setContactCountry(java.lang.String contactCountry) {
		_contactInformation.setContactCountry(contactCountry);
	}

	/**
	* Returns the contact first name of this contact information.
	*
	* @return the contact first name of this contact information
	*/
	@Override
	public java.lang.String getContactFirstName() {
		return _contactInformation.getContactFirstName();
	}

	/**
	* Sets the contact first name of this contact information.
	*
	* @param contactFirstName the contact first name of this contact information
	*/
	@Override
	public void setContactFirstName(java.lang.String contactFirstName) {
		_contactInformation.setContactFirstName(contactFirstName);
	}

	/**
	* Returns the contact last name of this contact information.
	*
	* @return the contact last name of this contact information
	*/
	@Override
	public java.lang.String getContactLastName() {
		return _contactInformation.getContactLastName();
	}

	/**
	* Sets the contact last name of this contact information.
	*
	* @param contactLastName the contact last name of this contact information
	*/
	@Override
	public void setContactLastName(java.lang.String contactLastName) {
		_contactInformation.setContactLastName(contactLastName);
	}

	/**
	* Returns the contact phone of this contact information.
	*
	* @return the contact phone of this contact information
	*/
	@Override
	public java.lang.String getContactPhone() {
		return _contactInformation.getContactPhone();
	}

	/**
	* Sets the contact phone of this contact information.
	*
	* @param contactPhone the contact phone of this contact information
	*/
	@Override
	public void setContactPhone(java.lang.String contactPhone) {
		_contactInformation.setContactPhone(contactPhone);
	}

	/**
	* Returns the contact address of this contact information.
	*
	* @return the contact address of this contact information
	*/
	@Override
	public java.lang.String getContactAddress() {
		return _contactInformation.getContactAddress();
	}

	/**
	* Sets the contact address of this contact information.
	*
	* @param contactAddress the contact address of this contact information
	*/
	@Override
	public void setContactAddress(java.lang.String contactAddress) {
		_contactInformation.setContactAddress(contactAddress);
	}

	/**
	* Returns the contact z i p of this contact information.
	*
	* @return the contact z i p of this contact information
	*/
	@Override
	public java.lang.String getContactZIP() {
		return _contactInformation.getContactZIP();
	}

	/**
	* Sets the contact z i p of this contact information.
	*
	* @param contactZIP the contact z i p of this contact information
	*/
	@Override
	public void setContactZIP(java.lang.String contactZIP) {
		_contactInformation.setContactZIP(contactZIP);
	}

	/**
	* Returns the contact city of this contact information.
	*
	* @return the contact city of this contact information
	*/
	@Override
	public java.lang.String getContactCity() {
		return _contactInformation.getContactCity();
	}

	/**
	* Sets the contact city of this contact information.
	*
	* @param contactCity the contact city of this contact information
	*/
	@Override
	public void setContactCity(java.lang.String contactCity) {
		_contactInformation.setContactCity(contactCity);
	}

	@Override
	public boolean isNew() {
		return _contactInformation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactInformation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactInformation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactInformation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactInformation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactInformation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactInformation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactInformation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactInformation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactInformation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactInformation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactInformationWrapper((ContactInformation)_contactInformation.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformation) {
		return _contactInformation.compareTo(contactInformation);
	}

	@Override
	public int hashCode() {
		return _contactInformation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.ContactInformation> toCacheModel() {
		return _contactInformation.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation toEscapedModel() {
		return new ContactInformationWrapper(_contactInformation.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.ContactInformation toUnescapedModel() {
		return new ContactInformationWrapper(_contactInformation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactInformation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactInformation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactInformation.persist();
	}

	@Override
	public java.lang.String getHtmlAddress() {
		return _contactInformation.getHtmlAddress();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactInformationWrapper)) {
			return false;
		}

		ContactInformationWrapper contactInformationWrapper = (ContactInformationWrapper)obj;

		if (Validator.equals(_contactInformation,
					contactInformationWrapper._contactInformation)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _contactInformation.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactInformation getWrappedContactInformation() {
		return _contactInformation;
	}

	@Override
	public ContactInformation getWrappedModel() {
		return _contactInformation;
	}

	@Override
	public void resetOriginalValues() {
		_contactInformation.resetOriginalValues();
	}

	private ContactInformation _contactInformation;
}