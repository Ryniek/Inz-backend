INSERT INTO user_role (id, name)
VALUES (1, 'USER');

INSERT INTO user (id, email, password, register_time, role_id)
VALUES (1, 'test', '$2a$10$XM05bBKsBOuYaIjMypWBp..yiaDSN.YKrcB3k42e7We50J/uxIM/m', '2010-01-01 07:37:51', 1);