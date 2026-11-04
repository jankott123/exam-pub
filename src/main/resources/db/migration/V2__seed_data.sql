INSERT INTO users (name, username, password, role, is_active, is_adult, pocket) VALUES
                                                                                    ('Bartender',  'bartender', '$2a$10$Ky/usw8zp41Tg.FwF0A2sOczCOm1ssNUSgBxyzTx0uSz.eRNqs3Q6', 'BARTENDER', TRUE,  TRUE,    0.00),
                                                                                    ('Jan Novak',  'jan',       '$2a$10$Ky/usw8zp41Tg.FwF0A2sOczCOm1ssNUSgBxyzTx0uSz.eRNqs3Q6', 'CUSTOMER',  TRUE,  TRUE,  500.00),
                                                                                    ('Petr Maly',  'petr',      '$2a$10$Ky/usw8zp41Tg.FwF0A2sOczCOm1ssNUSgBxyzTx0uSz.eRNqs3Q6', 'CUSTOMER',  TRUE,  FALSE, 200.00),
                                                                                    ('Eva Chuda',  'eva',       '$2a$10$Ky/usw8zp41Tg.FwF0A2sOczCOm1ssNUSgBxyzTx0uSz.eRNqs3Q6', 'CUSTOMER',  TRUE,  TRUE,   30.00),
                                                                                    ('Karel Stary','karel',     '$2a$10$Ky/usw8zp41Tg.FwF0A2sOczCOm1ssNUSgBxyzTx0uSz.eRNqs3Q6', 'CUSTOMER',  FALSE, TRUE,  300.00);

INSERT INTO products (name, price, is_for_adult) VALUES
                                                     ('Pilsner Urquell', 55.00, TRUE),
                                                     ('Becherovka',      70.00, TRUE),
                                                     ('Rum',             80.00, TRUE),
                                                     ('Kofola',          45.00, FALSE),
                                                     ('Lemonade',        40.00, FALSE),
                                                     ('Water',           25.00, FALSE);