<!-- 
BiBBoxCommonServices
user/edit_invitation

 -->
<%@ include file="/html/user/init.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	// Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_add_invitation = "ADD_INVITATION";
	String actionId_edit_invitation = "EDIT_INVITATION";

	String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
	long optionsParentOrganisation_option = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
	if (optionsParentOrganisation_option == 1) {
		com.liferay.portal.model.Group currentGroup = themeDisplay.getLayout().getGroup();
		if (currentGroup.isOrganization()) {
			// the group is an Organization
			optionsParentOrganisation_option = currentGroup.getClassPK();
		}
	}
%>

<div id="myDataTable"></div>

<%
	Long invitationId = ParamUtil.getLong(request, "invitationId");
	List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), optionsParentOrganisation_option);
	for (Organization organization : organizations) {
		if (!optionsTypeFilter_option.equals("")) {
			if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
				continue;
			}
		}
%>

<%
	}
%>
<div id="pizza"></div>

<portlet:resourceURL var="getOrganisationsURL"></portlet:resourceURL>

<% // query = "&q=" + encodeURIComponent('select * from local.search ' + 'where zip = "94089" and query = "pizza"'), %>

<aui:script use="aui-base,aui-datatable,aui-datatype,datatable-sort,datasource-get,datasource-jsonschema,datatable-datasource,aui-io-request,aui-io-request,event,node,aui-popover,valuechange,event-hover,aui-tooltip,event-valuechange,click">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [
    	<%
    	for (Organization organization : organizations) {
    		if (!optionsTypeFilter_option.equals("")) {
    			if (!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
    				continue;
    			}
    		}
    	
    	%>
    	{active: 'yes', last_change: '1236 Some Street', amount: 5, main_contact: '<%= "<input type=\"checkbox\" name=\"vehiclev\" value=\"Bike\">Bike" + "</input>" %>', colors:['red'], fruit:['banana','cherry'], last_login: '4/19/2007', name: '<%= organization.getName() %>', state: 'CA'},
    	<%
    	}
    	%>
      {active: 'no', last_change: '3721 Another Ave', amount: 3, main_contact: 'New York', colors:['red','blue'], fruit:['banana'], last_login: '2/15/2006', name: 'Joan K. Jones', state: 'NY'}
    ];

    var nestedCols = [
      {
        key: 'name',
        sortable: true
      },
      {
        key: 'last_login',
        sortable: true
      },
      {
        key: 'last_change'
      },
      {
        key: 'main_contact',
        name: 'Main Contact'
      },
      {
	      editor: new Y.RadioCellEditor(
	          {
	            editable: true,
	            options: {
	              yes: 'Yes',
	              no: 'No'
	            }
	          }
	        ),
	        key: 'active'
      }
    ];

    var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
        editEvent: 'dblclick',
        plugins: [
          {
            cfg: {
              highlightRange: false
            },
            fn: Y.Plugin.DataTableHighlight
          }
        ]
      }
    ).render('#myDataTable');

    dataTable.get('boundingBox').unselectable();
  }
);
</aui:script>