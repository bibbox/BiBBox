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

package at.meduni.graz.patho.haybaeck.model.impl;

import at.meduni.graz.patho.haybaeck.model.Sample;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sample in entity cache.
 *
 * @author reihsr
 * @see Sample
 * @generated
 */
public class SampleCacheModel implements CacheModel<Sample>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{sample_Id=");
		sb.append(sample_Id);
		sb.append(", patient_id=");
		sb.append(patient_id);
		sb.append(", t=");
		sb.append(t);
		sb.append(", n=");
		sb.append(n);
		sb.append(", m=");
		sb.append(m);
		sb.append(", g=");
		sb.append(g);
		sb.append(", r=");
		sb.append(r);
		sb.append(", p=");
		sb.append(p);
		sb.append(", l=");
		sb.append(l);
		sb.append(", v=");
		sb.append(v);
		sb.append(", stage=");
		sb.append(stage);
		sb.append(", operation=");
		sb.append(operation);
		sb.append(", post_op_treatment=");
		sb.append(post_op_treatment);
		sb.append(", recurrence=");
		sb.append(recurrence);
		sb.append(", recurrence_date=");
		sb.append(recurrence_date);
		sb.append(", dead_live=");
		sb.append(dead_live);
		sb.append(", last_follow_up_date=");
		sb.append(last_follow_up_date);
		sb.append(", hospital=");
		sb.append(hospital);
		sb.append(", tnm_staging=");
		sb.append(tnm_staging);
		sb.append(", diagnosis=");
		sb.append(diagnosis);
		sb.append(", operation_date=");
		sb.append(operation_date);
		sb.append(", tmp_identifier=");
		sb.append(tmp_identifier);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sample toEntityModel() {
		SampleImpl sampleImpl = new SampleImpl();

		sampleImpl.setSample_Id(sample_Id);
		sampleImpl.setPatient_id(patient_id);

		if (t == null) {
			sampleImpl.setT(StringPool.BLANK);
		}
		else {
			sampleImpl.setT(t);
		}

		if (n == null) {
			sampleImpl.setN(StringPool.BLANK);
		}
		else {
			sampleImpl.setN(n);
		}

		if (m == null) {
			sampleImpl.setM(StringPool.BLANK);
		}
		else {
			sampleImpl.setM(m);
		}

		if (g == null) {
			sampleImpl.setG(StringPool.BLANK);
		}
		else {
			sampleImpl.setG(g);
		}

		if (r == null) {
			sampleImpl.setR(StringPool.BLANK);
		}
		else {
			sampleImpl.setR(r);
		}

		if (p == null) {
			sampleImpl.setP(StringPool.BLANK);
		}
		else {
			sampleImpl.setP(p);
		}

		if (l == null) {
			sampleImpl.setL(StringPool.BLANK);
		}
		else {
			sampleImpl.setL(l);
		}

		if (v == null) {
			sampleImpl.setV(StringPool.BLANK);
		}
		else {
			sampleImpl.setV(v);
		}

		if (stage == null) {
			sampleImpl.setStage(StringPool.BLANK);
		}
		else {
			sampleImpl.setStage(stage);
		}

		if (operation == null) {
			sampleImpl.setOperation(StringPool.BLANK);
		}
		else {
			sampleImpl.setOperation(operation);
		}

		if (post_op_treatment == null) {
			sampleImpl.setPost_op_treatment(StringPool.BLANK);
		}
		else {
			sampleImpl.setPost_op_treatment(post_op_treatment);
		}

		sampleImpl.setRecurrence(recurrence);

		if (recurrence_date == Long.MIN_VALUE) {
			sampleImpl.setRecurrence_date(null);
		}
		else {
			sampleImpl.setRecurrence_date(new Date(recurrence_date));
		}

		if (dead_live == null) {
			sampleImpl.setDead_live(StringPool.BLANK);
		}
		else {
			sampleImpl.setDead_live(dead_live);
		}

		if (last_follow_up_date == Long.MIN_VALUE) {
			sampleImpl.setLast_follow_up_date(null);
		}
		else {
			sampleImpl.setLast_follow_up_date(new Date(last_follow_up_date));
		}

		if (hospital == null) {
			sampleImpl.setHospital(StringPool.BLANK);
		}
		else {
			sampleImpl.setHospital(hospital);
		}

		if (tnm_staging == null) {
			sampleImpl.setTnm_staging(StringPool.BLANK);
		}
		else {
			sampleImpl.setTnm_staging(tnm_staging);
		}

		if (diagnosis == null) {
			sampleImpl.setDiagnosis(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiagnosis(diagnosis);
		}

		if (operation_date == Long.MIN_VALUE) {
			sampleImpl.setOperation_date(null);
		}
		else {
			sampleImpl.setOperation_date(new Date(operation_date));
		}

		if (tmp_identifier == null) {
			sampleImpl.setTmp_identifier(StringPool.BLANK);
		}
		else {
			sampleImpl.setTmp_identifier(tmp_identifier);
		}

		sampleImpl.resetOriginalValues();

		return sampleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sample_Id = objectInput.readLong();
		patient_id = objectInput.readLong();
		t = objectInput.readUTF();
		n = objectInput.readUTF();
		m = objectInput.readUTF();
		g = objectInput.readUTF();
		r = objectInput.readUTF();
		p = objectInput.readUTF();
		l = objectInput.readUTF();
		v = objectInput.readUTF();
		stage = objectInput.readUTF();
		operation = objectInput.readUTF();
		post_op_treatment = objectInput.readUTF();
		recurrence = objectInput.readBoolean();
		recurrence_date = objectInput.readLong();
		dead_live = objectInput.readUTF();
		last_follow_up_date = objectInput.readLong();
		hospital = objectInput.readUTF();
		tnm_staging = objectInput.readUTF();
		diagnosis = objectInput.readUTF();
		operation_date = objectInput.readLong();
		tmp_identifier = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sample_Id);
		objectOutput.writeLong(patient_id);

		if (t == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(t);
		}

		if (n == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(n);
		}

		if (m == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(m);
		}

		if (g == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(g);
		}

		if (r == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(r);
		}

		if (p == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(p);
		}

		if (l == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(l);
		}

		if (v == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(v);
		}

		if (stage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stage);
		}

		if (operation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(operation);
		}

		if (post_op_treatment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(post_op_treatment);
		}

		objectOutput.writeBoolean(recurrence);
		objectOutput.writeLong(recurrence_date);

		if (dead_live == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dead_live);
		}

		objectOutput.writeLong(last_follow_up_date);

		if (hospital == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hospital);
		}

		if (tnm_staging == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnm_staging);
		}

		if (diagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diagnosis);
		}

		objectOutput.writeLong(operation_date);

		if (tmp_identifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tmp_identifier);
		}
	}

	public long sample_Id;
	public long patient_id;
	public String t;
	public String n;
	public String m;
	public String g;
	public String r;
	public String p;
	public String l;
	public String v;
	public String stage;
	public String operation;
	public String post_op_treatment;
	public boolean recurrence;
	public long recurrence_date;
	public String dead_live;
	public long last_follow_up_date;
	public String hospital;
	public String tnm_staging;
	public String diagnosis;
	public long operation_date;
	public String tmp_identifier;
}