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

import at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable;
import at.meduni.liferay.portlet.bbmriat.model.ddllinkingtableModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ddllinkingtable service. Represents a row in the &quot;bbmriat.ddllinkingtable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.meduni.liferay.portlet.bbmriat.model.ddllinkingtableModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ddllinkingtableImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see ddllinkingtableImpl
 * @see at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable
 * @see at.meduni.liferay.portlet.bbmriat.model.ddllinkingtableModel
 * @generated
 */
public class ddllinkingtableModelImpl extends BaseModelImpl<ddllinkingtable>
	implements ddllinkingtableModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddllinkingtable model instance should use the {@link at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable} interface instead.
	 */
	public static final String TABLE_NAME = "bbmriat.ddllinkingtable";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ddllinkingtable", Types.BIGINT },
			{ "recordid", Types.BIGINT },
			{ "recordsetid", Types.BIGINT },
			{ "linkrecordid", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table bbmriat.ddllinkingtable (ddllinkingtable LONG not null primary key,recordid LONG,recordsetid LONG,linkrecordid LONG)";
	public static final String TABLE_SQL_DROP = "drop table bbmriat.ddllinkingtable";
	public static final String ORDER_BY_JPQL = " ORDER BY ddllinkingtable.recordid ASC";
	public static final String ORDER_BY_SQL = " ORDER BY bbmriat.ddllinkingtable.recordid ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable"),
			true);
	public static long RECORDID_COLUMN_BITMASK = 1L;
	public static long RECORDSETID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable"));

	public ddllinkingtableModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ddllinkingtable;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDdllinkingtable(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ddllinkingtable;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ddllinkingtable.class;
	}

	@Override
	public String getModelClassName() {
		return ddllinkingtable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ddllinkingtable", getDdllinkingtable());
		attributes.put("recordid", getRecordid());
		attributes.put("recordsetid", getRecordsetid());
		attributes.put("linkrecordid", getLinkrecordid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ddllinkingtable = (Long)attributes.get("ddllinkingtable");

		if (ddllinkingtable != null) {
			setDdllinkingtable(ddllinkingtable);
		}

		Long recordid = (Long)attributes.get("recordid");

		if (recordid != null) {
			setRecordid(recordid);
		}

		Long recordsetid = (Long)attributes.get("recordsetid");

		if (recordsetid != null) {
			setRecordsetid(recordsetid);
		}

		Long linkrecordid = (Long)attributes.get("linkrecordid");

		if (linkrecordid != null) {
			setLinkrecordid(linkrecordid);
		}
	}

	@Override
	public long getDdllinkingtable() {
		return _ddllinkingtable;
	}

	@Override
	public void setDdllinkingtable(long ddllinkingtable) {
		_ddllinkingtable = ddllinkingtable;
	}

	@Override
	public long getRecordid() {
		return _recordid;
	}

	@Override
	public void setRecordid(long recordid) {
		_columnBitmask = -1L;

		if (!_setOriginalRecordid) {
			_setOriginalRecordid = true;

			_originalRecordid = _recordid;
		}

		_recordid = recordid;
	}

	public long getOriginalRecordid() {
		return _originalRecordid;
	}

	@Override
	public long getRecordsetid() {
		return _recordsetid;
	}

	@Override
	public void setRecordsetid(long recordsetid) {
		_columnBitmask |= RECORDSETID_COLUMN_BITMASK;

		if (!_setOriginalRecordsetid) {
			_setOriginalRecordsetid = true;

			_originalRecordsetid = _recordsetid;
		}

		_recordsetid = recordsetid;
	}

	public long getOriginalRecordsetid() {
		return _originalRecordsetid;
	}

	@Override
	public long getLinkrecordid() {
		return _linkrecordid;
	}

	@Override
	public void setLinkrecordid(long linkrecordid) {
		_linkrecordid = linkrecordid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ddllinkingtable.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ddllinkingtable toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ddllinkingtable)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ddllinkingtableImpl ddllinkingtableImpl = new ddllinkingtableImpl();

		ddllinkingtableImpl.setDdllinkingtable(getDdllinkingtable());
		ddllinkingtableImpl.setRecordid(getRecordid());
		ddllinkingtableImpl.setRecordsetid(getRecordsetid());
		ddllinkingtableImpl.setLinkrecordid(getLinkrecordid());

		ddllinkingtableImpl.resetOriginalValues();

		return ddllinkingtableImpl;
	}

	@Override
	public int compareTo(ddllinkingtable ddllinkingtable) {
		int value = 0;

		if (getRecordid() < ddllinkingtable.getRecordid()) {
			value = -1;
		}
		else if (getRecordid() > ddllinkingtable.getRecordid()) {
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

		if (!(obj instanceof ddllinkingtable)) {
			return false;
		}

		ddllinkingtable ddllinkingtable = (ddllinkingtable)obj;

		long primaryKey = ddllinkingtable.getPrimaryKey();

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
		ddllinkingtableModelImpl ddllinkingtableModelImpl = this;

		ddllinkingtableModelImpl._originalRecordid = ddllinkingtableModelImpl._recordid;

		ddllinkingtableModelImpl._setOriginalRecordid = false;

		ddllinkingtableModelImpl._originalRecordsetid = ddllinkingtableModelImpl._recordsetid;

		ddllinkingtableModelImpl._setOriginalRecordsetid = false;

		ddllinkingtableModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ddllinkingtable> toCacheModel() {
		ddllinkingtableCacheModel ddllinkingtableCacheModel = new ddllinkingtableCacheModel();

		ddllinkingtableCacheModel.ddllinkingtable = getDdllinkingtable();

		ddllinkingtableCacheModel.recordid = getRecordid();

		ddllinkingtableCacheModel.recordsetid = getRecordsetid();

		ddllinkingtableCacheModel.linkrecordid = getLinkrecordid();

		return ddllinkingtableCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ddllinkingtable=");
		sb.append(getDdllinkingtable());
		sb.append(", recordid=");
		sb.append(getRecordid());
		sb.append(", recordsetid=");
		sb.append(getRecordsetid());
		sb.append(", linkrecordid=");
		sb.append(getLinkrecordid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ddllinkingtable</column-name><column-value><![CDATA[");
		sb.append(getDdllinkingtable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recordid</column-name><column-value><![CDATA[");
		sb.append(getRecordid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recordsetid</column-name><column-value><![CDATA[");
		sb.append(getRecordsetid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkrecordid</column-name><column-value><![CDATA[");
		sb.append(getLinkrecordid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ddllinkingtable.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ddllinkingtable.class
		};
	private long _ddllinkingtable;
	private long _recordid;
	private long _originalRecordid;
	private boolean _setOriginalRecordid;
	private long _recordsetid;
	private long _originalRecordsetid;
	private boolean _setOriginalRecordsetid;
	private long _linkrecordid;
	private long _columnBitmask;
	private ddllinkingtable _escapedModel;
}