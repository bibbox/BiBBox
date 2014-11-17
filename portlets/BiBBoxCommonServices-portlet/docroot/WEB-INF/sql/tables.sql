create table bibboxcs.biobankpanelassessment (
	biobankpanelassessmentId LONG not null primary key,
	organizationId LONG,
	userId LONG,
	dateofassessment DATE null,
	background1_1 VARCHAR(75) null,
	background1_1_comments TEXT null,
	elsi1_2 VARCHAR(75) null,
	quality1_3 VARCHAR(75) null,
	quality1_3_comments TEXT null,
	cataloguemeetpurposes2_1 VARCHAR(75) null,
	adequateitplatform2_2 VARCHAR(75) null,
	addedvaluecatalogue2_3 VARCHAR(75) null,
	associateddata2_4 VARCHAR(75) null,
	associateddata2_4_comments TEXT null,
	reasonstoaccept3_1 TEXT null,
	recommendation3_2 TEXT null,
	needadditionalinformation3_3 TEXT null,
	finalrecommendation_4 TEXT null
);

create table bibboxcs.invitation (
	invitationId LONG not null primary key,
	name VARCHAR(75) null,
	subject VARCHAR(255) null,
	body TEXT null,
	status LONG,
	invitationsend DATE null,
	lastchanged DATE null,
	lastchanger LONG,
	filter VARCHAR(75) null
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
	securitytoken LONG,
	status LONG,
	statusdate DATE null
);