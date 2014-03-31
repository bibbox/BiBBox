
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list all_nav_items as nav_item>
			<#if nav_item.getName("en_US")?matches("FOOTER")>
				<#list nav_item.getChildren() as nav_child>
					<li id="layout_${nav_item.getLayoutId()}" role="presentation" style="display:inline-block;">
						<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${company_url}${nav_child.getFriendlyURL()}" ${nav_child.getTarget()} role="menuitem">
						<div style="margin: auto;display:inline-block;">
						<div style="height: 6px;width: 6px;border:1px solid;background: #ED660A;border-color: #ED660A;margin-top: 20px;margin-right: 10px;float: left;"></div>
						<div style="float: left;">${nav_child.getName()}</div>
						</div>
						</a>
					</li>
				</#list>
			</#if>
		</#list>
	</ul>