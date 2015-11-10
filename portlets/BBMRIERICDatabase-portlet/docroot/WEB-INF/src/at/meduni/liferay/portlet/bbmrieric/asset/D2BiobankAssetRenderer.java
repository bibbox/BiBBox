package at.meduni.liferay.portlet.bbmrieric.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.permission.D2BiobankPermission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class D2BiobankAssetRenderer extends BaseAssetRenderer {
	
	private D2Biobank d2biobank_;
	
	public D2BiobankAssetRenderer(D2Biobank d2biobank) {
		d2biobank_ = d2biobank;
	}
	
	@Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {
            long d2biobankId = d2biobank_.getBiobankId();

            boolean contains = false;
            try {
                    contains = D2BiobankPermission.contains(permissionChecker,
                    		d2biobankId, ActionKeys.UPDATE);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }
			
            return contains;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {
            long d2biobankId = d2biobank_.getBiobankId();

            boolean contains = false;
            
            try {
                    contains = D2BiobankPermission.contains(permissionChecker,
                    		d2biobankId, ActionKeys.VIEW);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            return contains;
    }

	@Override
	public String getClassName() {
		return D2Biobank.class.getName();
	}

	@Override
	public long getClassPK() {
		return d2biobank_.getBiobankId();
	}

	@Override
	public long getGroupId() {
		return d2biobank_.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Biobank ID: " + d2biobank_.getBbmribiobankID();
	}

	@Override
	public String getTitle(Locale locale) {
		return d2biobank_.getBiobankName();
	}

	@Override
	public long getUserId() {
		return d2biobank_.getUserId();
	}

	@Override
	public String getUserName() {
		return "LDAP Importer";
	}

	@Override
	public String getUuid() {
		return d2biobank_.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse, String template) throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
            renderRequest.setAttribute("bbmrieric_d2biobank", d2biobank_);
            return "/html/idcard/biobank/" + template + ".jsp";
	    }
	    else {
	    	return null;
	    }
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
	        return themeDisplay.getURLPortal() + "/BBMRIERICDatabase-portlet/image/biobank_icon.png";
	}
	
	private Log _log;

}
