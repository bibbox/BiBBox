<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<div id="container_invitation" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<%
String data_invitation = InvitationOrganisationLocalServiceUtil.getInvitationStatisticsInvitationsSend();
String data_reacted = InvitationOrganisationLocalServiceUtil.getInvitationStatisticsReacted();
String data_rejected = InvitationOrganisationLocalServiceUtil.getInvitationStatisticsRejected();
%>

<script type="text/javascript">
$(function () {
    $('#container_invitation').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Invitation Statistics'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: { // don't display the dummy year
                month: '%e. %b',
                year: '%b'
            },
            title: {
                text: 'Date'
            }
        },
        yAxis: {
            title: {
                text: 'Number of Organizations'
            },
            min: 0
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br>',
            pointFormat: '{point.x:%e. %b %y}: {point.y:.0f}'
        },

        plotOptions: {
            spline: {
                marker: {
                    enabled: true
                }
            }
        },

        series: [{
            name: 'Invitations Send',
            // Define the data points. All series have a dummy year
            // of 1970/71 in order to be compared on the same x axis. Note
            // that in JavaScript, months start at 0 for January, 1 for February etc.
            data: [
                <%= data_invitation %>
            ]
        }, {
            name: 'Reacted to the invitation',
            data: [
                <%= data_reacted %>
            ]
        }, {
            name: 'Rejected to participate',
            data: [
                <%= data_rejected %>
            ]
        }]
    });
});
</script>
