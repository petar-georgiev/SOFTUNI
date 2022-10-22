CREATE DATABASE `minions`;
USE `minions`;

CREATE TABLE `minions` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` INT
);

CREATE TABLE `towns` (
    `town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`town_id`);

INSERT INTO `towns` 
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO `minions` 
VALUES
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

CREATE TABLE `people` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200),
    `picture` BLOB,
    `height` FLOAT(5 , 2 ),
    `weight` FLOAT(5 , 2 ),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

CREATE TABLE `users` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30),
    `password` VARCHAR(26),
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

ALTER TABLE `USERS`
DROP PRIMARY KEY,
ADD CONSTRAINT PK_USERS
PRIMARY KEY (`ID`, `USERNAME`);

ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE;

CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` VARCHAR(100) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns FOREIGN KEY (`town_id`)
        REFERENCES `towns` (`id`)
);

CREATE TABLE `departments` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `employees` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `middle_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `job_title` VARCHAR(30),
    `department_id` INT,
    `hire_date` DATE,
    `salary` DECIMAL(10 , 2 ),
    `address_id` INT,
    CONSTRAINT fk_employees_deparments FOREIGN KEY (`department_id`)
        REFERENCES `departments` (`id`),
    CONSTRAINT fk_employees_addresses FOREIGN KEY (`address_id`)
        REFERENCES `addresses` (`id`)
);

INSERT INTO `towns` (`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');


INSERT INTO `departments` (`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');


INSERT INTO `employees` 
VALUES
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, NULL),
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, NULL),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, NULL),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00, NULL),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, NULL);

SELECT * FROM `towns`
ORDER BY `name`;

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

SELECT `name` FROM `towns`
ORDER BY `name`;

SELECT `name` FROM `departments`
ORDER BY `name`;

SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`
ORDER BY `salary` DESC;

UPDATE `employees`
SET `salary` = `salary` * 1.1;

SELECT `salary` FROM `employees`;


