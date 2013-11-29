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

package at.meduni.liferay.portlet.rdconnect.model;

import at.meduni.liferay.portlet.rdconnect.service.ClpSerializer;
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Robert Reihs
 */
public class MasterCandidateClp extends BaseModelImpl<MasterCandidate>
	implements MasterCandidate {
	public MasterCandidateClp() {
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterCandidateId", getMasterCandidateId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("contactperson", getContactperson());
		attributes.put("candidatetype", getCandidatetype());
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
	}

	@Override
	public long getMasterCandidateId() {
		return _masterCandidateId;
	}

	@Override
	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateId = masterCandidateId;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterCandidateId",
						long.class);

				method.invoke(_masterCandidateRemoteModel, masterCandidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_masterCandidateRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_masterCandidateRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactperson() {
		return _contactperson;
	}

	@Override
	public void setContactperson(String contactperson) {
		_contactperson = contactperson;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setContactperson", String.class);

				method.invoke(_masterCandidateRemoteModel, contactperson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCandidatetype() {
		return _candidatetype;
	}

	@Override
	public void setCandidatetype(String candidatetype) {
		_candidatetype = candidatetype;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidatetype", String.class);

				method.invoke(_masterCandidateRemoteModel, candidatetype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_masterCandidateRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasescodes() {
		return _diseasescodes;
	}

	@Override
	public void setDiseasescodes(String diseasescodes) {
		_diseasescodes = diseasescodes;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasescodes", String.class);

				method.invoke(_masterCandidateRemoteModel, diseasescodes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasesfreetext() {
		return _diseasesfreetext;
	}

	@Override
	public void setDiseasesfreetext(String diseasesfreetext) {
		_diseasesfreetext = diseasesfreetext;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasesfreetext",
						String.class);

				method.invoke(_masterCandidateRemoteModel, diseasesfreetext);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_masterCandidateRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_masterCandidateRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_masterCandidateRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMail() {
		return _mail;
	}

	@Override
	public void setMail(String mail) {
		_mail = mail;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setMail", String.class);

				method.invoke(_masterCandidateRemoteModel, mail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHead() {
		return _head;
	}

	@Override
	public void setHead(String head) {
		_head = head;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setHead", String.class);

				method.invoke(_masterCandidateRemoteModel, head);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupid() {
		return _groupid;
	}

	@Override
	public void setGroupid(long groupid) {
		_groupid = groupid;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupid", long.class);

				method.invoke(_masterCandidateRemoteModel, groupid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyid() {
		return _companyid;
	}

	@Override
	public void setCompanyid(long companyid) {
		_companyid = companyid;

		if (_masterCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyid", long.class);

				method.invoke(_masterCandidateRemoteModel, companyid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMasterCandidateRemoteModel() {
		return _masterCandidateRemoteModel;
	}

	public void setMasterCandidateRemoteModel(
		BaseModel<?> masterCandidateRemoteModel) {
		_masterCandidateRemoteModel = masterCandidateRemoteModel;
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

		Class<?> remoteModelClass = _masterCandidateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_masterCandidateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MasterCandidateLocalServiceUtil.addMasterCandidate(this);
		}
		else {
			MasterCandidateLocalServiceUtil.updateMasterCandidate(this);
		}
	}

	@Override
	public MasterCandidate toEscapedModel() {
		return (MasterCandidate)ProxyUtil.newProxyInstance(MasterCandidate.class.getClassLoader(),
			new Class[] { MasterCandidate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MasterCandidateClp clone = new MasterCandidateClp();

		clone.setMasterCandidateId(getMasterCandidateId());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setContactperson(getContactperson());
		clone.setCandidatetype(getCandidatetype());
		clone.setCountry(getCountry());
		clone.setDiseasescodes(getDiseasescodes());
		clone.setDiseasesfreetext(getDiseasesfreetext());
		clone.setComment(getComment());
		clone.setAddress(getAddress());
		clone.setDate(getDate());
		clone.setMail(getMail());
		clone.setHead(getHead());
		clone.setGroupid(getGroupid());
		clone.setCompanyid(getCompanyid());

		return clone;
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

		if (!(obj instanceof MasterCandidateClp)) {
			return false;
		}

		MasterCandidateClp masterCandidate = (MasterCandidateClp)obj;

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
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

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

		sb.append("</model>");

		return sb.toString();
	}

	private long _masterCandidateId;
	private String _name;
	private String _url;
	private String _contactperson;
	private String _candidatetype;
	private String _country;
	private String _diseasescodes;
	private String _diseasesfreetext;
	private String _comment;
	private String _address;
	private Date _date;
	private String _mail;
	private String _head;
	private long _groupid;
	private long _companyid;
	private BaseModel<?> _masterCandidateRemoteModel;
}