create table rdconnect.idcardapilog (
	idcardapilogId LONG not null primary key,
	userId LONG,
	ipaddress VARCHAR(75) null,
	accessDate DATE null,
	requestparameter VARCHAR(75) null
);