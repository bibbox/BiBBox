create index IX_D0165B5 on bibboxcs.invitation (invitationId);
create index IX_E3B3F6D3 on bibboxcs.invitation (status);

create index IX_C6196C00 on bibboxcs.invitation_organisation (invitationId);
create index IX_CE8257C9 on bibboxcs.invitation_organisation (invitationId, organisationId);
create index IX_C91A0641 on bibboxcs.invitation_organisation (organisationId);