<%
	String keywords = "";
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	keywords = httpRequest.getParameter("SEARCH");
	if (keywords == null) {
		keywords = "";
	}

	String searchurl1 = themeDisplay.getURLPortal() + "/web/guest" + themeDisplay.getLayout().getFriendlyURL();
%>

<aui:form action="<%=searchurl1%>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:column columnWidth="100" first="true">
				<input style="width: 420px;" type="text"
					placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..."
					value="<%=keywords%>" name="SEARCH" size="60">
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row cssClass="searchFiledFloat">
		<aui:button type="submit" value="Search" />
	</aui:button-row>
</aui:form>

<%
	long organizationId_search = 0;
	keywords = keywords.toLowerCase();
	java.util.Date modifieddate_search = null;
	java.util.TreeMap<java.util.Date, String> sortetdata_search = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
	List<Organization> organizations_search = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
	if(!keywords.equalsIgnoreCase("")) {
		for (Organization organization : organizations_search) {
			// remove all from the ignore list
			if (ignore.contains(organization.getName())) {
				continue;
			}
			boolean hit = false;
			List<String> hits = new ArrayList<String>();
			String country = "";
			modifieddate_search = organization.getModifiedDate();
			organizationId_search = organization.getOrganizationId();
			String imgPath = themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + organization.getLogoId();
			String orgPath = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL();
	
			// Search OrganisationId
			if (String.valueOf(organizationId_search).contains(keywords)) {
				hit = true;
				hits.add("overview::organisationid::" + organizationId_search);
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
						if (modifieddate_search.before(record.getModifiedDate())) {
							modifieddate_search = record.getModifiedDate();
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
								orgPath = orgPath + "/bb_home";
							} else if (type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
								// Search Type
								if ("registry".contains(keywords)) {
									hit = true;
									hits.add("overview::Type::" + "Registry");
								}
								if (organization.getLogoId() == 0) {
									imgPath = request.getContextPath() + "/images/Registry.png";
								}
								orgPath = orgPath + "/home";
							} else {
								// Search Type
								if ("registry".contains(keywords) || "biobank".contains(keywords)) {
									hit = true;
									hits.add("overview::Type::" + "Registry and Biobank");
								}
								if (organization.getLogoId() == 0) {
									imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
								}
								orgPath = orgPath + "/regbb_home";
							}
						}
					}
				} else {
					List<DDLRecord> records = rdc_rs.getRecords();
					for (DDLRecord record : records) {
						if (modifieddate_search.before(record.getModifiedDate())) {
							modifieddate_search = record.getModifiedDate();
						}
						Set<String> fieldnames = record.getFields().getNames();
						for (String fieldname : fieldnames) {
							if (record.getFieldValue(fieldname) != null) {
								String fieldvalue = record.getFieldValue(fieldname).toString();
								// Search Type
								if (fieldvalue.toLowerCase().contains(keywords)) {
									hit = true;
									String linkpage = "overview:";
									if (rdc_rsname.equals("Quality Indicators") || rdc_rsname.equals("Quality Indicators Biobank")
											|| rdc_rsname.equals("Quality Indicators Registry and Biobank")) {
										linkpage = "quality";
									}
									if (rdc_rsname.equals("Accessibility") || rdc_rsname.equals("Accessibility Biobank")
											|| rdc_rsname.equals("Accessibility Registry and Biobank")) {
										linkpage = "accessibility";
									}
									if (rdc_rsname.equals("Disease Areas (ICD10)") || rdc_rsname.equals("Disease Matrix")) {
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
					%><%= tmp_hit %> <br /> <%
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
	
				if (sortetdata_search.containsKey(modifieddate_search)) {
					String tmp = sortetdata_search.get(modifieddate_search);
					sortetdata_search.put(modifieddate_search, tmp + tableandcontent);
				} else {
					sortetdata_search.put(modifieddate_search, tableandcontent);
				}
			} else {
				%><span style="padding:10px;margin-top:10px;border-style: solid;border-color: #8bbf39;color: #8bbf39;">No search results found.</span><%
			}
		} 
	} else {
		%>
		<%@ include file="/html/organisation/organisationlister/organizationtyps/rdconnect.jsp" %>
		<%
	}

	for (java.util.Date date : sortetdata_search.keySet()) {
		%><%=sortetdata_search.get(date)%>
		<%
	}
%>
<br />

