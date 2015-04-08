<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

<%
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
}
String eventtype = ParamUtil.getString(request, "eventtype");
String eventdisplay = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("Display", eventtype).getOptionvalue();
%>

<style>
	.yui3-skin-sam .yui3-calendarnav-prevmonth span, .yui3-skin-sam .yui3-calendarnav-nextmonth span {
	    display: inline;
	}
</style>

<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

<aui:form action="<%= createEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="patientId" value="<%= String.valueOf(organizationId) %>" />
			<aui:input type="hidden" name="eventType" value="<%= eventdisplay %>" />
			<aui:column columnWidth="100" first="true">
				<label for="kdssmpdate"><%= "Date of " + eventdisplay %></label>
				<input class="form-control" name="kdssmpdate" type="text" placeholder="dd-mm-yyyy" value="">
			</aui:column>
			<!-- Dynamic loading Elements -->
			<%
			List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype);
			for(KdssmpConfiguration parameter : parameters) {
				KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
				String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
				if(parameterconfig.getGrouping().equalsIgnoreCase("")) {
					if(!parameterconfig.getComputed()) {
						if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
							%><%@ include file="/html/demo/dynamicevent/dynamicelements/html.jspf" %><%
						} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
							%><%@ include file="/html/demo/dynamicevent/dynamicelements/text.jspf" %><%
						} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
							%><%@ include file="/html/demo/dynamicevent/dynamicelements/textbox.jspf" %><%
						} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
							%><%@ include file="/html/demo/dynamicevent/dynamicelements/select.jspf" %><%
						} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
							%><%@ include file="/html/demo/dynamicevent/dynamicelements/multiselect.jspf" %><%
						}
					}
				}
			}
			%>
		</aui:layout>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
AUI().use(
  'aui-datepicker',
  function(Y) {
    var datepicker = new Y.DatePicker(
      {
        trigger: 'input',
        mask: '%d-%m-%Y',
        popover: {
          toolbars: {
            header: [[
              {
                icon:'icon-trash',
                label: 'Clear',
                on: {
                  click: function() {
                    datepicker.clearSelection();
                  }
                }
              },
              {
                icon:'icon-globe',
                label: 'Today',
                on: {
                  click: function() {
                    datepicker.clearSelection();
                    datepicker.selectDates(new Date());
                  }
                }
              }
            ]]
          },
          zIndex: 1
        }
      }
    );
  }
);
</aui:script>
