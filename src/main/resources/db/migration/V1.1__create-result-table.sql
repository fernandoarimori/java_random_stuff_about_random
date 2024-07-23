CREATE TABLE tb_result (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    weight decimal(10, 2) NOT NULL,
    sex_orientation varchar(1) NOT NULL,
    camps varchar(255) NOT NULL,
    persons int,
    PRIMARY KEY (id),
    FOREIGN KEY (persons) REFERENCES tb_person(id)
);