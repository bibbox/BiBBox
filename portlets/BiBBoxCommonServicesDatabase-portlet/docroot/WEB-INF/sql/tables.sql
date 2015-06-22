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
	position VARCHAR(75) null,
	key_ VARCHAR(75) null,
	image VARCHAR(75) null,
	elementcolor VARCHAR(75) null
);

create table bibboxcs.symbolconfiguration (
	symbolconfigurationId LONG not null primary key,
	scope VARCHAR(75) null,
	eventtype VARCHAR(75) null,
	basecolor VARCHAR(75) null,
	symboltype VARCHAR(75) null
);

create table bibboxcs.symboltypeconfiguration (
	symboltypeconfigurationId LONG not null primary key,
	symboltype VARCHAR(75) null,
	template TEXT null,
	symboliconconfiguration VARCHAR(75) null
);