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

package at.graz.meduni.liferay.model.impl;

import at.graz.meduni.liferay.model.ICDO3;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ICDO3 in entity cache.
 *
 * @author reihsr
 * @see ICDO3
 * @generated
 */
public class ICDO3CacheModel implements CacheModel<ICDO3>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", code=");
		sb.append(code);
		sb.append(", term=");
		sb.append(term);
		sb.append(", sui=");
		sb.append(sui);
		sb.append(", typ=");
		sb.append(typ);
		sb.append(", use=");
		sb.append(use);
		sb.append(", description=");
		sb.append(description);
		sb.append(", localisation=");
		sb.append(localisation);
		sb.append(", link=");
		sb.append(link);
		sb.append(", exklusiva=");
		sb.append(exklusiva);
		sb.append(", hint=");
		sb.append(hint);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ICDO3 toEntityModel() {
		ICDO3Impl icdo3Impl = new ICDO3Impl();

		icdo3Impl.setId(id);

		if (code == null) {
			icdo3Impl.setCode(StringPool.BLANK);
		}
		else {
			icdo3Impl.setCode(code);
		}

		icdo3Impl.setTerm(term);
		icdo3Impl.setSui(sui);

		if (typ == null) {
			icdo3Impl.setTyp(StringPool.BLANK);
		}
		else {
			icdo3Impl.setTyp(typ);
		}

		if (use == null) {
			icdo3Impl.setUse(StringPool.BLANK);
		}
		else {
			icdo3Impl.setUse(use);
		}

		if (description == null) {
			icdo3Impl.setDescription(StringPool.BLANK);
		}
		else {
			icdo3Impl.setDescription(description);
		}

		if (localisation == null) {
			icdo3Impl.setLocalisation(StringPool.BLANK);
		}
		else {
			icdo3Impl.setLocalisation(localisation);
		}

		if (link == null) {
			icdo3Impl.setLink(StringPool.BLANK);
		}
		else {
			icdo3Impl.setLink(link);
		}

		if (exklusiva == null) {
			icdo3Impl.setExklusiva(StringPool.BLANK);
		}
		else {
			icdo3Impl.setExklusiva(exklusiva);
		}

		if (hint == null) {
			icdo3Impl.setHint(StringPool.BLANK);
		}
		else {
			icdo3Impl.setHint(hint);
		}

		icdo3Impl.resetOriginalValues();

		return icdo3Impl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		code = objectInput.readUTF();
		term = objectInput.readInt();
		sui = objectInput.readInt();
		typ = objectInput.readUTF();
		use = objectInput.readUTF();
		description = objectInput.readUTF();
		localisation = objectInput.readUTF();
		link = objectInput.readUTF();
		exklusiva = objectInput.readUTF();
		hint = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(term);
		objectOutput.writeInt(sui);

		if (typ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typ);
		}

		if (use == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(use);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (localisation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localisation);
		}

		if (link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (exklusiva == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(exklusiva);
		}

		if (hint == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hint);
		}
	}

	public long id;
	public String code;
	public int term;
	public int sui;
	public String typ;
	public String use;
	public String description;
	public String localisation;
	public String link;
	public String exklusiva;
	public String hint;
}