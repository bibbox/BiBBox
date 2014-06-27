package at.meduni.liferay.portlet.bbmrieric;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;

public class BBMRIERICDLFolderListener implements ModelListener<DLFolder>  {

	private long companyId = 10154; // LocalTest default 10157
	private String[] fullAccess = {"ACCESS","DELETE","ADD_DOCUMENT","ADD_SHORTCUT","PERMISSIONS","UPDATE","ADD_SUBFOLDER","VIEW"};
	private String[] editAccess = {"DELETE","UPDATE","VIEW","ACCESS","ADD_DOCUMENT","ADD_SUBFOLDER"};
	private String[] viewAccess = {"VIEW","ACCESS"};
	private String[] noAccess = {};
	private String[][][] rolesacces = {
			{ {"BBMRI-ERIC-HQ-WEBEDITOR"}, fullAccess}, // BBMRI-ERIC Headquarter - Webeditor
			{ {"BBMRI-ERIC Site Editor"}, editAccess}, // BBMRI-ERIC Site Editor
			{ {"Site Member"}, viewAccess}, // Site Member
			{ {"BBMRI ERIC Site Owner"}, noAccess}, // BBMRI ERIC Site Owner
			{ {"BBMRI-ERIC HQ-MEMBER"}, noAccess}, // BBMRI-ERIC Headquarter - Member
			{ {"BBMRI-ERIC Organization Editor"}, noAccess}, // BBMRI-ERIC Organization Editor	
			{ {"Organization Content Reviewer"}, noAccess}, // Organization Content Reviewer
			{ {"Portal Content Reviewer"}, noAccess}, // Portal Content Reviewer
			{ {"Site Content Reviewer"}, noAccess}, // Site Content Reviewer
			{ {"Organization User"}, noAccess}, // Organization User
			{ {"Owner"}, noAccess}, // Owner			
			{ {"BBMRI-ERIC Site Chair"}, noAccess}, // BBMRI-ERIC Site Chair
			{ {"BBMRI-ERIC Site Co-Chair"}, noAccess}, // BBMRI-ERIC Site Co-Chair
			{ {"National Node Director"}, noAccess}, // National Node Director
			{ {"Power User"}, noAccess}, // Power User
			{ {"User"}, noAccess}, // User
			{ {"Guest"}, {"ACCESS"}} // Guest
	};
	
	@Override
	public void onAfterAddAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAfterCreate(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		for(int i=0; i < rolesacces.length; i++ ) {
			try {
				long roleId = RoleLocalServiceUtil.getRole(companyId,rolesacces[i][0][0]).getRoleId();
				String[] permissions = rolesacces[i][1];
				System.out.println(rolesacces[i][0][0] + ": " + roleId + " - " + permissions.toString());
				ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,DLFolder.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFolderId(), roleId, permissions);	
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onAfterRemove(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAfterRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAfterUpdate(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,DLFolder.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFolderId(), RoleLocalServiceUtil.getRole(companyId,"Owner").getRoleId(), noAccess);
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onBeforeAddAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBeforeCreate(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBeforeRemove(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBeforeRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onBeforeUpdate(DLFolder model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

}
