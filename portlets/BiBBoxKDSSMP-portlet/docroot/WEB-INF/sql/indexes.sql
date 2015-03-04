create index IX_7AAAB69A on kdssmp.configuration (scope);
create index IX_EA96A820 on kdssmp.configuration (scope, optionkey);

create index IX_EE52D922 on kdssmp.event (patientId);

create index IX_DD162E77 on kdssmp.eventdata (eventlayoutId);
create index IX_E83471B8 on kdssmp.eventdata (patientId);

create index IX_C8EC52FB on kdssmp.patientnamegenerator (name, type_);