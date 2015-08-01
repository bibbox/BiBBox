create table puchmuseum.fahrzeug (
	fahrzeugId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	typ VARCHAR(75) null
);

create table puchmuseum.person (
	personId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	vorname VARCHAR(75) null
);

create table puchmuseum.puchmuseumsobjekt (
	puchmuseumsobjectId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	objekttyp VARCHAR(75) null,
	objektid LONG,
	folder VARCHAR(75) null
);

create table puchmuseum.transaktion (
	transaktionId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	typ VARCHAR(75) null
);