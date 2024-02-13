insert into members (member_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('c3540a89-cb47-4c96-888e-ff96708db4d8', 'Alick', 'Ucceli', 'aucceli0@dot.gov', '73 Shoshone Road', 'Barraute', 'Québec', 'Canada', 'P0M 2T6');
insert into members (member_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('c8d41d17-68f9-4b2a-8a87-55db7d13d47f', 'François', 'Xavier', 'fxav@gmail.com', '73 Rue du Savoir', 'Brossard', 'Québec', 'Canada', 'J2Z 0L1');
insert into members (member_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('a8759f44-fd54-4c72-91a6-c216ab6eb52c', 'Mary', 'Johnson', 'maryjohnson@yahoo.com', '456 Elm St', 'Vancouver', 'British Columbia', 'Canada', 'V6B 2N9');
insert into members (member_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('b12a6c79-0a77-4217-a1cc-2e4d53e4c43d', 'John', 'Doe', 'johndoe@gmail.com', '789 Main St', 'Toronto', 'Ontario', 'Canada', 'M5V 2H1');

insert into employees (employee_id, first_name, last_name, email_address, department, street_address, city, province, country, postal_code, salary, commission_rate) values ('e3540a89-cb47-4c96-888e-ff96708db4d8', 'John', 'Doe', 'johndoe@gmail.com', 'SALES', '6753 Karmine St.', 'Montreal', 'Québec', 'Canada', 'J4Z0J2', 25000.00, 0.10);

insert into member_phonenumbers(member_id, type, number)
values (1, 'WORK', '515-555-5555');
insert into member_phonenumbers(member_id, type, number)
values (1, 'MOBILE', '514-555-4444');

insert into employee_phonenumbers(employee_id, type, number)
values (1, 'WORK', '515-123-1234');
insert into employee_phonenumbers(employee_id, type, number)
values (1, 'MOBILE', '514-333-1233');