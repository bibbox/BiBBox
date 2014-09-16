create table bbmriat.organizationlink (
	organizationlinkId LONG not null primary key,
	parentorganizationId LONG,
	organizationId LONG
);