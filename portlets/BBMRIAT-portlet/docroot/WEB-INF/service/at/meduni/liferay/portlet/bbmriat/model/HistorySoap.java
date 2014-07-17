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

package at.meduni.liferay.portlet.bbmriat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Robert Reihs
 * @generated
 */
public class HistorySoap implements Serializable {
	public static HistorySoap toSoapModel(History model) {
		HistorySoap soapModel = new HistorySoap();

		soapModel.setHistoryId(model.getHistoryId());
		soapModel.setAction(model.getAction());
		soapModel.setTime(model.getTime());
		soapModel.setHisto_id(model.getHisto_id());
		soapModel.setWorkplace_id(model.getWorkplace_id());
		soapModel.setOrder_id(model.getOrder_id());

		return soapModel;
	}

	public static HistorySoap[] toSoapModels(History[] models) {
		HistorySoap[] soapModels = new HistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[][] toSoapModels(History[][] models) {
		HistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[] toSoapModels(List<History> models) {
		List<HistorySoap> soapModels = new ArrayList<HistorySoap>(models.size());

		for (History model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistorySoap[soapModels.size()]);
	}

	public HistorySoap() {
	}

	public long getPrimaryKey() {
		return _historyId;
	}

	public void setPrimaryKey(long pk) {
		setHistoryId(pk);
	}

	public long getHistoryId() {
		return _historyId;
	}

	public void setHistoryId(long historyId) {
		_historyId = historyId;
	}

	public long getAction() {
		return _action;
	}

	public void setAction(long action) {
		_action = action;
	}

	public Date getTime() {
		return _time;
	}

	public void setTime(Date time) {
		_time = time;
	}

	public long getHisto_id() {
		return _histo_id;
	}

	public void setHisto_id(long histo_id) {
		_histo_id = histo_id;
	}

	public long getWorkplace_id() {
		return _workplace_id;
	}

	public void setWorkplace_id(long workplace_id) {
		_workplace_id = workplace_id;
	}

	public long getOrder_id() {
		return _order_id;
	}

	public void setOrder_id(long order_id) {
		_order_id = order_id;
	}

	private long _historyId;
	private long _action;
	private Date _time;
	private long _histo_id;
	private long _workplace_id;
	private long _order_id;
}