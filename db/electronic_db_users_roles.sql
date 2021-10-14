create table users_roles
(
    user_username varchar(255) not null,
    roles_id      varchar(255) not null,
    constraint FK1y8kc6nr793297gijoc5t5qmx
        foreign key (user_username) references users (username),
    constraint FKa62j07k5mhgifpp955h37ponj
        foreign key (roles_id) references roles (id)
);

INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('TVS', 'USER_ROLE');
INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('TVS', 'ADMIN_ROLE');
INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('TVS1', 'USER_ROLE');
INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('TVS1', 'ADMIN_ROLE');
INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('TVS123', 'USER_ROLE');
INSERT INTO `electronic-db`.users_roles (user_username, roles_id) VALUES ('trieuvanson', 'USER_ROLE');