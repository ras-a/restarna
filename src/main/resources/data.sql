INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin','himitsu',CURRENT_DATE,1);
INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin2','himitsu',CURRENT_DATE,0);

INSERT INTO bread(id, name, reading, price, description, image) VALUES (bread_seq.nextval, '薄皮生地', 'うすかわきじ', 120, '普通のバンズです', 'bun.jpeg');
INSERT INTO cream(id, name, reading, price, description, image) VALUES (cream_seq.nextval, '餡子', 'あんこ', 130, '国産の小豆で作っています', 'anko_tsubu.png');
INSERT INTO item(id, name, reading, bread, description)  VALUES (item_seq.nextval, 'あんパン', 'あんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のあんパン');
INSERT INTO store_item VALUES (1, 'img.jpg');
INSERT INTO cream(id, name, reading, price, description, image) VALUES (cream_seq.nextval, 'ホイップクリーム', 'ほいっぷくりいむ', 50, '雪印の牛乳から作っています', 'cream.png');
INSERT INTO item(id, name, reading, bread, description)  VALUES (item_seq.nextval, 'クリームあんパン', 'くりいむあんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のクリームあんパン');
INSERT INTO store_item VALUES (2, 'anpan_cream.jpg');

INSERT INTO item_cream VALUES (1, 1);
INSERT INTO item_cream VALUES (2, 1);
INSERT INTO item_cream VALUES (2, 2);

INSERT INTO customer(
	id,
	name,
	reading,
	password,
	email
) VALUES (
	1,
	'太郎',
	'たろう',
	'taroo',
	'e@mail.com'
);

INSERT INTO review(
	poster,
	item,
	description,
	score
) VALUES (
	1,
	1,
	'最高',
	4
);


INSERT INTO address_profile(
	id,
	customer,
	name,
	post_code,
	address,
	addressee_name,
	addressee_reading
) VALUES (
	address_seq.nextval,
	1,
	'main',
	'000-000',
	'京都府京都市',
	'太郎',
	'たろう'
);

INSERT INTO credit_card(
	id,
	owner,
	name,
	holder_name,
	no,
	cvc
) VALUES (
	credit_card_seq.nextval,
	1,
	'card',
	'CREAM TARO',
	'0123456789101112',
	'123'
);

INSERT INTO product_order(
	id,
	customer,
	payment_method,
	credit_card,
	address
) VALUES (
	1,
	1,
	0,
	1,
	1
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
