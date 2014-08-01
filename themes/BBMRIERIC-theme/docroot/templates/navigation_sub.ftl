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
               
               <#if nav_child.getName()?contains("BBMRI.")>
                  <#if first>
                     <li style="width: 25px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 4px;padding-right: 4px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/${nav_child.getName()?substring(6, 8)?lower_case}.gif" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/NationalNodesSymbol.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long">${nav_child.getLayout().getExpandoBridge().getAttribute("BBMRIERICNodeCountry")}</div>
                        </div>
                     </a>
                  </li>
               <#elseif nav_child.getName()?contains("splitter")>
               		<li style="padding-left: 3px;padding-right: 3px;font-weight:bold;margin-top:1px;">|</li>
               <#elseif nav_child.getName()?contains("GERMAN BIOBANK NODE")>
                  <#if first>
                     <li style="width: 25px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 4px;padding-right: 4px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/de.gif" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/NationalNodesSymbol.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long">${nav_child.getLayout().getExpandoBridge().getAttribute("BBMRIERICNodeCountry")}</div>
                        </div>
                     </a>
                  </li>
               <#elseif nav_child.getName()?contains("Common Service IT")>
                  <#if first>
                     <li style="width: 25px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 4px;padding-right: 4px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/itFlag.png" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/itIcon.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long"></div>
                        </div>
                     </a>
                  </li>
                  <#elseif nav_child.getName()?contains("IARC")>
                  <#if first>
                     <li style="width: 25px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 4px;padding-right: 4px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/iarc-logo.png" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/NationalNodesSymbol.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long"></div>
                        </div>
                     </a>
                  </li>
               <#elseif nav_child.getName()?contains("Central Executive Management Office")>
                  <#if first>
                     <li style="width: 20px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 30px;padding-right: 5px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/hqFlag.png" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/hqIcon.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long"></div>
                        </div>
                     </a>
                  </li>
               <#elseif nav_child.getName()?contains("Common Service ELSI")>
                  <#if first>
                     <li style="width: 20px;padding: 0;">&nbsp;</li>
                     <#assign first = false />
                  </#if>
                  <li style="padding-left: 10px;padding-right: 5px;" ${nav_child_attr_selected} class="${nav_child_css_class} " id="layout_${nav_child.getLayoutId()}" role="presentation">
                     <a class="tooltips" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
                        <img style="height:15px;" id='countryflag' src="/BBMRIERIC-theme/images/elsiFlag.png" height="15px" />
                        <div class="bbmrieric-tooltip-div">
                           <img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/elsiIcon.png" >
                           <div class="bbmrieric-tooltip-short">${nav_child.getName()}</div>
                           <div class="bbmrieric-tooltip-long"></div>
                        </div>
                     </a>
                  </li>
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