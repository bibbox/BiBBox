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

package com.bcnet.portlet.biobank.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author suyama
 */
public class BiobankContactPK implements Comparable<BiobankContactPK>,
	Serializable {
	public long biobankDbId;
	public long contactId;

	public BiobankContactPK() {
	}

	public BiobankContactPK(long biobankDbId, long contactId) {
		this.biobankDbId = biobankDbId;
		this.contactId = contactId;
	}

	public long getBiobankDbId() {
		return biobankDbId;
	}

	public void setBiobankDbId(long biobankDbId) {
		this.biobankDbId = biobankDbId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	@Override
	public int compareTo(BiobankContactPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (biobankDbId < pk.biobankDbId) {
			value = -1;
		}
		else if (biobankDbId > pk.biobankDbId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (contactId < pk.contactId) {
			value = -1;
		}
		else if (contactId > pk.contactId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankContactPK)) {
			return false;
		}

		BiobankContactPK pk = (BiobankContactPK)obj;

		if ((biobankDbId == pk.biobankDbId) && (contactId == pk.contactId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(biobankDbId) + String.valueOf(contactId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("biobankDbId");
		sb.append(StringPool.EQUAL);
		sb.append(biobankDbId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("contactId");
		sb.append(StringPool.EQUAL);
		sb.append(contactId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}