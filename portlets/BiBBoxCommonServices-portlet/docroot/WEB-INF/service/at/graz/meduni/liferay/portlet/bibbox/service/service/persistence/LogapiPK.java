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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author reihsr
 */
public class LogapiPK implements Comparable<LogapiPK>, Serializable {
	public long logapiId;
	public long userId;
	public String userip;
	public String logmsg;

	public LogapiPK() {
	}

	public LogapiPK(long logapiId, long userId, String userip, String logmsg) {
		this.logapiId = logapiId;
		this.userId = userId;
		this.userip = userip;
		this.logmsg = logmsg;
	}

	public long getLogapiId() {
		return logapiId;
	}

	public void setLogapiId(long logapiId) {
		this.logapiId = logapiId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getLogmsg() {
		return logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	@Override
	public int compareTo(LogapiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (logapiId < pk.logapiId) {
			value = -1;
		}
		else if (logapiId > pk.logapiId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = userip.compareTo(pk.userip);

		if (value != 0) {
			return value;
		}

		value = logmsg.compareTo(pk.logmsg);

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

		if (!(obj instanceof LogapiPK)) {
			return false;
		}

		LogapiPK pk = (LogapiPK)obj;

		if ((logapiId == pk.logapiId) && (userId == pk.userId) &&
				(userip.equals(pk.userip)) && (logmsg.equals(pk.logmsg))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(logapiId) + String.valueOf(userId) +
		String.valueOf(userip) + String.valueOf(logmsg)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("logapiId");
		sb.append(StringPool.EQUAL);
		sb.append(logapiId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userip");
		sb.append(StringPool.EQUAL);
		sb.append(userip);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("logmsg");
		sb.append(StringPool.EQUAL);
		sb.append(logmsg);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}