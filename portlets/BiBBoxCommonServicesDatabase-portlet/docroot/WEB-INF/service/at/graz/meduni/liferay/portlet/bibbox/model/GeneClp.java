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

package at.graz.meduni.liferay.portlet.bibbox.model;

import at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.GeneLocalServiceUtil;

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
public class GeneClp extends BaseModelImpl<Gene> implements Gene {
	public GeneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Gene.class;
	}

	@Override
	public String getModelClassName() {
		return Gene.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _geneId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeneId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geneId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geneId", getGeneId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("symbol", getSymbol());
		attributes.put("description", getDescription());
		attributes.put("geneorphanumber", getGeneorphanumber());
		attributes.put("genetype", getGenetype());
		attributes.put("genetypeorphanumber", getGenetypeorphanumber());
		attributes.put("genetypename", getGenetypename());
		attributes.put("disordergeneassociationtype",
			getDisordergeneassociationtype());
		attributes.put("disordergeneassociationtypename",
			getDisordergeneassociationtypename());
		attributes.put("disordergeneassociationstatus",
			getDisordergeneassociationstatus());
		attributes.put("disordergeneassociationstatusname",
			getDisordergeneassociationstatusname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String symbol = (String)attributes.get("symbol");

		if (symbol != null) {
			setSymbol(symbol);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long geneorphanumber = (Long)attributes.get("geneorphanumber");

		if (geneorphanumber != null) {
			setGeneorphanumber(geneorphanumber);
		}

		Long genetype = (Long)attributes.get("genetype");

		if (genetype != null) {
			setGenetype(genetype);
		}

		Long genetypeorphanumber = (Long)attributes.get("genetypeorphanumber");

		if (genetypeorphanumber != null) {
			setGenetypeorphanumber(genetypeorphanumber);
		}

		String genetypename = (String)attributes.get("genetypename");

		if (genetypename != null) {
			setGenetypename(genetypename);
		}

		Long disordergeneassociationtype = (Long)attributes.get(
				"disordergeneassociationtype");

		if (disordergeneassociationtype != null) {
			setDisordergeneassociationtype(disordergeneassociationtype);
		}

		String disordergeneassociationtypename = (String)attributes.get(
				"disordergeneassociationtypename");

		if (disordergeneassociationtypename != null) {
			setDisordergeneassociationtypename(disordergeneassociationtypename);
		}

		Long disordergeneassociationstatus = (Long)attributes.get(
				"disordergeneassociationstatus");

		if (disordergeneassociationstatus != null) {
			setDisordergeneassociationstatus(disordergeneassociationstatus);
		}

		String disordergeneassociationstatusname = (String)attributes.get(
				"disordergeneassociationstatusname");

		if (disordergeneassociationstatusname != null) {
			setDisordergeneassociationstatusname(disordergeneassociationstatusname);
		}
	}

	@Override
	public long getGeneId() {
		return _geneId;
	}

	@Override
	public void setGeneId(long geneId) {
		_geneId = geneId;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneId", long.class);

				method.invoke(_geneRemoteModel, geneId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetdisorderId",
						long.class);

				method.invoke(_geneRemoteModel, orphanetdisorderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSymbol() {
		return _symbol;
	}

	@Override
	public void setSymbol(String symbol) {
		_symbol = symbol;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setSymbol", String.class);

				method.invoke(_geneRemoteModel, symbol);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_geneRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGeneorphanumber() {
		return _geneorphanumber;
	}

	@Override
	public void setGeneorphanumber(long geneorphanumber) {
		_geneorphanumber = geneorphanumber;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneorphanumber", long.class);

				method.invoke(_geneRemoteModel, geneorphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGenetype() {
		return _genetype;
	}

	@Override
	public void setGenetype(long genetype) {
		_genetype = genetype;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setGenetype", long.class);

				method.invoke(_geneRemoteModel, genetype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGenetypeorphanumber() {
		return _genetypeorphanumber;
	}

	@Override
	public void setGenetypeorphanumber(long genetypeorphanumber) {
		_genetypeorphanumber = genetypeorphanumber;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setGenetypeorphanumber",
						long.class);

				method.invoke(_geneRemoteModel, genetypeorphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGenetypename() {
		return _genetypename;
	}

	@Override
	public void setGenetypename(String genetypename) {
		_genetypename = genetypename;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setGenetypename", String.class);

				method.invoke(_geneRemoteModel, genetypename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordergeneassociationtype() {
		return _disordergeneassociationtype;
	}

	@Override
	public void setDisordergeneassociationtype(long disordergeneassociationtype) {
		_disordergeneassociationtype = disordergeneassociationtype;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordergeneassociationtype",
						long.class);

				method.invoke(_geneRemoteModel, disordergeneassociationtype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisordergeneassociationtypename() {
		return _disordergeneassociationtypename;
	}

	@Override
	public void setDisordergeneassociationtypename(
		String disordergeneassociationtypename) {
		_disordergeneassociationtypename = disordergeneassociationtypename;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordergeneassociationtypename",
						String.class);

				method.invoke(_geneRemoteModel, disordergeneassociationtypename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisordergeneassociationstatus() {
		return _disordergeneassociationstatus;
	}

	@Override
	public void setDisordergeneassociationstatus(
		long disordergeneassociationstatus) {
		_disordergeneassociationstatus = disordergeneassociationstatus;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordergeneassociationstatus",
						long.class);

				method.invoke(_geneRemoteModel, disordergeneassociationstatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisordergeneassociationstatusname() {
		return _disordergeneassociationstatusname;
	}

	@Override
	public void setDisordergeneassociationstatusname(
		String disordergeneassociationstatusname) {
		_disordergeneassociationstatusname = disordergeneassociationstatusname;

		if (_geneRemoteModel != null) {
			try {
				Class<?> clazz = _geneRemoteModel.getClass();

				Method method = clazz.getMethod("setDisordergeneassociationstatusname",
						String.class);

				method.invoke(_geneRemoteModel,
					disordergeneassociationstatusname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneRemoteModel() {
		return _geneRemoteModel;
	}

	public void setGeneRemoteModel(BaseModel<?> geneRemoteModel) {
		_geneRemoteModel = geneRemoteModel;
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

		Class<?> remoteModelClass = _geneRemoteModel.getClass();

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

		Object returnValue = method.invoke(_geneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneLocalServiceUtil.addGene(this);
		}
		else {
			GeneLocalServiceUtil.updateGene(this);
		}
	}

	@Override
	public Gene toEscapedModel() {
		return (Gene)ProxyUtil.newProxyInstance(Gene.class.getClassLoader(),
			new Class[] { Gene.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneClp clone = new GeneClp();

		clone.setGeneId(getGeneId());
		clone.setOrphanetdisorderId(getOrphanetdisorderId());
		clone.setSymbol(getSymbol());
		clone.setDescription(getDescription());
		clone.setGeneorphanumber(getGeneorphanumber());
		clone.setGenetype(getGenetype());
		clone.setGenetypeorphanumber(getGenetypeorphanumber());
		clone.setGenetypename(getGenetypename());
		clone.setDisordergeneassociationtype(getDisordergeneassociationtype());
		clone.setDisordergeneassociationtypename(getDisordergeneassociationtypename());
		clone.setDisordergeneassociationstatus(getDisordergeneassociationstatus());
		clone.setDisordergeneassociationstatusname(getDisordergeneassociationstatusname());

		return clone;
	}

	@Override
	public int compareTo(Gene gene) {
		long primaryKey = gene.getPrimaryKey();

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

		if (!(obj instanceof GeneClp)) {
			return false;
		}

		GeneClp gene = (GeneClp)obj;

		long primaryKey = gene.getPrimaryKey();

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

		sb.append("{geneId=");
		sb.append(getGeneId());
		sb.append(", orphanetdisorderId=");
		sb.append(getOrphanetdisorderId());
		sb.append(", symbol=");
		sb.append(getSymbol());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", geneorphanumber=");
		sb.append(getGeneorphanumber());
		sb.append(", genetype=");
		sb.append(getGenetype());
		sb.append(", genetypeorphanumber=");
		sb.append(getGenetypeorphanumber());
		sb.append(", genetypename=");
		sb.append(getGenetypename());
		sb.append(", disordergeneassociationtype=");
		sb.append(getDisordergeneassociationtype());
		sb.append(", disordergeneassociationtypename=");
		sb.append(getDisordergeneassociationtypename());
		sb.append(", disordergeneassociationstatus=");
		sb.append(getDisordergeneassociationstatus());
		sb.append(", disordergeneassociationstatusname=");
		sb.append(getDisordergeneassociationstatusname());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.Gene");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>geneId</column-name><column-value><![CDATA[");
		sb.append(getGeneId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanetdisorderId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetdisorderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symbol</column-name><column-value><![CDATA[");
		sb.append(getSymbol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geneorphanumber</column-name><column-value><![CDATA[");
		sb.append(getGeneorphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genetype</column-name><column-value><![CDATA[");
		sb.append(getGenetype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genetypeorphanumber</column-name><column-value><![CDATA[");
		sb.append(getGenetypeorphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genetypename</column-name><column-value><![CDATA[");
		sb.append(getGenetypename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordergeneassociationtype</column-name><column-value><![CDATA[");
		sb.append(getDisordergeneassociationtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordergeneassociationtypename</column-name><column-value><![CDATA[");
		sb.append(getDisordergeneassociationtypename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordergeneassociationstatus</column-name><column-value><![CDATA[");
		sb.append(getDisordergeneassociationstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disordergeneassociationstatusname</column-name><column-value><![CDATA[");
		sb.append(getDisordergeneassociationstatusname());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _geneId;
	private long _orphanetdisorderId;
	private String _symbol;
	private String _description;
	private long _geneorphanumber;
	private long _genetype;
	private long _genetypeorphanumber;
	private String _genetypename;
	private long _disordergeneassociationtype;
	private String _disordergeneassociationtypename;
	private long _disordergeneassociationstatus;
	private String _disordergeneassociationstatusname;
	private BaseModel<?> _geneRemoteModel;
}