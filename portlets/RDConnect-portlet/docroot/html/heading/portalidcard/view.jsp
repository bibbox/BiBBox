<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalService" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="at.meduni.liferay.portlet.rdconnect.heading.PortalIDCard" %>

<portlet:defineObjects />

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>


<% 
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	
  	PortalIDCard pidc = new PortalIDCard();
  	
  	String organisationtype = "";
  	String shortdiscription = "";
  	int diseasecount = 0;
  	int documents = 0;
  	String quality = "";
  	String accessibility = "";
  	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
  	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		
  		if(rdc_rsname.equals("core")) {  		
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("Radio2493") != null) {
	  				String type = record.getFieldValue("Radio2493").toString();
	  				if(type.equalsIgnoreCase("[bb]")) {
	  					organisationtype = "Biobank";
	  				} else if(type.equalsIgnoreCase("[reg]")) {
	  					organisationtype = "Registry";
	  				} else {
	  					organisationtype = "Registry/Biobank";
	  				}
  				}
  				if(organization.getLogoId() == 0) {
  					if(record.getFieldValue("Radio2493") != null) {
		  				String type = record.getFieldValue("Radio2493").toString();
		  				if(type.equalsIgnoreCase("[bb]")) {
		  					imgPath = request.getContextPath() + "/images/Biobank.png";
		  				} else if(type.equalsIgnoreCase("[reg]")) {
		  					imgPath = request.getContextPath() + "/images/Registry.png";
		  				} else {
		  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
		  				}
	  				}
  				}
  				if(record.getFieldValue("Description") != null) {
  					shortdiscription = record.getFieldValue("Description").toString();
  				}
  			}
  		}
  		
  		if(rdc_rsname.equals("Disease Matrix")) {  		
  			diseasecount = rdc_rs.getRecords().size();
  		}
  		
  		if(rdc_rsname.equals("Accessibility")) { 
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
  			accessibility = "[" + counted + "/" + all + "]";
  		}
  		
  		if(rdc_rsname.equals("Quality Indicators")) { 
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
  			quality = "[" + counted + "/" + all + "]";
  		}
  	} 
%>
<!-- ID Card -->
<div class="rdc_idcard_idcardbody">
	<!-- top -->
	<div class="rdc_idcard_idcardbodytop">
		<span class="rdc_idcard_idcardbodytop-id">ID # <%= organizationId %></span>
		<span class="rdc_idcard_idcardbodytop-dateofinclution">Date of Inclusion: <%= dateFormat.format(organization.getCreateDate()) %> </span>
		<span class="rdc_idcard_idcardbodytop-type">Type: <%= organisationtype %> </span>
	</div>
	<!-- middle -->
	<div class="rdc_idcard_idcardbodymiddle">
		<aui:a href="<%= orgPath %>"><img alt="logo" class="rdc_idcard_idcardbodymiddle-logo" src="<%= imgPath %>" /></aui:a>
		<div class="rdc_idcard_idcardbodymiddle-organisationname"><%= organization.getName() %></div>
	</div>
	<!-- bottom -->
	<div class="rdc_idcard_idcardbodybottom">
		<div class="rdc_idcard_idcardbodybottom-shortdescription"><%= shortdiscription %></div>
		<div class="rdc_idcard_idcardbodybottom-menue">
		<!-- menue -->
			<ul>
			<%
			List<Layout> pagelayouts = themeDisplay.getLayouts();
			
			int width_all = 488 - pagelayouts.size() - ((pagelayouts.size()-1)*6);
			int width = (int)Math.floor(width_all/pagelayouts.size());
			int offset = width_all - (width*pagelayouts.size());
			boolean first = true;
			for(Layout l : pagelayouts) {
				String pagesurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
				
				String aktiveli = "<li style='width:" + width + "px;'>";
				if(first)
					aktiveli = "<li style='width:" + (width+offset) + "px;'>";
				first = false;
				
				String pageinformation = "";
				
				// Page count finder
				if(l.getNameCurrentValue().equalsIgnoreCase("Persons")) {
					pageinformation = "[" + UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId()).size() + "]";
				}
				if(l.getNameCurrentValue().equalsIgnoreCase("Diseases")) {
					pageinformation = "[" + diseasecount + "]";
				}
				if(l.getNameCurrentValue().equalsIgnoreCase("Quality")) {
					pageinformation = quality;
				}
				if(l.getNameCurrentValue().equalsIgnoreCase("Accessibility")) {
					pageinformation = accessibility;
				}
				
				%>	
				<%= aktiveli %><aui:a href="<%= pagesurl %>"><%= l.getName() %>
				</aui:a><br><span class="rdc_idcard_idcardbodybottom-menue-pageinformation"><%= pageinformation %></span></li>
				<%
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
