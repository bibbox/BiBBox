create table rdconnect.idcardapiupdate (
	idcardId LONG not null primary key,
	userId LONG,
	userip VARCHAR(75) null,
	logmsg VARCHAR(75) null,
	date_ DATE null
);