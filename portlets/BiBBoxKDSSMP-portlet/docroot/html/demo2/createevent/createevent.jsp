<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<style>
	.yui3-skin-sam .yui3-calendarnav-prevmonth span, .yui3-skin-sam .yui3-calendarnav-nextmonth span {
	    display: inline;
	}
</style>
<style>
	.notdisplayInput {
		display: none;
	}
	.aui .highliteMultiselect {
		border: 1px solid red;
	}
	.highliteMultiselectElement {
		border: 1px solid red;
		color: red;
	}
	.aui select[multiple] {
		height: 200px;
	}
	.select-highlight-suggest-1p {
		color: #CC3333;
	}
	.select-highlight-suggest-2p {
		color: #0000CC;
		background-color: #FFFF66;
	}
	.select-highlight-suggest-1n {
		color: #585858;
	}
	.select-highlight-suggest-2n {
		color: #909090;
	}
	.stagingfooter {
		font-size: 80%;
	}
</style>
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
long organizationId = 0;
long eventid = 0;
boolean status = false;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
	String eventtype = ParamUtil.getString(request, "eventtype");
	String eventdisplay = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("Display", eventtype).getOptionvalue();
	
	%>
	
	<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

	<aui:form action="<%= createEventURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:layout>
				<aui:input type="hidden" name="organizationId" value="<%= String.valueOf(organizationId) %>" />
				<aui:input type="hidden" name="eventType" value="<%= eventtype %>" />
				<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
				<aui:column columnWidth="100" first="true">
					<label for="kdssmpdate"><%= "Date of " + eventdisplay %></label>
					<input class="kdssmpdate" name="<portlet:namespace />kdssmpdate" type="text"	placeholder="dd-mm-yyyy" value="">
					
				</aui:column>
				<%
				List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", eventtype);
				for(KdssmpConfiguration parameter : parameters) {
					KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
					String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
					if(parameterconfig.getGrouping().equalsIgnoreCase("")) {
						if(!parameterconfig.getComputed()) {
							int columnwidth = 100;
							if(!parameterconfig.getColumnwidth().equals("")) {
								columnwidth = Integer.parseInt(parameterconfig.getColumnwidth());
							}
							if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
								%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/html.jspf" %><%
							} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
								%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/text.jspf" %><%
							} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
								%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/textbox.jspf" %><%
							} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
								%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/select.jspf" %><%
							} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
								%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/multiselect.jspf" %><%
							} 
						}
						if(!parameterconfig.getConfirmationscript().equals("")) {
							%>
							<aui:script><%= parameterconfig.getConfirmationscript() %></aui:script>
							<%
						}
					}
				}
				%>
			</aui:layout>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" />
		</aui:button-row>
	</aui:form>
	<%
}

//String eventdisplay = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("Display", eventtype).getOptionvalue();
%>
<aui:script>
AUI.add('datastore', function(A) {
	A.DatakDSSMPStore = {
		kDSSMPStore: function (target) {
			var tmp = "DO Nothing because no Event created yet";
		}
	}
}
);
</aui:script>

<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
AUI().use(
  'aui-datepicker',
  function(Y) {
    var datepicker = new Y.DatePicker(
      {
        trigger: '.kdssmpdate',
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
