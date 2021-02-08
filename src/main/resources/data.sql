INSERT INTO user_role (id, name)
VALUES (1, 'USER');

INSERT INTO user (id, email, password, register_time, role_id)
VALUES (1, 'test', '$2a$10$XM05bBKsBOuYaIjMypWBp..yiaDSN.YKrcB3k42e7We50J/uxIM/m', '2010-01-01 07:37:51', 1),
       (2, 'string', '$2a$10$TAqdFOrMrzi38eLfx81m3uBbX9UxuLqt0MvIRPjrRbcXjVEXaD3la', '2015-01-02 10:10:00', 1);