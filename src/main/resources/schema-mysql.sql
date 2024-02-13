create table if not exists members (
                                       id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       member_id VARCHAR(36),
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

create table if not exists employees (
                                         id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         employee_id VARCHAR(36),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    department VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9),
    salary DECIMAL(10, 2),
    commission_rate DECIMAL(10, 2)
    );

CREATE TABLE IF NOT EXISTS member_phonenumbers (
    member_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS employee_phonenumbers (
    employee_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS memberships(
                                           id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           membership_id VARCHAR(36),
    type VARCHAR(50),
    status VARCHAR(50),
    billing_type VARCHAR(50),
    card_fee DECIMAL(10, 2),
    registration_fee DECIMAL(10, 2),
    monthly_fee DECIMAL(10, 2)
    );
