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

import at.graz.meduni.liferay.portlet.bibbox.model.Icons;
import at.graz.meduni.liferay.portlet.bibbox.model.IconsModel;
import at.graz.meduni.liferay.portlet.bibbox.model.IconsSoap;

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
 * The base model implementation for the Icons service. Represents a row in the &quot;bibboxcs.icons&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.model.IconsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IconsImpl}.
 * </p>
 *
 * @author reihsr
 * @see IconsImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.Icons
 * @see at.graz.meduni.liferay.portlet.bibbox.model.IconsModel
 * @generated
 */
@JSON(strict = true)
public class IconsModelImpl extends BaseModelImpl<Icons> implements IconsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a icons model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.model.Icons} interface instead.
	 */
	public static final String TABLE_NAME = "bibboxcs.icons";
	public static final Object[][] TABLE_COLUMNS = {
			{ "iconsId", Types.BIGINT },
			{ "iconurl", Types.VARCHAR },
			{ "group_", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table bibboxcs.icons (iconsId LONG not null primary key,iconurl VARCHAR(75) null,group_ VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table bibboxcs.icons";
	public static final String ORDER_BY_JPQL = " ORDER BY icons.iconsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY bibboxcs.icons.iconsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.Icons"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.Icons"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Icons toModel(IconsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Icons model = new IconsImpl();

		model.setIconsId(soapModel.getIconsId());
		model.setIconurl(soapModel.getIconurl());
		model.setGroup(soapModel.getGroup());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Icons> toModels(IconsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Icons> models = new ArrayList<Icons>(soapModels.length);

		for (IconsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.model.Icons"));

	public IconsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _iconsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIconsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _iconsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Icons.class;
	}

	@Override
	public String getModelClassName() {
		return Icons.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconsId", getIconsId());
		attributes.put("iconurl", getIconurl());
		attributes.put("group", getGroup());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconsId = (Long)attributes.get("iconsId");

		if (iconsId != null) {
			setIconsId(iconsId);
		}

		String iconurl = (String)attributes.get("iconurl");

		if (iconurl != null) {
			setIconurl(iconurl);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}
	}

	@JSON
	@Override
	public long getIconsId() {
		return _iconsId;
	}

	@Override
	public void setIconsId(long iconsId) {
		_iconsId = iconsId;
	}

	@JSON
	@Override
	public String getIconurl() {
		if (_iconurl == null) {
			return StringPool.BLANK;
		}
		else {
			return _iconurl;
		}
	}

	@Override
	public void setIconurl(String iconurl) {
		_iconurl = iconurl;
	}

	@JSON
	@Override
	public String getGroup() {
		if (_group == null) {
			return StringPool.BLANK;
		}
		else {
			return _group;
		}
	}

	@Override
	public void setGroup(String group) {
		_group = group;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Icons.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Icons toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Icons)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IconsImpl iconsImpl = new IconsImpl();

		iconsImpl.setIconsId(getIconsId());
		iconsImpl.setIconurl(getIconurl());
		iconsImpl.setGroup(getGroup());

		iconsImpl.resetOriginalValues();

		return iconsImpl;
	}

	@Override
	public int compareTo(Icons icons) {
		long primaryKey = icons.getPrimaryKey();

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

		if (!(obj instanceof Icons)) {
			return false;
		}

		Icons icons = (Icons)obj;

		long primaryKey = icons.getPrimaryKey();

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
	public CacheModel<Icons> toCacheModel() {
		IconsCacheModel iconsCacheModel = new IconsCacheModel();

		iconsCacheModel.iconsId = getIconsId();

		iconsCacheModel.iconurl = getIconurl();

		String iconurl = iconsCacheModel.iconurl;

		if ((iconurl != null) && (iconurl.length() == 0)) {
			iconsCacheModel.iconurl = null;
		}

		iconsCacheModel.group = getGroup();

		String group = iconsCacheModel.group;

		if ((group != null) && (group.length() == 0)) {
			iconsCacheModel.group = null;
		}

		return iconsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{iconsId=");
		sb.append(getIconsId());
		sb.append(", iconurl=");
		sb.append(getIconurl());
		sb.append(", group=");
		sb.append(getGroup());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.Icons");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>iconsId</column-name><column-value><![CDATA[");
		sb.append(getIconsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconurl</column-name><column-value><![CDATA[");
		sb.append(getIconurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group</column-name><column-value><![CDATA[");
		sb.append(getGroup());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Icons.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Icons.class };
	private long _iconsId;
	private String _iconurl;
	private String _group;
	private Icons _escapedModel;
}