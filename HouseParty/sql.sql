CREATE TABLE all_list(
iuser INT(100) AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(20) NOT NULL UNIQUE,
idep INT(4) NOT NULL ,
hno INT(4) NOT NULL,
FOREIGN KEY (idep) REFERENCES depart(idep),
FOREIGN KEY (hno) REFERENCES house(hno)
);

CREATE TABLE depart(
idep INT(4) NOT NULL PRIMARY key,
dpname VARCHAR(10)
);

INSERT INTO depart
(idep, dpname)
VALUES
(1, "가문장"),
(2, "부 가문장"),
(3, "간부"),
(4, "가문원");

SELECT * FROM depart;
DROP TABLE depart;

SELECT * FROM all_list;
CREATE TABLE house (
hno INT(4) PRIMARY KEY,
hnm VARCHAR(20) NOT NULL
);

INSERT INTO house
(hno, hnm)
VALUES
("1","명화적"),
("2","Paladin"),
("3","Slience");


SELECT A.iuser, A.id, B.dpname, C.hnm FROM all_list A
LEFT JOIN depart B
ON A.idep = B.idep
LEFT JOIN house C
ON A.hno = C.hno;

DROP table today_list;
DROP TABLE cp_list;
DROP TABLE all_list;
