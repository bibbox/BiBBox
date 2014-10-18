<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page
	import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet"%>
<%@ page
	import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page
	import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.UserGroupRole"%>
<%@ page import="java.util.ArrayList"%>

<portlet:defineObjects />

<%
	String keywords = "";
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	keywords = httpRequest.getParameter("SEARCH");
	if (keywords == null) {
		keywords = "";
	}
%>

<%
	String searchurl1 = themeDisplay.getURLPortal() + "/web/guest/search";
%>
<aui:form action="<%= searchurl1 %>" method="POST" name="fm">
	<aui:fieldset>
		<input style="width: 420px;" type="text" placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..." value="<%= keywords %>" name="SEARCH" size="60">
	</aui:fieldset>
	<aui:button-row cssClass="searchFiledFloat">
		<aui:button type="submit" value="Search" />
	</aui:button-row>
</aui:form>


<%
	keywords = keywords.toLowerCase();
	long organizationId = 0;
	long userId2 = themeDisplay.getUserId();
	java.util.Date modifieddate = null;
	java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
	
	if(!keywords.equalsIgnoreCase("")) {
		for (Organization organization : organizations) {
			boolean hit = false;
			List<String> hits = new ArrayList<String>();
			String country = "";
			modifieddate = organization.getModifiedDate();
			organizationId = organization.getOrganizationId();
			String imgPath = themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + organization.getLogoId();
			String orgPath = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL();
			if (organization.getName().equalsIgnoreCase("National Biobank of Test"))
				continue;
			if (organization.getName().equalsIgnoreCase("BBMUSK"))
				continue;
			if (organization.getName().equalsIgnoreCase("Medical Univeristy of Shi'Kahr"))
				continue;
	
			// Search OrganisationId
			if (String.valueOf(organizationId).contains(keywords)) {
				hit = true;
				hits.add("overview::organisationid::" + organizationId);
			}
			// Search Organisation Name
			if (organization.getName().toLowerCase().contains(keywords)) {
				hit = true;
				hits.add("overview::Name::" + organization.getName());
			}
	
			List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for (DDLRecordSet rdc_rs : rdc_recordlist) {
				String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	
				if (rdc_rsname.equals("core")) {
					List<DDLRecord> records = rdc_rs.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
						if (record.getFieldValue("countryCode") != null) {
							country = record.getFieldValue("countryCode").toString();
							// Search Country
							if (country.toLowerCase().contains(keywords)) {
								hit = true;
								hits.add("overview::Country::" + country);
							}
						}
	
						if (record.getFieldValue("Radio2493") != null) {
							String type = record.getFieldValue("Radio2493").toString();
							if (type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
								// Search Type
								if ("biobank".contains(keywords)) {
									hit = true;
									hits.add("overview::Type::" + "Biobank");
								}
								if (organization.getLogoId() == 0) {
									imgPath = request.getContextPath() + "/images/Biobank.png";
								}
								if (themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
									orgPath = orgPath + "/at_home";
								} else {
									orgPath = orgPath + "/bb_home";
								}
							} else if (type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
								// Search Type
								if ("registry".contains(keywords)) {
									hit = true;
									hits.add("overview::Type::" + "Registry");
								}
								if (organization.getLogoId() == 0) {
									imgPath = request.getContextPath() + "/images/Registry.png";
								}
								if (themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
									orgPath = orgPath + "/at_home";
								} else {
									orgPath = orgPath + "/home";
								}
							} else {
								// Search Type
								if ("registry".contains(keywords) || "biobank".contains(keywords)) {
									hit = true;
									hits.add("overview::Type::" + "Registry and Biobank");
								}
								if (organization.getLogoId() == 0) {
									imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
								}
								if (themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
									orgPath = orgPath + "/at_home";
								} else {
									orgPath = orgPath + "/regbb_home";
								}
							}
						}
					}
				} else {
					List<DDLRecord> records = rdc_rs.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate.before(record.getModifiedDate())) {
							modifieddate = record.getModifiedDate();
						}
						Set<String> fieldnames = record.getFields().getNames();
						for(String fieldname : fieldnames) {
							if (record.getFieldValue(fieldname) != null) {
								String fieldvalue = record.getFieldValue(fieldname).toString();
								// Search Type
								if (fieldvalue.toLowerCase().contains(keywords)) {
									hit = true;
									String linkpage = "overview:";
									if(rdc_rsname.equals("Quality Indicators") || rdc_rsname.equals("Quality Indicators Biobank") || rdc_rsname.equals("Quality Indicators Registry and Biobank")) {
										linkpage = "quality";
									}
									if(rdc_rsname.equals("Accessibility") || rdc_rsname.equals("Accessibility Biobank") || rdc_rsname.equals("Accessibility Registry and Biobank")) {
										linkpage = "accessibility";
									}
									if(rdc_rsname.equals("Disease Areas (ICD10)") || rdc_rsname.equals("Disease Matrix")) {
										linkpage = "disease";
									}
									hits.add(linkpage + "::" + rdc_rs.getDDMStructure().getFieldLabel(fieldname, themeDisplay.getLocale()) + "::" + fieldvalue);
								}
							}
						}
					}
				}
			}
	
			if (hit) {
	
				String tableandcontent = "";
	
				tableandcontent += "<table class=\"rdc_coreinformation_organisation-table-images\">";
				tableandcontent += "<tr>";
				tableandcontent += "<td rowspan=\"4\" width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
				tableandcontent += "<td><a href=\"" + orgPath + "\">" + organization.getName() + "</a></td>";
				tableandcontent += "</tr>";
				tableandcontent += "<tr><td>Contact:";
				User maincontact = null;
				List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
				for (User usertmp : userlist) {
					List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
					for (UserGroupRole ugr : usergrouprolles) {
						if (ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT") || ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
								|| ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
							maincontact = usertmp;
						}
					}
				}
	
				if (maincontact != null) {
					tableandcontent += "<a href=\"mailto:" + maincontact.getEmailAddress() + "\">" + maincontact.getFullName() + "</a>";
				}
				tableandcontent += "</td></tr>";
				tableandcontent += "<tr><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\">";
				for (com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
					tableandcontent += "<a href=\"" + website.getUrl() + "\">" + website.getUrl() + "</a>";
				}
				tableandcontent += "</td></tr>";
				tableandcontent += "<tr><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\" style=\"background-color:rgba(244,244,225,0.5);\">";
				
				for(String tmp_hit : hits) {
					String[] split_hit = tmp_hit.split("::");
					String link = orgPath.toString(); 
					if(split_hit[0].equalsIgnoreCase("overview")) {
						link.replaceAll("home", "quality");
						System.out.println(link);
					}
					if(split_hit[0].equalsIgnoreCase("accessibility")) {
						link.replaceAll("home", "accessibility");
					}
					if(split_hit[0].equalsIgnoreCase("disease")) {
						link.replaceAll("home", "diseases");
					}
					tableandcontent += split_hit[1] + ": " + "<a href=\"" + link + "\">" + split_hit[2] + "</a><br>";
				}
	
				tableandcontent += "</td></tr>";
				tableandcontent += "</table><br>";
	
				if (themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
					if (country.equalsIgnoreCase("Austria")) {
						if (sortetdata.containsKey(modifieddate)) {
							String tmp = sortetdata.get(modifieddate);
							sortetdata.put(modifieddate, tmp + tableandcontent);
						} else {
							sortetdata.put(modifieddate, tableandcontent);
						}
					}
				} else {
					if (sortetdata.containsKey(modifieddate)) {
						String tmp = sortetdata.get(modifieddate);
						sortetdata.put(modifieddate, tmp + tableandcontent);
					} else {
						sortetdata.put(modifieddate, tableandcontent);
					}
				}
			}
		}
	
		for (java.util.Date date : sortetdata.keySet()) {
	%><%=sortetdata.get(date)%>
	<%
		}
	}
%>
<br />
