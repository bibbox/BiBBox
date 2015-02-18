create index IX_6CCBF5F6 on rdconnect.aqr_rating (masterCandidateId);

create index IX_3BFFA893 on rdconnect.candidate (country);
create index IX_3763A7DC on rdconnect.candidate (country, name, source, candidatetype, diseasesfreetext, diseasescodes, subunitof);
create index IX_F13F405F on rdconnect.candidate (country, name, source, candidatetype, subunitof);
create index IX_CBE8A198 on rdconnect.candidate (subunitof);

create index IX_F1E13E24 on rdconnect.master_candidate (country);
create index IX_4A7B236A on rdconnect.master_candidate (country, name, candidatetype);
create index IX_8F6D9D0B on rdconnect.master_candidate (organisationid);

create index IX_278FD8A3 on rdconnect.rdcrecommender (organisationId, recommendedorganisationId);

create index IX_35DEDE4E on rdconnect.searchindex_rdconnect (value);