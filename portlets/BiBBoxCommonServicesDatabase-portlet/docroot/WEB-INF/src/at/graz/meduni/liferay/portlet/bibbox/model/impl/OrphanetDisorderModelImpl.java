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

package at.graz.meduni.liferay.portlet.bibbox.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorderModel;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorderSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the OrphanetDisorder service. Represents a row in the &quot;ontologies.orphanetdisorder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrphanetDisorderImpl}.
 * </p>
 *
 * @author reihsr
 * @see OrphanetDisorderImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder
 * @see at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorderModel
 * @generated
 */
@JSON(strict = true)
public class OrphanetDisorderModelImpl extends BaseModelImpl<OrphanetDisorder>
	implements OrphanetDisorderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a orphanet disorder model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder} interface instead.
	 */
	public static final String TABLE_NAME = "ontologies.orphanetdisorder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "orphanetdisorderId", Types.BIGINT },
			{ "orphanumber", Types.BIGINT },
			{ "orpahnetlink", Types.VARCHAR },
			{ "diseasename", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ontologies.orphanetdisorder (orphanetdisorderId LONG not null primary key,orphanumber LONG,orpahnetlink TEXT null,diseasename TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table ontologies.orphanetdisorder";
	public static final String ORDER_BY_JPQL = " ORDER BY orphanetDisorder.orphanetdisorderId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ontologies.orphanetdisorder.orphanetdisorderId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder"),
			true);
	public static long ORPHANUMBER_COLUMN_BITMASK = 1L;
	public static long ORPHANETDISORDERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OrphanetDisorder toModel(OrphanetDisorderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OrphanetDisorder model = new OrphanetDisorderImpl();

		model.setOrphanetdisorderId(soapModel.getOrphanetdisorderId());
		model.setOrphanumber(soapModel.getOrphanumber());
		model.setOrpahnetlink(soapModel.getOrpahnetlink());
		model.setDiseasename(soapModel.getDiseasename());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OrphanetDisorder> toModels(
		OrphanetDisorderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OrphanetDisorder> models = new ArrayList<OrphanetDisorder>(soapModels.length);

		for (OrphanetDisorderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder"));

	public OrphanetDisorderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _orphanetdisorderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrphanetdisorderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orphanetdisorderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetDisorder.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetDisorder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("orphanumber", getOrphanumber());
		attributes.put("orpahnetlink", getOrpahnetlink());
		attributes.put("diseasename", getDiseasename());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		Long orphanumber = (Long)attributes.get("orphanumber");

		if (orphanumber != null) {
			setOrphanumber(orphanumber);
		}

		String orpahnetlink = (String)attributes.get("orpahnetlink");

		if (orpahnetlink != null) {
			setOrpahnetlink(orpahnetlink);
		}

		String diseasename = (String)attributes.get("diseasename");

		if (diseasename != null) {
			setDiseasename(diseasename);
		}
	}

	@JSON
	@Override
	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;
	}

	@JSON
	@Override
	public long getOrphanumber() {
		return _orphanumber;
	}

	@Override
	public void setOrphanumber(long orphanumber) {
		_columnBitmask |= ORPHANUMBER_COLUMN_BITMASK;

		if (!_setOriginalOrphanumber) {
			_setOriginalOrphanumber = true;

			_originalOrphanumber = _orphanumber;
		}

		_orphanumber = orphanumber;
	}

	public long getOriginalOrphanumber() {
		return _originalOrphanumber;
	}

	@JSON
	@Override
	public String getOrpahnetlink() {
		if (_orpahnetlink == null) {
			return StringPool.BLANK;
		}
		else {
			return _orpahnetlink;
		}
	}

	@Override
	public void setOrpahnetlink(String orpahnetlink) {
		_orpahnetlink = orpahnetlink;
	}

	@JSON
	@Override
	public String getDiseasename() {
		if (_diseasename == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseasename;
		}
	}

	@Override
	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OrphanetDisorder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OrphanetDisorder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OrphanetDisorder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OrphanetDisorderImpl orphanetDisorderImpl = new OrphanetDisorderImpl();

		orphanetDisorderImpl.setOrphanetdisorderId(getOrphanetdisorderId());
		orphanetDisorderImpl.setOrphanumber(getOrphanumber());
		orphanetDisorderImpl.setOrpahnetlink(getOrpahnetlink());
		orphanetDisorderImpl.setDiseasename(getDiseasename());

		orphanetDisorderImpl.resetOriginalValues();

		return orphanetDisorderImpl;
	}

	@Override
	public int compareTo(OrphanetDisorder orphanetDisorder) {
		long primaryKey = orphanetDisorder.getPrimaryKey();

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

		if (!(obj instanceof OrphanetDisorder)) {
			return false;
		}

		OrphanetDisorder orphanetDisorder = (OrphanetDisorder)obj;

		long primaryKey = orphanetDisorder.getPrimaryKey();

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
		OrphanetDisorderModelImpl orphanetDisorderModelImpl = this;

		orphanetDisorderModelImpl._originalOrphanumber = orphanetDisorderModelImpl._orphanumber;

		orphanetDisorderModelImpl._setOriginalOrphanumber = false;

		orphanetDisorderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OrphanetDisorder> toCacheModel() {
		OrphanetDisorderCacheModel orphanetDisorderCacheModel = new OrphanetDisorderCacheModel();

		orphanetDisorderCacheModel.orphanetdisorderId = getOrphanetdisorderId();

		orphanetDisorderCacheModel.orphanumber = getOrphanumber();

		orphanetDisorderCacheModel.orpahnetlink = getOrpahnetlink();

		String orpahnetlink = orphanetDisorderCacheModel.orpahnetlink;

		if ((orpahnetlink != null) && (orpahnetlink.length() == 0)) {
			orphanetDisorderCacheModel.orpahnetlink = null;
		}

		orphanetDisorderCacheModel.diseasename = getDiseasename();

		String diseasename = orphanetDisorderCacheModel.diseasename;

		if ((diseasename != null) && (diseasename.length() == 0)) {
			orphanetDisorderCacheModel.diseasename = null;
		}

		return orphanetDisorderCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{orphanetdisorderId=");
		sb.append(getOrphanetdisorderId());
		sb.append(", orphanumber=");
		sb.append(getOrphanumber());
		sb.append(", orpahnetlink=");
		sb.append(getOrpahnetlink());
		sb.append(", diseasename=");
		sb.append(getDiseasename());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orphanetdisorderId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetdisorderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanumber</column-name><column-value><![CDATA[");
		sb.append(getOrphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orpahnetlink</column-name><column-value><![CDATA[");
		sb.append(getOrpahnetlink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasename</column-name><column-value><![CDATA[");
		sb.append(getDiseasename());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OrphanetDisorder.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OrphanetDisorder.class
		};
	private long _orphanetdisorderId;
	private long _orphanumber;
	private long _originalOrphanumber;
	private boolean _setOriginalOrphanumber;
	private String _orpahnetlink;
	private String _diseasename;
	private long _columnBitmask;
	private OrphanetDisorder _escapedModel;
}