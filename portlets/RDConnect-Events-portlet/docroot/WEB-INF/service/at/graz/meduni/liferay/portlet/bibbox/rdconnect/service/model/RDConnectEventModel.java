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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RDConnectEvent service. Represents a row in the &quot;rdconnect.event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventImpl}.
 * </p>
 *
 * @author reihsr
 * @see RDConnectEvent
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl
 * @generated
 */
public interface RDConnectEventModel extends BaseModel<RDConnectEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a r d connect event model instance should use the {@link RDConnectEvent} interface instead.
	 */

	/**
	 * Returns the primary key of this r d connect event.
	 *
	 * @return the primary key of this r d connect event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this r d connect event.
	 *
	 * @param primaryKey the primary key of this r d connect event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event ID of this r d connect event.
	 *
	 * @return the event ID of this r d connect event
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this r d connect event.
	 *
	 * @param eventId the event ID of this r d connect event
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the eventdate of this r d connect event.
	 *
	 * @return the eventdate of this r d connect event
	 */
	public Date getEventdate();

	/**
	 * Sets the eventdate of this r d connect event.
	 *
	 * @param eventdate the eventdate of this r d connect event
	 */
	public void setEventdate(Date eventdate);

	/**
	 * Returns the organization ID of this r d connect event.
	 *
	 * @return the organization ID of this r d connect event
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this r d connect event.
	 *
	 * @param organizationId the organization ID of this r d connect event
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the user ID of this r d connect event.
	 *
	 * @return the user ID of this r d connect event
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this r d connect event.
	 *
	 * @param userId the user ID of this r d connect event
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this r d connect event.
	 *
	 * @return the user uuid of this r d connect event
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this r d connect event.
	 *
	 * @param userUuid the user uuid of this r d connect event
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the shorttext of this r d connect event.
	 *
	 * @return the shorttext of this r d connect event
	 */
	@AutoEscape
	public String getShorttext();

	/**
	 * Sets the shorttext of this r d connect event.
	 *
	 * @param shorttext the shorttext of this r d connect event
	 */
	public void setShorttext(String shorttext);

	/**
	 * Returns the longtext of this r d connect event.
	 *
	 * @return the longtext of this r d connect event
	 */
	@AutoEscape
	public String getLongtext();

	/**
	 * Sets the longtext of this r d connect event.
	 *
	 * @param longtext the longtext of this r d connect event
	 */
	public void setLongtext(String longtext);

	/**
	 * Returns the link of this r d connect event.
	 *
	 * @return the link of this r d connect event
	 */
	@AutoEscape
	public String getLink();

	/**
	 * Sets the link of this r d connect event.
	 *
	 * @param link the link of this r d connect event
	 */
	public void setLink(String link);

	/**
	 * Returns the restricted of this r d connect event.
	 *
	 * @return the restricted of this r d connect event
	 */
	@AutoEscape
	public String getRestricted();

	/**
	 * Sets the restricted of this r d connect event.
	 *
	 * @param restricted the restricted of this r d connect event
	 */
	public void setRestricted(String restricted);

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
	public int compareTo(RDConnectEvent rdConnectEvent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<RDConnectEvent> toCacheModel();

	@Override
	public RDConnectEvent toEscapedModel();

	@Override
	public RDConnectEvent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}