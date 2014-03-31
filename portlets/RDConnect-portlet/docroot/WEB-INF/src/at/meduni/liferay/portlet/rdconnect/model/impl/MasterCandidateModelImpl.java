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

package at.meduni.liferay.portlet.rdconnect.model.impl;

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MasterCandidate service. Represents a row in the &quot;rdconnect.master_candidate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.meduni.liferay.portlet.rdconnect.model.MasterCandidateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MasterCandidateImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see MasterCandidateImpl
 * @see at.meduni.liferay.portlet.rdconnect.model.MasterCandidate
 * @see at.meduni.liferay.portlet.rdconnect.model.MasterCandidateModel
 * @generated
 */
public class MasterCandidateModelImpl extends BaseModelImpl<MasterCandidate>
	implements MasterCandidateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a master candidate model instance should use the {@link at.meduni.liferay.portlet.rdconnect.model.MasterCandidate} interface instead.
	 */
	public static final String TABLE_NAME = "rdconnect.master_candidate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "masterCandidateId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "url", Types.VARCHAR },
			{ "contactperson", Types.VARCHAR },
			{ "candidatetype", Types.VARCHAR },
			{ "candidatesubtype", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "diseasescodes", Types.VARCHAR },
			{ "diseasesfreetext", Types.VARCHAR },
			{ "comment_", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP },
			{ "mail", Types.VARCHAR },
			{ "head", Types.VARCHAR },
			{ "groupid", Types.BIGINT },
			{ "companyid", Types.BIGINT },
			{ "organisationid", Types.BIGINT },
			{ "joinId", Types.BIGINT },
			{ "accepted", Types.BOOLEAN },
			{ "state_", Types.VARCHAR },
			{ "diseasescodesauto", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rdconnect.master_candidate (masterCandidateId LONG not null primary key,name VARCHAR(255) null,url TEXT null,contactperson TEXT null,candidatetype VARCHAR(75) null,candidatesubtype VARCHAR(75) null,country VARCHAR(75) null,diseasescodes TEXT null,diseasesfreetext TEXT null,comment_ TEXT null,address TEXT null,date_ DATE null,mail VARCHAR(255) null,head TEXT null,groupid LONG,companyid LONG,organisationid LONG,joinId LONG,accepted BOOLEAN,state_ VARCHAR(75) null,diseasescodesauto VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rdconnect.master_candidate";
	public static final String ORDER_BY_JPQL = " ORDER BY masterCandidate.country ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rdconnect.master_candidate.country ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.meduni.liferay.portlet.rdconnect.model.MasterCandidate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.meduni.liferay.portlet.rdconnect.model.MasterCandidate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.meduni.liferay.portlet.rdconnect.model.MasterCandidate"),
			true);
	public static long CANDIDATETYPE_COLUMN_BITMASK = 1L;
	public static long COUNTRY_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;
	public static long ORGANISATIONID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.meduni.liferay.portlet.rdconnect.model.MasterCandidate"));

	public MasterCandidateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _masterCandidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMasterCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _masterCandidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MasterCandidate.class;
	}

	@Override
	public String getModelClassName() {
		return MasterCandidate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterCandidateId", getMasterCandidateId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("contactperson", getContactperson());
		attributes.put("candidatetype", getCandidatetype());
		attributes.put("candidatesubtype", getCandidatesubtype());
		attributes.put("country", getCountry());
		attributes.put("diseasescodes", getDiseasescodes());
		attributes.put("diseasesfreetext", getDiseasesfreetext());
		attributes.put("comment", getComment());
		attributes.put("address", getAddress());
		attributes.put("date", getDate());
		attributes.put("mail", getMail());
		attributes.put("head", getHead());
		attributes.put("groupid", getGroupid());
		attributes.put("companyid", getCompanyid());
		attributes.put("organisationid", getOrganisationid());
		attributes.put("joinId", getJoinId());
		attributes.put("accepted", getAccepted());
		attributes.put("state", getState());
		attributes.put("diseasescodesauto", getDiseasescodesauto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterCandidateId = (Long)attributes.get("masterCandidateId");

		if (masterCandidateId != null) {
			setMasterCandidateId(masterCandidateId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String contactperson = (String)attributes.get("contactperson");

		if (contactperson != null) {
			setContactperson(contactperson);
		}

		String candidatetype = (String)attributes.get("candidatetype");

		if (candidatetype != null) {
			setCandidatetype(candidatetype);
		}

		String candidatesubtype = (String)attributes.get("candidatesubtype");

		if (candidatesubtype != null) {
			setCandidatesubtype(candidatesubtype);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String diseasescodes = (String)attributes.get("diseasescodes");

		if (diseasescodes != null) {
			setDiseasescodes(diseasescodes);
		}

		String diseasesfreetext = (String)attributes.get("diseasesfreetext");

		if (diseasesfreetext != null) {
			setDiseasesfreetext(diseasesfreetext);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String head = (String)attributes.get("head");

		if (head != null) {
			setHead(head);
		}

		Long groupid = (Long)attributes.get("groupid");

		if (groupid != null) {
			setGroupid(groupid);
		}

		Long companyid = (Long)attributes.get("companyid");

		if (companyid != null) {
			setCompanyid(companyid);
		}

		Long organisationid = (Long)attributes.get("organisationid");

		if (organisationid != null) {
			setOrganisationid(organisationid);
		}

		Long joinId = (Long)attributes.get("joinId");

		if (joinId != null) {
			setJoinId(joinId);
		}

		Boolean accepted = (Boolean)attributes.get("accepted");

		if (accepted != null) {
			setAccepted(accepted);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String diseasescodesauto = (String)attributes.get("diseasescodesauto");

		if (diseasescodesauto != null) {
			setDiseasescodesauto(diseasescodesauto);
		}
	}

	@Override
	public long getMasterCandidateId() {
		return _masterCandidateId;
	}

	@Override
	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateId = masterCandidateId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@Override
	public String getContactperson() {
		if (_contactperson == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactperson;
		}
	}

	@Override
	public void setContactperson(String contactperson) {
		_contactperson = contactperson;
	}

	@Override
	public String getCandidatetype() {
		if (_candidatetype == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidatetype;
		}
	}

	@Override
	public void setCandidatetype(String candidatetype) {
		_columnBitmask |= CANDIDATETYPE_COLUMN_BITMASK;

		if (_originalCandidatetype == null) {
			_originalCandidatetype = _candidatetype;
		}

		_candidatetype = candidatetype;
	}

	public String getOriginalCandidatetype() {
		return GetterUtil.getString(_originalCandidatetype);
	}

	@Override
	public String getCandidatesubtype() {
		if (_candidatesubtype == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidatesubtype;
		}
	}

	@Override
	public void setCandidatesubtype(String candidatesubtype) {
		_candidatesubtype = candidatesubtype;
	}

	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_columnBitmask = -1L;

		if (_originalCountry == null) {
			_originalCountry = _country;
		}

		_country = country;
	}

	public String getOriginalCountry() {
		return GetterUtil.getString(_originalCountry);
	}

	@Override
	public String getDiseasescodes() {
		if (_diseasescodes == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseasescodes;
		}
	}

	@Override
	public void setDiseasescodes(String diseasescodes) {
		_diseasescodes = diseasescodes;
	}

	@Override
	public String getDiseasesfreetext() {
		if (_diseasesfreetext == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseasesfreetext;
		}
	}

	@Override
	public void setDiseasesfreetext(String diseasesfreetext) {
		_diseasesfreetext = diseasesfreetext;
	}

	@Override
	public String getComment() {
		if (_comment == null) {
			return StringPool.BLANK;
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	@Override
	public String getMail() {
		if (_mail == null) {
			return StringPool.BLANK;
		}
		else {
			return _mail;
		}
	}

	@Override
	public void setMail(String mail) {
		_mail = mail;
	}

	@Override
	public String getHead() {
		if (_head == null) {
			return StringPool.BLANK;
		}
		else {
			return _head;
		}
	}

	@Override
	public void setHead(String head) {
		_head = head;
	}

	@Override
	public long getGroupid() {
		return _groupid;
	}

	@Override
	public void setGroupid(long groupid) {
		_groupid = groupid;
	}

	@Override
	public long getCompanyid() {
		return _companyid;
	}

	@Override
	public void setCompanyid(long companyid) {
		_companyid = companyid;
	}

	@Override
	public long getOrganisationid() {
		return _organisationid;
	}

	@Override
	public void setOrganisationid(long organisationid) {
		_columnBitmask |= ORGANISATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganisationid) {
			_setOriginalOrganisationid = true;

			_originalOrganisationid = _organisationid;
		}

		_organisationid = organisationid;
	}

	public long getOriginalOrganisationid() {
		return _originalOrganisationid;
	}

	@Override
	public long getJoinId() {
		return _joinId;
	}

	@Override
	public void setJoinId(long joinId) {
		_joinId = joinId;
	}

	@Override
	public boolean getAccepted() {
		return _accepted;
	}

	@Override
	public boolean isAccepted() {
		return _accepted;
	}

	@Override
	public void setAccepted(boolean accepted) {
		_accepted = accepted;
	}

	@Override
	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@Override
	public String getDiseasescodesauto() {
		if (_diseasescodesauto == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseasescodesauto;
		}
	}

	@Override
	public void setDiseasescodesauto(String diseasescodesauto) {
		_diseasescodesauto = diseasescodesauto;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MasterCandidate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MasterCandidate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MasterCandidate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MasterCandidateImpl masterCandidateImpl = new MasterCandidateImpl();

		masterCandidateImpl.setMasterCandidateId(getMasterCandidateId());
		masterCandidateImpl.setName(getName());
		masterCandidateImpl.setUrl(getUrl());
		masterCandidateImpl.setContactperson(getContactperson());
		masterCandidateImpl.setCandidatetype(getCandidatetype());
		masterCandidateImpl.setCandidatesubtype(getCandidatesubtype());
		masterCandidateImpl.setCountry(getCountry());
		masterCandidateImpl.setDiseasescodes(getDiseasescodes());
		masterCandidateImpl.setDiseasesfreetext(getDiseasesfreetext());
		masterCandidateImpl.setComment(getComment());
		masterCandidateImpl.setAddress(getAddress());
		masterCandidateImpl.setDate(getDate());
		masterCandidateImpl.setMail(getMail());
		masterCandidateImpl.setHead(getHead());
		masterCandidateImpl.setGroupid(getGroupid());
		masterCandidateImpl.setCompanyid(getCompanyid());
		masterCandidateImpl.setOrganisationid(getOrganisationid());
		masterCandidateImpl.setJoinId(getJoinId());
		masterCandidateImpl.setAccepted(getAccepted());
		masterCandidateImpl.setState(getState());
		masterCandidateImpl.setDiseasescodesauto(getDiseasescodesauto());

		masterCandidateImpl.resetOriginalValues();

		return masterCandidateImpl;
	}

	@Override
	public int compareTo(MasterCandidate masterCandidate) {
		int value = 0;

		value = getCountry().compareTo(masterCandidate.getCountry());

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

		if (!(obj instanceof MasterCandidate)) {
			return false;
		}

		MasterCandidate masterCandidate = (MasterCandidate)obj;

		long primaryKey = masterCandidate.getPrimaryKey();

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
		MasterCandidateModelImpl masterCandidateModelImpl = this;

		masterCandidateModelImpl._originalName = masterCandidateModelImpl._name;

		masterCandidateModelImpl._originalCandidatetype = masterCandidateModelImpl._candidatetype;

		masterCandidateModelImpl._originalCountry = masterCandidateModelImpl._country;

		masterCandidateModelImpl._originalOrganisationid = masterCandidateModelImpl._organisationid;

		masterCandidateModelImpl._setOriginalOrganisationid = false;

		masterCandidateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MasterCandidate> toCacheModel() {
		MasterCandidateCacheModel masterCandidateCacheModel = new MasterCandidateCacheModel();

		masterCandidateCacheModel.masterCandidateId = getMasterCandidateId();

		masterCandidateCacheModel.name = getName();

		String name = masterCandidateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			masterCandidateCacheModel.name = null;
		}

		masterCandidateCacheModel.url = getUrl();

		String url = masterCandidateCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			masterCandidateCacheModel.url = null;
		}

		masterCandidateCacheModel.contactperson = getContactperson();

		String contactperson = masterCandidateCacheModel.contactperson;

		if ((contactperson != null) && (contactperson.length() == 0)) {
			masterCandidateCacheModel.contactperson = null;
		}

		masterCandidateCacheModel.candidatetype = getCandidatetype();

		String candidatetype = masterCandidateCacheModel.candidatetype;

		if ((candidatetype != null) && (candidatetype.length() == 0)) {
			masterCandidateCacheModel.candidatetype = null;
		}

		masterCandidateCacheModel.candidatesubtype = getCandidatesubtype();

		String candidatesubtype = masterCandidateCacheModel.candidatesubtype;

		if ((candidatesubtype != null) && (candidatesubtype.length() == 0)) {
			masterCandidateCacheModel.candidatesubtype = null;
		}

		masterCandidateCacheModel.country = getCountry();

		String country = masterCandidateCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			masterCandidateCacheModel.country = null;
		}

		masterCandidateCacheModel.diseasescodes = getDiseasescodes();

		String diseasescodes = masterCandidateCacheModel.diseasescodes;

		if ((diseasescodes != null) && (diseasescodes.length() == 0)) {
			masterCandidateCacheModel.diseasescodes = null;
		}

		masterCandidateCacheModel.diseasesfreetext = getDiseasesfreetext();

		String diseasesfreetext = masterCandidateCacheModel.diseasesfreetext;

		if ((diseasesfreetext != null) && (diseasesfreetext.length() == 0)) {
			masterCandidateCacheModel.diseasesfreetext = null;
		}

		masterCandidateCacheModel.comment = getComment();

		String comment = masterCandidateCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			masterCandidateCacheModel.comment = null;
		}

		masterCandidateCacheModel.address = getAddress();

		String address = masterCandidateCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			masterCandidateCacheModel.address = null;
		}

		Date date = getDate();

		if (date != null) {
			masterCandidateCacheModel.date = date.getTime();
		}
		else {
			masterCandidateCacheModel.date = Long.MIN_VALUE;
		}

		masterCandidateCacheModel.mail = getMail();

		String mail = masterCandidateCacheModel.mail;

		if ((mail != null) && (mail.length() == 0)) {
			masterCandidateCacheModel.mail = null;
		}

		masterCandidateCacheModel.head = getHead();

		String head = masterCandidateCacheModel.head;

		if ((head != null) && (head.length() == 0)) {
			masterCandidateCacheModel.head = null;
		}

		masterCandidateCacheModel.groupid = getGroupid();

		masterCandidateCacheModel.companyid = getCompanyid();

		masterCandidateCacheModel.organisationid = getOrganisationid();

		masterCandidateCacheModel.joinId = getJoinId();

		masterCandidateCacheModel.accepted = getAccepted();

		masterCandidateCacheModel.state = getState();

		String state = masterCandidateCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			masterCandidateCacheModel.state = null;
		}

		masterCandidateCacheModel.diseasescodesauto = getDiseasescodesauto();

		String diseasescodesauto = masterCandidateCacheModel.diseasescodesauto;

		if ((diseasescodesauto != null) && (diseasescodesauto.length() == 0)) {
			masterCandidateCacheModel.diseasescodesauto = null;
		}

		return masterCandidateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{masterCandidateId=");
		sb.append(getMasterCandidateId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", contactperson=");
		sb.append(getContactperson());
		sb.append(", candidatetype=");
		sb.append(getCandidatetype());
		sb.append(", candidatesubtype=");
		sb.append(getCandidatesubtype());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", diseasescodes=");
		sb.append(getDiseasescodes());
		sb.append(", diseasesfreetext=");
		sb.append(getDiseasesfreetext());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", mail=");
		sb.append(getMail());
		sb.append(", head=");
		sb.append(getHead());
		sb.append(", groupid=");
		sb.append(getGroupid());
		sb.append(", companyid=");
		sb.append(getCompanyid());
		sb.append(", organisationid=");
		sb.append(getOrganisationid());
		sb.append(", joinId=");
		sb.append(getJoinId());
		sb.append(", accepted=");
		sb.append(getAccepted());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", diseasescodesauto=");
		sb.append(getDiseasescodesauto());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.rdconnect.model.MasterCandidate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>masterCandidateId</column-name><column-value><![CDATA[");
		sb.append(getMasterCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactperson</column-name><column-value><![CDATA[");
		sb.append(getContactperson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidatetype</column-name><column-value><![CDATA[");
		sb.append(getCandidatetype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidatesubtype</column-name><column-value><![CDATA[");
		sb.append(getCandidatesubtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasescodes</column-name><column-value><![CDATA[");
		sb.append(getDiseasescodes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasesfreetext</column-name><column-value><![CDATA[");
		sb.append(getDiseasesfreetext());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mail</column-name><column-value><![CDATA[");
		sb.append(getMail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>head</column-name><column-value><![CDATA[");
		sb.append(getHead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupid</column-name><column-value><![CDATA[");
		sb.append(getGroupid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyid</column-name><column-value><![CDATA[");
		sb.append(getCompanyid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organisationid</column-name><column-value><![CDATA[");
		sb.append(getOrganisationid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinId</column-name><column-value><![CDATA[");
		sb.append(getJoinId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accepted</column-name><column-value><![CDATA[");
		sb.append(getAccepted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasescodesauto</column-name><column-value><![CDATA[");
		sb.append(getDiseasescodesauto());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MasterCandidate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MasterCandidate.class
		};
	private long _masterCandidateId;
	private String _name;
	private String _originalName;
	private String _url;
	private String _contactperson;
	private String _candidatetype;
	private String _originalCandidatetype;
	private String _candidatesubtype;
	private String _country;
	private String _originalCountry;
	private String _diseasescodes;
	private String _diseasesfreetext;
	private String _comment;
	private String _address;
	private Date _date;
	private String _mail;
	private String _head;
	private long _groupid;
	private long _companyid;
	private long _organisationid;
	private long _originalOrganisationid;
	private boolean _setOriginalOrganisationid;
	private long _joinId;
	private boolean _accepted;
	private String _state;
	private String _diseasescodesauto;
	private long _columnBitmask;
	private MasterCandidate _escapedModel;
}