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

package at.graz.meduni.liferay.portlet.bibbox.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.service.model.idcard;
import at.graz.meduni.liferay.portlet.bibbox.service.model.idcardModel;
import at.graz.meduni.liferay.portlet.bibbox.service.model.idcardSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the idcard service. Represents a row in the &quot;rdconnect.idcardapiupdate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.service.model.idcardModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link idcardImpl}.
 * </p>
 *
 * @author reihsr
 * @see idcardImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.idcard
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.idcardModel
 * @generated
 */
@JSON(strict = true)
public class idcardModelImpl extends BaseModelImpl<idcard>
	implements idcardModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a idcard model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.idcard} interface instead.
	 */
	public static final String TABLE_NAME = "rdconnect.idcardapiupdate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "idcardId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userip", Types.VARCHAR },
			{ "logmsg", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table rdconnect.idcardapiupdate (idcardId LONG not null primary key,userId LONG,userip VARCHAR(75) null,logmsg VARCHAR(75) null,date_ DATE null)";
	public static final String TABLE_SQL_DROP = "drop table rdconnect.idcardapiupdate";
	public static final String ORDER_BY_JPQL = " ORDER BY idcard.idcardId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rdconnect.idcardapiupdate.idcardId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.service.model.idcard"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.service.model.idcard"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static idcard toModel(idcardSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		idcard model = new idcardImpl();

		model.setIdcardId(soapModel.getIdcardId());
		model.setUserId(soapModel.getUserId());
		model.setUserip(soapModel.getUserip());
		model.setLogmsg(soapModel.getLogmsg());
		model.setDate(soapModel.getDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<idcard> toModels(idcardSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<idcard> models = new ArrayList<idcard>(soapModels.length);

		for (idcardSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.service.model.idcard"));

	public idcardModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _idcardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdcardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idcardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return idcard.class;
	}

	@Override
	public String getModelClassName() {
		return idcard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idcardId", getIdcardId());
		attributes.put("userId", getUserId());
		attributes.put("userip", getUserip());
		attributes.put("logmsg", getLogmsg());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idcardId = (Long)attributes.get("idcardId");

		if (idcardId != null) {
			setIdcardId(idcardId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userip = (String)attributes.get("userip");

		if (userip != null) {
			setUserip(userip);
		}

		String logmsg = (String)attributes.get("logmsg");

		if (logmsg != null) {
			setLogmsg(logmsg);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@JSON
	@Override
	public long getIdcardId() {
		return _idcardId;
	}

	@Override
	public void setIdcardId(long idcardId) {
		_idcardId = idcardId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserip() {
		if (_userip == null) {
			return StringPool.BLANK;
		}
		else {
			return _userip;
		}
	}

	@Override
	public void setUserip(String userip) {
		_userip = userip;
	}

	@JSON
	@Override
	public String getLogmsg() {
		if (_logmsg == null) {
			return StringPool.BLANK;
		}
		else {
			return _logmsg;
		}
	}

	@Override
	public void setLogmsg(String logmsg) {
		_logmsg = logmsg;
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			idcard.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public idcard toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (idcard)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		idcardImpl idcardImpl = new idcardImpl();

		idcardImpl.setIdcardId(getIdcardId());
		idcardImpl.setUserId(getUserId());
		idcardImpl.setUserip(getUserip());
		idcardImpl.setLogmsg(getLogmsg());
		idcardImpl.setDate(getDate());

		idcardImpl.resetOriginalValues();

		return idcardImpl;
	}

	@Override
	public int compareTo(idcard idcard) {
		long primaryKey = idcard.getPrimaryKey();

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

		if (!(obj instanceof idcard)) {
			return false;
		}

		idcard idcard = (idcard)obj;

		long primaryKey = idcard.getPrimaryKey();

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
	public CacheModel<idcard> toCacheModel() {
		idcardCacheModel idcardCacheModel = new idcardCacheModel();

		idcardCacheModel.idcardId = getIdcardId();

		idcardCacheModel.userId = getUserId();

		idcardCacheModel.userip = getUserip();

		String userip = idcardCacheModel.userip;

		if ((userip != null) && (userip.length() == 0)) {
			idcardCacheModel.userip = null;
		}

		idcardCacheModel.logmsg = getLogmsg();

		String logmsg = idcardCacheModel.logmsg;

		if ((logmsg != null) && (logmsg.length() == 0)) {
			idcardCacheModel.logmsg = null;
		}

		Date date = getDate();

		if (date != null) {
			idcardCacheModel.date = date.getTime();
		}
		else {
			idcardCacheModel.date = Long.MIN_VALUE;
		}

		return idcardCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idcardId=");
		sb.append(getIdcardId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userip=");
		sb.append(getUserip());
		sb.append(", logmsg=");
		sb.append(getLogmsg());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.service.model.idcard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idcardId</column-name><column-value><![CDATA[");
		sb.append(getIdcardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userip</column-name><column-value><![CDATA[");
		sb.append(getUserip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logmsg</column-name><column-value><![CDATA[");
		sb.append(getLogmsg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = idcard.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { idcard.class };
	private long _idcardId;
	private long _userId;
	private String _userUuid;
	private String _userip;
	private String _logmsg;
	private Date _date;
	private idcard _escapedModel;
}