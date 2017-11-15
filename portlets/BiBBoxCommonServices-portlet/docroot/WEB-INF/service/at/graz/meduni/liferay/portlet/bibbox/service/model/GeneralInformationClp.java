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
import at.graz.meduni.liferay.portlet.bibbox.service.service.GeneralInformationLocalServiceUtil;

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
public class GeneralInformationClp extends BaseModelImpl<GeneralInformation>
	implements GeneralInformation {
	public GeneralInformationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GeneralInformation.class;
	}

	@Override
	public String getModelClassName() {
		return GeneralInformation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _generalinformationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeneralinformationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _generalinformationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("generalinformationId", getGeneralinformationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("acronym", getAcronym());
		attributes.put("description", getDescription());
		attributes.put("hosteinstitue", getHosteinstitue());
		attributes.put("typeofhosteinstitue", getTypeofhosteinstitue());
		attributes.put("sourceoffunding", getSourceoffunding());
		attributes.put("country", getCountry());
		attributes.put("targetpopulation", getTargetpopulation());
		attributes.put("yearofestablishment", getYearofestablishment());
		attributes.put("howmanyrdsareintheregistrybiobank",
			getHowmanyrdsareintheregistrybiobank());
		attributes.put("percentageofrarediseasesinyourregistrybiobank",
			getPercentageofrarediseasesinyourregistrybiobank());
		attributes.put("ontologies", getOntologies());
		attributes.put("biomaterialcollected", getBiomaterialcollected());
		attributes.put("biomaterialcollectedinbiobank",
			getBiomaterialcollectedinbiobank());
		attributes.put("biomaterialprepared", getBiomaterialprepared());
		attributes.put("origionofcollection", getOrigionofcollection());
		attributes.put("useofcollection", getUseofcollection());
		attributes.put("associateddataavailable", getAssociateddataavailable());
		attributes.put("imagingavailable", getImagingavailable());
		attributes.put("theregistrybiobanksislistedinotherinventoriesnetworks",
			getTheregistrybiobanksislistedinotherinventoriesnetworks());
		attributes.put("modifieddate", getModifieddate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long generalinformationId = (Long)attributes.get("generalinformationId");

		if (generalinformationId != null) {
			setGeneralinformationId(generalinformationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String hosteinstitue = (String)attributes.get("hosteinstitue");

		if (hosteinstitue != null) {
			setHosteinstitue(hosteinstitue);
		}

		String typeofhosteinstitue = (String)attributes.get(
				"typeofhosteinstitue");

		if (typeofhosteinstitue != null) {
			setTypeofhosteinstitue(typeofhosteinstitue);
		}

		String sourceoffunding = (String)attributes.get("sourceoffunding");

		if (sourceoffunding != null) {
			setSourceoffunding(sourceoffunding);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String targetpopulation = (String)attributes.get("targetpopulation");

		if (targetpopulation != null) {
			setTargetpopulation(targetpopulation);
		}

		String yearofestablishment = (String)attributes.get(
				"yearofestablishment");

		if (yearofestablishment != null) {
			setYearofestablishment(yearofestablishment);
		}

		String howmanyrdsareintheregistrybiobank = (String)attributes.get(
				"howmanyrdsareintheregistrybiobank");

		if (howmanyrdsareintheregistrybiobank != null) {
			setHowmanyrdsareintheregistrybiobank(howmanyrdsareintheregistrybiobank);
		}

		String percentageofrarediseasesinyourregistrybiobank = (String)attributes.get(
				"percentageofrarediseasesinyourregistrybiobank");

		if (percentageofrarediseasesinyourregistrybiobank != null) {
			setPercentageofrarediseasesinyourregistrybiobank(percentageofrarediseasesinyourregistrybiobank);
		}

		String ontologies = (String)attributes.get("ontologies");

		if (ontologies != null) {
			setOntologies(ontologies);
		}

		String biomaterialcollected = (String)attributes.get(
				"biomaterialcollected");

		if (biomaterialcollected != null) {
			setBiomaterialcollected(biomaterialcollected);
		}

		String biomaterialcollectedinbiobank = (String)attributes.get(
				"biomaterialcollectedinbiobank");

		if (biomaterialcollectedinbiobank != null) {
			setBiomaterialcollectedinbiobank(biomaterialcollectedinbiobank);
		}

		String biomaterialprepared = (String)attributes.get(
				"biomaterialprepared");

		if (biomaterialprepared != null) {
			setBiomaterialprepared(biomaterialprepared);
		}

		String origionofcollection = (String)attributes.get(
				"origionofcollection");

		if (origionofcollection != null) {
			setOrigionofcollection(origionofcollection);
		}

		String useofcollection = (String)attributes.get("useofcollection");

		if (useofcollection != null) {
			setUseofcollection(useofcollection);
		}

		String associateddataavailable = (String)attributes.get(
				"associateddataavailable");

		if (associateddataavailable != null) {
			setAssociateddataavailable(associateddataavailable);
		}

		String imagingavailable = (String)attributes.get("imagingavailable");

		if (imagingavailable != null) {
			setImagingavailable(imagingavailable);
		}

		String theregistrybiobanksislistedinotherinventoriesnetworks = (String)attributes.get(
				"theregistrybiobanksislistedinotherinventoriesnetworks");

		if (theregistrybiobanksislistedinotherinventoriesnetworks != null) {
			setTheregistrybiobanksislistedinotherinventoriesnetworks(theregistrybiobanksislistedinotherinventoriesnetworks);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}
	}

	@Override
	public long getGeneralinformationId() {
		return _generalinformationId;
	}

	@Override
	public void setGeneralinformationId(long generalinformationId) {
		_generalinformationId = generalinformationId;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneralinformationId",
						long.class);

				method.invoke(_generalInformationRemoteModel,
					generalinformationId);
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

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_generalInformationRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAcronym() {
		return _acronym;
	}

	@Override
	public void setAcronym(String acronym) {
		_acronym = acronym;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setAcronym", String.class);

				method.invoke(_generalInformationRemoteModel, acronym);
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

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_generalInformationRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHosteinstitue() {
		return _hosteinstitue;
	}

	@Override
	public void setHosteinstitue(String hosteinstitue) {
		_hosteinstitue = hosteinstitue;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setHosteinstitue", String.class);

				method.invoke(_generalInformationRemoteModel, hosteinstitue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeofhosteinstitue() {
		return _typeofhosteinstitue;
	}

	@Override
	public void setTypeofhosteinstitue(String typeofhosteinstitue) {
		_typeofhosteinstitue = typeofhosteinstitue;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeofhosteinstitue",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					typeofhosteinstitue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSourceoffunding() {
		return _sourceoffunding;
	}

	@Override
	public void setSourceoffunding(String sourceoffunding) {
		_sourceoffunding = sourceoffunding;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceoffunding",
						String.class);

				method.invoke(_generalInformationRemoteModel, sourceoffunding);
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

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_generalInformationRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetpopulation() {
		return _targetpopulation;
	}

	@Override
	public void setTargetpopulation(String targetpopulation) {
		_targetpopulation = targetpopulation;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetpopulation",
						String.class);

				method.invoke(_generalInformationRemoteModel, targetpopulation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYearofestablishment() {
		return _yearofestablishment;
	}

	@Override
	public void setYearofestablishment(String yearofestablishment) {
		_yearofestablishment = yearofestablishment;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setYearofestablishment",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					yearofestablishment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHowmanyrdsareintheregistrybiobank() {
		return _howmanyrdsareintheregistrybiobank;
	}

	@Override
	public void setHowmanyrdsareintheregistrybiobank(
		String howmanyrdsareintheregistrybiobank) {
		_howmanyrdsareintheregistrybiobank = howmanyrdsareintheregistrybiobank;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setHowmanyrdsareintheregistrybiobank",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					howmanyrdsareintheregistrybiobank);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPercentageofrarediseasesinyourregistrybiobank() {
		return _percentageofrarediseasesinyourregistrybiobank;
	}

	@Override
	public void setPercentageofrarediseasesinyourregistrybiobank(
		String percentageofrarediseasesinyourregistrybiobank) {
		_percentageofrarediseasesinyourregistrybiobank = percentageofrarediseasesinyourregistrybiobank;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setPercentageofrarediseasesinyourregistrybiobank",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					percentageofrarediseasesinyourregistrybiobank);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOntologies() {
		return _ontologies;
	}

	@Override
	public void setOntologies(String ontologies) {
		_ontologies = ontologies;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setOntologies", String.class);

				method.invoke(_generalInformationRemoteModel, ontologies);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiomaterialcollected() {
		return _biomaterialcollected;
	}

	@Override
	public void setBiomaterialcollected(String biomaterialcollected) {
		_biomaterialcollected = biomaterialcollected;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setBiomaterialcollected",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					biomaterialcollected);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiomaterialcollectedinbiobank() {
		return _biomaterialcollectedinbiobank;
	}

	@Override
	public void setBiomaterialcollectedinbiobank(
		String biomaterialcollectedinbiobank) {
		_biomaterialcollectedinbiobank = biomaterialcollectedinbiobank;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setBiomaterialcollectedinbiobank",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					biomaterialcollectedinbiobank);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiomaterialprepared() {
		return _biomaterialprepared;
	}

	@Override
	public void setBiomaterialprepared(String biomaterialprepared) {
		_biomaterialprepared = biomaterialprepared;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setBiomaterialprepared",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					biomaterialprepared);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrigionofcollection() {
		return _origionofcollection;
	}

	@Override
	public void setOrigionofcollection(String origionofcollection) {
		_origionofcollection = origionofcollection;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrigionofcollection",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					origionofcollection);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUseofcollection() {
		return _useofcollection;
	}

	@Override
	public void setUseofcollection(String useofcollection) {
		_useofcollection = useofcollection;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setUseofcollection",
						String.class);

				method.invoke(_generalInformationRemoteModel, useofcollection);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssociateddataavailable() {
		return _associateddataavailable;
	}

	@Override
	public void setAssociateddataavailable(String associateddataavailable) {
		_associateddataavailable = associateddataavailable;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociateddataavailable",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					associateddataavailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImagingavailable() {
		return _imagingavailable;
	}

	@Override
	public void setImagingavailable(String imagingavailable) {
		_imagingavailable = imagingavailable;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setImagingavailable",
						String.class);

				method.invoke(_generalInformationRemoteModel, imagingavailable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTheregistrybiobanksislistedinotherinventoriesnetworks() {
		return _theregistrybiobanksislistedinotherinventoriesnetworks;
	}

	@Override
	public void setTheregistrybiobanksislistedinotherinventoriesnetworks(
		String theregistrybiobanksislistedinotherinventoriesnetworks) {
		_theregistrybiobanksislistedinotherinventoriesnetworks = theregistrybiobanksislistedinotherinventoriesnetworks;

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setTheregistrybiobanksislistedinotherinventoriesnetworks",
						String.class);

				method.invoke(_generalInformationRemoteModel,
					theregistrybiobanksislistedinotherinventoriesnetworks);
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

		if (_generalInformationRemoteModel != null) {
			try {
				Class<?> clazz = _generalInformationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifieddate", Date.class);

				method.invoke(_generalInformationRemoteModel, modifieddate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getBiomaterialcollectedinbiobankFormated() {
		try {
			String methodName = "getBiomaterialcollectedinbiobankFormated";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getGeneralInformationRemoteModel() {
		return _generalInformationRemoteModel;
	}

	public void setGeneralInformationRemoteModel(
		BaseModel<?> generalInformationRemoteModel) {
		_generalInformationRemoteModel = generalInformationRemoteModel;
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

		Class<?> remoteModelClass = _generalInformationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_generalInformationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneralInformationLocalServiceUtil.addGeneralInformation(this);
		}
		else {
			GeneralInformationLocalServiceUtil.updateGeneralInformation(this);
		}
	}

	@Override
	public GeneralInformation toEscapedModel() {
		return (GeneralInformation)ProxyUtil.newProxyInstance(GeneralInformation.class.getClassLoader(),
			new Class[] { GeneralInformation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneralInformationClp clone = new GeneralInformationClp();

		clone.setGeneralinformationId(getGeneralinformationId());
		clone.setOrganizationId(getOrganizationId());
		clone.setAcronym(getAcronym());
		clone.setDescription(getDescription());
		clone.setHosteinstitue(getHosteinstitue());
		clone.setTypeofhosteinstitue(getTypeofhosteinstitue());
		clone.setSourceoffunding(getSourceoffunding());
		clone.setCountry(getCountry());
		clone.setTargetpopulation(getTargetpopulation());
		clone.setYearofestablishment(getYearofestablishment());
		clone.setHowmanyrdsareintheregistrybiobank(getHowmanyrdsareintheregistrybiobank());
		clone.setPercentageofrarediseasesinyourregistrybiobank(getPercentageofrarediseasesinyourregistrybiobank());
		clone.setOntologies(getOntologies());
		clone.setBiomaterialcollected(getBiomaterialcollected());
		clone.setBiomaterialcollectedinbiobank(getBiomaterialcollectedinbiobank());
		clone.setBiomaterialprepared(getBiomaterialprepared());
		clone.setOrigionofcollection(getOrigionofcollection());
		clone.setUseofcollection(getUseofcollection());
		clone.setAssociateddataavailable(getAssociateddataavailable());
		clone.setImagingavailable(getImagingavailable());
		clone.setTheregistrybiobanksislistedinotherinventoriesnetworks(getTheregistrybiobanksislistedinotherinventoriesnetworks());
		clone.setModifieddate(getModifieddate());

		return clone;
	}

	@Override
	public int compareTo(GeneralInformation generalInformation) {
		long primaryKey = generalInformation.getPrimaryKey();

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

		if (!(obj instanceof GeneralInformationClp)) {
			return false;
		}

		GeneralInformationClp generalInformation = (GeneralInformationClp)obj;

		long primaryKey = generalInformation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{generalinformationId=");
		sb.append(getGeneralinformationId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", acronym=");
		sb.append(getAcronym());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", hosteinstitue=");
		sb.append(getHosteinstitue());
		sb.append(", typeofhosteinstitue=");
		sb.append(getTypeofhosteinstitue());
		sb.append(", sourceoffunding=");
		sb.append(getSourceoffunding());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", targetpopulation=");
		sb.append(getTargetpopulation());
		sb.append(", yearofestablishment=");
		sb.append(getYearofestablishment());
		sb.append(", howmanyrdsareintheregistrybiobank=");
		sb.append(getHowmanyrdsareintheregistrybiobank());
		sb.append(", percentageofrarediseasesinyourregistrybiobank=");
		sb.append(getPercentageofrarediseasesinyourregistrybiobank());
		sb.append(", ontologies=");
		sb.append(getOntologies());
		sb.append(", biomaterialcollected=");
		sb.append(getBiomaterialcollected());
		sb.append(", biomaterialcollectedinbiobank=");
		sb.append(getBiomaterialcollectedinbiobank());
		sb.append(", biomaterialprepared=");
		sb.append(getBiomaterialprepared());
		sb.append(", origionofcollection=");
		sb.append(getOrigionofcollection());
		sb.append(", useofcollection=");
		sb.append(getUseofcollection());
		sb.append(", associateddataavailable=");
		sb.append(getAssociateddataavailable());
		sb.append(", imagingavailable=");
		sb.append(getImagingavailable());
		sb.append(", theregistrybiobanksislistedinotherinventoriesnetworks=");
		sb.append(getTheregistrybiobanksislistedinotherinventoriesnetworks());
		sb.append(", modifieddate=");
		sb.append(getModifieddate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>generalinformationId</column-name><column-value><![CDATA[");
		sb.append(getGeneralinformationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acronym</column-name><column-value><![CDATA[");
		sb.append(getAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hosteinstitue</column-name><column-value><![CDATA[");
		sb.append(getHosteinstitue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeofhosteinstitue</column-name><column-value><![CDATA[");
		sb.append(getTypeofhosteinstitue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceoffunding</column-name><column-value><![CDATA[");
		sb.append(getSourceoffunding());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetpopulation</column-name><column-value><![CDATA[");
		sb.append(getTargetpopulation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearofestablishment</column-name><column-value><![CDATA[");
		sb.append(getYearofestablishment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>howmanyrdsareintheregistrybiobank</column-name><column-value><![CDATA[");
		sb.append(getHowmanyrdsareintheregistrybiobank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>percentageofrarediseasesinyourregistrybiobank</column-name><column-value><![CDATA[");
		sb.append(getPercentageofrarediseasesinyourregistrybiobank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ontologies</column-name><column-value><![CDATA[");
		sb.append(getOntologies());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biomaterialcollected</column-name><column-value><![CDATA[");
		sb.append(getBiomaterialcollected());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biomaterialcollectedinbiobank</column-name><column-value><![CDATA[");
		sb.append(getBiomaterialcollectedinbiobank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biomaterialprepared</column-name><column-value><![CDATA[");
		sb.append(getBiomaterialprepared());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>origionofcollection</column-name><column-value><![CDATA[");
		sb.append(getOrigionofcollection());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useofcollection</column-name><column-value><![CDATA[");
		sb.append(getUseofcollection());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associateddataavailable</column-name><column-value><![CDATA[");
		sb.append(getAssociateddataavailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagingavailable</column-name><column-value><![CDATA[");
		sb.append(getImagingavailable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>theregistrybiobanksislistedinotherinventoriesnetworks</column-name><column-value><![CDATA[");
		sb.append(getTheregistrybiobanksislistedinotherinventoriesnetworks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifieddate</column-name><column-value><![CDATA[");
		sb.append(getModifieddate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _generalinformationId;
	private long _organizationId;
	private String _acronym;
	private String _description;
	private String _hosteinstitue;
	private String _typeofhosteinstitue;
	private String _sourceoffunding;
	private String _country;
	private String _targetpopulation;
	private String _yearofestablishment;
	private String _howmanyrdsareintheregistrybiobank;
	private String _percentageofrarediseasesinyourregistrybiobank;
	private String _ontologies;
	private String _biomaterialcollected;
	private String _biomaterialcollectedinbiobank;
	private String _biomaterialprepared;
	private String _origionofcollection;
	private String _useofcollection;
	private String _associateddataavailable;
	private String _imagingavailable;
	private String _theregistrybiobanksislistedinotherinventoriesnetworks;
	private Date _modifieddate;
	private BaseModel<?> _generalInformationRemoteModel;
}