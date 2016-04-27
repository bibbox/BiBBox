create table code_icd10 (
	id_ LONG not null primary key,
	code_ TEXT null,
	description TEXT null,
	INKLUSIVA VARCHAR(75) null,
	EXKLUSIVA VARCHAR(75) null,
	TYPE VARCHAR(75) null,
	USED DOUBLE,
	FROM_CODE VARCHAR(75) null,
	TO_CODE VARCHAR(75) null
);

create table code_icdo3 (
	id_ LONG not null primary key,
	code_ TEXT null,
	term INTEGER,
	sui INTEGER,
	typ VARCHAR(75) null,
	use_ VARCHAR(75) null,
	description TEXT null,
	localisation VARCHAR(75) null,
	link VARCHAR(75) null,
	exklusiva VARCHAR(75) null,
	hint VARCHAR(75) null
);

create table code_scg (
	id_ LONG not null primary key,
	code_ TEXT null,
	description TEXT null
);

create table dictionary2 (
	dictionary_id LONG not null primary key,
	synonym TEXT null,
	before_synonym INTEGER,
	after_synonym INTEGER,
	foreword BOOLEAN,
	ending BOOLEAN,
	sentence BOOLEAN,
	iscode BOOLEAN,
	pattern TEXT null,
	code_typ TEXT null,
	code_value TEXT null,
	root BOOLEAN,
	negation BOOLEAN,
	occur BOOLEAN,
	disease_ids TEXT null,
	dirty BOOLEAN,
	priority INTEGER,
	disease_ids_count INTEGER,
	priority_mode BOOLEAN
);

create table dictionary2_dictionary2_addiction_link (
	id_ LONG not null primary key,
	dictionary_id LONG,
	addiction_id LONG
);