<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>

<portlet:defineObjects />

This is the <b>Ajaxtest</b> portlet in View mode.

<%

%>

<liferay-theme:defineObjects />
<div>
<h5>Iframe Dialog Please click on button  and see Portlet Y is open In AUI Dialog....
</h5><br/>
<aui:button value="Click Me I will Open PortletY" id="openPortletY" name="openPortletY"></aui:button>
</div>
<aui:script use="liferay-util-window,aui-dialog-iframe-deprecated,aui-io-plugin-deprecated,aui-base,aui-io-deprecated,liferay-portlet-url">
AUI().use('aui-base','liferay-util-window','aui-dialog-iframe-deprecated','aui-io-plugin-deprecated','aui-io-deprecated','liferay-portlet-url',function(A) {
A.one('#<portlet:namespace/>openPortletY').on('click', function(event){
    var url =Liferay.PortletURL.createRenderURL();    
    url.setPortletId("ajaxtest_WAR_RDConnectportlet_INSTANCE_vAP4"); 
    url.setWindowState('pop_up');  
    var urlstring = url.toString();
    Liferay.Util.Window.getWindow( {
    	centered: true,
    	constrain2view: true,
    	modal: true,
    	resizable: false,
    	width: 450}).plug(A.Plugin.IO,{uri: urlstring}).render();             
	});
});
</aui:script>

<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="popupURL" >
    			<portlet:param name="mvcPath" value="/html/people/adduser.jsp" />
</portlet:renderURL>

<a href="<%= popupURL %>" target="_blank">Popup</a>


