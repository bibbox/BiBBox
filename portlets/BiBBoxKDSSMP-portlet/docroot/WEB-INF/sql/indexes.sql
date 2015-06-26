create index IX_7AAAB69A on kdssmp.configuration (scope);
create index IX_EA96A820 on kdssmp.configuration (scope, optionkey);
create index IX_DE0A46F2 on kdssmp.configuration (scope, optionvalue);

create index IX_EE52D922 on kdssmp.event (patientId);

create index IX_BA6D04D on kdssmp.eventdata (eventId);
create index IX_92D6A090 on kdssmp.eventdata (eventId, ontology);
create index IX_DD162E77 on kdssmp.eventdata (eventlayoutId);
create index IX_CADD23A on kdssmp.eventdata (eventlayoutId, ontology);
create index IX_E83471B8 on kdssmp.eventdata (patientId);

create index IX_704BD049 on kdssmp.parameteroptions (parameterconfigurationId);

create index IX_72F3E09B on kdssmp.patient (organizationId);

create index IX_C8EC52FB on kdssmp.patientnamegenerator (name, type_);