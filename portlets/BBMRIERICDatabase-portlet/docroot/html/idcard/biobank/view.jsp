<%@ include file="/html/idcard/init.jsp" %>

<c:if test='<%= D2BiobankModelPermission.contains(permissionChecker, scopeGroupId, "ADD_BIOBANK") %>'>
	<aui:button-row cssClass="d2biobank-button">
		<portlet:renderURL var="addEntryURL">
			<portlet:param name="mvcPath" value="/html/idcard/biobank/edit_biobank.jsp"></portlet:param>
		</portlet:renderURL>
		<aui:button onClick="<%= addEntryURL.toString() %>" value="Add Biobank"></aui:button>
	</aui:button-row>
</c:if>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/idcard/biobank/view_search.jsp" />
</liferay-portlet:renderURL>
<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<liferay-ui:search-container>
    <liferay-ui:search-container-results
        results="<%=D2BiobankLocalServiceUtil.getD2Biobanks(searchContainer.getStart(), searchContainer.getEnd())%>"
        total="<%=D2BiobankLocalServiceUtil.getD2BiobanksCount()%>" />

    <liferay-ui:search-container-row
        className="at.meduni.liferay.portlet.bbmrieric.model.D2Biobank" modelVar="entry">

        <liferay-ui:search-container-column-text property="biobankId" />
        
        <liferay-ui:search-container-column-text property="bbmribiobankID" />

        <liferay-ui:search-container-column-text property="biobankName" />
        
        <liferay-ui:search-container-column-jsp path="/html/idcard/biobank/biobank_actions.jsp" align="right" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:nav cssClass="nav-tabs">

    <%
        /*List<Guestbook> guestbooks = GuestbookLocalServiceUtil
                    .getGuestbooks(scopeGroupId);
            for (int i = 0; i < guestbooks.size(); i++) {
                Guestbook curGuestbook = (Guestbook) guestbooks.get(i);

                String cssClass = StringPool.BLANK;

                if (curGuestbook.getGuestbookId() == guestbookId) {
                    cssClass = "active";
                }*/
    %>

    <portlet:renderURL var="viewPageURL">
        <portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
        <portlet:param name="guestbookId"
            value="<%=String.valueOf(1)%>" />
    </portlet:renderURL>

    <aui:nav-item cssClass="" href="<%=viewPageURL%>"
        label="Collection 1" />
        <aui:nav-item cssClass="" href="<%=viewPageURL%>"
        label="Collection 2" />
        <aui:nav-item cssClass="" href="<%=viewPageURL%>"
        label="Collection 3" />
        <aui:nav-item cssClass="" href="<%=viewPageURL%>"
        label="Collection 4" />

    <%
        //}
    %>

</aui:nav>