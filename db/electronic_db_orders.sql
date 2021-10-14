create table orders
(
    id         bigint auto_increment
        primary key,
    address    varchar(255) null,
    createdate datetime     null,
    status     varchar(255) null,
    updatedate datetime     null,
    username   varchar(255) null,
    constraint FK5ul5qtyh6slfyq8i4jby7qecx
        foreign key (username) references users (username)
);

