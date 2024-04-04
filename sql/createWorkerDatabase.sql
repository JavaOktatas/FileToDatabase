DROP DATABASE IF EXISTS tanar_worker;
CREATE DATABASE tanar_worker;
USE tanar_worker;

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