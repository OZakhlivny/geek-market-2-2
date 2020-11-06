create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  name                  varchar(50),
  surname               varchar(50),
  phone                 varchar(20) unique,
  primary key (id)
);

create table user_profiles (
  id                    bigserial,
  user_id               bigint not null unique,
  gender                char(1),
  birth_year            int,
  hometown              varchar(100),
  primary key (id),
  foreign key (user_id) references users (id)
);


create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('SOMETHING');

insert into users (username, password, email, name, surname)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com', 'User', 'Userov');

insert into user_profiles (user_id, gender, birth_year, hometown)
values
(1, 'М', 1985, 'Rostov on Don');

insert into users_roles (user_id, role_id) values (1, 1), (1, 2);

create table categories (
    id                      bigserial primary key,
    title                   varchar(255)
);

create table products (
    id                      bigserial primary key,
    title                   varchar(255),
    price                   int,
    category_id             bigint references categories (id)
);

create table orders (
    id                      bigserial primary key,
    user_id                 bigint references users(id),
    price                   int,
    address                 varchar(1000)
);

create table order_items (
    id                      bigserial primary key,
    product_id              bigint references products(id),
    order_id                bigint references orders(id),
    price                   int,
    price_per_product       int,
    quantity                int
);

insert into categories (title)
values
('Food'),
('Notebook'),
('Smartphone');

insert into products (title, price, category_id)
values
('Bread', 1, 1),
('Samsung V100', 2, 3),
('Acer X1000', 3, 2);

