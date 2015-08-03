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

package at.graz.hmmc.liferay.portlet.puch.model.impl;

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Configuration in entity cache.
 *
 * @author reihsr
 * @see Configuration
 * @generated
 */
public class ConfigurationCacheModel implements CacheModel<Configuration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{configurationId=");
		sb.append(configurationId);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", optionkey=");
		sb.append(optionkey);
		sb.append(", optionvalue=");
		sb.append(optionvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Configuration toEntityModel() {
		ConfigurationImpl configurationImpl = new ConfigurationImpl();

		configurationImpl.setConfigurationId(configurationId);

		if (scope == null) {
			configurationImpl.setScope(StringPool.BLANK);
		}
		else {
			configurationImpl.setScope(scope);
		}

		if (optionkey == null) {
			configurationImpl.setOptionkey(StringPool.BLANK);
		}
		else {
			configurationImpl.setOptionkey(optionkey);
		}

		if (optionvalue == null) {
			configurationImpl.setOptionvalue(StringPool.BLANK);
		}
		else {
			configurationImpl.setOptionvalue(optionvalue);
		}

		configurationImpl.resetOriginalValues();

		return configurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configurationId = objectInput.readLong();
		scope = objectInput.readUTF();
		optionkey = objectInput.readUTF();
		optionvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(configurationId);

		if (scope == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (optionkey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionkey);
		}

		if (optionvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionvalue);
		}
	}

	public long configurationId;
	public String scope;
	public String optionkey;
	public String optionvalue;
}