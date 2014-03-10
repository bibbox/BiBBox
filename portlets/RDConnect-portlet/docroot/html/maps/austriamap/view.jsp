<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>

<portlet:defineObjects />
   
    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
  <script type='text/javascript'>
   google.load('visualization', '1', {'packages': ['geomap']});
   google.setOnLoadCallback(drawMap);

    function drawMap() {
    	var data = new google.visualization.DataTable();
    	data.addColumn("string", "City");
    	data.addColumn("number", "Number of Patients");
    	data.addColumn("string", "Title");
    	data.addColumn("string", "url");
        <% 
        List<Organization> austrian_organisations = new ArrayList<Organization>();
        List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
        for(Organization organization : organizations) {
        	if(organization.getName().equalsIgnoreCase("National Biobank of Test"))
        		continue;
        	if(organization.getName().equalsIgnoreCase("BBMUSK"))
        		continue;
        	if(organization.getName().equalsIgnoreCase("Medical Univeristy of Shi'Kahr"))
        		continue;
        	
        	if(organization.getAddress().getCity().length() > 2 &&  organization.getAddress().getCountry().getName().equals("austria")) {
        		austrian_organisations.add(organization);
        	}
        }
        %>data.addRows(<%= austrian_organisations.size() %>);<% 
        int count = 0;
        for(Organization organization : austrian_organisations) {
        	int patientcount = 0;
        	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
        	for(DDLRecordSet rdc_rs : rdc_recordlist) {
        		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
        		if(rdc_rsname.equals("Disease Matrix")) {
        			List<DDLRecord> records = rdc_rs.getRecords();
        			for(DDLRecord record : records) {
        				if(record.getFieldValue("Number_of_Donors") != null) {
        					try {
        						patientcount += Integer.valueOf(record.getFieldValue("Number_of_Donors").toString());
        					} catch(Exception e) {
        						
        					}
        				}
        			}
        		}
        	}
        	//System.out.println(organization.getAddress().getCity() +" " + organization.getAddress().getCountry().getName());
        	if(organization.getAddress().getCity().length() > 2 &&  organization.getAddress().getCountry().getName().equals("austria")) {
        		System.out.println(organization.getAddress().getCity());
		        %>
		        data.setValue(<%= count %>, 0, '<%= organization.getAddress().getCity() %>');
		        data.setValue(<%= count %>, 1,  <%= patientcount %>);
		        data.setValue(<%= count %>, 2, '<%= organization.getAddress().getCity() %> - <%= organization.getName() %>');
		        data.setValue(<%= count %>, 3, 'rd-connect.bibbox.org');
		        <% 
		        count++;
        	}
        
        }
        
        %>
      
      var options = {};
      options['region'] = 'AT';

      options['dataMode'] = 'markers';

      var container = document.getElementById('map_canvas_at');
      var geomap = new google.visualization.GeoMap(container);
      
	google.visualization.events.addListener(geomap,'select',function() {
    	  
          var selection = geomap.getSelection();
          var row = selection[0].row;
          var regioncode = predata.getValue(row,3);
          alert(regioncode);
          {
	            window.open('http://' + regioncode);
	      }
      });
      
      geomap.draw(data, options);
      
     
      
    };

  </script>

<div id='map_canvas_at'></div>

