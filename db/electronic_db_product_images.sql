create table product_images
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    images_url varchar(255) null,
    updatedate datetime     null,
    product_id int          null,
    constraint FKqnq71xsohugpqwf3c9gxmsuy
        foreign key (product_id) references products (id)
);

