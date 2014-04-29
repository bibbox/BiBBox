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
		if (number_of_groups == 4) {
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4\">";
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-icon\">";
			   String editroleimgpath = request.getContextPath() + "/images/person-icon.png";
			   committees += "<img id=\"committeelogo\" alt=\"committeelogo\" src=\"" + request.getContextPath() + "/images/committees_big.png\" width=\"50px\" height=\"50px\" />";
			   committees += "</div>";
			   committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-4-text\">";
			   committees += "<a href=\"" + url + "\">" + group.getDescriptiveName() + "</a>";
			   committees += "</div>";
			   committees += "</div>";
		}
		if (number_of_groups == 8) {
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-8\">";
            committees += "<a href=\"" + url + "\">" + group.getDescriptiveName() + "</a>";
            committees += "</div>";
      }
		if (number_of_groups == 24) {
            committees += "<div class=\"bbmri-eric-member-area-top-area-expand-container-committees-24\">";
            committees += "<a href=\"" + url + "\">" + group.getDescriptiveName() + "</a>";
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