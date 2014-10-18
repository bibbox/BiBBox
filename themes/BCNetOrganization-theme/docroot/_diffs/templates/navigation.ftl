<nav class="${nav_css_class}" id="navigation" role="navigation">
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" id="topemnu">
		
		<#assign parentfirst=true/>
		
		<#list nav_main_items as nav_item>
			<#assign nav_item_attr_has_popup = "" />
			<#assign nav_item_attr_selected = "" />
			<#assign nav_item_css_class = "" />

			<#if nav_item.isSelected()>
				<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
				<#assign nav_item_attr_selected = "aria-selected='true'" />
				<#assign nav_item_css_class = "selected" />
			</#if>
			
			<#assign nav_item_parent_first_css = ""/>
			<#assign nav_item_parent_last_css = ""/>
			
			<#if parentfirst>
				<#assign parentfirst=false/>
				<#assign nav_item_parent_first_css = "firstli"/>
			</#if>
			
			<#if !(nav_item_has_next)>
				<#assign nav_item_parent_last_css = "lastli"/>
			</#if>
			

			<li ${nav_item_attr_selected} class="${nav_item_css_class} ${nav_item_parent_first_css} ${nav_item_parent_last_css}" id="layout_${nav_item.getLayoutId()}" role="presentation">
				<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span>${nav_item.icon()} ${nav_item.getName()}</span></a>

				<#if nav_item.hasChildren()>
					<ul class="child-menu" role="menu">
					
					<#assign i = 0/>
					
						<#list nav_item.getChildren() as nav_child>
							<#assign nav_child_attr_selected = "" />
							<#assign nav_child_css_class = "" />

							<#if nav_item.isSelected()>
								<#assign nav_child_attr_selected = "aria-selected='true'" />
								<#assign nav_child_css_class = "selected" />
							</#if>

							<#assign nav_item_child_first_css = ""/>
							<#assign nav_item_child_last_css = ""/>
							
							<#if (i == 0)>
								<#assign nav_item_child_first_css = "firstli"/>
							</#if>
							
							<#if (!(nav_child_has_next) && (i > 0))>
								<#assign nav_item_child_last_css = "lastli"/>
							</#if>
							
							<li ${nav_child_attr_selected} class="${nav_child_css_class} ${nav_item_child_first_css} ${nav_item_child_last_css}" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
							</li>
							
							<#assign i = i + 1/>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
	</ul>
</nav>