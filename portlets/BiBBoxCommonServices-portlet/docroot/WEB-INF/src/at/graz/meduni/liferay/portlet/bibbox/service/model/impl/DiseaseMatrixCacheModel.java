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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DiseaseMatrix in entity cache.
 *
 * @author reihsr
 * @see DiseaseMatrix
 * @generated
 */
public class DiseaseMatrixCacheModel implements CacheModel<DiseaseMatrix>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{diseasematrixId=");
		sb.append(diseasematrixId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", diseasename=");
		sb.append(diseasename);
		sb.append(", patientcount=");
		sb.append(patientcount);
		sb.append(", gene=");
		sb.append(gene);
		sb.append(", orphanumber=");
		sb.append(orphanumber);
		sb.append(", icd10=");
		sb.append(icd10);
		sb.append(", omim=");
		sb.append(omim);
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append(", modifieddate=");
		sb.append(modifieddate);
		sb.append(", modifieduser=");
		sb.append(modifieduser);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DiseaseMatrix toEntityModel() {
		DiseaseMatrixImpl diseaseMatrixImpl = new DiseaseMatrixImpl();

		diseaseMatrixImpl.setDiseasematrixId(diseasematrixId);
		diseaseMatrixImpl.setOrganizationId(organizationId);

		if (diseasename == null) {
			diseaseMatrixImpl.setDiseasename(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setDiseasename(diseasename);
		}

		if (patientcount == null) {
			diseaseMatrixImpl.setPatientcount(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setPatientcount(patientcount);
		}

		if (gene == null) {
			diseaseMatrixImpl.setGene(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setGene(gene);
		}

		if (orphanumber == null) {
			diseaseMatrixImpl.setOrphanumber(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setOrphanumber(orphanumber);
		}

		if (icd10 == null) {
			diseaseMatrixImpl.setIcd10(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setIcd10(icd10);
		}

		if (omim == null) {
			diseaseMatrixImpl.setOmim(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setOmim(omim);
		}

		if (synonym == null) {
			diseaseMatrixImpl.setSynonym(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setSynonym(synonym);
		}

		if (modifieddate == Long.MIN_VALUE) {
			diseaseMatrixImpl.setModifieddate(null);
		}
		else {
			diseaseMatrixImpl.setModifieddate(new Date(modifieddate));
		}

		if (modifieduser == null) {
			diseaseMatrixImpl.setModifieduser(StringPool.BLANK);
		}
		else {
			diseaseMatrixImpl.setModifieduser(modifieduser);
		}

		diseaseMatrixImpl.resetOriginalValues();

		return diseaseMatrixImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		diseasematrixId = objectInput.readLong();
		organizationId = objectInput.readLong();
		diseasename = objectInput.readUTF();
		patientcount = objectInput.readUTF();
		gene = objectInput.readUTF();
		orphanumber = objectInput.readUTF();
		icd10 = objectInput.readUTF();
		omim = objectInput.readUTF();
		synonym = objectInput.readUTF();
		modifieddate = objectInput.readLong();
		modifieduser = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(diseasematrixId);
		objectOutput.writeLong(organizationId);

		if (diseasename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasename);
		}

		if (patientcount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patientcount);
		}

		if (gene == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gene);
		}

		if (orphanumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orphanumber);
		}

		if (icd10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(icd10);
		}

		if (omim == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(omim);
		}

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}

		objectOutput.writeLong(modifieddate);

		if (modifieduser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifieduser);
		}
	}

	public long diseasematrixId;
	public long organizationId;
	public String diseasename;
	public String patientcount;
	public String gene;
	public String orphanumber;
	public String icd10;
	public String omim;
	public String synonym;
	public long modifieddate;
	public String modifieduser;
}