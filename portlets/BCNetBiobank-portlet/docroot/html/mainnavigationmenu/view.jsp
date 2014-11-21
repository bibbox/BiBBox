<%@ include file="/html/init.jsp" %> 

<%
  	//System.out.println((String) request.getAttribute(WebKeys.PORTLET_ID));
 %>


<nav class="sort-pages modify-pages" id="navigation" role="navigation">
	<ul role="menubar" id="topmenu">
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
				int childcount = 0;
				
				menuepoint += "<ul class=\"child-menu\" role=\"menu\">";
				
				Iterator<Layout> childIterator = mainlayout.getChildren().iterator();
				while(childIterator.hasNext()){
					String childli = "";
					
					if(childcount == 0){
						childli = "class=\"firstli\"";
					}
					
					Layout childsetup = childIterator.next();
					if(!(childIterator.hasNext()) && (childcount > 0)){
						
						childli = "class=\"lastli\"";
					}
					childcount++;
					//for(Layout childsetup : mainlayout.getChildren()) {
						
						menuepoint += "<li id=\"layout_" + childsetup.getLayoutId() + "\"  " +childli + "  role=\"presentation\">";
						menuepoint += "<a role=\"menuitem\" href=\"" + childsetup.getFriendlyURL() + "\" aria-labelledby=\"layout_" + childsetup.getLayoutId() + "\"><span>" + childsetup.getNameCurrentValue() +"</span></a>";
						menuepoint += "</li>";
					//}
					
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

