create table rdconnect.event (
	eventId LONG not null primary key,
	eventdate DATE null,
	organizationId LONG,
	userId LONG,
	shorttext VARCHAR(75) null,
	longtext_ VARCHAR(75) null,
	link VARCHAR(75) null,
	restricted VARCHAR(75) null
);