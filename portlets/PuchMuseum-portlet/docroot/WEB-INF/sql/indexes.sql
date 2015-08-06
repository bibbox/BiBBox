create index IX_994A0FB0 on puchmuseum.configuration (optionkey);
create index IX_8761C7BA on puchmuseum.configuration (scope);
create index IX_57AFA300 on puchmuseum.configuration (scope, optionkey);
create index IX_68D009D2 on puchmuseum.configuration (scope, optionvalue);

create index IX_45298601 on puchmuseum.fahrzeug (typ);

create index IX_F695F4A0 on puchmuseum.objectdata (puchmuseumsobjectId);
create index IX_5B3F9DD0 on puchmuseum.objectdata (puchmuseumsobjectId, objectkey);

create index IX_6D2D031 on puchmuseum.parameteroptionsconfiguration (parameterconfigurationId);

create index IX_4B0097E7 on puchmuseum.person (vorname);

create index IX_DD84C3C1 on puchmuseum.transaktion (typ);

create index IX_91CE44A1 on puchmuseum_configuration (optionkey);
create index IX_BAE01D2B on puchmuseum_configuration (scope);
create index IX_AC42CEF on puchmuseum_configuration (scope, optionkey);
create index IX_A8E9D401 on puchmuseum_configuration (scope, optionvalue);

create index IX_A9AA7E8F on puchmuseum_objectdata (puchmuseumsobjectId);
create index IX_F404D881 on puchmuseum_objectdata (puchmuseumsobjectId, objectkey);

create index IX_343D20 on puchmuseum_parameteroptionsconfiguration (parameterconfigurationId);

create index IX_EAECDFD6 on puchmuseum_person (vorname);

create index IX_3B2179B2 on puchmuseum_transaktion (typ);