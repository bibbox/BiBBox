AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
	}
);
AUI().use(
		  'aui-toggler',
		  function(A) {
		    new A.Toggler(
		      {
		        container: '#bbmri-eric-member-area-top-toggler-xyz',
		        content: '.bbmri-eric-member-area-top-area-expand',
		        expanded: false,
		        header: '.bbmri-eric-member-area-top-area-not-expand-container-toggle'
		      }
		    );
		  }
		);