create index IX_A686D336 on bbmrieric.biobank (UUID);
create index IX_5629EA4D on bbmrieric.biobank (biobankcountry);
create index IX_446FCBE1 on bbmrieric.biobank (ldapbiobankID);

create index IX_1979D0D3 on bbmrieric.contactinformation (companyId);
create index IX_AED67015 on bbmrieric.contactinformation (groupId);
create index IX_278D0AF6 on bbmrieric.contactinformation (groupId, contactID);
create index IX_81395A0D on bbmrieric.contactinformation (groupId, updateuuid);
create index IX_7B8303DF on bbmrieric.contactinformation (uuid_);
create index IX_EAC62EE9 on bbmrieric.contactinformation (uuid_, companyId);
create unique index IX_12AF5BAB on bbmrieric.contactinformation (uuid_, groupId);

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

create index IX_E9E8CFD0 on bbmrieric.d2biobanknetwork (groupId, bbmriBiobankNetworkID);
create index IX_EF29EEA1 on bbmrieric.d2biobanknetwork (groupId, updateuuid);
create index IX_431A6B73 on bbmrieric.d2biobanknetwork (uuid_);
create index IX_3B0C02D5 on bbmrieric.d2biobanknetwork (uuid_, companyId);
create unique index IX_ABF13A97 on bbmrieric.d2biobanknetwork (uuid_, groupId);

create index IX_9EB361EF on bbmrieric.d2biobanknetworklink (d2biobanknetworkId, d2linkId, d2linktype);
create index IX_3B8BC438 on bbmrieric.d2biobanknetworklink (d2biobanknetworkId, d2linktype);
create index IX_69EE9788 on bbmrieric.d2biobanknetworklink (d2linkId, d2linktype);
create index IX_CCB89AE7 on bbmrieric.d2biobanknetworklink (groupId, updateuuid);
create index IX_A6096A39 on bbmrieric.d2biobanknetworklink (uuid_);
create index IX_8CD82C4F on bbmrieric.d2biobanknetworklink (uuid_, companyId);
create unique index IX_83CD7A91 on bbmrieric.d2biobanknetworklink (uuid_, groupId);

create index IX_B973517A on bbmrieric.d2collection (biobankId);
create index IX_A9DED87F on bbmrieric.d2collection (biobankId, parentd2collectionId);
create index IX_8E9D8A33 on bbmrieric.d2collection (companyId);
create index IX_FA590175 on bbmrieric.d2collection (groupId);
create index IX_3769E438 on bbmrieric.d2collection (groupId, bbmricollectionID);
create index IX_56128FA7 on bbmrieric.d2collection (groupId, bbmricollectionID, bbmribiobankID);
create index IX_37FDFAD0 on bbmrieric.d2collection (groupId, d2collectionId);
create index IX_418CDB6D on bbmrieric.d2collection (groupId, updateuuid);
create index IX_D73A6D3F on bbmrieric.d2collection (uuid_);
create index IX_A6212989 on bbmrieric.d2collection (uuid_, companyId);
create unique index IX_AFC87E4B on bbmrieric.d2collection (uuid_, groupId);

create index IX_E37156D4 on bbmrieric.diseasediscription (diseasecode);
create index IX_64144B9C on bbmrieric.diseasediscription (diseasegroup);
create index IX_CE49B53B on bbmrieric.diseasediscription (root);

create index IX_D4CB39C on bbmrieric.searchindex (UUID);
create index IX_5D2C4216 on bbmrieric.searchindex (organisationid);
create index IX_420D183F on bbmrieric.searchindex (organisationid, searchindexkey);
create index IX_B5F4E5E8 on bbmrieric.searchindex (searchindexvalue);
create index IX_8475E6D4 on bbmrieric.searchindex (value);