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

import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Invitation in entity cache.
 *
 * @author reihsr
 * @see Invitation
 * @generated
 */
public class InvitationCacheModel implements CacheModel<Invitation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{invitationId=");
		sb.append(invitationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", status=");
		sb.append(status);
		sb.append(", lastchanged=");
		sb.append(lastchanged);
		sb.append(", lastchanger=");
		sb.append(lastchanger);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Invitation toEntityModel() {
		InvitationImpl invitationImpl = new InvitationImpl();

		invitationImpl.setInvitationId(invitationId);

		if (name == null) {
			invitationImpl.setName(StringPool.BLANK);
		}
		else {
			invitationImpl.setName(name);
		}

		if (subject == null) {
			invitationImpl.setSubject(StringPool.BLANK);
		}
		else {
			invitationImpl.setSubject(subject);
		}

		if (body == null) {
			invitationImpl.setBody(StringPool.BLANK);
		}
		else {
			invitationImpl.setBody(body);
		}

		invitationImpl.setStatus(status);

		if (lastchanged == Long.MIN_VALUE) {
			invitationImpl.setLastchanged(null);
		}
		else {
			invitationImpl.setLastchanged(new Date(lastchanged));
		}

		invitationImpl.setLastchanger(lastchanger);

		invitationImpl.resetOriginalValues();

		return invitationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		invitationId = objectInput.readLong();
		name = objectInput.readUTF();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		status = objectInput.readLong();
		lastchanged = objectInput.readLong();
		lastchanger = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(invitationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		objectOutput.writeLong(status);
		objectOutput.writeLong(lastchanged);
		objectOutput.writeLong(lastchanger);
	}

	public long invitationId;
	public String name;
	public String subject;
	public String body;
	public long status;
	public long lastchanged;
	public long lastchanger;
}