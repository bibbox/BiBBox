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

package at.rdconnect.update.model;

import at.rdconnect.update.service.AddressUpdateLocalServiceUtil;
import at.rdconnect.update.service.ClpSerializer;

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
public class AddressUpdateClp extends BaseModelImpl<AddressUpdate>
	implements AddressUpdate {
	public AddressUpdateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AddressUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return AddressUpdate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _addressid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAddressid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _addressid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressid", getAddressid());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("street3", getStreet3());
		attributes.put("city", getCity());
		attributes.put("zip", getZip());
		attributes.put("regionid", getRegionid());
		attributes.put("contryid", getContryid());
		attributes.put("typeid", getTypeid());
		attributes.put("mailing", getMailing());
		attributes.put("primary_ad", getPrimary_ad());
		attributes.put("organizationid", getOrganizationid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressid = (Long)attributes.get("addressid");

		if (addressid != null) {
			setAddressid(addressid);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String street3 = (String)attributes.get("street3");

		if (street3 != null) {
			setStreet3(street3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		Long regionid = (Long)attributes.get("regionid");

		if (regionid != null) {
			setRegionid(regionid);
		}

		Long contryid = (Long)attributes.get("contryid");

		if (contryid != null) {
			setContryid(contryid);
		}

		Long typeid = (Long)attributes.get("typeid");

		if (typeid != null) {
			setTypeid(typeid);
		}

		Boolean mailing = (Boolean)attributes.get("mailing");

		if (mailing != null) {
			setMailing(mailing);
		}

		Boolean primary_ad = (Boolean)attributes.get("primary_ad");

		if (primary_ad != null) {
			setPrimary_ad(primary_ad);
		}

		Long organizationid = (Long)attributes.get("organizationid");

		if (organizationid != null) {
			setOrganizationid(organizationid);
		}
	}

	@Override
	public long getAddressid() {
		return _addressid;
	}

	@Override
	public void setAddressid(long addressid) {
		_addressid = addressid;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressid", long.class);

				method.invoke(_addressUpdateRemoteModel, addressid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet1() {
		return _street1;
	}

	@Override
	public void setStreet1(String street1) {
		_street1 = street1;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet1", String.class);

				method.invoke(_addressUpdateRemoteModel, street1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet2() {
		return _street2;
	}

	@Override
	public void setStreet2(String street2) {
		_street2 = street2;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet2", String.class);

				method.invoke(_addressUpdateRemoteModel, street2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet3() {
		return _street3;
	}

	@Override
	public void setStreet3(String street3) {
		_street3 = street3;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet3", String.class);

				method.invoke(_addressUpdateRemoteModel, street3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_addressUpdateRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZip() {
		return _zip;
	}

	@Override
	public void setZip(String zip) {
		_zip = zip;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", String.class);

				method.invoke(_addressUpdateRemoteModel, zip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionid() {
		return _regionid;
	}

	@Override
	public void setRegionid(long regionid) {
		_regionid = regionid;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionid", long.class);

				method.invoke(_addressUpdateRemoteModel, regionid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContryid() {
		return _contryid;
	}

	@Override
	public void setContryid(long contryid) {
		_contryid = contryid;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setContryid", long.class);

				method.invoke(_addressUpdateRemoteModel, contryid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeid() {
		return _typeid;
	}

	@Override
	public void setTypeid(long typeid) {
		_typeid = typeid;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeid", long.class);

				method.invoke(_addressUpdateRemoteModel, typeid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMailing() {
		return _mailing;
	}

	@Override
	public boolean isMailing() {
		return _mailing;
	}

	@Override
	public void setMailing(boolean mailing) {
		_mailing = mailing;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setMailing", boolean.class);

				method.invoke(_addressUpdateRemoteModel, mailing);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPrimary_ad() {
		return _primary_ad;
	}

	@Override
	public boolean isPrimary_ad() {
		return _primary_ad;
	}

	@Override
	public void setPrimary_ad(boolean primary_ad) {
		_primary_ad = primary_ad;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setPrimary_ad", boolean.class);

				method.invoke(_addressUpdateRemoteModel, primary_ad);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationid() {
		return _organizationid;
	}

	@Override
	public void setOrganizationid(long organizationid) {
		_organizationid = organizationid;

		if (_addressUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _addressUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationid", long.class);

				method.invoke(_addressUpdateRemoteModel, organizationid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressUpdateRemoteModel() {
		return _addressUpdateRemoteModel;
	}

	public void setAddressUpdateRemoteModel(
		BaseModel<?> addressUpdateRemoteModel) {
		_addressUpdateRemoteModel = addressUpdateRemoteModel;
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

		Class<?> remoteModelClass = _addressUpdateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_addressUpdateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressUpdateLocalServiceUtil.addAddressUpdate(this);
		}
		else {
			AddressUpdateLocalServiceUtil.updateAddressUpdate(this);
		}
	}

	@Override
	public AddressUpdate toEscapedModel() {
		return (AddressUpdate)ProxyUtil.newProxyInstance(AddressUpdate.class.getClassLoader(),
			new Class[] { AddressUpdate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AddressUpdateClp clone = new AddressUpdateClp();

		clone.setAddressid(getAddressid());
		clone.setStreet1(getStreet1());
		clone.setStreet2(getStreet2());
		clone.setStreet3(getStreet3());
		clone.setCity(getCity());
		clone.setZip(getZip());
		clone.setRegionid(getRegionid());
		clone.setContryid(getContryid());
		clone.setTypeid(getTypeid());
		clone.setMailing(getMailing());
		clone.setPrimary_ad(getPrimary_ad());
		clone.setOrganizationid(getOrganizationid());

		return clone;
	}

	@Override
	public int compareTo(AddressUpdate addressUpdate) {
		int value = 0;

		if (getOrganizationid() < addressUpdate.getOrganizationid()) {
			value = -1;
		}
		else if (getOrganizationid() > addressUpdate.getOrganizationid()) {
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

		if (!(obj instanceof AddressUpdateClp)) {
			return false;
		}

		AddressUpdateClp addressUpdate = (AddressUpdateClp)obj;

		long primaryKey = addressUpdate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{addressid=");
		sb.append(getAddressid());
		sb.append(", street1=");
		sb.append(getStreet1());
		sb.append(", street2=");
		sb.append(getStreet2());
		sb.append(", street3=");
		sb.append(getStreet3());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", regionid=");
		sb.append(getRegionid());
		sb.append(", contryid=");
		sb.append(getContryid());
		sb.append(", typeid=");
		sb.append(getTypeid());
		sb.append(", mailing=");
		sb.append(getMailing());
		sb.append(", primary_ad=");
		sb.append(getPrimary_ad());
		sb.append(", organizationid=");
		sb.append(getOrganizationid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("at.rdconnect.update.model.AddressUpdate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>addressid</column-name><column-value><![CDATA[");
		sb.append(getAddressid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street1</column-name><column-value><![CDATA[");
		sb.append(getStreet1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street2</column-name><column-value><![CDATA[");
		sb.append(getStreet2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street3</column-name><column-value><![CDATA[");
		sb.append(getStreet3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionid</column-name><column-value><![CDATA[");
		sb.append(getRegionid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contryid</column-name><column-value><![CDATA[");
		sb.append(getContryid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeid</column-name><column-value><![CDATA[");
		sb.append(getTypeid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailing</column-name><column-value><![CDATA[");
		sb.append(getMailing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>primary_ad</column-name><column-value><![CDATA[");
		sb.append(getPrimary_ad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationid</column-name><column-value><![CDATA[");
		sb.append(getOrganizationid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _addressid;
	private String _street1;
	private String _street2;
	private String _street3;
	private String _city;
	private String _zip;
	private long _regionid;
	private long _contryid;
	private long _typeid;
	private boolean _mailing;
	private boolean _primary_ad;
	private long _organizationid;
	private BaseModel<?> _addressUpdateRemoteModel;
}