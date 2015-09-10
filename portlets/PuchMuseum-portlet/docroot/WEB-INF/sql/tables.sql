create table puchmuseum.configuration (
	configurationId LONG not null primary key,
	scope VARCHAR(75) null,
	optionkey TEXT null,
	optionvalue TEXT null
);

create table puchmuseum.fahrzeug (
	fahrzeugId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	typ VARCHAR(75) null
);

create table puchmuseum.objectdata (
	objectdataId LONG not null primary key,
	puchmuseumsobjectId LONG,
	objectkey TEXT null,
	objectvalue TEXT null
);

create table puchmuseum.objectimage (
	objectimageId LONG not null primary key,
	puchmuseumsobjectId LONG,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	dlappimagerawId LONG,
	dlappimageprocessedId LONG,
	dlappimagewebId LONG
);

create table puchmuseum.parameterconfiguration (
	parameterconfigurationId LONG not null primary key,
	displaynameshort TEXT null,
	displaynamelong TEXT null,
	datatype VARCHAR(75) null,
	group_ VARCHAR(75) null,
	tab TEXT null,
	summery BOOLEAN,
	viewscript TEXT null,
	viewvisible BOOLEAN,
	viewtip TEXT null,
	viewtitlecss TEXT null,
	viewvaluecss TEXT null,
	viewcss TEXT null,
	editscript TEXT null,
	editvisible BOOLEAN,
	edittip TEXT null,
	edittitlecss TEXT null,
	editvaluecss TEXT null,
	editcss TEXT null,
	editcolumnwidth LONG
);

create table puchmuseum.parameteroptionsconfiguration (
	parameteroptionsconfigurationId LONG not null primary key,
	parameterconfigurationId LONG,
	optionkey TEXT null,
	optionvalue TEXT null
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
	folder LONG
);

create table puchmuseum.transaktion (
	transaktionId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	typ VARCHAR(75) null,
	puchmuseumsobjectId LONG,
	startDate DATE null,
	endDate DATE null
);

create table puchmuseum.transaktiondata (
	transaktiondataId LONG not null primary key,
	puchmuseumsobjectId LONG,
	transaktionId LONG,
	objectkey VARCHAR(75) null,
	objectvalue VARCHAR(75) null
);

create table puchmuseum_configuration (
	configurationId LONG not null primary key,
	scope VARCHAR(75) null,
	optionkey TEXT null,
	optionvalue TEXT null
);

create table puchmuseum_objectdata (
	objectdataId LONG not null primary key,
	puchmuseumsobjectId LONG,
	objectkey TEXT null,
	objectvalue TEXT null
);

create table puchmuseum_objectimage (
	objectimageId LONG not null primary key,
	puchmuseumsobjectId LONG,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	dlappimagerawId LONG,
	dlappimageprocessedId LONG,
	dlappimagewebId LONG
);

create table puchmuseum_parameterconfiguration (
	parameterconfigurationId LONG not null primary key,
	displaynameshort TEXT null,
	displaynamelong TEXT null,
	datatype VARCHAR(75) null,
	group_ VARCHAR(75) null,
	tab TEXT null,
	summery BOOLEAN,
	viewscript TEXT null,
	viewvisible BOOLEAN,
	viewtip TEXT null,
	viewtitlecss TEXT null,
	viewvaluecss TEXT null,
	viewcss TEXT null,
	editscript TEXT null,
	editvisible BOOLEAN,
	edittip TEXT null,
	edittitlecss TEXT null,
	editvaluecss TEXT null,
	editcss TEXT null,
	editcolumnwidth LONG
);

create table puchmuseum_parameteroptionsconfiguration (
	parameteroptionsconfigurationId LONG not null primary key,
	parameterconfigurationId LONG,
	optionkey TEXT null,
	optionvalue TEXT null
);

create table puchmuseum_person (
	personId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	vorname VARCHAR(75) null
);

create table puchmuseum_puchmuseumsobjekt (
	puchmuseumsobjectId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	objekttyp VARCHAR(75) null,
	objektid LONG,
	folder LONG
);

create table puchmuseum_transaktion (
	transaktionId LONG not null primary key,
	createrUserId LONG,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedDate DATE null,
	typ VARCHAR(75) null,
	puchmuseumsobjectId LONG,
	startDate DATE null,
	endDate DATE null
);

create table puchmuseum_transaktiondata (
	transaktiondataId LONG not null primary key,
	puchmuseumsobjectId LONG,
	transaktionId LONG,
	objectkey VARCHAR(75) null,
	objectvalue VARCHAR(75) null
);