INSERT INTO admin VALUES (admin_seq.nextval,'sysadmin','himitsu',CURRENT_DATE,0,1);

INSERT INTO bread(id, name, reading, price, description, image, date_created) VALUES (bread_seq.nextval, 'バンズ', 'ばんず', 50, '普通のバンズです', 'bun.jpeg', CURRENT_DATE);
INSERT INTO cream(id, name, reading, price, description, image, date_created) VALUES (cream_seq.nextval, '餡子', 'あんこ', 80, '国産の小豆で作っています', 'anko.jpeg', CURRENT_DATE);
INSERT INTO item(id, name, reading, bread, description)  VALUES (item_seq.nextval, 'あんパン', 'あんぱん', (SELECT id FROM bread WHERE name = 'バンズ'), '町のあんパン');
INSERT INTO item_cream VALUES (1, 1);
