<!--<nav class="${nav_css_class}" id="navigation" role="navigation">-->
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list nav_items as nav_item>
			<#if nav_item.isSelected()>
				<#list nav_item.getChildren() as nav_child>
					<#assign nav_child_attr_selected = "" />
					<#assign nav_child_css_class = "" />

					<#if nav_child.isSelected()>
						<#assign nav_child_attr_selected = "aria-selected='true'" />
						<#assign nav_child_css_class = "selected" />
					</#if>

					<li ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
						<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
					</li>
				</#list>
			</#if>
		</#list>
	</ul>
<!--</nav>-->