CREATE TABLE Document(
	id_document serial PRIMARY KEY,
	type_document VARCHAR ( 40 ) NOT NULL,
	seria VARCHAR ( 20 ) NOT NULL ,
	numar VARCHAR ( 20 ) NOT NULL UNIQUE,
	snils VARCHAR ( 20 ) UNIQUE,
	polis VARCHAR ( 20 ) UNIQUE
);

CREATE TABLE Patient(
	id_patient serial PRIMARY KEY,
	surname VARCHAR ( 30 ) NOT NULL,
	name VARCHAR ( 30 ) NOT NULL,
	full_name VARCHAR ( 30 ) NOT NULL,
	gender VARCHAR ( 5 ) NOT NULL,
	phone  VARCHAR ( 12 ) NOT NULL UNIQUE,
	address VARCHAR ( 100 ) NOT NULL ,
	document_id int unique references public.Document ( id_document )
);

CREATE TABLE Doctor(
	id_doctor serial PRIMARY KEY,
	surname VARCHAR ( 60 ) NOT NULL,
	name VARCHAR ( 60 ) NOT NULL,
	full_name VARCHAR ( 60 ) NOT NULL
);