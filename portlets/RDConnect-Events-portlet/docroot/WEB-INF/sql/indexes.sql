create index IX_843EF64E on rdconnect.event (eventdate);
create index IX_963B7F79 on rdconnect.event (restricted);

create index IX_FD4DFE8 on rdconnect.eventnotification (notificationtype, userId);
create index IX_7108D5CF on rdconnect.eventnotification (userId);