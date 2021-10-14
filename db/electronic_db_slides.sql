create table slides
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    images_url varchar(255) null,
    link       varchar(255) null,
    postion    int          null,
    updatedate datetime     null
);

