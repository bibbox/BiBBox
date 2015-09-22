create index IX_5F12CAE2 on bibboxcs.ddlconfiguration (ddmstructureId, fieldname);
create index IX_87846FF7 on bibboxcs.ddlconfiguration (recordsetId, fieldname);

create index IX_49480DA8 on bibboxcs.iconconfiguration (symbolconfigurationId, key_);
create index IX_57B82985 on bibboxcs.iconconfiguration (symbolconfigurationId, key_, position);
create index IX_DA438FB1 on bibboxcs.iconconfiguration (symbolconfigurationId, position);

create index IX_96DA16 on bibboxcs.symbolconfiguration (scope, eventtype);

create index IX_A84733E2 on bibboxcs.symboltypeconfiguration (symboltype);

create index IX_A12340B0 on rdconnect.searchindex_rdconnect (organisationid, key_);
create index IX_35DEDE4E on rdconnect.searchindex_rdconnect (value);