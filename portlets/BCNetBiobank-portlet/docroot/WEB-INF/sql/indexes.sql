create index IX_A81162A on biobankattributelists (biobankDbId);
create index IX_6DA6C50B on biobankattributelists (biobankDbId, attributeListName);
create index IX_56503876 on biobankattributelists (biobankDbId, attributeListName, attributeListValue);
create index IX_C703384C on biobankattributelists (biobankId);
create index IX_4FDBDBA9 on biobankattributelists (biobankId, attributeListName);
create index IX_F785D414 on biobankattributelists (biobankId, attributeListName, attributeListValue);

create index IX_62815FF0 on biobankattributelistsmaster (attributeListName);
create index IX_8C07D432 on biobankattributelistsmaster (attributeName);