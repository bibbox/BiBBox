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

package at.graz.hmmc.liferay.portlet.puch.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Person}.
 * </p>
 *
 * @author reihsr
 * @see Person
 * @generated
 */
public class PersonWrapper implements Person, ModelWrapper<Person> {
	public PersonWrapper(Person person) {
		_person = person;
	}

	@Override
	public Class<?> getModelClass() {
		return Person.class;
	}

	@Override
	public String getModelClassName() {
		return Person.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("personId", getPersonId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("vorname", getVorname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		Long createrUserId = (Long)attributes.get("createrUserId");

		if (createrUserId != null) {
			setCreaterUserId(createrUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String vorname = (String)attributes.get("vorname");

		if (vorname != null) {
			setVorname(vorname);
		}
	}

	/**
	* Returns the primary key of this person.
	*
	* @return the primary key of this person
	*/
	@Override
	public long getPrimaryKey() {
		return _person.getPrimaryKey();
	}

	/**
	* Sets the primary key of this person.
	*
	* @param primaryKey the primary key of this person
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_person.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the person ID of this person.
	*
	* @return the person ID of this person
	*/
	@Override
	public long getPersonId() {
		return _person.getPersonId();
	}

	/**
	* Sets the person ID of this person.
	*
	* @param personId the person ID of this person
	*/
	@Override
	public void setPersonId(long personId) {
		_person.setPersonId(personId);
	}

	/**
	* Returns the creater user ID of this person.
	*
	* @return the creater user ID of this person
	*/
	@Override
	public long getCreaterUserId() {
		return _person.getCreaterUserId();
	}

	/**
	* Sets the creater user ID of this person.
	*
	* @param createrUserId the creater user ID of this person
	*/
	@Override
	public void setCreaterUserId(long createrUserId) {
		_person.setCreaterUserId(createrUserId);
	}

	/**
	* Returns the creater user uuid of this person.
	*
	* @return the creater user uuid of this person
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreaterUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _person.getCreaterUserUuid();
	}

	/**
	* Sets the creater user uuid of this person.
	*
	* @param createrUserUuid the creater user uuid of this person
	*/
	@Override
	public void setCreaterUserUuid(java.lang.String createrUserUuid) {
		_person.setCreaterUserUuid(createrUserUuid);
	}

	/**
	* Returns the create date of this person.
	*
	* @return the create date of this person
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _person.getCreateDate();
	}

	/**
	* Sets the create date of this person.
	*
	* @param createDate the create date of this person
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_person.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this person.
	*
	* @return the modified user ID of this person
	*/
	@Override
	public long getModifiedUserId() {
		return _person.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this person.
	*
	* @param modifiedUserId the modified user ID of this person
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_person.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this person.
	*
	* @return the modified user uuid of this person
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _person.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this person.
	*
	* @param modifiedUserUuid the modified user uuid of this person
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_person.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified date of this person.
	*
	* @return the modified date of this person
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _person.getModifiedDate();
	}

	/**
	* Sets the modified date of this person.
	*
	* @param modifiedDate the modified date of this person
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_person.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the vorname of this person.
	*
	* @return the vorname of this person
	*/
	@Override
	public java.lang.String getVorname() {
		return _person.getVorname();
	}

	/**
	* Sets the vorname of this person.
	*
	* @param vorname the vorname of this person
	*/
	@Override
	public void setVorname(java.lang.String vorname) {
		_person.setVorname(vorname);
	}

	@Override
	public boolean isNew() {
		return _person.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_person.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _person.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_person.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _person.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _person.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_person.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _person.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_person.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_person.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_person.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PersonWrapper((Person)_person.clone());
	}

	@Override
	public int compareTo(at.graz.hmmc.liferay.portlet.puch.model.Person person) {
		return _person.compareTo(person);
	}

	@Override
	public int hashCode() {
		return _person.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.Person> toCacheModel() {
		return _person.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Person toEscapedModel() {
		return new PersonWrapper(_person.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Person toUnescapedModel() {
		return new PersonWrapper(_person.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _person.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _person.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_person.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonWrapper)) {
			return false;
		}

		PersonWrapper personWrapper = (PersonWrapper)obj;

		if (Validator.equals(_person, personWrapper._person)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Person getWrappedPerson() {
		return _person;
	}

	@Override
	public Person getWrappedModel() {
		return _person;
	}

	@Override
	public void resetOriginalValues() {
		_person.resetOriginalValues();
	}

	private Person _person;
}