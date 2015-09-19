
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
	  <#assign navcount = 0> 
		<#list all_nav_items as nav_item>
			<#if nav_item.getName("en_US")?matches("FOOTER")>
				<#list nav_item.getChildren() as nav_child>
				  <#assign navcount = navcount + 1> 
					<li id="layout_${nav_item.getLayoutId()}" role="presentation" style="display:inline-block;">
						<#assign itemhrefurl = nav_child.getFriendlyURL()?replace("(.+)web(.+)guest", "", 'r') />
						<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${itemhrefurl}" ${nav_child.getTarget()} role="menuitem">
						<div style="margin: auto;display:inline-block;background: #FEFEFE;height: 20px;width:100px;">
   						<div style="height: 8px;width: 8px;border:1px solid;background: #ED660A;border-color: #ED660A;margin-top: 5px;margin-left: -5px;float: left;"></div>
   						<div style="float: left;height: 18px;width:80px;font-size: 11px;">${nav_child.getName()}</div>
						</div>
						</a>
					</li>
					
					<#if navcount == 1>
					 <li style="display:inline-block;">
					    <div style="margin: auto;display:inline-block;">
					       <div style="float: left;color: #FFFFFF;font-size: 14px;margin-left: 20px;margin-right: 25px;">BBMRI-ERIC | Neue Stiftingtalstrasse 2/B/6 | 8010 Graz - AUSTRIA</div>
					    </div>
					 </li>
					</#if>
				</#list>
			</#if>
		</#list>
	</ul>