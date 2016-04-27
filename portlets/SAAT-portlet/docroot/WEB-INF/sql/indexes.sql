create index IX_C8EC0045 on code_icd10 (code_);

create index IX_B52B9E60 on code_icdo3 (code_);

create index IX_770AE97 on code_scg (code_);

create index IX_51D639F8 on dictionary2 (root);
create index IX_DA4FBF89 on dictionary2 (synonym);

create index IX_CCA85F5E on dictionary2_dictionary2_addiction_link (dictionary_id);