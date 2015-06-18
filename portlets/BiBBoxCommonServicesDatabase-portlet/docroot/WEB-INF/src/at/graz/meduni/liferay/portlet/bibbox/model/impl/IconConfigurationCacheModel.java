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

import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing IconConfiguration in entity cache.
 *
 * @author reihsr
 * @see IconConfiguration
 * @generated
 */
public class IconConfigurationCacheModel implements CacheModel<IconConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{iconconfigurationId=");
		sb.append(iconconfigurationId);
		sb.append(", symbolconfigurationId=");
		sb.append(symbolconfigurationId);
		sb.append(", position=");
		sb.append(position);
		sb.append(", key=");
		sb.append(key);
		sb.append(", image=");
		sb.append(image);
		sb.append(", elementcolor=");
		sb.append(elementcolor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IconConfiguration toEntityModel() {
		IconConfigurationImpl iconConfigurationImpl = new IconConfigurationImpl();

		iconConfigurationImpl.setIconconfigurationId(iconconfigurationId);
		iconConfigurationImpl.setSymbolconfigurationId(symbolconfigurationId);

		if (position == null) {
			iconConfigurationImpl.setPosition(StringPool.BLANK);
		}
		else {
			iconConfigurationImpl.setPosition(position);
		}

		if (key == null) {
			iconConfigurationImpl.setKey(StringPool.BLANK);
		}
		else {
			iconConfigurationImpl.setKey(key);
		}

		if (image == null) {
			iconConfigurationImpl.setImage(StringPool.BLANK);
		}
		else {
			iconConfigurationImpl.setImage(image);
		}

		if (elementcolor == null) {
			iconConfigurationImpl.setElementcolor(StringPool.BLANK);
		}
		else {
			iconConfigurationImpl.setElementcolor(elementcolor);
		}

		iconConfigurationImpl.resetOriginalValues();

		return iconConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		iconconfigurationId = objectInput.readLong();
		symbolconfigurationId = objectInput.readLong();
		position = objectInput.readUTF();
		key = objectInput.readUTF();
		image = objectInput.readUTF();
		elementcolor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(iconconfigurationId);
		objectOutput.writeLong(symbolconfigurationId);

		if (position == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(position);
		}

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (image == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (elementcolor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementcolor);
		}
	}

	public long iconconfigurationId;
	public long symbolconfigurationId;
	public String position;
	public String key;
	public String image;
	public String elementcolor;
}