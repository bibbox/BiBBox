create table kdssmp.arameterconfiguration (
	parameterconfigurationId LONG not null primary key,
	displayname VARCHAR(75) null,
	datatype VARCHAR(75) null,
	valuerange VARCHAR(75) null,
	displayoptions VARCHAR(75) null,
	visible VARCHAR(75) null,
	computed VARCHAR(75) null,
	confirmationscript VARCHAR(75) null
);

create table kdssmp.arameteroptions (
	parameteroptionsId LONG not null primary key,
	option_ VARCHAR(75) null,
	value VARCHAR(75) null
);

create table kdssmp.configuration (
	configurationId LONG not null primary key,
	scope TEXT null,
	optionkey TEXT null,
	optionvalue TEXT null
);

create table kdssmp.event (
	eventId LONG not null primary key,
	patientId LONG,
	layoutId LONG,
	eventdate DATE null,
	eventtype VARCHAR(75) null
);

create table kdssmp.eventdata (
	eventdataId LONG not null primary key,
	eventId LONG,
	patientId LONG,
	ontology TEXT null,
	value TEXT null
);

create table kdssmp.parameterconfiguration (
	parameterconfigurationId LONG not null primary key,
	displayname VARCHAR(75) null,
	datatype VARCHAR(75) null,
	valuerange VARCHAR(75) null,
	displayoptions VARCHAR(75) null,
	visible BOOLEAN,
	computed BOOLEAN,
	confirmationscript TEXT null,
	grouping TEXT null
);

create table kdssmp.parameteroptions (
	parameteroptionsId LONG not null primary key,
	parameterconfigurationId LONG,
	option_ VARCHAR(75) null,
	value VARCHAR(75) null
);

create table kdssmp.patient (
	patientId LONG not null primary key,
	organizationId LONG,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	gender VARCHAR(75) null,
	dateofbirth DATE null,
	dateofdeath DATE null
);

create table kdssmp.patientnamegenerator (
	patientnamegeneratorId LONG not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table kdssmp.rules (
	ruleId LONG not null primary key,
	rule VARCHAR(75) null
);