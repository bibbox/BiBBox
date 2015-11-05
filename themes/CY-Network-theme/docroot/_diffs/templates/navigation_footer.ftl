
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
	  <#assign navcount = 0> 
		<#list all_nav_items as nav_item>
			<#if nav_item.getName("en_US")?matches("FOOTER")>
				<#list nav_item.getChildren() as nav_child>
				  <#assign navcount = navcount + 1> 
				  <#if navcount != 1>
				  	<li style="color: #ffffff;"> | </li>
				  </#if>
					<li id="layout_${nav_item.getLayoutId()}" role="presentation">
						<a style="color:FFFFFF;" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${company_url}${nav_child.getFriendlyURL()}" ${nav_child.getTarget()} role="menuitem">
   						${nav_child.getName()}
						</a>
					</li>
				</#list>
			</#if>
		</#list>
	</ul>