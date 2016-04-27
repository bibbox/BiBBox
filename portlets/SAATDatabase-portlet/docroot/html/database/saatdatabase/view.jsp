<%@ include file="/html/init.jsp" %> 

<div id="saatTab">

  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab-import-data">Import Data</a></li>
    <li><a href="#tab-2">Tab #2</a></li>
    <li><a href="#tab-3">Tab #3</a></li>
  </ul>

  <div class="tab-content">
    <div id="tab-1" class="tab-pane">
      <%@ include file="/html/database/saatdatabase/tabs/import-data.jspf" %>
    </div>
    <div id="tab-2">
      <p></p>
    </div>
    <div id="tab-3" class="tab-pane">
      <p></p>
    </div>
  </div>

</div>

<aui:script>				
	YUI().use(
  		'aui-tabview',
		function(Y) {
			new Y.TabView({
				srcNode: '#saatTab'
      		}).render();
  		}
	);
</aui:script>