USE ViewTheQueueDB;
CREATE TABLE parks(
    park_name varchar(32) NOT NULL,
    description varchar(120),
    operation_status varchar(6) NOT NULL,
    opening_time time,
    closing_time time,
    primary key (park_name)
);