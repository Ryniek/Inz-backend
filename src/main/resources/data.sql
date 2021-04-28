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
       (4, 'Studium języków obcych', null, null),
       (5, 'Wydział Nauk Humanistycznych i Społecznych', null,  null),
       (6, 'Wincenty', 'Karawajczyk', 'dr'),
       (7, 'Krzysztof', 'Topolski', 'dr'),
       (8, 'Vadim', 'Romanuke', 'dr hab. inż.'),
       (9, 'Jerzy', 'Garus', 'dr hab. inż.'),
       (10, 'Andrzej', 'Glaner', 'dr'),
       (11, 'Jan', 'Masiejczyk', 'dr inż.'),
       (12, 'Artur', 'Cywiński', 'dr inż.'),
       (13, 'Tadeusz', 'Bodnar', 'mgr inż.'),
       (14, 'Tomasz', 'Górski', 'dr inż.'),
       (15, 'Wojciech', 'Jędruch', 'dr hab. inż.'),
       (16, 'Paweł', 'Piskur', 'dr inż.'),
       (17, 'Przemysław', 'Rodwald', 'kmdr por. dr inż.'),
       (18, 'Artur', 'Zacniewski', 'dr inż.'),
       (19, 'Wydział Mechaniczno-Elektryczny', null, null),
       (20, 'Akademickie Centrum Sportowe', null, null),
       (21, 'Janusz', 'Ogrodniczak', 'dr inż.');

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
VALUES (1, 1, 29, 0, 0, 0), (2, 0, 30, 0, 0, 0), (3, 0, 30, 0, 0, 0), (4, 0, 30, 0, 0, 0), (5, 0, 30, 0, 0, 0),
       (6, 0, 30, 0, 0, 0),
       (7, 1, 14, 0, 0, 0), (8, 0, 15, 0, 0, 0),
       (9, 10, 0, 15, 0, 0),
       (10, 5, 10, 0, 0, 0),
       (11, 30, 0, 0, 0, 0),
       (12, 30, 0, 0, 0, 0),
       (13, 20, 10, 0, 0, 0),(14, 20, 10, 0, 0, 0);

INSERT INTO non_contact_hours (id, consultation, exam, pwt, pwp)
VALUES (1, 5, 0, 8, 20),(2, 5, 0, 8, 20),(3, 5, 0, 8, 20),(4, 5, 0, 8, 20),(5, 5, 0, 8, 20),
       (6, 5, 0, 0, 15),
       --wf null
       (7, 5, 0, 10, 12),
       --ochrona wlasnosci null
       (8, 5, 0, 5, 0),
       (9, 5, 0, 5, 20),
       (10, 5, 0, 10, 5),(11, 5, 4, 10, 5);

INSERT INTO major_effect (id, code, content, type)
VALUES (1, 'W1', 'Ma elementarną  wiedzę z prawa gospodarczego i prawa autorskiego oraz wiedzę w zakresie inżynierskich  uwarunkowań działań o charakterze ekonomiczno-zarządczym.', 'KNOWLEDGE'),
       (2, 'W2', 'Ma uporządkowaną wiedzę z matematyki i metod jej stosowania,  zna podstawowe prawa i twierdzenia matematyki, w tym matematyki dyskretnej i metod probabilistycznych.', 'KNOWLEDGE'),
       (3, 'W3', 'Ma podstawową wiedzę z zakresu fizyki ze szczególnym uwzględnieniem aspektów istotnych w informatyce.', 'KNOWLEDGE'),
       (4, 'W4', 'Ma podstawową wiedzę z zakresu elektroniki, metod budowy układów elektronicznych, technik cyfrowych i metod ich stosowania w układach programowalnych', 'KNOWLEDGE'),
       (5, 'W5', 'Zna elementarne zagadnienia informatyki, jej uwarunkowań społecznych, zawodowych, środowiskowych, prawnych i etycznych.', 'KNOWLEDGE'),
       (6, 'W6', 'Ma podstawową wiedzę w zakresie grafiki komputerowej, zna podstawowe metody komunikacji z komputerem.', 'KNOWLEDGE'),
       (7, 'W7', 'Zna zasady budowy i funkcjonowania podstawowych składników systemów komputerowych oraz podstawowe zasady kodowania informacji, charakterystyczne dla informatyki.', 'KNOWLEDGE'),
       (8, 'W8', 'Ma podstawową wiedzę w zakresie technologii sieciowych, w tym sieci bezprzewodowych.', 'KNOWLEDGE'),
       (9, 'W9', 'Ma uporządkowaną, podbudowaną teoretycznie wiedzę w zakresie architektury SI, zasad projektowania oprogramowania dla poszczególnych architektur oraz działania systemów wbudowanych.', 'KNOWLEDGE'),
       (10, 'W10', 'Zna wybrane języki programowania, ma wiedzę w zakresie stosowanych technik programowania, a także projektowania i wytwarzania aplikacji i systemów inf.', 'KNOWLEDGE'),
       (11, 'W11', 'Ma wiedzę z algorytmizacji i podstaw tworzenia i przetwarzania struktur danych.', 'KNOWLEDGE'),
       (12, 'W12', 'Ma uporządkowaną, podbudowana teoretycznie wiedzę o budowie, zasadach projektowania i działania systemów informatycznych, w tym baz danych. Zna podstawowe metody ich ochrony.', 'KNOWLEDGE'),
       (13, 'W13', 'Zna podstawowe metody techniczne i narzędzia stosowane przy rozwiązywaniu prostych problemów z zakresu sztucznej inteligencji.', 'KNOWLEDGE'),
       (14, 'W14', 'Zna ogólne narzędzia wspomagające pracę informatyka oraz specyficzne narzędzia związane z wybraną specjalnością . Ma wiedzę w zakresie zastosowań rozwiązań informatycznych w rzeczywistych dziedzinach aktywności ludzkiej.', 'KNOWLEDGE'),
       (15, 'W15', 'Ma wiedze w zakresie metod gromadzenia, przetwarzania i stosowania zgromadzonych danych w wybranych dziedzinach informatyki.', 'KNOWLEDGE'),
       (16, 'W16', 'Zna metody projektowania, wytwarzania i administrowania systemami informatycznymi charakterystycznymi dla wybranych dziedzin  informatyki.', 'KNOWLEDGE'),
       (17, 'U1', 'Potrafi posługiwać się językiem obcym na poziomie B2 (ESOKJ RD) oraz umie posługiwać się językiem angielskim specjalistycznym dla informatyki.', 'SKILLS'),
       (18, 'U2', 'Potrafi pozyskiwać informacje z dokumentacji, literatury, Internetu oraz innych wiarygodnych źródeł w języku polskim i angielskim, integrować je, dokonywać ich interpretacji oraz wyciągać wnioski i formułować opinie.', 'SKILLS'),
       (19, 'U3', 'Potrafi ocenić pod kątem ekonomicznym i zarządczym znaczenie podejmowanych przez siebie działań inżynierskich oraz scharakteryzować podstawowe zasady aktywności gospodarczej.', 'SKILLS'),
       (20, 'U4', 'Potrafi wykorzystywać poznane modele, metody matematyczne, symulacje komputerowe oraz inne techniki obliczeniowe do rozwiązywania prostych problemów inżynierskich.', 'SKILLS'),
       (21, 'U5', 'Potrafi wyjaśnić podstawowe zależności fizyczne oraz wykorzystać je do rozwiązywania prostych problemów inżynierskich.', 'SKILLS'),
       (22, 'U6', 'Potrafi zaprojektować i opisać działanie prostych układów cyfrowych i elektronicznych.', 'SKILLS'),
       (23, 'U7', 'Ma umiejętności niezbędne do funkcjonowania w środowisku pracy, umie zachowywać się w sposób właściwy dla sfery przemysłowej. Potrafi sam rozwijać swoją wiedzę i umiejętności zawodowe.', 'SKILLS'),
       (24, 'U8', 'Potrafi zaprojektować i wykonać prosty interfejs graficzny lub komunikacyjny.', 'SKILLS'),
       (25, 'U9', 'Potrafi zaprojektować procesy wytwarzania aplikacji oraz aktywnie uczestniczyć w pracach zespołów informatycznych przejmując zadania charakterystyczne dla przydzielonej mu roli.', 'SKILLS'),
       (26, 'U10', 'Potrafi wyjaśnić zasady budowy i działania sprzętu IT oraz wykonać podstawowe operacje obliczeniowe w wybranych systemach kodowania.', 'SKILLS'),
       (27, 'U11', 'Ma podstawowe umiejętności w zakresie projektowania, programowania i obsługi systemów wbudowanych.', 'SKILLS'),
       (28, 'U12', 'Potrafi projektować i administrować sieciami komputerowymi, w tym sieciami bezprzewodowymi.', 'SKILLS'),
       (29, 'U13', 'Potrafi opisać obecne klasy architektur sprzętu komputerowego, szczegółowo objaśnić budowę jego elementów składowych oraz wskazać wpływ architektury na działanie oprogramowania.', 'SKILLS'),
       (30, 'U14', 'Umie właściwie wybrać i zastosować język i paradygmaty programowania dla analizowanego problemu inżynierskiego.', 'SKILLS'),
       (31, 'U15', 'Potrafi wybrać i zastosować algorytm i struktury danych najodpowiedniejsze dla prostego problemu technicznego, szczególnie dla wybranej specjalności.', 'SKILLS'),
       (32, 'U16', 'Potrafi opisać proces powstawania oprogramowania, używać wybranych narzędzi i technik wspomagających wytwarzanie aplikacji.', 'SKILLS'),
       (33, 'U17', 'Potrafi scharakteryzować  budowę i działanie wybranych systemów informatycznych oraz określić ich przydatność w konkretnych zastosowaniach inżynierskich.', 'SKILLS'),
       (34, 'U18', 'Potrafi administrować wybranymi systemami informatycznymi, w tym korzystać z właściwych technik zabezpieczających.', 'SKILLS'),
       (35, 'U19', 'Potrafi zaprojektować i wykonać relacyjna bazę danych oraz skonstruować przykładowe zapytanie SQL.', 'SKILLS'),
       (36, 'U20', 'Potrafi wybrać i zastosować właściwe techniki i narzędzia sztucznej inteligencji do rozwiązania prostych problemów inżynierskich.', 'SKILLS'),
       (37, 'U21', 'Potrafi określić możliwość zastosowania współczesnych metod i narzędzi informatycznych do rozwiązywania prostych problemów inżynierskich oraz wybrać i zastosować wybraną technikę w szczególności rozwiązania w zakresie wybranej specjalności.', 'SKILLS'),
       (38, 'U22', 'Potrafi wykryć i zinterpretować związki występujące w zjawiskach rzeczywistych oraz wykorzystać je w tworzeniu modeli, programów  i symulacji komputerowych dla wybranej specjalności.', 'SKILLS'),
       (39, 'U23', 'Potrafi wykorzystywać poznane modele, metody matematyczne, symulacje komputerowe, pomiary charakterystyk statycznych i dynamicznych oraz inne techniki obliczeniowe i analityczne do projektowania i wykonania projektów inżynierskich w wybranej dziedzinie.', 'SKILLS'),
       (40, 'U24', 'Umie dyskutować na tematy informatyczne i wyrobić sobie własną krytyczną opinię na temat nowych osiągnięć w wybranych dyscyplinach informatycznych.', 'SKILLS'),
       (41, 'K1', 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'SOCIAL'),
       (42, 'K2', 'Rozumie znaczenie społecznego oddziaływania informatyki, w tym technik komunikacyjnych i mobilności oraz posiada potrzebę informowania społeczeństwa o rozwoju i osiągnięciach informatyki.', 'SOCIAL'),
       (43, 'K3', 'Rozumie społeczny i zawodowy kontekst informatyki, jej zasady prawne i etyczne oraz  świadomie stosuje się do przepisów obowiązującego prawa, przestrzega zasad etyki zawodowej.', 'SOCIAL'),
       (44, 'K4', 'Rozumie znaczenie pojęć istotnych  w procesie kształtowania postaw takich jak patriotyzm, humanizm, tolerancja, współpraca wielokulturowa.', 'SOCIAL'),
       (45, 'K5', 'Rozumie kontekst ekonomiczny podejmowanych przez siebie działań i potrafi myśleć i działać w sposób przedsiębiorczy.', 'SOCIAL'),
       (46, 'K6', 'Potrafi pracować w zespole, przyjmując w nim różne role i rozumiejąc zasady odpowiedzialności i współpracy; rozumie konieczność systematycznej pracy nad projektami o charakterze długofalowym.', 'SOCIAL'),
       (47, 'K7', 'Rozumie i realizuję potrzebę prowadzenia zdrowego trybu życia i propagowania kultury fizycznej oraz uczestniczy w sportowym i społecznym życiu Uczelni.', 'SOCIAL');

INSERT INTO subject_effect (id, content, type)
VALUES (1, 'Ma podstawową wiedzę o miejscu i znaczeniu języków obcych w systemie nauk oraz o ich specyfice przedmiotowej.', 'SKILLS'),
       (2, 'Zna podstawową terminologię obcojęzyczną właściwą  dla studiowanego kierunku.', 'SKILLS'),
       (3, 'Zna i rozumie podstawowe pojęcia i zasady z zakresu ochrony własności przemysłowej i prawa autorskiego.', 'SKILLS'),
       (4, 'Ma świadomość kompleksowej natury języka oraz jego złożoność i historycznej zmienności jego znaczeń.', 'SKILLS'),
       (5, 'Ma umiejętności językowe właściwe dla studiowanego kierunku zgodnie z wymaganiami określonymi dla poziomu co najmniej B2 Europejskiego Systemu Opisu Kształcenia Językowego.', 'SKILLS'),
       (6, 'Umie samodzielnie wykorzystywać wiedzę z wykorzystaniem słowników, leksykonów oraz innych tradycyjnych i cyfrowych źródeł informacji.', 'SKILLS'),
       (7, 'Potrafi wyszukiwać, analizować, oceniać i selekcjonować informacje z różnych źródeł.', 'SKILLS'),
       (8, 'Posiada umiejętność przygotowania typowych prac pisemnych w języku angielskim właściwych dla studiowanego kierunku studiów.', 'SKILLS'),
       (9, 'Posiada umiejętność przygotowania wystąpień ustnych w języku angielskim dotyczących zagadnień szczegółowych z zakresu studiowanego kierunku studiów.', 'SKILLS'),
       (10, 'Ma świadomość posiadanej przez siebie wiedzy i umiejętności oraz konieczności ich stałej aktualizacji w kontekście wykonywanego zawodu.', 'SOCIAL'),
       (11, 'Rozumie potrzebę ciągłego dokształcania się, ciągłości praktyki komunikacyjnej w języku angielskim oraz uczenia się przez całe życie.', 'SOCIAL'),
       (12, 'Potrafi pracować w grupie, przyjmując różne role przy wykonywaniu wspólnych projektów i prowadzonej dyskusji.', 'SOCIAL'),
       (13, 'Efektywnie organizuje swoją pracę oraz innych i potrafi krytycznie ocenić jej priorytety oraz stopień zaawansowania.', 'SOCIAL'),
       (14, 'Potrafi uzupełniać i doskonalić nabytą wiedzę i umiejętności.', 'SOCIAL'),
       (15, 'Student zna podstawy polskiego prawa gospodarczego, potrafi wyjaśnić prawne i organizacyjne konsewkencje wyboru formy działalności gospodarczej oraz potrafi przygotować właściwą dokumentację.', 'KNOWLEDGE'),
       (16, 'Student zna podstawy zarządzania przedsiebiorstwem, potrafi dyskutować i opisywać sytuacje decyzyjne, które są typowe dla kierownictwa  szczebla operacyjnego i strategicznego.', 'KNOWLEDGE'),
       (17, 'Student potrafi sklasyfikować źródła pozyskiwania kapitału i potrafi przeanalizować ich opłacalność w konkretnych sytuacjach decyzyjnych.', 'SKILLS'),
       (18, 'Student potrafi przeanalizować dostępne narzędzia ekonomiczne i marketingowe pod kątem ich opłacalności i mozliwości wykorzystania w przykładowych sytuacjach decyzyjnych.', 'SKILLS'),
       (19, 'Student potrafi zaprojektować kompleksowe rozwiązanie  problemu ekonomicznego i zaprezentować go publicznie.', 'SKILLS'),
       (20, 'Student śledzi bieżącą sytuację ekonomiczną w kraju i na świecie, krytycznie obserwuje i dyskutuje model biznesowy przedsiębiorstw, zwlaszcza z branży informatycznej.', 'SOCIAL'),
       (21, 'Student uważnie śledzi treści wykładu, w celu lepszego zrozumienia kontekstu ekonomicznego zdarzeń i i działań,  samodzielnie wyszukuje informacje uzupełniające z innych źródeł oraz analizuje zasady funkcjonowania znanych mu przedsiębiorstw.', 'SOCIAL'),
       (22, 'Aktywnie uczestniczy w zajęciach laboratoryjnych, rozwiązuje problemy decyzyjne o charakterze ekonomicznym, dzieli się z grupą własnymi obserwacjami z otoczenia ekonomicznego kraju, rozumie procesy ewolucji zjawisk gospodarczych i konieczność ciągłego nadązania za zmieniajacymi się warunkami ekonomicznymi.', 'SOCIAL'),
       (23, 'Potrafi podejmować zadania długofalowe, dokonywać i przestrzegać ustaleń organizacyjnych, przejmować wyznaczone mu role w zespołach. ', 'SOCIAL'),
       (24, 'Ma wiedzę w zakresie definiowania prawa ochrony własności intelektualnej.', 'KNOWLEDGE'),
       (25, 'Umie zastosować podstawowe konstrukcje prawne dla rozwiązywania problemów pojawiających się w kontekście wykonywania i implementacji praw własności intelektualnej.', 'KNOWLEDGE'),
       (26, 'Umie dokonać analizy prawnej prostego stanu faktycznego z zakresu problematyki ochrony praw własności intelektualnej.', 'KNOWLEDGE'),
       (27, 'Potrafi pracować w grupie nad rozwiązaniem problemu prawnego  w sferze ochrony własności intelektualnej.', 'SOCIAL'),
       (28, 'Student zna podstawowe pojęcia ekonomiczne, potrafi opisać podstawowe zasady funkcjonowania gospodarki rynkowej i obiegu pieniądza, rozumie zasadę konstrukcji budżetu państwa.', 'KNOWLEDGE'),
       (29, 'Student potrafi ocenić pod kątem ekonomicznym typowe działania i decyzje inzynierskie, szczególnie gdy dotyczą branży informatycznej.', 'SKILLS'),
       (30, 'Student rozumie kontekst ekonomiczny podejmowanych przez siebie działań, potrafi wskazać ich główne przesłanki ekonomiczne.', 'SOCIAL'),
       (31, 'Student wyjaśnia główne terminy logiki, wymienia jej działy oraz pokazuje miejsce, rolę i zadania logiki w systemie nauk.', 'KNOWLEDGE'),
       (32, 'Student charakteryzuje istotę, rodzaje, strukturę oraz funkcje języka z punktu widzenia logiki.', 'KNOWLEDGE'),
       (33, 'Student rozróżnia podstawowe rodzaje rozumowań oraz ich błędy.', 'KNOWLEDGE'),
       (34, 'Student opisuje zasadnicze sposoby definiowania pojęć.', 'KNOWLEDGE'),
       (35, 'Student buduje definicje zgodnie z zaleceniami logiki; dostrzega błędy w definiowaniu.', 'SKILLS'),
       (36, 'Student sprawdza poprawność rozumowań dedukcyjnych za pomocą wybranych działań w ramach rachunku zdań.', 'SKILLS'),
       (37, 'Student wykrywa typowe przyczyny nieporozumień w procesie komunikowania się.', 'SKILLS'),
       (38, 'Student skutecznie posługuje się językiem naturalnym w procesie komunikowania się z innymi członkami swojej grupy.', 'SOCIAL'),
       (39, 'Rozumie potrzebę dbania o ciągły rozwój intelektualny i fizyczny,  zdaje sobie sprawę z konieczności uczenia się przez całe życie i adaptowania swojej wiedzy do zmian cywilizacyjnych.', 'KNOWLEDGE'),
       (40, 'Rozumie znaczenie pojęć istotnych  w procesie kształtowania postaw takich jak patriotyzm, humanizm, tolerancja, współpraca wielokulturowa.', 'KNOWLEDGE');

INSERT INTO major_major_effect(major_id, major_effect_id)
VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),(1, 11),(1, 12),(1, 13),(1, 14),(1, 15),(1, 16),(1, 17),(1, 18),(1, 19),(1, 20),(1, 21),(1, 22),(1, 23),(1, 24),(1, 25),(1, 26),(1, 27),(1, 28),(1, 29),(1, 30),(1, 31),(1, 32),(1, 33),(1, 34),(1, 35),(1, 36),(1, 37),(1, 38),(1, 39),(1, 40),(1, 41),(1, 42),(1, 43),(1, 44),(1, 45),(1, 46),(1, 47);

INSERT INTO major_module (id, major_id, module_id, tutor_id)
VALUES (1, 1, 1, 5), (2, 1, 2, 3), (3, 1, 3, 9), (4, 1, 4, 10), (5, 1, 5, 2),
       (6, 1, 6, 14), (7, 1, 7, 1), (8, 1, 8, 18), (9, 1, 9, 13), (10, 1, 10, 19);

INSERT INTO major_module_subject (id, major_module_id, subject_id, supervisor_id)
VALUES (1, 1, 1, 4), (2, 1, 2, 4), (3, 1, 3, 20), (4, 1, 4, 5), (5, 1, 5, 5), (6, 1, 6, 5), (7, 1, 7, 5), (8, 1, 8, 5),
       (9, 2, 9, 3), (10, 2, 10, 10), (11, 2, 11, 8), (12, 2, 12, 8),
       (13, 3, 13, 9), (14, 3, 14, 9), (15, 3, 15, 9), (16, 3, 16, 9), (17, 3, 17, 9),
       (18, 4, 18, 10), (19, 4, 19, 11), (20, 4, 20, 2), (21, 4, 21, 11),
       (22, 5, 22, 1), (23, 5, 23, 9), (24, 5, 24, 9), (25, 5, 25, 2), (26, 5, 26, 2),
       (27, 6, 27, 14), (28, 6, 28, 11), (29, 6, 29, 16), (30, 6, 30, 11), (31, 6, 31, 15), (32, 6, 32, 14),
       (33, 7, 33, 1), (34, 7, 34, 2), (35, 7, 35, 15), (36, 7, 36, 17),
       (37, 8, 37, 18), (38, 8, 38, 2), (39, 8, 39, 18), (40, 8, 40, 18), (41, 8, 41, 14), (42, 8, 42, 18), (43, 8, 43, 14), (44, 8, 44, 17),
       (45, 9, 45, 13), (46, 9, 46, 21), (47, 9, 47, 13), (48, 9, 48, 2), (49, 9, 49, 13), (50, 9, 50, 21), (51, 9, 51, 13), (52, 9, 52, 17),
       (53, 10, 53, 12), (54, 10, 54, 19), (55, 10, 55, 2), (56, 10, 56, 19);

INSERT INTO major_module_subject_details (id, ects, semester, type_of_passing, contact_hours_id, non_contact_hours_id, tutor_id, major_module_subject_id)
VALUES (1, 3, 1, 'GRADE', 1, 1, 4, 1), (2, 3, 1, 'GRADE', 2, 2, 4, 1), (3, 3, 3, 'GRADE', 3, 3, 4, 1), (4, 3, 4, 'GRADE', 4, 4, 4, 1), (5, 0, 5, 'GRADE', 5, 5, 4, 1),
       (6, 1, 6, 'GRADE', 6, 6, 4, 2),
       (7, 0, 1, 'GRADE', 7, null, 20, 3), (8, 0, 2, 'GRADE', 8, null, 20, 3),
       (9, 2, 7, 'GRADE', 9, 7, 5, 4),
       (10, 1, 6, 'GRADE', 10, null, 5, 5),
       (11, 2, 2, 'GRADE', 11, 8, 6, 6),
       (12, 3, 3, 'GRADE', 12, 9, 6, 7),
       (13, 2, 1, 'GRADE', 13, 10, 5, 8), (14, 2, 2, 'GRADE', 14, 11, 5, 8);

INSERT INTO major_effect_module_subject (major_effect_id, major_module_subject_id, connection_strength)
VALUES (1, 2, 3), (1, 4, 2), (1, 5, 1), (1, 6, 2), (1, 7, 3), (1, 8, 3), (1, 21, 1), (1, 44, 1), (1, 52, 2), (1, 54, 3), (1, 55, 1),
       (2, 2, 2), (2, 9, 3), (2, 10, 3), (2, 11, 3), (2, 12, 3), (2, 18, 1), (2, 52, 1),
       (3, 13, 3), (3, 14, 1), (3, 15, 1), (3, 16, 1), (3, 45, 1),
       (4, 14, 3), (4, 15, 3), (4, 16, 3), (4, 17, 2), (4, 22, 1), (4, 23, 2), (4, 24, 1),
       (5, 5, 1), (5, 20, 1), (5, 21, 3), (5, 44, 3), (5, 54, 3), (5, 56, 1),
       (6, 19, 3), (6, 56, 1),
       (7, 18, 3), (7, 22, 2), (7, 27, 1), (7, 44, 1), (7, 56, 1),
       (8, 25, 3), (8, 26, 3), (8, 33, 2), (8, 36, 1), (8, 39, 1), (8, 40, 1), (8, 41, 1), (8, 46, 1), (8, 48, 3), (8, 50, 1), (8, 51, 3), (8, 56, 1),
       (9, 10, 1),(9, 35, 3),(9, 26, 2),(9, 47, 3),(9, 14, 3),(9, 44, 3),(9, 40, 3),(9, 30, 1),(9, 54, 3),
       (10, 3, 2),(10, 7, 3),(10, 48, 1),(10, 36, 2),(10, 45, 1),(10, 50, 1),(10, 13, 2),
       (11, 36, 3),(11, 7, 3),(11, 55, 2),(11, 32, 3),(11, 48, 2),(11, 35, 1),(11, 37, 2),(11, 19, 1),(11, 45, 3),(11, 8, 3),(11, 10, 3),(11, 1, 2),
       (12, 26, 3),(12, 36, 1),(12, 40, 3),(12, 1, 2),(12, 18, 3),(12, 13, 1),(12, 55, 1),(12, 33, 1),(12, 12, 1),(12, 29, 1),(12, 10, 1),(12, 5, 2),(12, 15, 3),(12, 30, 2),
       (13, 24, 2),(13, 51, 1),(13, 19, 3),(13, 40, 1),(13, 38, 1),(13, 23, 3),(13, 39, 3),(13, 28, 2),(13, 25, 3),(13, 2, 1),(13, 26, 1),(13, 52, 1),(13, 8, 3),(13, 1, 1),(13, 41, 3),
       (14, 27, 3),(14, 16, 1),(14, 35, 1),(14, 1, 3),(14, 10, 2),
       (15, 7, 1),(15, 46, 1),(15, 21, 1),(15, 44, 3),(15, 13, 1),(15, 27, 1),(15, 34, 2),
       (16, 3, 3),(16, 36, 2),(16, 22, 3),(16, 35, 3),(16, 50, 3),(16, 33, 2),(16, 41, 3),(16, 12, 1),
       (17, 24, 2),(17, 50, 2),(17, 16, 2),(17, 44, 2),(17, 7, 2),(17, 40, 1),(17, 20, 3),(17, 52, 3),(17, 13, 1),
       (18, 51, 3),(18, 4, 1),(18, 28, 1),
       (19, 28, 3),(19, 45, 3),(19, 53, 1),(19, 16, 3),(19, 31, 3),(19, 41, 3),(19, 29, 3),(19, 51, 3),
       (20, 26, 3),(20, 45, 2),(20, 51, 3),(20, 13, 1),(20, 55, 2),(20, 17, 3),(20, 49, 2),(20, 3, 2),(20, 21, 3),(20, 19, 3),(20, 10, 1),(20, 44, 2),(20, 40, 3),
       (21, 38, 1),(21, 53, 2),
       (22, 5, 2),(22, 47, 1),(22, 26, 3),
       (23, 8, 1),(23, 20, 1),(23, 51, 3),(23, 38, 1),(23, 40, 3),(23, 50, 3),(23, 55, 1),(23, 3, 3),(23, 10, 3),
       (24, 40, 1),(24, 3, 2),(24, 16, 1),(24, 31, 2),(24, 55, 3),
       (25, 20, 3),(25, 49, 1),(25, 52, 1),(25, 22, 3),(25, 17, 1),(25, 13, 2),(25, 23, 2),(25, 8, 2),(25, 25, 2),(25, 27, 3),(25, 39, 1),(25, 42, 2),(25, 41, 3),
       (26, 1, 3),(26, 39, 2),(26, 15, 2),(26, 41, 3),(26, 38, 3),
       (27, 5, 1),(27, 34, 3),(27, 31, 2),(27, 39, 3),(27, 47, 2),(27, 38, 2),(27, 32, 3),(27, 54, 3),(27, 26, 2),
       (28, 33, 2),(28, 4, 2),(28, 42, 1),(28, 31, 2),(28, 45, 3),(28, 15, 1),(28, 17, 2),
       (29, 21, 1),(29, 35, 3),(29, 34, 1),
       (30, 43, 1),(30, 35, 1),(30, 16, 2),(30, 19, 1),(30, 53, 3),(30, 54, 2),(30, 15, 2),(30, 7, 1),(30, 42, 2),(30, 5, 3),(30, 55, 1),(30, 11, 2),(30, 32, 3),(30, 40, 2),(30, 33, 3),
       (31, 40, 2),(31, 55, 2),(31, 3, 1),(31, 31, 3),(31, 28, 3),(31, 47, 1),(31, 6, 2),(31, 37, 3),(31, 27, 1),(31, 43, 2),(31, 23, 2),(31, 17, 3),(31, 32, 1),(31, 48, 3),
       (32, 30, 2),(32, 50, 1),(32, 32, 1),(32, 55, 2),(32, 5, 1),(32, 39, 3),(32, 34, 3),(32, 6, 1),(32, 13, 2),
       (33, 28, 1),(33, 22, 3),(33, 26, 1),
       (34, 2, 1),(34, 23, 3),(34, 28, 3),(34, 48, 2),(34, 54, 2),(34, 43, 3),(34, 5, 3),
       (35, 47, 1),(35, 10, 3),(35, 28, 3),(35, 22, 3),(35, 41, 1),(35, 3, 2),(35, 30, 1),(35, 53, 1),(35, 45, 2),(35, 50, 1),(35, 5, 3),(35, 18, 1),(35, 26, 1),
       (36, 27, 3),(36, 32, 2),(36, 6, 1),
       (37, 7, 2),(37, 21, 3),
       (38, 2, 1),(38, 6, 3),(38, 48, 2),(38, 43, 3),(38, 11, 3),(38, 54, 3),(38, 49, 2),(38, 14, 2),(38, 12, 2),(38, 22, 2),
       (39, 50, 2),(39, 12, 1),(39, 40, 1),(39, 51, 3),(39, 3, 2),
       (40, 30, 1),(40, 26, 2),(40, 6, 1),(40, 17, 2),
       (41, 21, 1),(41, 38, 2),(41, 22, 2),(41, 3, 3),(41, 28, 3),(41, 51, 2),(41, 20, 1),(41, 34, 3),(41, 52, 1),(41, 23, 3),
       (42, 35, 2),(42, 32, 2),(42, 3, 2),(42, 34, 2),(42, 47, 3),(42, 44, 2),
       (43, 33, 2),(43, 49, 3),(43, 19, 3),(43, 28, 2),
       (44, 6, 1),(44, 51, 3),(44, 49, 3),(44, 8, 3),(44, 54, 1),(44, 13, 1),(44, 43, 2),(44, 29, 1),(44, 9, 1),(44, 44, 1),(44, 31, 1),(44, 10, 2),(44, 22, 2),
       (45, 50, 2),(45, 18, 2),
       (46, 27, 3),(46, 42, 2),(46, 41, 3),(46, 44, 2),(46, 15, 2),(46, 38, 3),(46, 7, 1),(46, 5, 3),(46, 47, 1),(46, 26, 3),(46, 33, 3),(46, 37, 1),(46, 34, 3),
       (47, 54, 3),(47, 26, 1),(47, 3, 1),(47, 53, 1),(47, 28, 2),(47, 6, 1),(47, 55, 2),(47, 8, 1),(47, 46, 2),(47, 4, 2),(47, 7, 3),(47, 17, 3),(47, 50, 2),(47, 1, 2),(47, 13, 3);

INSERT INTO subject_effect_module_subject (major_module_subject_id, subject_effect_id)
VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),(1, 11),(1, 12),(1, 13),(1, 14),
       (2, 1),(2, 2),(2, 3),(2, 4),(2, 5),(2, 6),(2, 7),(2, 8),(2, 9),(2, 10),(2, 11),(2, 12),(2, 13),(2, 14),
       (4, 15),(4, 16),(4, 17),(4, 18),(4, 19),(4, 20),(4, 21),(4, 22),(4, 23),
       (5, 24), (5, 25), (5, 26), (5, 27),
       (6, 28), (6, 29), (6, 30),
       (7, 31), (7, 32), (7, 33), (7, 34), (7, 35), (7, 36), (7, 37), (7, 38),
       (8, 39), (8, 40);

