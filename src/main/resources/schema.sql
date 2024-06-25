-- 会員
CREATE TABLE customer (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
 -- 読み仮名
	reading VARCHAR2(64 CHAR) NOT NULL,
	password VARCHAR2(128) NOT NULL,
	email VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE customer_seq NOCACHE;

-- 会員が登録した宛先住所
-- 複数登録可能
CREATE TABLE address_profile (
	id INTEGER PRIMARY KEY,
	customer INTEGER REFERENCES customer(id) NOT NULL,
	-- 宛先名
	name VARCHAR2(32 CHAR) UNIQUE NOT NULL,
	post_code VARCHAR2(8) NOT NULL,
	address VARCHAR2(128 CHAR) NOT NULL,
	phone_number VARCHAR2(11),
	email VARCHAR2(64 CHAR),
	-- 宛先名
	addressee_name VARCHAR2(32 CHAR) NOT NULL,
	-- 宛先名読み仮名
	addressee_reading VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE address_seq NOCACHE;

-- クレカ情報の登録
CREATE TABLE credit_card (
	id INTEGER PRIMARY KEY,
	owner INTEGER REFERENCES customer(id) NOT NULL,
	name VARCHAR2(32 CHAR) NOT NULL,
	holder_name VARCHAR2(64) NOT NULL,
	no VARCHAR2(16) NOT NULL,
	cvc VARCHAR2(3) NOT NULL,
	date_created DATE NOT NULL
);

CREATE SEQUENCE credit_card_seq NOCACHE;

-- 会員の標準宛先
-- address_profileが存在しないままでは作れないので、
-- その作成後に外部参照を追加
ALTER TABLE customer ADD main_address INTEGER DEFAULT NULL REFERENCES address_profile(id);
ALTER TABLE customer ADD main_credit_card INTEGER DEFAULT NULL REFERENCES credit_card(id);

-- パン生地の種類
CREATE TABLE bread (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
 -- 読み仮名
	reading VARCHAR2(64 CHAR) NOT NULL,
	price INTEGER NOT NULL,
	description VARCHAR2(128 CHAR) NOT NULL,
	image VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE bread_seq NOCACHE;

-- クリームの種類
CREATE TABLE cream (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
 -- 読み仮名
	reading VARCHAR2(64 CHAR) NOT NULL,
	price INTEGER NOT NULL,
	description VARCHAR2(128 CHAR) NOT NULL,
	image VARCHAR2(64 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE cream_seq NOCACHE;

-- 商品
CREATE TABLE item (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(32 CHAR) NOT NULL,
	-- 読み仮名
	reading VARCHAR2(64 CHAR) NOT NULL,
	bread INTEGER REFERENCES bread(id) NOT NULL,
	description VARCHAR2(512 CHAR) NOT NULL,
	date_created DATE NOT NULL,
	deleted NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE item_seq NOCACHE;

-- 商品とクリームの関係性
CREATE TABLE item_cream (
	item INTEGER REFERENCES item(id),
	cream INTEGER REFERENCES cream(id),
	CONSTRAINT pk_ic PRIMARY KEY (item, cream)
);

-- 既存の(店の)商品
CREATE TABLE store_item (
	item INTEGER PRIMARY KEY REFERENCES item(id),
	image VARCHAR2(64 CHAR) NOT NULL
);

-- 会員のカスタムで作成した商品
CREATE TABLE custom_item (
	item INTEGER PRIMARY KEY REFERENCES item(id) NOT NULL,
	creator INTEGER REFERENCES customer(id) NOT NULL,
 -- 公開済か否か
	is_public NUMBER(1) DEFAULT 0
);

-- 会員のお気に入り登録
CREATE TABLE favorite (
	owner INTEGER REFERENCES customer(id),
	item INTEGER REFERENCES item(id),
	CONSTRAINT pk_fav PRIMARY KEY (owner, item)
);

-- 注文
CREATE TABLE product_order (
	id INTEGER PRIMARY KEY,
	customer INTEGER REFERENCES customer(id),
	payment_method NUMBER(1) NOT NULL CHECK (payment_method BETWEEN 0 AND 4),
	credit_card INTEGER REFERENCES credit_card(id),
	date_created DATE NOT NULL,
	cancelled NUMBER(1) DEFAULT 0,
	address INTEGER REFERENCES address_profile(id) NOT NULL,
	optional_details VARCHAR2(512),
	completed DATE
);

CREATE SEQUENCE order_seq NOCACHE;

-- 注文の商品項目
CREATE TABLE product_order_item (
	product_order INTEGER NOT NULL REFERENCES product_order(id),
	item INTEGER NOT NULL REFERENCES item(id),
	amount INTEGER NOT NULL CHECK (amount > 0),
	CONSTRAINT pk_oi PRIMARY KEY (product_order, item)
);

-- 口コミ
CREATE TABLE review (
	poster INTEGER NOT NULL REFERENCES customer(id),
	item INTEGER NOT NULL REFERENCES item(id),
	description VARCHAR2(1024),
	score INTEGER CHECK (score BETWEEN 1 AND 5),
	deleted NUMBER(1) DEFAULT 0,
	date_created DATE NOT NULL,
	CONSTRAINT pk_review PRIMARY KEY (poster, item)
);

-- 管理者
CREATE TABLE admin (
	id INTEGER PRIMARY KEY,
	name VARCHAR2(16 CHAR),
	password VARCHAR2(32),
	date_created DATE NOT NULL,
	system NUMBER(1) DEFAULT 0
);

CREATE SEQUENCE admin_seq;

-- カート情報
CREATE TABLE cart (
	customer INTEGER NOT NULL REFERENCES customer(id),
	item INTEGER NOT NULL REFERENCES item(id),
	quantity INTEGER NOT NULL,
	CONSTRAINT pk_cart PRIMARY KEY (customer, item)
);