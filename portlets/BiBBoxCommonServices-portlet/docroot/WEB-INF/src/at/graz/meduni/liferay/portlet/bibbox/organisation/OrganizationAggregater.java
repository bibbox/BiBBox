package at.graz.meduni.liferay.portlet.bibbox.organisation;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;

public class OrganizationAggregater {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public JSONObject aggregateOrganizationDataForOrganizationlist(JSONObject json, long organizationId) {
		try {
			String organizations = "";
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			
			HashMap<String, Integer> result_local = new HashMap<String, Integer>();
			HashMap<String, java.util.Date> modifieddatehash_local = new HashMap<String, java.util.Date>();
			java.util.Date modifieddate = organization.getModifiedDate();
			long diseaserecordsetid = 0; 
			long materialrecordsetid = 0;
			
			// Extract ddl information
			try {
				List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
				for(DDLRecordSet ddlrecordset : ddlrecordsets) {
					String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
					if(ddlrecordsetname.equals("Disease Matrix")) {
						diseaserecordsetid = ddlrecordset.getDDMStructureId();
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  				try {
								if(ddlrecord.getFieldValue("Number_of_Patients___Doners") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Patients___Doners").toString());
									result_local.put("numberofdoners", result_local.get("numberofdoners") + number);
								}
							} catch (PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  			}
					} else if(ddlrecordsetname.equals("Material Matrix")) {
						materialrecordsetid = ddlrecordset.getDDMStructureId();
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  				try {
								if(ddlrecord.getFieldValue("Number_of_Samples") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Samples").toString());
									result_local.put("numberofsamples", result_local.get("numberofsamples") + number);
								}
								if(ddlrecord.getFieldValue("Number_of_Aliquots") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Aliquots").toString());
									result_local.put("numberofaliquots", result_local.get("numberofaliquots") + number);
								}
							} catch (PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  			}
					} else {
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  			}
					}
				}
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				for(Organization suborgaization : organization.getSuborganizations()) {
					HashMap<String, Integer> result = new HashMap<String, Integer>();
					result.put("numberofdoners", 0);
					result.put("numberofsamples", 0);
					result.put("numberofaliquots", 0);
					result.put("numberofsubcollections", 0);
					HashMap<String, java.util.Date> modifieddatehash = new HashMap<String, java.util.Date>();
					modifieddatehash.put("submodifieddate", modifieddate);
					recursiveAggregateOrganizationData(result, suborgaization, diseaserecordsetid, materialrecordsetid, modifieddatehash);
					organizations += suborgaization.getOrganizationId() + ";";
					json.put("numberofdoners" + suborgaization.getOrganizationId(), result.get("numberofdoners"));
					json.put("numberofsamples" + suborgaization.getOrganizationId(), result.get("numberofsamples"));
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			json.put("organizations", organizations);
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 
	 */
	public JSONObject aggregateOrganizationData(JSONObject json, long organizationId) {
		try {
			HashMap<String, Integer> result = new HashMap<String, Integer>();
			HashMap<String, java.util.Date> modifieddatehash = new HashMap<String, java.util.Date>();
			result.put("numberofdoners", 0);
			result.put("numberofsamples", 0);
			result.put("numberofaliquots", 0);
			result.put("numberofsubcollections", 0);
		
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			
			java.util.Date modifieddate = organization.getModifiedDate();
		
			long diseaserecordsetid = 0; 
			long materialrecordsetid = 0;
			
			// Extract ddl information
			try {
				List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
				for(DDLRecordSet ddlrecordset : ddlrecordsets) {
					String ddlrecordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
					if(ddlrecordsetname.equals("Disease Matrix")) {
						diseaserecordsetid = ddlrecordset.getDDMStructureId();
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  				try {
								if(ddlrecord.getFieldValue("Number_of_Patients___Doners") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Patients___Doners").toString());
									result.put("numberofdoners", result.get("numberofdoners") + number);
								}
							} catch (PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  			}
					} else if(ddlrecordsetname.equals("Material Matrix")) {
						materialrecordsetid = ddlrecordset.getDDMStructureId();
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  				try {
								if(ddlrecord.getFieldValue("Number_of_Samples") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Samples").toString());
									result.put("numberofsamples", result.get("numberofsamples") + number);
								}
								if(ddlrecord.getFieldValue("Number_of_Aliquots") != null) {
									Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Aliquots").toString());
									result.put("numberofaliquots", result.get("numberofaliquots") + number);
								}
							} catch (PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  			}
					} else {
						List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
			  			for(DDLRecord ddlrecord : ddlrecords) {
			  				if (modifieddate.before(ddlrecord.getModifiedDate())) {
			  					modifieddate = ddlrecord.getModifiedDate();
			  				}
			  			}
					}
				}
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			modifieddatehash.put("submodifieddate", modifieddate);
			
			try {
				for(Organization suborgaization : organization.getSuborganizations()) {
					recursiveAggregateOrganizationData(result, suborgaization, diseaserecordsetid, materialrecordsetid, modifieddatehash);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			json.put("numberofdoners", result.get("numberofdoners").toString());
			json.put("numberofsamples", result.get("numberofsamples").toString());
			json.put("numberofaliquots", result.get("numberofaliquots").toString());
			json.put("numberofsubcollections", result.get("numberofsubcollections").toString());
			json.put("lastactivities", dateFormat.format(modifieddate));
			json.put("lastactivitiessubcollection", dateFormat.format(modifieddatehash.get("submodifieddate")));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 
	 */
	private HashMap<String, Integer> recursiveAggregateOrganizationData(HashMap<String, Integer> result, Organization organization, long diseaserecordsetid, long materialrecordsetid, HashMap<String, java.util.Date> modifieddatehash) {
		if (modifieddatehash.get("submodifieddate").before(organization.getModifiedDate())) {
			modifieddatehash.put("submodifieddate", organization.getModifiedDate());
		}
		
		result.put("numberofsubcollections", result.get("numberofsubcollections") + 1);
		try {
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet ddlrecordset : ddlrecordsets) {
				if(ddlrecordset.getDDMStructureId() == diseaserecordsetid) {
					List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
		  			for(DDLRecord ddlrecord : ddlrecords) {
		  				if (modifieddatehash.get("submodifieddate").before(ddlrecord.getModifiedDate())) {
		  					modifieddatehash.put("submodifieddate", ddlrecord.getModifiedDate());
		  				}
		  				try {
							if(ddlrecord.getFieldValue("Number_of_Patients___Doners") != null) {
								Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Patients___Doners").toString());
								result.put("numberofdoners", result.get("numberofdoners") + number);
							}
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  			}
				} else if(ddlrecordset.getDDMStructureId() == materialrecordsetid) {
					List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
		  			for(DDLRecord ddlrecord : ddlrecords) {
		  				if (modifieddatehash.get("submodifieddate").before(ddlrecord.getModifiedDate())) {
		  					modifieddatehash.put("submodifieddate", ddlrecord.getModifiedDate());
		  				}
		  				try {
							if(ddlrecord.getFieldValue("Number_of_Samples") != null) {
								Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Samples").toString());
								result.put("numberofsamples", result.get("numberofsamples") + number);
							}
							if(ddlrecord.getFieldValue("Number_of_Aliquots") != null) {
								Integer number = Integer.valueOf(ddlrecord.getFieldValue("Number_of_Aliquots").toString());
								result.put("numberofaliquots", result.get("numberofaliquots") + number);
							}
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  			}
				} else {
					List<DDLRecord> ddlrecords = ddlrecordset.getRecords();
		  			for(DDLRecord ddlrecord : ddlrecords) {
		  				if (modifieddatehash.get("submodifieddate").before(ddlrecord.getModifiedDate())) {
		  					modifieddatehash.put("submodifieddate", ddlrecord.getModifiedDate());
		  				}
		  			}
				}
			}
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			for(Organization suborgaization : organization.getSuborganizations()) {
				recursiveAggregateOrganizationData(result, suborgaization, diseaserecordsetid, materialrecordsetid, modifieddatehash);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
