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

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SymbolTypeConfiguration in entity cache.
 *
 * @author reihsr
 * @see SymbolTypeConfiguration
 * @generated
 */
public class SymbolTypeConfigurationCacheModel implements CacheModel<SymbolTypeConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{symboltypeconfigurationId=");
		sb.append(symboltypeconfigurationId);
		sb.append(", symboltype=");
		sb.append(symboltype);
		sb.append(", template=");
		sb.append(template);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SymbolTypeConfiguration toEntityModel() {
		SymbolTypeConfigurationImpl symbolTypeConfigurationImpl = new SymbolTypeConfigurationImpl();

		symbolTypeConfigurationImpl.setSymboltypeconfigurationId(symboltypeconfigurationId);

		if (symboltype == null) {
			symbolTypeConfigurationImpl.setSymboltype(StringPool.BLANK);
		}
		else {
			symbolTypeConfigurationImpl.setSymboltype(symboltype);
		}

		if (template == null) {
			symbolTypeConfigurationImpl.setTemplate(StringPool.BLANK);
		}
		else {
			symbolTypeConfigurationImpl.setTemplate(template);
		}

		symbolTypeConfigurationImpl.resetOriginalValues();

		return symbolTypeConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		symboltypeconfigurationId = objectInput.readLong();
		symboltype = objectInput.readUTF();
		template = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(symboltypeconfigurationId);

		if (symboltype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(symboltype);
		}

		if (template == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(template);
		}
	}

	public long symboltypeconfigurationId;
	public String symboltype;
	public String template;
}