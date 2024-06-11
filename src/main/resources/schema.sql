CREATE TABLE customer (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
	reading VARCHAR2(64 CHAR) NOT NULL,
	password VARCHAR2(128 BYTE) NOT NULL,
	email VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) NOT NULL DEFAULT 0
);

CREATE SEQUENCE customer_seq NOCACHE;

CREATE TABLE address_profile (
	id INTEGER PRIMARY KEY,
	customer INTEGER REFERENCES customer(id) NOT NULL,
	name VARCHAR2(32 CHAR) NOT NULL,
	post_code VARCHAR2(8 BYTE) NOT NULL,
	address VARCHAR2(128 CHAR) NOT NULL,
	phone_number VARCHAR(11 BYTE),
	email VARCHAR2(64 CHAR),
	addressee_name VARCHAR2(32 CHAR) NOT NULL,
	addressee_reading VARCHAR(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE address_seq NOCACHE;

ALTER TABLE customer ADD main_address INTEGER REFERENCES address_profile(id) DEFAULT NULL;

CREATE TABLE bread (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
	reading VARCHAR2(64 CHAR) NOT NULL,
	price INTEGER NOT NULL,
	description VARCHAR2(128 CHAR) NOT NULL,
	image VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE bread_seq NOCACHE;

CREATE TABLE cream (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
	reading VARCHAR2(64 CHAR) NOT NULL,
	price INTEGER NOT NULL,
	description VARCHAR2(128 CHAR) NOT NULL,
	image VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE cream_seq NOCACHE;

CREATE TABLE item (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
	reading VARCHAR2(64 CHAR) NOT NULL,
	bread INTEGER REFERENCES bread(id) NOT NULL,
	description VARCHAR2(512 CHAR) NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE item_seq NOCACHE;

DROP TABLE item_cream;
CREATE TABLE item_cream (
	item INTEGER REFERENCES item(id),
	cream INTEGER REFERENCES cream(id),
	CONSTRAINT pk_ic PRIMARY KEY (item, cream)
);

CREATE TABLE store_item (
	item INTEGER PRIMARY KEY REFERENCES item(id),
	image VARCHAR2(64 CHAR) NOT NULL
);

CREATE TABLE custom_item (
	item INTEGER PRIMARY KEY REFERENCES item(id) NOT NULL,
	creator INTEGER REFERENCES customer(id) NOT NULL,
	is_public NUMBER(1) DEFAULT 0
);

CREATE TABLE favorite (
	owner REFERENCES customer(id),
	item REFERENCES item(id),
	CONSTRAINT pk_fav PRIMARY KEY (owner, item)
);

CREATE TABLE credit_card (
	owner INTEGER REFERENCES customer(id) NOT NULL,
	name VARCHAR2(32 CHAR) NOT NULL,
	holder_name VARCHAR2(64 BYTE) NOT NULL,
	no VARCHAR2(16 BYTE) NOT NULL,
	cvc VARCHAR2(3 BYTE) NOT NULL,
	CONSTRAINT pk_cc PRIMARY KEY (owner, name)
);

CREATE TABLE product_order (
	id INTEGER PRIMARY KEY,
	customer INTEGER REFERENCES customer(id),
	payment_method NUMBER(1) NOT NULL,
	credit_card VARCHAR2(32 CHAR),
	date_created DATE NOT NULL,
	cancelled NUMBER(1) DEFAULT 0,
	address INTEGER REFERENCES address_profile(id) NOT NULL,
	optional_details VARCHAR2(512),
	completed DATE,
	FOREIGN KEY (customer, credit_card) REFERENCES credit_card(owner, name)
);

CREATE SEQUENCE order_seq NOCACHE;

CREATE TABLE product_order_item (
	product_order INTEGER REFERENCES product_order(id) NOT NULL,
	item INTEGER REFERENCES item(id) NOT NULl,
	amount INTEGER CHECK (amount > 0),
	CONSTRAINT pk PRIMARY KEY (product_order, item)
);

CREATE TABLE admin (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(16 CHAR),
	password VARCHAR2(32 BYTE),
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0,
	system NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE admin_seq;