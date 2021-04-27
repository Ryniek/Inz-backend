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
       (4, 'TestoweImie1', 'TestoweNazwisko1', 'inż.'),
       (5, 'TestoweImie2', 'TestoweNazwisko2', 'kmdr dr hab. inż.'),
       (6, 'TestoweImie3', 'TestoweNazwisko3', 'mgr inż.'),
       (7, 'TestoweImie4', 'TestoweNazwisko4', 'kmdr dr hab. inż.'),
       (8, 'TestoweImie5', 'TestoweNazwisko5', 'mgr inż.'),
       (9, 'TestoweImie6', 'TestoweNazwisko6', 'kmdr dr hab. inż.'),
       (10, 'TestoweImie7', 'TestoweNazwisko7', 'kmdr dr hab. inż.'),
       (11, 'TestoweImie8', 'TestoweNazwisko8', 'mgr inż.');

INSERT INTO module (id, name, specialized)
VALUES (1, 'Moduł ogólnouczelniany', false),
       (2, 'Moduł matematyczny', false),
       (3, 'Moduł fizyczno-elektryczny', false),
    (4, 'Moduł informatyki ogólnej', false),
    (5, 'Moduł inżynierii komputerowej i sieci', false),
    (6, 'Moduł programowania', false),
    (7, 'Moduł systemów informatycznych', false),
    (8, 'Moduł specjalistyczny: Programowanie aplikacji użytkowych', true),
    (9, 'Moduł specjalistyczny: Sieci komputerowe', true),
    (10, 'Realizacja projektu zespołowego', false);


INSERT INTO subject (id, name, subject_code)
VALUES (1, 'Język angielski', 'Ja'), (2, 'Angielski zawodowy', 'Az'), (3, 'Wychowanie fizyczne', 'Wf'), (4, 'Podstawy przedsiębiorczości', 'Pp'), (5, 'Ochrona właśności intelektualnej', 'Owi'), (6, 'Podstawy ekonomii', 'H1'), (7, 'Podstawy logiki', 'H2'), (8, 'Historia Polski - wybrane aspekty', 'Hp'),
       (9, 'Matematyka', 'Mm'), (10, 'Matematyka dyskretna', 'Md'), (11, 'Metody probabilistyczne', 'Mp'), (12, 'Metody numeryczne', 'Mn'),
       (13, 'Fizyka', 'Ff'), (14, 'Podstawy elektrotechniki', 'Pet'), (15, 'Podstawy elektroniki', 'Pee'), (16, 'Układy cyfrowe', 'Uc'), (17, 'Podstawy automatyki', 'Pa'),
       (18, 'Podstawy informatyki', 'Pi'), (19, 'Grafika i komunikacja człowiek-komputer', 'Gkc'), (20, 'Zarządzanie projektami informatycznymi', 'Zpi'), (21, 'Problemy społeczne i zawodowe informatyka', 'Psz'),
       (22, 'Architektura systemów komputerowych', 'Ask'), (23, 'Systemy wbudowane', 'Sw'), (24, 'Sterowniki programowalne', 'Sp'), (25, 'Sieci komputerowe', 'Sk'), (26, 'Sieci bezprzewodowe', 'Sb'),
       (27, 'Języki programowania', 'Jp'), (28, 'Podstawy programowania', 'Pp'), (29, 'Programowanie inżynierskie Matlab', 'Pim'), (30, 'Metodologia programowania', 'Mp'), (31, 'Algorytmy i złożoności', 'Az'), (32, 'Inżynieria oprogramowania', 'Io'),
       (33, 'Systemy operacyjne', 'So'), (34, 'Bazy danych', 'Bd'), (35, 'Sztuczna inteligencja', 'Si'), (36, 'Bezpieczeństwo systemów informatycznych', 'Bsi'),
       (37, 'Projektowanie serwisów WWW', 'Psw'), (38, 'Zaawansowane bazy danych', 'Zbd'), (39, 'Aplikacje internetowe', 'Ai'), (40, 'Aplikacje mobilne dla systemu Android', 'Ama'), (41, 'Aplikacje w architekturze klient-serwer', 'Amw'), (42, 'Wstęp do uczenia maszynowego', 'Prr'), (43, 'Architektura zorientowana na usługi', 'Azu'), (44, 'Bezpieczeństwo serwisów internetowych', 'Bin'),
       (45, 'Protokoły sieci teleinformatycznych', 'Pst'), (46, 'Administrowanie serwerami', 'As'),(47, 'Routing w sieciach informatycznych', 'Rsi'),(48, 'Projektowanie i infrastuktura sieci', 'Psi'),(49, 'Technologie sieci rozległych', 'Tsr'),(50, 'Usługi katalogowe', 'Uk'),(51, 'Zarządzanie sieciami komputerowymi', 'Zsk'),(52, 'Bezpieczeństwo sieci', 'Bs'),
       (53, 'Zespołowe przedsięwzięcia inżynierskie', 'Zpi'), (54, 'Przygotownie do praktyki', 'Pp'), (55, 'Przygotowanie pracy dyplomowej', 'Ppd'), (56, 'Projekt dyplomowy inżynierski i egzamin zawodowy', null);

INSERT INTO module_subject (module_id, subject_id)
VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(2, 9),(2, 10),(2, 11),(2, 12),(3, 13),(3, 14),(3, 15),(3, 16),(3, 17),
  (4, 18),(4, 19),(4, 20),(4, 21),(5, 22),(5, 23),(5, 24),(5, 25),(5, 26),(6, 27),(6, 28),(6, 29),(6, 30),(6, 31),(6, 32),
  (7, 33),(7, 34),(7, 35),(7, 36),(8, 37),(8, 38),(8, 39),(8, 40),(8, 41),(8, 42),(8, 43),(8, 44),
    (9, 45),(9, 46),(9, 47),(9, 48),(9, 49),(9, 50),(9, 51),(9, 52),(10, 53),(10, 54),(10, 55),(10, 56);

INSERT INTO contact_hours (id, lecture, exercise, laboratory, seminar, project)
VALUES (1, 1, 29, 0, 0, 0), (2, 10, 15, 10, 0, 0), (3, 10, 14, 0, 0, 0), (4, 10, 20, 0, 0, 0), (5, 5, 25, 0, 0, 0),(6, 10, 20, 5, 0, 0),
       (7, 1, 29, 0, 0, 0), (8, 10, 15, 10, 0, 0), (9, 10, 14, 0, 0, 0), (10, 10, 20, 0, 0, 0), (11, 5, 25, 0, 0, 0),(12, 10, 20, 5, 0, 0),
       (13, 10, 20, 5, 0, 0),(14, 10, 20, 5, 0, 0),(15, 10, 20, 5, 0, 0),(16, 10, 20, 5, 0, 0);

INSERT INTO non_contact_hours (id, consultation, exam, pwt, pwp)
VALUES (1, 5, 0, 8, 20),(2, 10, 4, 0, 10),(3, 10, 4, 0, 5),(4, 10, 4, 0, 5),(5, 10, 4, 0, 5),(6, 10, 4, 0, 5),
       (7, 5, 0, 8, 20),(8, 10, 4, 0, 10),(9, 10, 4, 0, 5),(10, 10, 4, 0, 5),(11, 10, 4, 0, 5),(12, 10, 4, 0, 5),
       (13, 10, 4, 0, 5),(14, 10, 4, 0, 5),(15, 10, 4, 0, 5),(16, 10, 4, 0, 5);

INSERT INTO major_effect (id, code, content, type)
VALUES (1, 'N1_W02', 'Ma wiedzę ogólną o biosferze, fizyce atmosfery i oceanów, zna zasady i specyfikę wykonywania pomiarów hydrometeorologicznych.', 'KNOWLEDGE'),
       (2, 'N1_W03', 'Ma podstawową wiedzę w zakresie właściwości fizykochemicznych transportowanych ładunków i ich charakterystyki. ', 'KNOWLEDGE'),
       (3, 'I1_W06', 'Ma podstawową wiedzę w zakresie grafiki komputerowej, zna podstawowe metody komunikacji z komputerem', 'KNOWLEDGE'),
       (4, 'I1_W10', 'Zna wybrane języki programowania, ma wiedzę w zakresie stosowanych technik programowania, a także projektowania i wytwarzania aplikacji i systemów inf.', 'KNOWLEDGE'),
       (5, 'I1_W11', 'Ma wiedzę z algorytmizacji i podstaw tworzenia i przetwarzania struktur danych.', 'KNOWLEDGE'),
       (6, 'I1_U01', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki.', 'SKILLS'),
       (7, 'I1_U02', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie.', 'SKILLS'),
       (8, 'I1_U03', 'Potrafi ocenić pod kątem ekonomicznym i zarządczym znaczenie podejmowanych przez siebie działań inżynierskich oraz scharakteryzować podstawowe zasady aktywności gospodarczej.', 'SKILLS'),
       (9, 'I1_U18', 'Potrafi administrować wybranymi systemami informatycznymi, w tym korzystać z właściwych technik zabezpieczających.', 'SKILLS'),
       (10, 'I1_U19', 'Potrafi zaprojektować i wykonać relacyjna bazę danych oraz skonstruować przykładowe zapytanie SQL.', 'SKILLS'),
       (11, 'I1_K01', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL'),
       (12, 'I1_K02', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL'),
       (13, 'I1_K03', 'Rozumie społeczny i zawodowy kontekst informatyki, jej zasady prawne i etyczne oraz  świadomie stosuje się do przepisów obowiązującego prawa, przestrzega zasad etyki zawodowej.', 'SOCIAL'),
       (14, 'I1_K04', 'Rozumie znaczenie pojęć istotnych  w procesie kształtowania postaw takich jak patriotyzm, humanizm, tolerancja, współpraca wielokulturowa.', 'SOCIAL');

INSERT INTO subject_effect (id, code, content, type)
VALUES (1, 'W1', 'Ma elementarną  wiedzę z prawa gospodarczego i prawa autorskiego oraz wiedzę w zakresie inżynierskich  uwarunkowań działań o charakterze ekonomiczno-zarządczym.', 'KNOWLEDGE'),
       (2, 'W2', 'Ma uporządkowaną wiedzę z matematyki i metod jej stosowania,  zna podstawowe prawa i twierdzenia matematyki, w tym matematyki dyskretnej i metod probabilistycznych', 'KNOWLEDGE'),
       (3, 'U1', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki', 'SKILLS'),
       (4, 'U2', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie', 'SKILLS'),
       (5, 'K1', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL'),
       (6, 'K2', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL');

INSERT INTO major_major_effect(major_id, major_effect_id)
VALUES (1, 1), (1, 3), (1, 6), (1, 8), (1, 11),
       (2, 2), (2, 4), (2, 6), (2, 9), (2, 12),
       (3, 3), (3, 7), (3, 10), (3, 13), (3, 14);

INSERT INTO major_effect_subject_effect(major_effect_id, subject_effect_id)
VALUES (1, 1), (1, 3), (2, 2), (2, 5), (3, 6), (4, 6);

INSERT INTO major_module (id, major_id, module_id, tutor_id)
VALUES (1, 1, 1, 1), (2, 1, 2, 2), (3, 1, 3, 3), (4, 1, 8, 4), (5, 1, 9, 5),
       (6, 5, 1, 1), (7, 5, 2, 2), (8, 5, 3, 3), (9, 5, 8, 4), (10, 5, 9, 5);

INSERT INTO major_module_subject (id, ects, semester, major_module_id, subject_id, tutor_id, supervisor_id, contact_hours_id, non_contact_hours_id, type_of_passing)
VALUES (1, 5, 1, 1, 1, 2, 2, 1, 1, 'GRADE'), (2, 4, 2, 1, 1, 2, 2, 2, 2, 'GRADE'), (3, 1, 3, 1, 2, 2, 2,  3, 3, 'NO_GRADE'), (4, 8, 1, 2, 3, 3, 3, 4, 4, 'NO_GRADE'),
       (5, 4, 2, 2, 3, 3, 3, 5, 5, 'GRADE'), (6, 3, 5, 3, 4, 5, 5, 6, 6, 'NO_GRADE'), (7, 8, 6, 4, 9, 6, 6, 7, 7, 'GRADE'), (8, 10, 7, 5, 10, 7, 7, 8, 8, 'NO_GRADE'),
       (9, 5, 1, 6, 1, 2, 2, 9, 9, 'GRADE'), (10, 4, 2, 6, 1, 2, 2, 10, 10, 'GRADE'), (11, 1, 3, 6, 2, 2, 2, 11, 11, 'EXAM'), (12, 8, 1, 7, 3, 3, 3, 12, 12, 'EXAM'),
       (13, 4, 2, 7, 3, 3, 3, 13, 13, 'GRADE'), (14, 3, 5, 8, 4, 5, 5, 14, 14, 'EXAM'), (15, 8, 6, 9, 9, 6, 6, 15, 15, 'EXAM'), (16, 10, 7, 10, 10, 7, 7, 16, 16, 'EXAM');

INSERT INTO major_effect_subject (subject_id, major_effect_id, connection_strength)
VALUES (1, 1, 3), (2, 2, 2), (3, 5, 1), (3, 6, 2), (4, 7, 3), (5, 8, 2);


