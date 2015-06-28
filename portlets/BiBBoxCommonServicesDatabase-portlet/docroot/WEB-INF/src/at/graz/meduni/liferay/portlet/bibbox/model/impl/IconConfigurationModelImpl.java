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

import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.IconConfigurationModel;
import at.graz.meduni.liferay.portlet.bibbox.model.IconConfigurationSoap;

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
 * The base model implementation for the IconConfiguration service. Represents a row in the &quot;bibboxcs.iconconfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.model.IconConfigurationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IconConfigurationImpl}.
 * </p>
 *
 * @author reihsr
 * @see IconConfigurationImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration
 * @see at.graz.meduni.liferay.portlet.bibbox.model.IconConfigurationModel
 * @generated
 */
@JSON(strict = true)
public class IconConfigurationModelImpl extends BaseModelImpl<IconConfiguration>
	implements IconConfigurationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a icon configuration model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration} interface instead.
	 */
	public static final String TABLE_NAME = "bibboxcs.iconconfiguration";
	public static final Object[][] TABLE_COLUMNS = {
			{ "iconconfigurationId", Types.BIGINT },
			{ "symbolconfigurationId", Types.BIGINT },
			{ "position", Types.VARCHAR },
			{ "key_", Types.VARCHAR },
			{ "iconsId", Types.BIGINT },
			{ "elementcolor", Types.VARCHAR },
			{ "width", Types.VARCHAR },
			{ "height", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table bibboxcs.iconconfiguration (iconconfigurationId LONG not null primary key,symbolconfigurationId LONG,position TEXT null,key_ TEXT null,iconsId LONG,elementcolor VARCHAR(75) null,width VARCHAR(75) null,height VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table bibboxcs.iconconfiguration";
	public static final String ORDER_BY_JPQL = " ORDER BY iconConfiguration.iconconfigurationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY bibboxcs.iconconfiguration.iconconfigurationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration"),
			true);
	public static long KEY_COLUMN_BITMASK = 1L;
	public static long POSITION_COLUMN_BITMASK = 2L;
	public static long SYMBOLCONFIGURATIONID_COLUMN_BITMASK = 4L;
	public static long ICONCONFIGURATIONID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static IconConfiguration toModel(IconConfigurationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		IconConfiguration model = new IconConfigurationImpl();

		model.setIconconfigurationId(soapModel.getIconconfigurationId());
		model.setSymbolconfigurationId(soapModel.getSymbolconfigurationId());
		model.setPosition(soapModel.getPosition());
		model.setKey(soapModel.getKey());
		model.setIconsId(soapModel.getIconsId());
		model.setElementcolor(soapModel.getElementcolor());
		model.setWidth(soapModel.getWidth());
		model.setHeight(soapModel.getHeight());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<IconConfiguration> toModels(
		IconConfigurationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<IconConfiguration> models = new ArrayList<IconConfiguration>(soapModels.length);

		for (IconConfigurationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration"));

	public IconConfigurationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _iconconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIconconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _iconconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return IconConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return IconConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconconfigurationId", getIconconfigurationId());
		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("position", getPosition());
		attributes.put("key", getKey());
		attributes.put("iconsId", getIconsId());
		attributes.put("elementcolor", getElementcolor());
		attributes.put("width", getWidth());
		attributes.put("height", getHeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconconfigurationId = (Long)attributes.get("iconconfigurationId");

		if (iconconfigurationId != null) {
			setIconconfigurationId(iconconfigurationId);
		}

		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Long iconsId = (Long)attributes.get("iconsId");

		if (iconsId != null) {
			setIconsId(iconsId);
		}

		String elementcolor = (String)attributes.get("elementcolor");

		if (elementcolor != null) {
			setElementcolor(elementcolor);
		}

		String width = (String)attributes.get("width");

		if (width != null) {
			setWidth(width);
		}

		String height = (String)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}
	}

	@JSON
	@Override
	public long getIconconfigurationId() {
		return _iconconfigurationId;
	}

	@Override
	public void setIconconfigurationId(long iconconfigurationId) {
		_iconconfigurationId = iconconfigurationId;
	}

	@JSON
	@Override
	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_columnBitmask |= SYMBOLCONFIGURATIONID_COLUMN_BITMASK;

		if (!_setOriginalSymbolconfigurationId) {
			_setOriginalSymbolconfigurationId = true;

			_originalSymbolconfigurationId = _symbolconfigurationId;
		}

		_symbolconfigurationId = symbolconfigurationId;
	}

	public long getOriginalSymbolconfigurationId() {
		return _originalSymbolconfigurationId;
	}

	@JSON
	@Override
	public String getPosition() {
		if (_position == null) {
			return StringPool.BLANK;
		}
		else {
			return _position;
		}
	}

	@Override
	public void setPosition(String position) {
		_columnBitmask |= POSITION_COLUMN_BITMASK;

		if (_originalPosition == null) {
			_originalPosition = _position;
		}

		_position = position;
	}

	public String getOriginalPosition() {
		return GetterUtil.getString(_originalPosition);
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
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
	public String getElementcolor() {
		if (_elementcolor == null) {
			return StringPool.BLANK;
		}
		else {
			return _elementcolor;
		}
	}

	@Override
	public void setElementcolor(String elementcolor) {
		_elementcolor = elementcolor;
	}

	@JSON
	@Override
	public String getWidth() {
		if (_width == null) {
			return StringPool.BLANK;
		}
		else {
			return _width;
		}
	}

	@Override
	public void setWidth(String width) {
		_width = width;
	}

	@JSON
	@Override
	public String getHeight() {
		if (_height == null) {
			return StringPool.BLANK;
		}
		else {
			return _height;
		}
	}

	@Override
	public void setHeight(String height) {
		_height = height;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			IconConfiguration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public IconConfiguration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (IconConfiguration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IconConfigurationImpl iconConfigurationImpl = new IconConfigurationImpl();

		iconConfigurationImpl.setIconconfigurationId(getIconconfigurationId());
		iconConfigurationImpl.setSymbolconfigurationId(getSymbolconfigurationId());
		iconConfigurationImpl.setPosition(getPosition());
		iconConfigurationImpl.setKey(getKey());
		iconConfigurationImpl.setIconsId(getIconsId());
		iconConfigurationImpl.setElementcolor(getElementcolor());
		iconConfigurationImpl.setWidth(getWidth());
		iconConfigurationImpl.setHeight(getHeight());

		iconConfigurationImpl.resetOriginalValues();

		return iconConfigurationImpl;
	}

	@Override
	public int compareTo(IconConfiguration iconConfiguration) {
		long primaryKey = iconConfiguration.getPrimaryKey();

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

		if (!(obj instanceof IconConfiguration)) {
			return false;
		}

		IconConfiguration iconConfiguration = (IconConfiguration)obj;

		long primaryKey = iconConfiguration.getPrimaryKey();

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
		IconConfigurationModelImpl iconConfigurationModelImpl = this;

		iconConfigurationModelImpl._originalSymbolconfigurationId = iconConfigurationModelImpl._symbolconfigurationId;

		iconConfigurationModelImpl._setOriginalSymbolconfigurationId = false;

		iconConfigurationModelImpl._originalPosition = iconConfigurationModelImpl._position;

		iconConfigurationModelImpl._originalKey = iconConfigurationModelImpl._key;

		iconConfigurationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<IconConfiguration> toCacheModel() {
		IconConfigurationCacheModel iconConfigurationCacheModel = new IconConfigurationCacheModel();

		iconConfigurationCacheModel.iconconfigurationId = getIconconfigurationId();

		iconConfigurationCacheModel.symbolconfigurationId = getSymbolconfigurationId();

		iconConfigurationCacheModel.position = getPosition();

		String position = iconConfigurationCacheModel.position;

		if ((position != null) && (position.length() == 0)) {
			iconConfigurationCacheModel.position = null;
		}

		iconConfigurationCacheModel.key = getKey();

		String key = iconConfigurationCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			iconConfigurationCacheModel.key = null;
		}

		iconConfigurationCacheModel.iconsId = getIconsId();

		iconConfigurationCacheModel.elementcolor = getElementcolor();

		String elementcolor = iconConfigurationCacheModel.elementcolor;

		if ((elementcolor != null) && (elementcolor.length() == 0)) {
			iconConfigurationCacheModel.elementcolor = null;
		}

		iconConfigurationCacheModel.width = getWidth();

		String width = iconConfigurationCacheModel.width;

		if ((width != null) && (width.length() == 0)) {
			iconConfigurationCacheModel.width = null;
		}

		iconConfigurationCacheModel.height = getHeight();

		String height = iconConfigurationCacheModel.height;

		if ((height != null) && (height.length() == 0)) {
			iconConfigurationCacheModel.height = null;
		}

		return iconConfigurationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{iconconfigurationId=");
		sb.append(getIconconfigurationId());
		sb.append(", symbolconfigurationId=");
		sb.append(getSymbolconfigurationId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", iconsId=");
		sb.append(getIconsId());
		sb.append(", elementcolor=");
		sb.append(getElementcolor());
		sb.append(", width=");
		sb.append(getWidth());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>iconconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getIconconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symbolconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getSymbolconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconsId</column-name><column-value><![CDATA[");
		sb.append(getIconsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementcolor</column-name><column-value><![CDATA[");
		sb.append(getElementcolor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>width</column-name><column-value><![CDATA[");
		sb.append(getWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>height</column-name><column-value><![CDATA[");
		sb.append(getHeight());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = IconConfiguration.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			IconConfiguration.class
		};
	private long _iconconfigurationId;
	private long _symbolconfigurationId;
	private long _originalSymbolconfigurationId;
	private boolean _setOriginalSymbolconfigurationId;
	private String _position;
	private String _originalPosition;
	private String _key;
	private String _originalKey;
	private long _iconsId;
	private String _elementcolor;
	private String _width;
	private String _height;
	private long _columnBitmask;
	private IconConfiguration _escapedModel;
}