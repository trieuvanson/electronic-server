create table products
(
    id            int auto_increment
        primary key,
    best_seller   bit          null,
    createdate    datetime     null,
    description   varchar(255) null,
    features      bit          null,
    name          varchar(255) null,
    regular_price double       null,
    short_desc    varchar(255) null,
    slae_price    double       null,
    slug          varchar(255) null,
    status        bit          null,
    thumbnail     varchar(255) null,
    updatedate    datetime     null,
    category_id   int          null,
    constraint FK6t5dtw6tyo83ywljwohuc6g7k
        foreign key (category_id) references product_categories (id)
);

INSERT INTO `electronic-db`.products (id, best_seller, createdate, description, features, name, regular_price, short_desc, slae_price, slug, status, thumbnail, updatedate, category_id) VALUES (1, true, '2021-10-05 01:55:21', null, true, 'Note 8', null, null, null, null, null, null, '2021-10-05 01:55:18', 1);