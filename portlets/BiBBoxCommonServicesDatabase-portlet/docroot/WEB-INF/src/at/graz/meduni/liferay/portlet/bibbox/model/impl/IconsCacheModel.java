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

import at.graz.meduni.liferay.portlet.bibbox.model.Icons;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Icons in entity cache.
 *
 * @author reihsr
 * @see Icons
 * @generated
 */
public class IconsCacheModel implements CacheModel<Icons>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{iconsId=");
		sb.append(iconsId);
		sb.append(", iconurl=");
		sb.append(iconurl);
		sb.append(", group=");
		sb.append(group);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Icons toEntityModel() {
		IconsImpl iconsImpl = new IconsImpl();

		iconsImpl.setIconsId(iconsId);

		if (iconurl == null) {
			iconsImpl.setIconurl(StringPool.BLANK);
		}
		else {
			iconsImpl.setIconurl(iconurl);
		}

		if (group == null) {
			iconsImpl.setGroup(StringPool.BLANK);
		}
		else {
			iconsImpl.setGroup(group);
		}

		iconsImpl.resetOriginalValues();

		return iconsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		iconsId = objectInput.readLong();
		iconurl = objectInput.readUTF();
		group = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(iconsId);

		if (iconurl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(iconurl);
		}

		if (group == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(group);
		}
	}

	public long iconsId;
	public String iconurl;
	public String group;
}