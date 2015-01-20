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

import at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GeneralInformation in entity cache.
 *
 * @author reihsr
 * @see GeneralInformation
 * @generated
 */
public class GeneralInformationCacheModel implements CacheModel<GeneralInformation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{generalinformationId=");
		sb.append(generalinformationId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", acronym=");
		sb.append(acronym);
		sb.append(", description=");
		sb.append(description);
		sb.append(", hosteinstitue=");
		sb.append(hosteinstitue);
		sb.append(", typeofhosteinstitue=");
		sb.append(typeofhosteinstitue);
		sb.append(", sourceoffunding=");
		sb.append(sourceoffunding);
		sb.append(", country=");
		sb.append(country);
		sb.append(", targetpopulation=");
		sb.append(targetpopulation);
		sb.append(", yearofestablishment=");
		sb.append(yearofestablishment);
		sb.append(", howmanyrdsareintheregistrybiobank=");
		sb.append(howmanyrdsareintheregistrybiobank);
		sb.append(", percentageofrarediseasesinyourregistrybiobank=");
		sb.append(percentageofrarediseasesinyourregistrybiobank);
		sb.append(", ontologies=");
		sb.append(ontologies);
		sb.append(", biomaterialcollected=");
		sb.append(biomaterialcollected);
		sb.append(", biomaterialprepared=");
		sb.append(biomaterialprepared);
		sb.append(", origionofcollection=");
		sb.append(origionofcollection);
		sb.append(", useofcollection=");
		sb.append(useofcollection);
		sb.append(", associateddataavailable=");
		sb.append(associateddataavailable);
		sb.append(", imagingavailable=");
		sb.append(imagingavailable);
		sb.append(", theregistrybiobanksislistedinotherinventoriesnetworks=");
		sb.append(theregistrybiobanksislistedinotherinventoriesnetworks);
		sb.append(", modifieddate=");
		sb.append(modifieddate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeneralInformation toEntityModel() {
		GeneralInformationImpl generalInformationImpl = new GeneralInformationImpl();

		generalInformationImpl.setGeneralinformationId(generalinformationId);
		generalInformationImpl.setOrganizationId(organizationId);

		if (acronym == null) {
			generalInformationImpl.setAcronym(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setAcronym(acronym);
		}

		if (description == null) {
			generalInformationImpl.setDescription(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setDescription(description);
		}

		if (hosteinstitue == null) {
			generalInformationImpl.setHosteinstitue(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setHosteinstitue(hosteinstitue);
		}

		if (typeofhosteinstitue == null) {
			generalInformationImpl.setTypeofhosteinstitue(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setTypeofhosteinstitue(typeofhosteinstitue);
		}

		if (sourceoffunding == null) {
			generalInformationImpl.setSourceoffunding(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setSourceoffunding(sourceoffunding);
		}

		if (country == null) {
			generalInformationImpl.setCountry(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setCountry(country);
		}

		if (targetpopulation == null) {
			generalInformationImpl.setTargetpopulation(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setTargetpopulation(targetpopulation);
		}

		if (yearofestablishment == null) {
			generalInformationImpl.setYearofestablishment(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setYearofestablishment(yearofestablishment);
		}

		if (howmanyrdsareintheregistrybiobank == null) {
			generalInformationImpl.setHowmanyrdsareintheregistrybiobank(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setHowmanyrdsareintheregistrybiobank(howmanyrdsareintheregistrybiobank);
		}

		if (percentageofrarediseasesinyourregistrybiobank == null) {
			generalInformationImpl.setPercentageofrarediseasesinyourregistrybiobank(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setPercentageofrarediseasesinyourregistrybiobank(percentageofrarediseasesinyourregistrybiobank);
		}

		if (ontologies == null) {
			generalInformationImpl.setOntologies(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setOntologies(ontologies);
		}

		if (biomaterialcollected == null) {
			generalInformationImpl.setBiomaterialcollected(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setBiomaterialcollected(biomaterialcollected);
		}

		if (biomaterialprepared == null) {
			generalInformationImpl.setBiomaterialprepared(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setBiomaterialprepared(biomaterialprepared);
		}

		if (origionofcollection == null) {
			generalInformationImpl.setOrigionofcollection(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setOrigionofcollection(origionofcollection);
		}

		if (useofcollection == null) {
			generalInformationImpl.setUseofcollection(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setUseofcollection(useofcollection);
		}

		if (associateddataavailable == null) {
			generalInformationImpl.setAssociateddataavailable(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setAssociateddataavailable(associateddataavailable);
		}

		if (imagingavailable == null) {
			generalInformationImpl.setImagingavailable(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setImagingavailable(imagingavailable);
		}

		if (theregistrybiobanksislistedinotherinventoriesnetworks == null) {
			generalInformationImpl.setTheregistrybiobanksislistedinotherinventoriesnetworks(StringPool.BLANK);
		}
		else {
			generalInformationImpl.setTheregistrybiobanksislistedinotherinventoriesnetworks(theregistrybiobanksislistedinotherinventoriesnetworks);
		}

		if (modifieddate == Long.MIN_VALUE) {
			generalInformationImpl.setModifieddate(null);
		}
		else {
			generalInformationImpl.setModifieddate(new Date(modifieddate));
		}

		generalInformationImpl.resetOriginalValues();

		return generalInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		generalinformationId = objectInput.readLong();
		organizationId = objectInput.readLong();
		acronym = objectInput.readUTF();
		description = objectInput.readUTF();
		hosteinstitue = objectInput.readUTF();
		typeofhosteinstitue = objectInput.readUTF();
		sourceoffunding = objectInput.readUTF();
		country = objectInput.readUTF();
		targetpopulation = objectInput.readUTF();
		yearofestablishment = objectInput.readUTF();
		howmanyrdsareintheregistrybiobank = objectInput.readUTF();
		percentageofrarediseasesinyourregistrybiobank = objectInput.readUTF();
		ontologies = objectInput.readUTF();
		biomaterialcollected = objectInput.readUTF();
		biomaterialprepared = objectInput.readUTF();
		origionofcollection = objectInput.readUTF();
		useofcollection = objectInput.readUTF();
		associateddataavailable = objectInput.readUTF();
		imagingavailable = objectInput.readUTF();
		theregistrybiobanksislistedinotherinventoriesnetworks = objectInput.readUTF();
		modifieddate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(generalinformationId);
		objectOutput.writeLong(organizationId);

		if (acronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronym);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (hosteinstitue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hosteinstitue);
		}

		if (typeofhosteinstitue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeofhosteinstitue);
		}

		if (sourceoffunding == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sourceoffunding);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (targetpopulation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetpopulation);
		}

		if (yearofestablishment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yearofestablishment);
		}

		if (howmanyrdsareintheregistrybiobank == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(howmanyrdsareintheregistrybiobank);
		}

		if (percentageofrarediseasesinyourregistrybiobank == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(percentageofrarediseasesinyourregistrybiobank);
		}

		if (ontologies == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ontologies);
		}

		if (biomaterialcollected == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biomaterialcollected);
		}

		if (biomaterialprepared == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biomaterialprepared);
		}

		if (origionofcollection == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(origionofcollection);
		}

		if (useofcollection == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(useofcollection);
		}

		if (associateddataavailable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateddataavailable);
		}

		if (imagingavailable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imagingavailable);
		}

		if (theregistrybiobanksislistedinotherinventoriesnetworks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(theregistrybiobanksislistedinotherinventoriesnetworks);
		}

		objectOutput.writeLong(modifieddate);
	}

	public long generalinformationId;
	public long organizationId;
	public String acronym;
	public String description;
	public String hosteinstitue;
	public String typeofhosteinstitue;
	public String sourceoffunding;
	public String country;
	public String targetpopulation;
	public String yearofestablishment;
	public String howmanyrdsareintheregistrybiobank;
	public String percentageofrarediseasesinyourregistrybiobank;
	public String ontologies;
	public String biomaterialcollected;
	public String biomaterialprepared;
	public String origionofcollection;
	public String useofcollection;
	public String associateddataavailable;
	public String imagingavailable;
	public String theregistrybiobanksislistedinotherinventoriesnetworks;
	public long modifieddate;
}