USE ViewTheQueueDB;
CREATE TABLE restaurants(
    restaurant_name varchar(32) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    serves_vegetarian bit(1) NOT NULL,
    serves_vegan bit(1) NOT NULL,
    primary key (restaurant_name, park_name));