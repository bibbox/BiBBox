<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />

<%
String organizationinvitation = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
organizationinvitation = httpRequest.getParameter("invitation");
%>

<portlet:actionURL name='setReactDateForInvitation' var="setReactDateForInvitationURL" />

<aui:script use="aui-base,event">
	AUI().use('aui-base', 'event', 
		function(event) {
			var url = '<%= setReactDateForInvitationURL.toString() %>';
			var oid = <%= organizationinvitation %>;
			if(oid != null) {
				A.io.request(url,{
					//this is the data that you are sending to the action method
					data: {
						<portlet:namespace />bibbox_cs_organizationinvitation: <%= organizationinvitation %>,
					},
					dataType: 'json',
					on: {
						failure: function() { "failure" },
						success: function() { "success" }
					}
				});
			}
			return false;
		}
	);
</aui:script>