create table roles
(
    id         varchar(255) not null
        primary key,
    createdate datetime     null,
    name       varchar(255) null,
    updatedate datetime     null
);

INSERT INTO `electronic-db`.roles (id, createdate, name, updatedate) VALUES ('ADMIN_ROLE', '2021-10-04 09:46:15', 'ADMIN_ROLE', '2021-10-04 09:46:15');
INSERT INTO `electronic-db`.roles (id, createdate, name, updatedate) VALUES ('USER_ROLE', '2021-10-04 09:46:15', 'USER_ROLE', '2021-10-04 09:46:15');