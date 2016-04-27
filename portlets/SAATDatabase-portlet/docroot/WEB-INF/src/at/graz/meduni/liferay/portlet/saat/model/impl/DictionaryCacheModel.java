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

package at.graz.meduni.liferay.portlet.saat.model.impl;

import at.graz.meduni.liferay.portlet.saat.model.Dictionary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Dictionary in entity cache.
 *
 * @author reihsr
 * @see Dictionary
 * @generated
 */
public class DictionaryCacheModel implements CacheModel<Dictionary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{dictionaryId=");
		sb.append(dictionaryId);
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append(", before_synonym=");
		sb.append(before_synonym);
		sb.append(", after_synonym=");
		sb.append(after_synonym);
		sb.append(", foreword=");
		sb.append(foreword);
		sb.append(", ending=");
		sb.append(ending);
		sb.append(", sentence=");
		sb.append(sentence);
		sb.append(", iscode=");
		sb.append(iscode);
		sb.append(", pattern=");
		sb.append(pattern);
		sb.append(", code_typ=");
		sb.append(code_typ);
		sb.append(", code_value=");
		sb.append(code_value);
		sb.append(", root=");
		sb.append(root);
		sb.append(", negation=");
		sb.append(negation);
		sb.append(", occur=");
		sb.append(occur);
		sb.append(", disease_ids=");
		sb.append(disease_ids);
		sb.append(", dirty=");
		sb.append(dirty);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", disease_ids_count=");
		sb.append(disease_ids_count);
		sb.append(", priority_mode=");
		sb.append(priority_mode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dictionary toEntityModel() {
		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setDictionaryId(dictionaryId);

		if (synonym == null) {
			dictionaryImpl.setSynonym(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setSynonym(synonym);
		}

		dictionaryImpl.setBefore_synonym(before_synonym);
		dictionaryImpl.setAfter_synonym(after_synonym);
		dictionaryImpl.setForeword(foreword);
		dictionaryImpl.setEnding(ending);
		dictionaryImpl.setSentence(sentence);
		dictionaryImpl.setIscode(iscode);

		if (pattern == null) {
			dictionaryImpl.setPattern(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setPattern(pattern);
		}

		if (code_typ == null) {
			dictionaryImpl.setCode_typ(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCode_typ(code_typ);
		}

		if (code_value == null) {
			dictionaryImpl.setCode_value(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCode_value(code_value);
		}

		dictionaryImpl.setRoot(root);
		dictionaryImpl.setNegation(negation);
		dictionaryImpl.setOccur(occur);

		if (disease_ids == null) {
			dictionaryImpl.setDisease_ids(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setDisease_ids(disease_ids);
		}

		dictionaryImpl.setDirty(dirty);
		dictionaryImpl.setPriority(priority);
		dictionaryImpl.setDisease_ids_count(disease_ids_count);
		dictionaryImpl.setPriority_mode(priority_mode);

		dictionaryImpl.resetOriginalValues();

		return dictionaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictionaryId = objectInput.readLong();
		synonym = objectInput.readUTF();
		before_synonym = objectInput.readInt();
		after_synonym = objectInput.readInt();
		foreword = objectInput.readBoolean();
		ending = objectInput.readBoolean();
		sentence = objectInput.readBoolean();
		iscode = objectInput.readBoolean();
		pattern = objectInput.readUTF();
		code_typ = objectInput.readUTF();
		code_value = objectInput.readUTF();
		root = objectInput.readBoolean();
		negation = objectInput.readBoolean();
		occur = objectInput.readBoolean();
		disease_ids = objectInput.readUTF();
		dirty = objectInput.readBoolean();
		priority = objectInput.readInt();
		disease_ids_count = objectInput.readInt();
		priority_mode = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictionaryId);

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}

		objectOutput.writeInt(before_synonym);
		objectOutput.writeInt(after_synonym);
		objectOutput.writeBoolean(foreword);
		objectOutput.writeBoolean(ending);
		objectOutput.writeBoolean(sentence);
		objectOutput.writeBoolean(iscode);

		if (pattern == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pattern);
		}

		if (code_typ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code_typ);
		}

		if (code_value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code_value);
		}

		objectOutput.writeBoolean(root);
		objectOutput.writeBoolean(negation);
		objectOutput.writeBoolean(occur);

		if (disease_ids == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disease_ids);
		}

		objectOutput.writeBoolean(dirty);
		objectOutput.writeInt(priority);
		objectOutput.writeInt(disease_ids_count);
		objectOutput.writeBoolean(priority_mode);
	}

	public long dictionaryId;
	public String synonym;
	public int before_synonym;
	public int after_synonym;
	public boolean foreword;
	public boolean ending;
	public boolean sentence;
	public boolean iscode;
	public String pattern;
	public String code_typ;
	public String code_value;
	public boolean root;
	public boolean negation;
	public boolean occur;
	public String disease_ids;
	public boolean dirty;
	public int priority;
	public int disease_ids_count;
	public boolean priority_mode;
}