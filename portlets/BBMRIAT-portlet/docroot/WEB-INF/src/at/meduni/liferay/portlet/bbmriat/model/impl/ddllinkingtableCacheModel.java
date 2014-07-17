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

package at.meduni.liferay.portlet.bbmriat.model.impl;

import at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DDLLinkingTable in entity cache.
 *
 * @author Robert Reihs
 * @see DDLLinkingTable
 * @generated
 */
public class DDLLinkingTableCacheModel implements CacheModel<DDLLinkingTable>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ddllinkingtable=");
		sb.append(ddllinkingtable);
		sb.append(", recordid=");
		sb.append(recordid);
		sb.append(", recordsetid=");
		sb.append(recordsetid);
		sb.append(", linkrecordid=");
		sb.append(linkrecordid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DDLLinkingTable toEntityModel() {
		DDLLinkingTableImpl ddlLinkingTableImpl = new DDLLinkingTableImpl();

		ddlLinkingTableImpl.setDdllinkingtable(ddllinkingtable);
		ddlLinkingTableImpl.setRecordid(recordid);
		ddlLinkingTableImpl.setRecordsetid(recordsetid);
		ddlLinkingTableImpl.setLinkrecordid(linkrecordid);

		ddlLinkingTableImpl.resetOriginalValues();

		return ddlLinkingTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ddllinkingtable = objectInput.readLong();
		recordid = objectInput.readLong();
		recordsetid = objectInput.readLong();
		linkrecordid = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ddllinkingtable);
		objectOutput.writeLong(recordid);
		objectOutput.writeLong(recordsetid);
		objectOutput.writeLong(linkrecordid);
	}

	public long ddllinkingtable;
	public long recordid;
	public long recordsetid;
	public long linkrecordid;
}