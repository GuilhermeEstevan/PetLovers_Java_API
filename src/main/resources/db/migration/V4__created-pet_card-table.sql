CREATE TABLE pet_cards (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    service_type VARCHAR(255) NOT NULL,
    service VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    date DATE NOT NULL
);