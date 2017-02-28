INSERT INTO spectral_line (atom, atomic_number, line_length, spectral_line_order, satellite_type)
VALUES
('O', 3, 52, 1, 0),
('N', 3, 57, 2, 0),
('O', 1, 63, 3, 0),
('O', 3, 88, 4, 0),
('N', 2, 122, 5, 0),
('O', 1, 145, 6, 0),
('C', 2, 158, 7, 0),
('S', 4, 10.5, 1, 1),
('Ne', 2, 12.8000002, 2, 1),
('Ne', 5, 14.3000002, 3, 1),
('Ne', 3, 15.6000004, 4, 1),
('S', 3, 18.7000008, 5, 1),
('Ne', 5, 24.2999992, 6, 1),
('O', 4, 25.8999996, 7, 1),
('S', 3, 33.5, 8, 1),
('Si', 2, 34.7999992, 9, 1);


INSERT INTO users (cognome, email, nome, password, ruolo, userid)
VALUES
('admin','admin@admin.com', 'admin', 'admin',0,'admin'),
('user', 'user@user.com', 'user', 'user', 1, 'user');