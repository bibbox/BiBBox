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
long organizationId = 0;
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
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		
  		if(rdc_rsname.equals("core")) {  		
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if (modifieddate.before(record.getModifiedDate())) {
  					modifieddate = record.getModifiedDate();
  				}
  				recordid = record.getRecordId();
  				if(record.getFieldValue("Radio2493") != null) {
	  				String type = record.getFieldValue("Radio2493").toString();
	  				if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
	  					organisationtype = "Biobank";
	  					if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
		  					orgPath = orgPath + "/at_home";
		  				} else {
	  						orgPath = orgPath + "/bb_home";
		  				}
	  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
	  					organisationtype = "Registry";
	  					if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
		  					orgPath = orgPath + "/at_home";
		  				} else {
	  						orgPath = orgPath + "/home";
		  				}
	  				} else {
	  					organisationtype = "Registry/Biobank";
	  					if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
		  					orgPath = orgPath + "/at_home";
		  				} else {
	  						orgPath = orgPath + "/regbb_home";
		  				}
	  				}
  				}
  				if(organization.getLogoId() == 0) {
  					if(record.getFieldValue("Radio2493") != null) {
		  				String type = record.getFieldValue("Radio2493").toString();
		  				if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
		  					imgPath = request.getContextPath() + "/images/Biobank.png";
		  				} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
		  					imgPath = request.getContextPath() + "/images/Registry.png";
		  				} else {
		  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
		  				}
	  				}
  				}
  				if(record.getFieldValue("Description") != null) {
  					shortdiscription = record.getFieldValue("Description").toString();
  					shortdiscription = shortdiscription.replaceAll("<.*?>", "");
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
  	
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {	
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equals("Disease Matrix")) {  		
  			diseasecount = rdc_rs.getRecords().size();
  		}
  		
  	// All
  		if(rdc_rsname.equals("core")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		
  		// Registry
  		if(rdc_rsname.equals("Accessibility") && organisationtype.equalsIgnoreCase("Registry")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		
  		if(rdc_rsname.equals("Quality Indicators") && organisationtype.equalsIgnoreCase("Registry")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		if(rdc_rsname.equals("Accessibility Biobank") && organisationtype.equalsIgnoreCase("Biobank")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		
  		if(rdc_rsname.equals("Quality Indicators Biobank") && organisationtype.equalsIgnoreCase("Biobank")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		// Registry/Biobank
  		if(rdc_rsname.equals("Accessibility Registry and Biobank") && organisationtype.equalsIgnoreCase("Registry/Biobank")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
  		
  		if(rdc_rsname.equals("Quality Indicators Registry and Biobank") && organisationtype.equalsIgnoreCase("Registry/Biobank")) { 
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
		  						if(!record.getFieldValue(s).toString().equalsIgnoreCase("") && !record.getFieldValue(s).toString().equalsIgnoreCase("[]")) {
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
%>
<%
// Edit link
	boolean portaleditorrole = false;
    boolean biobankregistryownerrole = false;
    boolean biobankregistryeditorrole = false;
    for(Role role : themeDisplay.getUser().getRoles()) {
    	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
    		portaleditorrole = true;
    	if(role.getName().equalsIgnoreCase("Administrator"))
    		portaleditorrole = true;
    }
    //Biobank, Registry Owner
    for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroupId())) {
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-OWNER"))
    		biobankregistryownerrole = true; 
    	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-EDITOR"))
    		biobankregistryeditorrole = true;
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
		<div class="rdc_idcard_idcaibody-edit-icon-coreddl"><aui:a href="<%= editpathcoredll %>"><img style="width: 10px;height: 10px;" alt="Edit" src="<%= editimgpath %>" width="10px" height="10px" /></aui:a></div>
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
		<aui:a href="<%= orgPath %>"><img alt="logo" class="rdc_idcard_idcardbodymiddle-logo" src="<%= imgPath %>" height="85px" /></aui:a>
		<div class="rdc_idcard_idcardbodymiddle-organisationname"><%= organization.getName() %>
			<% if(biobankregistryownerrole || portaleditorrole || biobankregistryeditorrole) { %>
			<aui:a href="<%= editpathorganisation %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></aui:a>
			<% } %>
		</div>
	</div>
	<!-- bottom -->
	<div class="rdc_idcard_idcardbodybottom">
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
				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
					if(l.getNameCurrentValue().startsWith("at_")) {
						pages_display.put(l.getNameCurrentValue().replaceAll("at_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
					}
				} else  {
					if(organisationtype.equalsIgnoreCase("Registry") && (!l.getNameCurrentValue().startsWith("bb_") && !l.getNameCurrentValue().startsWith("regbb_") && !l.getNameCurrentValue().startsWith("at_"))) {
						pages_display.put(l.getNameCurrentValue(), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
					}
					if(organisationtype.equalsIgnoreCase("Biobank") && l.getNameCurrentValue().startsWith("bb_")) {
						pages_display.put(l.getNameCurrentValue().replaceAll("bb_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
					}
					if(organisationtype.equalsIgnoreCase("Registry/Biobank") && l.getNameCurrentValue().startsWith("regbb_")) {
						pages_display.put(l.getNameCurrentValue().replaceAll("regbb_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
					} /* else {
						pages_display.put(l.getNameCurrentValue().replaceAll("regbb_", ""), themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL());
					}*/
				}
			}
			
			if(pages_display.size() != 0) {
			int width_all = 488 - pages_display.size() - ((pages_display.size()-1)*10);
			int width = (int)Math.floor(width_all/pages_display.size());
			int offset = width_all - (width*pages_display.size());
			boolean first = true;
			//for(Layout l : pagelayouts) {
			for(String l : pages_display.keySet()) {
				String pagesurl = pages_display.get(l);
				
				String aktiveli = "<li style='width:" + width + "px;'>";
				if(first)
					aktiveli = "<li style='width:" + (width+offset) + "px;'>";
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
				if(l.equalsIgnoreCase("Quality")) {
					pageinformation = quality;
				}
				if(l.equalsIgnoreCase("Accessibility")) {
					pageinformation = accessibility;
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
