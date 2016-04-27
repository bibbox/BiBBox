create table saat_code_icd10 (
	icd10Id LONG not null primary key,
	code_ VARCHAR(255) null,
	description TEXT null,
	INKLUSIVA TEXT null,
	EXKLUSIVA TEXT null,
	TYPE TEXT null,
	USED DOUBLE,
	FROM_CODE TEXT null,
	TO_CODE TEXT null
);

create table saat_code_icdo3 (
	icdo3Id LONG not null primary key,
	code_ VARCHAR(255) null,
	term INTEGER,
	sui INTEGER,
	typ TEXT null,
	use_ TEXT null,
	description TEXT null,
	localisation TEXT null,
	link TEXT null,
	exklusiva TEXT null,
	hint TEXT null
);

create table saat_code_scg (
	scgId LONG not null primary key,
	code_ VARCHAR(255) null,
	description TEXT null
);

create table saat_dictionary (
	dictionaryId LONG not null primary key,
	synonym VARCHAR(255) null,
	before_synonym INTEGER,
	after_synonym INTEGER,
	foreword BOOLEAN,
	ending BOOLEAN,
	sentence BOOLEAN,
	iscode BOOLEAN,
	pattern VARCHAR(255) null,
	code_typ VARCHAR(75) null,
	code_value VARCHAR(75) null,
	root BOOLEAN,
	negation BOOLEAN,
	occur BOOLEAN,
	disease_ids TEXT null,
	dirty BOOLEAN,
	priority INTEGER,
	disease_ids_count INTEGER,
	priority_mode BOOLEAN
);

create table saat_dictionary_dictionary_addiction_link (
	dictionary_dictionary_addiction_linkId LONG not null primary key,
	dictionaryId LONG,
	addictionId LONG
);