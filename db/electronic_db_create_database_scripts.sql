create table brands
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    name       varchar(255) null,
    slugs      varchar(255) null,
    updatedate datetime     null
);

create table discounts
(
    id         varchar(255) not null
        primary key,
    discount   double       null,
    total      int          null,
    created_at datetime     null,
    expired_at datetime     null
);

create table product_categories
(
    id         int auto_increment
        primary key,
    banner     varchar(255) null,
    createdate datetime     null,
    name       varchar(255) null,
    slug       varchar(255) null,
    updatedate datetime     null,
    brand_id   int          null,
    constraint FK4i5wji1xieqwb74n9e89erugv
        foreign key (brand_id) references brands (id)
);

create table news
(
    id          int auto_increment
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

create table products
(
    id            int auto_increment
        primary key,
    best_seller   bit            null,
    createdate    datetime       null,
    description   varchar(15000) null,
    features      bit            null,
    name          varchar(255)   null,
    regular_price double         null,
    sale_price    double         null,
    short_desc    varchar(255)   null,
    status        bit            null,
    thumbnail     varchar(255)   null,
    thumbnail2    varchar(255)   null,
    updatedate    datetime       null,
    category_id   int            null,
    slug          varchar(255)   null,
    color         varchar(20)    null,
    constraint FK6t5dtw6tyo83ywljwohuc6g7k
        foreign key (category_id) references product_categories (id)
);

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

create table roles
(
    id         varchar(255) not null
        primary key,
    createdate datetime     null,
    name       varchar(255) null,
    updatedate datetime     null
);

create table slides
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    images_url varchar(255) null,
    link       varchar(255) null,
    postion    int          null,
    status     bit          null,
    updatedate datetime     null,
    product_id int          null,
    constraint FK2x707adbrevfba86kgnca4giv
        foreign key (product_id) references products (id)
);

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

create table users
(
    username   varchar(255) not null
        primary key,
    address    varchar(255) null,
    avatar     varchar(255) null,
    birthday   date         null,
    createdate datetime     null,
    email      varchar(255) null,
    fullname   varchar(255) null,
    gender     bit          null,
    password   varchar(255) null,
    phone      varchar(255) null,
    status     bit          null,
    updatedate datetime     null
);

create table address
(
    id         int auto_increment
        primary key,
    address    varchar(255) null,
    createdate datetime     null,
    fullname   varchar(255) null,
    phone      varchar(255) null,
    status     bit          null,
    type       bit          null,
    updatedate datetime     null,
    username   varchar(255) null,
    constraint FK9synidk0pr1oawx64h3crbhec
        foreign key (username) references users (username)
);

create table cart_item
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    quantity   int          null,
    product_id int          null,
    username   varchar(255) null,
    constraint FK66nq3j5yfpn3jgiwwwf2oyvyy
        foreign key (username) references users (username),
    constraint FKqkqmvkmbtiaqn2nfqf25ymfs2
        foreign key (product_id) references products (id)
);

create table favorites
(
    id         int auto_increment
        primary key,
    createdate datetime     null,
    productid  int          null,
    username   varchar(255) null,
    constraint FK8wudwhg5ue5oyh5398udtbgkt
        foreign key (productid) references products (id),
    constraint FKgun9e0l2253lebhqp387fxq1m
        foreign key (username) references users (username)
);

create table orders
(
    id         bigint auto_increment
        primary key,
    createdate datetime     null,
    note       varchar(255) null,
    payment    varchar(255) null,
    quantity   int          null,
    status     varchar(255) null,
    sub_total  double       null,
    total      double       null,
    updatedate datetime     null,
    address    int          null,
    username   varchar(255) null,
    discount   varchar(255) null,
    constraint FK5ul5qtyh6slfyq8i4jby7qecx
        foreign key (username) references users (username),
    constraint FKnwkqqwscw988u6gs6pclwbj18
        foreign key (discount) references discounts (id),
    constraint FKqqw5cd6q594ac1ifjxbq1cian
        foreign key (address) references address (id)
);

create table order_details
(
    id         bigint auto_increment
        primary key,
    price      double null,
    quantity   int    null,
    order_id   bigint null,
    product_id int    null,
    constraint FK4q98utpd73imf4yhttm3w0eax
        foreign key (product_id) references products (id),
    constraint FKjyu2qbqt8gnvno9oe9j2s2ldk
        foreign key (order_id) references orders (id)
);

create table users_roles
(
    user_username varchar(255) not null,
    roles_id      varchar(255) not null,
    constraint FK1y8kc6nr793297gijoc5t5qmx
        foreign key (user_username) references users (username),
    constraint FKa62j07k5mhgifpp955h37ponj
        foreign key (roles_id) references roles (id)
);

