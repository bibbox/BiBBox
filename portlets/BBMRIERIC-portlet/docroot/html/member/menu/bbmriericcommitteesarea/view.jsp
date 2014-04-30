<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys"%>

<portlet:defineObjects />


<%
	List<Group> groups = themeDisplay.getUser().getMySiteGroups();

	int number_of_groups = 0;
	if (groups.size() <= 4) {
		number_of_groups = 4;
	} else if (groups.size() > 4 && groups.size() <= 8) {
		number_of_groups = 8;
	} else if (groups.size() > 8 && groups.size() <= 24) {
		number_of_groups = 24;
	} else if (groups.size() > 24) {
		number_of_groups = 100;
	}

	String committees = "";

	for (Group group : groups) {
		String url = themeDisplay.getURLPortal()
	            + group.getPathFriendlyURL(false, themeDisplay)
	            + group.getFriendlyURL();
		String short_title = group.getExpandoBridge().getAttribute("Short Name").toString();
		String long_title = group.getDescriptiveName();
		if (number_of_groups == 4) {
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4\">";
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-icon\">";
			   String editroleimgpath = request.getContextPath() + "/images/person-icon.png";
			   committees += "<img id=\"committeelogo\" alt=\"committeelogo\" src=\"" + request.getContextPath() + "/images/committees_big.png\" width=\"50px\" height=\"50px\" />";
			   committees += "</div>";
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-text\">";
			   committees += "<span class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-text-short\"><a href=\"" + url + "\">" + short_title + "</a></span><br>";
			   committees += "<span class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-text-long\"><a href=\"" + url + "\">" + long_title + "</a></span>";
			   committees += "</div>";
			   committees += "</div>";
		}
		if (number_of_groups == 8) {
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-8\">";
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-8-icon\">";
            String editroleimgpath = request.getContextPath() + "/images/person-icon.png";
            committees += "<img id=\"committeelogo\" alt=\"committeelogo\" src=\"" + request.getContextPath() + "/images/committees_big.png\" width=\"30px\" height=\"35px\" />";
            committees += "</div>";
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-8-text\">";
            committees += "<span class=\"bbmri-eric-member-area-top-area-expand-container-committees-8-text-short\"><a href=\"" + url + "\">" + short_title + "</a></span><br>";
            committees += "<span class=\"bbmri-eric-member-area-top-area-expand-container-committees-8-text-long\"><a href=\"" + url + "\">" + long_title + "</a></span>";
            committees += "</div>";
            committees += "</div>";
      }
		if (number_of_groups == 24) {
			   if(short_title.length() == 0) {
				   short_title = long_title;
			   }
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-24\">";
            committees += "<a href=\"" + url + "\">" + short_title + "</a>";
            committees += "</div>";
      }
		
	}
	for(int i=groups.size(); i < number_of_groups; i++) {
		if (number_of_groups == 4) {
			committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4\"></div>";
		}
		if (number_of_groups == 8) {
			committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-8\"></div>";
		}
		if (number_of_groups == 24) {
			committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-24\"></div>";
		}
	}
%>
<%= committees %>