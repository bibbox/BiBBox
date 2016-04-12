create table bibboxcs.ddlconfiguration (
	ddlconfigurationId LONG not null primary key,
	ddmstructureId LONG,
	fieldname VARCHAR(75) null,
	group_ VARCHAR(75) null,
	display BOOLEAN,
	viewscript TEXT null,
	displaytip TEXT null,
	viewtitlecss TEXT null,
	viewvaluecss TEXT null,
	columwidth LONG,
	editscript TEXT null,
	edittip TEXT null
);

create table bibboxcs.iconconfiguration (
	iconconfigurationId LONG not null primary key,
	symbolconfigurationId LONG,
	position TEXT null,
	key_ TEXT null,
	iconsId LONG,
	elementcolor TEXT null,
	width TEXT null,
	height TEXT null
);

create table bibboxcs.icons (
	iconsId LONG not null primary key,
	iconurl TEXT null,
	group_ VARCHAR(75) null
);

create table bibboxcs.symbolconfiguration (
	symbolconfigurationId LONG not null primary key,
	scope TEXT null,
	eventtype VARCHAR(75) null,
	basecolor VARCHAR(75) null,
	symboltype VARCHAR(75) null
);

create table bibboxcs.symboltypeconfiguration (
	symboltypeconfigurationId LONG not null primary key,
	symboltype VARCHAR(75) null,
	template TEXT null,
	symboliconconfiguration VARCHAR(75) null,
	symboldiscription VARCHAR(75) null
);

create table ontologies.gene (
	geneId LONG not null primary key,
	orphanetdisorderId LONG,
	symbol TEXT null,
	description TEXT null,
	geneorphanumber LONG,
	genetype LONG,
	genetypeorphanumber LONG,
	genetypename VARCHAR(75) null,
	disordergeneassociationtype LONG,
	disordergeneassociationtypename TEXT null,
	disordergeneassociationstatus LONG,
	disordergeneassociationstatusname TEXT null
);

create table ontologies.genelocus (
	genelocusId LONG not null primary key,
	geneId LONG,
	genelocus TEXT null,
	genelocuskey TEXT null
);

create table ontologies.genereference (
	genereferenceId LONG not null primary key,
	geneId LONG,
	source VARCHAR(75) null,
	reference VARCHAR(75) null
);

create table ontologies.genesynonym (
	genesynonymId LONG not null primary key,
	geneId LONG,
	synonym TEXT null
);

create table ontologies.orphanetdisorder (
	orphanetdisorderId LONG not null primary key,
	orphanumber LONG,
	orpahnetlink TEXT null,
	diseasename TEXT null
);

create table ontologies.orphanetreference (
	orphanetreferenceId LONG not null primary key,
	orphanetdisorderId LONG,
	source TEXT null,
	reference TEXT null,
	disordermappingrelation LONG,
	disordermappingrelationorphanumber LONG,
	disordermappingrelationname TEXT null,
	disordermappingicdrelation LONG,
	disordermappingicdrelationorphanumber LONG,
	disordermappingicdrelationname TEXT null,
	disordermappingvalidationstatus LONG,
	disordermappingvalidationstatusorphanumber LONG,
	disordermappingvalidationstatusname TEXT null
);

create table ontologies.orphanetsynonym (
	orphanetsynonymId LONG not null primary key,
	orphanetdisorderId LONG,
	synonym TEXT null
);

create table rdconnect.searchindex_rdconnect (
	searchid LONG not null primary key,
	organisationid LONG,
	locationid LONG,
	location TEXT null,
	key_ TEXT null,
	value TEXT null
);