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

package at.meduni.liferay.portlet.bbmrieric.model;

import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class BioBankClp extends BaseModelImpl<BioBank> implements BioBank {
	public BioBankClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BioBank.class;
	}

	@Override
	public String getModelClassName() {
		return BioBank.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _biobankId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankId", getBiobankId());
		attributes.put("organisationid", getOrganisationid());
		attributes.put("ldapbiobankID", getLdapbiobankID());
		attributes.put("biobankcountry", getBiobankcountry());
		attributes.put("biobankname", getBiobankname());
		attributes.put("biobanktype", getBiobanktype());
		attributes.put("biobanksize", getBiobanksize());
		attributes.put("biobankdescription", getBiobankdescription());
		attributes.put("biobankjuristicperson", getBiobankjuristicperson());
		attributes.put("UUID", getUUID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankId = (Long)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		Long organisationid = (Long)attributes.get("organisationid");

		if (organisationid != null) {
			setOrganisationid(organisationid);
		}

		String ldapbiobankID = (String)attributes.get("ldapbiobankID");

		if (ldapbiobankID != null) {
			setLdapbiobankID(ldapbiobankID);
		}

		String biobankcountry = (String)attributes.get("biobankcountry");

		if (biobankcountry != null) {
			setBiobankcountry(biobankcountry);
		}

		String biobankname = (String)attributes.get("biobankname");

		if (biobankname != null) {
			setBiobankname(biobankname);
		}

		String biobanktype = (String)attributes.get("biobanktype");

		if (biobanktype != null) {
			setBiobanktype(biobanktype);
		}

		String biobanksize = (String)attributes.get("biobanksize");

		if (biobanksize != null) {
			setBiobanksize(biobanksize);
		}

		String biobankdescription = (String)attributes.get("biobankdescription");

		if (biobankdescription != null) {
			setBiobankdescription(biobankdescription);
		}

		String biobankjuristicperson = (String)attributes.get(
				"biobankjuristicperson");

		if (biobankjuristicperson != null) {
			setBiobankjuristicperson(biobankjuristicperson);
		}

		String UUID = (String)attributes.get("UUID");

		if (UUID != null) {
			setUUID(UUID);
		}
	}

	@Override
	public long getBiobankId() {
		return _biobankId;
	}

	@Override
	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankId", long.class);

				method.invoke(_bioBankRemoteModel, biobankId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganisationid() {
		return _organisationid;
	}

	@Override
	public void setOrganisationid(long organisationid) {
		_organisationid = organisationid;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationid", long.class);

				method.invoke(_bioBankRemoteModel, organisationid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdapbiobankID() {
		return _ldapbiobankID;
	}

	@Override
	public void setLdapbiobankID(String ldapbiobankID) {
		_ldapbiobankID = ldapbiobankID;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setLdapbiobankID", String.class);

				method.invoke(_bioBankRemoteModel, ldapbiobankID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankcountry() {
		return _biobankcountry;
	}

	@Override
	public void setBiobankcountry(String biobankcountry) {
		_biobankcountry = biobankcountry;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankcountry",
						String.class);

				method.invoke(_bioBankRemoteModel, biobankcountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankname() {
		return _biobankname;
	}

	@Override
	public void setBiobankname(String biobankname) {
		_biobankname = biobankname;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankname", String.class);

				method.invoke(_bioBankRemoteModel, biobankname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobanktype() {
		return _biobanktype;
	}

	@Override
	public void setBiobanktype(String biobanktype) {
		_biobanktype = biobanktype;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobanktype", String.class);

				method.invoke(_bioBankRemoteModel, biobanktype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobanksize() {
		return _biobanksize;
	}

	@Override
	public void setBiobanksize(String biobanksize) {
		_biobanksize = biobanksize;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobanksize", String.class);

				method.invoke(_bioBankRemoteModel, biobanksize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankdescription() {
		return _biobankdescription;
	}

	@Override
	public void setBiobankdescription(String biobankdescription) {
		_biobankdescription = biobankdescription;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankdescription",
						String.class);

				method.invoke(_bioBankRemoteModel, biobankdescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankjuristicperson() {
		return _biobankjuristicperson;
	}

	@Override
	public void setBiobankjuristicperson(String biobankjuristicperson) {
		_biobankjuristicperson = biobankjuristicperson;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankjuristicperson",
						String.class);

				method.invoke(_bioBankRemoteModel, biobankjuristicperson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUUID() {
		return _UUID;
	}

	@Override
	public void setUUID(String UUID) {
		_UUID = UUID;

		if (_bioBankRemoteModel != null) {
			try {
				Class<?> clazz = _bioBankRemoteModel.getClass();

				Method method = clazz.getMethod("setUUID", String.class);

				method.invoke(_bioBankRemoteModel, UUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBioBankRemoteModel() {
		return _bioBankRemoteModel;
	}

	public void setBioBankRemoteModel(BaseModel<?> bioBankRemoteModel) {
		_bioBankRemoteModel = bioBankRemoteModel;
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

		Class<?> remoteModelClass = _bioBankRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bioBankRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BioBankLocalServiceUtil.addBioBank(this);
		}
		else {
			BioBankLocalServiceUtil.updateBioBank(this);
		}
	}

	@Override
	public BioBank toEscapedModel() {
		return (BioBank)ProxyUtil.newProxyInstance(BioBank.class.getClassLoader(),
			new Class[] { BioBank.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BioBankClp clone = new BioBankClp();

		clone.setBiobankId(getBiobankId());
		clone.setOrganisationid(getOrganisationid());
		clone.setLdapbiobankID(getLdapbiobankID());
		clone.setBiobankcountry(getBiobankcountry());
		clone.setBiobankname(getBiobankname());
		clone.setBiobanktype(getBiobanktype());
		clone.setBiobanksize(getBiobanksize());
		clone.setBiobankdescription(getBiobankdescription());
		clone.setBiobankjuristicperson(getBiobankjuristicperson());
		clone.setUUID(getUUID());

		return clone;
	}

	@Override
	public int compareTo(BioBank bioBank) {
		long primaryKey = bioBank.getPrimaryKey();

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

		if (!(obj instanceof BioBankClp)) {
			return false;
		}

		BioBankClp bioBank = (BioBankClp)obj;

		long primaryKey = bioBank.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{biobankId=");
		sb.append(getBiobankId());
		sb.append(", organisationid=");
		sb.append(getOrganisationid());
		sb.append(", ldapbiobankID=");
		sb.append(getLdapbiobankID());
		sb.append(", biobankcountry=");
		sb.append(getBiobankcountry());
		sb.append(", biobankname=");
		sb.append(getBiobankname());
		sb.append(", biobanktype=");
		sb.append(getBiobanktype());
		sb.append(", biobanksize=");
		sb.append(getBiobanksize());
		sb.append(", biobankdescription=");
		sb.append(getBiobankdescription());
		sb.append(", biobankjuristicperson=");
		sb.append(getBiobankjuristicperson());
		sb.append(", UUID=");
		sb.append(getUUID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.model.BioBank");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankId</column-name><column-value><![CDATA[");
		sb.append(getBiobankId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organisationid</column-name><column-value><![CDATA[");
		sb.append(getOrganisationid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldapbiobankID</column-name><column-value><![CDATA[");
		sb.append(getLdapbiobankID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankcountry</column-name><column-value><![CDATA[");
		sb.append(getBiobankcountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankname</column-name><column-value><![CDATA[");
		sb.append(getBiobankname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobanktype</column-name><column-value><![CDATA[");
		sb.append(getBiobanktype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobanksize</column-name><column-value><![CDATA[");
		sb.append(getBiobanksize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankdescription</column-name><column-value><![CDATA[");
		sb.append(getBiobankdescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankjuristicperson</column-name><column-value><![CDATA[");
		sb.append(getBiobankjuristicperson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UUID</column-name><column-value><![CDATA[");
		sb.append(getUUID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biobankId;
	private long _organisationid;
	private String _ldapbiobankID;
	private String _biobankcountry;
	private String _biobankname;
	private String _biobanktype;
	private String _biobanksize;
	private String _biobankdescription;
	private String _biobankjuristicperson;
	private String _UUID;
	private BaseModel<?> _bioBankRemoteModel;
}