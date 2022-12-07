create table Person(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1001, 'Ajit', 'Chimgaon', CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1002, 'Gauri', 'Darwad', CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1003, 'Riyansh', 'London', CURRENT_TIMESTAMP());