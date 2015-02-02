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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RDConnectEvent in entity cache.
 *
 * @author reihsr
 * @see RDConnectEvent
 * @generated
 */
public class RDConnectEventCacheModel implements CacheModel<RDConnectEvent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", eventdate=");
		sb.append(eventdate);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", shorttext=");
		sb.append(shorttext);
		sb.append(", longtext=");
		sb.append(longtext);
		sb.append(", link=");
		sb.append(link);
		sb.append(", restricted=");
		sb.append(restricted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RDConnectEvent toEntityModel() {
		RDConnectEventImpl rdConnectEventImpl = new RDConnectEventImpl();

		rdConnectEventImpl.setEventId(eventId);

		if (eventdate == Long.MIN_VALUE) {
			rdConnectEventImpl.setEventdate(null);
		}
		else {
			rdConnectEventImpl.setEventdate(new Date(eventdate));
		}

		rdConnectEventImpl.setOrganizationId(organizationId);
		rdConnectEventImpl.setUserId(userId);

		if (shorttext == null) {
			rdConnectEventImpl.setShorttext(StringPool.BLANK);
		}
		else {
			rdConnectEventImpl.setShorttext(shorttext);
		}

		if (longtext == null) {
			rdConnectEventImpl.setLongtext(StringPool.BLANK);
		}
		else {
			rdConnectEventImpl.setLongtext(longtext);
		}

		if (link == null) {
			rdConnectEventImpl.setLink(StringPool.BLANK);
		}
		else {
			rdConnectEventImpl.setLink(link);
		}

		if (restricted == null) {
			rdConnectEventImpl.setRestricted(StringPool.BLANK);
		}
		else {
			rdConnectEventImpl.setRestricted(restricted);
		}

		rdConnectEventImpl.resetOriginalValues();

		return rdConnectEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();
		eventdate = objectInput.readLong();
		organizationId = objectInput.readLong();
		userId = objectInput.readLong();
		shorttext = objectInput.readUTF();
		longtext = objectInput.readUTF();
		link = objectInput.readUTF();
		restricted = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(eventdate);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(userId);

		if (shorttext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shorttext);
		}

		if (longtext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longtext);
		}

		if (link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (restricted == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(restricted);
		}
	}

	public long eventId;
	public long eventdate;
	public long organizationId;
	public long userId;
	public String shorttext;
	public String longtext;
	public String link;
	public String restricted;
}