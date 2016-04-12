create table pw_Inventory (
	inventoryId LONG not null primary key,
	createDate DATE null,
	inventarnummer LONG,
	webcontentId LONG,
	folderId LONG,
	structureId VARCHAR(75) null,
	structuretemplateId VARCHAR(75) null
);