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

package at.rdconnect.update.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AccessibilityUpdate service. Represents a row in the &quot;rdconnect.u_accessibility&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.rdconnect.update.model.impl.AccessibilityUpdateImpl}.
 * </p>
 *
 * @author reihsr
 * @see AccessibilityUpdate
 * @see at.rdconnect.update.model.impl.AccessibilityUpdateImpl
 * @see at.rdconnect.update.model.impl.AccessibilityUpdateModelImpl
 * @generated
 */
public interface AccessibilityUpdateModel extends BaseModel<AccessibilityUpdate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a accessibility update model instance should use the {@link AccessibilityUpdate} interface instead.
	 */

	/**
	 * Returns the primary key of this accessibility update.
	 *
	 * @return the primary key of this accessibility update
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this accessibility update.
	 *
	 * @param primaryKey the primary key of this accessibility update
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the coreid of this accessibility update.
	 *
	 * @return the coreid of this accessibility update
	 */
	public long getCoreid();

	/**
	 * Sets the coreid of this accessibility update.
	 *
	 * @param coreid the coreid of this accessibility update
	 */
	public void setCoreid(long coreid);

	/**
	 * Returns the organizationid of this accessibility update.
	 *
	 * @return the organizationid of this accessibility update
	 */
	public long getOrganizationid();

	/**
	 * Sets the organizationid of this accessibility update.
	 *
	 * @param organizationid the organizationid of this accessibility update
	 */
	public void setOrganizationid(long organizationid);

	/**
	 * Returns the fieldname of this accessibility update.
	 *
	 * @return the fieldname of this accessibility update
	 */
	@AutoEscape
	public String getFieldname();

	/**
	 * Sets the fieldname of this accessibility update.
	 *
	 * @param fieldname the fieldname of this accessibility update
	 */
	public void setFieldname(String fieldname);

	/**
	 * Returns the value of this accessibility update.
	 *
	 * @return the value of this accessibility update
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this accessibility update.
	 *
	 * @param value the value of this accessibility update
	 */
	public void setValue(String value);

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
	public int compareTo(AccessibilityUpdate accessibilityUpdate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AccessibilityUpdate> toCacheModel();

	@Override
	public AccessibilityUpdate toEscapedModel();

	@Override
	public AccessibilityUpdate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}