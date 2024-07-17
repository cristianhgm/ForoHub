CREATE TABLE topics (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE,
    message VARCHAR(400) NOT NULL UNIQUE,
    creationDate VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL,
    author INT NOT NULL,
    course VARCHAR(100) NOT NULL
);
