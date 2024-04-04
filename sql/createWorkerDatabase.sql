DROP DATABASE IF EXISTS resahh_worker;
CREATE DATABASE resahh_worker;
USE resahh_worker;

CREATE TABLE cities (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city VARCHAR( 20 )
);

CREATE TABLE workers (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR( 50 ),
    address VARCHAR( 100 ),
    salary INTEGER,
    bonus INTEGER,
    borndate date,
    hiredate date,
    city_id INTEGER,
    FOREIGN KEY( city_id ) REFERENCES cities( id )
);