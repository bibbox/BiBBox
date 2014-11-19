<%@ include file="/html/organisation/init.jsp" %> 

<portlet:defineObjects />

<%
long optionsListOrganizationFromMainOrganization_option = GetterUtil.getLong(portletPreferences.getValue("optionsListOrganizationFromMainOrganization", "0"));
String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
String optionsIgnoreOrganisations_option = GetterUtil.getString(portletPreferences.getValue("optionsIgnoreOrganisations", ""));
long optionsMainContactRole_option = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
long optionsDeleteTo_option = GetterUtil.getLong(portletPreferences.getValue("optionsDeleteTo", "0"));
boolean optionsEnableSearch_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsEnableSearch", "false"));

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
if(optionsTypeFilter_option.equals("RD-Connect")) {
	
	if(optionsEnableSearch_cfg) {
		%>
		<%@ include file="/html/organisation/organisationlister/organizationtyps/rdconnect_search.jsp" %>
		<%
	} else {
		%>
		<%@ include file="/html/organisation/organisationlister/organizationtyps/rdconnect.jsp" %>
		<%
	}
} else if(optionsTypeFilter_option.equals("Collection")) {
	%>
	<%@ include file="/html/organisation/organisationlister/organizationtyps/collection.jsp" %>
	<%
} else if(optionsTypeFilter_option.equals("bbmriat")) {
	%>
	<%@ include file="/html/organisation/organisationlister/organizationtyps/bbmriat.jsp" %>
	<%
} else {
	%>
	<%@ include file="/html/organisation/organisationlister/organizationtyps/default.jsp" %>
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
         <portlet:namespace />bibbox_cs_deleteto: <%= optionsDeleteTo_option %>,
      },
      dataType: 'json',
      on: {
        failure: function() { alert('There is a problem with the server connection.'); },
        success: function() { "success" }
      }
     });
        Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
    }  
    return false;
   }
  );
</aui:script>


