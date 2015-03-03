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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KdssmpConfiguration in entity cache.
 *
 * @author reihsr
 * @see KdssmpConfiguration
 * @generated
 */
public class KdssmpConfigurationCacheModel implements CacheModel<KdssmpConfiguration>,
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
	public KdssmpConfiguration toEntityModel() {
		KdssmpConfigurationImpl kdssmpConfigurationImpl = new KdssmpConfigurationImpl();

		kdssmpConfigurationImpl.setConfigurationId(configurationId);

		if (scope == null) {
			kdssmpConfigurationImpl.setScope(StringPool.BLANK);
		}
		else {
			kdssmpConfigurationImpl.setScope(scope);
		}

		if (optionkey == null) {
			kdssmpConfigurationImpl.setOptionkey(StringPool.BLANK);
		}
		else {
			kdssmpConfigurationImpl.setOptionkey(optionkey);
		}

		if (optionvalue == null) {
			kdssmpConfigurationImpl.setOptionvalue(StringPool.BLANK);
		}
		else {
			kdssmpConfigurationImpl.setOptionvalue(optionvalue);
		}

		kdssmpConfigurationImpl.resetOriginalValues();

		return kdssmpConfigurationImpl;
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