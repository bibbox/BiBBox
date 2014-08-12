create table bibboxcs.invitation (
	invitationId LONG not null primary key,
	name VARCHAR(75) null,
	subject VARCHAR(75) null,
	body VARCHAR(75) null,
	status LONG,
	lastchanged DATE null,
	lastchanger LONG
);

create table bibboxcs.invitation_organisation (
	invitationOrganisationId LONG not null primary key,
	invitationId LONG,
	organisationId LONG,
	userId LONG,
	lastchanged DATE null,
	lastchanger LONG
);