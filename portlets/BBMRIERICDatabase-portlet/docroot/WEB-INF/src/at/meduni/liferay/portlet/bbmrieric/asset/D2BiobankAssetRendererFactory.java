package at.meduni.liferay.portlet.bbmrieric.asset;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.permission.D2BiobankPermission;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class D2BiobankAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = D2Biobank.class.getName();
    public static final String TYPE = "d2biobank";
    private static final boolean _LINKABLE = true;
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		D2Biobank d2biobank = D2BiobankLocalServiceUtil.getD2Biobank(classPK);
		return new D2BiobankAssetRenderer(d2biobank);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
    public boolean isLinkable() {
            return _LINKABLE;
    }
	
	@Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {
		return D2BiobankPermission.contains(permissionChecker, classPK, actionId);
    }

}
