create table rdconnect.event (
	eventId LONG not null primary key,
	eventdate DATE null,
	eventtype TEXT null,
	organizationId LONG,
	userId LONG,
	shorttext TEXT null,
	longtext_ TEXT null,
	link TEXT null,
	restricted TEXT null,
	notificationsend BOOLEAN
);

create table rdconnect.eventnotification (
	eventnotificationId LONG not null primary key,
	notificationtype VARCHAR(75) null,
	userId LONG,
	notificationselected BOOLEAN
);