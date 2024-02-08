create table if not exists clients (
                                       id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       client_id VARCHAR(36),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9)
--     membership_id VARCHAR(36) add later when membership is created
    );

CREATE TABLE IF NOT EXISTS client_phonenumbers (
    client_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
);
