CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100),
    status VARCHAR(20),
    creation_date DATE
);