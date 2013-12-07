<div class="rdhubicol" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
		<table class="portlet-layout">
		<tr>
			<td class="aui-w100 portlet-column portlet-column-only rd-hub-column1" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
			</td>
		</tr>
		</table>

		<table class="portlet-layout">
		<tr>
			<td class="aui-w100 portlet-column portlet-column-only rd-hub-column2-w100" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")
			</td>
		</tr>
		</table>
	#else
		<div class="portlet-layout">
			<div class="aui-w100 portlet-column portlet-column-only rd-hub-column1" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
			</div>
		</div>

		<div class="portlet-layout">
			<div class="aui-w100 portlet-column portlet-column-only rd-hub-column2-w100" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")
			</div>
		</div>
	#end
</div>