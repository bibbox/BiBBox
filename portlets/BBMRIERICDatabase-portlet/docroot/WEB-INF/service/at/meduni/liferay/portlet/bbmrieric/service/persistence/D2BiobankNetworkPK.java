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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author reihsr
 */
public class D2BiobankNetworkPK implements Comparable<D2BiobankNetworkPK>,
	Serializable {
	public long d2biobanknetworkId;
	public long parentd2biobanknetworkId;

	public D2BiobankNetworkPK() {
	}

	public D2BiobankNetworkPK(long d2biobanknetworkId,
		long parentd2biobanknetworkId) {
		this.d2biobanknetworkId = d2biobanknetworkId;
		this.parentd2biobanknetworkId = parentd2biobanknetworkId;
	}

	public long getD2biobanknetworkId() {
		return d2biobanknetworkId;
	}

	public void setD2biobanknetworkId(long d2biobanknetworkId) {
		this.d2biobanknetworkId = d2biobanknetworkId;
	}

	public long getParentd2biobanknetworkId() {
		return parentd2biobanknetworkId;
	}

	public void setParentd2biobanknetworkId(long parentd2biobanknetworkId) {
		this.parentd2biobanknetworkId = parentd2biobanknetworkId;
	}

	@Override
	public int compareTo(D2BiobankNetworkPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (d2biobanknetworkId < pk.d2biobanknetworkId) {
			value = -1;
		}
		else if (d2biobanknetworkId > pk.d2biobanknetworkId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (parentd2biobanknetworkId < pk.parentd2biobanknetworkId) {
			value = -1;
		}
		else if (parentd2biobanknetworkId > pk.parentd2biobanknetworkId) {
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

		if (!(obj instanceof D2BiobankNetworkPK)) {
			return false;
		}

		D2BiobankNetworkPK pk = (D2BiobankNetworkPK)obj;

		if ((d2biobanknetworkId == pk.d2biobanknetworkId) &&
				(parentd2biobanknetworkId == pk.parentd2biobanknetworkId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(d2biobanknetworkId) +
		String.valueOf(parentd2biobanknetworkId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("d2biobanknetworkId");
		sb.append(StringPool.EQUAL);
		sb.append(d2biobanknetworkId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("parentd2biobanknetworkId");
		sb.append(StringPool.EQUAL);
		sb.append(parentd2biobanknetworkId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}