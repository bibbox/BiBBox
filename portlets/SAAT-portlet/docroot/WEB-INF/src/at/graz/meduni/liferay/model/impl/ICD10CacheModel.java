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

import at.graz.meduni.liferay.model.ICD10;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ICD10 in entity cache.
 *
 * @author reihsr
 * @see ICD10
 * @generated
 */
public class ICD10CacheModel implements CacheModel<ICD10>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", code=");
		sb.append(code);
		sb.append(", description=");
		sb.append(description);
		sb.append(", INKLUSIVA=");
		sb.append(INKLUSIVA);
		sb.append(", EXKLUSIVA=");
		sb.append(EXKLUSIVA);
		sb.append(", TYPE=");
		sb.append(TYPE);
		sb.append(", USED=");
		sb.append(USED);
		sb.append(", FROM_CODE=");
		sb.append(FROM_CODE);
		sb.append(", TO_CODE=");
		sb.append(TO_CODE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ICD10 toEntityModel() {
		ICD10Impl icd10Impl = new ICD10Impl();

		icd10Impl.setId(id);

		if (code == null) {
			icd10Impl.setCode(StringPool.BLANK);
		}
		else {
			icd10Impl.setCode(code);
		}

		if (description == null) {
			icd10Impl.setDescription(StringPool.BLANK);
		}
		else {
			icd10Impl.setDescription(description);
		}

		if (INKLUSIVA == null) {
			icd10Impl.setINKLUSIVA(StringPool.BLANK);
		}
		else {
			icd10Impl.setINKLUSIVA(INKLUSIVA);
		}

		if (EXKLUSIVA == null) {
			icd10Impl.setEXKLUSIVA(StringPool.BLANK);
		}
		else {
			icd10Impl.setEXKLUSIVA(EXKLUSIVA);
		}

		if (TYPE == null) {
			icd10Impl.setTYPE(StringPool.BLANK);
		}
		else {
			icd10Impl.setTYPE(TYPE);
		}

		icd10Impl.setUSED(USED);

		if (FROM_CODE == null) {
			icd10Impl.setFROM_CODE(StringPool.BLANK);
		}
		else {
			icd10Impl.setFROM_CODE(FROM_CODE);
		}

		if (TO_CODE == null) {
			icd10Impl.setTO_CODE(StringPool.BLANK);
		}
		else {
			icd10Impl.setTO_CODE(TO_CODE);
		}

		icd10Impl.resetOriginalValues();

		return icd10Impl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		INKLUSIVA = objectInput.readUTF();
		EXKLUSIVA = objectInput.readUTF();
		TYPE = objectInput.readUTF();
		USED = objectInput.readDouble();
		FROM_CODE = objectInput.readUTF();
		TO_CODE = objectInput.readUTF();
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (INKLUSIVA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(INKLUSIVA);
		}

		if (EXKLUSIVA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(EXKLUSIVA);
		}

		if (TYPE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TYPE);
		}

		objectOutput.writeDouble(USED);

		if (FROM_CODE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(FROM_CODE);
		}

		if (TO_CODE == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TO_CODE);
		}
	}

	public long id;
	public String code;
	public String description;
	public String INKLUSIVA;
	public String EXKLUSIVA;
	public String TYPE;
	public double USED;
	public String FROM_CODE;
	public String TO_CODE;
}