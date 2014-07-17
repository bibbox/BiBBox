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

import at.meduni.liferay.portlet.bbmriat.model.History;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing History in entity cache.
 *
 * @author Robert Reihs
 * @see History
 * @generated
 */
public class HistoryCacheModel implements CacheModel<History>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{historyId=");
		sb.append(historyId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", time=");
		sb.append(time);
		sb.append(", histo_id=");
		sb.append(histo_id);
		sb.append(", workplace_id=");
		sb.append(workplace_id);
		sb.append(", order_id=");
		sb.append(order_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public History toEntityModel() {
		HistoryImpl historyImpl = new HistoryImpl();

		historyImpl.setHistoryId(historyId);
		historyImpl.setAction(action);

		if (time == Long.MIN_VALUE) {
			historyImpl.setTime(null);
		}
		else {
			historyImpl.setTime(new Date(time));
		}

		historyImpl.setHisto_id(histo_id);
		historyImpl.setWorkplace_id(workplace_id);
		historyImpl.setOrder_id(order_id);

		historyImpl.resetOriginalValues();

		return historyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		historyId = objectInput.readLong();
		action = objectInput.readLong();
		time = objectInput.readLong();
		histo_id = objectInput.readLong();
		workplace_id = objectInput.readLong();
		order_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(historyId);
		objectOutput.writeLong(action);
		objectOutput.writeLong(time);
		objectOutput.writeLong(histo_id);
		objectOutput.writeLong(workplace_id);
		objectOutput.writeLong(order_id);
	}

	public long historyId;
	public long action;
	public long time;
	public long histo_id;
	public long workplace_id;
	public long order_id;
}