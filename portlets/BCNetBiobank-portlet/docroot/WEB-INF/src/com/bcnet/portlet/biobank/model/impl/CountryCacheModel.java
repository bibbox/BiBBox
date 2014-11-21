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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.Country;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Country in entity cache.
 *
 * @author suyama
 * @see Country
 * @generated
 */
public class CountryCacheModel implements CacheModel<Country>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{countryCode=");
		sb.append(countryCode);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Country toEntityModel() {
		CountryImpl countryImpl = new CountryImpl();

		if (countryCode == null) {
			countryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			countryImpl.setCountryCode(countryCode);
		}

		if (name == null) {
			countryImpl.setName(StringPool.BLANK);
		}
		else {
			countryImpl.setName(name);
		}

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryCode = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String countryCode;
	public String name;
}