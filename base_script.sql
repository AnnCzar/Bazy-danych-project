DROP DATABASE IF EXISTS calories_base;

CREATE DATABASE calories_base;

USE calories_base;

CREATE TABLE users(
user_name VARCHAR(100) PRIMARY KEY NOT NULL,
sex ENUM("M","F") NOT NULL,
weight FLOAT NOT NULL,
height FLOAT NOT NULL,
age INT,
avg_activity ENUM("brak", "mała", "umiarkowana", "duża", "bardzo duża", "zawodowa"),
goal ENUM("schudnąć", "utrzymać wagę", "przytyć")
);

CREATE TABLE daily_consumption(
id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
date DATE NOT NULL,
meals MEDIUMTEXT,
kalc FLOAT NOT NULL,
proteins FLOAT NOT NULL,
fat FLOAT NOT NULL,
carbs FLOAT NOT NULL,
user_name VARCHAR(100),
FOREIGN KEY (user_name) REFERENCES users(user_name)
);

CREATE TABLE meals(
meal_id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
meal_name VARCHAR(100) NOT NULL,
kalc FLOAT NOT NULL,
proteins FLOAT NOT NULL,
fat FLOAT NOT NULL,
carbs FLOAT NOT NULL,
products MEDIUMTEXT,
daily_consumption INT,
FOREIGN KEY (daily_consumption) REFERENCES daily_consumption(id)
);

CREATE TABLE products(
product_id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
product_name VARCHAR(100) NOT NULL,
kalc FLOAT NOT NULL,
proteins FLOAT NOT NULL,
carbs FLOAT NOT NULL,
fat FLOAT NOT NULL,
daily_consumption INT,
FOREIGN KEY (daily_consumption) REFERENCES daily_consumption(id)
);

CREATE TABLE products_to_meals(
product_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(product_id),
meal_id INT NOT NULL,
FOREIGN KEY (meal_id) REFERENCES meals(meal_id)
);

CREATE TABLE archive(
archive_id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
avg_kalc FLOAT,
weight FLOAT,
end_date DATE,
avg_activity ENUM("brak", "mała", "umiarkowana", "duża", "bardzo duża", "zawodowa"),
goal ENUM("schudnąć", "utrzymać wagę", "przytyć")
);

