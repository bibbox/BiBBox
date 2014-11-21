create table biobank (
	biobankDbId LONG not null primary key,
	biobankId VARCHAR(75) null,
	acronym VARCHAR(75) null,
	url VARCHAR(75) null,
	juristicPersonId LONG,
	countryCode VARCHAR(75) null,
	description VARCHAR(75) null,
	backup BOOLEAN,
	trainingCourses BOOLEAN
);

create table biobankattributelists (
	biobankAttributeListsId LONG not null primary key,
	biobankDbId LONG,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table biobankattributelistsmaster (
	biobankAttributeListsMasterId LONG not null primary key,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table biobankcontact (
	biobankDbId LONG not null,
	contactId LONG not null,
	primary key (biobankDbId, contactId)
);

create table contact (
	contactId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	zip VARCHAR(75) null,
	city VARCHAR(75) null,
	countryCode VARCHAR(75) null,
	juristicPersonId LONG,
	department VARCHAR(75) null,
	orcId VARCHAR(75) null
);

create table country (
	countryCode VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table juristicperson (
	juristicPersonId LONG not null primary key,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	address VARCHAR(75) null
);