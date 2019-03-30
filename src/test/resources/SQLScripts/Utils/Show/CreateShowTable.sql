USE ViewTheQueueDB;
CREATE TABLE shows(
    show_name varchar(32) NOT NULL,
    description varchar(120),
    park_name varchar(32) NOT NULL,
    area varchar(32) NOT NULL,
    operation_status varchar(6) NOT NULL,
    is_wheelchair_accessible bit(1) NOT NULL,
    has_express_line bit(1) NOT NULL,
    show_times varchar(70),
    primary key (show_name, park_name));