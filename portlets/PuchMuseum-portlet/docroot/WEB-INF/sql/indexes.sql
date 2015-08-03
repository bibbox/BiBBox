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