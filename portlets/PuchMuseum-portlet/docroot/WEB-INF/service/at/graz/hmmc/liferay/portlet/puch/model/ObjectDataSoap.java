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

package at.graz.hmmc.liferay.portlet.puch.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class ObjectDataSoap implements Serializable {
	public static ObjectDataSoap toSoapModel(ObjectData model) {
		ObjectDataSoap soapModel = new ObjectDataSoap();

		soapModel.setObjectdataId(model.getObjectdataId());
		soapModel.setPuchmuseumsobjectId(model.getPuchmuseumsobjectId());
		soapModel.setObjectkey(model.getObjectkey());
		soapModel.setObjectvalue(model.getObjectvalue());

		return soapModel;
	}

	public static ObjectDataSoap[] toSoapModels(ObjectData[] models) {
		ObjectDataSoap[] soapModels = new ObjectDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ObjectDataSoap[][] toSoapModels(ObjectData[][] models) {
		ObjectDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ObjectDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ObjectDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ObjectDataSoap[] toSoapModels(List<ObjectData> models) {
		List<ObjectDataSoap> soapModels = new ArrayList<ObjectDataSoap>(models.size());

		for (ObjectData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ObjectDataSoap[soapModels.size()]);
	}

	public ObjectDataSoap() {
	}

	public long getPrimaryKey() {
		return _objectdataId;
	}

	public void setPrimaryKey(long pk) {
		setObjectdataId(pk);
	}

	public long getObjectdataId() {
		return _objectdataId;
	}

	public void setObjectdataId(long objectdataId) {
		_objectdataId = objectdataId;
	}

	public long getPuchmuseumsobjectId() {
		return _puchmuseumsobjectId;
	}

	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchmuseumsobjectId = puchmuseumsobjectId;
	}

	public String getObjectkey() {
		return _objectkey;
	}

	public void setObjectkey(String objectkey) {
		_objectkey = objectkey;
	}

	public String getObjectvalue() {
		return _objectvalue;
	}

	public void setObjectvalue(String objectvalue) {
		_objectvalue = objectvalue;
	}

	private long _objectdataId;
	private long _puchmuseumsobjectId;
	private String _objectkey;
	private String _objectvalue;
}