CREATE DATABASE IF NOT EXISTS springdbJun2025;
USE springdbJun2025;

CREATE TABLE employee (
    empId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE
);
