<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

This is the <b>Ajaxtest</b> portlet in View mode.

<portlet:actionURL name='somethingHappensHere' var="somethingHappensHereURL" />

<aui:script use="aui-io-request, event, node">
	AUI().use('aui-io-request', 'event', 'node', function(A){
		var nodeObject = A.one('#save-button');
		nodeObject.on('click', function(event){
			var url = '<%= somethingHappensHereURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
				   <portlet:namespace />id: event.target.getAttribute('value'),
				   <portlet:namespace />name: 'wsd',
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('failure'); },
				  success: function(event, id, obj) { alert('success'); }
				}
			});
		});
	});
</aui:script>




<input id="save-button" type="submit" value="1" />
<input id="save-button" type="submit" value="2" />
<input id="save-button" type="submit" value="3" />
<input id="save-button" type="submit" value="4" />
<input id="save-button" type="submit" value="5" />


