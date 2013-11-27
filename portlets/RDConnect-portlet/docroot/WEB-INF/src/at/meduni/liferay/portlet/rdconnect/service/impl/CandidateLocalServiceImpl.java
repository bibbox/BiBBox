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

package at.meduni.liferay.portlet.rdconnect.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import at.meduni.liferay.portlet.rdconnect.model.Candidate;
import at.meduni.liferay.portlet.rdconnect.service.base.CandidateLocalServiceBaseImpl;

/**
 * The implementation of the candidate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.service.CandidateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.base.CandidateLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil
 */
public class CandidateLocalServiceImpl extends CandidateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.CandidateLocalServiceUtil} to access the candidate local service.
	 */
	
	public Candidate addCandidate(Candidate newCandidate) throws SystemException {
		Candidate candidate = candidatePersistence.create((int) counterLocalService.increment(Candidate.class.getName()) + 10000);
		candidate.setName(newCandidate.getName());
		candidate.setSource(newCandidate.getSource());
		candidate.setUrl(newCandidate.getUrl());
		candidate.setContactperson(newCandidate.getContactperson());
		candidate.setCandidatetype(newCandidate.getCandidatetype());
		candidate.setSubunitof(newCandidate.getSubunitof());
		candidate.setCountry(newCandidate.getCountry());
		candidate.setDiseasescodes(newCandidate.getDiseasescodes());
		candidate.setDiseasesfreetext(newCandidate.getDiseasesfreetext());
		candidate.setComment(newCandidate.getComment());
		candidate.setAddress(newCandidate.getAddress());
		candidate.setDate(new Date());
		candidate.setSearchurl(newCandidate.getSearchurl());
		candidate.setSourceId(newCandidate.getSourceId());
		candidate.setMail(newCandidate.getMail());
		candidate.setHead(newCandidate.getHead());
		
		//userPersistence
		//com.liferay.portal.service.persistence.OrganizationPersistence ld;
		//ld.create(organizationId)
		
		
		return candidatePersistence.update(candidate);
	}
	
	public List<Candidate> getAllCandidates() throws SystemException {
		List<Candidate> candidates = candidatePersistence.findBySubRemover("");
		return candidates;	
	}
	
	public List<Candidate> getFilterdCandidates(String name, String country, String type, String source) throws SystemException {
		if(country.equals("all")) {
			country = "%";
		} else {
			country = "%" + country + "%";
		}
		if(type.equals("all")) {
			type = "%";
		} else {
			if(type.equals("Registry"))
				type = "%" + "Registr" + "%";
			else
				type = "%" + type + "%";
		}
		if(source.equals("all")) {
			source = "%";
		} else {
			source = "%" + source + "%";
		}
		if(name.equals("")) {
			name = "%";
		} else {
			name = "%" + name + "%";
		}
		List<Candidate> candidates = candidatePersistence.findByCNST(country, name, source, type, "");
		return candidates;	
	}
	
	public String[] getSource() {
		String[] array = new String[] { "all", "orpha.net", "bbmri.eu", "rd-neuromics.eu", "ee", "eurobiobank.org", "online propose"};
		return array;
	}
	
	public String[] getTypesOfCandidates() {
		String[] array = new String[] { "all", "Biobank", "Registry"};
		return array;
	}
	
	public String[] getTypesOfCandidatesNewEntry() {
		String[] array = new String[] { "Biobank", "Registry", "Biobank/Registry"};
		return array;
	}
	
	public String[] getCountryNames() {
		String[] array = new String[] { 
				"all",
				"AUSTRALIA",
				"AUSTRIA",
				"BELGIUM",
				"BULGARIA",
				"CANADA",
				"CROATIA",
				"CYPRUS",
				"CZECH REPUBLIC",
				"DENMARK",
				"ESTONIA",
				"FINLAND",
				"FRANCE",
				"GEORGIA",
				"GERMANY",
				"GREECE",
				"HUNGARY",
				"ICELAND",
				"INTERNATIONAL",
				"IRELAND",
				"ISRAEL",
				"ITALY",
				"LATVIA",
				"LITHUANIA",
				"LUXEMBOURG",
				"MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF",
				"MALTA",
				"MOROCCO",
				"NETHERLANDS",
				"NORWAY",
				"POLAND",
				"PORTUGAL",
				"ROMANIA",
				"RUSSIA",
				"SERBIA",
				"SLOVAKIA",
				"SLOVENIA",
				"SPAIN",
				"SWEDEN",
				"SWITZERLAND",
				"TURKEY",
				"UKRAINE",
				"UNITED KINGDOM",
				"UNITED STATES" };
		return array;
	}
}