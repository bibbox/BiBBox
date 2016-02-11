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

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RDConnectEventNotification in entity cache.
 *
 * @author reihsr
 * @see RDConnectEventNotification
 * @generated
 */
public class RDConnectEventNotificationCacheModel implements CacheModel<RDConnectEventNotification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{eventnotificationId=");
		sb.append(eventnotificationId);
		sb.append(", notificationtype=");
		sb.append(notificationtype);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", notificationselected=");
		sb.append(notificationselected);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RDConnectEventNotification toEntityModel() {
		RDConnectEventNotificationImpl rdConnectEventNotificationImpl = new RDConnectEventNotificationImpl();

		rdConnectEventNotificationImpl.setEventnotificationId(eventnotificationId);

		if (notificationtype == null) {
			rdConnectEventNotificationImpl.setNotificationtype(StringPool.BLANK);
		}
		else {
			rdConnectEventNotificationImpl.setNotificationtype(notificationtype);
		}

		rdConnectEventNotificationImpl.setUserId(userId);
		rdConnectEventNotificationImpl.setNotificationselected(notificationselected);

		rdConnectEventNotificationImpl.resetOriginalValues();

		return rdConnectEventNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventnotificationId = objectInput.readLong();
		notificationtype = objectInput.readUTF();
		userId = objectInput.readLong();
		notificationselected = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventnotificationId);

		if (notificationtype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationtype);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeBoolean(notificationselected);
	}

	public long eventnotificationId;
	public String notificationtype;
	public long userId;
	public boolean notificationselected;
}