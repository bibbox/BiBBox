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

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DDLConfiguration in entity cache.
 *
 * @author reihsr
 * @see DDLConfiguration
 * @generated
 */
public class DDLConfigurationCacheModel implements CacheModel<DDLConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ddlconfigurationId=");
		sb.append(ddlconfigurationId);
		sb.append(", ddmstructureId=");
		sb.append(ddmstructureId);
		sb.append(", fieldname=");
		sb.append(fieldname);
		sb.append(", group=");
		sb.append(group);
		sb.append(", display=");
		sb.append(display);
		sb.append(", viewscript=");
		sb.append(viewscript);
		sb.append(", displaytip=");
		sb.append(displaytip);
		sb.append(", viewtitlecss=");
		sb.append(viewtitlecss);
		sb.append(", viewvaluecss=");
		sb.append(viewvaluecss);
		sb.append(", columwidth=");
		sb.append(columwidth);
		sb.append(", editscript=");
		sb.append(editscript);
		sb.append(", edittip=");
		sb.append(edittip);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DDLConfiguration toEntityModel() {
		DDLConfigurationImpl ddlConfigurationImpl = new DDLConfigurationImpl();

		ddlConfigurationImpl.setDdlconfigurationId(ddlconfigurationId);
		ddlConfigurationImpl.setDdmstructureId(ddmstructureId);

		if (fieldname == null) {
			ddlConfigurationImpl.setFieldname(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setFieldname(fieldname);
		}

		if (group == null) {
			ddlConfigurationImpl.setGroup(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setGroup(group);
		}

		ddlConfigurationImpl.setDisplay(display);

		if (viewscript == null) {
			ddlConfigurationImpl.setViewscript(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setViewscript(viewscript);
		}

		if (displaytip == null) {
			ddlConfigurationImpl.setDisplaytip(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setDisplaytip(displaytip);
		}

		if (viewtitlecss == null) {
			ddlConfigurationImpl.setViewtitlecss(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setViewtitlecss(viewtitlecss);
		}

		if (viewvaluecss == null) {
			ddlConfigurationImpl.setViewvaluecss(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setViewvaluecss(viewvaluecss);
		}

		ddlConfigurationImpl.setColumwidth(columwidth);

		if (editscript == null) {
			ddlConfigurationImpl.setEditscript(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setEditscript(editscript);
		}

		if (edittip == null) {
			ddlConfigurationImpl.setEdittip(StringPool.BLANK);
		}
		else {
			ddlConfigurationImpl.setEdittip(edittip);
		}

		ddlConfigurationImpl.resetOriginalValues();

		return ddlConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ddlconfigurationId = objectInput.readLong();
		ddmstructureId = objectInput.readLong();
		fieldname = objectInput.readUTF();
		group = objectInput.readUTF();
		display = objectInput.readBoolean();
		viewscript = objectInput.readUTF();
		displaytip = objectInput.readUTF();
		viewtitlecss = objectInput.readUTF();
		viewvaluecss = objectInput.readUTF();
		columwidth = objectInput.readLong();
		editscript = objectInput.readUTF();
		edittip = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ddlconfigurationId);
		objectOutput.writeLong(ddmstructureId);

		if (fieldname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fieldname);
		}

		if (group == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(group);
		}

		objectOutput.writeBoolean(display);

		if (viewscript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewscript);
		}

		if (displaytip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displaytip);
		}

		if (viewtitlecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewtitlecss);
		}

		if (viewvaluecss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(viewvaluecss);
		}

		objectOutput.writeLong(columwidth);

		if (editscript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(editscript);
		}

		if (edittip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(edittip);
		}
	}

	public long ddlconfigurationId;
	public long ddmstructureId;
	public String fieldname;
	public String group;
	public boolean display;
	public String viewscript;
	public String displaytip;
	public String viewtitlecss;
	public String viewvaluecss;
	public long columwidth;
	public String editscript;
	public String edittip;
}