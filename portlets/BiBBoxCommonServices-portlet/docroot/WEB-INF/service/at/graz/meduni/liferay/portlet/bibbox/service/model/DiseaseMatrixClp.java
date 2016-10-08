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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

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
 * @author reihsr
 */
public class DiseaseMatrixClp extends BaseModelImpl<DiseaseMatrix>
	implements DiseaseMatrix {
	public DiseaseMatrixClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DiseaseMatrix.class;
	}

	@Override
	public String getModelClassName() {
		return DiseaseMatrix.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _diseasematrixId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDiseasematrixId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _diseasematrixId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("diseasematrixId", getDiseasematrixId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("diseasename", getDiseasename());
		attributes.put("patientcount", getPatientcount());
		attributes.put("gene", getGene());
		attributes.put("orphanumber", getOrphanumber());
		attributes.put("icd10", getIcd10());
		attributes.put("omim", getOmim());
		attributes.put("synonym", getSynonym());
		attributes.put("modifieddate", getModifieddate());
		attributes.put("modifieduser", getModifieduser());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long diseasematrixId = (Long)attributes.get("diseasematrixId");

		if (diseasematrixId != null) {
			setDiseasematrixId(diseasematrixId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String diseasename = (String)attributes.get("diseasename");

		if (diseasename != null) {
			setDiseasename(diseasename);
		}

		String patientcount = (String)attributes.get("patientcount");

		if (patientcount != null) {
			setPatientcount(patientcount);
		}

		String gene = (String)attributes.get("gene");

		if (gene != null) {
			setGene(gene);
		}

		String orphanumber = (String)attributes.get("orphanumber");

		if (orphanumber != null) {
			setOrphanumber(orphanumber);
		}

		String icd10 = (String)attributes.get("icd10");

		if (icd10 != null) {
			setIcd10(icd10);
		}

		String omim = (String)attributes.get("omim");

		if (omim != null) {
			setOmim(omim);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}

		String modifieduser = (String)attributes.get("modifieduser");

		if (modifieduser != null) {
			setModifieduser(modifieduser);
		}
	}

	@Override
	public long getDiseasematrixId() {
		return _diseasematrixId;
	}

	@Override
	public void setDiseasematrixId(long diseasematrixId) {
		_diseasematrixId = diseasematrixId;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasematrixId", long.class);

				method.invoke(_diseaseMatrixRemoteModel, diseasematrixId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_diseaseMatrixRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseasename() {
		return _diseasename;
	}

	@Override
	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseasename", String.class);

				method.invoke(_diseaseMatrixRemoteModel, diseasename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatientcount() {
		return _patientcount;
	}

	@Override
	public void setPatientcount(String patientcount) {
		_patientcount = patientcount;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientcount", String.class);

				method.invoke(_diseaseMatrixRemoteModel, patientcount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGene() {
		return _gene;
	}

	@Override
	public void setGene(String gene) {
		_gene = gene;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setGene", String.class);

				method.invoke(_diseaseMatrixRemoteModel, gene);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrphanumber() {
		return _orphanumber;
	}

	@Override
	public void setOrphanumber(String orphanumber) {
		_orphanumber = orphanumber;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanumber", String.class);

				method.invoke(_diseaseMatrixRemoteModel, orphanumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIcd10() {
		return _icd10;
	}

	@Override
	public void setIcd10(String icd10) {
		_icd10 = icd10;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setIcd10", String.class);

				method.invoke(_diseaseMatrixRemoteModel, icd10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOmim() {
		return _omim;
	}

	@Override
	public void setOmim(String omim) {
		_omim = omim;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setOmim", String.class);

				method.invoke(_diseaseMatrixRemoteModel, omim);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSynonym() {
		return _synonym;
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setSynonym", String.class);

				method.invoke(_diseaseMatrixRemoteModel, synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifieddate() {
		return _modifieddate;
	}

	@Override
	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setModifieddate", Date.class);

				method.invoke(_diseaseMatrixRemoteModel, modifieddate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifieduser() {
		return _modifieduser;
	}

	@Override
	public void setModifieduser(String modifieduser) {
		_modifieduser = modifieduser;

		if (_diseaseMatrixRemoteModel != null) {
			try {
				Class<?> clazz = _diseaseMatrixRemoteModel.getClass();

				Method method = clazz.getMethod("setModifieduser", String.class);

				method.invoke(_diseaseMatrixRemoteModel, modifieduser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDiseaseMatrixRemoteModel() {
		return _diseaseMatrixRemoteModel;
	}

	public void setDiseaseMatrixRemoteModel(
		BaseModel<?> diseaseMatrixRemoteModel) {
		_diseaseMatrixRemoteModel = diseaseMatrixRemoteModel;
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

		Class<?> remoteModelClass = _diseaseMatrixRemoteModel.getClass();

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

		Object returnValue = method.invoke(_diseaseMatrixRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DiseaseMatrixLocalServiceUtil.addDiseaseMatrix(this);
		}
		else {
			DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(this);
		}
	}

	@Override
	public DiseaseMatrix toEscapedModel() {
		return (DiseaseMatrix)ProxyUtil.newProxyInstance(DiseaseMatrix.class.getClassLoader(),
			new Class[] { DiseaseMatrix.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DiseaseMatrixClp clone = new DiseaseMatrixClp();

		clone.setDiseasematrixId(getDiseasematrixId());
		clone.setOrganizationId(getOrganizationId());
		clone.setDiseasename(getDiseasename());
		clone.setPatientcount(getPatientcount());
		clone.setGene(getGene());
		clone.setOrphanumber(getOrphanumber());
		clone.setIcd10(getIcd10());
		clone.setOmim(getOmim());
		clone.setSynonym(getSynonym());
		clone.setModifieddate(getModifieddate());
		clone.setModifieduser(getModifieduser());

		return clone;
	}

	@Override
	public int compareTo(DiseaseMatrix diseaseMatrix) {
		long primaryKey = diseaseMatrix.getPrimaryKey();

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

		if (!(obj instanceof DiseaseMatrixClp)) {
			return false;
		}

		DiseaseMatrixClp diseaseMatrix = (DiseaseMatrixClp)obj;

		long primaryKey = diseaseMatrix.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{diseasematrixId=");
		sb.append(getDiseasematrixId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", diseasename=");
		sb.append(getDiseasename());
		sb.append(", patientcount=");
		sb.append(getPatientcount());
		sb.append(", gene=");
		sb.append(getGene());
		sb.append(", orphanumber=");
		sb.append(getOrphanumber());
		sb.append(", icd10=");
		sb.append(getIcd10());
		sb.append(", omim=");
		sb.append(getOmim());
		sb.append(", synonym=");
		sb.append(getSynonym());
		sb.append(", modifieddate=");
		sb.append(getModifieddate());
		sb.append(", modifieduser=");
		sb.append(getModifieduser());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>diseasematrixId</column-name><column-value><![CDATA[");
		sb.append(getDiseasematrixId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseasename</column-name><column-value><![CDATA[");
		sb.append(getDiseasename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientcount</column-name><column-value><![CDATA[");
		sb.append(getPatientcount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gene</column-name><column-value><![CDATA[");
		sb.append(getGene());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanumber</column-name><column-value><![CDATA[");
		sb.append(getOrphanumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icd10</column-name><column-value><![CDATA[");
		sb.append(getIcd10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>omim</column-name><column-value><![CDATA[");
		sb.append(getOmim());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synonym</column-name><column-value><![CDATA[");
		sb.append(getSynonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifieddate</column-name><column-value><![CDATA[");
		sb.append(getModifieddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifieduser</column-name><column-value><![CDATA[");
		sb.append(getModifieduser());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _diseasematrixId;
	private long _organizationId;
	private String _diseasename;
	private String _patientcount;
	private String _gene;
	private String _orphanumber;
	private String _icd10;
	private String _omim;
	private String _synonym;
	private Date _modifieddate;
	private String _modifieduser;
	private BaseModel<?> _diseaseMatrixRemoteModel;
}