<%@ include file="/html/iris/init.jsp"%>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

This is the <b>Iris Database Protortyper</b> portlet in View mode.

<div style="width: 100%;">
	<div id="panel1"
		style="float: left; width: 30%; background-color: yellow;">

		<%
		long displayDDMTemplateId = 36303;
		long formDDMTemplateId = 0;
		long recordSetId = 12230;
		
		long event_recordsetid = 12233;
		
		DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.getRecordSet(recordSetId);
		
		DDMStructure ddmStructure = recordSet.getDDMStructure();
		
		boolean showAddRecordButton = false;
		
		String portletResource = ParamUtil.getString(request, "portletResource");
		
		Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
		long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
		
		LiferayPortletURL editsitemembershipURL = PortletURLFactoryUtil.create(request, "167", controlPanelPlid, "RENDER_PHASE");
		editsitemembershipURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
		editsitemembershipURL.setControlPanelCategory("current_site.content");
		editsitemembershipURL.setParameter("redirect", currentURL);
		editsitemembershipURL.setWindowState(WindowState.MAXIMIZED);
		editsitemembershipURL.setParameter("formDDMTemplateId", "0");
		editsitemembershipURL.setParameter("recordSetId", "12230");
		editsitemembershipURL.setParameter("struts_action", "/dynamic_data_lists/edit_record");
		%>
      <button id="addpatient" type="button">Add Patient</button>
		<ol>
			<%
        List<DDLRecord> rocords = recordSet.getRecords();
        for(DDLRecord record : rocords) {
          List<ddllinkingtable> events = ddllinkingtableLocalServiceUtil.getDDLEntrysByRecordAndRecordset(record.getRecordId(), event_recordsetid);
          System.out.println(events.size());
          if(events == null || events.size() == 0) { 
        %>
			<li class="file"><a class="testlink"
				testtmp="/web/guest/iris/-/iris/patient/<%= record.getRecordId() %>"><%= record.getField("Name").getValue() %></a></li>
			<% } else { %>
			<li><a class="testlink"
				testtmp="/web/guest/iris/-/iris/patient/<%= record.getRecordId() %>"><label
					for="subfolder1"><%= record.getField("Name").getValue() %></label></a>
				<input type="checkbox" id="subfolder1" />
				<ol>
					<% for(ddllinkingtable event : events) { %>
					<li class="file"><a class="testlink"
						testtmp="/web/guest/iris/-/iris/patient/<%= record.getRecordId() %>/examination/<%= event.getLinkrecordid() %>"><%= event.getLinkrecordid() %></a></li>
					<% } %>
				</ol> <!-- <li class="file"><a href="document.pdf">File 1</a></li>
          <li>
              <label for="subfolder1">Subfolder 1</label>
              <input type="checkbox" id="subfolder1" />
              <ol>
                  <li class="file"><a href="">File 2</a></li>
                  <li class="file"><a href="">File 2</a></li>
                  <li class="file"><a href="">File 2</a></li>
              </ol>
          </li> --> <%
        }
        }
        %>
		</ol>

	</div>
	<!-- Pannel 2 -->
	<div id="panel2" style="float: left;width: 70%;background-color: #99FFCC;">
	  <div id="contentNode">
	  </div>
	</div>
</div>
<aui:script use="aui-tabview">
AUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
  }
);
</aui:script>
<aui:script use="aui-base,aui-io-request">
AUI().ready(
  'aui-base',
  'aui-io-request',
  function(A) {
    A.all('.testlink').each(function() {
      this.on('click', function(event){
         var url = event.currentTarget.getAttribute('testtmp');
         A.io.request(url,{
         on: {
              failure: function() { alert('Unable to Load Data'); },
              success: function() { 
               A.one('#contentNode').setHTML(this.get('responseData'));
               AUI().use(
					  'aui-tabview',
					  function(Y) {
					    new Y.TabView(
					      {
					        srcNode: '#bbmritab'
					      }
					    ).render();
					  }
					);
               }
            }
         });
     });
 });
});
</aui:script>
<aui:script use="aui-base,aui-io-request">
AUI().use('aui-base', function(A){
         var contentNode = A.one('#contentNode');
      
         if(contentNode) {
            contentNode.empty();
           contentNode.html('<div class="loading-animation"></div>');
           
           contentNode.load('/web/guest/iris/-/iris/');
           
         }
   });
</aui:script>
<aui:script use="aui-base">
            A.all('#addpatient').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1000
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_sitemembership',
                        title: 'Edit Site Membership.',
                        uri: '<%=editsitemembershipURL.toString()%>'
                     }
                  );
               }
            );
</aui:script>
