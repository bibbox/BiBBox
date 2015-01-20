create index IX_83FB5B8 on bibboxcs.biobankpanelassessment (organizationId);

create index IX_6A1E28D9 on bibboxcs.invitation (filter);
create index IX_D0165B5 on bibboxcs.invitation (invitationId);
create index IX_7894EDA5 on bibboxcs.invitation (rdcinvitationfilter);
create index IX_E3B3F6D3 on bibboxcs.invitation (status);

create index IX_C6196C00 on bibboxcs.invitation_organisation (invitationId);
create index IX_CE8257C9 on bibboxcs.invitation_organisation (invitationId, organisationId);
create index IX_C91A0641 on bibboxcs.invitation_organisation (organisationId);
create index IX_B7B5515E on bibboxcs.invitation_organisation (status);

create index IX_89618AEF on rdconnect.diseasematrix (organizationId);

create index IX_EB153260 on rdconnect.generalgnformation (organizationId);