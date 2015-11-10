<%@ include file="/html/idcard/init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/idcard/biobank/view.jsp"></portlet:param>
</portlet:renderURL>

<%
D2Biobank biobank = null;
long biobankId = ParamUtil.getLong(request, "biobankId");
if(biobankId != 0) {
	biobank = D2BiobankLocalServiceUtil.getD2Biobank(biobankId);
}
%>

<aui:model-context bean="<%= biobank %>" model="<%= D2Biobank.class %>" />
<portlet:actionURL var="addBiobankURL" windowState="normal" name='<%= biobank == null ? "addBiobank" : "updateBiobank" %>' />
<aui:form action="<%= addBiobankURL %>" name="<portlet:namespace />fm">
	<aui:fieldset>
			<aui:input name="biobankId" type="hidden"></aui:input>
            <aui:input name="biobankName"></aui:input>

        </aui:fieldset>
        
        <liferay-ui:asset-categories-error />
                <liferay-ui:asset-tags-error />
                <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="d2biobankCategorizationPanel" persistState="<%= true %>" title="categorization">
                        <aui:fieldset>
                                <aui:input name="categories" type="assetCategories" />

                                <aui:input name="tags" type="assetTags" />
                        </aui:fieldset>
                </liferay-ui:panel>

                <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="d2biobankAssetLinksPanel" persistState="<%= true %>" title="related-assets">
                        <aui:fieldset>
                                <liferay-ui:input-asset-links
                                        className="<%= D2Biobank.class.getName() %>"
                                        classPK="<%= biobankId %>"
                                />
                        </aui:fieldset>
                </liferay-ui:panel>

        <aui:button-row>

            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

        </aui:button-row>
</aui:form>