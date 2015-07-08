create table bbmrieric.biobank (
	biobankId LONG not null primary key,
	organisationid LONG,
	ldapbiobankID TEXT null,
	biobankcountry TEXT null,
	biobankname TEXT null,
	biobanktype TEXT null,
	biobanksize TEXT null,
	biobankdescription VARCHAR(75) null,
	biobankjuristicperson TEXT null,
	UUID VARCHAR(75) null
);

create table bbmrieric.searchindex (
	searchid LONG not null primary key,
	organisationid LONG,
	locationid LONG,
	location TEXT null,
	searchindexkey TEXT null,
	searchindexvalue TEXT null,
	UUID VARCHAR(75) null
);