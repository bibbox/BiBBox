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

import at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ImporterConfig in entity cache.
 *
 * @author reihsr
 * @see ImporterConfig
 * @generated
 */
public class ImporterConfigCacheModel implements CacheModel<ImporterConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{importerconfigId=");
		sb.append(importerconfigId);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", elementvalue=");
		sb.append(elementvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImporterConfig toEntityModel() {
		ImporterConfigImpl importerConfigImpl = new ImporterConfigImpl();

		importerConfigImpl.setImporterconfigId(importerconfigId);

		if (scope == null) {
			importerConfigImpl.setScope(StringPool.BLANK);
		}
		else {
			importerConfigImpl.setScope(scope);
		}

		if (elementId == null) {
			importerConfigImpl.setElementId(StringPool.BLANK);
		}
		else {
			importerConfigImpl.setElementId(elementId);
		}

		if (elementvalue == null) {
			importerConfigImpl.setElementvalue(StringPool.BLANK);
		}
		else {
			importerConfigImpl.setElementvalue(elementvalue);
		}

		importerConfigImpl.resetOriginalValues();

		return importerConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		importerconfigId = objectInput.readLong();
		scope = objectInput.readUTF();
		elementId = objectInput.readUTF();
		elementvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(importerconfigId);

		if (scope == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (elementId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementId);
		}

		if (elementvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementvalue);
		}
	}

	public long importerconfigId;
	public String scope;
	public String elementId;
	public String elementvalue;
}