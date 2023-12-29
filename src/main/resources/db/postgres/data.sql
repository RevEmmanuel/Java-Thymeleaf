INSERT INTO vets (first_name, last_name, password, country) SELECT 'James', 'Carter', 'password', 'USA' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=1);
INSERT INTO vets (first_name, last_name, password, country) SELECT 'Helen', 'Leary', 'password', 'Canada' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=2);
INSERT INTO vets (first_name, last_name, password, country) SELECT 'Linda', 'Douglas', 'password', 'UK' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=3);
INSERT INTO vets (first_name, last_name, password, country) SELECT 'Rafael', 'Ortega', 'password', 'Germany' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=4);
INSERT INTO vets (first_name, last_name, password, country) SELECT 'Henry', 'Stevens', 'password', 'France' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=5);
INSERT INTO vets (first_name, last_name, password, country) SELECT 'Sharon', 'Jenkins', 'password', 'UK' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=6);

INSERT INTO specialties (name) SELECT 'radiology' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='radiology');
INSERT INTO specialties (name) SELECT 'surgery' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='surgery'); 
INSERT INTO specialties (name) SELECT 'dentistry' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='dentistry');

INSERT INTO vet_specialties VALUES (2, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 3) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (4, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (5, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;

INSERT INTO types (name) SELECT 'cat' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='cat');
INSERT INTO types (name) SELECT 'dog' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='dog');
INSERT INTO types (name) SELECT 'lizard' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='lizard');
INSERT INTO types (name) SELECT 'snake' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='snake');
INSERT INTO types (name) SELECT 'bird' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='bird');
INSERT INTO types (name) SELECT 'hamster' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='cat');

INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=1);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=2);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=3);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=4);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=5);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=6);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=7);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=8);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=9);
INSERT INTO owners (first_name, last_name, address, city, telephone, password) SELECT 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'password' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=10);

INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Leo', '2000-09-07', 1, 1 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=1);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Basil', '2002-08-06', 6, 2 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=2);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Rosy', '2001-04-17', 2, 3 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=3);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Jewel', '2000-03-07', 2, 3 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=4);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Iggy', '2000-11-30', 3, 4 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=5);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'George', '2000-01-20', 4, 5 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=6);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Samantha', '1995-09-04', 1, 6 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=7);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Max', '1995-09-04', 1, 6 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=8);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Lucky', '1999-08-06', 5, 7 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=9);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Mulligan', '1997-02-24', 2, 8 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=10);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Freddy', '2000-03-09', 5, 9 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=11);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Lucky', '2000-06-24', 2, 10 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=12);
INSERT INTO pets (name, birth_date, type_id, owner_id) SELECT 'Sly', '2002-06-08', 1, 10 WHERE NOT EXISTS (SELECT * FROM pets WHERE id=13);

INSERT INTO visits (pet_id, visit_date, description) SELECT 7, '2010-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=1);
INSERT INTO visits (pet_id, visit_date, description) SELECT 8, '2011-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=2);
INSERT INTO visits (pet_id, visit_date, description) SELECT 8, '2009-06-04', 'neutered' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=3);
INSERT INTO visits (pet_id, visit_date, description) SELECT 7, '2008-09-04', 'spayed' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=4);

-- Sample SQL statements to generate dummy data for vet_service table
INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (1, 'Regular Checkup', 50.00),
                                                                (1, 'Vaccinations', 30.00),
                                                                (1, 'Dental Cleaning', 80.00),
                                                                (1, 'Regular Checkup 2', 50.00),
                                                                (1, 'Vaccinations 2', 30.00),
                                                                (1, 'Dental Cleaning 2', 80.00);

INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (2, 'Surgery', 200.00),
                                                                (2, 'X-Ray', 120.00),
                                                                (2, 'Ultrasound', 150.00),
                                                                (2, 'Surgery 2', 200.00),
                                                                (2, 'X-Ray 2', 120.00),
                                                                (2, 'Ultrasound 2', 150.00);

INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (3, 'Flea Treatment', 40.00),
                                                                (3, 'Micro chipping', 60.00),
                                                                (3, 'Behavioral Counseling', 90.00),
                                                                (3, 'Flea Treatment 2', 40.00),
                                                                (3, 'Micro chipping 2', 60.00),
                                                                (3, 'Behavioral Counseling 2', 90.00);

INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (4, 'Emergency Care', 250.00),
                                                                (4, 'Ophthalmology', 110.00),
                                                                (4, 'Dermatology', 85.00),
                                                                (4, 'Emergency Care 2', 250.00),
                                                                (4, 'Ophthalmology 2', 110.00),
                                                                (4, 'Dermatology 2', 85.00);

INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (5, 'Nutrition Consultation', 70.00),
                                                                (5, 'Geriatric Care', 55.00),
                                                                (5, 'Physical Therapy', 95.00),
                                                                (5, 'Nutrition Consultation 2', 70.00),
                                                                (5, 'Geriatric Care 2', 55.00),
                                                                (5, 'Physical Therapy 2', 95.00);

INSERT INTO vet_service (vet_id, service_name, service_price) VALUES
                                                                (6, 'Radiation Therapy', 300.00),
                                                                (6, 'Alternative Medicine', 180.00),
                                                                (6, 'Surgical Oncology', 270.00),
                                                                (6, 'Radiation Therapy 2', 300.00),
                                                                (6, 'Alternative Medicine 2', 180.00),
                                                                (6, 'Surgical Oncology 2', 270.00);

INSERT INTO taxes (id, country, percentage) VALUES
                                              (1, 'USA', 7.5),
                                              (2, 'Canada', 8.0),
                                              (3, 'UK', 6.2),
                                              (4, 'Germany', 9.5),
                                              (5, 'France', 7.8);
