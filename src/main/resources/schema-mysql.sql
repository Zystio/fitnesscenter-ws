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
    membership_type VARCHAR(50),
    status VARCHAR(50),
    billing_type VARCHAR(50),

    card_fee DECIMAL(10, 2),
    registration_fee DECIMAL(10, 2),

    payment DECIMAL(10, 2),
    payment_due_date VARCHAR(20)
    );

CREATE TABLE if NOT EXISTS purchases(
                                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        purchase_id VARCHAR(36),
    member_id VARCHAR(36),
    membership_id VARCHAR(36),
    employee_id VARCHAR(36),
    payment_type VARCHAR(50),
    credit_card_type VARCHAR(50),
    start_date DATE
    );
