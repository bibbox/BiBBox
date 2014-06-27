<%

displayDDMTemplateId = 36303;
formDDMTemplateId = 0;
recordSetId = 12230;

recordSet = DDLRecordSetLocalServiceUtil.getRecordSet(recordSetId);

ddmStructure = recordSet.getDDMStructure();

showAddRecordButton = false;

%>

<portlet:actionURL var="editRecordSetURL">
   <portlet:param name="struts_action" value="/dynamic_data_lists/edit_record_set" />
</portlet:actionURL>

<aui:form action="<%= editRecordSetURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveRecordSet();" %>'>
   <c:if test="<%= showAddRecordButton %>">
      <aui:nav-bar>
         <aui:nav>
            <portlet:renderURL var="addRecordURL">
               <portlet:param name="struts_action" value="/dynamic_data_lists/edit_record" />
               <portlet:param name="redirect" value="<%= currentURL %>" />
               <portlet:param name="recordSetId" value="<%= String.valueOf(recordSet.getRecordSetId()) %>" />
               <portlet:param name="formDDMTemplateId" value="<%= String.valueOf(formDDMTemplateId) %>" />
            </portlet:renderURL>

            <aui:nav-item href="<%= addRecordURL %>" iconCssClass="icon-plus" label='<%= LanguageUtil.format(pageContext, "add-x", HtmlUtil.escape(ddmStructure.getName(locale))) %>' />
         </aui:nav>
      </aui:nav-bar>
   </c:if>

   <%= DDLUtil.getTemplateContent(displayDDMTemplateId, recordSet, themeDisplay, renderRequest, renderResponse) %>

</aui:form>