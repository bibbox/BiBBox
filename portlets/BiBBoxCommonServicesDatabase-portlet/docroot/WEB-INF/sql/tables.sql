create table bibboxcs.ddlconfiguration (
	ddlconfigurationId LONG not null primary key,
	ddmstructureId LONG,
	fieldname VARCHAR(75) null,
	group_ VARCHAR(75) null,
	display BOOLEAN,
	viewscript TEXT null,
	displaytip TEXT null,
	viewtitlecss TEXT null,
	viewvaluecss TEXT null,
	columwidth LONG,
	editscript TEXT null,
	edittip TEXT null
);