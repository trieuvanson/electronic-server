create table submit_contacts
(
    id         bigint auto_increment
        primary key,
    content    varchar(255) null,
    createdate datetime     null,
    email      varchar(255) null,
    name       varchar(255) null,
    status     bit          null,
    updatedate datetime     null
);

