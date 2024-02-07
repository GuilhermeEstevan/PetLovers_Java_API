CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) DEFAULT 'lastName',
    phone VARCHAR(255) DEFAULT ''
);