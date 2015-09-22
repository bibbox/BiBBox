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
 * The base model interface for the Fahrzeug service. Represents a row in the &quot;puchmuseum.fahrzeug&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugImpl}.
 * </p>
 *
 * @author reihsr
 * @see Fahrzeug
 * @see at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugImpl
 * @see at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl
 * @generated
 */
public interface FahrzeugModel extends BaseModel<Fahrzeug> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fahrzeug model instance should use the {@link Fahrzeug} interface instead.
	 */

	/**
	 * Returns the primary key of this fahrzeug.
	 *
	 * @return the primary key of this fahrzeug
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fahrzeug.
	 *
	 * @param primaryKey the primary key of this fahrzeug
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fahrzeug ID of this fahrzeug.
	 *
	 * @return the fahrzeug ID of this fahrzeug
	 */
	public long getFahrzeugId();

	/**
	 * Sets the fahrzeug ID of this fahrzeug.
	 *
	 * @param fahrzeugId the fahrzeug ID of this fahrzeug
	 */
	public void setFahrzeugId(long fahrzeugId);

	/**
	 * Returns the creater user ID of this fahrzeug.
	 *
	 * @return the creater user ID of this fahrzeug
	 */
	public long getCreaterUserId();

	/**
	 * Sets the creater user ID of this fahrzeug.
	 *
	 * @param createrUserId the creater user ID of this fahrzeug
	 */
	public void setCreaterUserId(long createrUserId);

	/**
	 * Returns the creater user uuid of this fahrzeug.
	 *
	 * @return the creater user uuid of this fahrzeug
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreaterUserUuid() throws SystemException;

	/**
	 * Sets the creater user uuid of this fahrzeug.
	 *
	 * @param createrUserUuid the creater user uuid of this fahrzeug
	 */
	public void setCreaterUserUuid(String createrUserUuid);

	/**
	 * Returns the create date of this fahrzeug.
	 *
	 * @return the create date of this fahrzeug
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fahrzeug.
	 *
	 * @param createDate the create date of this fahrzeug
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified user ID of this fahrzeug.
	 *
	 * @return the modified user ID of this fahrzeug
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this fahrzeug.
	 *
	 * @param modifiedUserId the modified user ID of this fahrzeug
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this fahrzeug.
	 *
	 * @return the modified user uuid of this fahrzeug
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this fahrzeug.
	 *
	 * @param modifiedUserUuid the modified user uuid of this fahrzeug
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the modified date of this fahrzeug.
	 *
	 * @return the modified date of this fahrzeug
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fahrzeug.
	 *
	 * @param modifiedDate the modified date of this fahrzeug
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the typ of this fahrzeug.
	 *
	 * @return the typ of this fahrzeug
	 */
	@AutoEscape
	public String getTyp();

	/**
	 * Sets the typ of this fahrzeug.
	 *
	 * @param typ the typ of this fahrzeug
	 */
	public void setTyp(String typ);

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
	public int compareTo(Fahrzeug fahrzeug);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Fahrzeug> toCacheModel();

	@Override
	public Fahrzeug toEscapedModel();

	@Override
	public Fahrzeug toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}