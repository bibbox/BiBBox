create table rdconnect.u_accessibility (
	coreid LONG not null primary key,
	organizationid LONG,
	fieldname TEXT null,
	value TEXT null
);

create table rdconnect.u_address (
	addressid LONG not null primary key,
	street1 VARCHAR(75) null,
	street2 VARCHAR(75) null,
	street3 VARCHAR(75) null,
	city VARCHAR(75) null,
	zip VARCHAR(75) null,
	regionid LONG,
	contryid LONG,
	typeid LONG,
	mailing BOOLEAN,
	primary_ad BOOLEAN,
	organizationid LONG
);

create table rdconnect.u_core (
	coreid LONG not null primary key,
	organizationid LONG,
	fieldname TEXT null,
	value TEXT null
);

create table rdconnect.u_quality (
	coreid LONG not null primary key,
	organizationid LONG,
	fieldname TEXT null,
	value TEXT null
);