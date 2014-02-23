<%@include file="/html/init.jsp" %>

<%
	MasterCandidate master = null;

	long masterId = ParamUtil.getLong(request, "masterId");

	if (masterId > 0) {
		master = MasterCandidateLocalServiceUtil.getMasterCandidate(masterId);
	}
	
	String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
	String[] types = CandidateLocalServiceUtil.getTypesOfCandidatesNewEntry();
	
	String redirect = ParamUtil.getString(request, "redirect");	
	
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=master.getName() %>'
/>

<aui:model-context bean="<%= master %>" model="<%= MasterCandidate.class %>" />
<portlet:actionURL name='updateMasterCandidate' var="updateMasterCandidateURL" windowState="normal" />
<aui:form action="<%= updateMasterCandidateURL %>" method="POST" name="fm">
	<aui:fieldset>
	<aui:layout cssClass="proposelayout"> 
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="masterCandidateId" value='<%= master.getMasterCandidateId() %>' cssClass="propose"/>
	<aui:column columnWidth="100" first="true">
		<aui:input name="name" value='<%= master.getName() %>' cssClass="propose"/>
	</aui:column>
	<aui:column columnWidth="50" first="true">	
		<% if(master.getCountry().contains(";")) { %>
			<aui:input name="country" value='<%= master.getCountry() %>' />
		<% } else { %>
		<aui:select name="country" label="country" cssClass="propose">
			<% for (String string : countrylist) { %>
				<aui:option value="<%= string %>" selected="<%= master.getCountry().equalsIgnoreCase(string) %>"><%= string %></aui:option>
			<% } %>
		</aui:select>
		<% } %>
	</aui:column>
	<aui:column columnWidth="25">	
		<aui:select name="candidatetype" showEmptyOption="<%= true %>" label="Type" cssClass="propose">
			<% for (String string : types) { %>
				<aui:option value="<%= string %>" selected="<%= master.getCandidatetype().equalsIgnoreCase(string) ? true : false %>"><%= string %></aui:option>
			<% } %>
		</aui:select>
	</aui:column>
	<aui:column columnWidth="25" last="true">	
		<aui:input name="candidatesubtype" label="Acronym" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="100" first="true">			
		<aui:input name="url" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" first="true">	
		<aui:input name="contactperson" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" last="true">	
		<aui:input name="mail" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="100" first="true" >	
		<aui:input name="address" cssClass="propose"/>
	</aui:column>
	<aui:column columnWidth="50" first="true">
		<aui:input name="diseasescodes" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" last="true">
		<aui:input name="diseasesfreetext" cssClass="propose" />
	</aui:column>
	<!--<aui:column columnWidth="100" first="true">
		<aui:input name="diseasescodesauto" type="hidden" />
		<div id="DiseasTableToggler">
  			<h4 class="header toggler-header-collapsed"><span>+ Advanced options for diseases code entry</span></h4>
			<div class="content toggler-content-collapsed" id="DiseasTable">
			<button type="button" id="addRowButton" >Add Row</button>
			</div>
		</div>	
	</aui:column>-->
	<aui:column columnWidth="100" first="true">
		<aui:input name="comment"  cssClass="propose" />	
	</aui:column>
	<aui:column columnWidth="50" first="true">
		<aui:input name="head" cssClass="propose"  />
	</aui:column>
	<aui:column columnWidth="25">
		<aui:input name="joinId" cssClass="propose"  />
	</aui:column>
	<aui:column columnWidth="25" last="true" >
		<% if(master.getState().equalsIgnoreCase("P")) { %>
			<aui:input name="statepublished" label="Data checked: published" value="published" disabled="true" cssClass="propose" />
			<aui:input type="hidden" name="state" value="P" />
		<% } else { %>
			<aui:select name="state" cssClass="propose" label="Data checked">
				<aui:option value="X" selected='<%= master.getState().equalsIgnoreCase("X") ? true : false %>' >rejected</aui:option>
				<aui:option value="0" selected='<%= master.getState().equalsIgnoreCase("0") ? true : false %>' >not decided</aui:option>
				<aui:option value="1" selected='<%= master.getState().equalsIgnoreCase("1") ? true : false %>' >data checked</aui:option>
			</aui:select>
		<% } %>
	</aui:column>
	</aui:layout>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" onClick='<%= renderResponse.getNamespace() + "saveDataMasterTable();" %>' />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />saveDataMasterTable() {
		document.<portlet:namespace />fm.<portlet:namespace />diseasescodesauto.value = 'xyz';
	}
</aui:script>

<aui:script use="aui-datatable,aui-datatype,datatable-sort,aui-toggler,event, node">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [
      {name: 'ABC', donors: 500, ICD10: 'G50', OMIM: '231241', UMLS: '', MeSH: '', MedDRA: '', snomed: '', orpha: '', synonym: '', comment: ''},
      {name: 'CDE', donors: 100, ICD10: 'H60', OMIM: '124124', UMLS: '', MeSH: '', MedDRA: '', snomed: '', orpha: '', synonym: '', comment: ''}
    ];

    var nestedCols = [
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'name',
        sortable: true
      },
      {
        editor:  new Y.TextCellEditor(
          {
            inputFormatter: Y.DataType.String.evaluate,
            validator: {
              rules: {
                value: {
                  number: true,
                  required: true
                }
              }
            }
          }
        ),
        key: 'donors'
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'ICD10',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'OMIM',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'UMLS',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'MeSH',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'MedDRA',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'snomed',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'orpha',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'synonym',
        sortable: true
      },
      {
        editor: new Y.TextAreaCellEditor(),
        key: 'comment'
      }
    ];

    var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
        editEvent: 'dblclick',
        plugins: [
          {
            cfg: {
              highlightRange: false
            },
            fn: Y.Plugin.DataTableHighlight
          }
        ]
      }
    ).render('#DiseasTable');

    dataTable.get('boundingBox').unselectable();
    
    var addRow = A.all('#addRowButton');
    addRow.on('click', function(event){
		dataTable.data.add({name: '', donors: 0, ICD10: '', OMIM: '', UMLS: '', MeSH: '', MedDRA: '', snomed: '', orpha: '', synonym: '', comment: ''});
	});
    
  }
);
AUI().use(
  'aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: true,
        closeAllOnExpand: true,
        container: '#DiseasTableToggler',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);
</aui:script>