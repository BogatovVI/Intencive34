CREATE TABLE orders (
    Id serial,
    Name varchar(55) NOT NULL,
    Order_face varchar(55)
);

CREATE TABLE users (
    Id serial,
    Name varchar(55),
    Surname varchar(55),
    Birthday date,
    Telephone varchar(55),
    Email varchar(255),
    Meta json,
    Id_order int,
    dtype text
--     FOREIGN KEY (Id_order) REFERENCES orders (id)
);

SELECT * FROM users JOIN orders o on o.Id = users.Id_order;