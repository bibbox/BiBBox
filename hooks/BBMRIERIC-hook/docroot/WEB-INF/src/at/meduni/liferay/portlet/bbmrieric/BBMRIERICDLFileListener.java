package at.meduni.liferay.portlet.bbmrieric;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

public class BBMRIERICDLFileListener implements ModelListener<DLFileEntry> {
	
	private long companyId = 10154; // LocalTest default 10157 // server 10154
	private String[] fullAccess = {"ADD_DISCUSSION","DELETE","DELETE_DISCUSSION","OVERRIDE_CHECKOUT","PERMISSIONS","UPDATE","UPDATE_DISCUSSION","VIEW"};
	private String[] editAccess = {"DELETE","UPDATE","VIEW"};
	private String[] viewAccess = {"VIEW"};
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
			{ {"Guest"}, noAccess} // Guest
	};

	@Override
	public void onAfterAddAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("onAfterAddAssociation");
	}

	@Override
	public void onAfterCreate(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		for(int i=0; i < rolesacces.length; i++ ) {
			try {
				long roleId = RoleLocalServiceUtil.getRole(companyId,rolesacces[i][0][0]).getRoleId();
				String[] permissions = rolesacces[i][1];
				System.out.println(rolesacces[i][0][0] + ": " + roleId + " - " + permissions.toString());
				ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,DLFileEntry.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFileEntryId(), roleId, permissions);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void onAfterRemove(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterUpdate(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,DLFileEntry.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFileEntryId(), RoleLocalServiceUtil.getRole(companyId,"Owner").getRoleId(), noAccess);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
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
	public void onBeforeCreate(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBeforeRemove(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK,
			String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBeforeUpdate(DLFileEntry model) throws ModelListenerException {
		// TODO Auto-generated method stub
		
	}

}