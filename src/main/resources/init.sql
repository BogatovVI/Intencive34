CREATE TABLE orders (
    Id bigserial PRIMARY KEY,
    Name varchar(55) NOT NULL
);

CREATE TABLE users (
    Id bigserial PRIMARY KEY,
    Name varchar(55) NOT NULL,
    Surname varchar(55) NOT NULL,
    Telephone varchar(55) NOT NULL,
    Email varchar(255) NOT NULL,
    Id_order bigint,
    FOREIGN KEY (Id_order) REFERENCES orders (id)
);

SELECT * FROM users JOIN orders o on o.Id = users.Id_order;