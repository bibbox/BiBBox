<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />

<div id="topmenu-position">

<nav class="sort-pages modify-pages" id="navigation" role="navigation">
	<ul role="menubar" id="topemnu">
		<%
		List<Layout> mainlayouts = LayoutLocalServiceUtil.getLayouts(10181, false);
		int count = 0;
		String menuepoint = "";
		for(Layout mainlayout : mainlayouts) {
			if(mainlayout.getParentLayoutId() != 0) {
				break;
			}

			if(count == 1) {
				menuepoint = menuepoint.replaceAll("updateclassstring", "firstli");
			} else {
				menuepoint = menuepoint.replaceAll("updateclassstring", "");
			}
			
			menuepoint += "<li id=\"layout_" + mainlayout.getLayoutId() + "\" class=\"updateclassstring lfr-nav-deletable lfr-nav-sortable lfr-nav-updateable yui3-dd-drop\" role=\"presentation\">";
			menuepoint += "<a role=\"menuitem\" href=\"" + mainlayout.getFriendlyURL() + "\" aria-labelledby=\"layout_" + mainlayout.getLayoutId() + "\"><span>" + mainlayout.getNameCurrentValue() +"</span></a>";
			
			if(mainlayout.hasChildren()) {
				menuepoint += "<ul class=\"child-menu\" role=\"menu\">";
				count = 0;
				List<Layout> childsetups = mainlayout.getChildren();
				for(Layout childsetup : childsetups) {
					String childcss = "";
					if(count == 0) {
						childcss = "child-firstli";
					}
					if(count == (childsetups.size()-1)) {
						childcss = "child-lastli";
					}
					menuepoint += "<li id=\"layout_" + childsetup.getLayoutId() + "\" role=\"presentation\" class=\"" + childcss + "\">";
					menuepoint += "<a role=\"menuitem\" href=\"" + childsetup.getFriendlyURL() + "\" aria-labelledby=\"layout_" + childsetup.getLayoutId() + "\"><span>" + childsetup.getNameCurrentValue() +"</span></a>";
					menuepoint += "</li>";
				}
				menuepoint += "</ul>";
			}
			menuepoint += "</li>";
			count++;
		}
		menuepoint = menuepoint.replaceAll("updateclassstring", "lastli");
		%>
		<%= menuepoint %>
	</ul>
</nav>

</div>