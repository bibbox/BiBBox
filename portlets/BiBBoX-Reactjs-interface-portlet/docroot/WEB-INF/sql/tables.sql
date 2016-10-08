create table reactjsservice_ToolInformation (
	toolInformationId LONG not null primary key,
	gitUUID VARCHAR(75) null,
	logourl VARCHAR(75) null,
	name VARCHAR(75) null,
	category VARCHAR(75) null,
	company VARCHAR(75) null,
	demourl VARCHAR(75) null,
	downloadurl VARCHAR(75) null,
	toolId VARCHAR(75) null,
	platform VARCHAR(75) null,
	license VARCHAR(75) null,
	description VARCHAR(75) null
);