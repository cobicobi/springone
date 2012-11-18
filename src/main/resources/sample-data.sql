INSERT INTO user_data(id, name, password, username) VALUES (1, 'W. Priyambodo', 'qwertyuiop', 'cobicobi');
INSERT INTO user_data(id, name, password, username) VALUES (2, 'B. Adiantoro', 'asdfghjkl', 'arms');
INSERT INTO user_data(id, name, password, username) VALUES (3, 'B. Triyatmojo', 'zxcvbnm', 'ace');

INSERT INTO role(id, name) VALUES (1, 'user');
INSERT INTO role(id, name) VALUES (2, 'admin');

INSERT INTO user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO user_role(user_id, role_id) VALUES (2, 1);
INSERT INTO user_role(user_id, role_id) VALUES (3, 1);
