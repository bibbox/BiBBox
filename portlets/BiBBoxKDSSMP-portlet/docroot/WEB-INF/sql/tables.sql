create table kdssmp.configuration (
	configurationId LONG not null primary key,
	scope VARCHAR(75) null,
	optionkey VARCHAR(75) null,
	optionvalue VARCHAR(75) null
);

create table kdssmp.event (
	eventId LONG not null primary key,
	patientId LONG,
	eventdate DATE null,
	eventtype VARCHAR(75) null
);

create table kdssmp.eventdata (
	eventdataId LONG not null primary key,
	eventlayoutId LONG,
	patientId LONG,
	ontology VARCHAR(75) null,
	value VARCHAR(75) null
);

create table kdssmp.patientnamegenerator (
	patientnamegeneratorId LONG not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null
);