create table users
(
    username   varchar(255) not null
        primary key,
    address    varchar(255) null,
    avatar     varchar(255) null,
    birthday   datetime     null,
    createdate datetime     null,
    email      varchar(255) null,
    fullname   varchar(255) null,
    gender     bit          null,
    password   varchar(255) null,
    phone      varchar(255) null,
    status     bit          null,
    updatedate datetime     null
);

INSERT INTO `electronic-db`.users (username, address, avatar, birthday, createdate, email, fullname, gender, password, phone, status, updatedate) VALUES ('trieuvanson', null, null, null, null, 'Vodanhserver@gmail.com', 'SON TRIEU VAN', null, '$2a$10$mUODUlyAhS7R62d5GGHFYuIQO9MByAMmHpJk1B0X8qjfZQvssKxPe', null, null, null);
INSERT INTO `electronic-db`.users (username, address, avatar, birthday, createdate, email, fullname, gender, password, phone, status, updatedate) VALUES ('TVS', 'Tp.HCM', 'avatar.com', '2001-03-01 18:26:44', '2021-10-04 18:26:55', 'Vodanhserver@gmail.com', 'Triệu Văn Sơn', true, '$2a$10$tMSJ67zi97AffEo4ZkOWyO6tyQbKyqUwC0ZUv10L5iXqO93PgckT6', '0969894840', true, '2021-10-04 18:27:19');
INSERT INTO `electronic-db`.users (username, address, avatar, birthday, createdate, email, fullname, gender, password, phone, status, updatedate) VALUES ('TVS1', null, null, null, null, null, null, null, '$2a$10$SWZOwQS7fcS3W6K7WzzIkexuU/0VvYVArB/mLWO3fhjNa0xfx7uEm', null, null, null);
INSERT INTO `electronic-db`.users (username, address, avatar, birthday, createdate, email, fullname, gender, password, phone, status, updatedate) VALUES ('TVS123', null, null, null, null, 'Vodanhserver@gmail.com', 'Triệu Văn Sơn', null, '$2a$10$t9uFx649bCklD1USiA3E2uOPv3F5aIDEGXxwiHjztRrJ383wTMtZG', null, null, null);