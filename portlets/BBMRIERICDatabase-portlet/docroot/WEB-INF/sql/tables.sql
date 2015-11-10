create table bbmrieric.biobank (
	biobankId LONG not null primary key,
	organisationid LONG,
	ldapbiobankID TEXT null,
	biobankcountry TEXT null,
	biobankname TEXT null,
	biobanktype TEXT null,
	biobanksize TEXT null,
	biobankdescription VARCHAR(75) null,
	biobankjuristicperson TEXT null,
	UUID VARCHAR(75) null
);

create table bbmrieric.d2biobank (
	uuid_ VARCHAR(75) null,
	biobankId LONG not null primary key,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	updateuuid VARCHAR(75) null,
	contactIDRef VARCHAR(75) null,
	contactPriority LONG,
	bbmribiobankID VARCHAR(75) null,
	biobankName TEXT null,
	biobankJurisdicalPerson TEXT null,
	biobankCountry VARCHAR(75) null,
	biobankPartnerCharterSigned BOOLEAN,
	bioresourceReference VARCHAR(75) null,
	biobankNetworkIDRef VARCHAR(75) null,
	geoLatitude VARCHAR(75) null,
	geoLongitude VARCHAR(75) null,
	collaborationPartnersCommercial BOOLEAN,
	collaborationPartnersNonforprofit BOOLEAN,
	biobankITSupportAvailable BOOLEAN,
	biobankITStaffSize LONG,
	biobankISAvailable BOOLEAN,
	biobankHISAvailable BOOLEAN,
	biobankAcronym VARCHAR(75) null,
	biobankDescription TEXT null,
	biobankURL VARCHAR(500) null,
	biobankHeadFirstName VARCHAR(75) null,
	biobankHeadLastName VARCHAR(75) null,
	biobankHeadRole VARCHAR(75) null,
	biobankClinical BOOLEAN,
	biobankPopulation BOOLEAN,
	biobankResearchStudy BOOLEAN,
	biobankNonHuman BOOLEAN,
	biobankCollection BOOLEAN
);

create table bbmrieric.diseasediscription (
	diseasediscriptionId LONG not null primary key,
	diseasecode VARCHAR(75) null,
	diseasegroup VARCHAR(75) null,
	diseasediscription TEXT null,
	root BOOLEAN
);

create table bbmrieric.searchindex (
	searchid LONG not null primary key,
	organisationid LONG,
	locationid LONG,
	location TEXT null,
	searchindexkey TEXT null,
	searchindexvalue TEXT null,
	UUID VARCHAR(75) null
);