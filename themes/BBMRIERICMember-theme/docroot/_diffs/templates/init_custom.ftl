<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign layoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.service.LayoutLocalService")  />
<#assign all_nav_items = layoutLocalServiceUtil.getLayouts(layout.getGroupId(),false)  />
<#assign wronge_all_nav_items = theme_display.getLayouts() />
<#assign mysiteslist = themeDisplay.getUser().getMySites() />