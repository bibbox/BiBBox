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

import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ParameterOptionsConfiguration in entity cache.
 *
 * @author reihsr
 * @see ParameterOptionsConfiguration
 * @generated
 */
public class ParameterOptionsConfigurationCacheModel implements CacheModel<ParameterOptionsConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{parameteroptionsconfigurationId=");
		sb.append(parameteroptionsconfigurationId);
		sb.append(", parameterconfigurationId=");
		sb.append(parameterconfigurationId);
		sb.append(", optionkey=");
		sb.append(optionkey);
		sb.append(", optionvalue=");
		sb.append(optionvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ParameterOptionsConfiguration toEntityModel() {
		ParameterOptionsConfigurationImpl parameterOptionsConfigurationImpl = new ParameterOptionsConfigurationImpl();

		parameterOptionsConfigurationImpl.setParameteroptionsconfigurationId(parameteroptionsconfigurationId);
		parameterOptionsConfigurationImpl.setParameterconfigurationId(parameterconfigurationId);

		if (optionkey == null) {
			parameterOptionsConfigurationImpl.setOptionkey(StringPool.BLANK);
		}
		else {
			parameterOptionsConfigurationImpl.setOptionkey(optionkey);
		}

		if (optionvalue == null) {
			parameterOptionsConfigurationImpl.setOptionvalue(StringPool.BLANK);
		}
		else {
			parameterOptionsConfigurationImpl.setOptionvalue(optionvalue);
		}

		parameterOptionsConfigurationImpl.resetOriginalValues();

		return parameterOptionsConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parameteroptionsconfigurationId = objectInput.readLong();
		parameterconfigurationId = objectInput.readLong();
		optionkey = objectInput.readUTF();
		optionvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(parameteroptionsconfigurationId);
		objectOutput.writeLong(parameterconfigurationId);

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

	public long parameteroptionsconfigurationId;
	public long parameterconfigurationId;
	public String optionkey;
	public String optionvalue;
}