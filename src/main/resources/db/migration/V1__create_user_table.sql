CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    version BIGINT NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    cnh LONGBLOB NOT NULL,
    worker LONGBLOB NOT NULL,
    birth DATE
);
