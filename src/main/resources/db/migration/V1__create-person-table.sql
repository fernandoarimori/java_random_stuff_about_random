CREATE TABLE tb_person (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    weight decimal(10, 2) NOT NULL,
    sex_orientation varchar(1) NOT NULL,
    result int,
    PRIMARY KEY (id)
);