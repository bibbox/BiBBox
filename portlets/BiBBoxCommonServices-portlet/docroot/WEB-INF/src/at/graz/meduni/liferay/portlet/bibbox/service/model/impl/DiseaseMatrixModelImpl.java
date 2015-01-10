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

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixModel;

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
 * The base model implementation for the DiseaseMatrix service. Represents a row in the &quot;rdconnect.diseasematrix&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DiseaseMatrixImpl}.
 * </p>
 *
 * @author reihsr
 * @see DiseaseMatrixImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixModel
 * @generated
 */
public class DiseaseMatrixModelImpl extends BaseModelImpl<DiseaseMatrix>
	implements DiseaseMatrixModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a disease matrix model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix} interface instead.
	 */
	public static final String TABLE_NAME = "rdconnect.diseasematrix";
	public static final Object[][] TABLE_COLUMNS = {
			{ "diseasematrixId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "diseasename", Types.VARCHAR },
			{ "patientcount", Types.VARCHAR },
			{ "gene", Types.VARCHAR },
			{ "orphanumber", Types.VARCHAR },
			{ "icd10", Types.VARCHAR },
			{ "omim", Types.VARCHAR },
			{ "synonym", Types.VARCHAR },
			{ "modifieddate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table rdconnect.diseasematrix (diseasematrixId LONG not null primary key,organizationId LONG,diseasename TEXT null,patientcount TEXT null,gene TEXT null,orphanumber TEXT null,icd10 TEXT null,omim TEXT null,synonym TEXT null,modifieddate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table rdconnect.diseasematrix";
	public static final String ORDER_BY_JPQL = " ORDER BY diseaseMatrix.diseasematrixId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rdconnect.diseasematrix.diseasematrixId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long DISEASEMATRIXID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"));

	public DiseaseMatrixModelImpl() {
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
	public Class<?> getModelClass() {
		return DiseaseMatrix.class;
	}

	@Override
	public String getModelClassName() {
		return DiseaseMatrix.class.getName();
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
	}

	@Override
	public long getDiseasematrixId() {
		return _diseasematrixId;
	}

	@Override
	public void setDiseasematrixId(long diseasematrixId) {
		_diseasematrixId = diseasematrixId;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask |= ORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	@Override
	public String getDiseasename() {
		if (_diseasename == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseasename;
		}
	}

	@Override
	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;
	}

	@Override
	public String getPatientcount() {
		if (_patientcount == null) {
			return StringPool.BLANK;
		}
		else {
			return _patientcount;
		}
	}

	@Override
	public void setPatientcount(String patientcount) {
		_patientcount = patientcount;
	}

	@Override
	public String getGene() {
		if (_gene == null) {
			return StringPool.BLANK;
		}
		else {
			return _gene;
		}
	}

	@Override
	public void setGene(String gene) {
		_gene = gene;
	}

	@Override
	public String getOrphanumber() {
		if (_orphanumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _orphanumber;
		}
	}

	@Override
	public void setOrphanumber(String orphanumber) {
		_orphanumber = orphanumber;
	}

	@Override
	public String getIcd10() {
		if (_icd10 == null) {
			return StringPool.BLANK;
		}
		else {
			return _icd10;
		}
	}

	@Override
	public void setIcd10(String icd10) {
		_icd10 = icd10;
	}

	@Override
	public String getOmim() {
		if (_omim == null) {
			return StringPool.BLANK;
		}
		else {
			return _omim;
		}
	}

	@Override
	public void setOmim(String omim) {
		_omim = omim;
	}

	@Override
	public String getSynonym() {
		if (_synonym == null) {
			return StringPool.BLANK;
		}
		else {
			return _synonym;
		}
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	@Override
	public Date getModifieddate() {
		return _modifieddate;
	}

	@Override
	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DiseaseMatrix.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DiseaseMatrix toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DiseaseMatrix)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DiseaseMatrixImpl diseaseMatrixImpl = new DiseaseMatrixImpl();

		diseaseMatrixImpl.setDiseasematrixId(getDiseasematrixId());
		diseaseMatrixImpl.setOrganizationId(getOrganizationId());
		diseaseMatrixImpl.setDiseasename(getDiseasename());
		diseaseMatrixImpl.setPatientcount(getPatientcount());
		diseaseMatrixImpl.setGene(getGene());
		diseaseMatrixImpl.setOrphanumber(getOrphanumber());
		diseaseMatrixImpl.setIcd10(getIcd10());
		diseaseMatrixImpl.setOmim(getOmim());
		diseaseMatrixImpl.setSynonym(getSynonym());
		diseaseMatrixImpl.setModifieddate(getModifieddate());

		diseaseMatrixImpl.resetOriginalValues();

		return diseaseMatrixImpl;
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

		if (!(obj instanceof DiseaseMatrix)) {
			return false;
		}

		DiseaseMatrix diseaseMatrix = (DiseaseMatrix)obj;

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
	public void resetOriginalValues() {
		DiseaseMatrixModelImpl diseaseMatrixModelImpl = this;

		diseaseMatrixModelImpl._originalOrganizationId = diseaseMatrixModelImpl._organizationId;

		diseaseMatrixModelImpl._setOriginalOrganizationId = false;

		diseaseMatrixModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DiseaseMatrix> toCacheModel() {
		DiseaseMatrixCacheModel diseaseMatrixCacheModel = new DiseaseMatrixCacheModel();

		diseaseMatrixCacheModel.diseasematrixId = getDiseasematrixId();

		diseaseMatrixCacheModel.organizationId = getOrganizationId();

		diseaseMatrixCacheModel.diseasename = getDiseasename();

		String diseasename = diseaseMatrixCacheModel.diseasename;

		if ((diseasename != null) && (diseasename.length() == 0)) {
			diseaseMatrixCacheModel.diseasename = null;
		}

		diseaseMatrixCacheModel.patientcount = getPatientcount();

		String patientcount = diseaseMatrixCacheModel.patientcount;

		if ((patientcount != null) && (patientcount.length() == 0)) {
			diseaseMatrixCacheModel.patientcount = null;
		}

		diseaseMatrixCacheModel.gene = getGene();

		String gene = diseaseMatrixCacheModel.gene;

		if ((gene != null) && (gene.length() == 0)) {
			diseaseMatrixCacheModel.gene = null;
		}

		diseaseMatrixCacheModel.orphanumber = getOrphanumber();

		String orphanumber = diseaseMatrixCacheModel.orphanumber;

		if ((orphanumber != null) && (orphanumber.length() == 0)) {
			diseaseMatrixCacheModel.orphanumber = null;
		}

		diseaseMatrixCacheModel.icd10 = getIcd10();

		String icd10 = diseaseMatrixCacheModel.icd10;

		if ((icd10 != null) && (icd10.length() == 0)) {
			diseaseMatrixCacheModel.icd10 = null;
		}

		diseaseMatrixCacheModel.omim = getOmim();

		String omim = diseaseMatrixCacheModel.omim;

		if ((omim != null) && (omim.length() == 0)) {
			diseaseMatrixCacheModel.omim = null;
		}

		diseaseMatrixCacheModel.synonym = getSynonym();

		String synonym = diseaseMatrixCacheModel.synonym;

		if ((synonym != null) && (synonym.length() == 0)) {
			diseaseMatrixCacheModel.synonym = null;
		}

		Date modifieddate = getModifieddate();

		if (modifieddate != null) {
			diseaseMatrixCacheModel.modifieddate = modifieddate.getTime();
		}
		else {
			diseaseMatrixCacheModel.modifieddate = Long.MIN_VALUE;
		}

		return diseaseMatrixCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DiseaseMatrix.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DiseaseMatrix.class
		};
	private long _diseasematrixId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
	private String _diseasename;
	private String _patientcount;
	private String _gene;
	private String _orphanumber;
	private String _icd10;
	private String _omim;
	private String _synonym;
	private Date _modifieddate;
	private long _columnBitmask;
	private DiseaseMatrix _escapedModel;
}