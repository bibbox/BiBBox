<nav class="${nav_css_class}" id="navigation" role="navigation">
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
	  <#assign first = true />
		<#list nav_items as sub_nav_item>
			<#if sub_nav_item.isSelected()>
				<#list sub_nav_item.getChildren() as nav_child>
					<#assign nav_child_attr_selected = "" />
					<#assign nav_child_css_class = "" />

					<#if nav_child.isSelected()>
						<#assign nav_child_attr_selected = "aria-selected='true'" />
						<#assign nav_child_css_class = "selected" />
					</#if>&nbsp;
               
               <#if  nav_child.getName()?contains("splitter")>
               		<li style="padding-left: 3px;padding-right: 3px;font-weight:bold;margin-top:1px;">|</li>
               <#else>
                  <#if first>
                     <#assign first = false />
                  </#if>
                  <#list nav_child.getChildren() as nav_child_child>
                     <#if nav_child_child.isSelected()>
                        <#assign nav_child_attr_selected = "aria-selected='true'" />
                        <#assign nav_child_css_class = "selected" />
                     </#if>
                  </#list>
   					<li ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
   						<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
   					    <!-- Dropdown Menue -->
   					    <ul>
   					    <#if nav_child.hasChildren()>
   					    	<li style="height: 10px;padding: 0;">&nbsp;</li>
   					    </#if>
   					    <#list nav_child.getChildren() as nav_child_child>
   					       <#assign nav_child_child_attr_selected = "" />
                         <#assign nav_child_child_css_class = "" />
                         <#assign nav_child_child_css_class_weight = "selected_weight_normal" />
                         <#if nav_child_child.isSelected()>
                            <#assign nav_child_child_attr_selected = "aria-selected='true'" />
                            <#assign nav_child_child_css_class = "selected" />
                            <#assign nav_child_child_css_class_weight = "selected_weight_bold" />
                         </#if>
   					       <li ${nav_child_child_attr_selected} class="${nav_child_child_css_class} " id="layout_${nav_child_child.getLayoutId()}" role="presentation">
   					          <a class="${nav_child_child_css_class_weight}" aria-labelledby="layout_${nav_child_child.getLayoutId()}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">${nav_child_child.getName()}</a>
   					       </li>
   					    </#list>
   					    <#if nav_child.hasChildren()>
   					    	<li style="height: 10px;padding: 0;">&nbsp;</li>
   					    </#if>
   					    </ul>
   					</li>
					</#if>
				</#list>
			</#if>
		</#list>
		<li style="width: 5px;padding: 0;">&nbsp;</li>
	</ul>
</nav>