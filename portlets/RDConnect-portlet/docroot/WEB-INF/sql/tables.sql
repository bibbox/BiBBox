create table rdconnect.aqr_rating (
	aqrId LONG not null primary key,
	accessability LONG,
	quality LONG,
	relevance LONG,
	masterCandidateId LONG,
	aqrrater VARCHAR(75) null,
	ratingtype VARCHAR(75) null
);

create table rdconnect.candidate (
	candidateId LONG not null primary key,
	source VARCHAR(75) null,
	name VARCHAR(255) null,
	url TEXT null,
	contactperson TEXT null,
	candidatetype VARCHAR(75) null,
	candidatesubtype VARCHAR(75) null,
	subunitof VARCHAR(75) null,
	country VARCHAR(75) null,
	diseasescodes TEXT null,
	diseasesfreetext TEXT null,
	comment_ TEXT null,
	address TEXT null,
	date_ DATE null,
	searchurl TEXT null,
	sourceId VARCHAR(75) null,
	mail VARCHAR(255) null,
	head TEXT null,
	coverage VARCHAR(75) null,
	network VARCHAR(255) null,
	submittername VARCHAR(75) null,
	submitteremail VARCHAR(255) null,
	validated BOOLEAN,
	accepted BOOLEAN,
	masterId LONG,
	state_ VARCHAR(75) null
);

create table rdconnect.master_candidate (
	masterCandidateId LONG not null primary key,
	name VARCHAR(255) null,
	url TEXT null,
	contactperson TEXT null,
	candidatetype VARCHAR(75) null,
	candidatesubtype VARCHAR(75) null,
	country VARCHAR(75) null,
	diseasescodes TEXT null,
	diseasesfreetext TEXT null,
	comment_ TEXT null,
	address TEXT null,
	date_ DATE null,
	mail VARCHAR(255) null,
	head TEXT null,
	groupid LONG,
	companyid LONG,
	organisationid LONG,
	joinId LONG,
	accepted BOOLEAN,
	state_ VARCHAR(75) null,
	diseasescodesauto VARCHAR(75) null
);

create table rdconnect.master_candidate_link_candidate (
	linkId LONG not null primary key,
	candidateId LONG,
	masterCandidateId LONG
);

create table rdconnect.searchindex_rdconnect (
	searchid LONG not null primary key,
	organisationid LONG,
	locationid LONG,
	location TEXT null,
	key_ TEXT null,
	value TEXT null
);