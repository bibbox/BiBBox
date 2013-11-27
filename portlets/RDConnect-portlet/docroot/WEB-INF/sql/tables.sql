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
	url VARCHAR(255) null,
	contactperson TEXT null,
	candidatetype VARCHAR(75) null,
	subunitof VARCHAR(75) null,
	country VARCHAR(75) null,
	diseasescodes TEXT null,
	diseasesfreetext TEXT null,
	comment_ TEXT null,
	address TEXT null,
	date_ DATE null,
	searchurl VARCHAR(255) null,
	sourceId VARCHAR(75) null,
	mail VARCHAR(255) null,
	head TEXT null,
	submittername VARCHAR(255) null,
	submitteremail VARCHAR(255) null,
	validated BOOLEAN
);

create table rdconnect.master_candidate (
	masterCandidateId LONG not null primary key,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	contactperson VARCHAR(75) null,
	candidatetype VARCHAR(75) null,
	country VARCHAR(75) null,
	diseasescodes VARCHAR(75) null,
	diseasesfreetext VARCHAR(75) null,
	comment_ VARCHAR(75) null,
	address VARCHAR(75) null,
	date_ DATE null,
	mail VARCHAR(75) null,
	head VARCHAR(75) null
);

create table rdconnect.master_candidate_link_candidate (
	linkId LONG not null primary key,
	candidateId LONG,
	masterCandidateId LONG
);