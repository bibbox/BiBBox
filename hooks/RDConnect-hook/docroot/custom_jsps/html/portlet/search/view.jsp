<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/search/init.jsp" %>

<style>
.bbmri_eric_search {
	visibility: hidden;
}
</style>

<%
if(bbmri_disableSelection) {
	%>
	<div class="bbmri_eric_search">
	<%
}
%>

<liferay-ui:search />

<%
if(bbmri_disableSelection) {
	%>
	</div>
	<script>
		AUI().use('event', 'node', function(A) {
			var nodeObject = A.one('#_3_groupId');
			nodeObject.setStyle('display', 'none');
		});
	</script>
	<%
}
%>