create table brands
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    name       varchar(255) null,
    slugs      varchar(255) null,
    updatedate datetime     null
);

INSERT INTO `electronic-db`.brands (id, createdate, name, slugs, updatedate) VALUES (1, '2021-10-04 18:28:07', 'Điện Thoại', null, '2021-10-04 18:28:08');
INSERT INTO `electronic-db`.brands (id, createdate, name, slugs, updatedate) VALUES (2, '2021-10-04 18:28:17', 'Máy tính bàn', null, '2021-10-04 18:28:18');
INSERT INTO `electronic-db`.brands (id, createdate, name, slugs, updatedate) VALUES (3, '2021-10-04 18:28:23', 'Máy tính bảng', null, '2021-10-04 18:28:24');
INSERT INTO `electronic-db`.brands (id, createdate, name, slugs, updatedate) VALUES (4, '2021-10-04 18:28:28', 'Laptop', null, '2021-10-04 18:28:29');