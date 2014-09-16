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
  	String breadcrumbs = "<a href=\"" + themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL() + "\">" + organization.getName() + "</a>";
  	while(!parentfound) {
  		if(parent_organization.getParentOrganizationId() == 0) {
  			parentfound = true;
  		} else {
  			parent_organization = parent_organization.getParentOrganization();
  			String parent_organisationlink = themeDisplay.getURLPortal() + "/web" + parent_organization.getGroup().getFriendlyURL();
  			String link = "<a href=\"" + parent_organisationlink + "\">" + parent_organization.getName() + "</a>";
  			String splitter = " &gt; ";
  			breadcrumbs = link + splitter + breadcrumbs;
  		}
  	}
  	%>
  	<div class="bbmriat_header_subcollectioninformation_container">
  		<div class="bbmriat_header_subcollectioninformation_container-breadcrump">	
  			<%= breadcrumbs %>
  		</div>
  		<div class="bbmriat_header_subcollectioninformation_container-menue">
  			<ul>
  				<%
  				List<Layout> pagelayouts = themeDisplay.getLayouts();
  				for(Layout organization_layout : pagelayouts) {
  					String url = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL() + organization_layout.getFriendlyURL();
	  				%>
	  					<li><aui:a href="<%= url %>"><%= organization_layout.getName() %></aui:a></li>
	  				<%
  				}
  				%>
  			</ul>
  		</div>
  		<div class="bbmriat_header_subcollectioninformation_container_collectioninformation">
  			Number of Sub-Collections: <span id="numberofsubcollections"></span><br>
  			Number of Doners (including Sub-Collections): <span id="numberofdoners"></span><br>
  			Number of Samples (including Sub-Collections): <span id="numberofsaples"></span><br>
  			Number of Aliquots (including Sub-Collections): <span id="numberofaliquots"></span><br>
  			Last Activities: <span id="lastactivitiessubcollection"></span>
  		</div>
  	</div>


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
       <portlet:namespace />organizationId: '<%= organizationId %>',
    },
    dataType: 'json',
    on: {
      failure: function() { alert('There is a problem with the server connection.'); },
      success: function(data) {
       var response = this.get('responseData');
       //alert(response['firstName'] + " " + response['lastName'] + " " + response['middleName']);
       A.one('#numberofsubcollections').setHTML(response['numberofsubcollections']);
       A.one('#numberofdoners').setHTML(response['numberofdoners']);
       A.one('#numberofsaples').setHTML(response['numberofsamples']);
       A.one('#numberofaliquots').setHTML(response['numberofaliquots']);
       A.one('#lastactivitiessubcollection').setHTML(response['lastactivitiessubcollection']);
      }
    }
   });
  });
</aui:script>

  	<%
}
%>