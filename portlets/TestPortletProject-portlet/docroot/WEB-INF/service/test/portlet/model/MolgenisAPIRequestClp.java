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

package test.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import test.portlet.service.ClpSerializer;
import test.portlet.service.MolgenisAPIRequestLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class MolgenisAPIRequestClp extends BaseModelImpl<MolgenisAPIRequest>
	implements MolgenisAPIRequest {
	public MolgenisAPIRequestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MolgenisAPIRequest.class;
	}

	@Override
	public String getModelClassName() {
		return MolgenisAPIRequest.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _molgenisapirequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMolgenisapirequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _molgenisapirequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("molgenisapirequestId", getMolgenisapirequestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long molgenisapirequestId = (Long)attributes.get("molgenisapirequestId");

		if (molgenisapirequestId != null) {
			setMolgenisapirequestId(molgenisapirequestId);
		}
	}

	@Override
	public long getMolgenisapirequestId() {
		return _molgenisapirequestId;
	}

	@Override
	public void setMolgenisapirequestId(long molgenisapirequestId) {
		_molgenisapirequestId = molgenisapirequestId;

		if (_molgenisAPIRequestRemoteModel != null) {
			try {
				Class<?> clazz = _molgenisAPIRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setMolgenisapirequestId",
						long.class);

				method.invoke(_molgenisAPIRequestRemoteModel,
					molgenisapirequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMolgenisAPIRequestRemoteModel() {
		return _molgenisAPIRequestRemoteModel;
	}

	public void setMolgenisAPIRequestRemoteModel(
		BaseModel<?> molgenisAPIRequestRemoteModel) {
		_molgenisAPIRequestRemoteModel = molgenisAPIRequestRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _molgenisAPIRequestRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_molgenisAPIRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MolgenisAPIRequestLocalServiceUtil.addMolgenisAPIRequest(this);
		}
		else {
			MolgenisAPIRequestLocalServiceUtil.updateMolgenisAPIRequest(this);
		}
	}

	@Override
	public MolgenisAPIRequest toEscapedModel() {
		return (MolgenisAPIRequest)ProxyUtil.newProxyInstance(MolgenisAPIRequest.class.getClassLoader(),
			new Class[] { MolgenisAPIRequest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MolgenisAPIRequestClp clone = new MolgenisAPIRequestClp();

		clone.setMolgenisapirequestId(getMolgenisapirequestId());

		return clone;
	}

	@Override
	public int compareTo(MolgenisAPIRequest molgenisAPIRequest) {
		long primaryKey = molgenisAPIRequest.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MolgenisAPIRequestClp)) {
			return false;
		}

		MolgenisAPIRequestClp molgenisAPIRequest = (MolgenisAPIRequestClp)obj;

		long primaryKey = molgenisAPIRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{molgenisapirequestId=");
		sb.append(getMolgenisapirequestId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("test.portlet.model.MolgenisAPIRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>molgenisapirequestId</column-name><column-value><![CDATA[");
		sb.append(getMolgenisapirequestId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _molgenisapirequestId;
	private BaseModel<?> _molgenisAPIRequestRemoteModel;
}