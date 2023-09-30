CREATE TABLE orders (
    Id int primary key,
    User_id int,
    Name varchar(55) NOT NULL,
    Order_face varchar(55),
    foreign key (user_id) references users(id)
);

CREATE TABLE users (
    Id int primary key ,
    Name varchar(55),
    Surname varchar(55),
    Birthday date,
    Telephone varchar(55),
    Email varchar(255),
    Meta json,
    dtype text
);