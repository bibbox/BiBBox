create table bibboxcs.biobankpanelassessment (
	biobankpanelassessmentId LONG not null primary key,
	organizationId LONG,
	userId LONG,
	reviewer VARCHAR(75) null,
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

create table rdconnect.diseasematrix (
	diseasematrixId LONG not null primary key,
	organizationId LONG,
	diseasename TEXT null,
	patientcount TEXT null,
	gene TEXT null,
	orphanumber TEXT null,
	icd10 TEXT null,
	omim TEXT null,
	synonym TEXT null,
	modifieddate DATE null
);

create table rdconnect.generalgnformation (
	generalinformationId LONG not null primary key,
	organizationId LONG,
	acronym TEXT null,
	description TEXT null,
	hosteinstitue TEXT null,
	typeofhosteinstitue TEXT null,
	sourceoffunding TEXT null,
	country TEXT null,
	targetpopulation TEXT null,
	yearofestablishment TEXT null,
	howmanyrdsareintheregistrybiobank TEXT null,
	percentageofrarediseasesinyourregistrybiobank TEXT null,
	ontologies TEXT null,
	biomaterialcollected TEXT null,
	biomaterialprepared TEXT null,
	origionofcollection TEXT null,
	useofcollection TEXT null,
	associateddataavailable TEXT null,
	imagingavailable TEXT null,
	theregistrybiobanksislistedinotherinventoriesnetworks TEXT null,
	modifieddate DATE null
);

create table rdconnect.networks (
	networkId LONG not null primary key,
	organizationnetworkId LONG,
	organizationId LONG,
	relation VARCHAR(75) null,
	yearofestablishment VARCHAR(75) null
);