<%@ include file="/html/idcard/init.jsp" %>

<%
D2Biobank biobank = (D2Biobank)request.getAttribute("bbmrieric_d2biobank");

biobank = biobank.toEscapedModel();

AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(D2Biobank.class.getName(), biobank.getBiobankId());

String currentURL = PortalUtil.getCurrentURL(request);

List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(D2Biobank.class.getName(), biobank.getBiobankId());
PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), request);
%>

<dl>
	<dt>BiobankId</dt>
	<dd><%= biobank.getBiobankId() %></dd>
	<dt>Biobank</dt>
	<dd><%= biobank.getBiobankName() %></dd>
</dl>

<c:if test="<%= themeDisplay.isSignedIn() %>">
        <liferay-ui:panel-container extended="<%= false %>"
                id="guestbookCollaborationPanelContainer" persistState="<%= true %>">
                <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
                id="guestbookCollaborationPanel" persistState="<%= true %>"
                title='<%= LanguageUtil.get(pageContext, "collaboration") %>'>
                        <liferay-ui:ratings className="<%= D2Biobank.class.getName() %>"
                                classPK="<%= biobank.getBiobankId() %>" type="stars" />

                        <br /><br /><br />

                        <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

                        <liferay-ui:discussion className="<%= D2Biobank.class.getName() %>"
                    classPK="<%= biobank.getBiobankId() %>"
                    formAction="<%= discussionURL %>" formName="fm2"
                    ratingsEnabled="<%= true %>" redirect="<%= currentURL %>"
                    subject="<%= biobank.getBiobankName() %>"
                    userId="<%= biobank.getUserId() %>" />

                </liferay-ui:panel>
        </liferay-ui:panel-container>
</c:if>

<liferay-ui:asset-links
        assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
        className="<%= D2Biobank.class.getName() %>"
        classPK="<%= biobank.getBiobankId() %>" />