INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin','himitsu',CURRENT_DATE,1);
INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin2','himitsu',CURRENT_DATE,0);

INSERT INTO bread(id, name, reading, price, description, image, date_created) VALUES (bread_seq.nextval, '薄皮生地', 'うすかわきじ', 120, '普通のバンズです', 'bun.jpeg', '1998-05-13');
INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, '餡子', 'あんこ', 130, '国産の小豆で作っています', 'anko_tsubu.png', '1998-05-13');
INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, 'あんパン', 'あんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のあんパン', '1998-05-13');
INSERT INTO store_item VALUES (1, 'img.jpg');
INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, 'ホイップクリーム', 'ほいっぷくりいむ', 50, '雪印の牛乳から作っています', 'cream.png', '2001-06-12');
INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, 'クリームあんパン', 'くりいむあんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のクリームあんパン', '2001-06-12');
INSERT INTO store_item VALUES (2, 'anpan_cream.jpg');

INSERT INTO item_cream VALUES (1, 1);
INSERT INTO item_cream VALUES (2, 1);
INSERT INTO item_cream VALUES (2, 2);

INSERT INTO customer(
	id,
	name,
	reading,
	password,
	email,
	date_created
) VALUES (
	0,
	'NULL',
	CHAR(0),
	CHAR(0),
	CHAR(0),
	'0000-01-01'
);

INSERT INTO customer(
	id,
	name,
	reading,
	password,
	email,
	date_created
) VALUES (
	customer_seq.nextval,
	'太郎',
	'たろう',
	'taroo',
	'e@mail.com',
	'2022-04-08'
);

INSERT INTO review(
	poster,
	item,
	description,
	score,
	date_created
) VALUES (
	1,
	1,
	'最高',
	4,
	'2022-04-08'
);


INSERT INTO address_profile(
	id,
	customer,
	name,
	post_code,
	address,
	addressee_name,
	addressee_reading,
	date_created
) VALUES (
	address_seq.nextval,
	1,
	'main',
	'000-000',
	'京都府京都市',
	'太郎',
	'たろう',
	'2022-04-08'
);

INSERT INTO credit_card(
	id,
	owner,
	name,
	holder_name,
	no,
	cvc,
	date_created
) VALUES (
	credit_card_seq.nextval,
	1,
	'card',
	'CREAM TARO',
	'0123456789101112',
	'123',
	'2022-04-08'
);

INSERT INTO product_order(
	id,
	customer,
	payment_method,
	credit_card,
	address,
	date_created
) VALUES (
	order_seq.nextval,
	1,
	0,
	1,
	1,
	'2022-04-08'
);

INSERT INTO product_order_item VALUES (
	1,
	1,
	1
);

INSERT INTO cart VALUES (
	1,
	1,
	4
);

INSERT INTO favorite VALUES (
	1,
	1
);

INSERT INTO cart VALUES (
	1,
	2,
	4
);