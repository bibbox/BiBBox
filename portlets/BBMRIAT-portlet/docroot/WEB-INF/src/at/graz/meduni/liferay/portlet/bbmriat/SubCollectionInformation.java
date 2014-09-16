package at.graz.meduni.liferay.portlet.bbmriat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SubCollectionInformation
 */
public class SubCollectionInformation extends MVCPortlet {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.
	 * ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long organizationId = ParamUtil.getLong(resourceRequest, "organizationId");
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json = aggregateOrganizationData(json, organizationId);
			
			resourceResponse.getPortletOutputStream().write(json.toString().getBytes());
		} catch (IOException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private JSONObject aggregateOrganizationData(JSONObject json, long organizationId) {
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
	
	/**
	 * 
	 */
	private String aggregatenumberofdoners() {
		return "X";
	}
	
	/**
	 * 
	 */
	private String aggregateNumberOfSamples() {
		return "Y";
	}
}
