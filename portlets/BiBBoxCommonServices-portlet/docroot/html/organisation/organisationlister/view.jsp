<%@ include file="/html/organisation/init.jsp" %> 

<portlet:defineObjects />

<%
long optionsListOrganizationFromMainOrganization_option = GetterUtil.getLong(portletPreferences.getValue("optionsListOrganizationFromMainOrganization", "0"));
String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
String optionsIgnoreOrganisations_option = GetterUtil.getString(portletPreferences.getValue("optionsIgnoreOrganisations", ""));

//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_delete_organization = "DELETE_ORGANIZATION";

List<String> ignore = new ArrayList<String>();
for(String ignorenames : optionsIgnoreOrganisations_option.split(";")) {
	ignore.add(ignorenames);
}
long parentid = optionsListOrganizationFromMainOrganization_option;
if(optionsListOrganizationFromMainOrganization_option == 1) {
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	if (currentGroup.isOrganization()) {
		parentid = currentGroup.getClassPK();
	}
}
if(optionsListOrganizationFromMainOrganization_option == 2) {
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	if (currentGroup.isOrganization()) {
		parentid = currentGroup.getClassPK();
		Organization parent_organization = OrganizationLocalServiceUtil.getOrganization(parentid);
		boolean parentfound = false;
		while(!parentfound) {
	  		if(parent_organization.getParentOrganizationId() == 0) {
	  			parentfound = true;
	  		} else {
	  			parent_organization = parent_organization.getParentOrganization();
	  			parentid = parent_organization.getOrganizationId();
	  		}
	  	}
	}
}


List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), parentid);
for(Organization organization : organizations) {
	if(ignore.contains(organization.getName())) {
		continue;
	}
	String additional_information = "";
	if(!optionsTypeFilter_option.equals("")) {
		if(!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
			continue;
		}
		if(optionsTypeFilter_option.equals("Collection")) {
			String type_of_sample_collectin = "";
			String sampletype = "";
			String number_of_donors = "";
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet ddlrecordset : ddlrecordsets) {
				String recordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
				if(recordsetname.equals("Collection")) { 
					List<DDLRecord> records = ddlrecordset.getRecords();
					for(DDLRecord record : records) {
						if(record.getFieldValue("type_of_sample_collection") != null) {
							type_of_sample_collectin = record.getFieldValue("type_of_sample_collection").toString();
							type_of_sample_collectin = type_of_sample_collectin.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
						}
						if(record.getFieldValue("sample_type") != null) {
							sampletype = record.getFieldValue("sample_type").toString();
						}
						if(record.getFieldValue("number_of_donors") != null) {
							number_of_donors = "";
						}
					}
				}
			}
			additional_information = "<table style=\"border-width: 0px;\"><tr>";
			additional_information += "<tr><td>Type:</td><td>&nbsp" + type_of_sample_collectin + "</td></tr>";
			additional_information += "<tr><td>Sampletype:</td><td>&nbsp" + sampletype + "</td></tr>";
			additional_information += "<tr><td>Number of Doners:</td><td>&nbsp<span id=\"olnumberofdoners" + organization.getOrganizationId() + "\"></span></td></tr>";
			additional_information += "<tr><td>Number of Samples:</td><td>&nbsp<span id=\"olnumberofsamples" + organization.getOrganizationId() + "\"></span></td></tr>";
			
			List<Organization> suborganizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), organization.getOrganizationId());
			for(Organization suborganization : suborganizations) {
				String organisationlink = themeDisplay.getURLPortal() + "/web" + suborganization.getGroup().getFriendlyURL();
				additional_information += "<tr><td colspan=\"2\"><a href=\"" + organisationlink + "\">&nbsp&nbsp&nbsp-&nbsp&nbsp" + suborganization.getName() + "</a></td></tr>";
			}
			additional_information += "</table>";
			
		}
	}
	String organisationlink = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL();
	%>
	<div style="border-width: 1px;border-style: solid;border-color: #8bbf39;border-radius: 5px;padding:5px;margin:px;">
		<aui:a href="<%= organisationlink %>"><%= organization.getName() %></aui:a>
		<c:choose>
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_organization) %>">
				<span style="float:right;"><a id="deleteOrganization" class="icon-remove" style="color: red;" organisationid="<%= organization.getOrganizationId() %>" organisationname="<%= organization.getName() %>"></a></span>
			</c:when>
		</c:choose>
		<br />
		<%= additional_information %>
	</div>
	<br />
	<%
}
%>

<portlet:actionURL name='deleteOrganization' var="deleteOrganizationURL" />

<aui:script use="aui-base,event">
 A.all('#deleteOrganization').on(
   'click',
   function(event) {
    var confirmation_to_delete_user = confirm("Are you sure you want to delete the Organization " + event.currentTarget.getAttribute('organisationname') + " ?");
    if (confirmation_to_delete_user == true) {
     var url = '<%= deleteOrganizationURL.toString() %>';
     A.io.request(url,{
      //this is the data that you are sending to the action method
      data: {
         <portlet:namespace />bibbox_cs_organisationid: event.currentTarget.getAttribute('organisationid'),
      },
      dataType: 'json',
      on: {
        failure: function() { alert('There is a problem with the server connection.'); },
        success: function() { "success" }
      }
     });
        Liferay.Portlet.refresh('#<portlet:namespace />');
    }  
    return false;
   }
  );
</aui:script>

<portlet:resourceURL var="aggregateCollectionDataURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-io-request,aui-io-request,event,node,aui-popover,valuechange,event-hover,aui-tooltip,event-valuechange,click">
 AUI().use(
 'aui-base',
 'aui-io-request', 
 'node',
 function(A){
   var url = '<%= aggregateCollectionDataURL.toString() %>';
   A.io.request(url,{
    //this is the data that you are sending to the action method
    data: {
       <portlet:namespace />organizationId: '<%= parentid %>',
    },
    dataType: 'json',
    on: {
      failure: function() { 
      	//alert('There is a problem with the server connection.'); 
      },
      success: function(data) {
       var response = this.get('responseData');
       var organizationarray = response['organizations'].split(';');
       A.Array.each(organizationarray, function(value, index) {
       	A.one('#olnumberofdoners'+value).setHTML(response['numberofdoners'+value]);
       	A.one('#olnumberofsamples'+value).setHTML(response['numberofsamples'+value]);
       }) ;
      }
    }
   });
  });
</aui:script>
