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

package at.graz.meduni.liferay.portlet.bibbox.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SymbolConfiguration in entity cache.
 *
 * @author reihsr
 * @see SymbolConfiguration
 * @generated
 */
public class SymbolConfigurationCacheModel implements CacheModel<SymbolConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{symbolconfigurationId=");
		sb.append(symbolconfigurationId);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", eventtype=");
		sb.append(eventtype);
		sb.append(", basecolor=");
		sb.append(basecolor);
		sb.append(", symboltype=");
		sb.append(symboltype);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SymbolConfiguration toEntityModel() {
		SymbolConfigurationImpl symbolConfigurationImpl = new SymbolConfigurationImpl();

		symbolConfigurationImpl.setSymbolconfigurationId(symbolconfigurationId);

		if (scope == null) {
			symbolConfigurationImpl.setScope(StringPool.BLANK);
		}
		else {
			symbolConfigurationImpl.setScope(scope);
		}

		if (eventtype == null) {
			symbolConfigurationImpl.setEventtype(StringPool.BLANK);
		}
		else {
			symbolConfigurationImpl.setEventtype(eventtype);
		}

		if (basecolor == null) {
			symbolConfigurationImpl.setBasecolor(StringPool.BLANK);
		}
		else {
			symbolConfigurationImpl.setBasecolor(basecolor);
		}

		if (symboltype == null) {
			symbolConfigurationImpl.setSymboltype(StringPool.BLANK);
		}
		else {
			symbolConfigurationImpl.setSymboltype(symboltype);
		}

		symbolConfigurationImpl.resetOriginalValues();

		return symbolConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		symbolconfigurationId = objectInput.readLong();
		scope = objectInput.readUTF();
		eventtype = objectInput.readUTF();
		basecolor = objectInput.readUTF();
		symboltype = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(symbolconfigurationId);

		if (scope == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (eventtype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventtype);
		}

		if (basecolor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(basecolor);
		}

		if (symboltype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(symboltype);
		}
	}

	public long symbolconfigurationId;
	public String scope;
	public String eventtype;
	public String basecolor;
	public String symboltype;
}