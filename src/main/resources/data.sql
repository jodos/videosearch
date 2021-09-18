CREATE MEMORY TABLE PUBLIC.TBLCATEGORIES
(
    CATEGORYCODE INTEGER PRIMARY KEY,
    DESCRIPTION  VARCHAR(45)
);
CREATE MEMORY TABLE PUBLIC.TBLMOVIETITLES
(
    TITLENO         INTEGER     NOT NULL PRIMARY KEY,
    TITLE           VARCHAR(45) NOT NULL,
    DESCRIPTION     VARCHAR(50) NOT NULL,
    RATING          VARCHAR(10) NOT NULL,
    CATEGORYCODE    INTEGER     NOT NULL,
    RETAILPRICE     VARCHAR(45) NOT NULL,
    RENTALPRICE     VARCHAR(45) NOT NULL,
    COPIESPURCHASED INTEGER     NOT NULL
);
CREATE MEMORY TABLE PUBLIC.TBLRATINGS
(
    RATING      VARCHAR(10) NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(150) DEFAULT NULL
);
INSERT INTO TBLCATEGORIES
VALUES (1, 'Action/Aventure');
INSERT INTO TBLCATEGORIES
VALUES (2, 'Drame');
INSERT INTO TBLCATEGORIES
VALUES (3, 'Horreur');
INSERT INTO TBLCATEGORIES
VALUES (4, 'Comédie');
INSERT INTO TBLCATEGORIES
VALUES (5, 'Enfants');
INSERT INTO TBLCATEGORIES
VALUES (6, 'Familial');
INSERT INTO TBLCATEGORIES
VALUES (7, 'Science Fiction');
INSERT INTO TBLMOVIETITLES
VALUES (1, 'Piège de Cristal', 'Bruce Willis dans un film d''action et d''aventure', 'R', 1, 'CHF 20.95', 'CHF 2.50',
        3);
INSERT INTO TBLMOVIETITLES
VALUES (2, 'Dumb & Dumber', 'Film fou!', 'PG-13', 4, 'CHF 15.95', 'CHF 3.00', 6);
INSERT INTO TBLMOVIETITLES
VALUES (5, 'La liste de Schindler', 'Film très intense au sujet de l''Holocauste.', 'R', 2, 'CHF 20.00',
        'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (6, 'The Mask', 'De grands effets spéciaux basés sue une BD.', 'PG-13', 4, 'CHF 20.00', 'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (7, 'Balto', 'Animation au sujet de chiens d''Alaska.', 'G', 4, 'CHF 25.00', 'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (8, 'Rapid Fire', 'Le meilleur film d''arts martiaux de Brandon Lee.', 'R', 1, 'CHF 25.00', 'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (9, 'Star Trek V', 'The entreprise voyage dans le temps.', 'PG', 7, 'CHF 25.00', 'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (10, 'Crimson Tide', 'Mésaventures d''un sous-marin.', 'R', 2, 'CHF 25.00', 'CHF 3.00', 0);
INSERT INTO TBLMOVIETITLES
VALUES (11, 'Monty Python et le sacré Graal', 'Folie à la cour du roi Arthur.', 'PG', 4, 'CHF 20.00', 'CHF 3.00', 0);
INSERT INTO TBLRATINGS
VALUES ('G', 'Audience Générale');
INSERT INTO TBLRATINGS
VALUES ('NC-18', 'Interdit au moins de 18 ans');
INSERT INTO TBLRATINGS
VALUES ('PG', 'Accompagnement parental suggéré');
INSERT INTO TBLRATINGS
VALUES ('PG-13', 'Accompagnement parental suggéré pour les enfants de moins de 13 ans');
INSERT INTO TBLRATINGS
VALUES ('R', 'Adulte requis pour les enfants de moins de 17 ans');