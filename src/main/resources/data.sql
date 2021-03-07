INSERT INTO user_role (id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO user (id, email, password, register_time, role_id)
VALUES (1, 'string', '$2a$10$TAqdFOrMrzi38eLfx81m3uBbX9UxuLqt0MvIRPjrRbcXjVEXaD3la', '2015-01-02 10:10:00', 1),
       (2, 'admin', '$2a$10$2KTTKAOHETH3GLDaXkd7Su09G9EsE7h00Ycnk68rGc0QsWCvPZfCm', '2010-01-01 07:37:51', 2);

INSERT INTO department (id, name)
VALUES (1, 'Wydział Mechaniczno-Elektryczny'),
       (2, 'Wydział Nawigacji i Uzbrojenia Okrętowego');

INSERT INTO major (id, name, study_type, years, hidden, department_id)
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
VALUES (1, 1, 29, 0, 0, 0), (2, 10, 15, 10, 0, 0), (3, 10, 14, 0, 0, 0), (4, 10, 20, 0, 0, 0), (5, 5, 25, 0, 0, 0),(6, 10, 20, 5, 0, 0),
       (7, 1, 29, 0, 0, 0), (8, 10, 15, 10, 0, 0), (9, 10, 14, 0, 0, 0), (10, 10, 20, 0, 0, 0), (11, 5, 25, 0, 0, 0),(12, 10, 20, 5, 0, 0),
       (13, 10, 20, 5, 0, 0),(14, 10, 20, 5, 0, 0),(15, 10, 20, 5, 0, 0),(16, 10, 20, 5, 0, 0);

INSERT INTO non_contact_hours (id, consultation, exam, pwt, pwp)
VALUES (1, 5, 0, 8, 20),(2, 10, 4, 0, 10),(3, 10, 4, 0, 5),(4, 10, 4, 0, 5),(5, 10, 4, 0, 5),(6, 10, 4, 0, 5),
       (7, 5, 0, 8, 20),(8, 10, 4, 0, 10),(9, 10, 4, 0, 5),(10, 10, 4, 0, 5),(11, 10, 4, 0, 5),(12, 10, 4, 0, 5),
       (13, 10, 4, 0, 5),(14, 10, 4, 0, 5),(15, 10, 4, 0, 5),(16, 10, 4, 0, 5);

INSERT INTO effect (id, code, content, type, for_subject, for_major)
VALUES (1, 'W1', 'Ma elementarną  wiedzę z prawa gospodarczego i prawa autorskiego oraz wiedzę w zakresie inżynierskich  uwarunkowań działań o charakterze ekonomiczno-zarządczym.', 'KNOWLEDGE', true, false),
       (2, 'W2', 'Ma uporządkowaną wiedzę z matematyki i metod jej stosowania,  zna podstawowe prawa i twierdzenia matematyki, w tym matematyki dyskretnej i metod probabilistycznych', 'KNOWLEDGE', true, false),
       (3, 'U1', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki', 'SKILLS', true, false),
       (4, 'U2', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie', 'SKILLS', true, false),
       (5, 'K1', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL', true, false),
       (6, 'K2', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL', true, false),
       (7, 'N1_W02', 'Ma wiedzę ogólną o biosferze, fizyce atmosfery i oceanów, zna zasady i specyfikę wykonywania pomiarów hydrometeorologicznych.', 'KNOWLEDGE', false, true),
       (8, 'N1_W03', 'Ma podstawową wiedzę w zakresie właściwości fizykochemicznych transportowanych ładunków i ich charakterystyki. ', 'KNOWLEDGE', false, true),
       (9, 'I1_W06', 'Ma podstawową wiedzę w zakresie grafiki komputerowej, zna podstawowe metody komunikacji z komputerem', 'KNOWLEDGE', false, true),
       (10, 'I1_W10', 'Zna wybrane języki programowania, ma wiedzę w zakresie stosowanych technik programowania, a także projektowania i wytwarzania aplikacji i systemów inf.', 'KNOWLEDGE', false, true),
       (11, 'I1_W11', 'Ma wiedzę z algorytmizacji i podstaw tworzenia i przetwarzania struktur danych.', 'KNOWLEDGE', false, true),
       (12, 'I1_U01', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki.', 'SKILLS', false, true),
       (13, 'I1_U02', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie.', 'SKILLS', false, true),
       (14, 'I1_U03', 'Potrafi ocenić pod kątem ekonomicznym i zarządczym znaczenie podejmowanych przez siebie działań inżynierskich oraz scharakteryzować podstawowe zasady aktywności gospodarczej.', 'SKILLS', false, true),
       (15, 'I1_U18', 'Potrafi administrować wybranymi systemami informatycznymi, w tym korzystać z właściwych technik zabezpieczających.', 'SKILLS', false, true),
       (16, 'I1_U19', 'Potrafi zaprojektować i wykonać relacyjna bazę danych oraz skonstruować przykładowe zapytanie SQL.', 'SKILLS', false, true),
       (17, 'I1_K01', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL', false, true),
       (18, 'I1_K02', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL', false, true),
       (19, 'I1_K03', 'Rozumie społeczny i zawodowy kontekst informatyki, jej zasady prawne i etyczne oraz  świadomie stosuje się do przepisów obowiązującego prawa, przestrzega zasad etyki zawodowej.', 'SOCIAL', false, true),
       (20, 'I1_K04', 'Rozumie znaczenie pojęć istotnych  w procesie kształtowania postaw takich jak patriotyzm, humanizm, tolerancja, współpraca wielokulturowa.', 'SOCIAL', false, true);

INSERT INTO major_module (id, major_id, module_id, tutor_id)
VALUES (1, 1, 1, 1), (2, 1, 2, 2), (3, 1, 3, 3), (4, 1, 8, 4), (5, 1, 9, 5),
       (6, 5, 1, 1), (7, 5, 2, 2), (8, 5, 3, 3), (9, 5, 8, 4), (10, 5, 9, 5);

INSERT INTO major_module_subject (id, ects, semester, major_module_id, subject_id, tutor_id, contact_hours_id, non_contact_hours_id)
VALUES (1, 5, 1, 1, 1, 2, 1, 1), (2, 4, 2, 1, 1, 2, 2, 2), (3, 1, 3, 1, 2, 2, 3, 3), (4, 8, 1, 2, 3, 3, 4, 4),
       (5, 4, 2, 2, 3, 3, 5, 5), (6, 3, 5, 3, 4, 5, 6, 6), (7, 8, 6, 4, 9, 6, 7, 7), (8, 10, 7, 5, 10, 7, 8, 8),
       (9, 5, 1, 6, 1, 2, 9, 9), (10, 4, 2, 6, 1, 2, 10, 10), (11, 1, 3, 6, 2, 2, 11, 11), (12, 8, 1, 7, 3, 3, 12, 12),
       (13, 4, 2, 7, 3, 3, 13, 13), (14, 3, 5, 8, 4, 5, 14, 14), (15, 8, 6, 9, 9, 6, 15, 15), (16, 10, 7, 10, 10, 7, 16, 16);

INSERT INTO subject_effect (subject_id, effect_id, connection_strength)
VALUES (1, 1, 2), (4, 2, 3), (2, 2, 2), (3, 3, 3), (4, 4, 3), (5, 5, 1), (6, 5, 1), (7, 6, 2), (8, 6, 3),
       (9, 1, 2), (10, 2, 3), (11, 2, 2), (12, 3, 3), (4, 5, 3), (6, 2, 1), (8, 4, 1), (9, 4, 2), (10, 5, 3);

INSERT INTO major_effect (major_id, effect_id)
VALUES (1, 7), (1, 9), (1, 14), (1, 17), (1, 19),
       (2, 8), (2, 10), (2, 12), (2, 14), (2, 16), (2, 18),
       (3, 8), (3, 9), (3, 13), (3, 14), (3, 15), (3, 18), (3, 20),
       (4, 12), (4, 16), (4, 17),
       (5, 9), (5, 14), (5, 18),
       (6, 11), (6, 19),
       (7, 11), (7, 15), (7, 16),
       (8, 17),
       (9, 14), (9, 15),
       (10, 17), (10, 18), (10, 19),
       (11, 9), (11, 10);




