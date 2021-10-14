create table product_categories
(
    id         int auto_increment
        primary key,
    banner     varchar(255) null,
    createdate datetime     null,
    name       varchar(255) null,
    slug       varchar(255) null,
    updatedate datetime     null,
    brand_id   int          null,
    constraint FK4i5wji1xieqwb74n9e89erugv
        foreign key (brand_id) references brands (id)
);

INSERT INTO `electronic-db`.product_categories (id, banner, createdate, name, slug, updatedate, brand_id) VALUES (1, null, '2021-10-05 01:53:25', 'Xiaomi', null, '2021-10-05 01:53:25', 1);
INSERT INTO `electronic-db`.product_categories (id, banner, createdate, name, slug, updatedate, brand_id) VALUES (2, null, '2021-10-05 01:53:25', 'Samsung', null, '2021-10-05 01:53:25', 1);
INSERT INTO `electronic-db`.product_categories (id, banner, createdate, name, slug, updatedate, brand_id) VALUES (3, null, '2021-10-05 01:53:25', 'LG', null, '2021-10-05 01:53:25', 1);
INSERT INTO `electronic-db`.product_categories (id, banner, createdate, name, slug, updatedate, brand_id) VALUES (4, null, '2021-10-05 01:53:25', 'NOKIA', null, '2021-10-05 01:53:25', 1);
INSERT INTO `electronic-db`.product_categories (id, banner, createdate, name, slug, updatedate, brand_id) VALUES (5, null, '2021-10-05 01:53:25', 'IPHONE', null, '2021-10-05 01:53:25', 1);