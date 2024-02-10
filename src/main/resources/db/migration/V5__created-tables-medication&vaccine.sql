CREATE TABLE vaccine_info (
    id SERIAL PRIMARY KEY,
    vaccine_name VARCHAR(255) NOT NULL,
    dose_number VARCHAR(255) NOT NULL,
    next_due_date DATE NOT NULL
);

CREATE TABLE medication_info (
    id SERIAL PRIMARY KEY,
    medication_type VARCHAR(255) NOT NULL,
    frequency VARCHAR(255) NOT NULL,
    next_medication_date DATE NOT NULL
);