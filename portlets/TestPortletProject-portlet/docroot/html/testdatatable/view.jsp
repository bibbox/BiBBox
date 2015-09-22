<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<div id="datatable"></div>


<script type="text/javascript">
<!--
AUI().use('aui-datatable','aui-datatype','datatable-sort','aui-pagination','aui-pagination-centered',function(Y) {

// The functionality of this table would require additional modules be use()d,
            // but the feature APIs are aggregated onto Y.DataTable.
            // (Snippet is for illustration. Not all features are available today.)
            var table = new Y.DataTable({
            	columns: ['name', 'qty'],
                data: [
                    { name: 'Apple',  qty: 16 },
                    { name: 'Banana', qty: 10 },
                    { name: 'Carrot', qty: 34 },
                    { name: 'Date',   qty: 92 },
                    { name: 'Grape',  qty: 14 },
                    { name: 'Orange', qty: 74 },
                    { name: 'Rasin',  qty: 39 }
                ],
                rowsPerPage: 4,
                pageSizes: [ 4, 'Show All' ]
            }).render('#datatable');
            table.get('boundingBox').unselectable();

});
//-->
</script>
