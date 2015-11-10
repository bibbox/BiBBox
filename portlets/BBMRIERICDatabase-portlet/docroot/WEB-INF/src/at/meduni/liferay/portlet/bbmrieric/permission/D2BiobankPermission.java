package at.meduni.liferay.portlet.bbmrieric.permission;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class D2BiobankPermission {
	public static void check(PermissionChecker permissionChecker, long guestbookId, String actionId) throws PortalException, SystemException {

        if (!contains(permissionChecker, guestbookId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker, long biobankId, String actionId) throws PortalException, SystemException {

        D2Biobank biobank = D2BiobankLocalServiceUtil.getD2Biobank(biobankId);

        return permissionChecker.hasPermission(biobank.getGroupId(), D2Biobank.class.getName(), biobank.getBiobankId(), actionId);

    }
}
