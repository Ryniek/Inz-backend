INSERT INTO user_role (id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO user (id, email, password, register_time, role_id)
VALUES (1, 'string', '$2a$10$TAqdFOrMrzi38eLfx81m3uBbX9UxuLqt0MvIRPjrRbcXjVEXaD3la', '2015-01-02 10:10:00', 1),
       (2, 'admin', '$2a$10$XM05bBKsBOuYaIjMypWBp..yiaDSN.YKrcB3k42e7We50J/uxIM/m', '2010-01-01 07:37:51', 2);

INSERT INTO department (id, name)
VALUES (1, 'Wydział Mechaniczno-Elektryczny'),
       (2, 'Wydział Nawigacji i Uzbrojenia Okrętowego');

INSERT INTO field_of_study (id, name, study_type, years, hidden, department_id)
VALUES (1, 'Informatyka', 'FIRST_FULL', '2020/2021', false, 1),
       (2, 'Informatyka', 'MILITARY', '2020/2021', false, 1),
       (3, 'Mechanika i budowa maszyn', 'FIRST_FULL', '2020/2021', false, 1),
       (4, 'Mechanika i budowa maszyn', 'SECOND_FULL', '2020/2021', false, 1),
       (5, 'Nawigacja', 'FIRST_FULL', '2020/2021', false, 2),
       (6, 'Nawigacja', 'SECOND_FULL', '2020/2021', false, 2),
       (7, 'Nawigacja', 'FIRST_PART', '2020/2021', false, 2),
       (8, 'Nawigacja', 'SECOND_PART', '2020/2021', false, 2),
       (9, 'Nawigacja', 'MILITARY', '2020/2021', false, 2),
       (10, 'Nawigacja', 'MILITARY', '2019/2020', false, 2),
       (11, 'Nawigacja', 'MILITARY', '2018/2019', true, 2);

INSERT INTO tutor (id, first_name, last_name, degree)
VALUES (1, 'Andrzej', 'Żak', 'kmdr dr hab. inż.'),
       (2, 'Patrycja', 'Trojczak', 'dr inż.'),
       (3, 'Kornelia', 'Bernaciak', 'dr inż.'),
       (4, 'Test1', 'Blabla1', 'inż.'),
       (5, 'Test2', 'Blabla2', 'kmdr dr hab. inż.'),
       (6, 'Test3', 'Blabla3', 'mgr inż.'),
       (7, 'Test4', 'Blabla4', 'kmdr dr hab. inż.'),
       (8, 'Test5', 'Blabla5', 'mgr inż.'),
       (9, 'Test6', 'Blabla6', 'kmdr dr hab. inż.'),
       (10, 'Test7', 'Blabla7', 'kmdr dr hab. inż.'),
       (11, 'Test8', 'Blabla8', 'mgr inż.');

INSERT INTO module (id, name, specialized)
VALUES (1, 'Moduł ogólnouczelniany', false),
       (2, 'Moduł matematyczny', false),
       (3, 'Moduł fizyczno-elektryczny', false),
    (4, 'Moduł informatyki ogólnej', false),
    (5, 'Moduł inżynierii komputerowej i sieci', false),
    (6, 'Moduł programowania', false),
    (7, 'Moduł systemów informatycznych', false),
    (8, 'Moduł specjalistyczny: Programowanie robotów mobilnych', true),
    (9, 'Moduł specjalistyczny: Programowanie aplikacji użytkowych', true),
    (10, 'Moduł specjalistyczny: Biznesowe systemy informatyczne', true),
    (11, 'Moduł specjalistyczny: Sieci komputerowe', true);

INSERT INTO subject (id, name, subject_code)
VALUES (1, 'Język angielski', 'Ja'),
       (2, 'Angielski zawodowy', 'Az'),
       (3, 'Matematyka', 'Mm'),
       (4, 'Fizyka', 'Ff'),
       (5, 'Podstawy informatyki', 'Pi'),
       (6, 'Systemy wbudowane', 'Sw'),
       (7, 'Języki programowania', 'Jp'),
       (8, 'Systemy operacyjne', 'So'),
       (9, 'Podstawy robotyki', 'Pr'),
       (10, 'Aplikacje internetowe', 'Ai'),
       (11, 'Zaawansowane bazy danych', 'Zbd'),
       (12, 'Usługi katalogowe', 'Uk');

INSERT INTO module_subject (module_id, subject_id)
VALUES (1, 1),(1, 2),(2, 3),(3, 4),(4, 5),(5, 6),(6, 7),(7, 8),(8, 9),
       (9, 10),(10, 11),(11, 12);

INSERT INTO contact_hours (id, lecture, exercise, laboratory, seminar, project)
VALUES (1, 1, 29, 0, 0, 0),
       (2, 10, 15, 10, 0, 0),
       (3, 10, 14, 0, 0, 0),
       (4, 10, 20, 0, 0, 0),
       (5, 5, 25, 0, 0, 0),
       (6, 10, 20, 5, 0, 0);

INSERT INTO non_contact_hours (id, consultation, exam, pwt, pwp)
VALUES (1, 5, 0, 8, 20),
       (2, 10, 4, 0, 10),
       (3, 10, 4, 0, 5),
       (4, 10, 4, 0, 5),
       (5, 10, 4, 0, 5),
       (6, 10, 4, 0, 5);

INSERT INTO educational_outcomes (id, code, content, type, for_subject, for_field)
VALUES (1, 'W1', 'Ma elementarną  wiedzę z prawa gospodarczego i prawa autorskiego oraz wiedzę w zakresie inżynierskich  uwarunkowań działań o charakterze ekonomiczno-zarządczym.', 'KNOWLEDGE', true, false),
       (2, 'W2', 'Ma uporządkowaną wiedzę z matematyki i metod jej stosowania,  zna podstawowe prawa i twierdzenia matematyki, w tym matematyki dyskretnej i metod probabilistycznych', 'KNOWLEDGE', true, false),
       (3, 'U1', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki', 'SKILLS', true, false),
       (4, 'U2', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie', 'SKILLS', true, false),
       (5, 'K1', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL', true, false),
       (6, 'K2', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL', true, false);

INSERT INTO field_module (id, field_of_study_id, module_id, tutor_id)
VALUES (1, 1, 1, 1), (2, 1, 2, 2), (3, 1, 3, 3), (4, 1, 8, 4), (5, 1, 9, 5);

INSERT INTO field_module_subject (id, ects, semester, field_module_id, subject_id, tutor_id, contact_hours_id, non_contact_hours_id)
VALUES (1, 5, 1, 1, 1, 2, 1, 1), (2, 4, 2, 1, 1, 2, 2, 2), (3, 1, 3, 1, 2, 2, 3, 3),
       (4, 8, 1, 2, 3, 3, 4, 4), (5, 4, 2, 2, 3, 3, 5, 5),
       (6, 3, 5, 3, 4, 5, 6, 6),
       (7, 8, 6, 4, 9, 6, 7, 7),
       (8, 10, 7, 5, 10, 7, 8, 8);




