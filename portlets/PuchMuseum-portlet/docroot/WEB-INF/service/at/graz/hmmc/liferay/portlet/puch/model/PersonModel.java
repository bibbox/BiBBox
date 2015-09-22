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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Person service. Represents a row in the &quot;puchmuseum_person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonImpl}.
 * </p>
 *
 * @author reihsr
 * @see Person
 * @see at.graz.hmmc.liferay.portlet.puch.model.impl.PersonImpl
 * @see at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl
 * @generated
 */
public interface PersonModel extends BaseModel<Person> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a person model instance should use the {@link Person} interface instead.
	 */

	/**
	 * Returns the primary key of this person.
	 *
	 * @return the primary key of this person
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this person.
	 *
	 * @param primaryKey the primary key of this person
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the person ID of this person.
	 *
	 * @return the person ID of this person
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this person.
	 *
	 * @param personId the person ID of this person
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the creater user ID of this person.
	 *
	 * @return the creater user ID of this person
	 */
	public long getCreaterUserId();

	/**
	 * Sets the creater user ID of this person.
	 *
	 * @param createrUserId the creater user ID of this person
	 */
	public void setCreaterUserId(long createrUserId);

	/**
	 * Returns the creater user uuid of this person.
	 *
	 * @return the creater user uuid of this person
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreaterUserUuid() throws SystemException;

	/**
	 * Sets the creater user uuid of this person.
	 *
	 * @param createrUserUuid the creater user uuid of this person
	 */
	public void setCreaterUserUuid(String createrUserUuid);

	/**
	 * Returns the create date of this person.
	 *
	 * @return the create date of this person
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this person.
	 *
	 * @param createDate the create date of this person
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified user ID of this person.
	 *
	 * @return the modified user ID of this person
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this person.
	 *
	 * @param modifiedUserId the modified user ID of this person
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this person.
	 *
	 * @return the modified user uuid of this person
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this person.
	 *
	 * @param modifiedUserUuid the modified user uuid of this person
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the modified date of this person.
	 *
	 * @return the modified date of this person
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this person.
	 *
	 * @param modifiedDate the modified date of this person
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the vorname of this person.
	 *
	 * @return the vorname of this person
	 */
	@AutoEscape
	public String getVorname();

	/**
	 * Sets the vorname of this person.
	 *
	 * @param vorname the vorname of this person
	 */
	public void setVorname(String vorname);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Person person);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Person> toCacheModel();

	@Override
	public Person toEscapedModel();

	@Override
	public Person toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}