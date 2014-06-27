<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>

<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>

<portlet:defineObjects />

This is the <b>Ajaxtest</b> portlet in View mode.

<liferay-theme:defineObjects />



 <%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:renderURL var="simpleDialogExample" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="mvcPath" value="/html/people/view.jsp"/>
</portlet:renderURL>
<div>
<aui:button name="simple-dialog-example"  id="simple-dialog-example"  value="Click Here See Simple Allou UI Dialog"> </aui:button>
</div>
<aui:script use="aui-base,click,aui-dialog,aui-io">
AUI().use('aui-base', function(A) {
A.one('#<portlet:namespace />simple-dialog-example').on('click', function(event){
AUI().use('aui-dialog', 'aui-io', function(A) {
    var dialog = new A.Dialog({
    title: 'Upload Details',
    centered: true,
    modal: true,
    width: 500,
    height: 400,
    }).plug(A.Plugin.IO, {uri: '<%=simpleDialogExample%>'}).render();

});
});
});
</aui:script>


<!-- -------------------------- -->


<portlet:renderURL var="openURL" windowState= "<%= LiferayWindowState.POP_UP.toString() %>">
 <portlet:param name="jspPage" value="/html/people/view.jsp" />
</portlet:renderURL>

<button id="showModal" class="btn">Show Modal</button>

<div class="yui3-skin-sam">
    <div id="modal"></div>
</div>

<aui:script use="aui-modal,click">
AUI().use(
  'aui-modal',
  function(Y) {
      var url='${openURL}';
    var modal = new Y.Modal(
      {
        bodyContent: 'How many pages do you want to print?',
        centered: true,
        destroyOnHide: false,
        headerContent: '<h3>Print</h3>',
        height: 200,
        modal: true,
        render: '#modal',
        
        resizable: {
          handles: 'b, r'
        },
        toolbars: {
          body: [
            {
              icon: 'icon-file',
              label: 'Single Page'
            },
            {
              icon: 'icon-book',
              label: 'All Pages'
            }
          ]
        },
        visible: false,
        width: 450
      }
    ).render();

    modal.addToolbar(
      [
        {
          label: 'Cancel',
          on: {
            click: function() {
              modal.hide();
            }
          }
        },
        {
          label: 'Okay',
          on: {
            click: function() {
              alert('Just an example, there will be no printing here.');
            }
          }
        }
      ]
    );

    Y.one('#showModal').on(
      'click',
      function() {
        modal.show();
      }
    );
  }
);
</aui:script>



<liferay-ui:icon image="delete" message="file-entry-delete" url="javascript:alertDelete();" />
<liferay-ui:icon image="delete" message="file-entry-delete" url="javascript:showSiteManagement();" />

<aui:script use="aui-dialog,aui-overlay-manager">
Liferay.provide(
   window,
   'alertDelete',
   function() {
	   var instance = this;
	   var url='${openURL}';
	   Liferay.Util.openWindow( {
	      cache: false,
	      dialog: {
	         align: Liferay.Util.Window.ALIGN_CENTER,
	         after: {
	            render: function(event) {
	            this.set('y', this.get('y') + 50);
	         }
	      },
	      width: 820
		   },
		   dialogIframe: {
		      id: 'deleteIFrame',
		      uri: url
		   },
		   title: Liferay.Language.get('folder'),
		   uri: url
	   });
   },
['liferay-util-window']
);
</aui:script>


<aui:script use="aui-dialog,window,showSiteManagement">

Liferay.provide(
   window,
   'showSiteManagement',
   function() {
      var A = AUI();    
      var portletURL='${openURL}';
      var dialog = new A.Dialog(
         {
            destroyOnClose: true,
            modal: false,
            title: 'My title',
            width: 900
         }
      ).plug(
         A.Plugin.IO,
            {
               uri: portletURL.toString()
            }
      ).render();
   },
   ['aui-dialog']
); 
</aui:script>


