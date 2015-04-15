<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style> 
.rcorners6 {
    border-radius: 50px 50px;
    background: #8AC007;
    overflow: hidden;
}
.sizeclass {
    height: 75px;
    width: 75px;
}
</style> 

<%
long optionsRootPage_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRootPage", "0"));
List<Layout> portlet_layouts = themeDisplay.getLayouts();
if(optionsRootPage_cfg != 0) {
	Layout layout_root = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, optionsRootPage_cfg);
	if(layout_root.hasChildren()) {
		portlet_layouts = layout_root.getChildren();
	}
}
%>

<div class="container">  
<div class="row">  
<%
for(Layout portlet_layout : portlet_layouts) {
	String img_path = "/images/dashboard/";
	if(portlet_layout.getNameCurrentValue().equalsIgnoreCase("User")) {
		img_path += "user.png";
	} else if(portlet_layout.getNameCurrentValue().equalsIgnoreCase("Statistics")) {
		img_path += "Statistics.png";
	} else {
		String orgPath = themeDisplay.getURLPortal()+"/web"+ portlet_layout.getGroup().getFriendlyURL() + portlet_layout.getFriendlyURL();
		%>
			<div class="span1 rcorners6 sizeclass" ><aui:a class="span1 sizeclass" href="<%= orgPath %>"><%= portlet_layout.getName() %></aui:a></div> 
		<%
		continue;
	}
	String orgPath = themeDisplay.getURLPortal()+"/web"+ portlet_layout.getGroup().getFriendlyURL() + portlet_layout.getFriendlyURL();
%>
	<div class="span1 rcorners6 sizeclass" ><aui:a class="span1 sizeclass" href="<%= orgPath %>"><img src='<%= request.getContextPath() + img_path %>' class="center-block img-responsive img-circle" alt="Generic placeholder thumbnail"></aui:a></div> 
<%
}
%>
</div>    
