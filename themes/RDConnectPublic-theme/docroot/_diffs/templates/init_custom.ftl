<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign isadmin = theme_display.getPermissionChecker().isCompanyAdmin() />
<#assign home = (tilesTitle == "welcome") />