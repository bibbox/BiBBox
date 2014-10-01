create table bibboxcs.invitation (
	invitationId LONG not null primary key,
	name VARCHAR(75) null,
	subject VARCHAR(255) null,
	body TEXT null,
	status LONG,
	invitationsend DATE null,
	lastchanged DATE null,
	lastchanger LONG
);

create table bibboxcs.invitation_organisation (
	invitationOrganisationId LONG not null primary key,
	invitationId LONG,
	organisationId LONG,
	userId LONG,
	lastchanged DATE null,
	lastchanger LONG,
	reactdate DATE null,
	lastusedlink DATE null,
	rejectdate DATE null,
	securitylinktoken LONG,
	securitytoken LONG
);