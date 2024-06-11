INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin','himitsu',CURRENT_DATE,0,1);

INSERT INTO bread(id, name, reading, price, description, image, date_created) VALUES (bread_seq.nextval, 'バンズ', 'ばんず', 50, '普通のバンズです', 'bun.jpeg', CURRENT_DATE);
INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, '餡子', 'あんこ', 80, '国産の小豆で作っています', 'anko.jpeg', CURRENT_DATE);
INSERT INTO item(id, name, reading, bread, description)  VALUES (item_seq.nextval, 'あんパン', 'あんぱん', (SELECT id FROM bread WHERE name = 'バンズ'), '町のあんパン');
INSERT INTO item_cream VALUES (1, 1);

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


INSERT INTO address_profile(
	id,
	customer,
	name,
	post_code,
	address,
	addressee_name,
	addressee_reading
) VALUES (
	1,
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
	1,
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