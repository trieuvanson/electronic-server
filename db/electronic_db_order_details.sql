create table order_details
(
    id         bigint auto_increment
        primary key,
    price      double null,
    quanity    double null,
    order_id   bigint null,
    product_id int    null,
    constraint FK4q98utpd73imf4yhttm3w0eax
        foreign key (product_id) references products (id),
    constraint FKjyu2qbqt8gnvno9oe9j2s2ldk
        foreign key (order_id) references orders (id)
);

