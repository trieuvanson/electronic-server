create table news
(
    id          int          not null
        primary key,
    content     varchar(255) null,
    createdate  datetime     null,
    status      bit          null,
    title       varchar(255) null,
    updatedate  datetime     null,
    category_id int          null,
    constraint FK8kvxnfv5rxliuo77i0sg3e4tq
        foreign key (category_id) references product_categories (id)
);

