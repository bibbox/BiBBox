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

import at.meduni.liferay.portlet.rdconnect.model.RDCRecommender;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RDCRecommender in entity cache.
 *
 * @author Robert Reihs
 * @see RDCRecommender
 * @generated
 */
public class RDCRecommenderCacheModel implements CacheModel<RDCRecommender>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{rdcrecommenderid=");
		sb.append(rdcrecommenderid);
		sb.append(", organisationId=");
		sb.append(organisationId);
		sb.append(", recommendedorganisationId=");
		sb.append(recommendedorganisationId);
		sb.append(", recommendervalue=");
		sb.append(recommendervalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RDCRecommender toEntityModel() {
		RDCRecommenderImpl rdcRecommenderImpl = new RDCRecommenderImpl();

		rdcRecommenderImpl.setRdcrecommenderid(rdcrecommenderid);
		rdcRecommenderImpl.setOrganisationId(organisationId);
		rdcRecommenderImpl.setRecommendedorganisationId(recommendedorganisationId);
		rdcRecommenderImpl.setRecommendervalue(recommendervalue);

		rdcRecommenderImpl.resetOriginalValues();

		return rdcRecommenderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rdcrecommenderid = objectInput.readLong();
		organisationId = objectInput.readLong();
		recommendedorganisationId = objectInput.readLong();
		recommendervalue = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rdcrecommenderid);
		objectOutput.writeLong(organisationId);
		objectOutput.writeLong(recommendedorganisationId);
		objectOutput.writeDouble(recommendervalue);
	}

	public long rdcrecommenderid;
	public long organisationId;
	public long recommendedorganisationId;
	public double recommendervalue;
}