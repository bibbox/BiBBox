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

package test.portlet.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import test.portlet.model.MolgenisAPIRequest;
import test.portlet.model.MolgenisAPIRequestModel;
import test.portlet.model.MolgenisAPIRequestSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MolgenisAPIRequest service. Represents a row in the &quot;test_MolgenisAPIRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link test.portlet.model.MolgenisAPIRequestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MolgenisAPIRequestImpl}.
 * </p>
 *
 * @author reihsr
 * @see MolgenisAPIRequestImpl
 * @see test.portlet.model.MolgenisAPIRequest
 * @see test.portlet.model.MolgenisAPIRequestModel
 * @generated
 */
@JSON(strict = true)
public class MolgenisAPIRequestModelImpl extends BaseModelImpl<MolgenisAPIRequest>
	implements MolgenisAPIRequestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a molgenis a p i request model instance should use the {@link test.portlet.model.MolgenisAPIRequest} interface instead.
	 */
	public static final String TABLE_NAME = "test_MolgenisAPIRequest";
	public static final Object[][] TABLE_COLUMNS = {
			{ "molgenisapirequestId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table test_MolgenisAPIRequest (molgenisapirequestId LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table test_MolgenisAPIRequest";
	public static final String ORDER_BY_JPQL = " ORDER BY molgenisAPIRequest.molgenisapirequestId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY test_MolgenisAPIRequest.molgenisapirequestId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.test.portlet.model.MolgenisAPIRequest"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.test.portlet.model.MolgenisAPIRequest"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MolgenisAPIRequest toModel(MolgenisAPIRequestSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MolgenisAPIRequest model = new MolgenisAPIRequestImpl();

		model.setMolgenisapirequestId(soapModel.getMolgenisapirequestId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MolgenisAPIRequest> toModels(
		MolgenisAPIRequestSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MolgenisAPIRequest> models = new ArrayList<MolgenisAPIRequest>(soapModels.length);

		for (MolgenisAPIRequestSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.test.portlet.model.MolgenisAPIRequest"));

	public MolgenisAPIRequestModelImpl() {
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
	public Class<?> getModelClass() {
		return MolgenisAPIRequest.class;
	}

	@Override
	public String getModelClassName() {
		return MolgenisAPIRequest.class.getName();
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

	@JSON
	@Override
	public long getMolgenisapirequestId() {
		return _molgenisapirequestId;
	}

	@Override
	public void setMolgenisapirequestId(long molgenisapirequestId) {
		_molgenisapirequestId = molgenisapirequestId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MolgenisAPIRequest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MolgenisAPIRequest toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MolgenisAPIRequest)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MolgenisAPIRequestImpl molgenisAPIRequestImpl = new MolgenisAPIRequestImpl();

		molgenisAPIRequestImpl.setMolgenisapirequestId(getMolgenisapirequestId());

		molgenisAPIRequestImpl.resetOriginalValues();

		return molgenisAPIRequestImpl;
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

		if (!(obj instanceof MolgenisAPIRequest)) {
			return false;
		}

		MolgenisAPIRequest molgenisAPIRequest = (MolgenisAPIRequest)obj;

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<MolgenisAPIRequest> toCacheModel() {
		MolgenisAPIRequestCacheModel molgenisAPIRequestCacheModel = new MolgenisAPIRequestCacheModel();

		molgenisAPIRequestCacheModel.molgenisapirequestId = getMolgenisapirequestId();

		return molgenisAPIRequestCacheModel;
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

	private static ClassLoader _classLoader = MolgenisAPIRequest.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MolgenisAPIRequest.class
		};
	private long _molgenisapirequestId;
	private MolgenisAPIRequest _escapedModel;
}