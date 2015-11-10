create index IX_A686D336 on bbmrieric.biobank (UUID);
create index IX_5629EA4D on bbmrieric.biobank (biobankcountry);
create index IX_446FCBE1 on bbmrieric.biobank (ldapbiobankID);

create index IX_5F232146 on bbmrieric.d2biobank (biobankName);
create index IX_90CB06CF on bbmrieric.d2biobank (companyId);
create index IX_E3B4F511 on bbmrieric.d2biobank (groupId);
create index IX_A3ACE80 on bbmrieric.d2biobank (groupId, bbmribiobankID);
create index IX_122BB1BE on bbmrieric.d2biobank (groupId, biobankId);
create index IX_3E83BAEE on bbmrieric.d2biobank (groupId, biobankName);
create index IX_CEB992F7 on bbmrieric.d2biobank (groupId, status);
create index IX_B16C4509 on bbmrieric.d2biobank (groupId, updateuuid);
create index IX_369AB3B1 on bbmrieric.d2biobank (updateuuid);
create index IX_BEF697DB on bbmrieric.d2biobank (uuid_);
create index IX_A647856D on bbmrieric.d2biobank (uuid_, companyId);
create unique index IX_A4DC832F on bbmrieric.d2biobank (uuid_, groupId);

create index IX_E37156D4 on bbmrieric.diseasediscription (diseasecode);
create index IX_64144B9C on bbmrieric.diseasediscription (diseasegroup);
create index IX_CE49B53B on bbmrieric.diseasediscription (root);

create index IX_D4CB39C on bbmrieric.searchindex (UUID);
create index IX_5D2C4216 on bbmrieric.searchindex (organisationid);
create index IX_420D183F on bbmrieric.searchindex (organisationid, searchindexkey);
create index IX_B5F4E5E8 on bbmrieric.searchindex (searchindexvalue);
create index IX_8475E6D4 on bbmrieric.searchindex (value);