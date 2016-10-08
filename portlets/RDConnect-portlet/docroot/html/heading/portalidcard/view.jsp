<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalService" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="at.meduni.liferay.portlet.rdconnect.heading.PortalIDCard" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="java.util.LinkedHashMap"%>

<portlet:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>


<% 
long BIOBANK_ASSESSMENT_ORGANIZATION = 26616;
long CATALOG_ORGANIZATIONID = 10709;
long NETWORK_ORGANIZATIONID = 70977;
long organizationId = 0;
long recordId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	long recordid = 0;
  	organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	
  	PortalIDCard pidc = new PortalIDCard();
  	
  	String organisationtype = "";
  	String shortdiscription = "";
  	int diseasecount = 0;
  	int documents = 0;
  	String corecount = "";
  	String quality = "";
  	String accessibility = "";
  	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
  	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
  	
  	java.util.Date modifieddate = organization.getModifiedDate();
  	
 	// Core Functions
 	String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
 	String core_ddl_name = "core";
 	if(organizationtype.equalsIgnoreCase("Biobank")) {
 		if(organization.getLogoId() == 0) {
 			imgPath = request.getContextPath() + "/images/Biobank.png";
 		}
 		orgPath = orgPath + "/bb_home";	
 		organisationtype = "Biobank";
 		core_ddl_name = "bb_core";
 	} else {
 		if(organization.getLogoId() == 0) {
 			imgPath = request.getContextPath() + "/images/Registry.png";
 		}
 		orgPath = orgPath + "/reg_home";
 		organisationtype = "Registry";
 		core_ddl_name = "core";
 	}
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		
  		 if(rdc_rsname.equals(core_ddl_name)) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) { 
  				 recordId = record.getPrimaryKey();
  				if (modifieddate.before(record.getModifiedDate())) {
  				modifieddate = record.getModifiedDate();
  				}
  				recordid = record.getRecordId();
  				 if(record.getFieldValue("Description") != null) {
  					shortdiscription = record.getFieldValue("Description").toString();
  					shortdiscription = shortdiscription.replaceAll("<.*?>", "").replaceAll("\"\\]|\\[\"", "");
  				} 
  			}
  		 } else {
  		
	  		List<DDLRecord> records = rdc_rs.getRecords();
	  		for(DDLRecord record : records) {
	  			if (modifieddate.before(record.getModifiedDate())) {
	  				modifieddate = record.getModifiedDate();
	  			}
	  		}
  		 }
  	}
  	
  	diseasecount = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixsCount(organizationId);
  	
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {	
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		/*if(rdc_rsname.equals("Disease Matrix")) {  		
  			diseasecount = rdc_rs.getRecords().size();
  		}*/
  		
  	// Registry
  		if(rdc_rsname.equals("core") && organisationtype.equalsIgnoreCase("Registry")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				corecount = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				corecount = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  		
  		
  		if(rdc_rsname.equals("reg_accessibility") && organisationtype.equalsIgnoreCase("Registry")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				accessibility = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				accessibility = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  		
  		if(rdc_rsname.equals("reg_quality") && organisationtype.equalsIgnoreCase("Registry")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				quality = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				quality = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  		
  		// Biobank
  		if(rdc_rsname.equals("bb_core") && organisationtype.equalsIgnoreCase("Biobank")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				corecount = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				corecount = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  		if(rdc_rsname.equals("bb_accessibility") && organisationtype.equalsIgnoreCase("Biobank")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				accessibility = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				accessibility = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  		
  		if(rdc_rsname.equals("bb_quality") && organisationtype.equalsIgnoreCase("Biobank")) { 
  			int all = 0;
  			int counted = 0;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				long ddmstructureid = rdc_rs.getDDMStructureId();
  				DDMStructure dms = DDMStructureLocalServiceUtil.fetchStructure(ddmstructureid);
  				if(dms != null) {
	  				Set<String> fieldnames = dms.getFieldNames();
	  				for(String s : fieldnames) {
	  					if(!dms.isFieldPrivate(s)) {
	  						all++;
		  					if(record.getFieldValue(s) != null) {
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]") && !record.getFieldValue(s).toString().contains("ot specified") && !record.getFieldValue(s).toString().contains("ot Specified")) {
		  							counted++;
		  						}
		  					}
	  					}
	  				}
  				}
  			}
  			if(counted >= (all/2)) {
  				quality = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation\">[" + counted + "]</span>";
  			} else {
  				quality = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-gray\">[" + counted + "]</span>";
  			}
  		}
  	} 
  	// Count Documents
  	int filecount = 0;
  	try {
	  	PortalIDCard idcard = new PortalIDCard();
	  	filecount = idcard.getFilecount(themeDisplay.getScopeGroupId());
  	} catch (Exception ex) {
  		ex.printStackTrace();
  	}

	// Edit link
	boolean portaleditorrole = false;
    boolean biobankregistryownerrole = false;
    boolean biobankregistryeditorrole = false;
    for(Role role : themeDisplay.getUser().getRoles()) {
    	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
    		portaleditorrole = true;
    	if(role.getName().equalsIgnoreCase("Administrator"))
    		portaleditorrole = true;
    	if(role.getName().equalsIgnoreCase("RD-Connect CURATOR"))
    		portaleditorrole = true;
    }
    //Biobank, Registry Owner
    for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroupId())) {
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-OWNER"))
    		biobankregistryownerrole = true; 
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-EDITOR"))
    		biobankregistryeditorrole = true;
    	if(ugr.getRole().getName().equalsIgnoreCase("BB-REG-EDITOR"))
			biobankregistryownerrole = true;
		if(ugr.getRole().getName().equalsIgnoreCase("BB-REG-OWNER"))
			biobankregistryownerrole = true;
    }
    String editpathorganisation = "";
    String editpathcoredll = "";
    String editimgpath = request.getContextPath() + "/images/edit.png";
    if(biobankregistryownerrole || portaleditorrole) {
		Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
	    long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
		LiferayPortletURL editusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
		editusersURL.setParameter("struts_action", "/users_admin/edit_organization");
	    editusersURL.setParameter("tab", "websites");
	    editusersURL.setParameter("organizationId", String.valueOf(organizationId));
	    editusersURL.setParameter("redirect", currentURL);
	    editusersURL.setParameter("p_p_state", "maximized");
		editpathorganisation = editusersURL.toString();
		
		LiferayPortletURL editddlURL = PortletURLFactoryUtil.create(request, "167", controlPanelPlid, "RENDER_PHASE");
		editddlURL.setParameter("struts_action", "/dynamic_data_lists/edit_record");
		editddlURL.setParameter("p_p_state", "maximized");
		editddlURL.setParameter("redirect", currentURL);
		editddlURL.setParameter("cmd", "update");
		editddlURL.setParameter("formDDMTemplateId", "0");
		editddlURL.setParameter("recordId", String.valueOf(recordid));
		editpathcoredll = editddlURL.toString();
		%>
		<div class="rdc_idcard_idcaibody-edit-icon-coreddl"><span id="coreddledit" style="cursor:pointer;"><img style="width: 10px;height: 10px;" alt="Edit" src="<%= editimgpath %>" width="10px" height="10px" /></span></div>
		<%
	} %>

<!-- ID Card -->
<div class="rdc_idcard_idcardbody">
	<!-- top -->
	<div class="rdc_idcard_idcardbodytop">
		<span class="rdc_idcard_idcardbodytop-id">ID # <%= organizationId %></span>
		<span class="rdc_idcard_idcardbodytop-dateofinclution">Date of Inclusion: <%= dateFormat.format(organization.getCreateDate()) %> </span>
		<span class="rdc_idcard_idcardbodytop-type">Last Activities: <%= dateFormat.format(modifieddate) %> </span>
	</div>
	<!-- middle -->
	<div class="rdc_idcard_idcardbodymiddle">
		<aui:a href="<%= orgPath %>"><img alt="logo" class="rdc_idcard_idcardbodymiddle-logo" src="<%= imgPath %>" /></aui:a>
		<div class="rdc_idcard_idcardbodymiddle-organisationname"><%= organization.getName() %>
			<% if(biobankregistryownerrole || portaleditorrole || biobankregistryeditorrole) { %>
			<span id="organizationedit" style="cursor:pointer;"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span>
			<% } %>
		</div>
	</div>
	<!-- bottom -->
	<div class="rdc_idcard_idcardbodybottom">
		<%
		if(organization.getParentOrganizationId() != CATALOG_ORGANIZATIONID && organization.getParentOrganizationId() != 15401 && organization.getParentOrganizationId() != NETWORK_ORGANIZATIONID) {
			shortdiscription = "<p style=\"color: red;text-align: center;font-size:20px;\">Organization was deleted</p>";
			if(organization.getParentOrganizationId() == BIOBANK_ASSESSMENT_ORGANIZATION) {
				shortdiscription = "<p style=\"color: red;text-align: center;font-size:20px;\">Biobank in Assessment</p>";
			}
		}
		%>
		<div class="rdc_idcard_idcardbodybottom-shortdescription"><%= shortdiscription %>
		</div>
		<div class="rdc_idcard_idcardbodybottom-menue">
		<!-- menue -->
			<ul>
			<%
			List<Layout> pagelayouts = themeDisplay.getLayouts();
			// Determin which pages to show
			LinkedHashMap<String, String> pages_display = new LinkedHashMap<String, String>(); 
			for(Layout l : pagelayouts) { 
				
				if(l.getNameCurrentValue().equalsIgnoreCase("RDC-Login")) {
					continue;
				}
				if(organisationtype.equalsIgnoreCase("Registry") && (!l.getNameCurrentValue().startsWith("bb_") && !l.getNameCurrentValue().startsWith("regbb_") && !l.getNameCurrentValue().startsWith("at_"))) {
					pages_display.put(l.getNameCurrentValue().replaceAll("reg_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
				}
				if(organisationtype.equalsIgnoreCase("Biobank") && l.getNameCurrentValue().startsWith("bb_")) {
					pages_display.put(l.getNameCurrentValue().replaceAll("bb_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
				}
				if(organisationtype.equalsIgnoreCase("Registry/Biobank") && l.getNameCurrentValue().startsWith("regbb_")) {
					pages_display.put(l.getNameCurrentValue().replaceAll("regbb_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
				} 
			}
			
			if(pages_display.size() != 0) {
			int width_all = 488 - pages_display.size() - ((pages_display.size()-1)*10);
			int width = (int)Math.floor((width_all/pages_display.size())-1);
			int offset = width_all - (width*pages_display.size()-1);
			boolean first = true;
			//for(Layout l : pagelayouts) {
			for(String l : pages_display.keySet()) {
				String pagesurl = pages_display.get(l);
				
				String aktiveli = "<li style='width:" + width + "px;'>";
				if(first)
					aktiveli = "<li style='width:" + (width) + "px;'>";
				first = false;
				
				String pageinformation = "";
				
				// Page count finder corecount
				if(l.equalsIgnoreCase("Overview")) {
					pageinformation = corecount;
				}
				if(l.equalsIgnoreCase("Persons")) {
					pageinformation = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-noncalculates\">[" + UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId()).size() + "]</span>";
				}
				if(l.equalsIgnoreCase("Disease Matrix") || l.equalsIgnoreCase("Disease") || l.equalsIgnoreCase("Diseases")) {
					pageinformation = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-noncalculates\">[" + diseasecount + "]</span>";
				}
				if(l.equalsIgnoreCase("Quality") || l.equalsIgnoreCase("Standards")) {
					pageinformation = quality;
					l="Standards";
				}
				if(l.equalsIgnoreCase("Accessibility")) {
					pageinformation = accessibility;
				}
				if(l.equalsIgnoreCase("Documents")) {
					pageinformation = "<span class=\"rdc_idcard_idcardbodybottom-menue-pageinformation-noncalculates\">[" + filecount + "]</span>";
				}
				
				String items = "";
				if(!pageinformation.equalsIgnoreCase("")) {
					items = pageinformation.substring((pageinformation.indexOf("[")+1), (pageinformation.indexOf("]")));
				}
				
				%>	
				<%= aktiveli %><aui:a href="<%= pagesurl %>"><%= l %>
				</aui:a><br><span id="rdc_idcard_idcardbodybottom-menue-help" class="rdc_idcard_idcardbodybottom-menue-help" title="<%= items %> items specified"><%= pageinformation %><span></span></li>
				<%
			}
			}
			%>
			</ul>
		<!-- menue -->
		</div>
	</div>
</div>
<%
}
%>

<aui:script use="aui-tooltip">
	AUI().use('aui-tooltip', function(A) {
    	new A.Tooltip(
      	{
        	trigger: '#rdc_idcard_idcardbodybottom-menue-help',
        	position: 'right',
        	cssClass: 'tooltip-help'
      	});
  	});
</aui:script>
<%
String portletResource = ParamUtil.getString(request, "portletResource");
Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
// Edit Organization Link
LiferayPortletURL editorganizationURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
editorganizationURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
editorganizationURL.setParameter("redirect", currentURL);
editorganizationURL.setWindowState(WindowState.MAXIMIZED);
editorganizationURL.setParameter("organizationId", "" + organizationId);
editorganizationURL.setParameter("struts_action", "/users_admin/edit_organization");

// Edit Core DDL Link
LiferayPortletURL editcoreddlURL = PortletURLFactoryUtil.create(request, "167", controlPanelPlid, "RENDER_PHASE");
editcoreddlURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
editcoreddlURL.setParameter("redirect", currentURL);
editcoreddlURL.setWindowState(WindowState.MAXIMIZED);
editcoreddlURL.setParameter("cmd", "update");
editcoreddlURL.setParameter("struts_action", "/dynamic_data_lists/edit_record");
editcoreddlURL.setControlPanelCategory("current_site.content");
editcoreddlURL.setParameter("recordId", "" + recordId);
editcoreddlURL.setParameter("formDDMTemplateId", "0");

%>
<aui:script use="aui-base">
            A.all('#organizationedit').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1200
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_editorganization',
                        title: 'Edit Organization',
                        uri: '<%=editorganizationURL.toString()%>'
                     }
                  );
               }
            );
</aui:script>

<aui:script use="aui-base">
            A.all('#coreddledit').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1200
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_editcoreddl',
                        title: 'Edit Core',
                        uri: '<%=editcoreddlURL.toString()%>'
                     }
                  );
               }
            );
</aui:script>

<portlet:actionURL name='countUserOrgaization' var="countUserOrgaizationURL" />

<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
	AUI().ready('aui-io-request', 'event-valuechange', 'node', function(A){
			var url = '<%= countUserOrgaizationURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
					
				   <portlet:namespace />userid: <%= themeDisplay.getUserId() %>,
				   <portlet:namespace />ipaddress: '<%= PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr() %>',
				   <portlet:namespace />organizationid: <%= organizationId %>,
				},
				dataType: 'json',
				on: {
				  failure: function() {  },
				  success: function(event, id, obj) { "success" }
				}
			});
	});
</aui:script>
