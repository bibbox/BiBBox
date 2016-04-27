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

import at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DictionaryDictionaryLink in entity cache.
 *
 * @author reihsr
 * @see DictionaryDictionaryLink
 * @generated
 */
public class DictionaryDictionaryLinkCacheModel implements CacheModel<DictionaryDictionaryLink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{dictionary_dictionary_addiction_linkId=");
		sb.append(dictionary_dictionary_addiction_linkId);
		sb.append(", dictionaryId=");
		sb.append(dictionaryId);
		sb.append(", addictionId=");
		sb.append(addictionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DictionaryDictionaryLink toEntityModel() {
		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLinkImpl.setDictionary_dictionary_addiction_linkId(dictionary_dictionary_addiction_linkId);
		dictionaryDictionaryLinkImpl.setDictionaryId(dictionaryId);
		dictionaryDictionaryLinkImpl.setAddictionId(addictionId);

		dictionaryDictionaryLinkImpl.resetOriginalValues();

		return dictionaryDictionaryLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictionary_dictionary_addiction_linkId = objectInput.readLong();
		dictionaryId = objectInput.readLong();
		addictionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictionary_dictionary_addiction_linkId);
		objectOutput.writeLong(dictionaryId);
		objectOutput.writeLong(addictionId);
	}

	public long dictionary_dictionary_addiction_linkId;
	public long dictionaryId;
	public long addictionId;
}