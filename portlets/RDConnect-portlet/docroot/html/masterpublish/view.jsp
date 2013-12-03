<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

This is the <b>Master Publish</b> portlet in View mode.

<portlet:actionURL name='publishToGate' var="publishToGateURL" />

<aui:button type="cancel"  onClick="<%= publishToGateURL %>" />