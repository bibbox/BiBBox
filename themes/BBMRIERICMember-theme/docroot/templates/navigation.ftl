<!--<nav class="${nav_css_class}" id="navigation" role="navigation">-->
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" style="margin-right: 40px;">
		<#if site_name?matches("Intranet")>
		<#else>
			<li role="presentation">
				<a href="/web/home/media-center" role="menuitem">
					<div style="float: left;">
					<div class="bbmri-eric-square-blue"></div>
					<div style="float: left;">Download Centre</div>
					</div>
				</a>
			</li>
			<li role="presentation">
				<a href="/web/home/internal-meetings" role="menuitem">
					<div style="float: left;">
					<div class="bbmri-eric-square-blue"></div>
					<div style="float: left;">Internal and Public Meetings</div>
					</div>
				</a>
			</li>
			<li>
				<div style="float: left;">|</div>
			</li>
		</#if>
		<#list nav_items as nav_item>
			<#assign nav_item_attr_has_popup = "" />
			<#assign nav_item_attr_selected = "" />
			<#assign nav_item_css_class = "" />

			<#if nav_item.isSelected()>
				<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
				<#assign nav_item_attr_selected = "aria-selected='true'" />
				<#assign nav_item_css_class = "selected" />
			</#if>

			<li ${nav_item_attr_selected} class="${nav_item_css_class} " id="layout_${nav_item.getLayoutId()}" role="presentation">
				<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
				<div style="float: left;">
				<#if nav_item.isSelected()>
					<div class="bbmri-eric-square-orange"></div>
				<#else>
					<div class="bbmri-eric-square-blue"></div>
				</#if>
				<div style="float: left;">${nav_item.icon()} ${nav_item.getName()}</div>
				</div></a>
			</li>
		</#list>
	</ul>
<!--</nav>-->