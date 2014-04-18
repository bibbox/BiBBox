
		<#list nav_items as nav_item>
			
				<#list nav_item.getChildren() as nav_child>
					<#assign nav_child_child_is_selected = false />
					<#assign nav_child_child_has_elements = false />
						<#list nav_child.getChildren() as nav_child_child>
							<#assign nav_child_attr_selected = "" />
							<#assign nav_child_css_class = "" />
							<#assign nav_child_child_has_elements = true />
		
							<#if nav_child_child.isSelected()>
								<#assign nav_child_child_is_selected = true />
								<#assign nav_child_attr_selected = "aria-selected='true'" />
								<#assign nav_child_css_class = "selected" />
							</#if>
						</#list>
					<#if nav_child_child_has_elements>
						<#if nav_child.isSelected() || nav_child_child_is_selected>
							<div class="bbmri_eric_header-subsubmainmenu">
								<div class="bbmri_eric_header-subsubmainmenu-position">
									<div class="bbmri_eric_header-subsubmainmenu-floating">
										<nav class="${nav_css_class}" id="navigation" role="navigation">
											<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
												<#list nav_child.getChildren() as nav_child_child>
													<#assign nav_child_attr_selected = "" />
													<#assign nav_child_css_class = "" />
								
													<#if nav_child_child.isSelected()>
														<#assign nav_child_attr_selected = "aria-selected='true'" />
														<#assign nav_child_css_class = "selected" />
													</#if>
													<#if nav_child_child.getName()?contains("BBMRI.")>
														<li ${nav_item_attr_selected} class="${nav_item_css_class} " id="layout_${nav_item.getLayoutId()}" role="presentation">
															<a class="tooltips" aria-labelledby="layout_${nav_child_child.getLayoutId()}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
																<img style="height:15px;" id='countryflag' src="http://www.geonames.org/flags/x/${nav_child_child.getName()?substring(6, 8)?lower_case}.gif" height="15px" />
																<div class="bbmrieric-tooltip-div">
																	<img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/NationalNodesSymbol.png" >
																	<div class="bbmrieric-tooltip-short">${nav_child_child.getName()}</div>
																	<div class="bbmrieric-tooltip-long">${nav_child_child.getLayout().getExpandoBridge().getAttribute("BBMRIERICNodeDescription")}</div>
																</div>
															</a>
														</li>
													<#elseif nav_child_child.getName()?contains("GERMAN BIOBANK NODE")>
														<li ${nav_item_attr_selected} class="${nav_item_css_class} " id="layout_${nav_item.getLayoutId()}" role="presentation">
															<a class="tooltips" aria-labelledby="layout_${nav_child_child.getLayoutId()}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
																<img style="height:15px;" id='countryflag' src="http://www.geonames.org/flags/x/de.gif"  height="15px" />
																<div class="bbmrieric-tooltip-div">
																	<img class="bbmrieric-tooltip-image" height="30px" width="30px" src="/BBMRIERIC-theme/images/NationalNodesSymbol.png" >
																	<div class="bbmrieric-tooltip-short">${nav_child_child.getName()}</div>
																	<div class="bbmrieric-tooltip-long">${nav_child_child.getLayout().getExpandoBridge().getAttribute("BBMRIERICNodeDescription")}</div>
																</div>
															</a>
														</li>
													<#else>
														<li ${nav_item_attr_selected} class="${nav_item_css_class} " id="layout_${nav_item.getLayoutId()}" role="presentation">
															<a aria-labelledby="layout_${nav_child_child.getLayoutId()}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">${nav_child_child.getName()}</a>
														</li>
													</#if>
												</#list>
											</ul>
										</nav>
									</div>
								</div>
							</div>
						</#if>
					</#if>
				</#list>
		</#list>