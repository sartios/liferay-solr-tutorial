create table solr_IceCream (
	uuid_ VARCHAR(75) null,
	iceCreamId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	flavor VARCHAR(75) null,
	name VARCHAR(75) null
);

create table solr_IceCreamDocuments (
	uuid_ VARCHAR(75) null,
	iceCreamDocumentsId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	documentId LONG,
	iceCreamId LONG
);