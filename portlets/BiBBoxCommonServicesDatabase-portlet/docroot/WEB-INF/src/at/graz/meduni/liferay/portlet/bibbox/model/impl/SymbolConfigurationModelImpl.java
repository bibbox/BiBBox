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

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfigurationModel;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfigurationSoap;

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
 * The base model implementation for the SymbolConfiguration service. Represents a row in the &quot;bibboxcs.symbolconfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfigurationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SymbolConfigurationImpl}.
 * </p>
 *
 * @author reihsr
 * @see SymbolConfigurationImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration
 * @see at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfigurationModel
 * @generated
 */
@JSON(strict = true)
public class SymbolConfigurationModelImpl extends BaseModelImpl<SymbolConfiguration>
	implements SymbolConfigurationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a symbol configuration model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration} interface instead.
	 */
	public static final String TABLE_NAME = "bibboxcs.symbolconfiguration";
	public static final Object[][] TABLE_COLUMNS = {
			{ "symbolconfigurationId", Types.BIGINT },
			{ "scope", Types.VARCHAR },
			{ "eventtype", Types.VARCHAR },
			{ "basecolor", Types.VARCHAR },
			{ "symboltype", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table bibboxcs.symbolconfiguration (symbolconfigurationId LONG not null primary key,scope TEXT null,eventtype VARCHAR(75) null,basecolor VARCHAR(75) null,symboltype VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table bibboxcs.symbolconfiguration";
	public static final String ORDER_BY_JPQL = " ORDER BY symbolConfiguration.symbolconfigurationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY bibboxcs.symbolconfiguration.symbolconfigurationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration"),
			true);
	public static long EVENTTYPE_COLUMN_BITMASK = 1L;
	public static long SCOPE_COLUMN_BITMASK = 2L;
	public static long SYMBOLCONFIGURATIONID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SymbolConfiguration toModel(SymbolConfigurationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SymbolConfiguration model = new SymbolConfigurationImpl();

		model.setSymbolconfigurationId(soapModel.getSymbolconfigurationId());
		model.setScope(soapModel.getScope());
		model.setEventtype(soapModel.getEventtype());
		model.setBasecolor(soapModel.getBasecolor());
		model.setSymboltype(soapModel.getSymboltype());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SymbolConfiguration> toModels(
		SymbolConfigurationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SymbolConfiguration> models = new ArrayList<SymbolConfiguration>(soapModels.length);

		for (SymbolConfigurationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration"));

	public SymbolConfigurationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _symbolconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSymbolconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _symbolconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SymbolConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SymbolConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("scope", getScope());
		attributes.put("eventtype", getEventtype());
		attributes.put("basecolor", getBasecolor());
		attributes.put("symboltype", getSymboltype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String eventtype = (String)attributes.get("eventtype");

		if (eventtype != null) {
			setEventtype(eventtype);
		}

		String basecolor = (String)attributes.get("basecolor");

		if (basecolor != null) {
			setBasecolor(basecolor);
		}

		String symboltype = (String)attributes.get("symboltype");

		if (symboltype != null) {
			setSymboltype(symboltype);
		}
	}

	@JSON
	@Override
	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolconfigurationId = symbolconfigurationId;
	}

	@JSON
	@Override
	public String getScope() {
		if (_scope == null) {
			return StringPool.BLANK;
		}
		else {
			return _scope;
		}
	}

	@Override
	public void setScope(String scope) {
		_columnBitmask |= SCOPE_COLUMN_BITMASK;

		if (_originalScope == null) {
			_originalScope = _scope;
		}

		_scope = scope;
	}

	public String getOriginalScope() {
		return GetterUtil.getString(_originalScope);
	}

	@JSON
	@Override
	public String getEventtype() {
		if (_eventtype == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventtype;
		}
	}

	@Override
	public void setEventtype(String eventtype) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventtype == null) {
			_originalEventtype = _eventtype;
		}

		_eventtype = eventtype;
	}

	public String getOriginalEventtype() {
		return GetterUtil.getString(_originalEventtype);
	}

	@JSON
	@Override
	public String getBasecolor() {
		if (_basecolor == null) {
			return StringPool.BLANK;
		}
		else {
			return _basecolor;
		}
	}

	@Override
	public void setBasecolor(String basecolor) {
		_basecolor = basecolor;
	}

	@JSON
	@Override
	public String getSymboltype() {
		if (_symboltype == null) {
			return StringPool.BLANK;
		}
		else {
			return _symboltype;
		}
	}

	@Override
	public void setSymboltype(String symboltype) {
		_symboltype = symboltype;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SymbolConfiguration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SymbolConfiguration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SymbolConfiguration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SymbolConfigurationImpl symbolConfigurationImpl = new SymbolConfigurationImpl();

		symbolConfigurationImpl.setSymbolconfigurationId(getSymbolconfigurationId());
		symbolConfigurationImpl.setScope(getScope());
		symbolConfigurationImpl.setEventtype(getEventtype());
		symbolConfigurationImpl.setBasecolor(getBasecolor());
		symbolConfigurationImpl.setSymboltype(getSymboltype());

		symbolConfigurationImpl.resetOriginalValues();

		return symbolConfigurationImpl;
	}

	@Override
	public int compareTo(SymbolConfiguration symbolConfiguration) {
		long primaryKey = symbolConfiguration.getPrimaryKey();

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

		if (!(obj instanceof SymbolConfiguration)) {
			return false;
		}

		SymbolConfiguration symbolConfiguration = (SymbolConfiguration)obj;

		long primaryKey = symbolConfiguration.getPrimaryKey();

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
		SymbolConfigurationModelImpl symbolConfigurationModelImpl = this;

		symbolConfigurationModelImpl._originalScope = symbolConfigurationModelImpl._scope;

		symbolConfigurationModelImpl._originalEventtype = symbolConfigurationModelImpl._eventtype;

		symbolConfigurationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SymbolConfiguration> toCacheModel() {
		SymbolConfigurationCacheModel symbolConfigurationCacheModel = new SymbolConfigurationCacheModel();

		symbolConfigurationCacheModel.symbolconfigurationId = getSymbolconfigurationId();

		symbolConfigurationCacheModel.scope = getScope();

		String scope = symbolConfigurationCacheModel.scope;

		if ((scope != null) && (scope.length() == 0)) {
			symbolConfigurationCacheModel.scope = null;
		}

		symbolConfigurationCacheModel.eventtype = getEventtype();

		String eventtype = symbolConfigurationCacheModel.eventtype;

		if ((eventtype != null) && (eventtype.length() == 0)) {
			symbolConfigurationCacheModel.eventtype = null;
		}

		symbolConfigurationCacheModel.basecolor = getBasecolor();

		String basecolor = symbolConfigurationCacheModel.basecolor;

		if ((basecolor != null) && (basecolor.length() == 0)) {
			symbolConfigurationCacheModel.basecolor = null;
		}

		symbolConfigurationCacheModel.symboltype = getSymboltype();

		String symboltype = symbolConfigurationCacheModel.symboltype;

		if ((symboltype != null) && (symboltype.length() == 0)) {
			symbolConfigurationCacheModel.symboltype = null;
		}

		return symbolConfigurationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{symbolconfigurationId=");
		sb.append(getSymbolconfigurationId());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append(", eventtype=");
		sb.append(getEventtype());
		sb.append(", basecolor=");
		sb.append(getBasecolor());
		sb.append(", symboltype=");
		sb.append(getSymboltype());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>symbolconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getSymbolconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventtype</column-name><column-value><![CDATA[");
		sb.append(getEventtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>basecolor</column-name><column-value><![CDATA[");
		sb.append(getBasecolor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symboltype</column-name><column-value><![CDATA[");
		sb.append(getSymboltype());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SymbolConfiguration.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SymbolConfiguration.class
		};
	private long _symbolconfigurationId;
	private String _scope;
	private String _originalScope;
	private String _eventtype;
	private String _originalEventtype;
	private String _basecolor;
	private String _symboltype;
	private long _columnBitmask;
	private SymbolConfiguration _escapedModel;
}