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

package at.graz.meduni.liferay.portlet.bibbox.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InvitationOrganisation in entity cache.
 *
 * @author reihsr
 * @see InvitationOrganisation
 * @generated
 */
public class InvitationOrganisationCacheModel implements CacheModel<InvitationOrganisation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{invitationOrganisationId=");
		sb.append(invitationOrganisationId);
		sb.append(", invitationId=");
		sb.append(invitationId);
		sb.append(", organisationId=");
		sb.append(organisationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", lastchanged=");
		sb.append(lastchanged);
		sb.append(", lastchanger=");
		sb.append(lastchanger);
		sb.append(", reactdate=");
		sb.append(reactdate);
		sb.append(", lastusedlink=");
		sb.append(lastusedlink);
		sb.append(", rejectdate=");
		sb.append(rejectdate);
		sb.append(", securitylinktoken=");
		sb.append(securitylinktoken);
		sb.append(", securitytoken=");
		sb.append(securitytoken);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusdate=");
		sb.append(statusdate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InvitationOrganisation toEntityModel() {
		InvitationOrganisationImpl invitationOrganisationImpl = new InvitationOrganisationImpl();

		invitationOrganisationImpl.setInvitationOrganisationId(invitationOrganisationId);
		invitationOrganisationImpl.setInvitationId(invitationId);
		invitationOrganisationImpl.setOrganisationId(organisationId);
		invitationOrganisationImpl.setUserId(userId);

		if (lastchanged == Long.MIN_VALUE) {
			invitationOrganisationImpl.setLastchanged(null);
		}
		else {
			invitationOrganisationImpl.setLastchanged(new Date(lastchanged));
		}

		invitationOrganisationImpl.setLastchanger(lastchanger);

		if (reactdate == Long.MIN_VALUE) {
			invitationOrganisationImpl.setReactdate(null);
		}
		else {
			invitationOrganisationImpl.setReactdate(new Date(reactdate));
		}

		if (lastusedlink == Long.MIN_VALUE) {
			invitationOrganisationImpl.setLastusedlink(null);
		}
		else {
			invitationOrganisationImpl.setLastusedlink(new Date(lastusedlink));
		}

		if (rejectdate == Long.MIN_VALUE) {
			invitationOrganisationImpl.setRejectdate(null);
		}
		else {
			invitationOrganisationImpl.setRejectdate(new Date(rejectdate));
		}

		invitationOrganisationImpl.setSecuritylinktoken(securitylinktoken);
		invitationOrganisationImpl.setSecuritytoken(securitytoken);
		invitationOrganisationImpl.setStatus(status);

		if (statusdate == Long.MIN_VALUE) {
			invitationOrganisationImpl.setStatusdate(null);
		}
		else {
			invitationOrganisationImpl.setStatusdate(new Date(statusdate));
		}

		invitationOrganisationImpl.resetOriginalValues();

		return invitationOrganisationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		invitationOrganisationId = objectInput.readLong();
		invitationId = objectInput.readLong();
		organisationId = objectInput.readLong();
		userId = objectInput.readLong();
		lastchanged = objectInput.readLong();
		lastchanger = objectInput.readLong();
		reactdate = objectInput.readLong();
		lastusedlink = objectInput.readLong();
		rejectdate = objectInput.readLong();
		securitylinktoken = objectInput.readLong();
		securitytoken = objectInput.readLong();
		status = objectInput.readLong();
		statusdate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(invitationOrganisationId);
		objectOutput.writeLong(invitationId);
		objectOutput.writeLong(organisationId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(lastchanged);
		objectOutput.writeLong(lastchanger);
		objectOutput.writeLong(reactdate);
		objectOutput.writeLong(lastusedlink);
		objectOutput.writeLong(rejectdate);
		objectOutput.writeLong(securitylinktoken);
		objectOutput.writeLong(securitytoken);
		objectOutput.writeLong(status);
		objectOutput.writeLong(statusdate);
	}

	public long invitationOrganisationId;
	public long invitationId;
	public long organisationId;
	public long userId;
	public long lastchanged;
	public long lastchanger;
	public long reactdate;
	public long lastusedlink;
	public long rejectdate;
	public long securitylinktoken;
	public long securitytoken;
	public long status;
	public long statusdate;
}