DROP DATABASE IF EXISTS calories_db;

CREATE DATABASE calories_db;

USE calories_db;

CREATE TABLE product_calories(

id INT PRIMARY KEY,

product VARCHAR(500),

kcal INT NOT NULL,

protein float NOT NULL,

carbs  float NOT NULL,

fat float NOT NULL

);