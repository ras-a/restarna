INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin','himitsu',CURRENT_DATE,1);
INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin2','himitsu',CURRENT_DATE,0);


INSERT INTO bread(id, name, reading, price, description, image,date_created) VALUES (bread_seq.nextval, 'フランスパン生地', 'ふらんすぱんきじ', 150, '香ばしくてパリパリした食感が特徴です', 'France.jpg','1908-02-03');
INSERT INTO bread(id, name, reading, price, description, image,date_created) VALUES (bread_seq.nextval, '食パン生地', 'しょくぱんきじ', 130, 'ふわふわで柔らかい食感が人気です', 'bread.jpg','1983-01-01');
INSERT INTO bread(id, name, reading, price, description, image,date_created) VALUES (bread_seq.nextval, 'クロワッサン生地', 'くろわっさんきじ', 170, 'サクサクした食感が特徴の折り込み生地です', 'kuro.jpg','1995-9-30');
INSERT INTO bread(id, name, reading, price, description, image, date_created) VALUES (bread_seq.nextval, '薄皮生地', 'うすかわきじ', 120, '普通のバンズです', 'usukawa.jpg', '1998-05-13');
INSERT INTO bread(id, name, reading, price, description, image,date_created) VALUES (bread_seq.nextval, 'チャバタ生地', 'ちゃばたきじ', 170, 'オリーブオイルを使ったイタリアの平たいパン生地です', 'chabata.jpg','1998-08-13');

INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, '餡子', 'あんこ', 130, '国産の小豆で作っています', 'anko.jpg', '1998-05-13');
INSERT INTO cream(id, name, reading, price, description, image,date_created) VALUES (cream_seq.nextval, 'カスタードクリーム', 'かすたーどくりーむ', 130, '国産の卵と牛乳から作っています', 'custard_cream.jpg', '2011-07-24');
INSERT INTO cream(id, name, reading, price, description, image,date_created) VALUES (cream_seq.nextval, 'バタークリーム', 'ばたーくりーむ', 140, '国産バターから作っています', 'butter_cream.jpg', '2014-08-19');
INSERT INTO cream(id, name, reading, price, description, image,date_created) VALUES (cream_seq.nextval, 'チョコクリーム', 'ちょこくりーむ', 300, '国産ではありません', 'chocolate_cream.jpg', '2013-08-19');
INSERT INTO cream(id, name, reading, price, description, image,date_created) VALUES (cream_seq.nextval, '抹茶クリーム', 'まっちゃくりーむ', 400, 'とてもきれいな緑色です', 'matcha_cream.jpg', '2001-08-19');
INSERT INTO cream(id, name, reading, price, description, image,date_created) VALUES (cream_seq.nextval, 'ホイップクリーム', 'ほいっぷくりーむ', 300, 'ふわふわです', 'whipped_cream.jpg', '2009-08-19');


INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, 'あんパン', 'あんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のあんパン', '1998-05-13');
INSERT INTO store_item VALUES (1, 'img.jpg');
-- INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, 'ホイップクリーム', 'ほいっぷくりいむ', 50, '雪印の牛乳から作っています', 'cream.png', '2001-06-12');
INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, 'クリームあんパン', 'くりいむあんぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), '町のクリームあんパン', '2001-06-12');
INSERT INTO store_item VALUES (2, 'anpan_cream.jpg');
INSERT INTO item(id, name, reading, bread, description,date_created)  VALUES (item_seq.nextval, 'チョコクロワッサン', 'ちょこくろわっさん', (SELECT id FROM bread WHERE name = 'クロワッサン生地'), 'めちゃくちゃうまい', '1999-12-14');
INSERT INTO store_item VALUES (3, 'chocolate_croissant.jpg');
INSERT INTO item(id, name, reading, bread, description,date_created)  VALUES (item_seq.nextval, 'カスタードクリームパン', 'かすたーどくりーむぱん', (SELECT id FROM bread WHERE name = '薄皮生地'), 'クリーム多めです', '2016-12-14');
INSERT INTO store_item VALUES (4, 'custard_cream_pan.jpg');
INSERT INTO item(id, name, reading, bread, description,date_created)  VALUES (item_seq.nextval, 'バタークリームクロワッサン', 'ばたーくりーむくろわっさん', (SELECT id FROM bread WHERE name = 'クロワッサン生地'), 'カリカリしています', '2016-12-14');
INSERT INTO store_item VALUES (5, 'butter_cream_cro.jpg');


INSERT INTO item_cream VALUES (1, 1);
INSERT INTO item_cream VALUES (2, 1);
INSERT INTO item_cream VALUES (2, 2);
INSERT INTO item_cream VALUES (3, 4);
INSERT INTO item_cream VALUES (4, 2);
INSERT INTO item_cream VALUES (5, 3);

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

INSERT INTO customer(
	id,
	name,
	reading,
	password,
	email,
	date_created
) VALUES (
	customer_seq.nextval,
	'次郎',
	'じろう',
	'zhioo',
	'z@mail.com',
	'2022-04-09'
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
	'三郎',
	'さぶろう',
	'saburo',
	'3@mail.com',
	'2022-03-03'
);
INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, '抹茶クロワッサン', 'まっちゃくろわっさん', (SELECT id FROM bread WHERE name = 'クロワッサン生地'), 'クロワッサンの中に抹茶をぶちこみました', '2024-05-13');
INSERT INTO item_cream VALUES (6, 5);
INSERT INTO custom_item VALUES (6, 2, 0);

INSERT INTO item(id, name, reading, bread, description, date_created) VALUES (item_seq.nextval, '高カロリー食パン', 'こうかろりーしょくぱん', (SELECT id FROM bread WHERE name = '食パン生地'), '太りたいかたにオススメ', '2022-05-13');
INSERT INTO item_cream VALUES (7, 1);
INSERT INTO item_cream VALUES (7, 4);
INSERT INTO item_cream VALUES (7, 6);
INSERT INTO custom_item VALUES (7, 2, 0);


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

UPDATE customer SET
		main_address = 1,
		main_credit_card = 1
	WHERE id = 1;

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