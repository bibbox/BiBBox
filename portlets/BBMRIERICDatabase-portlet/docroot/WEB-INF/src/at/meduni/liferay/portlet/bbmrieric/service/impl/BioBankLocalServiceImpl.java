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

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankImpl;
import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalService;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.BioBankLocalServiceBaseImpl;

/**
 * The implementation of the bio bank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.BioBankLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil
 */
public class BioBankLocalServiceImpl extends BioBankLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil} to access the bio bank local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public List<BioBank> notUpdatedBioBank(String uuid) {
		try {
			return bioBankPersistence.findByNotUUID(uuid);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::notUpdatedBioBank] Could not find BioBnaks with not having (" + uuid + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public BioBank createBioBank(String ldapbiobankID) {
		try {
			BioBankImpl biobank = new BioBankImpl();
			biobank.setBiobankId(CounterLocalServiceUtil.increment(BioBank.class.getName()));
			biobank.setLdapbiobankID(ldapbiobankID);
			return biobank;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::createBioBank] Error creating new Biobank.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param ldapbiobankid
	 * @return
	 */
	public BioBank getBioBank(String ldapbiobankID) {
		try {
			return bioBankPersistence.findByLADPBiobankId(ldapbiobankID);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBank] Could not get Biobank with LDAPBiobankId " + ldapbiobankID + ".");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<BioBank> getBioBankByCountry(String country) {
		try {
			if(country.equalsIgnoreCase("")) {
				return bioBankPersistence.findAll();
			} else {
				return bioBankPersistence.findByBiobankCountry(country);
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankByCountry] Could not get Biobank List for Countrys " + country + ".");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public String getBioBankByCountryInJavaScriptArray(String country) {
		String array = "";
		//{Name: 'Test', OrganizationLink: '/home', Type: 'Biobank', 'Number of Cases': 5, 'Data Access Committe': 'no', 'Request data':  'http://rd-connect.eu', 'Nuber of access': 0}
		try {
			List<BioBank> biobanks = null;
			if(country.equalsIgnoreCase("")) {
				biobanks = bioBankPersistence.findAll();
			} else {
				biobanks = bioBankPersistence.findByBiobankCountry(country);
			}
			String seperator = "";
			for(BioBank biobank : biobanks) {
				array += seperator + "{";
				//Country
				array += "Country: '" + biobank.getBiobankcountry().replaceAll("'", "\\\\'") + "',";
				//BB ID
				array += "'BB_ID': '" + biobank.getLdapbiobankID().replaceAll("'", "\\\\'") + "',";
				//Name
				array += "Name: '" + biobank.getBiobankname().replaceAll("'", "\\\\'") + "',";
				//Type
				array += "Type: '" + biobank.getBiobanktype().replaceAll("'", "\\\\'").replaceAll(", biobankContact", "").replaceAll("biobankContact", "") + "',";
				//Size
				array += "Size: '" + biobank.getBiobanksize().replaceAll("'", "\\\\'") + "',";
				//Juristic Person
				array += "'Juristic Person': '" + biobank.getBiobankjuristicperson().replaceAll("'", "\\\\'") + "'";
				array += "}";
				seperator = ",";
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankByCountry] Could not get Biobank List for Countrys " + country + ".");
		}
		return array;
	}
	
	public String getBioBankFiltered(String keyword, String country, String materialtype, String diagnosisavailable, String biobanksize, String typeofbiobank) {
		String array = "";
		try {
			DynamicQuery dynamicQuery = BioBankLocalServiceUtil.dynamicQuery();		
			Criterion criterion = null;
			
			if(!keyword.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(RestrictionsFactoryUtil.ilike("searchindexvalue", "%" + keyword + "%"));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!country.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(PropertyFactoryUtil.forName("searchindexvalue").eq(country));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!diagnosisavailable.equalsIgnoreCase("")) {
				Criterion criterion_sub = createSearchDiagnosisString(diagnosisavailable);
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(criterion_sub);
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));

				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!materialtype.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				Criterion criterion_sub = RestrictionsFactoryUtil.like("searchindexkey", materialtype);
				criterion_sub = RestrictionsFactoryUtil.and(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "TRUE"));
				subQuery.add(criterion_sub);
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!typeofbiobank.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				Criterion criterion_sub = RestrictionsFactoryUtil.like("searchindexkey", "objectClass");
				criterion_sub = RestrictionsFactoryUtil.and(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + typeofbiobank + "%"));
				subQuery.add(criterion_sub);
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!biobanksize.equalsIgnoreCase("")) {
				
				String bbsize = "";
				if(biobanksize.equalsIgnoreCase("< 10 Samples")) {
		        	 bbsize = "0";
				} else if(biobanksize.equalsIgnoreCase("10 - 100 Samples")) {
		        	 bbsize = "1";
				} else if(biobanksize.equalsIgnoreCase("100 - 1.000 Samples")) {
		        	 bbsize = "2";
				} else if(biobanksize.equalsIgnoreCase("1.000 - 10.000 Samples")) {
		        	 bbsize = "3";
				} else if(biobanksize.equalsIgnoreCase("10.000 - 100.000 Samples")) {
		        	 bbsize = "4";
				} else if(biobanksize.equalsIgnoreCase("100.000 - 1.000.000 Samples")) {
		        	 bbsize = "5";
				} else if(biobanksize.equalsIgnoreCase("1.000.000 - 10.000.000 Samples")) {
		        	 bbsize = "6";
				} else if(biobanksize.equalsIgnoreCase("10.000.000 - 100.000.000 Samples")) {
		        	 bbsize = "7";
				} else if(biobanksize.equalsIgnoreCase("100.000.000 - 1.000.000.000 Samples")) {
		        	 bbsize = "8";
				}
				
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				Criterion criterion_sub = RestrictionsFactoryUtil.like("searchindexkey", "biobankSize");
				criterion_sub = RestrictionsFactoryUtil.and(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", bbsize));
				subQuery.add(criterion_sub);
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			// Add Criterion to the Main Biobank Query
			if(criterion != null) {
				dynamicQuery.add(criterion);
			}
			List<BioBank> biobanks = BioBankLocalServiceUtil.dynamicQuery(dynamicQuery);
			String seperator = "";
			for(BioBank biobank : biobanks) {
				String diagnosis_avialavble = "";
				SearchIndex searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "diagnosisAvailable");
				if(searchindex != null) {
					diagnosis_avialavble = searchindex.getSearchindexvalue().replaceAll("urn:miriam:", "");
				}
				array += seperator + "{";
				//Country
				array += "Country: '" + biobank.getBiobankcountry().replaceAll("'", "\\\\'") + "',";
				//BB ID
				array += "'BB_ID': '" + biobank.getLdapbiobankID().replaceAll("'", "\\\\'") + "',";
				//BB Diagnosis
				array += "'Diagnosis': '" + diagnosis_avialavble.replaceAll("'", "\\\\'") + "',";
				//Name
				array += "Name: '" + biobank.getBiobankname().replaceAll("'", "\\\\'") + "',";
				//Type
				array += "Type: '" + biobank.getBiobanktype().replaceAll("'", "\\\\'") + "',";
				//Size
				array += "Size: '" + biobank.getBiobanksize().replaceAll("'", "\\\\'") + "',";
				//Juristic Person
				array += "'Juristic Person': '" + biobank.getBiobankjuristicperson().replaceAll("'", "\\\\'") + "'";
				array += "}";
				seperator = ",";
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankFiltered] Could not get Biobank List filtered (" + keyword + ", " + country + ", " + materialtype + ", " + diagnosisavailable + ", " + biobanksize + ").");
			ex.printStackTrace();
		}
		return array;
	}
	
	private Criterion createSearchDiagnosisString(String diagnosisavailable) {
		Criterion criterion_sub = null;
		if(diagnosisavailable.contains("--")) {
			diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("-", "").trim();
			criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable + "%");
			if(diagnosisavailable.startsWith("B")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%A00-B%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%B*%"));
			} else if(diagnosisavailable.startsWith("D")) {
				try {
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					if(number >= 50) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D50-D%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%C00-D%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			} else if(diagnosisavailable.startsWith("H")) {
				try {
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					if(number >= 60) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H60-H%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H00-H%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			} else if(diagnosisavailable.startsWith("T")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%S00-T%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%T*%"));
			} else if(diagnosisavailable.startsWith("Y")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%V00-Y%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%Y*%"));
			} else {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "00-%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "*%"));
			}
			criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%icd:*%"));
		} else if(diagnosisavailable.contains("-")) {
			// Subgroup
			try {
				diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("- ", "").trim();
				// Search for individual codes
				String startletter = String.valueOf(diagnosisavailable.charAt(0));
				int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
				int number_stop = Integer.parseInt(diagnosisavailable.substring(5, 7));
				for(int counter = (int)Math.floor(number/10.); counter <= (int)Math.floor(number_stop/10.); counter ++) {
					if(criterion_sub == null) {
						criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%");
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%"));
					}
				}
				// Search for groups
				if(diagnosisavailable.startsWith("B")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%A00-B%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%B*%"));
				} else if(diagnosisavailable.startsWith("D")) {
					try {
						if(number >= 50) {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D50-D%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
						} else {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%C00-D%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				} else if(diagnosisavailable.startsWith("H")) {
					try {
						if(number >= 60) {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H60-H%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
						} else {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H00-H%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				} else if(diagnosisavailable.startsWith("T")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%S00-T%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%T*%"));
				} else if(diagnosisavailable.startsWith("Y")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%V00-Y%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%Y*%"));
				} else {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "00-%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "*%"));
				}
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%icd:*%"));
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			if(diagnosisavailable.contains("ICD*")) {
				criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%icd:%");
			} else if(diagnosisavailable.contains("OMIM*")) {
				criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%omim:%");
			} else if(diagnosisavailable.contains("ORPHA*")) {
				criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%orphanet%");
			} else {
				// Gruppen Search
				try {
					diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("- ", "").trim();
					//System.out.println("++++++" + startletter + number + diagnosisavailable.substring(4, 5) + number_stop);
					String startletter = String.valueOf(diagnosisavailable.charAt(0));
					String endletter = diagnosisavailable.substring(4, 5);
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					int number_stop = Integer.parseInt(diagnosisavailable.substring(5, 7));
					// Search for individual codes
					if(startletter.equalsIgnoreCase(endletter)) {
						for(int counter = (int)Math.floor(number/10.); counter <= (int)Math.floor(number_stop/10.); counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%"));
							}
						}
					} else {
						for(int counter = (int)Math.floor(number/10.); counter <= 9; counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%"));
							}
						}
						for(int counter = 0; counter <= (int)Math.floor(number_stop/10.); counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + startletter + counter + "%"));
							}
						}
					}
					// Search for groups
					if(diagnosisavailable.startsWith("B")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%A00-B%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%B*%"));
					} else if(diagnosisavailable.startsWith("D")) {
						try {
							if(number >= 50) {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D50-D%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%C00-D%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%D*%"));
							}
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					} else if(diagnosisavailable.startsWith("H")) {
						try {
							if(number >= 60) {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H60-H%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H00-H%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%H*%"));
							}
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					} else if(diagnosisavailable.startsWith("T")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%S00-T%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%T*%"));
					} else if(diagnosisavailable.startsWith("Y")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%V00-Y%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%Y*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "00-%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%" + diagnosisavailable.charAt(0) + "*%"));
					}
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "%icd:*%"));
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		System.out.println("|" + diagnosisavailable + "|");
		return criterion_sub;
	}
}