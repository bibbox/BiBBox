package at.graz.meduni.liferay.portlet.bibbox.importer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.ImporterConfigLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ScaleusImporter
 */
public class ScaleusImporter extends MVCPortlet {
	String date_format_pattern_ = "dd.mm.yyyy";
	SimpleDateFormat date_format_ = new SimpleDateFormat(date_format_pattern_);
	List<String> trutelLines = new ArrayList<String>();
	
	public void testImport(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Starting Scaleus Import...");
		try {
			
			
		clearScaleusDatabase();
		
		HashMap<String, String> biobank = readBiobankData(request);
		HashMap<String, String> collection = readCollectionData(request);
		HashMap<String, String> diseasematrix_list = readDiseaseMatrixData(request);
		HashMap<String, String> user_list = readUserData(request);
		
		String url = "http://localhost:8085/scaleus/api/v1/store/default";
		
		long organizationId = 0;
		
		HttpClient c = HttpClientBuilder.create().build();
		
		HttpPost p = new HttpPost(url);
		p.setHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
		
		long companyid = 10154;
		long parentid = 10709;
		
		String identifier_string = "apiv1/regbb/organization-id";
		String BiobankID = ParamUtil.getString(request, "BiobankID");
		if(!BiobankID.equals("")) {
			identifier_string = BiobankID;
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "BiobankID", BiobankID);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "BiobankID", "");
		}
		String identifier_collection_string = "collection-id";
		String CollectionID = ParamUtil.getString(request, "CollectionID");
		if(!CollectionID.equals("")) {
			identifier_collection_string = CollectionID;
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CollectionID", CollectionID);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CollectionID", "");
		}
		String identifier_diseasmatrix_string = "disease-matrix-id";
		String DiseaseMatrixID = ParamUtil.getString(request, "DiseaseMatrixID");
		if(!DiseaseMatrixID.equals("")) {
			identifier_diseasmatrix_string = DiseaseMatrixID;
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DiseaseMatrixID", DiseaseMatrixID);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DiseaseMatrixID", "");
		}
		String identifier_user_string = "person-id";
		String UserID = ParamUtil.getString(request, "UserID");
		if(!UserID.equals("")) {
			identifier_user_string = UserID;
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "UserID", UserID);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "UserID", "");
		}
		long maincontactrole = Long.parseLong(PropsUtil.get("rdconnectmaincontactid"));
		String MaincontactIDPredicate = ParamUtil.getString(request, "MaincontactIDPredicate");
		ImporterConfigLocalServiceUtil.setPredicate("scaleus", "MaincontactIDPredicate", MaincontactIDPredicate);
		String CollectionIDPredicate = ParamUtil.getString(request, "CollectionIDPredicate");
		ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CollectionIDPredicate", CollectionIDPredicate);
		String DiseasMatrixIDPredicate = ParamUtil.getString(request, "DiseasMatrixIDPredicate");
		ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DiseasMatrixIDPredicate", DiseasMatrixIDPredicate);
		
		
		
		// Regular input
		for(Organization organization : OrganizationLocalServiceUtil.getOrganizations(companyid, parentid)) {
			System.out.println("Creating entry for Organization: " + organization.getName());
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank"))
				continue;
			organizationId = organization.getOrganizationId();
			addScaleusEntry(p, c, "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organizationId, "http://purl.org/dc/terms/identifier", String.valueOf(organization.getOrganizationId()));
			addScaleusEntry(p, c, "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organizationId, "http://purl.org/dc/terms/name", organization.getName());
			addScaleusEntry(p, c, "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organizationId, "http://purl.org/dc/terms/type", organization.getExpandoBridge().getAttribute("Organization Type").toString());
			
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			for(Website website : websites) {
				addScaleusEntry(p, c, "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organizationId, "http://purl.org/dc/terms/url", website.getUrl());
			}
			
			String biobankidentifier = "http://catalogue.rd-connect.eu/" + identifier_string + "/" + organization.getOrganizationId();
			
			List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			
			for(String biobank_key : biobank.keySet()) {
				for(String value : getBiobankDataValue(biobank_key, organization, request, rdc_recordlist)) {
					addScaleusEntry(p, c, biobankidentifier, biobank.get(biobank_key), value);
				}
			}
			// Add Collection
			String collectionidentifier = biobankidentifier + "/" + identifier_collection_string + "/1";
			if(!CollectionIDPredicate.equals("")) {
				addScaleusEntry(p, c, biobankidentifier, CollectionIDPredicate, collectionidentifier);
			}
			addScaleusEntry(p, c, collectionidentifier, collection.get("CollectionNamePredicate"), "default");
			
			// Add DiseaseMatrix
			List<DiseaseMatrix> diseasematrixes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organization.getOrganizationId(), -1, -1);
			for(DiseaseMatrix diseasematrix : diseasematrixes) {
				String diseasematrixidentifier = collectionidentifier + "/" + identifier_diseasmatrix_string + "/" + diseasematrix.getDiseasematrixId();
				if(!DiseasMatrixIDPredicate.equals("")) {
					addScaleusEntry(p, c, collectionidentifier, DiseasMatrixIDPredicate, diseasematrixidentifier);
				}
				for(String diseasematrix_key : diseasematrix_list.keySet()) {
					for(String value : getDiseaseMatrixDataValue(diseasematrix_key, organization, diseasematrix)) {
						addScaleusEntry(p, c, diseasematrixidentifier, diseasematrix_list.get(diseasematrix_key), value);
					}
				}
			}
			// Add User
			
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organizationId);
			for(User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == maincontactrole) {
						String useridentifier = "http://catalogue.rd-connect.eu/" + identifier_user_string + "/" + user_mc.getUserId();
						if(!MaincontactIDPredicate.equals("")) {
							addScaleusEntry(p, c, biobankidentifier, MaincontactIDPredicate, useridentifier);
						}
						for(String user_key : user_list.keySet()) {
							for(String value : getUserDataValue(user_key, organization, user_mc)) { 
								addScaleusEntry(p, c, useridentifier, user_list.get(user_key), value);
							}
						}				
					}
				}
			}
		}
		
			
			Path file = Paths.get("/opt/liferay/turtel.txt");
			Files.write(file, trutelLines, StandardCharsets.UTF_8);
		
		} catch (Exception e) {
			System.err.println("Not handelt exception in scaleus importer.");
			e.printStackTrace();
		}
		System.out.println("Scaleus Import done ...");
	}
	
	private String[] getUserDataValue(String datafield, Organization organization, User user) {
		if(datafield.equals("FirstnamePredicate")) {
			return new String[]{user.getFirstName()};
		}
		if(datafield.equals("LastnamePredicate")) {
			return new String[]{user.getLastName()};
		}
		if(datafield.equals("EMailPredicate")) {
			return new String[]{user.getEmailAddress()};
		}
		/*
		List<Phone> phones = user_mc.getPhones();
		for(Phone phone: phones) {
			if(phone.isPrimary()) {
				json_main_contact.put("phone", phone.getNumber() + "" + phone.getExtension());
			}
		}		 
		*/
		return new String[]{};
	}
	
	private String[] getDiseaseMatrixDataValue(String datafield, Organization organization, DiseaseMatrix diseasematrix) {
		if(datafield.equals("DiseaseName")) {
			return new String[]{diseasematrix.getDiseasename()};
		}
		if(datafield.equals("NumberOfPatients")) {
			return new String[]{diseasematrix.getPatientcount()};
		}
		if(datafield.equals("Gene")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			for(String gene : diseasematrix.getGene().split(",|;")) {
				if(!gene.trim().equals("")) {
					returnurls.add(gene.trim());
				}
			}
			return returnurls.toArray(new String[]{});
		}
		if(datafield.equals("ORPHACode")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			for(String orpha : diseasematrix.getOrphanumber().split(",|;")) {
				if(!orpha.trim().equals("")) {
					if(orpha.trim().startsWith("ORPHA")) {
						returnurls.add(orpha.trim());
					} else {
						returnurls.add("ORPHA"  + orpha.trim());
					}
					
				}
			}
			return returnurls.toArray(new String[]{});
		}
		if(datafield.equals("ICD10")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			for(String icd10 : diseasematrix.getIcd10().split(",|;")) {
				if(!icd10.trim().equals("")) {
					returnurls.add(icd10.trim());
				}
			}
			return returnurls.toArray(new String[]{});
		}
		if(datafield.equals("OMIM")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			for(String omim : diseasematrix.getOmim().split(",|;")) {
				if(!omim.trim().equals("")) {
					if(omim.trim().startsWith("#")) {
						returnurls.add(omim.trim());
					} else {
						returnurls.add("#"  + omim.trim());
					}
					
				}
			}
			return returnurls.toArray(new String[]{});
		}
		if(datafield.equals("Synonym")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			for(String synonym : diseasematrix.getSynonym().split(",|;")) {
				if(!synonym.trim().equals("")) {
					returnurls.add(synonym.trim());
				}
			}
			return returnurls.toArray(new String[]{});
		}
		if(datafield.equals("ModifiedDate")) {
			return new String[]{date_format_.format(diseasematrix.getModifieddate())};
		}
		return new String[]{};
	}
	
	private String[] getBiobankDataValue(String datafield, Organization organization, ActionRequest request, List<DDLRecordSet> rdc_recordlist) {
		
		if(datafield.equals("NamePredicate")) {
			return new String[]{organization.getName()};
		}
		if(datafield.equals("OrganizationIDPredicate")) {
			return new String[]{String.valueOf(organization.getOrganizationId())};
		}
		if(datafield.equals("TypePredicate")) {
			return new String[]{organization.getExpandoBridge().getAttribute("Organization Type").toString()};
		}
		if(datafield.equals("AcronymPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("acronym") != null) {
								return new String[]{record.getField("acronym").getValue().toString()};
							}
			  			}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("URLPredicate")) {
			try {
				ArrayList<String> returnurls = new ArrayList<String>();
				List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
				for(Website website : websites) {
					returnurls.add(website.getUrl());
				}
				return returnurls.toArray(new String[]{});
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(datafield.equals("IDCardURLPredicate")) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			return new String[]{themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL()};
		}
		if(datafield.equals("AlsoListedInPredicate")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
								String[] also_listed_in = record.getField("The_registry_biobanks_is_listed_in_other_inventories_networks").getValue().toString().replaceAll("\"\\]|\\[\"", "").split("\",\"");
								for(String also_listed_initems : also_listed_in) {
									if(also_listed_initems.equalsIgnoreCase("not specified")) {
										continue;
									}
									if(also_listed_initems.equalsIgnoreCase("none")) {
										continue;
									}
									returnurls.add(also_listed_initems);
								}
							}
							if(record.getField("Additional_networks_inventories") != null) {
								String[] also_listed_in = record.getField("Additional_networks_inventories").getValue().toString().split(",|;");
								for(String also_listed_initems : also_listed_in) {
									returnurls.add(also_listed_initems.trim());
								}
							}
			  			}
						return returnurls.toArray(new String[]{});
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("LastActivitiesPredicate")) {
			return new String[]{date_format_.format(organization.getModifiedDate())};
		}
		if(datafield.equals("DateOfInclusioPredicate")) {
			return new String[]{date_format_.format(organization.getCreateDate())};
		}
		if(datafield.equals("TypeOfHostInstitutionPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						String returnvalue = "";
						for(DDLRecord record : records) {
							if(record.getField("Host_institution_is_a") != null) {
								returnvalue += record.getField("Host_institution_is_a").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
							if(record.getField("Type_of_host_institution") != null) {
								returnvalue += record.getField("Type_of_host_institution").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
			  			}
						return new String[]{returnvalue};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("TargetPopulationPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						String returnvalue = "";
						for(DDLRecord record : records) {
							
							/*if(record.getField("countryCode") != null) {
								returnvalue += record.getField("countryCode").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}*/
							if(record.getField("Target_population_of_the_registry") != null) {
								returnvalue += record.getField("Target_population_of_the_registry").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
				  		}
						return new String[]{returnvalue};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("TargetContryPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						String returnvalue = "";
						for(DDLRecord record : records) {
							
							if(record.getField("countryCode") != null) {
								returnvalue += record.getField("countryCode").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
							
				  		}
						return new String[]{returnvalue};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("AddressPredicate")) {
			String returnvalue = organization.getAddress().getStreet1();
			if(!organization.getAddress().getStreet2().equals("")) {
				returnvalue += ", " + organization.getAddress().getStreet2();
			}
			if(!organization.getAddress().getStreet3().equals("")) {
				returnvalue += ", " + organization.getAddress().getStreet3();
			}
			if(!organization.getAddress().getZip().equals("")) {
				returnvalue += ", " + organization.getAddress().getZip();
			}
			if(!organization.getAddress().getCity().equals("")) {
				returnvalue += ", " + organization.getAddress().getCity();
			}
			if(!organization.getAddress().getCountry().getName().equals("")) {
				returnvalue += ", " + organization.getAddress().getCountry().getName();
			}
			return new String[]{returnvalue};
		}
		if(datafield.equals("NameOfHostInstitutionPredicate")) {
			if(!organization.getAddress().getStreet1().equals("")) {
				return new String[]{organization.getAddress().getStreet1()};
			}
		}
		if(datafield.equals("Street1Predicate")) {
			if(!organization.getAddress().getStreet2().equals("")) {
				return new String[]{organization.getAddress().getStreet2()};
			}
		}
		if(datafield.equals("Street2Predicate")) {
			if(!organization.getAddress().getStreet3().equals("")) {
				return new String[]{organization.getAddress().getStreet3()};
			}
		}
		if(datafield.equals("ZIPPredicate")) {
			if(!organization.getAddress().getZip().equals("")) {
				return new String[]{organization.getAddress().getZip()};
			}
		}
		if(datafield.equals("CityPredicate")) {
			if(!organization.getAddress().getZip().equals("")) {
				return new String[]{organization.getAddress().getCity()};
			}
		}
		if(datafield.equals("CountryPredicate")) {
			if(!organization.getAddress().getZip().equals("")) {
				return new String[]{organization.getAddress().getCountry().getName()};
			}
		}
		if(datafield.equals("DescriptionPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("Description") != null) {
								return new String[]{record.getField("Description").getValue().toString().replaceAll("\"\\]|\\[\"", "")};
							}
				  		}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("SourceOfFundingPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						String returnvalue = "";
						for(DDLRecord record : records) {
							
							if(record.getField("Source_of_funding") != null) {
								returnvalue += record.getField("Source_of_funding").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
							if(record.getField("Text5085") != null) {
								returnvalue += record.getField("Text5085").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
				  		}
						return new String[]{returnvalue};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("YearOfEstablishmentPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("year_of_establishment") != null) {
								return new String[]{record.getField("year_of_establishment").getValue().toString().replaceAll("\"\\]|\\[\"", "")};
							}
				  		}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("OntologiesPredicate")) {
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						String returnvalue = "";
						for(DDLRecord record : records) {
							
							if(record.getField("Ontologies") != null) {
								returnvalue += record.getField("Ontologies").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
							if(record.getField("Additional_Ontologies") != null) {
								returnvalue += record.getField("Additional_Ontologies").getValue().toString().replaceAll("\"\\]|\\[\"", "");
							}
				  		}
						return new String[]{returnvalue};
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("AssociatedDataAvailablePredicate")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("Associated_data_available") != null) {
								String[] also_listed_in = record.getField("Associated_data_available").getValue().toString().replaceAll("\"\\]|\\[\"", "").split("\",\"");
								for(String also_listed_initems : also_listed_in) {
									if(also_listed_initems.equalsIgnoreCase("not specified")) {
										continue;
									}
									if(also_listed_initems.equalsIgnoreCase("none")) {
										continue;
									}
									returnurls.add(also_listed_initems);
								}
							}
							if(record.getField("Additional_Associated_data_available") != null) {
								String[] also_listed_in = record.getField("Additional_Associated_data_available").getValue().toString().split(",|;");
								for(String also_listed_initems : also_listed_in) {
									returnurls.add(also_listed_initems.trim());
								}
							}
			  			}
						return returnurls.toArray(new String[]{});
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		if(datafield.equals("ImagingAvailablePredicate")) {
			ArrayList<String> returnurls = new ArrayList<String>();
			String ddlname = "default";
			if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
					try {
						List<DDLRecord> records = rdc_rs.getRecords();
						for(DDLRecord record : records) {
							if(record.getField("Imaging_available") != null) {
								String[] also_listed_in = record.getField("Imaging_available").getValue().toString().replaceAll("\"\\]|\\[\"", "").split("\",\"");
								for(String also_listed_initems : also_listed_in) {
									if(also_listed_initems.equalsIgnoreCase("not specified")) {
										continue;
									}
									if(also_listed_initems.equalsIgnoreCase("none")) {
										continue;
									}
									returnurls.add(also_listed_initems);
								}
							}
							if(record.getField("Additional_Imaging_available") != null) {
								String[] also_listed_in = record.getField("Additional_Imaging_available").getValue().toString().split(",|;");
								for(String also_listed_initems : also_listed_in) {
									returnurls.add(also_listed_initems.trim());
								}
							}
			  			}
						return returnurls.toArray(new String[]{});
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			}
		}
		
		return new String[]{};
	}
	
	private HashMap<String, String> readUserData(ActionRequest request) {
		HashMap<String, String> user = new HashMap<String, String>();
		String FirstnamePredicate = ParamUtil.getString(request, "FirstnamePredicate");
		if(!FirstnamePredicate.equals("")) {
			user.put("FirstnamePredicate", FirstnamePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "FirstnamePredicate", FirstnamePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "FirstnamePredicate", "");
		}
		String LastnamePredicate = ParamUtil.getString(request, "LastnamePredicate");
		if(!LastnamePredicate.equals("")) {
			user.put("LastnamePredicate", LastnamePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "LastnamePredicate", LastnamePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "LastnamePredicate", "");
		}
		String EMailPredicate = ParamUtil.getString(request, "EMailPredicate");
		if(!EMailPredicate.equals("")) {
			user.put("EMailPredicate", EMailPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "EMailPredicate", EMailPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "EMailPredicate", "");
		}
		return user;
	}
	
	private HashMap<String, String> readDiseaseMatrixData(ActionRequest request) {
		HashMap<String, String> diseasematrix = new HashMap<String, String>();
		String DiseaseName = ParamUtil.getString(request, "DiseaseName");
		if(!DiseaseName.equals("")) {
			diseasematrix.put("DiseaseName", DiseaseName);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DiseaseName", DiseaseName);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DiseaseName", "");
		}
		String NumberOfPatients = ParamUtil.getString(request, "NumberOfPatients");
		if(!NumberOfPatients.equals("")) {
			diseasematrix.put("NumberOfPatients", NumberOfPatients);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NumberOfPatients", NumberOfPatients);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NumberOfPatients", "");
		}
		String Gene = ParamUtil.getString(request, "Gene");
		if(!Gene.equals("")) {
			diseasematrix.put("Gene", Gene);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Gene", Gene);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Gene", "");
		}
		String ORPHACode = ParamUtil.getString(request, "ORPHACode");
		if(!ORPHACode.equals("")) {
			diseasematrix.put("ORPHACode", ORPHACode);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ORPHACode", ORPHACode);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ORPHACode", "");
		}
		String ICD10 = ParamUtil.getString(request, "ICD10");
		if(!ICD10.equals("")) {
			diseasematrix.put("ICD10", ICD10);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ICD10", ICD10);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ICD10", "");
		}
		String OMIM = ParamUtil.getString(request, "OMIM");
		if(!OMIM.equals("")) {
			diseasematrix.put("OMIM", OMIM);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OMIM", OMIM);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OMIM", "");
		}
		String Synonym = ParamUtil.getString(request, "Synonym");
		if(!Synonym.equals("")) {
			diseasematrix.put("Synonym", Synonym);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Synonym", Synonym);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Synonym", "");
		}
		String ModifiedDate = ParamUtil.getString(request, "ModifiedDate");
		if(!ModifiedDate.equals("")) {
			diseasematrix.put("ModifiedDate", ModifiedDate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ModifiedDate", ModifiedDate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ModifiedDate", "");
		}
		return diseasematrix;
	}
	
	private HashMap<String, String> readCollectionData(ActionRequest request) {
		HashMap<String, String> collection = new HashMap<String, String>();
		String CollectionNamePredicate = ParamUtil.getString(request, "CollectionNamePredicate");
		if(!CollectionNamePredicate.equals("")) {
			collection.put("CollectionNamePredicate", CollectionNamePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CollectionNamePredicate", CollectionNamePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CollectionNamePredicate", "");
		}
		return collection;
	}
	
	private HashMap<String, String> readBiobankData(ActionRequest request) {
		HashMap<String, String> biobank = new HashMap<String, String>();
		
		String NamePredicate = ParamUtil.getString(request, "NamePredicate");
		if(!NamePredicate.equals("")) {
			biobank.put("NamePredicate", NamePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NamePredicate", NamePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NamePredicate", "");
		}
		String OrganizationIDPredicate = ParamUtil.getString(request, "OrganizationIDPredicate");
		if(!OrganizationIDPredicate.equals("")) {
			biobank.put("OrganizationIDPredicate", OrganizationIDPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OrganizationIDPredicate", OrganizationIDPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OrganizationIDPredicate", "");
		}
		String AcronymPredicate = ParamUtil.getString(request, "AcronymPredicate");
		if(!AcronymPredicate.equals("")) {
			biobank.put("AcronymPredicate", AcronymPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AcronymPredicate", AcronymPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AcronymPredicate", "");
		}
		String TypePredicate = ParamUtil.getString(request, "TypePredicate");
		if(!TypePredicate.equals("")) {
			biobank.put("TypePredicate", TypePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TypePredicate", TypePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TypePredicate", "");
		}   
		String URLPredicate = ParamUtil.getString(request, "URLPredicate");
		if(!URLPredicate.equals("")) {
			biobank.put("URLPredicate", URLPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "URLPredicate", URLPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "URLPredicate", "");
		}
		String IDCardURLPredicate = ParamUtil.getString(request, "IDCardURLPredicate");
		if(!IDCardURLPredicate.equals("")) {
			biobank.put("IDCardURLPredicate", IDCardURLPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "IDCardURLPredicate", IDCardURLPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "IDCardURLPredicate", "");
		}
		String AlsoListedInPredicate = ParamUtil.getString(request, "AlsoListedInPredicate");
		if(!AlsoListedInPredicate.equals("")) {
			biobank.put("AlsoListedInPredicate", AlsoListedInPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AlsoListedInPredicate", AlsoListedInPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AlsoListedInPredicate", "");
		}
		String LastActivitiesPredicate = ParamUtil.getString(request, "LastActivitiesPredicate");
		if(!LastActivitiesPredicate.equals("")) {
			biobank.put("LastActivitiesPredicate", LastActivitiesPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "LastActivitiesPredicate", LastActivitiesPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "LastActivitiesPredicate", "");
		}
		String DateOfInclusioPredicate = ParamUtil.getString(request, "DateOfInclusioPredicate");
		if(!DateOfInclusioPredicate.equals("")) {
			biobank.put("DateOfInclusioPredicate", DateOfInclusioPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DateOfInclusioPredicate", DateOfInclusioPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DateOfInclusioPredicate", "");
		}
		String TypeOfHostInstitutionPredicate = ParamUtil.getString(request, "TypeOfHostInstitutionPredicate");
		if(!TypeOfHostInstitutionPredicate.equals("")) {
			biobank.put("TypeOfHostInstitutionPredicate", TypeOfHostInstitutionPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TypeOfHostInstitutionPredicate", TypeOfHostInstitutionPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TypeOfHostInstitutionPredicate", "");
		}
		String TargetPopulationPredicate = ParamUtil.getString(request, "TargetPopulationPredicate");
		System.out.println("TargetPopulationPredicate: " + TargetPopulationPredicate);
		if(!TargetPopulationPredicate.equals("")) {
			biobank.put("TargetPopulationPredicate", TargetPopulationPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TargetPopulationPredicate", TargetPopulationPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TargetPopulationPredicate", "");
		}
		String AddressPredicate = ParamUtil.getString(request, "AddressPredicate");
		if(!AddressPredicate.equals("")) {
			biobank.put("AddressPredicate", AddressPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AddressPredicate", AddressPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AddressPredicate", "");
		}
		String NameOfHostInstitutionPredicate = ParamUtil.getString(request, "NameOfHostInstitutionPredicate");
		if(!NameOfHostInstitutionPredicate.equals("")) {
			biobank.put("NameOfHostInstitutionPredicate", NameOfHostInstitutionPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NameOfHostInstitutionPredicate", NameOfHostInstitutionPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "NameOfHostInstitutionPredicate", "");
		}
		String Street1Predicate = ParamUtil.getString(request, "Street1Predicate");
		if(!Street1Predicate.equals("")) {
			biobank.put("Street1Predicate", Street1Predicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Street1Predicate", Street1Predicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Street1Predicate", "");
		}
		String Street2Predicate = ParamUtil.getString(request, "Street2Predicate");
		if(!Street2Predicate.equals("")) {
			biobank.put("Street2Predicate", Street2Predicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Street2Predicate", Street2Predicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "Street2Predicate", "");
		}
		String ZIPPredicate = ParamUtil.getString(request, "ZIPPredicate");
		if(!ZIPPredicate.equals("")) {
			biobank.put("ZIPPredicate", ZIPPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ZIPPredicate", ZIPPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ZIPPredicate", "");
		}
		String CityPredicate = ParamUtil.getString(request, "CityPredicate");
		if(!CityPredicate.equals("")) {
			biobank.put("CityPredicate", CityPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CityPredicate", CityPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CityPredicate", "");
		}
		String CountryPredicate = ParamUtil.getString(request, "CountryPredicate");
		if(!CountryPredicate.equals("")) {
			biobank.put("CountryPredicate", CountryPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CountryPredicate", CountryPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "CountryPredicate", "");
		}
		String DescriptionPredicate = ParamUtil.getString(request, "DescriptionPredicate");
		if(!DescriptionPredicate.equals("")) {
			biobank.put("DescriptionPredicate", DescriptionPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DescriptionPredicate", DescriptionPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "DescriptionPredicate", "");
		}
		String SourceOfFundingPredicate = ParamUtil.getString(request, "SourceOfFundingPredicate");
		if(!SourceOfFundingPredicate.equals("")) {
			biobank.put("SourceOfFundingPredicate", SourceOfFundingPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "SourceOfFundingPredicate", SourceOfFundingPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "SourceOfFundingPredicate", "");
		}
		String TargetCountryPredicate = ParamUtil.getString(request, "TargetCountryPredicate");
		if(!TargetCountryPredicate.equals("")) {
			biobank.put("TargetCountryPredicate", TargetCountryPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TargetCountryPredicate", TargetCountryPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "TargetCountryPredicate", "");
		}
		String YearOfEstablishmentPredicate = ParamUtil.getString(request, "YearOfEstablishmentPredicate");
		if(!YearOfEstablishmentPredicate.equals("")) {
			biobank.put("YearOfEstablishmentPredicate", YearOfEstablishmentPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "YearOfEstablishmentPredicate", YearOfEstablishmentPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "YearOfEstablishmentPredicate", "");
		}
		String OntologiesPredicate = ParamUtil.getString(request, "OntologiesPredicate");
		if(!OntologiesPredicate.equals("")) {
			biobank.put("OntologiesPredicate", OntologiesPredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OntologiesPredicate", OntologiesPredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "OntologiesPredicate", "");
		}
		String AssociatedDataAvailablePredicate = ParamUtil.getString(request, "AssociatedDataAvailablePredicate");
		if(!AssociatedDataAvailablePredicate.equals("")) {
			biobank.put("AssociatedDataAvailablePredicate", AssociatedDataAvailablePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AssociatedDataAvailablePredicate", AssociatedDataAvailablePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "AssociatedDataAvailablePredicate", "");
		}
		String ImagingAvailablePredicate = ParamUtil.getString(request, "ImagingAvailablePredicate");
		if(!ImagingAvailablePredicate.equals("")) {
			biobank.put("ImagingAvailablePredicate", ImagingAvailablePredicate);
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ImagingAvailablePredicate", ImagingAvailablePredicate);
		} else {
			ImporterConfigLocalServiceUtil.setPredicate("scaleus", "ImagingAvailablePredicate", "");
		}
		return biobank;
	}
	
	
	private void clearScaleusDatabase() {
		String url = "http://localhost:8085/scaleus/api/v1/dataset/default";
		HttpClient c = HttpClientBuilder.create().build();
		
		HttpDelete d = new HttpDelete(url);
		d.setHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		try {
			HttpResponse r = c.execute(d);
			BufferedReader rd = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				
				System.out.println(line);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpPost p = new HttpPost(url);
		p.setHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		
		StringEntity stringentitiy = new StringEntity("", ContentType.APPLICATION_FORM_URLENCODED );
		
		p.setEntity(stringentitiy);
		
		try {
			HttpResponse r = c.execute(p);
			BufferedReader rd = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				
				System.out.println(line);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addScaleusEntry(HttpPost p, HttpClient c, String subject, String predicate, String object) throws UnsupportedEncodingException {
		
		//StringEntity stringentitiy = new StringEntity("{\"s\":\"http://bioinformatics.ua.pt\",\"p\":\"http://purl.org/dc/elements/1.1/title\",\"o\":\"University of Aveiro\"}");
		    
		String json = "{"
				+ "\"s\":\"" + subject + "\","
				+ "\"p\":\"" + predicate + "\","
				+ "\"o\":\"" + object + "\""
				+ "}"; 
		
		System.out.println("Creating enty in Scaleus: " + json);
		StringBuilder triple = new StringBuilder();
		//Build subject url
		triple.append("<");
		triple.append(subject);
		triple.append("> ");
		
		// Build predicate utl
		triple.append("<");
		triple.append(predicate);
		triple.append("> ");
		
		// Build object
		
		if(!object.contains("http")) {
			triple.append('"');
			triple.append(object);
			triple.append('"');
			
		}
		else {
			triple.append("<");
			triple.append(object);
			triple.append(">");
		}
		triple.append(" .");
		
		trutelLines.add(triple.toString());
		
		System.out.println("Statement" + triple.toString());
		
		StringEntity stringentitiy = new StringEntity(json, ContentType.APPLICATION_JSON );
		
		p.setEntity(stringentitiy);

		try {
			HttpResponse r = c.execute(p);
			BufferedReader rd = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				
				System.out.println(line);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
