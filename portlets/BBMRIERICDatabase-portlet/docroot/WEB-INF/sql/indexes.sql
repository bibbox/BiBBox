create index IX_A686D336 on bbmrieric.biobank (UUID);
create index IX_5629EA4D on bbmrieric.biobank (biobankcountry);
create index IX_446FCBE1 on bbmrieric.biobank (ldapbiobankID);

create index IX_E37156D4 on bbmrieric.diseasediscription (diseasecode);
create index IX_64144B9C on bbmrieric.diseasediscription (diseasegroup);
create index IX_CE49B53B on bbmrieric.diseasediscription (root);

create index IX_D4CB39C on bbmrieric.searchindex (UUID);
create index IX_5D2C4216 on bbmrieric.searchindex (organisationid);
create index IX_420D183F on bbmrieric.searchindex (organisationid, searchindexkey);
create index IX_B5F4E5E8 on bbmrieric.searchindex (searchindexvalue);
create index IX_8475E6D4 on bbmrieric.searchindex (value);