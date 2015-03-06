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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KdssmpParameterOptions in entity cache.
 *
 * @author reihsr
 * @see KdssmpParameterOptions
 * @generated
 */
public class KdssmpParameterOptionsCacheModel implements CacheModel<KdssmpParameterOptions>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{parameteroptionsId=");
		sb.append(parameteroptionsId);
		sb.append(", parameterconfigurationId=");
		sb.append(parameterconfigurationId);
		sb.append(", option=");
		sb.append(option);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KdssmpParameterOptions toEntityModel() {
		KdssmpParameterOptionsImpl kdssmpParameterOptionsImpl = new KdssmpParameterOptionsImpl();

		kdssmpParameterOptionsImpl.setParameteroptionsId(parameteroptionsId);
		kdssmpParameterOptionsImpl.setParameterconfigurationId(parameterconfigurationId);

		if (option == null) {
			kdssmpParameterOptionsImpl.setOption(StringPool.BLANK);
		}
		else {
			kdssmpParameterOptionsImpl.setOption(option);
		}

		if (value == null) {
			kdssmpParameterOptionsImpl.setValue(StringPool.BLANK);
		}
		else {
			kdssmpParameterOptionsImpl.setValue(value);
		}

		kdssmpParameterOptionsImpl.resetOriginalValues();

		return kdssmpParameterOptionsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parameteroptionsId = objectInput.readLong();
		parameterconfigurationId = objectInput.readLong();
		option = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(parameteroptionsId);
		objectOutput.writeLong(parameterconfigurationId);

		if (option == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(option);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long parameteroptionsId;
	public long parameterconfigurationId;
	public String option;
	public String value;
}