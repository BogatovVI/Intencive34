CREATE TABLE orders (
    id int,
    user_id int,
    order_name varchar(55) NOT NULL,
    order_face varchar(55),
    foreign key (user_id) references "public".users (id)
);

CREATE TABLE users (
    id int primary key ,
    user_name varchar(55),
    user_surname varchar(55),
    birthday date,
    telephone varchar(55),
    email varchar(255),
    meta json,
/*    id_order int,*/
    dtype text
--     FOREIGN KEY (Id_order) REFERENCES orders (id)
);

SELECT * FROM users u
INNER JOIN orders o
on u.id = o.user_id;

SELECT * FROM users
SELECT * FROM orders