create index IX_3BFFA893 on rdconnect.candidate (country);
create index IX_F13F405F on rdconnect.candidate (country, name, source, candidatetype, subunitof);
create index IX_CBE8A198 on rdconnect.candidate (subunitof);