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

import at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.ClpSerializer;

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
public class CandidateClp extends BaseModelImpl<Candidate> implements Candidate {
	public CandidateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Candidate.class;
	}

	@Override
	public String getModelClassName() {
		return Candidate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateId", getCandidateId());
		attributes.put("source", getSource());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("contactperson", getContactperson());
		attributes.put("candidatetype", getCandidatetype());
		attributes.put("subunitof", getSubunitof());
		attributes.put("country", getCountry());
		attributes.put("diseasescodes", getDiseasescodes());
		attributes.put("diseasesfreetext", getDiseasesfreetext());
		attributes.put("comment", getComment());
		attributes.put("address", getAddress());
		attributes.put("date", getDate());
		attributes.put("searchurl", getSearchurl());
		attributes.put("sourceId", getSourceId());
		attributes.put("mail", getMail());
		attributes.put("head", getHead());
		attributes.put("submittername", getSubmittername());
		attributes.put("submitteremail", getSubmitteremail());
		attributes.put("validated", getValidated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
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

		String subunitof = (String)attributes.get("subunitof");

		if (subunitof != null) {
			setSubunitof(subunitof);
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

		String searchurl = (String)attributes.get("searchurl");

		if (searchurl != null) {
			setSearchurl(searchurl);
		}

		String sourceId = (String)attributes.get("sourceId");

		if (sourceId != null) {
			setSourceId(sourceId);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String head = (String)attributes.get("head");

		if (head != null) {
			setHead(head);
		}

		String submittername = (String)attributes.get("submittername");

		if (submittername != null) {
			setSubmittername(submittername);
		}

		String submitteremail = (String)attributes.get("submitteremail");

		if (submitteremail != null) {
			setSubmitteremail(submitteremail);
		}

		Boolean validated = (Boolean)attributes.get("validated");

		if (validated != null) {
			setValidated(validated);
		}
	}

	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateId", long.class);

				method.invoke(_candidateRemoteModel, candidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSource() {
		return _source;
	}

	@Override
	public void setSource(String source) {
		_source = source;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", String.class);

				method.invoke(_candidateRemoteModel, source);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_candidateRemoteModel, name);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_candidateRemoteModel, url);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setContactperson", String.class);

				method.invoke(_candidateRemoteModel, contactperson);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidatetype", String.class);

				method.invoke(_candidateRemoteModel, candidatetype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubunitof() {
		return _subunitof;
	}

	@Override
	public void setSubunitof(String subunitof) {
		_subunitof = subunitof;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubunitof", String.class);

				method.invoke(_candidateRemoteModel, subunitof);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_candidateRemoteModel, country);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasescodes", String.class);

				method.invoke(_candidateRemoteModel, diseasescodes);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasesfreetext",
						String.class);

				method.invoke(_candidateRemoteModel, diseasesfreetext);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_candidateRemoteModel, comment);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_candidateRemoteModel, address);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_candidateRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchurl() {
		return _searchurl;
	}

	@Override
	public void setSearchurl(String searchurl) {
		_searchurl = searchurl;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchurl", String.class);

				method.invoke(_candidateRemoteModel, searchurl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSourceId() {
		return _sourceId;
	}

	@Override
	public void setSourceId(String sourceId) {
		_sourceId = sourceId;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceId", String.class);

				method.invoke(_candidateRemoteModel, sourceId);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setMail", String.class);

				method.invoke(_candidateRemoteModel, mail);
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

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setHead", String.class);

				method.invoke(_candidateRemoteModel, head);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmittername() {
		return _submittername;
	}

	@Override
	public void setSubmittername(String submittername) {
		_submittername = submittername;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmittername", String.class);

				method.invoke(_candidateRemoteModel, submittername);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubmitteremail() {
		return _submitteremail;
	}

	@Override
	public void setSubmitteremail(String submitteremail) {
		_submitteremail = submitteremail;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmitteremail",
						String.class);

				method.invoke(_candidateRemoteModel, submitteremail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getValidated() {
		return _validated;
	}

	@Override
	public boolean isValidated() {
		return _validated;
	}

	@Override
	public void setValidated(boolean validated) {
		_validated = validated;

		if (_candidateRemoteModel != null) {
			try {
				Class<?> clazz = _candidateRemoteModel.getClass();

				Method method = clazz.getMethod("setValidated", boolean.class);

				method.invoke(_candidateRemoteModel, validated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCandidateRemoteModel() {
		return _candidateRemoteModel;
	}

	public void setCandidateRemoteModel(BaseModel<?> candidateRemoteModel) {
		_candidateRemoteModel = candidateRemoteModel;
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

		Class<?> remoteModelClass = _candidateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_candidateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CandidateLocalServiceUtil.addCandidate(this);
		}
		else {
			CandidateLocalServiceUtil.updateCandidate(this);
		}
	}

	@Override
	public Candidate toEscapedModel() {
		return (Candidate)ProxyUtil.newProxyInstance(Candidate.class.getClassLoader(),
			new Class[] { Candidate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CandidateClp clone = new CandidateClp();

		clone.setCandidateId(getCandidateId());
		clone.setSource(getSource());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setContactperson(getContactperson());
		clone.setCandidatetype(getCandidatetype());
		clone.setSubunitof(getSubunitof());
		clone.setCountry(getCountry());
		clone.setDiseasescodes(getDiseasescodes());
		clone.setDiseasesfreetext(getDiseasesfreetext());
		clone.setComment(getComment());
		clone.setAddress(getAddress());
		clone.setDate(getDate());
		clone.setSearchurl(getSearchurl());
		clone.setSourceId(getSourceId());
		clone.setMail(getMail());
		clone.setHead(getHead());
		clone.setSubmittername(getSubmittername());
		clone.setSubmitteremail(getSubmitteremail());
		clone.setValidated(getValidated());

		return clone;
	}

	@Override
	public int compareTo(Candidate candidate) {
		int value = 0;

		value = getCountry().compareTo(candidate.getCountry());

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

		if (!(obj instanceof CandidateClp)) {
			return false;
		}

		CandidateClp candidate = (CandidateClp)obj;

		long primaryKey = candidate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{candidateId=");
		sb.append(getCandidateId());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", contactperson=");
		sb.append(getContactperson());
		sb.append(", candidatetype=");
		sb.append(getCandidatetype());
		sb.append(", subunitof=");
		sb.append(getSubunitof());
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
		sb.append(", searchurl=");
		sb.append(getSearchurl());
		sb.append(", sourceId=");
		sb.append(getSourceId());
		sb.append(", mail=");
		sb.append(getMail());
		sb.append(", head=");
		sb.append(getHead());
		sb.append(", submittername=");
		sb.append(getSubmittername());
		sb.append(", submitteremail=");
		sb.append(getSubmitteremail());
		sb.append(", validated=");
		sb.append(getValidated());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.rdconnect.model.Candidate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
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
			"<column><column-name>subunitof</column-name><column-value><![CDATA[");
		sb.append(getSubunitof());
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
			"<column><column-name>searchurl</column-name><column-value><![CDATA[");
		sb.append(getSearchurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceId</column-name><column-value><![CDATA[");
		sb.append(getSourceId());
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
			"<column><column-name>submittername</column-name><column-value><![CDATA[");
		sb.append(getSubmittername());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>submitteremail</column-name><column-value><![CDATA[");
		sb.append(getSubmitteremail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validated</column-name><column-value><![CDATA[");
		sb.append(getValidated());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _candidateId;
	private String _source;
	private String _name;
	private String _url;
	private String _contactperson;
	private String _candidatetype;
	private String _subunitof;
	private String _country;
	private String _diseasescodes;
	private String _diseasesfreetext;
	private String _comment;
	private String _address;
	private Date _date;
	private String _searchurl;
	private String _sourceId;
	private String _mail;
	private String _head;
	private String _submittername;
	private String _submitteremail;
	private boolean _validated;
	private BaseModel<?> _candidateRemoteModel;
}