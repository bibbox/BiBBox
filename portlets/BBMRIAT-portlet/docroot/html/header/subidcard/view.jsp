<%@ include file="/html/header/init.jsp" %> 

<portlet:defineObjects />

<%
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	long recordid = 0;
  	organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	boolean parentfound = false;
  	Organization parent_organization = organization;
  	while(!parentfound) {
  		if(parent_organization.getParentOrganizationId() == 0) {
  			parentfound = true;
  		} else {
  			parent_organization = parent_organization.getParentOrganization();
  		}
  	}
  	String parent_organisationlink = themeDisplay.getURLPortal() + "/web" + parent_organization.getGroup().getFriendlyURL();
  	String parent_organisationimgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+parent_organization.getLogoId();
  	
  	String shortdiscription = "";
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equals("Collection")) {  		
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				recordid = record.getRecordId();
  				if(record.getFieldValue("Description") != null) {
  					shortdiscription = record.getFieldValue("Description").toString();
  				}
  			}
  		}
  	}
	%>
	
	<!-- SUB ID Card -->
	<div class="bbmriat_subidcard_idcardbody">
		<!-- top -->
		<div class="bbmriat_subidcard_idcardbodytop">
			<%= organization.getName() %>
		</div>
		<!-- middle -->
		<div class="bbmriat_subidcard_idcardbodymiddle">
			<aui:a href="<%= parent_organisationlink %>"><img alt="logo" class="bbmriat_subidcard_idcardbodymiddle_logo" src="<%= parent_organisationimgPath %>" height="67px" /></aui:a>
			<div class="bbmriat_subidcard_idcardbodymiddle_organisationname">
				<%= parent_organization.getName() %>
			</div>
		</div>
		<!-- bottom -->
		<div class="bbmriat_subidcard_idcardbodybottom">
			<div class="bbmriat_subidcard_idcardbodybottom_area">
				<div class="bbmriat_subidcard_idcardbodybottom-shortdescription"><%= shortdiscription %>
				</div>
			</div>
			<!-- menu -->
			<div class="bbmriat_subidcard_idcardbodybottom_menue">
				<ul>
					<%
					List<Layout> parentorganization_layouts = LayoutLocalServiceUtil.getLayouts(parent_organization.getGroupId(), false);
					int width = (358 / parentorganization_layouts.size()) - 12; 
					for(Layout parentorganization_layout : parentorganization_layouts) { 
						String url = themeDisplay.getURLPortal() + "/web" + parent_organization.getGroup().getFriendlyURL() + parentorganization_layout.getFriendlyURL();
						%>
						<li style="width:<%= width %>px;">
							<aui:a href="<%= url %>"><%= parentorganization_layout.getNameCurrentValue().replaceAll("bb_", "") %></aui:a>
						</li>
						<%
					}
					%>
				</ul>
			</div>
		</div>
	</div>
	
	<%
}
%>
