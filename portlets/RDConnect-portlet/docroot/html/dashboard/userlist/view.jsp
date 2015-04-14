<%@ include file="/html/init.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date now = new java.util.Date();
String tabledata = "";
List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
for(User user_ : users) {
	String lastlogindate = "never";
	if(user_.getLastLoginDate() != null) {
		
		lastlogindate = ((now.getTime() - user_.getLastLoginDate().getTime())/(1000 *60*60*24)) + " (" + dateFormat.format(user_.getLastLoginDate()) + ")";
	}
	List<Organization> organizations = user_.getOrganizations();
	String organizationstring = "";
	String lnbrake = "";
	for(Organization organization : organizations) {
		organizationstring += lnbrake + organization.getName();
		lnbrake = "<br>";
	}
	tabledata += "{UserID: '" + user_.getUserId() + "', 'First Name': '" + user_.getFirstName() + "', 'Last Name': '" + 
		user_.getLastName() + "', 'E-mail': '" + user_.getEmailAddress() + 
		"', 'Last Login': '" + lastlogindate + "', 'Organizations': '" + organizationstring + "'},";
}
%>

<div id="myOrganizationTable"></div>

<aui:script use="node,aui-datatable,aui-datatype,datatable-sort">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [<%= tabledata %>];
    var nestedCols = [ 
    	{
    		key: 'UserID',
    		sortable: true
    	},
    	{
    		key: 'First Name',
    		sortable: true
    	},
    	{
    		key: 'Last Name',
    		sortable: true
    	},
    	{
    		key: 'E-mail',
    		sortable: true
    	},
    	{
    		key: 'Last Login',
    		sortable: true
    	},
    	{
    		key: 'Organizations',
    		sortable: true,
    		allowHTML: true,
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#myOrganizationTable');

    dataTable.get('boundingBox').unselectable();
  }
);
</aui:script>
