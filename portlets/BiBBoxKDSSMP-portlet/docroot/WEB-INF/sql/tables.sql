create table kdssmp.eventdata (
	eventdataId LONG not null primary key,
	eventlayoutId LONG,
	ontology VARCHAR(75) null,
	value VARCHAR(75) null
);

create table kdssmp.patientnamegenerator (
	patientnamegeneratorId LONG not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null
);