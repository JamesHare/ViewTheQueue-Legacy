USE ViewTheQueueDB;
CREATE TABLE attractions(
    attraction_name varchar(60) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    wait_time int NOT NULL,
    max_height_restriction_inches int,
    min_height_restriction_inches int,
    is_wheelchair_accessible bit(1) NOT NULL,
    has_express_line bit(1) NOT NULL,
    has_single_rider bit(1) NOT NULL,
    primary key (attraction_name, park_name));