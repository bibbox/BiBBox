<nav class="${nav_css_class}" id="navigation" role="navigation">
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list all_nav_items as nav_item>
			<#if nav_item.getName("en_US")?matches("FOOTER")>
				<#list nav_item.getChildren() as nav_child>
					<li id="layout_${nav_item.getLayoutId()}" role="presentation">
						<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${company_url}${nav_child.getFriendlyURL()}" ${nav_child.getTarget()} role="menuitem">
						<div style="float: left;">
						<div class="bbmri-eric-square-orange"></div>
						<div style="float: left;">${nav_child.getName()}</div>
						</div></a>
					</li>
				</#list>
			</#if>
		</#list>
	</ul>
</nav>