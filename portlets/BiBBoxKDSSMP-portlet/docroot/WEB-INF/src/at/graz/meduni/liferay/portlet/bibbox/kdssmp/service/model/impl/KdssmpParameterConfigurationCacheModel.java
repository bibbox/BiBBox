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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KdssmpParameterConfiguration in entity cache.
 *
 * @author reihsr
 * @see KdssmpParameterConfiguration
 * @generated
 */
public class KdssmpParameterConfigurationCacheModel implements CacheModel<KdssmpParameterConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{parameterconfigurationId=");
		sb.append(parameterconfigurationId);
		sb.append(", displayname=");
		sb.append(displayname);
		sb.append(", datatype=");
		sb.append(datatype);
		sb.append(", valuerange=");
		sb.append(valuerange);
		sb.append(", displayoptions=");
		sb.append(displayoptions);
		sb.append(", visible=");
		sb.append(visible);
		sb.append(", computed=");
		sb.append(computed);
		sb.append(", confirmationscript=");
		sb.append(confirmationscript);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KdssmpParameterConfiguration toEntityModel() {
		KdssmpParameterConfigurationImpl kdssmpParameterConfigurationImpl = new KdssmpParameterConfigurationImpl();

		kdssmpParameterConfigurationImpl.setParameterconfigurationId(parameterconfigurationId);

		if (displayname == null) {
			kdssmpParameterConfigurationImpl.setDisplayname(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setDisplayname(displayname);
		}

		if (datatype == null) {
			kdssmpParameterConfigurationImpl.setDatatype(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setDatatype(datatype);
		}

		if (valuerange == null) {
			kdssmpParameterConfigurationImpl.setValuerange(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setValuerange(valuerange);
		}

		if (displayoptions == null) {
			kdssmpParameterConfigurationImpl.setDisplayoptions(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setDisplayoptions(displayoptions);
		}

		if (visible == null) {
			kdssmpParameterConfigurationImpl.setVisible(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setVisible(visible);
		}

		if (computed == null) {
			kdssmpParameterConfigurationImpl.setComputed(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setComputed(computed);
		}

		if (confirmationscript == null) {
			kdssmpParameterConfigurationImpl.setConfirmationscript(StringPool.BLANK);
		}
		else {
			kdssmpParameterConfigurationImpl.setConfirmationscript(confirmationscript);
		}

		kdssmpParameterConfigurationImpl.resetOriginalValues();

		return kdssmpParameterConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parameterconfigurationId = objectInput.readLong();
		displayname = objectInput.readUTF();
		datatype = objectInput.readUTF();
		valuerange = objectInput.readUTF();
		displayoptions = objectInput.readUTF();
		visible = objectInput.readUTF();
		computed = objectInput.readUTF();
		confirmationscript = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(parameterconfigurationId);

		if (displayname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayname);
		}

		if (datatype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(datatype);
		}

		if (valuerange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(valuerange);
		}

		if (displayoptions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayoptions);
		}

		if (visible == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(visible);
		}

		if (computed == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(computed);
		}

		if (confirmationscript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(confirmationscript);
		}
	}

	public long parameterconfigurationId;
	public String displayname;
	public String datatype;
	public String valuerange;
	public String displayoptions;
	public String visible;
	public String computed;
	public String confirmationscript;
}